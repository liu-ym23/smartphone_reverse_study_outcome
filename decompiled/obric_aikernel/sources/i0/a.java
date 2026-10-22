package i0;

import android.app.Activity;
import android.os.Bundle;
import android.text.TextUtils;
import androidx.fragment.app.Fragment;
import com.bytedance.apm.core.ActivityLifeObserver;
import com.bytedance.apm6.hub.config.internal.SlardarSettingsConstants;
import com.bytedance.services.slardar.config.IConfigManager;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public abstract class a implements t4.d, u4.a, q0.b.e {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private boolean f9286c;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private boolean f9287g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private boolean f9288h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private boolean f9289i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    protected String f9290j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private long f9291k;

    public a() {
    }

    private final void l() {
        if (this.f9289i == true) goto L7;
        this.f9289i = true;
        if (f() == false) goto L7;
        q0.b.f().c(this);
    L7:
        i();
        this.f9291k = System.currentTimeMillis();
    }

    public final void b() {
        ActivityLifeObserver.getInstance().unregister(this);
        ((IConfigManager) c4.d.a(IConfigManager.class)).unregisterConfigListener(this);
        g();
    }

    protected void c(JSONObject r10) {
    }

    public final void d() {
        if (this.f9288h == false) goto L6;
        return;
    L6:
        if (TextUtils.isEmpty(this.f9290j) == true) goto L12;
        this.f9288h = true;
        ActivityLifeObserver.getInstance().register(this);
        this.f9287g = !ActivityLifeObserver.getInstance().isForeground();
        h();
        ((IConfigManager) c4.d.a(IConfigManager.class)).registerConfigListener(this);
        if (com.bytedance.apm.d.D() == false) goto L13;
        e0.e.b("AbstractPerfCollector", new String[]{"perf init: " + this.f9290j});
        return;
    L13:
        return;
    L12:
        throw new IllegalStateException("Must set collector Setting key, before init");
    }

    protected boolean e() {
        return this.f9287g;
    }

    protected abstract boolean f();

    protected void g() {
    }

    protected void h() {
    }

    protected void i() {
    }

    protected void j() {
    }

    protected void k(y.e r10) {
        b.c(r10);
        b.a(r10, r10.j());
        x.a.p().e(r10);
    }

    public final void m() {
        if (this.f9289i == false) goto L7;
        this.f9289i = false;
        if (f() == false) goto L7;
        q0.b.f().m(this);
    L7:
        j();
    }

    protected abstract long n();

    @Override // t4.d
    public void onActivityCreated(Activity r10, Bundle r11) {
    }

    @Override // t4.d
    public void onActivityPause(Activity r10) {
    }

    @Override // t4.d
    public void onActivityResume(Activity r10) {
    }

    @Override // t4.d
    public void onActivityStarted(Activity r10) {
    }

    @Override // t4.d
    public void onBackground(Activity r10) {
        this.f9287g = true;
        if (com.bytedance.apm.d.L() == false) goto L6;
        m();
        return;
    }

    @Override // t4.d
    public void onChange(Activity r10, Fragment r11) {
    }

    @Override // t4.d
    public void onFront(Activity r10) {
        this.f9287g = false;
        if (com.bytedance.apm.d.L() == true) goto L5;
        return;
    L5:
        if (this.f9286c == false) goto L9;
        l();
        return;
    }

    @Override // u4.a
    public void onReady() {
        this.f9286c = true;
        l();
    }

    @Override // u4.a
    public void onRefresh(JSONObject r10, boolean r11) {
        JSONObject r12 = r10.optJSONObject(SlardarSettingsConstants.SETTING_PERFORMANCE_MODULES);
        if (r12 != null) goto L5;
        return;
    L5:
        JSONObject r13 = r12.optJSONObject(this.f9290j);
        if (r13 != null) goto L8;
        return;
    L8:
        c(r13);
    }

    @Override // q0.b.e
    public final void onTimeEvent(long r10) {
        long r11 = n();
        if (r11 > 0) goto L5;
        return;
    L5:
        if ((r10 - this.f9291k) > r11) goto L7;
        return;
    L7:
        if (this.f9286c == false) goto L12;
        i();
        this.f9291k = System.currentTimeMillis();
        return;
    }
}
