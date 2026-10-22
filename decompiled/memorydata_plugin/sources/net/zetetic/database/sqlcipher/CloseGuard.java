package net.zetetic.database.sqlcipher;

import android.util.Log;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.Objects;

/* JADX INFO: loaded from: classes6.dex */
public final class CloseGuard {
    private static volatile boolean ENABLED;
    private static final CloseGuard NOOP = null;
    private static volatile Reporter REPORTER;
    private Throwable allocationSite;

    /* JADX INFO: renamed from: net.zetetic.database.sqlcipher.CloseGuard$1, reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
    }

    private static final class DefaultReporter implements Reporter {
        private DefaultReporter() {
        }

        /* synthetic */ DefaultReporter(AnonymousClass1 r1) {
            this();
        }

        @Override // net.zetetic.database.sqlcipher.CloseGuard.Reporter
        public void report(String r1, Throwable r2) {
            Log.w(r1, r2);
        }
    }

    public interface Reporter {
        void report(String r1, Throwable r2);
    }

    static {
        NOOP = new CloseGuard();
        ENABLED = true;
        REPORTER = new DefaultReporter(null);
    }

    private CloseGuard() {
    }

    public static CloseGuard get() {
        if (ENABLED == true) goto L7;
        return NOOP;
    L7:
        return new CloseGuard();
    }

    public static Reporter getReporter() {
        return REPORTER;
    }

    public static void setEnabled(boolean r0) {
        ENABLED = r0;
    }

    public static void setReporter(Reporter r2) {
        Reporter r3 = (Reporter) ZeusTransformUtils.wrapperContextForParams(r2, Reporter.class, "com.obric.memorydata.plugin");
        Objects.requireNonNull(r3, "reporter == null");
        REPORTER = r3;
    }

    public void close() {
        this.allocationSite = null;
    }

    public void open(String r3) {
        Objects.requireNonNull(r3, "closer == null");
        if (this != NOOP) goto L5;
        return;
    L5:
        if (ENABLED == false) goto L10;
        this.allocationSite = new Throwable("Explicit termination method '" + r3 + "' not called");
        return;
    }

    public void warnIfOpen() {
        if (this.allocationSite != null) goto L5;
        return;
    L5:
        if (ENABLED == false) goto L10;
        REPORTER.report("A resource was acquired at attached stack trace but never released. See java.io.Closeable for information on avoiding resource leaks.", this.allocationSite);
        return;
    }
}
