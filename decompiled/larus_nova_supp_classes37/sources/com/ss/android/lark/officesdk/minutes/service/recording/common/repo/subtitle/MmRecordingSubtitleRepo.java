package com.ss.android.lark.officesdk.minutes.service.recording.common.repo.subtitle;

import com.ss.android.lark.officesdk.minutes.service.foundation.mvi.repo.MviRepository;
import com.ss.android.lark.officesdk.minutes.service.recording.common.core.MmRecordingSession;
import com.ss.android.lark.openplatform.common.constant.AppbrandHostConstants;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
public final class MmRecordingSubtitleRepo extends MviRepository<d, com.ss.android.lark.officesdk.minutes.service.recording.common.repo.subtitle.a, Object> {
    public static final /* synthetic */ int o = 0;
    public final MmRecordingSession j;
    public final com.ss.android.lark.officesdk.minutes.service.recording.common.repo.a k;
    public final com.ss.android.lark.officesdk.minutes.service.foundation.userscope.a l;
    public final String m;
    public final Lazy n;

    public static final class a {
    }

    static {
    }

    @Override // com.ss.android.lark.officesdk.minutes.service.foundation.mvi.repo.MviRepository
    public final d a() {
        return new d(0);
    }

    public final com.ss.android.lark.officesdk.minutes.service.recording.common.repo.subtitle.a l() {
        return (com.ss.android.lark.officesdk.minutes.service.recording.common.repo.subtitle.a) this.n.getValue();
    }

    @Override // com.ss.android.lark.officesdk.minutes.service.foundation.mvi.repo.MviRepository
    public final String c() {
        return this.m;
    }

    public MmRecordingSubtitleRepo(MmRecordingSession r2, com.ss.android.lark.officesdk.minutes.service.recording.common.repo.a r3, com.ss.android.lark.officesdk.minutes.service.foundation.userscope.a r4) {
        Intrinsics.checkNotNullParameter(r2, AppbrandHostConstants.SCHEMA_INSPECT.SESSION);
        Intrinsics.checkNotNullParameter(r3, "repoContainer");
        Intrinsics.checkNotNullParameter(r4, "mmUccApi");
        this.j = r2;
        this.k = r3;
        this.l = r4;
        this.m = "MmRecordingSubtitleRepo";
        this.n = LazyKt.lazy(new MmRecordingSubtitleRepo$opt$2(this));
    }
}
