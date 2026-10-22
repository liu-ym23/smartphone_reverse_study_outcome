package com.ss.android.lark.mention.base.impl.atselector.view;

import android.view.View;
import com.larksuite.framework.utils.KeyboardUtils;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public final class l implements View.OnClickListener {
    public final /* synthetic */ AtView a;

    public l(AtView r1) {
        this.a = r1;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r2) {
        this.a.mSearchEt.setFocusable(true);
        this.a.mSearchEt.setFocusableInTouchMode(true);
        this.a.mSearchEt.requestFocus();
        KeyboardUtils.showKeyboard(this.a.b);
    }
}
