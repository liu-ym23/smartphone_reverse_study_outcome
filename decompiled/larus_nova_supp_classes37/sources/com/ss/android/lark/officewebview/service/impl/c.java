package com.ss.android.lark.officewebview.service.impl;

import com.ss.android.lark.officewebview.service.listener.OnViewScrollListener;
import oxb.h;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
public final class c implements h {
    public OnViewScrollListener a;

    public c() {
    }

    @Override // oxb.h
    public final void K(OnViewScrollListener r1) {
        this.a = r1;
    }

    @Override // oxb.h
    public final void u(int r4, int r5, int r6, int r7) {
        if (this.a != null) goto L6;
        return;
    L6:
        if (r4 != r6) goto L13;
        int r1 = r5 - r7;
        if (Math.abs(r1) < 3) goto L13;
        if (r5 <= r7) goto L11;
        OnViewScrollListener r8 = this.a;
        Math.abs(r1);
        r8.b();
    L20:
        this.a.c(r4, r5);
        return;
    L11:
        if (r5 >= r7) goto L20;
        OnViewScrollListener r9 = this.a;
        Math.abs(r1);
        r9.b();
    L13:
        if (r5 != r7) goto L20;
        if (Math.abs(r4 - r6) < 3) goto L20;
        if (r4 <= r6) goto L18;
        OnViewScrollListener r10 = this.a;
        Math.abs(r5 - r7);
        r10.b();
        goto L20
    L18:
        if (r4 >= r6) goto L20;
        OnViewScrollListener r11 = this.a;
        Math.abs(r5 - r7);
        r11.b();
        goto L20
    }

    @Override // oxb.h
    public final void m(int r1, int r2, int r3, int r4, int r5, int r6, int r7, int r8, boolean r9) {
        OnViewScrollListener r10 = this.a;
        if (r10 != null) goto L5;
        return;
    L5:
        r10.a();
    }
}
