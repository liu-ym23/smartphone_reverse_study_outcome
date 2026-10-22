package com.bytedance.android.live.revlink.impl.behavior;

import com.facebook.fresco.animation.drawable.AnimatedDrawable2;
import com.facebook.fresco.animation.drawable.BaseAnimationListener;
import com.larus.apm.impl.protector.RunnableProtector;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class l extends BaseAnimationListener {
    public int a;
    public final /* synthetic */ n b;
    public final /* synthetic */ int c;
    public final /* synthetic */ AnimatedDrawable2 d;

    public static final class a implements Runnable {
        public final /* synthetic */ l a;

        @Override // java.lang.Runnable
        public final void run() {
            this.a.b.a.b();     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }

        public a(l r1) {
            this.a = r1;
        }
    }

    public final void onAnimationStop(AnimatedDrawable2 r5) {
        this.b.a.d();
        f r6 = this.b.b;
        r6.sendMessageDelayed(r6.obtainMessage(1, new a(this)), ((Number) o.b.getValue(null, o.a[0])).longValue());
    }

    public final void onAnimationFrame(AnimatedDrawable2 r1, int r2) {
        if (r2 >= this.a) goto L5;
    L6:
        this.d.stop();
    L7:
        this.a = r2;
        return;
    L5:
        if (r2 < (this.c - 1)) goto L7;
        goto L6
    }

    public l(n r1, int r2, AnimatedDrawable2 r3) {
        this.b = r1;
        this.c = r2;
        this.d = r3;
        this.a = -1;
    }
}
