package com.bytedance.android.live.liveinteract.animation.tasklet;

import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.core.widget.HSImageView;
import com.facebook.fresco.animation.drawable.AnimatedDrawable2;
import com.facebook.fresco.animation.drawable.BaseAnimationListener;
import com.larus.apm.impl.protector.RunnableProtector;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class a0 extends BaseAnimationListener {
    public final /* synthetic */ z a;
    public final /* synthetic */ HSImageView b;

    public static final class a implements Runnable {
        public final /* synthetic */ a0 a;
        public final /* synthetic */ AnimatedDrawable2 b;

        public a(a0 r1, AnimatedDrawable2 r2) {
            this.a = r1;
            this.b = r2;
        }

        @Override // java.lang.Runnable
        public final void run() {
            a0 r0 = this.a;     // Catch: Throwable -> L4
            z r1 = r0.a;     // Catch: Throwable -> L4
            HSImageView r2 = r0.b;     // Catch: Throwable -> L4
            AnimatedDrawable2 r3 = this.b;     // Catch: Throwable -> L4
            int r4 = z.i;     // Catch: Throwable -> L4
            r1.b(r2, r3);     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }
    }

    public final void onAnimationStart(AnimatedDrawable2 r4) {
        z r0 = this.a;
        r0.getClass();
        StringBuilder r1 = new StringBuilder("onAnimationStart.Tasklet:");
        r1.append(r0.hashCode());
        r1.append(",drawable:");
        if (r4 == null) goto L5;
        int r5 = r4.hashCode();
    L6:
        r1.append(r5);
        ALogger.d("InteractAnimation.SenderSeatTasklet", r1.toString());
        return;
    L5:
        r5 = 0;
        goto L6
    }

    public final void onAnimationStop(AnimatedDrawable2 r3) {
        this.b.post(new a(this, r3));
    }

    public a0(z r1, HSImageView r2) {
        this.a = r1;
        this.b = r2;
    }
}
