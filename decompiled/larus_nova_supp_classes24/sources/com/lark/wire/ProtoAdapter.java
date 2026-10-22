package com.lark.wire;

import com.larksuite.component.universe_design.timepicker.impl.base.WheelView;
import java.io.IOException;
import java.time.Duration;
import java.time.Instant;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.JvmClassMappingKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KClass;
import okio.Buffer;
import okio.BufferedSink;
import okio.ByteString;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes24.dex */
public abstract class ProtoAdapter<E> {
    public static final l g = null;
    public static final s h = null;
    public static final b0 i = null;
    public static final p j = null;
    public static final t k = null;
    public static final c0 l = null;
    public static final q m = null;
    public static final f n = null;
    public static final c o = null;
    public static final m p = null;
    public static final w q = null;
    public static final y r = null;
    public static final x s = null;
    public static final z t = null;
    public static final a0 u = null;
    public final FieldEncoding a;
    public final KClass<?> b;
    public final String c;
    public final Syntax d;
    public final E e;
    public final k0 f;

    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00060\u0001j\u0002`\u0002B\u001d\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\f\u0010\u0005\u001a\b\u0012\u0002\b\u0003\u0018\u00010\u0006¢\u0006\u0004\b\u0007\u0010\bB\u001d\b\u0016\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\n\u0010\u0005\u001a\u0006\u0012\u0002\b\u00030\t¢\u0006\u0004\b\u0007\u0010\nR\u0010\u0010\u0003\u001a\u00020\u00048\u0006X\u0087\u0004¢\u0006\u0002\n\u0000¨\u0006\u000b"}, d2 = {"Lcom/lark/wire/ProtoAdapter$EnumConstantNotFoundException;", "Ljava/lang/IllegalArgumentException;", "Lkotlin/IllegalArgumentException;", "value", "", "type", "Lkotlin/reflect/KClass;", "<init>", "(ILkotlin/reflect/KClass;)V", "Ljava/lang/Class;", "(ILjava/lang/Class;)V", "wire-runtime"}, k = 1, mv = {2, 0, 0}, xi = WheelView.WHEEL_ITEM_HEIGHT)
    public static final class EnumConstantNotFoundException extends IllegalArgumentException {
        public final int value;

        public EnumConstantNotFoundException(int r3, KClass<?> r4) {
            StringBuilder r0 = new StringBuilder("Unknown enum tag ");
            r0.append(r3);
            r0.append(" for ");
            if (r4 == null) goto L7;
            Class r5 = JvmClassMappingKt.getJavaClass(r4);
            if (r5 == null) goto L7;
            String r6 = r5.getName();
        L8:
            r0.append(r6);
            super(r0.toString());
            this.value = r3;
            return;
        L7:
            r6 = null;
            goto L8
        }

        public EnumConstantNotFoundException(int r2, Class<?> r3) {
            Intrinsics.checkNotNullParameter(r3, "type");
            this(r2, JvmClassMappingKt.getKotlinClass(r3));
        }
    }

    public static final class a {

        /* JADX INFO: renamed from: com.lark.wire.ProtoAdapter$a$a, reason: collision with other inner class name */
        public static final class C0007a extends ProtoAdapter {
            public C0007a() {
                FieldEncoding r0 = FieldEncoding.LENGTH_DELIMITED;
                KClass r1 = Reflection.getOrCreateKotlinClass(Void.class);
                Intrinsics.checkNotNullParameter(r0, "fieldEncoding");
                Syntax r3 = Syntax.PROTO_2;
                Intrinsics.checkNotNullParameter(r0, "fieldEncoding");
                Intrinsics.checkNotNullParameter(r3, "syntax");
                super(r0, r1, r3, null);
            }

            @Override // com.lark.wire.ProtoAdapter
            public final Object b(h0 r2) {
                Intrinsics.checkNotNullParameter(r2, "reader");
                throw new IllegalStateException("Operation not supported.");
            }

            @Override // com.lark.wire.ProtoAdapter
            public final Object c(g0 r2) {
                Intrinsics.checkNotNullParameter(r2, "reader");
                throw new IllegalStateException("Operation not supported.");
            }

            @Override // com.lark.wire.ProtoAdapter
            public final int k(Object r2) {
                Intrinsics.checkNotNullParameter((Void) r2, "value");
                throw new IllegalStateException("Operation not supported.");
            }

            @Override // com.lark.wire.ProtoAdapter
            public final void f(j0 r2, Object r3) {
                Intrinsics.checkNotNullParameter(r2, "writer");
                Intrinsics.checkNotNullParameter((Void) r3, "value");
                throw new IllegalStateException("Operation not supported.");
            }

            @Override // com.lark.wire.ProtoAdapter
            public final void g(n0 r2, Object r3) {
                Intrinsics.checkNotNullParameter(r2, "writer");
                Intrinsics.checkNotNullParameter((Void) r3, "value");
                throw new IllegalStateException("Operation not supported.");
            }
        }

        @JvmStatic
        public static j a(ProtoAdapter r1, ProtoAdapter r2) {
            Intrinsics.checkNotNullParameter(r1, "keyAdapter");
            Intrinsics.checkNotNullParameter(r2, "valueAdapter");
            return new j(r1, r2);
        }
    }

    public ProtoAdapter() {
        throw null;
    }

    public abstract E c(g0 r1) throws IOException;

    public abstract void f(j0 r1, E r2) throws IOException;

    public abstract int k(E r1);

    static {
        FieldEncoding r0 = FieldEncoding.VARINT;
        KClass r1 = Reflection.getOrCreateKotlinClass(Boolean.TYPE);
        Syntax r2 = Syntax.PROTO_2;
        l r3 = new l(r0, r1, r2);
        g = r3;
        Class r4 = Integer.TYPE;
        s r5 = new s(r0, Reflection.getOrCreateKotlinClass(r4), r2);
        h = r5;
        new g(r5);
        b0 r6 = new b0(r0, Reflection.getOrCreateKotlinClass(r4), r2);
        i = r6;
        new g(r6);
        new g(new u(r0, Reflection.getOrCreateKotlinClass(r4), r2));
        FieldEncoding r7 = FieldEncoding.FIXED32;
        p r8 = new p(r7, Reflection.getOrCreateKotlinClass(r4), r2);
        j = r8;
        new g(r8);
        new g(new p(r7, Reflection.getOrCreateKotlinClass(r4), r2));
        Class r9 = Long.TYPE;
        t r10 = new t(r0, Reflection.getOrCreateKotlinClass(r9), r2);
        k = r10;
        new h(r10);
        c0 r11 = new c0(r0, Reflection.getOrCreateKotlinClass(r9), r2);
        l = r11;
        new h(r11);
        new h(new v(r0, Reflection.getOrCreateKotlinClass(r9), r2));
        FieldEncoding r12 = FieldEncoding.FIXED64;
        q r13 = new q(r12, Reflection.getOrCreateKotlinClass(r9), r2);
        m = r13;
        new h(r13);
        new h(new q(r12, Reflection.getOrCreateKotlinClass(r9), r2));
        f r14 = new f();
        n = r14;
        new e(r14);
        c r15 = new c();
        o = r15;
        new b(r15);
        FieldEncoding r16 = FieldEncoding.LENGTH_DELIMITED;
        m r17 = new m(r16, Reflection.getOrCreateKotlinClass(ByteString.class), r2, ByteString.EMPTY);
        p = r17;
        w r19 = new w(r16, Reflection.getOrCreateKotlinClass(String.class), r2);
        q = r19;
        KClass r20 = Reflection.getOrCreateKotlinClass(Unit.class);
        Syntax r110 = Syntax.PROTO_3;
        new o(r16, r20, r110);
        r = new y(r16, Reflection.getOrCreateKotlinClass(Map.class), r110);
        s = new x(r16, Reflection.getOrCreateKotlinClass(Map.class), r110);
        t = new z(r0, Reflection.getOrCreateKotlinClass(Void.class), r110);
        u = new a0(r16, Reflection.getOrCreateKotlinClass(Object.class), r110);
        f0.a(r15, "type.googleapis.com/google.protobuf.DoubleValue");
        f0.a(r14, "type.googleapis.com/google.protobuf.FloatValue");
        f0.a(r10, "type.googleapis.com/google.protobuf.Int64Value");
        f0.a(r11, "type.googleapis.com/google.protobuf.UInt64Value");
        f0.a(r5, "type.googleapis.com/google.protobuf.Int32Value");
        f0.a(r6, "type.googleapis.com/google.protobuf.UInt32Value");
        f0.a(r3, "type.googleapis.com/google.protobuf.BoolValue");
        f0.a(r19, "type.googleapis.com/google.protobuf.StringValue");
        f0.a(r17, "type.googleapis.com/google.protobuf.BytesValue");
        new n(r16, Reflection.getOrCreateKotlinClass(Duration.class), r110);     // Catch: NoClassDefFoundError -> L5
    L10:
        new r(FieldEncoding.LENGTH_DELIMITED, Reflection.getOrCreateKotlinClass(Instant.class), Syntax.PROTO_3);     // Catch: NoClassDefFoundError -> L8
        return;
    L8:
        new a.C0007a();
        return;
    L5:
        new a.C0007a();
        goto L10
    }

    public final k0 a() {
        k0 r0 = this.f;
        if (r0 == null) goto L6;
        return r0;
    L6:
        throw new UnsupportedOperationException("Can't create a repeated adapter from a repeated or packed adapter.");
    }

    public final KClass<?> getType() {
        return this.b;
    }

    public E b(h0 r2) throws IOException {
        Intrinsics.checkNotNullParameter(r2, "reader");
        return c(r2.i());
    }

    public final E d(ByteString r4) throws IOException {
        Intrinsics.checkNotNullParameter(r4, "bytes");
        int r0 = r4.size();
        Intrinsics.checkNotNullParameter(r4, "source");
        return b(new com.lark.wire.a(r4.toByteArray(), 0, r0));
    }

    public final E e(byte[] r4) throws IOException {
        Intrinsics.checkNotNullParameter(r4, "bytes");
        int r0 = r4.length;
        Intrinsics.checkNotNullParameter(r4, "source");
        return b(new com.lark.wire.a(r4, 0, r0));
    }

    public void g(n0 r2, E r3) throws IOException {
        Intrinsics.checkNotNullParameter(r2, "writer");
        e0 r0 = new e0(this, r3);
        r2.getClass();
        Intrinsics.checkNotNullParameter(r0, "block");
        r0.invoke((j0) r2.g.getValue());
        r2.d(((Buffer) r2.f.getValue()).readByteString());
    }

    public final void h(BufferedSink r3, E r4) throws IOException {
        Intrinsics.checkNotNullParameter(r3, "sink");
        n0 r1 = new n0();
        g(r1, r4);
        Intrinsics.checkNotNullParameter(r3, "sink");
        r1.a();
        r3.writeAll(r1.a);
    }

    public int l(int r3, E r4) {
        if (r4 != null) goto L4;
        return 0;
    L4:
        int r5 = k(r4);
        if (this.a != FieldEncoding.LENGTH_DELIMITED) goto L7;
        int r0 = j0.b;
        r5 = r5 + j0.a.a(r5);
    L7:
        int r1 = j0.b;
        FieldEncoding r2 = FieldEncoding.VARINT;
        Intrinsics.checkNotNullParameter(r2, "fieldEncoding");
        return j0.a.a((r3 << 3) | r2.getValue$wire_runtime()) + r5;
    }

    public final void m(g0 r2, List<E> r3) throws IOException {
        Intrinsics.checkNotNullParameter(r2, "reader");
        Intrinsics.checkNotNullParameter(r3, "destination");
        if (r2.b() == false) goto L6;
        ArrayList r4 = (ArrayList) r3;
        r4.add(c(r2));
        return;
    }

    public void i(j0 r2, int r3, E r4) throws IOException {
        Intrinsics.checkNotNullParameter(r2, "writer");
        if (r4 == null) goto L9;
        r2.b(r3, this.a);
        if (this.a != FieldEncoding.LENGTH_DELIMITED) goto L7;
        r2.c(k(r4));
    L7:
        f(r2, r4);
        return;
    }

    public void j(n0 r3, int r4, E r5) throws IOException {
        Intrinsics.checkNotNullParameter(r3, "writer");
        if (r5 != null) goto L5;
        return;
    L5:
        if (this.a != FieldEncoding.LENGTH_DELIMITED) goto L7;
        int r0 = r3.b();
        g(r3, r5);
        r3.h(r3.b() - r0);
    L8:
        r3.g(r4, this.a);
        return;
    L7:
        g(r3, r5);
        goto L8
    }

    public ProtoAdapter(FieldEncoding r7, KClass r8, Syntax r9, Object r10) {
        Intrinsics.checkNotNullParameter(r7, "fieldEncoding");
        Intrinsics.checkNotNullParameter(r9, "syntax");
        this(r7, r8, null, r9, r10);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public ProtoAdapter(FieldEncoding r2, KClass r3, String r4, Syntax r5, Object r6) {
        Intrinsics.checkNotNullParameter(r2, "fieldEncoding");
        Intrinsics.checkNotNullParameter(r5, "syntax");
        this.a = r2;
        this.b = r3;
        this.c = r4;
        this.d = r5;
        this.e = r6;
        boolean r7 = this instanceof k;
        if (r7 == true) goto L18;
        if ((this instanceof k0) == true) goto L18;
        FieldEncoding r8 = FieldEncoding.LENGTH_DELIMITED;
        if (r2 == r8) goto L18;
        if (r2 == r8) goto L12;
        boolean r9 = true;
    L13:
        if (r9 == false) goto L16;
        new k(this);
        goto L18
    L16:
        throw new IllegalArgumentException("Unable to pack a length-delimited type.".toString());
    L12:
        r9 = false;
    L18:
        if ((this instanceof k0) == true) goto L22;
        if (r7 == true) goto L22;
        k0 r10 = new k0(this);
    L23:
        this.f = r10;
        return;
    L22:
        r10 = null;
        goto L23
    }

    public /* synthetic */ ProtoAdapter(FieldEncoding r7, KClass r8, String r9, Syntax r10, Object r11, int r12) {
        if ((r12 & 16) == 0) goto L5;
        r11 = null;
    L5:
        this(r7, r8, r9, r10, r11);
    }
}
