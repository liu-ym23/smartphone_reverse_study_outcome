package g9a;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.text.TextUtils;
import com.bytedance.apm.d;
import com.bytedance.apm.util.m;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.bytedance.security.android.aopcheck.PolarisFileWrapper;
import com.obric.aivoice.core.data.NameKeys;
import i9a.b;
import java.io.DataOutputStream;
import java.net.HttpURLConnection;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import x8a.c;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
public final class a {
    static {
        new ArrayList();
    }

    public static String a(String r4) {
        if (TextUtils.isEmpty(r4) == false) goto L6;
        return NameKeys.UnloadStrategy_No_Strategy;
    L6:
        int r0 = r4.lastIndexOf(".");
        if (r0 != (-1)) goto L11;
        return r4.concat("-cloudMsg.zip");
    L11:
        return r4.substring(0, r0) + "-cloudMsg.zip";
    }

    public static void b(i9a.a r14) {
        h9a.a r0 = r14.i;
        if (r0 != null) goto L5;
        return;
    L5:
        if (r0.a().size() != 0) goto L8;
        return;
    L8:
        if (r14.b == false) goto L11;
    L27:
        boolean r1 = false;
    L29:
        if (r1 == true) goto L32;
        return;
    L32:
        if (r14.k == true) goto L35;
        r14.o = r14.i.a();
    L51:
        String r2 = j9a.a.a;
        int r3 = 0;
        boolean r4 = false;
    L53:
        if (r3 >= r14.o.size()) goto L77;
        PolarisFileWrapper r5 = new PolarisFileWrapper((String) ListProtector.get(r14.o, r3));
        if (r5.exists() == false) goto L75;
        if (r3 >= (r14.o.size() - 1)) goto L60;
        int r6 = 1;
    L62:
        if (r14.n == false) goto L64;
        r6 = r14.d;
    L64:
        boolean r7 = j9a.a.a(j9a.a.a, r5, r6, r14.h, r14.c, r14.e, r14.f, r14.g);
        if (r7 == true) goto L67;
    L69:
        if (r3 != 0) goto L71;
        r4 = r7;
        goto L75
    L71:
        if (r4 == false) goto L74;
        if (r7 == false) goto L74;
        r4 = true;
    L74:
        r4 = false;
        goto L75
    L67:
        if (r14.k == false) goto L69;
        r5.delete();
        goto L69
    L60:
        r6 = 2;
    L75:
        r3 = r3 + 1;
        goto L53
    L77:
        if (r14.m == false) goto L101;
        if (r4 == false) goto L102;
        Iterator r15 = r14.i.a().iterator();
    L81:
        if (r15.hasNext() == false) goto L104;
        PolarisFileWrapper r8 = new PolarisFileWrapper((String) r15.next());
        if (r8.exists() == false) goto L81;
        r8.delete();
        goto L81
    L104:
        return;
    L102:
        return;
    L101:
        return;
    L35:
        if (r14.i.a().size() != 1) goto L37;
    L47:
        PolarisFileWrapper r9 = new PolarisFileWrapper((String) ListProtector.get(r14.i.a(), 0));
        PolarisFileWrapper r10 = new PolarisFileWrapper(r9.getParent(), a(r9.getName()));
        if (r10.exists() == false) goto L50;
        r10.delete();
    L50:
        com.monitor.cloudmessage.utils.a.b(r10.getAbsolutePath(), (String[]) r14.i.a().toArray(new String[r14.i.a().size()]));
        ArrayList r11 = new ArrayList(1);
        r11.add(r10.getAbsolutePath());
        r14.o = r11;
        goto L51
    L37:
        if (r14.l == true) goto L47;
        ArrayList r12 = new ArrayList();
        Iterator r13 = r14.i.a().iterator();
    L41:
        if (r13.hasNext() == false) goto L46;
        String r16 = (String) r13.next();
        PolarisFileWrapper r17 = new PolarisFileWrapper(r16);
        PolarisFileWrapper r18 = new PolarisFileWrapper(r17.getParent(), a(r17.getName()));
        if (r18.exists() == false) goto L45;
        r18.delete();
    L45:
        com.monitor.cloudmessage.utils.a.b(r18.getAbsolutePath(), new String[]{r16});
        r12.add(r18.getAbsolutePath());
        goto L41
    L46:
        r14.o = r12;
        goto L51
    L11:
        if (r14.j == false) goto L13;
    L15:
        Context r19 = c.b().getContext();
        if (r19 != null) goto L86;
    L25:
        boolean r20 = false;
    L26:
        if (r20 == false) goto L27;
        r1 = true;
        goto L29
    L86:
        NetworkInfo r21 = ((ConnectivityManager) r19.getSystemService("connectivity")).getActiveNetworkInfo();     // Catch: Exception -> L23
        if (r21 == null) goto L25;
        if (r21.isConnected() == false) goto L25;
        r20 = true;
    L23:
        e = move-exception;
        e.printStackTrace();
        goto L25
    L13:
        if ((System.currentTimeMillis() - r14.a) >= 0) goto L15;
        goto L15
    }

    public static void c(b r17) {
        if (d.j() == false) goto L6;
        ps3.b.a(new String[]{"uploadInfo=" + r17});
    L6:
        if (TextUtils.isEmpty(r17.c) == false) goto L8;
        return;
    L8:
        String r1 = j9a.a.a;
        int r4 = r17.d;
        String r5 = r17.c;
        String r6 = r17.e;
        long r7 = r17.f;
        HashMap<String, String> r0 = r17.g;
        HttpURLConnection r13 = null;
        DataOutputStream r14 = null;
        HttpURLConnection r2 = m.a(r1);     // Catch: Throwable -> L49
        r2.setReadTimeout(30000);     // Catch: Throwable -> L47
        r2.setConnectTimeout(30000);     // Catch: Throwable -> L47
        r2.setDoInput(true);     // Catch: Throwable -> L47
        r2.setDoOutput(true);     // Catch: Throwable -> L47
        r2.setUseCaches(false);     // Catch: Throwable -> L47
        r2.setRequestMethod("POST");     // Catch: Throwable -> L47
        r2.setRequestProperty("Charset", "UTF-8");     // Catch: Throwable -> L47
        r2.setRequestProperty("connection", "keep-alive");     // Catch: Throwable -> L47
        r2.setRequestProperty("Content-Type", "multipart/form-data;boundary=" + j9a.a.c);     // Catch: Throwable -> L47
        Map r3 = j9a.a.b;     // Catch: Throwable -> L47
        if (r3 != null) goto L14;
    L24:
        r2.connect();     // Catch: Throwable -> L47
        DataOutputStream r8 = new DataOutputStream(r2.getOutputStream());     // Catch: Throwable -> L47
        StringBuffer r12 = new StringBuffer();     // Catch: Throwable -> L45
        r12.append("--");     // Catch: Throwable -> L45
        String r15 = j9a.a.c;     // Catch: Throwable -> L45
        r12.append(r15);     // Catch: Throwable -> L45
        r12.append("\r\n");     // Catch: Throwable -> L45
        r12.append("Content-Disposition: form-data; name=\"status\"\r\n\r\n" + r4 + "\r\n--" + r15 + "\r\n");     // Catch: Throwable -> L45
        r12.append("Content-Disposition: form-data; name=\"cid\"\r\n\r\n" + r5 + "\r\n--" + r15 + "\r\n");     // Catch: Throwable -> L45
        r12.append("Content-Disposition: form-data; name=\"err_msg\"\r\n\r\n" + r6 + "\r\n--" + r15 + "\r\n");     // Catch: Throwable -> L45
        StringBuilder r9 = new StringBuilder();     // Catch: Throwable -> L45
        r9.append("Content-Disposition: form-data; name=\"aid\"\r\n\r\n");     // Catch: Throwable -> L45
        c.b();     // Catch: Throwable -> L45
        r9.append(NameKeys.UnloadStrategy_No_Strategy);     // Catch: Throwable -> L45
        r9.append("\r\n");     // Catch: Throwable -> L45
        r9.append("--");     // Catch: Throwable -> L45
        r9.append(r15);     // Catch: Throwable -> L45
        r9.append("\r\n");     // Catch: Throwable -> L45
        r12.append(r9.toString());     // Catch: Throwable -> L45
        StringBuilder r10 = new StringBuilder();     // Catch: Throwable -> L45
        r10.append("Content-Disposition: form-data; name=\"update_version_code\"\r\n\r\n");     // Catch: Throwable -> L45
        c.b();     // Catch: Throwable -> L45
        r10.append(NameKeys.UnloadStrategy_No_Strategy);     // Catch: Throwable -> L45
        r10.append("\r\n");     // Catch: Throwable -> L45
        r10.append("--");     // Catch: Throwable -> L45
        r10.append(r15);     // Catch: Throwable -> L45
        r10.append("\r\n");     // Catch: Throwable -> L45
        r12.append(r10.toString());     // Catch: Throwable -> L45
        r12.append("Content-Disposition: form-data; name=\"operate_time\"\r\n\r\n" + r7 + "\r\n--" + r15 + "\r\n");     // Catch: Throwable -> L45
        if (r4 != 2) goto L28;
    L33:
        r8.write(r12.toString().getBytes());     // Catch: Throwable -> L45
        j9a.a.b(r8, r0);     // Catch: Throwable -> L45
        r12.setLength(0);     // Catch: Throwable -> L45
    L34:
        StringBuilder r11 = new StringBuilder();     // Catch: Throwable -> L45
        r11.append("Content-Disposition: form-data; name=\"uid\"\r\n\r\n");     // Catch: Throwable -> L45
        c.b();     // Catch: Throwable -> L45
        r11.append(NameKeys.UnloadStrategy_No_Strategy);     // Catch: Throwable -> L45
        r11.append("\r\n");     // Catch: Throwable -> L45
        r11.append("--");     // Catch: Throwable -> L45
        r11.append(r15);     // Catch: Throwable -> L45
        r11.append("\r\n");     // Catch: Throwable -> L45
        r12.append(r11.toString());     // Catch: Throwable -> L45
        r8.write(r12.toString().getBytes());     // Catch: Throwable -> L45
        r8.flush();     // Catch: Throwable -> L45
        r8.close();     // Catch: Throwable -> L45
        if (r2.getResponseCode() != 200) goto L42;
        r2.disconnect();
        r8.close();     // Catch: Throwable -> L40
        return;
    L40:
        th = move-exception;
        th.printStackTrace();
        return;
    L42:
        r2.disconnect();
        r8.close();     // Catch: Throwable -> L57
    L70:
        return;
    L28:
        if (r4 == 3) goto L33;
        if (r4 != 0) goto L34;
        if (r0 == null) goto L34;
        if (r0.isEmpty() == true) goto L34;
    L45:
        th = th;
        r14 = r8;
    L48:
        DataOutputStream r16 = r14;
        r13 = r2;
        DataOutputStream r18 = r16;
    L76:
        th.printStackTrace();     // Catch: Throwable -> L60
        if (r13 == null) goto L54;
        r13.disconnect();
    L54:
        if (r18 == null) goto L94;
        r18.close();     // Catch: Throwable -> L57
        goto L70
    L94:
        return;
    L60:
        th = move-exception;
        if (r13 == null) goto L64;
        r13.disconnect();
    L64:
        if (r18 == null) goto L96;
        r18.close();     // Catch: Throwable -> L67
        throw th;
    L67:
        th = move-exception;
        th.printStackTrace();
        throw th;
    L96:
        throw th;
    L14:
        if (((HashMap) r3).isEmpty() == true) goto L24;
        Iterator r19 = ((HashMap) r3).entrySet().iterator();     // Catch: Throwable -> L47
    L17:
        if (r19.hasNext() == false) goto L24;
        Map.Entry r110 = (Map.Entry) r19.next();     // Catch: Throwable -> L47
        String r111 = (String) r110.getKey();     // Catch: Throwable -> L47
        String r112 = (String) r110.getValue();     // Catch: Throwable -> L47
        if (TextUtils.isEmpty(r111) == true) goto L17;
        if (TextUtils.isEmpty(r112) == true) goto L17;
        r2.setRequestProperty(r111, r112);     // Catch: Throwable -> L47
    L47:
        th = th;
    L57:
        th = move-exception;
        th.printStackTrace();
        return;
    L49:
        th = th;
        r18 = null;
        goto L76
    }
}
