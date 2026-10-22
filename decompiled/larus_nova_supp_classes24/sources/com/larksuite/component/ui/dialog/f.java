package com.larksuite.component.ui.dialog;

import android.content.Context;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes24.dex */
public final class f implements c {
    public final d<?> a;
    public Context b;

    @Override // com.larksuite.component.ui.dialog.c
    public Context getContext() {
        return this.b;
    }

    public f(d<?> r2) {
        Intrinsics.checkNotNullParameter(r2, "lkuiDialogBuilder");
        this.a = r2;
    }
}
