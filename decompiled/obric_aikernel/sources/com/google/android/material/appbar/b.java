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
import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import com.google.android.material.internal.k;
import q5.g;

/* JADX INFO: loaded from: classes.dex */
@RequiresApi(21)
class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final int[] f2991a = null;

    static {
        f2991a = new int[]{R.attr.stateListAnimator};
    }

    static void a(@NonNull View r10) {
        r10.setOutlineProvider(ViewOutlineProvider.BOUNDS);
    }

    static void b(@NonNull View r11, float r12) {
        int r10 = r11.getResources().getInteger(g.app_bar_elevation_anim_duration);
        StateListAnimator r13 = new StateListAnimator();
        long r14 = r10;
        r13.addState(new int[]{R.attr.state_enabled, q5.b.state_liftable, -q5.b.state_lifted}, ObjectAnimator.ofFloat(r11, "elevation", new float[]{0.0f}).setDuration(r14));
        r13.addState(new int[]{R.attr.state_enabled}, ObjectAnimator.ofFloat(r11, "elevation", new float[]{r12}).setDuration(r14));
        r13.addState(new int[0], ObjectAnimator.ofFloat(r11, "elevation", new float[]{0.0f}).setDuration(0));
        r11.setStateListAnimator(r13);
    }

    static void c(@NonNull View r10, AttributeSet r11, int r12, int r13) {
        Context r14 = r10.getContext();
        TypedArray r15 = k.h(r14, r11, f2991a, r12, r13, new int[0]);
    L8:
        th = move-exception;
        r15.recycle();
        throw th;
    L4:
        if (r15.hasValue(0) == false) goto L6;
        r10.setStateListAnimator(AnimatorInflater.loadStateListAnimator(r14, r15.getResourceId(0, 0)));     // Catch: Throwable -> L8
    L6:
        r15.recycle();
    }
}
