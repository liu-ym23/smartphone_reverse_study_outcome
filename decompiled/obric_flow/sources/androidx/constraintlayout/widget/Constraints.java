package androidx.constraintlayout.widget;

import android.content.Context;
import android.content.res.TypedArray;
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

        public LayoutParams(int r5, int r10) {
            super(r5, r10);
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

        public LayoutParams(LayoutParams r5) {
            super(r5);
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

        public LayoutParams(Context r5, AttributeSet r10) {
            super(r5, r10);
            this.alpha = 1.0f;
            int r11 = 0;
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
            TypedArray r12 = r5.obtainStyledAttributes(r10, R.styleable.ConstraintSet);
            int r13 = r12.getIndexCount();
        L3:
            if (r11 >= r13) goto L41;
            int r14 = r12.getIndex(r11);
            if (r14 != R.styleable.ConstraintSet_android_alpha) goto L8;
            this.alpha = r12.getFloat(r14, this.alpha);
        L40:
            r11 = r11 + 1;
            goto L3
        L8:
            if (r14 != R.styleable.ConstraintSet_android_elevation) goto L11;
            this.elevation = r12.getFloat(r14, this.elevation);
            this.applyElevation = true;
            goto L40
        L11:
            if (r14 != R.styleable.ConstraintSet_android_rotationX) goto L14;
            this.rotationX = r12.getFloat(r14, this.rotationX);
            goto L40
        L14:
            if (r14 != R.styleable.ConstraintSet_android_rotationY) goto L17;
            this.rotationY = r12.getFloat(r14, this.rotationY);
            goto L40
        L17:
            if (r14 != R.styleable.ConstraintSet_android_rotation) goto L20;
            this.rotation = r12.getFloat(r14, this.rotation);
            goto L40
        L20:
            if (r14 != R.styleable.ConstraintSet_android_scaleX) goto L23;
            this.scaleX = r12.getFloat(r14, this.scaleX);
            goto L40
        L23:
            if (r14 != R.styleable.ConstraintSet_android_scaleY) goto L26;
            this.scaleY = r12.getFloat(r14, this.scaleY);
            goto L40
        L26:
            if (r14 != R.styleable.ConstraintSet_android_transformPivotX) goto L29;
            this.transformPivotX = r12.getFloat(r14, this.transformPivotX);
            goto L40
        L29:
            if (r14 != R.styleable.ConstraintSet_android_transformPivotY) goto L32;
            this.transformPivotY = r12.getFloat(r14, this.transformPivotY);
            goto L40
        L32:
            if (r14 != R.styleable.ConstraintSet_android_translationX) goto L35;
            this.translationX = r12.getFloat(r14, this.translationX);
            goto L40
        L35:
            if (r14 != R.styleable.ConstraintSet_android_translationY) goto L38;
            this.translationY = r12.getFloat(r14, this.translationY);
            goto L40
        L38:
            if (r14 != R.styleable.ConstraintSet_android_translationZ) goto L40;
            this.translationZ = r12.getFloat(r14, this.translationZ);
            goto L40
        L41:
            r12.recycle();
        }
    }

    public Constraints(Context r5) {
        super(r5);
        super.setVisibility(8);
    }

    private void init(AttributeSet r5) {
        Log.v(TAG, " ################# init");
    }

    @Override // android.view.ViewGroup
    public /* bridge */ /* synthetic */ ViewGroup.LayoutParams generateDefaultLayoutParams() {
        return generateDefaultLayoutParams();
    }

    @Override // android.view.ViewGroup
    public /* bridge */ /* synthetic */ ViewGroup.LayoutParams generateLayoutParams(AttributeSet r5) {
        return generateLayoutParams(r5);
    }

    public ConstraintSet getConstraintSet() {
        if (this.myConstraintSet != null) goto L5;
        this.myConstraintSet = new ConstraintSet();
    L5:
        this.myConstraintSet.clone(this);
        return this.myConstraintSet;
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onLayout(boolean r5, int r10, int r11, int r12, int r13) {
    }

    @Override // android.view.ViewGroup
    public LayoutParams generateDefaultLayoutParams() {
        return new LayoutParams(-2, -2);
    }

    @Override // android.view.ViewGroup
    public LayoutParams generateLayoutParams(AttributeSet r5) {
        return new LayoutParams(getContext(), r5);
    }

    public Constraints(Context r5, AttributeSet r10) {
        super(r5, r10);
        init(r10);
        super.setVisibility(8);
    }

    @Override // android.view.ViewGroup
    public ViewGroup.LayoutParams generateLayoutParams(ViewGroup.LayoutParams r5) {
        return new ConstraintLayout.LayoutParams(r5);
    }

    public Constraints(Context r5, AttributeSet r10, int r11) {
        super(r5, r10, r11);
        init(r10);
        super.setVisibility(8);
    }
}
