package q6;

import android.util.Log;
import com.bytedance.retrofit2.HttpMethodContrants;
import java.util.Objects;
import org.json.JSONObject;
import we.a0;
import we.c0;
import we.v;
import we.x;
import we.y;

/* JADX INFO: loaded from: classes.dex */
public final class a {
    public static String a(String r8) {
        return new JSONObject(new JSONObject(r8).getString("data")).getString("nonce");
    L4:
        e = move-exception;
        Log.e("ChallengeManager", "getChallenge exception:" + e.getMessage());
        return "";
    }

    public static String b(String r8) {
        int r10 = new JSONObject(r8).getInt("code");     // Catch: Exception -> L5
    L8:
        if (r10 >= 200) goto L10;
    L15:
        return "";
    L10:
        if (r10 >= 300) goto L15;
        return a(r8);
    L13:
        e = move-exception;
        Log.e("ChallengeManager", "parseChallenge exception:" + e.getMessage());
    L5:
        e = move-exception;
        Log.e("ChallengeManager", "getResponseCode exception:" + e.getMessage());
        r10 = 400;
        goto L8
    }

    public static String c() {
        v r8 = new v();
        y.a r10 = new y.a();
        m6.a r11 = b.a().f10170a;
        if (r11 == null) goto L5;
        boolean r12 = r11.onIsBoeEnv();
    L6:
        if (r12 == false) goto L8;
        String r13 = "https://ocean-secret-boe.bytedance.net/api/auth/challenge";
    L9:
        r10.e(r13);
        r10.c(null, HttpMethodContrants.GET);
        y r14 = r10.a();
        Log.i("ChallengeManager", "Request:" + r14.toString());
        Objects.toString(r14.f13341e);
        a0 r15 = x.f(r8, r14, false).d();     // Catch: Exception -> L16
        boolean r16 = r15.r();     // Catch: Exception -> L16
        c0 r17 = r15.f13120q;
        if (r16 == false) goto L14;
        String r18 = r17.n();     // Catch: Exception -> L16
        Log.i("ChallengeManager", "response:" + r15.toString());     // Catch: Exception -> L16
        return b(r18);
    L14:
        Log.i("ChallengeManager", "newCall failed!! response:" + r15.toString());     // Catch: Exception -> L16
        Log.i("ChallengeManager", "newCall failed!! response body:" + r17.n());     // Catch: Exception -> L16
    L18:
        return "";
    L16:
        e = move-exception;
        e.printStackTrace();
        goto L18
    L8:
        r13 = "https://ocean-secret.oceancloudapi.com/api/auth/challenge";
        goto L9
    L5:
        r12 = false;
        goto L6
    }
}
