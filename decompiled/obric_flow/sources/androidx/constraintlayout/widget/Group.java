package androidx.constraintlayout.widget;

import android.content.Context;
import android.util.AttributeSet;

/* JADX INFO: loaded from: classes.dex */
public class Group extends ConstraintHelper {
    public Group(Context r5) {
        super(r5);
    }

    @Override // androidx.constraintlayout.widget.ConstraintHelper
    public void init(AttributeSet r5) {
        super.init(r5);
        this.mUseViewMeasure = false;
    }

    @Override // androidx.constraintlayout.widget.ConstraintHelper, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        applyLayoutFeatures();
    }

    @Override // android.view.View
    public void setElevation(float r5) {
        super.setElevation(r5);
        applyLayoutFeatures();
    }

    @Override // android.view.View
    public void setVisibility(int r5) {
        super.setVisibility(r5);
        applyLayoutFeatures();
    }

    @Override // androidx.constraintlayout.widget.ConstraintHelper
    public void updatePostLayout(ConstraintLayout r5) {
        ConstraintLayout.LayoutParams r10 = (ConstraintLayout.LayoutParams) getLayoutParams();
        r10.widget.setWidth(0);
        r10.widget.setHeight(0);
    }

    public Group(Context r5, AttributeSet r10) {
        super(r5, r10);
    }

    public Group(Context r5, AttributeSet r10, int r11) {
        super(r5, r10, r11);
    }
}
