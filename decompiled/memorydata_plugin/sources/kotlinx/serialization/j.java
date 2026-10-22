package kotlinx.serialization;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.List;
import kotlin.Metadata;
import kotlin.reflect.KClass;
import kotlin.reflect.KType;

/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"kotlinx/serialization/SerializersKt__SerializersJvmKt", "kotlinx/serialization/SerializersKt__SerializersKt"}, k = 4, mv = {1, 7, 1}, xi = 48)
public final class j {
    public static final List<c<Object>> a(kotlinx.serialization.modules.d r2, List<? extends KType> r3, boolean r4) {
        return k.a(r2, (List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.memorydata.plugin"), r4);
    }

    public static final <T> c<T> a(KClass<T> r2) {
        return k.a((KClass) ZeusTransformUtils.wrapperContextForParams(r2, KClass.class, "com.obric.memorydata.plugin"));
    }

    public static final c<? extends Object> a(KClass<Object> r2, List<? extends KType> r3, List<? extends c<Object>> r4) {
        return k.a((KClass) ZeusTransformUtils.wrapperContextForParams(r2, KClass.class, "com.obric.memorydata.plugin"), (List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.memorydata.plugin"), (List) ZeusTransformUtils.wrapperContextForParams(r4, List.class, "com.obric.memorydata.plugin"));
    }

    public static final c<Object> a(kotlinx.serialization.modules.d r2, KType r3) {
        return k.a(r2, (KType) ZeusTransformUtils.wrapperContextForParams(r3, KType.class, "com.obric.memorydata.plugin"));
    }

    public static final c<Object> b(kotlinx.serialization.modules.d r2, KType r3) {
        return k.b(r2, (KType) ZeusTransformUtils.wrapperContextForParams(r3, KType.class, "com.obric.memorydata.plugin"));
    }
}
