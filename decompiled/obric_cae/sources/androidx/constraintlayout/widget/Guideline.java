package androidx.constraintlayout.widget;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.view.View;

/* JADX INFO: loaded from: classes.dex */
public class Guideline extends View {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public boolean f1409a;

    public Guideline(Context r8) {
        super(r8);
        this.f1409a = true;
        super.setVisibility(8);
    }

    @Override // android.view.View
    @SuppressLint({"MissingSuperCall"})
    public final void draw(Canvas r8) {
    }

    @Override // android.view.View
    public final void onMeasure(int r8, int r10) {
        setMeasuredDimension(0, 0);
    }

    public void setFilterRedundantCalls(boolean r8) {
        this.f1409a = r8;
    }

    public void setGuidelineBegin(int r8) {
        ConstraintLayout.a r10 = (ConstraintLayout.a) getLayoutParams();
        if (this.f1409a == true) goto L5;
    L7:
        r10.f1358a = r8;
        setLayoutParams(r10);
        return;
    L5:
        if (r10.f1358a != r8) goto L7;
    }

    public void setGuidelineEnd(int r8) {
        ConstraintLayout.a r10 = (ConstraintLayout.a) getLayoutParams();
        if (this.f1409a == true) goto L5;
    L7:
        r10.f1360b = r8;
        setLayoutParams(r10);
        return;
    L5:
        if (r10.f1360b != r8) goto L7;
    }

    public void setGuidelinePercent(float r8) {
        ConstraintLayout.a r10 = (ConstraintLayout.a) getLayoutParams();
        if (this.f1409a == true) goto L5;
    L7:
        r10.f1362c = r8;
        setLayoutParams(r10);
        return;
    L5:
        if (r10.f1362c != r8) goto L7;
    }

    @Override // android.view.View
    public void setVisibility(int r8) {
    }

    public Guideline(Context r8, AttributeSet r10) {
        super(r8, r10);
        this.f1409a = true;
        super.setVisibility(8);
    }
}
