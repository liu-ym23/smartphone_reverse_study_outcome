package org.apache.poi.poifs.crypt;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.function.Supplier;

/* JADX INFO: loaded from: classes7.dex */
public final enum EncryptionMode extends Enum<EncryptionMode> {
    private static final /* synthetic */ EncryptionMode[] $VALUES = null;
    public static final EncryptionMode agile = null;
    public static final EncryptionMode binaryRC4 = null;
    public static final EncryptionMode cryptoAPI = null;
    public static final EncryptionMode standard = null;
    public static final EncryptionMode xor = null;
    public final Supplier<EncryptionInfoBuilder> builder;
    public final int encryptionFlags;
    public final int versionMajor;
    public final int versionMinor;

    static {
        EncryptionMode r7 = new EncryptionMode("binaryRC4", 0, $$Lambda$CmtmbKY8Iue277jr8CWVoCRwZrQ.INSTANCE, 1, 1, 0);
        binaryRC4 = r7;
        EncryptionMode r0 = new EncryptionMode("cryptoAPI", 1, $$Lambda$sFFnThhcBsQC1e0O0lLI1xgt1Og.INSTANCE, 4, 2, 4);
        cryptoAPI = r0;
        EncryptionMode r1 = new EncryptionMode("standard", 2, $$Lambda$VMHM25q4LYBf8qaXGeK3gRp8HPI.INSTANCE, 4, 2, 36);
        standard = r1;
        EncryptionMode r2 = new EncryptionMode("agile", 3, $$Lambda$hVcQ6ZS3pAoOSNwOwG95U9PQWtk.INSTANCE, 4, 4, 64);
        agile = r2;
        EncryptionMode r3 = new EncryptionMode("xor", 4, $$Lambda$zmVDubEM41Kp54RwFIOCQQPHJk.INSTANCE, 0, 0, 0);
        xor = r3;
        $VALUES = new EncryptionMode[]{r7, r0, r1, r2, r3};
    }

    private EncryptionMode(String r3, int r4, Supplier r5, int r6, int r7, int r8) {
        Supplier<EncryptionInfoBuilder> r9 = (Supplier) ZeusTransformUtils.wrapperContextForParams(r5, Supplier.class, "com.obric.memorydata.plugin");
        super(r3, r4);
        this.builder = r9;
        this.versionMajor = r6;
        this.versionMinor = r7;
        this.encryptionFlags = r8;
    }

    public static EncryptionMode valueOf(String r2) {
        return (EncryptionMode) ZeusTransformUtils.preCheckCast(Enum.valueOf(EncryptionMode.class, r2), EncryptionMode.class, "com.obric.memorydata.plugin");
    }

    public static EncryptionMode[] values() {
        return (EncryptionMode[]) ZeusTransformUtils.preCheckCast($VALUES.clone(), EncryptionMode[].class, "com.obric.memorydata.plugin");
    }
}
