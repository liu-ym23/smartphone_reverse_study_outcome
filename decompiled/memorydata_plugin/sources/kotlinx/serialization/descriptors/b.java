package kotlinx.serialization.descriptors;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.KClass;
import kotlinx.serialization.internal.bw;

/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000\u001e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\b\u0003\u001a\u0016\u0010\u0007\u001a\u0004\u0018\u00010\u0002*\u00020\b2\u0006\u0010\t\u001a\u00020\u0002H\u0007\u001a\u001a\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00020\u000b*\u00020\b2\u0006\u0010\t\u001a\u00020\u0002H\u0007\u001a\u0018\u0010\f\u001a\u00020\u0002*\u00020\u00022\n\u0010\r\u001a\u0006\u0012\u0002\b\u00030\u0001H\u0000\"$\u0010\u0000\u001a\b\u0012\u0002\b\u0003\u0018\u00010\u0001*\u00020\u00028FX\u0087\u0004¢\u0006\f\u0012\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u000e"}, d2 = {"capturedKClass", "Lkotlin/reflect/KClass;", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "getCapturedKClass$annotations", "(Lkotlinx/serialization/descriptors/SerialDescriptor;)V", "getCapturedKClass", "(Lkotlinx/serialization/descriptors/SerialDescriptor;)Lkotlin/reflect/KClass;", "getContextualDescriptor", "Lkotlinx/serialization/modules/SerializersModule;", "descriptor", "getPolymorphicDescriptors", "", "withContext", "context", "kotlinx-serialization-core"}, k = 2, mv = {1, 7, 1}, xi = 48)
public final class b {
    public static final KClass<?> a(f r2) {
        f r3 = (f) ZeusTransformUtils.wrapperContextForParams(r2, f.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r3, "<this>");
        if (ZeusTransformUtils.instanceOf(r3, c.class) == false) goto L6;
        return ((c) ZeusTransformUtils.preCheckCast(r3, c.class, "com.obric.memorydata.plugin")).f17668a;
    L6:
        if (ZeusTransformUtils.instanceOf(r3, bw.class) == true) goto L11;
        return null;
    L11:
        return a(((bw) ZeusTransformUtils.preCheckCast(r3, bw.class, "com.obric.memorydata.plugin")).h());
    }

    public static final f a(f r2, KClass<?> r3) {
        f r4 = (f) ZeusTransformUtils.wrapperContextForParams(r2, f.class, "com.obric.memorydata.plugin");
        KClass r5 = (KClass) ZeusTransformUtils.wrapperContextForParams(r3, KClass.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r4, "<this>");
        Intrinsics.checkNotNullParameter(r5, "context");
        return (f) ZeusTransformUtils.preCheckCast(new c(r4, r5), f.class, "com.obric.memorydata.plugin");
    }

    public static final f a(kotlinx.serialization.modules.d r2, f r3) {
        f r4 = (f) ZeusTransformUtils.wrapperContextForParams(r3, f.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r2, "<this>");
        Intrinsics.checkNotNullParameter(r4, "descriptor");
        KClass<?> r5 = a(r4);
        if (r5 == null) goto L8;
        kotlinx.serialization.c r6 = kotlinx.serialization.modules.d.a(r2, r5, null, 2, null);
        if (r6 != null) goto L7;
        return null;
    L7:
        return r6.a();
    L8:
        return null;
    }
}
