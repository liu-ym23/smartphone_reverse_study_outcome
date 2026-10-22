package kotlinx.serialization.internal;

import androidx.exifinterface.media.ExifInterface;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.List;
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
@Metadata(d1 = {"\u00007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007*\u0001\f\b\u0003\u0018\u0000*\u0004\b\u0000\u0010\u00012\b\u0012\u0004\u0012\u0002H\u00010\u0002B3\u0012,\u0010\u0003\u001a(\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00060\u0005\u0012\n\u0012\b\u0012\u0004\u0012\u00020\b0\u0007\u0012\f\u0012\n\u0012\u0004\u0012\u00028\u0000\u0018\u00010\t0\u0004¢\u0006\u0002\u0010\nJB\u0010\u000e\u001a\u0010\u0012\f\u0012\n\u0012\u0004\u0012\u00028\u0000\u0018\u00010\t0\u000f2\f\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00060\u00052\f\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\b0\u0007H\u0016ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\u0004\b\u0012\u0010\u0013J\u0013\u0010\u0014\u001a\b\u0012\u0004\u0012\u00028\u00000\fH\u0002¢\u0006\u0002\u0010\u0015R\u0016\u0010\u000b\u001a\b\u0012\u0004\u0012\u00028\u00000\fX\u0082\u0004¢\u0006\u0004\n\u0002\u0010\rR4\u0010\u0003\u001a(\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00060\u0005\u0012\n\u0012\b\u0012\u0004\u0012\u00020\b0\u0007\u0012\f\u0012\n\u0012\u0004\u0012\u00028\u0000\u0018\u00010\t0\u0004X\u0082\u0004¢\u0006\u0002\n\u0000\u0082\u0002\u000f\n\u0002\b!\n\u0005\b¡\u001e0\u0001\n\u0002\b\u0019¨\u0006\u0016"}, d2 = {"Lkotlinx/serialization/internal/ClassValueParametrizedCache;", ExifInterface.GPS_DIRECTION_TRUE, "Lkotlinx/serialization/internal/ParametrizedSerializerCache;", "compute", "Lkotlin/Function2;", "Lkotlin/reflect/KClass;", "", "", "Lkotlin/reflect/KType;", "Lkotlinx/serialization/KSerializer;", "(Lkotlin/jvm/functions/Function2;)V", "classValue", "kotlinx/serialization/internal/ClassValueParametrizedCache$initClassValue$1", "Lkotlinx/serialization/internal/ClassValueParametrizedCache$initClassValue$1;", "get", "Lkotlin/Result;", "key", "types", "get-gIAlu-s", "(Lkotlin/reflect/KClass;Ljava/util/List;)Ljava/lang/Object;", "initClassValue", "()Lkotlinx/serialization/internal/ClassValueParametrizedCache$initClassValue$1;", "kotlinx-serialization-core"}, k = 1, mv = {1, 7, 1}, xi = 48)
final class t<T> implements bk<T> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Function2<KClass<Object>, List<? extends KType>, kotlinx.serialization.c<T>> f17815a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final a f17816b;

    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u00020\u0001J\u001a\u0010\u0003\u001a\b\u0012\u0004\u0012\u00028\u00000\u00022\n\u0010\u0004\u001a\u0006\u0012\u0002\b\u00030\u0005H\u0014¨\u0006\u0006"}, d2 = {"kotlinx/serialization/internal/ClassValueParametrizedCache$initClassValue$1", "Ljava/lang/ClassValue;", "Lkotlinx/serialization/internal/ParametrizedCacheEntry;", "computeValue", "type", "Ljava/lang/Class;", "kotlinx-serialization-core"}, k = 1, mv = {1, 7, 1}, xi = 48)
    public static final class a extends ClassValue<bj<T>> {
        a() {
        }

        public bj<T> a(Class<?> r1) {
            Intrinsics.checkNotNullParameter(r1, "type");
            return new bj();
        }

        @Override // java.lang.ClassValue
        public /* synthetic */ Object computeValue(Class r1) {
            return a(r1);
        }
    }

    public t(Function2<? super KClass<Object>, ? super List<? extends KType>, ? extends kotlinx.serialization.c<T>> r3) {
        Function2<KClass<Object>, List<? extends KType>, kotlinx.serialization.c<T>> r4 = (Function2) ZeusTransformUtils.wrapperContextForParams(r3, Function2.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r4, "compute");
        this.f17815a = r4;
        this.f17816b = a();
    }

    private final a a() {
        return new a();
    }

    @Override // kotlinx.serialization.internal.bk
    public Object a(KClass<Object> r4, List<? extends KType> r5) {
        KClass<Object> r6 = (KClass) ZeusTransformUtils.wrapperContextForParams(r4, KClass.class, "com.obric.memorydata.plugin");
        List<? extends KType> r7 = (List) ZeusTransformUtils.wrapperContextForParams(r5, List.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r6, "key");
        Intrinsics.checkNotNullParameter(r7, "types");
        ConcurrentMap r0 = (ConcurrentMap) ZeusTransformUtils.preCheckCast(bj.a((bj) ZeusTransformUtils.preCheckCast(this.f17816b.get(JvmClassMappingKt.getJavaClass(r6)), bj.class, "com.obric.memorydata.plugin")), ConcurrentMap.class, "com.obric.memorydata.plugin");
        Object r2 = r0.get(r7);
        if (r2 == null) goto L14;
    L12:
        Intrinsics.checkNotNullExpressionValue(r2, "serializers.getOrPut(typ… { producer() }\n        }");
        return ((Result) ZeusTransformUtils.preCheckCast(r2, Result.class, "com.obric.memorydata.plugin")).m1430unboximpl();
    L14:
        Result.Companion r3 = Result.Companion;     // Catch: Throwable -> L6
        Object r8 = Result.m1421constructorimpl((kotlinx.serialization.c) ZeusTransformUtils.preCheckCast(this.f17815a.invoke(r6, r7), kotlinx.serialization.c.class, "com.obric.memorydata.plugin"));     // Catch: Throwable -> L6
    L8:
        Result r9 = Result.m1420boximpl(r8);
        Object r10 = r0.putIfAbsent(r7, r9);
        if (r10 != null) goto L11;
        r2 = r9;
        goto L12
    L11:
        r2 = r10;
    L6:
        th = move-exception;
        Result.Companion r11 = Result.Companion;
        r8 = Result.m1421constructorimpl(ResultKt.createFailure(th));
        goto L8
    }
}
