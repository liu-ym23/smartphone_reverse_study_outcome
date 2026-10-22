package kotlinx.serialization.b;

import androidx.exifinterface.media.ExifInterface;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlinx.serialization.SerializationException;
import kotlinx.serialization.descriptors.f;

/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000x\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0005\n\u0002\b\u0002\n\u0002\u0010\f\n\u0002\b\u0002\n\u0002\u0010\u0006\n\u0002\b\u0004\n\u0002\u0010\u0007\n\u0002\b\u0006\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0010\u0001\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\n\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\b'\u0018\u00002\u00020\u00012\u00020\u0002B\u0005¢\u0006\u0002\u0010\u0003J\u0010\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0006H\u0016J\b\u0010\u0007\u001a\u00020\bH\u0016J\u0016\u0010\t\u001a\u00020\b2\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\n\u001a\u00020\u000bJ\b\u0010\f\u001a\u00020\rH\u0016J\u0016\u0010\u000e\u001a\u00020\r2\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\n\u001a\u00020\u000bJ\b\u0010\u000f\u001a\u00020\u0010H\u0016J\u0016\u0010\u0011\u001a\u00020\u00102\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\n\u001a\u00020\u000bJ\b\u0010\u0012\u001a\u00020\u0013H\u0016J\u0016\u0010\u0014\u001a\u00020\u00132\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\n\u001a\u00020\u000bJ\u0010\u0010\u0015\u001a\u00020\u000b2\u0006\u0010\u0016\u001a\u00020\u0006H\u0016J\b\u0010\u0017\u001a\u00020\u0018H\u0016J\u0016\u0010\u0019\u001a\u00020\u00182\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\n\u001a\u00020\u000bJ\u0010\u0010\u001a\u001a\u00020\u00012\u0006\u0010\u0005\u001a\u00020\u0006H\u0016J\u0018\u0010\u001b\u001a\u00020\u00012\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\n\u001a\u00020\u000bH\u0016J\b\u0010\u001c\u001a\u00020\u000bH\u0016J\u0016\u0010\u001d\u001a\u00020\u000b2\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\n\u001a\u00020\u000bJ\b\u0010\u001e\u001a\u00020\u001fH\u0016J\u0016\u0010 \u001a\u00020\u001f2\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\n\u001a\u00020\u000bJ\b\u0010!\u001a\u00020\bH\u0016J\n\u0010\"\u001a\u0004\u0018\u00010#H\u0016JA\u0010$\u001a\u0004\u0018\u0001H%\"\b\b\u0000\u0010%*\u00020&2\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\n\u001a\u00020\u000b2\u000e\u0010'\u001a\n\u0012\u0006\u0012\u0004\u0018\u0001H%0(2\b\u0010)\u001a\u0004\u0018\u0001H%¢\u0006\u0002\u0010*J;\u0010+\u001a\u0002H%\"\u0004\b\u0000\u0010%2\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\n\u001a\u00020\u000b2\f\u0010'\u001a\b\u0012\u0004\u0012\u0002H%0(2\b\u0010)\u001a\u0004\u0018\u0001H%H\u0016¢\u0006\u0002\u0010*J-\u0010,\u001a\u0002H%\"\u0004\b\u0000\u0010%2\f\u0010'\u001a\b\u0012\u0004\u0012\u0002H%0(2\n\b\u0002\u0010)\u001a\u0004\u0018\u0001H%H\u0016¢\u0006\u0002\u0010-J\b\u0010.\u001a\u00020/H\u0016J\u0016\u00100\u001a\u00020/2\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\n\u001a\u00020\u000bJ\b\u00101\u001a\u000202H\u0016J\u0016\u00103\u001a\u0002022\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\n\u001a\u00020\u000bJ\b\u00104\u001a\u00020&H\u0016J\u0010\u00105\u001a\u0002062\u0006\u0010\u0005\u001a\u00020\u0006H\u0016¨\u00067"}, d2 = {"Lkotlinx/serialization/encoding/AbstractDecoder;", "Lkotlinx/serialization/encoding/Decoder;", "Lkotlinx/serialization/encoding/CompositeDecoder;", "()V", "beginStructure", "descriptor", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "decodeBoolean", "", "decodeBooleanElement", "index", "", "decodeByte", "", "decodeByteElement", "decodeChar", "", "decodeCharElement", "decodeDouble", "", "decodeDoubleElement", "decodeEnum", "enumDescriptor", "decodeFloat", "", "decodeFloatElement", "decodeInline", "decodeInlineElement", "decodeInt", "decodeIntElement", "decodeLong", "", "decodeLongElement", "decodeNotNullMark", "decodeNull", "", "decodeNullableSerializableElement", ExifInterface.GPS_DIRECTION_TRUE, "", "deserializer", "Lkotlinx/serialization/DeserializationStrategy;", "previousValue", "(Lkotlinx/serialization/descriptors/SerialDescriptor;ILkotlinx/serialization/DeserializationStrategy;Ljava/lang/Object;)Ljava/lang/Object;", "decodeSerializableElement", "decodeSerializableValue", "(Lkotlinx/serialization/DeserializationStrategy;Ljava/lang/Object;)Ljava/lang/Object;", "decodeShort", "", "decodeShortElement", "decodeString", "", "decodeStringElement", "decodeValue", "endStructure", "", "kotlinx-serialization-core"}, k = 1, mv = {1, 7, 1}, xi = 48)
public abstract class a implements b, c {
    public a() {
    }

    @Override // kotlinx.serialization.b.c
    public int a(f r3) {
        Intrinsics.checkNotNullParameter((f) ZeusTransformUtils.wrapperContextForParams(r3, f.class, "com.obric.memorydata.plugin"), "enumDescriptor");
        Object r2 = a();
        Intrinsics.checkNotNull(r2, "null cannot be cast to non-null type kotlin.Int");
        return ((Integer) ZeusTransformUtils.preCheckCast(r2, Integer.class, "com.obric.memorydata.plugin")).intValue();
    }

    public Object a() {
        throw new SerializationException(Reflection.getOrCreateKotlinClass(getClass()) + " can't retrieve untyped values");
    }

    @Override // kotlinx.serialization.b.c
    public <T> T a(kotlinx.serialization.b<T> r3) {
        return (T) c.a.a(this, (kotlinx.serialization.b) ZeusTransformUtils.wrapperContextForParams(r3, kotlinx.serialization.b.class, "com.obric.memorydata.plugin"));
    }

    public <T> T a(kotlinx.serialization.b<T> r2, T r3) {
        kotlinx.serialization.b<T> r4 = (kotlinx.serialization.b) ZeusTransformUtils.wrapperContextForParams(r2, kotlinx.serialization.b.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r4, "deserializer");
        return (T) a(r4);
    }

    @Override // kotlinx.serialization.b.b
    public <T> T a(f r2, int r3, kotlinx.serialization.b<T> r4, T r5) {
        f r6 = (f) ZeusTransformUtils.wrapperContextForParams(r2, f.class, "com.obric.memorydata.plugin");
        kotlinx.serialization.b<T> r7 = (kotlinx.serialization.b) ZeusTransformUtils.wrapperContextForParams(r4, kotlinx.serialization.b.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r6, "descriptor");
        Intrinsics.checkNotNullParameter(r7, "deserializer");
        return (T) a(r7, r5);
    }

    @Override // kotlinx.serialization.b.b
    public final boolean a(f r2, int r3) {
        Intrinsics.checkNotNullParameter((f) ZeusTransformUtils.wrapperContextForParams(r2, f.class, "com.obric.memorydata.plugin"), "descriptor");
        return d();
    }

    @Override // kotlinx.serialization.b.b
    public final byte b(f r2, int r3) {
        Intrinsics.checkNotNullParameter((f) ZeusTransformUtils.wrapperContextForParams(r2, f.class, "com.obric.memorydata.plugin"), "descriptor");
        return e();
    }

    @Override // kotlinx.serialization.b.c
    public c b(f r3) {
        Intrinsics.checkNotNullParameter((f) ZeusTransformUtils.wrapperContextForParams(r3, f.class, "com.obric.memorydata.plugin"), "descriptor");
        return (c) ZeusTransformUtils.preCheckCast(this, c.class, "com.obric.memorydata.plugin");
    }

    @Override // kotlinx.serialization.b.c
    public boolean b() {
        return true;
    }

    @Override // kotlinx.serialization.b.c
    public Void c() {
        return null;
    }

    @Override // kotlinx.serialization.b.c
    public b c(f r3) {
        Intrinsics.checkNotNullParameter((f) ZeusTransformUtils.wrapperContextForParams(r3, f.class, "com.obric.memorydata.plugin"), "descriptor");
        return (b) ZeusTransformUtils.preCheckCast(this, b.class, "com.obric.memorydata.plugin");
    }

    @Override // kotlinx.serialization.b.b
    public final short c(f r2, int r3) {
        Intrinsics.checkNotNullParameter((f) ZeusTransformUtils.wrapperContextForParams(r2, f.class, "com.obric.memorydata.plugin"), "descriptor");
        return f();
    }

    @Override // kotlinx.serialization.b.b
    public final int d(f r2, int r3) {
        Intrinsics.checkNotNullParameter((f) ZeusTransformUtils.wrapperContextForParams(r2, f.class, "com.obric.memorydata.plugin"), "descriptor");
        return g();
    }

    @Override // kotlinx.serialization.b.b
    public void d(f r2) {
        Intrinsics.checkNotNullParameter((f) ZeusTransformUtils.wrapperContextForParams(r2, f.class, "com.obric.memorydata.plugin"), "descriptor");
    }

    @Override // kotlinx.serialization.b.c
    public boolean d() {
        Object r2 = a();
        Intrinsics.checkNotNull(r2, "null cannot be cast to non-null type kotlin.Boolean");
        return ((Boolean) ZeusTransformUtils.preCheckCast(r2, Boolean.class, "com.obric.memorydata.plugin")).booleanValue();
    }

    @Override // kotlinx.serialization.b.c
    public byte e() {
        Object r2 = a();
        Intrinsics.checkNotNull(r2, "null cannot be cast to non-null type kotlin.Byte");
        return ((Byte) ZeusTransformUtils.preCheckCast(r2, Byte.class, "com.obric.memorydata.plugin")).byteValue();
    }

    @Override // kotlinx.serialization.b.b
    public int e(f r3) {
        return b.C0886b.a(this, (f) ZeusTransformUtils.wrapperContextForParams(r3, f.class, "com.obric.memorydata.plugin"));
    }

    @Override // kotlinx.serialization.b.b
    public final long e(f r2, int r3) {
        Intrinsics.checkNotNullParameter((f) ZeusTransformUtils.wrapperContextForParams(r2, f.class, "com.obric.memorydata.plugin"), "descriptor");
        return h();
    }

    @Override // kotlinx.serialization.b.b
    public final float f(f r2, int r3) {
        Intrinsics.checkNotNullParameter((f) ZeusTransformUtils.wrapperContextForParams(r2, f.class, "com.obric.memorydata.plugin"), "descriptor");
        return i();
    }

    @Override // kotlinx.serialization.b.c
    public short f() {
        Object r2 = a();
        Intrinsics.checkNotNull(r2, "null cannot be cast to non-null type kotlin.Short");
        return ((Short) ZeusTransformUtils.preCheckCast(r2, Short.class, "com.obric.memorydata.plugin")).shortValue();
    }

    @Override // kotlinx.serialization.b.b
    public final double g(f r2, int r3) {
        Intrinsics.checkNotNullParameter((f) ZeusTransformUtils.wrapperContextForParams(r2, f.class, "com.obric.memorydata.plugin"), "descriptor");
        return j();
    }

    @Override // kotlinx.serialization.b.c
    public int g() {
        Object r2 = a();
        Intrinsics.checkNotNull(r2, "null cannot be cast to non-null type kotlin.Int");
        return ((Integer) ZeusTransformUtils.preCheckCast(r2, Integer.class, "com.obric.memorydata.plugin")).intValue();
    }

    @Override // kotlinx.serialization.b.b
    public final char h(f r2, int r3) {
        Intrinsics.checkNotNullParameter((f) ZeusTransformUtils.wrapperContextForParams(r2, f.class, "com.obric.memorydata.plugin"), "descriptor");
        return k();
    }

    @Override // kotlinx.serialization.b.c
    public long h() {
        Object r2 = a();
        Intrinsics.checkNotNull(r2, "null cannot be cast to non-null type kotlin.Long");
        return ((Long) ZeusTransformUtils.preCheckCast(r2, Long.class, "com.obric.memorydata.plugin")).longValue();
    }

    @Override // kotlinx.serialization.b.c
    public float i() {
        Object r2 = a();
        Intrinsics.checkNotNull(r2, "null cannot be cast to non-null type kotlin.Float");
        return ((Float) ZeusTransformUtils.preCheckCast(r2, Float.class, "com.obric.memorydata.plugin")).floatValue();
    }

    @Override // kotlinx.serialization.b.b
    public final String i(f r2, int r3) {
        Intrinsics.checkNotNullParameter((f) ZeusTransformUtils.wrapperContextForParams(r2, f.class, "com.obric.memorydata.plugin"), "descriptor");
        return l();
    }

    @Override // kotlinx.serialization.b.c
    public double j() {
        Object r2 = a();
        Intrinsics.checkNotNull(r2, "null cannot be cast to non-null type kotlin.Double");
        return ((Double) ZeusTransformUtils.preCheckCast(r2, Double.class, "com.obric.memorydata.plugin")).doubleValue();
    }

    @Override // kotlinx.serialization.b.b
    public c j(f r3, int r4) {
        f r5 = (f) ZeusTransformUtils.wrapperContextForParams(r3, f.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r5, "descriptor");
        return b(r5.b(r4));
    }

    @Override // kotlinx.serialization.b.c
    public char k() {
        Object r2 = a();
        Intrinsics.checkNotNull(r2, "null cannot be cast to non-null type kotlin.Char");
        return ((Character) ZeusTransformUtils.preCheckCast(r2, Character.class, "com.obric.memorydata.plugin")).charValue();
    }

    @Override // kotlinx.serialization.b.c
    public String l() {
        Object r2 = a();
        Intrinsics.checkNotNull(r2, "null cannot be cast to non-null type kotlin.String");
        return (String) ZeusTransformUtils.preCheckCast(r2, String.class, "com.obric.memorydata.plugin");
    }

    @Override // kotlinx.serialization.b.b
    public boolean m() {
        return b.C0886b.a(this);
    }
}
