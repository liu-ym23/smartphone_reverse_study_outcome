package com.ss.android.lark.officesdk.minutes.service.recording.common.perf.appreciable;

import com.ss.android.lark.officesdk.minutes.api.recording.common.data.MmRecordingSource;
import com.ss.android.lark.officesdk.minutes.api.recording.doubao.DoubaoBizInfo;
import com.ss.android.lark.officesdk.minutes.service.recording.common.statistics.core.MmRecordingCommonParam;
import java.util.concurrent.atomic.AtomicReference;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
public final class MmRecordingSubtitleAppreciable {
    public final AtomicReference<a> a;

    public static final class a {
        public Function0<MmRecordingCommonParam> a;
        public final String b;
        public final String c;
        public final long d;
        public Long e;
        public Long f;
        public boolean g;
        public boolean h;

        public a() {
            throw null;
        }

        public final boolean equals(Object r8) {
            if (this != r8) goto L6;
            return true;
        L6:
            if ((r8 instanceof a) == true) goto L8;
            return false;
        L8:
            a r9 = (a) r8;
            if (Intrinsics.areEqual(this.a, r9.a) == true) goto L12;
            return false;
        L12:
            if (Intrinsics.areEqual(this.b, r9.b) == true) goto L15;
            return false;
        L15:
            if (Intrinsics.areEqual(this.c, r9.c) == true) goto L18;
            return false;
        L18:
            if (this.d == r9.d) goto L21;
            return false;
        L21:
            if (Intrinsics.areEqual(this.e, r9.e) == true) goto L24;
            return false;
        L24:
            if (Intrinsics.areEqual(this.f, r9.f) == true) goto L27;
            return false;
        L27:
            if (this.g == r9.g) goto L30;
            return false;
        L30:
            if (this.h == r9.h) goto L32;
            return false;
        L32:
            return true;
        }

        public final int hashCode() {
            int r0 = ((((this.a.hashCode() * 31) + this.b.hashCode()) * 31) + this.c.hashCode()) * 31;
            long r1 = this.d;
            int r2 = (r0 + ((int) (r1 ^ (r1 >>> 32)))) * 31;
            Long r3 = this.e;
            int r4 = 0;
            if (r3 != null) goto L5;
            int r5 = 0;
        L6:
            int r6 = (r2 + r5) * 31;
            Long r7 = this.f;
            if (r7 == null) goto L10;
            r4 = r7.hashCode();
        L10:
            int r8 = (r6 + r4) * 31;
            int r9 = 1231;
            if (this.g == false) goto L13;
            int r10 = 1231;
        L14:
            int r11 = (r8 + r10) * 31;
            if (this.h == true) goto L19;
            r9 = 1237;
        L19:
            return r11 + r9;
        L13:
            r10 = 1237;
            goto L14
        L5:
            r5 = r3.hashCode();
            goto L6
        }

        public final String toString() {
            return "AsrContext(commonParamProvider=" + this.a + ", conversationId=" + this.b + ", messageId=" + this.c + ", requestStartTimeMs=" + this.d + ", startMeetingLatencyMs=" + this.e + ", subtitleOpenSuccessTimeMs=" + this.f + ", hasTrackedSubtitleOpenSuccess=" + this.g + ", hasTrackedFirstSubtitleOnScreenSuccess=" + this.h + ')';
        }

        public a(Function0 r2, String r3, String r4, long r5) {
            Intrinsics.checkNotNullParameter(r2, "commonParamProvider");
            Intrinsics.checkNotNullParameter(r3, "conversationId");
            Intrinsics.checkNotNullParameter(r4, "messageId");
            this.a = r2;
            this.b = r3;
            this.c = r4;
            this.d = r5;
            this.e = null;
            this.f = null;
            this.g = false;
            this.h = false;
        }
    }

    public static final class b {
    }

    static {
    }

    public final void a() {
        a r0 = this.a.get();
        String r2 = null;
        this.a.set(null);
        StringBuilder r1 = new StringBuilder("[clearSubtitleTracking] cleared, traceId=");
        if (r0 == null) goto L9;
        Function0<MmRecordingCommonParam> r3 = r0.a;
        if (r3 == null) goto L9;
        MmRecordingCommonParam r4 = (MmRecordingCommonParam) r3.invoke();
        if (r4 == null) goto L9;
        r2 = r4.getRecordingTraceId();
    L9:
        r1.append(r2);
        lvb.a.e("MmRecordingSubtitleMetrics", r1.toString());
    }

    public final void d() {
        a r0 = this.a.get();
        if (r0 != null) goto L7;
        lvb.a.h("MmRecordingSubtitleMetrics", "[trackerSubtitleOpenSuccess] missing subtitle context");
        return;
    L7:
        if (r0.g == false) goto L10;
        lvb.a.h("MmRecordingSubtitleMetrics", "[trackerSubtitleOpenSuccess] duplicated, traceId=" + ((MmRecordingCommonParam) r0.a.invoke()).getRecordingTraceId());
        return;
    L10:
        r0.g = true;
        r0.f = Long.valueOf(System.currentTimeMillis());
        MmRecordingCommonParam r2 = (MmRecordingCommonParam) r0.a.invoke();
        com.ss.android.lark.officesdk.minutes.service.recording.common.statistics.core.d r3 = new com.ss.android.lark.officesdk.minutes.service.recording.common.statistics.core.d();
        MmRecordingSource r4 = r2.getSource();
        String r5 = null;
        if (r4 == null) goto L13;
        String r6 = r4.getValue();
    L14:
        if (r6 != null) goto L16;
        r6 = "";
    L16:
        r3.e("source", r6);
        r3.e("message_id", r0.c);
        r3.e("conversation_id", r0.b);
        r3.e("start_meeting_latency", String.valueOf(r0.e));
        Long r7 = r0.f;
        if (r7 == null) goto L23;
        long r8 = r7.longValue() - r0.d;
        Long r9 = r0.e;
        if (r9 == null) goto L21;
        long r10 = r9.longValue();
    L22:
        String r11 = String.valueOf(RangesKt.coerceAtLeast(r8 - r10, 0));
    L24:
        r3.e("open_subtitle_latency", r11);
        Long r12 = r0.f;
        if (r12 == null) goto L27;
        r5 = String.valueOf(RangesKt.coerceAtLeast(r12.longValue() - r0.d, 0));
    L27:
        r3.e("total_latency", r5);
        lvb.a.e("MmRecordingSubtitleMetrics", "[trackerSubtitleOpenSuccess] traceId=" + r2.getRecordingTraceId() + ", recordId=" + r2.getTrackerRecordId() + ", startMeetingLatencyMs=" + r0.e);
        com.ss.android.lark.officesdk.minutes.service.recording.common.perf.appreciable.b r1 = com.ss.android.lark.officesdk.minutes.service.recording.common.perf.appreciable.a.a;
        com.ss.android.lark.officesdk.minutes.service.recording.common.perf.appreciable.a.a("subtitle_open_success", r2, r3.a());
        return;
    L21:
        r10 = 0;
        goto L22
    L23:
        r11 = null;
        goto L24
    L13:
        r6 = null;
        goto L14
    }

    public MmRecordingSubtitleAppreciable() {
        this.a = new AtomicReference(null);
    }

    public final void b(Function0<MmRecordingCommonParam> r7) {
        Intrinsics.checkNotNullParameter(r7, "commonParamProvider");
        a r0 = this.a.get();
        if (r0 != null) goto L6;
        lvb.a.h("MmRecordingSubtitleMetrics", "[onStartMeetingSuccess] missing subtitle context");
        return;
    L6:
        Intrinsics.checkNotNullParameter(r7, "<set-?>");
        r0.a = r7;
        MmRecordingCommonParam r8 = (MmRecordingCommonParam) r7.invoke();
        r0.e = Long.valueOf(RangesKt.coerceAtLeast(System.currentTimeMillis() - r0.d, 0));
        lvb.a.e("MmRecordingSubtitleMetrics", "[onStartMeetingSuccess] traceId=" + r8.getRecordingTraceId() + ", recordId=" + r8.getTrackerRecordId() + ", latencyMs=" + r0.e);
    }

    public final void c(String r24, MmRecordingSource r25, DoubaoBizInfo r26) {
        Intrinsics.checkNotNullParameter(r24, "recordingTraceId");
        String r16 = null;
        final MmRecordingCommonParam r15 = new MmRecordingCommonParam(null, null, false, null, null, null, r24, r25, null, null, null, 1855, null);
        Function0<MmRecordingCommonParam> r1 = new MmRecordingSubtitleAppreciable$startSubtitleTracking$context$1(r15);
        if (r26 == null) goto L5;
        String r2 = r26.getConversationId();
    L7:
        if (r2 != null) goto L9;
        String r19 = "";
    L10:
        if (r26 == null) goto L12;
        String r3 = r26.getMessageId();
    L13:
        if (r3 != null) goto L15;
        String r20 = "";
    L16:
        a r0 = new a(r1, r19, r20, System.currentTimeMillis());
        this.a.set(r0);
        StringBuilder r4 = new StringBuilder("[startSubtitleTracking] traceId=");
        r4.append(r24);
        r4.append(", source=");
        if (r25 == null) goto L19;
        r16 = r25.getValue();
    L19:
        r4.append(r16);
        r4.append(", conversationId=");
        r4.append(r0.b);
        r4.append(", messageId=");
        r4.append(r0.c);
        lvb.a.e("MmRecordingSubtitleMetrics", r4.toString());
        return;
    L15:
        r20 = r3;
        goto L16
    L12:
        r3 = null;
        goto L13
    L9:
        r19 = r2;
        goto L10
    L5:
        r2 = null;
        goto L7
    }
}
