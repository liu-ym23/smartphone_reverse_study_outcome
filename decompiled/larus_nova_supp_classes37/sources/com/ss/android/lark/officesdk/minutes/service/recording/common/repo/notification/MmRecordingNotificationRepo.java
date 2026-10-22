package com.ss.android.lark.officesdk.minutes.service.recording.common.repo.notification;

import com.ss.android.lark.officesdk.minutes.service.foundation.mvi.repo.MviRepository;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
public final class MmRecordingNotificationRepo extends MviRepository<a, Object, b> {
    public final MmRecordingNotificationRepo$opt$1 j;

    @Override // com.ss.android.lark.officesdk.minutes.service.foundation.mvi.repo.MviRepository
    public final a a() {
        return new a(false, false, false, false);
    }

    public MmRecordingNotificationRepo() {
        this.j = new MmRecordingNotificationRepo$opt$1(this);
    }
}
