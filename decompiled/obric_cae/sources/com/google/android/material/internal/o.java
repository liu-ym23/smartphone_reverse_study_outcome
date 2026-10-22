package com.google.android.material.internal;

import android.view.View;
import android.view.ViewGroup;
import com.google.android.material.bottomsheet.BottomSheetBehavior;
import j0.m0;

/* JADX INFO: loaded from: classes.dex */
public final class o implements j0.q {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ q.a f4891a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ q.b f4892b;

    public o(k9.b r8, q.b r10) {
        this.f4891a = r8;
        this.f4892b = r10;
    }

    @Override // j0.q
    public final m0 a(View r14, m0 r15) {
        q.b r8 = new q.b(this.f4892b);
        k9.b r13 = (k9.b) this.f4891a;
        r13.getClass();
        a0.b r10 = r15.a(7);
        a0.b r11 = r15.a(32);
        int r12 = r10.f5b;
        BottomSheetBehavior r16 = r13.f8976b;
        r16.f4430w = r12;
        boolean r17 = q.a(r14);
        int r18 = r14.getPaddingBottom();
        int r19 = r14.getPaddingLeft();
        int r20 = r14.getPaddingRight();
        boolean r21 = r16.f4422o;
        if (r21 == false) goto L5;
        int r22 = r15.b();
        r16.f4429v = r22;
        r18 = r22 + r8.f4895c;
    L5:
        int r23 = r8.f4894b;
        int r24 = r8.f4893a;
        boolean r110 = r16.f4423p;
        int r111 = r10.f4a;
        if (r110 == false) goto L11;
        if (r17 == false) goto L9;
        int r25 = r23;
    L10:
        r19 = r25 + r111;
        goto L11
    L9:
        r25 = r24;
    L11:
        boolean r112 = r16.f4424q;
        int r113 = r10.f6c;
        if (r112 == false) goto L16;
        if (r17 == false) goto L15;
        r23 = r24;
    L15:
        r20 = r23 + r113;
    L16:
        ViewGroup.MarginLayoutParams r26 = (ViewGroup.MarginLayoutParams) r14.getLayoutParams();
        boolean r27 = true;
        if (r16.f4426s == true) goto L19;
    L21:
        boolean r28 = false;
    L23:
        if (r16.f4427t == false) goto L28;
        if (r26.rightMargin == r113) goto L28;
        r26.rightMargin = r113;
        r28 = true;
    L28:
        if (r16.f4428u == false) goto L32;
        int r114 = r26.topMargin;
        int r29 = r10.f5b;
        if (r114 == r29) goto L32;
        r26.topMargin = r29;
    L33:
        if (r27 == false) goto L35;
        r14.setLayoutParams(r26);
    L35:
        r14.setPadding(r19, r14.getPaddingTop(), r20, r18);
        boolean r115 = r13.f8975a;
        if (r115 == false) goto L38;
        r16.f4420m = r11.f7d;
    L38:
        if (r21 == true) goto L40;
        if (r115 == true) goto L40;
    L41:
        return r15;
    L40:
        r16.R();
    L32:
        r27 = r28;
        goto L33
    L19:
        if (r26.leftMargin == r111) goto L21;
        r26.leftMargin = r111;
        r28 = true;
        goto L23
    }
}
