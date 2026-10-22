package com.ss.android.lark.officesdk.minutes.service.recording.common.repo.summary.helper;

import com.ss.android.lark.officesdk.minutes.service.recording.common.repo.MmRecordingRepo;
import com.ss.android.lark.officesdk.minutes.service.recording.common.repo.helper.MmBaseNetReconnectHelper;
import com.ss.android.lark.officesdk.minutes.service.recording.common.repo.summary.MmRecordingSummaryRepo;
import com.ss.android.lark.officesdk.minutes.service.recording.common.repo.summary.MmSummaryStatus;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.DelayKt;
import lvb.a;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
public final class MmSummaryNetReconnectHelper extends MmBaseNetReconnectHelper {
    public final MmRecordingSummaryRepo g;
    public final String h;
    public final long i;
    public final long j;

    @Override // com.ss.android.lark.officesdk.minutes.service.recording.common.repo.helper.MmBaseNetReconnectHelper
    public final void f() {
        a.e(this.h, "onNetworkStatusChanged, net unAvailable");
    }

    @Override // com.ss.android.lark.officesdk.minutes.service.recording.common.repo.helper.MmBaseNetReconnectHelper
    public final long c() {
        return this.j;
    }

    @Override // com.ss.android.lark.officesdk.minutes.service.recording.common.repo.helper.MmBaseNetReconnectHelper
    public final long d() {
        return this.i;
    }

    @Override // com.ss.android.lark.officesdk.minutes.service.recording.common.repo.helper.MmBaseNetReconnectHelper
    public final String e() {
        return this.h;
    }

    @Override // com.ss.android.lark.officesdk.minutes.service.recording.common.repo.helper.MmBaseNetReconnectHelper
    public final Object b(Continuation<? super Unit> r5) {
        if ((r5 instanceof MmSummaryNetReconnectHelper$doFetch$1) == false) goto L7;
        MmSummaryNetReconnectHelper$doFetch$1 r0 = (MmSummaryNetReconnectHelper$doFetch$1) r5;
        int r1 = r0.label;
        if ((r1 & Integer.MIN_VALUE) == 0) goto L7;
        r0.label = r1 - Integer.MIN_VALUE;
    L8:
        Object r6 = r0.result;
        Object r2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r3 = r0.label;
        if (r3 == 0) goto L14;
        if (r3 != 1) goto L13;
        ResultKt.throwOnFailure(r6);
    L19:
        this.g.l().x("NetworkReconnect");
        return Unit.INSTANCE;
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        ResultKt.throwOnFailure(r6);
        if (this.g.l().m().e != MmSummaryStatus.MeetingAISummaryOpenError) goto L19;
        a.e(this.h, "doFetch, status is Error, retry meetingAISwitch first");
        this.g.l().P0();
        r0.label = 1;
        if (DelayKt.delay(1000, r0) != r2) goto L19;
        return r2;
    L7:
        r0 = new MmSummaryNetReconnectHelper$doFetch$1(this, r5);
        goto L8
    }

    public MmSummaryNetReconnectHelper(MmRecordingRepo r3, MmRecordingSummaryRepo r4) {
        Intrinsics.checkNotNullParameter(r3, "recordingRepo");
        Intrinsics.checkNotNullParameter(r4, "summaryRepo");
        CoroutineScope r1 = r4.d();
        Intrinsics.checkNotNullParameter(r3, "recordingRepo");
        Intrinsics.checkNotNullParameter(r1, "scope");
        super(r3.n().c, r1);
        this.g = r4;
        this.h = "MmSummaryNetReconnectHelper";
        this.i = 2000;
        this.j = 1500;
    }
}
