package n4a;

import android.app.ActivityManager;
import android.content.Context;
import android.os.Build;
import android.os.Environment;
import android.os.StatFs;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.view.WindowManager;
import com.lynx.tasm.event.LynxTouchEvent;
import com.obric.aivoice.core.data.NameKeys;
import java.io.ByteArrayOutputStream;
import java.security.PublicKey;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
public final class w4 {

    public static class a {
        public String a;
        public String b;
        public String c;
        public String d;
        public String e;
        public String f;
        public String g;
        public String h;
        public String i;
        public String j;
        public String k;
        public String l;
        public String m;
        public String n;
        public String o;
        public String p;
        public String q;
        public String r;
        public String s;
        public String t;
        public String u;
        public String v;
        public String w;
        public String x;
        public String y;

        public a() {
        }
    }

    public static String a() {
        String r0 = String.valueOf(System.currentTimeMillis());     // Catch: Throwable -> L8
        String r1 = "1";
        if (v4.a() == true) goto L6;
        r1 = "0";
    L6:
        int r2 = r0.length();     // Catch: Throwable -> L8
        return r0.substring(0, r2 - 2) + r1 + r0.substring(r2 - 1);
    L8:
        th = move-exception;
        n.a(th, "CI", "TS");
        return null;
    }

    public static String b(Context r3, String r4, String r5) {
        return b5.a(v4.f(r3) + ":" + r4.substring(0, r4.length() - 3) + ":" + r5);
    L5:
        th = move-exception;
        n.a(th, "CI", "Sco");
        return null;
    }

    public static void c(ByteArrayOutputStream r2, String r3) {
        if (TextUtils.isEmpty(r3) == false) goto L5;
        f5.f(r2, (byte) 0, new byte[0]);
        return;
    L5:
        if (r3.getBytes().length <= 255) goto L7;
        byte r0 = -1;
    L8:
        f5.f(r2, r0, f5.j(r3));
        return;
    L7:
        r0 = (byte) r3.getBytes().length;
        goto L8
    }

    public static byte[] e(a r7) {
        ByteArrayOutputStream r1 = new ByteArrayOutputStream();     // Catch: Throwable -> L15
        c(r1, r7.a);     // Catch: Throwable -> L13
        c(r1, r7.b);     // Catch: Throwable -> L13
        c(r1, r7.c);     // Catch: Throwable -> L13
        c(r1, r7.d);     // Catch: Throwable -> L13
        c(r1, r7.e);     // Catch: Throwable -> L13
        c(r1, r7.f);     // Catch: Throwable -> L13
        c(r1, r7.g);     // Catch: Throwable -> L13
        c(r1, r7.h);     // Catch: Throwable -> L13
        c(r1, r7.i);     // Catch: Throwable -> L13
        c(r1, r7.j);     // Catch: Throwable -> L13
        c(r1, r7.k);     // Catch: Throwable -> L13
        c(r1, r7.l);     // Catch: Throwable -> L13
        c(r1, r7.m);     // Catch: Throwable -> L13
        c(r1, r7.n);     // Catch: Throwable -> L13
        c(r1, r7.o);     // Catch: Throwable -> L13
        c(r1, r7.p);     // Catch: Throwable -> L13
        c(r1, r7.q);     // Catch: Throwable -> L13
        c(r1, r7.r);     // Catch: Throwable -> L13
        c(r1, r7.s);     // Catch: Throwable -> L13
        c(r1, r7.t);     // Catch: Throwable -> L13
        c(r1, null);     // Catch: Throwable -> L13
        c(r1, null);     // Catch: Throwable -> L13
        c(r1, r7.u);     // Catch: Throwable -> L13
        c(r1, r7.v);     // Catch: Throwable -> L13
        c(r1, r7.w);     // Catch: Throwable -> L13
        c(r1, r7.x);     // Catch: Throwable -> L13
        c(r1, r7.y);     // Catch: Throwable -> L13
        byte[] r8 = r1.toByteArray();     // Catch: Throwable -> L13
        new String(r8);     // Catch: Throwable -> L13
        byte[] r9 = f5.n(r8);     // Catch: Throwable -> L13
        PublicKey r2 = f5.q();     // Catch: Throwable -> L13
        if (r9.length <= 117) goto L7;
        byte[] r3 = new byte[117];     // Catch: Throwable -> L13
        System.arraycopy(r9, 0, r3, 0, 117);     // Catch: Throwable -> L13
        byte[] r4 = y4.b(r3, r2);     // Catch: Throwable -> L13
        byte[] r5 = new byte[(r9.length + LynxTouchEvent.kPseudoStateFocusTransition) - 117];     // Catch: Throwable -> L13
        System.arraycopy(r4, 0, r5, 0, LynxTouchEvent.kPseudoStateFocusTransition);     // Catch: Throwable -> L13
        System.arraycopy(r9, 117, r5, LynxTouchEvent.kPseudoStateFocusTransition, r9.length - 117);     // Catch: Throwable -> L13
    L31:
        r1.close();     // Catch: Throwable -> L10
    L12:
        return r5;
    L10:
        th = move-exception;
        th.printStackTrace();
        goto L12
    L7:
        r5 = y4.b(r9, r2);     // Catch: Throwable -> L13
    L13:
        th = th;
    L40:
        n.a(th, "CI", "gzx");     // Catch: Throwable -> L24
        if (r1 != null) goto L36;
    L23:
        return null;
    L36:
        r1.close();     // Catch: Throwable -> L21
    L21:
        th = move-exception;
        th.printStackTrace();
    L24:
        th = move-exception;
        if (r1 != null) goto L33;
    L30:
        throw th;
    L33:
        r1.close();     // Catch: Throwable -> L28
    L28:
        th = move-exception;
        th.printStackTrace();
    L15:
        th = th;
        r1 = null;
        goto L40
    }

    public static a d(Context r11, boolean r12, boolean r13) {
        a r0 = new a();
        r0.a = NameKeys.UnloadStrategy_No_Strategy;
        r0.b = NameKeys.UnloadStrategy_No_Strategy;
        String r2 = x4.q(r11);
        if (r2 != null) goto L5;
        r2 = NameKeys.UnloadStrategy_No_Strategy;
    L5:
        r0.c = r2;
        r0.d = v4.d(r11);
        r0.e = Build.MODEL;
        r0.f = Build.MANUFACTURER;
        r0.g = Build.DEVICE;
        r0.h = v4.b(r11);
        r0.i = v4.e(r11);
        r0.j = String.valueOf(Build.VERSION.SDK_INT);
        r0.k = NameKeys.UnloadStrategy_No_Strategy;
        String r3 = x4.o;     // Catch: Throwable -> L109
        if (r3 != null) goto L9;
    L11:
        DisplayMetrics r4 = new DisplayMetrics();     // Catch: Throwable -> L109
        WindowManager r5 = (WindowManager) r11.getSystemService("window");     // Catch: Throwable -> L109
        if (r5 != null) goto L14;
        String r6 = NameKeys.UnloadStrategy_No_Strategy;
    L21:
        r0.l = r6;
        StringBuilder r7 = new StringBuilder();
        r7.append(x4.r(r11));
        r0.m = r7.toString();
        StringBuilder r8 = new StringBuilder();
        int r9 = x4.d(r11);     // Catch: Throwable -> L24
    L25:
        r8.append(r9);
        r0.n = r8.toString();
        String r10 = x4.b(r11);     // Catch: Throwable -> L28
    L29:
        r0.o = r10;
        if (x4.n == false) goto L114;
    L44:
        String r14 = x4.m;
    L45:
        r0.p = r14;
        r0.q = NameKeys.UnloadStrategy_No_Strategy;
        r0.r = NameKeys.UnloadStrategy_No_Strategy;
        int r15 = 0;
        if (r12 == false) goto L48;
        r0.s = NameKeys.UnloadStrategy_No_Strategy;
        r0.t = NameKeys.UnloadStrategy_No_Strategy;
    L49:
        r0.u = x4.d;
        String r16 = x4.j(r11);
        if (TextUtils.isEmpty(r16) == true) goto L52;
        r0.v = r16;
    L53:
        r0.w = "aid=";
        if (r13 == false) goto L58;
        if (c.b == false) goto L58;
    L59:
        String r17 = x4.p(r11);
        if (TextUtils.isEmpty(r17) == true) goto L63;
        r0.w += "|oaid=" + r17;
    L63:
        if (TextUtils.isEmpty(NameKeys.UnloadStrategy_No_Strategy) == true) goto L66;
        r0.w += "|multiImeis=";
    L66:
        if (TextUtils.isEmpty(NameKeys.UnloadStrategy_No_Strategy) == true) goto L68;
        r0.w += "|meid=";
    L68:
        r0.w += "|serial=";
        if (TextUtils.isEmpty(NameKeys.UnloadStrategy_No_Strategy) == false) goto L78;
        if (x4.e == null) goto L78;
        String r18 = i.b;     // Catch: Throwable -> L77
        String r19 = null;
    L80:
        if (TextUtils.isEmpty(r19) == true) goto L82;
        r0.w += "|adiuExtras=" + r19;
    L82:
        StringBuilder r110 = new StringBuilder();
        r110.append(r0.w);
        r110.append("|storage=");
        long r20 = x4.q;
        if (r20 == 0) goto L110;
    L87:
        r110.append(r20);
        r110.append("|ram=");
        int r21 = x4.r;
        if (r21 == 0) goto L90;
        r15 = r21;
    L94:
        r110.append(r15);
        r110.append("|arch=");
        if (TextUtils.isEmpty(x4.s) == true) goto L97;
        String r111 = x4.s;
    L98:
        r110.append(r111);
        r0.w = r110.toString();
        String r112 = m.a().b();
        if (TextUtils.isEmpty(r112) == true) goto L101;
        r0.x = r112;
    L102:
        if (r12 == false) goto L106;
        b.a();
        if (TextUtils.isEmpty(NameKeys.UnloadStrategy_No_Strategy) == true) goto L106;
        r0.y = NameKeys.UnloadStrategy_No_Strategy;
    L106:
        return r0;
    L101:
        r0.x = NameKeys.UnloadStrategy_No_Strategy;
        goto L102
    L97:
        r111 = System.getProperty("os.arch");
        x4.s = r111;
        goto L98
    L90:
        ActivityManager r113 = (ActivityManager) r11.getSystemService("activity");
        if (r113 == null) goto L94;
        ActivityManager.MemoryInfo r22 = new ActivityManager.MemoryInfo();
        r113.getMemoryInfo(r22);
        r15 = ((int) (r22.totalMem / 1024)) / 1024;
        x4.r = r15;
        goto L94
    L110:
        StatFs r23 = new StatFs(Environment.getRootDirectory().getAbsolutePath());     // Catch: Throwable -> L107
        StatFs r24 = new StatFs(Environment.getExternalStorageDirectory().getAbsolutePath());     // Catch: Throwable -> L107
        x4.q = ((r23.getBlockCountLong() * r23.getBlockSizeLong()) / 1048576) + ((r24.getBlockCountLong() * r24.getBlockSizeLong()) / 1048576);     // Catch: Throwable -> L107
    L86:
        r20 = x4.q;
    L78:
        r19 = NameKeys.UnloadStrategy_No_Strategy;
    L58:
        if (c.c == false) goto L63;
    L52:
        r0.v = NameKeys.UnloadStrategy_No_Strategy;
        goto L53
    L48:
        String[] r25 = {NameKeys.UnloadStrategy_No_Strategy, NameKeys.UnloadStrategy_No_Strategy};
        r0.s = r25[0];
        r0.t = r25[1];
        goto L49
    L114:
        x4.i(r11);     // Catch: Throwable -> L108
        TelephonyManager r26 = (TelephonyManager) r11.getSystemService("phone");     // Catch: Throwable -> L108
        if (r26 == null) goto L42;
        String r27 = r26.getNetworkOperator();     // Catch: Throwable -> L108
        if (TextUtils.isEmpty(r27) == false) goto L38;
    L41:
        x4.n = true;     // Catch: Throwable -> L108
        goto L42
    L38:
        if (r27.length() < 3) goto L41;
        x4.m = r27.substring(3);     // Catch: Throwable -> L108
        x4.n = true;     // Catch: Throwable -> L108
    L42:
        r14 = x4.m;     // Catch: Throwable -> L108
    L28:
        r10 = NameKeys.UnloadStrategy_No_Strategy;
    L24:
        r9 = -1;
        goto L25
    L14:
        r5.getDefaultDisplay().getMetrics(r4);     // Catch: Throwable -> L109
        int r28 = r4.widthPixels;     // Catch: Throwable -> L109
        int r29 = r4.heightPixels;     // Catch: Throwable -> L109
        if (r29 <= r28) goto L18;
        StringBuilder r30 = new StringBuilder();     // Catch: Throwable -> L109
        r30.append(r28);     // Catch: Throwable -> L109
        r30.append("*");     // Catch: Throwable -> L109
        r30.append(r29);     // Catch: Throwable -> L109
    L19:
        x4.o = r30.toString();     // Catch: Throwable -> L109
        goto L20
    L18:
        r30 = new StringBuilder();     // Catch: Throwable -> L109
        r30.append(r29);     // Catch: Throwable -> L109
        r30.append("*");     // Catch: Throwable -> L109
        r30.append(r28);     // Catch: Throwable -> L109
        goto L19
    L9:
        if (NameKeys.UnloadStrategy_No_Strategy.equals(r3) == true) goto L11;
        r6 = x4.o;     // Catch: Throwable -> L109
    L20:
        r6 = x4.o;
        goto L21
    }
}
