package com.google.android.material.transition;

import android.animation.Animator;
import android.animation.ObjectAnimator;
import android.animation.PropertyValuesHolder;
import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import androidx.core.view.ViewCompat;
import com.obric.memorydata.plugin.R;
import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: loaded from: classes2.dex */
public final class k implements m {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private int f4264a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private int f4265b;

    public k(int r2) {
        this.f4265b = -1;
        this.f4264a = r2;
    }

    private int a(Context r3) {
        Context r4 = (Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.memorydata.plugin");
        int r2 = this.f4265b;
        if (r2 == (-1)) goto L6;
        return r2;
    L6:
        return ZeusTransformUtils.getResources(r4, "com.obric.memorydata.plugin").getDimensionPixelSize(ZeusTransformUtils.mapRes(R.dimen.mtrl_transition_shared_axis_slide_distance, "dimen", "mtrl_transition_shared_axis_slide_distance"));
    }

    private static Animator a(final View r5, float r6, float r7, final float r8) {
        ObjectAnimator r9 = ObjectAnimator.ofPropertyValuesHolder(r5, new PropertyValuesHolder[]{PropertyValuesHolder.ofFloat(View.TRANSLATION_X, new float[]{r6, r7})});
        r9.addListener(new AnonymousClass1(r5, r8));
        return r9;
    }

    private static Animator a(View r3, View r4, int r5, int r6) {
        float r0 = r4.getTranslationX();
        float r1 = r4.getTranslationY();
        if (r5 == 3) goto L35;
        if (r5 == 5) goto L33;
        if (r5 == 48) goto L31;
        if (r5 == 80) goto L29;
        if (r5 == 8388611) goto L23;
        if (r5 != 8388613) goto L21;
        if (a(r3) == false) goto L17;
        float r7 = r0 - r6;
    L19:
        return a(r4, r7, r0, r0);
    L17:
        r7 = r6 + r0;
        goto L19
    L21:
        throw new IllegalArgumentException("Invalid slide direction: " + r5);
    L23:
        if (a(r3) == false) goto L25;
        float r8 = r6 + r0;
    L27:
        return a(r4, r8, r0, r0);
    L25:
        r8 = r0 - r6;
        goto L27
    L29:
        return b(r4, r6 + r1, r1, r1);
    L31:
        return b(r4, r1 - r6, r1, r1);
    L33:
        return a(r4, r0 - r6, r0, r0);
    L35:
        return a(r4, r6 + r0, r0, r0);
    }

    private static boolean a(View r1) {
        if (ViewCompat.getLayoutDirection(r1) == 1) goto L7;
        return false;
    L7:
        return true;
    }

    private static Animator b(final View r5, float r6, float r7, final float r8) {
        ObjectAnimator r9 = ObjectAnimator.ofPropertyValuesHolder(r5, new PropertyValuesHolder[]{PropertyValuesHolder.ofFloat(View.TRANSLATION_Y, new float[]{r6, r7})});
        r9.addListener(new AnonymousClass2(r5, r8));
        return r9;
    }

    private static Animator b(View r3, View r4, int r5, int r6) {
        float r0 = r4.getTranslationX();
        float r1 = r4.getTranslationY();
        if (r5 == 3) goto L35;
        if (r5 == 5) goto L33;
        if (r5 == 48) goto L31;
        if (r5 == 80) goto L29;
        if (r5 == 8388611) goto L23;
        if (r5 != 8388613) goto L21;
        if (a(r3) == false) goto L17;
        float r7 = r6 + r0;
    L19:
        return a(r4, r0, r7, r0);
    L17:
        r7 = r0 - r6;
        goto L19
    L21:
        throw new IllegalArgumentException("Invalid slide direction: " + r5);
    L23:
        if (a(r3) == false) goto L25;
        float r8 = r0 - r6;
    L27:
        return a(r4, r0, r8, r0);
    L25:
        r8 = r6 + r0;
        goto L27
    L29:
        return b(r4, r1, r1 - r6, r1);
    L31:
        return b(r4, r1, r6 + r1, r1);
    L33:
        return a(r4, r0, r6 + r0, r0);
    L35:
        return a(r4, r0, r0 - r6, r0);
    }

    @Override // com.google.android.material.transition.m
    public Animator a(ViewGroup r5, View r6) {
        return a(r5, r6, this.f4264a, a((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(r6.getContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin")));
    }

    @Override // com.google.android.material.transition.m
    public Animator b(ViewGroup r5, View r6) {
        return b(r5, r6, this.f4264a, a((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(r6.getContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin")));
    }
}
