package com.obric.memorydata.utils;

import com.obric.aiagent.product.platform.api.IPlatformService;
import com.obric.memorydata.middleware.api.log.IRunLog;
import com.obric.memorydata.middleware.api.log.RunLog;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\n\n\u0002\u0010\u0002\n\u0002\b\u0004\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\b\u0010\u000e\u001a\u0004\u0018\u00010\bJ\b\u0010\u000f\u001a\u0004\u0018\u00010\nJ\u0006\u0010\u0015\u001a\u00020\rJ\u0006\u0010\u0016\u001a\u00020\rJ\u0006\u0010\u0017\u001a\u00020\u0018J\u0016\u0010\u0019\u001a\u00020\r2\u0006\u0010\u001a\u001a\u00020\u00052\u0006\u0010\u001b\u001a\u00020\rR\u000e\u0010\u0004\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u0010\u0010\u0007\u001a\u0004\u0018\u00010\bX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\t\u001a\u0004\u0018\u00010\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0001X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u0082\u000e¢\u0006\u0002\n\u0000R\u001b\u0010\u0010\u001a\u00020\r8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0013\u0010\u0014\u001a\u0004\b\u0011\u0010\u0012¨\u0006\u001c"}, d2 = {"Lcom/obric/memorydata/utils/PlatformService;", "", "<init>", "()V", "KEY_APP_VARIANT", "", "TAG", "cachedPlatformService", "Lcom/obric/aiagent/product/platform/api/IPlatformService;", "cachedFeatureService", "Lcom/obric/aiagent/product/feature/api/IFeatureService;", "lock", "notInitLogged", "", "getPlatformService", "getFeatureService", "useAssistantApiCache", "getUseAssistantApiCache", "()Z", "useAssistantApiCache$delegate", "Lkotlin/Lazy;", "useAssistantApi", "isSdkInitialized", "clearCacheForTest", "", "isFeatureEnable", "key", "defaultValue", "utils_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class am {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final am f13169a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static volatile IPlatformService f13170b;
    private static com.obric.aiagent.product.feature.a.a c;
    private static final Object d = null;
    private static volatile boolean e;
    private static final Lazy f = null;

    static {
        f13169a = new am();
        d = new Object();
        f = LazyKt.lazy($$Lambda$am$AI06rF7WD_cn1k2zfo64eLrG9uQ.INSTANCE);
    }

    private am() {
    }

    private final boolean d() {
        return ((Boolean) ZeusTransformUtils.preCheckCast(f.getValue(), Boolean.class, "com.obric.memorydata.plugin")).booleanValue();
    }

    private static final boolean e() {
        boolean r0 = com.obric.aiagent.product.b.f5974a.a().romInfo().useAssistantApi();
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "SdkChecker", "useAssistantApi: " + r0, false, 4, null);
        return r0;
    }

    public static /* synthetic */ boolean lambda$AI06rF7WD_cn1k2zfo64eLrG9uQ() {
        return e();
    }

    public final IPlatformService a() {
        IPlatformService r7 = f13170b;
        if (r7 == null) goto L5;
        return r7;
    L5:
        Object r8 = d;
        monitor-enter(r8);
        IPlatformService r0 = f13170b;     // Catch: Throwable -> L22
        if (r0 == null) goto L11;
        monitor-exit(r8);
        return r0;
    L11:
        IPlatformService r1 = com.obric.aiagent.product.b.f5974a.a();     // Catch: Throwable -> L22
        if (r1 == null) goto L14;
        f13170b = r1;     // Catch: Throwable -> L22
        e = false;     // Catch: Throwable -> L22
        monitor-exit(r8);
        return r1;
    L14:
        if (e == true) goto L17;
        IRunLog.a.b((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "SdkChecker", "product-platform is not initialized", null, 4, null);     // Catch: Throwable -> L22
        e = true;     // Catch: Throwable -> L22
    L17:
        monitor-exit(r8);
        return null;
    L22:
        th = move-exception;
        throw th;
    }

    public final boolean a(String r10, boolean r11) {
        Intrinsics.checkNotNullParameter(r10, "key");
        com.obric.aiagent.product.feature.a.a r9 = b();
        if (r9 == null) goto L5;
        Boolean r0 = Boolean.valueOf(r9.a(r10));
    L6:
        if (r0 == null) goto L8;
        boolean r1 = r0.booleanValue();
    L9:
        IRunLog r3 = (IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin");
        StringBuilder r12 = new StringBuilder().append("key=").append(r10).append(",result=").append(r1).append(",platform:[service==null:");
        if (r9 != null) goto L12;
        boolean r13 = true;
    L13:
        IRunLog.a.a(r3, "SdkChecker", r12.append(r13).append(",enable=").append(r0).append("],default=").append(r11).toString(), false, 4, null);
        return r1;
    L12:
        r13 = false;
        goto L13
    L8:
        r1 = r11;
        goto L9
    L5:
        r0 = null;
        goto L6
    }

    public final com.obric.aiagent.product.feature.a.a b() {
        com.obric.aiagent.product.feature.a.a r8 = c;
        if (r8 == null) goto L5;
        return r8;
    L5:
        Object r9 = d;
        monitor-enter(r9);
        com.obric.aiagent.product.feature.a.a r0 = c;     // Catch: Throwable -> L14
        if (r0 == null) goto L11;
        monitor-exit(r9);
        return r0;
    L11:
        com.obric.aiagent.product.feature.a.a r1 = com.obric.aiagent.product.b.f5974a.b();     // Catch: Throwable -> L14
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "SdkChecker", "init IFeatureService", false, 4, null);     // Catch: Throwable -> L14
        c = r1;     // Catch: Throwable -> L14
        monitor-exit(r9);
        return r1;
    L14:
        th = move-exception;
        throw th;
    }

    public final boolean c() {
        return d();
    }
}
