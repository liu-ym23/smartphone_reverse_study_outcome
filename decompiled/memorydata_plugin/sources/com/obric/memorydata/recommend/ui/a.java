package com.obric.memorydata.recommend.ui;

import com.obric.memorydata.utils.Format;
import java.text.SimpleDateFormat;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u000e\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nJ\u000e\u0010\u000b\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nR\u0010\u0010\u0004\u001a\u00020\u00058\u0002X\u0083\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0006\u001a\u00020\u00058\u0002X\u0083\u0004¢\u0006\u0002\n\u0000¨\u0006\f"}, d2 = {"Lcom/obric/memorydata/recommend/ui/MemoryDataToCardDateUtil;", "", "<init>", "()V", "ymdFormatter", "Ljava/text/SimpleDateFormat;", "ymdSimpleFormatter", "formatDateByCurrentYear", "", "timestamp", "", "formatSimpleMonthDate", "recommend_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final a f12641a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final SimpleDateFormat f12642b = null;
    private static final SimpleDateFormat c = null;

    static {
        f12641a = new a();
        f12642b = new SimpleDateFormat(Format.FULL.getValue());
        c = new SimpleDateFormat(Format.MONTH_DAY_HOUR_MINUTE.getValue());
    }

    private a() {
    }

    public final String a(long r1) {
        String r0 = f12642b.format(Long.valueOf(r1));
        Intrinsics.checkNotNullExpressionValue(r0, "format(...)");
        return r0;
    }

    public final String b(long r1) {
        String r0 = c.format(Long.valueOf(r1));
        Intrinsics.checkNotNullExpressionValue(r0, "format(...)");
        return r0;
    }
}
