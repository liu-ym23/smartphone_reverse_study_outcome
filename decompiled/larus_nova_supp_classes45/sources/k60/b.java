package k60;

import android.app.Application;
import android.os.Handler;
import android.os.Looper;
import android.view.Choreographer;
import android.view.Display;
import android.view.WindowManager;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.core.setting.LiveInfraSettingKeys;
import com.bytedance.android.live.core.setting.q1;
import com.bytedance.android.live.core.utils.MainThreadPostUtils;
import com.bytedance.android.live.core.utils.v;
import com.bytedance.android.livesdkapi.model.com.bytedance.android.live.core.performance.fwatchdog.LiveFWatchDogV2Config;
import com.bytedance.fwatchdog.FWatchDogV2;
import com.larus.apm.impl.protector.RunnableProtector;
import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;
import iy5.e;
import iy5.f;
import iy5.h;
import iy5.i;
import iy5.j;
import iy5.k;
import iy5.l;
import java.lang.reflect.Field;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public final class b {
    public static final k60.a a = null;
    public static final LiveFWatchDogV2Config b = null;
    public static int c;
    public static boolean d;
    public static int e;
    public static int f;
    public static final a g = null;
    public static final C0241b h = null;

    public class a implements Runnable {
        public a() {
        }

        @Override // java.lang.Runnable
        public final void run() {
            b.h();     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }
    }

    /* JADX INFO: renamed from: k60.b$b, reason: collision with other inner class name */
    public class C0241b implements j {
        public C0241b() {
        }

        public final void i(String r2) {
            if (v.a() == true) goto L7;
            ALogger.i("FWatchDogV2", r2);
            return;
        }

        public final void v(String r2) {
            if (v.a() == true) goto L7;
            ALogger.v("FWatchDog", r2);
            return;
        }

        public final void d(String r2, String r3) {
            if (v.a() == true) goto L7;
            ALogger.d(r2, r3);
            return;
        }

        public final void e(String r2, String r3) {
            if (v.a() == true) goto L7;
            ALogger.e(r2, r3);
            return;
        }

        public final void w(String r2, String r3) {
            if (v.a() == true) goto L7;
            ALogger.w(r2, r3);
            return;
        }
    }

    static {
        a = LiveInfraSettingKeys.LIVE_WIDGET_FRAMEWORK_OPT.getValue();
        b = (LiveFWatchDogV2Config) q1.a.getValue();
        c = -1;
        d = false;
        e = 0;
        f = 0;
        g = new a();
        h = new C0241b();
    }

    public static boolean a() {
        k60.a r0 = a;
        if (r0.mEnable == true) goto L5;
    L7:
        return false;
    L5:
        if (r0.mEnableAsync == false) goto L7;
        return true;
    }

    public static boolean b() {
        if (a.mEnable == true) goto L5;
    L7:
        return false;
    L5:
        if (b.getEnterStartDelay() <= 0) goto L7;
        return true;
    }

    public static boolean c() {
        k60.a r0 = a;
        if (r0.mEnable == true) goto L5;
    L7:
        return false;
    L5:
        if (r0.mEnableInsert == false) goto L7;
        return true;
    }

    public static boolean d() {
        k60.a r0 = a;
        if (r0.mEnable == true) goto L5;
    L7:
        return false;
    L5:
        if (r0.mEnableRxJava == false) goto L7;
        return true;
    }

    public static boolean e() {
        k60.a r0 = a;
        if (r0.mEnable == true) goto L5;
    L7:
        return false;
    L5:
        if (r0.mEnableThreadPool == false) goto L7;
        return true;
    }

    public static boolean f() {
        k60.a r0 = a;
        if (r0.mEnable == true) goto L5;
    L7:
        return false;
    L5:
        if (r0.mEnableToolbar == false) goto L7;
        return true;
    }

    public static int g() {
        k60.a r0 = a;
        if (r0.mEnable == true) goto L7;
        return -1;
    L7:
        return r0.mStrategyVersion;
    }

    public static int h() {
        MainThreadPostUtils.d(g);
        if (d == true) goto L5;
    L8:
        k60.a r0 = a;
        if (r0.mEnable == true) goto L11;
    L13:
        boolean r1 = false;
    L15:
        if (r1 == false) goto L35;
        if (f == 1) goto L35;
        h.a r2 = new h.a();
        LiveFWatchDogV2Config r5 = b;
        r2.a = r5.getEnableLog();
        r2.b = r5.getLogLevel();
        r2.c = r5.getMinSdkApi();
        r2.d = r5.getMaxSdkApi();
        r2.f = r5.getEnableRetryReflect();
        if (r5.getOnVsyncActionStrategy() != 0) goto L21;
        r2.e = 0;
    L22:
        FWatchDogV2 r6 = FWatchDogV2.c();
        h r7 = new h(r2);
        r6.j = r7;
        f r3 = r6.i;
        r3.a = r7.a;
        int r8 = r7.b;
        if (r8 < 0) goto L26;
        if (r8 > 5) goto L26;
        r3.c = r8;
    L26:
        r6.a = new l(new iy5.a(), r7.f);
        int r4 = FWatchDogV2.c().f();
        f = 2;
        if (r4 <= 0) goto L30;
        c = r4;
        return r4;
    L30:
        d = true;
        e = r4;
        if (r5.getEnableFallback() == true) goto L35;
        c = r4;
        return r4;
    L21:
        r2.e = 1;
    L35:
        if (r0.mEnable == true) goto L37;
    L39:
        boolean r9 = false;
    L40:
        if (r9 == false) goto L132;
        f = 1;
        e r11 = e.d();
        Application r12 = jc1.a.b();
        double r13 = r0.mMaxDropFrame;
        float r14 = r0.mDropFrameCheckTime;
        long r15 = r0.mDynamicIntervalFrames;
        long r16 = r0.mNRTimeConfig;
        boolean r17 = r0.mOptimizeReflect;
        boolean r18 = r0.mEnableLog;
        boolean r19 = r0.mEnableV2Opt;
        e.b r110 = h;
        if (r11.e == false) goto L45;
        r11.y.e("FWatchDog", "FWatchDog is running!Config failed!");
    L83:
        e r21 = e.d();
        r21.getClass();
        if (Looper.myLooper() != Looper.getMainLooper()) goto L86;
        boolean r22 = true;
    L87:
        if (r22 == false) goto L131;
        boolean r23 = ((Boolean) new k(Choreographer.getInstance()).c("USE_VSYNC", new Class[0]).a).booleanValue();     // Catch: Exception -> L134
    L103:
        if (r23 == true) goto L106;
        r21.y.b("FWatchDog", "not use vsync!");
        int r24 = -2;
    L127:
        if (r24 <= 0) goto L129;
        c = r24;
    L129:
        return r24;
    L106:
        if (r21.e == false) goto L108;
        r21.y.b("FWatchDog", "FWatchDog has started!");
        r24 = -3;
        goto L127
    L108:
        r21.e = true;
        int r25 = e.M.addAndGet(1);
        if (r21.E == true) goto L111;
        r21.d = r25;
    L111:
        r21.y.a("FWatchDog", "startWatchDog");
        r21.l = (long) (r21.C * r21.p);
        r21.k = r21.l + r21.o;
        Choreographer.getInstance().removeFrameCallback(r21.F);
        Choreographer.getInstance().postFrameCallback(r21.F);
        if (r21.s == true) goto L114;
        e.d r26 = r21.f;
        if (r26 == null) goto L124;
        if (r26 != null) goto L135;
    L125:
        ThreadMethodProxy.start(r21.f);
    L126:
        r24 = r25;
        goto L127
    L135:
        r26.y = true;     // Catch: Exception -> L122
        r21.f.interrupt();     // Catch: Exception -> L122
    L122:
        e = move-exception;
        r21.y.b("FWatchDog", e.getMessage());
        goto L125
    L124:
        r21.f = new e.d(r21, r21.p, r21.q);
        goto L125
    L114:
        if (r21.g == null) goto L116;
        r21.h();
    L116:
        e.e r27 = new e.e();
        r21.g = r27;
        ThreadMethodProxy.setPriority(r27, 5);
        ThreadMethodProxy.start(r21.g);
        r21.h = true;
        r21.i = new Handler(r21.g.getLooper());
        r21.i.removeCallbacks(r21.K);
        Handler r28 = r21.i;
        e.c r29 = r21.K;
        r28.postDelayed(r29, ((e.f) r29).a);
    L141:
        iy5.a r31 = r21.a;     // Catch: Exception -> L101
        if (r31.g != null) goto L97;
        r31.g = r31.b(Choreographer.class, "USE_VSYNC", Boolean.class);     // Catch: Exception -> L101
    L97:
        Field r32 = r31.g;     // Catch: Exception -> L101
        if (r32 == null) goto L102;
        r23 = r32.getBoolean(Choreographer.getInstance());     // Catch: Exception -> L101
    L102:
        r23 = false;
    L101:
        r21.y.b("FWatchDog", "read vsync field error!");
        goto L102
    L131:
        throw new IllegalThreadStateException("FWatchDog must start from mainThread!");
    L86:
        r22 = false;
        goto L87
    L45:
        if (r13 <= 0.0d) goto L48;
        r11.p = r13;
    L48:
        if (r14 <= 0.0f) goto L51;
        r11.q = r14;
    L51:
        if (r15 < 0) goto L54;
        r11.m = r15;
    L54:
        if (r16 <= 0) goto L57;
        r11.r = r16 * 1000000;
    L57:
        if (r12 != null) goto L59;
        i.c = 60;
    L69:
        float r33 = 1000 / i.c;
        i.d = r33;
        i.e = true;
        if (i.a >= 0) goto L72;
        i.a = (long) Math.ceil(r33 * 1000000.0f);
    L72:
        r11.C = i.a;
        if (i.b < 0) goto L75;
    L79:
        r11.D = i.b;
        f r34 = r11.y;
        if (r110 != null) goto L82;
        r110 = r11.J;
    L82:
        r34.b = r110;
        r34.a = r18;
        r11.t = r17;
        r11.s = r19;
        goto L83
    L75:
        if (i.e == false) goto L77;
        float r35 = i.d;
    L78:
        i.b = (long) Math.ceil(r35);
        goto L79
    L77:
        r35 = 16.666668f;
        goto L78
    L59:
        WindowManager r36 = (WindowManager) r12.getSystemService("window");
        if (r36 == null) goto L65;
        Display r37 = r36.getDefaultDisplay();
        if (r37 == null) goto L64;
        i.c = r37.getRefreshRate();
    L67:
        if (i.c > 0.0f) goto L69;
        i.c = 60;
        goto L69
    L64:
        i.c = 60;
        goto L67
    L65:
        i.c = 60;
        goto L67
    L132:
        return -1;
    L37:
        if (r0.mEnableFWatchDog == false) goto L39;
        r9 = true;
        goto L40
    L11:
        if (b.getEnable() == false) goto L13;
        r1 = true;
        goto L15
    L5:
        if (b.getEnableFallback() == true) goto L8;
        return e;
    }

    public static void i() {
        MainThreadPostUtils.d(g);
        j(c);
    }

    public static void j(int r7) {
        int r0 = f;
        if (r0 != 2) goto L6;
        FWatchDogV2.c().g(r7);
        return;
    L6:
        if (r0 != 1) goto L36;
        e r1 = e.d();
        r1.getClass();
        if (r7 >= 0) goto L11;
        return;
    L11:
        if (Looper.myLooper() != Looper.getMainLooper()) goto L13;
        boolean r2 = true;
    L14:
        if (r2 == false) goto L32;
        if (r1.d == r7) goto L19;
        return;
    L19:
        if (r1.e == false) goto L40;
        r1.e = false;
        r1.y.a("FWatchDog", "stopWatchDog");
        if (r1.s == false) goto L34;
        r1.h();
    L30:
        Choreographer.getInstance().removeFrameCallback(r1.F);
        r1.e().removeCallbacks(r1.G);
        r1.e().removeCallbacks(r1.H);
        r1.e().removeCallbacks(r1.I);
        r1.g(r1.u);
        r1.a();
        r1.j = -1;
        r1.o = 0;
        r1.n = 0;
        r1.m = 10;
        r1.v = -1;
        r1.u = -1;
        r1.w = -1;
        r1.x = false;
        r1.f = null;
        r1.B = null;
        r1.E = false;
        return;
    L34:
        e.d r8 = r1.f;     // Catch: Exception -> L28
        if (r8 == null) goto L30;
        r8.y = true;     // Catch: Exception -> L28
        r1.f.interrupt();     // Catch: Exception -> L28
    L28:
        e = move-exception;
        r1.y.b("FWatchDog", e.getMessage());
        goto L30
    L40:
        return;
    L32:
        throw new IllegalThreadStateException("FWatchDog must stop from mainThread!");
    L13:
        r2 = false;
        goto L14
    }

    public static void k(float r12) {
        e r0 = e.d();
        if (r12 <= 0.0f) goto L12;
        r0.q = r12;
        if (r0.s == false) goto L9;
        e.c r1 = r0.K;
        if (r1 == null) goto L14;
        ((e.f) r1).a = Math.max((long) ((((e.f) r1).c.D * ((e.f) r1).b) * ((double) r12)), 1);
        ((e.f) r1).c.y.a("FWatchDog", "updateCheckInterval:" + ((e.f) r1).a + "  mDropFrameCheckTime:" + r12);
        return;
    L14:
        return;
    L9:
        e.d r2 = r0.f;
        if (r2 == null) goto L16;
        double r6 = r12;
        r2.w = r6;
        r2.x = Math.max((long) ((r2.z.D * r2.v) * r6), 1);
        r2.z.y.a("FWatchDog", "updateCheckInterval:" + r2.x + "  dropFrameCheckTime:" + r12);
        return;
    L16:
        return;
    L12:
        r0.getClass();
    }
}
