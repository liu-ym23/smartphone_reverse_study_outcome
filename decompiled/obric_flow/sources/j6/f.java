package j6;

import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public final class f implements h6.b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f18262a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f18263b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final JSONObject f18264c;
    public JSONObject d;

    public f(String r5, String r10, JSONObject r11, JSONObject r12) {
        this.f18262a = r5;
        this.f18263b = r10;
        this.f18264c = r11;
        this.d = r12;
    }

    @Override // h6.b
    public final String a() {
        return "ui_action";
    }

    @Override // h6.b
    public final boolean b(JSONObject r5) {
        return false;
    }

    @Override // h6.b
    public final JSONObject c() {
    L7:
        return null;
    L3:
        if (this.d != null) goto L5;
        this.d = new JSONObject();     // Catch: JSONException -> L7
    L5:
        this.d.put("log_type", "ui_action");     // Catch: JSONException -> L7
        this.d.put("action", this.f18262a);     // Catch: JSONException -> L7
        this.d.put("page", this.f18263b);     // Catch: JSONException -> L7
        this.d.put("context", this.f18264c);     // Catch: JSONException -> L7
        return this.d;
    }

    @Override // h6.b
    public final boolean d() {
        return true;
    }

    @Override // h6.b
    public final String e() {
        return "ui_action";
    }
}
