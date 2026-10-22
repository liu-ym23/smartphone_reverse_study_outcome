package com.squareup.wire;

import defpackage.b;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.logging.Logger;
import jf.d;
import jf.e;
import jf.f;
import jf.g;
import jf.n;
import jf.p;
import jf.q;
import jf.r;
import jf.x;

/* JADX INFO: loaded from: classes2.dex */
public abstract class ProtoAdapter<E> {
    public static final ProtoAdapter<Boolean> BOOL = null;
    public static final ProtoAdapter<g> BYTES = null;
    public static final ProtoAdapter<Double> DOUBLE = null;
    public static final ProtoAdapter<Integer> FIXED32 = null;
    public static final ProtoAdapter<Long> FIXED64 = null;
    private static final int FIXED_32_SIZE = 4;
    private static final int FIXED_64_SIZE = 8;
    private static final int FIXED_BOOL_SIZE = 1;
    public static final ProtoAdapter<Float> FLOAT = null;
    public static final ProtoAdapter<Integer> INT32 = null;
    public static final ProtoAdapter<Long> INT64 = null;
    public static final ProtoAdapter<Integer> SFIXED32 = null;
    public static final ProtoAdapter<Long> SFIXED64 = null;
    public static final ProtoAdapter<Integer> SINT32 = null;
    public static final ProtoAdapter<Long> SINT64 = null;
    public static final ProtoAdapter<String> STRING = null;
    public static final ProtoAdapter<Integer> UINT32 = null;
    public static final ProtoAdapter<Long> UINT64 = null;
    private final FieldEncoding fieldEncoding;
    final Class<?> javaType;
    ProtoAdapter<List<E>> packedAdapter;
    ProtoAdapter<List<E>> repeatedAdapter;

    public static final class EnumConstantNotFoundException extends IllegalArgumentException {
        public final int value;

        public EnumConstantNotFoundException(int r8, Class<?> r10) {
            StringBuilder r11 = b.f("Unknown enum tag ", r8, " for ");
            r11.append(r10.getCanonicalName());
            super(r11.toString());
            this.value = r8;
        }
    }

    public static final class MapEntryProtoAdapter<K, V> extends ProtoAdapter<Map.Entry<K, V>> {
        final ProtoAdapter<K> keyAdapter;
        final ProtoAdapter<V> valueAdapter;

        public MapEntryProtoAdapter(ProtoAdapter<K> r8, ProtoAdapter<V> r10) {
            super(FieldEncoding.LENGTH_DELIMITED, null);
            this.keyAdapter = r8;
            this.valueAdapter = r10;
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ Object decode(ProtoReader r8) {
            return decode(r8);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ void encode(ProtoWriter r8, Object r10) {
            encode(r8, (Map.Entry) r10);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ int encodedSize(Object r8) {
            return encodedSize((Map.Entry) r8);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public Map.Entry<K, V> decode(ProtoReader r8) {
            throw new UnsupportedOperationException();
        }

        public void encode(ProtoWriter r8, Map.Entry<K, V> r10) {
            this.keyAdapter.encodeWithTag(r8, 1, r10.getKey());
            this.valueAdapter.encodeWithTag(r8, 2, r10.getValue());
        }

        public int encodedSize(Map.Entry<K, V> r8) {
            int r10 = this.keyAdapter.encodedSizeWithTag(1, r8.getKey());
            return this.valueAdapter.encodedSizeWithTag(2, r8.getValue()) + r10;
        }
    }

    public static final class MapProtoAdapter<K, V> extends ProtoAdapter<Map<K, V>> {
        private final MapEntryProtoAdapter<K, V> entryAdapter;

        public MapProtoAdapter(ProtoAdapter<K> r8, ProtoAdapter<V> r10) {
            super(FieldEncoding.LENGTH_DELIMITED, null);
            this.entryAdapter = new MapEntryProtoAdapter(r8, r10);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ Object decode(ProtoReader r8) {
            return decode(r8);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ void encode(ProtoWriter r8, Object r10) {
            encode(r8, (Map) r10);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ void encodeWithTag(ProtoWriter r8, int r10, Object r11) {
            encodeWithTag(r8, r10, (Map) r11);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ int encodedSize(Object r8) {
            return encodedSize((Map) r8);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ int encodedSizeWithTag(int r8, Object r10) {
            return encodedSizeWithTag(r8, (Map) r10);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ Object redact(Object r8) {
            return redact((Map) r8);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public Map<K, V> decode(ProtoReader r8) {
            long r10 = r8.beginMessage();
            K r11 = null;
            V r12 = null;
        L3:
            int r13 = r8.nextTag();
            if (r13 == (-1)) goto L12;
            if (r13 != 1) goto L8;
            r11 = this.entryAdapter.keyAdapter.decode(r8);
            goto L3
        L8:
            if (r13 != 2) goto L3;
            r12 = this.entryAdapter.valueAdapter.decode(r8);
            goto L3
        L12:
            r8.endMessage(r10);
            if (r11 == null) goto L20;
            if (r12 == null) goto L18;
            return Collections.singletonMap(r11, r12);
        L18:
            throw new IllegalStateException("Map entry with null value");
        L20:
            throw new IllegalStateException("Map entry with null key");
        }

        public void encode(ProtoWriter r8, Map<K, V> r10) {
            throw new UnsupportedOperationException("Repeated values can only be encoded with a tag.");
        }

        public void encodeWithTag(ProtoWriter r8, int r10, Map<K, V> r11) {
            Iterator<Map.Entry<K, V>> r12 = r11.entrySet().iterator();
        L4:
            if (r12.hasNext() == false) goto L6;
            Map.Entry<K, V> r13 = r12.next();
            this.entryAdapter.encodeWithTag(r8, r10, r13);
            goto L4
        }

        public int encodedSize(Map<K, V> r8) {
            throw new UnsupportedOperationException("Repeated values can only be sized with a tag.");
        }

        public int encodedSizeWithTag(int r8, Map<K, V> r10) {
            Iterator<Map.Entry<K, V>> r11 = r10.entrySet().iterator();
            int r12 = 0;
        L4:
            if (r11.hasNext() == false) goto L6;
            Map.Entry<K, V> r13 = r11.next();
            r12 = r12 + this.entryAdapter.encodedSizeWithTag(r8, r13);
            goto L4
        L6:
            return r12;
        }

        public Map<K, V> redact(Map<K, V> r8) {
            return Collections.emptyMap();
        }
    }

    static {
        final FieldEncoding r8 = FieldEncoding.VARINT;
        final Class<Boolean> r10 = Boolean.class;
        BOOL = new AnonymousClass1(r8, r10);
        final Class<Integer> r11 = Integer.class;
        INT32 = new AnonymousClass2(r8, r11);
        UINT32 = new AnonymousClass3(r8, r11);
        SINT32 = new AnonymousClass4(r8, r11);
        final FieldEncoding r12 = FieldEncoding.FIXED32;
        ProtoAdapter<Integer> r13 = new AnonymousClass5(r12, r11);
        FIXED32 = r13;
        SFIXED32 = r13;
        final Class<Long> r14 = Long.class;
        INT64 = new AnonymousClass6(r8, r14);
        UINT64 = new AnonymousClass7(r8, r14);
        SINT64 = new AnonymousClass8(r8, r14);
        final FieldEncoding r15 = FieldEncoding.FIXED64;
        ProtoAdapter<Long> r16 = new AnonymousClass9(r15, r14);
        FIXED64 = r16;
        SFIXED64 = r16;
        final Class<Float> r17 = Float.class;
        FLOAT = new AnonymousClass10(r12, r17);
        final Class<Double> r18 = Double.class;
        DOUBLE = new AnonymousClass11(r15, r18);
        final FieldEncoding r19 = FieldEncoding.LENGTH_DELIMITED;
        final Class<String> r20 = String.class;
        STRING = new AnonymousClass12(r19, r20);
        final Class<g> r21 = g.class;
        BYTES = new AnonymousClass13(r19, r21);
    }

    public ProtoAdapter(FieldEncoding r8, Class<?> r10) {
        this.fieldEncoding = r8;
        this.javaType = r10;
    }

    private ProtoAdapter<List<E>> createPacked() {
        FieldEncoding r8 = this.fieldEncoding;
        final FieldEncoding r10 = FieldEncoding.LENGTH_DELIMITED;
        if (r8 == r10) goto L7;
        final Class<List> r11 = List.class;
        return new AnonymousClass14(this, r10, r11);
    L7:
        throw new IllegalArgumentException("Unable to pack a length-delimited type.");
    }

    private ProtoAdapter<List<E>> createRepeated() {
        final FieldEncoding r8 = this.fieldEncoding;
        final Class<List> r10 = List.class;
        return new AnonymousClass15(this, r8, r10);
    }

    public static <M extends Message> ProtoAdapter<M> get(M r8) {
        return get(r8.getClass());
    }

    public static <E extends WireEnum> RuntimeEnumAdapter<E> newEnumAdapter(Class<E> r8) {
        return new RuntimeEnumAdapter(r8);
    }

    public static <K, V> ProtoAdapter<Map<K, V>> newMapAdapter(ProtoAdapter<K> r8, ProtoAdapter<V> r10) {
        return new MapProtoAdapter(r8, r10);
    }

    public static <M extends Message<M, B>, B extends Message.Builder<M, B>> ProtoAdapter<M> newMessageAdapter(Class<M> r8) {
        return RuntimeMessageAdapter.create(r8);
    }

    public final ProtoAdapter<List<E>> asPacked() {
        ProtoAdapter<List<E>> r8 = this.packedAdapter;
        if (r8 != null) goto L7;
        ProtoAdapter<List<E>> r10 = createPacked();
        this.packedAdapter = r10;
        return r10;
    L7:
        return r8;
    }

    public final ProtoAdapter<List<E>> asRepeated() {
        ProtoAdapter<List<E>> r8 = this.repeatedAdapter;
        if (r8 != null) goto L7;
        ProtoAdapter<List<E>> r10 = createRepeated();
        this.repeatedAdapter = r10;
        return r10;
    L7:
        return r8;
    }

    public abstract E decode(ProtoReader r8);

    public final E decode(InputStream r8) {
        Preconditions.checkNotNull(r8, "stream == null");
        Logger r10 = p.f8861a;
        x r11 = new x();
        if (r8 == null) goto L7;
        return decode(new r(new n(r8, r11)));
    L7:
        throw new IllegalArgumentException("in == null");
    }

    public abstract void encode(ProtoWriter r8, E r10);

    public final void encode(OutputStream r8, E r10) {
        Preconditions.checkNotNull(r10, "value == null");
        Preconditions.checkNotNull(r8, "stream == null");
        q r11 = new q(p.c(r8));
        encode(r11, r10);
        r11.f();
    }

    public void encodeWithTag(ProtoWriter r8, int r10, E r11) {
        if (r11 != null) goto L4;
        return;
    L4:
        r8.writeTag(r10, this.fieldEncoding);
        if (this.fieldEncoding != FieldEncoding.LENGTH_DELIMITED) goto L7;
        r8.writeVarint32(encodedSize(r11));
    L7:
        encode(r8, r11);
    }

    public abstract int encodedSize(E r8);

    public int encodedSizeWithTag(int r8, E r10) {
        if (r10 != null) goto L5;
        return 0;
    L5:
        int r11 = encodedSize(r10);
        if (this.fieldEncoding != FieldEncoding.LENGTH_DELIMITED) goto L9;
        r11 = r11 + ProtoWriter.varint32Size(r11);
    L9:
        return ProtoWriter.tagSize(r8) + r11;
    }

    public E redact(E r8) {
        return null;
    }

    public String toString(E r8) {
        return r8.toString();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public ProtoAdapter<?> withLabel(WireField.Label r8) {
        if (r8.isRepeated() == true) goto L5;
        return this;
    L5:
        if (r8.isPacked() == false) goto L8;
        return asPacked();
    L8:
        return asRepeated();
    }

    public static <M> ProtoAdapter<M> get(Class<M> r8) {
        return (ProtoAdapter) r8.getField("ADAPTER").get(null);
    L4:
        e = move-exception;
        throw new IllegalArgumentException("failed to access " + r8.getName() + "#ADAPTER", e);
    }

    public static ProtoAdapter<?> get(String r8) {
        int r10 = r8.indexOf(35);     // Catch: Throwable -> L5
        String r11 = r8.substring(0, r10);     // Catch: Throwable -> L5
        String r12 = r8.substring(r10 + 1);     // Catch: Throwable -> L5
        return (ProtoAdapter) Class.forName(r11).getField(r12).get(null);
    L5:
        e = move-exception;
        throw new IllegalArgumentException(b.c("failed to access ", r8), e);
    }

    public final void encode(e r8, E r10) {
        Preconditions.checkNotNull(r10, "value == null");
        Preconditions.checkNotNull(r8, "sink == null");
        encode(new ProtoWriter(r8), r10);
    }

    public final byte[] encode(E r8) {
        Preconditions.checkNotNull(r8, "value == null");
        d r10 = new d();
        encode(r10, r8);     // Catch: IOException -> L9
        return r10.w(r10.f8830b);
    L6:
        e = move-exception;
        throw new AssertionError(e);
    L9:
        e = move-exception;
        throw new AssertionError(e);
    }

    public final E decode(f r8) {
        Preconditions.checkNotNull(r8, "source == null");
        return decode(new ProtoReader(r8));
    }

    public final E decode(g r8) {
        Preconditions.checkNotNull(r8, "bytes == null");
        d r10 = new d();
        r10.E(r8);
        return decode(r10);
    }

    public final E decode(byte[] r8) {
        Preconditions.checkNotNull(r8, "bytes == null");
        d r10 = new d();
        r10.m15write(r8);
        return decode(r10);
    }
}
