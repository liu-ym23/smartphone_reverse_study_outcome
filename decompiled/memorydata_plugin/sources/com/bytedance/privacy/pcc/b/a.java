package com.bytedance.privacy.pcc.b;

import com.bytedance.apm6.util.constant.NetConst;
import com.bytedance.privacy.c.b;
import com.bytedance.privacy.e.c;
import com.bytedance.privacy.pcc.b.a.e;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.io.IOException;
import java.net.ConnectException;
import java.net.SocketTimeoutException;
import java.util.Iterator;
import java.util.Map;
import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

/* JADX INFO: loaded from: classes2.dex */
public class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final String f3049a = "a";

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final OkHttpClient f3050b = null;
    private static volatile a c;

    static {
        f3050b = new OkHttpClient();
    }

    private a() {
    }

    public static a a() {
        if (c != null) goto L15;
        monitor-enter(a.class);
    L11:
        th = move-exception;
        throw th;
    L7:
        if (c != null) goto L9;
        c = new a();     // Catch: Throwable -> L11
    L9:
        monitor-exit(a.class);     // Catch: Throwable -> L11
    L15:
        return c;
    }

    private static Request.Builder a(Request.Builder r1) {
        b.a().b();
        return r1;
    }

    private static String b() {
        if (b.a().b() == false) goto L5;
        return "https://opcc-gateway-boe.bytedance.net";
    L5:
        return "https://opcc-gateway.obriccloud.com";
    }

    public com.bytedance.privacy.pcc.b.a.a a(String r6, Map<String, String> r7) {
        Map r8 = (Map) ZeusTransformUtils.wrapperContextForParams(r7, Map.class, "com.obric.memorydata.plugin");
        String r0 = b() + "/opcc/v2/auth/get/challenge";
        Request.Builder r9 = a(new Request.Builder().url(r0).get().addHeader("x-requestId", r6).addHeader("x-timestamp", String.valueOf(System.currentTimeMillis())));
        if (r8 == null) goto L8;
        Iterator r10 = r8.entrySet().iterator();
    L6:
        if (r10.hasNext() == false) goto L8;
        Map.Entry r2 = (Map.Entry) ZeusTransformUtils.preCheckCast(r10.next(), Map.Entry.class, "com.obric.memorydata.plugin");
        r9.addHeader((String) ZeusTransformUtils.preCheckCast(r2.getKey(), String.class, "com.obric.memorydata.plugin"), (String) ZeusTransformUtils.preCheckCast(r2.getValue(), String.class, "com.obric.memorydata.plugin"));
    L8:
        Request r11 = r9.build();
        c.a(f3049a, "PCC GetChallenge request: " + r0);
        int r12 = 1;
    L10:
        if (r12 > 3) goto L54;
        Response r1 = f3050b.newCall(r11).execute();     // Catch: Exception -> L41 IOException -> L43 ConnectException -> L45 SocketTimeoutException -> L47
        if (r1.body() == null) goto L15;
        String r3 = r1.body().string();     // Catch: Throwable -> L34
    L17:
        if (r1.isSuccessful() == false) goto L29;
        com.bytedance.privacy.pcc.b.a.a r4 = com.bytedance.privacy.pcc.b.a.a.a(r3);     // Catch: Throwable -> L34
        if (r4 != null) goto L21;
    L27:
        String r5 = f3049a;     // Catch: Throwable -> L34
        String r13 = "PCC GetChallenge attempt " + r12 + ": nonce empty in response";     // Catch: Throwable -> L34
    L28:
        c.d(r5, r13);     // Catch: Throwable -> L34
        if (r1 == null) goto L50;
        r1.close();     // Catch: Exception -> L41 IOException -> L43 ConnectException -> L45 SocketTimeoutException -> L47
    L50:
        if (r12 >= 3) goto L53;
        Thread.sleep(500);     // Catch: InterruptedException -> L56
    L53:
        r12 = r12 + 1;
        goto L10
    L21:
        if (r4.a() == null) goto L27;
        if (r4.a().isEmpty() == true) goto L27;
        if (r1 == null) goto L26;
        r1.close();     // Catch: Exception -> L41 IOException -> L43 ConnectException -> L45 SocketTimeoutException -> L47
    L26:
        return r4;
    L29:
        r5 = f3049a;     // Catch: Throwable -> L34
        r13 = "PCC GetChallenge attempt " + r12 + ": HTTP " + r1.code();     // Catch: Throwable -> L34
        goto L28
    L15:
        r3 = "";
    L34:
        th = move-exception;
        if (r1 != null) goto L61;
    L40:
        throw th;     // Catch: Exception -> L41 IOException -> L43 ConnectException -> L45 SocketTimeoutException -> L47
    L61:
        r1.close();     // Catch: Throwable -> L38
    L38:
        th = move-exception;
        th.addSuppressed(th);     // Catch: Exception -> L41 IOException -> L43 ConnectException -> L45 SocketTimeoutException -> L47
    L45:
        e = move-exception;
        String r14 = f3049a;
        StringBuilder r15 = new StringBuilder().append("PCC GetChallenge attempt ").append(r12).append(": ConnectException: ");
        String r16 = e.getMessage();
    L49:
        c.d(r14, r15.append(r16).toString());
    L47:
        e = move-exception;
        r14 = f3049a;
        r15 = new StringBuilder().append("PCC GetChallenge attempt ").append(r12).append(": SocketTimeoutException: ");
        r16 = e.getMessage();
    L43:
        e = move-exception;
        r14 = f3049a;
        r15 = new StringBuilder().append("PCC GetChallenge attempt ").append(r12).append(": IOException: ");
        r16 = e.getMessage();
    L41:
        e = move-exception;
        c.a(f3049a, "PCC GetChallenge attempt " + r12 + ": unexpected exception: ", e);
        goto L50
    L54:
        return null;
    }

    public com.bytedance.privacy.pcc.b.a.c a(String r5, String r6, String r7, Map<String, String> r8) {
        Map r9 = (Map) ZeusTransformUtils.wrapperContextForParams(r8, Map.class, "com.obric.memorydata.plugin");
        String r0 = b() + "/opcc/v2/auth/create/channel";
        Request.Builder r10 = a(new Request.Builder().url(r0).post(RequestBody.create(MediaType.parse("application/json; charset=utf-8"), r7)).addHeader(NetConst.KEY_CONTENT_TYPE, "application/json").addHeader("x-requestId", r5).addHeader("x-timestamp", r6));
        if (r9 == null) goto L8;
        Iterator r11 = r9.entrySet().iterator();
    L6:
        if (r11.hasNext() == false) goto L8;
        Map.Entry r12 = (Map.Entry) ZeusTransformUtils.preCheckCast(r11.next(), Map.Entry.class, "com.obric.memorydata.plugin");
        r10.addHeader((String) ZeusTransformUtils.preCheckCast(r12.getKey(), String.class, "com.obric.memorydata.plugin"), (String) ZeusTransformUtils.preCheckCast(r12.getValue(), String.class, "com.obric.memorydata.plugin"));
    L8:
        Request r13 = r10.build();
        c.a(f3049a, "PCC CreateChannel request: " + r0);
        int r14 = 1;
    L10:
        if (r14 > 3) goto L47;
        Response r15 = f3050b.newCall(r13).execute();     // Catch: Exception -> L34 IOException -> L36 ConnectException -> L38 SocketTimeoutException -> L40
    L27:
        th = move-exception;
        if (r15 != null) goto L54;
    L33:
        throw th;     // Catch: Exception -> L34 IOException -> L36 ConnectException -> L38 SocketTimeoutException -> L40
    L54:
        r15.close();     // Catch: Throwable -> L31
    L31:
        th = move-exception;
        th.addSuppressed(th);     // Catch: Exception -> L34 IOException -> L36 ConnectException -> L38 SocketTimeoutException -> L40
        goto L33
    L14:
        if (r15.body() == null) goto L16;
        String r1 = r15.body().string();     // Catch: Throwable -> L27
    L17:
        String r2 = r15.header("x-responseId", "");     // Catch: Throwable -> L27
        if (r15.isSuccessful() == true) goto L19;
        c.d(f3049a, "PCC CreateChannel attempt " + r14 + ": HTTP " + r15.code());     // Catch: Throwable -> L27
        if (r15 == null) goto L43;
        r15.close();     // Catch: Exception -> L34 IOException -> L36 ConnectException -> L38 SocketTimeoutException -> L40
    L43:
        if (r14 >= 3) goto L46;
        Thread.sleep(500);     // Catch: InterruptedException -> L49
    L46:
        r14 = r14 + 1;
        goto L10
    L19:
        com.bytedance.privacy.pcc.b.a.c r3 = com.bytedance.privacy.pcc.b.a.c.a(r1, r2);     // Catch: Throwable -> L27
        if (r15 == null) goto L22;
        r15.close();     // Catch: Exception -> L34 IOException -> L36 ConnectException -> L38 SocketTimeoutException -> L40
    L22:
        return r3;
    L16:
        r1 = "";
    L38:
        e = move-exception;
        String r4 = f3049a;
        StringBuilder r16 = new StringBuilder().append("PCC CreateChannel attempt ").append(r14).append(": ConnectException: ");
        String r17 = e.getMessage();
    L42:
        c.d(r4, r16.append(r17).toString());
    L40:
        e = move-exception;
        r4 = f3049a;
        r16 = new StringBuilder().append("PCC CreateChannel attempt ").append(r14).append(": SocketTimeoutException: ");
        r17 = e.getMessage();
    L36:
        e = move-exception;
        r4 = f3049a;
        r16 = new StringBuilder().append("PCC CreateChannel attempt ").append(r14).append(": IOException: ");
        r17 = e.getMessage();
    L34:
        e = move-exception;
        c.a(f3049a, "PCC CreateChannel attempt " + r14 + ": unexpected exception: ", e);
        goto L43
    L47:
        return null;
    }

    public String a(String r5, String r6, String r7) {
        String r0 = b() + "/opcc/v2/auth/upload/channelRet";
        Request r8 = a(new Request.Builder().url(r0).post(RequestBody.create(MediaType.parse("application/json; charset=utf-8"), r7)).addHeader(NetConst.KEY_CONTENT_TYPE, "application/json").addHeader("x-requestId", r5).addHeader("x-timestamp", r6)).build();
        c.a(f3049a, "PCC UploadChannelRet request: " + r0);
        int r9 = 1;
    L3:
        String r10 = "";
        if (r9 > 3) goto L39;
        Response r1 = f3050b.newCall(r8).execute();     // Catch: Exception -> L26 IOException -> L28 ConnectException -> L30 SocketTimeoutException -> L32
    L19:
        th = move-exception;
        if (r1 != null) goto L43;
    L25:
        throw th;     // Catch: Exception -> L26 IOException -> L28 ConnectException -> L30 SocketTimeoutException -> L32
    L43:
        r1.close();     // Catch: Throwable -> L23
    L23:
        th = move-exception;
        th.addSuppressed(th);     // Catch: Exception -> L26 IOException -> L28 ConnectException -> L30 SocketTimeoutException -> L32
        goto L25
    L7:
        if (r1.body() == null) goto L10;
        r10 = r1.body().string();     // Catch: Throwable -> L19
    L10:
        if (r1.isSuccessful() == true) goto L11;
        c.d(f3049a, "PCC UploadChannelRet attempt " + r9 + ": HTTP " + r1.code());     // Catch: Throwable -> L19
        if (r1 == null) goto L35;
        r1.close();     // Catch: Exception -> L26 IOException -> L28 ConnectException -> L30 SocketTimeoutException -> L32
    L35:
        if (r9 >= 3) goto L38;
        Thread.sleep(500);     // Catch: InterruptedException -> L40
    L38:
        r9 = r9 + 1;
        goto L3
    L11:
        String r11 = e.a(r10).a();     // Catch: Throwable -> L19
        if (r1 == null) goto L14;
        r1.close();     // Catch: Exception -> L26 IOException -> L28 ConnectException -> L30 SocketTimeoutException -> L32
    L14:
        return r11;
    L30:
        e = move-exception;
        String r2 = f3049a;
        StringBuilder r3 = new StringBuilder().append("PCC UploadChannelRet attempt ").append(r9).append(": ConnectException: ");
        String r12 = e.getMessage();
    L34:
        c.d(r2, r3.append(r12).toString());
    L32:
        e = move-exception;
        r2 = f3049a;
        r3 = new StringBuilder().append("PCC UploadChannelRet attempt ").append(r9).append(": SocketTimeoutException: ");
        r12 = e.getMessage();
    L28:
        e = move-exception;
        r2 = f3049a;
        r3 = new StringBuilder().append("PCC UploadChannelRet attempt ").append(r9).append(": IOException: ");
        r12 = e.getMessage();
    L26:
        e = move-exception;
        c.a(f3049a, "PCC UploadChannelRet attempt " + r9 + ": unexpected exception: ", e);
        goto L35
    L39:
        return "";
    }
}
