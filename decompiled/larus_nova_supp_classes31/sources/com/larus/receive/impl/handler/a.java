package com.larus.receive.impl.handler;

import android.content.Context;
import android.content.Intent;
import com.larus.receive.contract.ReceiveCustomDiffContract;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
public final class a implements b {
    public a() {
    }

    @Override // com.larus.receive.impl.handler.b
    public final String getName() {
        return ReceiveCustomDiffContract.b.getName();
    }

    @Override // com.larus.receive.impl.handler.b
    public final void a(Context r3) {
        Intrinsics.checkNotNullParameter(r3, "context");
        Intrinsics.checkNotNullParameter("landing", "currentPage");
        ReceiveCustomDiffContract.b.a(r3);
    }

    @Override // com.larus.receive.impl.handler.b
    public final boolean b(Intent r2) {
        Intrinsics.checkNotNullParameter(r2, "intent");
        return ReceiveCustomDiffContract.b.b(r2);
    }
}
