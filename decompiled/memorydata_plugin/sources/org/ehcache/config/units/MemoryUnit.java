package org.ehcache.config.units;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import org.ehcache.config.j;

/* JADX INFO: loaded from: classes7.dex */
public final enum MemoryUnit extends Enum<MemoryUnit> implements j {
    private static final /* synthetic */ MemoryUnit[] $VALUES = null;
    public static final MemoryUnit B = null;
    public static final MemoryUnit GB = null;
    public static final MemoryUnit KB = null;
    public static final MemoryUnit MB = null;
    public static final MemoryUnit PB = null;
    public static final MemoryUnit TB = null;
    private final int index;
    private final String stringForm;

    static {
        MemoryUnit r0 = new MemoryUnit("B", 0, "B", 0);
        B = r0;
        MemoryUnit r1 = new MemoryUnit("KB", 1, "kB", 10);
        KB = r1;
        MemoryUnit r3 = new MemoryUnit("MB", 2, "MB", 20);
        MB = r3;
        MemoryUnit r5 = new MemoryUnit("GB", 3, "GB", 30);
        GB = r5;
        MemoryUnit r7 = new MemoryUnit("TB", 4, "TB", 40);
        TB = r7;
        MemoryUnit r9 = new MemoryUnit("PB", 5, "PB", 50);
        PB = r9;
        $VALUES = new MemoryUnit[]{r0, r1, r3, r5, r7, r9};
    }

    private MemoryUnit(String r1, int r2, String r3, int r4) {
        super(r1, r2);
        this.stringForm = r3;
        this.index = r4;
    }

    private static long doConvert(int r3, long r4) {
        if (r3 != 0) goto L4;
    L18:
        return r4;
    L4:
        if (r4 == 0) goto L18;
        if (r3 >= 0) goto L9;
        int r0 = -r3;
        return (((r4 >> (r0 - 1)) >>> (r3 + 64)) + r4) >> r0;
    L9:
        if (r4 >= 0) goto L11;
        long r1 = ~r4;
    L13:
        if (r3 >= Long.numberOfLeadingZeros(r1)) goto L17;
        return r4 << r3;
    L17:
        throw new ArithmeticException("Conversion overflows");
    L11:
        r1 = r4;
        goto L13
    }

    public static MemoryUnit valueOf(String r2) {
        return (MemoryUnit) ZeusTransformUtils.preCheckCast(Enum.valueOf(MemoryUnit.class, r2), MemoryUnit.class, "com.obric.memorydata.plugin");
    }

    public static MemoryUnit[] values() {
        return (MemoryUnit[]) ZeusTransformUtils.preCheckCast($VALUES.clone(), MemoryUnit[].class, "com.obric.memorydata.plugin");
    }

    @Override // org.ehcache.config.j
    public int compareTo(long r4, long r6, j r8) {
        j r9 = (j) ZeusTransformUtils.wrapperContextForParams(r8, j.class, "com.obric.memorydata.plugin");
        if (ZeusTransformUtils.instanceOf(r9, MemoryUnit.class) == false) goto L15;
        MemoryUnit r10 = (MemoryUnit) ZeusTransformUtils.preCheckCast(r9, MemoryUnit.class, "com.obric.memorydata.plugin");
        if (this.index >= r10.index) goto L18;
        return Long.signum(r4 - convert(r6, r10));
    L9:
        return Long.signum(r10.convert(r4, this) - r6);
    L18:
        return Long.signum(r10.convert(r4, this) - r6);
    L13:
        return Long.signum(r4 - convert(r6, r10));
    L15:
        throw new IllegalArgumentException();
    }

    public long convert(long r1, MemoryUnit r3) {
        return doConvert(r3.index - this.index, r1);
    }

    public long toBytes(long r2) {
        return doConvert(this.index - B.index, r2);
    }

    @Override // java.lang.Enum
    public String toString() {
        return this.stringForm;
    }
}
