package org.ehcache.xml.model;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;

/* JADX INFO: loaded from: classes7.dex */
@XmlEnum
@XmlType(name = "resource-unit")
public final enum ResourceUnit extends Enum<ResourceUnit> {
    private static final /* synthetic */ ResourceUnit[] $VALUES = null;
    public static final ResourceUnit B = null;

    @XmlEnumValue("entries")
    public static final ResourceUnit ENTRIES = null;
    public static final ResourceUnit GB = null;

    @XmlEnumValue("kB")
    public static final ResourceUnit K_B = null;
    public static final ResourceUnit MB = null;
    public static final ResourceUnit PB = null;
    public static final ResourceUnit TB = null;
    private final String value;

    static {
        ResourceUnit r0 = new ResourceUnit("ENTRIES", 0, "entries");
        ENTRIES = r0;
        ResourceUnit r1 = new ResourceUnit("B", 1, "B");
        B = r1;
        ResourceUnit r3 = new ResourceUnit("K_B", 2, "kB");
        K_B = r3;
        ResourceUnit r5 = new ResourceUnit("MB", 3, "MB");
        MB = r5;
        ResourceUnit r7 = new ResourceUnit("GB", 4, "GB");
        GB = r7;
        ResourceUnit r9 = new ResourceUnit("TB", 5, "TB");
        TB = r9;
        ResourceUnit r11 = new ResourceUnit("PB", 6, "PB");
        PB = r11;
        $VALUES = new ResourceUnit[]{r0, r1, r3, r5, r7, r9, r11};
    }

    private ResourceUnit(String r1, int r2, String r3) {
        super(r1, r2);
        this.value = r3;
    }

    public static ResourceUnit fromValue(String r5) {
        ResourceUnit[] r0 = values();
        int r1 = r0.length;
        int r2 = 0;
    L3:
        if (r2 >= r1) goto L9;
        ResourceUnit r3 = r0[r2];
        if (r3.value.equals(r5) == true) goto L6;
        r2 = r2 + 1;
        goto L3
    L6:
        return r3;
    L9:
        throw new IllegalArgumentException(r5);
    }

    public static ResourceUnit valueOf(String r2) {
        return (ResourceUnit) ZeusTransformUtils.preCheckCast(Enum.valueOf(ResourceUnit.class, r2), ResourceUnit.class, "com.obric.memorydata.plugin");
    }

    public static ResourceUnit[] values() {
        return (ResourceUnit[]) ZeusTransformUtils.preCheckCast($VALUES.clone(), ResourceUnit[].class, "com.obric.memorydata.plugin");
    }

    public String value() {
        return this.value;
    }
}
