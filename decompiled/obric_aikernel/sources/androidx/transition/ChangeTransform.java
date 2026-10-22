package androidx.transition;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ObjectAnimator;
import android.animation.PropertyValuesHolder;
import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Matrix;
import android.graphics.PointF;
import android.os.Build;
import android.util.AttributeSet;
import android.util.Property;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
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

    private static class GhostListener extends TransitionListenerAdapter {
        private GhostView mGhostView;
        private View mView;

        GhostListener(View r10, GhostView r11) {
            this.mView = r10;
            this.mGhostView = r11;
        }

        @Override // androidx.transition.TransitionListenerAdapter, androidx.transition.Transition.TransitionListener
        public void onTransitionEnd(@NonNull Transition r10) {
            r10.removeListener(this);
            GhostViewUtils.removeGhost(this.mView);
            this.mView.setTag(R.id.transition_transform, null);
            this.mView.setTag(R.id.parent_matrix, null);
        }

        @Override // androidx.transition.TransitionListenerAdapter, androidx.transition.Transition.TransitionListener
        public void onTransitionPause(@NonNull Transition r10) {
            this.mGhostView.setVisibility(4);
        }

        @Override // androidx.transition.TransitionListenerAdapter, androidx.transition.Transition.TransitionListener
        public void onTransitionResume(@NonNull Transition r10) {
            this.mGhostView.setVisibility(0);
        }
    }

    private static class PathAnimatorMatrix {
        private final Matrix mMatrix;
        private float mTranslationX;
        private float mTranslationY;
        private final float[] mValues;
        private final View mView;

        PathAnimatorMatrix(View r10, float[] r11) {
            this.mMatrix = new Matrix();
            this.mView = r10;
            float[] r12 = (float[]) r11.clone();
            this.mValues = r12;
            this.mTranslationX = r12[2];
            this.mTranslationY = r12[5];
            setAnimationMatrix();
        }

        private void setAnimationMatrix() {
            float[] r10 = this.mValues;
            r10[2] = this.mTranslationX;
            r10[5] = this.mTranslationY;
            this.mMatrix.setValues(r10);
            ViewUtils.setAnimationMatrix(this.mView, this.mMatrix);
        }

        Matrix getMatrix() {
            return this.mMatrix;
        }

        void setTranslation(PointF r10) {
            this.mTranslationX = r10.x;
            this.mTranslationY = r10.y;
            setAnimationMatrix();
        }

        void setValues(float[] r10) {
            System.arraycopy(r10, 0, this.mValues, 0, r10.length);
            setAnimationMatrix();
        }
    }

    private static class Transforms {
        final float mRotationX;
        final float mRotationY;
        final float mRotationZ;
        final float mScaleX;
        final float mScaleY;
        final float mTranslationX;
        final float mTranslationY;
        final float mTranslationZ;

        Transforms(View r10) {
            this.mTranslationX = r10.getTranslationX();
            this.mTranslationY = r10.getTranslationY();
            this.mTranslationZ = ViewCompat.getTranslationZ(r10);
            this.mScaleX = r10.getScaleX();
            this.mScaleY = r10.getScaleY();
            this.mRotationX = r10.getRotationX();
            this.mRotationY = r10.getRotationY();
            this.mRotationZ = r10.getRotation();
        }

        public boolean equals(Object r10) {
            if ((r10 instanceof Transforms) == true) goto L5;
            return false;
        L5:
            Transforms r11 = (Transforms) r10;
            if (r11.mTranslationX == this.mTranslationX) goto L8;
            return false;
        L8:
            if (r11.mTranslationY == this.mTranslationY) goto L10;
            return false;
        L10:
            if (r11.mTranslationZ == this.mTranslationZ) goto L12;
            return false;
        L12:
            if (r11.mScaleX == this.mScaleX) goto L14;
            return false;
        L14:
            if (r11.mScaleY == this.mScaleY) goto L16;
            return false;
        L16:
            if (r11.mRotationX == this.mRotationX) goto L18;
            return false;
        L18:
            if (r11.mRotationY == this.mRotationY) goto L20;
            return false;
        L20:
            if (r11.mRotationZ != this.mRotationZ) goto L30;
            return true;
        L30:
            return false;
        }

        public int hashCode() {
            float r10 = this.mTranslationX;
            int r11 = 0;
            if (r10 == 0.0f) goto L5;
            int r12 = Float.floatToIntBits(r10);
        L6:
            int r13 = r12 * 31;
            float r14 = this.mTranslationY;
            if (r14 == 0.0f) goto L9;
            int r15 = Float.floatToIntBits(r14);
        L10:
            int r16 = (r13 + r15) * 31;
            float r17 = this.mTranslationZ;
            if (r17 == 0.0f) goto L13;
            int r18 = Float.floatToIntBits(r17);
        L14:
            int r19 = (r16 + r18) * 31;
            float r20 = this.mScaleX;
            if (r20 == 0.0f) goto L17;
            int r21 = Float.floatToIntBits(r20);
        L18:
            int r22 = (r19 + r21) * 31;
            float r23 = this.mScaleY;
            if (r23 == 0.0f) goto L21;
            int r24 = Float.floatToIntBits(r23);
        L22:
            int r25 = (r22 + r24) * 31;
            float r26 = this.mRotationX;
            if (r26 == 0.0f) goto L25;
            int r27 = Float.floatToIntBits(r26);
        L26:
            int r28 = (r25 + r27) * 31;
            float r29 = this.mRotationY;
            if (r29 == 0.0f) goto L29;
            int r30 = Float.floatToIntBits(r29);
        L30:
            int r31 = (r28 + r30) * 31;
            float r32 = this.mRotationZ;
            if (r32 == 0.0f) goto L34;
            r11 = Float.floatToIntBits(r32);
        L34:
            return r31 + r11;
        L29:
            r30 = 0;
            goto L30
        L25:
            r27 = 0;
            goto L26
        L21:
            r24 = 0;
            goto L22
        L17:
            r21 = 0;
            goto L18
        L13:
            r18 = 0;
            goto L14
        L9:
            r15 = 0;
            goto L10
        L5:
            r12 = 0;
            goto L6
        }

        public void restore(View r10) {
            ChangeTransform.setTransforms(r10, this.mTranslationX, this.mTranslationY, this.mTranslationZ, this.mScaleX, this.mScaleY, this.mRotationX, this.mRotationY, this.mRotationZ);
        }
    }

    static {
        sTransitionProperties = new String[]{PROPNAME_MATRIX, PROPNAME_TRANSFORMS, PROPNAME_PARENT_MATRIX};
        final Class<float[]> r10 = float[].class;
        final String r11 = "nonTranslations";
        NON_TRANSLATIONS_PROPERTY = new AnonymousClass1(r10, r11);
        final Class<PointF> r12 = PointF.class;
        final String r13 = "translations";
        TRANSLATIONS_PROPERTY = new AnonymousClass2(r12, r13);
        if (Build.VERSION.SDK_INT < 21) goto L5;
        boolean r14 = true;
    L6:
        SUPPORTS_VIEW_REMOVAL_SUPPRESSION = r14;
        return;
    L5:
        r14 = false;
        goto L6
    }

    public ChangeTransform() {
        this.mUseOverlay = true;
        this.mReparent = true;
        this.mTempMatrix = new Matrix();
    }

    @SuppressLint({"RestrictedApi"})
    public ChangeTransform(Context r10, AttributeSet r11) {
        super(r10, r11);
        this.mUseOverlay = true;
        this.mReparent = true;
        this.mTempMatrix = new Matrix();
        TypedArray r12 = r10.obtainStyledAttributes(r11, Styleable.CHANGE_TRANSFORM);
        XmlPullParser r13 = (XmlPullParser) r11;
        this.mUseOverlay = TypedArrayUtils.getNamedBoolean(r12, r13, "reparentWithOverlay", 1, true);
        this.mReparent = TypedArrayUtils.getNamedBoolean(r12, r13, "reparent", 0, true);
        r12.recycle();
    }

    private void captureValues(TransitionValues r10) {
        View r11 = r10.view;
        if (r11.getVisibility() != 8) goto L5;
        return;
    L5:
        r10.values.put(PROPNAME_PARENT, r11.getParent());
        r10.values.put(PROPNAME_TRANSFORMS, new Transforms(r11));
        Matrix r12 = r11.getMatrix();
        if (r12 != null) goto L8;
    L11:
        Matrix r13 = null;
    L12:
        r10.values.put(PROPNAME_MATRIX, r13);
        if (this.mReparent == false) goto L16;
        Matrix r14 = new Matrix();
        ViewGroup r15 = (ViewGroup) r11.getParent();
        ViewUtils.transformMatrixToGlobal(r15, r14);
        r14.preTranslate(-r15.getScrollX(), -r15.getScrollY());
        r10.values.put(PROPNAME_PARENT_MATRIX, r14);
        r10.values.put(PROPNAME_INTERMEDIATE_MATRIX, r11.getTag(R.id.transition_transform));
        r10.values.put(PROPNAME_INTERMEDIATE_PARENT_MATRIX, r11.getTag(R.id.parent_matrix));
        return;
    L16:
        return;
    L8:
        if (r12.isIdentity() == true) goto L11;
        r13 = new Matrix(r12);
        goto L12
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r3v1, types: [androidx.transition.Transition] */
    /* JADX WARN: Type inference failed for: r3v5 */
    /* JADX WARN: Type inference failed for: r3v6 */
    private void createGhostView(ViewGroup r10, TransitionValues r11, TransitionValues r12) {
        View r13 = r12.view;
        Matrix r14 = new Matrix((Matrix) r12.values.get(PROPNAME_PARENT_MATRIX));
        ViewUtils.transformMatrixToLocal(r10, r14);
        GhostView r15 = GhostViewUtils.addGhost(r13, r10, r14);
        if (r15 != null) goto L5;
        return;
    L5:
        r15.reserveEndViewTransition((ViewGroup) r11.values.get(PROPNAME_PARENT), r11.view);
        ?? r16 = this;
    L6:
        TransitionSet r17 = r16.mParent;
        if (r17 == null) goto L9;
        r16 = r17;
        goto L6
    L9:
        r16.addListener(new GhostListener(r13, r15));
        if (SUPPORTS_VIEW_REMOVAL_SUPPRESSION == false) goto L17;
        View r18 = r11.view;
        if (r18 == r12.view) goto L14;
        ViewUtils.setTransitionAlpha(r18, 0.0f);
    L14:
        ViewUtils.setTransitionAlpha(r13, 1.0f);
        return;
    }

    private ObjectAnimator createTransformAnimator(TransitionValues r13, TransitionValues r14, final boolean r15) {
        Matrix r16 = (Matrix) r13.values.get(PROPNAME_MATRIX);
        Matrix r10 = (Matrix) r14.values.get(PROPNAME_MATRIX);
        if (r16 != null) goto L5;
        r16 = MatrixUtils.IDENTITY_MATRIX;
    L5:
        if (r10 != null) goto L7;
        r10 = MatrixUtils.IDENTITY_MATRIX;
    L7:
        final Matrix r11 = r10;
        if (r16.equals(r11) == false) goto L11;
        return null;
    L11:
        final Transforms r12 = (Transforms) r14.values.get(PROPNAME_TRANSFORMS);
        final View r17 = r14.view;
        setIdentityTransforms(r17);
        float[] r18 = new float[9];
        r16.getValues(r18);
        float[] r19 = new float[9];
        r11.getValues(r19);
        final PathAnimatorMatrix r20 = new PathAnimatorMatrix(r17, r18);
        ObjectAnimator r110 = ObjectAnimator.ofPropertyValuesHolder(r20, new PropertyValuesHolder[]{PropertyValuesHolder.ofObject(NON_TRANSLATIONS_PROPERTY, new FloatArrayEvaluator(new float[9]), new float[][]{r18, r19}), PropertyValuesHolderUtils.ofPointF(TRANSLATIONS_PROPERTY, getPathMotion().getPath(r18[2], r18[5], r19[2], r19[5]))});
        AnimatorListenerAdapter r111 = new AnonymousClass3(this, r15, r11, r17, r12, r20);
        r110.addListener(r111);
        AnimatorUtils.addPauseListener(r110, r111);
        return r110;
    }

    private boolean parentsMatch(ViewGroup r10, ViewGroup r11) {
        boolean r12 = true;
        if (isValidTarget(r10) == true) goto L5;
    L12:
        if (r10 == r11) goto L16;
    L14:
        r12 = false;
    L16:
        return r12;
    L5:
        if (isValidTarget(r11) == false) goto L12;
        TransitionValues r13 = getMatchedTransitionValues(r10, true);
        if (r13 != null) goto L10;
        return false;
    L10:
        if (r11 != r13.view) goto L14;
        goto L14
    }

    static void setIdentityTransforms(View r10) {
        setTransforms(r10, 0.0f, 0.0f, 0.0f, 1.0f, 1.0f, 0.0f, 0.0f, 0.0f);
    }

    private void setMatricesForParent(TransitionValues r10, TransitionValues r11) {
        Matrix r12 = (Matrix) r11.values.get(PROPNAME_PARENT_MATRIX);
        r11.view.setTag(R.id.parent_matrix, r12);
        Matrix r13 = this.mTempMatrix;
        r13.reset();
        r12.invert(r13);
        Matrix r14 = (Matrix) r10.values.get(PROPNAME_MATRIX);
        if (r14 != null) goto L5;
        r14 = new Matrix();
        r10.values.put(PROPNAME_MATRIX, r14);
    L5:
        r14.postConcat((Matrix) r10.values.get(PROPNAME_PARENT_MATRIX));
        r14.postConcat(r13);
    }

    static void setTransforms(View r10, float r11, float r12, float r13, float r14, float r15, float r16, float r17, float r18) {
        r10.setTranslationX(r11);
        r10.setTranslationY(r12);
        ViewCompat.setTranslationZ(r10, r13);
        r10.setScaleX(r14);
        r10.setScaleY(r15);
        r10.setRotationX(r16);
        r10.setRotationY(r17);
        r10.setRotation(r18);
    }

    @Override // androidx.transition.Transition
    public void captureEndValues(@NonNull TransitionValues r10) {
        captureValues(r10);
    }

    @Override // androidx.transition.Transition
    public void captureStartValues(@NonNull TransitionValues r10) {
        captureValues(r10);
        if (SUPPORTS_VIEW_REMOVAL_SUPPRESSION == true) goto L6;
        ((ViewGroup) r10.view.getParent()).startViewTransition(r10.view);
        return;
    }

    @Override // androidx.transition.Transition
    public Animator createAnimator(@NonNull ViewGroup r10, TransitionValues r11, TransitionValues r12) {
        if (r11 == null) goto L33;
        if (r12 != null) goto L5;
        return null;
    L5:
        if (r11.values.containsKey(PROPNAME_PARENT) == true) goto L7;
        return null;
    L7:
        if (r12.values.containsKey(PROPNAME_PARENT) == false) goto L37;
        ViewGroup r13 = (ViewGroup) r11.values.get(PROPNAME_PARENT);
        ViewGroup r14 = (ViewGroup) r12.values.get(PROPNAME_PARENT);
        if (this.mReparent == true) goto L12;
    L14:
        boolean r15 = false;
    L15:
        Matrix r16 = (Matrix) r11.values.get(PROPNAME_INTERMEDIATE_MATRIX);
        if (r16 == null) goto L18;
        r11.values.put(PROPNAME_MATRIX, r16);
    L18:
        Matrix r17 = (Matrix) r11.values.get(PROPNAME_INTERMEDIATE_PARENT_MATRIX);
        if (r17 == null) goto L21;
        r11.values.put(PROPNAME_PARENT_MATRIX, r17);
    L21:
        if (r15 == false) goto L23;
        setMatricesForParent(r11, r12);
    L23:
        ObjectAnimator r18 = createTransformAnimator(r11, r12, r15);
        if (r15 == false) goto L30;
        if (r18 == null) goto L30;
        if (this.mUseOverlay == false) goto L30;
        createGhostView(r10, r11, r12);
    L32:
        return r18;
    L30:
        if (SUPPORTS_VIEW_REMOVAL_SUPPRESSION == true) goto L32;
        r13.endViewTransition(r11.view);
        goto L32
    L12:
        if (parentsMatch(r13, r14) == true) goto L14;
        r15 = true;
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
    public String[] getTransitionProperties() {
        return sTransitionProperties;
    }

    public void setReparent(boolean r10) {
        this.mReparent = r10;
    }

    public void setReparentWithOverlay(boolean r10) {
        this.mUseOverlay = r10;
    }
}
