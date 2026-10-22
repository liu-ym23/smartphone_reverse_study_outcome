package kotlinx.serialization.modules;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: Add missing generic type declarations: [Base] */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001\"\b\b\u0000\u0010\u0002*\u00020\u0003*\b\u0012\u0004\u0012\u0002H\u00020\u0004H\n¢\u0006\u0002\b\u0005"}, d2 = {"<anonymous>", "", "Base", "", "Lkotlinx/serialization/modules/PolymorphicModuleBuilder;", "invoke"}, k = 3, mv = {1, 7, 1}, xi = 176)
public final class SerializersModuleBuildersKt$polymorphic$1<Base> extends Lambda implements Function1<b<? super Base>, Unit> {
    public static final SerializersModuleBuildersKt$polymorphic$1 INSTANCE = null;

    static {
        INSTANCE = new SerializersModuleBuildersKt$polymorphic$1();
    }

    public SerializersModuleBuildersKt$polymorphic$1() {
        super(1);
    }

    @Override // kotlin.jvm.functions.Function1
    public /* synthetic */ Unit invoke(Object r3) {
        invoke((b) ZeusTransformUtils.preCheckCast(r3, b.class, "com.obric.memorydata.plugin"));
        return Unit.INSTANCE;
    }

    public final void invoke(b<? super Base> r1) {
        Intrinsics.checkNotNullParameter(r1, "$this$null");
    }
}
