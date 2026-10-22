package com.google.common.cache;

import java.util.logging.Logger;

/* JADX INFO: loaded from: classes2.dex */
abstract enum LocalCache$EntryFactory extends Enum<LocalCache$EntryFactory> {
    static final int ACCESS_MASK = 1;
    public static final LocalCache$EntryFactory STRONG = null;
    public static final LocalCache$EntryFactory STRONG_ACCESS = null;
    public static final LocalCache$EntryFactory STRONG_ACCESS_WRITE = null;
    public static final LocalCache$EntryFactory STRONG_WRITE = null;
    public static final LocalCache$EntryFactory WEAK = null;
    public static final LocalCache$EntryFactory WEAK_ACCESS = null;
    public static final LocalCache$EntryFactory WEAK_ACCESS_WRITE = null;
    static final int WEAK_MASK = 4;
    public static final LocalCache$EntryFactory WEAK_WRITE = null;
    static final int WRITE_MASK = 2;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ LocalCache$EntryFactory[] f8680a = null;
    static final LocalCache$EntryFactory[] factories = null;

    static {
        final String r5 = "STRONG";
        final int r10 = 0;
        LocalCache$EntryFactory r11 = new AnonymousClass1(r5, r10);
        STRONG = r11;
        final String r12 = "STRONG_ACCESS";
        final int r13 = 1;
        LocalCache$EntryFactory r14 = new AnonymousClass2(r12, r13);
        STRONG_ACCESS = r14;
        final String r15 = "STRONG_WRITE";
        final int r16 = 2;
        LocalCache$EntryFactory r17 = new AnonymousClass3(r15, r16);
        STRONG_WRITE = r17;
        final String r18 = "STRONG_ACCESS_WRITE";
        final int r19 = 3;
        LocalCache$EntryFactory r20 = new AnonymousClass4(r18, r19);
        STRONG_ACCESS_WRITE = r20;
        final String r110 = "WEAK";
        final int r111 = 4;
        LocalCache$EntryFactory r21 = new AnonymousClass5(r110, r111);
        WEAK = r21;
        final String r112 = "WEAK_ACCESS";
        final int r113 = 5;
        LocalCache$EntryFactory r114 = new AnonymousClass6(r112, r113);
        WEAK_ACCESS = r114;
        final String r115 = "WEAK_WRITE";
        final int r116 = 6;
        LocalCache$EntryFactory r117 = new AnonymousClass7(r115, r116);
        WEAK_WRITE = r117;
        final String r118 = "WEAK_ACCESS_WRITE";
        final int r119 = 7;
        LocalCache$EntryFactory r120 = new AnonymousClass8(r118, r119);
        WEAK_ACCESS_WRITE = r120;
        f8680a = new LocalCache$EntryFactory[]{r11, r14, r17, r20, r21, r114, r117, r120};
        factories = new LocalCache$EntryFactory[]{r11, r14, r17, r20, r21, r114, r117, r120};
    }

    public LocalCache$EntryFactory(String r5, int r10, n r11) {
        super(r5, r10);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static LocalCache$EntryFactory getFactory(LocalCache$Strength r5, boolean r10, boolean r11) {
        int r12 = 0;
        if (r5 != LocalCache$Strength.WEAK) goto L5;
        char r13 = 4;
    L6:
        boolean r14 = r13 | (r10 ? 1 : 0);
        if (r11 == false) goto L10;
        r12 = 2;
    L10:
        return factories[(r14 ? 1 : 0) | r12];
    L5:
        r13 = 0;
        goto L6
    }

    public static LocalCache$EntryFactory valueOf(String r5) {
        return (LocalCache$EntryFactory) Enum.valueOf(LocalCache$EntryFactory.class, r5);
    }

    public static LocalCache$EntryFactory[] values() {
        return (LocalCache$EntryFactory[]) f8680a.clone();
    }

    public <K, V> void copyAccessEntry(v0 r5, v0 r10) {
        r10.setAccessTime(r5.getAccessTime());
        v0 r11 = r5.getPreviousInAccessQueue();
        Logger r12 = q0.f8742v;
        r11.setNextInAccessQueue(r10);
        r10.setPreviousInAccessQueue(r11);
        v0 r13 = r5.getNextInAccessQueue();
        r10.setNextInAccessQueue(r13);
        r13.setPreviousInAccessQueue(r10);
        LocalCache$NullEntry r14 = LocalCache$NullEntry.INSTANCE;
        r5.setNextInAccessQueue(r14);
        r5.setPreviousInAccessQueue(r14);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public <K, V> v0 copyEntry(LocalCache$Segment<K, V> r5, v0 r10, v0 r11) {
        return newEntry(r5, r10.getKey(), r10.getHash(), r11);
    }

    public <K, V> void copyWriteEntry(v0 r5, v0 r10) {
        r10.setWriteTime(r5.getWriteTime());
        v0 r11 = r5.getPreviousInWriteQueue();
        Logger r12 = q0.f8742v;
        r11.setNextInWriteQueue(r10);
        r10.setPreviousInWriteQueue(r11);
        v0 r13 = r5.getNextInWriteQueue();
        r10.setNextInWriteQueue(r13);
        r13.setPreviousInWriteQueue(r10);
        LocalCache$NullEntry r14 = LocalCache$NullEntry.INSTANCE;
        r5.setNextInWriteQueue(r14);
        r5.setPreviousInWriteQueue(r14);
    }

    public abstract <K, V> v0 newEntry(LocalCache$Segment<K, V> r5, K r10, int r11, v0 r12);
}
