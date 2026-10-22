package com.ss.android.lark.officesdk.minutes.service.recording.common.repo.subtitle;

import com.ss.android.lark.officesdk.minutes.service.recording.common.repo.subtitle.helper.MmSubtitleSmoothType;
import com.ss.android.lark.pb.minutes.v1.RecordingSubtitleData;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
public final class f implements rvb.a.c {
    public final /* synthetic */ MmRecordingSubtitleRepo$opt$2.AnonymousClass1 a;

    public f(MmRecordingSubtitleRepo$opt$2.AnonymousClass1 r1) {
        this.a = r1;
    }

    @Override // rvb.a.c
    public final void a(RecordingSubtitleData r2, String r3, MmSubtitleSmoothType r4) {
        Intrinsics.checkNotNullParameter(r2, "data");
        Intrinsics.checkNotNullParameter(r3, "smoothContent");
        Intrinsics.checkNotNullParameter(r4, "smoothType");
        if (((d) this.a.m()).e == false) goto L6;
        this.a.a1(r2, r4, r3);
        return;
    }
}
