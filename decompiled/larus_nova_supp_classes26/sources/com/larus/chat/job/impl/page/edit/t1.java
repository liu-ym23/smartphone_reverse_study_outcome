package com.larus.chat.job.impl.page.edit;

import android.text.Editable;
import android.text.TextWatcher;
import android.widget.EditText;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
public final class t1 implements TextWatcher {
    public final /* synthetic */ u1 a;
    public final /* synthetic */ z.b b;
    public final /* synthetic */ Function1<String, Unit> c;

    @Override // android.text.TextWatcher
    public final void beforeTextChanged(CharSequence r1, int r2, int r3, int r4) {
    }

    @Override // android.text.TextWatcher
    public final void onTextChanged(CharSequence r1, int r2, int r3, int r4) {
    }

    @Override // android.text.TextWatcher
    public final void afterTextChanged(Editable r4) {
        EditText r0 = this.a.a.b;
        q1 r1 = new q1(r0.getSelectionStart(), r0.getSelectionEnd());
        this.a.c.invoke(this.b.a, r1);
        if (r4 == null) goto L5;
        String r5 = r4.toString();
    L6:
        if (r5 != null) goto L8;
        r5 = "";
    L8:
        this.c.invoke(r5);
        return;
    L5:
        r5 = null;
        goto L6
    }

    public t1(u1 r1, z.b r2, e r3) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
    }
}
