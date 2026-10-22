package com.larksuite.framework.section.utils;

import android.view.View;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes24.dex */
public final class b implements View.OnClickListener {
    public final /* synthetic */ com.larksuite.framework.section.c a;
    public final /* synthetic */ com.ss.android.lark.todo.impl.features.detail.viewmodel.a b;
    public final /* synthetic */ String c;

    public b(com.larksuite.framework.section.c r1, com.ss.android.lark.todo.impl.features.detail.viewmodel.a.s r2, String r3) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r3) {
        this.a.b(this.b, this.c);
    }
}
