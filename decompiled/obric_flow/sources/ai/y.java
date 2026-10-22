package ai;

import android.os.Handler;
import android.os.Looper;
import java.util.concurrent.Executor;

/* JADX INFO: loaded from: classes2.dex */
public final class y implements Executor {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f308a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Object f309b;

    public y(int r5) {
        this.f308a = r5;
        switch(r5) {
            case 1: goto L8;
            case 2: goto L6;
            default: goto L4;
        };
    L4:
        this.f309b = new Handler(Looper.getMainLooper());
        return;
    L6:
        this.f309b = new ThreadLocal();
        return;
    L8:
        this.f309b = new Handler(Looper.getMainLooper());
    }

    @Override // java.util.concurrent.Executor
    public final void execute(Runnable r5) {
        switch(this.f308a) {
            case 0: goto L33;
            case 1: goto L31;
            default: goto L4;
        };
    L4:
        ThreadLocal r10 = (ThreadLocal) this.f309b;
        Integer r11 = (Integer) r10.get();
        Integer r12 = 0;
        if (r11 != null) goto L7;
        r11 = r12;
    L7:
        int r13 = r11.intValue() + 1;
        r10.set(Integer.valueOf(r13));
        if (r13 > 15) goto L12;
        r5.run();     // Catch: Throwable -> L10
    L13:
        Integer r14 = (Integer) r10.get();
        if (r14 == null) goto L17;
        r12 = r14;
    L17:
        int r15 = r12.intValue() - 1;
        if (r15 != 0) goto L20;
        r10.remove();
        return;
    L20:
        r10.set(Integer.valueOf(r15));
        return;
    L12:
        h.c.d.f17256a.execute(r5);     // Catch: Throwable -> L10
    L10:
        th = move-exception;
        Integer r16 = (Integer) r10.get();
        if (r16 == null) goto L26;
        r12 = r16;
    L26:
        int r17 = r12.intValue() - 1;
        if (r17 != 0) goto L29;
        r10.remove();
    L30:
        throw th;
    L29:
        r10.set(Integer.valueOf(r17));
        goto L30
    L31:
        ((Handler) this.f309b).post(r5);
        return;
    L33:
        ((Handler) this.f309b).post(r5);
    }
}
