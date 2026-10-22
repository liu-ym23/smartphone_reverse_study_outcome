package com.obric.common.oea.foundation.animation.constants;

import kotlin.Metadata;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0006\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006¨\u0006\u0007"}, d2 = {"Lcom/obric/common/oea/foundation/animation/constants/RepeatMode;", "", "<init>", "(Ljava/lang/String;I)V", "NORMAL", "LOOP", "REVERSE", "foundation_standardRelease"}, k = 1, mv = {1, 4, 3})
public final enum RepeatMode extends Enum<RepeatMode> {
    private static final /* synthetic */ RepeatMode[] $VALUES = null;
    public static final RepeatMode LOOP = null;
    public static final RepeatMode NORMAL = null;
    public static final RepeatMode REVERSE = null;

    static {
        RepeatMode r10 = new RepeatMode("NORMAL", 0);
        NORMAL = r10;
        RepeatMode r11 = new RepeatMode("LOOP", 1);
        LOOP = r11;
        RepeatMode r12 = new RepeatMode("REVERSE", 2);
        REVERSE = r12;
        $VALUES = new RepeatMode[]{r10, r11, r12};
    }

    private RepeatMode(String r10, int r11) {
        super(r10, r11);
    }

    public static RepeatMode valueOf(String r10) {
        return (RepeatMode) Enum.valueOf(RepeatMode.class, r10);
    }

    public static RepeatMode[] values() {
        return (RepeatMode[]) $VALUES.clone();
    }
}
