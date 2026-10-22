package o1;

import com.bytedance.ai.bridge.core.annotation.AIBridgeDefaultValue;
import com.bytedance.ai.bridge.core.annotation.AIBridgeParamField;
import java.lang.reflect.Method;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes2.dex */
public abstract class e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final ConcurrentHashMap f20389a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final ConcurrentHashMap f20390b = null;

    static {
        f20389a = new ConcurrentHashMap();
        f20390b = new ConcurrentHashMap();
    }

    public static Class a(Class r10, Class r11) {
        Class r5 = r10.getSuperclass();     // Catch: Throwable -> L24
        int r12 = 0;
        if (r5 == null) goto L17;
        Class<?>[] r13 = r5.getDeclaredClasses();     // Catch: Throwable -> L24
        if (r13 == null) goto L17;
        int r14 = r13.length;     // Catch: Throwable -> L24
        int r15 = 0;
    L8:
        if (r15 >= r14) goto L13;
        Class<?> r16 = r13[r15];     // Catch: Throwable -> L24
        if (r16.getAnnotation(r11) != null) goto L14;
        r15 = r15 + 1;     // Catch: Throwable -> L24
    L14:
        if (r16 == null) goto L17;
        return r16;
    L13:
        r16 = null;
    L17:
        Class<?>[] r17 = r10.getDeclaredClasses();     // Catch: Throwable -> L24
        int r18 = r17.length;     // Catch: Throwable -> L24
    L18:
        if (r12 >= r18) goto L23;
        Class<?> r19 = r17[r12];     // Catch: Throwable -> L24
        if (r19.getAnnotation(r11) != null) goto L21;
        r12 = r12 + 1;
        goto L18
    L21:
        return r19;
    L23:
        return null;
    }

    public static d b(Class r19) {
        Method[] r5 = r19.getDeclaredMethods();
        Intrinsics.checkNotNull(r5);
        d r10 = new d();
        int r11 = r5.length;
        int r12 = 0;
    L3:
        if (r12 >= r11) goto L8;
        Method r13 = r5[r12];
        AIBridgeParamField r14 = (AIBridgeParamField) r13.getAnnotation(AIBridgeParamField.class);
        if (r14 == null) goto L7;
        AIBridgeDefaultValue r15 = r14.defaultValue();
        k r16 = new k(r14.required(), r14.keyPath(), new h(r15.type(), r15.doubleValue(), r15.stringValue(), r15.intValue(), r15.boolValue(), r15.longValue()));
        r10.f20388a.put(r13, r16);
    L7:
        r12 = r12 + 1;
        goto L3
    L8:
        return r10;
    }
}
