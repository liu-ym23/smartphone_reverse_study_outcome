package com.bytedance.android.livesdk.gift.platform.business.normal.view.v2.animation;

import com.bytedance.android.live.core.utils.i0;
import com.facebook.fresco.animation.drawable.AnimatedDrawable2;
import com.facebook.fresco.animation.drawable.BaseAnimationListener;
import com.larus.apm.impl.protector.RunnableProtector;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class j {

    public static final class a extends BaseAnimationListener {
        public final /* synthetic */ Function0 a;
        public final /* synthetic */ Function0 b;

        /* JADX INFO: renamed from: com.bytedance.android.livesdk.gift.platform.business.normal.view.v2.animation.j$a$a, reason: collision with other inner class name */
        public static final class RunnableC0062a implements Runnable {
            public final /* synthetic */ a a;

            public RunnableC0062a(a r1) {
                this.a = r1;
            }

            @Override // java.lang.Runnable
            public final void run() {
                this.a.a.invoke();     // Catch: Throwable -> L4
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
                this.a.b.invoke();     // Catch: Throwable -> L4
                return;
            L4:
                th = move-exception;
                if (RunnableProtector.intercept(th) == false) goto L8;
                return;
            L8:
                throw th;
            }
        }

        public final void onAnimationStart(AnimatedDrawable2 r1) {
            i0.h(new RunnableC0062a(this));
        }

        public final void onAnimationStop(AnimatedDrawable2 r1) {
            i0.h(new b(this));
        }

        public a(Function0 r1, Function0 r2) {
            this.a = r1;
            this.b = r2;
        }
    }

    public static final void a(AnimatedDrawable2 r1, Function0<Unit> r2, Function0<Unit> r3) {
        Intrinsics.checkNotNullParameter(r1, "$this$bindListener");
        Intrinsics.checkNotNullParameter(r2, "onStart");
        Intrinsics.checkNotNullParameter(r3, "onEnd");
        r1.setAnimationListener(new a(r2, r3));
    }
}
