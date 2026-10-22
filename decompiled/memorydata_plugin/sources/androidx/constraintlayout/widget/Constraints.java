package androidx.constraintlayout.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.os.Build;
import android.util.AttributeSet;
import android.util.Log;
import android.view.ViewGroup;
import com.obric.memorydata.plugin.R;
import com.volcengine.zeus.transform.ZeusTransformUtils;

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

        public LayoutParams(int r1, int r2) {
            super(r1, r2);
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

        public LayoutParams(Context r7, AttributeSet r8) {
            Context r9 = (Context) ZeusTransformUtils.wrapperContextForParams(r7, Context.class, "com.obric.memorydata.plugin");
            AttributeSet r10 = (AttributeSet) ZeusTransformUtils.wrapperContextForParams(r8, AttributeSet.class, "com.obric.memorydata.plugin");
            super(r9, r10);
            this.alpha = 1.0f;
            int r1 = 0;
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
            TypedArray r11 = r9.obtainStyledAttributes(r10, R.styleable.ConstraintSet);
            int r12 = r11.getIndexCount();
        L3:
            if (r1 >= r12) goto L45;
            int r0 = r11.getIndex(r1);
            if (r0 != ZeusTransformUtils.mapRes(R.styleable.ConstraintSet_android_alpha, "styleable", "ConstraintSet_android_alpha")) goto L8;
            this.alpha = r11.getFloat(r0, this.alpha);
        L44:
            r1 = r1 + 1;
            goto L3
        L8:
            if (r0 != ZeusTransformUtils.mapRes(R.styleable.ConstraintSet_android_elevation, "styleable", "ConstraintSet_android_elevation")) goto L13;
            if (Build.VERSION.SDK_INT < 21) goto L44;
            this.elevation = r11.getFloat(r0, this.elevation);
            this.applyElevation = true;
            goto L44
        L13:
            if (r0 != ZeusTransformUtils.mapRes(R.styleable.ConstraintSet_android_rotationX, "styleable", "ConstraintSet_android_rotationX")) goto L16;
            this.rotationX = r11.getFloat(r0, this.rotationX);
            goto L44
        L16:
            if (r0 != ZeusTransformUtils.mapRes(R.styleable.ConstraintSet_android_rotationY, "styleable", "ConstraintSet_android_rotationY")) goto L19;
            this.rotationY = r11.getFloat(r0, this.rotationY);
            goto L44
        L19:
            if (r0 != ZeusTransformUtils.mapRes(R.styleable.ConstraintSet_android_rotation, "styleable", "ConstraintSet_android_rotation")) goto L22;
            this.rotation = r11.getFloat(r0, this.rotation);
            goto L44
        L22:
            if (r0 != ZeusTransformUtils.mapRes(R.styleable.ConstraintSet_android_scaleX, "styleable", "ConstraintSet_android_scaleX")) goto L25;
            this.scaleX = r11.getFloat(r0, this.scaleX);
            goto L44
        L25:
            if (r0 != ZeusTransformUtils.mapRes(R.styleable.ConstraintSet_android_scaleY, "styleable", "ConstraintSet_android_scaleY")) goto L28;
            this.scaleY = r11.getFloat(r0, this.scaleY);
            goto L44
        L28:
            if (r0 != ZeusTransformUtils.mapRes(R.styleable.ConstraintSet_android_transformPivotX, "styleable", "ConstraintSet_android_transformPivotX")) goto L31;
            this.transformPivotX = r11.getFloat(r0, this.transformPivotX);
            goto L44
        L31:
            if (r0 != ZeusTransformUtils.mapRes(R.styleable.ConstraintSet_android_transformPivotY, "styleable", "ConstraintSet_android_transformPivotY")) goto L34;
            this.transformPivotY = r11.getFloat(r0, this.transformPivotY);
            goto L44
        L34:
            if (r0 != ZeusTransformUtils.mapRes(R.styleable.ConstraintSet_android_translationX, "styleable", "ConstraintSet_android_translationX")) goto L37;
            this.translationX = r11.getFloat(r0, this.translationX);
            goto L44
        L37:
            if (r0 != ZeusTransformUtils.mapRes(R.styleable.ConstraintSet_android_translationY, "styleable", "ConstraintSet_android_translationY")) goto L40;
            this.translationY = r11.getFloat(r0, this.translationY);
            goto L44
        L40:
            if (r0 != ZeusTransformUtils.mapRes(R.styleable.ConstraintSet_android_translationZ, "styleable", "ConstraintSet_android_translationZ")) goto L44;
            if (Build.VERSION.SDK_INT < 21) goto L44;
            this.translationZ = r11.getFloat(r0, this.translationZ);
            goto L44
        L45:
            r11.recycle();
        }

        public LayoutParams(LayoutParams r2) {
            super(r2);
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

    public Constraints(Context r3) {
        super((Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.memorydata.plugin"));
        super.setVisibility(8);
    }

    public Constraints(Context r3, AttributeSet r4) {
        Context r5 = (Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.memorydata.plugin");
        AttributeSet r6 = (AttributeSet) ZeusTransformUtils.wrapperContextForParams(r4, AttributeSet.class, "com.obric.memorydata.plugin");
        super(r5, r6);
        init(r6);
        super.setVisibility(8);
    }

    public Constraints(Context r3, AttributeSet r4, int r5) {
        Context r6 = (Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.memorydata.plugin");
        AttributeSet r7 = (AttributeSet) ZeusTransformUtils.wrapperContextForParams(r4, AttributeSet.class, "com.obric.memorydata.plugin");
        super(r6, r7, r5);
        init(r7);
        super.setVisibility(8);
    }

    private void init(AttributeSet r2) {
        AttributeSet r1 = (AttributeSet) ZeusTransformUtils.wrapperContextForParams(r2, AttributeSet.class, "com.obric.memorydata.plugin");
        Log.v(TAG, " ################# init");
    }

    @Override // android.view.ViewGroup
    public /* bridge */ /* synthetic */ ViewGroup.LayoutParams generateDefaultLayoutParams() {
        return generateDefaultLayoutParams();
    }

    @Override // android.view.ViewGroup
    public LayoutParams generateDefaultLayoutParams() {
        return new LayoutParams(-2, -2);
    }

    @Override // android.view.ViewGroup
    public /* synthetic */ ViewGroup.LayoutParams generateLayoutParams(AttributeSet r3) {
        return generateLayoutParams((AttributeSet) ZeusTransformUtils.wrapperContextForParams(r3, AttributeSet.class, "com.obric.memorydata.plugin"));
    }

    @Override // android.view.ViewGroup
    public ViewGroup.LayoutParams generateLayoutParams(ViewGroup.LayoutParams r1) {
        return new ConstraintLayout.LayoutParams(r1);
    }

    @Override // android.view.ViewGroup
    public LayoutParams generateLayoutParams(AttributeSet r4) {
        AttributeSet r5 = (AttributeSet) ZeusTransformUtils.wrapperContextForParams(r4, AttributeSet.class, "com.obric.memorydata.plugin");
        return new LayoutParams((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(getContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin"), r5);
    }

    public ConstraintSet getConstraintSet() {
        if (this.myConstraintSet != null) goto L5;
        this.myConstraintSet = new ConstraintSet();
    L5:
        this.myConstraintSet.clone(this);
        return this.myConstraintSet;
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onLayout(boolean r1, int r2, int r3, int r4, int r5) {
    }
}
