package f3;

import com.bytedance.ai.bridge.core.AIBridgeMethod;
import com.bytedance.ai.bridge.core.annotation.AIBridgeDefaultValue;
import com.bytedance.ai.bridge.core.annotation.AIBridgeParamField;
import java.lang.reflect.Method;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public final class g {
    public static final ConcurrentHashMap<Class<? extends AIBridgeMethod>, d> a = null;
    public static final ConcurrentHashMap<Class<?>, Class<? extends AIBridgeMethod>> b = null;

    static {
        a = new ConcurrentHashMap();
        b = new ConcurrentHashMap();
    }

    public static e b(Class r19) {
        Method[] r0 = r19.getDeclaredMethods();
        Intrinsics.checkNotNull(r0);
        e r1 = new e(null);
        int r10 = r0.length;
        int r11 = 0;
    L3:
        if (r11 >= r10) goto L8;
        Method r12 = r0[r11];
        AIBridgeParamField r13 = (AIBridgeParamField) r12.getAnnotation(AIBridgeParamField.class);
        if (r13 == null) goto L7;
        AIBridgeDefaultValue r14 = r13.defaultValue();
        n r15 = new n(r13.required(), r13.keyPath(), new j(r14.type(), r14.doubleValue(), r14.stringValue(), r14.intValue(), r14.boolValue(), r14.longValue()));
        r1.a.put(r12, r15);
    L7:
        r11 = r11 + 1;
        goto L3
    L8:
        return r1;
    }

    public static Class a(Class r10, Class r11) {
        Class r1 = r10.getSuperclass();     // Catch: Throwable -> L30
        if (r1 == null) goto L20;
        Class<?>[] r12 = r1.getDeclaredClasses();     // Catch: Throwable -> L30
        if (r12 == null) goto L20;
        int r13 = r12.length;     // Catch: Throwable -> L30
        int r14 = 0;
    L8:
        if (r14 >= r13) goto L16;
        Class<?> r15 = r12[r14];     // Catch: Throwable -> L30
        if (r15.getAnnotation(r11) == null) goto L12;
        boolean r16 = true;
    L13:
        if (r16 == true) goto L17;
        r14 = r14 + 1;     // Catch: Throwable -> L30
    L17:
        if (r15 == null) goto L20;
        return r15;
    L12:
        r16 = false;
        goto L13
    L16:
        r15 = null;
    L20:
        Class<?>[] r17 = r10.getDeclaredClasses();     // Catch: Throwable -> L30
        int r18 = r17.length;     // Catch: Throwable -> L30
        int r19 = 0;
    L21:
        if (r19 >= r18) goto L39;
        Class<?> r20 = r17[r19];     // Catch: Throwable -> L30
        if (r20.getAnnotation(r11) == null) goto L25;
        boolean r21 = true;
    L26:
        if (r21 == true) goto L37;
        r19 = r19 + 1;
        goto L21
    L37:
        return r20;
    L25:
        r21 = false;
        goto L26
    L39:
        return null;
    L38:
        return null;
    }
}
