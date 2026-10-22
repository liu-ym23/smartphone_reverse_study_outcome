package com.bytedance.android.livesdk.interactivity.roomintro.v2.adapter;

import android.text.Editable;
import android.text.TextWatcher;
import com.bytedance.android.live.core.utils.f2;
import com.bytedance.android.live.core.utils.s1;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class e implements TextWatcher {
    public final /* synthetic */ a a;

    @Override // android.text.TextWatcher
    public final void afterTextChanged(Editable r1) {
    }

    @Override // android.text.TextWatcher
    public final void beforeTextChanged(CharSequence r1, int r2, int r3, int r4) {
    }

    public e(a r1) {
        this.a = r1;
    }

    @Override // android.text.TextWatcher
    public final void onTextChanged(CharSequence r2, int r3, int r4, int r5) {
        int r6 = this.a.b();
        if (r2 != null) goto L5;
    L8:
        boolean r0 = true;
    L9:
        if (r0 == false) goto L11;
        return;
    L11:
        if (r2.length() > r6) goto L13;
        return;
    L13:
        if ((r2 instanceof Editable) == true) goto L15;
        CharSequence r1 = null;
    L16:
        Editable r7 = (Editable) r1;
        if (r7 == null) goto L19;
        r7.delete(r6, r2.length());
    L19:
        f2.c(s1.C(2131919924, new Object[]{Integer.valueOf(r6)}), 0);
        return;
    L15:
        r1 = r2;
        goto L16
    L5:
        if (r2.length() == 0) goto L8;
        r0 = false;
        goto L9
    }
}
