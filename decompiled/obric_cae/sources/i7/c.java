package i7;

import com.bytedance.retrofit2.SsRunnable;
import java.util.concurrent.Executor;
import v6.d;
import v6.e;

/* JADX INFO: loaded from: classes.dex */
public final class c implements Executor {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static volatile e f8277a;

    @Override // java.util.concurrent.Executor
    public final void execute(Runnable r8) {
        if (r8 == null) goto L50;
        v6.c.a r10 = v6.c.a.f12737b;
        if ((r8 instanceof SsRunnable) == false) goto L18;
        SsRunnable r11 = (SsRunnable) r8;
        int r12 = r11.priority();
        if (r12 != 0) goto L9;
        r10 = v6.c.a.f12736a;
    L17:
        boolean r13 = r11.isStreaming();
        int r14 = r11.getRequestDelayTime();
    L20:
        if (f8277a == null) goto L22;
    L34:
        v6.a r15 = new v6.a(r10, r14, r8);
        e r16 = f8277a;
        if (r13 == false) goto L43;
        monitor-enter(r16);
        d.f12742p.b(r15);     // Catch: Throwable -> L40
        monitor-exit(r16);
        return;
    L40:
        th = move-exception;
        throw th;
    L43:
        monitor-enter(r16);
        d.f12742p.a(r15);     // Catch: Throwable -> L47
        monitor-exit(r16);
        return;
    L47:
        th = move-exception;
        throw th;
    L22:
        if (e.f12751c == null) goto L24;
    L33:
        f8277a = e.f12751c;
        goto L34
    L24:
        monitor-enter(e.class);
    L30:
        th = move-exception;
        throw th;
    L26:
        if (e.f12751c != null) goto L28;
        e.f12751c = new e();     // Catch: Throwable -> L30
    L28:
        monitor-exit(e.class);     // Catch: Throwable -> L30
        goto L33
    L9:
        if (1 == r12) goto L17;
        if (2 != r12) goto L15;
        r10 = v6.c.a.f12738m;
        goto L17
    L15:
        if (3 != r12) goto L17;
        r10 = v6.c.a.f12739n;
        goto L17
    L18:
        r13 = false;
        r14 = 0;
        goto L20
    }
}
