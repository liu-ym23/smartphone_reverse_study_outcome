package com.ss.android.lark.chameleonv2.debug;

import android.view.View;
import android.widget.AutoCompleteTextView;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public final class h implements View.OnFocusChangeListener {
    public final /* synthetic */ AutoCompleteTextView a;

    public h(AutoCompleteTextView r1) {
        this.a = r1;
    }

    @Override // android.view.View.OnFocusChangeListener
    public final void onFocusChange(View r1, boolean r2) {
        if (r2 == false) goto L4;
        this.a.showDropDown();
        return;
    L4:
        this.a.dismissDropDown();
    }
}
