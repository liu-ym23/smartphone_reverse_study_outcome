package k;

import android.app.Activity;
import android.os.Build;
import com.bytedance.apm.core.ActivityLifeObserver;
import com.bytedance.crash.dumper.Scraps;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public class c extends i0.a {

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    private static int f9972m = 10;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private boolean f9973l;

    static {
    }

    public c() {
        this.f9290j = Scraps.BATTERY;
    }

    @Override // i0.a
    protected void c(JSONObject r10) {
        boolean r11 = true;
        if (Build.VERSION.SDK_INT >= 21) goto L5;
    L7:
        r11 = false;
    L8:
        this.f9973l = r11;
        return;
    L5:
        if (r10.optInt("energy_enable", 0) != 1) goto L7;
        goto L7
    }

    @Override // i0.a
    protected boolean f() {
        return this.f9973l;
    }

    @Override // i0.a
    protected void i() {
        super.i();
        if (this.f9973l == true) goto L5;
        return;
    L5:
        if (e() == false) goto L8;
        return;
    L8:
        if (s.a.e(com.bytedance.apm.d.g()) == false) goto L10;
        return;
    L10:
        float r10 = ub.c.b(com.bytedance.apm.d.g());
        if (r10 >= f9972m) goto L16;
        return;
    L16:
        JSONObject r11 = new JSONObject();     // Catch: JSONException -> L15
        r11.put("timing_current", r10);     // Catch: JSONException -> L15
        JSONObject r12 = new JSONObject();     // Catch: JSONException -> L15
        r12.put("scene", ActivityLifeObserver.getInstance().getTopActivityClassName());     // Catch: JSONException -> L15
        k(new y.e(Scraps.BATTERY, "", r11, r12, null));     // Catch: JSONException -> L15
        return;
    }

    @Override // i0.a
    protected long n() {
        return 300000;
    }

    @Override // i0.a, t4.d
    public void onBackground(Activity r10) {
        super.onBackground(r10);
        q0.b.f().m(this);
    }

    @Override // i0.a, t4.d
    public void onFront(Activity r10) {
        super.onFront(r10);
        if (this.f9973l == false) goto L6;
        q0.b.f().c(this);
        return;
    }
}
