package com.ss.android.lark.create.groupchat.impl.service.interceptor;

import android.content.DialogInterface;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public final class d implements DialogInterface.OnClickListener {
    public final /* synthetic */ Function1<Boolean, Unit> a;
    public final /* synthetic */ boolean b;

    /* JADX WARN: Multi-variable type inference failed */
    public d(Function1<? super Boolean, Unit> r1, boolean r2) {
        this.a = r1;
        this.b = r2;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public final void onClick(DialogInterface r2, int r3) {
        Function1<Boolean, Unit> r4 = this.a;
        if (r4 == null) goto L5;
        r4.invoke(Boolean.valueOf(this.b));
    L5:
        r2.dismiss();
    }
}
