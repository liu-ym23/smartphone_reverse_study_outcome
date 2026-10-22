package b5;

import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public final class b extends android.support.v4.media.a {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f3060c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public int f3061d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public int f3062e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public long f3063f;

    public b() {
        this.f3060c = 0;
        this.f3061d = 0;
        this.f3062e = 0;
        this.f3063f = 0;
    }

    @Override // android.support.v4.media.a
    public final JSONObject i() {
        JSONObject r8 = new JSONObject();
        r8.put("params_for_special", "uc_login");     // Catch: JSONException -> L5
        r8.put("duration", this.f3063f);     // Catch: JSONException -> L5
        r8.put("type", this.f3060c);     // Catch: JSONException -> L5
        r8.put("state", this.f3061d);     // Catch: JSONException -> L5
        r8.put("flag", this.f3062e);     // Catch: JSONException -> L5
    L7:
        return r8;
    L5:
        e = move-exception;
        e.printStackTrace();
        goto L7
    }

    @Override // android.support.v4.media.a
    public final void w() {
        this.f3060c = 0;
        this.f3061d = 0;
        this.f3062e = 0;
        this.f3063f = 0;
    }
}
