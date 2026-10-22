package com.ss.android.socialbase.downloader.constants;

/* JADX INFO: loaded from: classes2.dex */
public final enum EnqueueType extends Enum<EnqueueType> {
    private static final /* synthetic */ EnqueueType[] $VALUES = null;
    public static final EnqueueType ENQUEUE_HEAD = null;
    public static final EnqueueType ENQUEUE_NONE = null;
    public static final EnqueueType ENQUEUE_TAIL = null;
    public static final EnqueueType NEW_ENQUEUE_IMMEDIATE = null;
    public static final EnqueueType NEW_ENQUEUE_NORMAL = null;

    static {
        EnqueueType r10 = new EnqueueType("ENQUEUE_NONE", 0);
        ENQUEUE_NONE = r10;
        EnqueueType r11 = new EnqueueType("ENQUEUE_HEAD", 1);
        ENQUEUE_HEAD = r11;
        EnqueueType r12 = new EnqueueType("ENQUEUE_TAIL", 2);
        ENQUEUE_TAIL = r12;
        EnqueueType r13 = new EnqueueType("NEW_ENQUEUE_NORMAL", 3);
        NEW_ENQUEUE_NORMAL = r13;
        EnqueueType r14 = new EnqueueType("NEW_ENQUEUE_IMMEDIATE", 4);
        NEW_ENQUEUE_IMMEDIATE = r14;
        $VALUES = new EnqueueType[]{r10, r11, r12, r13, r14};
    }

    private EnqueueType(String r10, int r11) {
        super(r10, r11);
    }

    public static EnqueueType valueOf(String r10) {
        return (EnqueueType) Enum.valueOf(EnqueueType.class, r10);
    }

    public static EnqueueType[] values() {
        return (EnqueueType[]) $VALUES.clone();
    }
}
