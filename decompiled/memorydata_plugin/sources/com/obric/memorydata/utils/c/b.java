package com.obric.memorydata.utils.c;

import android.os.Bundle;
import com.obric.aiagent.product.platform.api.IPlatformService;
import com.obric.aiagent.product.platform.api.memory.IObricMemoryManager;
import com.obric.aiagent.product.platform.api.memory.ObricMemoryActionCallback;
import com.obric.aiagent.product.platform.api.memory.ObricSystemEventCallback;
import com.obric.memorydata.middleware.api.app.UserSettings;
import com.obric.memorydata.middleware.api.log.IRunLog;
import com.obric.memorydata.middleware.api.log.RunLog;
import com.obric.memorydata.utils.am;
import com.obric.memorydata.utils.y;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import kotlin.ExceptionsKt;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0007\bÆ\u0002\u0018\u00002\u00020\u0001:\u0002\u0013\u0014B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\n\u0010\f\u001a\u0004\u0018\u00010\u000bH\u0002J\u0012\u0010\r\u001a\u00020\u000e2\b\u0010\u000f\u001a\u0004\u0018\u00010\u0007H\u0007J\b\u0010\u0010\u001a\u00020\u000eH\u0007J\u0012\u0010\u0011\u001a\u00020\u000e2\b\u0010\u000f\u001a\u0004\u0018\u00010\tH\u0007J\b\u0010\u0012\u001a\u00020\u000eH\u0007R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u0010\u0010\u0006\u001a\u0004\u0018\u00010\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\b\u001a\u0004\u0018\u00010\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\n\u001a\u0004\u0018\u00010\u000bX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u0015"}, d2 = {"Lcom/obric/memorydata/utils/framework/MemoryManagerProxy;", "", "<init>", "()V", "TAG", "", "lastMemoryActionCallbackWrapper", "Lcom/obric/memorydata/utils/framework/MemoryManagerProxy$MemoryActionCallbackWrapper;", "lastSystemEventCallbackWrapper", "Lcom/obric/memorydata/utils/framework/MemoryManagerProxy$SystemEventCallbackWrapper;", "cachedMemoryManager", "Lcom/obric/aiagent/product/platform/api/memory/IObricMemoryManager;", "getMemoryManager", "registerMemoryActionCallback", "", "callbackWrapper", "unregisterMemoryActionCallback", "registerSystemEventCallback", "unregisterSystemEventCallback", "MemoryActionCallbackWrapper", "SystemEventCallbackWrapper", "utils_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final b f13198a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static a f13199b;
    private static InterfaceC0719b c;
    private static IObricMemoryManager d;

    @Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\bæ\u0080\u0001\u0018\u00002\u00020\u0001J\u0018\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H&J\u0010\u0010\b\u001a\u00020\u00032\u0006\u0010\t\u001a\u00020\u0005H\u0016¨\u0006\n"}, d2 = {"Lcom/obric/memorydata/utils/framework/MemoryManagerProxy$MemoryActionCallbackWrapper;", "", "onAction", "", "var1", "", "var2", "Landroid/os/Bundle;", "onEnterpriseAction", "actionType", "utils_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public interface a {
        void onAction(int r1, Bundle r2);

        void onEnterpriseAction(int r1);
    }

    /* JADX INFO: renamed from: com.obric.memorydata.utils.c.b$b, reason: collision with other inner class name */
    @Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\bæ\u0080\u0001\u0018\u00002\u00020\u0001J\"\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00052\b\u0010\u0007\u001a\u0004\u0018\u00010\bH&¨\u0006\t"}, d2 = {"Lcom/obric/memorydata/utils/framework/MemoryManagerProxy$SystemEventCallbackWrapper;", "", "onEvent", "", "var1", "", "var2", "var3", "Landroid/os/Bundle;", "utils_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public interface InterfaceC0719b {
        void onEvent(int r1, int r2, Bundle r3);
    }

    @Metadata(d1 = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0018\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0016¨\u0006\b"}, d2 = {"com/obric/memorydata/utils/framework/MemoryManagerProxy$registerMemoryActionCallback$platformCallback$1", "Lcom/obric/aiagent/product/platform/api/memory/ObricMemoryActionCallback;", "onAction", "", "actionType", "", "extras", "Landroid/os/Bundle;", "utils_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class c extends ObricMemoryActionCallback {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ a f13200a;

        c(a r3) {
            this.f13200a = (a) ZeusTransformUtils.wrapperContextForParams(r3, a.class, "com.obric.memorydata.plugin");
        }

        @Override // com.obric.aiagent.product.platform.api.memory.ObricMemoryActionCallback
        public void onAction(int r7, Bundle r8) {
            Intrinsics.checkNotNullParameter(r8, "extras");
            if (UserSettings.INSTANCE.isEnterpriseAccount() == false) goto L6;
            IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "MemoryManagerProxy", "ignore memory action for enterprise account, actionType=" + r7, false, 4, null);
            this.f13200a.onEnterpriseAction(r7);
            return;
        L6:
            this.f13200a.onAction(r7, r8);
        }
    }

    @Metadata(d1 = {"\u0000\u001f\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\"\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00052\b\u0010\u0007\u001a\u0004\u0018\u00010\bH\u0016¨\u0006\t"}, d2 = {"com/obric/memorydata/utils/framework/MemoryManagerProxy$registerSystemEventCallback$platformCallback$1", "Lcom/obric/aiagent/product/platform/api/memory/ObricSystemEventCallback;", "onEvent", "", "event", "", "state", "extras", "Landroid/os/Bundle;", "utils_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class d extends ObricSystemEventCallback {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ InterfaceC0719b f13201a;

        d(InterfaceC0719b r3) {
            this.f13201a = (InterfaceC0719b) ZeusTransformUtils.wrapperContextForParams(r3, InterfaceC0719b.class, "com.obric.memorydata.plugin");
        }

        @Override // com.obric.aiagent.product.platform.api.memory.ObricSystemEventCallback
        public void onEvent(int r1, int r2, Bundle r3) {
            this.f13201a.onEvent(r1, r2, r3);
        }
    }

    static {
        f13198a = new b();
    }

    private b() {
    }

    private static final IObricMemoryManager a(Exception r9) {
        Intrinsics.checkNotNullParameter(r9, "e");
        IRunLog.a.b((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "MemoryManagerProxy", "fail to get IObricMemoryManager: " + ExceptionsKt.stackTraceToString((Throwable) ZeusTransformUtils.preCheckCast(r9, Throwable.class, "com.obric.memorydata.plugin")), null, 4, null);
        return null;
    }

    @JvmStatic
    public static final void a() {
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "MemoryManagerProxy", "unregister system event callback", false, 4, null);
        IObricMemoryManager r0 = f13198a.b();
        if (r0 == null) goto L5;
        r0.unregisterSystemEventCallback();
    L6:
        c = null;
        return;
    L5:
        IRunLog.a.b((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "MemoryManagerProxy", "unregister system event callback error: service not available", null, 4, null);
        goto L6
    }

    @JvmStatic
    public static final void a(a r8) {
        a r9 = (a) ZeusTransformUtils.wrapperContextForParams(r8, a.class, "com.obric.memorydata.plugin");
        if (r9 != null) goto L6;
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "MemoryManagerProxy", "register null memory action callback, ignore", false, 4, null);
        return;
    L6:
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "MemoryManagerProxy", "register memory action callback", false, 4, null);
        c r0 = new c(r9);
        IObricMemoryManager r2 = f13198a.b();
        if (r2 == null) goto L9;
        r2.registerMemoryActionCallback((ObricMemoryActionCallback) ZeusTransformUtils.preCheckCast(r0, ObricMemoryActionCallback.class, "com.obric.memorydata.plugin"));
    L10:
        f13199b = r9;
        return;
    L9:
        IRunLog.a.b((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "MemoryManagerProxy", "register memory action callback error: service not available", null, 4, null);
        goto L10
    }

    @JvmStatic
    public static final void a(InterfaceC0719b r8) {
        InterfaceC0719b r9 = (InterfaceC0719b) ZeusTransformUtils.wrapperContextForParams(r8, InterfaceC0719b.class, "com.obric.memorydata.plugin");
        if (r9 != null) goto L6;
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "MemoryManagerProxy", "register null system event callback, ignore", false, 4, null);
        return;
    L6:
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "MemoryManagerProxy", "register system event callback", false, 4, null);
        d r0 = new d(r9);
        IObricMemoryManager r2 = f13198a.b();
        if (r2 == null) goto L9;
        r2.registerSystemEventCallback((ObricSystemEventCallback) ZeusTransformUtils.preCheckCast(r0, ObricSystemEventCallback.class, "com.obric.memorydata.plugin"));
    L10:
        c = r9;
        return;
    L9:
        IRunLog.a.b((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "MemoryManagerProxy", "register system event callback error: service not available", null, 4, null);
        goto L10
    }

    private final IObricMemoryManager b() {
        IObricMemoryManager r2 = d;
        if (r2 == null) goto L6;
        return r2;
    L6:
        return (IObricMemoryManager) ZeusTransformUtils.preCheckCast(y.a($$Lambda$b$ZICHtmyVhqoyZ67vfXy5lAAe92Q.INSTANCE, $$Lambda$b$RiXTPMOT3S1p1K0deRiRehVRnIA.INSTANCE), IObricMemoryManager.class, "com.obric.memorydata.plugin");
    }

    private static final IObricMemoryManager c() {
        IPlatformService r0 = am.f13169a.a();
        if (r0 == null) goto L7;
        IObricMemoryManager r1 = r0.memoryManager();
        if (r1 == null) goto L7;
        d = r1;
        return r1;
    L7:
        IRunLog.a.b((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "MemoryManagerProxy", "IObricMemoryManager is not initialized", null, 4, null);
        return null;
    }

    public static /* synthetic */ IObricMemoryManager lambda$RiXTPMOT3S1p1K0deRiRehVRnIA() {
        return c();
    }

    public static /* synthetic */ IObricMemoryManager lambda$ZICHtmyVhqoyZ67vfXy5lAAe92Q(Exception r0) {
        return a(r0);
    }
}
