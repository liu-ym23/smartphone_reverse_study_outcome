package kotlinx.serialization.internal;

import androidx.exifinterface.media.ExifInterface;
import com.bytedance.crash.entity.EventBody;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlin.reflect.KClass;
import kotlinx.serialization.SerializationException;

/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\b'\u0018\u0000*\b\b\u0000\u0010\u0001*\u00020\u00022\b\u0012\u0004\u0012\u0002H\u00010\u0003B\u0007\b\u0000¢\u0006\u0002\u0010\u0004J\u0015\u0010\t\u001a\u00028\u00002\u0006\u0010\n\u001a\u00020\u000bH\u0002¢\u0006\u0002\u0010\fJ\u0013\u0010\r\u001a\u00028\u00002\u0006\u0010\u000e\u001a\u00020\u000f¢\u0006\u0002\u0010\u0010J$\u0010\u0011\u001a\f\u0012\u0006\b\u0001\u0012\u00028\u0000\u0018\u00010\u00122\u0006\u0010\u000e\u001a\u00020\u000b2\b\u0010\u0013\u001a\u0004\u0018\u00010\u0014H\u0017J%\u0010\u0011\u001a\n\u0012\u0004\u0012\u00028\u0000\u0018\u00010\u00152\u0006\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00028\u0000H\u0017¢\u0006\u0002\u0010\u0019J\u001b\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00028\u0000¢\u0006\u0002\u0010\u001cR\u0018\u0010\u0005\u001a\b\u0012\u0004\u0012\u00028\u00000\u0006X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0007\u0010\b¨\u0006\u001d"}, d2 = {"Lkotlinx/serialization/internal/AbstractPolymorphicSerializer;", ExifInterface.GPS_DIRECTION_TRUE, "", "Lkotlinx/serialization/KSerializer;", "()V", "baseClass", "Lkotlin/reflect/KClass;", "getBaseClass", "()Lkotlin/reflect/KClass;", "decodeSequentially", "compositeDecoder", "Lkotlinx/serialization/encoding/CompositeDecoder;", "(Lkotlinx/serialization/encoding/CompositeDecoder;)Ljava/lang/Object;", "deserialize", "decoder", "Lkotlinx/serialization/encoding/Decoder;", "(Lkotlinx/serialization/encoding/Decoder;)Ljava/lang/Object;", "findPolymorphicSerializerOrNull", "Lkotlinx/serialization/DeserializationStrategy;", "klassName", "", "Lkotlinx/serialization/SerializationStrategy;", "encoder", "Lkotlinx/serialization/encoding/Encoder;", EventBody.KEY_VALUE, "(Lkotlinx/serialization/encoding/Encoder;Ljava/lang/Object;)Lkotlinx/serialization/SerializationStrategy;", "serialize", "", "(Lkotlinx/serialization/encoding/Encoder;Ljava/lang/Object;)V", "kotlinx-serialization-core"}, k = 1, mv = {1, 7, 1}, xi = 48)
public abstract class b<T> implements kotlinx.serialization.c<T> {
    public b() {
    }

    private final T a(kotlinx.serialization.b.b r8) {
        kotlinx.serialization.b.b r0 = (kotlinx.serialization.b.b) ZeusTransformUtils.wrapperContextForParams(r8, kotlinx.serialization.b.b.class, "com.obric.memorydata.plugin");
        kotlinx.serialization.b r3 = kotlinx.serialization.f.a(this, r0, r0.i(a(), 0));
        return (T) kotlinx.serialization.b.b.C0886b.a(r0, a(), 1, r3, null, 8, null);
    }

    public static final /* synthetic */ Object a(b r2, kotlinx.serialization.b.b r3) {
        return r2.a((kotlinx.serialization.b.b) ZeusTransformUtils.wrapperContextForParams(r3, kotlinx.serialization.b.b.class, "com.obric.memorydata.plugin"));
    }

    @Override // kotlinx.serialization.b
    public final T a(kotlinx.serialization.b.c r11) {
        kotlinx.serialization.b.c r12 = (kotlinx.serialization.b.c) ZeusTransformUtils.wrapperContextForParams(r11, kotlinx.serialization.b.c.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r12, "decoder");
        kotlinx.serialization.descriptors.f r0 = a();
        kotlinx.serialization.b.b r13 = r12.c(r0);
        Ref.ObjectRef r9 = new Ref.ObjectRef();
        if (r13.m() == false) goto L5;
        T r10 = (T) a(this, r13);
    L24:
        r13.d(r0);
        return r10;
    L5:
        Object r2 = null;
    L6:
        int r4 = r13.f(a());
        if (r4 == (-1)) goto L22;
        if (r4 != 0) goto L10;
        r9.element = (T) r13.i(a(), r4);
        goto L6
    L10:
        if (r4 != 1) goto L11;
        T r3 = r9.element;
        if (r3 == null) goto L20;
        r9.element = r3;
        r2 = kotlinx.serialization.b.b.C0886b.a(r13, a(), r4, kotlinx.serialization.f.a(this, r13, (String) ZeusTransformUtils.preCheckCast(r9.element, String.class, "com.obric.memorydata.plugin")), null, 8, null);
        goto L6
    L20:
        throw new IllegalArgumentException("Cannot read polymorphic value before its type token".toString());
    L11:
        StringBuilder r14 = new StringBuilder().append("Invalid index in polymorphic deserialization of ");
        String r1 = (String) ZeusTransformUtils.preCheckCast(r9.element, String.class, "com.obric.memorydata.plugin");
        if (r1 != null) goto L15;
        r1 = "unknown class";
    L15:
        throw new SerializationException(r14.append(r1).append("\n Expected 0, 1 or DECODE_DONE(-1), but found ").append(r4).toString());
    L22:
        if (r2 == null) goto L27;
        Intrinsics.checkNotNull(r2, "null cannot be cast to non-null type T of kotlinx.serialization.internal.AbstractPolymorphicSerializer.deserialize$lambda$3");
        r10 = (T) r2;
        goto L24
    L27:
        throw new IllegalArgumentException(("Polymorphic value has not been read for class " + ((String) ZeusTransformUtils.preCheckCast(r9.element, String.class, "com.obric.memorydata.plugin"))).toString());
    }

    public kotlinx.serialization.b<? extends T> a(kotlinx.serialization.b.b r3, String r4) {
        kotlinx.serialization.b.b r5 = (kotlinx.serialization.b.b) ZeusTransformUtils.wrapperContextForParams(r3, kotlinx.serialization.b.b.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r5, "decoder");
        return r5.n().a(b(), r4);
    }

    public abstract KClass<T> b();
}
