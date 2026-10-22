package kotlinx.serialization.internal;

import com.bytedance.crash.entity.EventBody;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÁ\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0003J\u0011\u0010\b\u001a\u00020\u00022\u0006\u0010\t\u001a\u00020\nH\u0096\u0001J\u001e\u0010\u000b\u001a\u00020\u00022\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u0002H\u0096\u0001¢\u0006\u0002\u0010\u000fR\u0012\u0010\u0004\u001a\u00020\u0005X\u0096\u0005¢\u0006\u0006\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0010"}, d2 = {"Lkotlinx/serialization/internal/UnitSerializer;", "Lkotlinx/serialization/KSerializer;", "", "()V", "descriptor", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "getDescriptor", "()Lkotlinx/serialization/descriptors/SerialDescriptor;", "deserialize", "decoder", "Lkotlinx/serialization/encoding/Decoder;", "serialize", "encoder", "Lkotlinx/serialization/encoding/Encoder;", EventBody.KEY_VALUE, "(Lkotlinx/serialization/encoding/Encoder;Lkotlin/Unit;)V", "kotlinx-serialization-core"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class cs implements kotlinx.serialization.c<Unit> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final cs f17792a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final /* synthetic */ bh<Unit> f17793b;

    static {
        f17792a = new cs();
    }

    private cs() {
        this.f17793b = new bh("kotlin.Unit", Unit.INSTANCE);
    }

    @Override // kotlinx.serialization.b
    public /* synthetic */ Object a(kotlinx.serialization.b.c r3) {
        b((kotlinx.serialization.b.c) ZeusTransformUtils.wrapperContextForParams(r3, kotlinx.serialization.b.c.class, "com.obric.memorydata.plugin"));
        return Unit.INSTANCE;
    }

    @Override // kotlinx.serialization.c, kotlinx.serialization.b
    public kotlinx.serialization.descriptors.f a() {
        return this.f17793b.a();
    }

    public void b(kotlinx.serialization.b.c r3) {
        kotlinx.serialization.b.c r4 = (kotlinx.serialization.b.c) ZeusTransformUtils.wrapperContextForParams(r3, kotlinx.serialization.b.c.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r4, "decoder");
        this.f17793b.a(r4);
    }
}
