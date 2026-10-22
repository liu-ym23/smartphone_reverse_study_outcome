package com.ss.android.lark.officesdk.minutes.service.recording.common.repo.summary;

import com.ss.android.lark.officesdk.minutes.api.recording.common.depend.feature.MmOfficeSdkFeature;
import com.ss.android.lark.officesdk.minutes.service.foundation.mvi.repo.MviRepository;
import com.ss.android.lark.officesdk.minutes.service.recording.common.repo.MmRecordingRepo;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
public final class MmRecordingSummaryRepo extends MviRepository<c, a, d> {
    public final MmRecordingRepo j;
    public final com.ss.android.lark.officesdk.minutes.service.foundation.userscope.a k;
    public final String l;
    public final Lazy m;

    @Override // com.ss.android.lark.officesdk.minutes.service.foundation.mvi.repo.MviRepository
    public final c a() {
        com.ss.android.lark.officesdk.minutes.service.foundation.feature.a r0 = this.k.getFeatureService();
        int r1 = com.ss.android.lark.officesdk.minutes.service.foundation.feature.b.a;
        Intrinsics.checkNotNullParameter(r0, "featureService");
        boolean r5 = !r0.h(MmOfficeSdkFeature.RecordingNoAiNotes);
        Intrinsics.checkNotNullParameter(r0, "featureService");
        boolean r2 = r0.h(MmOfficeSdkFeature.RecordAiLayout);
        boolean r4 = com.ss.android.lark.officesdk.minutes.service.foundation.feature.b.a(r0);
        Intrinsics.checkNotNullParameter(r0, "featureService");
        if (r0.h(MmOfficeSdkFeature.RecordingHideSwitchTab) == true) goto L7;
        if (r4 == true) goto L7;
        boolean r3 = false;
    L9:
        if (r5 == false) goto L12;
        if (r2 == false) goto L12;
        boolean r6 = true;
    L13:
        if (r5 == false) goto L17;
        if (r3 == true) goto L17;
        if (r2 == false) goto L17;
        boolean r7 = true;
    L18:
        if (r5 == false) goto L21;
        if (r2 == false) goto L21;
        MmSummaryViewType r8 = MmSummaryViewType.FishBone;
    L23:
        return new c(r5, r6, r7, r8, 8176);
    L21:
        r8 = MmSummaryViewType.Markdown;
    L17:
        r7 = false;
    L12:
        r6 = false;
    L7:
        r3 = true;
        goto L9
    }

    public final a l() {
        return (a) this.m.getValue();
    }

    @Override // com.ss.android.lark.officesdk.minutes.service.foundation.mvi.repo.MviRepository
    public final String c() {
        return this.l;
    }

    public MmRecordingSummaryRepo(MmRecordingRepo r2, com.ss.android.lark.officesdk.minutes.service.foundation.userscope.a r3) {
        Intrinsics.checkNotNullParameter(r2, "recordingRepo");
        Intrinsics.checkNotNullParameter(r3, "mmUccApi");
        this.j = r2;
        this.k = r3;
        this.l = "MmSummaryRepo_" + hashCode();
        this.m = LazyKt.lazy(new MmRecordingSummaryRepo$opt$2(this));
    }
}
