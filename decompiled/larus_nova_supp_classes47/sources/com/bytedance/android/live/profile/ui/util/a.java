package com.bytedance.android.live.profile.ui.util;

import android.graphics.drawable.Animatable;
import com.bytedance.android.live.core.log.ALogger;
import com.facebook.drawee.controller.BaseControllerListener;
import com.facebook.fresco.animation.drawable.AnimatedDrawable2;
import com.facebook.fresco.animation.drawable.BaseAnimationListener;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class a extends BaseControllerListener<Object> {
    public int a;
    public final /* synthetic */ boolean b;
    public final /* synthetic */ Function0 c;
    public final /* synthetic */ Function0 d;

    /* JADX INFO: renamed from: com.bytedance.android.live.profile.ui.util.a$a, reason: collision with other inner class name */
    public static final class C0017a extends BaseAnimationListener {
        public final /* synthetic */ a a;
        public final /* synthetic */ int b;
        public final /* synthetic */ Animatable c;

        public final void onAnimationRepeat(AnimatedDrawable2 r1) {
            super.onAnimationRepeat(r1);
            if (r1 == null) goto L6;
            r1.stop();
            return;
        }

        public final void onAnimationStart(AnimatedDrawable2 r1) {
            super.onAnimationStart(r1);
            Function0 r2 = this.a.c;
            if (r2 == null) goto L6;
            Unit r3 = (Unit) r2.invoke();
            return;
        }

        public final void onAnimationStop(AnimatedDrawable2 r1) {
            super.onAnimationStop(r1);
            Function0 r2 = this.a.d;
            if (r2 == null) goto L6;
            Unit r3 = (Unit) r2.invoke();
            return;
        }

        public final void onAnimationFrame(AnimatedDrawable2 r2, int r3) {
            Intrinsics.checkNotNullParameter(r2, "drawable2");
            ALogger.i("renaoyingwebp", String.valueOf(r3));
            if (r3 >= this.a.a) goto L5;
        L6:
            this.c.stop();
        L7:
            this.a.a = r3;
            return;
        L5:
            if (r3 < (this.b - 1)) goto L7;
            goto L6
        }

        public C0017a(a r1, int r2, Animatable r3) {
            this.a = r1;
            this.b = r2;
            this.c = r3;
        }
    }

    public a(boolean r1, Function0 r2, Function0 r3) {
        this.b = r1;
        this.c = r2;
        this.d = r3;
        this.a = -1;
    }

    public final void onFinalImageSet(String r2, Object r3, Animatable r4) {
        if ((r4 instanceof AnimatedDrawable2) == true) goto L5;
        return;
    L5:
        if (this.b == false) goto L7;
        int r5 = p.a;
        AnimatedDrawable2 r6 = (AnimatedDrawable2) r4;
        Intrinsics.checkNotNullParameter(r6, "animatable");
        r6.setPrivateFrameSchedulerFactory(o.a);
    L7:
        AnimatedDrawable2 r7 = (AnimatedDrawable2) r4;
        r7.setAnimationListener(new C0017a(this, r7.getFrameCount(), r4));
    }
}
