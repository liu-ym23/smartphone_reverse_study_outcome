package am;

import android.os.Message;
import android.os.Process;
import android.os.SystemClock;
import com.bytedance.crash.util.NativeTools;
import com.lynx.animax.util.AnimaXLog;
import com.lynx.base.log.LynxLog;
import com.lynx.tasm.base.TraceEvent;
import kotlin.Unit;

/* JADX INFO: loaded from: classes2.dex */
public final class a extends Thread {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f318a;

    public /* synthetic */ a(Runnable r5, String r10, int r11) {
        this.f318a = r11;
        super(r5, r10);
    }

    @Override // java.lang.Thread, java.lang.Runnable
    public void run() {
        switch(this.f318a) {
            case 0: goto L85;
            case 1: goto L89;
            case 2: goto L42;
            case 3: goto L4;
            case 4: goto L84;
            case 5: goto L25;
            case 6: goto L6;
            default: goto L4;
        };
    L4:
        super.run();
        return;
    L6:
        super.run();
    L93:
        if (a.a.d == false) goto L23;
        long r5 = SystemClock.uptimeMillis();     // Catch: Throwable -> L82
        if (z5.a.e() == false) goto L12;
    L18:
        a.a.g = (r5 - a.a.f19i) / a.a.f18h;     // Catch: Throwable -> L82
        long r10 = r5 - a.a.f19i;     // Catch: Throwable -> L82
        long r11 = a.a.f18h;     // Catch: Throwable -> L82
        long r12 = r10 % r11;     // Catch: Throwable -> L82
        if (r12 < 95) goto L21;
        a.a.g--;     // Catch: Throwable -> L82
        r11 = a.a.f18h << 1;     // Catch: Throwable -> L82
    L21:
        SystemClock.sleep(r11 - r12);     // Catch: Throwable -> L82
        goto L93
    L12:
        if (a.a.f26p >= 0) goto L87;
    L16:
        long r13 = 0;
    L17:
        a.a.f27q = r13;     // Catch: Throwable -> L82
        goto L18
    L87:
        r13 = NativeTools.k().j(a.a.f26p);     // Catch: Throwable -> L81
    L23:
        a.a.f23m = false;
        return;
    L25:
        Process.setThreadPriority(10);
        super.run();
        return;
    L42:
        Process.setThreadPriority(10);
        super.run();
        return;
    L85:
        d r14 = (d) d.f321c.remove();     // Catch: Exception -> L79
        Object r15 = d.d;     // Catch: Exception -> L79
        monitor-enter(r15);     // Catch: Exception -> L79
    L67:
        if (r14.f322a == true) goto L71;
        d.g.offer(r14);     // Catch: Throwable -> L69
    L72:
        d r16 = (d) d.g.poll();     // Catch: Throwable -> L69
        if (r16 == null) goto L75;
        r16.b(d.f);     // Catch: Throwable -> L69
        goto L72
    L75:
        monitor-exit(r15);     // Catch: Throwable -> L69
        goto L85
    L71:
        Message.obtain(c.f320a, 2, r14).sendToTarget();     // Catch: Throwable -> L69
        r15.wait(500);     // Catch: Throwable -> L69
    L69:
        th = move-exception;
        throw th;     // Catch: Exception -> L79
    L79:
        e = move-exception;
        AnimaXLog.a(AnimaXLog.LogLevel.f9715c, "CleanupReference", "Queue remove exception:" + e.toString());
    L89:
        com.lynx.tasm.base.c r17 = (com.lynx.tasm.base.c) com.lynx.tasm.base.c.f10120c.remove();     // Catch: Exception -> L62
        Object r18 = com.lynx.tasm.base.c.d;     // Catch: Exception -> L62
        monitor-enter(r18);     // Catch: Exception -> L62
    L47:
        if (r17.f10121a == true) goto L51;
        com.lynx.tasm.base.c.g.offer(r17);     // Catch: Throwable -> L49
    L52:
        com.lynx.tasm.base.c r19 = (com.lynx.tasm.base.c) com.lynx.tasm.base.c.g.poll();     // Catch: Throwable -> L49
        if (r19 == null) goto L58;
        TraceEvent.c("CleanupReference.ReaperThread.runCleanupTask");     // Catch: Throwable -> L49
        com.lynx.tasm.base.c.f.remove(r19);     // Catch: Throwable -> L49
        Runnable r20 = r19.f10122b;     // Catch: Throwable -> L49
        r19.f10122b = null;     // Catch: Throwable -> L49
        if (r20 == null) goto L57;
        r20.run();     // Catch: Throwable -> L49
    L57:
        r19.clear();     // Catch: Throwable -> L49
        TraceEvent.a(0, "CleanupReference.ReaperThread.runCleanupTask");     // Catch: Throwable -> L49
        goto L52
    L58:
        monitor-exit(r18);     // Catch: Throwable -> L49
        goto L89
    L51:
        Message.obtain(com.lynx.tasm.base.b.f10119a, 2, r17).sendToTarget();     // Catch: Throwable -> L49
        r18.wait(500);     // Catch: Throwable -> L49
    L49:
        th = move-exception;
        throw th;     // Catch: Exception -> L62
    L62:
        e = move-exception;
        LynxLog.b(4, "CleanupReference", "Queue remove exception:" + e.toString());
    L84:
        monitor-enter(nu.e.class);     // Catch: InterruptedException -> L83
        nu.e.Companion.getClass();     // Catch: Throwable -> L34
        nu.e r21 = nu.b.a();     // Catch: Throwable -> L34
        if (r21 != nu.e.access$getHead$cp()) goto L36;
        nu.e.access$setHead$cp(null);     // Catch: Throwable -> L34
        goto L84
    L32:
        monitor-exit(nu.e.class);     // Catch: InterruptedException -> L83
        return;
    L36:
        Unit r22 = Unit.INSTANCE;     // Catch: Throwable -> L34
        monitor-exit(nu.e.class);     // Catch: InterruptedException -> L83
        if (r21 == null) goto L84;
        r21.timedOut();     // Catch: InterruptedException -> L83
    L34:
        th = move-exception;
        throw th;     // Catch: InterruptedException -> L83
    }

    public /* synthetic */ a(String r5, int r10) {
        this.f318a = r10;
        super(r5);
    }

    public /* synthetic */ a(ThreadGroup r5, Runnable r10, String r11, long r12) {
        this.f318a = 2;
        super(r5, r10, r11, r12);
    }
}
