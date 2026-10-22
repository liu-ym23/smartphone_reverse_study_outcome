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
import com.google.android.material.internal.ThemeEnforcement;

/* JADX INFO: loaded from: classes2.dex */
@RequiresApi(21)
class ViewUtilsLollipop {
    private static final int[] STATE_LIST_ANIM_ATTRS = null;

    static {
        STATE_LIST_ANIM_ATTRS = new int[]{R.attr.stateListAnimator};
    }

    public ViewUtilsLollipop() {
    }

    public static void setBoundsViewOutlineProvider(@NonNull View r5) {
        r5.setOutlineProvider(ViewOutlineProvider.BOUNDS);
    }

    public static void setDefaultAppBarLayoutStateListAnimator(@NonNull View r11, float r12) {
        int r5 = r11.getResources().getInteger(com.google.android.material.R.integer.app_bar_elevation_anim_duration);
        StateListAnimator r10 = new StateListAnimator();
        long r13 = r5;
        r10.addState(new int[]{R.attr.state_enabled, com.google.android.material.R.attr.state_liftable, -com.google.android.material.R.attr.state_lifted}, ObjectAnimator.ofFloat(r11, "elevation", new float[]{0.0f}).setDuration(r13));
        r10.addState(new int[]{R.attr.state_enabled}, ObjectAnimator.ofFloat(r11, "elevation", new float[]{r12}).setDuration(r13));
        r10.addState(new int[0], ObjectAnimator.ofFloat(r11, "elevation", new float[]{0.0f}).setDuration(0));
        r11.setStateListAnimator(r10);
    }

    public static void setStateListAnimatorFromAttrs(@NonNull View r10, AttributeSet r11, int r12, int r13) {
        Context r14 = r10.getContext();
        TypedArray r15 = ThemeEnforcement.obtainStyledAttributes(r14, r11, STATE_LIST_ANIM_ATTRS, r12, r13, new int[0]);
    L7:
        th = move-exception;
        r15.recycle();
        throw th;
    L4:
        if (r15.hasValue(0) == false) goto L9;
        r10.setStateListAnimator(AnimatorInflater.loadStateListAnimator(r14, r15.getResourceId(0, 0)));     // Catch: Throwable -> L7
    L9:
        r15.recycle();
    }
}
