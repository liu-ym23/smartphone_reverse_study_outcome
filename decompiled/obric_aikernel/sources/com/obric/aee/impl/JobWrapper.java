package com.obric.aee.impl;

import androidx.annotation.Keep;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.v1;

/* JADX INFO: loaded from: classes2.dex */
@Keep
public final class JobWrapper {
    private final v1 job;

    public JobWrapper(v1 r10) {
        Intrinsics.checkNotNullParameter(r10, "job");
        this.job = r10;
    }

    public final void cancel() {
        v1.a.a(this.job, null, 1, null);
    }

    public final v1 getJob() {
        return this.job;
    }
}
