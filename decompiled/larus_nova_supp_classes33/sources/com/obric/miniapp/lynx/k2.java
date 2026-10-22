package com.obric.miniapp.lynx;

import android.text.Editable;
import android.text.TextWatcher;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Regex;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
public final class k2 implements TextWatcher {
    public final /* synthetic */ LynxOUIDatePickerViewUI a;

    @Override // android.text.TextWatcher
    public final void beforeTextChanged(CharSequence r1, int r2, int r3, int r4) {
    }

    @Override // android.text.TextWatcher
    public final void onTextChanged(CharSequence r1, int r2, int r3, int r4) {
    }

    public k2(LynxOUIDatePickerViewUI r1) {
        this.a = r1;
    }

    @Override // android.text.TextWatcher
    public final void afterTextChanged(Editable r5) {
        if (this.a.v == false) goto L5;
        return;
    L5:
        if (r5 == null) goto L19;
        String r0 = r5.toString();
        if (r0 == null) goto L22;
        this.a.getClass();
        String r1 = new Regex("\\s*年\\s*").replace(r0, "年");
        String r2 = new Regex("\\s*月\\s*").replace(r1, "月");
        if (Intrinsics.areEqual(r2, r0) == false) goto L12;
        return;
    L12:
        this.a.v = true;
        r5.replace(0, r5.length(), r2);     // Catch: Throwable -> L16
        this.a.v = false;
        return;
    L16:
        th = move-exception;
        this.a.v = false;
        throw th;
    L22:
        return;
    }
}
