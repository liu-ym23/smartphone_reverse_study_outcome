package com.google.common.util.concurrent;

/* JADX INFO: loaded from: classes2.dex */
public abstract enum CycleDetectingLockFactory$Policies extends Enum<CycleDetectingLockFactory$Policies> {
    public static final CycleDetectingLockFactory$Policies DISABLED = null;
    public static final CycleDetectingLockFactory$Policies THROW = null;
    public static final CycleDetectingLockFactory$Policies WARN = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ CycleDetectingLockFactory$Policies[] f9387a = null;

    static {
        final String r5 = "THROW";
        final int r10 = 0;
        CycleDetectingLockFactory$Policies r11 = new AnonymousClass1(r5, r10);
        THROW = r11;
        final String r12 = "WARN";
        final int r13 = 1;
        CycleDetectingLockFactory$Policies r14 = new AnonymousClass2(r12, r13);
        WARN = r14;
        final String r15 = "DISABLED";
        final int r16 = 2;
        CycleDetectingLockFactory$Policies r17 = new AnonymousClass3(r15, r16);
        DISABLED = r17;
        f9387a = new CycleDetectingLockFactory$Policies[]{r11, r14, r17};
    }

    public CycleDetectingLockFactory$Policies(String r5, int r10, g0 r11) {
        super(r5, r10);
    }

    public static CycleDetectingLockFactory$Policies valueOf(String r5) {
        return (CycleDetectingLockFactory$Policies) Enum.valueOf(CycleDetectingLockFactory$Policies.class, r5);
    }

    public static CycleDetectingLockFactory$Policies[] values() {
        return (CycleDetectingLockFactory$Policies[]) f9387a.clone();
    }

    public abstract /* synthetic */ void handlePotentialDeadlock(CycleDetectingLockFactory$PotentialDeadlockException r5);
}
