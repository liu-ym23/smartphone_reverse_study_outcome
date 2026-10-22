package com.ss.android.lark.officesdk.minutes.service.recording.common.repo.meta;

import com.ss.android.lark.officesdk.minutes.service.foundation.mvi.repo.MviRepository;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.Job;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
public final class MmRecordingMetaRepo extends MviRepository<b, a, c> {
    public final com.ss.android.lark.officesdk.minutes.service.foundation.userscope.a j;
    public final String k;
    public volatile Job l;
    public final Lazy m;

    @Override // com.ss.android.lark.officesdk.minutes.service.foundation.mvi.repo.MviRepository
    public final b a() {
        return new b(0);
    }

    public final a l() {
        return (a) this.m.getValue();
    }

    @Override // com.ss.android.lark.officesdk.minutes.service.foundation.mvi.repo.MviRepository
    public final String c() {
        return this.k;
    }

    public MmRecordingMetaRepo(com.ss.android.lark.officesdk.minutes.service.foundation.userscope.a r2) {
        Intrinsics.checkNotNullParameter(r2, "mmUccApi");
        this.j = r2;
        this.k = "MmRecordingMetaRepo";
        this.m = LazyKt.lazy(new MmRecordingMetaRepo$opt$2(this));
    }
}
