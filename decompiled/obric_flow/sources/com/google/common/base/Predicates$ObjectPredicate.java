package com.google.common.base;

/* JADX INFO: loaded from: classes2.dex */
abstract enum Predicates$ObjectPredicate extends Enum<Predicates$ObjectPredicate> implements z {
    public static final Predicates$ObjectPredicate ALWAYS_FALSE = null;
    public static final Predicates$ObjectPredicate ALWAYS_TRUE = null;
    public static final Predicates$ObjectPredicate IS_NULL = null;
    public static final Predicates$ObjectPredicate NOT_NULL = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ Predicates$ObjectPredicate[] f8644a = null;

    static {
        final String r5 = "ALWAYS_TRUE";
        final int r10 = 0;
        Predicates$ObjectPredicate r11 = new AnonymousClass1(r5, r10);
        ALWAYS_TRUE = r11;
        final String r12 = "ALWAYS_FALSE";
        final int r13 = 1;
        Predicates$ObjectPredicate r14 = new AnonymousClass2(r12, r13);
        ALWAYS_FALSE = r14;
        final String r15 = "IS_NULL";
        final int r16 = 2;
        Predicates$ObjectPredicate r17 = new AnonymousClass3(r15, r16);
        IS_NULL = r17;
        final String r18 = "NOT_NULL";
        final int r19 = 3;
        Predicates$ObjectPredicate r20 = new AnonymousClass4(r18, r19);
        NOT_NULL = r20;
        f8644a = new Predicates$ObjectPredicate[]{r11, r14, r17, r20};
    }

    public Predicates$ObjectPredicate(String r5, int r10, a0 r11) {
        super(r5, r10);
    }

    public static Predicates$ObjectPredicate valueOf(String r5) {
        return (Predicates$ObjectPredicate) Enum.valueOf(Predicates$ObjectPredicate.class, r5);
    }

    public static Predicates$ObjectPredicate[] values() {
        return (Predicates$ObjectPredicate[]) f8644a.clone();
    }

    @Override // com.google.common.base.z
    public abstract /* synthetic */ boolean apply(Object r5);

    @Override // com.google.common.base.z, java.util.function.Predicate
    public boolean test(Object r5) {
        return apply(r5);
    }

    public <T> z withNarrowedType() {
        return this;
    }
}
