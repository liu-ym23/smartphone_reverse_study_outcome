package com.ss.android.socialbase.downloader.constants;

/* JADX INFO: loaded from: classes3.dex */
public final enum EnqueueType extends Enum<EnqueueType> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final EnqueueType f15277a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final EnqueueType f15278b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final EnqueueType f15279c = null;
    public static final EnqueueType d = null;
    public static final EnqueueType e = null;
    public static final /* synthetic */ EnqueueType[] f = null;

    static {
        EnqueueType r5 = new EnqueueType("ENQUEUE_NONE", 0);
        f15277a = r5;
        EnqueueType r10 = new EnqueueType("ENQUEUE_HEAD", 1);
        f15278b = r10;
        EnqueueType r11 = new EnqueueType("ENQUEUE_TAIL", 2);
        f15279c = r11;
        EnqueueType r12 = new EnqueueType("NEW_ENQUEUE_NORMAL", 3);
        d = r12;
        EnqueueType r13 = new EnqueueType("NEW_ENQUEUE_IMMEDIATE", 4);
        e = r13;
        f = new EnqueueType[]{r5, r10, r11, r12, r13};
    }

    public EnqueueType(String r5, int r10) {
        super(r5, r10);
    }

    public static EnqueueType valueOf(String r5) {
        return (EnqueueType) Enum.valueOf(EnqueueType.class, r5);
    }

    public static EnqueueType[] values() {
        return (EnqueueType[]) f.clone();
    }
}
