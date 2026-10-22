package y4;

import android.app.Activity;
import android.app.Application;
import android.os.Bundle;
import x4.d0;
import x4.f0;
import x4.r;
import x4.t;

/* JADX INFO: loaded from: classes.dex */
public final class a implements Application.ActivityLifecycleCallbacks, b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f13988a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public boolean f13989b;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public boolean f13990m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public b.a f13991n;

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityCreated(Activity r8, Bundle r10) {
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityDestroyed(Activity r8) {
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityPaused(Activity r8) {
        int r10 = this.f13988a - 1;
        this.f13988a = r10;
        if (r10 > 0) goto L5;
        this.f13989b = false;
    L5:
        if (r10 >= 0) goto L8;
        this.f13988a = 0;
        return;
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityResumed(Activity r8) {
        if (this.f13988a >= 0) goto L5;
        this.f13988a = 0;
    L5:
        int r10 = this.f13988a;
        if (r10 != 0) goto L8;
        this.f13989b = true;
    L8:
        this.f13988a = r10 + 1;
        this.f13990m = true;
        b.a r11 = this.f13991n;
        if (r11 == null) goto L12;
        f0 r12 = (f0) r11;
        d0 r13 = r12.f13418b;
        ((a) r13.f13395n).f13991n = null;
        int r14 = r.f13543a;
        String r15 = r13.f13392a.a();
        t.e(r12.f13417a, r15);
        return;
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivitySaveInstanceState(Activity r8, Bundle r10) {
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityStarted(Activity r8) {
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityStopped(Activity r8) {
    }
}
