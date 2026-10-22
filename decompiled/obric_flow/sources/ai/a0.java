package ai;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.concurrent.Executor;

/* JADX INFO: loaded from: classes2.dex */
public final class a0 implements Executor {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Object f178a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final Method f179b = null;

    static {
        Class<?> r5 = Class.forName("org.robovm.apple.foundation.NSOperationQueue");     // Catch: Exception -> L4
        f178a = r5.getDeclaredMethod("getMainQueue", null).invoke(null, null);     // Catch: Exception -> L4
        f179b = r5.getDeclaredMethod("addOperation", new Class[]{Runnable.class});     // Catch: Exception -> L4
        return;
    L4:
        e = move-exception;
        throw new AssertionError(e);
    }

    @Override // java.util.concurrent.Executor
    public final void execute(Runnable r5) {
        f179b.invoke(f178a, new Object[]{r5});     // Catch: InvocationTargetException -> L4 Throwable -> L6
        return;
    L6:
        e = move-exception;
        throw new AssertionError(e);
    L4:
        e = move-exception;
        Throwable r10 = e.getCause();
        if ((r10 instanceof RuntimeException) == true) goto L17;
        if ((r10 instanceof Error) == false) goto L15;
        throw ((Error) r10);
    L15:
        throw new RuntimeException(r10);
    L17:
        throw ((RuntimeException) r10);
    }
}
