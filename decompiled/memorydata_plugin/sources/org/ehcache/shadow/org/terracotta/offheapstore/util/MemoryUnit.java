package org.ehcache.shadow.org.terracotta.offheapstore.util;

import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: loaded from: classes7.dex */
public final enum MemoryUnit extends Enum<MemoryUnit> {
    private static final /* synthetic */ MemoryUnit[] $VALUES = null;
    public static final MemoryUnit BITS = null;
    public static final MemoryUnit BYTES = null;
    public static final MemoryUnit GIGABYTES = null;
    public static final MemoryUnit KILOBYTES = null;
    public static final MemoryUnit MEGABYTES = null;
    public static final MemoryUnit NIBBLES = null;
    public static final MemoryUnit TERABYTES = null;
    private final int index;

    static {
        MemoryUnit r0 = new MemoryUnit("BITS", 0, -3);
        BITS = r0;
        MemoryUnit r1 = new MemoryUnit("NIBBLES", 1, -1);
        NIBBLES = r1;
        MemoryUnit r3 = new MemoryUnit("BYTES", 2, 0);
        BYTES = r3;
        MemoryUnit r5 = new MemoryUnit("KILOBYTES", 3, 10);
        KILOBYTES = r5;
        MemoryUnit r7 = new MemoryUnit("MEGABYTES", 4, 20);
        MEGABYTES = r7;
        MemoryUnit r9 = new MemoryUnit("GIGABYTES", 5, 30);
        GIGABYTES = r9;
        MemoryUnit r11 = new MemoryUnit("TERABYTES", 6, 40);
        TERABYTES = r11;
        $VALUES = new MemoryUnit[]{r0, r1, r3, r5, r7, r9, r11};
    }

    private MemoryUnit(String r1, int r2, int r3) {
        super(r1, r2);
        this.index = r3;
    }

    private static int doConvert(int r1, int r2) {
        if (r2 < 0) goto L15;
        if (r1 != 0) goto L5;
        return r2;
    L5:
        if (r1 >= 0) goto L9;
        return r2 >>> (-r1);
    L9:
        if (r1 < Integer.numberOfLeadingZeros(r2)) goto L13;
        return Integer.MAX_VALUE;
    L13:
        return r2 << r1;
    L15:
        throw new IllegalArgumentException();
    }

    private static long doConvert(int r2, long r3) {
        if (r3 < 0) goto L16;
        if (r2 != 0) goto L6;
        return r3;
    L6:
        if (r2 >= 0) goto L10;
        return r3 >>> (-r2);
    L10:
        if (r2 < Long.numberOfLeadingZeros(r3)) goto L14;
        return Long.MAX_VALUE;
    L14:
        return r3 << r2;
    L16:
        throw new IllegalArgumentException();
    }

    public static MemoryUnit valueOf(String r2) {
        return (MemoryUnit) ZeusTransformUtils.preCheckCast(Enum.valueOf(MemoryUnit.class, r2), MemoryUnit.class, "com.obric.memorydata.plugin");
    }

    public static MemoryUnit[] values() {
        return (MemoryUnit[]) ZeusTransformUtils.preCheckCast($VALUES.clone(), MemoryUnit[].class, "com.obric.memorydata.plugin");
    }

    public long convert(long r1, MemoryUnit r3) {
        return doConvert(r3.index - this.index, r1);
    }

    public int toBits(int r2) {
        return doConvert(this.index - BITS.index, r2);
    }

    public long toBits(long r2) {
        return doConvert(this.index - BITS.index, r2);
    }

    public int toBytes(int r2) {
        return doConvert(this.index - BYTES.index, r2);
    }

    public long toBytes(long r2) {
        return doConvert(this.index - BYTES.index, r2);
    }
}
