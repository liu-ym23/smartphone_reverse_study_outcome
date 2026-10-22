package com.bytedance.reparo.core;

import android.app.Application;
import android.content.Context;
import android.os.Build;
import android.widget.Toast;
import com.bytedance.reparo.core.exception.PatchException;
import com.bytedance.security.android.aopcheck.PolarisFileWrapper;
import com.larus.utils.logger.FLogger;
import com.obric.sva.sdk.session.IWakeupSessionConstant;
import d97.b;
import d97.d;
import dalvik.system.DexFile;
import e97.c;
import e97.f;
import e97.g;
import e97.i;
import java.io.File;
import java.io.IOException;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes6.dex */
public abstract class WandTrick {
    public static volatile WandTrick h;
    public static File i;
    public volatile boolean a;
    public boolean b;
    public Context c;
    public int d;
    public boolean e;
    public int f;
    public final Object g;

    public static abstract class a {
        public static final a b = null;
        public int a;

        public a() {
        }

        public abstract int a() throws Exception;

        public abstract boolean b(int r1);

        static {
            b = new a();
        }

        public final boolean c() throws Exception {
            int r0 = a();
            this.a = r0;
            return b(r0);
        }
    }

    public static native Object allocObject(Class r0);

    public static native Object callMethodDirect(Class r0, Object r1, Object r2, Object[] r3, Object[] r4, String r5, Class r6);

    public static native Object createInstance(Class r0, Constructor r1, Object[] r2, Object[] r3);

    private native int deoptimizeNative(Object[] r1, int[] r2, boolean r3, String[] r4, String[] r5, long[] r6);

    private native int initNative(boolean r1, String r2, boolean r3, String[] r4);

    public static native void removeClassesFromClassLinker(String[] r0, Object r1);

    public native boolean RuntimeGetStartupCompleted();

    public abstract a b(Application r1, boolean r2, Map<Class, h> r3, List<String> r4, List<String> r5, List<Object> r6, b r7, d r8) throws Exception;

    public native void changeClinitToPreverified(Class r1);

    public native void changeConstructorToPublic(Constructor r1);

    public native void changeFieldToPublic(Field r1);

    public native void changeMethodProtectedToPublic(Method r1);

    public native void changeMethodToPreverified(Object r1);

    public native void clearPointerArrayMemory(long r1, int r3);

    public native Constructor getClinitMethod(Class r1);

    public native boolean isSoLoaded(String r1);

    public native void markImageGenerateFinished();

    public native int nativeGetCheckRuntimeStartUp();

    public native int nativeGetHookRuntimeImageGenerateStatus();

    public native boolean nativeHasAnyAppImage();

    public native boolean nativeHasAppImageFor(String r1);

    public native int redefineClassesNative(Class[] r1, byte[][] r2, Object[] r3, int[] r4, Object[] r5, String[] r6, String[] r7, long[] r8);

    public native int replaceMethodNative(Object[] r1, Object[] r2, int[] r3, String[] r4, String[] r5, long[] r6);

    public static WandTrick f() {
        if (h != null) goto L18;
        monitor-enter(WandTrick.class);
    L14:
        th = move-exception;
        throw th;
    L7:
        if (h == null) goto L9;
    L12:
        monitor-exit(WandTrick.class);     // Catch: Throwable -> L14
        goto L18
    L9:
        if (Build.VERSION.SDK_INT < 26) goto L11;
        h = new b();     // Catch: Throwable -> L14
        goto L12
    L11:
        h = new f();     // Catch: Throwable -> L14
    L18:
        return h;
    }

    public WandTrick() {
        this.d = IWakeupSessionConstant.RC_ERROR;
        int r0 = 0;
        this.e = false;
        this.f = -1;
        this.g = new Object();
        if (i == null) goto L13;
        String[] r1 = com.bytedance.reparo.core.a.a;
        int r3 = r1.length;
        int r4 = 0;
    L5:
        if (r0 >= r3) goto L12;
        String r5 = r1[r0];
        PolarisFileWrapper r6 = new PolarisFileWrapper(i, r5);
        if (r6.exists() == false) goto L11;
        System.load(r6.getAbsolutePath());
        if (r5.equals("libreparo.so") == false) goto L11;
        r4 = 1;
    L11:
        r0 = r0 + 1;
        goto L5
    L12:
        r0 = r4;
    L13:
        if (r0 != 0) goto L27;
        a("reparo");
    L27:
        a("jato");     // Catch: Throwable -> L17
    L23:
        this.a = true;
        return;
    L17:
        th = move-exception;
        th.printStackTrace();
        a("jatolite");     // Catch: Throwable -> L21
    L21:
        th = move-exception;
        th.printStackTrace();
        goto L23
    }

    public static WandTrick e() throws Exception {
        f();
        if (h.d != Integer.MIN_VALUE) goto L15;
        WandTrick r0 = h;
        monitor-enter(r0);
    L11:
        th = move-exception;
        throw th;
    L7:
        if (h.d != Integer.MIN_VALUE) goto L9;
        h.h(o.c().e);     // Catch: Throwable -> L11
    L9:
        monitor-exit(r0);     // Catch: Throwable -> L11
    L15:
        if (h.d == 0) goto L17;
        int r1 = h.d;
        throw new PatchException("Failed to initialize wand trick, load skipped, initialize ret = " + r1, r1);
    L17:
        return h;
    }

    @JvmStatic
    public static void a(String r3) {
        Intrinsics.checkNotNullParameter(r3, "libName");
        FLogger r0 = FLogger.a;
        r0.i("Librarian_loadLib", "loadLibrary start libName -> ".concat(r3));
        com.bytedance.librarian.a.c(r3);
        r0.i("Librarian_loadLib", "loadLibrary success by librarian -> ".concat(r3));
    }

    public static ArrayList d(Class r6) {
        ArrayList r0 = new ArrayList();
        Method[] r1 = (Method[]) g.f(r6).b;
        int r2 = r1.length;
        int r3 = 0;
    L3:
        if (r3 >= r2) goto L8;
        Method r4 = r1[r3];
        if (r4.getDeclaringClass() != r6) goto L7;
        r0.add(r4);
    L7:
        r3 = r3 + 1;
        goto L3
    L8:
        return r0;
    }

    public static int[] g(Object[] r6) {
        int r0 = r6.length;
        int[] r1 = new int[r0];
        int r3 = 0;
    L3:
        if (r3 >= r0) goto L12;
        Object r4 = r6[r3];
        if ((r4 instanceof Method) == false) goto L8;
        r1[r3] = ((Method) r4).getModifiers();
    L11:
        r3 = r3 + 1;
        goto L3
    L8:
        if ((r4 instanceof Constructor) == false) goto L10;
        r1[r3] = ((Constructor) r4).getModifiers();
        goto L11
    L10:
        r1[r3] = 0;
        goto L11
    L12:
        return r1;
    }

    public static boolean i(String r5) {
        String[] r0 = com.bytedance.reparo.core.a.a;
        int r1 = r0.length;
        int r3 = 0;
    L3:
        if (r3 >= r1) goto L9;
        if (r0[r3].equals(r5) == true) goto L6;
        r3 = r3 + 1;
        goto L3
    L6:
        return true;
    L9:
        return false;
    }

    public final void h(i r9) {
        monitor-enter(this);
    L54:
        th = move-exception;
        throw th;
    L47:
        th = th;
        i r1 = null;
    L50:
        if (this.d == (-13)) goto L53;
        if (r1 == null) goto L53;
        r1.b();     // Catch: Throwable -> L54
    L53:
        throw th;     // Catch: Throwable -> L54
    L6:
        if (this.d == Integer.MIN_VALUE) goto L9;
        monitor-exit(this);
        return;
    L9:
        r1 = new i(r9.b(), f.b(this.c));     // Catch: Throwable -> L47
    L16:
        th = th;
        goto L50
    L11:
        if (i.e == false) goto L13;
        r1.a();     // Catch: Throwable -> L16
    L13:
        boolean r3 = true;
        this.b = true;     // Catch: Throwable -> L16
        Application r4 = r9.a;     // Catch: Throwable -> L16
        this.c = r4;     // Catch: Throwable -> L16
        if (r9.f != null) goto L18;
        r9.f = new PolarisFileWrapper(r4.getFilesDir(), f.b(r4) + "_init.info");     // Catch: Throwable -> L16
    L18:
        String r5 = r9.f.getAbsolutePath();     // Catch: Throwable -> L16
        int r6 = 0;
        if ((this.c.getApplicationInfo().flags & 2) != 0) goto L22;
        r3 = false;
    L22:
        if (r3 == false) goto L30;
        if (r9.g == true) goto L30;
        b97.a.b("Hotfix disabled under debuggable mode.");     // Catch: Throwable -> L16
        Toast.makeText(this.c, "Hotfix disabled under debuggable mode.", 0).show();     // Catch: Throwable -> L16
        this.d = -1;     // Catch: Throwable -> L16
        r1.b();     // Catch: Throwable -> L54
        monitor-exit(this);
        return;
    L30:
        if (this.a == false) goto L40;
        String[] r7 = new String[10];     // Catch: Throwable -> L16
        int r10 = initNative(this.b, r5, r9.h, r7);     // Catch: Throwable -> L16
        this.d = r10;     // Catch: Throwable -> L16
        if (r10 != Integer.MIN_VALUE) goto L34;
        c.b().execute(new q(this));     // Catch: Throwable -> L16
    L34:
        k.b r11 = k.a;     // Catch: Throwable -> L16
    L35:
        if (r6 >= 10) goto L41;
        String r12 = r7[r6];     // Catch: Throwable -> L16
        if (r12 == null) goto L41;
        k.a.d(r12);     // Catch: Throwable -> L16
        r6 = r6 + 1;     // Catch: Throwable -> L16
    L41:
        k.c("WandTrick", "initialize wand trick complete, ret = " + this.d);     // Catch: Throwable -> L16
        if (this.d == (-13)) goto L45;
        r1.b();     // Catch: Throwable -> L54
    L45:
        monitor-exit(this);
        return;
    L40:
        this.d = -2;     // Catch: Throwable -> L16
        goto L41
    }

    public final int c(Map r14, List r15, List r16, List r17, b r18) throws Exception {
        if (r14 == null) goto L61;
        if (r14.isEmpty() == true) goto L61;
        r18.b("prepare_for_deopt");
        Context r0 = this.c;
        HashMap<String, Class> r3 = n.a;
        ArrayList r4 = new ArrayList();
        PolarisFileWrapper r6 = new PolarisFileWrapper(r0.getFilesDir(), "hotfix_opt");     // Catch: Exception -> L34 ClassNotFoundException -> L36 IOException -> L38
        if (r6.exists() == true) goto L10;
        r6.mkdirs();     // Catch: Exception -> L34 ClassNotFoundException -> L36 IOException -> L38
    L13:
        Iterator r1 = r15.iterator();     // Catch: Exception -> L34 ClassNotFoundException -> L36 IOException -> L38
    L15:
        if (r1.hasNext() == false) goto L29;
        String r7 = (String) r1.next();     // Catch: Exception -> L34 ClassNotFoundException -> L36 IOException -> L38
        PolarisFileWrapper r8 = new PolarisFileWrapper(r7);     // Catch: Exception -> L34 ClassNotFoundException -> L36 IOException -> L38
        PolarisFileWrapper r9 = new PolarisFileWrapper(r6, r8.getName());     // Catch: Exception -> L34 ClassNotFoundException -> L36 IOException -> L38
        r8.setReadOnly();     // Catch: Exception -> L34 ClassNotFoundException -> L36 IOException -> L38
        DexFile r10 = DexFile.loadDex(r7, r9.getAbsolutePath(), 0);     // Catch: Exception -> L34 ClassNotFoundException -> L36 IOException -> L38
        n.b.add(r10);     // Catch: Exception -> L34 ClassNotFoundException -> L36 IOException -> L38
        if (r15.size() > 1) goto L25;
        if (r16 == null) goto L25;
        if (r16.isEmpty() == true) goto L25;
        Iterator r11 = r16.iterator();     // Catch: Exception -> L34 ClassNotFoundException -> L36 IOException -> L38
    L23:
        if (r11.hasNext() == false) goto L15;
        r4.add(n.i((String) r11.next(), r10));     // Catch: Exception -> L34 ClassNotFoundException -> L36 IOException -> L38
    L25:
        Enumeration<String> r12 = r10.entries();     // Catch: Exception -> L34 ClassNotFoundException -> L36 IOException -> L38
    L27:
        if (r12.hasMoreElements() == false) goto L15;
        r4.add(n.i(r12.nextElement(), r10));     // Catch: Exception -> L34 ClassNotFoundException -> L36 IOException -> L38
        goto L27
    L29:
        Iterator r2 = r4.iterator();     // Catch: Exception -> L34 ClassNotFoundException -> L36 IOException -> L38
    L30:
        if (r2.hasNext() == false) goto L40;
        ClassModifier.c((Class) r2.next(), false);     // Catch: Exception -> L34 ClassNotFoundException -> L36 IOException -> L38
    L40:
        if (r15 != null) goto L42;
    L48:
        ArrayList r5 = new ArrayList();
        Iterator r13 = r4.iterator();
    L50:
        if (r13.hasNext() == false) goto L58;
        Class<?> r19 = (Class) r13.next();
        r5.addAll(d(r19));
        ArrayList r20 = new ArrayList();
        Constructor<?>[] r21 = r19.getDeclaredConstructors();
        int r22 = r21.length;
        int r23 = 0;
    L52:
        if (r23 >= r22) goto L57;
        Constructor<?> r110 = r21[r23];
        if (r110.getDeclaringClass() != r19) goto L56;
        r20.add(r110);
    L56:
        r23 = r23 + 1;
        goto L52
    L57:
        r5.addAll(r20);
        goto L50
    L58:
        r5.addAll(r17);
        r18.a("prepare_for_deopt");
        Object[] r24 = r5.toArray();
        String[] r25 = new String[10];
        int[] r26 = g(r24);
        r18.b("deoptimizeNative");
        String[] r27 = new String[100];
        r18.e.add(r27);
        long[] r28 = new long[100];
        r18.f.add(r28);
        int r29 = deoptimizeNative(r24, r26, true, r25, r27, r28);
        r18.a("deoptimizeNative");
        k.d("deopt", r25);
        return r29;
    L42:
        if (r15.isEmpty() == true) goto L48;
        if (r4.isEmpty() == false) goto L48;
        throw new Exception("Invalid additional class.");
    L10:
        if (r6.isDirectory() == true) goto L13;
        r6.delete();     // Catch: Exception -> L34 ClassNotFoundException -> L36 IOException -> L38
        r6.mkdirs();     // Catch: Exception -> L34 ClassNotFoundException -> L36 IOException -> L38
    L38:
        e = e;
    L39:
        b97.a.c("load additional class failed.", e);
    L36:
        e = e;
    L34:
        e = move-exception;
        b97.a.c("load additional class failed.", e);
    L61:
        throw new Exception("Invalid patch info.");
    }
}
