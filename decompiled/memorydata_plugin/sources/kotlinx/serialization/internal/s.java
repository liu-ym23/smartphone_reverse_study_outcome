package kotlinx.serialization.internal;

import androidx.exifinterface.media.ExifInterface;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import kotlin.Metadata;
import kotlin.jvm.JvmClassMappingKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.KClass;

/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000+\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\b\u0004\n\u0002\u0010\u0000\n\u0002\b\u0003*\u0001\t\b\u0003\u0018\u0000*\u0004\b\u0000\u0010\u00012\b\u0012\u0004\u0012\u0002H\u00010\u0002B%\u0012\u001e\u0010\u0003\u001a\u001a\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u0005\u0012\f\u0012\n\u0012\u0004\u0012\u00028\u0000\u0018\u00010\u00060\u0004¢\u0006\u0002\u0010\u0007J\u001e\u0010\u000b\u001a\n\u0012\u0004\u0012\u00028\u0000\u0018\u00010\u00062\f\u0010\f\u001a\b\u0012\u0004\u0012\u00020\r0\u0005H\u0016J\u0013\u0010\u000e\u001a\b\u0012\u0004\u0012\u00028\u00000\tH\u0002¢\u0006\u0002\u0010\u000fR\u0016\u0010\b\u001a\b\u0012\u0004\u0012\u00028\u00000\tX\u0082\u0004¢\u0006\u0004\n\u0002\u0010\nR&\u0010\u0003\u001a\u001a\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u0005\u0012\f\u0012\n\u0012\u0004\u0012\u00028\u0000\u0018\u00010\u00060\u0004X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0010"}, d2 = {"Lkotlinx/serialization/internal/ClassValueCache;", ExifInterface.GPS_DIRECTION_TRUE, "Lkotlinx/serialization/internal/SerializerCache;", "compute", "Lkotlin/Function1;", "Lkotlin/reflect/KClass;", "Lkotlinx/serialization/KSerializer;", "(Lkotlin/jvm/functions/Function1;)V", "classValue", "kotlinx/serialization/internal/ClassValueCache$initClassValue$1", "Lkotlinx/serialization/internal/ClassValueCache$initClassValue$1;", "get", "key", "", "initClassValue", "()Lkotlinx/serialization/internal/ClassValueCache$initClassValue$1;", "kotlinx-serialization-core"}, k = 1, mv = {1, 7, 1}, xi = 48)
final class s<T> implements bx<T> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Function1<KClass<?>, kotlinx.serialization.c<T>> f17812a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final a f17813b;

    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u00020\u0001J\u001a\u0010\u0003\u001a\b\u0012\u0004\u0012\u00028\u00000\u00022\n\u0010\u0004\u001a\u0006\u0012\u0002\b\u00030\u0005H\u0014¨\u0006\u0006"}, d2 = {"kotlinx/serialization/internal/ClassValueCache$initClassValue$1", "Ljava/lang/ClassValue;", "Lkotlinx/serialization/internal/CacheEntry;", "computeValue", "type", "Ljava/lang/Class;", "kotlinx-serialization-core"}, k = 1, mv = {1, 7, 1}, xi = 48)
    public static final class a extends ClassValue<m<T>> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ s<T> f17814a;

        a(s<T> r1) {
            this.f17814a = r1;
        }

        public m<T> a(Class<?> r3) {
            Intrinsics.checkNotNullParameter(r3, "type");
            return new m((kotlinx.serialization.c) ZeusTransformUtils.preCheckCast(s.a(this.f17814a).invoke(JvmClassMappingKt.getKotlinClass(r3)), kotlinx.serialization.c.class, "com.obric.memorydata.plugin"));
        }

        @Override // java.lang.ClassValue
        public /* synthetic */ Object computeValue(Class r1) {
            return a(r1);
        }
    }

    public s(Function1<? super KClass<?>, ? extends kotlinx.serialization.c<T>> r3) {
        Function1<KClass<?>, kotlinx.serialization.c<T>> r4 = (Function1) ZeusTransformUtils.wrapperContextForParams(r3, Function1.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r4, "compute");
        this.f17812a = r4;
        this.f17813b = a();
    }

    public static final /* synthetic */ Function1 a(s r0) {
        return r0.f17812a;
    }

    private final a a() {
        return new a(this);
    }

    @Override // kotlinx.serialization.internal.bx
    public kotlinx.serialization.c<T> a(KClass<Object> r3) {
        KClass r4 = (KClass) ZeusTransformUtils.wrapperContextForParams(r3, KClass.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r4, "key");
        return ((m) ZeusTransformUtils.preCheckCast(this.f17813b.get(JvmClassMappingKt.getJavaClass(r4)), m.class, "com.obric.memorydata.plugin")).f17805a;
    }
}
