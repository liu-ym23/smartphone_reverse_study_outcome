package com.larus.dora.impl.nl.notification_rule.ui;

import android.text.Editable;
import android.text.TextWatcher;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.larus.dora.impl.databinding.LarusDoraFragmentAddRuleInputBinding;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
public final class h implements TextWatcher {
    public final /* synthetic */ AddRuleInputFragment a;

    @Override // android.text.TextWatcher
    public final void afterTextChanged(Editable r1) {
    }

    @Override // android.text.TextWatcher
    public final void beforeTextChanged(CharSequence r1, int r2, int r3, int r4) {
    }

    public h(AddRuleInputFragment r1) {
        this.a = r1;
    }

    @Override // android.text.TextWatcher
    public final void onTextChanged(CharSequence r1, int r2, int r3, int r4) {
        if (r1 == null) goto L5;
        String r5 = r1.toString();
        if (r5 == null) goto L5;
    L6:
        AddRuleInputFragment r6 = this.a;
        int r7 = r5.length();
        int r8 = AddRuleInputFragment.h;
        r6.T90(r7);
        this.a.S90(r5);
        AddRuleInputFragment r9 = this.a;
        LarusDoraFragmentAddRuleInputBinding r10 = r9.d;
        if (r10 == null) goto L11;
        ConstraintLayout r11 = r10.h;
        if (r11 == null) goto L11;
        r11.setBackgroundResource(2131240420);
    L11:
        LarusDoraFragmentAddRuleInputBinding r12 = r9.d;
        if (r12 == null) goto L17;
        TextView r13 = r12.d;
        if (r13 == null) goto L18;
        r13.setVisibility(8);
        return;
    L18:
        return;
    L17:
        return;
    L5:
        r5 = "";
        goto L6
    }
}
