package com.bytedance.common.utility;

import android.os.Looper;
import android.text.TextUtils;
import android.util.Log;
import android.util.Printer;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public final class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static int f1259a = 5;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static b f1260b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static a f1261c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static boolean f1262d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private static Printer f1263e;

    public interface a {
        void a(long r10);
    }

    static class b implements Printer {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        List<Printer> f1264a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        List<Printer> f1265b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        List<Printer> f1266c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        boolean f1267d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        boolean f1268e;

        b() {
            this.f1264a = new ArrayList();
            this.f1265b = new ArrayList();
            this.f1266c = new ArrayList();
            this.f1267d = false;
            this.f1268e = false;
        }

        @Override // android.util.Printer
        public void println(String r10) {
            if (TextUtils.isEmpty(r10) == false) goto L6;
            return;
        L6:
            if (d.a() == null) goto L8;
            long r11 = System.currentTimeMillis();
        L10:
            if (r10.charAt(0) != '>') goto L21;
            if (this.f1268e == false) goto L21;
            Iterator<Printer> r12 = this.f1266c.iterator();
        L15:
            if (r12.hasNext() == false) goto L19;
            Printer r13 = r12.next();
            if (this.f1264a.contains(r13) == true) goto L15;
            this.f1264a.add(r13);
            goto L15
        L19:
            this.f1266c.clear();
            this.f1268e = false;
        L21:
            if (this.f1264a.size() <= d.b()) goto L23;
            Log.e("LooperPrinterUtils", "wrapper contains too many printer,please check if the useless printer have been removed");
        L23:
            Iterator<Printer> r14 = this.f1264a.iterator();
        L25:
            if (r14.hasNext() == false) goto L30;
            Printer r15 = r14.next();
            if (r15 == null) goto L25;
            r15.println(r10);
            goto L25
        L30:
            if (r10.charAt(0) != '<') goto L39;
            if (this.f1267d == false) goto L39;
            Iterator<Printer> r16 = this.f1265b.iterator();
        L35:
            if (r16.hasNext() == false) goto L37;
            Printer r17 = r16.next();
            this.f1264a.remove(r17);
            this.f1266c.remove(r17);
            goto L35
        L37:
            this.f1265b.clear();
            this.f1267d = false;
        L39:
            if (d.a() != null) goto L41;
            return;
        L41:
            if (r11 <= 0) goto L56;
            d.a().a(System.currentTimeMillis() - r11);
            return;
        L56:
            return;
        L8:
            r11 = 0;
            goto L10
        }
    }

    static {
    }

    static /* synthetic */ a a() {
        return f1261c;
    }

    static /* synthetic */ int b() {
        return f1259a;
    }

    public static void c(Printer r10) {
        if (r10 != null) goto L4;
        return;
    L4:
        if (f1260b.f1266c.contains(r10) == true) goto L8;
        f1260b.f1266c.add(r10);
        f1260b.f1268e = true;
        return;
    }

    private static Printer d() {
        Field r10 = Class.forName("android.os.Looper").getDeclaredField("mLogging");     // Catch: Exception -> L4
        r10.setAccessible(true);     // Catch: Exception -> L4
        return (Printer) r10.get(Looper.getMainLooper());
    L4:
        return null;
    }

    public static List<Printer> e() {
        b r10 = f1260b;
        if (r10 != null) goto L5;
        return null;
    L5:
        return r10.f1264a;
    }

    public static void f() {
        if (f1262d == false) goto L5;
        return;
    L5:
        f1262d = true;
        f1260b = new b();
        Printer r10 = d();
        f1263e = r10;
        if (r10 == null) goto L8;
        f1260b.f1264a.add(r10);
    L8:
        Looper.getMainLooper().setMessageLogging(f1260b);
    }

    public static void g(Printer r10) {
        if (r10 != null) goto L4;
        return;
    L4:
        if (f1260b.f1265b.contains(r10) == true) goto L8;
        f1260b.f1265b.add(r10);
        f1260b.f1267d = true;
        return;
    }
}
