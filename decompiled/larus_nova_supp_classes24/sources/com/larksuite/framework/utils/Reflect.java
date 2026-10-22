package com.larksuite.framework.utils;

import com.bytedance.mira.exception.PluginClassNotFoundException;
import com.larus.mirabridge.impl.lancet.FastClassNotFoundHandler;
import com.larus.mirabridge.impl.lancet.MiraPluginFix;
import com.ss.android.lark.log.Log;
import java.lang.reflect.AccessibleObject;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Member;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.Arrays;
import java.util.concurrent.ConcurrentHashMap;
import me.ele.lancet.base.annotations.Skip;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes24.dex */
public final class Reflect {
    public final Object a;
    public final boolean b;

    public static class ReflectException extends RuntimeException {
        private static final long serialVersionUID = -2243843843843438438L;

        public ReflectException() {
        }

        public ReflectException(String r1) {
            super(r1);
        }

        public ReflectException(Throwable r1) {
            super(r1);
        }

        public ReflectException(String r1, Throwable r2) {
            super(r1, r2);
        }
    }

    public static class a {
        public a() {
        }
    }

    public final Reflect c() throws ReflectException {
        /*  JADX ERROR: Simple mode code generation failed
            java.lang.IndexOutOfBoundsException: Index 0 out of bounds for length 0
            	at java.base/jdk.internal.util.Preconditions.outOfBounds(Preconditions.java:100)
            	at java.base/jdk.internal.util.Preconditions.outOfBoundsCheckIndex(Preconditions.java:106)
            	at java.base/jdk.internal.util.Preconditions.checkIndex(Preconditions.java:302)
            	at java.base/java.util.Objects.checkIndex(Objects.java:365)
            	at java.base/java.util.ArrayList.get(ArrayList.java:428)
            	at jadx.core.codegen.MethodGen.generateSimpleCode(MethodGen.java:354)
            	at jadx.core.codegen.MethodGen.addSimpleMethodCode(MethodGen.java:316)
            	at jadx.core.codegen.MethodGen.addInstructions(MethodGen.java:279)
            	at jadx.core.codegen.ClassGen.addMethodCode(ClassGen.java:420)
            	at jadx.core.codegen.ClassGen.addMethod(ClassGen.java:345)
            	at jadx.core.codegen.ClassGen.lambda$addInnerClsAndMethods$2(ClassGen.java:299)
            	at java.base/java.util.stream.ForEachOps$ForEachOp$OfRef.accept(ForEachOps.java:186)
            	at java.base/java.util.ArrayList.forEach(ArrayList.java:1612)
            	at java.base/java.util.stream.SortedOps$RefSortingSink.end(SortedOps.java:395)
            	at java.base/java.util.stream.Sink$ChainedReference.end(Sink.java:261)
            	at java.base/java.util.stream.ReferencePipeline$7$1FlatMap.end(ReferencePipeline.java:284)
            	at java.base/java.util.stream.AbstractPipeline.copyInto(AbstractPipeline.java:571)
            	at java.base/java.util.stream.AbstractPipeline.wrapAndCopyInto(AbstractPipeline.java:560)
            	at java.base/java.util.stream.ForEachOps$ForEachOp.evaluateSequential(ForEachOps.java:153)
            	at java.base/java.util.stream.ForEachOps$ForEachOp$OfRef.evaluateSequential(ForEachOps.java:176)
            	at java.base/java.util.stream.AbstractPipeline.evaluate(AbstractPipeline.java:265)
            	at java.base/java.util.stream.ReferencePipeline.forEach(ReferencePipeline.java:632)
            	at jadx.core.codegen.ClassGen.addInnerClsAndMethods(ClassGen.java:295)
            	at jadx.core.codegen.ClassGen.addClassBody(ClassGen.java:284)
            	at jadx.core.codegen.ClassGen.addClassBody(ClassGen.java:268)
            	at jadx.core.codegen.ClassGen.addClassCode(ClassGen.java:160)
            	at jadx.core.codegen.ClassGen.makeClass(ClassGen.java:104)
            	at jadx.core.codegen.CodeGen.wrapCodeGen(CodeGen.java:45)
            	at jadx.core.codegen.CodeGen.generateJavaCode(CodeGen.java:34)
            	at jadx.core.codegen.CodeGen.generate(CodeGen.java:22)
            	at jadx.core.ProcessClass.process(ProcessClass.java:89)
            	at jadx.core.ProcessClass.generateCode(ProcessClass.java:127)
            	at jadx.core.dex.nodes.ClassNode.generateClassCode(ClassNode.java:405)
            	at jadx.core.dex.nodes.ClassNode.decompile(ClassNode.java:393)
            	at jadx.core.dex.nodes.ClassNode.getCode(ClassNode.java:343)
            */
        /*
            this = this;
            r0 = 0
            java.lang.Object[] r1 = new java.lang.Object[r0]
            java.lang.Class[] r2 = new java.lang.Class[r0]
            java.lang.Class r3 = r8.k()     // Catch: java.lang.NoSuchMethodException -> L24
            java.lang.reflect.Constructor r3 = r3.getDeclaredConstructor(r2)     // Catch: java.lang.NoSuchMethodException -> L24
            java.lang.reflect.AccessibleObject r3 = b(r3)     // Catch: java.lang.Exception -> L1d
            java.lang.reflect.Constructor r3 = (java.lang.reflect.Constructor) r3     // Catch: java.lang.Exception -> L1d
            java.lang.Object r3 = r3.newInstance(r1)     // Catch: java.lang.Exception -> L1d
            com.larksuite.framework.utils.Reflect r4 = new com.larksuite.framework.utils.Reflect     // Catch: java.lang.Exception -> L1d
            r4.<init>(r3)     // Catch: java.lang.Exception -> L1d
            goto L4b
        L1d:
            r3 = move-exception
            com.larksuite.framework.utils.Reflect$ReflectException r4 = new com.larksuite.framework.utils.Reflect$ReflectException     // Catch: java.lang.NoSuchMethodException -> L24
            r4.<init>(r3)     // Catch: java.lang.NoSuchMethodException -> L24
            throw r4     // Catch: java.lang.NoSuchMethodException -> L24
        L24:
            r3 = move-exception
            java.lang.Class r4 = r8.k()
            java.lang.reflect.Constructor[] r4 = r4.getDeclaredConstructors()
            int r5 = r4.length
        L2e:
            if (r0 >= r5) goto L56
            r6 = r4[r0]
            java.lang.Class[] r7 = r6.getParameterTypes()
            boolean r7 = g(r7, r2)
            if (r7 == 0) goto L53
            java.lang.reflect.AccessibleObject r0 = b(r6)     // Catch: java.lang.Exception -> L4c
            java.lang.reflect.Constructor r0 = (java.lang.reflect.Constructor) r0     // Catch: java.lang.Exception -> L4c
            java.lang.Object r0 = r0.newInstance(r1)     // Catch: java.lang.Exception -> L4c
            com.larksuite.framework.utils.Reflect r4 = new com.larksuite.framework.utils.Reflect     // Catch: java.lang.Exception -> L4c
            r4.<init>(r0)     // Catch: java.lang.Exception -> L4c
        L4b:
            return r4
        L4c:
            r0 = move-exception
            com.larksuite.framework.utils.Reflect$ReflectException r1 = new com.larksuite.framework.utils.Reflect$ReflectException
            r1.<init>(r0)
            throw r1
        L53:
            int r0 = r0 + 1
            goto L2e
        L56:
            com.larksuite.framework.utils.Reflect$ReflectException r0 = new com.larksuite.framework.utils.Reflect$ReflectException
            r0.<init>(r3)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.larksuite.framework.utils.Reflect.c():com.larksuite.framework.utils.Reflect");
    }

    public final int hashCode() {
        return this.a.hashCode();
    }

    public final Class<?> k() {
        if (this.b == false) goto L7;
        return (Class) this.a;
    L7:
        return this.a.getClass();
    }

    public final String toString() {
        return this.a.toString();
    }

    public Reflect(Class<?> r1) {
        this.a = r1;
        this.b = true;
    }

    @Skip({"com.larus.mirabridge.impl.lancet+", "com.bytedance.mira.hook.delegate.DyMiraClassLoader", "com.bytedance.mira.hook.delegate.MiraClassLoader", "com.bytedance.ies.stark.util.NReflectUtils", "-com.bytedance.mira.core.PluginClassLoader", "com.bytedance.common.jato.util.DeviceInfoUtils", "com.bytedance.mira.helper.ClassLoaderHelper", "com.bytedance.mira.core.opt.res+"})
    public static Class a(String r3) throws ClassNotFoundException {
        ConcurrentHashMap r0 = FastClassNotFoundHandler.a;
        FastClassNotFoundHandler.Status r1 = FastClassNotFoundHandler.Status.STATUS_NOTING;
        if (el9.a.a() == true) goto L34;
        Class<?> r2 = Class.forName(r3);     // Catch: Throwable -> L8
        if (r1 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L7;
        FastClassNotFoundHandler.a(r3);     // Catch: Throwable -> L8
    L7:
        return r2;
    L8:
        th = move-exception;
        if (r1 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L12;
        FastClassNotFoundHandler.b(r3);
    L12:
        throw th;
    L34:
        Class<?> r4 = Class.forName(r3);     // Catch: Throwable -> L17
        if (r1 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L16;
        FastClassNotFoundHandler.a(r3);     // Catch: Throwable -> L17
    L16:
        return r4;
    L17:
        th = move-exception;
        if (r1 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L22;
        FastClassNotFoundHandler.b(r3);
    L22:
        if ((th instanceof PluginClassNotFoundException) == false) goto L24;
        throw th;
    L24:
        if ((th instanceof ClassNotFoundException) == true) goto L30;
        if ((th instanceof NoClassDefFoundError) == true) goto L30;
        throw th;
    L30:
        return MiraPluginFix.forName(r3);
    }

    public static <T extends AccessibleObject> T b(T r2) {
        if (r2 != null) goto L6;
        return null;
    L6:
        if ((r2 instanceof Member) == false) goto L13;
        Member r0 = (Member) r2;
        if (Modifier.isPublic(r0.getModifiers()) == false) goto L13;
        if (Modifier.isPublic(r0.getDeclaringClass().getModifiers()) == false) goto L13;
        return r2;
    L13:
        if (r2.isAccessible() == true) goto L15;
        r2.setAccessible(true);
    L15:
        return r2;
    }

    public static Class<?> l(Class<?> r1) {
        if (r1 != null) goto L6;
        return null;
    L6:
        if (r1.isPrimitive() == true) goto L8;
        return r1;
    L8:
        if (Boolean.TYPE != r1) goto L12;
        return Boolean.class;
    L12:
        if (Integer.TYPE != r1) goto L16;
        return Integer.class;
    L16:
        if (Long.TYPE != r1) goto L20;
        return Long.class;
    L20:
        if (Short.TYPE != r1) goto L24;
        return Short.class;
    L24:
        if (Byte.TYPE != r1) goto L28;
        return Byte.class;
    L28:
        if (Double.TYPE != r1) goto L32;
        return Double.class;
    L32:
        if (Float.TYPE != r1) goto L36;
        return Float.class;
    L36:
        if (Character.TYPE != r1) goto L40;
        return Character.class;
    L40:
        if (Void.TYPE != r1) goto L44;
        return Void.class;
    L44:
        return r1;
    }

    public Reflect call(String r3) throws ReflectException {
        return call(r3, null, new Object[0]);
    }

    public final boolean equals(Object r2) {
        if ((r2 instanceof Reflect) == true) goto L5;
        return false;
    L5:
        return this.a.equals(((Reflect) r2).a);
    }

    public Reflect(Object r1) {
        this.a = r1;
        this.b = false;
    }

    public static boolean g(Class[] r4, Class[] r5) {
        if (r4.length != r5.length) goto L16;
        int r0 = 0;
    L6:
        if (r0 >= r5.length) goto L14;
        if (r5[r0] == a.class) goto L12;
        if (l(r4[r0]).isAssignableFrom(l(r5[r0])) == true) goto L12;
        return false;
    L12:
        r0 = r0 + 1;
        goto L6
    L14:
        return true;
    L16:
        return false;
    }

    public final Method d(String r17, Class... r19) throws NoSuchMethodException {
        String r0 = r17;
        Class<?> r2 = k();
        return r2.getMethod(r0, r19);
    L25:
        return r2.getDeclaredMethod(r0, r19);
    L7:
        r2 = r2.getSuperclass();
        if (r2 != null) goto L25;
        Class<?> r3 = k();
        Method[] r4 = r3.getMethods();
        int r5 = r4.length;
        int r6 = 0;
    L10:
        if (r6 >= r5) goto L21;
        Method r7 = r4[r6];
        if (r0.equals(r7.getName()) == false) goto L19;
        Class<?>[] r8 = r7.getParameterTypes();
        int r9 = r8.length;
        int r11 = 0;
        int r12 = 1;
    L14:
        if (r11 >= r9) goto L17;
        Log.d("Plugin", "Reflect type = " + r3 + " method = " + r0 + " paramTypes " + r12 + " = " + r8[r11].getName());
        r12 = r12 + 1;
        r11 = r11 + 1;
        goto L14
    L17:
        if (r8.length != r19.length) goto L19;
        return r7;
    L19:
        r6 = r6 + 1;
        goto L10
    L21:
        throw new NoSuchMethodException();
    }

    public final Reflect e(String r1, Class<?>... r2) throws ReflectException {
        return new Reflect(f(r1, r2).get(this.a));
    L4:
        e = move-exception;
        throw new ReflectException(e);
    }

    public final Field f(String r9, Class<?>... r10) throws ReflectException {
        Class<?> r0 = k();
        if (r10.length <= 0) goto L35;
    L31:
        Field[] r1 = r0.getDeclaredFields();     // Catch: Exception -> L15
        int r2 = r1.length;     // Catch: Exception -> L15
        int r4 = 0;
    L5:
        if (r4 >= r2) goto L16;
        Field r5 = r1[r4];     // Catch: Exception -> L15
        Class<?> r6 = r5.getType();     // Catch: Exception -> L15
        if (r6 == null) goto L14;
        if (r6.getName().equals(r10[0].getName()) == false) goto L14;
        if (r5.getName().equals(r9) == false) goto L14;
        return (Field) b(r5);
    L14:
        r4 = r4 + 1;
    L16:
        r0 = r0.getSuperclass();
        if (r0 != null) goto L31;
        throw new ReflectException("NoSuchFieldException");
    L35:
        return r0.getField(r9);
    L23:
        e = move-exception;
    L33:
        return (Field) b(r0.getDeclaredField(r9));
    L26:
        r0 = r0.getSuperclass();
        if (r0 != null) goto L33;
        throw new ReflectException(e);
    }

    public final void i(String r3, Object r4) throws ReflectException {
        Field r5 = f(r3, new Class[0]);     // Catch: Exception -> L8
        Object r0 = this.a;     // Catch: Exception -> L8
        if ((r4 instanceof Reflect) == false) goto L6;
        r4 = ((Reflect) r4).a;     // Catch: Exception -> L8
    L6:
        r5.set(r0, r4);     // Catch: Exception -> L8
        return;
    L8:
        e = move-exception;
        throw new ReflectException(e);
    }

    public final Method j(String r9, Class<?>[] r10) throws NoSuchMethodException {
        Class<?> r0 = k();
        Method[] r1 = r0.getMethods();
        int r2 = r1.length;
        int r4 = 0;
    L3:
        boolean r5 = true;
        if (r4 >= r2) goto L14;
        Method r6 = r1[r4];
        if (r6.getName().equals(r9) == true) goto L8;
    L10:
        r5 = false;
    L11:
        if (r5 == true) goto L12;
        r4 = r4 + 1;
        goto L3
    L12:
        return r6;
    L8:
        if (g(r6.getParameterTypes(), r10) == false) goto L10;
    L14:
        Method[] r3 = r0.getDeclaredMethods();
        int r7 = r3.length;
        int r8 = 0;
    L15:
        if (r8 >= r7) goto L25;
        Method r11 = r3[r8];
        if (r11.getName().equals(r9) == true) goto L19;
    L21:
        boolean r12 = false;
    L22:
        if (r12 == true) goto L23;
        r8 = r8 + 1;
        goto L15
    L23:
        return r11;
    L19:
        if (g(r11.getParameterTypes(), r10) == false) goto L21;
        r12 = true;
        goto L22
    L25:
        r0 = r0.getSuperclass();
        if (r0 != null) goto L14;
        throw new NoSuchMethodException("No similar method " + r9 + " with params " + Arrays.toString(r10) + " could be found on type " + k() + ".");
    }

    public static Reflect h(Method r2, Object r3, Object... r4) throws ReflectException {
        b(r2);     // Catch: Exception -> L8
        if (r2.getReturnType() != Void.TYPE) goto L7;
        r2.invoke(r3, r4);     // Catch: Exception -> L8
        return new Reflect(r3);
    L7:
        return new Reflect(r2.invoke(r3, r4));
    L8:
        e = move-exception;
        throw new ReflectException(e);
    }

    public Reflect call(String r3, Class<?>[] r4, Object... r5) throws ReflectException {
        return h(d(r3, r4), this.a, r5);
    L4:
        return h(j(r3, r4), this.a, r5);
    L6:
        e = move-exception;
        throw new ReflectException(e);
    }
}
