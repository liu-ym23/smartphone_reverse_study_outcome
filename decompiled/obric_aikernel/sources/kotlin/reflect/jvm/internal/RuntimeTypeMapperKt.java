package kotlin.reflect.jvm.internal;

import java.lang.reflect.Method;
import kotlin.collections.ArraysKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.descriptors.runtime.structure.ReflectClassUtilKt;

/* JADX INFO: loaded from: classes3.dex */
public final class RuntimeTypeMapperKt {
    public static final /* synthetic */ String access$getSignature(Method r10) {
        return getSignature(r10);
    }

    private static final String getSignature(Method r11) {
        StringBuilder r10 = new StringBuilder();
        r10.append(r11.getName());
        Class<?>[] r12 = r11.getParameterTypes();
        Intrinsics.checkNotNullExpressionValue(r12, "parameterTypes");
        r10.append(ArraysKt.joinToString$default(r12, "", "(", ")", 0, null, RuntimeTypeMapperKt$signature$1.INSTANCE, 24, null));
        Class<?> r13 = r11.getReturnType();
        Intrinsics.checkNotNullExpressionValue(r13, "returnType");
        r10.append(ReflectClassUtilKt.getDesc(r13));
        return r10.toString();
    }
}
