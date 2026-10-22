package com.google.common.reflect;

import java.lang.reflect.ParameterizedType;
import java.util.Objects;

/* JADX INFO: loaded from: classes2.dex */
abstract enum Types$ClassOwnership extends Enum<Types$ClassOwnership> {
    static final Types$ClassOwnership JVM_BEHAVIOR = null;
    public static final Types$ClassOwnership LOCAL_CLASS_HAS_NO_OWNER = null;
    public static final Types$ClassOwnership OWNED_BY_ENCLOSING_CLASS = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ Types$ClassOwnership[] f9352a = null;

    static {
        final String r5 = "OWNED_BY_ENCLOSING_CLASS";
        final int r10 = 0;
        Types$ClassOwnership r11 = new AnonymousClass1(r5, r10);
        OWNED_BY_ENCLOSING_CLASS = r11;
        final String r12 = "LOCAL_CLASS_HAS_NO_OWNER";
        final int r13 = 1;
        Types$ClassOwnership r14 = new AnonymousClass2(r12, r13);
        LOCAL_CLASS_HAS_NO_OWNER = r14;
        f9352a = new Types$ClassOwnership[]{r11, r14};
        ParameterizedType r15 = (ParameterizedType) s.class.getGenericSuperclass();
        Objects.requireNonNull(r15);
        Types$ClassOwnership[] r16 = values();
        int r17 = r16.length;
    L3:
        if (r10 >= r17) goto L10;
        Types$ClassOwnership r18 = r16[r10];
        if (r18.getOwnerType(s.class) == r15.getOwnerType()) goto L6;
        r10 = r10 + 1;
        goto L3
    L6:
        JVM_BEHAVIOR = r18;
        return;
    L10:
        throw new AssertionError();
    }

    public Types$ClassOwnership(String r5, int r10, r r11) {
        super(r5, r10);
    }

    public static Types$ClassOwnership valueOf(String r5) {
        return (Types$ClassOwnership) Enum.valueOf(Types$ClassOwnership.class, r5);
    }

    public static Types$ClassOwnership[] values() {
        return (Types$ClassOwnership[]) f9352a.clone();
    }

    public abstract Class<?> getOwnerType(Class<?> r5);
}
