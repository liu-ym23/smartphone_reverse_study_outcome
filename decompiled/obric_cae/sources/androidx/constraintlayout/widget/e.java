package androidx.constraintlayout.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import java.util.HashMap;

/* JADX INFO: loaded from: classes.dex */
public final class e extends ViewGroup {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public d f1531a;

    public static class a extends ConstraintLayout.a {
        public final float A0;
        public final float B0;
        public final float C0;
        public final float D0;

        /* JADX INFO: renamed from: r0, reason: collision with root package name */
        public final float f1532r0;

        /* JADX INFO: renamed from: s0, reason: collision with root package name */
        public final boolean f1533s0;

        /* JADX INFO: renamed from: t0, reason: collision with root package name */
        public final float f1534t0;

        /* JADX INFO: renamed from: u0, reason: collision with root package name */
        public final float f1535u0;

        /* JADX INFO: renamed from: v0, reason: collision with root package name */
        public final float f1536v0;

        /* JADX INFO: renamed from: w0, reason: collision with root package name */
        public final float f1537w0;

        /* JADX INFO: renamed from: x0, reason: collision with root package name */
        public final float f1538x0;

        /* JADX INFO: renamed from: y0, reason: collision with root package name */
        public final float f1539y0;

        /* JADX INFO: renamed from: z0, reason: collision with root package name */
        public final float f1540z0;

        public a() {
            super(-2, -2);
            this.f1532r0 = 1.0f;
            this.f1533s0 = false;
            this.f1534t0 = 0.0f;
            this.f1535u0 = 0.0f;
            this.f1536v0 = 0.0f;
            this.f1537w0 = 0.0f;
            this.f1538x0 = 1.0f;
            this.f1539y0 = 1.0f;
            this.f1540z0 = 0.0f;
            this.A0 = 0.0f;
            this.B0 = 0.0f;
            this.C0 = 0.0f;
            this.D0 = 0.0f;
        }

        public a(Context r8, AttributeSet r10) {
            super(r8, r10);
            this.f1532r0 = 1.0f;
            int r11 = 0;
            this.f1533s0 = false;
            this.f1534t0 = 0.0f;
            this.f1535u0 = 0.0f;
            this.f1536v0 = 0.0f;
            this.f1537w0 = 0.0f;
            this.f1538x0 = 1.0f;
            this.f1539y0 = 1.0f;
            this.f1540z0 = 0.0f;
            this.A0 = 0.0f;
            this.B0 = 0.0f;
            this.C0 = 0.0f;
            this.D0 = 0.0f;
            TypedArray r12 = r8.obtainStyledAttributes(r10, v.d.f12658d);
            int r13 = r12.getIndexCount();
        L3:
            if (r11 >= r13) goto L41;
            int r14 = r12.getIndex(r11);
            if (r14 != 15) goto L8;
            this.f1532r0 = r12.getFloat(r14, this.f1532r0);
        L40:
            r11 = r11 + 1;
            goto L3
        L8:
            if (r14 != 28) goto L11;
            this.f1534t0 = r12.getFloat(r14, this.f1534t0);
            this.f1533s0 = true;
            goto L40
        L11:
            if (r14 != 23) goto L14;
            this.f1536v0 = r12.getFloat(r14, this.f1536v0);
            goto L40
        L14:
            if (r14 != 24) goto L17;
            this.f1537w0 = r12.getFloat(r14, this.f1537w0);
            goto L40
        L17:
            if (r14 != 22) goto L20;
            this.f1535u0 = r12.getFloat(r14, this.f1535u0);
            goto L40
        L20:
            if (r14 != 20) goto L23;
            this.f1538x0 = r12.getFloat(r14, this.f1538x0);
            goto L40
        L23:
            if (r14 != 21) goto L26;
            this.f1539y0 = r12.getFloat(r14, this.f1539y0);
            goto L40
        L26:
            if (r14 != 16) goto L29;
            this.f1540z0 = r12.getFloat(r14, this.f1540z0);
            goto L40
        L29:
            if (r14 != 17) goto L32;
            this.A0 = r12.getFloat(r14, this.A0);
            goto L40
        L32:
            if (r14 != 18) goto L35;
            this.B0 = r12.getFloat(r14, this.B0);
            goto L40
        L35:
            if (r14 != 19) goto L38;
            this.C0 = r12.getFloat(r14, this.C0);
            goto L40
        L38:
            if (r14 != 27) goto L40;
            this.D0 = r12.getFloat(r14, this.D0);
            goto L40
        L41:
            r12.recycle();
        }
    }

    @Override // android.view.ViewGroup
    public final ViewGroup.LayoutParams generateDefaultLayoutParams() {
        return new a();
    }

    @Override // android.view.ViewGroup
    public final ViewGroup.LayoutParams generateLayoutParams(AttributeSet r8) {
        return new a(getContext(), r8);
    }

    public d getConstraintSet() {
        if (this.f1531a != null) goto L5;
        this.f1531a = new d();
    L5:
        d r8 = this.f1531a;
        r8.getClass();
        int r10 = getChildCount();
        HashMap<Integer, d.a> r11 = r8.f1443c;
        r11.clear();
        int r12 = 0;
    L6:
        if (r12 >= r10) goto L28;
        View r13 = getChildAt(r12);
        a r14 = (a) r13.getLayoutParams();
        int r15 = r13.getId();
        if (r8.f1442b == false) goto L15;
        if (r15 != (-1)) goto L15;
        throw new RuntimeException("All children of ConstraintLayout must have ids to use ConstraintSet");
    L15:
        if (r11.containsKey(Integer.valueOf(r15)) == true) goto L17;
        r11.put(Integer.valueOf(r15), new d.a());
    L17:
        d.a r16 = r11.get(Integer.valueOf(r15));
        if (r16 == null) goto L26;
        if ((r13 instanceof c) == false) goto L25;
        c r17 = (c) r13;
        r16.c(r15, r14);
        if ((r17 instanceof androidx.constraintlayout.widget.a) == false) goto L25;
        d.b r18 = r16.f1447d;
        r18.f1477h0 = 1;
        androidx.constraintlayout.widget.a r19 = (androidx.constraintlayout.widget.a) r17;
        r18.f1473f0 = r19.getType();
        r18.f1479i0 = r19.getReferencedIds();
        r18.f1475g0 = r19.getMargin();
    L25:
        r16.c(r15, r14);
    L26:
        r12 = r12 + 1;
        goto L6
    L28:
        return this.f1531a;
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void onLayout(boolean r8, int r10, int r11, int r12, int r13) {
    }

    @Override // android.view.ViewGroup
    public final ViewGroup.LayoutParams generateLayoutParams(ViewGroup.LayoutParams r8) {
        return new ConstraintLayout.a(r8);
    }
}
