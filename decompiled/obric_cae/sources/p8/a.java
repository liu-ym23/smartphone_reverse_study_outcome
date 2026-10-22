package p8;

import android.util.Log;
import com.bytedance.retrofit2.HttpMethodContrants;
import java.io.IOException;
import java.net.ConnectException;
import java.net.SocketTimeoutException;
import java.util.Objects;
import org.json.JSONObject;
import we.a0;
import we.c0;
import we.v;
import we.x;
import we.y;

/* JADX INFO: loaded from: classes.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final v f9948a = null;

    static {
        f9948a = new v();
    }

    public static String a(String r8) {
        return new JSONObject(new JSONObject(r8).getString("data")).getString("nonce");
    L4:
        e = move-exception;
        Log.e("a", "getChallenge exception: " + e.getMessage());
        return "";
    }

    public static String b(String r8) {
        int r10 = new JSONObject(r8).getInt("code");     // Catch: Exception -> L5
    L8:
        if (r10 >= 200) goto L10;
        return "";
    L10:
        if (r10 >= 300) goto L21;
        return a(r8);
    L13:
        e = move-exception;
        Log.e("a", "parseChallenge exception: " + e.getMessage());
        return "";
    L21:
        return "";
    L5:
        e = move-exception;
        Log.e("a", "getResponseCode exception: " + e.getMessage());
        r10 = 400;
        goto L8
    }

    public static String c() {
        y.a r8 = new y.a();
        m8.b r10 = b.a().f9950a;
        if (r10 == null) goto L5;
        boolean r11 = r10.onIsBoeEnv();
    L6:
        if (r11 == false) goto L8;
        String r12 = "https://ocean-secret-boe.bytedance.net/api/auth/challenge";
    L9:
        r8.e(r12);
        r8.c(null, HttpMethodContrants.GET);
        y r13 = r8.a();
        r13.toString();
        Objects.toString(r13.f13341e);
        int r14 = 1;
        String r15 = "";
    L11:
        if (r14 > 3) goto L44;
        v r16 = f9948a;     // Catch: Exception -> L31 IOException -> L33 ConnectException -> L35 SocketTimeoutException -> L37
        r16.getClass();     // Catch: Exception -> L31 IOException -> L33 ConnectException -> L35 SocketTimeoutException -> L37
        a0 r17 = x.f(r16, r13, false).d();     // Catch: Exception -> L31 IOException -> L33 ConnectException -> L35 SocketTimeoutException -> L37
        c0 r18 = r17.f13120q;     // Catch: Throwable -> L25
        if (r18 == null) goto L16;
        String r19 = r18.n();     // Catch: Throwable -> L25
    L18:
        if (r17.r() == true) goto L19;
        Log.e("a", "Challenge Attempt " + r14 + ": Response failed, code = " + r17.f13116m);     // Catch: Throwable -> L25
        StringBuilder r110 = new StringBuilder();     // Catch: Throwable -> L25
        r110.append("Challenge Response body:");     // Catch: Throwable -> L25
        r110.append(r19);     // Catch: Throwable -> L25
        Log.e("a", r110.toString());     // Catch: Throwable -> L25
        r17.close();     // Catch: Exception -> L31 IOException -> L33 ConnectException -> L35 SocketTimeoutException -> L37
    L40:
        if (r14 >= 3) goto L43;
        Thread.sleep(500);     // Catch: InterruptedException -> L45
    L43:
        r14 = r14 + 1;
        goto L11
    L19:
        r15 = b(r19);     // Catch: Throwable -> L25
        r17.close();     // Catch: Exception -> L31 IOException -> L33 ConnectException -> L35 SocketTimeoutException -> L37
        goto L44
    L16:
        r19 = "";
    L25:
        th = move-exception;
        r17.close();     // Catch: Throwable -> L28
    L30:
        throw th;     // Catch: Exception -> L31 IOException -> L33 ConnectException -> L35 SocketTimeoutException -> L37
    L28:
        th = move-exception;
        th.addSuppressed(th);     // Catch: Exception -> L31 IOException -> L33 ConnectException -> L35 SocketTimeoutException -> L37
    L35:
        e = move-exception;
        StringBuilder r20 = defpackage.b.f("Challenge Attempt ", r14, ": ConnectException (connect timeout): ");
        String r21 = e.getMessage();
    L39:
        r20.append(r21);
        Log.e("a", r20.toString());
    L37:
        e = move-exception;
        r20 = defpackage.b.f("Challenge Attempt ", r14, ": SocketTimeoutException (read/write timeout): ");
        r21 = e.getMessage();
    L33:
        e = move-exception;
        r20 = defpackage.b.f("Challenge Attempt ", r14, ": IOException: ");
        r21 = e.getMessage();
    L31:
        e = move-exception;
        Log.e("a", "Challenge Attempt " + r14 + ": Unexpected exception: ", e);
        e.printStackTrace();
    L44:
        return r15;
    L8:
        r12 = "https://ocean-secret.oceancloudapi.com/api/auth/challenge";
        goto L9
    L5:
        r11 = false;
        goto L6
    }
}
