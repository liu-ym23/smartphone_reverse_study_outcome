package androidx.transition;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ObjectAnimator;
import android.animation.PropertyValuesHolder;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Matrix;
import android.graphics.PointF;
import android.os.Build;
import android.util.AttributeSet;
import android.util.Property;
import android.view.View;
import android.view.ViewGroup;
import androidx.core.content.res.TypedArrayUtils;
import androidx.core.view.ViewCompat;
import com.bytedance.bdinstall.oaid.OaidModel;
import com.obric.memorydata.plugin.R;
import com.volcengine.zeus.transform.ZeusTransformUtils;
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

        GhostListener(View r3, GhostView r4) {
            GhostView r5 = (GhostView) ZeusTransformUtils.wrapperContextForParams(r4, GhostView.class, "com.obric.memorydata.plugin");
            this.mView = r3;
            this.mGhostView = r5;
        }

        @Override // androidx.transition.TransitionListenerAdapter, androidx.transition.Transition.TransitionListener
        public void onTransitionEnd(Transition r4) {
            r4.removeListener(this);
            GhostViewUtils.removeGhost(this.mView);
            this.mView.setTag(ZeusTransformUtils.mapRes(R.id.transition_transform, OaidModel.KEY_ID, "transition_transform"), null);
            this.mView.setTag(ZeusTransformUtils.mapRes(R.id.parent_matrix, OaidModel.KEY_ID, "parent_matrix"), null);
        }

        @Override // androidx.transition.TransitionListenerAdapter, androidx.transition.Transition.TransitionListener
        public void onTransitionPause(Transition r1) {
            this.mGhostView.setVisibility(4);
        }

        @Override // androidx.transition.TransitionListenerAdapter, androidx.transition.Transition.TransitionListener
        public void onTransitionResume(Transition r1) {
            this.mGhostView.setVisibility(0);
        }
    }

    private static class PathAnimatorMatrix {
        private final Matrix mMatrix;
        private float mTranslationX;
        private float mTranslationY;
        private final float[] mValues;
        private final View mView;

        PathAnimatorMatrix(View r2, float[] r3) {
            this.mMatrix = new Matrix();
            this.mView = r2;
            float[] r4 = (float[]) ZeusTransformUtils.preCheckCast(r3.clone(), float[].class, "com.obric.memorydata.plugin");
            this.mValues = r4;
            this.mTranslationX = r4[2];
            this.mTranslationY = r4[5];
            setAnimationMatrix();
        }

        private void setAnimationMatrix() {
            float[] r0 = this.mValues;
            r0[2] = this.mTranslationX;
            r0[5] = this.mTranslationY;
            this.mMatrix.setValues(r0);
            ViewUtils.setAnimationMatrix(this.mView, this.mMatrix);
        }

        Matrix getMatrix() {
            return this.mMatrix;
        }

        void setTranslation(PointF r2) {
            this.mTranslationX = r2.x;
            this.mTranslationY = r2.y;
            setAnimationMatrix();
        }

        void setValues(float[] r4) {
            System.arraycopy(r4, 0, this.mValues, 0, r4.length);
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

        Transforms(View r2) {
            this.mTranslationX = r2.getTranslationX();
            this.mTranslationY = r2.getTranslationY();
            this.mTranslationZ = ViewCompat.getTranslationZ(r2);
            this.mScaleX = r2.getScaleX();
            this.mScaleY = r2.getScaleY();
            this.mRotationX = r2.getRotationX();
            this.mRotationY = r2.getRotationY();
            this.mRotationZ = r2.getRotation();
        }

        public boolean equals(Object r4) {
            if (ZeusTransformUtils.instanceOf(r4, Transforms.class) == true) goto L5;
            return false;
        L5:
            Transforms r5 = (Transforms) ZeusTransformUtils.preCheckCast(r4, Transforms.class, "com.obric.memorydata.plugin");
            if (r5.mTranslationX == this.mTranslationX) goto L8;
            return false;
        L8:
            if (r5.mTranslationY == this.mTranslationY) goto L10;
            return false;
        L10:
            if (r5.mTranslationZ == this.mTranslationZ) goto L12;
            return false;
        L12:
            if (r5.mScaleX == this.mScaleX) goto L14;
            return false;
        L14:
            if (r5.mScaleY == this.mScaleY) goto L16;
            return false;
        L16:
            if (r5.mRotationX == this.mRotationX) goto L18;
            return false;
        L18:
            if (r5.mRotationY == this.mRotationY) goto L20;
            return false;
        L20:
            if (r5.mRotationZ != this.mRotationZ) goto L30;
            return true;
        L30:
            return false;
        }

        public int hashCode() {
            float r0 = this.mTranslationX;
            int r3 = 0;
            if (r0 == 0.0f) goto L5;
            int r1 = Float.floatToIntBits(r0);
        L6:
            int r2 = r1 * 31;
            float r4 = this.mTranslationY;
            if (r4 == 0.0f) goto L9;
            int r5 = Float.floatToIntBits(r4);
        L10:
            int r6 = (r2 + r5) * 31;
            float r7 = this.mTranslationZ;
            if (r7 == 0.0f) goto L13;
            int r8 = Float.floatToIntBits(r7);
        L14:
            int r9 = (r6 + r8) * 31;
            float r10 = this.mScaleX;
            if (r10 == 0.0f) goto L17;
            int r11 = Float.floatToIntBits(r10);
        L18:
            int r12 = (r9 + r11) * 31;
            float r13 = this.mScaleY;
            if (r13 == 0.0f) goto L21;
            int r14 = Float.floatToIntBits(r13);
        L22:
            int r15 = (r12 + r14) * 31;
            float r16 = this.mRotationX;
            if (r16 == 0.0f) goto L25;
            int r17 = Float.floatToIntBits(r16);
        L26:
            int r18 = (r15 + r17) * 31;
            float r19 = this.mRotationY;
            if (r19 == 0.0f) goto L29;
            int r20 = Float.floatToIntBits(r19);
        L30:
            int r21 = (r18 + r20) * 31;
            float r22 = this.mRotationZ;
            if (r22 == 0.0f) goto L34;
            r3 = Float.floatToIntBits(r22);
        L34:
            return r21 + r3;
        L29:
            r20 = 0;
            goto L30
        L25:
            r17 = 0;
            goto L26
        L21:
            r14 = 0;
            goto L22
        L17:
            r11 = 0;
            goto L18
        L13:
            r8 = 0;
            goto L14
        L9:
            r5 = 0;
            goto L10
        L5:
            r1 = 0;
            goto L6
        }

        public void restore(View r10) {
            ChangeTransform.setTransforms(r10, this.mTranslationX, this.mTranslationY, this.mTranslationZ, this.mScaleX, this.mScaleY, this.mRotationX, this.mRotationY, this.mRotationZ);
        }
    }

    static {
        sTransitionProperties = new String[]{PROPNAME_MATRIX, PROPNAME_TRANSFORMS, PROPNAME_PARENT_MATRIX};
        final Class<float[]> r1 = float[].class;
        final String r2 = "nonTranslations";
        NON_TRANSLATIONS_PROPERTY = new AnonymousClass1(r1, r2);
        final Class<PointF> r3 = PointF.class;
        final String r4 = "translations";
        TRANSLATIONS_PROPERTY = new AnonymousClass2(r3, r4);
        if (Build.VERSION.SDK_INT < 21) goto L5;
        boolean r0 = true;
    L6:
        SUPPORTS_VIEW_REMOVAL_SUPPRESSION = r0;
        return;
    L5:
        r0 = false;
        goto L6
    }

    public ChangeTransform() {
        this.mUseOverlay = true;
        this.mReparent = true;
        this.mTempMatrix = new Matrix();
    }

    public ChangeTransform(Context r5, AttributeSet r6) {
        Context r7 = (Context) ZeusTransformUtils.wrapperContextForParams(r5, Context.class, "com.obric.memorydata.plugin");
        AttributeSet r8 = (AttributeSet) ZeusTransformUtils.wrapperContextForParams(r6, AttributeSet.class, "com.obric.memorydata.plugin");
        super(r7, r8);
        this.mUseOverlay = true;
        this.mReparent = true;
        this.mTempMatrix = new Matrix();
        TypedArray r9 = r7.obtainStyledAttributes(r8, Styleable.CHANGE_TRANSFORM);
        this.mUseOverlay = TypedArrayUtils.getNamedBoolean(r9, (XmlPullParser) ZeusTransformUtils.preCheckCast(r8, XmlPullParser.class, "com.obric.memorydata.plugin"), "reparentWithOverlay", 1, true);
        this.mReparent = TypedArrayUtils.getNamedBoolean(r9, (XmlPullParser) ZeusTransformUtils.preCheckCast(r8, XmlPullParser.class, "com.obric.memorydata.plugin"), "reparent", 0, true);
        r9.recycle();
    }

    private void captureValues(TransitionValues r5) {
        View r0 = r5.view;
        if (r0.getVisibility() != 8) goto L5;
        return;
    L5:
        r5.values.put(PROPNAME_PARENT, r0.getParent());
        r5.values.put(PROPNAME_TRANSFORMS, new Transforms(r0));
        Matrix r1 = r0.getMatrix();
        if (r1 != null) goto L8;
    L11:
        Matrix r2 = null;
    L12:
        r5.values.put(PROPNAME_MATRIX, r2);
        if (this.mReparent == false) goto L16;
        Matrix r4 = new Matrix();
        ViewGroup r3 = (ViewGroup) ZeusTransformUtils.preCheckCast(r0.getParent(), ViewGroup.class, "com.obric.memorydata.plugin");
        ViewUtils.transformMatrixToGlobal(r3, r4);
        r4.preTranslate(-r3.getScrollX(), -r3.getScrollY());
        r5.values.put(PROPNAME_PARENT_MATRIX, r4);
        r5.values.put(PROPNAME_INTERMEDIATE_MATRIX, r0.getTag(ZeusTransformUtils.mapRes(R.id.transition_transform, OaidModel.KEY_ID, "transition_transform")));
        r5.values.put(PROPNAME_INTERMEDIATE_PARENT_MATRIX, r0.getTag(ZeusTransformUtils.mapRes(R.id.parent_matrix, OaidModel.KEY_ID, "parent_matrix")));
        return;
    L16:
        return;
    L8:
        if (r1.isIdentity() == true) goto L11;
        r2 = new Matrix(r1);
        goto L12
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r4v1, types: [androidx.transition.Transition] */
    /* JADX WARN: Type inference failed for: r4v7 */
    /* JADX WARN: Type inference failed for: r4v8 */
    private void createGhostView(ViewGroup r5, TransitionValues r6, TransitionValues r7) {
        View r0 = r7.view;
        Matrix r2 = new Matrix((Matrix) ZeusTransformUtils.preCheckCast(r7.values.get(PROPNAME_PARENT_MATRIX), Matrix.class, "com.obric.memorydata.plugin"));
        ViewUtils.transformMatrixToLocal(r5, r2);
        GhostView r8 = GhostViewUtils.addGhost(r0, r5, r2);
        if (r8 != null) goto L5;
        return;
    L5:
        r8.reserveEndViewTransition((ViewGroup) ZeusTransformUtils.preCheckCast(r6.values.get(PROPNAME_PARENT), ViewGroup.class, "com.obric.memorydata.plugin"), r6.view);
        ?? r4 = this;
    L7:
        if (r4.mParent == null) goto L9;
        r4 = r4.mParent;
        goto L7
    L9:
        r4.addListener(new GhostListener(r0, r8));
        if (SUPPORTS_VIEW_REMOVAL_SUPPRESSION == true) goto L12;
        return;
    L12:
        if (r6.view == r7.view) goto L14;
        ViewUtils.setTransitionAlpha(r6.view, 0.0f);
    L14:
        ViewUtils.setTransitionAlpha(r0, 1.0f);
    }

    private ObjectAnimator createTransformAnimator(TransitionValues r13, TransitionValues r14, final boolean r15) {
        Matrix r16 = (Matrix) ZeusTransformUtils.preCheckCast(r13.values.get(PROPNAME_MATRIX), Matrix.class, "com.obric.memorydata.plugin");
        Matrix r0 = (Matrix) ZeusTransformUtils.preCheckCast(r14.values.get(PROPNAME_MATRIX), Matrix.class, "com.obric.memorydata.plugin");
        if (r16 != null) goto L5;
        r16 = MatrixUtils.IDENTITY_MATRIX;
    L5:
        if (r0 != null) goto L7;
        r0 = MatrixUtils.IDENTITY_MATRIX;
    L7:
        final Matrix r6 = r0;
        if (r16.equals(r6) == false) goto L11;
        return null;
    L11:
        final Transforms r8 = (Transforms) ZeusTransformUtils.preCheckCast(r14.values.get(PROPNAME_TRANSFORMS), Transforms.class, "com.obric.memorydata.plugin");
        final View r7 = r14.view;
        setIdentityTransforms(r7);
        float[] r1 = new float[9];
        r16.getValues(r1);
        float[] r17 = new float[9];
        r6.getValues(r17);
        final PathAnimatorMatrix r9 = new PathAnimatorMatrix(r7, r1);
        ObjectAnimator r18 = ObjectAnimator.ofPropertyValuesHolder(r9, new PropertyValuesHolder[]{PropertyValuesHolder.ofObject(NON_TRANSLATIONS_PROPERTY, new FloatArrayEvaluator(new float[9]), new float[][]{r1, r17}), PropertyValuesHolderUtils.ofPointF(TRANSLATIONS_PROPERTY, getPathMotion().getPath(r1[2], r1[5], r17[2], r17[5]))});
        AnimatorListenerAdapter r19 = new AnonymousClass3(this, r15, r6, r7, r8, r9);
        r18.addListener(r19);
        AnimatorUtils.addPauseListener(r18, r19);
        return r18;
    }

    private boolean parentsMatch(ViewGroup r4, ViewGroup r5) {
        boolean r1 = true;
        if (isValidTarget(r4) == true) goto L5;
    L12:
        if (r4 == r5) goto L16;
    L14:
        r1 = false;
    L16:
        return r1;
    L5:
        if (isValidTarget(r5) == false) goto L12;
        TransitionValues r3 = getMatchedTransitionValues(r4, true);
        if (r3 != null) goto L10;
        return false;
    L10:
        if (r5 != r3.view) goto L14;
        goto L14
    }

    static void setIdentityTransforms(View r9) {
        setTransforms(r9, 0.0f, 0.0f, 0.0f, 1.0f, 1.0f, 0.0f, 0.0f, 0.0f);
    }

    private void setMatricesForParent(TransitionValues r7, TransitionValues r8) {
        Matrix r0 = (Matrix) ZeusTransformUtils.preCheckCast(r8.values.get(PROPNAME_PARENT_MATRIX), Matrix.class, "com.obric.memorydata.plugin");
        r8.view.setTag(ZeusTransformUtils.mapRes(R.id.parent_matrix, OaidModel.KEY_ID, "parent_matrix"), r0);
        Matrix r6 = this.mTempMatrix;
        r6.reset();
        r0.invert(r6);
        Matrix r9 = (Matrix) ZeusTransformUtils.preCheckCast(r7.values.get(PROPNAME_MATRIX), Matrix.class, "com.obric.memorydata.plugin");
        if (r9 != null) goto L5;
        r9 = new Matrix();
        r7.values.put(PROPNAME_MATRIX, r9);
    L5:
        r9.postConcat((Matrix) ZeusTransformUtils.preCheckCast(r7.values.get(PROPNAME_PARENT_MATRIX), Matrix.class, "com.obric.memorydata.plugin"));
        r9.postConcat(r6);
    }

    static void setTransforms(View r0, float r1, float r2, float r3, float r4, float r5, float r6, float r7, float r8) {
        r0.setTranslationX(r1);
        r0.setTranslationY(r2);
        ViewCompat.setTranslationZ(r0, r3);
        r0.setScaleX(r4);
        r0.setScaleY(r5);
        r0.setRotationX(r6);
        r0.setRotationY(r7);
        r0.setRotation(r8);
    }

    @Override // androidx.transition.Transition
    public void captureEndValues(TransitionValues r1) {
        captureValues(r1);
    }

    @Override // androidx.transition.Transition
    public void captureStartValues(TransitionValues r3) {
        captureValues(r3);
        if (SUPPORTS_VIEW_REMOVAL_SUPPRESSION == true) goto L6;
        ((ViewGroup) ZeusTransformUtils.preCheckCast(r3.view.getParent(), ViewGroup.class, "com.obric.memorydata.plugin")).startViewTransition(r3.view);
        return;
    }

    @Override // androidx.transition.Transition
    public Animator createAnimator(ViewGroup r7, TransitionValues r8, TransitionValues r9) {
        if (r8 == null) goto L33;
        if (r9 != null) goto L5;
        return null;
    L5:
        if (r8.values.containsKey(PROPNAME_PARENT) == true) goto L7;
        return null;
    L7:
        if (r9.values.containsKey(PROPNAME_PARENT) == false) goto L37;
        ViewGroup r0 = (ViewGroup) ZeusTransformUtils.preCheckCast(r8.values.get(PROPNAME_PARENT), ViewGroup.class, "com.obric.memorydata.plugin");
        ViewGroup r1 = (ViewGroup) ZeusTransformUtils.preCheckCast(r9.values.get(PROPNAME_PARENT), ViewGroup.class, "com.obric.memorydata.plugin");
        if (this.mReparent == true) goto L12;
    L14:
        boolean r2 = false;
    L15:
        Matrix r3 = (Matrix) ZeusTransformUtils.preCheckCast(r8.values.get(PROPNAME_INTERMEDIATE_MATRIX), Matrix.class, "com.obric.memorydata.plugin");
        if (r3 == null) goto L18;
        r8.values.put(PROPNAME_MATRIX, r3);
    L18:
        Matrix r4 = (Matrix) ZeusTransformUtils.preCheckCast(r8.values.get(PROPNAME_INTERMEDIATE_PARENT_MATRIX), Matrix.class, "com.obric.memorydata.plugin");
        if (r4 == null) goto L21;
        r8.values.put(PROPNAME_PARENT_MATRIX, r4);
    L21:
        if (r2 == false) goto L23;
        setMatricesForParent(r8, r9);
    L23:
        ObjectAnimator r5 = createTransformAnimator(r8, r9, r2);
        if (r2 == false) goto L30;
        if (r5 == null) goto L30;
        if (this.mUseOverlay == false) goto L30;
        createGhostView(r7, r8, r9);
    L32:
        return r5;
    L30:
        if (SUPPORTS_VIEW_REMOVAL_SUPPRESSION == true) goto L32;
        r0.endViewTransition(r8.view);
        goto L32
    L12:
        if (parentsMatch(r0, r1) == true) goto L14;
        r2 = true;
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

    public void setReparent(boolean r1) {
        this.mReparent = r1;
    }

    public void setReparentWithOverlay(boolean r1) {
        this.mUseOverlay = r1;
    }
}
