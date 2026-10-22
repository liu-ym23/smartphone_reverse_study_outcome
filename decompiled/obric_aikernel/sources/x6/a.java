package x6;

import android.text.TextUtils;
import com.bytedance.apm.util.m;
import com.bytedance.apm6.util.constant.NetConst;
import com.bytedance.common.wschannel.WsConstants;
import com.bytedance.crypto.cloudsync.network.CloudConfig;
import com.monitor.cloudmessage.utils.d;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.net.HttpURLConnection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.UUID;
import w6.b;

/* JADX INFO: loaded from: classes2.dex */
public class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static String f13564a = "https://mon.zijieapi.com/monitor/collect/c/cloudcontrol/file";

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static String f13565b = "UTF-8";

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static Map<String, String> f13566c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    static final String f13567d = null;

    static {
        f13566c = new HashMap();
        f13567d = "cloudMessage" + UUID.randomUUID().toString();
    }

    private static boolean a(String r14, File r15, Map<String, String> r16, int r17, String r18, String r19, String r20, long r21, HashMap<String, String> r23) {
        if (TextUtils.isEmpty(r14) == true) goto L77;
        if (r15 == null) goto L77;
        if (r15.exists() == false) goto L77;
        HttpURLConnection r10 = null;
        HttpURLConnection r11 = m.a(r14);     // Catch: Throwable -> L55
        r11.setReadTimeout(30000);     // Catch: Throwable -> L52
        r11.setConnectTimeout(30000);     // Catch: Throwable -> L52
        r11.setDoInput(true);     // Catch: Throwable -> L52
        r11.setDoOutput(true);     // Catch: Throwable -> L52
        r11.setUseCaches(false);     // Catch: Throwable -> L52
        r11.setRequestMethod(CloudConfig.REQUEST_TYPE_POST);     // Catch: Throwable -> L52
        r11.setRequestProperty("Charset", f13565b);     // Catch: Throwable -> L52
        r11.setRequestProperty(WsConstants.KEY_CONNECTION, "keep-alive");     // Catch: Throwable -> L52
        r11.setRequestProperty(NetConst.KEY_CONTENT_TYPE, "multipart/form-data;boundary=" + f13567d);     // Catch: Throwable -> L52
        Map<String, String> r12 = f13566c;     // Catch: Throwable -> L52
        if (r12 != null) goto L13;
    L23:
        r11.connect();     // Catch: Throwable -> L52
        DataOutputStream r13 = new DataOutputStream(r11.getOutputStream());     // Catch: Throwable -> L52
        StringBuffer r22 = new StringBuffer();     // Catch: Throwable -> L50
        r22.append("--");     // Catch: Throwable -> L50
        String r110 = f13567d;     // Catch: Throwable -> L50
        r22.append(r110);     // Catch: Throwable -> L50
        r22.append("\r\n");     // Catch: Throwable -> L50
        r22.append("Content-Disposition: form-data; name=\"status\"\r\n\r\n" + r17 + "\r\n--" + r110 + "\r\n");     // Catch: Throwable -> L50
        r22.append("Content-Disposition: form-data; name=\"cid\"\r\n\r\n" + r19 + "\r\n--" + r110 + "\r\n");     // Catch: Throwable -> L50
        r22.append("Content-Disposition: form-data; name=\"err_msg\"\r\n\r\n" + r20 + "\r\n--" + r110 + "\r\n");     // Catch: Throwable -> L50
        r22.append("Content-Disposition: form-data; name=\"operate_time\"\r\n\r\n" + r21 + "\r\n--" + r110 + "\r\n");     // Catch: Throwable -> L50
        StringBuilder r111 = new StringBuilder();     // Catch: Throwable -> L50
        r111.append("Content-Disposition: form-data; name=\"aid\"\r\n\r\n");     // Catch: Throwable -> L50
        k6.a.k();     // Catch: Throwable -> L50
        r111.append(k6.a.f());     // Catch: Throwable -> L50
        r111.append("\r\n");     // Catch: Throwable -> L50
        r111.append("--");     // Catch: Throwable -> L50
        r111.append(r110);     // Catch: Throwable -> L50
        r111.append("\r\n");     // Catch: Throwable -> L50
        r22.append(r111.toString());     // Catch: Throwable -> L50
        StringBuilder r112 = new StringBuilder();     // Catch: Throwable -> L50
        r112.append("Content-Disposition: form-data; name=\"update_version_code\"\r\n\r\n");     // Catch: Throwable -> L50
        k6.a.k();     // Catch: Throwable -> L50
        r112.append(k6.a.n());     // Catch: Throwable -> L50
        r112.append("\r\n");     // Catch: Throwable -> L50
        r112.append("--");     // Catch: Throwable -> L50
        r112.append(r110);     // Catch: Throwable -> L50
        r112.append("\r\n");     // Catch: Throwable -> L50
        r22.append(r112.toString());     // Catch: Throwable -> L50
        StringBuilder r113 = new StringBuilder();     // Catch: Throwable -> L50
        r113.append("Content-Disposition: form-data; name=\"uid\"\r\n\r\n");     // Catch: Throwable -> L50
        k6.a.k();     // Catch: Throwable -> L50
        r113.append(k6.a.m());     // Catch: Throwable -> L50
        r113.append("\r\n");     // Catch: Throwable -> L50
        r113.append("--");     // Catch: Throwable -> L50
        r113.append(r110);     // Catch: Throwable -> L50
        r113.append("\r\n");     // Catch: Throwable -> L50
        r22.append(r113.toString());     // Catch: Throwable -> L50
        if (r17 != 2) goto L27;
    L32:
        r13.write(r22.toString().getBytes());     // Catch: Throwable -> L50
        f(r13, r23);     // Catch: Throwable -> L50
        r22.setLength(0);     // Catch: Throwable -> L50
    L33:
        r22.append("Content-Disposition: form-data; name=\"file\"; filetype=\"" + r18 + "\"; filename=\"" + r15.getName() + "\"\r\n");     // Catch: Throwable -> L50
        r22.append("Content-Type: text/plain\r\n");     // Catch: Throwable -> L50
        r22.append("\r\n");     // Catch: Throwable -> L50
        r13.write(r22.toString().getBytes());     // Catch: Throwable -> L50
        FileInputStream r24 = new FileInputStream(r15);     // Catch: Throwable -> L50
        byte[] r25 = new byte[1024];     // Catch: Throwable -> L50
    L34:
        int r26 = r24.read(r25);     // Catch: Throwable -> L50
        if (r26 == (-1)) goto L37;
        r13.write(r25, 0, r26);     // Catch: Throwable -> L50
        goto L34
    L37:
        r24.close();     // Catch: Throwable -> L50
        r13.write("\r\n".getBytes());     // Catch: Throwable -> L50
        r13.write(("--" + f13567d + "--\r\n").getBytes());     // Catch: Throwable -> L50
        r13.flush();     // Catch: Throwable -> L50
        r13.close();     // Catch: Throwable -> L50
        int r27 = r11.getResponseCode();     // Catch: Throwable -> L50
        r11.disconnect();
        if (r27 == 200) goto L88;
        r13.close();     // Catch: Throwable -> L47
    L49:
        return false;
    L47:
        th = move-exception;
        th.printStackTrace();
        goto L49
    L88:
        r13.close();     // Catch: Throwable -> L42
    L44:
        return true;
    L42:
        th = move-exception;
        th.printStackTrace();
        goto L44
    L27:
        if (r17 == 3) goto L32;
        if (r17 != 0) goto L33;
        if (r23 == null) goto L33;
        if (r23.isEmpty() == true) goto L33;
    L50:
        th = th;
    L54:
        r10 = r11;
    L86:
        th.printStackTrace();     // Catch: Throwable -> L66
        if (r10 == null) goto L60;
        r10.disconnect();
    L60:
        if (r13 != null) goto L78;
    L65:
        return false;
    L78:
        r13.close();     // Catch: Throwable -> L63
    L63:
        th = move-exception;
        th.printStackTrace();
    L66:
        th = move-exception;
        if (r10 == null) goto L70;
        r10.disconnect();
    L70:
        if (r13 == null) goto L103;
        r13.close();     // Catch: Throwable -> L73
        throw th;
    L73:
        th = move-exception;
        th.printStackTrace();
        throw th;
    L103:
        throw th;
    L13:
        if (r12.isEmpty() == true) goto L23;
        Iterator<Map.Entry<String, String>> r28 = f13566c.entrySet().iterator();     // Catch: Throwable -> L52
    L16:
        if (r28.hasNext() == false) goto L23;
        Map.Entry<String, String> r114 = r28.next();     // Catch: Throwable -> L52
        String r115 = r114.getKey();     // Catch: Throwable -> L52
        String r116 = r114.getValue();     // Catch: Throwable -> L52
        if (TextUtils.isEmpty(r115) == true) goto L16;
        if (TextUtils.isEmpty(r116) == true) goto L16;
        r11.setRequestProperty(r115, r116);     // Catch: Throwable -> L52
    L52:
        th = th;
        r13 = null;
    L55:
        th = th;
        r13 = null;
    L77:
        throw new IllegalArgumentException("url and file not be null ");
    }

    private static boolean b(String r10, Map<String, String> r11, int r12, String r13, String r14, long r15, HashMap<String, String> r16) {
        HttpURLConnection r17 = null;
        HttpURLConnection r18 = m.a(r10);     // Catch: Throwable -> L46
        r18.setReadTimeout(30000);     // Catch: Throwable -> L43
        r18.setConnectTimeout(30000);     // Catch: Throwable -> L43
        r18.setDoInput(true);     // Catch: Throwable -> L43
        r18.setDoOutput(true);     // Catch: Throwable -> L43
        r18.setUseCaches(false);     // Catch: Throwable -> L43
        r18.setRequestMethod(CloudConfig.REQUEST_TYPE_POST);     // Catch: Throwable -> L43
        r18.setRequestProperty("Charset", f13565b);     // Catch: Throwable -> L43
        r18.setRequestProperty(WsConstants.KEY_CONNECTION, "keep-alive");     // Catch: Throwable -> L43
        r18.setRequestProperty(NetConst.KEY_CONTENT_TYPE, "multipart/form-data;boundary=" + f13567d);     // Catch: Throwable -> L43
        Map<String, String> r19 = f13566c;     // Catch: Throwable -> L43
        if (r19 != null) goto L8;
    L18:
        r18.connect();     // Catch: Throwable -> L43
        DataOutputStream r20 = new DataOutputStream(r18.getOutputStream());     // Catch: Throwable -> L43
        StringBuffer r21 = new StringBuffer();     // Catch: Throwable -> L41
        r21.append("--");     // Catch: Throwable -> L41
        String r22 = f13567d;     // Catch: Throwable -> L41
        r21.append(r22);     // Catch: Throwable -> L41
        r21.append("\r\n");     // Catch: Throwable -> L41
        r21.append("Content-Disposition: form-data; name=\"status\"\r\n\r\n" + r12 + "\r\n--" + r22 + "\r\n");     // Catch: Throwable -> L41
        r21.append("Content-Disposition: form-data; name=\"cid\"\r\n\r\n" + r13 + "\r\n--" + r22 + "\r\n");     // Catch: Throwable -> L41
        r21.append("Content-Disposition: form-data; name=\"err_msg\"\r\n\r\n" + r14 + "\r\n--" + r22 + "\r\n");     // Catch: Throwable -> L41
        StringBuilder r110 = new StringBuilder();     // Catch: Throwable -> L41
        r110.append("Content-Disposition: form-data; name=\"aid\"\r\n\r\n");     // Catch: Throwable -> L41
        k6.a.k();     // Catch: Throwable -> L41
        r110.append(k6.a.f());     // Catch: Throwable -> L41
        r110.append("\r\n");     // Catch: Throwable -> L41
        r110.append("--");     // Catch: Throwable -> L41
        r110.append(r22);     // Catch: Throwable -> L41
        r110.append("\r\n");     // Catch: Throwable -> L41
        r21.append(r110.toString());     // Catch: Throwable -> L41
        StringBuilder r111 = new StringBuilder();     // Catch: Throwable -> L41
        r111.append("Content-Disposition: form-data; name=\"update_version_code\"\r\n\r\n");     // Catch: Throwable -> L41
        k6.a.k();     // Catch: Throwable -> L41
        r111.append(k6.a.n());     // Catch: Throwable -> L41
        r111.append("\r\n");     // Catch: Throwable -> L41
        r111.append("--");     // Catch: Throwable -> L41
        r111.append(r22);     // Catch: Throwable -> L41
        r111.append("\r\n");     // Catch: Throwable -> L41
        r21.append(r111.toString());     // Catch: Throwable -> L41
        r21.append("Content-Disposition: form-data; name=\"operate_time\"\r\n\r\n" + r15 + "\r\n--" + r22 + "\r\n");     // Catch: Throwable -> L41
        if (r12 != 2) goto L22;
    L27:
        r20.write(r21.toString().getBytes());     // Catch: Throwable -> L41
        f(r20, r16);     // Catch: Throwable -> L41
        r21.setLength(0);     // Catch: Throwable -> L41
    L28:
        StringBuilder r112 = new StringBuilder();     // Catch: Throwable -> L41
        r112.append("Content-Disposition: form-data; name=\"uid\"\r\n\r\n");     // Catch: Throwable -> L41
        k6.a.k();     // Catch: Throwable -> L41
        r112.append(k6.a.m());     // Catch: Throwable -> L41
        r112.append("\r\n");     // Catch: Throwable -> L41
        r112.append("--");     // Catch: Throwable -> L41
        r112.append(r22);     // Catch: Throwable -> L41
        r112.append("\r\n");     // Catch: Throwable -> L41
        r21.append(r112.toString());     // Catch: Throwable -> L41
        r20.write(r21.toString().getBytes());     // Catch: Throwable -> L41
        r20.flush();     // Catch: Throwable -> L41
        r20.close();     // Catch: Throwable -> L41
        int r23 = r18.getResponseCode();     // Catch: Throwable -> L41
        r18.disconnect();
        if (r23 != 200) goto L80;
        r20.close();     // Catch: Throwable -> L33
    L35:
        return true;
    L33:
        th = move-exception;
        th.printStackTrace();
        goto L35
    L80:
        r20.close();     // Catch: Throwable -> L38
    L40:
        return false;
    L38:
        th = move-exception;
        th.printStackTrace();
        goto L40
    L22:
        if (r12 == 3) goto L27;
        if (r12 != 0) goto L28;
        if (r16 == null) goto L28;
        if (r16.isEmpty() == true) goto L28;
    L41:
        th = th;
    L45:
        r17 = r18;
    L78:
        th.printStackTrace();     // Catch: Throwable -> L57
        if (r17 == null) goto L51;
        r17.disconnect();
    L51:
        if (r20 != null) goto L72;
    L56:
        return false;
    L72:
        r20.close();     // Catch: Throwable -> L54
    L54:
        th = move-exception;
        th.printStackTrace();
    L57:
        th = move-exception;
        if (r17 == null) goto L60;
        r17.disconnect();
    L60:
        if (r20 != null) goto L76;
    L65:
        throw th;
    L76:
        r20.close();     // Catch: Throwable -> L63
    L63:
        th = move-exception;
        th.printStackTrace();
        goto L65
    L8:
        if (r19.isEmpty() == true) goto L18;
        Iterator<Map.Entry<String, String>> r24 = f13566c.entrySet().iterator();     // Catch: Throwable -> L43
    L11:
        if (r24.hasNext() == false) goto L18;
        Map.Entry<String, String> r25 = r24.next();     // Catch: Throwable -> L43
        String r26 = r25.getKey();     // Catch: Throwable -> L43
        String r27 = r25.getValue();     // Catch: Throwable -> L43
        if (TextUtils.isEmpty(r26) == true) goto L11;
        if (TextUtils.isEmpty(r27) == true) goto L11;
        r18.setRequestProperty(r26, r27);     // Catch: Throwable -> L43
    L43:
        th = th;
        r20 = null;
    L46:
        th = th;
        r20 = null;
        goto L78
    }

    public static boolean c(b r10) {
        return b(f13564a, null, r10.a(), r10.b(), r10.c(), r10.e(), r10.f());
    }

    public static boolean d(File r10, int r11, String r12, String r13, String r14, long r15, HashMap<String, String> r17) {
        return a(f13564a, r10, null, r11, r12, r13, r14, r15, r17);
    }

    public static boolean e(w6.a r15) {
        int r10 = 0;
        boolean r11 = false;
    L4:
        if (r10 >= r15.l().size()) goto L27;
        File r12 = new File(r15.l().get(r10));
        if (r12.exists() == false) goto L26;
        if (r10 >= (r15.l().size() - 1)) goto L11;
        int r13 = 1;
    L13:
        if (r15.o() == false) goto L15;
        r13 = r15.a();
    L15:
        boolean r14 = a(f13564a, r12, null, r13, r15.k(), r15.b(), r15.c(), r15.e(), r15.f());
        if (r14 == true) goto L18;
    L20:
        if (r10 != 0) goto L22;
        r11 = r14;
        goto L26
    L22:
        if (r11 == false) goto L25;
        if (r14 == false) goto L25;
        r11 = true;
    L25:
        r11 = false;
        goto L26
    L18:
        if (r15.m() == false) goto L20;
        r12.delete();
        goto L20
    L11:
        r13 = 2;
    L26:
        r10 = r10 + 1;
        goto L4
    L27:
        return r11;
    }

    private static void f(DataOutputStream r10, HashMap<String, String> r11) {
        if (k6.a.k().h() != null) goto L5;
    L7:
        if (r11 != null) goto L9;
        return;
    L9:
        if (r11.size() == 0) goto L13;
        r10.write(("Content-Disposition: form-data; name=\"fileSpecific\"; filetype=\"command_specificparams\"; filename=\"specific_params.txt\"\r\nContent-Type: text/plain\r\n\r\n").getBytes());
        r10.write(d.b(r11).getBytes());
        r10.write("\r\n".getBytes());
        r10.write(("--" + f13567d + "\r\n").getBytes());
        r10.flush();
        return;
    L13:
        return;
    L5:
        if (k6.a.k().h().size() == 0) goto L7;
        r10.write(("Content-Disposition: form-data; name=\"fileCommon\"; filetype=\"command_commonparams\"; filename=\"common_params.txt\"\r\nContent-Type: text/plain\r\n\r\n").getBytes());
        r10.write(d.b(k6.a.k().h()).getBytes());
        r10.write("\r\n".getBytes());
        r10.write(("--" + f13567d + "\r\n").getBytes());
        r10.flush();
        goto L7
    }
}
