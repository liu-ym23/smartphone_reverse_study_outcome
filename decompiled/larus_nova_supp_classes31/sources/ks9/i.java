package ks9;

import android.text.Editable;
import android.text.TextWatcher;
import com.larus.profile.impl.relaxedit.input.LynxUIInputLit;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
public final class i implements TextWatcher {
    public final /* synthetic */ LynxUIInputLit a;

    @Override // android.text.TextWatcher
    public final void beforeTextChanged(CharSequence r1, int r2, int r3, int r4) {
    }

    @Override // android.text.TextWatcher
    public final void onTextChanged(CharSequence r1, int r2, int r3, int r4) {
    }

    public i(LynxUIInputLit r1) {
        this.a = r1;
    }

    @Override // android.text.TextWatcher
    public final void afterTextChanged(Editable r3) {
        LynxUIInputLit r0 = this.a;
        if (r0.a == false) goto L5;
        return;
    L5:
        LynxUIInputLit.M(r0, r3);
    }
}
