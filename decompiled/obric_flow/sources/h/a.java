package h;

import ai.r0;
import android.os.Handler;
import android.os.Looper;
import com.bytedance.frameworks.baselib.network.dispatcher.IRequest$Priority;
import java.util.concurrent.Executor;

/* JADX INFO: loaded from: classes.dex */
public final class a implements Executor {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static volatile r9.c f17251b;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f17252a;

    public /* synthetic */ a(int r5) {
        this.f17252a = r5;
    }

    private final void a(Runnable r5) {
    }

    @Override // java.util.concurrent.Executor
    public final void execute(Runnable r5) {
        switch(this.f17252a) {
            case 0: goto L45;
            case 1: goto L53;
            case 2: goto L43;
            default: goto L4;
        };
    L4:
        if (r5 == null) goto L42;
        IRequest$Priority r10 = IRequest$Priority.NORMAL;
        if ((r5 instanceof r0) == false) goto L20;
        r0 r11 = (r0) r5;
        int r12 = r11.n();
        if (r12 != 0) goto L11;
        r10 = IRequest$Priority.LOW;
    L19:
        boolean r13 = r11.q();
        int r14 = r11.m();
    L22:
        if (f17251b != null) goto L24;
        f17251b = r9.c.h();
    L24:
        r9.a r15 = new r9.a(r10, r14, r5);
        if (r13 == false) goto L34;
        r9.c r16 = f17251b;
        monitor-enter(r16);
        r9.b.f.b(r15);     // Catch: Throwable -> L31
        monitor-exit(r16);
        return;
    L31:
        th = move-exception;
        throw th;
    L34:
        r9.c r17 = f17251b;
        monitor-enter(r17);
        r9.b.f.a(r15);     // Catch: Throwable -> L39
        monitor-exit(r17);
        return;
    L39:
        th = move-exception;
        throw th;
    L11:
        if (1 == r12) goto L19;
        if (2 != r12) goto L17;
        r10 = IRequest$Priority.HIGH;
        goto L19
    L17:
        if (3 != r12) goto L19;
        r10 = IRequest$Priority.IMMEDIATE;
        goto L19
    L20:
        r13 = false;
        r14 = 0;
        goto L22
    L42:
        return;
    L43:
        r5.run();
        return;
    L45:
        new Handler(Looper.getMainLooper()).post(r5);
        return;
    }
}
