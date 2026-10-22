package b9;

import android.os.Build;
import android.os.Process;
import android.os.StrictMode;
import android.os.SystemClock;
import android.util.Log;
import com.bumptech.glide.load.engine.h0;
import com.bytedance.crash.c;
import com.bytedance.crash.gwpasan.GwpAsan;
import com.bytedance.crash.heaptracker.NativeHeapTracker;
import com.bytedance.crash.n;
import com.lynx.tasm.utils.e;
import java.io.File;
import java.io.IOException;
import t2.d;
import w8.b;

/* JADX INFO: loaded from: classes2.dex */
public final class a extends Thread {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f886a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Object f887b;

    public a(GwpAsan r5) {
        this.f886a = 0;
        this.f887b = r5;
        super("XAsanTracker");
    }

    @Override // java.lang.Thread, java.lang.Runnable
    public final void run() {
        switch(this.f886a) {
            case 0: goto L123;
            case 1: goto L75;
            case 2: goto L18;
            case 3: goto L9;
            default: goto L4;
        };
    L4:
        super.run();
    L5:
        SystemClock.sleep(n.f4062j.getDefaultAnrCheckInterval());
        h0 r5 = (h0) ((jm.a) this.f887b).f18353b;
        if (r5.f1510a == true) goto L7;
        ((b) r5.f1511b).k(-1, null);
        h0.f = SystemClock.uptimeMillis();
        goto L5
    L7:
        return;
    L9:
        int r10 = ((d) this.f887b).f22093b.ordinal();
        if (r10 != 0) goto L12;
        Process.setThreadPriority(10);
    L16:
        super.run();
        return;
    L12:
        if (r10 != 2) goto L16;
        Process.setThreadPriority(-4);
    L18:
        NativeHeapTracker r11 = (NativeHeapTracker) this.f887b;
        int r12 = r11.f4045a;
        String r13 = r11.g;
        File r14 = r11.f;
        int r15 = 0;
        if (r12 == 5) goto L67;
        if (r11.f4046b == true) goto L67;
        boolean r16 = r11.f4050j;
        if (r16 == false) goto L25;
        e.g(r11.l().concat("Thread running ..."));
    L25:
        int r17 = r11.f4045a;
        int r18 = r11.e;
        if (r17 != 1) goto L28;
        int r19 = (int) (NativeHeapTracker.b() / 1048576);
        int r20 = r11.f4047c;
        if (r19 < r20) goto L58;
        NativeHeapTracker.m(r11);
        r11.f4045a = 2;
    L62:
        r15 = r18;
    L63:
        if (r15 <= 0) goto L18;
        if (r16 == false) goto L66;
        e.g(r11.l() + "Thread sleeping " + r15 + " seconds ...");
    L66:
        SystemClock.sleep(r15 * 1000);
        goto L18
    L58:
        if (r19 > (r20 / 4)) goto L60;
    L59:
        r15 = r18 * 4;
        goto L63
    L60:
        if (r19 == 0) goto L62;
        r15 = (r18 * r20) / r19;
        goto L63
    L28:
        if (r17 == 2) goto L48;
        int r21 = r11.d;
        if (r17 == 3) goto L37;
        if (r17 != 4) goto L62;
        if (((int) (NativeHeapTracker.g() / 65536)) < r21) goto L36;
        NativeHeapTracker.i(r11);
        r11.f4045a = 5;
        goto L63
    L36:
        NativeHeapTracker.m(r11);
        r11.f4045a = 3;
        goto L62
    L37:
        int r22 = (int) (NativeHeapTracker.g() / 1048576);
        if (r16 == false) goto L41;
        e.g("Tracking leak " + r22 + " MB");
    L41:
        if (r22 < ((r21 * 5) / 4)) goto L44;
        NativeHeapTracker.d(r11);
        r11.f4045a = 4;
        goto L62
    L44:
        if (r22 < (r21 / 4)) goto L59;
        if (r22 == 0) goto L62;
        r15 = (r18 * r21) / r22;
        goto L63
    L48:
        File r23 = new File(r14.getAbsolutePath() + r13);
        if (r23.exists() == true) goto L51;
    L53:
        r11.f4045a = 3;
        goto L63
    L51:
        if (r23.delete() == true) goto L53;
        e.g("delete guard file faild!");
    L67:
        NativeHeapTracker.f4041l = false;
        if (r11.f4046b == false) goto L126;
        NativeHeapTracker.k(r11);
    L126:
        cl.a.u(String.valueOf(System.currentTimeMillis() / 1000), new File(r14.getAbsolutePath() + r13), false);     // Catch: IOException -> L72
    L73:
        e.g(r11.l().concat("Thread exit!"));
        return;
    L72:
        e.g("write guard file faild!");
        goto L73
    L75:
        Process.setThreadPriority(9);
        if (((c0.a) this.f887b).f1095b == false) goto L128;
        StrictMode.setThreadPolicy(new StrictMode.ThreadPolicy.Builder().detectNetwork().penaltyDeath().build());
    L128:
        super.run();     // Catch: Throwable -> L80
        return;
    L80:
        th = move-exception;
        if (Log.isLoggable("GlideExecutor", 6) == false) goto L137;
        Log.e("GlideExecutor", "Request threw uncaught throwable", th);
        return;
    L137:
        return;
    L123:
        GwpAsan r110 = (GwpAsan) this.f887b;     // Catch: Throwable -> L96
        io.reactivex.exceptions.a.d("XASAN", "loadLibrary...");     // Catch: Throwable -> L96
        if (r110.f4040a == true) goto L94;
        io.reactivex.exceptions.a.p(GwpAsan.f4038n, "npth_xasan");     // Catch: Throwable -> L91
        r110.f4040a = true;     // Catch: Throwable -> L91
    L91:
        th = move-exception;
        th.printStackTrace();     // Catch: Throwable -> L96
    L94:
        if (r110.f4040a == true) goto L98;
        io.reactivex.exceptions.a.e("XASAN", "XAsan Init Failed load Lib Fail");     // Catch: Throwable -> L96
        return;
    L98:
        File r111 = GwpAsan.f4037m;     // Catch: Throwable -> L96
        if (r111 != null) goto L102;
        io.reactivex.exceptions.a.e("XASAN", "mLogDirectory is null");     // Catch: Throwable -> L96
        return;
    L102:
        if (r111.exists() == true) goto L107;
        if (GwpAsan.f4037m.mkdir() == true) goto L107;
        io.reactivex.exceptions.a.e("XASAN", "cannot create " + GwpAsan.f4037m);     // Catch: Throwable -> L96
        return;
    L107:
        if (GwpAsan.e(GwpAsan.f4034j) == true) goto L109;
        io.reactivex.exceptions.a.e("XASAN", "init params failed");     // Catch: Throwable -> L96
        return;
    L109:
        GwpAsan.g[5] = GwpAsan.f4037m.getAbsolutePath() + '/' + n.f();     // Catch: Throwable -> L96
        GwpAsan.g[6] = GwpAsan.f4037m.getAbsolutePath();     // Catch: Throwable -> L96
        GwpAsan.f4033i = true;     // Catch: Throwable -> L96
        String[] r112 = GwpAsan.g;     // Catch: Throwable -> L96
        if (r112 != null) goto L112;
    L116:
        int r113 = -1;
    L117:
        if (1 == r113) goto L119;
        io.reactivex.exceptions.a.e("XASAN", "XAsan Init Failed code " + r113);     // Catch: Throwable -> L96
        return;
    L119:
        io.reactivex.exceptions.a.d("XASAN", "init end");     // Catch: Throwable -> L96
        return;
    L112:
        if (r112[5] == null) goto L116;
        if (r112[6] == null) goto L116;
        r113 = GwpAsan.a(Build.VERSION.SDK_INT, GwpAsan.g);     // Catch: Throwable -> L96
    L96:
        th = move-exception;
        c.f4025a.getClass();
        m.b.h("NPTH_CATCH", th);
    }

    public a(NativeHeapTracker r5) {
        this.f886a = 2;
        this.f887b = r5;
        super("NativeHeapTracker");
    }

    public a(Runnable r5, String r10, d r11) {
        this.f886a = 3;
        this.f887b = r11;
        super(r5, r10);
    }

    public a(jm.a r5) {
        this.f886a = 4;
        this.f887b = r5;
        super("anr_monitor_new");
    }

    public a(c0.a r5, Runnable r10, String r11) {
        this.f886a = 1;
        this.f887b = r5;
        super(r10, r11);
    }
}
