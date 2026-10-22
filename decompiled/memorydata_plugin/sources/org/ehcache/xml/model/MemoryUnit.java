package org.ehcache.xml.model;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;

/* JADX INFO: loaded from: classes7.dex */
@XmlEnum
@XmlType(name = "memory-unit")
public final enum MemoryUnit extends Enum<MemoryUnit> {
    private static final /* synthetic */ MemoryUnit[] $VALUES = null;
    public static final MemoryUnit B = null;
    public static final MemoryUnit GB = null;

    @XmlEnumValue("kB")
    public static final MemoryUnit K_B = null;
    public static final MemoryUnit MB = null;
    public static final MemoryUnit PB = null;
    public static final MemoryUnit TB = null;
    private final String value;

    static {
        MemoryUnit r0 = new MemoryUnit("B", 0, "B");
        B = r0;
        MemoryUnit r1 = new MemoryUnit("K_B", 1, "kB");
        K_B = r1;
        MemoryUnit r3 = new MemoryUnit("MB", 2, "MB");
        MB = r3;
        MemoryUnit r5 = new MemoryUnit("GB", 3, "GB");
        GB = r5;
        MemoryUnit r7 = new MemoryUnit("TB", 4, "TB");
        TB = r7;
        MemoryUnit r9 = new MemoryUnit("PB", 5, "PB");
        PB = r9;
        $VALUES = new MemoryUnit[]{r0, r1, r3, r5, r7, r9};
    }

    private MemoryUnit(String r1, int r2, String r3) {
        super(r1, r2);
        this.value = r3;
    }

    public static MemoryUnit fromValue(String r5) {
        MemoryUnit[] r0 = values();
        int r1 = r0.length;
        int r2 = 0;
    L3:
        if (r2 >= r1) goto L9;
        MemoryUnit r3 = r0[r2];
        if (r3.value.equals(r5) == true) goto L6;
        r2 = r2 + 1;
        goto L3
    L6:
        return r3;
    L9:
        throw new IllegalArgumentException(r5);
    }

    public static MemoryUnit valueOf(String r2) {
        return (MemoryUnit) ZeusTransformUtils.preCheckCast(Enum.valueOf(MemoryUnit.class, r2), MemoryUnit.class, "com.obric.memorydata.plugin");
    }

    public static MemoryUnit[] values() {
        return (MemoryUnit[]) ZeusTransformUtils.preCheckCast($VALUES.clone(), MemoryUnit[].class, "com.obric.memorydata.plugin");
    }

    public String value() {
        return this.value;
    }
}
