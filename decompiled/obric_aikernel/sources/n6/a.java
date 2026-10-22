package n6;

import android.text.TextUtils;
import com.bytedance.apm.d;
import com.bytedance.common.wschannel.WsConstants;
import e0.e;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private String f11256a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private String f11257b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @Deprecated
    private long f11258c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private String f11259d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private JSONObject f11260e;

    public a() {
    }

    public static a a(String r10) {
        if (TextUtils.isEmpty(r10) == false) goto L15;
        return null;
    L15:
        a r11 = new a();     // Catch: Exception -> L10
        JSONObject r12 = new JSONObject(r10);     // Catch: Exception -> L10
        r11.f11259d = r12.optString("command_id");     // Catch: Exception -> L10
        r11.f11257b = r12.optString(WsConstants.KEY_CONNECTION_TYPE);     // Catch: Exception -> L10
        String r13 = r12.optString("params");     // Catch: Exception -> L10
        JSONObject r14 = new JSONObject();     // Catch: Exception -> L10
        if (TextUtils.isEmpty(r13) == true) goto L8;
        r14 = new JSONObject(r13);     // Catch: Exception -> L10
    L8:
        r11.f11256a = r13;     // Catch: Exception -> L10
        r11.f11260e = r14;     // Catch: Exception -> L10
        return r11;
    L10:
        e = move-exception;
        if (d.D() == false) goto L14;
        e.f("cloudmessage", e, new String[]{"Parse CloudMessage Error."});
    L14:
        return null;
    }

    public String b() {
        return this.f11259d;
    }

    public String c() {
        return this.f11256a;
    }

    public JSONObject d() {
        return this.f11260e;
    }

    public String e() {
        return this.f11257b;
    }

    public boolean f() {
        return this.f11260e.optBoolean("wifiOnly");
    }

    public String toString() {
        return "CloudMessage{mParams='" + this.f11256a + "', mType=" + this.f11257b + ", send_time=" + this.f11258c + ", command_id='" + this.f11259d + "'}";
    }
}
