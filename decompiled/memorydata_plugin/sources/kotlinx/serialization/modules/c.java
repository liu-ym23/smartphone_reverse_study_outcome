package kotlinx.serialization.modules;

import androidx.exifinterface.media.ExifInterface;
import com.bytedance.crash.entity.EventBody;
import com.bytedance.crash.tracker.ActivityLifecycle;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.TypeIntrinsics;
import kotlin.reflect.KClass;

/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000d\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\b\u0006\b\u0000\u0018\u00002\u00020\u0001Bä\u0001\u0012\u0016\u0010\u0002\u001a\u0012\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u0004\u0012\u0004\u0012\u00020\u00050\u0003\u0012*\u0010\u0006\u001a&\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u0004\u0012\u0018\u0012\u0016\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u0004\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00070\u00030\u0003\u0012.\u0010\b\u001a*\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u0004\u0012\u001c\u0012\u001a\u0012\u0002\b\u0003\u0012\n\u0012\b\u0012\u0002\b\u0003\u0018\u00010\n0\tj\u0006\u0012\u0002\b\u0003`\u000b0\u0003\u0012&\u0010\f\u001a\"\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u0004\u0012\u0014\u0012\u0012\u0012\u0004\u0012\u00020\r\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00070\u00030\u0003\u0012A\u0010\u000e\u001a=\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u0004\u0012/\u0012-\u0012\u0015\u0012\u0013\u0018\u00010\r¢\u0006\f\b\u000f\u0012\b\b\u0010\u0012\u0004\b\b(\u0011\u0012\n\u0012\b\u0012\u0002\b\u0003\u0018\u00010\u00120\tj\u0006\u0012\u0002\b\u0003`\u00130\u0003¢\u0006\u0002\u0010\u0014J\u0010\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u0018H\u0016J:\u0010\u0019\u001a\n\u0012\u0004\u0012\u0002H\u001a\u0018\u00010\u0007\"\b\b\u0000\u0010\u001a*\u00020\u001b2\f\u0010\u001c\u001a\b\u0012\u0004\u0012\u0002H\u001a0\u00042\u0010\u0010\u001d\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00070\u001eH\u0016J7\u0010\u001f\u001a\n\u0012\u0004\u0012\u0002H\u001a\u0018\u00010\n\"\b\b\u0000\u0010\u001a*\u00020\u001b2\u000e\u0010 \u001a\n\u0012\u0006\b\u0000\u0012\u0002H\u001a0\u00042\u0006\u0010!\u001a\u0002H\u001aH\u0016¢\u0006\u0002\u0010\"J6\u0010\u001f\u001a\f\u0012\u0006\b\u0001\u0012\u0002H\u001a\u0018\u00010\u0012\"\b\b\u0000\u0010\u001a*\u00020\u001b2\u000e\u0010 \u001a\n\u0012\u0006\b\u0000\u0012\u0002H\u001a0\u00042\b\u0010#\u001a\u0004\u0018\u00010\rH\u0016R\u001e\u0010\u0002\u001a\u0012\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u0004\u0012\u0004\u0012\u00020\u00050\u0003X\u0082\u0004¢\u0006\u0002\n\u0000RI\u0010\u000e\u001a=\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u0004\u0012/\u0012-\u0012\u0015\u0012\u0013\u0018\u00010\r¢\u0006\f\b\u000f\u0012\b\b\u0010\u0012\u0004\b\b(\u0011\u0012\n\u0012\b\u0012\u0002\b\u0003\u0018\u00010\u00120\tj\u0006\u0012\u0002\b\u0003`\u00130\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R6\u0010\b\u001a*\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u0004\u0012\u001c\u0012\u001a\u0012\u0002\b\u0003\u0012\n\u0012\b\u0012\u0002\b\u0003\u0018\u00010\n0\tj\u0006\u0012\u0002\b\u0003`\u000b0\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R.\u0010\f\u001a\"\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u0004\u0012\u0014\u0012\u0012\u0012\u0004\u0012\u00020\r\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00070\u00030\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R4\u0010\u0006\u001a&\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u0004\u0012\u0018\u0012\u0016\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u0004\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00070\u00030\u00038\u0006X\u0087\u0004¢\u0006\u0002\n\u0000¨\u0006$"}, d2 = {"Lkotlinx/serialization/modules/SerialModuleImpl;", "Lkotlinx/serialization/modules/SerializersModule;", "class2ContextualFactory", "", "Lkotlin/reflect/KClass;", "Lkotlinx/serialization/modules/ContextualProvider;", "polyBase2Serializers", "Lkotlinx/serialization/KSerializer;", "polyBase2DefaultSerializerProvider", "Lkotlin/Function1;", "Lkotlinx/serialization/SerializationStrategy;", "Lkotlinx/serialization/modules/PolymorphicSerializerProvider;", "polyBase2NamedSerializers", "", "polyBase2DefaultDeserializerProvider", "Lkotlin/ParameterName;", ActivityLifecycle.NAME, "className", "Lkotlinx/serialization/DeserializationStrategy;", "Lkotlinx/serialization/modules/PolymorphicDeserializerProvider;", "(Ljava/util/Map;Ljava/util/Map;Ljava/util/Map;Ljava/util/Map;Ljava/util/Map;)V", "dumpTo", "", "collector", "Lkotlinx/serialization/modules/SerializersModuleCollector;", "getContextual", ExifInterface.GPS_DIRECTION_TRUE, "", "kClass", "typeArgumentsSerializers", "", "getPolymorphic", "baseClass", EventBody.KEY_VALUE, "(Lkotlin/reflect/KClass;Ljava/lang/Object;)Lkotlinx/serialization/SerializationStrategy;", "serializedClassName", "kotlinx-serialization-core"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class c extends d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Map<KClass<?>, Map<KClass<?>, kotlinx.serialization.c<?>>> f17868a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final Map<KClass<?>, a> f17869b;
    private final Map<KClass<?>, Function1<?, Object<?>>> c;
    private final Map<KClass<?>, Map<String, kotlinx.serialization.c<?>>> d;
    private final Map<KClass<?>, Function1<String, kotlinx.serialization.b<?>>> e;

    public c(Map<KClass<?>, ? extends a> r3, Map<KClass<?>, ? extends Map<KClass<?>, ? extends kotlinx.serialization.c<?>>> r4, Map<KClass<?>, ? extends Function1<?, ? extends Object<?>>> r5, Map<KClass<?>, ? extends Map<String, ? extends kotlinx.serialization.c<?>>> r6, Map<KClass<?>, ? extends Function1<? super String, ? extends kotlinx.serialization.b<?>>> r7) {
        Map<KClass<?>, a> r8 = (Map) ZeusTransformUtils.wrapperContextForParams(r3, Map.class, "com.obric.memorydata.plugin");
        Map<KClass<?>, Map<KClass<?>, kotlinx.serialization.c<?>>> r9 = (Map) ZeusTransformUtils.wrapperContextForParams(r4, Map.class, "com.obric.memorydata.plugin");
        Map<KClass<?>, Function1<?, Object<?>>> r10 = (Map) ZeusTransformUtils.wrapperContextForParams(r5, Map.class, "com.obric.memorydata.plugin");
        Map<KClass<?>, Map<String, kotlinx.serialization.c<?>>> r11 = (Map) ZeusTransformUtils.wrapperContextForParams(r6, Map.class, "com.obric.memorydata.plugin");
        Map<KClass<?>, Function1<String, kotlinx.serialization.b<?>>> r12 = (Map) ZeusTransformUtils.wrapperContextForParams(r7, Map.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r8, "class2ContextualFactory");
        Intrinsics.checkNotNullParameter(r9, "polyBase2Serializers");
        Intrinsics.checkNotNullParameter(r10, "polyBase2DefaultSerializerProvider");
        Intrinsics.checkNotNullParameter(r11, "polyBase2NamedSerializers");
        Intrinsics.checkNotNullParameter(r12, "polyBase2DefaultDeserializerProvider");
        super(null);
        this.f17869b = r8;
        this.f17868a = r9;
        this.c = r10;
        this.d = r11;
        this.e = r12;
    }

    @Override // kotlinx.serialization.modules.d
    public <T> kotlinx.serialization.b<? extends T> a(KClass<? super T> r5, String r6) {
        KClass r7 = (KClass) ZeusTransformUtils.wrapperContextForParams(r5, KClass.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r7, "baseClass");
        Map r0 = (Map) ZeusTransformUtils.preCheckCast(this.d.get(r7), Map.class, "com.obric.memorydata.plugin");
        if (r0 == null) goto L5;
        kotlinx.serialization.c r1 = (kotlinx.serialization.c) ZeusTransformUtils.preCheckCast(r0.get(r6), kotlinx.serialization.c.class, "com.obric.memorydata.plugin");
    L7:
        if (ZeusTransformUtils.instanceOf(r1, kotlinx.serialization.c.class) == true) goto L10;
        r1 = null;
    L10:
        if (r1 != null) goto L12;
        Function1<String, kotlinx.serialization.b<?>> r4 = this.e.get(r7);
        if (TypeIntrinsics.isFunctionOfArity(r4, 1) == false) goto L16;
        Function1 r8 = (Function1) ZeusTransformUtils.preCheckCast(r4, Function1.class, "com.obric.memorydata.plugin");
    L17:
        if (r8 != null) goto L19;
        return null;
    L19:
        return (kotlinx.serialization.b) ZeusTransformUtils.preCheckCast(r8.invoke(r6), kotlinx.serialization.b.class, "com.obric.memorydata.plugin");
    L16:
        r8 = null;
        goto L17
    L12:
        return (kotlinx.serialization.b) ZeusTransformUtils.preCheckCast(r1, kotlinx.serialization.b.class, "com.obric.memorydata.plugin");
    L5:
        r1 = null;
        goto L7
    }

    @Override // kotlinx.serialization.modules.d
    public <T> kotlinx.serialization.c<T> a(KClass<T> r3, List<? extends kotlinx.serialization.c<?>> r4) {
        KClass r5 = (KClass) ZeusTransformUtils.wrapperContextForParams(r3, KClass.class, "com.obric.memorydata.plugin");
        List<? extends kotlinx.serialization.c<?>> r6 = (List) ZeusTransformUtils.wrapperContextForParams(r4, List.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r5, "kClass");
        Intrinsics.checkNotNullParameter(r6, "typeArgumentsSerializers");
        a r2 = (a) ZeusTransformUtils.preCheckCast(this.f17869b.get(r5), a.class, "com.obric.memorydata.plugin");
        if (r2 == null) goto L5;
        kotlinx.serialization.c<?> r7 = r2.a(r6);
    L7:
        if (ZeusTransformUtils.instanceOf(r7, kotlinx.serialization.c.class) == true) goto L9;
        return null;
    L9:
        return (kotlinx.serialization.c<T>) r7;
    L5:
        r7 = null;
        goto L7
    }
}
