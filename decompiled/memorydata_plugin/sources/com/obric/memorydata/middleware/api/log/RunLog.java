package com.obric.memorydata.middleware.api.log;

import com.bytedance.bdlocation.monitor.LocationMonitorConst;
import com.bytedance.news.common.service.manager.ext.ServiceManagerExtKt;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0003\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0019\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u0007H\u0096\u0001J#\u0010\t\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u00072\b\u0010\n\u001a\u0004\u0018\u00010\u000bH\u0096\u0001J#\u0010\f\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u00072\b\u0010\r\u001a\u0004\u0018\u00010\u000eH\u0096\u0001J!\u0010\u000f\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\u0010\u001a\u00020\u0011H\u0096\u0001J#\u0010\u0012\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u00072\b\u0010\r\u001a\u0004\u0018\u00010\u000eH\u0096\u0001¨\u0006\u0013"}, d2 = {"Lcom/obric/memorydata/middleware/api/log/RunLog;", "Lcom/obric/memorydata/middleware/api/log/IRunLog;", "<init>", "()V", "debug", "", LocationMonitorConst.TAG, "", "message", "debugLocalTest", "data", "", "error", "trace", "", "info", "printLogcat", "", "warn", "middleware_api_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class RunLog implements IRunLog {
    public static final RunLog INSTANCE = null;
    private final /* synthetic */ IRunLog $$delegate_0;

    static {
        INSTANCE = new RunLog();
    }

    private RunLog() {
        IRunLog r0 = (IRunLog) ZeusTransformUtils.preCheckCast(ServiceManagerExtKt.impl(Reflection.getOrCreateKotlinClass(IRunLog.class)), IRunLog.class, "com.obric.memorydata.plugin");
        if (r0 != null) goto L5;
        r0 = (IRunLog) ZeusTransformUtils.preCheckCast(new AnonymousClass1(), IRunLog.class, "com.obric.memorydata.plugin");
    L5:
        this.$$delegate_0 = r0;
    }

    @Override // com.obric.memorydata.middleware.api.log.IRunLog
    public void debug(String r2, String r3) {
        Intrinsics.checkNotNullParameter(r2, LocationMonitorConst.TAG);
        Intrinsics.checkNotNullParameter(r3, "message");
        this.$$delegate_0.debug(r2, r3);
    }

    @Override // com.obric.memorydata.middleware.api.log.IRunLog
    public void debugLocalTest(String r2, String r3, Object r4) {
        Intrinsics.checkNotNullParameter(r2, LocationMonitorConst.TAG);
        Intrinsics.checkNotNullParameter(r3, "message");
        this.$$delegate_0.debugLocalTest(r2, r3, r4);
    }

    @Override // com.obric.memorydata.middleware.api.log.IRunLog
    public void error(String r2, String r3, Throwable r4) {
        Intrinsics.checkNotNullParameter(r2, LocationMonitorConst.TAG);
        Intrinsics.checkNotNullParameter(r3, "message");
        this.$$delegate_0.error(r2, r3, r4);
    }

    @Override // com.obric.memorydata.middleware.api.log.IRunLog
    public void info(String r2, String r3, boolean r4) {
        Intrinsics.checkNotNullParameter(r2, LocationMonitorConst.TAG);
        Intrinsics.checkNotNullParameter(r3, "message");
        this.$$delegate_0.info(r2, r3, r4);
    }

    @Override // com.obric.memorydata.middleware.api.log.IRunLog
    public void warn(String r2, String r3, Throwable r4) {
        Intrinsics.checkNotNullParameter(r2, LocationMonitorConst.TAG);
        Intrinsics.checkNotNullParameter(r3, "message");
        this.$$delegate_0.warn(r2, r3, r4);
    }
}
