package com.lark.kmp.rustclient.api.model;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes24.dex */
public final class k<RAW, DATA> extends g<RAW, DATA> {
    public final DATA b;

    public k(DATA r2, RAW r3, j r4) {
        Intrinsics.checkNotNullParameter(r4, "scopePayload");
        super(r3);
        this.b = r2;
    }
}
