package com.ss.android.lark.officesdk.minutes.ui.foundation.widget;

import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.Job;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
public final class c implements TextWatcher {
    public final /* synthetic */ MmSearchInputView a;

    @Override // android.text.TextWatcher
    public final void beforeTextChanged(CharSequence r1, int r2, int r3, int r4) {
    }

    @Override // android.text.TextWatcher
    public final void onTextChanged(CharSequence r1, int r2, int r3, int r4) {
    }

    public c(MmSearchInputView r1) {
        this.a = r1;
    }

    @Override // android.text.TextWatcher
    public final void afterTextChanged(Editable r11) {
        View r0 = null;
        if (r11 == null) goto L5;
        String r12 = r11.toString();
    L6:
        if (r12 != null) goto L8;
        r12 = "";
    L8:
        Function1<String, Unit> r1 = this.a.getOnTextChangedListener();
        if (r1 == null) goto L11;
        r1.invoke(r12);
    L11:
        MmSearchInputView r2 = this.a;
        Job r3 = r2.g;
        boolean r4 = true;
        if (r3 == null) goto L15;
        Job.DefaultImpls.cancel$default(r3, null, 1, null);
    L15:
        if (r2.f > 0) goto L19;
        Function1<? super String, Unit> r5 = r2.l;
        if (r5 == null) goto L20;
        r5.invoke(r12);
    L20:
        View r6 = this.a.d;
        if (r6 != null) goto L23;
        Intrinsics.throwUninitializedPropertyAccessException("searchClearButton");
    L24:
        int r7 = 0;
        if (r12.length() > 0) goto L28;
        r4 = false;
    L28:
        if (r4 == true) goto L31;
        r7 = 8;
    L31:
        r0.setVisibility(r7);
        return;
    L23:
        r0 = r6;
        goto L24
    L19:
        r2.g = BuildersKt.launch$default(r2.a, null, null, new MmSearchInputView$dispatchDebouncedTextChanged$1(r2, r12, null), 3, null);
        goto L20
    L5:
        r12 = null;
        goto L6
    }
}
