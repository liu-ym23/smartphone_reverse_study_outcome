package com.bytedance.android.live.profit.util;

import android.graphics.drawable.Animatable;
import com.facebook.fresco.animation.drawable.AnimatedDrawable2;
import com.facebook.fresco.animation.drawable.BaseAnimationListener;
import java.lang.ref.WeakReference;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class h extends l {
    public int a;
    public final /* synthetic */ Function0 b;
    public final /* synthetic */ Function0 c;
    public final /* synthetic */ boolean d;
    public final /* synthetic */ boolean e;

    public static final class a extends BaseAnimationListener {
        public final /* synthetic */ h a;
        public final /* synthetic */ Animatable b;

        public final void onAnimationRepeat(AnimatedDrawable2 r1) {
            this.b.stop();
        }

        public final void onAnimationStart(AnimatedDrawable2 r2) {
            Intrinsics.checkNotNullParameter(r2, "drawable2");
            this.a.b.invoke();
        }

        public final void onAnimationStop(AnimatedDrawable2 r2) {
            Intrinsics.checkNotNullParameter(r2, "drawable2");
            this.a.c.invoke();
        }

        public a(h r1, Animatable r2) {
            this.a = r1;
            this.b = r2;
        }

        public final void onAnimationFrame(AnimatedDrawable2 r2, int r3) {
            Intrinsics.checkNotNullParameter(r2, "drawable2");
            if (r3 < this.a.a) goto L7;
            if (r3 >= (r2.getFrameCount() - 1)) goto L7;
        L10:
            this.a.a = r3;
            return;
        L7:
            if (this.a.d == false) goto L9;
            this.b.jumpToFrame(r2.getFrameCount() - 1);
        L9:
            this.b.stop();
            goto L10
        }
    }

    public final void onFinalImageSet(String r1, Object r2, Animatable r3) {
        if ((r3 instanceof AnimatedDrawable2) == false) goto L6;
        new WeakReference(r3);
        AnimatedDrawable2 r4 = (AnimatedDrawable2) r3;
        r4.setLoopCount(1);
        r4.setAnimationListener(new a(this, r3));
    L6:
        if (this.e == false) goto L10;
        if (r3 == null) goto L11;
        r3.start();
        return;
    L11:
        return;
    }

    public h(Function0 r1, Function0 r2, boolean r3, boolean r4) {
        this.b = r1;
        this.c = r2;
        this.d = r3;
        this.e = r4;
        this.a = -1;
        new WeakReference(null);
    }
}
