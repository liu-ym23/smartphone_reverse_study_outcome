package com.larus.bmhome.upload.sdk.impl.core;

import com.larus.bmhome.upload.sdk.api.model.CancelReason;
import is8.j;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.z0;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
public final class a implements gs8.b {
    public final Flow<j> a;
    public final Function1<CancelReason, Boolean> b;

    @Override // gs8.b
    public final Flow<j> a() {
        return this.a;
    }

    @Override // gs8.b
    public final boolean b(CancelReason r2) {
        Intrinsics.checkNotNullParameter(r2, "reason");
        return ((Boolean) this.b.invoke(r2)).booleanValue();
    }

    public a(String r2, z0 r3, com.larus.bmhome.upload.sdk.impl.b r4) {
        Intrinsics.checkNotNullParameter(r2, "taskId");
        Intrinsics.checkNotNullParameter(r3, "states");
        Intrinsics.checkNotNullParameter(r4, "cancelAction");
        this.a = r3;
        this.b = r4;
    }
}
