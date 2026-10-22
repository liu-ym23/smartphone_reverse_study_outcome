package com.bytedance.android.annie.debug.controller;

import android.content.Context;
import android.view.View;
import com.bytedance.android.annie.debug.ui.PageInfoFragment;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public final class c implements View.OnClickListener {
    public final /* synthetic */ e a;

    public c(e r1) {
        this.a = r1;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r10) {
        Context r11 = this.a.a;
        PageInfoFragment r0 = new PageInfoFragment();
        r0.d = this.a.b.ac();
        a8.c.b(r11, r0, "page-info");
    }
}
