package androidx.constraintlayout.widget;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.view.View;
import androidx.constraintlayout.motion.widget.MotionLayout;

/* JADX INFO: loaded from: classes.dex */
public class ReactiveGuide extends View implements SharedValues.SharedValuesListener {
    private boolean mAnimateChange;
    private boolean mApplyToAllConstraintSets;
    private int mApplyToConstraintSetId;
    private int mAttributeId;

    public ReactiveGuide(Context r10) {
        super(r10);
        this.mAttributeId = -1;
        this.mAnimateChange = false;
        this.mApplyToConstraintSetId = 0;
        this.mApplyToAllConstraintSets = true;
        super.setVisibility(8);
        init(null);
    }

    public ReactiveGuide(Context r10, AttributeSet r11) {
        super(r10, r11);
        this.mAttributeId = -1;
        this.mAnimateChange = false;
        this.mApplyToConstraintSetId = 0;
        this.mApplyToAllConstraintSets = true;
        super.setVisibility(8);
        init(r11);
    }

    public ReactiveGuide(Context r10, AttributeSet r11, int r12) {
        super(r10, r11, r12);
        this.mAttributeId = -1;
        this.mAnimateChange = false;
        this.mApplyToConstraintSetId = 0;
        this.mApplyToAllConstraintSets = true;
        super.setVisibility(8);
        init(r11);
    }

    public ReactiveGuide(Context r10, AttributeSet r11, int r12, int r13) {
        super(r10, r11, r12);
        this.mAttributeId = -1;
        this.mAnimateChange = false;
        this.mApplyToConstraintSetId = 0;
        this.mApplyToAllConstraintSets = true;
        super.setVisibility(8);
        init(r11);
    }

    private void changeValue(int r10, int r11, MotionLayout r12, int r13) {
        ConstraintSet r14 = r12.getConstraintSet(r13);
        r14.setGuidelineEnd(r11, r10);
        r12.updateState(r13, r14);
    }

    private void init(AttributeSet r10) {
        if (r10 == null) goto L20;
        TypedArray r11 = getContext().obtainStyledAttributes(r10, R.styleable.ConstraintLayout_ReactiveGuide);
        int r12 = r11.getIndexCount();
        int r13 = 0;
    L4:
        if (r13 >= r12) goto L18;
        int r14 = r11.getIndex(r13);
        if (r14 != R.styleable.ConstraintLayout_ReactiveGuide_reactiveGuide_valueId) goto L9;
        this.mAttributeId = r11.getResourceId(r14, this.mAttributeId);
    L17:
        r13 = r13 + 1;
        goto L4
    L9:
        if (r14 != R.styleable.ConstraintLayout_ReactiveGuide_reactiveGuide_animateChange) goto L12;
        this.mAnimateChange = r11.getBoolean(r14, this.mAnimateChange);
        goto L17
    L12:
        if (r14 != R.styleable.ConstraintLayout_ReactiveGuide_reactiveGuide_applyToConstraintSet) goto L15;
        this.mApplyToConstraintSetId = r11.getResourceId(r14, this.mApplyToConstraintSetId);
        goto L17
    L15:
        if (r14 != R.styleable.ConstraintLayout_ReactiveGuide_reactiveGuide_applyToAllConstraintSets) goto L17;
        this.mApplyToAllConstraintSets = r11.getBoolean(r14, this.mApplyToAllConstraintSets);
        goto L17
    L18:
        r11.recycle();
    L20:
        if (this.mAttributeId == (-1)) goto L29;
        ConstraintLayout.getSharedValues().addListener(this.mAttributeId, this);
        return;
    }

    @Override // android.view.View
    @SuppressLint({"MissingSuperCall"})
    public void draw(Canvas r10) {
    }

    public int getApplyToConstraintSetId() {
        return this.mApplyToConstraintSetId;
    }

    public int getAttributeId() {
        return this.mAttributeId;
    }

    public boolean isAnimatingChange() {
        return this.mAnimateChange;
    }

    @Override // android.view.View
    protected void onMeasure(int r10, int r11) {
        setMeasuredDimension(0, 0);
    }

    @Override // androidx.constraintlayout.widget.SharedValues.SharedValuesListener
    public void onNewValue(int r10, int r11, int r12) {
        setGuidelineBegin(r11);
        int r13 = getId();
        if (r13 > 0) goto L6;
        return;
    L6:
        if ((getParent() instanceof MotionLayout) == false) goto L34;
        MotionLayout r14 = (MotionLayout) getParent();
        int r15 = r14.getCurrentState();
        int r16 = this.mApplyToConstraintSetId;
        if (r16 == 0) goto L10;
        r15 = r16;
    L10:
        int r17 = 0;
        if (this.mAnimateChange == false) goto L23;
        if (this.mApplyToAllConstraintSets == false) goto L21;
        int[] r18 = r14.getConstraintSetIds();
    L16:
        if (r17 >= r18.length) goto L21;
        int r19 = r18[r17];
        if (r19 == r15) goto L20;
        changeValue(r11, r13, r14, r19);
    L20:
        r17 = r17 + 1;
    L21:
        ConstraintSet r20 = r14.cloneConstraintSet(r15);
        r20.setGuidelineEnd(r13, r11);
        r14.updateStateAnimate(r15, r20, 1000);
        return;
    L23:
        if (this.mApplyToAllConstraintSets == false) goto L28;
        int[] r21 = r14.getConstraintSetIds();
    L26:
        if (r17 >= r21.length) goto L36;
        changeValue(r11, r13, r14, r21[r17]);
        r17 = r17 + 1;
        goto L26
    L36:
        return;
    L28:
        changeValue(r11, r13, r14, r15);
        return;
    }

    public void setAnimateChange(boolean r10) {
        this.mAnimateChange = r10;
    }

    public void setApplyToConstraintSetId(int r10) {
        this.mApplyToConstraintSetId = r10;
    }

    public void setAttributeId(int r10) {
        SharedValues r11 = ConstraintLayout.getSharedValues();
        int r12 = this.mAttributeId;
        if (r12 == (-1)) goto L5;
        r11.removeListener(r12, this);
    L5:
        this.mAttributeId = r10;
        if (r10 == (-1)) goto L9;
        r11.addListener(r10, this);
        return;
    }

    public void setGuidelineBegin(int r10) {
        ConstraintLayout.LayoutParams r11 = (ConstraintLayout.LayoutParams) getLayoutParams();
        r11.guideBegin = r10;
        setLayoutParams(r11);
    }

    public void setGuidelineEnd(int r10) {
        ConstraintLayout.LayoutParams r11 = (ConstraintLayout.LayoutParams) getLayoutParams();
        r11.guideEnd = r10;
        setLayoutParams(r11);
    }

    public void setGuidelinePercent(float r10) {
        ConstraintLayout.LayoutParams r11 = (ConstraintLayout.LayoutParams) getLayoutParams();
        r11.guidePercent = r10;
        setLayoutParams(r11);
    }

    @Override // android.view.View
    public void setVisibility(int r10) {
    }
}
