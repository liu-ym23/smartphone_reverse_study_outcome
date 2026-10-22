package com.google.common.collect;

import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: loaded from: classes2.dex */
public abstract class s {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final s f4697a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final s f4698b = null;
    private static final s c = null;

    private static final class a extends s {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final int f4699a;

        a(int r2) {
            super(null);
            this.f4699a = r2;
        }

        @Override // com.google.common.collect.s
        public s a(Comparable<?> r3, Comparable<?> r4) {
            Comparable r5 = (Comparable) ZeusTransformUtils.wrapperContextForParams(r3, Comparable.class, "com.obric.memorydata.plugin");
            Comparable r6 = (Comparable) ZeusTransformUtils.wrapperContextForParams(r4, Comparable.class, "com.obric.memorydata.plugin");
            return this;
        }

        @Override // com.google.common.collect.s
        public int b() {
            return this.f4699a;
        }
    }

    static {
        f4697a = new AnonymousClass1();
        f4698b = new a(-1);
        c = new a(1);
    }

    private s() {
    }

    /* synthetic */ s(AnonymousClass1 r1) {
        this();
    }

    public static s a() {
        return f4697a;
    }

    static /* synthetic */ s c() {
        return f4698b;
    }

    static /* synthetic */ s d() {
        return c;
    }

    static /* synthetic */ s e() {
        return f4697a;
    }

    public abstract s a(Comparable<?> r1, Comparable<?> r2);

    public abstract int b();
}
