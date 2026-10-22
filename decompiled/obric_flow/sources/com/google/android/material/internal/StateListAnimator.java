package com.google.android.material.internal;

import android.animation.Animator;
import android.animation.ValueAnimator;
import android.util.StateSet;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RestrictTo;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes2.dex */
@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
public final class StateListAnimator {
    private final Animator.AnimatorListener animationListener;

    @Nullable
    private Tuple lastMatch;

    @Nullable
    ValueAnimator runningAnimator;
    private final ArrayList<Tuple> tuples;

    public static class Tuple {
        final ValueAnimator animator;
        final int[] specs;

        public Tuple(int[] r5, ValueAnimator r10) {
            this.specs = r5;
            this.animator = r10;
        }
    }

    public StateListAnimator() {
        this.tuples = new ArrayList();
        this.lastMatch = null;
        this.runningAnimator = null;
        this.animationListener = new AnonymousClass1(this);
    }

    private void cancel() {
        ValueAnimator r5 = this.runningAnimator;
        if (r5 == null) goto L6;
        r5.cancel();
        this.runningAnimator = null;
        return;
    }

    private void start(@NonNull Tuple r5) {
        ValueAnimator r10 = r5.animator;
        this.runningAnimator = r10;
        r10.start();
    }

    public void addState(int[] r5, ValueAnimator r10) {
        Tuple r11 = new Tuple(r5, r10);
        r10.addListener(this.animationListener);
        this.tuples.add(r11);
    }

    public void jumpToCurrentState() {
        ValueAnimator r5 = this.runningAnimator;
        if (r5 == null) goto L6;
        r5.end();
        this.runningAnimator = null;
        return;
    }

    public void setState(int[] r5) {
        int r10 = this.tuples.size();
        int r11 = 0;
    L3:
        if (r11 >= r10) goto L8;
        Tuple r12 = this.tuples.get(r11);
        if (StateSet.stateSetMatches(r12.specs, r5) == true) goto L9;
        r11 = r11 + 1;
    L9:
        Tuple r13 = this.lastMatch;
        if (r12 != r13) goto L12;
        return;
    L12:
        if (r13 == null) goto L14;
        cancel();
    L14:
        this.lastMatch = r12;
        if (r12 == null) goto L20;
        start(r12);
        return;
    L20:
        return;
    L8:
        r12 = null;
        goto L9
    }
}
