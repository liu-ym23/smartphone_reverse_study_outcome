package androidx.work;

import android.content.Context;

/* JADX INFO: loaded from: classes.dex */
public abstract class y {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final String f2966a = null;

    static {
        f2966a = m.f("WorkerFactory");
    }

    public final l a(Context r8, String r10, WorkerParameters r11) {
        String r12 = f2966a;
        l r13 = null;
        Class r14 = Class.forName(r10).asSubclass(l.class);     // Catch: Throwable -> L5
    L7:
        if (r14 != null) goto L20;
    L13:
        if (r13 != null) goto L15;
    L19:
        return r13;
    L15:
        if (r13.isUsed() == false) goto L19;
        throw new IllegalStateException("WorkerFactory (" + getClass().getName() + ") returned an instance of a ListenableWorker (" + r10 + ") which has already been invoked. createWorker() must always return a new instance of a ListenableWorker.");
    L20:
        r13 = (l) r14.getDeclaredConstructor(new Class[]{Context.class, WorkerParameters.class}).newInstance(new Object[]{r8, r11});     // Catch: Throwable -> L11
    L11:
        th = move-exception;
        m.d().c(r12, "Could not instantiate " + r10, th);
    L5:
        th = move-exception;
        m.d().c(r12, "Invalid class: " + r10, th);
        r14 = null;
        goto L7
    }
}
