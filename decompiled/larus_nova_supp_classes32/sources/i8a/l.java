package i8a;

import com.lynx.tasm.base.LLog;
import com.lynx.tasm.core.LynxThreadPool;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
public abstract class l {
    private static final String TAG = "LynxLazyInitializer";
    private static final long TIMEOUT = 3;
    private final AtomicBoolean initialized;
    private final com.lynx.tasm.utils.k runnable;

    public static /* synthetic */ void e(l r0) {
        r0.runCatching();
    }

    public abstract boolean doInitialize();

    public boolean ensureInitialized() {
        return ensureInitialized(true);
    }

    private void runCatching() {
        this.initialized.set(doInitialize());     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        LLog.e(TAG, "initialize failed: " + th);
    }

    public void initialize() {
        if (this.runnable.b.get() != 0) goto L6;
        LynxThreadPool.a().execute(this.runnable);
        return;
    }

    /* JADX WARN: Type inference failed for: r1v0, types: [i8a.k] */
    public l() {
        this.runnable = new com.lynx.tasm.utils.k(new k(this));
        this.initialized = new AtomicBoolean(false);
    }

    public boolean ensureInitialized(boolean r5) {
        if (this.runnable.b.get() == 3) goto L5;
        if (r5 == true) goto L8;
        initialize();
    L9:
        com.lynx.tasm.utils.k r6 = this.runnable;
        TimeUnit r0 = TimeUnit.SECONDS;
        r6.getClass();
        boolean r7 = r6.d.await(3, r0);     // Catch: InterruptedException -> L12
    L13:
        if (r7 == true) goto L17;
        LLog.e(TAG, "ensureInitialized timeout");
        return false;
    L17:
        return this.initialized.get();
    L12:
        r7 = false;
        goto L13
    L8:
        this.runnable.run();
        goto L9
    L5:
        return this.initialized.get();
    }
}
