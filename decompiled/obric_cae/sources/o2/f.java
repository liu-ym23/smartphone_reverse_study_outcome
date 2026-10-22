package o2;

import com.obric.cae.BWDL.BwdlDrop.fileTransmission.BwdlDropActionFrame;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public final class f implements m2.c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f9643a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f9644b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final JSONObject f9645c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public JSONObject f9646d;

    public f(String r8, String r10, JSONObject r11) {
        this.f9643a = r8;
        this.f9644b = r10;
        this.f9645c = r11;
        this.f9646d = null;
    }

    @Override // m2.c
    public final String a() {
        return "ui_action";
    }

    @Override // m2.c
    public final boolean b(JSONObject r8) {
        return false;
    }

    @Override // m2.c
    public final JSONObject c() {
    L7:
        return null;
    L3:
        if (this.f9646d != null) goto L5;
        this.f9646d = new JSONObject();     // Catch: JSONException -> L7
    L5:
        this.f9646d.put("log_type", "ui_action");     // Catch: JSONException -> L7
        this.f9646d.put(BwdlDropActionFrame.HEADER, this.f9643a);     // Catch: JSONException -> L7
        this.f9646d.put("page", this.f9644b);     // Catch: JSONException -> L7
        this.f9646d.put("context", this.f9645c);     // Catch: JSONException -> L7
        return this.f9646d;
    }

    @Override // m2.c
    public final boolean d() {
        return true;
    }

    @Override // m2.c
    public final String e() {
        return "ui_action";
    }
}
