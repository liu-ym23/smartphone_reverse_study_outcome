package androidx.lifecycle;

import android.app.Activity;
import android.os.Bundle;
import android.os.Handler;

/* JADX INFO: loaded from: classes.dex */
public final class x extends d {
    final /* synthetic */ w this$0;

    public static final class a extends d {
        final /* synthetic */ w this$0;

        public a(w r8) {
            this.this$0 = r8;
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityPostResumed(Activity r8) {
            he.i.f(r8, "activity");
            this.this$0.a();
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityPostStarted(Activity r8) {
            he.i.f(r8, "activity");
            w r10 = this.this$0;
            int r11 = r10.f2196a + 1;
            r10.f2196a = r11;
            if (r11 == 1) goto L5;
            return;
        L5:
            if (r10.f2199n == false) goto L9;
            r10.f2201p.f(h.a.ON_START);
            r10.f2199n = false;
            return;
        }
    }

    public x(w r8) {
        this.this$0 = r8;
    }

    @Override // androidx.lifecycle.d, android.app.Application.ActivityLifecycleCallbacks
    public void onActivityCreated(Activity r8, Bundle r10) {
        he.i.f(r8, "activity");
    }

    @Override // androidx.lifecycle.d, android.app.Application.ActivityLifecycleCallbacks
    public void onActivityPaused(Activity r8) {
        he.i.f(r8, "activity");
        w r10 = this.this$0;
        int r11 = r10.f2197b - 1;
        r10.f2197b = r11;
        if (r11 != 0) goto L6;
        Handler r12 = r10.f2200o;
        he.i.c(r12);
        r12.postDelayed(r10.f2202q, 700);
        return;
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityPreCreated(Activity r8, Bundle r10) {
        he.i.f(r8, "activity");
        w.a.a(r8, new a(this.this$0));
    }

    @Override // androidx.lifecycle.d, android.app.Application.ActivityLifecycleCallbacks
    public void onActivityStopped(Activity r8) {
        he.i.f(r8, "activity");
        w r10 = this.this$0;
        int r11 = r10.f2196a - 1;
        r10.f2196a = r11;
        if (r11 == 0) goto L5;
        return;
    L5:
        if (r10.f2198m == false) goto L9;
        r10.f2201p.f(h.a.ON_STOP);
        r10.f2199n = true;
        return;
    }
}
