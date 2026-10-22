package com.bytedance.android.livesdk.config;

import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\b\n\u0002\b\u000b\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\f¨\u0006\r"}, d2 = {"Lcom/bytedance/android/livesdk/config/AlignModeType;", "", "", "value", "I", "getValue", "()I", "LEFT_ALIGN", "HORIZONTAL_CENTER_ALIGN", "RIGHT_ALIGN", "TOP_ALIGN", "VERTICAL_CENTER_ALIGN", "BOTTOM_ALIGN", "infrastructure_saasRelease"}, k = 1, mv = {1, 4, 3})
public final enum AlignModeType extends Enum<AlignModeType> {
    public static final AlignModeType BOTTOM_ALIGN = null;
    public static final AlignModeType HORIZONTAL_CENTER_ALIGN = null;
    public static final AlignModeType LEFT_ALIGN = null;
    public static final AlignModeType RIGHT_ALIGN = null;
    public static final AlignModeType TOP_ALIGN = null;
    public static final AlignModeType VERTICAL_CENTER_ALIGN = null;
    public static final /* synthetic */ AlignModeType[] a = null;
    private final int value;

    static {
        AlignModeType r1 = new AlignModeType("LEFT_ALIGN", 0, 3);
        LEFT_ALIGN = r1;
        AlignModeType r2 = new AlignModeType("HORIZONTAL_CENTER_ALIGN", 1, 4);
        HORIZONTAL_CENTER_ALIGN = r2;
        AlignModeType r3 = new AlignModeType("RIGHT_ALIGN", 2, 5);
        RIGHT_ALIGN = r3;
        AlignModeType r4 = new AlignModeType("TOP_ALIGN", 3, 1);
        TOP_ALIGN = r4;
        AlignModeType r5 = new AlignModeType("VERTICAL_CENTER_ALIGN", 4, 4);
        VERTICAL_CENTER_ALIGN = r5;
        AlignModeType r6 = new AlignModeType("BOTTOM_ALIGN", 5, 7);
        BOTTOM_ALIGN = r6;
        a = new AlignModeType[]{r1, r2, r3, r4, r5, r6};
    }

    public static AlignModeType valueOf(String r1) {
        return (AlignModeType) r27.a.a(AlignModeType.class, r1);
    }

    public static AlignModeType[] values() {
        return (AlignModeType[]) a.clone();
    }

    public final int getValue() {
        return this.value;
    }

    public AlignModeType(String r1, int r2, int r3) {
        super(r1, r2);
        this.value = r3;
    }
}
