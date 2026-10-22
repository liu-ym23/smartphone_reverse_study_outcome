package com.larus.dora.impl.nl;

import android.text.Editable;
import android.text.TextWatcher;
import androidx.appcompat.widget.AppCompatTextView;
import com.larus.dora.impl.databinding.LarusDoraDialogNlApplistBinding;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
public final class j implements TextWatcher {
    public final /* synthetic */ NLAppListDialogFragment a;

    @Override // android.text.TextWatcher
    public final void beforeTextChanged(CharSequence r1, int r2, int r3, int r4) {
    }

    @Override // android.text.TextWatcher
    public final void onTextChanged(CharSequence r1, int r2, int r3, int r4) {
    }

    public j(NLAppListDialogFragment r1) {
        this.a = r1;
    }

    @Override // android.text.TextWatcher
    public final void afterTextChanged(Editable r3) {
        NLAppListDialogFragment r0 = this.a;
        int r1 = NLAppListDialogFragment.i;
        r0.T90().onSearchQueryChanged(String.valueOf(r3));
        LarusDoraDialogNlApplistBinding r4 = this.a.e;
        if (r4 == null) goto L7;
        AppCompatTextView r5 = r4.e;
        if (r5 == null) goto L7;
        r5.setVisibility(0);
    L7:
        this.a.g = true;
    }
}
