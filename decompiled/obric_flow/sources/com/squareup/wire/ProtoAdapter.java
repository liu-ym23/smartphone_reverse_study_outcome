package com.squareup.wire;

import ai.j0;
import f4.b;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import nu.j;
import nu.k;
import nu.l;
import nu.w;
import okio.ByteString;

/* JADX INFO: loaded from: classes3.dex */
public abstract class ProtoAdapter<E> {
    public static final ProtoAdapter<Boolean> BOOL = null;
    public static final ProtoAdapter<ByteString> BYTES = null;
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

        public EnumConstantNotFoundException(int r5, Class<?> r10) {
            StringBuilder r11 = j0.s(r5, "Unknown enum tag ", " for ");
            r11.append(r10.getCanonicalName());
            super(r11.toString());
            this.value = r5;
        }
    }

    public static final class MapEntryProtoAdapter<K, V> extends ProtoAdapter<Map.Entry<K, V>> {
        final ProtoAdapter<K> keyAdapter;
        final ProtoAdapter<V> valueAdapter;

        public MapEntryProtoAdapter(ProtoAdapter<K> r5, ProtoAdapter<V> r10) {
            super(FieldEncoding.LENGTH_DELIMITED, null);
            this.keyAdapter = r5;
            this.valueAdapter = r10;
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ Object decode(ProtoReader r5) throws IOException {
            return decode(r5);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ void encode(ProtoWriter r5, Object r10) throws IOException {
            encode(r5, (Map.Entry) r10);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ int encodedSize(Object r5) {
            return encodedSize((Map.Entry) r5);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public Map.Entry<K, V> decode(ProtoReader r5) {
            throw new UnsupportedOperationException();
        }

        public void encode(ProtoWriter r5, Map.Entry<K, V> r10) throws IOException {
            this.keyAdapter.encodeWithTag(r5, 1, r10.getKey());
            this.valueAdapter.encodeWithTag(r5, 2, r10.getValue());
        }

        public int encodedSize(Map.Entry<K, V> r5) {
            int r10 = this.keyAdapter.encodedSizeWithTag(1, r5.getKey());
            return this.valueAdapter.encodedSizeWithTag(2, r5.getValue()) + r10;
        }
    }

    public static final class MapProtoAdapter<K, V> extends ProtoAdapter<Map<K, V>> {
        private final MapEntryProtoAdapter<K, V> entryAdapter;

        public MapProtoAdapter(ProtoAdapter<K> r5, ProtoAdapter<V> r10) {
            super(FieldEncoding.LENGTH_DELIMITED, null);
            this.entryAdapter = new MapEntryProtoAdapter(r5, r10);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ Object decode(ProtoReader r5) throws IOException {
            return decode(r5);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ void encode(ProtoWriter r5, Object r10) throws IOException {
            encode(r5, (Map) r10);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ void encodeWithTag(ProtoWriter r5, int r10, Object r11) throws IOException {
            encodeWithTag(r5, r10, (Map) r11);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ int encodedSize(Object r5) {
            return encodedSize((Map) r5);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ int encodedSizeWithTag(int r5, Object r10) {
            return encodedSizeWithTag(r5, (Map) r10);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ Object redact(Object r5) {
            return redact((Map) r5);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public Map<K, V> decode(ProtoReader r10) throws IOException {
            long r5 = r10.beginMessage();
            K r11 = null;
            V r12 = null;
        L3:
            int r13 = r10.nextTag();
            if (r13 == (-1)) goto L12;
            if (r13 != 1) goto L8;
            r11 = this.entryAdapter.keyAdapter.decode(r10);
            goto L3
        L8:
            if (r13 != 2) goto L3;
            r12 = this.entryAdapter.valueAdapter.decode(r10);
            goto L3
        L12:
            r10.endMessage(r5);
            if (r11 == null) goto L20;
            if (r12 == null) goto L18;
            return Collections.singletonMap(r11, r12);
        L18:
            throw new IllegalStateException("Map entry with null value");
        L20:
            throw new IllegalStateException("Map entry with null key");
        }

        public void encode(ProtoWriter r5, Map<K, V> r10) {
            throw new UnsupportedOperationException("Repeated values can only be encoded with a tag.");
        }

        public void encodeWithTag(ProtoWriter r5, int r10, Map<K, V> r11) throws IOException {
            Iterator<Map.Entry<K, V>> r12 = r11.entrySet().iterator();
        L4:
            if (r12.hasNext() == false) goto L6;
            Map.Entry<K, V> r13 = r12.next();
            this.entryAdapter.encodeWithTag(r5, r10, r13);
            goto L4
        }

        public int encodedSize(Map<K, V> r5) {
            throw new UnsupportedOperationException("Repeated values can only be sized with a tag.");
        }

        public int encodedSizeWithTag(int r5, Map<K, V> r10) {
            Iterator<Map.Entry<K, V>> r11 = r10.entrySet().iterator();
            int r12 = 0;
        L4:
            if (r11.hasNext() == false) goto L6;
            Map.Entry<K, V> r13 = r11.next();
            r12 = r12 + this.entryAdapter.encodedSizeWithTag(r5, r13);
            goto L4
        L6:
            return r12;
        }

        public Map<K, V> redact(Map<K, V> r5) {
            return Collections.emptyMap();
        }
    }

    static {
        final FieldEncoding r5 = FieldEncoding.VARINT;
        final Class<Boolean> r10 = Boolean.class;
        BOOL = new AnonymousClass1(r5, r10);
        final Class<Integer> r11 = Integer.class;
        INT32 = new AnonymousClass2(r5, r11);
        UINT32 = new AnonymousClass3(r5, r11);
        SINT32 = new AnonymousClass4(r5, r11);
        final FieldEncoding r12 = FieldEncoding.FIXED32;
        ProtoAdapter<Integer> r13 = new AnonymousClass5(r12, r11);
        FIXED32 = r13;
        SFIXED32 = r13;
        final Class<Long> r14 = Long.class;
        INT64 = new AnonymousClass6(r5, r14);
        UINT64 = new AnonymousClass7(r5, r14);
        SINT64 = new AnonymousClass8(r5, r14);
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
        final Class<ByteString> r21 = ByteString.class;
        BYTES = new AnonymousClass13(r19, r21);
    }

    public ProtoAdapter(FieldEncoding r5, Class<?> r10) {
        this.fieldEncoding = r5;
        this.javaType = r10;
    }

    private ProtoAdapter<List<E>> createPacked() {
        FieldEncoding r5 = this.fieldEncoding;
        final FieldEncoding r10 = FieldEncoding.LENGTH_DELIMITED;
        if (r5 == r10) goto L7;
        final Class<List> r11 = List.class;
        return new AnonymousClass14(this, r10, r11);
    L7:
        throw new IllegalArgumentException("Unable to pack a length-delimited type.");
    }

    private ProtoAdapter<List<E>> createRepeated() {
        final FieldEncoding r5 = this.fieldEncoding;
        final Class<List> r10 = List.class;
        return new AnonymousClass15(this, r5, r10);
    }

    public static <M extends Message> ProtoAdapter<M> get(M r5) {
        return get(r5.getClass());
    }

    public static <E extends WireEnum> RuntimeEnumAdapter<E> newEnumAdapter(Class<E> r5) {
        return new RuntimeEnumAdapter(r5);
    }

    public static <K, V> ProtoAdapter<Map<K, V>> newMapAdapter(ProtoAdapter<K> r5, ProtoAdapter<V> r10) {
        return new MapProtoAdapter(r5, r10);
    }

    public static <M extends Message<M, B>, B extends Message.Builder<M, B>> ProtoAdapter<M> newMessageAdapter(Class<M> r5) {
        return RuntimeMessageAdapter.create(r5);
    }

    public final ProtoAdapter<List<E>> asPacked() {
        ProtoAdapter<List<E>> r5 = this.packedAdapter;
        if (r5 != null) goto L7;
        ProtoAdapter<List<E>> r10 = createPacked();
        this.packedAdapter = r10;
        return r10;
    L7:
        return r5;
    }

    public final ProtoAdapter<List<E>> asRepeated() {
        ProtoAdapter<List<E>> r5 = this.repeatedAdapter;
        if (r5 != null) goto L7;
        ProtoAdapter<List<E>> r10 = createRepeated();
        this.repeatedAdapter = r10;
        return r10;
    L7:
        return r5;
    }

    public abstract E decode(ProtoReader r5) throws IOException;

    public final E decode(byte[] r5) throws IOException {
        Preconditions.checkNotNull(r5, "bytes == null");
        j r10 = new j();
        r10.R(r5);
        return decode(r10);
    }

    public abstract void encode(ProtoWriter r5, E r10) throws IOException;

    public final void encode(k r5, E r10) throws IOException {
        Preconditions.checkNotNull(r10, "value == null");
        Preconditions.checkNotNull(r5, "sink == null");
        encode(new ProtoWriter(r5), r10);
    }

    public void encodeWithTag(ProtoWriter r5, int r10, E r11) throws IOException {
        if (r11 != null) goto L4;
        return;
    L4:
        r5.writeTag(r10, this.fieldEncoding);
        if (this.fieldEncoding != FieldEncoding.LENGTH_DELIMITED) goto L7;
        r5.writeVarint32(encodedSize(r11));
    L7:
        encode(r5, r11);
    }

    public abstract int encodedSize(E r5);

    public int encodedSizeWithTag(int r5, E r10) {
        if (r10 != null) goto L5;
        return 0;
    L5:
        int r11 = encodedSize(r10);
        if (this.fieldEncoding != FieldEncoding.LENGTH_DELIMITED) goto L9;
        r11 = r11 + ProtoWriter.varint32Size(r11);
    L9:
        return ProtoWriter.tagSize(r5) + r11;
    }

    public E redact(E r5) {
        return null;
    }

    public String toString(E r5) {
        return r5.toString();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public ProtoAdapter<?> withLabel(WireField.Label r5) {
        if (r5.isRepeated() == true) goto L5;
        return this;
    L5:
        if (r5.isPacked() == false) goto L8;
        return asPacked();
    L8:
        return asRepeated();
    }

    public static <M> ProtoAdapter<M> get(Class<M> r5) {
        return (ProtoAdapter) r5.getField("ADAPTER").get(null);
    L4:
        e = move-exception;
        throw new IllegalArgumentException("failed to access " + r5.getName() + "#ADAPTER", e);
    }

    public static ProtoAdapter<?> get(String r5) {
        int r10 = r5.indexOf(35);     // Catch: Throwable -> L5
        String r11 = r5.substring(0, r10);     // Catch: Throwable -> L5
        String r12 = r5.substring(r10 + 1);     // Catch: Throwable -> L5
        return (ProtoAdapter) Class.forName(r11).getField(r12).get(null);
    L5:
        e = move-exception;
        throw new IllegalArgumentException(j0.C("failed to access ", r5), e);
    }

    public final byte[] encode(E r5) {
        Preconditions.checkNotNull(r5, "value == null");
        j r10 = new j();
        encode(r10, r5);     // Catch: IOException -> L6
        return r10.K(r10.f20328b);
    L6:
        e = move-exception;
        throw new AssertionError(e);
    }

    public final E decode(ByteString r5) throws IOException {
        Preconditions.checkNotNull(r5, "bytes == null");
        j r10 = new j();
        r10.Q(r5);
        return decode(r10);
    }

    public final E decode(InputStream r5) throws IOException {
        Preconditions.checkNotNull(r5, "stream == null");
        return decode(b.e(b.p(r5)));
    }

    public final E decode(l r5) throws IOException {
        Preconditions.checkNotNull(r5, "source == null");
        return decode(new ProtoReader(r5));
    }

    public final void encode(OutputStream r5, E r10) throws IOException {
        Preconditions.checkNotNull(r10, "value == null");
        Preconditions.checkNotNull(r5, "stream == null");
        w r11 = b.d(b.n(r5));
        encode(r11, r10);
        r11.i();
    }
}
