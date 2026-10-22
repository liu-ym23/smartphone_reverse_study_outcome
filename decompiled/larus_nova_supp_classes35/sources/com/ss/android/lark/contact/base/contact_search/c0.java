package com.ss.android.lark.contact.base.contact_search;

import android.view.View;
import com.larksuite.framework.utils.KeyboardUtils;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public final class c0 implements View.OnClickListener {
    public final /* synthetic */ b0 a;

    public c0(b0 r1) {
        this.a = r1;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r1) {
        KeyboardUtils.hideKeyboard(this.a.a.getActivity());
    }
}
