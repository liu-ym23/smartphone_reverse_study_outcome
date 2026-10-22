package com.lark.kmp.rustclient.api.model;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes24.dex */
public final class b<RAW, DATA> extends g<RAW, DATA> {
    public final f b;

    public b(f r2, RAW r3, j r4) {
        Intrinsics.checkNotNullParameter(r2, "error");
        Intrinsics.checkNotNullParameter(r4, "scopePayload");
        super(r3);
        this.b = r2;
    }
}
