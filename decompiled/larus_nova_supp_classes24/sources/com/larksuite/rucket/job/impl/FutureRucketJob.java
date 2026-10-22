package com.larksuite.rucket.job.impl;

import com.larksuite.rucket.job.RucketJob;
import com.larksuite.rucket.job.RucketJobImpl;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes24.dex */
public final class FutureRucketJob<T> extends RucketJobImpl<T> {
    public FutureRucketJob() {
    }

    public final void b(RucketJob<T> r4) {
        Intrinsics.checkNotNullParameter(r4, "origin");
        r4.setNextJob(nextJob());
        r4.setPrevJob(prevJob());
        RucketJob.error$default(RucketJob.then$default(r4, null, new FutureRucketJob$setOrigin$1(this, null), 1, null), null, new FutureRucketJob$setOrigin$2(this, null), 1, null);
    }
}
