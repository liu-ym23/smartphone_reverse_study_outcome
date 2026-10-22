package com.obric.memorydata.sdk.screencapture.rule;

import com.obric.eventkit.eventstaskmanager.ITaskManager;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import r27.a;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes6.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0006\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006¨\u0006\u0007"}, d2 = {"Lcom/obric/memorydata/sdk/screencapture/rule/CacheStrategy;", "", "<init>", "(Ljava/lang/String;I)V", "NO_CACHE", "CACHE_WITH_ROOT_NODE", "CACHE_WITH_UNIQUE_NODE", "memoryDataSDK_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = ITaskManager.Stub.TRANSACTION_getEventTasksByType)
public final enum CacheStrategy extends Enum<CacheStrategy> {
    public static final CacheStrategy CACHE_WITH_ROOT_NODE = null;
    public static final CacheStrategy CACHE_WITH_UNIQUE_NODE = null;
    public static final CacheStrategy NO_CACHE = null;
    public static final /* synthetic */ CacheStrategy[] a = null;
    public static final /* synthetic */ EnumEntries b = null;

    public static EnumEntries<CacheStrategy> getEntries() {
        return b;
    }

    static {
        CacheStrategy r0 = new CacheStrategy("NO_CACHE", 0);
        NO_CACHE = r0;
        CacheStrategy r1 = new CacheStrategy("CACHE_WITH_ROOT_NODE", 1);
        CACHE_WITH_ROOT_NODE = r1;
        CacheStrategy r3 = new CacheStrategy("CACHE_WITH_UNIQUE_NODE", 2);
        CACHE_WITH_UNIQUE_NODE = r3;
        CacheStrategy[] r5 = {r0, r1, r3};
        a = r5;
        b = EnumEntriesKt.enumEntries(r5);
    }

    public static CacheStrategy[] values() {
        return (CacheStrategy[]) a.clone();
    }

    public static CacheStrategy valueOf(String r1) {
        return (CacheStrategy) a.a(CacheStrategy.class, r1);
    }

    public CacheStrategy(String r1, int r2) {
        super(r1, r2);
    }
}
