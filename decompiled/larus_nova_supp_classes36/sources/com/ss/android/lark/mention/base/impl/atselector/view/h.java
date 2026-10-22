package com.ss.android.lark.mention.base.impl.atselector.view;

import android.view.View;
import com.larksuite.framework.utils.KeyboardUtils;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public final class h implements View.OnClickListener {
    public final /* synthetic */ AtView a;

    public h(AtView r1) {
        this.a = r1;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r1) {
        KeyboardUtils.hideKeyboard(this.a.b);
        this.a.c.y();
    }
}
