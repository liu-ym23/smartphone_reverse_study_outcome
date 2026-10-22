package com.larus.dora.obric.device_management.setting.earbuds.broadcast;

import android.text.Editable;
import android.text.TextWatcher;
import android.widget.TextView;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
public final class i implements TextWatcher {
    public final /* synthetic */ DoraObricEarbudsAddRuleInputSheet a;

    @Override // android.text.TextWatcher
    public final void afterTextChanged(Editable r1) {
    }

    @Override // android.text.TextWatcher
    public final void beforeTextChanged(CharSequence r1, int r2, int r3, int r4) {
    }

    public i(DoraObricEarbudsAddRuleInputSheet r1) {
        this.a = r1;
    }

    @Override // android.text.TextWatcher
    public final void onTextChanged(CharSequence r2, int r3, int r4, int r5) {
        boolean r6 = false;
        if (r2 == null) goto L5;
        int r7 = r2.length();
    L6:
        DoraObricEarbudsAddRuleInputSheet r8 = this.a;
        int r9 = DoraObricEarbudsAddRuleInputSheet.i;
        TextView r10 = r8.f;
        if (r10 == null) goto L9;
        r10.setText(r7 + "/300");
    L9:
        DoraObricEarbudsAddRuleInputSheet r11 = this.a;
        if (r7 <= 0) goto L12;
        r6 = true;
    L12:
        r11.W90(r6);
        return;
    L5:
        r7 = 0;
        goto L6
    }
}
