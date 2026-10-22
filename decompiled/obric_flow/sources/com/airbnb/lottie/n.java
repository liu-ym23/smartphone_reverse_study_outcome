package com.airbnb.lottie;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.PathMeasure;
import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.Callable;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;

/* JADX INFO: loaded from: classes.dex */
public abstract class n {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final HashMap f1293a = null;

    static {
        f1293a = new HashMap();
    }

    public static c0 a(String r5, Callable r10) {
        if (r5 != null) goto L4;
        h r11 = null;
    L5:
        if (r11 != null) goto L7;
        HashMap r12 = f1293a;
        if (r5 != null) goto L11;
    L14:
        c0 r13 = new c0(r10);
        if (r5 == null) goto L17;
        r13.b(new i(r5, 0));
        r13.a(new i(r5, 1));
        r12.put(r5, r13);
    L17:
        return r13;
    L11:
        if (r12.containsKey(r5) == false) goto L14;
        return (c0) r12.get(r5);
    L7:
        return new c0(new m(r11, 1));
    L4:
        r11 = (h) o.g.f20375b.f20376a.get(r5);
        goto L5
    }

    public static a0 b(InputStream r5, String r10) {
        nu.x r11 = f4.b.e(f4.b.p(r5));     // Catch: Throwable -> L5
        String[] r12 = com.airbnb.lottie.parser.moshi.a.e;     // Catch: Throwable -> L5
        a0 r13 = c(new com.airbnb.lottie.parser.moshi.b(r11), r10, true);     // Catch: Throwable -> L5
        u.f.b(r5);
        return r13;
    L5:
        th = move-exception;
        u.f.b(r5);
        throw th;
    }

    public static a0 c(com.airbnb.lottie.parser.moshi.b r5, String r10, boolean r11) {
        h r12 = t.q.a(r5);     // Catch: Throwable -> L9 Exception -> L11
        if (r10 == null) goto L5;
        o.g.f20375b.f20376a.put(r10, r12);     // Catch: Throwable -> L9 Exception -> L11
    L5:
        a0 r13 = new a0(r12);     // Catch: Throwable -> L9 Exception -> L11
        if (r11 == false) goto L8;
        u.f.b(r5);
    L8:
        return r13;
    L11:
        e = move-exception;
        a0 r14 = new a0(e);     // Catch: Throwable -> L9
        if (r11 == false) goto L15;
        u.f.b(r5);
    L15:
        return r14;
    L9:
        th = move-exception;
        if (r11 == false) goto L18;
        u.f.b(r5);
    L18:
        throw th;
    }

    public static a0 d(ZipInputStream r10, String r11) {
        HashMap r5 = new HashMap();
        ZipEntry r12 = r10.getNextEntry();     // Catch: IOException -> L9
        h r13 = null;
    L5:
        if (r12 == null) goto L23;
        String r14 = r12.getName();     // Catch: IOException -> L9
        if (r14.contains("__MACOSX") == false) goto L12;
        r10.closeEntry();     // Catch: IOException -> L9
    L21:
        r12 = r10.getNextEntry();     // Catch: IOException -> L9
        goto L5
    L12:
        if (r12.getName().contains(".json") == false) goto L15;
        nu.x r15 = f4.b.e(f4.b.p(r10));     // Catch: IOException -> L9
        String[] r16 = com.airbnb.lottie.parser.moshi.a.e;     // Catch: IOException -> L9
        r13 = (h) c(new com.airbnb.lottie.parser.moshi.b(r15), null, false).f1247a;     // Catch: IOException -> L9
        goto L21
    L15:
        if (r14.contains(".png") == false) goto L17;
    L20:
        String[] r17 = r14.split("/");     // Catch: IOException -> L9
        r5.put(r17[r17.length - 1], BitmapFactory.decodeStream(r10));     // Catch: IOException -> L9
        goto L21
    L17:
        if (r14.contains(".webp") == true) goto L20;
        r10.closeEntry();     // Catch: IOException -> L9
        goto L21
    L23:
        if (r13 == null) goto L25;
        Iterator r18 = r5.entrySet().iterator();
    L28:
        if (r18.hasNext() == false) goto L44;
        Map.Entry r19 = (Map.Entry) r18.next();
        String r20 = (String) r19.getKey();
        Iterator r21 = r13.d.values().iterator();
    L31:
        if (r21.hasNext() == false) goto L35;
        x r22 = (x) r21.next();
        if (r22.f1355c.equals(r20) == false) goto L31;
    L36:
        if (r22 == null) goto L28;
        Bitmap r23 = (Bitmap) r19.getValue();
        PathMeasure r24 = u.f.f22191a;
        int r25 = r23.getWidth();
        int r26 = r22.f1353a;
        int r27 = r22.f1354b;
        if (r25 == r26) goto L40;
    L42:
        Bitmap r28 = Bitmap.createScaledBitmap(r23, r26, r27, true);
        r23.recycle();
        r23 = r28;
    L43:
        r22.d = r23;
        goto L28
    L40:
        if (r23.getHeight() != r27) goto L42;
    L35:
        r22 = null;
        goto L36
    L44:
        Iterator r29 = r13.d.entrySet().iterator();
    L46:
        if (r29.hasNext() == false) goto L51;
        Map.Entry r30 = (Map.Entry) r29.next();
        if (((x) r30.getValue()).d != null) goto L46;
        return new a0(new IllegalStateException("There is no image for ".concat(((x) r30.getValue()).f1355c)));
    L51:
        if (r11 == null) goto L54;
        o.g.f20375b.f20376a.put(r11, r13);
    L54:
        return new a0(r13);
    L25:
        return new a0(new IllegalArgumentException("Unable to parse composition"));
    L9:
        e = move-exception;
        return new a0(e);
    }

    public static String e(int r5, Context r10) {
        StringBuilder r11 = new StringBuilder("rawRes");
        if ((r10.getResources().getConfiguration().uiMode & 48) != 32) goto L5;
        String r12 = "_night_";
    L6:
        r11.append(r12);
        r11.append(r5);
        return r11.toString();
    L5:
        r12 = "_day_";
        goto L6
    }
}
