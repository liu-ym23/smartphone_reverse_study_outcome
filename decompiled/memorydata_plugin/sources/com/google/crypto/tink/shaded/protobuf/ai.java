package com.google.crypto.tink.shaded.protobuf;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
abstract class ai {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final ai f4948a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final ai f4949b = null;

    /* JADX INFO: renamed from: com.google.crypto.tink.shaded.protobuf.ai$1, reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
    }

    private static final class a extends ai {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private static final Class<?> f4950a = null;

        static {
            f4950a = Collections.unmodifiableList(Collections.emptyList()).getClass();
        }

        private a() {
            super(null);
        }

        /* synthetic */ a(AnonymousClass1 r1) {
            this();
        }

        private static <L> List<L> a(Object r4, long r5, int r7) {
            List<L> r0 = c(r4, r5);
            if (r0.isEmpty() == false) goto L15;
            if (ZeusTransformUtils.instanceOf(r0, ah.class) == false) goto L8;
            List<L> r1 = new ag(r7);
        L13:
            bx.a(r4, r5, r1);
            return r1;
        L8:
            if (ZeusTransformUtils.instanceOf(r0, bf.class) == true) goto L10;
        L12:
            r1 = new ArrayList(r7);
            goto L13
        L10:
            if (ZeusTransformUtils.instanceOf(r0, ab.i.class) == false) goto L12;
            r1 = ((ab.i) ZeusTransformUtils.preCheckCast(r0, ab.i.class, "com.obric.memorydata.plugin")).e(r7);
            goto L13
        L15:
            if (f4950a.isAssignableFrom(r0.getClass()) == false) goto L19;
            ArrayList r2 = new ArrayList(r0.size() + r7);
            r2.addAll(r0);
            Object r3 = r2;
        L17:
            bx.a(r4, r5, r3);
            return (List<L>) r3;
        L19:
            if (ZeusTransformUtils.instanceOf(r0, bw.class) == false) goto L22;
            ag r6 = new ag(r0.size() + r7);
            r6.addAll((bw) ZeusTransformUtils.preCheckCast(r0, bw.class, "com.obric.memorydata.plugin"));
            r3 = r6;
            goto L17
        L22:
            if (ZeusTransformUtils.instanceOf(r0, bf.class) == true) goto L24;
            return r0;
        L24:
            if (ZeusTransformUtils.instanceOf(r0, ab.i.class) == true) goto L26;
            return r0;
        L26:
            if (((ab.i) ZeusTransformUtils.preCheckCast(r0, ab.i.class, "com.obric.memorydata.plugin")).a() == true) goto L32;
            r1 = ((ab.i) ZeusTransformUtils.preCheckCast(r0, ab.i.class, "com.obric.memorydata.plugin")).e(r0.size() + r7);
            goto L13
        L32:
            return r0;
        }

        static <E> List<E> c(Object r0, long r1) {
            return (List) ZeusTransformUtils.preCheckCast(bx.f(r0, r1), List.class, "com.obric.memorydata.plugin");
        }

        @Override // com.google.crypto.tink.shaded.protobuf.ai
        <L> List<L> a(Object r1, long r2) {
            return a(r1, r2, 10);
        }

        @Override // com.google.crypto.tink.shaded.protobuf.ai
        <E> void a(Object r3, Object r4, long r5) {
            List r2 = c(r4, r5);
            List r6 = a(r3, r5, r2.size());
            int r0 = r6.size();
            int r1 = r2.size();
            if (r0 <= 0) goto L6;
            if (r1 <= 0) goto L6;
            r6.addAll(r2);
        L6:
            if (r0 <= 0) goto L8;
            r2 = r6;
        L8:
            bx.a(r3, r5, r2);
        }

        @Override // com.google.crypto.tink.shaded.protobuf.ai
        void b(Object r4, long r5) {
            List r3 = (List) ZeusTransformUtils.preCheckCast(bx.f(r4, r5), List.class, "com.obric.memorydata.plugin");
            if (ZeusTransformUtils.instanceOf(r3, ah.class) == false) goto L6;
            Object r6 = ((ah) ZeusTransformUtils.preCheckCast(r3, ah.class, "com.obric.memorydata.plugin")).e();
        L17:
            bx.a(r4, r5, r6);
            return;
        L6:
            if (f4950a.isAssignableFrom(r3.getClass()) == false) goto L9;
            return;
        L9:
            if (ZeusTransformUtils.instanceOf(r3, bf.class) == true) goto L11;
        L16:
            r6 = Collections.unmodifiableList(r3);
            goto L17
        L11:
            if (ZeusTransformUtils.instanceOf(r3, ab.i.class) == false) goto L16;
            if (((ab.i) ZeusTransformUtils.preCheckCast(r3, ab.i.class, "com.obric.memorydata.plugin")).a() == false) goto L19;
            ((ab.i) ZeusTransformUtils.preCheckCast(r3, ab.i.class, "com.obric.memorydata.plugin")).b();
            return;
        }
    }

    private static final class b extends ai {
        private b() {
            super(null);
        }

        /* synthetic */ b(AnonymousClass1 r1) {
            this();
        }

        static <E> ab.i<E> c(Object r0, long r1) {
            return (ab.i) ZeusTransformUtils.preCheckCast(bx.f(r0, r1), ab.i.class, "com.obric.memorydata.plugin");
        }

        @Override // com.google.crypto.tink.shaded.protobuf.ai
        <L> List<L> a(Object r2, long r3) {
            ab.i r1 = c(r2, r3);
            if (r1.a() == true) goto L10;
            int r0 = r1.size();
            if (r0 != 0) goto L7;
            int r4 = 10;
        L8:
            ab.i r5 = r1.e(r4);
            bx.a(r2, r3, r5);
            return r5;
        L7:
            r4 = r0 * 2;
            goto L8
        L10:
            return r1;
        }

        @Override // com.google.crypto.tink.shaded.protobuf.ai
        <E> void a(Object r4, Object r5, long r6) {
            ab.i r3 = c(r4, r6);
            ab.i r7 = c(r5, r6);
            int r0 = r3.size();
            int r1 = r7.size();
            if (r0 <= 0) goto L9;
            if (r1 <= 0) goto L9;
            if (r3.a() == true) goto L8;
            r3 = r3.e(r1 + r0);
        L8:
            r3.addAll(r7);
        L9:
            if (r0 <= 0) goto L11;
            r7 = r3;
        L11:
            bx.a(r4, r6, r7);
        }

        @Override // com.google.crypto.tink.shaded.protobuf.ai
        void b(Object r1, long r2) {
            c(r1, r2).b();
        }
    }

    static {
        AnonymousClass1 r1 = null;
        f4948a = new a(r1);
        f4949b = new b(r1);
    }

    private ai() {
    }

    /* synthetic */ ai(AnonymousClass1 r1) {
        this();
    }

    static ai a() {
        return f4948a;
    }

    static ai b() {
        return f4949b;
    }

    abstract <L> List<L> a(Object r1, long r2);

    abstract <L> void a(Object r1, Object r2, long r3);

    abstract void b(Object r1, long r2);
}
