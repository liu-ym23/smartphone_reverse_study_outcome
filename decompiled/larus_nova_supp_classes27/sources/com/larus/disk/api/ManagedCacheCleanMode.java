package com.larus.disk.api;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import r27.a;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0005\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005¨\u0006\u0006"}, d2 = {"Lcom/larus/disk/api/ManagedCacheCleanMode;", "", "<init>", "(Ljava/lang/String;I)V", "MANUAL_ONLY", "EXPIRED_FILES", "api_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum ManagedCacheCleanMode extends Enum<ManagedCacheCleanMode> {
    public static final ManagedCacheCleanMode EXPIRED_FILES = null;
    public static final ManagedCacheCleanMode MANUAL_ONLY = null;
    public static final /* synthetic */ ManagedCacheCleanMode[] a = null;
    public static final /* synthetic */ EnumEntries b = null;

    public static EnumEntries<ManagedCacheCleanMode> getEntries() {
        return b;
    }

    static {
        ManagedCacheCleanMode r0 = new ManagedCacheCleanMode("MANUAL_ONLY", 0);
        MANUAL_ONLY = r0;
        ManagedCacheCleanMode r1 = new ManagedCacheCleanMode("EXPIRED_FILES", 1);
        EXPIRED_FILES = r1;
        ManagedCacheCleanMode[] r3 = {r0, r1};
        a = r3;
        b = EnumEntriesKt.enumEntries(r3);
    }

    public static ManagedCacheCleanMode[] values() {
        return (ManagedCacheCleanMode[]) a.clone();
    }

    public static ManagedCacheCleanMode valueOf(String r1) {
        return (ManagedCacheCleanMode) a.a(ManagedCacheCleanMode.class, r1);
    }

    public ManagedCacheCleanMode(String r1, int r2) {
        super(r1, r2);
    }
}
