package org.apache.commons.compress.compressors.snappy;

import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: loaded from: classes6.dex */
public final enum FramedSnappyDialect extends Enum<FramedSnappyDialect> {
    private static final /* synthetic */ FramedSnappyDialect[] $VALUES = null;
    public static final FramedSnappyDialect IWORK_ARCHIVE = null;
    public static final FramedSnappyDialect STANDARD = null;
    private final boolean checksumWithCompressedChunks;
    private final boolean streamIdentifier;

    static {
        FramedSnappyDialect r0 = new FramedSnappyDialect("STANDARD", 0, true, true);
        STANDARD = r0;
        FramedSnappyDialect r1 = new FramedSnappyDialect("IWORK_ARCHIVE", 1, false, false);
        IWORK_ARCHIVE = r1;
        $VALUES = new FramedSnappyDialect[]{r0, r1};
    }

    private FramedSnappyDialect(String r1, int r2, boolean r3, boolean r4) {
        super(r1, r2);
        this.streamIdentifier = r3;
        this.checksumWithCompressedChunks = r4;
    }

    public static FramedSnappyDialect valueOf(String r2) {
        return (FramedSnappyDialect) ZeusTransformUtils.preCheckCast(Enum.valueOf(FramedSnappyDialect.class, r2), FramedSnappyDialect.class, "com.obric.memorydata.plugin");
    }

    public static FramedSnappyDialect[] values() {
        return (FramedSnappyDialect[]) ZeusTransformUtils.preCheckCast($VALUES.clone(), FramedSnappyDialect[].class, "com.obric.memorydata.plugin");
    }

    boolean hasStreamIdentifier() {
        return this.streamIdentifier;
    }

    boolean usesChecksumWithCompressedChunks() {
        return this.checksumWithCompressedChunks;
    }
}
