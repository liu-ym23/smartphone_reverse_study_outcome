package com.ss.android.lark.chat.cot.detail.blueprint.block;

import android.view.View;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public final class b implements View.OnLayoutChangeListener {
    public final /* synthetic */ c a;

    public b(c r1) {
        this.a = r1;
    }

    @Override // android.view.View.OnLayoutChangeListener
    public final void onLayoutChange(View r1, int r2, int r3, int r4, int r5, int r6, int r7, int r8, int r9) {
        c r10 = this.a;
        String r11 = r10.f;
        if (r11 != null) goto L5;
        return;
    L5:
        int r12 = r4 - r2;
        if (r12 > 0) goto L8;
        return;
    L8:
        r10.f = null;
        r10.d(r11, com.ss.android.lark.movable.utils.b.f(r12, r10.a.getContext()));
    }
}
