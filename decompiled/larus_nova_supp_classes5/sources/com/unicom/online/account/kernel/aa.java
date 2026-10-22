package com.unicom.online.account.kernel;

import android.content.Context;
import android.net.Network;
import android.net.Uri;
import android.text.TextUtils;
import android.util.Base64;
import com.larus.utils.logger.FLogger;
import com.ss.android.ugc.effectmanager.common.EffectRequest;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Locale;
import javax.net.ssl.HttpsURLConnection;
import me.ele.lancet.base.annotations.Skip;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes5.dex */
public final class aa {
    public static boolean a;
    public static boolean b;

    public aa() {
    }

    private static String a(InputStream r6) {
        ByteArrayOutputStream r1 = new ByteArrayOutputStream();     // Catch: Throwable -> L14 Exception -> L16
    L37:
        byte[] r2 = new byte[1024];     // Catch: Exception -> L12 Throwable -> L24
    L6:
        int r3 = r6.read(r2);     // Catch: Exception -> L12 Throwable -> L24
        if (r3 == (-1)) goto L9;
        r1.write(r2, 0, r3);     // Catch: Exception -> L12 Throwable -> L24
        goto L6
    L9:
        String r4 = new String(r1.toByteArray());     // Catch: Exception -> L12 Throwable -> L24
        r1.close();     // Catch: Exception -> L30
        r6.close();     // Catch: Exception -> L30
    L11:
        return r4;
    L12:
        e = e;
    L18:
        aj.a(e);     // Catch: Throwable -> L24
        if (r1 != null) goto L33;
    L21:
        if (r6 == null) goto L23;
        r6.close();     // Catch: Exception -> L31
    L23:
        return null;
    L33:
        r1.close();     // Catch: Exception -> L31
    L24:
        Throwable th = th;
    L25:
        if (r1 != null) goto L35;
    L27:
        if (r6 == null) goto L29;
        r6.close();     // Catch: Exception -> L32
    L29:
        throw th;
    L35:
        r1.close();     // Catch: Exception -> L32
    L16:
        e = e;
        r1 = null;
    L14:
        th = move-exception;
        r1 = null;
        th = th;
        goto L25
    }

    private static String a(String r2) {
        if (r2.contains(":") == true) goto L5;
        return r2;
    L5:
        return "[" + r2 + "]";
    }

    public static String a(String r5, String r6) {
        String r0 = "";
        OutputStream r1 = null;
        URL r2 = new URL(r5);     // Catch: Throwable -> L15 Exception -> L17
        HttpURLConnection r7 = (HttpURLConnection) INVOKEVIRTUAL_com_unicom_online_account_kernel_aa_com_obric_assistant_network_okhttp_UrlConnLancet_openConnection(r2);     // Catch: Throwable -> L15 Exception -> L17
        String r3 = r2.getProtocol();     // Catch: Throwable -> L15 Exception -> L17
        if (an.b(r3).booleanValue() == false) goto L6;
        "https".equals(r3.toLowerCase(Locale.getDefault()));     // Catch: Throwable -> L15 Exception -> L17
    L6:
        r7.setConnectTimeout(50000);     // Catch: Throwable -> L15 Exception -> L17
        r7.setReadTimeout(50000);     // Catch: Throwable -> L15 Exception -> L17
        r7.setDoOutput(true);     // Catch: Throwable -> L15 Exception -> L17
        r7.setDoInput(true);     // Catch: Throwable -> L15 Exception -> L17
        r7.setUseCaches(false);     // Catch: Throwable -> L15 Exception -> L17
        r7.setRequestMethod("POST");     // Catch: Throwable -> L15 Exception -> L17
        r7.setRequestProperty("user-agent", "Mozilla/5.0 (Linux; U; Android %s) AppleWebKit/533.1 (KHTML, like Gecko) Version/4.0 %sSafari/533.1");     // Catch: Throwable -> L15 Exception -> L17
        r7.setRequestProperty("Charset", EffectRequest.DEFAULT_PARAMS_ENCODING);     // Catch: Throwable -> L15 Exception -> L17
        r7.setRequestProperty("connection", "keep-alive");     // Catch: Throwable -> L15 Exception -> L17
        r7.setRequestProperty("api-protocol", "1.1");     // Catch: Throwable -> L15 Exception -> L17
        r7.connect();     // Catch: Throwable -> L15 Exception -> L17
        r1 = r7.getOutputStream();     // Catch: Throwable -> L15 Exception -> L17
        r1.write(r6.getBytes("utf-8"));     // Catch: Throwable -> L15 Exception -> L17
        r1.flush();     // Catch: Throwable -> L15 Exception -> L17
        r1.close();     // Catch: Throwable -> L15 Exception -> L17
        int r8 = r7.getResponseCode();     // Catch: Throwable -> L15 Exception -> L17
        if (r8 != 200) goto L9;
        InputStream r4 = r7.getInputStream();     // Catch: Throwable -> L15 Exception -> L17
        r0 = a(r4);     // Catch: Throwable -> L15 Exception -> L17
        r7.disconnect();     // Catch: Throwable -> L15 Exception -> L17
        r4.close();     // Catch: Throwable -> L15 Exception -> L17
    L9:
        aj.a("responseCode = " + r8 + "\nresult = " + r0);     // Catch: Throwable -> L15 Exception -> L17
        r1.close();     // Catch: IOException -> L12
    L14:
        return r0;
    L12:
        e = move-exception;
        aj.a(e);
        goto L14
    L17:
        e = move-exception;
        aj.a(e);     // Catch: Throwable -> L15
        if (r1 != null) goto L35;
    L24:
        return r0;
    L35:
        r1.close();     // Catch: IOException -> L22
    L22:
        e = move-exception;
        aj.a(e);
    L15:
        th = move-exception;
        if (r1 != null) goto L37;
    L30:
        throw th;
    L37:
        r1.close();     // Catch: IOException -> L28
    L28:
        e = move-exception;
        aj.a(e);
        goto L30
    }

    /* JADX WARN: Multi-variable type inference failed */
    private String b(Context r18, String r19, HashMap<String, String> r20, Object r21) {
        String r3 = r19;
        long r9 = System.currentTimeMillis();
        String r0 = new URL(r3).getHost();     // Catch: MalformedURLException -> L5
    L8:
        if (r0.contains(i.d()) == false) goto L18;
        if (b == false) goto L18;
        if (a == false) goto L18;
        if (TextUtils.isEmpty(ak.a) == true) goto L16;
        r3 = r3.replaceFirst(i.d(), a(ak.a));
    L16:
        b = false;
    L18:
        if (r3.contains("nisportal") == false) goto L20;
        e.a().a = 1;
    L20:
        aj.a("\n*********************\nrequestGetHttp() requestUrl - >" + r3.substring(0, 30) + "...\n ...\n \n*********************\n");
        URL r14 = new URL(r3);     // Catch: Throwable -> L63 Exception -> L65
        if (r21 == null) goto L25;
        URLConnection r15 = ((Network) r21).openConnection(r14);     // Catch: Throwable -> L63 Exception -> L65
    L24:
        HttpURLConnection r16 = (HttpURLConnection) r15;     // Catch: Throwable -> L63 Exception -> L65
        r16.setDoInput(true);     // Catch: Exception -> L61 Throwable -> L77
        r16.setDoOutput(false);     // Catch: Exception -> L61 Throwable -> L77
        r16.setUseCaches(false);     // Catch: Exception -> L61 Throwable -> L77
        r16.setInstanceFollowRedirects(false);     // Catch: Exception -> L61 Throwable -> L77
        r16.setReadTimeout(10000);     // Catch: Exception -> L61 Throwable -> L77
        r16.setConnectTimeout(10000);     // Catch: Exception -> L61 Throwable -> L77
        r16.setRequestMethod("GET");     // Catch: Exception -> L61 Throwable -> L77
        boolean r13 = ac.c();     // Catch: Exception -> L61 Throwable -> L77
        r16.setInstanceFollowRedirects(r13);     // Catch: Exception -> L61 Throwable -> L77
        HttpURLConnection.setFollowRedirects(r13);     // Catch: Exception -> L61 Throwable -> L77
        if (r20 == null) goto L33;
        Iterator<String> r17 = r20.keySet().iterator();     // Catch: Exception -> L61 Throwable -> L77
    L31:
        if (r17.hasNext() == false) goto L33;
        String r110 = r17.next();     // Catch: Exception -> L61 Throwable -> L77
        r16.setRequestProperty(r110, r20.get(r110));     // Catch: Exception -> L61 Throwable -> L77
    L33:
        r16.addRequestProperty("Connection", "close");     // Catch: Exception -> L61 Throwable -> L77
        aj.a("TAG\thttpsURLConnection.connect();\n");     // Catch: Exception -> L61 Throwable -> L77
        g r4 = new g();     // Catch: Exception -> L61 Throwable -> L77
        r4.a = r3.substring(0, r3.indexOf("?"));     // Catch: Exception -> L61 Throwable -> L77
        r4.b = System.currentTimeMillis();     // Catch: Exception -> L61 Throwable -> L77
        r16.connect();     // Catch: Exception -> L61 Throwable -> L77
        r4.c = System.currentTimeMillis();     // Catch: Exception -> L61 Throwable -> L77
        r4.d = 1;     // Catch: Exception -> L61 Throwable -> L77
        e.a().a(r4);     // Catch: Exception -> L61 Throwable -> L77
        aj.a("connect cost:" + (System.currentTimeMillis() - r9));     // Catch: Exception -> L61 Throwable -> L77
        long r10 = System.currentTimeMillis();     // Catch: Exception -> L61 Throwable -> L77
        int r5 = r16.getResponseCode();     // Catch: Exception -> L61 Throwable -> L77
        aj.a("\n*********************\nrequestGetHttp() statusCode - >" + r5 + "\n*********************\n");     // Catch: Exception -> L61 Throwable -> L77
        StringBuilder r11 = new StringBuilder("response cost:");     // Catch: Exception -> L61 Throwable -> L77
        r11.append(System.currentTimeMillis() - r10);     // Catch: Exception -> L61 Throwable -> L77
        aj.a(r11.toString());     // Catch: Exception -> L61 Throwable -> L77
        if (r5 != 200) goto L44;
        InputStream r1 = r16.getInputStream();     // Catch: Exception -> L61 Throwable -> L77
        String r2 = a(r1);     // Catch: Exception -> L61 Throwable -> L77
        r16.getInputStream().close();     // Catch: Exception -> L61 Throwable -> L77
        r16.disconnect();     // Catch: Exception -> L61 Throwable -> L77
        r1.close();     // Catch: Exception -> L61 Throwable -> L77
        if (TextUtils.isEmpty(r2) == false) goto L41;
        JSONObject r6 = new JSONObject();     // Catch: Exception -> L61 Throwable -> L77
        r6.put("code", 410012);     // Catch: Exception -> L61 Throwable -> L77
        r6.put("msg", "返回数据体为空");     // Catch: Exception -> L61 Throwable -> L77
        r6.put("data", "requestUrl:".concat(r3));     // Catch: Exception -> L61 Throwable -> L77
        String r7 = r6.toString();     // Catch: Exception -> L61 Throwable -> L77
        r16.disconnect();
        return r7;
    L41:
        r16.disconnect();
        return r2;
    L44:
        if (r5 != 302) goto L58;
        String r8 = r16.getHeaderField("Location");     // Catch: Exception -> L61 Throwable -> L77
        aj.a("redirectUrl is \n".concat(String.valueOf(r8)));     // Catch: Exception -> L61 Throwable -> L77
        aj.a("System.currentTimeMillis() is  \n" + System.currentTimeMillis());     // Catch: Exception -> L61 Throwable -> L77
        if (TextUtils.isEmpty(r8) == false) goto L48;
        JSONObject r12 = new JSONObject();     // Catch: Exception -> L61 Throwable -> L77
        r12.put("code", 410013);     // Catch: Exception -> L61 Throwable -> L77
        r12.put("msg", "无跳转地址");     // Catch: Exception -> L61 Throwable -> L77
        r12.put("data", r0);     // Catch: Exception -> L61 Throwable -> L77
        String r22 = r12.toString();     // Catch: Exception -> L61 Throwable -> L77
        r16.disconnect();
        return r22;
    L48:
        if (r8.startsWith("https") == false) goto L52;
        String r23 = a(r18, r8, null, r21);     // Catch: Exception -> L61 Throwable -> L77
        r16.disconnect();
        return r23;
    L52:
        aj.a("warning http redirectUrl \n" + System.currentTimeMillis());     // Catch: Exception -> L61 Throwable -> L77
        String r24 = b(r18, r8, null, r21);     // Catch: Exception -> L61 Throwable -> L77
        r16.disconnect();
        return r24;
    L58:
        JSONObject r25 = new JSONObject();     // Catch: Exception -> L61 Throwable -> L77
        r25.put("code", 410010);     // Catch: Exception -> L61 Throwable -> L77
        r25.put("msg", "Https状态码错误".concat(String.valueOf(r5)));     // Catch: Exception -> L61 Throwable -> L77
        r25.put("data", "requestUrl:".concat(r3));     // Catch: Exception -> L61 Throwable -> L77
        String r26 = r25.toString();     // Catch: Exception -> L61 Throwable -> L77
        r16.disconnect();
        return r26;
    L61:
        e = e;
    L67:
        aj.a(e);     // Catch: Throwable -> L77
        JSONObject r27 = new JSONObject();     // Catch: Exception -> L72 Throwable -> L77
        r27.put("code", 410024);     // Catch: Exception -> L72 Throwable -> L77
        r27.put("msg", "http异常" + e.getMessage());     // Catch: Exception -> L72 Throwable -> L77
        r27.put("data", "requestUrl->".concat(r3));     // Catch: Exception -> L72 Throwable -> L77
        String r28 = r27.toString();     // Catch: Exception -> L72 Throwable -> L77
        if (r16 == null) goto L71;
        r16.disconnect();
    L71:
        return r28;
    L73:
        if (r16 == null) goto L90;
        r16.disconnect();
        return null;
    L90:
        return null;
    L25:
        r15 = INVOKEVIRTUAL_com_unicom_online_account_kernel_aa_com_obric_assistant_network_okhttp_UrlConnLancet_openConnection(r14);     // Catch: Throwable -> L63 Exception -> L65
    L77:
        th = th;
        HttpsURLConnection r111 = "...\n ...\n \n*********************\n";
    L79:
        if (r111 == 0) goto L81;
        r111.disconnect();
    L81:
        throw th;
    L65:
        e = e;
        r16 = null;
    L63:
        th = th;
        r111 = 0;
    L5:
        e = move-exception;
        aj.a(e);
        r0 = r3;
        goto L8
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r11v1 */
    /* JADX WARN: Type inference failed for: r11v10 */
    /* JADX WARN: Type inference failed for: r11v11, types: [long] */
    /* JADX WARN: Type inference failed for: r11v2, types: [java.lang.Object] */
    /* JADX WARN: Type inference failed for: r11v3 */
    /* JADX WARN: Type inference failed for: r11v4 */
    /* JADX WARN: Type inference failed for: r11v5 */
    /* JADX WARN: Type inference failed for: r18v0, types: [java.lang.String] */
    /* JADX WARN: Type inference failed for: r1v0, types: [com.unicom.online.account.kernel.aa] */
    /* JADX WARN: Type inference failed for: r1v1, types: [com.unicom.online.account.kernel.aa] */
    /* JADX WARN: Type inference failed for: r1v10 */
    /* JADX WARN: Type inference failed for: r1v2 */
    /* JADX WARN: Type inference failed for: r1v27 */
    /* JADX WARN: Type inference failed for: r1v29, types: [java.lang.StringBuilder] */
    /* JADX WARN: Type inference failed for: r1v3 */
    /* JADX WARN: Type inference failed for: r1v32, types: [boolean] */
    /* JADX WARN: Type inference failed for: r1v42 */
    /* JADX WARN: Type inference failed for: r1v43 */
    /* JADX WARN: Type inference failed for: r1v5 */
    /* JADX WARN: Type inference failed for: r1v7 */
    /* JADX WARN: Type inference failed for: r1v8 */
    /* JADX WARN: Type inference failed for: r23v0, types: [com.unicom.online.account.kernel.aa] */
    /* JADX WARN: Type inference failed for: r26v0, types: [java.util.HashMap, java.util.HashMap<java.lang.String, java.lang.String>] */
    /* JADX WARN: Type inference failed for: r27v0, types: [java.lang.Object] */
    /* JADX WARN: Type inference failed for: r2v1 */
    /* JADX WARN: Type inference failed for: r2v10 */
    /* JADX WARN: Type inference failed for: r2v11 */
    /* JADX WARN: Type inference failed for: r2v12 */
    /* JADX WARN: Type inference failed for: r2v2, types: [java.util.HashMap] */
    /* JADX WARN: Type inference failed for: r2v24 */
    /* JADX WARN: Type inference failed for: r2v27, types: [java.lang.String] */
    /* JADX WARN: Type inference failed for: r4v1 */
    /* JADX WARN: Type inference failed for: r4v14 */
    /* JADX WARN: Type inference failed for: r4v15, types: [android.content.Context] */
    /* JADX WARN: Type inference failed for: r4v16 */
    /* JADX WARN: Type inference failed for: r4v2, types: [android.content.Context] */
    /* JADX WARN: Type inference failed for: r4v4 */
    /* JADX WARN: Type inference failed for: r4v5 */
    /* JADX WARN: Type inference failed for: r4v6 */
    /* JADX WARN: Type inference failed for: r4v7 */
    /* JADX WARN: Type inference failed for: r4v8 */
    /* JADX WARN: Type inference failed for: r9v23 */
    /* JADX WARN: Type inference failed for: r9v24 */
    /* JADX WARN: Type inference failed for: r9v26 */
    /* JADX WARN: Type inference failed for: r9v27 */
    /* JADX WARN: Type inference failed for: r9v31 */
    /* JADX WARN: Type inference failed for: r9v32 */
    /* JADX WARN: Type inference failed for: r9v39 */
    /* JADX WARN: Type inference failed for: r9v4 */
    /* JADX WARN: Type inference failed for: r9v5, types: [java.lang.String] */
    public final String a(Context r24, String r25, HashMap<String, String> r26, Object r27) {
        aa this = this;
        String r3 = r25;
        String r6 = "ret_url";
        System.currentTimeMillis();
        String r12 = i.g();
        String r0 = new URL(r3).getHost();     // Catch: MalformedURLException -> L5
    L7:
        String r13 = r0;
        if (r13.contains(i.d()) == false) goto L19;
        if (b == false) goto L19;
        if (a == false) goto L19;
        if (TextUtils.isEmpty(ak.a) == true) goto L16;
        String r1 = i.d();
        String r15 = a(ak.a);
        String r2 = r3.replaceFirst(r1, r15);
    L17:
        b = false;
        r3 = r2;
        goto L19
    L16:
        r2 = r3;
    L19:
        if (ac.b() == true) goto L233;
    L46:
        r15 = "DNS cache use error,clean domain = ";
        r6 = "data";
    L47:
        boolean r17 = false;
    L49:
        if (r3.contains("nisportal") == false) goto L51;
        e.a().a = 1;
    L51:
        StringBuilder r4 = new StringBuilder("\n*********************\nrequestGetHttps() requestUrl - >");
        ?? r18 = r15;
        r4.append(r3.substring(0, 30));
        r4.append("...\n*********************\n");
        aj.a(r4.toString());
        URL r5 = new URL(r3);     // Catch: Throwable -> L164 Exception -> L166
        if (r27 != 0) goto L239;
        HttpsURLConnection r7 = (HttpsURLConnection) INVOKEVIRTUAL_com_unicom_online_account_kernel_aa_com_obric_assistant_network_okhttp_UrlConnLancet_openConnection(r5);     // Catch: Throwable -> L164 Exception -> L166
    L60:
        HttpsURLConnection r16 = r7;
        r16.setDoInput(true);     // Catch: Exception -> L161 Throwable -> L164
        r16.setDoOutput(false);     // Catch: Exception -> L161 Throwable -> L164
        r16.setUseCaches(false);     // Catch: Exception -> L161 Throwable -> L164
        r16.setInstanceFollowRedirects(false);     // Catch: Exception -> L161 Throwable -> L164
        r16.setReadTimeout(10000);     // Catch: Exception -> L161 Throwable -> L164
        r16.setConnectTimeout(10000);     // Catch: Exception -> L161 Throwable -> L164
        r16.setRequestMethod("GET");     // Catch: Exception -> L161 Throwable -> L164
        r16.setHostnameVerifier(new a(this));     // Catch: Exception -> L161 Throwable -> L164
        boolean r8 = ac.c();     // Catch: Exception -> L161 Throwable -> L164
        r16.setInstanceFollowRedirects(r8);     // Catch: Exception -> L161 Throwable -> L164
        HttpURLConnection.setFollowRedirects(r8);     // Catch: Exception -> L161 Throwable -> L164
        if (r26 == 0) goto L67;
        Iterator r9 = r26.keySet().iterator();     // Catch: Exception -> L161 Throwable -> L164
    L65:
        if (r9.hasNext() == false) goto L67;
        String r10 = (String) r9.next();     // Catch: Exception -> L161 Throwable -> L164
        r16.setRequestProperty(r10, (String) r26.get(r10));     // Catch: Exception -> L161 Throwable -> L164
    L67:
        r16.addRequestProperty("Connection", "close");     // Catch: Exception -> L161 Throwable -> L164
        aj.a("TAG\thttpsURLConnection.connect();\n");     // Catch: Exception -> L161 Throwable -> L164
        g r11 = new g();     // Catch: Exception -> L161 Throwable -> L164
        r11.a = r3.substring(0, r3.indexOf("?"));     // Catch: Exception -> L161 Throwable -> L164
        String r14 = "msg";
        r11.b = System.currentTimeMillis();     // Catch: Exception -> L159 Throwable -> L164
        aj.a(3, r3.substring(0, 30));     // Catch: Exception -> L153 Throwable -> L155
        r16.connect();     // Catch: Exception -> L153 Throwable -> L155
        r11.c = System.currentTimeMillis();     // Catch: Exception -> L153 Throwable -> L155
        r11.d = 1;     // Catch: Exception -> L153 Throwable -> L155
        e.a().a(r11);     // Catch: Exception -> L153 Throwable -> L155
        StringBuilder r19 = new StringBuilder("connect url cost:");     // Catch: Exception -> L153 Throwable -> L155
        r19.append(r11.c - r11.b);     // Catch: Exception -> L149 Throwable -> L155
        aj.a(r19.toString());     // Catch: Exception -> L149 Throwable -> L155
        StringBuilder r20 = new StringBuilder("cost:");     // Catch: Exception -> L149 Throwable -> L155
        r20.append(r11.c - r11.b);     // Catch: Exception -> L146 Throwable -> L155
        r20.append("ms\n");     // Catch: Exception -> L146 Throwable -> L155
        aj.a(3, r20.toString());     // Catch: Exception -> L146 Throwable -> L155
        long r21 = System.currentTimeMillis();     // Catch: Exception -> L146 Throwable -> L155
        int r22 = r16.getResponseCode();     // Catch: Exception -> L146 Throwable -> L155
        aj.a("\n*********************\n requestGetHttps() statusCode - >" + r22 + "\n*********************\n");     // Catch: Exception -> L146 Throwable -> L155
        StringBuilder r23 = new StringBuilder("get response cost:");     // Catch: Exception -> L146 Throwable -> L155
        long r28 = System.currentTimeMillis() - r21;     // Catch: Exception -> L146 Throwable -> L155
        r23.append(r28);     // Catch: Exception -> L146 Throwable -> L155
        aj.a(r23.toString());     // Catch: Exception -> L146 Throwable -> L155
        String r29 = r16.getURL().toString();     // Catch: Exception -> L146 Throwable -> L155
        String r30 = "seq";
        if (r29.contains("ret_url") == false) goto L84;
        if (r12.equalsIgnoreCase("seqAndroidEmpty") == false) goto L84;
        r12 = Uri.parse(new String(Base64.decode(Uri.parse(r29).getQueryParameter("ret_url"), 0))).getQueryParameter("seq");     // Catch: Exception -> L146 Throwable -> L155
        aj.a("seq = " + r12 + "\nstatusCode = " + r22);     // Catch: Exception -> L146 Throwable -> L155
    L84:
        if (r22 == 200) goto L228;
        r6 = r6;
        String r31 = "code";
        if (r22 != 302) goto L111;
    L127:
        ?? r32 = r24;
        r18 = r18;
        String r33 = new String(r16.getHeaderField("Location"));     // Catch: Exception -> L144 Throwable -> L155
        StringBuilder r34 = new StringBuilder("statusCode == 302 301, redirectUrl is \n");     // Catch: Exception -> L144 Throwable -> L155
        r34.append(r33.substring(0, 30));     // Catch: Exception -> L142 Throwable -> L155
        r34.append("...");     // Catch: Exception -> L142 Throwable -> L155
        aj.a(r34.toString());     // Catch: Exception -> L142 Throwable -> L155
        r26 = "System.currentTimeMillis() is  \n";
        ?? r35 = new StringBuilder("System.currentTimeMillis() is  \n");     // Catch: Exception -> L142 Throwable -> L155
        r27 = System.currentTimeMillis();     // Catch: Exception -> L142 Throwable -> L155
        r35.append(r27);     // Catch: Exception -> L142 Throwable -> L155
        aj.a(r35.toString());     // Catch: Exception -> L142 Throwable -> L155
        r16.getInputStream().close();     // Catch: Exception -> L142 Throwable -> L155
        r16.disconnect();     // Catch: Exception -> L142 Throwable -> L155
        this = TextUtils.isEmpty(r33);     // Catch: Exception -> L142 Throwable -> L155
        if (this != 0) goto L138;
        if (r33.startsWith("https") == false) goto L137;
        return a(r32, r33, r26, r27);
    L137:
        return b(r32, r33, r26, r27);
    L138:
        JSONObject r36 = new JSONObject();     // Catch: Exception -> L140 Throwable -> L164
        r36.put(r31, 410013);     // Catch: Exception -> L140 Throwable -> L164
        r36.put(r14, "无跳转地址");     // Catch: Exception -> L140 Throwable -> L164
        r36.put(r6, r13);     // Catch: Exception -> L140 Throwable -> L164
        return r36.toString();
    L140:
        e = e;
    L254:
        if (ac.b() == false) goto L172;
        if (r17 == false) goto L172;
        ak.b(r32, r13);     // Catch: Throwable -> L164 Exception -> L209
        aj.a(r18 + r13 + "\n");     // Catch: Throwable -> L164 Exception -> L209
    L172:
        if (r16 == null) goto L174;
        r16.getInputStream().close();     // Catch: Throwable -> L164 Exception -> L209
        r16.disconnect();     // Catch: Throwable -> L164 Exception -> L209
    L174:
        int r37 = al.e();     // Catch: Throwable -> L164
        aj.a("\n*********************\niRetry = >" + r37 + " \n   e-->" + e + "\n*********************\n");     // Catch: Throwable -> L164
        aj.a(e);     // Catch: Throwable -> L164
        String r38 = e.getMessage();     // Catch: Throwable -> L164
        if (r38 != null) goto L177;
    L252:
        aj.a("catch (Exception e) is  ".concat(String.valueOf(e)));     // Catch: Throwable -> L164 Exception -> L206
        JSONObject r39 = new JSONObject();     // Catch: Throwable -> L164 Exception -> L206
        r39.put(r31, 410011);     // Catch: Throwable -> L164 Exception -> L206
        r39.put(r14, "https异常: ".concat(String.valueOf(r38)));     // Catch: Throwable -> L164 Exception -> L206
        r39.put(r6, "requestUrl->".concat(r3));     // Catch: Throwable -> L164 Exception -> L206
        return r39.toString();
    L206:
        return null;
    L177:
        if (r37 >= al.d()) goto L252;
        int r40 = al.f();     // Catch: Throwable -> L164
        if (r38.contains("resolve host") == false) goto L199;
        if (r13.contains(i.d()) == false) goto L184;
    L187:
        boolean r110 = true;
    L188:
        if (r110 == false) goto L199;
        aj.a("resolve host error: retry->" + r40 + " times \ne_getMessage=" + r38);     // Catch: Throwable -> L164
        if (b == false) goto L197;
        if (a == false) goto L197;
        if (TextUtils.isEmpty(ak.a) == true) goto L197;
        r3 = r3.replaceFirst(i.d(), a(ak.a));     // Catch: Throwable -> L164
    L197:
        return this.a(r32, r3, r26, r27);
    L184:
        if (r13.contains(i.e()) == true) goto L187;
        r110 = false;
    L199:
        if (r38.contains("Failed to connect") == false) goto L202;
        aj.a("Failed to connect error: retry->" + r40 + " times \ne_getMessage=" + r38);     // Catch: Throwable -> L164
        return this.a(r32, r3, r26, r27);
    L202:
        aj.a("other  error: retry->" + r40 + " times \ne_getMessage=" + r38);     // Catch: Throwable -> L164
        return this.a(r32, r3, r26, r27);
    L142:
        e = e;
        this = this;
        r26 = r26;
        r27 = r27;
        goto L254
    L111:
        if (r22 == 301) goto L127;
        if (ac.b() == false) goto L121;
        if (r17 == false) goto L121;
        ak.b(r24, r13);     // Catch: Exception -> L211 Throwable -> L155
        aj.a(r18 + r13 + "\n");     // Catch: Exception -> L210 Throwable -> L155
    L121:
        r16.getInputStream().close();     // Catch: Exception -> L210 Throwable -> L155
        r16.disconnect();     // Catch: Exception -> L210 Throwable -> L155
    L125:
        JSONObject r41 = new JSONObject();     // Catch: Exception -> L144 Throwable -> L155
        r41.put(r31, 410010);     // Catch: Exception -> L144 Throwable -> L155
        r41.put(r14, "Https状态码错误".concat(String.valueOf(r22)));     // Catch: Exception -> L144 Throwable -> L155
        r41.put(r6, "requestUrl:".concat(r3));     // Catch: Exception -> L144 Throwable -> L155
        return r41.toString();
    L144:
        e = e;
        r32 = r30;
        r18 = r28;
        goto L254
    L228:
        InputStream r42 = r16.getInputStream();     // Catch: Exception -> L105 Throwable -> L155
        r31 = a(r42);     // Catch: Exception -> L105 Throwable -> L155
        String r43 = new String(r31);     // Catch: Exception -> L105 Throwable -> L155
        r16.disconnect();     // Catch: Exception -> L105 Throwable -> L155
        r42.close();     // Catch: Exception -> L105 Throwable -> L155
        if (an.a(r12).booleanValue() == false) goto L230;
        r12 = i.g();     // Catch: Exception -> L146 Throwable -> L155
    L230:
        if (TextUtils.isEmpty(r43) == false) goto L98;
        JSONObject r44 = new JSONObject();     // Catch: Exception -> L105 Throwable -> L155
        r31 = "code";
        r44.put(r31, 410012);     // Catch: Exception -> L96 Throwable -> L155
        r44.put(r14, "返回数据体为空");     // Catch: Exception -> L96 Throwable -> L155
        r44.put("seq", r12);     // Catch: Exception -> L96 Throwable -> L155
        r44.put(r6, "requestUrl:".concat(r3));     // Catch: Exception -> L103 Throwable -> L155
        return r44.toString();
    L96:
        e = e;
        r6 = r6;
    L107:
        r32 = r24;
        r18 = r18;
        goto L254
    L98:
        JSONObject r45 = new JSONObject(r43);     // Catch: Exception -> L103 Throwable -> L155
        if (TextUtils.isEmpty(r45.optString("seq")) == false) goto L102;
        r45.put("seq", r12);     // Catch: Exception -> L103 Throwable -> L155
    L102:
        return r45.toString();
    L103:
        e = e;
    L105:
        e = e;
        r6 = r6;
        r31 = "code";
    L146:
        e = e;
        r32 = r24;
        r6 = r6;
        r18 = r18;
        r31 = "code";
    L149:
        e = e;
        this = this;
        r26 = r26;
        r27 = r27;
        r6 = r6;
        r18 = r18;
        r31 = "code";
        r32 = r24;
    L151:
        e = e;
        this = this;
        r26 = r26;
        r6 = r6;
        r18 = r18;
        r32 = r24;
        r27 = r27;
        r31 = "code";
    L153:
        e = e;
        this = this;
    L163:
        this = this;
    L58:
        r32 = r24;
        r26 = r26;
        r27 = r27;
        r31 = "code";
    L157:
        e = e;
        this = this;
    L155:
        th = move-exception;
        throw th;
    L159:
        e = e;
    L161:
        e = e;
        r14 = "msg";
        goto L163
    L239:
        r7 = (HttpsURLConnection) ((Network) r27).openConnection(r5);     // Catch: Exception -> L56 Throwable -> L164
    L56:
        e = e;
        r14 = "msg";
        r16 = null;
        this = this;
    L164:
        th = move-exception;
        throw th;
    L166:
        e = e;
        r14 = "msg";
        r6 = r6;
        r18 = r18;
        r32 = r24;
        r26 = r26;
        r27 = r27;
        r31 = "code";
        r16 = null;
        goto L254
    L233:
        d r46 = ak.i(r13);     // Catch: Exception -> L42
        if (r46 != null) goto L23;
        r15 = "DNS cache use error,clean domain = ";
        r6 = "data";
        ak.a(r24, r13);     // Catch: Exception -> L40
        String r47 = "DNS cache add domain = " + r13 + "\n";     // Catch: Exception -> L40
    L37:
        aj.a(r47);     // Catch: Exception -> L40
        goto L47
    L23:
        if (ak.a(r13) == false) goto L46;
        String r111 = r46.b;     // Catch: Exception -> L42
        if (r111 == null) goto L46;
        if (r111.length() <= 0) goto L46;
        r15 = "DNS cache use error,clean domain = ";
        r6 = "data";
        if (r46.c <= System.currentTimeMillis()) goto L36;
        r3 = r3.replaceFirst(r13, a(r46.b));     // Catch: Exception -> L40
        ak.p.add(r46.b);     // Catch: Exception -> L40
        aj.a("DNS cache use domain = " + r13 + "\n");     // Catch: Exception -> L34
        r17 = true;
    L34:
        e = move-exception;
        Exception r48 = e;
        boolean r49 = true;
    L45:
        r17 = r49;
        aj.a("DNS cache catch error = " + r48.getMessage() + "\n");
        goto L49
    L36:
        ak.b(r24, r13);     // Catch: Exception -> L40
        r47 = "DNS cache expire,clean domain = " + r13 + "\n";     // Catch: Exception -> L40
    L40:
        e = e;
    L44:
        r48 = e;
        r49 = false;
    L42:
        e = e;
        r15 = "DNS cache use error,clean domain = ";
        r6 = "data";
    L5:
        e = move-exception;
        aj.a(e);
        r0 = "";
        goto L7
    }

    @Skip({"com.obric.assistant.network.okhttp"})
    public static URLConnection INVOKEVIRTUAL_com_unicom_online_account_kernel_aa_com_obric_assistant_network_okhttp_UrlConnLancet_openConnection(URL r7) throws IOException {
        String r3 = r7.getHost();     // Catch: Throwable -> L8 IOException -> L12
        String r4 = r7.getPath();     // Catch: Throwable -> L8 IOException -> L12
        if (com.obric.assistant.network.okhttp.a.c(r3, r4) == false) goto L11;
        FLogger.a.i("UrlConnLancet", "openConnection drop host=" + r3 + " path=" + r4);     // Catch: Throwable -> L8 IOException -> L12
        com.obric.assistant.network.okhttp.a.b(com.obric.assistant.network.okhttp.a.a(r3, r4), r3, r4);     // Catch: Throwable -> L8 IOException -> L12
        throw new IOException("[NetGuard] dropped " + r7);     // Catch: Throwable -> L8 IOException -> L12
    L11:
        return r7.openConnection();
    L12:
        e = move-exception;
        throw e;
    L8:
        th = move-exception;
        FLogger.a.e("UrlConnLancet", "openConnection intercept failed, fallback to origin: " + th.getMessage());
        goto L11
    }
}
