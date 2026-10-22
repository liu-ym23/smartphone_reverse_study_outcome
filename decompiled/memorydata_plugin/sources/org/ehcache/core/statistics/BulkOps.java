package org.ehcache.core.statistics;

import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: loaded from: classes7.dex */
public final enum BulkOps extends Enum<BulkOps> {
    private static final /* synthetic */ BulkOps[] $VALUES = null;
    public static final BulkOps GET_ALL_HITS = null;
    public static final BulkOps GET_ALL_MISS = null;
    public static final BulkOps PUT_ALL = null;
    public static final BulkOps REMOVE_ALL = null;
    public static final BulkOps UPDATE_ALL = null;

    static {
        BulkOps r0 = new BulkOps("GET_ALL_HITS", 0);
        GET_ALL_HITS = r0;
        BulkOps r1 = new BulkOps("GET_ALL_MISS", 1);
        GET_ALL_MISS = r1;
        BulkOps r3 = new BulkOps("PUT_ALL", 2);
        PUT_ALL = r3;
        BulkOps r5 = new BulkOps("REMOVE_ALL", 3);
        REMOVE_ALL = r5;
        BulkOps r7 = new BulkOps("UPDATE_ALL", 4);
        UPDATE_ALL = r7;
        $VALUES = new BulkOps[]{r0, r1, r3, r5, r7};
    }

    private BulkOps(String r1, int r2) {
        super(r1, r2);
    }

    public static BulkOps valueOf(String r2) {
        return (BulkOps) ZeusTransformUtils.preCheckCast(Enum.valueOf(BulkOps.class, r2), BulkOps.class, "com.obric.memorydata.plugin");
    }

    public static BulkOps[] values() {
        return (BulkOps[]) ZeusTransformUtils.preCheckCast($VALUES.clone(), BulkOps[].class, "com.obric.memorydata.plugin");
    }
}
