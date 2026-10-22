package a0;

import android.content.ContentResolver;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Typeface;
import android.graphics.fonts.Font;
import android.graphics.fonts.FontFamily;
import android.os.Handler;
import android.os.Looper;
import android.os.ParcelFileDescriptor;
import g0.i;
import g0.j;
import g0.k;
import g0.m;
import g0.o;
import java.io.IOException;
import java.util.ArrayList;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/* JADX INFO: loaded from: classes.dex */
public final class e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final f f12a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final n.f<String, Typeface> f13b = null;

    public static class a extends t2.b {
        public final z.f.e H;

        public a(z.f.e r8) {
            this.H = r8;
        }
    }

    static {
        f12a = new f();
        f13b = new n.f(16);
    }

    public static Typeface a(Context r10, m[] r11, int r12) {
        f12a.getClass();
        ContentResolver r13 = r10.getContentResolver();
        int r8 = r11.length;     // Catch: Exception -> L32
        FontFamily.Builder r14 = null;
        int r15 = 0;
    L4:
        if (r15 >= r8) goto L27;
        m r16 = r11[r15];     // Catch: Exception -> L32
        ParcelFileDescriptor r17 = r13.openFileDescriptor(r16.f7528a, "r", null);     // Catch: IOException -> L31 Exception -> L32
        if (r17 != null) goto L39;
        if (r17 == null) goto L26;
    L18:
        r17.close();     // Catch: IOException -> L31 Exception -> L32
        goto L26
    L39:
        Font.Builder r18 = new Font.Builder(r17).setWeight(r16.f7530c);     // Catch: Throwable -> L20
        if (r16.f7531d == false) goto L13;
        int r19 = 1;
    L14:
        Font r20 = r18.setSlant(r19).setTtcIndex(r16.f7529b).build();     // Catch: Throwable -> L20
        if (r14 != null) goto L17;
        r14 = new FontFamily.Builder(r20);     // Catch: Throwable -> L20
        goto L18
    L17:
        r14.addFont(r20);     // Catch: Throwable -> L20
        goto L18
    L13:
        r19 = 0;
    L20:
        th = move-exception;
        r17.close();     // Catch: Throwable -> L23
    L25:
        throw th;     // Catch: IOException -> L31 Exception -> L32
    L23:
        th = move-exception;
        th.addSuppressed(th);     // Catch: IOException -> L31 Exception -> L32
    L26:
        r15 = r15 + 1;
        goto L4
    L27:
        if (r14 == null) goto L45;
        FontFamily r21 = r14.build();     // Catch: Exception -> L32
        return new Typeface.CustomFallbackBuilder(r21).setStyle(f.a(r21, r12).getStyle()).build();
    L45:
        return null;
    L46:
        return null;
    }

    public static Typeface b(Context r14, z.d.b r15, Resources r16, int r17, String r18, int r19, int r20, z.f.e r21, boolean r22) {
        boolean r8 = false;
        Typeface r10 = null;
        if ((r15 instanceof z.d.e) == false) goto L70;
        z.d.e r11 = (z.d.e) r15;
        String r12 = r11.f14143d;
        if (r12 != null) goto L7;
    L14:
        Typeface r13 = null;
    L15:
        if (r13 == null) goto L19;
        if (r21 == null) goto L18;
        r21.b(r13);
    L18:
        return r13;
    L19:
        if (r22 == true) goto L21;
        if (r21 != null) goto L26;
    L24:
        r8 = true;
    L26:
        if (r22 == false) goto L28;
        int r23 = r11.f14141b;
    L29:
        Handler r24 = new Handler(Looper.getMainLooper());
        a r110 = new a(r21);
        g0.f r25 = r11.f14140a;
        g0.c r26 = new g0.c(r110, r24);
        if (r8 == false) goto L50;
        n.f<String, Typeface> r27 = k.f7520a;
        String r28 = r25.f7509e + "-" + r20;
        Typeface r29 = k.f7520a.a(r28);
        if (r29 == null) goto L34;
        r26.a(new k.a(r29));
        r10 = r29;
    L97:
        if (r10 == null) goto L99;
        f13b.b(d(r16, r17, r18, r19, r20), r10);
    L99:
        return r10;
    L34:
        if (r23 != (-1)) goto L111;
        k.a r30 = k.a(r28, r14, r25, r20);
        r26.a(r30);
        r10 = r30.f7524a;
        goto L97
    L111:
    L49:
        r26.a(new k.a(-3));
        goto L97
    L112:
        k.a r31 = (k.a) k.f7521b.submit(new g0.g(r28, r14, r25, r20)).get(r23, TimeUnit.MILLISECONDS);     // Catch: InterruptedException -> L49
        r26.a(r31);     // Catch: InterruptedException -> L49
        r10 = r31.f7524a;     // Catch: InterruptedException -> L49
        goto L97
    L44:
        e = move-exception;
        throw e;     // Catch: InterruptedException -> L49
    L46:
        e = move-exception;
        throw new RuntimeException(e);     // Catch: InterruptedException -> L49
    L43:
        throw new InterruptedException("timeout");     // Catch: InterruptedException -> L49
    L50:
        n.f<String, Typeface> r32 = k.f7520a;
        String r33 = r25.f7509e + "-" + r20;
        Typeface r34 = k.f7520a.a(r33);
        if (r34 == null) goto L53;
        r26.a(new k.a(r34));
        r10 = r34;
        goto L97
    L53:
        g0.h r35 = new g0.h(r26);
        Object r36 = k.f7522c;
        monitor-enter(r36);
        n.h<String, ArrayList<i0.a<k.a>>> r37 = k.f7523d;     // Catch: Throwable -> L67
        ArrayList<i0.a<k.a>> r38 = r37.getOrDefault(r33, null);     // Catch: Throwable -> L67
        if (r38 == null) goto L60;
        r38.add(r35);     // Catch: Throwable -> L67
        monitor-exit(r36);     // Catch: Throwable -> L67
    L108:
        goto L97
    L60:
        ArrayList<i0.a<k.a>> r39 = new ArrayList();     // Catch: Throwable -> L67
        r39.add(r35);     // Catch: Throwable -> L67
        r37.put(r33, r39);     // Catch: Throwable -> L67
        monitor-exit(r36);     // Catch: Throwable -> L67
        i r40 = new i(r33, r14, r25, r20);
        ThreadPoolExecutor r41 = k.f7521b;
        j r42 = new j(r33);
        if (Looper.myLooper() != null) goto L65;
        Handler r43 = new Handler(Looper.getMainLooper());
    L66:
        r41.execute(new o(r43, r40, r42));
        goto L108
    L65:
        r43 = new Handler();
    L67:
        th = move-exception;
        throw th;
    L28:
        r23 = -1;
        goto L29
    L21:
        if (r11.f14142c != 0) goto L26;
    L7:
        if (r12.isEmpty() == true) goto L14;
        r13 = Typeface.create(r12, 0);
        Typeface r44 = Typeface.create(Typeface.DEFAULT, 0);
        if (r13 == null) goto L14;
        if (r13.equals(r44) == true) goto L14;
    L70:
        z.d.c r45 = (z.d.c) r15;
        f12a.getClass();
        z.d.C0201d[] r46 = r45.f14134a;     // Catch: Exception -> L92
        int r47 = r46.length;     // Catch: Exception -> L92
        int r48 = 0;
        FontFamily.Builder r49 = null;
    L72:
        if (r48 >= r47) goto L88;
        z.d.C0201d r111 = r46[r48];     // Catch: Exception -> L92
    L102:
        Font.Builder r112 = new Font.Builder(r16, r111.f14139e).setWeight(r111.f14135a);     // Catch: IOException -> L100 Exception -> L101
        if (r111.f14136b == false) goto L79;
        int r113 = 1;
    L80:
        Font r114 = r112.setSlant(r113).setTtcIndex(r111.f14138d).setFontVariationSettings(r111.f14137c).build();     // Catch: IOException -> L100 Exception -> L101
        if (r49 != null) goto L83;
        r49 = new FontFamily.Builder(r114);     // Catch: IOException -> L100 Exception -> L101
        goto L86
    L83:
        r49.addFont(r114);     // Catch: IOException -> L100 Exception -> L101
        goto L86
    L79:
        r113 = 0;
    L86:
        r48 = r48 + 1;
        goto L72
    L88:
        if (r49 == null) goto L93;
        FontFamily r50 = r49.build();     // Catch: Exception -> L101
        r10 = new Typeface.CustomFallbackBuilder(r50).setStyle(f.a(r50, r20).getStyle()).build();     // Catch: Exception -> L101
    L93:
        if (r21 == null) goto L97;
        if (r10 == null) goto L96;
        r21.b(r10);
        goto L97
    L96:
        r21.a(-3);
        goto L97
    }

    public static Typeface c(Resources r8, int r10, String r11, int r12, int r13) {
        f12a.getClass();
        Font r14 = new Font.Builder(r8, r10).build();     // Catch: Exception -> L5
        Typeface r15 = new Typeface.CustomFallbackBuilder(new FontFamily.Builder(r14).build()).setStyle(r14.getStyle()).build();     // Catch: Exception -> L5
    L6:
        if (r15 == null) goto L8;
        String r16 = d(r8, r10, r11, r12, r13);
        f13b.b(r16, r15);
    L8:
        return r15;
    L5:
        r15 = null;
        goto L6
    }

    public static String d(Resources r8, int r10, String r11, int r12, int r13) {
        return r8.getResourcePackageName(r10) + '-' + r11 + '-' + r12 + '-' + r10 + '-' + r13;
    }
}
