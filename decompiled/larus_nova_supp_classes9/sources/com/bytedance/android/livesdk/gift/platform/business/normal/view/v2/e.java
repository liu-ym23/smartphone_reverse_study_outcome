package com.bytedance.android.livesdk.gift.platform.business.normal.view.v2;

import android.graphics.drawable.Animatable;
import com.facebook.drawee.controller.BaseControllerListener;
import com.facebook.fresco.animation.drawable.AnimatedDrawable2;
import com.facebook.fresco.animation.drawable.BaseAnimationListener;
import com.larus.apm.impl.protector.RunnableProtector;
import kotlin.jvm.functions.Function0;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class e extends BaseControllerListener<Object> {
    public final /* synthetic */ NormalGiftCombViewV2 a;
    public final /* synthetic */ Function0 b;
    public final /* synthetic */ Function0 c;

    public static final class a extends BaseAnimationListener {
        public int a;
        public final /* synthetic */ e b;
        public final /* synthetic */ Animatable c;

        /* JADX INFO: renamed from: com.bytedance.android.livesdk.gift.platform.business.normal.view.v2.e$a$a, reason: collision with other inner class name */
        public static final class RunnableC0063a implements Runnable {
            public final /* synthetic */ a a;

            public RunnableC0063a(a r1) {
                this.a = r1;
            }

            @Override // java.lang.Runnable
            public final void run() {
                this.a.b.b.invoke();     // Catch: Throwable -> L4
                return;
            L4:
                th = move-exception;
                if (RunnableProtector.intercept(th) == false) goto L8;
                return;
            L8:
                throw th;
            }
        }

        public static final class b implements Runnable {
            public final /* synthetic */ a a;

            public b(a r1) {
                this.a = r1;
            }

            @Override // java.lang.Runnable
            public final void run() {
                this.a.b.c.invoke();     // Catch: Throwable -> L4
                return;
            L4:
                th = move-exception;
                if (RunnableProtector.intercept(th) == false) goto L8;
                return;
            L8:
                throw th;
            }
        }

        public final void onAnimationStart(AnimatedDrawable2 r2) {
            this.b.a.post(new RunnableC0063a(this));
        }

        public final void onAnimationStop(AnimatedDrawable2 r2) {
            this.b.a.post(new b(this));
        }

        public a(e r1, Animatable r2) {
            this.b = r1;
            this.c = r2;
            this.a = -1;
        }

        public final void onAnimationFrame(AnimatedDrawable2 r1, int r2) {
            if (r2 >= this.a) goto L5;
            this.c.stop();
        L5:
            this.a = r2;
        }
    }

    public e(NormalGiftCombViewV2 r1, Function0 r2, Function0 r3) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
    }

    public final void onFinalImageSet(String r1, Object r2, Animatable r3) {
        if ((r3 instanceof AnimatedDrawable2) == false) goto L5;
        ((AnimatedDrawable2) r3).setAnimationListener(new a(this, r3));
    L5:
        if (r3 == null) goto L8;
        r3.start();
        return;
    }
}
