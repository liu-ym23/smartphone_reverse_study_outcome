package com.google.common.io;

import com.google.common.base.z;

/* JADX INFO: loaded from: classes2.dex */
abstract enum Files$FilePredicate extends Enum<Files$FilePredicate> implements z {
    public static final Files$FilePredicate IS_DIRECTORY = null;
    public static final Files$FilePredicate IS_FILE = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ Files$FilePredicate[] f9300a = null;

    static {
        final String r5 = "IS_DIRECTORY";
        final int r10 = 0;
        Files$FilePredicate r11 = new AnonymousClass1(r5, r10);
        IS_DIRECTORY = r11;
        final String r12 = "IS_FILE";
        final int r13 = 1;
        Files$FilePredicate r14 = new AnonymousClass2(r12, r13);
        IS_FILE = r14;
        f9300a = new Files$FilePredicate[]{r11, r14};
    }

    public Files$FilePredicate(String r5, int r10, a r11) {
        super(r5, r10);
    }

    public static Files$FilePredicate valueOf(String r5) {
        return (Files$FilePredicate) Enum.valueOf(Files$FilePredicate.class, r5);
    }

    public static Files$FilePredicate[] values() {
        return (Files$FilePredicate[]) f9300a.clone();
    }

    @Override // com.google.common.base.z
    public abstract /* synthetic */ boolean apply(Object r5);

    @Override // com.google.common.base.z, java.util.function.Predicate
    public boolean test(Object r5) {
        return apply(r5);
    }
}
