package com.bytedance.android.ec.core.utils.rotation;

import android.animation.Animator;
import android.animation.ValueAnimator;
import android.view.View;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public abstract class a<T> extends e<T> {
    public final boolean j;

    /* JADX INFO: renamed from: com.bytedance.android.ec.core.utils.rotation.a$a, reason: collision with other inner class name */
    public static final class C0146a {
    }

    public static final class b implements ValueAnimator.AnimatorUpdateListener {
        public final /* synthetic */ View a;

        public b(View r1) {
            this.a = r1;
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public final void onAnimationUpdate(ValueAnimator r10) {
            Object r11 = r10.getAnimatedValue();
            if (r11 == null) goto L7;
            float r12 = ((Float) r11).floatValue();
            this.a.setAlpha(r12);
            return;
        L7:
            throw new NullPointerException("null cannot be cast to non-null type kotlin.Float");
        }
    }

    public static final class c implements ValueAnimator.AnimatorUpdateListener {
        public final /* synthetic */ View a;

        public c(View r1) {
            this.a = r1;
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public final void onAnimationUpdate(ValueAnimator r10) {
            Object r11 = r10.getAnimatedValue();
            if (r11 == null) goto L7;
            float r12 = ((Float) r11).floatValue();
            this.a.setAlpha(r12);
            return;
        L7:
            throw new NullPointerException("null cannot be cast to non-null type kotlin.Float");
        }
    }

    static {
    }

    @Override // com.bytedance.android.ec.core.utils.rotation.e
    public Animator b(View r10) {
        Intrinsics.checkNotNullParameter(r10, "layout");
        ValueAnimator r0 = ValueAnimator.ofFloat(new float[]{0.0f, 1.0f});
        r0.setDuration(300);
        if (this.j == true) goto L5;
        long r1 = 80;
    L6:
        r0.setStartDelay(r1);
        if (this.j == true) goto L9;
        r0.addUpdateListener(new b(r10));
    L9:
        return r0;
    L5:
        r1 = 120;
        goto L6
    }

    @Override // com.bytedance.android.ec.core.utils.rotation.e
    public Animator c(View r10) {
        Intrinsics.checkNotNullParameter(r10, "layout");
        ValueAnimator r0 = ValueAnimator.ofFloat(new float[]{1.0f, 0.0f});
        r0.setDuration(120);
        if (this.j == true) goto L5;
        r0.addUpdateListener(new c(r10));
    L5:
        return r0;
    }

    public a(List r10, long r11, long r12, boolean r13) {
        Intrinsics.checkNotNullParameter(r10, "rotationData");
        Intrinsics.checkNotNullParameter(r10, "rotationData");
        this.a = r10;
        this.b = r11;
        this.c = r12;
        this.d = true;
        this.j = r13;
    }
}
