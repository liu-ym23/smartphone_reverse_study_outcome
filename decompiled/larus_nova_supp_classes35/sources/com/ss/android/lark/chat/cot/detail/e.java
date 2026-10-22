package com.ss.android.lark.chat.cot.detail;

import android.view.View;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public final class e implements View.OnClickListener {
    public final /* synthetic */ c a;

    public e(c r1) {
        this.a = r1;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r1) {
        Function0<Unit> r2 = this.a.k;
        if (r2 == null) goto L6;
        r2.invoke();
        return;
    }
}
