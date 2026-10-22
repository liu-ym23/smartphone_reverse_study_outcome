package x4;

import android.text.TextUtils;
import com.bytedance.common.wschannel.WsConstants;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public final class i0 implements Cloneable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public String f13443a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public String f13444b;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public String f13445m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public String f13446n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public String f13447o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public String f13448p;

    public i0() {
        this.f13443a = "";
        this.f13444b = "";
    }

    public static i0 b(String r8) {
        if (TextUtils.isEmpty(r8) == false) goto L10;
        return null;
    L10:
        JSONObject r10 = new JSONObject(r8);     // Catch: JSONException -> L7
        i0 r11 = new i0();     // Catch: JSONException -> L7
        r11.f13443a = r10.optString("did", "");     // Catch: JSONException -> L7
        r11.f13444b = r10.optString(WsConstants.KEY_INSTALL_ID, "");     // Catch: JSONException -> L7
        r11.f13445m = r10.optString("openudid", "");     // Catch: JSONException -> L7
        r11.f13446n = r10.optString("cliend_udid", "");     // Catch: JSONException -> L7
        r11.f13447o = r10.optString("ssid", "");     // Catch: JSONException -> L7
        r11.f13447o = r10.optString("eDid", "");     // Catch: JSONException -> L7
        r11.f13447o = r10.optString("eIid", "");     // Catch: JSONException -> L7
        r11.f13448p = r10.optString("egdi", "");     // Catch: JSONException -> L7
        r11.toString();     // Catch: JSONException -> L7
        int r12 = r.f13543a;     // Catch: JSONException -> L7
        return r11;
    L7:
        e = move-exception;
        e.printStackTrace();
        return null;
    }

    public final i0 a() {
        return (i0) super.clone();
    L4:
        int r8 = r.f13543a;
        return null;
    }

    public final /* bridge */ /* synthetic */ Object clone() {
        return a();
    }

    public final String toString() {
        StringBuilder r8 = new StringBuilder("{d='");
        r8.append(this.f13443a);
        r8.append("', i='");
        r8.append(this.f13444b);
        r8.append("', o='");
        r8.append(this.f13445m);
        r8.append("', c='");
        r8.append(this.f13446n);
        r8.append("', s='");
        r8.append(this.f13447o);
        r8.append("', eDid='null', eIid='null', e='");
        return android.aimedia.a.i(r8, this.f13448p, "'}");
    }
}
