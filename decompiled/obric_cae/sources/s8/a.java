package s8;

import android.util.Log;
import androidx.appcompat.widget.k;
import org.json.JSONObject;
import we.v;

/* JADX INFO: loaded from: classes.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final v f12048a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static volatile a f12049b;

    static {
        f12048a = new v();
    }

    public a() {
    }

    public static e6.a a(String r8) {
        int r10 = new JSONObject(r8).getInt("code");     // Catch: Exception -> L5
    L26:
        String r11 = new JSONObject(r8).getString("msg");     // Catch: Exception -> L9
    L12:
        if (r10 >= 200) goto L14;
    L19:
        k r12 = null;
    L21:
        return new e6.a(r10, r11, r12);
    L14:
        if (r10 >= 300) goto L19;
        r12 = b(r8);     // Catch: Exception -> L17
    L17:
        e = move-exception;
        Log.e("a", "buildNetworkResponse exception: " + e.getMessage());
    L9:
        e = move-exception;
        Log.e("a", "getResponseMsg exception: " + e.getMessage());
        r11 = "";
    L5:
        e = move-exception;
        Log.e("a", "getResponseCode exception: " + e.getMessage());
        r10 = 400;
        goto L26
    }

    public static k b(String r8) {
        JSONObject r10 = new JSONObject(new JSONObject(r8).getString("data"));     // Catch: Exception -> L5
        return new k(r10.optString("rpuid", ""), r10.optString("rpdid", ""));
    L5:
        e = move-exception;
        Log.e("a", "getPseudoID exception: " + e.getMessage());
        return null;
    }
}
