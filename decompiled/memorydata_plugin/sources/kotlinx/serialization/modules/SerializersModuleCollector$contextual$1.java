package kotlinx.serialization.modules;

import androidx.exifinterface.media.ExifInterface;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000\u0014\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010 \n\u0000\u0010\u0000\u001a\u0006\u0012\u0002\b\u00030\u0001\"\b\b\u0000\u0010\u0002*\u00020\u00032\u0010\u0010\u0004\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00010\u0005H\n¢\u0006\u0002\b\u0006"}, d2 = {"<anonymous>", "Lkotlinx/serialization/KSerializer;", ExifInterface.GPS_DIRECTION_TRUE, "", "it", "", "invoke"}, k = 3, mv = {1, 7, 1}, xi = 48)
final class SerializersModuleCollector$contextual$1 extends Lambda implements Function1<List<? extends kotlinx.serialization.c<?>>, kotlinx.serialization.c<?>> {
    final /* synthetic */ kotlinx.serialization.c<T> $serializer;

    SerializersModuleCollector$contextual$1(kotlinx.serialization.c<T> r3) {
        this.$serializer = (kotlinx.serialization.c) ZeusTransformUtils.wrapperContextForParams(r3, kotlinx.serialization.c.class, "com.obric.memorydata.plugin");
        super(1);
    }

    @Override // kotlin.jvm.functions.Function1
    public /* synthetic */ kotlinx.serialization.c<?> invoke(List<? extends kotlinx.serialization.c<?>> r3) {
        return invoke2((List) ZeusTransformUtils.preCheckCast(r3, List.class, "com.obric.memorydata.plugin"));
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final kotlinx.serialization.c<?> invoke2(List<? extends kotlinx.serialization.c<?>> r3) {
        Intrinsics.checkNotNullParameter((List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.memorydata.plugin"), "it");
        return this.$serializer;
    }
}
