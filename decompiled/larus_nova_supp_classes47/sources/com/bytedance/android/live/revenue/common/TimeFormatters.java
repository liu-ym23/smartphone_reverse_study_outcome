package com.bytedance.android.live.revenue.common;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\u0000\n\u0002\b\u0002\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u00012\u00020\u0002j\u0002\b\u0003¨\u0006\u0004"}, d2 = {"Lcom/bytedance/android/live/revenue/common/TimeFormatters;", "", "", "MM_SS", "revenue-common_saasRelease"}, k = 1, mv = {1, 5, 1})
public abstract enum TimeFormatters extends Enum<TimeFormatters> {
    public static final TimeFormatters MM_SS = null;
    public static final /* synthetic */ TimeFormatters[] a = null;

    static {
        final String r2 = "MM_SS";
        final int r3 = 0;
        TimeFormatters r1 = new MM_SS(r2, r3);
        MM_SS = r1;
        a = new TimeFormatters[]{r1};
    }

    public TimeFormatters() {
        throw null;
    }

    public static TimeFormatters valueOf(String r1) {
        return (TimeFormatters) r27.a.a(TimeFormatters.class, r1);
    }

    public static TimeFormatters[] values() {
        return (TimeFormatters[]) a.clone();
    }

    public abstract /* synthetic */ String invoke(u0 r1);

    public TimeFormatters(String r1, int r2, DefaultConstructorMarker r3) {
        super(r1, r2);
    }
}
