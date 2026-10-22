package com.obric.memorydata.memory.ui.automemory;

import java.time.format.DateTimeFormatter;
import java.util.Locale;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0018\u0002\n\u0000\"\u000e\u0010\u0000\u001a\u00020\u0001X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0002"}, d2 = {"DATE_TIME_FORMAT", "Ljava/time/format/DateTimeFormatter;", "memory_obricRelease"}, k = 2, mv = {2, 0, 0}, xi = 48)
public final class g {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final DateTimeFormatter f10674a = null;

    static {
        DateTimeFormatter r0 = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm", Locale.CHINA);
        Intrinsics.checkNotNullExpressionValue(r0, "ofPattern(...)");
        f10674a = r0;
    }

    public static final /* synthetic */ DateTimeFormatter a() {
        return f10674a;
    }
}
