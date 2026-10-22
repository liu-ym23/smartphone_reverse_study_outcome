package com.bytedance.android.livesdk.chatroom.vs_base.metrics;

import am2.b0;
import com.bytedance.android.livesdk.chatroom.vs_base.log.d;
import com.bytedance.android.livesdk.log.filter.o;
import com.bytedance.android.livesdkapi.depend.model.live.IRoom;
import com.bytedance.ies.sdk.widgets.DataCenter;
import cr1.a;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import kotlin.Metadata;
import kotlin.collections.SetsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\b\n\u0002\u0010\"\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001J\u0006\u0010\u0003\u001a\u00020\u0002J\u0018\u0010\b\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006J\u0010\u0010\t\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u0006H\u0004R$\u0010\f\u001a\u0012\u0012\u0004\u0012\u00020\u00040\nj\b\u0012\u0004\u0012\u00020\u0004`\u000b8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\f\u0010\rR$\u0010\u000f\u001a\u0004\u0018\u00010\u000e8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u000f\u0010\u0010\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014R\u0016\u0010\u0015\u001a\u00020\u000e8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0015\u0010\u0016R\u001a\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\u00180\u00178\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0019\u0010\u001aR\u0014\u0010\u001c\u001a\u00020\u001b8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u001c\u0010\u001dj\u0002\b\u001e¨\u0006\u001f"}, d2 = {"Lcom/bytedance/android/livesdk/chatroom/vs_base/metrics/ReplayUILatch;", "", "", "reset", "Lcr1/a;", "uiShowData", "Lcom/bytedance/ies/sdk/widgets/DataCenter;", "dataCenter", "countDown", "report", "Ljava/util/HashSet;", "Lkotlin/collections/HashSet;", "countDownSet", "Ljava/util/HashSet;", "", "startTime", "Ljava/lang/Long;", "getStartTime", "()Ljava/lang/Long;", "setStartTime", "(Ljava/lang/Long;)V", "maxTime", "J", "", "Lcom/bytedance/android/livesdk/chatroom/vs_base/metrics/ReplayUIMetrics;", "uiMetricsSet", "Ljava/util/Set;", "", "eventName", "Ljava/lang/String;", "MAIN_UI", "vs-base_saasRelease"}, k = 1, mv = {1, 4, 3})
public final enum ReplayUILatch extends Enum<ReplayUILatch> {
    public static final ReplayUILatch MAIN_UI = null;
    public static final /* synthetic */ ReplayUILatch[] a = null;
    private final HashSet<a> countDownSet;
    private final String eventName;
    private long maxTime;
    private Long startTime;
    private final Set<ReplayUIMetrics> uiMetricsSet;

    static {
        ReplayUILatch r2 = new ReplayUILatch(SetsKt.setOf(new ReplayUIMetrics[]{ReplayUIMetrics.TOOLBAR, ReplayUIMetrics.EXPAND_AREA, ReplayUIMetrics.BACK_GROUND}));
        MAIN_UI = r2;
        a = new ReplayUILatch[]{r2};
    }

    public static ReplayUILatch valueOf(String r1) {
        return (ReplayUILatch) r27.a.a(ReplayUILatch.class, r1);
    }

    public static ReplayUILatch[] values() {
        return (ReplayUILatch[]) a.clone();
    }

    public final void reset() {
        this.countDownSet.clear();
    }

    public final Long getStartTime() {
        return this.startTime;
    }

    public ReplayUILatch(Set r3) {
        super("MAIN_UI", 0);
        this.uiMetricsSet = r3;
        this.eventName = "vs_video_main_ui";
        this.countDownSet = new HashSet();
        this.maxTime = -1;
    }

    public final void report(DataCenter r8) {
        Intrinsics.checkNotNullParameter(r8, "dataCenter");
        Long r0 = this.startTime;
        if (r0 == null) goto L17;
        r0.longValue();
        Long r1 = this.startTime;
        Intrinsics.checkNotNull(r1);
        if (r1.longValue() >= 0) goto L7;
        return;
    L7:
        HashMap r2 = new HashMap();
        Iterator<T> r3 = this.countDownSet.iterator();
    L9:
        if (r3.hasNext() == false) goto L11;
        a r4 = (a) r3.next();
        long r5 = r4.b;
        Long r6 = this.startTime;
        Intrinsics.checkNotNull(r6);
        r2.put(r4.a.name(), String.valueOf(r5 - r6.longValue()));
        goto L9
    L11:
        long r7 = this.maxTime;
        Long r9 = this.startTime;
        Intrinsics.checkNotNull(r9);
        long r10 = r7 - r9.longValue();
        o r11 = d.a(r8).c(b0.class);
        if (r11 == null) goto L14;
        r11.a(r2);
    L14:
        r2.put("duration", String.valueOf(r10));
        d.a(r8).d(this.eventName, r2, new Object[]{IRoom.class});
        return;
    }

    public final void setStartTime(Long r1) {
        this.startTime = r1;
    }

    public final void countDown(a r6, DataCenter r7) {
        Intrinsics.checkNotNullParameter(r6, "uiShowData");
        if (r7 != null) goto L5;
        return;
    L5:
        Long r0 = this.startTime;
        if (r0 == null) goto L25;
        r0.longValue();
        Long r1 = this.startTime;
        Intrinsics.checkNotNull(r1);
        if (r1.longValue() >= 0) goto L10;
        return;
    L10:
        ReplayUIMetrics r2 = r6.a;
        Iterator<T> r3 = this.countDownSet.iterator();
    L12:
        if (r3.hasNext() == false) goto L17;
        if (((a) r3.next()).a != r2) goto L12;
        return;
    L17:
        if (this.uiMetricsSet.contains(r2) == false) goto L26;
        this.countDownSet.add(r6);
        this.maxTime = r6.b;
        if (this.uiMetricsSet.size() != this.countDownSet.size()) goto L27;
        report(r7);
        return;
    L27:
        return;
    L26:
        return;
    }
}
