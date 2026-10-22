package kotlinx.serialization.descriptors;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0004\u001a\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lkotlinx/serialization/descriptors/a;", "", "invoke", "(Lkotlinx/serialization/descriptors/a;)V", "<anonymous>"}, k = 3, mv = {1, 9, 0})
final class SerialDescriptorsKt$buildClassSerialDescriptor$1 extends Lambda implements Function1<a, Unit> {
    public static final SerialDescriptorsKt$buildClassSerialDescriptor$1 INSTANCE = null;

    static {
        INSTANCE = new SerialDescriptorsKt$buildClassSerialDescriptor$1();
    }

    public SerialDescriptorsKt$buildClassSerialDescriptor$1() {
        super(1);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(a r5) {
        Intrinsics.checkNotNullParameter(r5, "$this$null");
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(a r5) {
        invoke2(r5);
        return Unit.INSTANCE;
    }
}
