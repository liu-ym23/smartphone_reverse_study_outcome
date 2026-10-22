package com.bytedance.common.utility;

import android.os.Looper;
import android.text.TextUtils;
import android.util.Log;
import android.util.Printer;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public final class e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static int f1981a = 5;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static b f1982b;
    private static a c;
    private static boolean d;
    private static Printer e;

    public interface a {
        void a(long r1);
    }

    static class b implements Printer {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        List<Printer> f1983a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        List<Printer> f1984b;
        List<Printer> c;
        boolean d;
        boolean e;

        b() {
            this.f1983a = new ArrayList();
            this.f1984b = new ArrayList();
            this.c = new ArrayList();
            this.d = false;
            this.e = false;
        }

        @Override // android.util.Printer
        public void println(String r10) {
            if (TextUtils.isEmpty(r10) == false) goto L6;
            return;
        L6:
            if (e.c() == null) goto L8;
            long r3 = System.currentTimeMillis();
        L10:
            if (r10.charAt(0) != '>') goto L21;
            if (this.e == false) goto L21;
            Iterator<Printer> r5 = this.c.iterator();
        L15:
            if (r5.hasNext() == false) goto L19;
            Printer r6 = (Printer) ZeusTransformUtils.preCheckCast(r5.next(), Printer.class, "com.obric.memorydata.plugin");
            if (this.f1983a.contains(r6) == true) goto L15;
            this.f1983a.add(r6);
            goto L15
        L19:
            this.c.clear();
            this.e = false;
        L21:
            if (this.f1983a.size() <= e.d()) goto L23;
            Log.e("LooperPrinterUtils", "wrapper contains too many printer,please check if the useless printer have been removed");
        L23:
            Iterator<Printer> r7 = this.f1983a.iterator();
        L25:
            if (r7.hasNext() == false) goto L30;
            Printer r8 = (Printer) ZeusTransformUtils.preCheckCast(r7.next(), Printer.class, "com.obric.memorydata.plugin");
            if (r8 == null) goto L25;
            r8.println(r10);
            goto L25
        L30:
            if (r10.charAt(0) != '<') goto L39;
            if (this.d == false) goto L39;
            Iterator<Printer> r11 = this.f1984b.iterator();
        L35:
            if (r11.hasNext() == false) goto L37;
            Printer r9 = (Printer) ZeusTransformUtils.preCheckCast(r11.next(), Printer.class, "com.obric.memorydata.plugin");
            this.f1983a.remove(r9);
            this.c.remove(r9);
            goto L35
        L37:
            this.f1984b.clear();
            this.d = false;
        L39:
            if (e.c() != null) goto L41;
            return;
        L41:
            if (r3 <= 0) goto L56;
            e.c().a(System.currentTimeMillis() - r3);
            return;
        L56:
            return;
        L8:
            r3 = 0;
            goto L10
        }
    }

    static {
    }

    public static void a() {
        if (d == false) goto L5;
        return;
    L5:
        d = true;
        f1982b = new b();
        Printer r0 = e();
        e = r0;
        if (r0 == null) goto L8;
        f1982b.f1983a.add(e);
    L8:
        Looper.getMainLooper().setMessageLogging(f1982b);
    }

    public static void a(Printer r2) {
        Printer r3 = (Printer) ZeusTransformUtils.wrapperContextForParams(r2, Printer.class, "com.obric.memorydata.plugin");
        if (r3 != null) goto L5;
        return;
    L5:
        if (f1982b.c.contains(r3) == true) goto L9;
        f1982b.c.add(r3);
        f1982b.e = true;
        return;
    }

    public static List<Printer> b() {
        b r0 = f1982b;
        if (r0 != null) goto L5;
        return null;
    L5:
        return r0.f1983a;
    }

    public static void b(Printer r2) {
        Printer r3 = (Printer) ZeusTransformUtils.wrapperContextForParams(r2, Printer.class, "com.obric.memorydata.plugin");
        if (r3 != null) goto L5;
        return;
    L5:
        if (f1982b.f1984b.contains(r3) == true) goto L9;
        f1982b.f1984b.add(r3);
        f1982b.d = true;
        return;
    }

    static /* synthetic */ a c() {
        return c;
    }

    static /* synthetic */ int d() {
        return f1981a;
    }

    private static Printer e() {
        Field r1 = ZeusTransformUtils.forName("android.os.Looper", "com.obric.memorydata.plugin").getDeclaredField("mLogging");     // Catch: Exception -> L5
        r1.setAccessible(true);     // Catch: Exception -> L5
        return (Printer) ZeusTransformUtils.preCheckCast(r1.get(Looper.getMainLooper()), Printer.class, "com.obric.memorydata.plugin");
    L5:
        return null;
    }
}
