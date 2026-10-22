package com.obric.common.oea.foundation.animation.constants;

import kotlin.Metadata;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0005\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005¨\u0006\u0006"}, d2 = {"Lcom/obric/common/oea/foundation/animation/constants/RunMode;", "", "<init>", "(Ljava/lang/String;I)V", "PARALLEL", "SERIAL", "foundation_standardRelease"}, k = 1, mv = {1, 4, 3})
public final enum RunMode extends Enum<RunMode> {
    private static final /* synthetic */ RunMode[] $VALUES = null;
    public static final RunMode PARALLEL = null;
    public static final RunMode SERIAL = null;

    static {
        RunMode r10 = new RunMode("PARALLEL", 0);
        PARALLEL = r10;
        RunMode r11 = new RunMode("SERIAL", 1);
        SERIAL = r11;
        $VALUES = new RunMode[]{r10, r11};
    }

    private RunMode(String r10, int r11) {
        super(r10, r11);
    }

    public static RunMode valueOf(String r10) {
        return (RunMode) Enum.valueOf(RunMode.class, r10);
    }

    public static RunMode[] values() {
        return (RunMode[]) $VALUES.clone();
    }
}
