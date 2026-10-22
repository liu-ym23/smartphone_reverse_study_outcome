package com.ss.android.lark.officesdk.minutes.service.recording.common.repo.cta;

import com.ss.android.lark.officesdk.minutes.api.recording.common.data.MmRecordingSource;
import com.ss.android.lark.officesdk.minutes.service.foundation.mvi.repo.MviRepository;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
public final class MmRecordingQuotaCtaRepo extends MviRepository<c, a, d> {
    public final com.ss.android.lark.officesdk.minutes.service.foundation.userscope.a j;
    public final MmRecordingSource k;
    public final String l;
    public final Lazy m;

    @Override // com.ss.android.lark.officesdk.minutes.service.foundation.mvi.repo.MviRepository
    public final c a() {
        if (f.c(this.k) == true) goto L7;
        h.b r1 = h.b.a;
        return new c(r1, r1, 4);
    L7:
        return new c(null, null, 7);
    }

    public final a l() {
        return (a) this.m.getValue();
    }

    @Override // com.ss.android.lark.officesdk.minutes.service.foundation.mvi.repo.MviRepository
    public final String c() {
        return this.l;
    }

    public MmRecordingQuotaCtaRepo(com.ss.android.lark.officesdk.minutes.service.foundation.userscope.a r2, MmRecordingSource r3) {
        Intrinsics.checkNotNullParameter(r2, "mmUccApi");
        this.j = r2;
        this.k = r3;
        this.l = "MmRecordingQuotaCtaRepo_" + hashCode();
        this.m = LazyKt.lazy(new MmRecordingQuotaCtaRepo$opt$2(this));
    }
}
