package v;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewParent;
import androidx.constraintlayout.widget.ConstraintLayout;
import s.l;

/* JADX INFO: loaded from: classes.dex */
public abstract class f extends androidx.constraintlayout.widget.c {

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public boolean f12667s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public boolean f12668t;

    public f(Context r8, AttributeSet r10) {
        super(r8, r10);
    }

    @Override // androidx.constraintlayout.widget.c
    public final void g(ConstraintLayout r8) {
        f(r8);
    }

    @Override // androidx.constraintlayout.widget.c
    public void i(AttributeSet r8) {
        super.i(r8);
        if (r8 == null) goto L19;
        TypedArray r10 = getContext().obtainStyledAttributes(r8, d.f12656b);
        int r11 = r10.getIndexCount();
        int r12 = 0;
    L5:
        if (r12 >= r11) goto L13;
        int r13 = r10.getIndex(r12);
        if (r13 != 6) goto L10;
        this.f12667s = true;
    L12:
        r12 = r12 + 1;
        goto L5
    L10:
        if (r13 != 22) goto L12;
        this.f12668t = true;
        goto L12
    L13:
        r10.recycle();
        return;
    }

    public void l(l r8, int r10, int r11) {
    }

    @Override // androidx.constraintlayout.widget.c, android.view.View
    public final void onAttachedToWindow() {
        super.onAttachedToWindow();
        if (this.f12667s == false) goto L5;
    L6:
        ViewParent r8 = getParent();
        if ((r8 instanceof ConstraintLayout) == false) goto L28;
        ConstraintLayout r10 = (ConstraintLayout) r8;
        int r11 = getVisibility();
        float r12 = getElevation();
        int r13 = 0;
    L10:
        if (r13 >= this.f1431b) goto L29;
        int r14 = this.f1430a[r13];
        View r15 = r10.f1343a.get(r14);
        if (r15 == null) goto L21;
        if (this.f12667s == false) goto L17;
        r15.setVisibility(r11);
    L17:
        if (this.f12668t == false) goto L21;
        if (r12 <= 0.0f) goto L21;
        r15.setTranslationZ(r15.getTranslationZ() + r12);
    L21:
        r13 = r13 + 1;
        goto L10
    L29:
        return;
    L28:
        return;
    L5:
        if (this.f12668t == true) goto L6;
    }

    @Override // android.view.View
    public void setElevation(float r8) {
        super.setElevation(r8);
        ViewParent r10 = getParent();
        if (r10 != null) goto L5;
        return;
    L5:
        if ((r10 instanceof ConstraintLayout) == false) goto L9;
        f((ConstraintLayout) r10);
        return;
    }

    @Override // android.view.View
    public void setVisibility(int r8) {
        super.setVisibility(r8);
        ViewParent r10 = getParent();
        if (r10 != null) goto L5;
        return;
    L5:
        if ((r10 instanceof ConstraintLayout) == false) goto L9;
        f((ConstraintLayout) r10);
        return;
    }
}
