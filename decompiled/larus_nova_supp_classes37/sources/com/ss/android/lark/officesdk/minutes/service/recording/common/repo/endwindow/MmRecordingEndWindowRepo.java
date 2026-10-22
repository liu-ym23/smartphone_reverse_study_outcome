package com.ss.android.lark.officesdk.minutes.service.recording.common.repo.endwindow;

import com.ss.android.lark.officesdk.minutes.service.foundation.mvi.repo.MviRepository;
import com.ss.android.lark.officesdk.minutes.service.recording.common.repo.MmRecordingRepo;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
public final class MmRecordingEndWindowRepo extends MviRepository<c, a, Object> {
    public final MmRecordingRepo j;
    public final com.ss.android.lark.officesdk.minutes.service.foundation.userscope.a k;
    public final String l;
    public final Lazy m;

    @Override // com.ss.android.lark.officesdk.minutes.service.foundation.mvi.repo.MviRepository
    public final c a() {
        return new c(0);
    }

    @Override // com.ss.android.lark.officesdk.minutes.service.foundation.mvi.repo.MviRepository
    public final String c() {
        return this.l;
    }

    public MmRecordingEndWindowRepo(MmRecordingRepo r2, com.ss.android.lark.officesdk.minutes.service.foundation.userscope.a r3) {
        Intrinsics.checkNotNullParameter(r2, "recordingRepo");
        Intrinsics.checkNotNullParameter(r3, "mmUccApi");
        this.j = r2;
        this.k = r3;
        this.l = "RecordUX_D_EndWindowRepo";
        this.m = LazyKt.lazy(new MmRecordingEndWindowRepo$opt$2(this));
    }
}
