package androidx.constraintlayout.widget;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.view.View;

/* JADX INFO: loaded from: classes.dex */
public class Guideline extends View {
    private boolean mFilterRedundantCalls;

    public Guideline(Context r10) {
        super(r10);
        this.mFilterRedundantCalls = true;
        super.setVisibility(8);
    }

    public Guideline(Context r10, AttributeSet r11) {
        super(r10, r11);
        this.mFilterRedundantCalls = true;
        super.setVisibility(8);
    }

    public Guideline(Context r10, AttributeSet r11, int r12) {
        super(r10, r11, r12);
        this.mFilterRedundantCalls = true;
        super.setVisibility(8);
    }

    public Guideline(Context r10, AttributeSet r11, int r12, int r13) {
        super(r10, r11, r12);
        this.mFilterRedundantCalls = true;
        super.setVisibility(8);
    }

    @Override // android.view.View
    @SuppressLint({"MissingSuperCall"})
    public void draw(Canvas r10) {
    }

    @Override // android.view.View
    protected void onMeasure(int r10, int r11) {
        setMeasuredDimension(0, 0);
    }

    public void setFilterRedundantCalls(boolean r10) {
        this.mFilterRedundantCalls = r10;
    }

    public void setGuidelineBegin(int r10) {
        ConstraintLayout.LayoutParams r11 = (ConstraintLayout.LayoutParams) getLayoutParams();
        if (this.mFilterRedundantCalls == true) goto L5;
    L7:
        r11.guideBegin = r10;
        setLayoutParams(r11);
        return;
    L5:
        if (r11.guideBegin != r10) goto L7;
    }

    public void setGuidelineEnd(int r10) {
        ConstraintLayout.LayoutParams r11 = (ConstraintLayout.LayoutParams) getLayoutParams();
        if (this.mFilterRedundantCalls == true) goto L5;
    L7:
        r11.guideEnd = r10;
        setLayoutParams(r11);
        return;
    L5:
        if (r11.guideEnd != r10) goto L7;
    }

    public void setGuidelinePercent(float r10) {
        ConstraintLayout.LayoutParams r11 = (ConstraintLayout.LayoutParams) getLayoutParams();
        if (this.mFilterRedundantCalls == true) goto L5;
    L7:
        r11.guidePercent = r10;
        setLayoutParams(r11);
        return;
    L5:
        if (r11.guidePercent != r10) goto L7;
    }

    @Override // android.view.View
    public void setVisibility(int r10) {
    }
}
