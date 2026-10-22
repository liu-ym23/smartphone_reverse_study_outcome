package kotlinx.serialization.modules;

import androidx.exifinterface.media.ExifInterface;
import com.bytedance.crash.entity.EventBody;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.reflect.KClass;

/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0000\b6\u0018\u00002\u00020\u0001B\u0007\b\u0004¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H'J(\u0010\u0007\u001a\n\u0012\u0004\u0012\u0002H\t\u0018\u00010\b\"\b\b\u0000\u0010\t*\u00020\u00012\f\u0010\n\u001a\b\u0012\u0004\u0012\u0002H\t0\u000bH\u0007J<\u0010\u0007\u001a\n\u0012\u0004\u0012\u0002H\t\u0018\u00010\b\"\b\b\u0000\u0010\t*\u00020\u00012\f\u0010\f\u001a\b\u0012\u0004\u0012\u0002H\t0\u000b2\u0012\b\u0002\u0010\r\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\b0\u000eH'J7\u0010\u000f\u001a\n\u0012\u0004\u0012\u0002H\t\u0018\u00010\u0010\"\b\b\u0000\u0010\t*\u00020\u00012\u000e\u0010\u0011\u001a\n\u0012\u0006\b\u0000\u0012\u0002H\t0\u000b2\u0006\u0010\u0012\u001a\u0002H\tH'¢\u0006\u0002\u0010\u0013J6\u0010\u000f\u001a\f\u0012\u0006\b\u0001\u0012\u0002H\t\u0018\u00010\u0014\"\b\b\u0000\u0010\t*\u00020\u00012\u000e\u0010\u0011\u001a\n\u0012\u0006\b\u0000\u0012\u0002H\t0\u000b2\b\u0010\u0015\u001a\u0004\u0018\u00010\u0016H'\u0082\u0001\u0001\u0017¨\u0006\u0018"}, d2 = {"Lkotlinx/serialization/modules/SerializersModule;", "", "()V", "dumpTo", "", "collector", "Lkotlinx/serialization/modules/SerializersModuleCollector;", "getContextual", "Lkotlinx/serialization/KSerializer;", ExifInterface.GPS_DIRECTION_TRUE, "kclass", "Lkotlin/reflect/KClass;", "kClass", "typeArgumentsSerializers", "", "getPolymorphic", "Lkotlinx/serialization/SerializationStrategy;", "baseClass", EventBody.KEY_VALUE, "(Lkotlin/reflect/KClass;Ljava/lang/Object;)Lkotlinx/serialization/SerializationStrategy;", "Lkotlinx/serialization/DeserializationStrategy;", "serializedClassName", "", "Lkotlinx/serialization/modules/SerialModuleImpl;", "kotlinx-serialization-core"}, k = 1, mv = {1, 7, 1}, xi = 48)
public abstract class d {
    private d() {
    }

    public /* synthetic */ d(DefaultConstructorMarker r1) {
        this();
    }

    public static /* synthetic */ kotlinx.serialization.c a(d r2, KClass r3, List r4, int r5, Object r6) {
        KClass r7 = (KClass) ZeusTransformUtils.wrapperContextForParams(r3, KClass.class, "com.obric.memorydata.plugin");
        List<? extends kotlinx.serialization.c<?>> r8 = (List) ZeusTransformUtils.wrapperContextForParams(r4, List.class, "com.obric.memorydata.plugin");
        if (r6 != null) goto L10;
        if ((r5 & 2) == 0) goto L8;
        r8 = CollectionsKt.emptyList();
    L8:
        return r2.a(r7, r8);
    L10:
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: getContextual");
    }

    public abstract <T> kotlinx.serialization.b<? extends T> a(KClass<? super T> r1, String r2);

    public abstract <T> kotlinx.serialization.c<T> a(KClass<T> r1, List<? extends kotlinx.serialization.c<?>> r2);
}
