package org.apache.commons.math3.ode.sampling;

import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: loaded from: classes6.dex */
public final enum StepNormalizerBounds extends Enum<StepNormalizerBounds> {
    private static final /* synthetic */ StepNormalizerBounds[] $VALUES = null;
    public static final StepNormalizerBounds BOTH = null;
    public static final StepNormalizerBounds FIRST = null;
    public static final StepNormalizerBounds LAST = null;
    public static final StepNormalizerBounds NEITHER = null;
    private final boolean first;
    private final boolean last;

    static {
        StepNormalizerBounds r0 = new StepNormalizerBounds("NEITHER", 0, false, false);
        NEITHER = r0;
        StepNormalizerBounds r1 = new StepNormalizerBounds("FIRST", 1, true, false);
        FIRST = r1;
        StepNormalizerBounds r3 = new StepNormalizerBounds("LAST", 2, false, true);
        LAST = r3;
        StepNormalizerBounds r5 = new StepNormalizerBounds("BOTH", 3, true, true);
        BOTH = r5;
        $VALUES = new StepNormalizerBounds[]{r0, r1, r3, r5};
    }

    private StepNormalizerBounds(String r1, int r2, boolean r3, boolean r4) {
        super(r1, r2);
        this.first = r3;
        this.last = r4;
    }

    public static StepNormalizerBounds valueOf(String r2) {
        return (StepNormalizerBounds) ZeusTransformUtils.preCheckCast(Enum.valueOf(StepNormalizerBounds.class, r2), StepNormalizerBounds.class, "com.obric.memorydata.plugin");
    }

    public static StepNormalizerBounds[] values() {
        return (StepNormalizerBounds[]) ZeusTransformUtils.preCheckCast($VALUES.clone(), StepNormalizerBounds[].class, "com.obric.memorydata.plugin");
    }

    public boolean firstIncluded() {
        return this.first;
    }

    public boolean lastIncluded() {
        return this.last;
    }
}
