package com.google.android.material.appbar;

import android.R;
import android.animation.AnimatorInflater;
import android.animation.ObjectAnimator;
import android.animation.StateListAnimator;
import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewOutlineProvider;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import com.google.android.material.internal.k;
import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: loaded from: classes2.dex */
class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final int[] f3774a = null;

    static {
        f3774a = new int[]{R.attr.stateListAnimator};
    }

    static void a(View r1) {
        r1.setOutlineProvider(ViewOutlineProvider.BOUNDS);
    }

    static void a(View r11, float r12) {
        int r0 = ZeusTransformUtils.getResources(r11, "com.obric.memorydata.plugin").getInteger(ZeusTransformUtils.mapRes(com.obric.memorydata.plugin.R.integer.app_bar_elevation_anim_duration, TypedValues.Custom.S_INT, "app_bar_elevation_anim_duration"));
        StateListAnimator r1 = new StateListAnimator();
        long r9 = r0;
        r1.addState(new int[]{R.attr.state_enabled, ZeusTransformUtils.mapRes(com.obric.memorydata.plugin.R.attr.state_liftable, "attr", "state_liftable"), -ZeusTransformUtils.mapRes(com.obric.memorydata.plugin.R.attr.state_lifted, "attr", "state_lifted")}, ObjectAnimator.ofFloat(r11, "elevation", new float[]{0.0f}).setDuration(r9));
        r1.addState(new int[]{R.attr.state_enabled}, ObjectAnimator.ofFloat(r11, "elevation", new float[]{r12}).setDuration(r9));
        r1.addState(new int[0], ObjectAnimator.ofFloat(r11, "elevation", new float[]{0.0f}).setDuration(0));
        r11.setStateListAnimator(r1);
    }

    static void a(View r8, AttributeSet r9, int r10, int r11) {
        AttributeSet r3 = (AttributeSet) ZeusTransformUtils.wrapperContextForParams(r9, AttributeSet.class, "com.obric.memorydata.plugin");
        Context r12 = (Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(r8.getContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin");
        TypedArray r13 = k.a(r12, r3, f3774a, r10, r11, new int[0]);
    L8:
        th = move-exception;
        r13.recycle();
        throw th;
    L4:
        if (r13.hasValue(0) == false) goto L6;
        r8.setStateListAnimator(AnimatorInflater.loadStateListAnimator(r12, r13.getResourceId(0, 0)));     // Catch: Throwable -> L8
    L6:
        r13.recycle();
    }
}
