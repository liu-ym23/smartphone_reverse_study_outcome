package nc;

import java.util.logging.Handler;
import java.util.logging.LogRecord;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes3.dex */
public final class d extends Handler {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final d f11345a = null;

    static {
        f11345a = new d();
    }

    private d() {
    }

    @Override // java.util.logging.Handler
    public void close() {
    }

    @Override // java.util.logging.Handler
    public void flush() {
    }

    @Override // java.util.logging.Handler
    public void publish(LogRecord r10) {
        Intrinsics.checkNotNullParameter(r10, "record");
        c r11 = c.f11342a;
        String r12 = r10.getLoggerName();
        Intrinsics.checkNotNullExpressionValue(r12, "record.loggerName");
        int r13 = e.a(r10);
        String r14 = r10.getMessage();
        Intrinsics.checkNotNullExpressionValue(r14, "record.message");
        r11.a(r12, r13, r14, r10.getThrown());
    }
}
