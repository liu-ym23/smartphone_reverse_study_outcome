package com.larksuite.framework.section.utils;

import android.view.View;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes24.dex */
public final class c implements View.OnClickListener {
    public final /* synthetic */ e a;
    public final /* synthetic */ long b;
    public final /* synthetic */ com.larksuite.framework.section.c c;
    public final /* synthetic */ com.ss.android.lark.todo.impl.features.detail.viewmodel.a d;

    public c(e r1, long r2, com.larksuite.framework.section.c r4, com.ss.android.lark.todo.impl.features.detail.viewmodel.a.a2 r5) {
        this.a = r1;
        this.b = r2;
        this.c = r4;
        this.d = r5;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r6) {
        long r0 = System.currentTimeMillis();
        e r7 = this.a;
        if ((r0 - r7.b) <= this.b) goto L6;
        r7.b = System.currentTimeMillis();
        this.c.a(this.d);
        return;
    }
}
