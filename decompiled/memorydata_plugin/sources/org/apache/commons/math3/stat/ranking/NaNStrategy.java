package org.apache.commons.math3.stat.ranking;

import com.obric.memorydata.database.entity.RawObservationEntity;
import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: loaded from: classes6.dex */
public final enum NaNStrategy extends Enum<NaNStrategy> {
    private static final /* synthetic */ NaNStrategy[] $VALUES = null;
    public static final NaNStrategy FAILED = null;
    public static final NaNStrategy FIXED = null;
    public static final NaNStrategy MAXIMAL = null;
    public static final NaNStrategy MINIMAL = null;
    public static final NaNStrategy REMOVED = null;

    static {
        NaNStrategy r0 = new NaNStrategy("MINIMAL", 0);
        MINIMAL = r0;
        NaNStrategy r1 = new NaNStrategy("MAXIMAL", 1);
        MAXIMAL = r1;
        NaNStrategy r3 = new NaNStrategy("REMOVED", 2);
        REMOVED = r3;
        NaNStrategy r5 = new NaNStrategy("FIXED", 3);
        FIXED = r5;
        NaNStrategy r7 = new NaNStrategy(RawObservationEntity.STATE_FAILED, 4);
        FAILED = r7;
        $VALUES = new NaNStrategy[]{r0, r1, r3, r5, r7};
    }

    private NaNStrategy(String r1, int r2) {
        super(r1, r2);
    }

    public static NaNStrategy valueOf(String r2) {
        return (NaNStrategy) ZeusTransformUtils.preCheckCast(Enum.valueOf(NaNStrategy.class, r2), NaNStrategy.class, "com.obric.memorydata.plugin");
    }

    public static NaNStrategy[] values() {
        return (NaNStrategy[]) ZeusTransformUtils.preCheckCast($VALUES.clone(), NaNStrategy[].class, "com.obric.memorydata.plugin");
    }
}
