package kotlinx.serialization;

import androidx.exifinterface.media.ExifInterface;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.lang.annotation.Annotation;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.LazyThreadSafetyMode;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.KClass;

/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0002\u0010\u001b\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0000\u0018\u0000*\b\b\u0000\u0010\u0001*\u00020\u00022\b\u0012\u0004\u0012\u0002H\u00010\u0003B#\b\u0011\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00028\u00000\u0005\u0012\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007¢\u0006\u0002\u0010\tB\u0013\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00028\u00000\u0005¢\u0006\u0002\u0010\nJ\b\u0010\u0015\u001a\u00020\u0016H\u0016R\u0014\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\b0\fX\u0082\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\u0004\u001a\b\u0012\u0004\u0012\u00028\u00000\u0005X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u001b\u0010\u000f\u001a\u00020\u00108VX\u0096\u0084\u0002¢\u0006\f\n\u0004\b\u0013\u0010\u0014\u001a\u0004\b\u0011\u0010\u0012¨\u0006\u0017"}, d2 = {"Lkotlinx/serialization/PolymorphicSerializer;", ExifInterface.GPS_DIRECTION_TRUE, "", "Lkotlinx/serialization/internal/AbstractPolymorphicSerializer;", "baseClass", "Lkotlin/reflect/KClass;", "classAnnotations", "", "", "(Lkotlin/reflect/KClass;[Ljava/lang/annotation/Annotation;)V", "(Lkotlin/reflect/KClass;)V", "_annotations", "", "getBaseClass", "()Lkotlin/reflect/KClass;", "descriptor", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "getDescriptor", "()Lkotlinx/serialization/descriptors/SerialDescriptor;", "descriptor$delegate", "Lkotlin/Lazy;", "toString", "", "kotlinx-serialization-core"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class e<T> extends kotlinx.serialization.internal.b<T> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final KClass<T> f17695a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private List<? extends Annotation> f17696b;
    private final Lazy c;

    public e(KClass<T> r4) {
        KClass<T> r5 = (KClass) ZeusTransformUtils.wrapperContextForParams(r4, KClass.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r5, "baseClass");
        this.f17695a = r5;
        this.f17696b = CollectionsKt.emptyList();
        this.c = LazyKt.lazy(LazyThreadSafetyMode.PUBLICATION, (Function0) ZeusTransformUtils.preCheckCast(new PolymorphicSerializer$descriptor$2(this), Function0.class, "com.obric.memorydata.plugin"));
    }

    public static final /* synthetic */ List a(e r0) {
        return r0.f17696b;
    }

    @Override // kotlinx.serialization.c, kotlinx.serialization.b
    public kotlinx.serialization.descriptors.f a() {
        return (kotlinx.serialization.descriptors.f) ZeusTransformUtils.preCheckCast(this.c.getValue(), kotlinx.serialization.descriptors.f.class, "com.obric.memorydata.plugin");
    }

    @Override // kotlinx.serialization.internal.b
    public KClass<T> b() {
        return this.f17695a;
    }

    public String toString() {
        return "kotlinx.serialization.PolymorphicSerializer(baseClass: " + b() + ')';
    }
}
