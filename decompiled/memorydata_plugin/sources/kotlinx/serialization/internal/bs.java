package kotlinx.serialization.internal;

import com.bytedance.crash.entity.EventBody;
import com.obric.aikernel.sdk.ext.Params;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.serialization.internal.bq;

/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000Z\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010(\n\u0002\b\u0007\b!\u0018\u0000*\u0004\b\u0000\u0010\u0001*\u0004\b\u0001\u0010\u0002*\u000e\b\u0002\u0010\u0003*\b\u0012\u0004\u0012\u0002H\u00020\u00042\u0014\u0012\u0004\u0012\u0002H\u0001\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u00030\u0005B\u0015\b\u0000\u0012\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00028\u00000\u0007¢\u0006\u0002\u0010\bJ\r\u0010\r\u001a\u00028\u0002H\u0004¢\u0006\u0002\u0010\u000eJ\u0013\u0010\u000f\u001a\u00028\u00012\u0006\u0010\u0010\u001a\u00020\u0011¢\u0006\u0002\u0010\u0012J\r\u0010\u0013\u001a\u00028\u0001H$¢\u0006\u0002\u0010\u0014J-\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0010\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u00192\u0006\u0010\r\u001a\u00028\u00022\u0006\u0010\u001a\u001a\u00020\u001bH$¢\u0006\u0002\u0010\u001cJ\u001b\u0010\u001d\u001a\u00020\u00162\u0006\u0010\u001e\u001a\u00020\u001f2\u0006\u0010 \u001a\u00028\u0001¢\u0006\u0002\u0010!J%\u0010\"\u001a\u00020\u00162\u0006\u0010\u001e\u001a\u00020#2\u0006\u0010$\u001a\u00028\u00012\u0006\u0010%\u001a\u00020\u0019H$¢\u0006\u0002\u0010&J\u0011\u0010'\u001a\u00020\u0019*\u00028\u0002H\u0004¢\u0006\u0002\u0010(J\u0019\u0010)\u001a\u00020\u0016*\u00028\u00022\u0006\u0010%\u001a\u00020\u0019H\u0004¢\u0006\u0002\u0010*J\u0017\u0010+\u001a\b\u0012\u0004\u0012\u00028\u00000,*\u00028\u0001H\u0004¢\u0006\u0002\u0010-J!\u0010.\u001a\u00020\u0016*\u00028\u00022\u0006\u0010\u0018\u001a\u00020\u00192\u0006\u0010/\u001a\u00028\u0000H\u0004¢\u0006\u0002\u00100J\u0011\u00101\u001a\u00028\u0001*\u00028\u0002H\u0004¢\u0006\u0002\u00102R\u0011\u0010\t\u001a\u00020\n¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\f¨\u00063"}, d2 = {"Lkotlinx/serialization/internal/PrimitiveArraySerializer;", "Element", "Array", "Builder", "Lkotlinx/serialization/internal/PrimitiveArrayBuilder;", "Lkotlinx/serialization/internal/CollectionLikeSerializer;", "primitiveSerializer", "Lkotlinx/serialization/KSerializer;", "(Lkotlinx/serialization/KSerializer;)V", "descriptor", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "getDescriptor", "()Lkotlinx/serialization/descriptors/SerialDescriptor;", "builder", "()Lkotlinx/serialization/internal/PrimitiveArrayBuilder;", "deserialize", "decoder", "Lkotlinx/serialization/encoding/Decoder;", "(Lkotlinx/serialization/encoding/Decoder;)Ljava/lang/Object;", "empty", "()Ljava/lang/Object;", "readElement", "", "Lkotlinx/serialization/encoding/CompositeDecoder;", "index", "", "checkIndex", "", "(Lkotlinx/serialization/encoding/CompositeDecoder;ILkotlinx/serialization/internal/PrimitiveArrayBuilder;Z)V", "serialize", "encoder", "Lkotlinx/serialization/encoding/Encoder;", EventBody.KEY_VALUE, "(Lkotlinx/serialization/encoding/Encoder;Ljava/lang/Object;)V", "writeContent", "Lkotlinx/serialization/encoding/CompositeEncoder;", Params.CONTENT, "size", "(Lkotlinx/serialization/encoding/CompositeEncoder;Ljava/lang/Object;I)V", "builderSize", "(Lkotlinx/serialization/internal/PrimitiveArrayBuilder;)I", "checkCapacity", "(Lkotlinx/serialization/internal/PrimitiveArrayBuilder;I)V", "collectionIterator", "", "(Ljava/lang/Object;)Ljava/util/Iterator;", "insert", "element", "(Lkotlinx/serialization/internal/PrimitiveArrayBuilder;ILjava/lang/Object;)V", "toResult", "(Lkotlinx/serialization/internal/PrimitiveArrayBuilder;)Ljava/lang/Object;", "kotlinx-serialization-core"}, k = 1, mv = {1, 7, 1}, xi = 48)
public abstract class bs<Element, Array, Builder extends bq<Array>> extends u<Element, Array, Builder> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final kotlinx.serialization.descriptors.f f17752a;

    public bs(kotlinx.serialization.c<Element> r3) {
        kotlinx.serialization.c r4 = (kotlinx.serialization.c) ZeusTransformUtils.wrapperContextForParams(r3, kotlinx.serialization.c.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r4, "primitiveSerializer");
        super(r4, null);
        this.f17752a = (kotlinx.serialization.descriptors.f) ZeusTransformUtils.preCheckCast(new br(r4.a()), kotlinx.serialization.descriptors.f.class, "com.obric.memorydata.plugin");
    }

    @Override // kotlinx.serialization.internal.a
    public /* synthetic */ int a(Object r3) {
        return a((bq) ZeusTransformUtils.preCheckCast(r3, bq.class, "com.obric.memorydata.plugin"));
    }

    public final int a(Builder r1) {
        Intrinsics.checkNotNullParameter(r1, "<this>");
        return r1.a();
    }

    @Override // kotlinx.serialization.internal.a, kotlinx.serialization.b
    public final Array a(kotlinx.serialization.b.c r3) {
        kotlinx.serialization.b.c r4 = (kotlinx.serialization.b.c) ZeusTransformUtils.wrapperContextForParams(r3, kotlinx.serialization.b.c.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r4, "decoder");
        return a(r4, null);
    }

    @Override // kotlinx.serialization.internal.u, kotlinx.serialization.c, kotlinx.serialization.b
    public final kotlinx.serialization.descriptors.f a() {
        return this.f17752a;
    }

    @Override // kotlinx.serialization.internal.a
    public /* synthetic */ void a(Object r3, int r4) {
        a((bq) ZeusTransformUtils.preCheckCast(r3, bq.class, "com.obric.memorydata.plugin"), r4);
    }

    public final void a(Builder r1, int r2) {
        Intrinsics.checkNotNullParameter(r1, "<this>");
        r1.a(r2);
    }

    @Override // kotlinx.serialization.internal.a
    public /* synthetic */ Object b() {
        return e();
    }

    @Override // kotlinx.serialization.internal.a
    public /* synthetic */ Object b(Object r3) {
        return b((bq) ZeusTransformUtils.preCheckCast(r3, bq.class, "com.obric.memorydata.plugin"));
    }

    public final Array b(Builder r1) {
        Intrinsics.checkNotNullParameter(r1, "<this>");
        return (Array) r1.c();
    }

    public abstract Array d();

    public final Builder e() {
        return (Builder) ZeusTransformUtils.preCheckCast(c(d()), bq.class, "com.obric.memorydata.plugin");
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // kotlinx.serialization.internal.u
    public /* synthetic */ void insert(Object r3, int r4, Object r5) {
        insert((bq) ZeusTransformUtils.preCheckCast(r3, bq.class, "com.obric.memorydata.plugin"), r4, r5);
    }

    public final void insert(Builder r1, int r2, Element r3) {
        Intrinsics.checkNotNullParameter(r1, "<this>");
        throw new IllegalStateException("This method lead to boxing and must not be used, use Builder.append instead".toString());
    }
}
