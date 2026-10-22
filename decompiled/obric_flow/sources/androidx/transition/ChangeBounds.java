package androidx.transition;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.content.res.TypedArray;
import android.content.res.XmlResourceParser;
import android.graphics.PointF;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.util.Property;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.content.res.TypedArrayUtils;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
public class ChangeBounds extends Transition {
    private static final Property<View, PointF> BOTTOM_RIGHT_ONLY_PROPERTY = null;
    private static final Property<ViewBounds, PointF> BOTTOM_RIGHT_PROPERTY = null;
    private static final Property<View, PointF> POSITION_PROPERTY = null;
    private static final String PROPNAME_BOUNDS = "android:changeBounds:bounds";
    private static final String PROPNAME_CLIP = "android:changeBounds:clip";
    private static final String PROPNAME_PARENT = "android:changeBounds:parent";
    private static final String PROPNAME_WINDOW_X = "android:changeBounds:windowX";
    private static final String PROPNAME_WINDOW_Y = "android:changeBounds:windowY";
    private static final Property<View, PointF> TOP_LEFT_ONLY_PROPERTY = null;
    private static final Property<ViewBounds, PointF> TOP_LEFT_PROPERTY = null;
    private static final RectEvaluator sRectEvaluator = null;
    private static final String[] sTransitionProperties = null;
    private boolean mResizeClip;

    public static class ClipListener extends AnimatorListenerAdapter implements Transition.TransitionListener {
        private final int mEndBottom;
        private final Rect mEndClip;
        private final boolean mEndClipIsNull;
        private final int mEndLeft;
        private final int mEndRight;
        private final int mEndTop;
        private boolean mIsCanceled;
        private final int mStartBottom;
        private final Rect mStartClip;
        private final boolean mStartClipIsNull;
        private final int mStartLeft;
        private final int mStartRight;
        private final int mStartTop;
        private final View mView;

        public ClipListener(View r5, Rect r10, boolean r11, Rect r12, boolean r13, int r14, int r15, int r16, int r17, int r18, int r19, int r110, int r111) {
            this.mView = r5;
            this.mStartClip = r10;
            this.mStartClipIsNull = r11;
            this.mEndClip = r12;
            this.mEndClipIsNull = r13;
            this.mStartLeft = r14;
            this.mStartTop = r15;
            this.mStartRight = r16;
            this.mStartBottom = r17;
            this.mEndLeft = r18;
            this.mEndTop = r19;
            this.mEndRight = r110;
            this.mEndBottom = r111;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator r5) {
            onAnimationEnd(r5, false);
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator r5) {
            onAnimationStart(r5, false);
        }

        @Override // androidx.transition.Transition.TransitionListener
        public void onTransitionCancel(@NonNull Transition r5) {
            this.mIsCanceled = true;
        }

        @Override // androidx.transition.Transition.TransitionListener
        public void onTransitionEnd(@NonNull Transition r5) {
        }

        @Override // androidx.transition.Transition.TransitionListener
        public void onTransitionPause(@NonNull Transition r5) {
            Rect r10 = this.mView.getClipBounds();
            this.mView.setTag(R.id.transition_clip, r10);
            if (this.mEndClipIsNull == false) goto L5;
            Rect r11 = null;
        L6:
            this.mView.setClipBounds(r11);
            return;
        L5:
            r11 = this.mEndClip;
            goto L6
        }

        @Override // androidx.transition.Transition.TransitionListener
        public void onTransitionResume(@NonNull Transition r5) {
            Rect r10 = (Rect) this.mView.getTag(R.id.transition_clip);
            this.mView.setTag(R.id.transition_clip, null);
            this.mView.setClipBounds(r10);
        }

        @Override // androidx.transition.Transition.TransitionListener
        public void onTransitionStart(@NonNull Transition r5) {
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator r5, boolean r10) {
            if (this.mIsCanceled == false) goto L5;
            return;
        L5:
            Rect r11 = null;
            if (r10 == false) goto L12;
            if (this.mStartClipIsNull == true) goto L15;
            r11 = this.mStartClip;
        L15:
            this.mView.setClipBounds(r11);
            if (r10 == false) goto L18;
            ViewUtils.setLeftTopRightBottom(this.mView, this.mStartLeft, this.mStartTop, this.mStartRight, this.mStartBottom);
            return;
        L18:
            ViewUtils.setLeftTopRightBottom(this.mView, this.mEndLeft, this.mEndTop, this.mEndRight, this.mEndBottom);
            return;
        L12:
            if (this.mEndClipIsNull == true) goto L15;
            r11 = this.mEndClip;
            goto L15
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator r5, boolean r10) {
            int r11 = Math.max(this.mStartRight - this.mStartLeft, this.mEndRight - this.mEndLeft);
            int r12 = Math.max(this.mStartBottom - this.mStartTop, this.mEndBottom - this.mEndTop);
            if (r10 == false) goto L5;
            int r13 = this.mEndLeft;
        L6:
            if (r10 == false) goto L8;
            int r14 = this.mEndTop;
        L9:
            ViewUtils.setLeftTopRightBottom(this.mView, r13, r14, r11 + r13, r12 + r14);
            if (r10 == false) goto L12;
            Rect r15 = this.mEndClip;
        L13:
            this.mView.setClipBounds(r15);
            return;
        L12:
            r15 = this.mStartClip;
            goto L13
        L8:
            r14 = this.mStartTop;
            goto L9
        L5:
            r13 = this.mStartLeft;
            goto L6
        }
    }

    public static class SuppressLayoutListener extends TransitionListenerAdapter {
        boolean mCanceled;
        final ViewGroup mParent;

        public SuppressLayoutListener(@NonNull ViewGroup r5) {
            this.mCanceled = false;
            this.mParent = r5;
        }

        @Override // androidx.transition.TransitionListenerAdapter, androidx.transition.Transition.TransitionListener
        public void onTransitionCancel(@NonNull Transition r5) {
            ViewGroupUtils.suppressLayout(this.mParent, false);
            this.mCanceled = true;
        }

        @Override // androidx.transition.TransitionListenerAdapter, androidx.transition.Transition.TransitionListener
        public void onTransitionEnd(@NonNull Transition r5) {
            if (this.mCanceled == true) goto L5;
            ViewGroupUtils.suppressLayout(this.mParent, false);
        L5:
            r5.removeListener(this);
        }

        @Override // androidx.transition.TransitionListenerAdapter, androidx.transition.Transition.TransitionListener
        public void onTransitionPause(@NonNull Transition r5) {
            ViewGroupUtils.suppressLayout(this.mParent, false);
        }

        @Override // androidx.transition.TransitionListenerAdapter, androidx.transition.Transition.TransitionListener
        public void onTransitionResume(@NonNull Transition r5) {
            ViewGroupUtils.suppressLayout(this.mParent, true);
        }
    }

    public static class ViewBounds {
        private int mBottom;
        private int mBottomRightCalls;
        private int mLeft;
        private int mRight;
        private int mTop;
        private int mTopLeftCalls;
        private final View mView;

        public ViewBounds(View r5) {
            this.mView = r5;
        }

        private void setLeftTopRightBottom() {
            ViewUtils.setLeftTopRightBottom(this.mView, this.mLeft, this.mTop, this.mRight, this.mBottom);
            this.mTopLeftCalls = 0;
            this.mBottomRightCalls = 0;
        }

        public void setBottomRight(PointF r5) {
            this.mRight = Math.round(r5.x);
            this.mBottom = Math.round(r5.y);
            int r10 = this.mBottomRightCalls + 1;
            this.mBottomRightCalls = r10;
            if (this.mTopLeftCalls != r10) goto L6;
            setLeftTopRightBottom();
            return;
        }

        public void setTopLeft(PointF r5) {
            this.mLeft = Math.round(r5.x);
            this.mTop = Math.round(r5.y);
            int r10 = this.mTopLeftCalls + 1;
            this.mTopLeftCalls = r10;
            if (r10 != this.mBottomRightCalls) goto L6;
            setLeftTopRightBottom();
            return;
        }
    }

    static {
        sTransitionProperties = new String[]{PROPNAME_BOUNDS, PROPNAME_CLIP, PROPNAME_PARENT, PROPNAME_WINDOW_X, PROPNAME_WINDOW_Y};
        final Class<PointF> r5 = PointF.class;
        final String r10 = "topLeft";
        TOP_LEFT_PROPERTY = new AnonymousClass1(r5, r10);
        final String r11 = "bottomRight";
        BOTTOM_RIGHT_PROPERTY = new AnonymousClass2(r5, r11);
        BOTTOM_RIGHT_ONLY_PROPERTY = new AnonymousClass3(r5, r11);
        TOP_LEFT_ONLY_PROPERTY = new AnonymousClass4(r5, r10);
        final String r12 = "position";
        POSITION_PROPERTY = new AnonymousClass5(r5, r12);
        sRectEvaluator = new RectEvaluator();
    }

    public ChangeBounds() {
        this.mResizeClip = false;
    }

    private void captureValues(TransitionValues r10) {
        View r5 = r10.view;
        if (r5.isLaidOut() == false) goto L5;
    L8:
        r10.values.put(PROPNAME_BOUNDS, new Rect(r5.getLeft(), r5.getTop(), r5.getRight(), r5.getBottom()));
        r10.values.put(PROPNAME_PARENT, r10.view.getParent());
        if (this.mResizeClip == false) goto L13;
        r10.values.put(PROPNAME_CLIP, r5.getClipBounds());
        return;
    L13:
        return;
    L5:
        if (r5.getWidth() != 0) goto L8;
        if (r5.getHeight() != 0) goto L8;
    }

    @Override // androidx.transition.Transition
    public void captureEndValues(@NonNull TransitionValues r5) {
        captureValues(r5);
    }

    @Override // androidx.transition.Transition
    public void captureStartValues(@NonNull TransitionValues r5) {
        captureValues(r5);
        if (this.mResizeClip == false) goto L8;
        Rect r10 = (Rect) r5.view.getTag(R.id.transition_clip);
        if (r10 == null) goto L9;
        r5.values.put(PROPNAME_CLIP, r10);
        return;
    L9:
        return;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // androidx.transition.Transition
    @Nullable
    public Animator createAnimator(@NonNull ViewGroup r25, @Nullable TransitionValues r26, @Nullable TransitionValues r27) {
        if (r26 == null) goto L5;
        if (r27 == null) goto L5;
        Map<String, Object> r10 = r26.values;
        Map<String, Object> r11 = r27.values;
        ViewGroup r12 = (ViewGroup) r10.get(PROPNAME_PARENT);
        ViewGroup r13 = (ViewGroup) r11.get(PROPNAME_PARENT);
        if (r12 == null) goto L9;
        if (r13 == null) goto L9;
        View r14 = r27.view;
        Rect r15 = (Rect) r26.values.get(PROPNAME_BOUNDS);
        Rect r16 = (Rect) r27.values.get(PROPNAME_BOUNDS);
        int r17 = r15.left;
        int r18 = r16.left;
        int r19 = r15.top;
        int r110 = r16.top;
        int r111 = r15.right;
        int r112 = r16.right;
        int r20 = r15.bottom;
        int r21 = r16.bottom;
        int r22 = r111 - r17;
        int r5 = r20 - r19;
        int r23 = r112 - r18;
        int r24 = r21 - r110;
        Rect r28 = (Rect) r26.values.get(PROPNAME_CLIP);
        Rect r29 = (Rect) r27.values.get(PROPNAME_CLIP);
        if (r22 == 0) goto L13;
        if (r5 == 0) goto L13;
    L15:
        if (r17 != r18) goto L19;
        if (r19 != r110) goto L19;
        int r30 = 0;
    L20:
        if (r111 != r112) goto L22;
        if (r20 != r21) goto L22;
    L24:
        if (r28 != null) goto L26;
    L29:
        if (r28 != null) goto L33;
        if (r29 == null) goto L33;
    L32:
        r30 = r30 + 1;
    L33:
        if (r30 > 0) goto L35;
        return null;
    L35:
        if (this.mResizeClip == true) goto L47;
        View r31 = r14;
        ViewUtils.setLeftTopRightBottom(r31, r17, r19, r111, r20);
        if (r30 != 2) goto L42;
        if (r22 != r23) goto L41;
        if (r5 != r24) goto L41;
        Animator r32 = ObjectAnimatorUtils.ofPointF(r31, POSITION_PROPERTY, getPathMotion().getPath(r17, r19, r18, r110));
    L72:
        if ((r31.getParent() instanceof ViewGroup) == false) goto L74;
        ViewGroup r33 = (ViewGroup) r31.getParent();
        ViewGroupUtils.suppressLayout(r33, true);
        getRootTransition().addListener(new SuppressLayoutListener(r33));
    L74:
        return r32;
    L41:
        final ViewBounds r34 = new ViewBounds(r31);
        ObjectAnimator r35 = ObjectAnimatorUtils.ofPointF(r34, TOP_LEFT_PROPERTY, getPathMotion().getPath(r17, r19, r18, r110));
        ObjectAnimator r36 = ObjectAnimatorUtils.ofPointF(r34, BOTTOM_RIGHT_PROPERTY, getPathMotion().getPath(r111, r20, r112, r21));
        AnimatorSet r37 = new AnimatorSet();
        r37.playTogether(new Animator[]{r35, r36});
        r37.addListener(new AnonymousClass6(this, r34));
        r32 = r37;
        goto L72
    L42:
        if (r17 != r18) goto L46;
        if (r19 != r110) goto L46;
        r32 = ObjectAnimatorUtils.ofPointF(r31, BOTTOM_RIGHT_ONLY_PROPERTY, getPathMotion().getPath(r111, r20, r112, r21));
    L46:
        r32 = ObjectAnimatorUtils.ofPointF(r31, TOP_LEFT_ONLY_PROPERTY, getPathMotion().getPath(r17, r19, r18, r110));
        goto L72
    L47:
        r31 = r14;
        ViewUtils.setLeftTopRightBottom(r31, r17, r19, Math.max(r22, r23) + r17, r19 + Math.max(r5, r24));
        if (r17 != r18) goto L52;
        if (r19 != r110) goto L52;
        ObjectAnimator r38 = null;
    L53:
        if (r28 != null) goto L55;
        boolean r113 = true;
    L56:
        if (r113 == false) goto L59;
        int r39 = 0;
        r28 = new Rect(0, 0, r22, r5);
    L58:
        Rect r114 = r28;
        if (r29 != null) goto L62;
        int r40 = 1;
    L63:
        if (r40 == 0) goto L65;
        Rect r41 = new Rect(r39, r39, r23, r24);
    L67:
        if (r114.equals(r41) == true) goto L69;
        r31.setClipBounds(r114);
        ObjectAnimator r42 = ObjectAnimator.ofObject(r31, "clipBounds", sRectEvaluator, new Object[]{r114, r41});
        ClipListener r43 = new ClipListener(r31, r114, r113, r41, r40, r17, r19, r111, r20, r18, r110, r112, r21);
        r42.addListener(r43);
        addListener(r43);
    L70:
        r32 = TransitionUtils.mergeAnimators(r38, r42);
        goto L72
    L69:
        r42 = null;
        goto L70
    L65:
        r41 = r29;
        goto L67
    L62:
        r40 = r39;
        goto L63
    L59:
        r39 = 0;
        goto L58
    L55:
        r113 = false;
    L52:
        r38 = ObjectAnimatorUtils.ofPointF(r31, POSITION_PROPERTY, getPathMotion().getPath(r17, r19, r18, r110));
        goto L53
    L26:
        if (r28.equals(r29) == false) goto L32;
    L22:
        r30 = r30 + 1;
    L19:
        r30 = 1;
    L13:
        if (r23 == 0) goto L23;
        if (r24 != 0) goto L15;
    L23:
        r30 = 0;
    L9:
        return null;
    L5:
        return null;
    }

    public boolean getResizeClip() {
        return this.mResizeClip;
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

    public void setResizeClip(boolean r5) {
        this.mResizeClip = r5;
    }

    public ChangeBounds(@NonNull Context r5, @NonNull AttributeSet r10) {
        super(r5, r10);
        this.mResizeClip = false;
        TypedArray r11 = r5.obtainStyledAttributes(r10, Styleable.CHANGE_BOUNDS);
        boolean r12 = TypedArrayUtils.getNamedBoolean(r11, (XmlResourceParser) r10, "resizeClip", 0, false);
        r11.recycle();
        setResizeClip(r12);
    }
}
