package com.bytedance.ttnet.diagnosis;

import com.bytedance.ttnet.TTNetInit;
import com.bytedance.ttnet.c;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import r2.i;

/* JADX INFO: loaded from: classes.dex */
public class TTNetDiagnosisService {
    public static final int ACCELERATE_TARGET = 2;
    public static final int ACTION_FORCE_CELLULAR = 1;
    public static final int ACTION_FORCE_DEFAULT = 3;
    public static final int ACTION_FORCE_WIFI = 2;
    public static final int ACTION_UNSPECIFIED = 0;
    public static final int DIAGNOSE_TARGET = 3;
    public static final int DIAGNOSE_V2_TARGET = 4;
    public static final int DNS_RESOLVE_TARGET = 0;
    public static final int NET_DETECT_ALL = -1;
    public static final int NET_DETECT_FULL_DNS = 128;
    public static final int NET_DETECT_HTTP_GET = 1;
    public static final int NET_DETECT_HTTP_ISP = 4096;
    public static final int NET_DETECT_ICMP_PING = 2;
    public static final int NET_DETECT_LOCAL_DNS = 8;
    public static final int NET_DETECT_TCP_CONNECT = 256;
    public static final int NET_DETECT_TCP_ECHO = 512;
    public static final int NET_DETECT_TCP_PERF = 2048;
    public static final int NET_DETECT_TRACEROUTE = 4;
    public static final int NET_DETECT_UDP_PERF = 1024;
    public static final int NET_DETECT_UDP_PING = 64;
    public static final int RACE_TARGETS = 1;
    public static final int RAW_DETECT_TARGETS = 5;
    private static final Map<Integer, String> sTypeStringMap = null;

    static {
        HashMap r10 = new HashMap();
        sTypeStringMap = r10;
        r10.put(0, "DNS_RESOLVE_TARGET");
        r10.put(1, "RACE_TARGETS");
        r10.put(2, "ACCELERATE_TARGET");
        r10.put(3, "DIAGNOSE_TARGET");
        r10.put(4, "DIAGNOSE_V2_TARGET");
        r10.put(5, "RAW_DETECT_TARGETS");
    }

    public TTNetDiagnosisService() {
    }

    public static IDiagnosisRequest createRequest(int r10, String r11, int r12, int r13) {
        return createRequest(r10, r11, r12, 0, r13);
    }

    public static IDiagnosisRequest createRequest(int r10, String r11, int r12, int r13, int r14) {
        if (isOneTargetRequestType(r10) == false) goto L20;
        if (isValidNetDetect(r10, r12) == false) goto L18;
        if (r10 != 0) goto L8;
    L15:
        ArrayList r15 = new ArrayList();
        r15.add(r11);
        return new a(r10, r15, r12, r13, r14);
    L8:
        if (r10 == 2) goto L15;
        if (r10 == 3) goto L15;
        if (r10 == 4) goto L15;
        return null;
    L18:
        throw new IllegalArgumentException("Illegal netDetectType: " + r12);
    L20:
        throw new IllegalArgumentException("Type " + requestTypeToString(r10) + " of request should be created with multiple targets.");
    }

    public static IDiagnosisRequest createRequest(int r10, List<String> r11, int r12, int r13) {
        if (isOneTargetRequestType(r10) == true) goto L17;
        if (isValidNetDetect(r10, r12) == false) goto L15;
        if (r10 == 1) goto L13;
        if (r10 == 5) goto L13;
        return null;
    L13:
        return new a(r10, r11, r12, 0, r13);
    L15:
        throw new IllegalArgumentException("Illegal netDetectType: " + r12);
    L17:
        throw new IllegalArgumentException("Type " + requestTypeToString(r10) + " of request should be created with only one target.");
    }

    private static i getCronetHttpClient() {
        if (c.c() == false) goto L7;
        return i.w(TTNetInit.getTTNetDepend().getContext());
    L7:
        throw new UnsupportedOperationException("Cronet is not enabled");
    }

    private static boolean isOneTargetRequestType(int r10) {
        if (r10 == 0) goto L18;
        if (r10 != 1) goto L6;
        return false;
    L6:
        if (r10 == 2) goto L18;
        if (r10 == 3) goto L18;
        if (r10 == 4) goto L18;
        if (r10 != 5) goto L15;
        return false;
    L15:
        throw new IllegalArgumentException("Illegal request type: " + r10);
    L18:
        return true;
    }

    private static boolean isValidNetDetect(int r10, long r11) {
        if (r10 != 0) goto L5;
        return true;
    L5:
        if (r10 == 1) goto L28;
        if (r10 == 2) goto L19;
        if (r10 != 3) goto L11;
    L17:
        return true;
    L11:
        if (r10 == 4) goto L17;
        if (r10 == 5) goto L28;
        throw new IllegalArgumentException("Illegal request type: " + r10);
    L19:
        if (r11 != 1) goto L21;
    L26:
        return true;
    L21:
        if (r11 == 2) goto L26;
        if (r11 == 64) goto L26;
        return false;
    L28:
        if (((-1) & r11) != 0) goto L30;
    L32:
        return false;
    L30:
        if ((r11 & 0) != 0) goto L32;
        return true;
    }

    public static void reportUserLog(String r10) {
        if (r10 != null) goto L4;
        return;
    L4:
        if (r10.isEmpty() == true) goto L17;
        i r11 = getCronetHttpClient();     // Catch: Exception -> L10
        if (r11 == null) goto L16;
        r11.H(r10);     // Catch: Exception -> L10
        return;
    L16:
        return;
    L10:
        e = move-exception;
        e.printStackTrace();
        return;
    }

    private static String requestTypeToString(int r10) {
        return sTypeStringMap.get(Integer.valueOf(r10));
    }
}
