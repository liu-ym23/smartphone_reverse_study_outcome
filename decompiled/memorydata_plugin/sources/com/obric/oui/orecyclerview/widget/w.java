package com.obric.oui.orecyclerview.widget;

import android.content.Context;
import android.graphics.PointF;
import android.view.View;
import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: loaded from: classes5.dex */
public class w extends aa {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private v f14239b;
    private v c;

    public w() {
    }

    private int a(View r1, v r2) {
        return (r2.a(r1) + (r2.e(r1) / 2)) - (r2.c() + (r2.f() / 2));
    }

    private View a(RecyclerView.h r8, v r9) {
        int r7 = r8.x();
        View r0 = null;
        if (r7 != 0) goto L5;
        return null;
    L5:
        int r1 = r9.c() + (r9.f() / 2);
        int r2 = Integer.MAX_VALUE;
        int r3 = 0;
    L6:
        if (r3 >= r7) goto L11;
        View r4 = r8.i(r3);
        int r5 = Math.abs((r9.a(r4) + (r9.e(r4) / 2)) - r1);
        if (r5 >= r2) goto L10;
        r0 = r4;
        r2 = r5;
    L10:
        r3 = r3 + 1;
        goto L6
    L11:
        return r0;
    }

    private boolean b(RecyclerView.h r2, int r3, int r4) {
        if (r2.e() == false) goto L8;
        if (r3 <= 0) goto L7;
        return true;
    L7:
        return false;
    L8:
        if (r4 <= 0) goto L11;
        return true;
    L11:
        return false;
    }

    private boolean d(RecyclerView.h r4) {
        int r3 = r4.H();
        if (ZeusTransformUtils.instanceOf(r4, RecyclerView.r.b.class) == false) goto L12;
        PointF r5 = ((RecyclerView.r.b) ZeusTransformUtils.preCheckCast(r4, RecyclerView.r.b.class, "com.obric.memorydata.plugin")).d(r3 - 1);
        if (r5 != null) goto L7;
        return false;
    L7:
        if (r5.x < 0.0f) goto L11;
        if (r5.y < 0.0f) goto L11;
        return false;
    L11:
        return true;
    L12:
        return false;
    }

    private v e(RecyclerView.h r2) {
        if (r2.f() == false) goto L7;
        return f(r2);
    L7:
        if (r2.e() == true) goto L9;
        return null;
    L9:
        return g(r2);
    }

    private v f(RecyclerView.h r2) {
        v r0 = this.f14239b;
        if (r0 != null) goto L5;
    L6:
        this.f14239b = v.b(r2);
    L8:
        return this.f14239b;
    L5:
        if (r0.f14237a == r2) goto L8;
        goto L6
    }

    private v g(RecyclerView.h r2) {
        v r0 = this.c;
        if (r0 != null) goto L5;
    L6:
        this.c = v.a(r2);
    L8:
        return this.c;
    L5:
        if (r0.f14237a == r2) goto L8;
        goto L6
    }

    @Override // com.obric.oui.orecyclerview.widget.aa
    public int a(RecyclerView.h r12, int r13, int r14) {
        int r0 = r12.H();
        if (r0 != 0) goto L5;
        return -1;
    L5:
        v r2 = e(r12);
        if (r2 != null) goto L8;
        return -1;
    L8:
        int r3 = Integer.MIN_VALUE;
        int r4 = Integer.MAX_VALUE;
        int r5 = r12.x();
        int r6 = 0;
        View r7 = null;
        View r8 = null;
    L9:
        if (r6 >= r5) goto L21;
        View r9 = r12.i(r6);
        if (r9 == null) goto L20;
        int r10 = a(r9, r2);
        if (r10 > 0) goto L17;
        if (r10 <= r3) goto L17;
        r8 = r9;
        r3 = r10;
    L17:
        if (r10 < 0) goto L20;
        if (r10 >= r4) goto L20;
        r7 = r9;
        r4 = r10;
    L20:
        r6 = r6 + 1;
        goto L9
    L21:
        boolean r15 = b(r12, r13, r14);
        if (r15 == false) goto L26;
        if (r7 == null) goto L26;
        return r12.d(r7);
    L26:
        if (r15 == true) goto L30;
        if (r8 == null) goto L30;
        return r12.d(r8);
    L30:
        if (r15 == false) goto L32;
        r7 = r8;
    L32:
        if (r7 != null) goto L34;
        return -1;
    L34:
        int r16 = r12.d(r7);
        if (d(r12) != r15) goto L37;
        int r11 = -1;
    L38:
        int r17 = r16 + r11;
        if (r17 < 0) goto L43;
        if (r17 >= r0) goto L43;
        return r17;
    L43:
        return -1;
    L37:
        r11 = 1;
        goto L38
    }

    @Override // com.obric.oui.orecyclerview.widget.aa
    public View a(RecyclerView.h r2) {
        if (r2.f() == false) goto L8;
        v r0 = f(r2);
    L6:
        return a(r2, r0);
    L8:
        if (r2.e() == false) goto L10;
        r0 = g(r2);
        goto L6
    L10:
        return null;
    }

    @Override // com.obric.oui.orecyclerview.widget.aa
    public int[] a(RecyclerView.h r5, View r6) {
        int[] r0 = new int[2];
        if (r5.e() == false) goto L5;
        r0[0] = a(r6, g(r5));
    L7:
        if (r5.f() == false) goto L9;
        r0[1] = a(r6, f(r5));
    L10:
        return r0;
    L9:
        r0[1] = 0;
        goto L10
    L5:
        r0[0] = 0;
        goto L7
    }

    @Override // com.obric.oui.orecyclerview.widget.aa
    public RecyclerView.r b(RecyclerView.h r4) {
        if (ZeusTransformUtils.instanceOf(r4, RecyclerView.r.b.class) == true) goto L6;
        return null;
    L6:
        final Context r0 = (Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(this.f14114a.getContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin");
        return new AnonymousClass1(this, r0);
    }
}
