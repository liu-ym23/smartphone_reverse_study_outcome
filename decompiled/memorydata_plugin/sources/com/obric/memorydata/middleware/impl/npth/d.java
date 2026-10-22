package com.obric.memorydata.middleware.impl.npth;

import com.bytedance.crash.config.ConfigManager;
import com.bytedance.crash.monitor.AppMonitor;
import com.bytedance.crash.monitor.MonitorManager;
import com.obric.memorydata.middleware.api.log.IRunLog;
import com.obric.memorydata.middleware.api.log.RunLog;
import com.obric.memorydata.utils.threadpool.ThreadPoolContainer;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\bÀ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0006\u0010\n\u001a\u00020\u000bJ\b\u0010\f\u001a\u00020\rH\u0002R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082T¢\u0006\u0002\n\u0000¨\u0006\u000e"}, d2 = {"Lcom/obric/memorydata/middleware/impl/npth/NpthRemoteConfigTrigger;", "", "<init>", "()V", "TAG", "", "MAX_RETRY", "", "RETRY_INTERVAL_MS", "", "tryFetchAsync", "", "fetchOnce", "", "middleware_impl_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final d f11793a = null;

    static {
        f11793a = new d();
    }

    private d() {
    }

    private final boolean b() {
        Result.Companion r2 = Result.Companion;     // Catch: Throwable -> L20
        d r6 = (d) ZeusTransformUtils.preCheckCast(this, d.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L20
        AppMonitor r7 = MonitorManager.getAppMonitor();     // Catch: Throwable -> L20
        boolean r3 = true;
        if (r7 != null) goto L6;
    L5:
        r3 = false;
    L18:
        Object r8 = Result.m1421constructorimpl(Boolean.valueOf(r3));     // Catch: Throwable -> L20
    L22:
        Throwable r4 = Result.m1424exceptionOrNullimpl(r8);
        if (r4 == null) goto L26;
        RunLog.INSTANCE.warn("NpthRemoteConfigTrigger", "fetchOnce failed", r4);
    L26:
        if (Result.m1427isFailureimpl(r8) == false) goto L29;
        r8 = false;
    L29:
        return ((Boolean) ZeusTransformUtils.preCheckCast(r8, Boolean.class, "com.obric.memorydata.plugin")).booleanValue();
    L6:
        Field r5 = ConfigManager.class.getDeclaredField("mManagers");     // Catch: Throwable -> L20
        r5.setAccessible(true);     // Catch: Throwable -> L20
        ConfigManager r9 = null;
        Object r10 = r5.get(null);     // Catch: Throwable -> L20
        if (ZeusTransformUtils.instanceOf(r10, ConcurrentHashMap.class) == false) goto L9;
        ConcurrentHashMap r11 = (ConcurrentHashMap) ZeusTransformUtils.preCheckCast(r10, ConcurrentHashMap.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L20
    L10:
        if (r11 == null) goto L5;
        Object r12 = ((Map) ZeusTransformUtils.preCheckCast(r11, Map.class, "com.obric.memorydata.plugin")).get(r7);     // Catch: Throwable -> L20
        if (ZeusTransformUtils.instanceOf(r12, ConfigManager.class) == false) goto L15;
        r9 = (ConfigManager) ZeusTransformUtils.preCheckCast(r12, ConfigManager.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L20
    L15:
        if (r9 == null) goto L5;
        Method r13 = ConfigManager.class.getDeclaredMethod("queryConfigFromRemote", new Class[0]);     // Catch: Throwable -> L20
        r13.setAccessible(true);     // Catch: Throwable -> L20
        r13.invoke(r9, new Object[0]);     // Catch: Throwable -> L20
        goto L18
    L9:
        r11 = null;
    L20:
        th = move-exception;
        Result.Companion r14 = Result.Companion;
        r8 = Result.m1421constructorimpl(ResultKt.createFailure(th));
        goto L22
    }

    private static final void c() {
        int r0 = 0;
    L4:
        if (r0 >= 10) goto L13;
        if (f11793a.b() == true) goto L7;
        Thread.sleep(500);     // Catch: InterruptedException -> L12
        r0 = r0 + 1;
    L12:
        return;
    L7:
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "NpthRemoteConfigTrigger", "trigger queryConfigFromRemote success at retry=" + r0, false, 4, null);
        return;
    L13:
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "NpthRemoteConfigTrigger", "trigger queryConfigFromRemote give up after 10 retries", null, 4, null);
    }

    public static /* synthetic */ void lambda$otUs4zuUslOPiqi225ToGV5GJE4() {
        c();
    }

    public final void a() {
        ThreadPoolContainer.Companion.execute($$Lambda$d$otUs4zuUslOPiqi225ToGV5GJE4.INSTANCE);
    }
}
