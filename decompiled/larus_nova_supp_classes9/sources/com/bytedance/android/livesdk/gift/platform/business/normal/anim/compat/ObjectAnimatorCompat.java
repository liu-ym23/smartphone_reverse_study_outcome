package com.bytedance.android.livesdk.gift.platform.business.normal.anim.compat;

import android.animation.Animator;
import android.animation.TimeInterpolator;
import android.view.Choreographer;
import android.view.View;
import com.bytedance.android.live.core.utils.v;
import com.bytedance.android.livesdk.utils.animate.frame.ValueFrameAnimator;
import com.bytedance.bdlocation.BuildConfig;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class ObjectAnimatorCompat extends Animator {
    public static final /* synthetic */ int l = 0;
    public WeakReference<View> a;
    public final List<String> b;
    public ValueFrameAnimator.b c;
    public float d;
    public float e;
    public long f;
    public TimeInterpolator g;
    public boolean h;
    public final Function1<? super Float, Unit> i;
    public final Function0<Unit> j;
    public final Function0<Unit> k;

    @Retention(RetentionPolicy.RUNTIME)
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u001b\n\u0000\b\u0081\u0002\u0018\u00002\u00020\u0001B\u0000¨\u0006\u0002"}, d2 = {"Lcom/bytedance/android/livesdk/gift/platform/business/normal/anim/compat/ObjectAnimatorCompat$Method;", BuildConfig.FLAVOR, "livegift-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
    public @interface Method {
    }

    public static final class a {
        public static ObjectAnimatorCompat a(View r1, @Method String r2, float r3, float r4) {
            Intrinsics.checkNotNullParameter(r2, "method");
            ObjectAnimatorCompat r0 = new ObjectAnimatorCompat();
            r0.setTarget(r1);
            ((ArrayList) r0.b).add(r2);
            r0.d = r3;
            r0.e = r4;
            return r0;
        }
    }

    static {
    }

    @Override // android.animation.Animator
    public final long getStartDelay() {
        return 0;
    }

    @Override // android.animation.Animator
    public final void setStartDelay(long r1) {
    }

    @Override // android.animation.Animator
    public final void start() {
        this.c = new ValueFrameAnimator.b("ObjectAnimatorCompat", 60, this.f, false, 0, 0, new ObjectAnimatorCompat$initAnimator$1(this), this.j, this.k, null, null);
        super.start();
        ValueFrameAnimator.b r0 = this.c;
        if (r0 == null) goto L5;
        r0.d();
    L5:
        this.h = true;
    }

    public ObjectAnimatorCompat() {
        this.b = new ArrayList();
        this.e = 1.0f;
        this.f = 1000;
        this.i = new ObjectAnimatorCompat$onAnimateUpdatedListener$1(this);
        this.j = new ObjectAnimatorCompat$onAnimateStartListener$1(this);
        this.k = new ObjectAnimatorCompat$onAnimateEndListener$1(this);
    }

    @Override // android.animation.Animator
    public final void cancel() {
        super.cancel();
        ValueFrameAnimator.b r0 = this.c;
        if (r0 == null) goto L5;
        r0.b();
    L5:
        this.h = false;
    }

    @Override // android.animation.Animator
    public final void pause() {
        super.pause();
        ValueFrameAnimator.b r0 = this.c;
        if (r0 != null) goto L5;
        return;
    L5:
        if (((com.bytedance.android.livesdk.utils.animate.frame.a) r0).a == null) goto L7;
        boolean r1 = true;
    L8:
        if (r1 == false) goto L16;
        ((com.bytedance.android.livesdk.utils.animate.frame.a) r0).d = System.currentTimeMillis() - ((com.bytedance.android.livesdk.utils.animate.frame.a) r0).c;
        ((com.bytedance.android.livesdk.utils.animate.frame.a) r0).e = true;
        ((com.bytedance.android.livesdk.utils.animate.frame.a) r0).g = true;
        Choreographer.FrameCallback r2 = ((com.bytedance.android.livesdk.utils.animate.frame.a) r0).a;
        if (r2 == null) goto L15;
        Choreographer.getInstance().removeFrameCallback(r2);
        ((com.bytedance.android.livesdk.utils.animate.frame.a) r0).a = null;
        return;
    L15:
        return;
    L16:
        return;
    L7:
        r1 = false;
        goto L8
    }

    @Override // android.animation.Animator
    public final void resume() {
        super.resume();
        this.h = true;
        ValueFrameAnimator.b r0 = this.c;
        if (r0 != null) goto L5;
        return;
    L5:
        if (((com.bytedance.android.livesdk.utils.animate.frame.a) r0).g == false) goto L10;
        ((com.bytedance.android.livesdk.utils.animate.frame.a) r0).g = false;
        r0.d();
        return;
    }

    @Override // android.animation.Animator
    public final long getDuration() {
        return this.f;
    }

    @Override // android.animation.Animator
    public final TimeInterpolator getInterpolator() {
        return this.g;
    }

    @Override // android.animation.Animator
    public final boolean isRunning() {
        return this.h;
    }

    @Override // android.animation.Animator
    public final void addListener(Animator.AnimatorListener r1) {
        super.addListener(r1);
    }

    @Override // android.animation.Animator
    public final void addPauseListener(Animator.AnimatorPauseListener r2) {
        super.addPauseListener(r2);
        if (v.a() == true) goto L6;
        return;
    L6:
        throw new IllegalAccessException("not support");
    }

    @Override // android.animation.Animator
    public final Animator setDuration(long r1) {
        this.f = r1;
        return this;
    }

    @Override // android.animation.Animator
    public final void setInterpolator(TimeInterpolator r1) {
        this.g = r1;
    }

    @Override // android.animation.Animator
    public final void setTarget(Object r2) {
        if ((r2 instanceof View) == false) goto L7;
        this.a = new WeakReference(r2);
        return;
    L7:
        throw new IllegalArgumentException("must be a view");
    }
}
