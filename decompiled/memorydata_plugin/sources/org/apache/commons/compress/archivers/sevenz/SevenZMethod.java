package org.apache.commons.compress.archivers.sevenz;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.Arrays;

/* JADX INFO: loaded from: classes6.dex */
public final enum SevenZMethod extends Enum<SevenZMethod> {
    private static final /* synthetic */ SevenZMethod[] $VALUES = null;
    public static final SevenZMethod AES256SHA256 = null;
    public static final SevenZMethod BCJ_ARM_FILTER = null;
    public static final SevenZMethod BCJ_ARM_THUMB_FILTER = null;
    public static final SevenZMethod BCJ_IA64_FILTER = null;
    public static final SevenZMethod BCJ_PPC_FILTER = null;
    public static final SevenZMethod BCJ_SPARC_FILTER = null;
    public static final SevenZMethod BCJ_X86_FILTER = null;
    public static final SevenZMethod BZIP2 = null;
    public static final SevenZMethod COPY = null;
    public static final SevenZMethod DEFLATE = null;
    public static final SevenZMethod DEFLATE64 = null;
    public static final SevenZMethod DELTA_FILTER = null;
    public static final SevenZMethod LZMA = null;
    public static final SevenZMethod LZMA2 = null;
    private final byte[] id;

    static {
        SevenZMethod r0 = new SevenZMethod("COPY", 0, new byte[]{0});
        COPY = r0;
        SevenZMethod r2 = new SevenZMethod("LZMA", 1, new byte[]{3, 1, 1});
        LZMA = r2;
        SevenZMethod r5 = new SevenZMethod("LZMA2", 2, new byte[]{33});
        LZMA2 = r5;
        SevenZMethod r6 = new SevenZMethod("DEFLATE", 3, new byte[]{4, 1, 8});
        DEFLATE = r6;
        SevenZMethod r7 = new SevenZMethod("DEFLATE64", 4, new byte[]{4, 1, 9});
        DEFLATE64 = r7;
        SevenZMethod r9 = new SevenZMethod("BZIP2", 5, new byte[]{4, 2, 2});
        BZIP2 = r9;
        SevenZMethod r10 = new SevenZMethod("AES256SHA256", 6, new byte[]{6, -15, 7, 1});
        AES256SHA256 = r10;
        SevenZMethod r12 = new SevenZMethod("BCJ_X86_FILTER", 7, new byte[]{3, 3, 1, 3});
        BCJ_X86_FILTER = r12;
        SevenZMethod r14 = new SevenZMethod("BCJ_PPC_FILTER", 8, new byte[]{3, 3, 2, 5});
        BCJ_PPC_FILTER = r14;
        SevenZMethod r13 = new SevenZMethod("BCJ_IA64_FILTER", 9, new byte[]{3, 3, 4, 1});
        BCJ_IA64_FILTER = r13;
        SevenZMethod r8 = new SevenZMethod("BCJ_ARM_FILTER", 10, new byte[]{3, 3, 5, 1});
        BCJ_ARM_FILTER = r8;
        SevenZMethod r3 = new SevenZMethod("BCJ_ARM_THUMB_FILTER", 11, new byte[]{3, 3, 7, 1});
        BCJ_ARM_THUMB_FILTER = r3;
        SevenZMethod r4 = new SevenZMethod("BCJ_SPARC_FILTER", 12, new byte[]{3, 3, 8, 5});
        BCJ_SPARC_FILTER = r4;
        SevenZMethod r1 = new SevenZMethod("DELTA_FILTER", 13, new byte[]{3});
        DELTA_FILTER = r1;
        $VALUES = new SevenZMethod[]{r0, r2, r5, r6, r7, r9, r10, r12, r14, r13, r8, r3, r4, r1};
    }

    private SevenZMethod(String r1, int r2, byte[] r3) {
        super(r1, r2);
        this.id = r3;
    }

    static SevenZMethod byId(byte[] r5) {
        SevenZMethod[] r0 = (SevenZMethod[]) ZeusTransformUtils.preCheckCast(SevenZMethod.class.getEnumConstants(), SevenZMethod[].class, "com.obric.memorydata.plugin");
        int r1 = r0.length;
        int r2 = 0;
    L3:
        if (r2 >= r1) goto L8;
        SevenZMethod r3 = r0[r2];
        if (Arrays.equals(r3.id, r5) == true) goto L6;
        r2 = r2 + 1;
        goto L3
    L6:
        return r3;
    L8:
        return null;
    }

    public static SevenZMethod valueOf(String r2) {
        return (SevenZMethod) ZeusTransformUtils.preCheckCast(Enum.valueOf(SevenZMethod.class, r2), SevenZMethod.class, "com.obric.memorydata.plugin");
    }

    public static SevenZMethod[] values() {
        return (SevenZMethod[]) ZeusTransformUtils.preCheckCast($VALUES.clone(), SevenZMethod[].class, "com.obric.memorydata.plugin");
    }

    byte[] getId() {
        byte[] r3 = this.id;
        int r0 = r3.length;
        byte[] r1 = new byte[r0];
        System.arraycopy(r3, 0, r1, 0, r0);
        return r1;
    }
}
