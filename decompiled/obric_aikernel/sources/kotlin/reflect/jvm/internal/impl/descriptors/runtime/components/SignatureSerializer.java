package kotlin.reflect.jvm.internal.impl.descriptors.runtime.components;

import com.bytedance.crash.event.EnsureReportData;
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

    public final String constructorDesc(Constructor<?> r10) {
        Intrinsics.checkNotNullParameter(r10, "constructor");
        StringBuilder r11 = new StringBuilder();
        r11.append("(");
        Class<?>[] r12 = r10.getParameterTypes();
        Intrinsics.checkNotNullExpressionValue(r12, "constructor.parameterTypes");
        int r13 = r12.length;
        int r14 = 0;
    L3:
        if (r14 >= r13) goto L5;
        Class<?> r15 = r12[r14];
        Intrinsics.checkNotNullExpressionValue(r15, "parameterType");
        r11.append(ReflectClassUtilKt.getDesc(r15));
        r14 = r14 + 1;
        goto L3
    L5:
        r11.append(")V");
        String r16 = r11.toString();
        Intrinsics.checkNotNullExpressionValue(r16, "sb.toString()");
        return r16;
    }

    public final String fieldDesc(Field r10) {
        Intrinsics.checkNotNullParameter(r10, "field");
        Class<?> r11 = r10.getType();
        Intrinsics.checkNotNullExpressionValue(r11, "field.type");
        return ReflectClassUtilKt.getDesc(r11);
    }

    public final String methodDesc(Method r10) {
        Intrinsics.checkNotNullParameter(r10, EnsureReportData.METHOD);
        StringBuilder r11 = new StringBuilder();
        r11.append("(");
        Class<?>[] r12 = r10.getParameterTypes();
        Intrinsics.checkNotNullExpressionValue(r12, "method.parameterTypes");
        int r13 = r12.length;
        int r14 = 0;
    L3:
        if (r14 >= r13) goto L5;
        Class<?> r15 = r12[r14];
        Intrinsics.checkNotNullExpressionValue(r15, "parameterType");
        r11.append(ReflectClassUtilKt.getDesc(r15));
        r14 = r14 + 1;
        goto L3
    L5:
        r11.append(")");
        Class<?> r16 = r10.getReturnType();
        Intrinsics.checkNotNullExpressionValue(r16, "method.returnType");
        r11.append(ReflectClassUtilKt.getDesc(r16));
        String r17 = r11.toString();
        Intrinsics.checkNotNullExpressionValue(r17, "sb.toString()");
        return r17;
    }
}
