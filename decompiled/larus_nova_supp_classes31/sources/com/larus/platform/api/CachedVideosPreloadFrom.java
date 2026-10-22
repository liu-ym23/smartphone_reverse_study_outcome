package com.larus.platform.api;

import com.tencent.open.log.TraceLevel;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.collections.MapsKt;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.ranges.RangesKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0002\b\r\b\u0086\u0081\u0002\u0018\u0000 \u000f2\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\u000fB\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000e¨\u0006\u0010"}, d2 = {"Lcom/larus/platform/api/CachedVideosPreloadFrom;", "", "value", "", "<init>", "(Ljava/lang/String;II)V", "getValue", "()I", "DEFAULT", "OUTER_FALLBACK", "CMD", "BIND_PULL_API", "REFRESH_VIDEO", "UN_CONSUMED", "UNLIMITED_FLOW", "Companion", "platform_release"}, k = 1, mv = {2, 1, 0}, xi = TraceLevel.ABOVE_WARN)
public final enum CachedVideosPreloadFrom extends Enum<CachedVideosPreloadFrom> {
    public static final CachedVideosPreloadFrom BIND_PULL_API = null;
    public static final CachedVideosPreloadFrom CMD = null;
    public static final a Companion = null;
    public static final CachedVideosPreloadFrom DEFAULT = null;
    public static final CachedVideosPreloadFrom OUTER_FALLBACK = null;
    public static final CachedVideosPreloadFrom REFRESH_VIDEO = null;
    public static final CachedVideosPreloadFrom UNLIMITED_FLOW = null;
    public static final CachedVideosPreloadFrom UN_CONSUMED = null;
    public static final Map<Integer, CachedVideosPreloadFrom> a = null;
    public static final /* synthetic */ CachedVideosPreloadFrom[] b = null;
    public static final /* synthetic */ EnumEntries c = null;
    private final int value;

    public static EnumEntries<CachedVideosPreloadFrom> getEntries() {
        return c;
    }

    /* JADX WARN: Type inference failed for: r0v2, types: [com.larus.platform.api.CachedVideosPreloadFrom$a] */
    static {
        int r2 = 0;
        CachedVideosPreloadFrom r0 = new CachedVideosPreloadFrom("DEFAULT", 0, 0);
        DEFAULT = r0;
        CachedVideosPreloadFrom r1 = new CachedVideosPreloadFrom("OUTER_FALLBACK", 1, 1);
        OUTER_FALLBACK = r1;
        CachedVideosPreloadFrom r3 = new CachedVideosPreloadFrom("CMD", 2, 2);
        CMD = r3;
        CachedVideosPreloadFrom r5 = new CachedVideosPreloadFrom("BIND_PULL_API", 3, 3);
        BIND_PULL_API = r5;
        CachedVideosPreloadFrom r7 = new CachedVideosPreloadFrom("REFRESH_VIDEO", 4, 4);
        REFRESH_VIDEO = r7;
        CachedVideosPreloadFrom r9 = new CachedVideosPreloadFrom("UN_CONSUMED", 5, 5);
        UN_CONSUMED = r9;
        CachedVideosPreloadFrom r11 = new CachedVideosPreloadFrom("UNLIMITED_FLOW", 6, 6);
        UNLIMITED_FLOW = r11;
        CachedVideosPreloadFrom[] r13 = {r0, r1, r3, r5, r7, r9, r11};
        b = r13;
        c = EnumEntriesKt.enumEntries(r13);
        Companion = new a();
        CachedVideosPreloadFrom[] r4 = values();
        LinkedHashMap r6 = new LinkedHashMap(RangesKt.coerceAtLeast(MapsKt.mapCapacity(r4.length), 16));
        int r8 = r4.length;
    L3:
        if (r2 >= r8) goto L5;
        CachedVideosPreloadFrom r10 = r4[r2];
        r6.put(Integer.valueOf(r10.value), r10);
        r2 = r2 + 1;
        goto L3
    L5:
        a = r6;
    }

    public static CachedVideosPreloadFrom[] values() {
        return (CachedVideosPreloadFrom[]) b.clone();
    }

    public static final /* synthetic */ Map access$getMap$cp() {
        return a;
    }

    public final int getValue() {
        return this.value;
    }

    public static CachedVideosPreloadFrom valueOf(String r1) {
        return (CachedVideosPreloadFrom) r27.a.a(CachedVideosPreloadFrom.class, r1);
    }

    public CachedVideosPreloadFrom(String r1, int r2, int r3) {
        super(r1, r2);
        this.value = r3;
    }
}
