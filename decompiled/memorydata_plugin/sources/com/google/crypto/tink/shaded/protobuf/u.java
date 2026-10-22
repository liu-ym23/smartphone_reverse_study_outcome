package com.google.crypto.tink.shaded.protobuf;

import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: loaded from: classes2.dex */
final class u implements Comparable<u> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final java.lang.reflect.Field f5039a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final FieldType f5040b;
    private final Class<?> c;
    private final int d;
    private final java.lang.reflect.Field e;
    private final int f;
    private final boolean g;
    private final boolean h;
    private final bb i;
    private final java.lang.reflect.Field j;
    private final Class<?> k;
    private final Object l;
    private final ab.e m;

    /* JADX INFO: renamed from: com.google.crypto.tink.shaded.protobuf.u$1, reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        static final /* synthetic */ int[] f5041a = null;

        static {
            int[] r0 = new int[FieldType.values().length];
            f5041a = r0;
            r0[FieldType.MESSAGE.ordinal()] = 1;     // Catch: NoSuchFieldError -> L8
        L12:
            f5041a[FieldType.GROUP.ordinal()] = 2;     // Catch: NoSuchFieldError -> L9
        L14:
            f5041a[FieldType.MESSAGE_LIST.ordinal()] = 3;     // Catch: NoSuchFieldError -> L10
        L18:
            f5041a[FieldType.GROUP_LIST.ordinal()] = 4;     // Catch: NoSuchFieldError -> L11
            return;
        }
    }

    public int a() {
        return this.d;
    }

    public int a(u r1) {
        return this.d - r1.d;
    }

    public java.lang.reflect.Field b() {
        return this.f5039a;
    }

    public bb c() {
        return this.i;
    }

    @Override // java.lang.Comparable
    public /* synthetic */ int compareTo(u r3) {
        return a((u) ZeusTransformUtils.preCheckCast(r3, u.class, "com.obric.memorydata.plugin"));
    }

    public ab.e d() {
        return this.m;
    }

    public java.lang.reflect.Field e() {
        return this.e;
    }

    public Object f() {
        return this.l;
    }

    public int g() {
        return this.f;
    }

    public FieldType getType() {
        return this.f5040b;
    }

    public boolean h() {
        return this.g;
    }

    public boolean i() {
        return this.h;
    }

    public java.lang.reflect.Field j() {
        return this.j;
    }

    public Class<?> k() {
        int r0 = AnonymousClass1.f5041a[this.f5040b.ordinal()];
        if (r0 != 1) goto L5;
    L14:
        java.lang.reflect.Field r1 = this.f5039a;
        if (r1 == null) goto L18;
        return r1.getType();
    L18:
        return this.k;
    L5:
        if (r0 == 2) goto L14;
        if (r0 == 3) goto L13;
        if (r0 == 4) goto L13;
        return null;
    L13:
        return this.c;
    }
}
