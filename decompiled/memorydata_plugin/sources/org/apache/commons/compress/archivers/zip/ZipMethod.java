package org.apache.commons.compress.archivers.zip;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: classes6.dex */
public final enum ZipMethod extends Enum<ZipMethod> {
    private static final /* synthetic */ ZipMethod[] $VALUES = null;
    public static final ZipMethod AES_ENCRYPTED = null;
    public static final ZipMethod BZIP2 = null;
    public static final ZipMethod DEFLATED = null;
    public static final ZipMethod ENHANCED_DEFLATED = null;
    public static final ZipMethod EXPANDING_LEVEL_1 = null;
    public static final ZipMethod EXPANDING_LEVEL_2 = null;
    public static final ZipMethod EXPANDING_LEVEL_3 = null;
    public static final ZipMethod EXPANDING_LEVEL_4 = null;
    public static final ZipMethod IMPLODING = null;
    public static final ZipMethod JPEG = null;
    public static final ZipMethod LZMA = null;
    public static final ZipMethod PKWARE_IMPLODING = null;
    public static final ZipMethod PPMD = null;
    public static final ZipMethod STORED = null;
    public static final ZipMethod TOKENIZATION = null;
    public static final ZipMethod UNKNOWN = null;
    static final int UNKNOWN_CODE = -1;
    public static final ZipMethod UNSHRINKING = null;
    public static final ZipMethod WAVPACK = null;
    public static final ZipMethod XZ = null;
    private static final Map<Integer, ZipMethod> codeToEnum = null;
    private final int code;

    static {
        ZipMethod r0 = new ZipMethod("STORED", 0, 0);
        STORED = r0;
        ZipMethod r1 = new ZipMethod("UNSHRINKING", 1, 1);
        UNSHRINKING = r1;
        ZipMethod r3 = new ZipMethod("EXPANDING_LEVEL_1", 2, 2);
        EXPANDING_LEVEL_1 = r3;
        ZipMethod r5 = new ZipMethod("EXPANDING_LEVEL_2", 3, 3);
        EXPANDING_LEVEL_2 = r5;
        ZipMethod r7 = new ZipMethod("EXPANDING_LEVEL_3", 4, 4);
        EXPANDING_LEVEL_3 = r7;
        ZipMethod r9 = new ZipMethod("EXPANDING_LEVEL_4", 5, 5);
        EXPANDING_LEVEL_4 = r9;
        ZipMethod r11 = new ZipMethod("IMPLODING", 6, 6);
        IMPLODING = r11;
        ZipMethod r13 = new ZipMethod("TOKENIZATION", 7, 7);
        TOKENIZATION = r13;
        ZipMethod r15 = new ZipMethod("DEFLATED", 8, 8);
        DEFLATED = r15;
        ZipMethod r14 = new ZipMethod("ENHANCED_DEFLATED", 9, 9);
        ENHANCED_DEFLATED = r14;
        ZipMethod r12 = new ZipMethod("PKWARE_IMPLODING", 10, 10);
        PKWARE_IMPLODING = r12;
        ZipMethod r10 = new ZipMethod("BZIP2", 11, 12);
        BZIP2 = r10;
        ZipMethod r8 = new ZipMethod("LZMA", 12, 14);
        LZMA = r8;
        ZipMethod r6 = new ZipMethod("XZ", 13, 95);
        XZ = r6;
        ZipMethod r4 = new ZipMethod("JPEG", 14, 96);
        JPEG = r4;
        ZipMethod r2 = new ZipMethod("WAVPACK", 15, 97);
        WAVPACK = r2;
        ZipMethod r16 = new ZipMethod("PPMD", 16, 98);
        PPMD = r16;
        ZipMethod r17 = new ZipMethod("AES_ENCRYPTED", 17, 99);
        AES_ENCRYPTED = r17;
        ZipMethod r18 = new ZipMethod("UNKNOWN", 18);
        UNKNOWN = r18;
        $VALUES = new ZipMethod[]{r0, r1, r3, r5, r7, r9, r11, r13, r15, r14, r12, r10, r8, r6, r4, r2, r16, r17, r18};
        HashMap r19 = new HashMap();
        ZipMethod[] r20 = values();
        int r21 = r20.length;
        int r22 = 0;
    L3:
        if (r22 >= r21) goto L5;
        ZipMethod r23 = r20[r22];
        r19.put(Integer.valueOf(r23.getCode()), r23);
        r22 = r22 + 1;
        goto L3
    L5:
        codeToEnum = Collections.unmodifiableMap(r19);
    }

    private ZipMethod(String r2, int r3) {
        this(r2, r3, -1);
    }

    private ZipMethod(String r1, int r2, int r3) {
        super(r1, r2);
        this.code = r3;
    }

    public static ZipMethod getMethodByCode(int r2) {
        return (ZipMethod) ZeusTransformUtils.preCheckCast(codeToEnum.get(Integer.valueOf(r2)), ZipMethod.class, "com.obric.memorydata.plugin");
    }

    public static ZipMethod valueOf(String r2) {
        return (ZipMethod) ZeusTransformUtils.preCheckCast(Enum.valueOf(ZipMethod.class, r2), ZipMethod.class, "com.obric.memorydata.plugin");
    }

    public static ZipMethod[] values() {
        return (ZipMethod[]) ZeusTransformUtils.preCheckCast($VALUES.clone(), ZipMethod[].class, "com.obric.memorydata.plugin");
    }

    public int getCode() {
        return this.code;
    }
}
