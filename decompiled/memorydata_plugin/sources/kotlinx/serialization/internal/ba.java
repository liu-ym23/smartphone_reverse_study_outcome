package kotlinx.serialization.internal;

import com.bytedance.crash.entity.EventBody;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\bÁ\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0003J\u0015\u0010\b\u001a\u00020\u00022\u0006\u0010\t\u001a\u00020\nH\u0016¢\u0006\u0002\u0010\u000bJ\u0018\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u0002H\u0016R\u0014\u0010\u0004\u001a\u00020\u0005X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0011"}, d2 = {"Lkotlinx/serialization/internal/LongSerializer;", "Lkotlinx/serialization/KSerializer;", "", "()V", "descriptor", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "getDescriptor", "()Lkotlinx/serialization/descriptors/SerialDescriptor;", "deserialize", "decoder", "Lkotlinx/serialization/encoding/Decoder;", "(Lkotlinx/serialization/encoding/Decoder;)Ljava/lang/Long;", "serialize", "", "encoder", "Lkotlinx/serialization/encoding/Encoder;", EventBody.KEY_VALUE, "kotlinx-serialization-core"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class ba implements kotlinx.serialization.c<Long> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final ba f17732a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final kotlinx.serialization.descriptors.f f17733b = null;

    static {
        f17732a = new ba();
        f17733b = (kotlinx.serialization.descriptors.f) ZeusTransformUtils.preCheckCast(new bt("kotlin.Long", (kotlinx.serialization.descriptors.e) ZeusTransformUtils.preCheckCast(kotlinx.serialization.descriptors.e.g.f17678a, kotlinx.serialization.descriptors.e.class, "com.obric.memorydata.plugin")), kotlinx.serialization.descriptors.f.class, "com.obric.memorydata.plugin");
    }

    private ba() {
    }

    @Override // kotlinx.serialization.b
    public /* synthetic */ Object a(kotlinx.serialization.b.c r3) {
        return b((kotlinx.serialization.b.c) ZeusTransformUtils.wrapperContextForParams(r3, kotlinx.serialization.b.c.class, "com.obric.memorydata.plugin"));
    }

    @Override // kotlinx.serialization.c, kotlinx.serialization.b
    public kotlinx.serialization.descriptors.f a() {
        return f17733b;
    }

    public Long b(kotlinx.serialization.b.c r2) {
        kotlinx.serialization.b.c r1 = (kotlinx.serialization.b.c) ZeusTransformUtils.wrapperContextForParams(r2, kotlinx.serialization.b.c.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r1, "decoder");
        return Long.valueOf(r1.h());
    }
}
