package androidx.transition;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.animation.PropertyValuesHolder;
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
import androidx.core.content.res.TypedArrayUtils;
import androidx.core.view.ViewCompat;
import com.volcengine.zeus.transform.ZeusTransformUtils;
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

        ViewBounds(View r1) {
            this.mView = r1;
        }

        private void setLeftTopRightBottom() {
            ViewUtils.setLeftTopRightBottom(this.mView, this.mLeft, this.mTop, this.mRight, this.mBottom);
            this.mTopLeftCalls = 0;
            this.mBottomRightCalls = 0;
        }

        void setBottomRight(PointF r2) {
            this.mRight = Math.round(r2.x);
            this.mBottom = Math.round(r2.y);
            int r3 = this.mBottomRightCalls + 1;
            this.mBottomRightCalls = r3;
            if (this.mTopLeftCalls != r3) goto L6;
            setLeftTopRightBottom();
            return;
        }

        void setTopLeft(PointF r2) {
            this.mLeft = Math.round(r2.x);
            this.mTop = Math.round(r2.y);
            int r3 = this.mTopLeftCalls + 1;
            this.mTopLeftCalls = r3;
            if (r3 != this.mBottomRightCalls) goto L6;
            setLeftTopRightBottom();
            return;
        }
    }

    static {
        sTransitionProperties = new String[]{PROPNAME_BOUNDS, PROPNAME_CLIP, PROPNAME_PARENT, PROPNAME_WINDOW_X, PROPNAME_WINDOW_Y};
        final Class<PointF> r1 = PointF.class;
        final String r2 = "boundsOrigin";
        DRAWABLE_ORIGIN_PROPERTY = new AnonymousClass1(r1, r2);
        final Class<PointF> r3 = PointF.class;
        final String r4 = "topLeft";
        TOP_LEFT_PROPERTY = new AnonymousClass2(r3, r4);
        final Class<PointF> r5 = PointF.class;
        final String r6 = "bottomRight";
        BOTTOM_RIGHT_PROPERTY = new AnonymousClass3(r5, r6);
        final Class<PointF> r7 = PointF.class;
        BOTTOM_RIGHT_ONLY_PROPERTY = new AnonymousClass4(r7, r6);
        final Class<PointF> r8 = PointF.class;
        TOP_LEFT_ONLY_PROPERTY = new AnonymousClass5(r8, r4);
        final Class<PointF> r9 = PointF.class;
        final String r10 = "position";
        POSITION_PROPERTY = new AnonymousClass6(r9, r10);
        sRectEvaluator = new RectEvaluator();
    }

    public ChangeBounds() {
        this.mTempLocation = new int[2];
        this.mResizeClip = false;
        this.mReparent = false;
    }

    public ChangeBounds(Context r4, AttributeSet r5) {
        Context r6 = (Context) ZeusTransformUtils.wrapperContextForParams(r4, Context.class, "com.obric.memorydata.plugin");
        AttributeSet r7 = (AttributeSet) ZeusTransformUtils.wrapperContextForParams(r5, AttributeSet.class, "com.obric.memorydata.plugin");
        super(r6, r7);
        this.mTempLocation = new int[2];
        this.mResizeClip = false;
        this.mReparent = false;
        TypedArray r8 = r6.obtainStyledAttributes(r7, Styleable.CHANGE_BOUNDS);
        boolean r9 = TypedArrayUtils.getNamedBoolean(r8, (XmlResourceParser) ZeusTransformUtils.preCheckCast(r7, XmlResourceParser.class, "com.obric.memorydata.plugin"), "resizeClip", 0, false);
        r8.recycle();
        setResizeClip(r9);
    }

    private void captureValues(TransitionValues r8) {
        View r0 = r8.view;
        if (ViewCompat.isLaidOut(r0) == false) goto L5;
    L8:
        r8.values.put(PROPNAME_BOUNDS, new Rect(r0.getLeft(), r0.getTop(), r0.getRight(), r0.getBottom()));
        r8.values.put(PROPNAME_PARENT, r8.view.getParent());
        if (this.mReparent == false) goto L12;
        r8.view.getLocationInWindow(this.mTempLocation);
        r8.values.put(PROPNAME_WINDOW_X, Integer.valueOf(this.mTempLocation[0]));
        r8.values.put(PROPNAME_WINDOW_Y, Integer.valueOf(this.mTempLocation[1]));
    L12:
        if (this.mResizeClip == false) goto L16;
        r8.values.put(PROPNAME_CLIP, ViewCompat.getClipBounds(r0));
        return;
    L16:
        return;
    L5:
        if (r0.getWidth() != 0) goto L8;
        if (r0.getHeight() != 0) goto L8;
    }

    private boolean parentMatches(View r3, View r4) {
        if (this.mReparent == false) goto L11;
        TransitionValues r2 = getMatchedTransitionValues(r3, true);
        if (r2 != null) goto L10;
        if (r3 != r4) goto L12;
        return true;
    L12:
        return false;
    L10:
        if (r4 != r2.view) goto L12;
        return true;
    L11:
        return true;
    }

    @Override // androidx.transition.Transition
    public void captureEndValues(TransitionValues r1) {
        captureValues(r1);
    }

    @Override // androidx.transition.Transition
    public void captureStartValues(TransitionValues r1) {
        captureValues(r1);
    }

    @Override // androidx.transition.Transition
    public Animator createAnimator(final ViewGroup r19, TransitionValues r20, TransitionValues r21) {
        if (r20 == null) goto L79;
        if (r21 == null) goto L83;
        Map<String, Object> r3 = r20.values;
        Map<String, Object> r4 = r21.values;
        ViewGroup r5 = (ViewGroup) ZeusTransformUtils.preCheckCast(r3.get(PROPNAME_PARENT), ViewGroup.class, "com.obric.memorydata.plugin");
        ViewGroup r6 = (ViewGroup) ZeusTransformUtils.preCheckCast(r4.get(PROPNAME_PARENT), ViewGroup.class, "com.obric.memorydata.plugin");
        if (r5 == null) goto L77;
        if (r6 == null) goto L82;
        final View r10 = r21.view;
        if (parentMatches(r5, r6) == false) goto L69;
        Rect r7 = (Rect) ZeusTransformUtils.preCheckCast(r20.values.get(PROPNAME_BOUNDS), Rect.class, "com.obric.memorydata.plugin");
        Rect r8 = (Rect) ZeusTransformUtils.preCheckCast(r21.values.get(PROPNAME_BOUNDS), Rect.class, "com.obric.memorydata.plugin");
        int r9 = r7.left;
        final int r11 = r8.left;
        int r12 = r7.top;
        final int r13 = r8.top;
        int r14 = r7.right;
        final int r15 = r8.right;
        int r16 = r7.bottom;
        final int r17 = r8.bottom;
        int r2 = r14 - r9;
        int r18 = r16 - r12;
        int r22 = r15 - r11;
        int r110 = r17 - r13;
        Rect r0 = (Rect) ZeusTransformUtils.preCheckCast(r20.values.get(PROPNAME_CLIP), Rect.class, "com.obric.memorydata.plugin");
        final Rect r23 = (Rect) ZeusTransformUtils.preCheckCast(r21.values.get(PROPNAME_CLIP), Rect.class, "com.obric.memorydata.plugin");
        if (r2 == 0) goto L15;
        if (r18 == 0) goto L15;
    L17:
        if (r9 != r11) goto L21;
        if (r12 != r13) goto L21;
        int r1 = 0;
    L22:
        int r24 = r16;
        if (r14 != r15) goto L25;
        if (r24 != r17) goto L25;
    L27:
        if (r0 != null) goto L29;
    L30:
        if (r0 != null) goto L33;
        if (r23 == null) goto L33;
    L32:
        r1 = r1 + 1;
    L33:
        if (r1 > 0) goto L35;
        return null;
    L35:
        if (this.mResizeClip == true) goto L48;
        ViewUtils.setLeftTopRightBottom(r10, r9, r12, r14, r24);
        if (r1 != 2) goto L42;
        if (r2 != r22) goto L41;
        if (r18 != r110) goto L41;
        Path r25 = getPathMotion().getPath(r9, r12, r11, r13);
        Property<View, PointF> r26 = POSITION_PROPERTY;
    L47:
        Animator r27 = ObjectAnimatorUtils.ofPointF(r10, r26, r25);
        final View r28 = r10;
    L66:
        if (ZeusTransformUtils.instanceOf(r28.getParent(), ViewGroup.class) == false) goto L68;
        final ViewGroup r29 = (ViewGroup) ZeusTransformUtils.preCheckCast(r28.getParent(), ViewGroup.class, "com.obric.memorydata.plugin");
        ViewGroupUtils.suppressLayout(r29, true);
        addListener(new AnonymousClass9(this, r29));
    L68:
        return r27;
    L41:
        final ViewBounds r30 = new ViewBounds(r10);
        ObjectAnimator r31 = ObjectAnimatorUtils.ofPointF(r30, TOP_LEFT_PROPERTY, getPathMotion().getPath(r9, r12, r11, r13));
        ObjectAnimator r32 = ObjectAnimatorUtils.ofPointF(r30, BOTTOM_RIGHT_PROPERTY, getPathMotion().getPath(r14, r24, r15, r17));
        AnimatorSet r33 = new AnimatorSet();
        r33.playTogether(new Animator[]{r31, r32});
        r33.addListener(new AnonymousClass7(this, r30));
        r28 = r10;
        r27 = r33;
        goto L66
    L42:
        if (r9 != r11) goto L46;
        if (r12 != r13) goto L46;
        r25 = getPathMotion().getPath(r14, r24, r15, r17);
        r26 = BOTTOM_RIGHT_ONLY_PROPERTY;
    L46:
        r25 = getPathMotion().getPath(r9, r12, r11, r13);
        r26 = TOP_LEFT_ONLY_PROPERTY;
        goto L47
    L48:
        r28 = r10;
        ViewUtils.setLeftTopRightBottom(r28, r9, r12, Math.max(r2, r22) + r9, Math.max(r18, r110) + r12);
        if (r9 != r11) goto L53;
        if (r12 != r13) goto L53;
        ObjectAnimator r34 = null;
    L54:
        if (r0 != null) goto L56;
        int r35 = 0;
        Rect r36 = new Rect(0, 0, r2, r18);
    L57:
        if (r23 != null) goto L59;
        Rect r37 = new Rect(r35, r35, r22, r110);
    L61:
        if (r36.equals(r37) == true) goto L63;
        ViewCompat.setClipBounds(r28, r36);
        RectEvaluator r38 = sRectEvaluator;
        Object[] r39 = new Object[2];
        r39[r35] = r36;
        r39[1] = r37;
        ObjectAnimator r111 = ObjectAnimator.ofObject(r28, "clipBounds", r38, r39);
        r111.addListener(new AnonymousClass8(this, r28, r23, r11, r13, r15, r17));
        ObjectAnimator r40 = r111;
    L64:
        r27 = TransitionUtils.mergeAnimators(r34, r40);
        goto L66
    L63:
        r40 = null;
        goto L64
    L59:
        r37 = r23;
        goto L61
    L56:
        r35 = 0;
        r36 = r0;
    L53:
        r34 = ObjectAnimatorUtils.ofPointF(r28, POSITION_PROPERTY, getPathMotion().getPath(r9, r12, r11, r13));
        goto L54
    L29:
        if (r0.equals(r23) == false) goto L32;
    L25:
        r1 = r1 + 1;
    L21:
        r1 = 1;
    L15:
        if (r22 == 0) goto L26;
        if (r110 != 0) goto L17;
    L26:
        r24 = r16;
        r1 = 0;
        goto L27
    L69:
        int r41 = ((Integer) ZeusTransformUtils.preCheckCast(r20.values.get(PROPNAME_WINDOW_X), Integer.class, "com.obric.memorydata.plugin")).intValue();
        int r42 = ((Integer) ZeusTransformUtils.preCheckCast(r20.values.get(PROPNAME_WINDOW_Y), Integer.class, "com.obric.memorydata.plugin")).intValue();
        int r43 = ((Integer) ZeusTransformUtils.preCheckCast(r21.values.get(PROPNAME_WINDOW_X), Integer.class, "com.obric.memorydata.plugin")).intValue();
        int r44 = ((Integer) ZeusTransformUtils.preCheckCast(r21.values.get(PROPNAME_WINDOW_Y), Integer.class, "com.obric.memorydata.plugin")).intValue();
        if (r41 != r43) goto L75;
        if (r42 != r44) goto L75;
        return null;
    L75:
        r19.getLocationInWindow(this.mTempLocation);
        Bitmap r45 = Bitmap.createBitmap(r10.getWidth(), r10.getHeight(), Bitmap.Config.ARGB_8888);
        r10.draw(new Canvas(r45));
        final BitmapDrawable r46 = new BitmapDrawable(r45);
        final float r47 = ViewUtils.getTransitionAlpha(r10);
        ViewUtils.setTransitionAlpha(r10, 0.0f);
        ViewUtils.getOverlay(r19).add(r46);
        PathMotion r48 = getPathMotion();
        int[] r49 = this.mTempLocation;
        ObjectAnimator r50 = ObjectAnimator.ofPropertyValuesHolder(r46, new PropertyValuesHolder[]{PropertyValuesHolderUtils.ofPointF(DRAWABLE_ORIGIN_PROPERTY, r48.getPath(r41 - r49[0], r42 - r49[1], r43 - r49[0], r44 - r49[1]))});
        r50.addListener(new AnonymousClass10(this, r19, r46, r10, r47));
        return r50;
    L82:
        return null;
    L77:
        return null;
    L83:
        return null;
    L79:
        return null;
    }

    public boolean getResizeClip() {
        return this.mResizeClip;
    }

    @Override // androidx.transition.Transition
    public String[] getTransitionProperties() {
        return sTransitionProperties;
    }

    public void setResizeClip(boolean r1) {
        this.mResizeClip = r1;
    }
}
