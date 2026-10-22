package com.facebook.imageutils;

import com.facebook.common.logging.FLog;
import com.facebook.imageformat.ImageFormat;
import java.io.InputStream;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/* JADX INFO: loaded from: classes2.dex */
public abstract class AvifFormatUtil {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Class f8448a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static ImageFormat f8449b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static ImageFormat f8450c;
    public static Method d;

    static {
        f8448a = Class.forName("com.bytedance.fresco.avif.AvifDecoder");     // Catch: Throwable -> L4
        return;
    L4:
        FLog.b("AvifFormatUtil", "No AvifDecoder class");
    }

    public static int[] a(InputStream r10) {
        int r5 = r10.available();
        byte[] r11 = new byte[r5];
        r10.reset();
        if (r10.read(r11, 0, r5) == (-1)) goto L18;
        Class r12 = f8448a;
        if (r12 != null) goto L19;
        return null;
    L19:
    L16:
        FLog.b("AvifFormatUtil", "IllegalAccessException happened when invoke parseSimpleMeta");
    L17:
        FLog.b("AvifFormatUtil", "No parseSimpleMeta method AvifDecoder");
    L15:
        FLog.b("AvifFormatUtil", "InvocationTargetException happened when invoke parseSimpleMeta");
    L14:
        FLog.b("AvifFormatUtil", "Exception happened when invoke parseSimpleMeta");
        goto L18
    L8:
        if (d != null) goto L10;
        d = r12.getDeclaredMethod("parseSimpleMeta", new Class[]{byte[].class, Integer.TYPE});     // Catch: Throwable -> L14 InvocationTargetException -> L15 IllegalAccessException -> L16 NoSuchMethodException -> L17
    L10:
        Method r13 = d;     // Catch: Throwable -> L14 InvocationTargetException -> L15 IllegalAccessException -> L16 NoSuchMethodException -> L17
        if (r13 == null) goto L18;
        r13.setAccessible(true);     // Catch: Throwable -> L14 InvocationTargetException -> L15 IllegalAccessException -> L16 NoSuchMethodException -> L17
        return (int[]) d.invoke(null, new Object[]{r11, Integer.valueOf(r5)});
    L18:
        return null;
    }
}
