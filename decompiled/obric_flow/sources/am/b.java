package am;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.lynx.animax.util.AnimaXLog;
import com.lynx.base.log.LynxLog;
import com.lynx.tasm.base.TraceEvent;
import com.obric.android.agilelogger.ALog;
import java.util.HashSet;
import mn.h;
import so.f;

/* JADX INFO: loaded from: classes2.dex */
public final class b extends Handler {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f319a;

    public /* synthetic */ b(Looper r5, int r10) {
        this.f319a = r10;
        super(r5);
    }

    @Override // android.os.Handler
    public final void handleMessage(Message r5) {
        switch(this.f319a) {
            case 0: goto L50;
            case 1: goto L74;
            default: goto L4;
        };
    L4:
        int r10 = r5.what;
        if (r10 != 1) goto L7;
        Object r11 = r5.obj;
        if (r11 != null) goto L13;
        return;
    L13:
        if ((r11 instanceof f) == false) goto L91;
        ALog.access$000((f) r11);
        return;
    L91:
        return;
    L7:
        if (r10 != 2) goto L92;
        h.h();
        return;
    L92:
        return;
    L50:
        d r12 = (d) r5.obj;
        int r13 = r5.what;
        if (r13 != 1) goto L53;
        d.e.add(r12);
    L57:
        Object r14 = d.d;
        monitor-enter(r14);
    L72:
        d r15 = (d) d.f321c.poll();     // Catch: Throwable -> L64
        if (r15 == null) goto L67;
        if (r15.f322a == false) goto L63;
        r15.b(d.e);     // Catch: Throwable -> L64
        goto L72
    L63:
        d.g.offer(r15);     // Catch: Throwable -> L64
        goto L72
    L67:
        d.d.notifyAll();     // Catch: Throwable -> L64
        monitor-exit(r14);     // Catch: Throwable -> L64
        return;
    L64:
        th = move-exception;
        throw th;
    L53:
        if (r13 == 2) goto L55;
        String r16 = String.format("Bad message=%d", new Object[]{Integer.valueOf(r13)});
        AnimaXLog.a(AnimaXLog.LogLevel.f9715c, "CleanupReference", r16);
        goto L57
    L55:
        r12.b(d.e);
        goto L57
    L74:
        TraceEvent.c("CleanupReference.LazyHolder.handleMessage");     // Catch: Throwable -> L22
        com.lynx.tasm.base.c r17 = (com.lynx.tasm.base.c) r5.obj;     // Catch: Throwable -> L22
        int r18 = r5.what;     // Catch: Throwable -> L22
        if (r18 != 1) goto L20;
        com.lynx.tasm.base.c.e.add(r17);     // Catch: Throwable -> L22
    L29:
        Object r19 = com.lynx.tasm.base.c.d;     // Catch: Throwable -> L22
        monitor-enter(r19);     // Catch: Throwable -> L22
    L75:
        com.lynx.tasm.base.c r20 = (com.lynx.tasm.base.c) com.lynx.tasm.base.c.f10120c.poll();     // Catch: Throwable -> L36
        if (r20 == null) goto L42;
        if (r20.f10121a == false) goto L35;
        com.lynx.tasm.base.c.e.remove(r20);     // Catch: Throwable -> L36
        Runnable r21 = r20.f10122b;     // Catch: Throwable -> L36
        r20.f10122b = null;     // Catch: Throwable -> L36
        if (r21 == null) goto L41;
        r21.run();     // Catch: Throwable -> L36
    L41:
        r20.clear();     // Catch: Throwable -> L36
        goto L75
    L35:
        com.lynx.tasm.base.c.g.offer(r20);     // Catch: Throwable -> L36
        goto L75
    L42:
        com.lynx.tasm.base.c.d.notifyAll();     // Catch: Throwable -> L36
        monitor-exit(r19);     // Catch: Throwable -> L36
        TraceEvent.a(0, "CleanupReference.LazyHolder.handleMessage");
        return;
    L36:
        th = move-exception;
        throw th;     // Catch: Throwable -> L22
    L20:
        if (r18 == 2) goto L24;
        LynxLog.b(4, "CleanupReference", String.format("Bad message=%d", new Object[]{Integer.valueOf(r18)}));     // Catch: Throwable -> L22
        goto L29
    L24:
        HashSet r22 = com.lynx.tasm.base.c.e;     // Catch: Throwable -> L22
        r17.getClass();     // Catch: Throwable -> L22
        r22.remove(r17);     // Catch: Throwable -> L22
        Runnable r23 = r17.f10122b;     // Catch: Throwable -> L22
        r17.f10122b = null;     // Catch: Throwable -> L22
        if (r23 == null) goto L27;
        r23.run();     // Catch: Throwable -> L22
    L27:
        r17.clear();     // Catch: Throwable -> L22
    L22:
        th = move-exception;
        TraceEvent.a(0, "CleanupReference.LazyHolder.handleMessage");
        throw th;
    }
}
