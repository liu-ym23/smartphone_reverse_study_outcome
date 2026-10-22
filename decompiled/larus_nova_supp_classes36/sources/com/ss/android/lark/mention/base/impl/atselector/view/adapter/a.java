package com.ss.android.lark.mention.base.impl.atselector.view.adapter;

import android.view.View;
import com.ss.android.lark.mention.base.impl.atselector.bean.BaseAtBean;
import com.ss.android.lark.mention.base.impl.atselector.view.AtView;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public final class a implements View.OnClickListener {
    public final /* synthetic */ BaseAtBean a;
    public final /* synthetic */ AtHeaderSelectedAdapter b;

    @Override // android.view.View.OnClickListener
    public final void onClick(View r2) {
        AtHeaderSelectedAdapter.a r3 = this.b.b;
        if (r3 != null) goto L5;
        return;
    L5:
        BaseAtBean r0 = this.a;
        ((AtView.c) r3).a.i.c5(r0);
    }

    public a(AtHeaderSelectedAdapter r1, BaseAtBean r2) {
        this.b = r1;
        this.a = r2;
    }
}
