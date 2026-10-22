package com.ss.android.deviceregister;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.os.Process;
import android.util.Log;
import com.bytedance.bdinstall.compat.intf.IAppTraitCallback;
import com.bytedance.common.utility.Logger;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.Map;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes6.dex */
public class f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static volatile f f15214a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static volatile boolean f15215b = false;
    private static Context c = null;
    private static volatile String d = "";
    private static volatile int e = -1;
    private static volatile boolean f = true;
    private static volatile boolean g = false;
    private static volatile boolean h = false;
    private static volatile boolean i;
    private static volatile IAppTraitCallback j;
    private static volatile j k;
    private static boolean l;
    private static volatile s m;
    private static volatile m n;
    private static int o;
    private static k p;
    private static k q;
    private static boolean r;

    public interface a {
        void a(String r1, String r2);

        void a(boolean r1);

        void a(boolean r1, boolean r2);
    }

    static {
        k = new j.a();
        l = false;
        o = -1;
        p = new p();
        q = new b();
        r = false;
    }

    private f(boolean r3, boolean r4) {
        p.a(c, r, r3, r4);     // Catch: Throwable -> L5
        return;
    L5:
        th = move-exception;
        Log.e("BDInstall", "error when init ", th);
        th.printStackTrace();
    }

    public static void a(Context r2) {
        c = (Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(((Context) ZeusTransformUtils.wrapperContextForParams(r2, Context.class, "com.obric.memorydata.plugin")).getApplicationContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin");
    }

    public static void a(Context r2, String r3) {
        Context r4 = (Context) ZeusTransformUtils.wrapperContextForParams(r2, Context.class, "com.obric.memorydata.plugin");
        p.a(r4, r3);
    }

    static void a(Context r3, boolean r4, boolean r5) {
        Context r6 = (Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.memorydata.plugin");
        if (r6 == null) goto L24;
        f15215b = true;
        if (ZeusTransformUtils.instanceOf(r6, Activity.class) == false) goto L7;
        a(true);
    L7:
        c = (Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(r6.getApplicationContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin");
        if (f15214a != null) goto L20;
        monitor-enter(f.class);
    L16:
        th = move-exception;
        throw th;
    L12:
        if (f15214a != null) goto L14;
        f15214a = new f(r4, r5);     // Catch: Throwable -> L16
        f15214a.d(r6);     // Catch: Throwable -> L16
    L14:
        monitor-exit(f.class);     // Catch: Throwable -> L16
    L20:
        if (Logger.debug() == false) goto L27;
        Logger.d("DeviceRegisterManager", "DeviceRegister init, DeviceRegister : " + f15214a.toString() + ", process : " + Process.myPid());
        return;
    L27:
        return;
    L24:
        throw new IllegalArgumentException("context = null");
    }

    public static void a(Bundle r1) {
        p.a(r1);
    }

    public static void a(com.ss.android.deviceregister.a.i r2) {
        com.ss.android.deviceregister.a.i r3 = (com.ss.android.deviceregister.a.i) ZeusTransformUtils.wrapperContextForParams(r2, com.ss.android.deviceregister.a.i.class, "com.obric.memorydata.plugin");
        p.a(r3);
    }

    public static void a(a r2) {
        a r3 = (a) ZeusTransformUtils.wrapperContextForParams(r2, a.class, "com.obric.memorydata.plugin");
        p.a(r3);
    }

    public static void a(String r1) {
        p.a(r1);
    }

    public static void a(Map<String, String> r2) {
        Map<String, String> r3 = (Map) ZeusTransformUtils.wrapperContextForParams(r2, Map.class, "com.obric.memorydata.plugin");
        p.a(r3, c);
    }

    public static void a(boolean r1) {
        p.a(r1);
    }

    public static void a(boolean r2, long r3, q r5) {
        q r6 = (q) ZeusTransformUtils.wrapperContextForParams(r5, q.class, "com.obric.memorydata.plugin");
        f r0 = f15214a;
        if (c() == false) goto L8;
        if (r0 == null) goto L8;
        p.a(r2, r3, r6);
        return;
    L8:
        p.d(r2);
    }

    public static boolean a() {
        if (e >= 0) goto L6;
        Logger.e("DeviceRegisterManager", Log.getStackTraceString(new RuntimeException("SwitchToBdtracker has not been set!")));
    L6:
        if (e <= 0) goto L8;
        return true;
    L8:
        return false;
    }

    public static boolean a(Context r2, JSONObject r3, boolean r4) {
        Context r5 = (Context) ZeusTransformUtils.wrapperContextForParams(r2, Context.class, "com.obric.memorydata.plugin");
        return p.a(r5, r3, r4);
    }

    public static void b(Context r2, String r3) {
        Context r4 = (Context) ZeusTransformUtils.wrapperContextForParams(r2, Context.class, "com.obric.memorydata.plugin");
        p.b(r4, r3);
    }

    public static void b(boolean r1) {
        p.c(r1);
    }

    public static boolean b() {
        return p.f();
    }

    public static boolean b(Context r2) {
        Context r3 = (Context) ZeusTransformUtils.wrapperContextForParams(r2, Context.class, "com.obric.memorydata.plugin");
        return p.b(r3);
    }

    public static String c(Context r2) {
        Context r3 = (Context) ZeusTransformUtils.wrapperContextForParams(r2, Context.class, "com.obric.memorydata.plugin");
        return p.a(r3);
    }

    public static void c(boolean r1) {
        p.b(r1);
    }

    public static boolean c() {
        return f15215b;
    }

    public static String d() {
        return d;
    }

    private void d(Context r2) {
        Context r1 = (Context) ZeusTransformUtils.wrapperContextForParams(r2, Context.class, "com.obric.memorydata.plugin");
        p.c(r1);
    }

    public static boolean d(boolean r2) {
        f r0 = f15214a;
        if (c() == false) goto L8;
        if (r0 == null) goto L8;
        return p.e(r2);
    L8:
        p.d(r2);
        return false;
    }

    public static int e() {
        return o;
    }

    public static boolean f() {
        return i;
    }

    public static IAppTraitCallback g() {
        return j;
    }

    public static String h() {
        return p.a();
    }

    public static boolean i() {
        return p.d();
    }

    public static int j() {
        return p.e();
    }

    public static void k() {
        p.c();
    }

    public static String l() {
        return p.b();
    }

    public static boolean m() {
        return g;
    }

    public static boolean n() {
        return f;
    }

    public static j o() {
        return k;
    }

    public static s p() {
        return m;
    }

    public static boolean q() {
        return h;
    }

    public static m r() {
        return n;
    }

    public static boolean s() {
        return l;
    }
}
