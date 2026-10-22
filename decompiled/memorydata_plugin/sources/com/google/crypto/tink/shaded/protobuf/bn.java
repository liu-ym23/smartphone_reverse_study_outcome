package com.google.crypto.tink.shaded.protobuf;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.Iterator;
import java.util.List;
import java.util.RandomAccess;

/* JADX INFO: loaded from: classes2.dex */
final class bn {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final Class<?> f4982a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final bt<?, ?> f4983b = null;
    private static final bt<?, ?> c = null;

    static {
        f4982a = d();
        f4983b = c();
        c = new bv();
    }

    static int a(int r2, Object r3, bl r4) {
        bl r5 = (bl) ZeusTransformUtils.wrapperContextForParams(r4, bl.class, "com.obric.memorydata.plugin");
        if (ZeusTransformUtils.instanceOf(r3, af.class) == false) goto L7;
        return CodedOutputStream.a(r2, (af) ZeusTransformUtils.preCheckCast(r3, af.class, "com.obric.memorydata.plugin"));
    L7:
        return CodedOutputStream.b(r2, (at) ZeusTransformUtils.preCheckCast(r3, at.class, "com.obric.memorydata.plugin"), r5);
    }

    static int a(int r5, List<?> r6) {
        List r7 = (List) ZeusTransformUtils.wrapperContextForParams(r6, List.class, "com.obric.memorydata.plugin");
        int r0 = r7.size();
        int r2 = 0;
        if (r0 != 0) goto L5;
        return 0;
    L5:
        int r8 = CodedOutputStream.h(r5) * r0;
        if (ZeusTransformUtils.instanceOf(r7, ah.class) == false) goto L14;
        ah r9 = (ah) ZeusTransformUtils.preCheckCast(r7, ah.class, "com.obric.memorydata.plugin");
    L8:
        if (r2 >= r0) goto L20;
        Object r3 = r9.d(r2);
        if (ZeusTransformUtils.instanceOf(r3, ByteString.class) == false) goto L12;
        int r4 = CodedOutputStream.b((ByteString) ZeusTransformUtils.preCheckCast(r3, ByteString.class, "com.obric.memorydata.plugin"));
    L13:
        r8 = r8 + r4;
        r2 = r2 + 1;
        goto L8
    L12:
        r4 = CodedOutputStream.b((String) ZeusTransformUtils.preCheckCast(r3, String.class, "com.obric.memorydata.plugin"));
    L20:
        return r8;
    L14:
        if (r2 >= r0) goto L20;
        Object r10 = r7.get(r2);
        if (ZeusTransformUtils.instanceOf(r10, ByteString.class) == false) goto L18;
        int r11 = CodedOutputStream.b((ByteString) ZeusTransformUtils.preCheckCast(r10, ByteString.class, "com.obric.memorydata.plugin"));
    L19:
        r8 = r8 + r11;
        r2 = r2 + 1;
        goto L14
    L18:
        r11 = CodedOutputStream.b((String) ZeusTransformUtils.preCheckCast(r10, String.class, "com.obric.memorydata.plugin"));
        goto L19
    }

    static int a(int r5, List<?> r6, bl r7) {
        List r8 = (List) ZeusTransformUtils.wrapperContextForParams(r6, List.class, "com.obric.memorydata.plugin");
        bl r9 = (bl) ZeusTransformUtils.wrapperContextForParams(r7, bl.class, "com.obric.memorydata.plugin");
        int r0 = r8.size();
        int r2 = 0;
        if (r0 != 0) goto L5;
        return 0;
    L5:
        int r10 = CodedOutputStream.h(r5) * r0;
    L6:
        if (r2 >= r0) goto L12;
        Object r3 = r8.get(r2);
        if (ZeusTransformUtils.instanceOf(r3, af.class) == false) goto L10;
        int r4 = CodedOutputStream.a((af) ZeusTransformUtils.preCheckCast(r3, af.class, "com.obric.memorydata.plugin"));
    L11:
        r10 = r10 + r4;
        r2 = r2 + 1;
        goto L6
    L10:
        r4 = CodedOutputStream.b((at) ZeusTransformUtils.preCheckCast(r3, at.class, "com.obric.memorydata.plugin"), r9);
        goto L11
    L12:
        return r10;
    }

    static int a(int r2, List<Long> r3, boolean r4) {
        List r5 = (List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.memorydata.plugin");
        if (r5.size() != 0) goto L6;
        return 0;
    L6:
        int r0 = a(r5);
        if (r4 == false) goto L11;
        return CodedOutputStream.h(r2) + CodedOutputStream.o(r0);
    L11:
        return r0 + (r5.size() * CodedOutputStream.h(r2));
    }

    static int a(List<Long> r6) {
        List r7 = (List) ZeusTransformUtils.wrapperContextForParams(r6, List.class, "com.obric.memorydata.plugin");
        int r0 = r7.size();
        int r2 = 0;
        if (r0 != 0) goto L6;
        return 0;
    L6:
        if (ZeusTransformUtils.instanceOf(r7, al.class) == false) goto L10;
        al r8 = (al) ZeusTransformUtils.preCheckCast(r7, al.class, "com.obric.memorydata.plugin");
        int r1 = 0;
    L8:
        if (r2 >= r0) goto L17;
        r1 = r1 + CodedOutputStream.f(r8.c(r2));
        r2 = r2 + 1;
        goto L8
    L17:
        return r1;
    L10:
        int r3 = 0;
    L11:
        if (r2 >= r0) goto L14;
        r3 = r3 + CodedOutputStream.f(((Long) ZeusTransformUtils.preCheckCast(r7.get(r2), Long.class, "com.obric.memorydata.plugin")).longValue());
        r2 = r2 + 1;
        goto L11
    L14:
        return r3;
    }

    public static bt<?, ?> a() {
        return f4983b;
    }

    static <UT, UB> UB a(Object r2, int r3, int r4, UB r5, bt<UT, UB> r6) {
        if (r5 != null) goto L4;
        r5 = r6.c(r2);
    L4:
        r6.a(r5, r3, r4);
        return r5;
    }

    static <UT, UB> UB a(Object r6, int r7, List<Integer> r8, ab.d<?> r9, UB r10, bt<UT, UB> r11) {
        List r12 = (List) ZeusTransformUtils.wrapperContextForParams(r8, List.class, "com.obric.memorydata.plugin");
        ab.d r13 = (ab.d) ZeusTransformUtils.wrapperContextForParams(r9, ab.d.class, "com.obric.memorydata.plugin");
        if (r13 != null) goto L6;
        return r10;
    L6:
        if (ZeusTransformUtils.instanceOf(r12, RandomAccess.class) == false) goto L18;
        int r0 = r12.size();
        int r2 = 0;
        int r3 = 0;
    L8:
        if (r2 >= r0) goto L16;
        int r4 = ((Integer) ZeusTransformUtils.preCheckCast(r12.get(r2), Integer.class, "com.obric.memorydata.plugin")).intValue();
        if (r13.b(r4) == null) goto L14;
        if (r2 == r3) goto L13;
        r12.set(r3, Integer.valueOf(r4));
    L13:
        r3 = r3 + 1;
    L15:
        r2 = r2 + 1;
        goto L8
    L14:
        r10 = (UB) a(r6, r7, r4, r10, r11);
        goto L15
    L16:
        if (r3 == r0) goto L24;
        r12.subList(r3, r0).clear();
    L24:
        return r10;
    L18:
        Iterator r14 = r12.iterator();
    L20:
        if (r14.hasNext() == false) goto L24;
        int r1 = ((Integer) ZeusTransformUtils.preCheckCast(r14.next(), Integer.class, "com.obric.memorydata.plugin")).intValue();
        if (r13.b(r1) != null) goto L20;
        r10 = (UB) a(r6, r7, r1, r10, r11);
        r14.remove();
        goto L20
    }

    static <UT, UB> UB a(Object r6, int r7, List<Integer> r8, ab.e r9, UB r10, bt<UT, UB> r11) {
        List r12 = (List) ZeusTransformUtils.wrapperContextForParams(r8, List.class, "com.obric.memorydata.plugin");
        ab.e r13 = (ab.e) ZeusTransformUtils.wrapperContextForParams(r9, ab.e.class, "com.obric.memorydata.plugin");
        if (r13 != null) goto L6;
        return r10;
    L6:
        if (ZeusTransformUtils.instanceOf(r12, RandomAccess.class) == false) goto L18;
        int r0 = r12.size();
        int r2 = 0;
        int r3 = 0;
    L8:
        if (r2 >= r0) goto L16;
        int r4 = ((Integer) ZeusTransformUtils.preCheckCast(r12.get(r2), Integer.class, "com.obric.memorydata.plugin")).intValue();
        if (r13.a(r4) == false) goto L14;
        if (r2 == r3) goto L13;
        r12.set(r3, Integer.valueOf(r4));
    L13:
        r3 = r3 + 1;
    L15:
        r2 = r2 + 1;
        goto L8
    L14:
        r10 = (UB) a(r6, r7, r4, r10, r11);
        goto L15
    L16:
        if (r3 == r0) goto L24;
        r12.subList(r3, r0).clear();
    L24:
        return r10;
    L18:
        Iterator r14 = r12.iterator();
    L20:
        if (r14.hasNext() == false) goto L24;
        int r1 = ((Integer) ZeusTransformUtils.preCheckCast(r14.next(), Integer.class, "com.obric.memorydata.plugin")).intValue();
        if (r13.a(r1) == true) goto L20;
        r10 = (UB) a(r6, r7, r1, r10, r11);
        r14.remove();
        goto L20
    }

    public static void a(int r2, List<String> r3, Writer r4) {
        List<String> r5 = (List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.memorydata.plugin");
        Writer r6 = (Writer) ZeusTransformUtils.wrapperContextForParams(r4, Writer.class, "com.obric.memorydata.plugin");
        if (r5 != null) goto L5;
        return;
    L5:
        if (r5.isEmpty() == true) goto L9;
        r6.a(r2, r5);
        return;
    }

    public static void a(int r2, List<?> r3, Writer r4, bl r5) {
        List<?> r6 = (List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.memorydata.plugin");
        Writer r7 = (Writer) ZeusTransformUtils.wrapperContextForParams(r4, Writer.class, "com.obric.memorydata.plugin");
        bl r8 = (bl) ZeusTransformUtils.wrapperContextForParams(r5, bl.class, "com.obric.memorydata.plugin");
        if (r6 != null) goto L5;
        return;
    L5:
        if (r6.isEmpty() == true) goto L9;
        r7.a(r2, r6, r8);
        return;
    }

    public static void a(int r2, List<Double> r3, Writer r4, boolean r5) {
        List<Double> r6 = (List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.memorydata.plugin");
        Writer r7 = (Writer) ZeusTransformUtils.wrapperContextForParams(r4, Writer.class, "com.obric.memorydata.plugin");
        if (r6 != null) goto L5;
        return;
    L5:
        if (r6.isEmpty() == true) goto L9;
        r7.g(r2, r6, r5);
        return;
    }

    static <T> void a(ao r2, T r3, T r4, long r5) {
        bx.a(r3, r5, ((ao) ZeusTransformUtils.wrapperContextForParams(r2, ao.class, "com.obric.memorydata.plugin")).a(bx.f(r3, r5), bx.f(r4, r5)));
    }

    static <T, UT, UB> void a(bt<UT, UB> r1, T r2, T r3) {
        r1.a(r2, r1.c(r1.b(r2), r1.b(r3)));
    }

    static <T, FT extends w.a<FT>> void a(r<FT> r1, T r2, T r3) {
        w<T> r4 = r1.a(r3);
        if (r4.c() == true) goto L6;
        r1.b(r2).a(r4);
        return;
    }

    public static void a(Class<?> r1) {
        if (GeneratedMessageLite.class.isAssignableFrom(r1) == true) goto L11;
        Class<?> r0 = f4982a;
        if (r0 != null) goto L7;
        return;
    L7:
        if (r0.isAssignableFrom(r1) == false) goto L10;
        return;
    L10:
        throw new IllegalArgumentException("Message classes must extend GeneratedMessageV3 or GeneratedMessageLite");
    }

    static boolean a(Object r0, Object r1) {
        if (r0 == r1) goto L8;
        if (r0 != null) goto L5;
    L7:
        return false;
    L5:
        if (r0.equals(r1) == false) goto L7;
    L8:
        return true;
    }

    static int b(int r4, List<ByteString> r5) {
        List r6 = (List) ZeusTransformUtils.wrapperContextForParams(r5, List.class, "com.obric.memorydata.plugin");
        int r0 = r6.size();
        int r2 = 0;
        if (r0 != 0) goto L5;
        return 0;
    L5:
        int r1 = r0 * CodedOutputStream.h(r4);
    L7:
        if (r2 >= r6.size()) goto L9;
        r1 = r1 + CodedOutputStream.b((ByteString) ZeusTransformUtils.preCheckCast(r6.get(r2), ByteString.class, "com.obric.memorydata.plugin"));
        r2 = r2 + 1;
        goto L7
    L9:
        return r1;
    }

    static int b(int r6, List<at> r7, bl r8) {
        List r9 = (List) ZeusTransformUtils.wrapperContextForParams(r7, List.class, "com.obric.memorydata.plugin");
        bl r10 = (bl) ZeusTransformUtils.wrapperContextForParams(r8, bl.class, "com.obric.memorydata.plugin");
        int r0 = r9.size();
        int r2 = 0;
        if (r0 != 0) goto L5;
        return 0;
    L5:
        int r3 = 0;
    L6:
        if (r2 >= r0) goto L8;
        r3 = r3 + CodedOutputStream.d(r6, (at) ZeusTransformUtils.preCheckCast(r9.get(r2), at.class, "com.obric.memorydata.plugin"), r10);
        r2 = r2 + 1;
        goto L6
    L8:
        return r3;
    }

    static int b(int r2, List<Long> r3, boolean r4) {
        List r5 = (List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.memorydata.plugin");
        int r0 = r5.size();
        if (r0 != 0) goto L6;
        return 0;
    L6:
        int r6 = b(r5);
        int r7 = CodedOutputStream.h(r2);
        if (r4 == false) goto L11;
        return r7 + CodedOutputStream.o(r6);
    L11:
        return r6 + (r0 * r7);
    }

    static int b(List<Long> r6) {
        List r7 = (List) ZeusTransformUtils.wrapperContextForParams(r6, List.class, "com.obric.memorydata.plugin");
        int r0 = r7.size();
        int r2 = 0;
        if (r0 != 0) goto L6;
        return 0;
    L6:
        if (ZeusTransformUtils.instanceOf(r7, al.class) == false) goto L10;
        al r8 = (al) ZeusTransformUtils.preCheckCast(r7, al.class, "com.obric.memorydata.plugin");
        int r1 = 0;
    L8:
        if (r2 >= r0) goto L17;
        r1 = r1 + CodedOutputStream.g(r8.c(r2));
        r2 = r2 + 1;
        goto L8
    L17:
        return r1;
    L10:
        int r3 = 0;
    L11:
        if (r2 >= r0) goto L14;
        r3 = r3 + CodedOutputStream.g(((Long) ZeusTransformUtils.preCheckCast(r7.get(r2), Long.class, "com.obric.memorydata.plugin")).longValue());
        r2 = r2 + 1;
        goto L11
    L14:
        return r3;
    }

    public static bt<?, ?> b() {
        return c;
    }

    public static void b(int r2, List<ByteString> r3, Writer r4) {
        List<ByteString> r5 = (List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.memorydata.plugin");
        Writer r6 = (Writer) ZeusTransformUtils.wrapperContextForParams(r4, Writer.class, "com.obric.memorydata.plugin");
        if (r5 != null) goto L5;
        return;
    L5:
        if (r5.isEmpty() == true) goto L9;
        r6.b(r2, r5);
        return;
    }

    public static void b(int r2, List<?> r3, Writer r4, bl r5) {
        List<?> r6 = (List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.memorydata.plugin");
        Writer r7 = (Writer) ZeusTransformUtils.wrapperContextForParams(r4, Writer.class, "com.obric.memorydata.plugin");
        bl r8 = (bl) ZeusTransformUtils.wrapperContextForParams(r5, bl.class, "com.obric.memorydata.plugin");
        if (r6 != null) goto L5;
        return;
    L5:
        if (r6.isEmpty() == true) goto L9;
        r7.b(r2, r6, r8);
        return;
    }

    public static void b(int r2, List<Float> r3, Writer r4, boolean r5) {
        List<Float> r6 = (List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.memorydata.plugin");
        Writer r7 = (Writer) ZeusTransformUtils.wrapperContextForParams(r4, Writer.class, "com.obric.memorydata.plugin");
        if (r6 != null) goto L5;
        return;
    L5:
        if (r6.isEmpty() == true) goto L9;
        r7.f(r2, r6, r5);
        return;
    }

    static int c(int r2, List<Long> r3, boolean r4) {
        List r5 = (List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.memorydata.plugin");
        int r0 = r5.size();
        if (r0 != 0) goto L6;
        return 0;
    L6:
        int r6 = c(r5);
        int r7 = CodedOutputStream.h(r2);
        if (r4 == false) goto L11;
        return r7 + CodedOutputStream.o(r6);
    L11:
        return r6 + (r0 * r7);
    }

    static int c(List<Long> r6) {
        List r7 = (List) ZeusTransformUtils.wrapperContextForParams(r6, List.class, "com.obric.memorydata.plugin");
        int r0 = r7.size();
        int r2 = 0;
        if (r0 != 0) goto L6;
        return 0;
    L6:
        if (ZeusTransformUtils.instanceOf(r7, al.class) == false) goto L10;
        al r8 = (al) ZeusTransformUtils.preCheckCast(r7, al.class, "com.obric.memorydata.plugin");
        int r1 = 0;
    L8:
        if (r2 >= r0) goto L17;
        r1 = r1 + CodedOutputStream.h(r8.c(r2));
        r2 = r2 + 1;
        goto L8
    L17:
        return r1;
    L10:
        int r3 = 0;
    L11:
        if (r2 >= r0) goto L14;
        r3 = r3 + CodedOutputStream.h(((Long) ZeusTransformUtils.preCheckCast(r7.get(r2), Long.class, "com.obric.memorydata.plugin")).longValue());
        r2 = r2 + 1;
        goto L11
    L14:
        return r3;
    }

    private static bt<?, ?> c() {
        Class<?> r1 = e();     // Catch: Throwable -> L8
        if (r1 != null) goto L6;
        return null;
    L6:
        return (bt) ZeusTransformUtils.preCheckCast(r1.getConstructor(new Class[0]).newInstance(new Object[0]), bt.class, "com.obric.memorydata.plugin");
    L8:
        return null;
    }

    public static void c(int r2, List<Long> r3, Writer r4, boolean r5) {
        List<Long> r6 = (List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.memorydata.plugin");
        Writer r7 = (Writer) ZeusTransformUtils.wrapperContextForParams(r4, Writer.class, "com.obric.memorydata.plugin");
        if (r6 != null) goto L5;
        return;
    L5:
        if (r6.isEmpty() == true) goto L9;
        r7.c(r2, r6, r5);
        return;
    }

    static int d(int r2, List<Integer> r3, boolean r4) {
        List r5 = (List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.memorydata.plugin");
        int r0 = r5.size();
        if (r0 != 0) goto L6;
        return 0;
    L6:
        int r6 = d(r5);
        int r7 = CodedOutputStream.h(r2);
        if (r4 == false) goto L11;
        return r7 + CodedOutputStream.o(r6);
    L11:
        return r6 + (r0 * r7);
    }

    static int d(List<Integer> r6) {
        List r7 = (List) ZeusTransformUtils.wrapperContextForParams(r6, List.class, "com.obric.memorydata.plugin");
        int r0 = r7.size();
        int r2 = 0;
        if (r0 != 0) goto L6;
        return 0;
    L6:
        if (ZeusTransformUtils.instanceOf(r7, aa.class) == false) goto L10;
        aa r8 = (aa) ZeusTransformUtils.preCheckCast(r7, aa.class, "com.obric.memorydata.plugin");
        int r1 = 0;
    L8:
        if (r2 >= r0) goto L17;
        r1 = r1 + CodedOutputStream.n(r8.c(r2));
        r2 = r2 + 1;
        goto L8
    L17:
        return r1;
    L10:
        int r3 = 0;
    L11:
        if (r2 >= r0) goto L14;
        r3 = r3 + CodedOutputStream.n(((Integer) ZeusTransformUtils.preCheckCast(r7.get(r2), Integer.class, "com.obric.memorydata.plugin")).intValue());
        r2 = r2 + 1;
        goto L11
    L14:
        return r3;
    }

    private static Class<?> d() {
        return ZeusTransformUtils.forName("com.google.crypto.tink.shaded.protobuf.GeneratedMessageV3", "com.obric.memorydata.plugin");
    L4:
        return null;
    }

    public static void d(int r2, List<Long> r3, Writer r4, boolean r5) {
        List<Long> r6 = (List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.memorydata.plugin");
        Writer r7 = (Writer) ZeusTransformUtils.wrapperContextForParams(r4, Writer.class, "com.obric.memorydata.plugin");
        if (r6 != null) goto L5;
        return;
    L5:
        if (r6.isEmpty() == true) goto L9;
        r7.d(r2, r6, r5);
        return;
    }

    static int e(int r2, List<Integer> r3, boolean r4) {
        List r5 = (List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.memorydata.plugin");
        int r0 = r5.size();
        if (r0 != 0) goto L6;
        return 0;
    L6:
        int r6 = e(r5);
        int r7 = CodedOutputStream.h(r2);
        if (r4 == false) goto L11;
        return r7 + CodedOutputStream.o(r6);
    L11:
        return r6 + (r0 * r7);
    }

    static int e(List<Integer> r6) {
        List r7 = (List) ZeusTransformUtils.wrapperContextForParams(r6, List.class, "com.obric.memorydata.plugin");
        int r0 = r7.size();
        int r2 = 0;
        if (r0 != 0) goto L6;
        return 0;
    L6:
        if (ZeusTransformUtils.instanceOf(r7, aa.class) == false) goto L10;
        aa r8 = (aa) ZeusTransformUtils.preCheckCast(r7, aa.class, "com.obric.memorydata.plugin");
        int r1 = 0;
    L8:
        if (r2 >= r0) goto L17;
        r1 = r1 + CodedOutputStream.i(r8.c(r2));
        r2 = r2 + 1;
        goto L8
    L17:
        return r1;
    L10:
        int r3 = 0;
    L11:
        if (r2 >= r0) goto L14;
        r3 = r3 + CodedOutputStream.i(((Integer) ZeusTransformUtils.preCheckCast(r7.get(r2), Integer.class, "com.obric.memorydata.plugin")).intValue());
        r2 = r2 + 1;
        goto L11
    L14:
        return r3;
    }

    private static Class<?> e() {
        return ZeusTransformUtils.forName("com.google.crypto.tink.shaded.protobuf.UnknownFieldSetSchema", "com.obric.memorydata.plugin");
    L4:
        return null;
    }

    public static void e(int r2, List<Long> r3, Writer r4, boolean r5) {
        List<Long> r6 = (List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.memorydata.plugin");
        Writer r7 = (Writer) ZeusTransformUtils.wrapperContextForParams(r4, Writer.class, "com.obric.memorydata.plugin");
        if (r6 != null) goto L5;
        return;
    L5:
        if (r6.isEmpty() == true) goto L9;
        r7.n(r2, r6, r5);
        return;
    }

    static int f(int r2, List<Integer> r3, boolean r4) {
        List r5 = (List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.memorydata.plugin");
        int r0 = r5.size();
        if (r0 != 0) goto L6;
        return 0;
    L6:
        int r6 = f(r5);
        int r7 = CodedOutputStream.h(r2);
        if (r4 == false) goto L11;
        return r7 + CodedOutputStream.o(r6);
    L11:
        return r6 + (r0 * r7);
    }

    static int f(List<Integer> r6) {
        List r7 = (List) ZeusTransformUtils.wrapperContextForParams(r6, List.class, "com.obric.memorydata.plugin");
        int r0 = r7.size();
        int r2 = 0;
        if (r0 != 0) goto L6;
        return 0;
    L6:
        if (ZeusTransformUtils.instanceOf(r7, aa.class) == false) goto L10;
        aa r8 = (aa) ZeusTransformUtils.preCheckCast(r7, aa.class, "com.obric.memorydata.plugin");
        int r1 = 0;
    L8:
        if (r2 >= r0) goto L17;
        r1 = r1 + CodedOutputStream.j(r8.c(r2));
        r2 = r2 + 1;
        goto L8
    L17:
        return r1;
    L10:
        int r3 = 0;
    L11:
        if (r2 >= r0) goto L14;
        r3 = r3 + CodedOutputStream.j(((Integer) ZeusTransformUtils.preCheckCast(r7.get(r2), Integer.class, "com.obric.memorydata.plugin")).intValue());
        r2 = r2 + 1;
        goto L11
    L14:
        return r3;
    }

    public static void f(int r2, List<Long> r3, Writer r4, boolean r5) {
        List<Long> r6 = (List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.memorydata.plugin");
        Writer r7 = (Writer) ZeusTransformUtils.wrapperContextForParams(r4, Writer.class, "com.obric.memorydata.plugin");
        if (r6 != null) goto L5;
        return;
    L5:
        if (r6.isEmpty() == true) goto L9;
        r7.e(r2, r6, r5);
        return;
    }

    static int g(int r2, List<Integer> r3, boolean r4) {
        List r5 = (List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.memorydata.plugin");
        int r0 = r5.size();
        if (r0 != 0) goto L6;
        return 0;
    L6:
        int r6 = g(r5);
        int r7 = CodedOutputStream.h(r2);
        if (r4 == false) goto L11;
        return r7 + CodedOutputStream.o(r6);
    L11:
        return r6 + (r0 * r7);
    }

    static int g(List<Integer> r6) {
        List r7 = (List) ZeusTransformUtils.wrapperContextForParams(r6, List.class, "com.obric.memorydata.plugin");
        int r0 = r7.size();
        int r2 = 0;
        if (r0 != 0) goto L6;
        return 0;
    L6:
        if (ZeusTransformUtils.instanceOf(r7, aa.class) == false) goto L10;
        aa r8 = (aa) ZeusTransformUtils.preCheckCast(r7, aa.class, "com.obric.memorydata.plugin");
        int r1 = 0;
    L8:
        if (r2 >= r0) goto L17;
        r1 = r1 + CodedOutputStream.k(r8.c(r2));
        r2 = r2 + 1;
        goto L8
    L17:
        return r1;
    L10:
        int r3 = 0;
    L11:
        if (r2 >= r0) goto L14;
        r3 = r3 + CodedOutputStream.k(((Integer) ZeusTransformUtils.preCheckCast(r7.get(r2), Integer.class, "com.obric.memorydata.plugin")).intValue());
        r2 = r2 + 1;
        goto L11
    L14:
        return r3;
    }

    public static void g(int r2, List<Long> r3, Writer r4, boolean r5) {
        List<Long> r6 = (List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.memorydata.plugin");
        Writer r7 = (Writer) ZeusTransformUtils.wrapperContextForParams(r4, Writer.class, "com.obric.memorydata.plugin");
        if (r6 != null) goto L5;
        return;
    L5:
        if (r6.isEmpty() == true) goto L9;
        r7.l(r2, r6, r5);
        return;
    }

    static int h(int r2, List<?> r3, boolean r4) {
        int r5 = ((List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.memorydata.plugin")).size();
        if (r5 != 0) goto L5;
        return 0;
    L5:
        if (r4 == false) goto L9;
        return CodedOutputStream.h(r2) + CodedOutputStream.o(r5 * 4);
    L9:
        return r5 * CodedOutputStream.k(r2, 0);
    }

    static int h(List<?> r2) {
        return ((List) ZeusTransformUtils.wrapperContextForParams(r2, List.class, "com.obric.memorydata.plugin")).size() * 4;
    }

    public static void h(int r2, List<Integer> r3, Writer r4, boolean r5) {
        List<Integer> r6 = (List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.memorydata.plugin");
        Writer r7 = (Writer) ZeusTransformUtils.wrapperContextForParams(r4, Writer.class, "com.obric.memorydata.plugin");
        if (r6 != null) goto L5;
        return;
    L5:
        if (r6.isEmpty() == true) goto L9;
        r7.a(r2, r6, r5);
        return;
    }

    static int i(int r2, List<?> r3, boolean r4) {
        int r5 = ((List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.memorydata.plugin")).size();
        if (r5 != 0) goto L6;
        return 0;
    L6:
        if (r4 == false) goto L10;
        return CodedOutputStream.h(r2) + CodedOutputStream.o(r5 * 8);
    L10:
        return r5 * CodedOutputStream.i(r2, 0);
    }

    static int i(List<?> r2) {
        return ((List) ZeusTransformUtils.wrapperContextForParams(r2, List.class, "com.obric.memorydata.plugin")).size() * 8;
    }

    public static void i(int r2, List<Integer> r3, Writer r4, boolean r5) {
        List<Integer> r6 = (List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.memorydata.plugin");
        Writer r7 = (Writer) ZeusTransformUtils.wrapperContextForParams(r4, Writer.class, "com.obric.memorydata.plugin");
        if (r6 != null) goto L5;
        return;
    L5:
        if (r6.isEmpty() == true) goto L9;
        r7.j(r2, r6, r5);
        return;
    }

    static int j(int r2, List<?> r3, boolean r4) {
        int r5 = ((List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.memorydata.plugin")).size();
        if (r5 != 0) goto L6;
        return 0;
    L6:
        if (r4 == false) goto L10;
        return CodedOutputStream.h(r2) + CodedOutputStream.o(r5);
    L10:
        return r5 * CodedOutputStream.b(r2, true);
    }

    static int j(List<?> r2) {
        return ((List) ZeusTransformUtils.wrapperContextForParams(r2, List.class, "com.obric.memorydata.plugin")).size();
    }

    public static void j(int r2, List<Integer> r3, Writer r4, boolean r5) {
        List<Integer> r6 = (List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.memorydata.plugin");
        Writer r7 = (Writer) ZeusTransformUtils.wrapperContextForParams(r4, Writer.class, "com.obric.memorydata.plugin");
        if (r6 != null) goto L5;
        return;
    L5:
        if (r6.isEmpty() == true) goto L9;
        r7.m(r2, r6, r5);
        return;
    }

    public static void k(int r2, List<Integer> r3, Writer r4, boolean r5) {
        List<Integer> r6 = (List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.memorydata.plugin");
        Writer r7 = (Writer) ZeusTransformUtils.wrapperContextForParams(r4, Writer.class, "com.obric.memorydata.plugin");
        if (r6 != null) goto L5;
        return;
    L5:
        if (r6.isEmpty() == true) goto L9;
        r7.b(r2, r6, r5);
        return;
    }

    public static void l(int r2, List<Integer> r3, Writer r4, boolean r5) {
        List<Integer> r6 = (List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.memorydata.plugin");
        Writer r7 = (Writer) ZeusTransformUtils.wrapperContextForParams(r4, Writer.class, "com.obric.memorydata.plugin");
        if (r6 != null) goto L5;
        return;
    L5:
        if (r6.isEmpty() == true) goto L9;
        r7.k(r2, r6, r5);
        return;
    }

    public static void m(int r2, List<Integer> r3, Writer r4, boolean r5) {
        List<Integer> r6 = (List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.memorydata.plugin");
        Writer r7 = (Writer) ZeusTransformUtils.wrapperContextForParams(r4, Writer.class, "com.obric.memorydata.plugin");
        if (r6 != null) goto L5;
        return;
    L5:
        if (r6.isEmpty() == true) goto L9;
        r7.h(r2, r6, r5);
        return;
    }

    public static void n(int r2, List<Boolean> r3, Writer r4, boolean r5) {
        List<Boolean> r6 = (List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.memorydata.plugin");
        Writer r7 = (Writer) ZeusTransformUtils.wrapperContextForParams(r4, Writer.class, "com.obric.memorydata.plugin");
        if (r6 != null) goto L5;
        return;
    L5:
        if (r6.isEmpty() == true) goto L9;
        r7.i(r2, r6, r5);
        return;
    }
}
