package kotlinx.serialization;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.KClass;
import kotlin.reflect.KType;
import kotlinx.serialization.internal.bk;
import kotlinx.serialization.internal.bx;
import kotlinx.serialization.internal.o;

/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000:\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\u001a(\u0010\f\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0002\u0018\u00010\r2\f\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u0011H\u0000\u001aD\u0010\u0012\u001a\u0012\u0012\u000e\u0012\f\u0012\u0006\u0012\u0004\u0018\u00010\u0002\u0018\u00010\r0\u00132\f\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00020\u000f2\f\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00160\u00152\u0006\u0010\u0010\u001a\u00020\u0011H\u0000ø\u0001\u0000¢\u0006\u0002\u0010\u0017\"\u001e\u0010\u0000\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00020\u00018\u0002X\u0083\u0004¢\u0006\b\n\u0000\u0012\u0004\b\u0003\u0010\u0004\"\u001e\u0010\u0005\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u00018\u0002X\u0083\u0004¢\u0006\b\n\u0000\u0012\u0004\b\u0006\u0010\u0004\"\u001e\u0010\u0007\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00020\b8\u0002X\u0083\u0004¢\u0006\b\n\u0000\u0012\u0004\b\t\u0010\u0004\"\u001e\u0010\n\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\b8\u0002X\u0083\u0004¢\u0006\b\n\u0000\u0012\u0004\b\u000b\u0010\u0004\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006\u0018"}, d2 = {"PARAMETRIZED_SERIALIZERS_CACHE", "Lkotlinx/serialization/internal/ParametrizedSerializerCache;", "", "getPARAMETRIZED_SERIALIZERS_CACHE$annotations", "()V", "PARAMETRIZED_SERIALIZERS_CACHE_NULLABLE", "getPARAMETRIZED_SERIALIZERS_CACHE_NULLABLE$annotations", "SERIALIZERS_CACHE", "Lkotlinx/serialization/internal/SerializerCache;", "getSERIALIZERS_CACHE$annotations", "SERIALIZERS_CACHE_NULLABLE", "getSERIALIZERS_CACHE_NULLABLE$annotations", "findCachedSerializer", "Lkotlinx/serialization/KSerializer;", "clazz", "Lkotlin/reflect/KClass;", "isNullable", "", "findParametrizedCachedSerializer", "Lkotlin/Result;", "types", "", "Lkotlin/reflect/KType;", "(Lkotlin/reflect/KClass;Ljava/util/List;Z)Ljava/lang/Object;", "kotlinx-serialization-core"}, k = 2, mv = {1, 7, 1}, xi = 48)
public final class i {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final bx<? extends Object> f17699a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final bx<Object> f17700b = null;
    private static final bk<? extends Object> c = null;
    private static final bk<Object> d = null;

    static {
        f17699a = o.a((Function1) ZeusTransformUtils.preCheckCast(SerializersCacheKt$SERIALIZERS_CACHE$1.INSTANCE, Function1.class, "com.obric.memorydata.plugin"));
        f17700b = o.a((Function1) ZeusTransformUtils.preCheckCast(SerializersCacheKt$SERIALIZERS_CACHE_NULLABLE$1.INSTANCE, Function1.class, "com.obric.memorydata.plugin"));
        c = o.a((Function2) ZeusTransformUtils.preCheckCast(SerializersCacheKt$PARAMETRIZED_SERIALIZERS_CACHE$1.INSTANCE, Function2.class, "com.obric.memorydata.plugin"));
        d = o.a((Function2) ZeusTransformUtils.preCheckCast(SerializersCacheKt$PARAMETRIZED_SERIALIZERS_CACHE_NULLABLE$1.INSTANCE, Function2.class, "com.obric.memorydata.plugin"));
    }

    public static final Object a(KClass<Object> r2, List<? extends KType> r3, boolean r4) {
        KClass<Object> r5 = (KClass) ZeusTransformUtils.wrapperContextForParams(r2, KClass.class, "com.obric.memorydata.plugin");
        List<? extends KType> r6 = (List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r5, "clazz");
        Intrinsics.checkNotNullParameter(r6, "types");
        if (r4 == true) goto L5;
        bk<? extends Object> r7 = c;
    L7:
        return r7.a(r5, r6);
    L5:
        r7 = d;
        goto L7
    }

    public static final c<Object> a(KClass<Object> r2, boolean r3) {
        KClass<Object> r4 = (KClass) ZeusTransformUtils.wrapperContextForParams(r2, KClass.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r4, "clazz");
        if (r3 == true) goto L9;
        c<? extends Object> r5 = f17699a.a(r4);
        if (r5 != null) goto L11;
        return null;
    L11:
        return r5;
    L9:
        return f17700b.a(r4);
    }
}
