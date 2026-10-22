package org.apache.commons.math3.stat.ranking;

import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: loaded from: classes6.dex */
public final enum TiesStrategy extends Enum<TiesStrategy> {
    private static final /* synthetic */ TiesStrategy[] $VALUES = null;
    public static final TiesStrategy AVERAGE = null;
    public static final TiesStrategy MAXIMUM = null;
    public static final TiesStrategy MINIMUM = null;
    public static final TiesStrategy RANDOM = null;
    public static final TiesStrategy SEQUENTIAL = null;

    static {
        TiesStrategy r0 = new TiesStrategy("SEQUENTIAL", 0);
        SEQUENTIAL = r0;
        TiesStrategy r1 = new TiesStrategy("MINIMUM", 1);
        MINIMUM = r1;
        TiesStrategy r3 = new TiesStrategy("MAXIMUM", 2);
        MAXIMUM = r3;
        TiesStrategy r5 = new TiesStrategy("AVERAGE", 3);
        AVERAGE = r5;
        TiesStrategy r7 = new TiesStrategy("RANDOM", 4);
        RANDOM = r7;
        $VALUES = new TiesStrategy[]{r0, r1, r3, r5, r7};
    }

    private TiesStrategy(String r1, int r2) {
        super(r1, r2);
    }

    public static TiesStrategy valueOf(String r2) {
        return (TiesStrategy) ZeusTransformUtils.preCheckCast(Enum.valueOf(TiesStrategy.class, r2), TiesStrategy.class, "com.obric.memorydata.plugin");
    }

    public static TiesStrategy[] values() {
        return (TiesStrategy[]) ZeusTransformUtils.preCheckCast($VALUES.clone(), TiesStrategy[].class, "com.obric.memorydata.plugin");
    }
}
