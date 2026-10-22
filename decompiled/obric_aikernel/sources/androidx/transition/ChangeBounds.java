package androidx.transition;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.animation.PropertyValuesHolder;
import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.TypedArray;
import android.content.res.XmlResourceParser;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Path;
import android.graphics.PointF;
import android.graphics.Rect;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.util.Property;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.content.res.TypedArrayUtils;
import androidx.core.view.ViewCompat;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
public class ChangeBounds extends Transition {
    private static final Property<View, PointF> BOTTOM_RIGHT_ONLY_PROPERTY = null;
    private static final Property<ViewBounds, PointF> BOTTOM_RIGHT_PROPERTY = null;
    private static final Property<Drawable, PointF> DRAWABLE_ORIGIN_PROPERTY = null;
    private static final Property<View, PointF> POSITION_PROPERTY = null;
    private static final String PROPNAME_BOUNDS = "android:changeBounds:bounds";
    private static final String PROPNAME_CLIP = "android:changeBounds:clip";
    private static final String PROPNAME_PARENT = "android:changeBounds:parent";
    private static final String PROPNAME_WINDOW_X = "android:changeBounds:windowX";
    private static final String PROPNAME_WINDOW_Y = "android:changeBounds:windowY";
    private static final Property<View, PointF> TOP_LEFT_ONLY_PROPERTY = null;
    private static final Property<ViewBounds, PointF> TOP_LEFT_PROPERTY = null;
    private static RectEvaluator sRectEvaluator;
    private static final String[] sTransitionProperties = null;
    private boolean mReparent;
    private boolean mResizeClip;
    private int[] mTempLocation;

    private static class ViewBounds {
        private int mBottom;
        private int mBottomRightCalls;
        private int mLeft;
        private int mRight;
        private int mTop;
        private int mTopLeftCalls;
        private View mView;

        ViewBounds(View r10) {
            this.mView = r10;
        }

        private void setLeftTopRightBottom() {
            ViewUtils.setLeftTopRightBottom(this.mView, this.mLeft, this.mTop, this.mRight, this.mBottom);
            this.mTopLeftCalls = 0;
            this.mBottomRightCalls = 0;
        }

        void setBottomRight(PointF r10) {
            this.mRight = Math.round(r10.x);
            this.mBottom = Math.round(r10.y);
            int r11 = this.mBottomRightCalls + 1;
            this.mBottomRightCalls = r11;
            if (this.mTopLeftCalls != r11) goto L6;
            setLeftTopRightBottom();
            return;
        }

        void setTopLeft(PointF r10) {
            this.mLeft = Math.round(r10.x);
            this.mTop = Math.round(r10.y);
            int r11 = this.mTopLeftCalls + 1;
            this.mTopLeftCalls = r11;
            if (r11 != this.mBottomRightCalls) goto L6;
            setLeftTopRightBottom();
            return;
        }
    }

    static {
        sTransitionProperties = new String[]{PROPNAME_BOUNDS, PROPNAME_CLIP, PROPNAME_PARENT, PROPNAME_WINDOW_X, PROPNAME_WINDOW_Y};
        final Class<PointF> r10 = PointF.class;
        final String r11 = "boundsOrigin";
        DRAWABLE_ORIGIN_PROPERTY = new AnonymousClass1(r10, r11);
        final Class<PointF> r12 = PointF.class;
        final String r13 = "topLeft";
        TOP_LEFT_PROPERTY = new AnonymousClass2(r12, r13);
        final Class<PointF> r14 = PointF.class;
        final String r15 = "bottomRight";
        BOTTOM_RIGHT_PROPERTY = new AnonymousClass3(r14, r15);
        final Class<PointF> r16 = PointF.class;
        BOTTOM_RIGHT_ONLY_PROPERTY = new AnonymousClass4(r16, r15);
        final Class<PointF> r17 = PointF.class;
        TOP_LEFT_ONLY_PROPERTY = new AnonymousClass5(r17, r13);
        final Class<PointF> r18 = PointF.class;
        final String r19 = "position";
        POSITION_PROPERTY = new AnonymousClass6(r18, r19);
        sRectEvaluator = new RectEvaluator();
    }

    public ChangeBounds() {
        this.mTempLocation = new int[2];
        this.mResizeClip = false;
        this.mReparent = false;
    }

    @SuppressLint({"RestrictedApi"})
    public ChangeBounds(Context r10, AttributeSet r11) {
        super(r10, r11);
        this.mTempLocation = new int[2];
        this.mResizeClip = false;
        this.mReparent = false;
        TypedArray r12 = r10.obtainStyledAttributes(r11, Styleable.CHANGE_BOUNDS);
        boolean r13 = TypedArrayUtils.getNamedBoolean(r12, (XmlResourceParser) r11, "resizeClip", 0, false);
        r12.recycle();
        setResizeClip(r13);
    }

    private void captureValues(TransitionValues r10) {
        View r11 = r10.view;
        if (ViewCompat.isLaidOut(r11) == false) goto L5;
    L8:
        r10.values.put(PROPNAME_BOUNDS, new Rect(r11.getLeft(), r11.getTop(), r11.getRight(), r11.getBottom()));
        r10.values.put(PROPNAME_PARENT, r10.view.getParent());
        if (this.mReparent == false) goto L12;
        r10.view.getLocationInWindow(this.mTempLocation);
        r10.values.put(PROPNAME_WINDOW_X, Integer.valueOf(this.mTempLocation[0]));
        r10.values.put(PROPNAME_WINDOW_Y, Integer.valueOf(this.mTempLocation[1]));
    L12:
        if (this.mResizeClip == false) goto L16;
        r10.values.put(PROPNAME_CLIP, ViewCompat.getClipBounds(r11));
        return;
    L16:
        return;
    L5:
        if (r11.getWidth() != 0) goto L8;
        if (r11.getHeight() != 0) goto L8;
    }

    private boolean parentMatches(View r10, View r11) {
        if (this.mReparent == false) goto L11;
        TransitionValues r12 = getMatchedTransitionValues(r10, true);
        if (r12 != null) goto L10;
        if (r10 != r11) goto L12;
        return true;
    L12:
        return false;
    L10:
        if (r11 != r12.view) goto L12;
        return true;
    L11:
        return true;
    }

    @Override // androidx.transition.Transition
    public void captureEndValues(@NonNull TransitionValues r10) {
        captureValues(r10);
    }

    @Override // androidx.transition.Transition
    public void captureStartValues(@NonNull TransitionValues r10) {
        captureValues(r10);
    }

    @Override // androidx.transition.Transition
    @Nullable
    public Animator createAnimator(@NonNull final ViewGroup r19, @Nullable TransitionValues r20, @Nullable TransitionValues r21) {
        if (r20 == null) goto L78;
        if (r21 == null) goto L82;
        Map<String, Object> r10 = r20.values;
        Map<String, Object> r11 = r21.values;
        ViewGroup r12 = (ViewGroup) r10.get(PROPNAME_PARENT);
        ViewGroup r13 = (ViewGroup) r11.get(PROPNAME_PARENT);
        if (r12 == null) goto L76;
        if (r13 == null) goto L81;
        final View r14 = r21.view;
        if (parentMatches(r12, r13) == false) goto L68;
        Rect r15 = (Rect) r20.values.get(PROPNAME_BOUNDS);
        Rect r16 = (Rect) r21.values.get(PROPNAME_BOUNDS);
        int r17 = r15.left;
        final int r18 = r16.left;
        int r110 = r15.top;
        final int r111 = r16.top;
        int r112 = r15.right;
        final int r113 = r16.right;
        int r22 = r15.bottom;
        final int r114 = r16.bottom;
        int r23 = r112 - r17;
        int r24 = r22 - r110;
        int r115 = r113 - r18;
        int r25 = r114 - r111;
        Rect r26 = (Rect) r20.values.get(PROPNAME_CLIP);
        final Rect r27 = (Rect) r21.values.get(PROPNAME_CLIP);
        if (r23 == 0) goto L15;
        if (r24 == 0) goto L15;
    L17:
        if (r17 != r18) goto L21;
        if (r110 != r111) goto L21;
        int r28 = 0;
    L22:
        if (r112 != r113) goto L24;
        if (r22 != r114) goto L24;
    L26:
        if (r26 != null) goto L28;
    L29:
        if (r26 != null) goto L32;
        if (r27 == null) goto L32;
    L31:
        r28 = r28 + 1;
    L32:
        if (r28 > 0) goto L34;
        return null;
    L34:
        if (this.mResizeClip == true) goto L47;
        final View r29 = r14;
        ViewUtils.setLeftTopRightBottom(r29, r17, r110, r112, r22);
        if (r28 != 2) goto L41;
        if (r23 != r115) goto L40;
        if (r24 != r25) goto L40;
        Path r30 = getPathMotion().getPath(r17, r110, r18, r111);
        Property<View, PointF> r31 = POSITION_PROPERTY;
    L46:
        Animator r32 = ObjectAnimatorUtils.ofPointF(r29, r31, r30);
    L65:
        if ((r29.getParent() instanceof ViewGroup) == false) goto L67;
        final ViewGroup r33 = (ViewGroup) r29.getParent();
        ViewGroupUtils.suppressLayout(r33, true);
        addListener(new AnonymousClass9(this, r33));
    L67:
        return r32;
    L40:
        final ViewBounds r34 = new ViewBounds(r29);
        ObjectAnimator r35 = ObjectAnimatorUtils.ofPointF(r34, TOP_LEFT_PROPERTY, getPathMotion().getPath(r17, r110, r18, r111));
        ObjectAnimator r36 = ObjectAnimatorUtils.ofPointF(r34, BOTTOM_RIGHT_PROPERTY, getPathMotion().getPath(r112, r22, r113, r114));
        AnimatorSet r37 = new AnimatorSet();
        r37.playTogether(new Animator[]{r35, r36});
        r37.addListener(new AnonymousClass7(this, r34));
        r32 = r37;
        goto L65
    L41:
        if (r17 != r18) goto L45;
        if (r110 != r111) goto L45;
        r30 = getPathMotion().getPath(r112, r22, r113, r114);
        r31 = BOTTOM_RIGHT_ONLY_PROPERTY;
    L45:
        r30 = getPathMotion().getPath(r17, r110, r18, r111);
        r31 = TOP_LEFT_ONLY_PROPERTY;
        goto L46
    L47:
        r29 = r14;
        ViewUtils.setLeftTopRightBottom(r29, r17, r110, Math.max(r23, r115) + r17, Math.max(r24, r25) + r110);
        if (r17 != r18) goto L52;
        if (r110 != r111) goto L52;
        ObjectAnimator r116 = null;
    L53:
        if (r26 != null) goto L55;
        int r38 = 0;
        Rect r39 = new Rect(0, 0, r23, r24);
    L56:
        if (r27 != null) goto L58;
        Rect r40 = new Rect(r38, r38, r115, r25);
    L60:
        if (r39.equals(r40) == true) goto L62;
        ViewCompat.setClipBounds(r29, r39);
        RectEvaluator r41 = sRectEvaluator;
        Object[] r42 = new Object[2];
        r42[r38] = r39;
        r42[1] = r40;
        ObjectAnimator r117 = ObjectAnimator.ofObject(r29, "clipBounds", r41, r42);
        r117.addListener(new AnonymousClass8(this, r29, r27, r18, r111, r113, r114));
        ObjectAnimator r43 = r117;
    L63:
        r32 = TransitionUtils.mergeAnimators(r116, r43);
        goto L65
    L62:
        r43 = null;
        goto L63
    L58:
        r40 = r27;
        goto L60
    L55:
        r38 = 0;
        r39 = r26;
    L52:
        r116 = ObjectAnimatorUtils.ofPointF(r29, POSITION_PROPERTY, getPathMotion().getPath(r17, r110, r18, r111));
        goto L53
    L28:
        if (r26.equals(r27) == false) goto L31;
    L24:
        r28 = r28 + 1;
    L21:
        r28 = 1;
    L15:
        if (r115 == 0) goto L25;
        if (r25 != 0) goto L17;
    L25:
        r28 = 0;
        goto L26
    L68:
        int r44 = ((Integer) r20.values.get(PROPNAME_WINDOW_X)).intValue();
        int r45 = ((Integer) r20.values.get(PROPNAME_WINDOW_Y)).intValue();
        int r46 = ((Integer) r21.values.get(PROPNAME_WINDOW_X)).intValue();
        int r47 = ((Integer) r21.values.get(PROPNAME_WINDOW_Y)).intValue();
        if (r44 != r46) goto L74;
        if (r45 != r47) goto L74;
        return null;
    L74:
        r19.getLocationInWindow(this.mTempLocation);
        Bitmap r48 = Bitmap.createBitmap(r14.getWidth(), r14.getHeight(), Bitmap.Config.ARGB_8888);
        r14.draw(new Canvas(r48));
        final BitmapDrawable r49 = new BitmapDrawable(r48);
        final float r50 = ViewUtils.getTransitionAlpha(r14);
        ViewUtils.setTransitionAlpha(r14, 0.0f);
        ViewUtils.getOverlay(r19).add(r49);
        PathMotion r51 = getPathMotion();
        int[] r118 = this.mTempLocation;
        ObjectAnimator r119 = ObjectAnimator.ofPropertyValuesHolder(r49, new PropertyValuesHolder[]{PropertyValuesHolderUtils.ofPointF(DRAWABLE_ORIGIN_PROPERTY, r51.getPath(r44 - r118[0], r45 - r118[1], r46 - r118[0], r47 - r118[1]))});
        r119.addListener(new AnonymousClass10(this, r19, r49, r14, r50));
        return r119;
    L81:
        return null;
    L76:
        return null;
    L82:
        return null;
    L78:
        return null;
    }

    public boolean getResizeClip() {
        return this.mResizeClip;
    }

    @Override // androidx.transition.Transition
    @Nullable
    public String[] getTransitionProperties() {
        return sTransitionProperties;
    }

    public void setResizeClip(boolean r10) {
        this.mResizeClip = r10;
    }
}
