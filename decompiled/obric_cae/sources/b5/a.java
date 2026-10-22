package b5;

import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public final class a extends android.support.v4.media.a {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public long f3053c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public long f3054d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public long f3055e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public boolean f3056f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public int f3057g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public int f3058h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public boolean f3059i;

    public a() {
        this.f3053c = 0;
        this.f3054d = 0;
        this.f3055e = 0;
        this.f3056f = false;
        this.f3057g = 0;
        this.f3058h = 0;
        this.f3059i = false;
    }

    @Override // android.support.v4.media.a
    public final JSONObject i() {
        JSONObject r8 = new JSONObject();
        r8.put("params_for_special", "uc_login");     // Catch: JSONException -> L5
        r8.put("duration", this.f3054d - this.f3053c);     // Catch: JSONException -> L5
        r8.put("retry_count", this.f3055e);     // Catch: JSONException -> L5
        r8.put("is_first", this.f3056f);     // Catch: JSONException -> L5
        r8.put("is_new_user_mode", this.f3057g);     // Catch: JSONException -> L5
        r8.put("scene", this.f3058h);     // Catch: JSONException -> L5
        r8.put("result", this.f3059i);     // Catch: JSONException -> L5
    L7:
        return r8;
    L5:
        e = move-exception;
        e.printStackTrace();
        goto L7
    }

    @Override // android.support.v4.media.a
    public final void w() {
        this.f3053c = 0;
        this.f3054d = 0;
        this.f3055e = 0;
        this.f3056f = false;
        this.f3059i = false;
    }
}
