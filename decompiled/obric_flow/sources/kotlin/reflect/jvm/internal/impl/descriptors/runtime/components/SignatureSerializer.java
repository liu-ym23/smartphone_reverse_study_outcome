package kotlin.reflect.jvm.internal.impl.descriptors.runtime.components;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.descriptors.runtime.structure.ReflectClassUtilKt;

/* JADX INFO: loaded from: classes3.dex */
final class SignatureSerializer {
    public static final SignatureSerializer INSTANCE = null;

    static {
        INSTANCE = new SignatureSerializer();
    }

    private SignatureSerializer() {
    }

    public final String constructorDesc(Constructor<?> r5) {
        Intrinsics.checkNotNullParameter(r5, "constructor");
        StringBuilder r10 = new StringBuilder("(");
        Class<?>[] r11 = r5.getParameterTypes();
        int r12 = r11.length;
        int r13 = 0;
    L3:
        if (r13 >= r12) goto L5;
        r10.append(ReflectClassUtilKt.getDesc(r11[r13]));
        r13 = r13 + 1;
        goto L3
    L5:
        r10.append(")V");
        return r10.toString();
    }

    public final String fieldDesc(Field r5) {
        Intrinsics.checkNotNullParameter(r5, "field");
        return ReflectClassUtilKt.getDesc(r5.getType());
    }

    public final String methodDesc(Method r5) {
        Intrinsics.checkNotNullParameter(r5, "method");
        StringBuilder r10 = new StringBuilder("(");
        Class<?>[] r11 = r5.getParameterTypes();
        int r12 = r11.length;
        int r13 = 0;
    L3:
        if (r13 >= r12) goto L5;
        r10.append(ReflectClassUtilKt.getDesc(r11[r13]));
        r13 = r13 + 1;
        goto L3
    L5:
        r10.append(")");
        r10.append(ReflectClassUtilKt.getDesc(r5.getReturnType()));
        return r10.toString();
    }
}
