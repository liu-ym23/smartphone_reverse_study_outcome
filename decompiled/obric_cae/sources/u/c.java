package u;

import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import androidx.constraintlayout.widget.ConstraintLayout;

/* JADX INFO: loaded from: classes.dex */
public final class c extends androidx.constraintlayout.widget.c implements d.c {

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public boolean f12402s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public boolean f12403t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public float f12404u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public View[] f12405v;

    @Override // u.d.c
    public final void a() {
    }

    @Override // u.d.c
    public final void b() {
    }

    public float getProgress() {
        return this.f12404u;
    }

    @Override // androidx.constraintlayout.widget.c
    public final void i(AttributeSet r8) {
        super.i(r8);
        if (r8 == null) goto L18;
        TypedArray r10 = getContext().obtainStyledAttributes(r8, v.d.f12662h);
        int r11 = r10.getIndexCount();
        int r12 = 0;
    L5:
        if (r12 >= r11) goto L12;
        int r13 = r10.getIndex(r12);
        if (r13 != 1) goto L9;
        this.f12402s = r10.getBoolean(r13, this.f12402s);
    L11:
        r12 = r12 + 1;
        goto L5
    L9:
        if (r13 != 0) goto L11;
        this.f12403t = r10.getBoolean(r13, this.f12403t);
        goto L11
    L12:
        r10.recycle();
        return;
    }

    public void setProgress(float r8) {
        this.f12404u = r8;
        int r10 = 0;
        if (this.f1431b <= 0) goto L17;
        ConstraintLayout r11 = (ConstraintLayout) getParent();
        View[] r12 = this.f1436q;
        if (r12 != null) goto L7;
    L8:
        this.f1436q = new View[this.f1431b];
    L9:
        int r13 = 0;
    L11:
        if (r13 >= this.f1431b) goto L13;
        this.f1436q[r13] = r11.f1343a.get(this.f1430a[r13]);
        r13 = r13 + 1;
        goto L11
    L13:
        this.f12405v = this.f1436q;
    L15:
        if (r10 >= this.f1431b) goto L20;
        View r14 = this.f12405v[r10];
        r10 = r10 + 1;
        goto L15
    L20:
        return;
    L7:
        if (r12.length == this.f1431b) goto L9;
    L17:
        ViewGroup r15 = (ViewGroup) getParent();
        int r16 = r15.getChildCount();
    L18:
        if (r10 >= r16) goto L24;
        boolean r17 = r15.getChildAt(r10) instanceof c;
        r10 = r10 + 1;
        goto L18
    }
}
