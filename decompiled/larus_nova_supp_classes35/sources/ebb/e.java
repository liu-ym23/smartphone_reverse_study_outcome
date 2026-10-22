package ebb;

import android.text.TextUtils;
import com.bytedance.mira.exception.PluginClassNotFoundException;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.bytedance.security.android.aopcheck.PolarisFileWrapper;
import com.larus.mirabridge.impl.lancet.FastClassNotFoundHandler;
import com.larus.mirabridge.impl.lancet.MiraPluginFix;
import com.ss.android.lark.vfs.VFSFile;
import java.io.File;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.jvm.internal.ArrayIteratorKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import me.ele.lancet.base.annotations.Skip;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public final class e {
    public static Object a;
    public static Method b;

    static {
    }

    public e() {
    }

    @Skip({"com.larus.mirabridge.impl.lancet+", "com.bytedance.mira.hook.delegate.DyMiraClassLoader", "com.bytedance.mira.hook.delegate.MiraClassLoader", "com.bytedance.ies.stark.util.NReflectUtils", "-com.bytedance.mira.core.PluginClassLoader", "com.bytedance.common.jato.util.DeviceInfoUtils", "com.bytedance.mira.helper.ClassLoaderHelper", "com.bytedance.mira.core.opt.res+"})
    public static Class a() throws ClassNotFoundException {
        ConcurrentHashMap r0 = FastClassNotFoundHandler.a;
        FastClassNotFoundHandler.Status r1 = FastClassNotFoundHandler.Status.STATUS_NOTING;
        if (el9.a.a() == true) goto L34;
        Class<?> r2 = Class.forName("libcore.io.Libcore");     // Catch: Throwable -> L8
        if (r1 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L7;
        FastClassNotFoundHandler.a("libcore.io.Libcore");     // Catch: Throwable -> L8
    L7:
        return r2;
    L8:
        th = move-exception;
        if (r1 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L12;
        FastClassNotFoundHandler.b("libcore.io.Libcore");
    L12:
        throw th;
    L34:
        Class<?> r3 = Class.forName("libcore.io.Libcore");     // Catch: Throwable -> L17
        if (r1 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L16;
        FastClassNotFoundHandler.a("libcore.io.Libcore");     // Catch: Throwable -> L17
    L16:
        return r3;
    L17:
        th = move-exception;
        if (r1 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L22;
        FastClassNotFoundHandler.b("libcore.io.Libcore");
    L22:
        if ((th instanceof PluginClassNotFoundException) == false) goto L24;
        throw th;
    L24:
        if ((th instanceof ClassNotFoundException) == true) goto L30;
        if ((th instanceof NoClassDefFoundError) == true) goto L30;
        throw th;
    L30:
        return MiraPluginFix.forName("libcore.io.Libcore");
    }

    public static List b(File r5) {
        ArrayList r0 = new ArrayList();
        if (r5.exists() == true) goto L5;
    L21:
        return r0;
    L5:
        if (r5.isDirectory() == false) goto L21;
        File[] r6 = r5.listFiles();
        if (r6 != null) goto L10;
        return r0;
    L10:
        int r1 = r6.length;
        int r2 = 0;
    L11:
        if (r2 >= r1) goto L21;
        File r3 = r6[r2];
        if (r3.exists() == false) goto L20;
        if (r3.isFile() == false) goto L18;
        Intrinsics.checkNotNull(r3);
        r0.add(r3);
    L18:
        if (r3.isDirectory() == false) goto L20;
        r0.addAll(b(r3));
    L20:
        r2 = r2 + 1;
        goto L11
    }

    public static long f(File r4) {
        Intrinsics.checkNotNullParameter(r4, "folder");
        long r0 = 0;
        File[] r2 = r4.listFiles();     // Catch: Throwable -> L15
        if (r2 == null) goto L6;
        Iterator r5 = ArrayIteratorKt.iterator(r2);     // Catch: Throwable -> L15
    L9:
        if (r5.hasNext() == false) goto L17;
        File r3 = (File) r5.next();     // Catch: Throwable -> L15
        if (r3.isDirectory() == false) goto L13;
        Intrinsics.checkNotNull(r3);     // Catch: Throwable -> L15
        long r6 = f(r3);     // Catch: Throwable -> L15
    L14:
        r0 = r0 + r6;
        goto L9
    L13:
        r6 = r3.length();     // Catch: Throwable -> L15
    L17:
        return r0;
    L6:
        return r4.length();
    L15:
        th = move-exception;
        th.printStackTrace();
        goto L17
    }

    public static long g(File r7) {
        Intrinsics.checkNotNullParameter(r7, "file");
        boolean r2 = false;
        Field r3 = null;
        if (a != null) goto L6;
    L7:
        Field r0 = a().getDeclaredField("os");     // Catch: Throwable -> L35
        if (r0.isAccessible() == true) goto L10;
        r0.setAccessible(true);     // Catch: Throwable -> L35
    L10:
        Object r1 = r0.get(null);     // Catch: Throwable -> L35
        a = r1;     // Catch: Throwable -> L35
        if (r1 == null) goto L13;
        Method r4 = r1.getClass().getMethod("lstat", new Class[]{String.class});     // Catch: Throwable -> L35
    L14:
        b = r4;     // Catch: Throwable -> L35
    L16:
        if (r7.exists() == true) goto L19;
        return 0;
    L19:
        Method r5 = b;     // Catch: Throwable -> L35
        if (r5 == null) goto L22;
        Object r6 = r5.invoke(a, new Object[]{r7.getAbsolutePath()});     // Catch: Throwable -> L35
    L23:
        if (r6 == null) goto L25;
        r3 = r6.getClass().getDeclaredField("st_atime");     // Catch: Throwable -> L35
    L25:
        if (r3 != null) goto L27;
    L29:
        if (r2 == false) goto L31;
        r3.setAccessible(true);     // Catch: Throwable -> L35
    L31:
        if (r3 == null) goto L34;
        return r3.getLong(r6) * ((long) 1000);
    L34:
        return r7.lastModified();
    L27:
        if (r3.isAccessible() == true) goto L29;
        r2 = true;
        goto L29
    L22:
        r6 = null;
        goto L23
    L13:
        r4 = null;
        goto L14
    L6:
        if (b != null) goto L16;
    L36:
        return r7.lastModified();
    }

    public static List c(String r9, int r10) {
        List r11 = b(new PolarisFileWrapper(r9));
        Intrinsics.checkNotNullParameter(r11, "files");
        ArrayList r0 = new ArrayList();
        ArrayList r1 = (ArrayList) r11;
        if (r1.isEmpty() == true) goto L19;
        LinkedHashMap r2 = new LinkedHashMap();
        Iterator r3 = r1.iterator();
    L7:
        if (r3.hasNext() == false) goto L9;
        File r4 = (File) r3.next();
        r2.put(r4.getAbsolutePath(), Long.valueOf(g(r4)));
        goto L7
    L9:
        Collections.sort(r11, new d(r2));
        int r5 = 0;
        String r6 = com.larksuite.framework.utils.e.c(new Date(g((File) ListProtector.get(r11, 0))), "yyyy-MM-dd");
        Iterator r7 = r1.iterator();
    L11:
        if (r7.hasNext() == false) goto L18;
        String r8 = com.larksuite.framework.utils.e.c(new Date(g((File) r7.next())), "yyyy-MM-dd");
        if (TextUtils.equals(r8, r6) == true) goto L15;
        r10 = r10 - 1;
        r6 = r8;
    L15:
        if (r10 <= 0) goto L18;
        r5 = r5 + 1;
    L18:
        r0.addAll(r1.subList(r5, r1.size()));
    L19:
        return r0;
    }

    public static List d(String r8, int r9) {
        ArrayList r0 = new ArrayList();
        ArrayList r10 = (ArrayList) b(new PolarisFileWrapper(r8));
        if (r10.isEmpty() == false) goto L5;
        return r0;
    L5:
        Iterator r11 = r10.iterator();
    L7:
        if (r11.hasNext() == false) goto L11;
        File r1 = (File) r11.next();
        if ((Math.abs(System.currentTimeMillis() - g(r1)) - (((long) r9) * 86400000)) <= 0) goto L7;
        r0.add(r1);
        goto L7
    L11:
        return r0;
    }

    public static List e(VFSFile r8, String r9) {
        ArrayList r0 = new ArrayList();
        if (r8.exists() == true) goto L5;
    L23:
        return r0;
    L5:
        if (r8.isDirectory() == false) goto L23;
        if (TextUtils.isEmpty(r9) == false) goto L10;
        return r0;
    L10:
        File[] r10 = r8.listFiles();
        if (r10 != null) goto L13;
        return r0;
    L13:
        int r1 = r10.length;
        int r3 = 0;
    L14:
        if (r3 >= r1) goto L23;
        File r4 = r10[r3];
        if (r4.exists() == false) goto L22;
        if (r4.isFile() == false) goto L22;
        String r5 = r4.getName();
        Intrinsics.checkNotNull(r9);
        if (StringsKt.startsWith$default(r5, r9, false, 2, null) == false) goto L22;
        Intrinsics.checkNotNull(r4);
        r0.add(r4);
    L22:
        r3 = r3 + 1;
        goto L14
    }
}
