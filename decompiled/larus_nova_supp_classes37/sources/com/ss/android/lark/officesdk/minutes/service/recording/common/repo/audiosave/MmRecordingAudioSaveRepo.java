package com.ss.android.lark.officesdk.minutes.service.recording.common.repo.audiosave;

import com.ss.android.lark.officesdk.minutes.api.recording.common.data.MmRecordingSource;
import com.ss.android.lark.officesdk.minutes.service.foundation.mvi.repo.MviRepository;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.Job;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
public final class MmRecordingAudioSaveRepo extends MviRepository {
    public final com.ss.android.lark.officesdk.minutes.service.foundation.userscope.a j;
    public final MmRecordingSource k;
    public final String l;
    public Job m;
    public final Lazy n;

    @Override // com.ss.android.lark.officesdk.minutes.service.foundation.mvi.repo.MviRepository
    public final Object a() {
        return new f(0);
    }

    public final b m() {
        return (b) this.n.getValue();
    }

    @Override // com.ss.android.lark.officesdk.minutes.service.foundation.mvi.repo.MviRepository
    public final String c() {
        return this.l;
    }

    public static final void l(MmRecordingAudioSaveRepo r2) {
        if (r2.k != MmRecordingSource.FEISHU_HARDWARE_D1204) goto L6;
        r2.j.I().e();
        return;
    }

    public MmRecordingAudioSaveRepo(com.ss.android.lark.officesdk.minutes.service.foundation.userscope.a r2, MmRecordingSource r3) {
        Intrinsics.checkNotNullParameter(r2, "mmUccApi");
        this.j = r2;
        this.k = r3;
        this.l = "MmRecordingAudioSaveRepo";
        this.n = LazyKt.lazy(new MmRecordingAudioSaveRepo$opt$2(this));
    }
}
