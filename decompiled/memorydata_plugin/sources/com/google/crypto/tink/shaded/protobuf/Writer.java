package com.google.crypto.tink.shaded.protobuf;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes2.dex */
interface Writer {

    public static final enum FieldOrder extends Enum<FieldOrder> {
        private static final /* synthetic */ FieldOrder[] $VALUES = null;
        public static final FieldOrder ASCENDING = null;
        public static final FieldOrder DESCENDING = null;

        static {
            FieldOrder r0 = new FieldOrder("ASCENDING", 0);
            ASCENDING = r0;
            FieldOrder r1 = new FieldOrder("DESCENDING", 1);
            DESCENDING = r1;
            $VALUES = new FieldOrder[]{r0, r1};
        }

        private FieldOrder(String r1, int r2) {
            super(r1, r2);
        }

        public static FieldOrder valueOf(String r2) {
            return (FieldOrder) ZeusTransformUtils.preCheckCast(Enum.valueOf(FieldOrder.class, r2), FieldOrder.class, "com.obric.memorydata.plugin");
        }

        public static FieldOrder[] values() {
            return (FieldOrder[]) ZeusTransformUtils.preCheckCast($VALUES.clone(), FieldOrder[].class, "com.obric.memorydata.plugin");
        }
    }

    FieldOrder a();

    @Deprecated
    void a(int r1);

    void a(int r1, double r2);

    void a(int r1, float r2);

    void a(int r1, int r2);

    void a(int r1, long r2);

    void a(int r1, ByteString r2);

    <K, V> void a(int r1, an.a<K, V> r2, Map<K, V> r3);

    void a(int r1, Object r2);

    void a(int r1, Object r2, bl r3);

    void a(int r1, String r2);

    void a(int r1, List<String> r2);

    void a(int r1, List<?> r2, bl r3);

    void a(int r1, List<Integer> r2, boolean r3);

    void a(int r1, boolean r2);

    @Deprecated
    void b(int r1);

    void b(int r1, int r2);

    void b(int r1, long r2);

    @Deprecated
    void b(int r1, Object r2, bl r3);

    void b(int r1, List<ByteString> r2);

    @Deprecated
    void b(int r1, List<?> r2, bl r3);

    void b(int r1, List<Integer> r2, boolean r3);

    void c(int r1, int r2);

    void c(int r1, long r2);

    void c(int r1, List<Long> r2, boolean r3);

    void d(int r1, int r2);

    void d(int r1, long r2);

    void d(int r1, List<Long> r2, boolean r3);

    void e(int r1, int r2);

    void e(int r1, long r2);

    void e(int r1, List<Long> r2, boolean r3);

    void f(int r1, int r2);

    void f(int r1, List<Float> r2, boolean r3);

    void g(int r1, List<Double> r2, boolean r3);

    void h(int r1, List<Integer> r2, boolean r3);

    void i(int r1, List<Boolean> r2, boolean r3);

    void j(int r1, List<Integer> r2, boolean r3);

    void k(int r1, List<Integer> r2, boolean r3);

    void l(int r1, List<Long> r2, boolean r3);

    void m(int r1, List<Integer> r2, boolean r3);

    void n(int r1, List<Long> r2, boolean r3);
}
