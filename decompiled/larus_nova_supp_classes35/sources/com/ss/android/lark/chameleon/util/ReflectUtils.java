package com.ss.android.lark.chameleon.util;

import com.bytedance.mira.exception.PluginClassNotFoundException;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.larus.mirabridge.impl.lancet.FastClassNotFoundHandler;
import com.larus.mirabridge.impl.lancet.MiraPluginFix;
import com.tencent.qqmusic.third.api.contract.BuildConfig;
import el9.a;
import java.lang.reflect.AccessibleObject;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Member;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Proxy;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import me.ele.lancet.base.annotations.Skip;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public final class ReflectUtils {
    private final Object object;
    private final Class<?> type;

    public static class NULL {
        private NULL() {
        }
    }

    public static class ReflectException extends RuntimeException {
        private static final long serialVersionUID = 858774075258496016L;

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

    public static /* synthetic */ Class access$001(String r0) throws ClassNotFoundException {
        return Class.forName(r0);
    }

    public static /* synthetic */ Class access$002(String r0, boolean r1, ClassLoader r2) throws ClassNotFoundException {
        return Class.forName(r0, r1, r2);
    }

    public ReflectUtils newInstance() {
        return newInstance(new Object[0]);
    }

    public int hashCode() {
        return this.object.hashCode();
    }

    public String toString() {
        return this.object.toString();
    }

    private Class<?> type() {
        return this.type;
    }

    public <T> T get() {
        return (T) this.object;
    }

    private ReflectUtils(Class<?> r1) {
        this(r1, r1);
    }

    @Skip({"com.larus.mirabridge.impl.lancet+", "com.bytedance.mira.hook.delegate.DyMiraClassLoader", "com.bytedance.mira.hook.delegate.MiraClassLoader", "com.bytedance.ies.stark.util.NReflectUtils", "-com.bytedance.mira.core.PluginClassLoader", "com.bytedance.common.jato.util.DeviceInfoUtils", "com.bytedance.mira.helper.ClassLoaderHelper", "com.bytedance.mira.core.opt.res+"})
    public static Class INVOKESTATIC_com_ss_android_lark_chameleon_util_ReflectUtils_com_larus_mirabridge_impl_lancet_MiraReflectLancet_forName(String r3) throws ClassNotFoundException {
        ConcurrentHashMap r0 = FastClassNotFoundHandler.a;
        FastClassNotFoundHandler.Status r1 = FastClassNotFoundHandler.Status.STATUS_NOTING;
        if (a.a() == true) goto L34;
        Class r2 = access$001(r3);     // Catch: Throwable -> L8
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
        Class r4 = access$001(r3);     // Catch: Throwable -> L17
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

    public static /* synthetic */ Object access$000(ReflectUtils r0) {
        return r0.object;
    }

    public static /* synthetic */ String access$100(String r0) {
        return property(r0);
    }

    private <T extends AccessibleObject> T accessible(T r3) {
        if (r3 != null) goto L6;
        return null;
    L6:
        if ((r3 instanceof Member) == false) goto L13;
        Member r0 = (Member) r3;
        if (Modifier.isPublic(r0.getModifiers()) == false) goto L13;
        if (Modifier.isPublic(r0.getDeclaringClass().getModifiers()) == false) goto L13;
        return r3;
    L13:
        if (r3.isAccessible() == true) goto L15;
        r3.setAccessible(true);
    L15:
        return r3;
    }

    private static Class<?> forName(String r1) {
        return INVOKESTATIC_com_ss_android_lark_chameleon_util_ReflectUtils_com_larus_mirabridge_impl_lancet_MiraReflectLancet_forName(r1);
    L4:
        e = move-exception;
        throw new ReflectException(e);
    }

    private Field getAccessibleField(String r4) {
        Class<?> r0 = type();
        return (Field) accessible(r0.getField(r4));
    L5:
        e = move-exception;
    L13:
        return (Field) accessible(r0.getDeclaredField(r4));
    L8:
        r0 = r0.getSuperclass();
        if (r0 != null) goto L13;
        throw new ReflectException(e);
    }

    private Class<?>[] getArgsType(Object... r4) {
        int r0 = 0;
        if (r4 == null) goto L5;
        Class<?>[] r1 = new Class[r4.length];
    L8:
        if (r0 >= r4.length) goto L14;
        Object r2 = r4[r0];
        if (r2 != null) goto L12;
        Class<?> r3 = NULL.class;
    L13:
        r1[r0] = r3;
        r0 = r0 + 1;
        goto L8
    L12:
        r3 = r2.getClass();
        goto L13
    L14:
        return r1;
    L5:
        return new Class[0];
    }

    private Field getField(String r3) throws IllegalAccessException {
        Field r4 = getAccessibleField(r3);
        if ((r4.getModifiers() & 16) == 16) goto L7;
    L5:
        return r4;
    L7:
        Field r0 = Field.class.getDeclaredField("modifiers");     // Catch: NoSuchFieldException -> L6
        r0.setAccessible(true);     // Catch: NoSuchFieldException -> L6
        r0.setInt(r4, r4.getModifiers() & (-17));     // Catch: NoSuchFieldException -> L6
        goto L5
    }

    public static <T> Class<T> getGenericClass(Object r2) {
        if (r2 != null) goto L5;
        return null;
    L5:
        Type r3 = r2.getClass().getGenericSuperclass();
        if ((r3 instanceof ParameterizedType) == false) goto L16;
        if (r3 != null) goto L9;
        Type[] r4 = null;
    L10:
        if (r4 != null) goto L12;
        return null;
    L12:
        if (r4.length > 0) goto L15;
        return null;
    L15:
        return (Class) r4[0];
    L9:
        r4 = ((ParameterizedType) r3).getActualTypeArguments();
        goto L10
    L16:
        return null;
    }

    public static <T> Class<T> getGenericInterfaceClass(Object r3) {
        if (r3 != null) goto L5;
        return null;
    L5:
        Class<?> r4 = r3.getClass();
    L6:
        if (r4 == null) goto L12;
        if (r4.getGenericInterfaces() == null) goto L11;
        if (r4.getGenericInterfaces().length != 0) goto L12;
    L11:
        r4 = r4.getSuperclass();
    L12:
        if (r4 != null) goto L14;
        return null;
    L14:
        Type[] r5 = r4.getGenericInterfaces();
        if (r5 != null) goto L17;
    L22:
        Type[] r6 = null;
    L23:
        if (r6 != null) goto L25;
        return null;
    L25:
        if (r6.length > 0) goto L28;
        return null;
    L28:
        return (Class) r6[0];
    L17:
        if (r5.length <= 0) goto L22;
        Type r7 = r5[0];
        if ((r7 instanceof ParameterizedType) == false) goto L22;
        r6 = ((ParameterizedType) r7).getActualTypeArguments();
        goto L23
    }

    private static String property(String r3) {
        int r0 = r3.length();
        if (r0 != 0) goto L7;
        return BuildConfig.FLAVOR;
    L7:
        if (r0 != 1) goto L11;
        return r3.toLowerCase();
    L11:
        return r3.substring(0, 1).toLowerCase() + r3.substring(1);
    }

    public static ReflectUtils reflect(Object r2) throws ReflectException {
        if (r2 != null) goto L5;
        Class<?> r1 = Object.class;
    L7:
        return new ReflectUtils(r1, r2);
    L5:
        r1 = r2.getClass();
        goto L7
    }

    private void sortConstructors(List<Constructor<?>> r2) {
        Collections.sort(r2, new AnonymousClass1(this));
    }

    private void sortMethods(List<Method> r2) {
        Collections.sort(r2, new AnonymousClass2(this));
    }

    private Object unwrap(Object r2) {
        if ((r2 instanceof ReflectUtils) == true) goto L5;
        return r2;
    L5:
        return ((ReflectUtils) r2).get();
    }

    public static Class<?> wrapper(Class<?> r1) {
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

    public boolean equals(Object r2) {
        if ((r2 instanceof ReflectUtils) == true) goto L5;
    L7:
        return false;
    L5:
        if (this.object.equals(((ReflectUtils) r2).get()) == false) goto L7;
        return true;
    }

    public ReflectUtils field(String r4) {
        Field r5 = getField(r4);     // Catch: IllegalAccessException -> L4
        return new ReflectUtils(r5.getType(), r5.get(this.object));
    L4:
        e = move-exception;
        throw new ReflectException(e);
    }

    public ReflectUtils method(String r2) throws ReflectException {
        return method(r2, new Object[0]);
    }

    public ReflectUtils newInstance(Object... r10) {
        Class<?>[] r0 = getArgsType(r10);
        return newInstance(type().getDeclaredConstructor(r0), r10);
    L5:
        e = move-exception;
        ArrayList r2 = new ArrayList();
        Constructor<?>[] r3 = type().getDeclaredConstructors();
        int r4 = r3.length;
        int r6 = 0;
    L7:
        if (r6 >= r4) goto L13;
        Constructor<?> r7 = r3[r6];
        if (match(r7.getParameterTypes(), r0) == false) goto L11;
        r2.add(r7);
    L11:
        r6 = r6 + 1;
        goto L7
    L13:
        if (r2.isEmpty() == true) goto L17;
        sortConstructors(r2);
        return newInstance((Constructor) ListProtector.get(r2, 0), r10);
    L17:
        throw new ReflectException(e);
    }

    public <P> P proxy(Class<P> r5) {
        final boolean r0 = this.object instanceof Map;
        InvocationHandler r1 = new AnonymousClass3(this, r0);
        return (P) Proxy.newProxyInstance(r5.getClassLoader(), new Class[]{r5}, r1);
    }

    public static ReflectUtils reflect(String r0) throws ReflectException {
        return reflect(forName(r0));
    }

    public static ReflectUtils reflect(Class<?> r1) throws ReflectException {
        return new ReflectUtils(r1);
    }

    private ReflectUtils(Class<?> r1, Object r2) {
        this.type = r1;
        this.object = r2;
    }

    private Method exactMethod(String r2, Class<?>[] r3) throws NoSuchMethodException {
        Class<?> r0 = type();
        return r0.getMethod(r2, r3);
    L15:
        return r0.getDeclaredMethod(r2, r3);
    L7:
        r0 = r0.getSuperclass();
        if (r0 != null) goto L15;
        throw new NoSuchMethodException();
    }

    private static Class<?> forName(String r1, ClassLoader r2) {
        return INVOKESTATIC_com_ss_android_lark_chameleon_util_ReflectUtils_com_larus_mirabridge_impl_lancet_MiraReflectLancet_forName(r1, true, r2);
    L5:
        e = move-exception;
        throw new ReflectException(e);
    }

    private boolean match(Class<?>[] r5, Class<?>[] r6) {
        if (r5.length != r6.length) goto L16;
        int r0 = 0;
    L6:
        if (r0 >= r6.length) goto L14;
        if (r6[r0] == NULL.class) goto L13;
        if (wrapper(r5[r0]).isAssignableFrom(wrapper(r6[r0])) == true) goto L13;
        return false;
    L13:
        r0 = r0 + 1;
        goto L6
    L14:
        return true;
    L16:
        return false;
    }

    private ReflectUtils newInstance(Constructor<?> r3, Object... r4) {
        return new ReflectUtils(r3.getDeclaringClass(), ((Constructor) accessible(r3)).newInstance(r4));
    L4:
        e = move-exception;
        throw new ReflectException(e);
    }

    public static ReflectUtils reflect(String r0, ClassLoader r1) throws ReflectException {
        return reflect(forName(r0, r1));
    }

    private Method similarMethod(String r9, Class<?>[] r10) throws NoSuchMethodException {
        Class<?> r0 = type();
        ArrayList r1 = new ArrayList();
        Method[] r2 = r0.getMethods();
        int r3 = r2.length;
        int r5 = 0;
    L3:
        if (r5 >= r3) goto L9;
        Method r6 = r2[r5];
        if (isSimilarSignature(r6, r9, r10) == false) goto L7;
        r1.add(r6);
    L7:
        r5 = r5 + 1;
        goto L3
    L9:
        if (r1.isEmpty() == true) goto L12;
        sortMethods(r1);
        return (Method) ListProtector.get(r1, 0);
    L12:
        Method[] r4 = r0.getDeclaredMethods();
        int r7 = r4.length;
        int r8 = 0;
    L13:
        if (r8 >= r7) goto L19;
        Method r11 = r4[r8];
        if (isSimilarSignature(r11, r9, r10) == false) goto L17;
        r1.add(r11);
    L17:
        r8 = r8 + 1;
        goto L13
    L19:
        if (r1.isEmpty() == false) goto L20;
        r0 = r0.getSuperclass();
        if (r0 != null) goto L12;
        throw new NoSuchMethodException("No similar method " + r9 + " with params " + Arrays.toString(r10) + " could be found on type " + type() + ".");
    L20:
        sortMethods(r1);
        return (Method) ListProtector.get(r1, 0);
    }

    public ReflectUtils field(String r2, Object r3) {
        getField(r2).set(this.object, unwrap(r3));     // Catch: Exception -> L4
        return this;
    L4:
        e = move-exception;
        throw new ReflectException(e);
    }

    public ReflectUtils method(String r4, Object... r5) throws ReflectException {
        Class<?>[] r0 = getArgsType(r5);
        return method(exactMethod(r4, r0), this.object, r5);
    L5:
        return method(similarMethod(r4, r0), this.object, r5);
    L7:
        e = move-exception;
        throw new ReflectException(e);
    }

    @Skip({"com.larus.mirabridge.impl.lancet+", "com.bytedance.mira.hook.delegate.DyMiraClassLoader", "com.bytedance.mira.hook.delegate.MiraClassLoader", "com.bytedance.ies.stark.util.NReflectUtils", "-com.bytedance.mira.core.PluginClassLoader", "com.bytedance.mira.core.opt.res+"})
    public static Class INVOKESTATIC_com_ss_android_lark_chameleon_util_ReflectUtils_com_larus_mirabridge_impl_lancet_MiraReflectLancet_forName(String r2, boolean r3, ClassLoader r4) throws ClassNotFoundException {
        ConcurrentHashMap r0 = FastClassNotFoundHandler.a;
        FastClassNotFoundHandler.Status r1 = FastClassNotFoundHandler.Status.STATUS_NOTING;
        if (a.a() == true) goto L34;
        Class r5 = access$002(r2, r3, r4);     // Catch: Throwable -> L8
        if (r1 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L7;
        FastClassNotFoundHandler.a(r2);     // Catch: Throwable -> L8
    L7:
        return r5;
    L8:
        th = move-exception;
        if (r1 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L12;
        FastClassNotFoundHandler.b(r2);
    L12:
        throw th;
    L34:
        Class r6 = access$002(r2, r3, r4);     // Catch: Throwable -> L17
        if (r1 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L16;
        FastClassNotFoundHandler.a(r2);     // Catch: Throwable -> L17
    L16:
        return r6;
    L17:
        th = move-exception;
        if (r1 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L22;
        FastClassNotFoundHandler.b(r2);
    L22:
        if ((th instanceof PluginClassNotFoundException) == false) goto L24;
        throw th;
    L24:
        if ((th instanceof ClassNotFoundException) == true) goto L30;
        if ((th instanceof NoClassDefFoundError) == true) goto L30;
        throw th;
    L30:
        return MiraPluginFix.forName(r2);
    }

    private boolean isSimilarSignature(Method r2, String r3, Class<?>[] r4) {
        if (r2.getName().equals(r3) == true) goto L5;
    L7:
        return false;
    L5:
        if (match(r2.getParameterTypes(), r4) == false) goto L7;
        return true;
    }

    private ReflectUtils method(Method r3, Object r4, Object... r5) {
        accessible(r3);     // Catch: Exception -> L8
        if (r3.getReturnType() != Void.TYPE) goto L7;
        r3.invoke(r4, r5);     // Catch: Exception -> L8
        return reflect(r4);
    L7:
        return reflect(r3.invoke(r4, r5));
    L8:
        e = move-exception;
        throw new ReflectException(e);
    }
}
