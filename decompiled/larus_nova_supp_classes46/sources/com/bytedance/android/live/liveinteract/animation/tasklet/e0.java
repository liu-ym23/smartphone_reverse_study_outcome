package com.bytedance.android.live.liveinteract.animation.tasklet;

import com.bytedance.android.live.core.log.ALogger;
import com.facebook.fresco.animation.drawable.AnimatedDrawable2;
import com.facebook.fresco.animation.drawable.BaseAnimationListener;
import com.larus.apm.impl.protector.RunnableProtector;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class e0 extends BaseAnimationListener {
    public final /* synthetic */ f0 a;

    public static final class a implements Runnable {
        public final /* synthetic */ e0 a;

        public a(e0 r1) {
            this.a = r1;
        }

        public final void a() {
            WebPAnimationTasklet r0 = this.a.a.a;
            if (r0.g == true) goto L6;
            WebPAnimationTasklet.c(r0);
            ALogger.d("InteractAnimation.WebPAnimationTasklet", "onAnimationStop#" + this.a.a.a.hashCode() + " cause timeout.");
            return;
        }

        @Override // java.lang.Runnable
        public final void run() {
            a();     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }
    }

    public e0(f0 r1) {
        this.a = r1;
    }

    public final void onAnimationStart(AnimatedDrawable2 r4) {
        ALogger.d("InteractAnimation.WebPAnimationTasklet", "onAnimationStart#" + this.a.a.hashCode());
        WebPAnimationTasklet r5 = this.a.a;
        Function2<d, Boolean, Unit> r0 = r5.k;
        if (r0 == null) goto L5;
        Unit r6 = (Unit) r0.invoke(r5, Boolean.TRUE);
    L5:
        WebPAnimationTasklet.b(this.a.a).postDelayed(new a(this), 10000);
    }

    public final void onAnimationStop(AnimatedDrawable2 r3) {
        WebPAnimationTasklet r4 = this.a.a;
        Function2<d, Boolean, Unit> r0 = r4.k;
        if (r0 == null) goto L5;
        Unit r5 = (Unit) r0.invoke(r4, Boolean.FALSE);
    L5:
        WebPAnimationTasklet.c(this.a.a);
        ALogger.d("InteractAnimation.WebPAnimationTasklet", "onAnimationStop#" + this.a.a.hashCode());
    }

    public final void onAnimationFrame(AnimatedDrawable2 r2, int r3) {
        Intrinsics.checkNotNullParameter(r2, "drawable");
        if (r3 < (r2.getFrameCount() - 1)) goto L6;
        r2.stop();
        return;
    }
}
