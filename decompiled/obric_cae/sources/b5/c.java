package b5;

import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public final class c extends android.support.v4.media.a {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public long f3064c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public long f3065d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public int f3066e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public boolean f3067f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public boolean f3068g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public int f3069h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public int f3070i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public boolean f3071j;

    public c() {
        this.f3064c = 0;
        this.f3065d = 0;
        this.f3066e = 0;
        this.f3067f = false;
        this.f3068g = false;
        this.f3069h = 0;
        this.f3070i = 0;
        this.f3071j = false;
    }

    @Override // android.support.v4.media.a
    public final JSONObject i() {
        JSONObject r8 = new JSONObject();
        r8.put("params_for_special", "uc_login");     // Catch: JSONException -> L5
        r8.put("duration", this.f3065d - this.f3064c);     // Catch: JSONException -> L5
        r8.put("retry_count", this.f3066e);     // Catch: JSONException -> L5
        r8.put("is_first", this.f3068g);     // Catch: JSONException -> L5
        r8.put("did_change", this.f3067f);     // Catch: JSONException -> L5
        r8.put("is_new_user_mode", this.f3069h);     // Catch: JSONException -> L5
        r8.put("scene", this.f3070i);     // Catch: JSONException -> L5
        r8.put("result", this.f3071j);     // Catch: JSONException -> L5
    L7:
        return r8;
    L5:
        e = move-exception;
        e.printStackTrace();
        goto L7
    }

    @Override // android.support.v4.media.a
    public final void w() {
        this.f3064c = 0;
        this.f3065d = 0;
        this.f3066e = 0;
        this.f3067f = false;
        this.f3068g = false;
        this.f3071j = false;
    }
}
