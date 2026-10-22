package com.larksuite.rucket.job.impl;

import com.larksuite.rucket.job.RucketJobImpl;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes24.dex */
public final class a<T> extends RucketJobImpl<T> {
    public final Function0<T> a;

    /* JADX WARN: Multi-variable type inference failed */
    public a(Function0<? extends T> r8) {
        Intrinsics.checkNotNullParameter(r8, "action");
        this.a = r8;
        BuildersKt.launch$default(this, null, null, new WorkerRucketJob$onExecute$1(this, null), 3, null);
    }
}
