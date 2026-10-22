package com.bytedance.android.livesdk.gift.platform.business.dialog.v3.repo.receiver;

import java.util.concurrent.Callable;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final /* synthetic */ class b implements Callable {
    public final /* synthetic */ Function0 a;

    public b(Function0 r2) {
        Intrinsics.checkNotNullParameter(r2, "function");
        this.a = r2;
    }

    @Override // java.util.concurrent.Callable
    public final /* synthetic */ Object call() {
        return this.a.invoke();
    }
}
