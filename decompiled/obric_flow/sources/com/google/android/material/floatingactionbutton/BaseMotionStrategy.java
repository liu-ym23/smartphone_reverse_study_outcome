package com.google.android.material.floatingactionbutton;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.content.Context;
import android.view.View;
import androidx.annotation.CallSuper;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.util.Preconditions;
import com.google.android.material.animation.AnimatorSetCompat;
import com.google.android.material.animation.MotionSpec;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
abstract class BaseMotionStrategy implements MotionStrategy {
    private final Context context;

    @Nullable
    private MotionSpec defaultMotionSpec;

    @NonNull
    private final ExtendedFloatingActionButton fab;
    private final ArrayList<Animator.AnimatorListener> listeners;

    @Nullable
    private MotionSpec motionSpec;
    private final AnimatorTracker tracker;

    public BaseMotionStrategy(@NonNull ExtendedFloatingActionButton r5, AnimatorTracker r10) {
        this.listeners = new ArrayList();
        this.fab = r5;
        this.context = r5.getContext();
        this.tracker = r10;
    }

    public static /* synthetic */ ExtendedFloatingActionButton access$000(BaseMotionStrategy r5) {
        return r5.fab;
    }

    @Override // com.google.android.material.floatingactionbutton.MotionStrategy
    public final void addAnimationListener(@NonNull Animator.AnimatorListener r5) {
        this.listeners.add(r5);
    }

    @Override // com.google.android.material.floatingactionbutton.MotionStrategy
    public AnimatorSet createAnimator() {
        return createAnimator(getCurrentMotionSpec());
    }

    @Override // com.google.android.material.floatingactionbutton.MotionStrategy
    public final MotionSpec getCurrentMotionSpec() {
        MotionSpec r5 = this.motionSpec;
        if (r5 == null) goto L6;
        return r5;
    L6:
        if (this.defaultMotionSpec != null) goto L9;
        this.defaultMotionSpec = MotionSpec.createFromResource(this.context, getDefaultMotionSpecResource());
    L9:
        return (MotionSpec) Preconditions.checkNotNull(this.defaultMotionSpec);
    }

    @Override // com.google.android.material.floatingactionbutton.MotionStrategy
    @NonNull
    public final List<Animator.AnimatorListener> getListeners() {
        return this.listeners;
    }

    @Override // com.google.android.material.floatingactionbutton.MotionStrategy
    @Nullable
    public MotionSpec getMotionSpec() {
        return this.motionSpec;
    }

    @Override // com.google.android.material.floatingactionbutton.MotionStrategy
    @CallSuper
    public void onAnimationCancel() {
        this.tracker.clear();
    }

    @Override // com.google.android.material.floatingactionbutton.MotionStrategy
    @CallSuper
    public void onAnimationEnd() {
        this.tracker.clear();
    }

    @Override // com.google.android.material.floatingactionbutton.MotionStrategy
    @CallSuper
    public void onAnimationStart(Animator r5) {
        this.tracker.onNextAnimationStart(r5);
    }

    @Override // com.google.android.material.floatingactionbutton.MotionStrategy
    public final void removeAnimationListener(@NonNull Animator.AnimatorListener r5) {
        this.listeners.remove(r5);
    }

    @Override // com.google.android.material.floatingactionbutton.MotionStrategy
    public final void setMotionSpec(@Nullable MotionSpec r5) {
        this.motionSpec = r5;
    }

    @NonNull
    public AnimatorSet createAnimator(@NonNull MotionSpec r10) {
        ArrayList r5 = new ArrayList();
        if (r10.hasPropertyValues("opacity") == false) goto L6;
        r5.add(r10.getAnimator("opacity", this.fab, View.ALPHA));
    L6:
        if (r10.hasPropertyValues("scale") == false) goto L9;
        r5.add(r10.getAnimator("scale", this.fab, View.SCALE_Y));
        r5.add(r10.getAnimator("scale", this.fab, View.SCALE_X));
    L9:
        if (r10.hasPropertyValues("width") == false) goto L12;
        r5.add(r10.getAnimator("width", this.fab, ExtendedFloatingActionButton.WIDTH));
    L12:
        if (r10.hasPropertyValues("height") == false) goto L15;
        r5.add(r10.getAnimator("height", this.fab, ExtendedFloatingActionButton.HEIGHT));
    L15:
        if (r10.hasPropertyValues("paddingStart") == false) goto L18;
        r5.add(r10.getAnimator("paddingStart", this.fab, ExtendedFloatingActionButton.PADDING_START));
    L18:
        if (r10.hasPropertyValues("paddingEnd") == false) goto L21;
        r5.add(r10.getAnimator("paddingEnd", this.fab, ExtendedFloatingActionButton.PADDING_END));
    L21:
        if (r10.hasPropertyValues("labelOpacity") == false) goto L23;
        final Class<Float> r11 = Float.class;
        final String r12 = "LABEL_OPACITY_PROPERTY";
        r5.add(r10.getAnimator("labelOpacity", this.fab, new AnonymousClass1(this, r11, r12)));
    L23:
        AnimatorSet r13 = new AnimatorSet();
        AnimatorSetCompat.playTogether(r13, r5);
        return r13;
    }
}
