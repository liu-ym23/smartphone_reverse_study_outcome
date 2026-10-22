package x4;

import android.content.Context;
import com.bytedance.common.wschannel.WsConstants;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public final class q0 implements a0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Context f13541a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public j0 f13542b;

    public interface a {
    }

    public q0(Context r8) {
        this.f13541a = r8;
    }

    @Override // x4.a0
    public final void a(i0 r8) {
        if (this.f13542b != null) goto L5;
        return;
    L5:
        r8.getClass();
        JSONObject r10 = new JSONObject();
        r10.put("did", r8.f13443a);     // Catch: JSONException -> L8
        r10.put(WsConstants.KEY_INSTALL_ID, r8.f13444b);     // Catch: JSONException -> L8
        r10.put("openudid", r8.f13445m);     // Catch: JSONException -> L8
        r10.put("cliend_udid", r8.f13446n);     // Catch: JSONException -> L8
        r10.put("ssid", r8.f13447o);     // Catch: JSONException -> L8
        r10.put("eDid", null);     // Catch: JSONException -> L8
        r10.put("eIid", null);     // Catch: JSONException -> L8
        r10.put("egdi", r8.f13448p);     // Catch: JSONException -> L8
    L10:
        String r11 = r10.toString();
        boolean r12 = this.f13542b.J;
        Context r13 = this.f13541a;
        if (r12 == false) goto L13;
        r13.getSharedPreferences("ug_install_op_pref", 0).edit().putString("install_info", r11).apply();
    L13:
        v0.a(r13).c(this.f13542b.a(), "install_info", r11);
        return;
    L8:
        e = move-exception;
        e.printStackTrace();
        goto L10
    }
}
