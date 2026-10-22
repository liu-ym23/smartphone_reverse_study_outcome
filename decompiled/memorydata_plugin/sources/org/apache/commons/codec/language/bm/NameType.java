package org.apache.commons.codec.language.bm;

import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: loaded from: classes6.dex */
public final enum NameType extends Enum<NameType> {
    private static final /* synthetic */ NameType[] $VALUES = null;
    public static final NameType ASHKENAZI = null;
    public static final NameType GENERIC = null;
    public static final NameType SEPHARDIC = null;
    private final String name;

    static {
        NameType r0 = new NameType("ASHKENAZI", 0, "ash");
        ASHKENAZI = r0;
        NameType r1 = new NameType("GENERIC", 1, "gen");
        GENERIC = r1;
        NameType r3 = new NameType("SEPHARDIC", 2, "sep");
        SEPHARDIC = r3;
        $VALUES = new NameType[]{r0, r1, r3};
    }

    private NameType(String r1, int r2, String r3) {
        super(r1, r2);
        this.name = r3;
    }

    public static NameType valueOf(String r2) {
        return (NameType) ZeusTransformUtils.preCheckCast(Enum.valueOf(NameType.class, r2), NameType.class, "com.obric.memorydata.plugin");
    }

    public static NameType[] values() {
        return (NameType[]) ZeusTransformUtils.preCheckCast($VALUES.clone(), NameType[].class, "com.obric.memorydata.plugin");
    }

    public String getName() {
        return this.name;
    }
}
