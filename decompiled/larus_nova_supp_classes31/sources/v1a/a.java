package v1a;

import java.lang.reflect.Field;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import kotlin.jvm.JvmClassMappingKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.KClass;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
public final class a {
    /* JADX WARN: Multi-variable type inference failed */
    public static final boolean a(Field r2, KClass<?>... r3) {
        if (r3.length <= 0) goto L9;
        KClass<?> r4 = r3[0];
        Class<?> r5 = r2.getType();
        if ((r5 instanceof ParameterizedType) == false) goto L8;
        Class r6 = JvmClassMappingKt.getJavaClass(r4);
        Type r7 = ((ParameterizedType) r5).getRawType();
        Intrinsics.checkNotNull(r7, "null cannot be cast to non-null type java.lang.Class<*>");
        return r6.isAssignableFrom((Class) r7);
    L8:
        return JvmClassMappingKt.getJavaClass(r4).isAssignableFrom(r5);
    L9:
        return false;
    }
}
