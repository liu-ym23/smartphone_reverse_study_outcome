package com.alibaba.excel.support.cglib.core;

import androidx.constraintlayout.core.motion.utils.TypedValues;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.beans.IntrospectionException;
import java.beans.Introspector;
import java.beans.PropertyDescriptor;
import java.lang.invoke.MethodHandles;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Member;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.security.AccessController;
import java.security.ProtectionDomain;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
public class ae {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final Map f366a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final Map f367b = null;
    private static final ClassLoader c = null;
    private static final Method d = null;
    private static final Method e = null;
    private static final Method f = null;
    private static final Throwable g = null;
    private static final ProtectionDomain h = null;
    private static final List<Method> i = null;
    private static final String[] j = null;

    static {
        f366a = new HashMap(8);
        f367b = new HashMap(8);
        c = ae.class.getClassLoader();
        i = new ArrayList();
        Method r2 = null;
        Method r3 = (Method) ZeusTransformUtils.preCheckCast(AccessController.doPrivileged(new AnonymousClass1()), Method.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L5
        Method r4 = (Method) ZeusTransformUtils.preCheckCast(AccessController.doPrivileged(new AnonymousClass2()), Method.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L5
        Method r1 = (Method) ZeusTransformUtils.preCheckCast(AccessController.doPrivileged(new AnonymousClass3()), Method.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L5
        Throwable r5 = null;
        r2 = r3;
    L7:
        d = r2;
        e = r4;
        f = r1;
        g = r5;
        h = a(ae.class);
        AccessController.doPrivileged(new AnonymousClass4());
        j = new String[]{"java.lang"};
        Map r0 = f366a;
        r0.put("byte", Byte.TYPE);
        r0.put("char", Character.TYPE);
        r0.put("double", Double.TYPE);
        r0.put(TypedValues.Custom.S_FLOAT, Float.TYPE);
        r0.put("int", Integer.TYPE);
        r0.put("long", Long.TYPE);
        r0.put("short", Short.TYPE);
        r0.put(TypedValues.Custom.S_BOOLEAN, Boolean.TYPE);
        Map r6 = f367b;
        r6.put("byte", "B");
        r6.put("char", "C");
        r6.put("double", com.tom_roush.pdfbox.pdmodel.a.c.a.f16161b);
        r6.put(TypedValues.Custom.S_FLOAT, "F");
        r6.put("int", "I");
        r6.put("long", "J");
        r6.put("short", "S");
        r6.put(TypedValues.Custom.S_BOOLEAN, "Z");
        return;
    L5:
        th = move-exception;
        r5 = th;
        r1 = null;
        r4 = null;
        goto L7
    }

    private ae() {
    }

    public static w a(Member r2, final int r3) {
        final Member r4 = (Member) ZeusTransformUtils.wrapperContextForParams(r2, Member.class, "com.obric.memorydata.plugin");
        final ag r0 = b(r4);
        return new AnonymousClass6(r4, r3, r0);
    }

    public static Class a(String r17, byte[] r18, final ClassLoader r19, ProtectionDomain r20, final Class<?> r21) {
        Throwable th = g;
        if (r21 != null) goto L5;
    L23:
        Class r10 = null;
    L24:
        if (r10 != null) goto L57;
        if (r20 != null) goto L27;
        ProtectionDomain r11 = h;
    L81:
        r10 = (Class) ZeusTransformUtils.preCheckCast(r19.getClass().getMethod("publicDefineClass", new Class[]{String.class, byte[].class, ProtectionDomain.class}).invoke(r19, new Object[]{r17, r18, r11}), Class.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L31 InvocationTargetException -> L33
    L37:
        if (r10 != null) goto L57;
        Method r13 = f;
        if (r13 == null) goto L57;
        Object[] r14 = {r17, r18, 0, Integer.valueOf(r18.length), r11};
    L52:
        e = move-exception;
        throw new CodeGenerationException(e.getTargetException());
    L46:
        th = th;
        if (th.getClass().getName().endsWith("InaccessibleObjectException") == true) goto L57;
        throw new CodeGenerationException(th);
    L42:
        if (r13.isAccessible() == true) goto L44;
        r13.setAccessible(true);     // Catch: Throwable -> L46 InvocationTargetException -> L52
    L44:
        r10 = (Class) ZeusTransformUtils.preCheckCast(r13.invoke(r19, r14), Class.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L46 InvocationTargetException -> L52
        goto L57
    L33:
        e = move-exception;
        if (ZeusTransformUtils.instanceOf(e.getTargetException(), UnsupportedOperationException.class) == false) goto L56;
        th = e.getTargetException();
        goto L37
    L56:
        throw new CodeGenerationException(e.getTargetException());
    L31:
        th = th;
        goto L37
    L27:
        r11 = r20;
    L57:
        if (r10 != null) goto L76;
        if (r21 == null) goto L76;
        if (r21.getClassLoader() == r19) goto L76;
        Method r12 = d;
        if (r12 == null) goto L76;
        Method r15 = e;
        if (r15 == null) goto L76;
        r10 = (Class) ZeusTransformUtils.preCheckCast(r15.invoke((MethodHandles.Lookup) ZeusTransformUtils.preCheckCast(r12.invoke(null, new Object[]{r21, MethodHandles.lookup()}), MethodHandles.Lookup.class, "com.obric.memorydata.plugin"), new Object[]{r18}), Class.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L67 IllegalAccessException -> L70 InvocationTargetException -> L73
    L70:
        e = move-exception;
        throw new ReflectUtils$6(e, r21, r19);
    L73:
        e = move-exception;
        throw new CodeGenerationException(e.getTargetException());
    L67:
        th = move-exception;
        throw new CodeGenerationException(th);
    L76:
        if (r10 == null) goto L80;
        Class.forName(r17, true, r19);
        return r10;
    L80:
        throw new CodeGenerationException(th);
    L5:
        if (r21.getClassLoader() != r19) goto L23;
        Method r16 = d;
        if (r16 == null) goto L23;
        Method r110 = e;
        if (r110 == null) goto L23;
        r10 = (Class) ZeusTransformUtils.preCheckCast(r110.invoke((MethodHandles.Lookup) ZeusTransformUtils.preCheckCast(r16.invoke(null, new Object[]{r21, MethodHandles.lookup()}), MethodHandles.Lookup.class, "com.obric.memorydata.plugin"), new Object[]{r18}), Class.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L12 InvocationTargetException -> L15
    L15:
        e = move-exception;
        th = e.getTargetException();
        if (th.getClass() == LinkageError.class) goto L23;
        if (th.getClass() == IllegalArgumentException.class) goto L23;
        throw new CodeGenerationException(th);
    L12:
        th = move-exception;
        throw new CodeGenerationException(th);
    }

    public static Object a(Class r0, Class[] r1, Object[] r2) {
        return a(a(r0, r1), r2);
    }

    private static /* synthetic */ Object a(Constructor r1) {
        r1.setAccessible(true);
        return null;
    }

    public static Object a(Constructor r2, Object[] r3) {
        boolean r0 = r2.isAccessible();
        if (r0 == false) goto L25;
    L6:
        Object r4 = r2.newInstance(r3);     // Catch: Throwable -> L10 InvocationTargetException -> L12 IllegalAccessException -> L15 InstantiationException -> L18
        if (r0 == true) goto L9;
        r2.setAccessible(r0);
    L9:
        return r4;
    L18:
        e = move-exception;
        throw new CodeGenerationException(e);     // Catch: Throwable -> L10
    L15:
        e = move-exception;
        throw new CodeGenerationException(e);     // Catch: Throwable -> L10
    L12:
        e = move-exception;
        throw new CodeGenerationException(e.getTargetException());     // Catch: Throwable -> L10
    L25:
        r2.setAccessible(true);     // Catch: Throwable -> L10 InvocationTargetException -> L12 IllegalAccessException -> L15 InstantiationException -> L18
    L10:
        th = move-exception;
        if (r0 == true) goto L23;
        r2.setAccessible(r0);
    L23:
        throw th;
    }

    public static Constructor a(Class r0, Class[] r1) {
        final Constructor r2 = r0.getDeclaredConstructor(r1);     // Catch: NoSuchMethodException -> L7
        if (System.getSecurityManager() == null) goto L5;
        AccessController.doPrivileged(new $$Lambda$ae$ku4RnR2yHI3ga0PHcjHX_7VDyg(r2));     // Catch: NoSuchMethodException -> L7
    L6:
        return r2;
    L5:
        r2.setAccessible(true);     // Catch: NoSuchMethodException -> L7
    L7:
        e = move-exception;
        throw new CodeGenerationException(e);
    }

    public static ProtectionDomain a(final Class r2) {
        if (r2 != null) goto L6;
        return null;
    L6:
        return (ProtectionDomain) ZeusTransformUtils.preCheckCast(AccessController.doPrivileged(new AnonymousClass5(r2)), ProtectionDomain.class, "com.obric.memorydata.plugin");
    }

    static /* synthetic */ List a() {
        return i;
    }

    public static List a(Class r2, List r3) {
        List r4 = (List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.memorydata.plugin");
        if (r2 != Object.class) goto L5;
        List<Method> r0 = i;
    L6:
        r4.addAll(r0);
        Class r1 = r2.getSuperclass();
        if (r1 == null) goto L9;
        a(r1, r4);
    L9:
        Class<?>[] r5 = r2.getInterfaces();
        int r6 = 0;
    L11:
        if (r6 >= r5.length) goto L13;
        a(r5[r6], r4);
        r6 = r6 + 1;
        goto L11
    L13:
        return r4;
    L5:
        r0 = Arrays.asList(r2.getDeclaredMethods());
        goto L6
    }

    public static com.alibaba.excel.support.asm.aa[] a(Member r2) {
        Member r3 = (Member) ZeusTransformUtils.wrapperContextForParams(r2, Member.class, "com.obric.memorydata.plugin");
        if (ZeusTransformUtils.instanceOf(r3, Method.class) == false) goto L7;
        return ai.a(((Method) ZeusTransformUtils.preCheckCast(r3, Method.class, "com.obric.memorydata.plugin")).getExceptionTypes());
    L7:
        if (ZeusTransformUtils.instanceOf(r3, Constructor.class) == false) goto L11;
        return ai.a(((Constructor) ZeusTransformUtils.preCheckCast(r3, Constructor.class, "com.obric.memorydata.plugin")).getExceptionTypes());
    L11:
        throw new IllegalArgumentException("Cannot get exception types of a field");
    }

    private static PropertyDescriptor[] a(Class r5, boolean r6, boolean r7) {
        PropertyDescriptor[] r8 = Introspector.getBeanInfo(r5, Object.class).getPropertyDescriptors();     // Catch: IntrospectionException -> L21
        if (r6 == false) goto L7;
        if (r7 == false) goto L7;
        return r8;
    L7:
        ArrayList r1 = new ArrayList(r8.length);     // Catch: IntrospectionException -> L21
        int r2 = 0;
    L9:
        if (r2 >= r8.length) goto L19;
        PropertyDescriptor r3 = r8[r2];     // Catch: IntrospectionException -> L21
        if (r6 == true) goto L13;
    L14:
        if (r7 == false) goto L18;
        if (r3.getWriteMethod() == null) goto L18;
    L17:
        r1.add(r3);     // Catch: IntrospectionException -> L21
    L18:
        r2 = r2 + 1;     // Catch: IntrospectionException -> L21
        goto L9
    L13:
        if (r3.getReadMethod() != null) goto L17;
    L19:
        return (PropertyDescriptor[]) ZeusTransformUtils.preCheckCast((PropertyDescriptor[]) ZeusTransformUtils.preCheckCast(r1.toArray(new PropertyDescriptor[r1.size()]), PropertyDescriptor[].class, "com.obric.memorydata.plugin"), PropertyDescriptor[].class, "com.obric.memorydata.plugin");
    L21:
        e = move-exception;
        throw new CodeGenerationException(e);
    }

    public static String[] a(Class[] r4) {
        if (r4 != null) goto L5;
        return null;
    L5:
        int r0 = r4.length;
        String[] r1 = new String[r0];
        int r2 = 0;
    L6:
        if (r2 >= r0) goto L8;
        r1[r2] = r4[r2].getName();
        r2 = r2 + 1;
        goto L6
    L8:
        return r1;
    }

    public static int b(Class[] r3) {
        int r1 = 0;
    L4:
        if (r1 >= r3.length) goto L9;
        if (Modifier.isPublic(r3[r1].getModifiers()) == false) goto L7;
        r1 = r1 + 1;
        goto L4
    L7:
        return r1;
    L9:
        return 0;
    }

    public static ag b(Member r4) {
        Member r5 = (Member) ZeusTransformUtils.wrapperContextForParams(r4, Member.class, "com.obric.memorydata.plugin");
        if (ZeusTransformUtils.instanceOf(r5, Method.class) == false) goto L7;
        return new ag(r5.getName(), com.alibaba.excel.support.asm.aa.a((Method) ZeusTransformUtils.preCheckCast(r5, Method.class, "com.obric.memorydata.plugin")));
    L7:
        if (ZeusTransformUtils.instanceOf(r5, Constructor.class) == false) goto L11;
        com.alibaba.excel.support.asm.aa[] r6 = ai.a(((Constructor) ZeusTransformUtils.preCheckCast(r5, Constructor.class, "com.obric.memorydata.plugin")).getParameterTypes());
        return new ag("<init>", com.alibaba.excel.support.asm.aa.a(com.alibaba.excel.support.asm.aa.f300a, r6));
    L11:
        throw new IllegalArgumentException("Cannot get signature of a field");
    }

    public static Object b(Class r2) {
        return a(r2, i.i, null);
    }

    public static w c(Member r2) {
        Member r3 = (Member) ZeusTransformUtils.wrapperContextForParams(r2, Member.class, "com.obric.memorydata.plugin");
        return a(r3, r3.getModifiers());
    }

    public static Method c(Class r3) {
        Method r0 = f(r3);
        if (r0.getName().equals("newInstance") == false) goto L6;
        return r0;
    L6:
        throw new IllegalArgumentException(r3 + " missing newInstance method");
    }

    public static PropertyDescriptor[] d(Class r2) {
        return a(r2, true, false);
    }

    public static PropertyDescriptor[] e(Class r2) {
        return a(r2, false, true);
    }

    public static Method f(Class r3) {
        if (r3.isInterface() == false) goto L11;
        Method[] r0 = r3.getDeclaredMethods();
        if (r0.length != 1) goto L9;
        return r0[0];
    L9:
        throw new IllegalArgumentException("expecting exactly 1 method in " + r3);
    L11:
        throw new IllegalArgumentException(r3 + " is not an interface");
    }

    public static f g(final Class r3) {
        final com.alibaba.excel.support.asm.aa r0 = com.alibaba.excel.support.asm.aa.getType(r3);
        if (r3.getSuperclass() != null) goto L5;
        final com.alibaba.excel.support.asm.aa r1 = null;
    L7:
        return new AnonymousClass7(r0, r1, r3);
    L5:
        r1 = com.alibaba.excel.support.asm.aa.getType(r3.getSuperclass());
        goto L7
    }

    /* JADX INFO: renamed from: lambda$ku4-RnR2yHI3ga0PHcjHX_7VDyg, reason: not valid java name */
    public static /* synthetic */ Object m71lambda$ku4RnR2yHI3ga0PHcjHX_7VDyg(Constructor r0) {
        return a(r0);
    }
}
