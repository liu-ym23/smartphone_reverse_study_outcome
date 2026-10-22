package com.ss.android.lark.keyboard.edittext2.compat;

import android.view.KeyEvent;
import com.ss.android.lark.keyboard.editor.input.BaseRichTextInputPlugin;
import kotlin.Function;
import kotlin.jvm.internal.FunctionAdapter;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public final /* synthetic */ class b implements c, FunctionAdapter {
    public final /* synthetic */ c a;

    public b(BaseRichTextInputPlugin.m r1) {
        this.a = r1;
    }

    public final boolean equals(Object r3) {
        if ((r3 instanceof c) == true) goto L5;
        return false;
    L5:
        if ((r3 instanceof FunctionAdapter) == true) goto L7;
        return false;
    L7:
        return Intrinsics.areEqual(getFunctionDelegate(), ((FunctionAdapter) r3).getFunctionDelegate());
    }

    public final Function<?> getFunctionDelegate() {
        return new FunctionReferenceImpl(2, this.a, c.class, "onKeyPreIme", "onKeyPreIme(ILandroid/view/KeyEvent;)Z", 0);
    }

    public final int hashCode() {
        return getFunctionDelegate().hashCode();
    }

    @Override // com.ss.android.lark.keyboard.edittext2.compat.c
    public final boolean a(int r2, KeyEvent r3) {
        return this.a.a(r2, r3);
    }
}
