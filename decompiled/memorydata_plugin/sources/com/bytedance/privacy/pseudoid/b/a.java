package com.bytedance.privacy.pseudoid.b;

import androidx.core.app.NotificationCompat;
import com.bytedance.apm6.util.constant.NetConst;
import com.bytedance.privacy.pseudoid.PseudoManager;
import java.io.IOException;
import java.net.ConnectException;
import java.net.SocketTimeoutException;
import okhttp3.Headers;
import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final String f3081a = "a";

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static String f3082b = "https://ocean-secret-boe.bytedance.net/api/identity/pseudonymize";
    private static String c = "https://ocean-secret.oceancloudapi.com/api/identity/pseudonymize";
    private static final OkHttpClient d = null;
    private static volatile a e;

    static {
        d = new OkHttpClient();
    }

    public a() {
    }

    private int a(String r3) {
        return new JSONObject(r3).getInt("code");
    L4:
        e = move-exception;
        com.bytedance.privacy.e.c.d(f3081a, "getResponseCode exception: " + e.getMessage());
        return 400;
    }

    public static a a() {
        if (e != null) goto L15;
        monitor-enter(PseudoManager.class);
    L11:
        th = move-exception;
        throw th;
    L7:
        if (e != null) goto L9;
        e = new a();     // Catch: Throwable -> L11
    L9:
        monitor-exit(PseudoManager.class);     // Catch: Throwable -> L11
    L15:
        return e;
    }

    public static String b() {
        if (com.bytedance.privacy.c.b.a().b() == false) goto L7;
        return f3082b;
    L7:
        return c;
    }

    private String b(String r3) {
        return new JSONObject(r3).getString(NotificationCompat.CATEGORY_MESSAGE);
    L4:
        e = move-exception;
        com.bytedance.privacy.e.c.d(f3081a, "getResponseMsg exception: " + e.getMessage());
        return "";
    }

    private Request b(b r5) {
        RequestBody r0 = RequestBody.create(MediaType.parse("application/json"), "{}");
        Headers r1 = Headers.of(com.bytedance.privacy.pseudoid.a.a.f3079a.c());
        return new Request.Builder().url(r5.b()).method(r5.a(), r0).headers(r1).addHeader(NetConst.KEY_CONTENT_TYPE, "application/json").addHeader("x-att-certchain", r5.c()).build();
    }

    private d c(String r3) {
        JSONObject r0 = new JSONObject(new JSONObject(r3).getString("data"));     // Catch: Exception -> L5
        return new d(r0.optString("rpdid", ""), r0.optString("rpuid", ""));
    L5:
        e = move-exception;
        com.bytedance.privacy.e.c.d(f3081a, "getPseudoID exception: " + e.getMessage());
        return null;
    }

    private c d(String r6) {
        int r0 = a(r6);
        String r1 = b(r6);
        d r3 = null;
        if (r0 < 200) goto L11;
        if (r0 >= 300) goto L11;
        r3 = c(r6);     // Catch: Exception -> L8
    L8:
        e = move-exception;
        com.bytedance.privacy.e.c.d(f3081a, "buildNetworkResponse exception: " + e.getMessage());
    L11:
        return new c(r0, r1, r3);
    }

    public c a(b r11) {
        com.bytedance.privacy.e.c.a(f3081a, "executeRequest enter");
        Request r12 = b(r11);
        c r1 = new c(400, "", null);
        int r2 = 1;
    L4:
        if (r2 > 3) goto L49;
        Response r6 = d.newCall(r12).execute();     // Catch: Exception -> L36 IOException -> L38 ConnectException -> L40 SocketTimeoutException -> L42
    L29:
        th = move-exception;
        if (r6 != null) goto L55;
    L35:
        throw th;     // Catch: Exception -> L36 IOException -> L38 ConnectException -> L40 SocketTimeoutException -> L42
    L55:
        r6.close();     // Catch: Throwable -> L33
    L33:
        th = move-exception;
        th.addSuppressed(th);     // Catch: Exception -> L36 IOException -> L38 ConnectException -> L40 SocketTimeoutException -> L42
        goto L35
    L7:
        if (r6.body() == null) goto L9;
        String r7 = r6.body().string();     // Catch: Throwable -> L29
    L11:
        if (r6.isSuccessful() == true) goto L12;
        com.bytedance.privacy.e.c.d(f3081a, "PseudoID Attempt " + r2 + ": Response failed, code = " + r6.code());     // Catch: Throwable -> L29
        c r8 = new c(r6.code(), r6.message(), null);     // Catch: Throwable -> L29
        if (r6 != null) goto L57;
    L28:
        r1 = r8;
    L45:
        if (r2 >= 3) goto L48;
        Thread.sleep(500);     // Catch: InterruptedException -> L50
    L48:
        r2 = r2 + 1;
        goto L4
    L57:
        r6.close();     // Catch: Exception -> L20 IOException -> L22 ConnectException -> L24 SocketTimeoutException -> L26
    L24:
        e = e;
        r1 = r8;
    L41:
        String r9 = f3081a;
        StringBuilder r10 = new StringBuilder().append("Challenge Attempt ").append(r2).append(": ConnectException (connect timeout): ");
        String r13 = e.getMessage();
    L44:
        com.bytedance.privacy.e.c.d(r9, r10.append(r13).toString());
    L26:
        e = e;
        r1 = r8;
    L43:
        r9 = f3081a;
        r10 = new StringBuilder().append("Challenge Attempt ").append(r2).append(": SocketTimeoutException (read/write timeout): ");
        r13 = e.getMessage();
    L22:
        e = e;
        r1 = r8;
    L39:
        r9 = f3081a;
        r10 = new StringBuilder().append("Challenge Attempt ").append(r2).append(": IOException: ");
        r13 = e.getMessage();
    L20:
        e = e;
        r1 = r8;
    L37:
        r9 = f3081a;
        r10 = new StringBuilder().append("Challenge Attempt ").append(r2).append(": Unexpected exception: ");
        r13 = e.getMessage();
        goto L44
    L12:
        com.bytedance.privacy.e.c.a(f3081a, "PseudoID Response received successfully");     // Catch: Throwable -> L29
        r1 = d(r7);     // Catch: Throwable -> L29
        if (r6 == null) goto L49;
        r6.close();     // Catch: Exception -> L36 IOException -> L38 ConnectException -> L40 SocketTimeoutException -> L42
        goto L49
    L9:
        r7 = "";
    L40:
        e = e;
    L42:
        e = e;
    L38:
        e = e;
    L36:
        e = e;
    L49:
        return r1;
    }
}
