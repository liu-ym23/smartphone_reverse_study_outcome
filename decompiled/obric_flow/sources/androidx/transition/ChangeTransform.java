package androidx.transition;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ObjectAnimator;
import android.animation.PropertyValuesHolder;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Matrix;
import android.graphics.Path;
import android.graphics.PointF;
import android.util.AttributeSet;
import android.util.Property;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.content.res.TypedArrayUtils;
import androidx.core.view.ViewCompat;
import org.xmlpull.v1.XmlPullParser;

/* JADX INFO: loaded from: classes.dex */
public class ChangeTransform extends Transition {
    private static final Property<PathAnimatorMatrix, float[]> NON_TRANSLATIONS_PROPERTY = null;
    private static final String PROPNAME_INTERMEDIATE_MATRIX = "android:changeTransform:intermediateMatrix";
    private static final String PROPNAME_INTERMEDIATE_PARENT_MATRIX = "android:changeTransform:intermediateParentMatrix";
    private static final String PROPNAME_MATRIX = "android:changeTransform:matrix";
    private static final String PROPNAME_PARENT = "android:changeTransform:parent";
    private static final String PROPNAME_PARENT_MATRIX = "android:changeTransform:parentMatrix";
    private static final String PROPNAME_TRANSFORMS = "android:changeTransform:transforms";
    private static final boolean SUPPORTS_VIEW_REMOVAL_SUPPRESSION = false;
    private static final Property<PathAnimatorMatrix, PointF> TRANSLATIONS_PROPERTY = null;
    private static final String[] sTransitionProperties = null;
    private boolean mReparent;
    private Matrix mTempMatrix;
    boolean mUseOverlay;

    public static class GhostListener extends TransitionListenerAdapter {
        private GhostView mGhostView;
        private View mView;

        public GhostListener(View r5, GhostView r10) {
            this.mView = r5;
            this.mGhostView = r10;
        }

        @Override // androidx.transition.TransitionListenerAdapter, androidx.transition.Transition.TransitionListener
        public void onTransitionEnd(@NonNull Transition r5) {
            r5.removeListener(this);
            GhostViewUtils.removeGhost(this.mView);
            this.mView.setTag(R.id.transition_transform, null);
            this.mView.setTag(R.id.parent_matrix, null);
        }

        @Override // androidx.transition.TransitionListenerAdapter, androidx.transition.Transition.TransitionListener
        public void onTransitionPause(@NonNull Transition r5) {
            this.mGhostView.setVisibility(4);
        }

        @Override // androidx.transition.TransitionListenerAdapter, androidx.transition.Transition.TransitionListener
        public void onTransitionResume(@NonNull Transition r5) {
            this.mGhostView.setVisibility(0);
        }
    }

    public static class Listener extends AnimatorListenerAdapter {
        private final Matrix mEndMatrix;
        private final boolean mHandleParentChange;
        private boolean mIsCanceled;
        private final PathAnimatorMatrix mPathAnimatorMatrix;
        private final Matrix mTempMatrix;
        private final Transforms mTransforms;
        private final boolean mUseOverlay;
        private final View mView;

        public Listener(View r5, Transforms r10, PathAnimatorMatrix r11, Matrix r12, boolean r13, boolean r14) {
            this.mTempMatrix = new Matrix();
            this.mHandleParentChange = r13;
            this.mUseOverlay = r14;
            this.mView = r5;
            this.mTransforms = r10;
            this.mPathAnimatorMatrix = r11;
            this.mEndMatrix = r12;
        }

        private void setCurrentMatrix(Matrix r5) {
            this.mTempMatrix.set(r5);
            this.mView.setTag(R.id.transition_transform, this.mTempMatrix);
            this.mTransforms.restore(this.mView);
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationCancel(Animator r5) {
            this.mIsCanceled = true;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator r5) {
            if (this.mIsCanceled == false) goto L5;
        L10:
            ViewUtils.setAnimationMatrix(this.mView, null);
            this.mTransforms.restore(this.mView);
            return;
        L5:
            if (this.mHandleParentChange == true) goto L7;
        L9:
            this.mView.setTag(R.id.transition_transform, null);
            this.mView.setTag(R.id.parent_matrix, null);
            goto L10
        L7:
            if (this.mUseOverlay == false) goto L9;
            setCurrentMatrix(this.mEndMatrix);
            goto L10
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorPauseListener
        public void onAnimationPause(Animator r5) {
            setCurrentMatrix(this.mPathAnimatorMatrix.getMatrix());
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorPauseListener
        public void onAnimationResume(Animator r5) {
            ChangeTransform.setIdentityTransforms(this.mView);
        }
    }

    public static class PathAnimatorMatrix {
        private final Matrix mMatrix;
        private float mTranslationX;
        private float mTranslationY;
        private final float[] mValues;
        private final View mView;

        public PathAnimatorMatrix(View r5, float[] r10) {
            this.mMatrix = new Matrix();
            this.mView = r5;
            float[] r11 = (float[]) r10.clone();
            this.mValues = r11;
            this.mTranslationX = r11[2];
            this.mTranslationY = r11[5];
            setAnimationMatrix();
        }

        private void setAnimationMatrix() {
            float[] r5 = this.mValues;
            r5[2] = this.mTranslationX;
            r5[5] = this.mTranslationY;
            this.mMatrix.setValues(r5);
            ViewUtils.setAnimationMatrix(this.mView, this.mMatrix);
        }

        public Matrix getMatrix() {
            return this.mMatrix;
        }

        public void setTranslation(PointF r5) {
            this.mTranslationX = r5.x;
            this.mTranslationY = r5.y;
            setAnimationMatrix();
        }

        public void setValues(float[] r5) {
            System.arraycopy(r5, 0, this.mValues, 0, r5.length);
            setAnimationMatrix();
        }
    }

    public static class Transforms {
        final float mRotationX;
        final float mRotationY;
        final float mRotationZ;
        final float mScaleX;
        final float mScaleY;
        final float mTranslationX;
        final float mTranslationY;
        final float mTranslationZ;

        public Transforms(View r5) {
            this.mTranslationX = r5.getTranslationX();
            this.mTranslationY = r5.getTranslationY();
            this.mTranslationZ = ViewCompat.getTranslationZ(r5);
            this.mScaleX = r5.getScaleX();
            this.mScaleY = r5.getScaleY();
            this.mRotationX = r5.getRotationX();
            this.mRotationY = r5.getRotationY();
            this.mRotationZ = r5.getRotation();
        }

        public boolean equals(Object r5) {
            if ((r5 instanceof Transforms) == true) goto L5;
            return false;
        L5:
            Transforms r10 = (Transforms) r5;
            if (r10.mTranslationX == this.mTranslationX) goto L8;
            return false;
        L8:
            if (r10.mTranslationY == this.mTranslationY) goto L10;
            return false;
        L10:
            if (r10.mTranslationZ == this.mTranslationZ) goto L12;
            return false;
        L12:
            if (r10.mScaleX == this.mScaleX) goto L14;
            return false;
        L14:
            if (r10.mScaleY == this.mScaleY) goto L16;
            return false;
        L16:
            if (r10.mRotationX == this.mRotationX) goto L18;
            return false;
        L18:
            if (r10.mRotationY == this.mRotationY) goto L20;
            return false;
        L20:
            if (r10.mRotationZ != this.mRotationZ) goto L30;
            return true;
        L30:
            return false;
        }

        public int hashCode() {
            float r5 = this.mTranslationX;
            int r10 = 0;
            if (r5 == 0.0f) goto L5;
            int r11 = Float.floatToIntBits(r5);
        L6:
            int r12 = r11 * 31;
            float r13 = this.mTranslationY;
            if (r13 == 0.0f) goto L9;
            int r14 = Float.floatToIntBits(r13);
        L10:
            int r15 = (r12 + r14) * 31;
            float r16 = this.mTranslationZ;
            if (r16 == 0.0f) goto L13;
            int r17 = Float.floatToIntBits(r16);
        L14:
            int r18 = (r15 + r17) * 31;
            float r19 = this.mScaleX;
            if (r19 == 0.0f) goto L17;
            int r20 = Float.floatToIntBits(r19);
        L18:
            int r21 = (r18 + r20) * 31;
            float r22 = this.mScaleY;
            if (r22 == 0.0f) goto L21;
            int r23 = Float.floatToIntBits(r22);
        L22:
            int r24 = (r21 + r23) * 31;
            float r25 = this.mRotationX;
            if (r25 == 0.0f) goto L25;
            int r26 = Float.floatToIntBits(r25);
        L26:
            int r27 = (r24 + r26) * 31;
            float r28 = this.mRotationY;
            if (r28 == 0.0f) goto L29;
            int r29 = Float.floatToIntBits(r28);
        L30:
            int r30 = (r27 + r29) * 31;
            float r31 = this.mRotationZ;
            if (r31 == 0.0f) goto L34;
            r10 = Float.floatToIntBits(r31);
        L34:
            return r30 + r10;
        L29:
            r29 = 0;
            goto L30
        L25:
            r26 = 0;
            goto L26
        L21:
            r23 = 0;
            goto L22
        L17:
            r20 = 0;
            goto L18
        L13:
            r17 = 0;
            goto L14
        L9:
            r14 = 0;
            goto L10
        L5:
            r11 = 0;
            goto L6
        }

        public void restore(View r10) {
            ChangeTransform.setTransforms(r10, this.mTranslationX, this.mTranslationY, this.mTranslationZ, this.mScaleX, this.mScaleY, this.mRotationX, this.mRotationY, this.mRotationZ);
        }
    }

    static {
        sTransitionProperties = new String[]{PROPNAME_MATRIX, PROPNAME_TRANSFORMS, PROPNAME_PARENT_MATRIX};
        final Class<float[]> r5 = float[].class;
        final String r10 = "nonTranslations";
        NON_TRANSLATIONS_PROPERTY = new AnonymousClass1(r5, r10);
        final Class<PointF> r11 = PointF.class;
        final String r12 = "translations";
        TRANSLATIONS_PROPERTY = new AnonymousClass2(r11, r12);
        SUPPORTS_VIEW_REMOVAL_SUPPRESSION = true;
    }

    public ChangeTransform() {
        this.mUseOverlay = true;
        this.mReparent = true;
        this.mTempMatrix = new Matrix();
    }

    private void captureValues(TransitionValues r5) {
        View r10 = r5.view;
        if (r10.getVisibility() != 8) goto L5;
        return;
    L5:
        r5.values.put(PROPNAME_PARENT, r10.getParent());
        r5.values.put(PROPNAME_TRANSFORMS, new Transforms(r10));
        Matrix r11 = r10.getMatrix();
        if (r11 != null) goto L8;
    L11:
        Matrix r12 = null;
    L12:
        r5.values.put(PROPNAME_MATRIX, r12);
        if (this.mReparent == false) goto L16;
        Matrix r13 = new Matrix();
        ViewGroup r14 = (ViewGroup) r10.getParent();
        ViewUtils.transformMatrixToGlobal(r14, r13);
        r13.preTranslate(-r14.getScrollX(), -r14.getScrollY());
        r5.values.put(PROPNAME_PARENT_MATRIX, r13);
        r5.values.put(PROPNAME_INTERMEDIATE_MATRIX, r10.getTag(R.id.transition_transform));
        r5.values.put(PROPNAME_INTERMEDIATE_PARENT_MATRIX, r10.getTag(R.id.parent_matrix));
        return;
    L16:
        return;
    L8:
        if (r11.isIdentity() == true) goto L11;
        r12 = new Matrix(r11);
        goto L12
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r3v1, types: [androidx.transition.Transition] */
    /* JADX WARN: Type inference failed for: r3v5 */
    /* JADX WARN: Type inference failed for: r3v6 */
    private void createGhostView(ViewGroup r5, TransitionValues r10, TransitionValues r11) {
        View r12 = r11.view;
        Matrix r13 = new Matrix((Matrix) r11.values.get(PROPNAME_PARENT_MATRIX));
        ViewUtils.transformMatrixToLocal(r5, r13);
        GhostView r14 = GhostViewUtils.addGhost(r12, r5, r13);
        if (r14 != null) goto L5;
        return;
    L5:
        r14.reserveEndViewTransition((ViewGroup) r10.values.get(PROPNAME_PARENT), r10.view);
        ?? r15 = this;
    L6:
        TransitionSet r16 = r15.mParent;
        if (r16 == null) goto L9;
        r15 = r16;
        goto L6
    L9:
        r15.addListener(new GhostListener(r12, r14));
        if (SUPPORTS_VIEW_REMOVAL_SUPPRESSION == false) goto L17;
        View r17 = r10.view;
        if (r17 == r11.view) goto L14;
        ViewUtils.setTransitionAlpha(r17, 0.0f);
    L14:
        ViewUtils.setTransitionAlpha(r12, 1.0f);
        return;
    }

    private ObjectAnimator createTransformAnimator(TransitionValues r10, TransitionValues r11, boolean r12) {
        Matrix r13 = (Matrix) r10.values.get(PROPNAME_MATRIX);
        Matrix r5 = (Matrix) r11.values.get(PROPNAME_MATRIX);
        if (r13 != null) goto L5;
        r13 = MatrixUtils.IDENTITY_MATRIX;
    L5:
        if (r5 != null) goto L7;
        r5 = MatrixUtils.IDENTITY_MATRIX;
    L7:
        Matrix r14 = r5;
        if (r13.equals(r14) == false) goto L11;
        return null;
    L11:
        Transforms r15 = (Transforms) r11.values.get(PROPNAME_TRANSFORMS);
        View r16 = r11.view;
        setIdentityTransforms(r16);
        float[] r17 = new float[9];
        r13.getValues(r17);
        float[] r18 = new float[9];
        r14.getValues(r18);
        PathAnimatorMatrix r19 = new PathAnimatorMatrix(r16, r17);
        PropertyValuesHolder r110 = PropertyValuesHolder.ofObject(NON_TRANSLATIONS_PROPERTY, new FloatArrayEvaluator(new float[9]), new float[][]{r17, r18});
        Path r111 = getPathMotion().getPath(r17[2], r17[5], r18[2], r18[5]);
        ObjectAnimator r112 = ObjectAnimator.ofPropertyValuesHolder(r19, new PropertyValuesHolder[]{r110, PropertyValuesHolderUtils.ofPointF(TRANSLATIONS_PROPERTY, r111)});
        Listener r113 = new Listener(r16, r15, r19, r14, r12, this.mUseOverlay);
        r112.addListener(r113);
        r112.addPauseListener(r113);
        return r112;
    }

    private boolean parentsMatch(ViewGroup r5, ViewGroup r10) {
        boolean r11 = true;
        if (isValidTarget(r5) == true) goto L5;
    L14:
        if (r5 == r10) goto L17;
    L12:
        r11 = false;
    L17:
        return r11;
    L5:
        if (isValidTarget(r10) == false) goto L14;
        TransitionValues r12 = getMatchedTransitionValues(r5, true);
        if (r12 != null) goto L10;
        return false;
    L10:
        if (r10 != r12.view) goto L12;
        goto L12
    }

    public static void setIdentityTransforms(View r10) {
        setTransforms(r10, 0.0f, 0.0f, 0.0f, 1.0f, 1.0f, 0.0f, 0.0f, 0.0f);
    }

    private void setMatricesForParent(TransitionValues r5, TransitionValues r10) {
        Matrix r11 = (Matrix) r10.values.get(PROPNAME_PARENT_MATRIX);
        r10.view.setTag(R.id.parent_matrix, r11);
        Matrix r12 = this.mTempMatrix;
        r12.reset();
        r11.invert(r12);
        Matrix r13 = (Matrix) r5.values.get(PROPNAME_MATRIX);
        if (r13 != null) goto L5;
        r13 = new Matrix();
        r5.values.put(PROPNAME_MATRIX, r13);
    L5:
        r13.postConcat((Matrix) r5.values.get(PROPNAME_PARENT_MATRIX));
        r13.postConcat(r12);
    }

    public static void setTransforms(View r5, float r10, float r11, float r12, float r13, float r14, float r15, float r16, float r17) {
        r5.setTranslationX(r10);
        r5.setTranslationY(r11);
        ViewCompat.setTranslationZ(r5, r12);
        r5.setScaleX(r13);
        r5.setScaleY(r14);
        r5.setRotationX(r15);
        r5.setRotationY(r16);
        r5.setRotation(r17);
    }

    @Override // androidx.transition.Transition
    public void captureEndValues(@NonNull TransitionValues r5) {
        captureValues(r5);
    }

    @Override // androidx.transition.Transition
    public void captureStartValues(@NonNull TransitionValues r5) {
        captureValues(r5);
        if (SUPPORTS_VIEW_REMOVAL_SUPPRESSION == true) goto L6;
        ((ViewGroup) r5.view.getParent()).startViewTransition(r5.view);
        return;
    }

    @Override // androidx.transition.Transition
    @Nullable
    public Animator createAnimator(@NonNull ViewGroup r10, @Nullable TransitionValues r11, @Nullable TransitionValues r12) {
        if (r11 == null) goto L33;
        if (r12 != null) goto L5;
        return null;
    L5:
        if (r11.values.containsKey(PROPNAME_PARENT) == true) goto L7;
        return null;
    L7:
        if (r12.values.containsKey(PROPNAME_PARENT) == false) goto L37;
        ViewGroup r5 = (ViewGroup) r11.values.get(PROPNAME_PARENT);
        ViewGroup r13 = (ViewGroup) r12.values.get(PROPNAME_PARENT);
        if (this.mReparent == true) goto L12;
    L14:
        boolean r14 = false;
    L15:
        Matrix r15 = (Matrix) r11.values.get(PROPNAME_INTERMEDIATE_MATRIX);
        if (r15 == null) goto L18;
        r11.values.put(PROPNAME_MATRIX, r15);
    L18:
        Matrix r16 = (Matrix) r11.values.get(PROPNAME_INTERMEDIATE_PARENT_MATRIX);
        if (r16 == null) goto L21;
        r11.values.put(PROPNAME_PARENT_MATRIX, r16);
    L21:
        if (r14 == false) goto L23;
        setMatricesForParent(r11, r12);
    L23:
        ObjectAnimator r17 = createTransformAnimator(r11, r12, r14);
        if (r14 == false) goto L30;
        if (r17 == null) goto L30;
        if (this.mUseOverlay == false) goto L30;
        createGhostView(r10, r11, r12);
    L32:
        return r17;
    L30:
        if (SUPPORTS_VIEW_REMOVAL_SUPPRESSION == true) goto L32;
        r5.endViewTransition(r11.view);
        goto L32
    L12:
        if (parentsMatch(r5, r13) == true) goto L14;
        r14 = true;
        goto L15
    L37:
        return null;
    L33:
        return null;
    }

    public boolean getReparent() {
        return this.mReparent;
    }

    public boolean getReparentWithOverlay() {
        return this.mUseOverlay;
    }

    @Override // androidx.transition.Transition
    @NonNull
    public String[] getTransitionProperties() {
        return sTransitionProperties;
    }

    public void setReparent(boolean r5) {
        this.mReparent = r5;
    }

    public void setReparentWithOverlay(boolean r5) {
        this.mUseOverlay = r5;
    }

    public ChangeTransform(@NonNull Context r5, @NonNull AttributeSet r10) {
        super(r5, r10);
        this.mUseOverlay = true;
        this.mReparent = true;
        this.mTempMatrix = new Matrix();
        TypedArray r11 = r5.obtainStyledAttributes(r10, Styleable.CHANGE_TRANSFORM);
        XmlPullParser r12 = (XmlPullParser) r10;
        this.mUseOverlay = TypedArrayUtils.getNamedBoolean(r11, r12, "reparentWithOverlay", 1, true);
        this.mReparent = TypedArrayUtils.getNamedBoolean(r11, r12, "reparent", 0, true);
        r11.recycle();
    }
}
