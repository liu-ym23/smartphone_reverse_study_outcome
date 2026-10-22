package com.ss.android.lark.passportc.internal;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
public abstract class f extends u {
    public final StateTransferType a;

    public final StateTransferType getType() {
        return this.a;
    }

    public f(StateTransferType r2) {
        Intrinsics.checkNotNullParameter(r2, "type");
        this.a = r2;
    }
}
