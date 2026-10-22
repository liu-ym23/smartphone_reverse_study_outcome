package org.ehcache.sizeof.impl;

import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: loaded from: classes7.dex */
final enum PrimitiveType extends Enum<PrimitiveType> {
    private static final /* synthetic */ PrimitiveType[] $VALUES = null;
    public static final PrimitiveType BOOLEAN = null;
    public static final PrimitiveType BYTE = null;
    public static final PrimitiveType CHAR = null;
    public static final PrimitiveType DOUBLE = null;
    public static final PrimitiveType FLOAT = null;
    public static final PrimitiveType INT = null;
    public static final PrimitiveType LONG = null;
    public static final PrimitiveType SHORT = null;
    private final int size;
    private final Class<?> type;

    static {
        PrimitiveType r0 = new PrimitiveType("BOOLEAN", 0, Boolean.TYPE, 1);
        BOOLEAN = r0;
        PrimitiveType r1 = new PrimitiveType("BYTE", 1, Byte.TYPE, 1);
        BYTE = r1;
        PrimitiveType r2 = new PrimitiveType("CHAR", 2, Character.TYPE, 2);
        CHAR = r2;
        PrimitiveType r5 = new PrimitiveType("SHORT", 3, Short.TYPE, 2);
        SHORT = r5;
        PrimitiveType r6 = new PrimitiveType("INT", 4, Integer.TYPE, 4);
        INT = r6;
        PrimitiveType r8 = new PrimitiveType("FLOAT", 5, Float.TYPE, 4);
        FLOAT = r8;
        PrimitiveType r10 = new PrimitiveType("DOUBLE", 6, Double.TYPE, 8);
        DOUBLE = r10;
        PrimitiveType r12 = new PrimitiveType("LONG", 7, Long.TYPE, 8);
        LONG = r12;
        $VALUES = new PrimitiveType[]{r0, r1, r2, r5, r6, r8, r10, r12};
    }

    private PrimitiveType(String r1, int r2, Class r3, int r4) {
        super(r1, r2);
        this.type = r3;
        this.size = r4;
    }

    public static PrimitiveType forType(Class<?> r5) {
        PrimitiveType[] r0 = values();
        int r1 = r0.length;
        int r2 = 0;
    L3:
        if (r2 >= r1) goto L8;
        PrimitiveType r3 = r0[r2];
        if (r3.getType() == r5) goto L6;
        r2 = r2 + 1;
        goto L3
    L6:
        return r3;
    L8:
        return null;
    }

    public static long getArraySize() {
        return JvmInformation.CURRENT_JVM_INFORMATION.getObjectHeaderSize() + INT.getSize();
    }

    public static int getReferenceSize() {
        return JvmInformation.CURRENT_JVM_INFORMATION.getJavaPointerSize();
    }

    public static PrimitiveType valueOf(String r2) {
        return (PrimitiveType) ZeusTransformUtils.preCheckCast(Enum.valueOf(PrimitiveType.class, r2), PrimitiveType.class, "com.obric.memorydata.plugin");
    }

    public static PrimitiveType[] values() {
        return (PrimitiveType[]) ZeusTransformUtils.preCheckCast($VALUES.clone(), PrimitiveType[].class, "com.obric.memorydata.plugin");
    }

    public int getSize() {
        return this.size;
    }

    public Class<?> getType() {
        return this.type;
    }
}
