package kotlinx.serialization.internal;

import androidx.exifinterface.media.ExifInterface;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.jvm.JvmClassMappingKt;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.KClass;
import kotlin.reflect.KType;

/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0002\u0018\u0000*\u0004\b\u0000\u0010\u00012\b\u0012\u0004\u0012\u0002H\u00010\u0002B3\u0012,\u0010\u0003\u001a(\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00060\u0005\u0012\n\u0012\b\u0012\u0004\u0012\u00020\b0\u0007\u0012\f\u0012\n\u0012\u0004\u0012\u00028\u0000\u0018\u00010\t0\u0004¢\u0006\u0002\u0010\nJB\u0010\u000f\u001a\u0010\u0012\f\u0012\n\u0012\u0004\u0012\u00028\u0000\u0018\u00010\t0\u00102\f\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00060\u00052\f\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\b0\u0007H\u0016ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\u0004\b\u0013\u0010\u0014R$\u0010\u000b\u001a\u0018\u0012\b\u0012\u0006\u0012\u0002\b\u00030\r\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u000e0\fX\u0082\u0004¢\u0006\u0002\n\u0000R4\u0010\u0003\u001a(\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00060\u0005\u0012\n\u0012\b\u0012\u0004\u0012\u00020\b0\u0007\u0012\f\u0012\n\u0012\u0004\u0012\u00028\u0000\u0018\u00010\t0\u0004X\u0082\u0004¢\u0006\u0002\n\u0000\u0082\u0002\u000f\n\u0002\b!\n\u0005\b¡\u001e0\u0001\n\u0002\b\u0019¨\u0006\u0015"}, d2 = {"Lkotlinx/serialization/internal/ConcurrentHashMapParametrizedCache;", ExifInterface.GPS_DIRECTION_TRUE, "Lkotlinx/serialization/internal/ParametrizedSerializerCache;", "compute", "Lkotlin/Function2;", "Lkotlin/reflect/KClass;", "", "", "Lkotlin/reflect/KType;", "Lkotlinx/serialization/KSerializer;", "(Lkotlin/jvm/functions/Function2;)V", "cache", "Ljava/util/concurrent/ConcurrentHashMap;", "Ljava/lang/Class;", "Lkotlinx/serialization/internal/ParametrizedCacheEntry;", "get", "Lkotlin/Result;", "key", "types", "get-gIAlu-s", "(Lkotlin/reflect/KClass;Ljava/util/List;)Ljava/lang/Object;", "kotlinx-serialization-core"}, k = 1, mv = {1, 7, 1}, xi = 48)
final class x<T> implements bk<T> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Function2<KClass<Object>, List<? extends KType>, kotlinx.serialization.c<T>> f17820a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final ConcurrentHashMap<Class<?>, bj<T>> f17821b;

    public x(Function2<? super KClass<Object>, ? super List<? extends KType>, ? extends kotlinx.serialization.c<T>> r3) {
        Function2<KClass<Object>, List<? extends KType>, kotlinx.serialization.c<T>> r4 = (Function2) ZeusTransformUtils.wrapperContextForParams(r3, Function2.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r4, "compute");
        this.f17820a = r4;
        this.f17821b = new ConcurrentHashMap();
    }

    @Override // kotlinx.serialization.internal.bk
    public Object a(KClass<Object> r5, List<? extends KType> r6) {
        KClass<Object> r7 = (KClass) ZeusTransformUtils.wrapperContextForParams(r5, KClass.class, "com.obric.memorydata.plugin");
        List<? extends KType> r8 = (List) ZeusTransformUtils.wrapperContextForParams(r6, List.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r7, "key");
        Intrinsics.checkNotNullParameter(r8, "types");
        ConcurrentMap r0 = (ConcurrentMap) ZeusTransformUtils.preCheckCast(this.f17821b, ConcurrentMap.class, "com.obric.memorydata.plugin");
        Class r2 = JvmClassMappingKt.getJavaClass(r7);
        Object r3 = r0.get(r2);
        if (r3 != null) goto L8;
        r3 = new bj();
        Object r1 = r0.putIfAbsent(r2, r3);
        if (r1 == null) goto L8;
        r3 = r1;
    L8:
        ConcurrentMap r4 = (ConcurrentMap) ZeusTransformUtils.preCheckCast(bj.a((bj) ZeusTransformUtils.preCheckCast(r3, bj.class, "com.obric.memorydata.plugin")), ConcurrentMap.class, "com.obric.memorydata.plugin");
        Object r9 = r4.get(r8);
        if (r9 == null) goto L20;
    L18:
        Intrinsics.checkNotNullExpressionValue(r9, "serializers.getOrPut(typ… { producer() }\n        }");
        return ((Result) ZeusTransformUtils.preCheckCast(r9, Result.class, "com.obric.memorydata.plugin")).m1430unboximpl();
    L20:
        Result.Companion r10 = Result.Companion;     // Catch: Throwable -> L12
        Object r11 = Result.m1421constructorimpl((kotlinx.serialization.c) ZeusTransformUtils.preCheckCast(this.f17820a.invoke(r7, r8), kotlinx.serialization.c.class, "com.obric.memorydata.plugin"));     // Catch: Throwable -> L12
    L14:
        Result r12 = Result.m1420boximpl(r11);
        Object r13 = r4.putIfAbsent(r8, r12);
        if (r13 != null) goto L17;
        r9 = r12;
        goto L18
    L17:
        r9 = r13;
    L12:
        th = move-exception;
        Result.Companion r14 = Result.Companion;
        r11 = Result.m1421constructorimpl(ResultKt.createFailure(th));
        goto L14
    }
}
