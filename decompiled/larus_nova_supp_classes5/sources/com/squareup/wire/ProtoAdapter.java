package com.squareup.wire;

import com.bytedance.mira.exception.PluginClassNotFoundException;
import com.larus.mirabridge.impl.lancet.FastClassNotFoundHandler;
import com.larus.mirabridge.impl.lancet.MiraPluginFix;
import el9.a;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import me.ele.lancet.base.annotations.Skip;
import okio.Buffer;
import okio.BufferedSink;
import okio.BufferedSource;
import okio.ByteString;
import okio.Okio;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes5.dex */
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

    public static final class MapEntryProtoAdapter<K, V> extends ProtoAdapter<Map.Entry<K, V>> {
        final ProtoAdapter<K> keyAdapter;
        final ProtoAdapter<V> valueAdapter;

        @Override // com.squareup.wire.ProtoAdapter
        public Map.Entry<K, V> decode(ProtoReader r1) {
            throw new UnsupportedOperationException();
        }

        public int encodedSize(Map.Entry<K, V> r4) {
            return this.keyAdapter.encodedSizeWithTag(1, r4.getKey()) + this.valueAdapter.encodedSizeWithTag(2, r4.getValue());
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ Object decode(ProtoReader r1) throws IOException {
            return decode(r1);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ int encodedSize(Object r1) {
            return encodedSize((Map.Entry) r1);
        }

        public MapEntryProtoAdapter(ProtoAdapter<K> r3, ProtoAdapter<V> r4) {
            super(FieldEncoding.LENGTH_DELIMITED, null);
            this.keyAdapter = r3;
            this.valueAdapter = r4;
        }

        public void encode(ProtoWriter r4, Map.Entry<K, V> r5) throws IOException {
            this.keyAdapter.encodeWithTag(r4, 1, r5.getKey());
            this.valueAdapter.encodeWithTag(r4, 2, r5.getValue());
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ void encode(ProtoWriter r1, Object r2) throws IOException {
            encode(r1, (Map.Entry) r2);
        }
    }

    public static final class MapProtoAdapter<K, V> extends ProtoAdapter<Map<K, V>> {
        private final MapEntryProtoAdapter<K, V> entryAdapter;

        @Override // com.squareup.wire.ProtoAdapter
        public Map<K, V> decode(ProtoReader r7) throws IOException {
            long r0 = r7.beginMessage();
            K r2 = null;
            V r3 = null;
        L3:
            int r4 = r7.nextTag();
            if (r4 == (-1)) goto L12;
            if (r4 != 1) goto L8;
            r2 = this.entryAdapter.keyAdapter.decode(r7);
            goto L3
        L8:
            if (r4 != 2) goto L3;
            r3 = this.entryAdapter.valueAdapter.decode(r7);
            goto L3
        L12:
            r7.endMessage(r0);
            if (r2 == null) goto L20;
            if (r3 == null) goto L18;
            return Collections.singletonMap(r2, r3);
        L18:
            throw new IllegalStateException("Map entry with null value");
        L20:
            throw new IllegalStateException("Map entry with null key");
        }

        public int encodedSize(Map<K, V> r2) {
            throw new UnsupportedOperationException("Repeated values can only be sized with a tag.");
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ Object redact(Object r1) {
            return redact((Map) r1);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ Object decode(ProtoReader r1) throws IOException {
            return decode(r1);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ int encodedSize(Object r1) {
            return encodedSize((Map) r1);
        }

        public Map<K, V> redact(Map<K, V> r1) {
            return Collections.emptyMap();
        }

        public MapProtoAdapter(ProtoAdapter<K> r3, ProtoAdapter<V> r4) {
            super(FieldEncoding.LENGTH_DELIMITED, null);
            this.entryAdapter = new MapEntryProtoAdapter(r3, r4);
        }

        public void encode(ProtoWriter r1, Map<K, V> r2) {
            throw new UnsupportedOperationException("Repeated values can only be encoded with a tag.");
        }

        public int encodedSizeWithTag(int r4, Map<K, V> r5) {
            Iterator<Map.Entry<K, V>> r6 = r5.entrySet().iterator();
            int r0 = 0;
        L4:
            if (r6.hasNext() == false) goto L6;
            Map.Entry<K, V> r1 = r6.next();
            r0 = r0 + this.entryAdapter.encodedSizeWithTag(r4, r1);
            goto L4
        L6:
            return r0;
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ void encode(ProtoWriter r1, Object r2) throws IOException {
            encode(r1, (Map) r2);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ int encodedSizeWithTag(int r1, Object r2) {
            return encodedSizeWithTag(r1, (Map) r2);
        }

        public void encodeWithTag(ProtoWriter r3, int r4, Map<K, V> r5) throws IOException {
            Iterator<Map.Entry<K, V>> r6 = r5.entrySet().iterator();
        L4:
            if (r6.hasNext() == false) goto L6;
            Map.Entry<K, V> r0 = r6.next();
            this.entryAdapter.encodeWithTag(r3, r4, r0);
            goto L4
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ void encodeWithTag(ProtoWriter r1, int r2, Object r3) throws IOException {
            encodeWithTag(r1, r2, (Map) r3);
        }
    }

    public static /* synthetic */ Class access$000(String r0) throws ClassNotFoundException {
        return Class.forName(r0);
    }

    public abstract E decode(ProtoReader r1) throws IOException;

    public abstract void encode(ProtoWriter r1, E r2) throws IOException;

    public abstract int encodedSize(E r1);

    public E redact(E r1) {
        return null;
    }

    static {
        final FieldEncoding r1 = FieldEncoding.VARINT;
        final Class<Boolean> r2 = Boolean.class;
        BOOL = new AnonymousClass1(r1, r2);
        final Class<Integer> r3 = Integer.class;
        INT32 = new AnonymousClass2(r1, r3);
        final Class<Integer> r4 = Integer.class;
        UINT32 = new AnonymousClass3(r1, r4);
        final Class<Integer> r5 = Integer.class;
        SINT32 = new AnonymousClass4(r1, r5);
        final FieldEncoding r6 = FieldEncoding.FIXED32;
        final Class<Integer> r7 = Integer.class;
        ProtoAdapter<Integer> r0 = new AnonymousClass5(r6, r7);
        FIXED32 = r0;
        SFIXED32 = r0;
        final Class<Long> r8 = Long.class;
        INT64 = new AnonymousClass6(r1, r8);
        final Class<Long> r9 = Long.class;
        UINT64 = new AnonymousClass7(r1, r9);
        final Class<Long> r10 = Long.class;
        SINT64 = new AnonymousClass8(r1, r10);
        final FieldEncoding r11 = FieldEncoding.FIXED64;
        final Class<Long> r12 = Long.class;
        ProtoAdapter<Long> r13 = new AnonymousClass9(r11, r12);
        FIXED64 = r13;
        SFIXED64 = r13;
        final Class<Float> r14 = Float.class;
        FLOAT = new AnonymousClass10(r6, r14);
        final Class<Double> r15 = Double.class;
        DOUBLE = new AnonymousClass11(r11, r15);
        final FieldEncoding r16 = FieldEncoding.LENGTH_DELIMITED;
        final Class<String> r17 = String.class;
        STRING = new AnonymousClass12(r16, r17);
        final Class<ByteString> r18 = ByteString.class;
        BYTES = new AnonymousClass13(r16, r18);
    }

    private ProtoAdapter<List<E>> createPacked() {
        FieldEncoding r0 = this.fieldEncoding;
        FieldEncoding r1 = FieldEncoding.LENGTH_DELIMITED;
        if (r0 == r1) goto L7;
        return new 14(this, r1, List.class);
    L7:
        throw new IllegalArgumentException("Unable to pack a length-delimited type.");
    }

    private ProtoAdapter<List<E>> createRepeated() {
        final FieldEncoding r1 = this.fieldEncoding;
        final Class<List> r2 = List.class;
        return new AnonymousClass15(this, r1, r2);
    }

    public final ProtoAdapter<List<E>> asPacked() {
        ProtoAdapter<List<E>> r0 = this.packedAdapter;
        if (r0 != null) goto L7;
        ProtoAdapter<List<E>> r1 = createPacked();
        this.packedAdapter = r1;
        return r1;
    L7:
        return r0;
    }

    public final ProtoAdapter<List<E>> asRepeated() {
        ProtoAdapter<List<E>> r0 = this.repeatedAdapter;
        if (r0 != null) goto L7;
        ProtoAdapter<List<E>> r1 = createRepeated();
        this.repeatedAdapter = r1;
        return r1;
    L7:
        return r0;
    }

    @Skip({"com.larus.mirabridge.impl.lancet+", "com.bytedance.mira.hook.delegate.DyMiraClassLoader", "com.bytedance.mira.hook.delegate.MiraClassLoader", "com.bytedance.ies.stark.util.NReflectUtils", "-com.bytedance.mira.core.PluginClassLoader", "com.bytedance.common.jato.util.DeviceInfoUtils", "com.bytedance.mira.helper.ClassLoaderHelper", "com.bytedance.mira.core.opt.res+"})
    public static Class INVOKESTATIC_com_squareup_wire_ProtoAdapter_com_larus_mirabridge_impl_lancet_MiraReflectLancet_forName(String r3) throws ClassNotFoundException {
        ConcurrentHashMap r0 = FastClassNotFoundHandler.a;
        FastClassNotFoundHandler.Status r1 = FastClassNotFoundHandler.Status.STATUS_NOTING;
        if (a.a() == true) goto L34;
        Class r2 = access$000(r3);     // Catch: Throwable -> L8
        if (r1 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L7;
        FastClassNotFoundHandler.a(r3);     // Catch: Throwable -> L8
    L7:
        return r2;
    L8:
        th = move-exception;
        if (r1 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L12;
        FastClassNotFoundHandler.b(r3);
    L12:
        throw th;
    L34:
        Class r4 = access$000(r3);     // Catch: Throwable -> L17
        if (r1 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L16;
        FastClassNotFoundHandler.a(r3);     // Catch: Throwable -> L17
    L16:
        return r4;
    L17:
        th = move-exception;
        if (r1 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L22;
        FastClassNotFoundHandler.b(r3);
    L22:
        if ((th instanceof PluginClassNotFoundException) == false) goto L24;
        throw th;
    L24:
        if ((th instanceof ClassNotFoundException) == true) goto L30;
        if ((th instanceof NoClassDefFoundError) == true) goto L30;
        throw th;
    L30:
        return MiraPluginFix.forName(r3);
    }

    public static ProtoAdapter<?> get(String r4) {
        int r0 = r4.indexOf(35);     // Catch: ClassNotFoundException -> L5 Throwable -> L7 IllegalAccessException -> L9
        String r1 = r4.substring(0, r0);     // Catch: ClassNotFoundException -> L5 Throwable -> L7 IllegalAccessException -> L9
        return (ProtoAdapter) INVOKESTATIC_com_squareup_wire_ProtoAdapter_com_larus_mirabridge_impl_lancet_MiraReflectLancet_forName(r1).getField(r4.substring(r0 + 1)).get(null);
    L7:
        e = move-exception;
        throw new IllegalArgumentException("failed to access " + r4, e);
    }

    public static <E extends WireEnum> RuntimeEnumAdapter<E> newEnumAdapter(Class<E> r1) {
        return new RuntimeEnumAdapter(r1);
    }

    public static <M extends Message<M, B>, B extends Message.Builder<M, B>> ProtoAdapter<M> newMessageAdapter(Class<M> r0) {
        return RuntimeMessageAdapter.create(r0);
    }

    public final E decode(InputStream r2) throws IOException {
        Preconditions.checkNotNull(r2, "stream == null");
        return decode(Okio.buffer(Okio.source(r2)));
    }

    public final byte[] encode(E r2) {
        Preconditions.checkNotNull(r2, "value == null");
        Buffer r0 = new Buffer();
        encode(r0, r2);     // Catch: IOException -> L6
        return r0.readByteArray();
    L6:
        e = move-exception;
        throw new AssertionError(e);
    }

    public String toString(E r1) {
        return r1.toString();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public ProtoAdapter<?> withLabel(WireField.Label r2) {
        if (r2.isRepeated() == true) goto L5;
        return this;
    L5:
        if (r2.isPacked() == false) goto L8;
        return asPacked();
    L8:
        return asRepeated();
    }

    public static <M> ProtoAdapter<M> get(Class<M> r4) {
        return (ProtoAdapter) r4.getField("ADAPTER").get(null);
    L6:
        e = move-exception;
        throw new IllegalArgumentException("failed to access " + r4.getName() + "#ADAPTER", e);
    }

    public final E decode(ByteString r2) throws IOException {
        Preconditions.checkNotNull(r2, "bytes == null");
        return decode(new Buffer().write(r2));
    }

    public static <M extends Message> ProtoAdapter<M> get(M r0) {
        return get(r0.getClass());
    }

    public final E decode(byte[] r2) throws IOException {
        Preconditions.checkNotNull(r2, "bytes == null");
        return decode(new Buffer().write(r2));
    }

    public final E decode(BufferedSource r2) throws IOException {
        Preconditions.checkNotNull(r2, "source == null");
        return decode(new ProtoReader(r2));
    }

    public ProtoAdapter(FieldEncoding r1, Class<?> r2) {
        this.fieldEncoding = r1;
        this.javaType = r2;
    }

    public static <K, V> ProtoAdapter<Map<K, V>> newMapAdapter(ProtoAdapter<K> r1, ProtoAdapter<V> r2) {
        return new MapProtoAdapter(r1, r2);
    }

    public final void encode(OutputStream r2, E r3) throws IOException {
        Preconditions.checkNotNull(r3, "value == null");
        Preconditions.checkNotNull(r2, "stream == null");
        BufferedSink r4 = Okio.buffer(Okio.sink(r2));
        encode(r4, r3);
        r4.emit();
    }

    public int encodedSizeWithTag(int r3, E r4) {
        if (r4 != null) goto L5;
        return 0;
    L5:
        int r5 = encodedSize(r4);
        if (this.fieldEncoding != FieldEncoding.LENGTH_DELIMITED) goto L9;
        r5 = r5 + ProtoWriter.varint32Size(r5);
    L9:
        return r5 + ProtoWriter.tagSize(r3);
    }

    public final void encode(BufferedSink r2, E r3) throws IOException {
        Preconditions.checkNotNull(r3, "value == null");
        Preconditions.checkNotNull(r2, "sink == null");
        encode(new ProtoWriter(r2), r3);
    }

    public void encodeWithTag(ProtoWriter r2, int r3, E r4) throws IOException {
        if (r4 != null) goto L4;
        return;
    L4:
        r2.writeTag(r3, this.fieldEncoding);
        if (this.fieldEncoding != FieldEncoding.LENGTH_DELIMITED) goto L7;
        r2.writeVarint32(encodedSize(r4));
    L7:
        encode(r2, r4);
    }
}
