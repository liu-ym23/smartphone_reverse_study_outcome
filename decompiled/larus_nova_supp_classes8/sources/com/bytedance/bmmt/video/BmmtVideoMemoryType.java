package com.bytedance.bmmt.video;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final enum BmmtVideoMemoryType extends Enum<BmmtVideoMemoryType> {
    private static final /* synthetic */ BmmtVideoMemoryType[] $VALUES = null;
    public static final BmmtVideoMemoryType kBYTE_MEMORY = null;
    public static final BmmtVideoMemoryType kOPENGL_TEXTURE = null;
    public static final BmmtVideoMemoryType kUNKNOWN = null;
    private int value;

    private static /* synthetic */ BmmtVideoMemoryType[] $values() {
        return new BmmtVideoMemoryType[]{kUNKNOWN, kBYTE_MEMORY, kOPENGL_TEXTURE};
    }

    static {
        kUNKNOWN = new BmmtVideoMemoryType("kUNKNOWN", 0, 0);
        kBYTE_MEMORY = new BmmtVideoMemoryType("kBYTE_MEMORY", 1, 1);
        kOPENGL_TEXTURE = new BmmtVideoMemoryType("kOPENGL_TEXTURE", 2, 3);
        $VALUES = $values();
    }

    public static BmmtVideoMemoryType[] values() {
        return (BmmtVideoMemoryType[]) $VALUES.clone();
    }

    public int value() {
        return this.value;
    }

    public static BmmtVideoMemoryType fromId(int r5) {
        BmmtVideoMemoryType[] r0 = values();
        int r1 = r0.length;
        int r2 = 0;
    L3:
        if (r2 >= r1) goto L8;
        BmmtVideoMemoryType r3 = r0[r2];
        if (r3.value() == r5) goto L6;
        r2 = r2 + 1;
        goto L3
    L6:
        return r3;
    L8:
        return null;
    }

    public static BmmtVideoMemoryType valueOf(String r1) {
        return (BmmtVideoMemoryType) r27.a.a(BmmtVideoMemoryType.class, r1);
    }

    private BmmtVideoMemoryType(String r1, int r2, int r3) {
        super(r1, r2);
        this.value = r3;
    }
}
