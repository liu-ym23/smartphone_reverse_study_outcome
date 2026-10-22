package com.bytedance.reparo.core;

import android.text.TextUtils;
import com.bytedance.mira.exception.PluginClassNotFoundException;
import com.bytedance.mt.protector.impl.string2number.CastIntegerProtector;
import com.larus.mirabridge.impl.lancet.FastClassNotFoundHandler;
import com.larus.mirabridge.impl.lancet.MiraPluginFix;
import dalvik.system.DexFile;
import el9.a;
import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.concurrent.ConcurrentHashMap;
import me.ele.lancet.base.annotations.Skip;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes6.dex */
public final class n {
    public static final HashMap<String, Class> a = null;
    public static final ArrayList<DexFile> b = null;
    public static final String c = null;

    public n() {
    }

    public static boolean h() {
        String r1 = c;     // Catch: Exception -> L13
        if (r1 != null) goto L6;
        return true;
    L6:
        if (r1.length() < 1) goto L17;
        if (CastIntegerProtector.parseInt(String.valueOf(r1.charAt(0))) >= 2) goto L18;
        return false;
    L18:
        return true;
    L17:
        return true;
    L19:
        return true;
    }

    static {
        a = new HashMap();
        b = new ArrayList();
        c = System.getProperty("java.vm.version", "");
    }

    @Skip({"com.larus.mirabridge.impl.lancet+", "com.bytedance.mira.hook.delegate.DyMiraClassLoader", "com.bytedance.mira.hook.delegate.MiraClassLoader", "com.bytedance.ies.stark.util.NReflectUtils", "-com.bytedance.mira.core.PluginClassLoader", "com.bytedance.common.jato.util.DeviceInfoUtils", "com.bytedance.mira.helper.ClassLoaderHelper", "com.bytedance.mira.core.opt.res+"})
    public static Class b() throws ClassNotFoundException {
        ConcurrentHashMap r0 = FastClassNotFoundHandler.a;
        FastClassNotFoundHandler.Status r1 = FastClassNotFoundHandler.Status.STATUS_NOTING;
        if (a.a() == true) goto L34;
        Class<?> r2 = Class.forName("android.os.SystemProperties");     // Catch: Throwable -> L8
        if (r1 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L7;
        FastClassNotFoundHandler.a("android.os.SystemProperties");     // Catch: Throwable -> L8
    L7:
        return r2;
    L8:
        th = move-exception;
        if (r1 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L12;
        FastClassNotFoundHandler.b("android.os.SystemProperties");
    L12:
        throw th;
    L34:
        Class<?> r3 = Class.forName("android.os.SystemProperties");     // Catch: Throwable -> L17
        if (r1 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L16;
        FastClassNotFoundHandler.a("android.os.SystemProperties");     // Catch: Throwable -> L17
    L16:
        return r3;
    L17:
        th = move-exception;
        if (r1 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L22;
        FastClassNotFoundHandler.b("android.os.SystemProperties");
    L22:
        if ((th instanceof PluginClassNotFoundException) == false) goto L24;
        throw th;
    L24:
        if ((th instanceof ClassNotFoundException) == true) goto L30;
        if ((th instanceof NoClassDefFoundError) == true) goto L30;
        throw th;
    L30:
        return MiraPluginFix.forName("android.os.SystemProperties");
    }

    public static String a(String r6) {
        int r0 = r6.length();
        if (r0 > 1) goto L5;
        return r6;
    L5:
        if (r6.charAt(0) != 'L') goto L11;
        int r1 = r0 - 1;
        if (r6.charAt(r1) != ';') goto L11;
        return r6.substring(1, r1).replace('/', '.');
    L11:
        return r6.replace('/', '.');
    }

    public static String c(Constructor r4) {
        StringBuilder r0 = new StringBuilder("(");
        Class<?>[] r5 = r4.getParameterTypes();
        int r1 = 0;
    L4:
        if (r1 >= r5.length) goto L9;
        String r2 = g(r5[r1]);
        if (TextUtils.isEmpty(r2) == true) goto L8;
        r0.append(r2);
    L8:
        r1 = r1 + 1;
        goto L4
    L9:
        r0.append(")");
        r0.append(e(Void.TYPE));
        return r0.toString();
    }

    public static String d(Method r5) {
        StringBuilder r0 = new StringBuilder("(");
        Class<?>[] r1 = r5.getParameterTypes();
        int r2 = 0;
    L4:
        if (r2 >= r1.length) goto L9;
        String r3 = g(r1[r2]);
        if (TextUtils.isEmpty(r3) == true) goto L8;
        r0.append(r3);
    L8:
        r2 = r2 + 1;
        goto L4
    L9:
        r0.append(")");
        r0.append(g(r5.getReturnType()));
        return r0.toString();
    }

    public static String e(Class<?> r1) {
        if (Boolean.TYPE.equals(r1) == false) goto L7;
        return "Z";
    L7:
        if (Byte.TYPE.equals(r1) == false) goto L11;
        return "B";
    L11:
        if (Character.TYPE.equals(r1) == false) goto L15;
        return "C";
    L15:
        if (Short.TYPE.equals(r1) == false) goto L19;
        return "S";
    L19:
        if (Integer.TYPE.equals(r1) == false) goto L23;
        return "I";
    L23:
        if (Long.TYPE.equals(r1) == false) goto L27;
        return "J";
    L27:
        if (Float.TYPE.equals(r1) == false) goto L31;
        return "F";
    L31:
        if (Double.TYPE.equals(r1) == false) goto L35;
        return "D";
    L35:
        if (Void.TYPE.equals(r1) == false) goto L38;
        return "V";
    L38:
        return null;
    }

    public static String g(Class<?> r2) {
        if (r2.isPrimitive() == false) goto L7;
        return e(r2);
    L7:
        if (r2.isArray() == true) goto L9;
        String r3 = r2.getName().replace('.', '/');
        if (r3.length() > 0) goto L13;
        return r3;
    L13:
        if (r3.charAt(0) != '[') goto L15;
        return r3;
    L15:
        return "L" + r3 + ";";
    L9:
        return "[" + g(r2.getComponentType());
    }

    public static String f(String r3, String r4) {
        return "L" + r3.replaceAll("\\.", "_") + "_" + r4.replaceAll("<", "_i_").replaceAll(">", "_i_");
    }

    public static Class i(String r4, DexFile r5) throws Exception {
        Class r6 = r5.loadClass(r4, n.class.getClassLoader());
        if (r6 == null) goto L36;
        String r7 = r6.getName();
        ClassLoader r0 = r6.getClassLoader();
        ConcurrentHashMap r1 = FastClassNotFoundHandler.a;
        FastClassNotFoundHandler.Status r2 = FastClassNotFoundHandler.Status.STATUS_NOTING;
        if (a.a() == true) goto L39;
        Class.forName(r7, false, r0);     // Catch: Throwable -> L10
        if (r2 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L32;
        FastClassNotFoundHandler.a(r7);     // Catch: Throwable -> L10
    L32:
        a.put(r6.getName(), r6);
        return r6;
    L10:
        th = move-exception;
        if (r2 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L14;
        FastClassNotFoundHandler.b(r7);
    L14:
        throw th;
    L39:
        Class.forName(r7, false, r0);     // Catch: Throwable -> L19
        if (r2 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L32;
        FastClassNotFoundHandler.a(r7);     // Catch: Throwable -> L19
    L19:
        th = move-exception;
        if (r2 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L24;
        FastClassNotFoundHandler.b(r7);
    L24:
        if ((th instanceof PluginClassNotFoundException) == false) goto L26;
        throw th;
    L26:
        if ((th instanceof ClassNotFoundException) == false) goto L28;
    L31:
        MiraPluginFix.forName(r7);
        goto L32
    L28:
        if ((th instanceof NoClassDefFoundError) == true) goto L31;
        throw th;
    L36:
        throw new ClassNotFoundException(r4);
    }
}
