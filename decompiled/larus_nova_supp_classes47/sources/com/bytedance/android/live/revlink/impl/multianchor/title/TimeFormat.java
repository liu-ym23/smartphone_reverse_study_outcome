package com.bytedance.android.live.revlink.impl.multianchor.title;

import kotlin.Metadata;
import r27.a;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0003\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001j\u0002\b\u0002j\u0002\b\u0003¨\u0006\u0004"}, d2 = {"Lcom/bytedance/android/live/revlink/impl/multianchor/title/TimeFormat;", "", "TIME_S", "TIME_MM_SS", "liverevlink-impl_saasRelease"}, k = 1, mv = {1, 5, 1})
public final enum TimeFormat extends Enum<TimeFormat> {
    public static final TimeFormat TIME_MM_SS = null;
    public static final TimeFormat TIME_S = null;
    public static final /* synthetic */ TimeFormat[] a = null;

    static {
        TimeFormat r1 = new TimeFormat("TIME_S", 0);
        TIME_S = r1;
        TimeFormat r2 = new TimeFormat("TIME_MM_SS", 1);
        TIME_MM_SS = r2;
        a = new TimeFormat[]{r1, r2};
    }

    public static TimeFormat valueOf(String r1) {
        return (TimeFormat) a.a(TimeFormat.class, r1);
    }

    public static TimeFormat[] values() {
        return (TimeFormat[]) a.clone();
    }

    public TimeFormat(String r1, int r2) {
        super(r1, r2);
    }
}
