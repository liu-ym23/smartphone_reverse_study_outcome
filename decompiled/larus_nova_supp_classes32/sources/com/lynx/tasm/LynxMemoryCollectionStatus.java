package com.lynx.tasm;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
public final enum LynxMemoryCollectionStatus extends Enum<LynxMemoryCollectionStatus> {
    public static final LynxMemoryCollectionStatus COMPLETED = null;
    public static final LynxMemoryCollectionStatus TIMEOUT = null;
    public static final /* synthetic */ LynxMemoryCollectionStatus[] a = null;

    static {
        LynxMemoryCollectionStatus r0 = new LynxMemoryCollectionStatus("COMPLETED", 0);
        COMPLETED = r0;
        LynxMemoryCollectionStatus r1 = new LynxMemoryCollectionStatus("TIMEOUT", 1);
        TIMEOUT = r1;
        a = new LynxMemoryCollectionStatus[]{r0, r1};
    }

    public static LynxMemoryCollectionStatus[] values() {
        return (LynxMemoryCollectionStatus[]) a.clone();
    }

    public static LynxMemoryCollectionStatus valueOf(String r1) {
        return (LynxMemoryCollectionStatus) r27.a.a(LynxMemoryCollectionStatus.class, r1);
    }

    public LynxMemoryCollectionStatus(String r1, int r2) {
        super(r1, r2);
    }
}
