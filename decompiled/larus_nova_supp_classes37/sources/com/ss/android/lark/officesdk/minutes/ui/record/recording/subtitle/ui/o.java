package com.ss.android.lark.officesdk.minutes.ui.record.recording.subtitle.ui;

import android.view.ViewTreeObserver;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.ss.android.lark.officesdk.minutes.api.recording.common.data.MmRecordingSource;
import com.ss.android.lark.officesdk.minutes.service.recording.common.perf.appreciable.MmRecordingSubtitleAppreciable;
import com.ss.android.lark.officesdk.minutes.service.recording.common.statistics.core.MmRecordingCommonParam;
import java.util.concurrent.atomic.AtomicReference;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
public final class o implements ViewTreeObserver.OnPreDrawListener {
    public final /* synthetic */ RecyclerView a;
    public final /* synthetic */ MmSubtitleFragment b;

    public o(RecyclerView r1, MmSubtitleFragment r2) {
        this.a = r1;
        this.b = r2;
    }

    @Override // android.view.ViewTreeObserver.OnPreDrawListener
    public final boolean onPreDraw() {
        if (this.a.getViewTreeObserver().isAlive() == true) goto L5;
        return true;
    L5:
        LinearLayoutManager r0 = this.b.o;
        if (r0 != null) goto L8;
        Intrinsics.throwUninitializedPropertyAccessException("layoutManager");
        r0 = null;
    L8:
        int r1 = r0.findFirstVisibleItemPosition();
        boolean r4 = false;
        if (this.a.getChildCount() == 0) goto L11;
        boolean r3 = true;
    L12:
        if (r3 == true) goto L14;
    L16:
        if (r4 == false) goto L43;
        this.b.z = true;
        MmRecordingSubtitleAppreciable r2 = com.ss.android.lark.officesdk.minutes.service.recording.common.perf.appreciable.a.d;
        MmRecordingSubtitleAppreciable.a r5 = r2.a.get();
        if (r5 != null) goto L21;
        lvb.a.h("MmRecordingSubtitleMetrics", "[trackerFirstSubtitleOnScreenSuccess] missing subtitle context");
    L39:
        ViewTreeObserver.OnPreDrawListener r6 = this.b.A;
        if (r6 == null) goto L42;
        this.a.getViewTreeObserver().removeOnPreDrawListener(r6);
    L42:
        this.b.A = null;
        goto L43
    L21:
        if (r5.h == false) goto L23;
        lvb.a.h("MmRecordingSubtitleMetrics", "[trackerFirstSubtitleOnScreenSuccess] duplicated, traceId=" + ((MmRecordingCommonParam) r5.a.invoke()).getRecordingTraceId());
        goto L39
    L23:
        Long r7 = r5.f;
        if (r7 == null) goto L38;
        long r8 = r7.longValue();
        r5.h = true;
        MmRecordingCommonParam r9 = (MmRecordingCommonParam) r5.a.invoke();
        com.ss.android.lark.officesdk.minutes.service.recording.common.statistics.core.d r10 = new com.ss.android.lark.officesdk.minutes.service.recording.common.statistics.core.d();
        MmRecordingSource r11 = r9.getSource();
        if (r11 == null) goto L28;
        String r12 = r11.getValue();
    L29:
        if (r12 != null) goto L31;
        r12 = "";
    L31:
        r10.e("source", r12);
        r10.e("message_id", r5.c);
        r10.e("conversation_id", r5.b);
        r10.e("receive_first_subtitle_latency", String.valueOf(RangesKt.coerceAtLeast(System.currentTimeMillis() - r8, 0)));
        lvb.a.e("MmRecordingSubtitleMetrics", "[trackerFirstSubtitleOnScreenSuccess] traceId=" + r9.getRecordingTraceId() + ", recordId=" + r9.getTrackerRecordId());
        com.ss.android.lark.officesdk.minutes.service.recording.common.perf.appreciable.a.a("listen_to_subtitle", r9, r10.a());
        AtomicReference<MmRecordingSubtitleAppreciable.a> r13 = r2.a;
    L33:
        if (r13.compareAndSet(r5, null) == true) goto L37;
        if (r13.get() == r5) goto L33;
    L37:
        lvb.a.e("MmRecordingSubtitleMetrics", "[trackerFirstSubtitleOnScreenSuccess] clear subtitle context, traceId=" + r9.getRecordingTraceId());
        goto L39
    L28:
        r12 = null;
        goto L29
    L38:
        lvb.a.h("MmRecordingSubtitleMetrics", "[trackerFirstSubtitleOnScreenSuccess] subtitle open time missing, traceId=" + ((MmRecordingCommonParam) r5.a.invoke()).getRecordingTraceId());
    L43:
        return true;
    L14:
        if (r1 == (-1)) goto L16;
        r4 = true;
        goto L16
    L11:
        r3 = false;
        goto L12
    }
}
