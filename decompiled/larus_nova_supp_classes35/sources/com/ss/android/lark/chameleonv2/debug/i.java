package com.ss.android.lark.chameleonv2.debug;

import android.view.View;
import android.widget.AutoCompleteTextView;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public final class i implements View.OnClickListener {
    public final /* synthetic */ AutoCompleteTextView a;

    public i(AutoCompleteTextView r1) {
        this.a = r1;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r1) {
        this.a.showDropDown();
    }
}
