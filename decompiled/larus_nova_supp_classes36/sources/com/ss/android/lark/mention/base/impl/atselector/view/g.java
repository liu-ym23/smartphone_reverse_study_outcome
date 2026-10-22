package com.ss.android.lark.mention.base.impl.atselector.view;

import android.view.View;
import com.ss.android.lark.ui.IActionTitlebar;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public final class g extends IActionTitlebar.TextAction {
    public final /* synthetic */ AtView a;

    public final void performAction(View r2) {
        AtView r3 = this.a;
        r3.i.V2(r3.h);
    }

    public g(AtView r1, String r2) {
        this.a = r1;
        super(r2);
    }
}
