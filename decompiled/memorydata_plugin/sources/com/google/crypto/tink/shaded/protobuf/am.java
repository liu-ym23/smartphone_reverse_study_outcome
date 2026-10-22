package com.google.crypto.tink.shaded.protobuf;

import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: loaded from: classes2.dex */
final class am implements bm {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final as f4954b = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final as f4955a;

    /* JADX INFO: renamed from: com.google.crypto.tink.shaded.protobuf.am$2, reason: invalid class name */
    static /* synthetic */ class AnonymousClass2 {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        static final /* synthetic */ int[] f4956a = null;

        static {
            int[] r0 = new int[ProtoSyntax.values().length];
            f4956a = r0;
            r0[ProtoSyntax.PROTO3.ordinal()] = 1;     // Catch: NoSuchFieldError -> L5
            return;
        }
    }

    private static class a implements as {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private as[] f4957a;

        a(as... r1) {
            this.f4957a = r1;
        }

        @Override // com.google.crypto.tink.shaded.protobuf.as
        public boolean a(Class<?> r5) {
            as[] r4 = this.f4957a;
            int r0 = r4.length;
            int r2 = 0;
        L3:
            if (r2 >= r0) goto L9;
            if (r4[r2].a(r5) == true) goto L6;
            r2 = r2 + 1;
            goto L3
        L6:
            return true;
        L9:
            return false;
        }

        @Override // com.google.crypto.tink.shaded.protobuf.as
        public ar b(Class<?> r5) {
            as[] r4 = this.f4957a;
            int r0 = r4.length;
            int r1 = 0;
        L3:
            if (r1 >= r0) goto L10;
            as r2 = r4[r1];
            if (r2.a(r5) == true) goto L7;
            r1 = r1 + 1;
            goto L3
        L7:
            return r2.b(r5);
        L10:
            throw new UnsupportedOperationException("No factory is available for message type: " + r5.getName());
        }
    }

    static {
        f4954b = new AnonymousClass1();
    }

    public am() {
        this(a());
    }

    private am(as r3) {
        this.f4955a = (as) ZeusTransformUtils.preCheckCast(ab.a((as) ZeusTransformUtils.wrapperContextForParams(r3, as.class, "com.obric.memorydata.plugin"), "messageInfoFactory"), as.class, "com.obric.memorydata.plugin");
    }

    private static as a() {
        return new a(new as[]{y.a(), b()});
    }

    private static <T> bl<T> a(Class<T> r7, ar r8) {
        ar r1 = (ar) ZeusTransformUtils.wrapperContextForParams(r8, ar.class, "com.obric.memorydata.plugin");
        if (GeneratedMessageLite.class.isAssignableFrom(r7) == false) goto L10;
        boolean r9 = a(r1);
        ay r2 = ba.b();
        ai r3 = ai.b();
        bt<?, ?> r4 = bn.b();
        if (r9 == false) goto L7;
        r<?> r5 = t.a();
    L9:
        return aw.a(r7, r1, r2, r3, r4, r5, aq.b());
    L7:
        r5 = null;
        goto L9
    L10:
        boolean r10 = a(r1);
        ay r6 = ba.a();
        ai r11 = ai.a();
        bt<?, ?> r12 = bn.a();
        if (r10 == false) goto L13;
        r<?> r13 = t.b();
    L15:
        return aw.a(r7, r1, r6, r11, r12, r13, aq.a());
    L13:
        r13 = null;
        goto L15
    }

    private static boolean a(ar r2) {
        ar r3 = (ar) ZeusTransformUtils.wrapperContextForParams(r2, ar.class, "com.obric.memorydata.plugin");
        if (AnonymousClass2.f4956a[r3.a().ordinal()] == 1) goto L5;
        return true;
    L5:
        return false;
    }

    private static as b() {
        return (as) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.forName("com.google.crypto.tink.shaded.protobuf.DescriptorMessageInfoFactory", "com.obric.memorydata.plugin").getDeclaredMethod("getInstance", new Class[0]).invoke(null, new Object[0]), as.class, "com.obric.memorydata.plugin");
    L6:
        return f4954b;
    }

    @Override // com.google.crypto.tink.shaded.protobuf.bm
    public <T> bl<T> a(Class<T> r2) {
        bn.a(r2);
        ar r1 = this.f4955a.b(r2);
        if (r1.b() == false) goto L11;
        if (GeneratedMessageLite.class.isAssignableFrom(r2) == false) goto L9;
        bt<?, ?> r3 = bn.b();
        r<?> r0 = t.a();
    L8:
        return ax.a(r3, r0, r1.c());
    L9:
        r3 = bn.a();
        r0 = t.b();
        goto L8
    L11:
        return a(r2, r1);
    }
}
