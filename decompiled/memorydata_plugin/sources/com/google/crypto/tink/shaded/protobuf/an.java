package com.google.crypto.tink.shaded.protobuf;

/* JADX INFO: loaded from: classes2.dex */
public class an<K, V> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final a<K, V> f4958a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final K f4959b;
    private final V c;

    static class a<K, V> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final WireFormat.FieldType f4960a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final K f4961b;
        public final WireFormat.FieldType c;
        public final V d;

        public a(WireFormat.FieldType r1, K r2, WireFormat.FieldType r3, V r4) {
            this.f4960a = r1;
            this.f4961b = r2;
            this.c = r3;
            this.d = r4;
        }
    }

    private an(WireFormat.FieldType r2, K r3, WireFormat.FieldType r4, V r5) {
        this.f4958a = new a(r2, r3, r4, r5);
        this.f4959b = r3;
        this.c = r5;
    }

    static <K, V> int a(a<K, V> r2, K r3, V r4) {
        return w.a(r2.f4960a, 1, r3) + w.a(r2.c, 2, r4);
    }

    public static <K, V> an<K, V> a(WireFormat.FieldType r1, K r2, WireFormat.FieldType r3, V r4) {
        return new an(r1, r2, r3, r4);
    }

    static <K, V> void a(CodedOutputStream r2, a<K, V> r3, K r4, V r5) {
        w.a(r2, r3.f4960a, 1, r4);
        w.a(r2, r3.c, 2, r5);
    }

    public int a(int r1, K r2, V r3) {
        return CodedOutputStream.h(r1) + CodedOutputStream.o(a(this.f4958a, r2, r3));
    }

    a<K, V> a() {
        return this.f4958a;
    }
}
