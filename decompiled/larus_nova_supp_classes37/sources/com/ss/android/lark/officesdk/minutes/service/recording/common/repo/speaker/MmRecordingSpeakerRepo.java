package com.ss.android.lark.officesdk.minutes.service.recording.common.repo.speaker;

import com.ss.android.lark.officesdk.minutes.service.foundation.mvi.repo.MviRepository;
import com.ss.android.lark.officesdk.minutes.service.recording.common.repo.subtitle.MmRecordingSubtitleRepo;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
public final class MmRecordingSpeakerRepo extends MviRepository<f, a, Object> {
    public final com.ss.android.lark.officesdk.minutes.service.foundation.userscope.a j;
    public final Function0<MmRecordingSubtitleRepo> k;
    public final String l;
    public final Lazy m;

    @Override // com.ss.android.lark.officesdk.minutes.service.foundation.mvi.repo.MviRepository
    public final f a() {
        return new f(0);
    }

    public final a l() {
        return (a) this.m.getValue();
    }

    @Override // com.ss.android.lark.officesdk.minutes.service.foundation.mvi.repo.MviRepository
    public final String c() {
        return this.l;
    }

    public MmRecordingSpeakerRepo(com.ss.android.lark.officesdk.minutes.service.foundation.userscope.a r2, Function0<MmRecordingSubtitleRepo> r3) {
        Intrinsics.checkNotNullParameter(r2, "mmUccApi");
        Intrinsics.checkNotNullParameter(r3, "subtitleProvider");
        this.j = r2;
        this.k = r3;
        this.l = "MmRecordingSpeakerRepo";
        this.m = LazyKt.lazy(new MmRecordingSpeakerRepo$opt$2(this));
    }
}
