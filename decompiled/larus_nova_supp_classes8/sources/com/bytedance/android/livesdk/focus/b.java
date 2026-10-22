package com.bytedance.android.livesdk.focus;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import com.bytedance.android.livesdkapi.depend.model.broadcast.ExposureCompensationInfo;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class b {
    public static final /* synthetic */ int o = 0;
    public int a;
    public int b;
    public int c;
    public int d;
    public boolean e;
    public boolean f;
    public boolean g;
    public final Lazy h;
    public final Lazy i;
    public final Lazy j;
    public final ViewGroup k;
    public final ImageView l;
    public final ExposureSeekBarView m;
    public final a n;

    public interface a {
        ExposureCompensationInfo getCameraECInfo();

        void setExposure(int r1);
    }

    /* JADX INFO: renamed from: com.bytedance.android.livesdk.focus.b$b, reason: collision with other inner class name */
    public static final class C0350b {
    }

    static {
    }

    public static final AnimatorSet a(b r8, View r9, Function0 r10) {
        r8.getClass();
        ObjectAnimator r0 = ObjectAnimator.ofFloat(r9, View.ALPHA, new float[]{1.0f, 1.0f});
        r0.setDuration(500);
        ObjectAnimator r4 = ObjectAnimator.ofFloat(r9, View.ALPHA, new float[]{1.0f, 0.5f});
        r4.setDuration(1000);
        ObjectAnimator r5 = ObjectAnimator.ofFloat(r9, View.ALPHA, new float[]{0.5f, 0.5f});
        r5.setDuration(500);
        ObjectAnimator r6 = ObjectAnimator.ofFloat(r9, View.ALPHA, new float[]{0.5f, 0.0f});
        r6.setDuration(500);
        r6.addListener(new FocusAndExposureManager$getAlphaDisappearAnimation$1(r8, r9, r10));
        AnimatorSet r11 = new AnimatorSet();
        r11.playSequentially(new Animator[]{r0, r4, r5, r6});
        return r11;
    }

    public b(ViewGroup r2, ImageView r3, ExposureSeekBarView r4, LiveFocusWidget.c r5) {
        Intrinsics.checkNotNullParameter(r2, "containerView");
        Intrinsics.checkNotNullParameter(r3, "focusIcon");
        Intrinsics.checkNotNullParameter(r4, "exposureSeekBar");
        Intrinsics.checkNotNullParameter(r5, "cameraListener");
        this.k = r2;
        this.l = r3;
        this.m = r4;
        this.n = r5;
        this.h = LazyKt.lazy(new FocusAndExposureManager$defaultAnimationSet$2(this));
        this.i = LazyKt.lazy(new FocusAndExposureManager$focusIconAlphaDisappearAnimationSet$2(this));
        this.j = LazyKt.lazy(new FocusAndExposureManager$exposureSeekBarAlphaDisappearAnimationSet$2(this));
    }
}
