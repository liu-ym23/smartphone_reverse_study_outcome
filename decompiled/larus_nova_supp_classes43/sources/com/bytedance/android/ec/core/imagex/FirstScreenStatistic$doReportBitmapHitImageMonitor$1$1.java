package com.bytedance.android.ec.core.imagex;

import kotlin.Metadata;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\n\n\u0000\n\u0002\u0010\t\n\u0002\b\u0003\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00012\u0006\u0010\u0003\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0004"}, d2 = {com.bytedance.android.ec.core.event.a.KEY_DURATION, "", "startTime", "endTime", "invoke"}, k = 3, mv = {1, 4, 3})
final class FirstScreenStatistic$doReportBitmapHitImageMonitor$1$1 extends Lambda implements Function2<Long, Long, Long> {
    public static final FirstScreenStatistic$doReportBitmapHitImageMonitor$1$1 INSTANCE = null;

    static {
        INSTANCE = new FirstScreenStatistic$doReportBitmapHitImageMonitor$1$1();
    }

    public FirstScreenStatistic$doReportBitmapHitImageMonitor$1$1() {
        super(2);
    }

    public final long invoke(long r10, long r11) {
        if (r10 > 0) goto L5;
    L7:
        return -1;
    L5:
        if (r11 < r10) goto L7;
        return r11 - r10;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r10, Object r11) {
        return Long.valueOf(invoke(((Number) r10).longValue(), ((Number) r11).longValue()));
    }
}
