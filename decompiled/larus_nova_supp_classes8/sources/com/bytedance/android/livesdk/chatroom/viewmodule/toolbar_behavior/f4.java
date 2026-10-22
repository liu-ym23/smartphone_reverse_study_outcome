package com.bytedance.android.livesdk.chatroom.viewmodule.toolbar_behavior;

import android.graphics.drawable.Animatable;
import com.facebook.fresco.animation.drawable.AnimatedDrawable2;
import com.facebook.fresco.animation.drawable.BaseAnimationListener;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class f4 extends BaseAnimationListener {
    public int a;
    public final /* synthetic */ Function0 b;
    public final /* synthetic */ Function0 c;
    public final /* synthetic */ Animatable d;
    public final /* synthetic */ Function2 e;

    public final void onAnimationStart(AnimatedDrawable2 r2) {
        Intrinsics.checkNotNullParameter(r2, "drawable2");
        Function0 r3 = this.b;
        if (r3 == null) goto L6;
        Unit r4 = (Unit) r3.invoke();
        return;
    }

    public final void onAnimationStop(AnimatedDrawable2 r2) {
        Intrinsics.checkNotNullParameter(r2, "drawable2");
        Function0 r3 = this.c;
        if (r3 == null) goto L6;
        Unit r4 = (Unit) r3.invoke();
        return;
    }

    public final void onAnimationFrame(AnimatedDrawable2 r3, int r4) {
        Intrinsics.checkNotNullParameter(r3, "drawable2");
        if (r4 >= this.a) goto L5;
        this.d.stop();
    L5:
        Function2 r0 = this.e;
        if (r0 == null) goto L8;
        Unit r5 = (Unit) r0.invoke(Integer.valueOf(r4), Integer.valueOf(r3.getFrameCount()));
    L8:
        this.a = r4;
    }

    public f4(Function0 r1, Function0 r2, Animatable r3, Function2 r4) {
        this.b = r1;
        this.c = r2;
        this.d = r3;
        this.e = r4;
        this.a = -1;
    }
}
