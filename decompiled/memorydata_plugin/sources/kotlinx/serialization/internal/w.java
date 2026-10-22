package kotlinx.serialization.internal;

import androidx.exifinterface.media.ExifInterface;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import kotlin.Metadata;
import kotlin.jvm.JvmClassMappingKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.KClass;

/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\b\u0002\u0018\u0000*\u0004\b\u0000\u0010\u00012\b\u0012\u0004\u0012\u0002H\u00010\u0002B%\u0012\u001e\u0010\u0003\u001a\u001a\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u0005\u0012\f\u0012\n\u0012\u0004\u0012\u00028\u0000\u0018\u00010\u00060\u0004¢\u0006\u0002\u0010\u0007J\u001e\u0010\f\u001a\n\u0012\u0004\u0012\u00028\u0000\u0018\u00010\u00062\f\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u000e0\u0005H\u0016R$\u0010\b\u001a\u0018\u0012\b\u0012\u0006\u0012\u0002\b\u00030\n\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u000b0\tX\u0082\u0004¢\u0006\u0002\n\u0000R&\u0010\u0003\u001a\u001a\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u0005\u0012\f\u0012\n\u0012\u0004\u0012\u00028\u0000\u0018\u00010\u00060\u0004X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u000f"}, d2 = {"Lkotlinx/serialization/internal/ConcurrentHashMapCache;", ExifInterface.GPS_DIRECTION_TRUE, "Lkotlinx/serialization/internal/SerializerCache;", "compute", "Lkotlin/Function1;", "Lkotlin/reflect/KClass;", "Lkotlinx/serialization/KSerializer;", "(Lkotlin/jvm/functions/Function1;)V", "cache", "Ljava/util/concurrent/ConcurrentHashMap;", "Ljava/lang/Class;", "Lkotlinx/serialization/internal/CacheEntry;", "get", "key", "", "kotlinx-serialization-core"}, k = 1, mv = {1, 7, 1}, xi = 48)
final class w<T> implements bx<T> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Function1<KClass<?>, kotlinx.serialization.c<T>> f17818a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final ConcurrentHashMap<Class<?>, m<T>> f17819b;

    public w(Function1<? super KClass<?>, ? extends kotlinx.serialization.c<T>> r3) {
        Function1<KClass<?>, kotlinx.serialization.c<T>> r4 = (Function1) ZeusTransformUtils.wrapperContextForParams(r3, Function1.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r4, "compute");
        this.f17818a = r4;
        this.f17819b = new ConcurrentHashMap();
    }

    @Override // kotlinx.serialization.internal.bx
    public kotlinx.serialization.c<T> a(KClass<Object> r5) {
        KClass<?> r6 = (KClass) ZeusTransformUtils.wrapperContextForParams(r5, KClass.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r6, "key");
        ConcurrentMap r0 = (ConcurrentMap) ZeusTransformUtils.preCheckCast(this.f17819b, ConcurrentMap.class, "com.obric.memorydata.plugin");
        Class r2 = JvmClassMappingKt.getJavaClass(r6);
        Object r3 = r0.get(r2);
        if (r3 != null) goto L9;
        r3 = new m((kotlinx.serialization.c) ZeusTransformUtils.preCheckCast(this.f17818a.invoke(r6), kotlinx.serialization.c.class, "com.obric.memorydata.plugin"));
        Object r4 = r0.putIfAbsent(r2, r3);
        if (r4 == null) goto L9;
        r3 = r4;
    L9:
        return ((m) ZeusTransformUtils.preCheckCast(r3, m.class, "com.obric.memorydata.plugin")).f17805a;
    }
}
