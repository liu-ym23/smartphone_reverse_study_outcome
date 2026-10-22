package com.ss.android.lark.officesdk.minutes.service.recording.common.core.service.upload;

import com.ss.android.lark.officesdk.minutes.api.recording.common.data.MmRecordingSource;
import com.ss.android.lark.officesdk.minutes.service.foundation.mvi.thread.MMCoroutines;
import com.ss.android.lark.officesdk.minutes.service.recording.common.core.MmRecordingSession;
import com.ss.android.lark.officesdk.minutes.service.recording.common.perf.appreciable.MmRecordingHistoryUploadAgeInfo;
import com.ss.android.lark.officesdk.minutes.service.recording.common.perf.appreciable.d;
import com.ss.android.lark.officesdk.minutes.service.recording.common.statistics.core.MmRecordingCommonParam;
import com.ss.android.lark.officesdk.minutes.service.recording.common.statistics.l;
import iub.k;
import java.io.File;
import java.util.List;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.ExecutorCoroutineDispatcher;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
public final class MmRecordingHistoryUploadResumeTracker {
    public static final /* synthetic */ int c = 0;
    public final MmRecordingSession a;
    public final com.ss.android.lark.officesdk.minutes.service.foundation.userscope.a b;

    public static final class a {
    }

    static {
    }

    public MmRecordingHistoryUploadResumeTracker(MmRecordingSession r2) {
        Intrinsics.checkNotNullParameter(r2, "recordingSession");
        this.a = r2;
        this.b = r2.b;
    }

    public final Object b(String r27, Continuation<? super Unit> r28) {
        String r1 = r27;
        if ((r28 instanceof MmRecordingHistoryUploadResumeTracker$track$1) == false) goto L7;
        MmRecordingHistoryUploadResumeTracker$track$1 r3 = (MmRecordingHistoryUploadResumeTracker$track$1) r28;
        int r4 = r3.label;
        if ((r4 & Integer.MIN_VALUE) == 0) goto L7;
        r3.label = r4 - Integer.MIN_VALUE;
    L8:
        Object r2 = r3.result;
        Object r5 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r6 = r3.label;
        if (r6 == 0) goto L16;
        if (r6 == 1) goto L15;
        if (r6 != 2) goto L14;
        List<? extends File> r7 = (List) r3.L$2;
        MmRecordingCommonParam r8 = (MmRecordingCommonParam) r3.L$1;
        String r9 = (String) r3.L$0;
        ResultKt.throwOnFailure(r2);
        String r13 = r9;
        MmRecordingCommonParam r10 = r8;
    L23:
        MmRecordingHistoryUploadAgeInfo r11 = (MmRecordingHistoryUploadAgeInfo) r2;
        k r12 = this.a.f;
        if (r12 == null) goto L29;
        MmRecordingSource r14 = r12.a;
        if (r14 == null) goto L29;
        String r15 = r14.name();
        if (r15 == null) goto L29;
    L30:
        lvb.a.e("MmHistoryUploadResumeTracker", "[track] send resume event, meetingId=" + r13 + ", traceId=" + this.a.c + ", source=" + r15 + ", ageInfo=" + r11 + ", pendingSegmentCount=" + r7.size());
        d r16 = com.ss.android.lark.officesdk.minutes.service.recording.common.perf.appreciable.a.c;
        String r17 = this.a.c;
        MmRecordingSource r18 = r10.getSource();
        if (r18 != null) goto L36;
        k r19 = this.a.f;
        if (r19 == null) goto L35;
        r18 = r19.a;
        goto L36
    L35:
        r18 = null;
    L36:
        MmRecordingCommonParam r20 = MmRecordingCommonParam.copy$default(r10, null, r13, false, null, r13, null, r17, r18, null, null, null, 1837, null);
        int r21 = r7.size();
        r16.getClass();
        Intrinsics.checkNotNullParameter(r20, "commonParam");
        Intrinsics.checkNotNullParameter(r15, "source");
        Intrinsics.checkNotNullParameter(r11, "ageInfo");
        lvb.a.e("MmRecordingUploadMetrics", "[trackHistoryUploadResume] recordId=" + r20.getTrackerRecordId() + ", traceId=" + r20.getRecordingTraceId() + ", source=" + r15 + ", ageInfo=" + r11 + ", pendingSegmentCount=" + r21);
        com.ss.android.lark.officesdk.minutes.service.recording.common.statistics.core.d r22 = new com.ss.android.lark.officesdk.minutes.service.recording.common.statistics.core.d();
        r22.e("source", r15);
        r22.c("age_ms", r11.a);
        r22.e("age_bucket", r11.b);
        r22.b("is_over_24h", r11.c ? 1 : 0);
        r22.b("pending_segment_count", r21);
        com.ss.android.lark.officesdk.minutes.service.recording.common.perf.appreciable.a.a("recording_history_upload_resume", r20, r22.a());
        if (r11.c == false) goto L40;
        l.i(this.a.b(), "upload", Boxing.boxInt(-10024), "expired_over_24h", null, null, null, null, null, 4080);
    L40:
        return Unit.INSTANCE;
    L29:
        r15 = "history_recording";
        goto L30
    L14:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L15:
        MmRecordingCommonParam r23 = (MmRecordingCommonParam) r3.L$1;
        String r24 = (String) r3.L$0;
        ResultKt.throwOnFailure(r2);
        MmRecordingCommonParam r25 = r23;
        r1 = r24;
    L19:
        List<? extends File> r26 = (List) r2;
        r3.L$0 = r1;
        r3.L$1 = r25;
        r3.L$2 = r26;
        r3.label = 2;
        Object r29 = a(r1, r26, r3);
        if (r29 != r5) goto L22;
        return r5;
    L22:
        r13 = r1;
        r7 = r26;
        r2 = r29;
        r10 = r25;
        goto L23
    L16:
        ResultKt.throwOnFailure(r2);
        lvb.a.e("MmHistoryUploadResumeTracker", "[track] start, meetingId=" + r1);
        String r30 = this.b.getCurrentUserId();
        r25 = this.a.j();
        r3.L$0 = r1;
        r3.L$1 = r25;
        r3.label = 1;
        r2 = BuildersKt.withContext(MMCoroutines.a(), new MmRecordingHistoryUploadResumeTracker$getHistorySegmentFiles$2(r30, r1, null), r3);
        if (r2 != r5) goto L19;
        return r5;
    L7:
        r3 = new MmRecordingHistoryUploadResumeTracker$track$1(this, r28);
        goto L8
    }

    public final Object a(String r11, List<? extends File> r12, Continuation<? super MmRecordingHistoryUploadAgeInfo> r13) {
        if ((r13 instanceof MmRecordingHistoryUploadResumeTracker$resolveHistoryUploadAgeInfo$1) == false) goto L7;
        MmRecordingHistoryUploadResumeTracker$resolveHistoryUploadAgeInfo$1 r0 = (MmRecordingHistoryUploadResumeTracker$resolveHistoryUploadAgeInfo$1) r13;
        int r1 = r0.label;
        if ((r1 & Integer.MIN_VALUE) == 0) goto L7;
        r0.label = r1 - Integer.MIN_VALUE;
    L8:
        Object r14 = r0.result;
        Object r2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r3 = r0.label;
        boolean r4 = true;
        if (r3 == 0) goto L14;
        if (r3 != 1) goto L13;
        r11 = (String) r0.L$0;
        ResultKt.throwOnFailure(r14);
    L17:
        Long r15 = (Long) r14;
        if (r15 == null) goto L41;
        lvb.a.e("MmHistoryUploadResumeTracker", "[resolveHistoryUploadAgeInfo] use latest segment file mtime, meetingId=" + r11 + ", latestSegmentFileMtime=" + r15);
        int r16 = MmRecordingHistoryUploadAgeInfo.d;
        long r5 = System.currentTimeMillis();
        if (r15.longValue() <= 0) goto L43;
        long r6 = Math.max(0, r5 - r15.longValue());
        if (r6 >= 0) goto L26;
        String r17 = MmRecordingHistoryUploadAgeInfo.AgeBucket.UNKNOWN.getValue();
    L36:
        if (r6 >= 86400000) goto L40;
        r4 = false;
    L40:
        return new MmRecordingHistoryUploadAgeInfo(r6, r17, r4);
    L26:
        if (r6 >= 3600000) goto L29;
        r17 = MmRecordingHistoryUploadAgeInfo.AgeBucket.WITHIN_1H.getValue();
        goto L36
    L29:
        if (r6 >= 21600000) goto L32;
        r17 = MmRecordingHistoryUploadAgeInfo.AgeBucket.BETWEEN_1H_6H.getValue();
        goto L36
    L32:
        if (r6 >= 86400000) goto L34;
        r17 = MmRecordingHistoryUploadAgeInfo.AgeBucket.BETWEEN_6H_24H.getValue();
        goto L36
    L34:
        r17 = MmRecordingHistoryUploadAgeInfo.AgeBucket.EXPIRED_24H.getValue();
        goto L36
    L43:
        return new MmRecordingHistoryUploadAgeInfo(-1, MmRecordingHistoryUploadAgeInfo.AgeBucket.UNKNOWN.getValue(), false);
    L41:
        lvb.a.h("MmHistoryUploadResumeTracker", "[resolveHistoryUploadAgeInfo] age unknown, meetingId=" + r11);
        return new MmRecordingHistoryUploadAgeInfo(-1, MmRecordingHistoryUploadAgeInfo.AgeBucket.UNKNOWN.getValue(), false);
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        ResultKt.throwOnFailure(r14);
        ExecutorCoroutineDispatcher r18 = MMCoroutines.a();
        MmRecordingHistoryUploadResumeTracker$resolveHistoryUploadAgeInfo$latestSegmentFileMtime$1 r7 = new MmRecordingHistoryUploadResumeTracker$resolveHistoryUploadAgeInfo$latestSegmentFileMtime$1(r12, null);
        r0.L$0 = r11;
        r0.label = 1;
        r14 = BuildersKt.withContext(r18, r7, r0);
        if (r14 != r2) goto L17;
        return r2;
    L7:
        r0 = new MmRecordingHistoryUploadResumeTracker$resolveHistoryUploadAgeInfo$1(this, r13);
        goto L8
    }
}
