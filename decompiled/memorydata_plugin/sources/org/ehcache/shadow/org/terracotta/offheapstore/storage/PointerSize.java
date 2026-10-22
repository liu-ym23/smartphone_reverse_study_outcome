package org.ehcache.shadow.org.terracotta.offheapstore.storage;

import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: loaded from: classes7.dex */
public final enum PointerSize extends Enum<PointerSize> {
    private static final /* synthetic */ PointerSize[] $VALUES = null;
    public static final PointerSize INT = null;
    public static final PointerSize LONG = null;
    private final int size;

    static {
        PointerSize r0 = new PointerSize("INT", 0, 32);
        INT = r0;
        PointerSize r1 = new PointerSize("LONG", 1, 64);
        LONG = r1;
        $VALUES = new PointerSize[]{r0, r1};
    }

    private PointerSize(String r1, int r2, int r3) {
        super(r1, r2);
        this.size = r3;
    }

    public static PointerSize valueOf(String r2) {
        return (PointerSize) ZeusTransformUtils.preCheckCast(Enum.valueOf(PointerSize.class, r2), PointerSize.class, "com.obric.memorydata.plugin");
    }

    public static PointerSize[] values() {
        return (PointerSize[]) ZeusTransformUtils.preCheckCast($VALUES.clone(), PointerSize[].class, "com.obric.memorydata.plugin");
    }

    public int bitSize() {
        return this.size;
    }

    public int byteSize() {
        return this.size / 8;
    }
}
