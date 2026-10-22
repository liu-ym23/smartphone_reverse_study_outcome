package com.facebook.imageutils;

import com.facebook.common.logging.FLog;
import com.facebook.imageformat.ImageFormat;
import java.io.InputStream;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/* JADX INFO: loaded from: classes2.dex */
public abstract class HeifFormatUtil {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static volatile Class f8453a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final Class f8454b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static ImageFormat f8455c;
    public static ImageFormat d;
    public static Method e;
    public static Method f;

    static {
        f8454b = Class.forName("com.bytedance.fresco.heif.HeifDecoder");     // Catch: ClassNotFoundException -> L4
        return;
    L4:
        e = move-exception;
        FLog.a("HeifFormatUtil", "Heif init ", e);
    }

    public static ImageFormat a() {
        ImageFormat r5 = d;
        if (r5 == null) goto L5;
        return r5;
    L5:
        Class r10 = f8454b;
        if (r10 != null) goto L21;
        return null;
    L21:
        d = (ImageFormat) r10.getDeclaredField("HEIF_FORMAT_ANIMATED").get(null);     // Catch: Exception -> L10 IllegalAccessException -> L12 NoSuchFieldException -> L14
    L20:
        return d;
    L12:
        e = move-exception;
        FLog.a("HeifFormatUtil", "HEIF_FORMAT_ANIMATED init ", e);
    L14:
        e = move-exception;
        FLog.a("HeifFormatUtil", "HEIF_FORMAT_ANIMATED init ", e);
    L10:
        e = move-exception;
        e.printStackTrace();
        goto L20
    }

    public static int[] b(InputStream r10) {
        if (r10 != null) goto L5;
        return null;
    L5:
        int r5 = r10.available();
        byte[] r11 = new byte[r5];
        r10.reset();
        if (r10.read(r11, 0, r5) != (-1)) goto L8;
        return null;
    L8:
        monitor-enter(HeifFormatUtil.class);
    L13:
        th = move-exception;
        throw th;
    L10:
        if (f8453a == null) goto L44;
    L17:
        Class r12 = f8453a;     // Catch: Throwable -> L13
        monitor-exit(HeifFormatUtil.class);     // Catch: Throwable -> L13
        if (r12 != null) goto L48;
        return null;
    L48:
    L28:
        e = move-exception;
        e.printStackTrace();
    L40:
        return null;
    L30:
        e = move-exception;
        e.printStackTrace();
    L26:
        e = move-exception;
        e.printStackTrace();
    L24:
        e = move-exception;
        e.printStackTrace();
        goto L40
    L22:
        if (f != null) goto L32;
        f = r12.getDeclaredMethod("parseThumbMeta", new Class[]{byte[].class, Integer.TYPE});     // Catch: Exception -> L24 InvocationTargetException -> L26 IllegalAccessException -> L28 NoSuchMethodException -> L30
    L32:
        Method r13 = f;     // Catch: Exception -> L24 InvocationTargetException -> L26 IllegalAccessException -> L28 NoSuchMethodException -> L30
        if (r13 == null) goto L40;
        r13.setAccessible(true);     // Catch: Exception -> L24 InvocationTargetException -> L26 IllegalAccessException -> L28 NoSuchMethodException -> L30
        return (int[]) f.invoke(null, new Object[]{r11, Integer.valueOf(r5)});
    L44:
        f8453a = Class.forName("com.bytedance.fresco.nativeheif.Heif");     // Catch: Throwable -> L13 ClassNotFoundException -> L15
    L15:
        e = move-exception;
        FLog.a("HeifFormatUtil", "Heif init ", e);     // Catch: Throwable -> L13
        goto L17
    }

    public static int[] a(InputStream r10) {
        int r5 = r10.available();
        byte[] r11 = new byte[r5];
        r10.reset();
        if (r10.read(r11, 0, r5) != (-1)) goto L5;
        return null;
    L5:
        monitor-enter(HeifFormatUtil.class);
    L10:
        th = move-exception;
        throw th;
    L7:
        if (f8453a == null) goto L43;
    L14:
        Class r12 = f8453a;     // Catch: Throwable -> L10
        monitor-exit(HeifFormatUtil.class);     // Catch: Throwable -> L10
        if (r12 != null) goto L45;
        return null;
    L45:
    L25:
        e = move-exception;
        e.printStackTrace();
    L37:
        return null;
    L27:
        e = move-exception;
        e.printStackTrace();
    L23:
        e = move-exception;
        e.printStackTrace();
    L21:
        e = move-exception;
        e.printStackTrace();
        goto L37
    L19:
        if (e != null) goto L29;
        e = r12.getDeclaredMethod("parseSimpleMeta", new Class[]{byte[].class, Integer.TYPE});     // Catch: Exception -> L21 InvocationTargetException -> L23 IllegalAccessException -> L25 NoSuchMethodException -> L27
    L29:
        Method r13 = e;     // Catch: Exception -> L21 InvocationTargetException -> L23 IllegalAccessException -> L25 NoSuchMethodException -> L27
        if (r13 == null) goto L37;
        r13.setAccessible(true);     // Catch: Exception -> L21 InvocationTargetException -> L23 IllegalAccessException -> L25 NoSuchMethodException -> L27
        return (int[]) e.invoke(null, new Object[]{r11, Integer.valueOf(r5)});
    L43:
        f8453a = Class.forName("com.bytedance.fresco.nativeheif.Heif");     // Catch: Throwable -> L10 ClassNotFoundException -> L12
    L12:
        e = move-exception;
        FLog.a("HeifFormatUtil", "Heif init ", e);     // Catch: Throwable -> L10
        goto L14
    }
}
