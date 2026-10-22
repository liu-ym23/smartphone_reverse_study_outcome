package kotlin.reflect.jvm.internal.impl.descriptors.runtime.components;

import java.util.Set;
import kotlin.collections.SetsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes5.dex */
public final class ReflectKotlinClassKt {
    private static final Set<Class<?>> TYPES_ELIGIBLE_FOR_SIMPLE_VISIT = null;

    static {
        TYPES_ELIGIBLE_FOR_SIMPLE_VISIT = SetsKt.setOf(new Class[]{Integer.class, Character.class, Byte.class, Long.class, Short.class, Boolean.class, Double.class, Float.class, int[].class, char[].class, byte[].class, long[].class, short[].class, boolean[].class, double[].class, float[].class, Class.class, String.class});
    }

    public static final /* synthetic */ Set access$getTYPES_ELIGIBLE_FOR_SIMPLE_VISIT$p() {
        return TYPES_ELIGIBLE_FOR_SIMPLE_VISIT;
    }
}
