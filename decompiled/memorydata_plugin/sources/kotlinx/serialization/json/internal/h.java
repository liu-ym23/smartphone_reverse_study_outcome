package kotlinx.serialization.json.internal;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import kotlin.KotlinNothingValueException;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.UStringsKt;

/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0005\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0010\n\n\u0000\b\u0000\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\b\u0010\u000b\u001a\u00020\fH\u0016J\u0010\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u0010H\u0016J\b\u0010\u0011\u001a\u00020\u000eH\u0016J\b\u0010\u0012\u001a\u00020\u0013H\u0016J\b\u0010\u0014\u001a\u00020\u0015H\u0016R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0007\u001a\u00020\bX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n¨\u0006\u0016"}, d2 = {"Lkotlinx/serialization/json/internal/JsonDecoderForUnsignedTypes;", "Lkotlinx/serialization/encoding/AbstractDecoder;", "lexer", "Lkotlinx/serialization/json/internal/AbstractJsonLexer;", "json", "Lkotlinx/serialization/json/Json;", "(Lkotlinx/serialization/json/internal/AbstractJsonLexer;Lkotlinx/serialization/json/Json;)V", "serializersModule", "Lkotlinx/serialization/modules/SerializersModule;", "getSerializersModule", "()Lkotlinx/serialization/modules/SerializersModule;", "decodeByte", "", "decodeElementIndex", "", "descriptor", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "decodeInt", "decodeLong", "", "decodeShort", "", "kotlinx-serialization-json"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class h extends kotlinx.serialization.b.a {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final a f17843b;
    private final kotlinx.serialization.modules.d c;

    public h(a r2, kotlinx.serialization.json.a r3) {
        Intrinsics.checkNotNullParameter(r2, "lexer");
        Intrinsics.checkNotNullParameter(r3, "json");
        this.f17843b = r2;
        this.c = r3.b();
    }

    @Override // kotlinx.serialization.b.a, kotlinx.serialization.b.c
    public byte e() {
        a r0 = this.f17843b;
        String r6 = r0.i();
        return UStringsKt.toUByte(r6);
    L5:
        a.a(r0, "Failed to parse type 'UByte' for input '" + r6 + '\'', 0, null, 6, null);
        throw new KotlinNothingValueException();
    }

    @Override // kotlinx.serialization.b.b
    public int f(kotlinx.serialization.descriptors.f r2) {
        Intrinsics.checkNotNullParameter((kotlinx.serialization.descriptors.f) ZeusTransformUtils.wrapperContextForParams(r2, kotlinx.serialization.descriptors.f.class, "com.obric.memorydata.plugin"), "descriptor");
        throw new IllegalStateException("unsupported".toString());
    }

    @Override // kotlinx.serialization.b.a, kotlinx.serialization.b.c
    public short f() {
        a r0 = this.f17843b;
        String r6 = r0.i();
        return UStringsKt.toUShort(r6);
    L5:
        a.a(r0, "Failed to parse type 'UShort' for input '" + r6 + '\'', 0, null, 6, null);
        throw new KotlinNothingValueException();
    }

    @Override // kotlinx.serialization.b.a, kotlinx.serialization.b.c
    public int g() {
        a r0 = this.f17843b;
        String r6 = r0.i();
        return UStringsKt.toUInt(r6);
    L5:
        a.a(r0, "Failed to parse type 'UInt' for input '" + r6 + '\'', 0, null, 6, null);
        throw new KotlinNothingValueException();
    }

    @Override // kotlinx.serialization.b.a, kotlinx.serialization.b.c
    public long h() {
        a r0 = this.f17843b;
        String r6 = r0.i();
        return UStringsKt.toULong(r6);
    L5:
        a.a(r0, "Failed to parse type 'ULong' for input '" + r6 + '\'', 0, null, 6, null);
        throw new KotlinNothingValueException();
    }

    @Override // kotlinx.serialization.b.b, kotlinx.serialization.b.c
    public kotlinx.serialization.modules.d n() {
        return this.c;
    }
}
