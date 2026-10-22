package kotlinx.serialization.descriptors;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n¢\u0006\u0002\b\u0003"}, d2 = {"<anonymous>", "", "Lkotlinx/serialization/descriptors/ClassSerialDescriptorBuilder;", "invoke"}, k = 3, mv = {1, 7, 1}, xi = 48)
final class SerialDescriptorsKt$buildClassSerialDescriptor$1 extends Lambda implements Function1<a, Unit> {
    public static final SerialDescriptorsKt$buildClassSerialDescriptor$1 INSTANCE = null;

    static {
        INSTANCE = new SerialDescriptorsKt$buildClassSerialDescriptor$1();
    }

    SerialDescriptorsKt$buildClassSerialDescriptor$1() {
        super(1);
    }

    @Override // kotlin.jvm.functions.Function1
    public /* synthetic */ Unit invoke(a r3) {
        invoke2((a) ZeusTransformUtils.preCheckCast(r3, a.class, "com.obric.memorydata.plugin"));
        return Unit.INSTANCE;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(a r1) {
        Intrinsics.checkNotNullParameter(r1, "$this$null");
    }
}
