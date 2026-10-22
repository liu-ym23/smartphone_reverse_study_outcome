package com.bytedance.android.alog;

import android.content.Context;
import android.text.TextUtils;
import com.obric.cae.location.StarLocationManager;
import com.obric.cae.smartBluetooth.deviceIdentification.bdim.BdimCategoryConstants;
import com.obric.cae.smartNetwork.networkRateLimit.TrafficControlConfig;
import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;

/* JADX INFO: loaded from: classes.dex */
public class Alog {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final int f3681c = 0;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final int f3682d = 0;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final int f3683e = 0;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final int f3684f = 0;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final ArrayList<String> f3685g = null;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static boolean f3686h;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f3687a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public long f3688b;

    public static final enum a extends Enum<a> {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final a f3689b = null;

        /* JADX INFO: renamed from: m, reason: collision with root package name */
        public static final a f3690m = null;

        /* JADX INFO: renamed from: n, reason: collision with root package name */
        public static final /* synthetic */ a[] f3691n = null;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final int f3692a;

        static {
            a r8 = new a(BdimCategoryConstants.VALUE_NONE, 0, 0);
            f3689b = r8;
            a r10 = new a("EC_SECP256K1", 1, 1);
            f3690m = r10;
            f3691n = new a[]{r8, r10, new a("EC_SECP256R1", 2, 2)};
        }

        public a(String r8, int r10, int r11) {
            super(r8, r10);
            this.f3692a = r11;
        }

        public static a valueOf(String r8) {
            return (a) Enum.valueOf(a.class, r8);
        }

        public static a[] values() {
            return (a[]) f3691n.clone();
        }
    }

    public static class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final Context f3693a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public int f3694b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public boolean f3695c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public String f3696d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public String f3697e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public int f3698f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public int f3699g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public int f3700h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        public String f3701i;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        public int f3702j;

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        public int f3703k;

        /* JADX INFO: renamed from: l, reason: collision with root package name */
        public String f3704l;

        /* JADX INFO: renamed from: m, reason: collision with root package name */
        public int f3705m;

        /* JADX INFO: renamed from: n, reason: collision with root package name */
        public int f3706n;

        /* JADX INFO: renamed from: o, reason: collision with root package name */
        public int f3707o;

        /* JADX INFO: renamed from: p, reason: collision with root package name */
        public int f3708p;

        /* JADX INFO: renamed from: q, reason: collision with root package name */
        public int f3709q;

        /* JADX INFO: renamed from: r, reason: collision with root package name */
        public int f3710r;

        /* JADX INFO: renamed from: s, reason: collision with root package name */
        public String f3711s;

        public b(Context r8) {
            this.f3694b = 0;
            this.f3695c = false;
            this.f3696d = null;
            this.f3697e = null;
            this.f3698f = TrafficControlConfig.DEFAULT_UNLIMITED_RATE;
            this.f3699g = 20971520;
            this.f3700h = 7;
            this.f3701i = null;
            this.f3702j = 65536;
            this.f3703k = 196608;
            this.f3704l = null;
            this.f3705m = Alog.f3681c;
            this.f3706n = 0;
            this.f3707o = 0;
            this.f3708p = Alog.f3682d;
            this.f3709q = Alog.f3683e;
            this.f3710r = Alog.f3684f;
            this.f3711s = "b012e20c9aab1cb5257aca2069cb79a9339b3a2224f771c78d64972137936eaf0b2f7ebd8d46c2607e1d7fe7723d40b147b8ecfa8fe2eaeee05210c75822381a";
            Context r10 = r8.getApplicationContext();
            if (r10 == null) goto L5;
            r8 = r10;
        L5:
            this.f3693a = r8;
        }

        public final Alog a() {
            if (this.f3696d != null) goto L5;
            this.f3696d = "default";
        L5:
            ArrayList<String> r8 = Alog.f3685g;
            monitor-enter(r8);
            Iterator<String> r10 = r8.iterator();     // Catch: Throwable -> L42
        L8:
            String r11 = null;
            if (r10.hasNext() == false) goto L14;
            if (r10.next().equals(this.f3696d) == false) goto L8;
            monitor-exit(r8);     // Catch: Throwable -> L42
            return null;
        L14:
            Alog.f3685g.add(this.f3696d);     // Catch: Throwable -> L42
            monitor-exit(r8);     // Catch: Throwable -> L42
            if (this.f3697e != null) goto L24;
            File r12 = this.f3693a.getExternalFilesDir(null);
            if (r12 == null) goto L21;
            String r13 = r12.getPath() + "/alog";
        L22:
            this.f3697e = r13;
            goto L24
        L21:
            r13 = this.f3693a.getFilesDir() + "/alog";
        L24:
            if (this.f3701i != null) goto L27;
            this.f3701i = this.f3693a.getFilesDir() + "/alog";
        L27:
            if (this.f3704l != null) goto L34;
            Context r14 = this.f3693a;
            r11 = r14.getPackageManager().getPackageInfo(r14.getPackageName(), 0).versionName;     // Catch: Exception -> L45
        L31:
            if (TextUtils.isEmpty(r11) == false) goto L33;
            r11 = "unknown";
        L33:
            this.f3704l = r11;
        L34:
            int r15 = (this.f3702j / 4096) * 4096;
            this.f3702j = r15;
            int r16 = (this.f3703k / 4096) * 4096;
            this.f3703k = r16;
            if (r15 >= 4096) goto L37;
            this.f3702j = 4096;
        L37:
            int r17 = this.f3702j * 2;
            if (r16 >= r17) goto L41;
            this.f3703k = r17;
        L41:
            return new Alog(this.f3694b, this.f3695c, this.f3696d, this.f3697e, this.f3698f, this.f3699g, this.f3700h, this.f3701i, this.f3702j, this.f3703k, this.f3704l, this.f3705m, this.f3706n, this.f3707o, this.f3708p, this.f3709q, this.f3710r, this.f3711s);
        L42:
            th = move-exception;
            throw th;
        }

        public final void b(a r8) {
            this.f3710r = r8.f3692a;
        }

        public final void c(String r8) {
            this.f3701i = r8;
        }

        public final void d(int r8) {
            this.f3702j = r8;
        }

        public final void e(int r8) {
            this.f3703k = r8;
        }

        public final void f(c r8) {
            this.f3708p = r8.f3715a;
        }

        public final void g(String r8) {
            if (TextUtils.isEmpty(r8) == false) goto L5;
            return;
        L5:
            if (r8.contains("-") == false) goto L8;
            r8 = r8.replace("-", "");
        L8:
            if (r8.contains("_") == false) goto L11;
            r8 = r8.replace("_", "");
        L11:
            if (TextUtils.isEmpty(r8) == true) goto L15;
            this.f3696d = r8;
            return;
        }

        public final void h(int r8) {
            this.f3694b = r8;
        }

        public final void i(String r8) {
            this.f3697e = r8;
        }

        public final void j(int r8) {
            this.f3700h = r8;
        }

        public final void k(int r8) {
            this.f3698f = r8;
        }

        public final void l(int r8) {
            this.f3699g = r8;
        }

        public final void m() {
            d[] r8 = d.f3716a;
            this.f3705m = 1;
        }

        public final void n() {
            e[] r8 = e.f3717a;
            this.f3707o = 1;
        }

        public final void o(String r8) {
            this.f3711s = r8;
        }

        public final void p(f r8) {
            this.f3709q = r8.f3721a;
        }

        public final void q(boolean r8) {
            this.f3695c = r8;
        }

        public final void r() {
            g[] r8 = g.f3722a;
            this.f3706n = 0;
        }
    }

    public static final enum c extends Enum<c> {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final c f3712b = null;

        /* JADX INFO: renamed from: m, reason: collision with root package name */
        public static final c f3713m = null;

        /* JADX INFO: renamed from: n, reason: collision with root package name */
        public static final /* synthetic */ c[] f3714n = null;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final int f3715a;

        static {
            c r8 = new c(BdimCategoryConstants.VALUE_NONE, 0, 0);
            f3712b = r8;
            c r10 = new c("ZLIB", 1, 1);
            c r11 = new c("ZSTD", 2, 2);
            f3713m = r11;
            f3714n = new c[]{r8, r10, r11};
        }

        public c(String r8, int r10, int r11) {
            super(r8, r10);
            this.f3715a = r11;
        }

        public static c valueOf(String r8) {
            return (c) Enum.valueOf(c.class, r8);
        }

        public static c[] values() {
            return (c[]) f3714n.clone();
        }
    }

    public static final enum d extends Enum<d> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ d[] f3716a = null;

        static {
            f3716a = new d[]{new d(StarLocationManager.EXTRA_SPEED, 0, 0), new d("SAFE", 1, 1)};
        }

        public d(String r8, int r10, int r11) {
            super(r8, r10);
        }

        public static d valueOf(String r8) {
            return (d) Enum.valueOf(d.class, r8);
        }

        public static d[] values() {
            return (d[]) f3716a.clone();
        }
    }

    public static final enum e extends Enum<e> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ e[] f3717a = null;

        static {
            f3717a = new e[]{new e("DEFAULT", 0, 0), new e("LEGACY", 1, 1)};
        }

        public e(String r8, int r10, int r11) {
            super(r8, r10);
        }

        public static e valueOf(String r8) {
            return (e) Enum.valueOf(e.class, r8);
        }

        public static e[] values() {
            return (e[]) f3717a.clone();
        }
    }

    public static final enum f extends Enum<f> {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final f f3718b = null;

        /* JADX INFO: renamed from: m, reason: collision with root package name */
        public static final f f3719m = null;

        /* JADX INFO: renamed from: n, reason: collision with root package name */
        public static final /* synthetic */ f[] f3720n = null;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final int f3721a;

        static {
            f r8 = new f(BdimCategoryConstants.VALUE_NONE, 0, 0);
            f3718b = r8;
            f r10 = new f("TEA_16", 1, 1);
            f3719m = r10;
            f3720n = new f[]{r8, r10, new f("TEA_32", 2, 2), new f("TEA_64", 3, 3)};
        }

        public f(String r8, int r10, int r11) {
            super(r8, r10);
            this.f3721a = r11;
        }

        public static f valueOf(String r8) {
            return (f) Enum.valueOf(f.class, r8);
        }

        public static f[] values() {
            return (f[]) f3720n.clone();
        }
    }

    public static final enum g extends Enum<g> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ g[] f3722a = null;

        static {
            f3722a = new g[]{new g("RAW", 0, 0), new g("ISO_8601", 1, 1)};
        }

        public g(String r8, int r10, int r11) {
            super(r8, r10);
        }

        public static g valueOf(String r8) {
            return (g) Enum.valueOf(g.class, r8);
        }

        public static g[] values() {
            return (g[]) f3722a.clone();
        }
    }

    static {
        d[] r8 = d.f3716a;
        f3681c = 1;
        g[] r10 = g.f3722a;
        e[] r11 = e.f3717a;
        c r12 = c.f3712b;
        f3682d = 2;
        f r13 = f.f3718b;
        f3683e = 1;
        a r14 = a.f3689b;
        f3684f = 1;
        f3685g = new ArrayList();
        f3686h = false;
    }

    public Alog(int r8, boolean r10, String r11, String r12, int r13, int r14, int r15, String r16, int r17, int r18, String r19, int r110, int r111, int r112, int r113, int r114, int r20, String r21) {
        this.f3687a = r8;
        int r22 = r18 / r17;
        this.f3688b = nativeCreate(r8, r10, r11, r12, r13, r14, r15, r16, r17, r18, r19, r110, r111, r112, r113, r114, r20, r21);
    }

    public static synchronized void c(defpackage.c r8) {
        monitor-enter(Alog.class);
    L21:
        th = move-exception;
        throw th;
    L5:
        if (f3686h == false) goto L24;
        monitor-exit(Alog.class);
        return;
    L24:
        Context r10 = fd.a.f7381b.f7407a;     // Catch: Throwable -> L17
        if (y0.d.f13904a != null) goto L12;
        y0.d.f13904a = r10;     // Catch: Throwable -> L17
    L12:
        y7.a r11 = y7.a.f14041m;     // Catch: Throwable -> L17
        if (r11 == null) goto L15;
        r11.f("alog");     // Catch: Throwable -> L17
    L18:
        f3686h = true;     // Catch: Throwable -> L21
        monitor-exit(Alog.class);
        return;
    L15:
        System.loadLibrary("alog");     // Catch: Throwable -> L17
    L17:
        System.loadLibrary("alog");     // Catch: Throwable -> L21
        goto L18
    }

    private static native void nativeAsyncFlush(long r8);

    private static native long nativeCreate(int r8, boolean r10, String r11, String r12, int r13, int r14, int r15, String r16, int r17, int r18, String r19, int r110, int r111, int r112, int r113, int r114, int r115, String r116);

    private static native void nativeDestroy(long r8);

    private static native long nativeGetLegacyFlushFuncAddr();

    private static native long nativeGetLegacyGetLogFileDirFuncAddr();

    private static native long nativeGetLegacyWriteFuncAddr();

    private static native long nativeGetNativeWriteFuncAddr();

    public static native void nativeSetDefaultInstance(long r8);

    private static native void nativeSetLevel(long r8, int r10);

    private static native void nativeSetSyslog(long r8, boolean r10);

    private static native void nativeSyncFlush(long r8);

    private static native void nativeTimedSyncFlush(long r8, int r10);

    private static native void nativeWrite(long r8, int r10, String r11, String r12);

    private static native void nativeWriteAsyncMsg(long r8, int r10, String r11, String r12, long r13, long r14);

    public final void a() {
        long r8 = this.f3688b;
        if (r8 == 0) goto L6;
        nativeAsyncFlush(r8);
        return;
    }

    public final long b() {
        if (this.f3688b != 0) goto L5;
        return 0;
    L5:
        return nativeGetLegacyWriteFuncAddr();
    }

    public final void d(int r8) {
        this.f3687a = r8;
        long r10 = this.f3688b;
        if (r10 == 0) goto L6;
        nativeSetLevel(r10, r8);
        return;
    }

    public final void e(boolean r8) {
        long r10 = this.f3688b;
        if (r10 == 0) goto L6;
        nativeSetSyslog(r10, r8);
        return;
    }

    public final void f(int r8, String r10, String r11) {
        long r12 = this.f3688b;
        if (r12 != 0) goto L5;
        return;
    L5:
        if (r8 < this.f3687a) goto L11;
        if (r10 == null) goto L12;
        if (r11 == null) goto L13;
        nativeWrite(r12, r8, r10, r11);
        return;
    L13:
        return;
    L12:
        return;
    }

    public final void finalize() {
        super.finalize();     // Catch: Throwable -> L13
        monitor-enter(this);
        long r8 = this.f3688b;     // Catch: Throwable -> L10
        if (r8 == 0) goto L8;
        this.f3687a = 6;     // Catch: Throwable -> L10
        nativeDestroy(r8);     // Catch: Throwable -> L10
        this.f3688b = 0;     // Catch: Throwable -> L10
    L8:
        monitor-exit(this);     // Catch: Throwable -> L10
        return;
    L10:
        th = move-exception;
        throw th;
    L13:
        th = move-exception;
        monitor-enter(this);
        long r10 = this.f3688b;     // Catch: Throwable -> L20
        if (r10 == 0) goto L18;
        this.f3687a = 6;     // Catch: Throwable -> L20
        nativeDestroy(r10);     // Catch: Throwable -> L20
        this.f3688b = 0;     // Catch: Throwable -> L20
    L18:
        throw th;
    L20:
        th = move-exception;
        throw th;
    }

    public final void g(int r10, String r11, String r12, long r13, long r15) {
        long r8 = this.f3688b;
        if (r8 != 0) goto L5;
        return;
    L5:
        if (r10 < this.f3687a) goto L11;
        if (r11 == null) goto L12;
        if (r12 == null) goto L13;
        nativeWriteAsyncMsg(r8, r10, r11, r12, r13, r15);
        return;
    L13:
        return;
    L12:
        return;
    }
}
