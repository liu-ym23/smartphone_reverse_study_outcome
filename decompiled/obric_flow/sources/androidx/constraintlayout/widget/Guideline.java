package androidx.constraintlayout.widget;

import android.content.Context;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.view.View;

/* JADX INFO: loaded from: classes.dex */
public class Guideline extends View {
    public Guideline(Context r5) {
        super(r5);
        super.setVisibility(8);
    }

    @Override // android.view.View
    public void draw(Canvas r5) {
    }

    @Override // android.view.View
    public void onMeasure(int r5, int r10) {
        setMeasuredDimension(0, 0);
    }

    public void setGuidelineBegin(int r5) {
        ConstraintLayout.LayoutParams r10 = (ConstraintLayout.LayoutParams) getLayoutParams();
        r10.guideBegin = r5;
        setLayoutParams(r10);
    }

    public void setGuidelineEnd(int r5) {
        ConstraintLayout.LayoutParams r10 = (ConstraintLayout.LayoutParams) getLayoutParams();
        r10.guideEnd = r5;
        setLayoutParams(r10);
    }

    public void setGuidelinePercent(float r5) {
        ConstraintLayout.LayoutParams r10 = (ConstraintLayout.LayoutParams) getLayoutParams();
        r10.guidePercent = r5;
        setLayoutParams(r10);
    }

    @Override // android.view.View
    public void setVisibility(int r5) {
    }

    public Guideline(Context r5, AttributeSet r10) {
        super(r5, r10);
        super.setVisibility(8);
    }

    public Guideline(Context r5, AttributeSet r10, int r11) {
        super(r5, r10, r11);
        super.setVisibility(8);
    }

    public Guideline(Context r5, AttributeSet r10, int r11, int r12) {
        super(r5, r10, r11);
        super.setVisibility(8);
    }
}
