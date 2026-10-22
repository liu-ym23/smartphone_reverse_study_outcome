package yg0;

import com.larus.apm.impl.protector.RunnableProtector;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class g implements Runnable {
    public static final g a = null;

    static {
        a = new g();
    }

    public g() {
    }

    @Override // java.lang.Runnable
    public final void run() {
        ln0.a r0 = h.a;     // Catch: Throwable -> L7
        if (r0 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("newLayoutConfigManager");     // Catch: Throwable -> L7
    L5:
        r0.b();     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        if (RunnableProtector.intercept(th) == false) goto L11;
        return;
    L11:
        throw th;
    }
}
