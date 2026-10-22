package wia;

import com.obric.capabilitykit.logger.ILogger;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes5.dex */
public final class z implements ILogger {
    public static final z a = null;

    static {
        a = new z();
    }

    public z() {
    }

    @Override // com.obric.capabilitykit.logger.ILogger
    public final void d(String r1, String r2) {
        Intrinsics.checkNotNullParameter(r1, "tag");
    }

    @Override // com.obric.capabilitykit.logger.ILogger
    public final void e(String r1, String r2) {
        Intrinsics.checkNotNullParameter(r1, "tag");
    }

    @Override // com.obric.capabilitykit.logger.ILogger
    public final void e(String r1, String r2, Throwable r3) {
        Intrinsics.checkNotNullParameter(r1, "tag");
    }

    @Override // com.obric.capabilitykit.logger.ILogger
    public final void i(String r1, String r2) {
        Intrinsics.checkNotNullParameter(r1, "tag");
    }

    @Override // com.obric.capabilitykit.logger.ILogger
    public final boolean isDebug() {
        return false;
    }

    @Override // com.obric.capabilitykit.logger.ILogger
    public final void v(String r1, String r2) {
        Intrinsics.checkNotNullParameter(r1, "tag");
    }

    @Override // com.obric.capabilitykit.logger.ILogger
    public final void w(String r1, String r2) {
        Intrinsics.checkNotNullParameter(r1, "tag");
    }

    @Override // com.obric.capabilitykit.logger.ILogger
    public final void w(String r1, String r2, Throwable r3) {
        Intrinsics.checkNotNullParameter(r1, "tag");
    }

    @Override // com.obric.capabilitykit.logger.ILogger
    public final void w(String r1, Throwable r2) {
        Intrinsics.checkNotNullParameter(r1, "tag");
    }
}
