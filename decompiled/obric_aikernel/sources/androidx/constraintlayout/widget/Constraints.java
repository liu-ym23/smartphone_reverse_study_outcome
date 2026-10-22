package androidx.constraintlayout.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.os.Build;
import android.util.AttributeSet;
import android.util.Log;
import android.view.ViewGroup;

/* JADX INFO: loaded from: classes.dex */
public class Constraints extends ViewGroup {
    public static final String TAG = "Constraints";
    ConstraintSet myConstraintSet;

    public static class LayoutParams extends ConstraintLayout.LayoutParams {
        public float alpha;
        public boolean applyElevation;
        public float elevation;
        public float rotation;
        public float rotationX;
        public float rotationY;
        public float scaleX;
        public float scaleY;
        public float transformPivotX;
        public float transformPivotY;
        public float translationX;
        public float translationY;
        public float translationZ;

        public LayoutParams(int r10, int r11) {
            super(r10, r11);
            this.alpha = 1.0f;
            this.applyElevation = false;
            this.elevation = 0.0f;
            this.rotation = 0.0f;
            this.rotationX = 0.0f;
            this.rotationY = 0.0f;
            this.scaleX = 1.0f;
            this.scaleY = 1.0f;
            this.transformPivotX = 0.0f;
            this.transformPivotY = 0.0f;
            this.translationX = 0.0f;
            this.translationY = 0.0f;
            this.translationZ = 0.0f;
        }

        public LayoutParams(Context r10, AttributeSet r11) {
            super(r10, r11);
            this.alpha = 1.0f;
            int r12 = 0;
            this.applyElevation = false;
            this.elevation = 0.0f;
            this.rotation = 0.0f;
            this.rotationX = 0.0f;
            this.rotationY = 0.0f;
            this.scaleX = 1.0f;
            this.scaleY = 1.0f;
            this.transformPivotX = 0.0f;
            this.transformPivotY = 0.0f;
            this.translationX = 0.0f;
            this.translationY = 0.0f;
            this.translationZ = 0.0f;
            TypedArray r13 = r10.obtainStyledAttributes(r11, R.styleable.ConstraintSet);
            int r14 = r13.getIndexCount();
        L3:
            if (r12 >= r14) goto L45;
            int r15 = r13.getIndex(r12);
            if (r15 != R.styleable.ConstraintSet_android_alpha) goto L8;
            this.alpha = r13.getFloat(r15, this.alpha);
        L44:
            r12 = r12 + 1;
            goto L3
        L8:
            if (r15 != R.styleable.ConstraintSet_android_elevation) goto L13;
            if (Build.VERSION.SDK_INT < 21) goto L44;
            this.elevation = r13.getFloat(r15, this.elevation);
            this.applyElevation = true;
            goto L44
        L13:
            if (r15 != R.styleable.ConstraintSet_android_rotationX) goto L16;
            this.rotationX = r13.getFloat(r15, this.rotationX);
            goto L44
        L16:
            if (r15 != R.styleable.ConstraintSet_android_rotationY) goto L19;
            this.rotationY = r13.getFloat(r15, this.rotationY);
            goto L44
        L19:
            if (r15 != R.styleable.ConstraintSet_android_rotation) goto L22;
            this.rotation = r13.getFloat(r15, this.rotation);
            goto L44
        L22:
            if (r15 != R.styleable.ConstraintSet_android_scaleX) goto L25;
            this.scaleX = r13.getFloat(r15, this.scaleX);
            goto L44
        L25:
            if (r15 != R.styleable.ConstraintSet_android_scaleY) goto L28;
            this.scaleY = r13.getFloat(r15, this.scaleY);
            goto L44
        L28:
            if (r15 != R.styleable.ConstraintSet_android_transformPivotX) goto L31;
            this.transformPivotX = r13.getFloat(r15, this.transformPivotX);
            goto L44
        L31:
            if (r15 != R.styleable.ConstraintSet_android_transformPivotY) goto L34;
            this.transformPivotY = r13.getFloat(r15, this.transformPivotY);
            goto L44
        L34:
            if (r15 != R.styleable.ConstraintSet_android_translationX) goto L37;
            this.translationX = r13.getFloat(r15, this.translationX);
            goto L44
        L37:
            if (r15 != R.styleable.ConstraintSet_android_translationY) goto L40;
            this.translationY = r13.getFloat(r15, this.translationY);
            goto L44
        L40:
            if (r15 != R.styleable.ConstraintSet_android_translationZ) goto L44;
            if (Build.VERSION.SDK_INT < 21) goto L44;
            this.translationZ = r13.getFloat(r15, this.translationZ);
            goto L44
        L45:
            r13.recycle();
        }

        public LayoutParams(LayoutParams r10) {
            super(r10);
            this.alpha = 1.0f;
            this.applyElevation = false;
            this.elevation = 0.0f;
            this.rotation = 0.0f;
            this.rotationX = 0.0f;
            this.rotationY = 0.0f;
            this.scaleX = 1.0f;
            this.scaleY = 1.0f;
            this.transformPivotX = 0.0f;
            this.transformPivotY = 0.0f;
            this.translationX = 0.0f;
            this.translationY = 0.0f;
            this.translationZ = 0.0f;
        }
    }

    public Constraints(Context r10) {
        super(r10);
        super.setVisibility(8);
    }

    public Constraints(Context r10, AttributeSet r11) {
        super(r10, r11);
        init(r11);
        super.setVisibility(8);
    }

    public Constraints(Context r10, AttributeSet r11, int r12) {
        super(r10, r11, r12);
        init(r11);
        super.setVisibility(8);
    }

    private void init(AttributeSet r10) {
        Log.v(TAG, " ################# init");
    }

    @Override // android.view.ViewGroup
    protected /* bridge */ /* synthetic */ ViewGroup.LayoutParams generateDefaultLayoutParams() {
        return generateDefaultLayoutParams();
    }

    @Override // android.view.ViewGroup
    protected LayoutParams generateDefaultLayoutParams() {
        return new LayoutParams(-2, -2);
    }

    @Override // android.view.ViewGroup
    public /* bridge */ /* synthetic */ ViewGroup.LayoutParams generateLayoutParams(AttributeSet r10) {
        return generateLayoutParams(r10);
    }

    @Override // android.view.ViewGroup
    protected ViewGroup.LayoutParams generateLayoutParams(ViewGroup.LayoutParams r10) {
        return new ConstraintLayout.LayoutParams(r10);
    }

    @Override // android.view.ViewGroup
    public LayoutParams generateLayoutParams(AttributeSet r10) {
        return new LayoutParams(getContext(), r10);
    }

    public ConstraintSet getConstraintSet() {
        if (this.myConstraintSet != null) goto L5;
        this.myConstraintSet = new ConstraintSet();
    L5:
        this.myConstraintSet.clone(this);
        return this.myConstraintSet;
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onLayout(boolean r10, int r11, int r12, int r13, int r14) {
    }
}
