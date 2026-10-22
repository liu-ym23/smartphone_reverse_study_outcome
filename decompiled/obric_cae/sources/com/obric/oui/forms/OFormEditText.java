package com.obric.oui.forms;

import android.content.Context;
import android.util.AttributeSet;
import androidx.appcompat.widget.AppCompatEditText;
import he.i;

/* JADX INFO: loaded from: classes2.dex */
public final class OFormEditText extends AppCompatEditText {

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public boolean f6287o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public boolean f6288p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public boolean f6289q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public boolean f6290r;

    public OFormEditText(Context r8, AttributeSet r10) {
        i.f(r8, "context");
        super(r8, r10, 0);
    }

    @Override // android.view.View
    public float getBottomFadingEdgeStrength() {
        if (this.f6290r == true) goto L7;
        return 0.0f;
    L7:
        return super.getBottomFadingEdgeStrength();
    }

    @Override // android.widget.TextView, android.view.View
    public float getLeftFadingEdgeStrength() {
        if (this.f6287o == true) goto L7;
        return 0.0f;
    L7:
        return super.getLeftFadingEdgeStrength();
    }

    @Override // android.widget.TextView, android.view.View
    public float getRightFadingEdgeStrength() {
        if (this.f6288p == true) goto L7;
        return 0.0f;
    L7:
        return super.getRightFadingEdgeStrength();
    }

    @Override // android.view.View
    public float getTopFadingEdgeStrength() {
        if (this.f6289q == true) goto L7;
        return 0.0f;
    L7:
        return super.getTopFadingEdgeStrength();
    }

    public final void setBottomFading(boolean r8) {
        this.f6290r = r8;
    }

    public final void setLeftFading(boolean r8) {
        this.f6287o = r8;
    }

    public final void setRightFading(boolean r8) {
        this.f6288p = r8;
    }

    public final void setTopFading(boolean r8) {
        this.f6289q = r8;
    }
}
