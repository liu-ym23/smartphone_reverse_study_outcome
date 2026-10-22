package com.larus.dora.obric.device_management.setting.earbuds.broadcast;

import android.text.Editable;
import android.text.TextWatcher;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
public final class y implements TextWatcher {
    public final /* synthetic */ DoraObricEarbudsAppListActivity a;

    @Override // android.text.TextWatcher
    public final void beforeTextChanged(CharSequence r1, int r2, int r3, int r4) {
    }

    @Override // android.text.TextWatcher
    public final void onTextChanged(CharSequence r1, int r2, int r3, int r4) {
    }

    public y(DoraObricEarbudsAppListActivity r1) {
        this.a = r1;
    }

    @Override // android.text.TextWatcher
    public final void afterTextChanged(Editable r3) {
        if (r3 == null) goto L4;
        String r4 = r3.toString();
    L5:
        if (r4 != null) goto L7;
        r4 = "";
    L7:
        DoraObricEarbudsAppListActivity r0 = this.a;
        int r1 = DoraObricEarbudsAppListActivity.m;
        r0.O1().onSearchQueryChanged(r4);
        DoraObricEarbudsAppListActivity r2 = this.a;
        if (r4.length() <= 0) goto L10;
        boolean r5 = true;
    L11:
        r2.k = r5;
        return;
    L10:
        r5 = false;
        goto L11
    L4:
        r4 = null;
        goto L5
    }
}
