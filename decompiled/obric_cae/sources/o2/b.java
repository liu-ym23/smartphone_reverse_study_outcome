package o2;

import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public final class b implements m2.c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f9625a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final JSONObject f9626b;

    public b(JSONObject r8, String r10) {
        this.f9625a = r10;
        this.f9626b = r8;
    }

    @Override // m2.c
    public final String a() {
        return this.f9625a;
    }

    @Override // m2.c
    public final boolean b(JSONObject r8) {
        return false;
    }

    @Override // m2.c
    public final JSONObject c() {
        JSONObject r8 = this.f9626b;
        if (r8 != null) goto L9;
        return null;
    L9:
        r8.put("log_type", this.f9625a);     // Catch: JSONException -> L8
    L5:
        return r8;
    }

    @Override // m2.c
    public final boolean d() {
        return true;
    }

    @Override // m2.c
    public final String e() {
        return "common_log";
    }
}
