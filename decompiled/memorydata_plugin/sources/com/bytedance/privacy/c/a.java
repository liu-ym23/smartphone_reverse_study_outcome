package com.bytedance.privacy.c;

import com.bytedance.privacy.e.c;
import java.io.IOException;
import java.net.ConnectException;
import java.net.SocketTimeoutException;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final String f3004a = "a";

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final OkHttpClient f3005b = null;

    static {
        f3005b = new OkHttpClient();
    }

    public a() {
    }

    private static int a(String r3) {
        return new JSONObject(r3).getInt("code");
    L4:
        e = move-exception;
        c.d(f3004a, "getResponseCode exception: " + e.getMessage());
        return 400;
    }

    public static String a() {
        return c();
    }

    private static String b() {
        if (b.a().b() == false) goto L6;
        return "https://ocean-secret-boe.bytedance.net/api/auth/challenge";
    L6:
        return "https://ocean-secret.oceancloudapi.com/api/auth/challenge";
    }

    private static String b(String r3) {
        return new JSONObject(new JSONObject(r3).getString("data")).getString("nonce");
    L4:
        e = move-exception;
        c.d(f3004a, "getChallenge exception: " + e.getMessage());
        return "";
    }

    private static String c() {
        Request r1 = new Request.Builder().url(b()).get().build();
        int r2 = 1;
        String r4 = "";
    L4:
        if (r2 > 3) goto L40;
        Response r6 = f3005b.newCall(r1).execute();     // Catch: Exception -> L27 IOException -> L29 ConnectException -> L31 SocketTimeoutException -> L33
    L20:
        th = move-exception;
        if (r6 != null) goto L42;
    L26:
        throw th;     // Catch: Exception -> L27 IOException -> L29 ConnectException -> L31 SocketTimeoutException -> L33
    L42:
        r6.close();     // Catch: Throwable -> L24
    L24:
        th = move-exception;
        th.addSuppressed(th);     // Catch: Exception -> L27 IOException -> L29 ConnectException -> L31 SocketTimeoutException -> L33
        goto L26
    L7:
        if (r6.body() == null) goto L9;
        String r7 = r6.body().string();     // Catch: Throwable -> L20
    L11:
        if (r6.isSuccessful() == true) goto L12;
        c.d(f3004a, "Challenge Attempt " + r2 + ": Response failed, code = " + r6.code());     // Catch: Throwable -> L20
        if (r6 == null) goto L36;
        r6.close();     // Catch: Exception -> L27 IOException -> L29 ConnectException -> L31 SocketTimeoutException -> L33
    L36:
        if (r2 >= 3) goto L39;
        Thread.sleep(500);     // Catch: InterruptedException -> L41
    L39:
        r2 = r2 + 1;
        goto L4
    L12:
        c.a(f3004a, "Challenge Response received successfully");     // Catch: Throwable -> L20
        r4 = c(r7);     // Catch: Throwable -> L20
        if (r6 == null) goto L40;
        r6.close();     // Catch: Exception -> L27 IOException -> L29 ConnectException -> L31 SocketTimeoutException -> L33
        goto L40
    L9:
        r7 = "";
    L31:
        e = move-exception;
        String r8 = f3004a;
        StringBuilder r9 = new StringBuilder().append("Challenge Attempt ").append(r2).append(": ConnectException (connect timeout): ");
        String r10 = e.getMessage();
    L35:
        c.d(r8, r9.append(r10).toString());
    L33:
        e = move-exception;
        r8 = f3004a;
        r9 = new StringBuilder().append("Challenge Attempt ").append(r2).append(": SocketTimeoutException (read/write timeout): ");
        r10 = e.getMessage();
    L29:
        e = move-exception;
        r8 = f3004a;
        r9 = new StringBuilder().append("Challenge Attempt ").append(r2).append(": IOException: ");
        r10 = e.getMessage();
    L27:
        e = move-exception;
        c.a(f3004a, "Challenge Attempt " + r2 + ": Unexpected exception: ", e);
    L40:
        return r4;
    }

    private static String c(String r4) {
        int r0 = a(r4);
        if (r0 >= 200) goto L5;
        return "";
    L5:
        if (r0 >= 300) goto L14;
        return b(r4);
    L8:
        e = move-exception;
        c.d(f3004a, "parseChallenge exception: " + e.getMessage());
        return "";
    L14:
        return "";
    }
}
