package org.apache.commons.compress.compressors.pack200;

import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: loaded from: classes6.dex */
public abstract enum Pack200Strategy extends Enum<Pack200Strategy> {
    private static final /* synthetic */ Pack200Strategy[] $VALUES = null;
    public static final Pack200Strategy IN_MEMORY = null;
    public static final Pack200Strategy TEMP_FILE = null;

    static {
        final String r1 = "IN_MEMORY";
        final int r2 = 0;
        Pack200Strategy r0 = new AnonymousClass1(r1, r2);
        IN_MEMORY = r0;
        final String r3 = "TEMP_FILE";
        final int r4 = 1;
        Pack200Strategy r5 = new AnonymousClass2(r3, r4);
        TEMP_FILE = r5;
        $VALUES = new Pack200Strategy[]{r0, r5};
    }

    private Pack200Strategy(String r1, int r2) {
        super(r1, r2);
    }

    /* synthetic */ Pack200Strategy(String r1, int r2, AnonymousClass1 r3) {
        this(r1, r2);
    }

    public static Pack200Strategy valueOf(String r2) {
        return (Pack200Strategy) ZeusTransformUtils.preCheckCast(Enum.valueOf(Pack200Strategy.class, r2), Pack200Strategy.class, "com.obric.memorydata.plugin");
    }

    public static Pack200Strategy[] values() {
        return (Pack200Strategy[]) ZeusTransformUtils.preCheckCast($VALUES.clone(), Pack200Strategy[].class, "com.obric.memorydata.plugin");
    }

    abstract StreamBridge newStreamBridge();
}
