package org.apache.poi.ss.usermodel;

import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: loaded from: classes7.dex */
public final enum ReadingOrder extends Enum<ReadingOrder> {
    private static final /* synthetic */ ReadingOrder[] $VALUES = null;
    public static final ReadingOrder CONTEXT = null;
    public static final ReadingOrder LEFT_TO_RIGHT = null;
    public static final ReadingOrder RIGHT_TO_LEFT = null;

    static {
        ReadingOrder r0 = new ReadingOrder("CONTEXT", 0);
        CONTEXT = r0;
        ReadingOrder r1 = new ReadingOrder("LEFT_TO_RIGHT", 1);
        LEFT_TO_RIGHT = r1;
        ReadingOrder r3 = new ReadingOrder("RIGHT_TO_LEFT", 2);
        RIGHT_TO_LEFT = r3;
        $VALUES = new ReadingOrder[]{r0, r1, r3};
    }

    private ReadingOrder(String r1, int r2) {
        super(r1, r2);
    }

    public static ReadingOrder forLong(long r3) {
        if (r3 < 0) goto L9;
        if (r3 >= values().length) goto L9;
        return values()[(int) r3];
    L9:
        throw new IllegalArgumentException("Invalid ReadingOrder code: " + r3);
    }

    public static ReadingOrder valueOf(String r2) {
        return (ReadingOrder) ZeusTransformUtils.preCheckCast(Enum.valueOf(ReadingOrder.class, r2), ReadingOrder.class, "com.obric.memorydata.plugin");
    }

    public static ReadingOrder[] values() {
        return (ReadingOrder[]) ZeusTransformUtils.preCheckCast($VALUES.clone(), ReadingOrder[].class, "com.obric.memorydata.plugin");
    }

    public short getCode() {
        return (short) ordinal();
    }
}
