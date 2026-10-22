package androidx.transition;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

/* JADX INFO: loaded from: classes.dex */
public class ChangeClipBounds extends Transition {
    static final Rect NULL_SENTINEL = null;
    private static final String PROPNAME_BOUNDS = "android:clipBounds:bounds";
    private static final String PROPNAME_CLIP = "android:clipBounds:clip";
    private static final String[] sTransitionProperties = null;

    public static class Listener extends AnimatorListenerAdapter implements Transition.TransitionListener {
        private final Rect mEnd;
        private final Rect mStart;
        private final View mView;

        public Listener(View r5, Rect r10, Rect r11) {
            this.mView = r5;
            this.mStart = r10;
            this.mEnd = r11;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator r5) {
            onAnimationEnd(r5, false);
        }

        @Override // androidx.transition.Transition.TransitionListener
        public void onTransitionCancel(@NonNull Transition r5) {
        }

        @Override // androidx.transition.Transition.TransitionListener
        public void onTransitionEnd(@NonNull Transition r5) {
        }

        @Override // androidx.transition.Transition.TransitionListener
        public void onTransitionPause(@NonNull Transition r5) {
            Rect r10 = this.mView.getClipBounds();
            if (r10 != null) goto L5;
            r10 = ChangeClipBounds.NULL_SENTINEL;
        L5:
            this.mView.setTag(R.id.transition_clip, r10);
            this.mView.setClipBounds(this.mEnd);
        }

        @Override // androidx.transition.Transition.TransitionListener
        public void onTransitionResume(@NonNull Transition r5) {
            Rect r10 = (Rect) this.mView.getTag(R.id.transition_clip);
            this.mView.setClipBounds(r10);
            this.mView.setTag(R.id.transition_clip, null);
        }

        @Override // androidx.transition.Transition.TransitionListener
        public void onTransitionStart(@NonNull Transition r5) {
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator r5, boolean r10) {
            if (r10 == true) goto L4;
            this.mView.setClipBounds(this.mEnd);
            return;
        L4:
            this.mView.setClipBounds(this.mStart);
        }
    }

    static {
        sTransitionProperties = new String[]{PROPNAME_CLIP};
        NULL_SENTINEL = new Rect();
    }

    public ChangeClipBounds() {
    }

    private void captureValues(TransitionValues r5, boolean r10) {
        View r11 = r5.view;
        if (r11.getVisibility() != 8) goto L5;
        return;
    L5:
        Rect r12 = null;
        if (r10 == false) goto L8;
        Rect r13 = (Rect) r11.getTag(R.id.transition_clip);
    L9:
        if (r13 != null) goto L12;
        r13 = r11.getClipBounds();
    L12:
        if (r13 == NULL_SENTINEL) goto L15;
        r12 = r13;
    L15:
        r5.values.put(PROPNAME_CLIP, r12);
        if (r12 != null) goto L19;
        r5.values.put(PROPNAME_BOUNDS, new Rect(0, 0, r11.getWidth(), r11.getHeight()));
        return;
    L19:
        return;
    L8:
        r13 = null;
        goto L9
    }

    @Override // androidx.transition.Transition
    public void captureEndValues(@NonNull TransitionValues r5) {
        captureValues(r5, false);
    }

    @Override // androidx.transition.Transition
    public void captureStartValues(@NonNull TransitionValues r5) {
        captureValues(r5, true);
    }

    @Override // androidx.transition.Transition
    @Nullable
    public Animator createAnimator(@NonNull ViewGroup r10, @Nullable TransitionValues r11, @Nullable TransitionValues r12) {
        if (r11 == null) goto L26;
        if (r12 != null) goto L6;
        return null;
    L6:
        if (r11.values.containsKey(PROPNAME_CLIP) == true) goto L8;
        return null;
    L8:
        if (r12.values.containsKey(PROPNAME_CLIP) == false) goto L29;
        Rect r5 = (Rect) r11.values.get(PROPNAME_CLIP);
        Rect r13 = (Rect) r12.values.get(PROPNAME_CLIP);
        if (r5 != null) goto L15;
        if (r13 != null) goto L15;
        return null;
    L15:
        if (r5 != null) goto L17;
        Rect r14 = (Rect) r11.values.get(PROPNAME_BOUNDS);
    L18:
        if (r13 != null) goto L20;
        Rect r15 = (Rect) r12.values.get(PROPNAME_BOUNDS);
    L22:
        if (r14.equals(r15) == false) goto L24;
        return null;
    L24:
        r12.view.setClipBounds(r5);
        RectEvaluator r16 = new RectEvaluator(new Rect());
        ObjectAnimator r17 = ObjectAnimator.ofObject(r12.view, ViewUtils.CLIP_BOUNDS, r16, new Rect[]{r14, r15});
        Listener r18 = new Listener(r12.view, r5, r13);
        r17.addListener(r18);
        addListener(r18);
        return r17;
    L20:
        r15 = r13;
        goto L22
    L17:
        r14 = r5;
        goto L18
    L29:
        return null;
    L26:
        return null;
    }

    @Override // androidx.transition.Transition
    @NonNull
    public String[] getTransitionProperties() {
        return sTransitionProperties;
    }

    @Override // androidx.transition.Transition
    public boolean isSeekingSupported() {
        return true;
    }

    public ChangeClipBounds(@NonNull Context r5, @NonNull AttributeSet r10) {
        super(r5, r10);
    }
}
