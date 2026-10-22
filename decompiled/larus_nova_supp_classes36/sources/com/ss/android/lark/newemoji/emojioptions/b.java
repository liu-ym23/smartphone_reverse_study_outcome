package com.ss.android.lark.newemoji.emojioptions;

import android.content.Context;
import android.widget.LinearLayout;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public final class b extends LinearLayout implements i {
    public final c a;
    public int b;
    public float c;
    public int d;
    public int e;

    public static final class a {
    }

    static {
    }

    @Override // com.ss.android.lark.newemoji.emojioptions.i
    public final Context a() {
        if ((this instanceof Fragment) == false) goto L5;
        FragmentActivity r0 = ((Fragment) this).requireActivity();
    L6:
        if (r0 == null) goto L9;
        return r0;
    L9:
        throw new IllegalStateException("Currently no implementation found");
    L5:
        r0 = getContext();
        goto L6
    }

    public final void b() {
        if (this.b != 48) goto L5;
        this.e = getPaddingBottom() - ((int) this.c);
        this.d = getPaddingTop();
        return;
    L5:
        this.d = getPaddingTop() - ((int) this.c);
        this.e = getPaddingBottom();
    }

    public final float getTailWidth() {
        return this.a.f;
    }

    public b(Context r2) {
        Intrinsics.checkNotNullParameter(r2, "context");
        super(r2);
        c r0 = new c(r2);
        this.a = r0;
        this.b = 80;
        this.c = i.a.a(this, 7);
        setBackground(r0);
        setTailHeight(this.c);
        setPopupGravity(this.b);
    }

    public final void setBorderColor(int r2) {
        this.a.h = r2;
    }

    public final void setBorderRadius(float r2) {
        this.a.d = r2;
    }

    public final void setBorderWidth(float r2) {
        this.a.e = r2;
    }

    public final void setColor(int r2) {
        this.a.i = r2;
    }

    public final void setPopupGravity(int r4) {
        c r0 = this.a;
        r0.getClass();
        if (r4 != 48) goto L5;
    L7:
        r0.k = r4;
    L8:
        this.b = r4;
        setPadding(getPaddingLeft(), this.d, getPaddingRight(), this.e);
        return;
    L5:
        if (r4 == 80) goto L7;
        goto L7
    }

    public final void setTailHeight(float r4) {
        this.a.g = r4;
        this.c = r4;
        setPadding(getPaddingLeft(), this.d, getPaddingRight(), this.e);
    }

    public final void setTailOffsetX(float r2) {
        this.a.j = r2;
    }

    public final void setTailWidth(float r2) {
        this.a.f = r2;
    }

    @Override // android.view.View
    public final void setPadding(int r3, int r4, int r5, int r6) {
        if (this.b != 48) goto L5;
        r6 = r6 + ((int) this.c);
    L6:
        super.setPadding(r3, r4, r5, r6);
        b();
        return;
    L5:
        r4 = r4 + ((int) this.c);
        goto L6
    }

    @Override // android.view.View
    public final void setPaddingRelative(int r2, int r3, int r4, int r5) {
        if (this.b != 48) goto L5;
        r5 = r5 + ((int) this.c);
    L6:
        super.setPaddingRelative(r2, r3, getRight(), r5);
        b();
        return;
    L5:
        r3 = r3 + ((int) this.c);
        goto L6
    }
}
