package com.ss.android.lark.keyboard.edittext2.edittors.at;

import com.ss.android.lark.keyboard.edittext2.base.FunctionEditText;
import com.ss.android.lark.log.Log;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public final class EditTextSpanHolder implements d {
    public final String a;
    public FunctionEditText b;
    public Function1<? super FunctionEditText, Unit> c;

    public EditTextSpanHolder(String r2) {
        Intrinsics.checkNotNullParameter(r2, "tag");
        this.a = r2;
        this.c = EditTextSpanHolder$actionOnAttached$1.INSTANCE;
    }

    public final void a(Function1<? super FunctionEditText, Unit> r2) {
        Intrinsics.checkNotNullParameter(r2, "action");
        this.c = r2;
        FunctionEditText r0 = this.b;
        if (r0 == null) goto L6;
        r2.invoke(r0);
        this.c = EditTextSpanHolder$consumeAction$1.INSTANCE;
        return;
    }

    @Override // com.ss.android.lark.keyboard.edittext2.edittors.at.d
    public final void c(FunctionEditText r3) {
        Intrinsics.checkNotNullParameter(r3, "editText");
        if (this.b == null) goto L5;
        return;
    L5:
        Log.i(this.a, "onSpanAttached: invoke action on attach.");
        this.c.invoke(r3);
        this.c = EditTextSpanHolder$consumeAction$1.INSTANCE;
        this.b = r3;
    }
}
