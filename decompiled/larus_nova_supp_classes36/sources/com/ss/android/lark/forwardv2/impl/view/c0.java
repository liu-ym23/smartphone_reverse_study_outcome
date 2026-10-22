package com.ss.android.lark.forwardv2.impl.view;

import android.view.View;
import com.ss.android.lark.ui.IActionTitlebar;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public final class c0 extends IActionTitlebar.TextAction {
    public final /* synthetic */ d0 a;

    public final void performAction(final View r2) {
        qqb.c.c(new b0(this, r2));
    }

    public c0(d0 r1, String r2) {
        this.a = r1;
        super(r2);
    }

    public static /* synthetic */ void a(c0 r0, View r1) {
        super/*com.ss.android.lark.ui.IActionTitlebar.BaseAction*/.performAction(r1);
        d0 r2 = r0.a;
        r2.d.s3(r2.f);
    }
}
