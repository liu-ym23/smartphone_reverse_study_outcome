package com.google.common.cache;

/* JADX INFO: loaded from: classes2.dex */
public abstract enum RemovalCause extends Enum<RemovalCause> {
    public static final RemovalCause COLLECTED = null;
    public static final RemovalCause EXPIRED = null;
    public static final RemovalCause EXPLICIT = null;
    public static final RemovalCause REPLACED = null;
    public static final RemovalCause SIZE = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ RemovalCause[] f8683a = null;

    static {
        final String r5 = "EXPLICIT";
        final int r10 = 0;
        RemovalCause r11 = new AnonymousClass1(r5, r10);
        EXPLICIT = r11;
        final String r12 = "REPLACED";
        final int r13 = 1;
        RemovalCause r14 = new AnonymousClass2(r12, r13);
        REPLACED = r14;
        final String r15 = "COLLECTED";
        final int r16 = 2;
        RemovalCause r17 = new AnonymousClass3(r15, r16);
        COLLECTED = r17;
        final String r18 = "EXPIRED";
        final int r19 = 3;
        RemovalCause r20 = new AnonymousClass4(r18, r19);
        EXPIRED = r20;
        final String r21 = "SIZE";
        final int r110 = 4;
        RemovalCause r22 = new AnonymousClass5(r21, r110);
        SIZE = r22;
        f8683a = new RemovalCause[]{r11, r14, r17, r20, r22};
    }

    public RemovalCause(String r5, int r10, AnonymousClass1 r11) {
        super(r5, r10);
    }

    public static RemovalCause valueOf(String r5) {
        return (RemovalCause) Enum.valueOf(RemovalCause.class, r5);
    }

    public static RemovalCause[] values() {
        return (RemovalCause[]) f8683a.clone();
    }

    public abstract boolean wasEvicted();
}
