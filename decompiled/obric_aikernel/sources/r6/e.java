package r6;

import android.content.Context;
import android.text.TextUtils;
import com.bytedance.apm6.util.constant.ReportConsts;
import com.monitor.cloudmessage.utils.NetworkUtils;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.URL;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public class e {
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r7v0 */
    /* JADX WARN: Type inference failed for: r7v1 */
    /* JADX WARN: Type inference failed for: r7v11 */
    /* JADX WARN: Type inference failed for: r7v13 */
    /* JADX WARN: Type inference failed for: r7v14 */
    /* JADX WARN: Type inference failed for: r7v15 */
    /* JADX WARN: Type inference failed for: r7v16 */
    /* JADX WARN: Type inference failed for: r7v17 */
    /* JADX WARN: Type inference failed for: r7v2, types: [java.io.InputStream] */
    /* JADX WARN: Type inference failed for: r7v3, types: [java.io.InputStream] */
    public static File a(Context r13, JSONObject r14) {
        String r15 = r14.optString("domain");
        OutputStream r10 = null;
        if (TextUtils.isEmpty(r15) == true) goto L109;
        JSONObject r11 = new JSONObject();
        if (r15.startsWith("http://") == false) goto L7;
    L9:
        String r12 = null;
    L136:
        String r16 = new URL(r15).getHost();     // Catch: Throwable -> L63 Exception -> L65
        String r17 = com.monitor.cloudmessage.utils.b.h(r13).getAbsolutePath();     // Catch: Throwable -> L63 Exception -> L65
        String r18 = r17 + File.separator + String.format("%s.txt", new Object[]{r16});     // Catch: Throwable -> L63 Exception -> L65
        r11.put("networkType", NetworkUtils.e(r13));     // Catch: Throwable -> L63 Exception -> L65
        r11.put("currentNativeIP", NetworkUtils.d());     // Catch: Throwable -> L63 Exception -> L65
        r11.put("localDNS", NetworkUtils.c(r13));     // Catch: Throwable -> L63 Exception -> L65
        r11.put("localGateway", NetworkUtils.b(r13));     // Catch: Throwable -> L63 Exception -> L65
        r11.put("uploadSpeed", NetworkUtils.j(r13));     // Catch: Throwable -> L63 Exception -> L65
        r11.put("downloadSpeed", NetworkUtils.a(r13));     // Catch: Throwable -> L63 Exception -> L65
        r11.put("cdn", r16);     // Catch: Throwable -> L63 Exception -> L65
        r11.put("domainNameParse", NetworkUtils.m(r16));     // Catch: Throwable -> L63 Exception -> L65
        if (NetworkUtils.n(r15, r11) == true) goto L14;
        if (r12 == null) goto L14;
        NetworkUtils.n(r12, r11);     // Catch: Throwable -> L63 Exception -> L65
    L14:
        Process r19 = Runtime.getRuntime().exec("ping -c 5 " + r16);     // Catch: Throwable -> L63 Exception -> L65
        OutputStream r110 = r19.getOutputStream();     // Catch: Throwable -> L63 Exception -> L65
        r110.close();     // Catch: Throwable -> L59 Exception -> L61
        long r20 = System.nanoTime();     // Catch: Throwable -> L59 Exception -> L61
        float r21 = 0.0f;
        InputStream r22 = r19.getInputStream();     // Catch: Throwable -> L59 Exception -> L61
        BufferedReader r23 = new BufferedReader(new InputStreamReader(r22, "UTF8"));     // Catch: Throwable -> L55 Exception -> L57
        JSONArray r24 = new JSONArray();     // Catch: Throwable -> L55 Exception -> L57
    L17:
        String r111 = r23.readLine();     // Catch: Throwable -> L55 Exception -> L57
        if (r111 == null) goto L24;
        r24.put(r111);     // Catch: Throwable -> L55 Exception -> L57
        if (r111.contains("From") == true) goto L23;
        if (r111.contains("from") == false) goto L17;
    L23:
        r21 = (System.nanoTime() - r20) / 1000000.0f;     // Catch: Throwable -> L55 Exception -> L57
        goto L17
    L24:
        r19.destroy();     // Catch: Throwable -> L55 Exception -> L57
        r11.put("pingResults", r24);     // Catch: Throwable -> L55 Exception -> L57
        r11.put("elapsedTime", r21);     // Catch: Throwable -> L55 Exception -> L57
        File r112 = new File(r17);     // Catch: Throwable -> L55 Exception -> L57
        if (r112.exists() == true) goto L27;
        r112.mkdirs();     // Catch: Throwable -> L55 Exception -> L57
    L27:
        FileWriter r113 = new FileWriter(r18);     // Catch: Throwable -> L55 Exception -> L57
    L138:
        BufferedWriter r25 = new BufferedWriter(r113);     // Catch: Throwable -> L49 Exception -> L52
        r25.write(r11.toString());     // Catch: Throwable -> L45 Exception -> L47
        r110.close();     // Catch: IOException -> L32
    L34:
        if (r22 != null) goto L128;
    L122:
        r25.close();     // Catch: IOException -> L41
        r113.close();     // Catch: IOException -> L41
    L44:
        return new File(r18);
    L41:
        e = move-exception;
        e.printStackTrace();
        goto L44
    L128:
        r22.close();     // Catch: IOException -> L37
    L37:
        e = move-exception;
        e.printStackTrace();
    L32:
        e = move-exception;
        e.printStackTrace();
        goto L34
    L47:
        e = e;
    L54:
        FileWriter r114 = r113;
        e = e;
        OutputStream r26 = r110;
        ?? r27 = r22;
    L116:
        e.printStackTrace();     // Catch: Throwable -> L88
        if (r26 != null) goto L118;
    L74:
        if (r27 != 0) goto L110;
    L79:
        if (r25 != null) goto L124;
    L83:
        if (r114 == null) goto L87;
        r114.close();     // Catch: IOException -> L81
    L81:
        e = move-exception;
        e.printStackTrace();
    L87:
        return null;
    L124:
        r25.close();     // Catch: IOException -> L81
        goto L83
    L110:
        r27.close();     // Catch: IOException -> L77
    L77:
        e = move-exception;
        e.printStackTrace();
        goto L79
    L118:
        r26.close();     // Catch: IOException -> L72
    L72:
        e = move-exception;
        e.printStackTrace();
    L88:
        th = th;
        r10 = r26;
        ?? r28 = r27;
    L90:
        if (r10 != null) goto L112;
    L95:
        if (r28 != 0) goto L126;
    L100:
        if (r25 != null) goto L120;
    L104:
        if (r114 == null) goto L146;
        r114.close();     // Catch: IOException -> L102
        throw th;
    L102:
        e = move-exception;
        e.printStackTrace();
        throw th;
    L146:
        throw th;
    L120:
        r25.close();     // Catch: IOException -> L102
        goto L104
    L126:
        r28.close();     // Catch: IOException -> L98
    L98:
        e = move-exception;
        e.printStackTrace();
        goto L100
    L112:
        r10.close();     // Catch: IOException -> L93
    L93:
        e = move-exception;
        e.printStackTrace();
    L45:
        th = th;
    L51:
        r10 = r110;
        r114 = r113;
        th = th;
        r28 = r22;
        goto L90
    L52:
        e = e;
        r25 = null;
    L49:
        th = th;
        r25 = null;
    L57:
        e = e;
        r26 = r110;
        r114 = null;
        r25 = null;
        r27 = r22;
    L55:
        th = th;
        r25 = null;
        r10 = r110;
        r114 = null;
        r28 = r22;
        goto L90
    L61:
        e = e;
        r26 = r110;
        r114 = null;
        r25 = null;
    L67:
        r27 = r25;
    L59:
        th = th;
        r25 = null;
        r28 = 0;
        r10 = r110;
        r114 = null;
        goto L90
    L65:
        e = e;
        r114 = null;
        r26 = null;
        r25 = null;
    L63:
        th = th;
        r114 = null;
        r25 = null;
        r28 = 0;
        goto L90
    L7:
        if (r15.startsWith(ReportConsts.HTTPS) == true) goto L9;
        r12 = "http://" + r15;
        r15 = ReportConsts.HTTPS + r15;
        goto L136
    L109:
        return null;
    }
}
