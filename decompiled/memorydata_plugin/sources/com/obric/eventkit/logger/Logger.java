package com.obric.eventkit.logger;

import androidx.core.app.NotificationCompat;
import b.a.a.b.a;
import com.bytedance.bdlocation.monitor.LocationMonitorConst;
import com.ttnet.org.chromium.base.BaseSwitches;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u0003\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0006\bÇ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u001a\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\b\u0010\b\u001a\u0004\u0018\u00010\u0007H\u0016J\u001a\u0010\t\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\b\u0010\b\u001a\u0004\u0018\u00010\u0007H\u0016J$\u0010\t\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\b\u0010\b\u001a\u0004\u0018\u00010\u00072\b\u0010\n\u001a\u0004\u0018\u00010\u000bH\u0016J\b\u0010\f\u001a\u00020\u0001H\u0002J\u001a\u0010\r\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\b\u0010\b\u001a\u0004\u0018\u00010\u0007H\u0016J\b\u0010\u000e\u001a\u00020\u000fH\u0016J\u0010\u0010\u0010\u001a\u00020\u00072\u0006\u0010\u0006\u001a\u00020\u0007H\u0002J\u000e\u0010\u0011\u001a\u00020\u00052\u0006\u0010\u0012\u001a\u00020\u0001J\u001a\u0010\u0013\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\b\u0010\b\u001a\u0004\u0018\u00010\u0007H\u0016J\u001a\u0010\u0014\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\b\u0010\b\u001a\u0004\u0018\u00010\u0007H\u0016J$\u0010\u0014\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\b\u0010\b\u001a\u0004\u0018\u00010\u00072\b\u0010\n\u001a\u0004\u0018\u00010\u000bH\u0016J\u001a\u0010\u0014\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\b\u0010\n\u001a\u0004\u0018\u00010\u000bH\u0016R\u0010\u0010\u0003\u001a\u0004\u0018\u00010\u0001X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u0015"}, d2 = {"Lcom/obric/eventkit/logger/Logger;", "Lcom/obric/eventkit/logger/ILogger;", "()V", "impl", "d", "", LocationMonitorConst.TAG, "", NotificationCompat.CATEGORY_MESSAGE, "e", "tr", "", "getImpl", "i", "isDebug", "", "normalizeTag", "setLogger", "logger", BaseSwitches.V, "w", "eventstaskkit_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class Logger implements ILogger {
    public static final Logger INSTANCE = null;
    private static ILogger impl;

    static {
        INSTANCE = new Logger();
    }

    private Logger() {
    }

    private final ILogger getImpl() {
        ILogger r0 = impl;
        if (r0 == null) goto L5;
        return r0;
    L5:
        return a.f91a;
    }

    private final String normalizeTag(String r2) {
        return "ac_" + r2;
    }

    @Override // com.obric.eventkit.logger.ILogger
    public void d(String r2, String r3) {
        Intrinsics.checkNotNullParameter(r2, LocationMonitorConst.TAG);
        getImpl().d(normalizeTag(r2), r3);
    }

    @Override // com.obric.eventkit.logger.ILogger
    public void e(String r2, String r3) {
        Intrinsics.checkNotNullParameter(r2, LocationMonitorConst.TAG);
        getImpl().e(normalizeTag(r2), r3);
    }

    @Override // com.obric.eventkit.logger.ILogger
    public void e(String r2, String r3, Throwable r4) {
        Intrinsics.checkNotNullParameter(r2, LocationMonitorConst.TAG);
        getImpl().e(normalizeTag(r2), r3, r4);
    }

    @Override // com.obric.eventkit.logger.ILogger
    public void i(String r2, String r3) {
        Intrinsics.checkNotNullParameter(r2, LocationMonitorConst.TAG);
        getImpl().i(normalizeTag(r2), r3);
    }

    @Override // com.obric.eventkit.logger.ILogger
    public boolean isDebug() {
        return getImpl().isDebug();
    }

    public final void setLogger(ILogger r2) {
        ILogger r1 = (ILogger) ZeusTransformUtils.wrapperContextForParams(r2, ILogger.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r1, "logger");
        impl = r1;
    }

    @Override // com.obric.eventkit.logger.ILogger
    public void v(String r2, String r3) {
        Intrinsics.checkNotNullParameter(r2, LocationMonitorConst.TAG);
        if (isDebug() == true) goto L5;
        return;
    L5:
        getImpl().v(normalizeTag(r2), r3);
    }

    @Override // com.obric.eventkit.logger.ILogger
    public void w(String r2, String r3) {
        Intrinsics.checkNotNullParameter(r2, LocationMonitorConst.TAG);
        getImpl().w(normalizeTag(r2), r3);
    }

    @Override // com.obric.eventkit.logger.ILogger
    public void w(String r2, String r3, Throwable r4) {
        Intrinsics.checkNotNullParameter(r2, LocationMonitorConst.TAG);
        getImpl().w(normalizeTag(r2), r3, r4);
    }

    @Override // com.obric.eventkit.logger.ILogger
    public void w(String r2, Throwable r3) {
        Intrinsics.checkNotNullParameter(r2, LocationMonitorConst.TAG);
        getImpl().w(normalizeTag(r2), r3);
    }
}
