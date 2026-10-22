package com.obric.assistant.cocreationreview;

import android.text.Editable;
import android.text.TextWatcher;
import com.obric.aivoice.core.data.NameKeys;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
public final class r5 implements TextWatcher {
    public final Function1<String, Unit> a;

    @Override // android.text.TextWatcher
    public final void afterTextChanged(Editable r1) {
    }

    @Override // android.text.TextWatcher
    public final void beforeTextChanged(CharSequence r1, int r2, int r3, int r4) {
    }

    /* JADX WARN: Multi-variable type inference failed */
    public r5(Function1<? super String, Unit> r2) {
        Intrinsics.checkNotNullParameter(r2, "onTextChanged");
        this.a = r2;
    }

    @Override // android.text.TextWatcher
    public final void onTextChanged(CharSequence r1, int r2, int r3, int r4) {
        Function1<String, Unit> r5 = this.a;
        if (r1 == null) goto L5;
        String r6 = r1.toString();
    L6:
        if (r6 != null) goto L8;
        r6 = NameKeys.UnloadStrategy_No_Strategy;
    L8:
        r5.invoke(r6);
        return;
    L5:
        r6 = null;
        goto L6
    }
}
