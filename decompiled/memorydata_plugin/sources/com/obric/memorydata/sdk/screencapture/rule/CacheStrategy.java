package com.obric.memorydata.sdk.screencapture.rule;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0006\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006¨\u0006\u0007"}, d2 = {"Lcom/obric/memorydata/sdk/screencapture/rule/CacheStrategy;", "", "<init>", "(Ljava/lang/String;I)V", "NO_CACHE", "CACHE_WITH_ROOT_NODE", "CACHE_WITH_UNIQUE_NODE", "memoryDataSDK_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final enum CacheStrategy extends Enum<CacheStrategy> {
    private static final /* synthetic */ EnumEntries $ENTRIES = null;
    private static final /* synthetic */ CacheStrategy[] $VALUES = null;
    public static final CacheStrategy CACHE_WITH_ROOT_NODE = null;
    public static final CacheStrategy CACHE_WITH_UNIQUE_NODE = null;
    public static final CacheStrategy NO_CACHE = null;

    private static final /* synthetic */ CacheStrategy[] $values() {
        return new CacheStrategy[]{NO_CACHE, CACHE_WITH_ROOT_NODE, CACHE_WITH_UNIQUE_NODE};
    }

    static {
        NO_CACHE = new CacheStrategy("NO_CACHE", 0);
        CACHE_WITH_ROOT_NODE = new CacheStrategy("CACHE_WITH_ROOT_NODE", 1);
        CACHE_WITH_UNIQUE_NODE = new CacheStrategy("CACHE_WITH_UNIQUE_NODE", 2);
        CacheStrategy[] r0 = $values();
        $VALUES = r0;
        $ENTRIES = EnumEntriesKt.enumEntries((Enum[]) ZeusTransformUtils.preCheckCast(r0, Enum[].class, "com.obric.memorydata.plugin"));
    }

    private CacheStrategy(String r1, int r2) {
        super(r1, r2);
    }

    public static EnumEntries<CacheStrategy> getEntries() {
        return $ENTRIES;
    }

    public static CacheStrategy valueOf(String r2) {
        return (CacheStrategy) ZeusTransformUtils.preCheckCast(Enum.valueOf(CacheStrategy.class, r2), CacheStrategy.class, "com.obric.memorydata.plugin");
    }

    public static CacheStrategy[] values() {
        return (CacheStrategy[]) ZeusTransformUtils.preCheckCast($VALUES.clone(), CacheStrategy[].class, "com.obric.memorydata.plugin");
    }
}
