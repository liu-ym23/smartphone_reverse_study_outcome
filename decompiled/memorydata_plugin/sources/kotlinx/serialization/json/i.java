package kotlinx.serialization.json;

import com.bytedance.crash.entity.EventBody;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\bÁ\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0003J\u0010\u0010\b\u001a\u00020\u00022\u0006\u0010\t\u001a\u00020\nH\u0016J\u0018\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u0002H\u0016R\u0014\u0010\u0004\u001a\u00020\u0005X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0010"}, d2 = {"Lkotlinx/serialization/json/JsonElementSerializer;", "Lkotlinx/serialization/KSerializer;", "Lkotlinx/serialization/json/JsonElement;", "()V", "descriptor", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "getDescriptor", "()Lkotlinx/serialization/descriptors/SerialDescriptor;", "deserialize", "decoder", "Lkotlinx/serialization/encoding/Decoder;", "serialize", "", "encoder", "Lkotlinx/serialization/encoding/Encoder;", EventBody.KEY_VALUE, "kotlinx-serialization-json"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class i implements kotlinx.serialization.c<g> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final i f17835a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final kotlinx.serialization.descriptors.f f17836b = null;

    static {
        f17835a = new i();
        f17836b = kotlinx.serialization.descriptors.i.a("kotlinx.serialization.json.JsonElement", (kotlinx.serialization.descriptors.j) ZeusTransformUtils.preCheckCast(kotlinx.serialization.descriptors.d.b.f17671a, kotlinx.serialization.descriptors.j.class, "com.obric.memorydata.plugin"), new kotlinx.serialization.descriptors.f[0], (Function1) ZeusTransformUtils.preCheckCast(JsonElementSerializer$descriptor$1.INSTANCE, Function1.class, "com.obric.memorydata.plugin"));
    }

    private i() {
    }

    @Override // kotlinx.serialization.b
    public /* synthetic */ Object a(kotlinx.serialization.b.c r3) {
        return b((kotlinx.serialization.b.c) ZeusTransformUtils.wrapperContextForParams(r3, kotlinx.serialization.b.c.class, "com.obric.memorydata.plugin"));
    }

    @Override // kotlinx.serialization.c, kotlinx.serialization.b
    public kotlinx.serialization.descriptors.f a() {
        return f17836b;
    }

    public g b(kotlinx.serialization.b.c r2) {
        kotlinx.serialization.b.c r1 = (kotlinx.serialization.b.c) ZeusTransformUtils.wrapperContextForParams(r2, kotlinx.serialization.b.c.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r1, "decoder");
        return j.a(r1).o();
    }
}
