package ko;

import com.lynx.base.log.LynxLog;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: loaded from: classes2.dex */
public abstract class l {
    private static final String TAG = "LynxLazyInitializer";
    private static final long TIMEOUT = 3;
    private final AtomicBoolean initialized;
    private final com.lynx.tasm.utils.h runnable;

    public l() {
        this.runnable = new com.lynx.tasm.utils.h(new com.obric.oui.lisitem.a(this, 13));
        this.initialized = new AtomicBoolean(false);
    }

    public final void a() {
        this.initialized.set(doInitialize());     // Catch: Exception -> L4
        return;
    L4:
        e = move-exception;
        LynxLog.b(4, TAG, "initialize failed: " + e);
    }

    public abstract boolean doInitialize();

    public boolean ensureInitialized(boolean r5) {
        if (this.runnable.f11175b.get() != 3) goto L6;
        return true;
    L6:
        if (r5 == true) goto L8;
        initialize();
    L9:
        com.lynx.tasm.utils.h r10 = this.runnable;
        TimeUnit r11 = TimeUnit.SECONDS;
        r10.getClass();
        boolean r12 = r10.d.await(TIMEOUT, r11);     // Catch: InterruptedException -> L12
    L13:
        if (r12 == true) goto L17;
        LynxLog.b(4, TAG, "ensureInitialized timeout");
        return false;
    L17:
        return this.initialized.get();
    L12:
        r12 = false;
        goto L13
    L8:
        this.runnable.run();
        goto L9
    }

    public void initialize() {
        if (this.runnable.f11175b.get() != 0) goto L6;
        mn.h.d().execute(this.runnable);
        return;
    }

    public boolean ensureInitialized() {
        return ensureInitialized(true);
    }
}
