package x0;

import android.app.Activity;
import android.app.Application;
import android.os.Bundle;
import android.text.TextUtils;
import com.bytedance.applog.c;
import f1.g;
import java.util.HashSet;
import l1.h;

/* JADX INFO: loaded from: classes.dex */
public class a implements Application.ActivityLifecycleCallbacks {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private int f13474b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private h f13475c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private long f13476d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private String f13477e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final HashSet<Integer> f13478f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final c f13479g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private boolean f13480h;

    public a(c r10) {
        this.f13474b = 0;
        this.f13478f = new HashSet(8);
        this.f13480h = true;
        this.f13479g = r10;
    }

    private void c() {
        this.f13479g.P().i("App first to frontend...", new Object[0]);
    }

    private void d() {
        this.f13479g.P().i("App back to frontend...", new Object[0]);
        if (this.f13479g.K() != null) goto L5;
        return;
    L5:
        if (this.f13479g.K().X() == false) goto L9;
        this.f13479g.v0();
        return;
    }

    private void e() {
        this.f13479g.P().i("App enter to background...", new Object[0]);
        if (this.f13479g.K() == null) goto L8;
        if (this.f13479g.K().P() == false) goto L8;
        this.f13479g.flush();
    L8:
        if (this.f13479g.K() != null) goto L10;
        return;
    L10:
        if (this.f13479g.K().X() == false) goto L14;
        this.f13479g.w0();
        return;
    }

    public h a() {
        return this.f13475c;
    }

    public void b(String r10, int r11) {
        long r12 = System.currentTimeMillis();
        this.f13479g.P().i("onActivityResumed: {}", new Object[]{r10});
        h r13 = g(r10, "", r12, this.f13477e);
        this.f13475c = r13;
        r13.C = !this.f13478f.remove(Integer.valueOf(r11)) ? 1 : 0;
    }

    public h f(h r10, long r11) {
        h r12 = (h) r10.b();
        r12.x(r11);
        long r13 = r11 - r10.f10828g;
        if (r13 > 0) goto L5;
        r13 = 1000;
    L5:
        r12.f10865z = r13;
        this.f13479g.p0(r12);
        return r12;
    }

    public h g(String r10, String r11, long r12, String r13) {
        h r14 = new h();
        if (TextUtils.isEmpty(r11) == true) goto L5;
        r10 = r10 + ":" + r11;
    L5:
        r14.B = r10;
        r14.x(r12);
        r14.f10865z = -1;
        if (r13 != null) goto L9;
        r13 = "";
    L9:
        r14.A = r13;
        this.f13479g.p0(r14);
        return r14;
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityCreated(Activity r10, Bundle r11) {
        this.f13478f.add(Integer.valueOf(r10.hashCode()));
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityDestroyed(Activity r10) {
        this.f13478f.remove(Integer.valueOf(r10.hashCode()));
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityPaused(Activity r10) {
        long r11 = System.currentTimeMillis();
        g r12 = this.f13479g.P();
        Object[] r13 = new Object[1];
        if (r10 == null) goto L5;
        String r14 = r10.getClass().getName();
    L6:
        r13[0] = r14;
        r12.i("onActivityPaused:{}", r13);
        h r15 = this.f13475c;
        if (r15 == null) goto L10;
        this.f13477e = r15.B;
        this.f13476d = r11;
        f(r15, r11);
        this.f13475c = null;
        return;
    L10:
        return;
    L5:
        r14 = "";
        goto L6
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityResumed(Activity r10) {
        long r11 = System.currentTimeMillis();
        this.f13479g.P().i("onActivityResumed: {}", new Object[]{r10.getClass().getName()});
        h r12 = g(r10.getClass().getName(), "", r11, this.f13477e);
        this.f13475c = r12;
        r12.C = !this.f13478f.remove(Integer.valueOf(r10.hashCode())) ? 1 : 0;
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivitySaveInstanceState(Activity r10, Bundle r11) {
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityStarted(Activity r10) {
        if (this.f13474b == 0) goto L5;
    L8:
        this.f13474b++;
        this.f13480h = false;
        return;
    L5:
        if (this.f13480h == true) goto L7;
        d();
        goto L8
    L7:
        c();
        goto L8
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityStopped(Activity r10) {
        if (this.f13477e == null) goto L8;
        int r11 = this.f13474b - 1;
        this.f13474b = r11;
        if (r11 > 0) goto L9;
        this.f13477e = null;
        this.f13476d = 0;
        e();
        return;
    L9:
        return;
    }
}
