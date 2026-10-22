package qa;

import android.app.ActivityManager;
import android.content.Context;
import android.os.Build;
import android.os.Environment;
import android.os.StatFs;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.view.WindowManager;
import com.obric.cae.smartBluetooth.deviceIdentification.bdim.BdimCategoryConstants;
import java.io.ByteArrayOutputStream;
import java.security.PublicKey;

/* JADX INFO: loaded from: classes.dex */
public final class j4 {

    public static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public String f10632a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public String f10633b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public String f10634c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public String f10635d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public String f10636e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public String f10637f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public String f10638g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public String f10639h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        public String f10640i;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        public String f10641j;

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        public String f10642k;

        /* JADX INFO: renamed from: l, reason: collision with root package name */
        public String f10643l;

        /* JADX INFO: renamed from: m, reason: collision with root package name */
        public String f10644m;

        /* JADX INFO: renamed from: n, reason: collision with root package name */
        public String f10645n;

        /* JADX INFO: renamed from: o, reason: collision with root package name */
        public String f10646o;

        /* JADX INFO: renamed from: p, reason: collision with root package name */
        public String f10647p;

        /* JADX INFO: renamed from: q, reason: collision with root package name */
        public String f10648q;

        /* JADX INFO: renamed from: r, reason: collision with root package name */
        public String f10649r;

        /* JADX INFO: renamed from: s, reason: collision with root package name */
        public String f10650s;

        /* JADX INFO: renamed from: t, reason: collision with root package name */
        public String f10651t;

        /* JADX INFO: renamed from: u, reason: collision with root package name */
        public String f10652u;

        /* JADX INFO: renamed from: v, reason: collision with root package name */
        public String f10653v;

        /* JADX INFO: renamed from: w, reason: collision with root package name */
        public String f10654w;

        /* JADX INFO: renamed from: x, reason: collision with root package name */
        public String f10655x;

        /* JADX INFO: renamed from: y, reason: collision with root package name */
        public String f10656y;
    }

    public static String a() {
        String r8 = String.valueOf(System.currentTimeMillis());     // Catch: Throwable -> L8
        String r10 = "1";
        if (h4.a() == true) goto L6;
        r10 = "0";
    L6:
        int r11 = r8.length();     // Catch: Throwable -> L8
        return r8.substring(0, r11 - 2) + r10 + r8.substring(r11 - 1);
    L8:
        th = move-exception;
        l.a("CI", "TS", th);
        return null;
    }

    public static String b(Context r8, String r10, String r11) {
        return l6.a.j(h4.f(r8) + BdimCategoryConstants.SEPARATOR_COLON + r10.substring(0, r10.length() - 3) + BdimCategoryConstants.SEPARATOR_COLON + r11);
    L5:
        th = move-exception;
        l.a("CI", "Sco", th);
        return null;
    }

    public static void c(ByteArrayOutputStream r8, String r10) {
        if (TextUtils.isEmpty(r10) == false) goto L5;
        t4.e(r8, (byte) 0, new byte[0]);
        return;
    L5:
        if (r10.getBytes().length <= 255) goto L7;
        byte r11 = -1;
    L8:
        t4.e(r8, r11, t4.i(r10));
        return;
    L7:
        r11 = (byte) r10.getBytes().length;
        goto L8
    }

    public static a d(Context r11, boolean r12, boolean r13) {
        a r8 = new a();
        r8.f10632a = "";
        r8.f10633b = "";
        String r10 = k4.m(r11);
        if (r10 != null) goto L5;
        r10 = "";
    L5:
        r8.f10634c = r10;
        r8.f10635d = h4.d(r11);
        r8.f10636e = Build.MODEL;
        r8.f10637f = Build.MANUFACTURER;
        r8.f10638g = Build.DEVICE;
        r8.f10639h = h4.b(r11);
        r8.f10640i = h4.e(r11);
        r8.f10641j = String.valueOf(Build.VERSION.SDK_INT);
        r8.f10642k = "";
        String r14 = k4.f10762o;     // Catch: Throwable -> L121
        if (r14 != null) goto L9;
    L11:
        DisplayMetrics r15 = new DisplayMetrics();     // Catch: Throwable -> L121
        WindowManager r16 = (WindowManager) r11.getSystemService("window");     // Catch: Throwable -> L121
        if (r16 != null) goto L14;
        String r17 = "";
    L21:
        r8.f10643l = r17;
        StringBuilder r18 = new StringBuilder();
        r18.append(k4.n(r11));
        r8.f10644m = r18.toString();
        StringBuilder r19 = new StringBuilder();
        int r20 = k4.d(r11);     // Catch: Throwable -> L24
    L25:
        r19.append(r20);
        r8.f10645n = r19.toString();
        String r21 = k4.b(r11);     // Catch: Throwable -> L28
    L29:
        r8.f10646o = r21;
        if (k4.f10761n == false) goto L122;
    L44:
        String r22 = k4.f10760m;
    L45:
        r8.f10647p = r22;
        r8.f10648q = "";
        r8.f10649r = "";
        int r23 = 0;
        if (r12 == false) goto L48;
        r8.f10650s = "";
        r8.f10651t = "";
    L49:
        r8.f10652u = k4.f10751d;
        String r24 = k4.h(r11);
        if (TextUtils.isEmpty(r24) == true) goto L52;
        r8.f10653v = r24;
    L53:
        r8.f10654w = "aid=";
        if (r13 == false) goto L58;
        if (b.f10221b == false) goto L58;
    L59:
        String r110 = k4.l(r11);
        if (TextUtils.isEmpty(r110) == true) goto L63;
        r8.f10654w += "|oaid=" + r110;
    L63:
        if (TextUtils.isEmpty("") == true) goto L66;
        r8.f10654w = android.aimedia.a.i(new StringBuilder(), r8.f10654w, "|multiImeis=");
    L66:
        if (TextUtils.isEmpty("") == true) goto L68;
        r8.f10654w = android.aimedia.a.i(new StringBuilder(), r8.f10654w, "|meid=");
    L68:
        r8.f10654w = android.aimedia.a.i(new StringBuilder(), r8.f10654w, "|serial=");
        if (TextUtils.isEmpty("") == false) goto L77;
        if (k4.f10752e == null) goto L77;
        String r111 = h.f10486b;     // Catch: Throwable -> L119
        String r112 = null;
    L79:
        if (TextUtils.isEmpty(r112) == true) goto L81;
        r8.f10654w += "|adiuExtras=" + r112;
    L81:
        StringBuilder r113 = new StringBuilder();
        r113.append(r8.f10654w);
        r113.append("|storage=");
        long r25 = k4.f10764q;
        if (r25 == 0) goto L123;
    L86:
        r113.append(r25);
        r113.append("|ram=");
        int r26 = k4.f10765r;
        if (r26 == 0) goto L89;
        r23 = r26;
    L93:
        r113.append(r23);
        r113.append("|arch=");
        if (TextUtils.isEmpty(k4.f10766s) == true) goto L96;
        String r114 = k4.f10766s;
    L97:
        r113.append(r114);
        r8.f10654w = r113.toString();
        String r115 = k.a().f10607m;
        if (TextUtils.isEmpty(r115) == true) goto L100;
        r8.f10655x = r115;
    L101:
        if (r12 == true) goto L103;
    L117:
        return r8;
    L103:
        if (qa.a.f10201a != null) goto L115;
        monitor-enter(qa.a.class);
    L111:
        th = move-exception;
        throw th;
    L107:
        if (qa.a.f10201a != null) goto L109;
        qa.a.f10201a = new qa.a();     // Catch: Throwable -> L111
    L109:
        monitor-exit(qa.a.class);     // Catch: Throwable -> L111
    L115:
        if (TextUtils.isEmpty("") == true) goto L117;
        r8.f10656y = "";
        goto L117
    L100:
        r8.f10655x = "";
        goto L101
    L96:
        r114 = System.getProperty("os.arch");
        k4.f10766s = r114;
        goto L97
    L89:
        ActivityManager r116 = (ActivityManager) r11.getSystemService("activity");
        if (r116 == null) goto L93;
        ActivityManager.MemoryInfo r27 = new ActivityManager.MemoryInfo();
        r116.getMemoryInfo(r27);
        r23 = ((int) (r27.totalMem / 1024)) / 1024;
        k4.f10765r = r23;
        goto L93
    L123:
        StatFs r28 = new StatFs(Environment.getRootDirectory().getAbsolutePath());     // Catch: Throwable -> L118
        StatFs r29 = new StatFs(Environment.getExternalStorageDirectory().getAbsolutePath());     // Catch: Throwable -> L118
        k4.f10764q = ((r28.getBlockCountLong() * r28.getBlockSizeLong()) / 1048576) + ((r29.getBlockCountLong() * r29.getBlockSizeLong()) / 1048576);     // Catch: Throwable -> L118
    L85:
        r25 = k4.f10764q;
    L77:
        r112 = "";
    L58:
        if (b.f10222c == false) goto L63;
    L52:
        r8.f10653v = "";
        goto L53
    L48:
        String[] r30 = {"", ""};
        r8.f10650s = r30[0];
        r8.f10651t = r30[1];
        goto L49
    L122:
        k4.g(r11);     // Catch: Throwable -> L120
        TelephonyManager r31 = (TelephonyManager) r11.getSystemService("phone");     // Catch: Throwable -> L120
        if (r31 == null) goto L42;
        String r32 = r31.getNetworkOperator();     // Catch: Throwable -> L120
        if (TextUtils.isEmpty(r32) == false) goto L38;
    L41:
        k4.f10761n = true;     // Catch: Throwable -> L120
        goto L42
    L38:
        if (r32.length() < 3) goto L41;
        k4.f10760m = r32.substring(3);     // Catch: Throwable -> L120
        k4.f10761n = true;     // Catch: Throwable -> L120
    L42:
        r22 = k4.f10760m;     // Catch: Throwable -> L120
    L28:
        r21 = "";
    L24:
        r20 = -1;
        goto L25
    L14:
        r16.getDefaultDisplay().getMetrics(r15);     // Catch: Throwable -> L121
        int r33 = r15.widthPixels;     // Catch: Throwable -> L121
        int r34 = r15.heightPixels;     // Catch: Throwable -> L121
        if (r34 <= r33) goto L18;
        StringBuilder r35 = new StringBuilder();     // Catch: Throwable -> L121
        r35.append(r33);     // Catch: Throwable -> L121
        r35.append("*");     // Catch: Throwable -> L121
        r35.append(r34);     // Catch: Throwable -> L121
    L19:
        k4.f10762o = r35.toString();     // Catch: Throwable -> L121
        goto L20
    L18:
        r35 = new StringBuilder();     // Catch: Throwable -> L121
        r35.append(r34);     // Catch: Throwable -> L121
        r35.append("*");     // Catch: Throwable -> L121
        r35.append(r33);     // Catch: Throwable -> L121
        goto L19
    L9:
        if ("".equals(r14) == true) goto L11;
        r17 = k4.f10762o;     // Catch: Throwable -> L121
    L20:
        r17 = k4.f10762o;
        goto L21
    }

    public static byte[] e(a r8) {
        ByteArrayOutputStream r10 = new ByteArrayOutputStream();     // Catch: Throwable -> L15
        c(r10, r8.f10632a);     // Catch: Throwable -> L7
        c(r10, r8.f10633b);     // Catch: Throwable -> L7
        c(r10, r8.f10634c);     // Catch: Throwable -> L7
        c(r10, r8.f10635d);     // Catch: Throwable -> L7
        c(r10, r8.f10636e);     // Catch: Throwable -> L7
        c(r10, r8.f10637f);     // Catch: Throwable -> L7
        c(r10, r8.f10638g);     // Catch: Throwable -> L7
        c(r10, r8.f10639h);     // Catch: Throwable -> L7
        c(r10, r8.f10640i);     // Catch: Throwable -> L7
        c(r10, r8.f10641j);     // Catch: Throwable -> L7
        c(r10, r8.f10642k);     // Catch: Throwable -> L7
        c(r10, r8.f10643l);     // Catch: Throwable -> L7
        c(r10, r8.f10644m);     // Catch: Throwable -> L7
        c(r10, r8.f10645n);     // Catch: Throwable -> L7
        c(r10, r8.f10646o);     // Catch: Throwable -> L7
        c(r10, r8.f10647p);     // Catch: Throwable -> L7
        c(r10, r8.f10648q);     // Catch: Throwable -> L7
        c(r10, r8.f10649r);     // Catch: Throwable -> L7
        c(r10, r8.f10650s);     // Catch: Throwable -> L7
        c(r10, r8.f10651t);     // Catch: Throwable -> L7
        c(r10, null);     // Catch: Throwable -> L7
        c(r10, null);     // Catch: Throwable -> L7
        c(r10, r8.f10652u);     // Catch: Throwable -> L7
        c(r10, r8.f10653v);     // Catch: Throwable -> L7
        c(r10, r8.f10654w);     // Catch: Throwable -> L7
        c(r10, r8.f10655x);     // Catch: Throwable -> L7
        c(r10, r8.f10656y);     // Catch: Throwable -> L7
        byte[] r11 = r10.toByteArray();     // Catch: Throwable -> L7
        new String(r11);     // Catch: Throwable -> L7
        byte[] r12 = t4.m(r11);     // Catch: Throwable -> L7
        PublicKey r13 = t4.p();     // Catch: Throwable -> L7
        if (r12.length <= 117) goto L9;
        byte[] r14 = new byte[117];     // Catch: Throwable -> L7
        System.arraycopy(r12, 0, r14, 0, 117);     // Catch: Throwable -> L7
        byte[] r15 = l4.b(r14, r13);     // Catch: Throwable -> L7
        byte[] r16 = new byte[(r12.length + 128) - 117];     // Catch: Throwable -> L7
        System.arraycopy(r15, 0, r16, 0, 128);     // Catch: Throwable -> L7
        System.arraycopy(r12, 117, r16, 128, r12.length - 117);     // Catch: Throwable -> L7
    L33:
        r10.close();     // Catch: Throwable -> L12
    L14:
        return r16;
    L12:
        th = move-exception;
        th.printStackTrace();
        goto L14
    L9:
        r16 = l4.b(r12, r13);     // Catch: Throwable -> L7
    L7:
        th = th;
    L40:
        l.a("CI", "gzx", th);     // Catch: Throwable -> L24
        if (r10 != null) goto L35;
    L23:
        return null;
    L35:
        r10.close();     // Catch: Throwable -> L21
    L21:
        th = move-exception;
        th.printStackTrace();
    L24:
        th = move-exception;
        if (r10 != null) goto L31;
    L30:
        throw th;
    L31:
        r10.close();     // Catch: Throwable -> L28
    L28:
        th = move-exception;
        th.printStackTrace();
    L15:
        th = th;
        r10 = null;
        goto L40
    }
}
