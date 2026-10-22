package cj;

import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.collections.ArraysKt;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.JvmClassMappingKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KClass;

/* JADX INFO: loaded from: classes2.dex */
public abstract class l {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final ConcurrentHashMap f1209a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final ConcurrentHashMap f1210b = null;

    static {
        new LinkedHashMap();
        f1209a = new ConcurrentHashMap();
        f1210b = new ConcurrentHashMap();
    }

    public static g a(Class r29, HashMap r30) {
        Method[] r5 = r29.getDeclaredMethods();
        g r10 = new g();
        int r11 = r5.length;
        int r12 = 0;
    L3:
        if (r12 >= r11) goto L34;
        Method r13 = r5[r12];
        dj.c r14 = (dj.c) r13.getAnnotation(dj.c.class);
        if (r14 == null) goto L33;
        dj.a r15 = r14.defaultValue();
        dj.f r16 = (dj.f) r13.getAnnotation(dj.f.class);
        dj.b r17 = (dj.b) r13.getAnnotation(dj.b.class);
        KClass r18 = Reflection.getOrCreateKotlinClass(r14.nestedClassType());
        String r19 = r14.keyPath();
        boolean r110 = Intrinsics.areEqual(r18, Reflection.getOrCreateKotlinClass(fj.a.class));
        HashMap r111 = r10.f1198b;
        if (r110 == false) goto L9;
    L13:
        boolean r112 = r14.required();
        KClass r113 = Reflection.getOrCreateKotlinClass(r14.primitiveClassType());
        boolean r114 = r14.isEnum();
        boolean r115 = r14.isGetter();
        h r28 = new h(r15.type(), r15.doubleValue(), r15.stringValue(), r15.intValue(), r15.boolValue(), r15.longValue());
        Class<?> r116 = r13.getReturnType();
        if (r16 == null) goto L21;
        String[] r20 = r16.option();
        if (r20 == null) goto L21;
        List r21 = ArraysKt.toList(r20);
        if (r21 == null) goto L21;
    L20:
        List r22 = r21;
        if (r17 == null) goto L29;
        int[] r23 = r17.option();
        if (r23 == null) goto L29;
        List<Integer> r24 = ArraysKt.toList(r23);
        if (r24 == null) goto L29;
    L30:
        i r117 = new i(r112, r19, r18, r113, r114, r115, r28, r116, r22, r24);
        r10.f1197a.put(r13, r117);
        if (r14.isGetter() == false) goto L33;
        r111.put(r19, r117);
    L29:
        r24 = CollectionsKt.emptyList();
    L21:
        r21 = CollectionsKt.emptyList();
        goto L20
    L9:
        if (r30.containsKey(JvmClassMappingKt.getJavaClass(r18)) == true) goto L13;
        if (r111.containsKey(r19) == true) goto L13;
        r30.put(JvmClassMappingKt.getJavaClass(r18), a(JvmClassMappingKt.getJavaClass(r18), r30));
    L33:
        r12 = r12 + 1;
        goto L3
    L34:
        return r10;
    }

    public static Class b(Class r10, Class r11) {
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
}
