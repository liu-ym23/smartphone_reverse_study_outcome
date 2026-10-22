package com.larus.dora.obric.device_management.setting.g.feedback;

import android.text.Editable;
import android.text.TextWatcher;
import android.widget.TextView;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
public final class x implements TextWatcher {
    public boolean a;
    public final /* synthetic */ DoraObricGFeedbackFragment b;

    @Override // android.text.TextWatcher
    public final void beforeTextChanged(CharSequence r1, int r2, int r3, int r4) {
    }

    @Override // android.text.TextWatcher
    public final void onTextChanged(CharSequence r1, int r2, int r3, int r4) {
    }

    public x(DoraObricGFeedbackFragment r1) {
        this.b = r1;
    }

    @Override // android.text.TextWatcher
    public final void afterTextChanged(Editable r8) {
        if (this.a == false) goto L5;
        return;
    L5:
        this.a = true;
        if (r8 == null) goto L21;
        DoraObricGFeedbackFragment r0 = this.b;
        int r1 = r8.length();
        if (r1 <= 300) goto L10;
        r8.replace(300, r1, "");
    L10:
        int r3 = r8.length();
        TextView r4 = r0.p;
        TextView r5 = null;
        if (r4 != null) goto L13;
        Intrinsics.throwUninitializedPropertyAccessException("charCountText");
        r4 = null;
    L13:
        r4.setText(String.valueOf(r3));
        TextView r6 = r0.p;
        if (r6 != null) goto L16;
        Intrinsics.throwUninitializedPropertyAccessException("charCountText");
    L17:
        if (r1 <= 300) goto L19;
        int r2 = v19.c.a(2130970996, r0.requireContext(), 2131102650);
    L20:
        r5.setTextColor(r2);
        r0.Y90().getFeedbackContentFlow().setValue(r8.toString());
        goto L21
    L19:
        r2 = r0.da0();
        goto L20
    L16:
        r5 = r6;
    L21:
        this.a = false;
    }
}
