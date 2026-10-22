package com.obric.cae.smartNetwork.networkRateLimit;

import com.bytedance.bdlocation.exception.BDLocationException;
import com.obric.cae.log.CaeLog;
import com.obric.cae.smartBluetooth.deviceIdentification.bdim.BdimCategoryConstants;
import defpackage.b;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* JADX INFO: loaded from: classes2.dex */
public class TcFilterParser {
    private static final int IFNAME_MAX_LEN = 15;
    private static final String TAG = "TcFilterParser";
    private static final int TC_INPUT_PARENT = 6;
    private static final String TC_INPUT_VIRTUAL_IFNAME = "ifb0";
    private static final int TC_OUTPUT_PARENT = 5;

    public static class FilterHandles {
        public String inputHandle;
        public String outputHandle;

        public FilterHandles(String r8, String r10) {
            this.outputHandle = r8;
            this.inputHandle = r10;
        }
    }

    public static class PortRequest {
        public boolean isIpv4;
        public int port;

        public PortRequest(boolean r8, int r10) {
            this.isIpv4 = r8;
            this.port = r10;
        }

        public String getKey() {
            StringBuilder r8 = new StringBuilder();
            if (this.isIpv4 == false) goto L5;
            String r10 = "v4:";
        L6:
            r8.append(r10);
            r8.append(this.port);
            return r8.toString();
        L5:
            r10 = "v6:";
            goto L6
        }
    }

    public TcFilterParser() {
    }

    private static String executeCommand(String r8) {
        StringBuilder r10 = new StringBuilder();
        Process r11 = Runtime.getRuntime().exec(r8);     // Catch: Exception -> L10
        BufferedReader r12 = new BufferedReader(new InputStreamReader(r11.getInputStream()));     // Catch: Exception -> L10
    L4:
        String r13 = r12.readLine();     // Catch: Exception -> L10
        if (r13 == null) goto L7;
        r10.append(r13);     // Catch: Exception -> L10
        r10.append("\n");     // Catch: Exception -> L10
        goto L4
    L7:
        r11.waitFor();     // Catch: Exception -> L10
        return r10.toString();
    L10:
        e = move-exception;
        b.k(e, new StringBuilder("executeCommand failed: "), TAG);
        return null;
    }

    private static Map<String, String> fetchAndParseHandles(String r8, int r10, List<PortRequest> r11) {
        String r12 = executeCommand("tc filter show dev " + r8 + " parent " + r10 + BdimCategoryConstants.SEPARATOR_COLON);
        if (r12 != null) goto L5;
    L9:
        CaeLog.e(TAG, "tcOutput is null or empty for dev " + r8 + " parent " + r10);
        return new HashMap();
    L5:
        if (r12.isEmpty() == true) goto L9;
        return parseHandlesFromOutput(r12, r8, r11);
    }

    public static Map<String, FilterHandles> getHandlesByFilterLog(String r8, List<PortRequest> r10) {
        HashMap r11 = new HashMap();
        if (isValidIfName(r8) == false) goto L12;
        if (r10 == null) goto L12;
        if (r10.isEmpty() == true) goto L12;
        Map<String, String> r12 = fetchAndParseHandles(r8, 5, r10);
        Map<String, String> r13 = fetchAndParseHandles(TC_INPUT_VIRTUAL_IFNAME, 6, r10);
        Iterator<PortRequest> r14 = r10.iterator();
    L10:
        if (r14.hasNext() == false) goto L12;
        String r15 = r14.next().getKey();
        r11.put(r15, new FilterHandles(r12.get(r15), r13.get(r15)));
    L12:
        return r11;
    }

    private static boolean isValidIfName(String r8) {
        if (r8 != null) goto L4;
    L12:
        CaeLog.e(TAG, "Invalid ifName: " + r8);
        return false;
    L4:
        if (r8.isEmpty() == true) goto L12;
        if (r8.length() > 15) goto L12;
        if (r8.contains(";") == true) goto L12;
        return true;
    }

    private static Map<String, String> parseHandlesFromOutput(String r13, String r14, List<PortRequest> r15) {
        HashMap r8 = new HashMap();
        HashMap r10 = new HashMap();
        Iterator<PortRequest> r16 = r15.iterator();
    L4:
        if (r16.hasNext() == false) goto L15;
        PortRequest r11 = r16.next();
        String r12 = String.format("%04x", new Object[]{Integer.valueOf(r11.port)}).toLowerCase();
        String r17 = "20";
        if (r14.equals(TC_INPUT_VIRTUAL_IFNAME) == false) goto L10;
        StringBuilder r18 = b.h("match 0000", r12, "/0000ffff at ");
        if (r11.isIpv4 == true) goto L14;
    L13:
        r17 = BDLocationException.ERROR_MULTI_THREAD_LOCATE;
    L14:
        r18.append(r17);
        r10.put(r18.toString(), r11.getKey());
        goto L4
    L10:
        r18 = b.h("match ", r12, "0000/ffff0000 at ");
        if (r11.isIpv4 == false) goto L13;
    L15:
        String[] r19 = r13.split("\\r?\\n");
        Pattern r110 = Pattern.compile("filter (?:parent \\d+: )?protocol\\s+\\b(ipv6|ip)\\b.*?fh ([0-9a-fA-F:]+) order");
        int r111 = r19.length;
        String r20 = null;
        int r21 = 0;
        String r22 = null;
    L16:
        if (r21 >= r111) goto L36;
        String r23 = r19[r21].trim().replaceAll("\\s+", " ");
        if (r23.startsWith("filter ") == false) goto L23;
        Matcher r24 = r110.matcher(r23);
        if (r24.find() == false) goto L35;
        r20 = r24.group(1);
        r22 = r24.group(2);
    L35:
        r21 = r21 + 1;
        goto L16
    L23:
        if (r23.startsWith("match ") == false) goto L35;
        boolean r25 = "ip".equals(r20);
        boolean r26 = "ipv6".equals(r20);
        Iterator r27 = r10.entrySet().iterator();
    L26:
        if (r27.hasNext() == false) goto L35;
        Map.Entry r112 = (Map.Entry) r27.next();
        String r113 = (String) r112.getKey();
        String r114 = (String) r112.getValue();
        boolean r115 = r114.startsWith("v4:");
        if (r115 == false) goto L30;
        if (r25 == false) goto L30;
    L33:
        if (r23.contains(r113) == false) goto L26;
        r8.put(r114, r22);
    L30:
        if (r115 == true) goto L26;
        if (r26 == false) goto L26;
    L36:
        return r8;
    }
}
