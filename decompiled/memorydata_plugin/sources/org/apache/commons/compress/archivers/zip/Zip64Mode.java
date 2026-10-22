package org.apache.commons.compress.archivers.zip;

import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: loaded from: classes6.dex */
public final enum Zip64Mode extends Enum<Zip64Mode> {
    private static final /* synthetic */ Zip64Mode[] $VALUES = null;
    public static final Zip64Mode Always = null;
    public static final Zip64Mode AlwaysWithCompatibility = null;
    public static final Zip64Mode AsNeeded = null;
    public static final Zip64Mode Never = null;

    static {
        Zip64Mode r0 = new Zip64Mode("Always", 0);
        Always = r0;
        Zip64Mode r1 = new Zip64Mode("Never", 1);
        Never = r1;
        Zip64Mode r3 = new Zip64Mode("AsNeeded", 2);
        AsNeeded = r3;
        Zip64Mode r5 = new Zip64Mode("AlwaysWithCompatibility", 3);
        AlwaysWithCompatibility = r5;
        $VALUES = new Zip64Mode[]{r0, r1, r3, r5};
    }

    private Zip64Mode(String r1, int r2) {
        super(r1, r2);
    }

    public static Zip64Mode valueOf(String r2) {
        return (Zip64Mode) ZeusTransformUtils.preCheckCast(Enum.valueOf(Zip64Mode.class, r2), Zip64Mode.class, "com.obric.memorydata.plugin");
    }

    public static Zip64Mode[] values() {
        return (Zip64Mode[]) ZeusTransformUtils.preCheckCast($VALUES.clone(), Zip64Mode[].class, "com.obric.memorydata.plugin");
    }
}
