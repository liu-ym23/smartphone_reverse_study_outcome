package org.lsposed.hiddenapibypass;

import android.util.Log;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.annotation.VisibleForTesting;
import dalvik.system.VMRuntime;
import java.lang.invoke.MethodHandle;
import java.lang.invoke.MethodHandleInfo;
import java.lang.invoke.MethodHandles;
import java.lang.reflect.Constructor;
import java.lang.reflect.Executable;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import sun.misc.Unsafe;

/* JADX INFO: loaded from: classes3.dex */
@RequiresApi(28)
public final class HiddenApiBypass {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final Unsafe f21031a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final long f21032b = 0;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static final long f21033c = 0;
    private static final long d = 0;
    private static final long e = 0;
    private static final long f = 0;
    private static final long g = 0;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private static final long f21034h = 0;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private static final long f21035i = 0;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private static final long f21036j = 0;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private static final long f21037k = 0;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private static final long f21038l = 0;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    private static final long f21039m = 0;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    private static final Set f21040n = null;

    static {
        f21040n = new HashSet();
        Unsafe r5 = (Unsafe) Unsafe.class.getDeclaredMethod("getUnsafe", null).invoke(null, null);     // Catch: ReflectiveOperationException -> L5
        f21031a = r5;     // Catch: ReflectiveOperationException -> L5
        f21032b = r5.objectFieldOffset(Helper$Executable.class.getDeclaredField("artMethod"));     // Catch: ReflectiveOperationException -> L5
        f21033c = r5.objectFieldOffset(Helper$Executable.class.getDeclaredField("declaringClass"));     // Catch: ReflectiveOperationException -> L5
        long r10 = r5.objectFieldOffset(Helper$MethodHandle.class.getDeclaredField("artFieldOrMethod"));     // Catch: ReflectiveOperationException -> L5
        d = r10;     // Catch: ReflectiveOperationException -> L5
        e = r5.objectFieldOffset(Helper$MethodHandleImpl.class.getDeclaredField("info"));     // Catch: ReflectiveOperationException -> L5
        long r11 = r5.objectFieldOffset(Helper$Class.class.getDeclaredField("methods"));     // Catch: ReflectiveOperationException -> L5
        f = r11;     // Catch: ReflectiveOperationException -> L5
        long r12 = r5.objectFieldOffset(Helper$Class.class.getDeclaredField("iFields"));     // Catch: ReflectiveOperationException -> L5
        g = r12;     // Catch: ReflectiveOperationException -> L5
        f21034h = r5.objectFieldOffset(Helper$Class.class.getDeclaredField("sFields"));     // Catch: ReflectiveOperationException -> L5
        f21035i = r5.objectFieldOffset(Helper$HandleInfo.class.getDeclaredField("member"));     // Catch: ReflectiveOperationException -> L5
        Method r13 = Helper$NeverCall.class.getDeclaredMethod("a", null);     // Catch: ReflectiveOperationException -> L5
        Method r14 = Helper$NeverCall.class.getDeclaredMethod("b", null);     // Catch: ReflectiveOperationException -> L5
        r13.setAccessible(true);     // Catch: ReflectiveOperationException -> L5
        r14.setAccessible(true);     // Catch: ReflectiveOperationException -> L5
        MethodHandle r15 = MethodHandles.lookup().unreflect(r13);     // Catch: ReflectiveOperationException -> L5
        MethodHandle r16 = MethodHandles.lookup().unreflect(r14);     // Catch: ReflectiveOperationException -> L5
        long r17 = r5.getLong(r15, r10);     // Catch: ReflectiveOperationException -> L5
        long r18 = r5.getLong(r16, r10);     // Catch: ReflectiveOperationException -> L5
        long r19 = r5.getLong(Helper$NeverCall.class, r11);     // Catch: ReflectiveOperationException -> L5
        long r20 = r18 - r17;     // Catch: ReflectiveOperationException -> L5
        f21036j = r20;     // Catch: ReflectiveOperationException -> L5
        f21037k = (r17 - r19) - r20;     // Catch: ReflectiveOperationException -> L5
        Field r21 = Helper$NeverCall.class.getDeclaredField("i");     // Catch: ReflectiveOperationException -> L5
        Field r22 = Helper$NeverCall.class.getDeclaredField("j");     // Catch: ReflectiveOperationException -> L5
        r21.setAccessible(true);     // Catch: ReflectiveOperationException -> L5
        r22.setAccessible(true);     // Catch: ReflectiveOperationException -> L5
        MethodHandle r23 = MethodHandles.lookup().unreflectGetter(r21);     // Catch: ReflectiveOperationException -> L5
        MethodHandle r24 = MethodHandles.lookup().unreflectGetter(r22);     // Catch: ReflectiveOperationException -> L5
        long r25 = r5.getLong(r23, r10);     // Catch: ReflectiveOperationException -> L5
        long r26 = r5.getLong(r24, r10);     // Catch: ReflectiveOperationException -> L5
        long r27 = r5.getLong(Helper$NeverCall.class, r12);     // Catch: ReflectiveOperationException -> L5
        f21038l = r26 - r25;     // Catch: ReflectiveOperationException -> L5
        f21039m = r25 - r27;     // Catch: ReflectiveOperationException -> L5
        return;
    L5:
        e = move-exception;
        Log.e("HiddenApiBypass", "Initialize error", e);
        throw new ExceptionInInitializerError(e);
    }

    public HiddenApiBypass() {
    }

    @VisibleForTesting
    public static boolean a(Class[] r5, Object[] r10) {
        if (r5.length == r10.length) goto L5;
        return false;
    L5:
        int r11 = 0;
    L7:
        if (r11 >= r5.length) goto L56;
        if (r5[r11].isPrimitive() == false) goto L50;
        Class r12 = r5[r11];
        if (r12 != Integer.TYPE) goto L16;
        if ((r10[r11] instanceof Integer) == true) goto L16;
        return false;
    L16:
        if (r12 != Byte.TYPE) goto L21;
        if ((r10[r11] instanceof Byte) == true) goto L21;
        return false;
    L21:
        if (r12 != Character.TYPE) goto L26;
        if ((r10[r11] instanceof Character) == true) goto L26;
        return false;
    L26:
        if (r12 != Boolean.TYPE) goto L31;
        if ((r10[r11] instanceof Boolean) == true) goto L31;
        return false;
    L31:
        if (r12 != Double.TYPE) goto L36;
        if ((r10[r11] instanceof Double) == true) goto L36;
        return false;
    L36:
        if (r12 != Float.TYPE) goto L41;
        if ((r10[r11] instanceof Float) == true) goto L41;
        return false;
    L41:
        if (r12 != Long.TYPE) goto L46;
        if ((r10[r11] instanceof Long) == true) goto L46;
        return false;
    L46:
        if (r12 != Short.TYPE) goto L55;
        if ((r10[r11] instanceof Short) == true) goto L55;
        return false;
    L55:
        r11 = r11 + 1;
        goto L7
    L50:
        Object r13 = r10[r11];
        if (r13 == null) goto L55;
        if (r5[r11].isInstance(r13) == true) goto L55;
        return false;
    L56:
        return true;
    }

    public static boolean addHiddenApiExemptions(String... r5) {
        Set r10 = f21040n;
        r10.addAll(Arrays.asList(r5));
        String[] r11 = new String[((HashSet) r10).size()];
        r10.toArray(r11);
        return setHiddenApiExemptions(r11);
    }

    public static boolean clearHiddenApiExemptions() {
        ((HashSet) f21040n).clear();
        return setHiddenApiExemptions(new String[0]);
    }

    @NonNull
    public static Constructor getDeclaredConstructor(@NonNull Class r5, @NonNull Class... r10) {
        Iterator r11 = getDeclaredMethods(r5).iterator();
    L4:
        if (r11.hasNext() == false) goto L21;
        Executable r12 = (Executable) r11.next();
        if ((r12 instanceof Constructor) == false) goto L4;
        Class<?>[] r13 = r12.getParameterTypes();
        if (r13.length != r10.length) goto L4;
        int r14 = 0;
    L13:
        if (r14 >= r10.length) goto L19;
        if (r10[r14] != r13[r14]) goto L4;
        r14 = r14 + 1;
        goto L13
    L19:
        return (Constructor) r12;
    L21:
        throw new NoSuchMethodException("Cannot find matching constructor");
    }

    @NonNull
    public static Method getDeclaredMethod(@NonNull Class r5, @NonNull String r10, @NonNull Class... r11) {
        Iterator r12 = getDeclaredMethods(r5).iterator();
    L4:
        if (r12.hasNext() == false) goto L24;
        Executable r13 = (Executable) r12.next();
        if (r13.getName().equals(r10) == false) goto L4;
        if ((r13 instanceof Method) == false) goto L4;
        Class<?>[] r14 = r13.getParameterTypes();
        if (r14.length != r11.length) goto L4;
        int r15 = 0;
    L16:
        if (r15 >= r11.length) goto L22;
        if (r11[r15] != r14[r15]) goto L4;
        r15 = r15 + 1;
        goto L16
    L22:
        return (Method) r13;
    L24:
        throw new NoSuchMethodException("Cannot find matching method");
    }

    @NonNull
    public static List getDeclaredMethods(@NonNull Class r14) {
        ArrayList r5 = new ArrayList();
        if (r14.isPrimitive() == false) goto L5;
    L16:
        return r5;
    L5:
        if (r14.isArray() == true) goto L16;
        Method r10 = Helper$NeverCall.class.getDeclaredMethod("a", null);     // Catch: Throwable -> L18
        r10.setAccessible(true);     // Catch: Throwable -> L18
        MethodHandle r11 = MethodHandles.lookup().unreflect(r10);     // Catch: Throwable -> L18
        Unsafe r12 = f21031a;
        long r13 = r12.getLong(r14, f);
        if (r13 != 0) goto L11;
        return r5;
    L11:
        int r15 = r12.getInt(r13);
        int r16 = 0;
    L12:
        if (r16 >= r15) goto L16;
        long r17 = ((((long) r16) * f21036j) + r13) + f21037k;
        Unsafe r18 = f21031a;
        r18.putLong(r11, d, r17);
        r18.putObject(r11, e, null);
        MethodHandles.lookup().revealDirect(r11);     // Catch: Throwable -> L17
    L15:
        Unsafe r19 = f21031a;
        r5.add((Executable) r19.getObject((MethodHandleInfo) r19.getObject(r11, e), f21035i));
        r16 = r16 + 1;
        goto L12
    }

    @NonNull
    public static List getInstanceFields(@NonNull Class r13) {
        ArrayList r5 = new ArrayList();
        if (r13.isPrimitive() == false) goto L5;
    L16:
        return r5;
    L5:
        if (r13.isArray() == true) goto L16;
        Field r10 = Helper$NeverCall.class.getDeclaredField("i");     // Catch: Throwable -> L18
        r10.setAccessible(true);     // Catch: Throwable -> L18
        MethodHandle r11 = MethodHandles.lookup().unreflectGetter(r10);     // Catch: Throwable -> L18
        Unsafe r12 = f21031a;
        long r14 = r12.getLong(r13, g);
        if (r14 != 0) goto L11;
        return r5;
    L11:
        int r15 = r12.getInt(r14);
        int r16 = 0;
    L12:
        if (r16 >= r15) goto L16;
        long r17 = ((((long) r16) * f21038l) + r14) + f21039m;
        Unsafe r18 = f21031a;
        r18.putLong(r11, d, r17);
        r18.putObject(r11, e, null);
        MethodHandles.lookup().revealDirect(r11);     // Catch: Throwable -> L17
    L15:
        Unsafe r19 = f21031a;
        r5.add((Field) r19.getObject((MethodHandleInfo) r19.getObject(r11, e), f21035i));
        r16 = r16 + 1;
        goto L12
    }

    @NonNull
    public static List getStaticFields(@NonNull Class r13) {
        ArrayList r5 = new ArrayList();
        if (r13.isPrimitive() == false) goto L5;
    L16:
        return r5;
    L5:
        if (r13.isArray() == true) goto L16;
        Field r10 = Helper$NeverCall.class.getDeclaredField("s");     // Catch: Throwable -> L18
        r10.setAccessible(true);     // Catch: Throwable -> L18
        MethodHandle r11 = MethodHandles.lookup().unreflectGetter(r10);     // Catch: Throwable -> L18
        Unsafe r12 = f21031a;
        long r14 = r12.getLong(r13, f21034h);
        if (r14 != 0) goto L11;
        return r5;
    L11:
        int r15 = r12.getInt(r14);
        int r16 = 0;
    L12:
        if (r16 >= r15) goto L16;
        long r17 = ((((long) r16) * f21038l) + r14) + f21039m;
        Unsafe r18 = f21031a;
        r18.putLong(r11, d, r17);
        r18.putObject(r11, e, null);
        MethodHandles.lookup().revealDirect(r11);     // Catch: Throwable -> L17
    L15:
        Unsafe r19 = f21031a;
        r5.add((Field) r19.getObject((MethodHandleInfo) r19.getObject(r11, e), f21035i));
        r16 = r16 + 1;
        goto L12
    }

    public static Object invoke(@NonNull Class r12, @Nullable Object r13, @NonNull String r14, Object... r15) {
        if (r13 != null) goto L5;
    L9:
        Method r5 = Helper$InvokeStub.class.getDeclaredMethod("invoke", new Class[]{Object[].class});
        r5.setAccessible(true);
        Unsafe r10 = f21031a;
        long r11 = r10.getLong(r12, f);
        if (r11 == 0) goto L23;
        int r16 = r10.getInt(r11);
        int r17 = 0;
    L12:
        if (r17 >= r16) goto L21;
        long r18 = ((((long) r17) * f21036j) + r11) + f21037k;
        f21031a.putLong(r5, f21032b, r18);
        if (r14.equals(r5.getName()) == false) goto L19;
        if (a(r5.getParameterTypes(), r15) == false) goto L19;
        return r5.invoke(r13, r15);
    L19:
        r17 = r17 + 1;
        goto L12
    L21:
        throw new NoSuchMethodException("Cannot find matching method");
    L23:
        throw new NoSuchMethodException("Cannot find matching method");
    L5:
        if (r12.isInstance(r13) == true) goto L9;
        throw new IllegalArgumentException("this object is not an instance of the given class");
    }

    public static Object newInstance(@NonNull Class r21, Object... r22) {
        Method r5 = Helper$InvokeStub.class.getDeclaredMethod("invoke", new Class[]{Object[].class});
        Constructor r10 = Helper$InvokeStub.class.getDeclaredConstructor(new Class[]{Object[].class});
        r10.setAccessible(true);
        Unsafe r11 = f21031a;
        long r12 = r11.getLong(r21, f);
        if (r12 == 0) goto L16;
        int r13 = r11.getInt(r12);
        int r15 = 0;
    L5:
        if (r15 >= r13) goto L14;
        long r16 = ((((long) r15) * f21036j) + r12) + f21037k;
        Unsafe r14 = f21031a;
        long r18 = f21032b;
        r14.putLong(r5, r18, r16);
        if ("<init>".equals(r5.getName()) == false) goto L12;
        r14.putLong(r10, r18, r16);
        r14.putObject(r10, f21033c, r21);
        if (a(r10.getParameterTypes(), r22) == false) goto L12;
        return r10.newInstance(r22);
    L12:
        r15 = r15 + 1;
        goto L5
    L14:
        throw new NoSuchMethodException("Cannot find matching constructor");
    L16:
        throw new NoSuchMethodException("Cannot find matching constructor");
    }

    public static boolean setHiddenApiExemptions(@NonNull String... r10) {
        invoke(VMRuntime.class, invoke(VMRuntime.class, null, "getRuntime", new Object[0]), "setHiddenApiExemptions", new Object[]{r10});     // Catch: Throwable -> L6
        return true;
    L6:
        th = move-exception;
        Log.w("HiddenApiBypass", "setHiddenApiExemptions", th);
        return false;
    }
}
