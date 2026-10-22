package com.bytedance.android.live.core.utils;

import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.os.SystemClock;
import android.text.TextUtils;
import com.bytedance.android.live.core.cmc.setting.CMCSettings;
import com.bytedance.android.live.core.log.ALogger;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public final class i0 {
    public static c50.a a;
    public static c50.e b;

    public i0() {
    }

    public static boolean b() {
        if (CMCSettings.LIVE_CMC_CONFIG.getValue().mEnable == true) goto L5;
        return false;
    L5:
        if (Looper.myLooper() != Looper.getMainLooper()) goto L7;
        boolean r0 = true;
    L8:
        if (r0 == false) goto L12;
        return true;
    L12:
        return false;
    L7:
        r0 = false;
        goto L8
    }

    public static Handler c() {
        if (a != null) goto L15;
        monitor-enter(i0.class);
    L11:
        th = move-exception;
        throw th;
    L7:
        if (a != null) goto L9;
        c50.a r1 = new c50.a(Looper.getMainLooper());     // Catch: Throwable -> L11
        a = r1;     // Catch: Throwable -> L11
        b = new c50.e(r1);     // Catch: Throwable -> L11
    L9:
        monitor-exit(i0.class);     // Catch: Throwable -> L11
    L15:
        return a;
    }

    public static void a(String r5) {
        if (TextUtils.isEmpty(r5) == false) goto L5;
        return;
    L5:
        if (b() == false) goto L47;
        c();
        c50.e r0 = b;
        Integer r6 = r0.a.remove(r5);
        f50.a r1 = r0.c;
        HashMap<Integer, c50.d> r2 = r0.b;
        if (r1.a == false) goto L18;
        if (r6 == null) goto L12;
        int r3 = r6.intValue();
    L13:
        if (r2 == null) goto L18;
        c50.d r4 = r2.get(Integer.valueOf(r3));
        if (r4 == null) goto L18;
        r4.b();
        goto L18
    L12:
        r3 = -1;
    L18:
        if (r6 != null) goto L20;
        return;
    L20:
        if (r6.intValue() == (-1)) goto L48;
        c50.d r7 = r0.b.remove(r6);
        if (r7 == null) goto L28;
        ArrayList<c50.c> r8 = r7.d;
        if (r8 == null) goto L27;
        r8.clear();
    L27:
        r7.a = null;
        r7.b = -1;
    L28:
        d50.a r9 = r0.d;
        int r11 = r6.intValue();
        r9.d.remove(Integer.valueOf(r11));
        if (r11 == (-1)) goto L49;
        f50.a r12 = r9.c;
        Handler r13 = r9.a;
        HashMap<Integer, c50.d> r14 = r9.b;
        if (r12.a == false) goto L39;
        if (r14 == null) goto L38;
        c50.d r15 = r14.get(Integer.valueOf(r11));
        if (r15 == null) goto L38;
        r15.b();
    L38:
        r12.b(r13, r14);
    L39:
        r9.a.removeMessages(r11);
        f50.a r16 = r9.c;
        Handler r17 = r9.a;
        HashMap<Integer, c50.d> r18 = r9.b;
        if (r16.a == false) goto L43;
        r16.b(r17, r18);
    L43:
        r9.f();
        return;
    L49:
        return;
    L48:
        return;
    }

    public static void d(Runnable r3) {
        if (r3 != null) goto L4;
        return;
    L4:
        c().postAtTime(r3, 5);
    }

    public static void f(Runnable r3) {
        if (r3 != null) goto L4;
        return;
    L4:
        c().postAtTime(r3, 3);
    }

    public static void g(Runnable r3) {
        if (r3 != null) goto L4;
        return;
    L4:
        Message r4 = Message.obtain(c(), r3);
        if (Build.VERSION.SDK_INT < 22) goto L7;
        ALogger.i("SlideTaskDelay", "setAsynchronous true");
        r4.setAsynchronous(true);
    L7:
        c().sendMessageAtTime(r4, 3);
    }

    public static void h(Runnable r1) {
        c().post(r1);
    }

    public static void e(String r4, Runnable r5) {
        if (r5 != null) goto L4;
        return;
    L4:
        Handler r0 = c();
        if (b() == true) goto L7;
    L11:
        r0.postAtTime(r5, 5);
        return;
    L7:
        if (CMCSettings.LIVE_CMC_CONFIG.getValue().mInsertSupport == false) goto L11;
        if (b.b(r4, r5, 5) == true) goto L13;
        r0.postAtTime(r5, 5);
        return;
    }

    public static void i(String r4, Runnable r5) {
        if (r5 != null) goto L4;
        return;
    L4:
        Handler r0 = c();
        if (b() == true) goto L7;
        r0.post(r5);
        return;
    L7:
        if (b.b(r4, r5, SystemClock.uptimeMillis()) == true) goto L11;
        r0.post(r5);
        return;
    }

    public static void k(String r6, Runnable r7) {
        if (r7 != null) goto L4;
        return;
    L4:
        Handler r0 = c();
        if (b() == false) goto L45;
        c50.e r1 = b;
        if (r1.c.a == false) goto L10;
    L10:
        Integer r8 = r1.a.get(r6);
        if (r8 == null) goto L13;
        int r9 = r8.intValue();
    L14:
        if (r9 == (-1)) goto L42;
        c50.d r2 = r1.b.get(Integer.valueOf(r9));
        if (r2 == null) goto L19;
        c50.c r3 = r2.a(r7);
    L20:
        if (r3 != null) goto L31;
        Iterator<Map.Entry<Integer, c50.d>> r4 = r1.b.entrySet().iterator();
    L23:
        if (r4.hasNext() == false) goto L31;
        Map.Entry<Integer, c50.d> r5 = r4.next();
        if (r5.getKey().intValue() == r9) goto L23;
        c50.d r11 = r5.getValue();
        if (r11 == null) goto L30;
        r3 = r11.a(r7);
    L30:
        if (r3 == null) goto L23;
    L31:
        d50.a r12 = r1.d;
        if (r3 == null) goto L41;
        f50.a r13 = r12.c;
        HashMap<Integer, c50.d> r14 = r12.b;
        if (r13.a == false) goto L40;
        if (r14 == null) goto L40;
        c50.d r15 = r14.get(Integer.valueOf(r3.d));
        if (r15 == null) goto L40;
        r15.b();
    L40:
        r12.a.removeCallbacks(r3);
        r12.d(r3);
        boolean r16 = true;
    L43:
        if (r16 == true) goto L53;
        r0.removeCallbacks(r7);
        return;
    L53:
        return;
    L41:
        r12.getClass();
        goto L42
    L19:
        r3 = null;
    L42:
        r16 = false;
        goto L43
    L13:
        r9 = -1;
        goto L14
    L45:
        r0.removeCallbacks(r7);
    }

    public static void j(String r4, Runnable r5, long r6) {
        if (r5 != null) goto L4;
        return;
    L4:
        Handler r0 = c();
        if (b() == true) goto L7;
        r0.postDelayed(r5, r6);
        return;
    L7:
        if (b.b(r4, r5, SystemClock.uptimeMillis() + r6) == true) goto L11;
        r0.postDelayed(r5, r6);
        return;
    }
}
