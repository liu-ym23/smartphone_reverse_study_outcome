package kotlinx.serialization.json.internal;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import kotlin.Metadata;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes6.dex */
@Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
/* synthetic */ class JsonElementMarker$origin$1 extends FunctionReferenceImpl implements Function2<kotlinx.serialization.descriptors.f, Integer, Boolean> {
    JsonElementMarker$origin$1(Object r8) {
        super(2, r8, i.class, "readIfAbsent", "readIfAbsent(Lkotlinx/serialization/descriptors/SerialDescriptor;I)Z", 0);
    }

    public final Boolean invoke(kotlinx.serialization.descriptors.f r3, int r4) {
        kotlinx.serialization.descriptors.f r5 = (kotlinx.serialization.descriptors.f) ZeusTransformUtils.wrapperContextForParams(r3, kotlinx.serialization.descriptors.f.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r5, "p0");
        return Boolean.valueOf(i.a((i) ZeusTransformUtils.preCheckCast(this.receiver, i.class, "com.obric.memorydata.plugin"), r5, r4));
    }

    @Override // kotlin.jvm.functions.Function2
    public /* synthetic */ Boolean invoke(kotlinx.serialization.descriptors.f r3, Integer r4) {
        return invoke((kotlinx.serialization.descriptors.f) ZeusTransformUtils.preCheckCast(r3, kotlinx.serialization.descriptors.f.class, "com.obric.memorydata.plugin"), ((Number) ZeusTransformUtils.preCheckCast(r4, Number.class, "com.obric.memorydata.plugin")).intValue());
    }
}
