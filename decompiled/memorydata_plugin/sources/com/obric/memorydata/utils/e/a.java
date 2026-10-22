package com.obric.memorydata.utils.e;

import android.content.Context;
import android.hardware.display.DisplayManager;
import android.view.Display;
import com.bytedance.apm6.util.constant.CommonConsts;
import com.obric.aiagent.product.platform.api.IPlatformService;
import com.obric.aiagent.product.platform.api.app.IObricActivityManager;
import com.obric.aiagent.product.platform.api.app.ObricDisplayInfoCallback;
import com.obric.memorydata.middleware.api.appcontext.AppContext;
import com.obric.memorydata.middleware.api.log.IRunLog;
import com.obric.memorydata.middleware.api.log.RunLog;
import com.obric.memorydata.utils.am;
import com.obric.memorydata.utils.y;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import kotlin.ExceptionsKt;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.flow.ae;
import kotlinx.coroutines.flow.ar;
import kotlinx.coroutines.flow.at;
import kotlinx.coroutines.flow.k;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000G\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0002*\u0001\u0010\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\n\u0010\u000e\u001a\u0004\u0018\u00010\rH\u0002J\u0010\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\bH\u0002J\u0006\u0010\u0015\u001a\u00020\u0013J\u0016\u0010\u0016\u001a\u0010\u0012\u0004\u0012\u00020\u0018\u0012\u0004\u0012\u00020\u0018\u0018\u00010\u0017H\u0007J\b\u0010\u0019\u001a\u00020\u0013H\u0002R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u0014\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u0017\u0010\t\u001a\b\u0012\u0004\u0012\u00020\b0\n¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\u000bR\u0010\u0010\f\u001a\u0004\u0018\u00010\rX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000f\u001a\u00020\u0010X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u0011¨\u0006\u001a"}, d2 = {"Lcom/obric/memorydata/utils/screen/DisplayInfoManager;", "", "<init>", "()V", "TAG", "", "_isWindowSecure", "Lkotlinx/coroutines/flow/MutableStateFlow;", "", "isWindowSecure", "Lkotlinx/coroutines/flow/StateFlow;", "()Lkotlinx/coroutines/flow/StateFlow;", "cachedActivityManager", "Lcom/obric/aiagent/product/platform/api/app/IObricActivityManager;", "getActivityManager", "displayInfoCallback", "com/obric/memorydata/utils/screen/DisplayInfoManager$displayInfoCallback$1", "Lcom/obric/memorydata/utils/screen/DisplayInfoManager$displayInfoCallback$1;", "updateSecureState", "", "secure", CommonConsts.APM_INNER_EVENT_COST_INIT, "queryPhysicalPortraitScreenSize", "Lkotlin/Pair;", "", "registerSecureStateListener", "utils_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final a f13206a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final ae<Boolean> f13207b = null;
    private static final ar<Boolean> c = null;
    private static IObricActivityManager d;
    private static final C0720a e = null;

    /* JADX INFO: renamed from: com.obric.memorydata.utils.e.a$a, reason: collision with other inner class name */
    @Metadata(d1 = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0018\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0016¨\u0006\b"}, d2 = {"com/obric/memorydata/utils/screen/DisplayInfoManager$displayInfoCallback$1", "Lcom/obric/aiagent/product/platform/api/app/ObricDisplayInfoCallback;", "onDisplaySecureChanged", "", "displayId", "", "secure", "", "utils_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class C0720a extends ObricDisplayInfoCallback {
        C0720a() {
        }

        @Override // com.obric.aiagent.product.platform.api.app.ObricDisplayInfoCallback
        public void onDisplaySecureChanged(int r7, boolean r8) {
            IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "DisplayInfoManager", "onDisplaySecureChanged: " + r7 + ' ' + r8, false, 4, null);
            a.a(a.f13206a, r8);
        }
    }

    static {
        f13206a = new a();
        ae<Boolean> r0 = at.a(false);
        f13207b = r0;
        c = k.a(r0);
        e = new C0720a();
    }

    private a() {
    }

    private static final IObricActivityManager a(Exception r9) {
        Intrinsics.checkNotNullParameter(r9, "e");
        IRunLog.a.b((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "DisplayInfoManager", "fail to get IObricActivityManager: " + ExceptionsKt.stackTraceToString((Throwable) ZeusTransformUtils.preCheckCast(r9, Throwable.class, "com.obric.memorydata.plugin")), null, 4, null);
        return null;
    }

    public static final /* synthetic */ void a(a r0, boolean r1) {
        r0.a(r1);
    }

    private final void a(boolean r7) {
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "DisplayInfoManager", "updateSecureState: " + r7, false, 4, null);
        f13207b.b(Boolean.valueOf(r7));
    }

    private final IObricActivityManager d() {
        IObricActivityManager r2 = d;
        if (r2 == null) goto L6;
        return r2;
    L6:
        return (IObricActivityManager) ZeusTransformUtils.preCheckCast(y.a($$Lambda$a$zg1wL2dhGEG1MApb6aT51FvbA.INSTANCE, $$Lambda$a$_zxPx1SZMR7LUNBApMgt8iWnzN4.INSTANCE), IObricActivityManager.class, "com.obric.memorydata.plugin");
    }

    private final void e() {
        IObricActivityManager r8 = d();     // Catch: Exception -> L8
        if (r8 == null) goto L6;
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "DisplayInfoManager", "Registered secure state listener isRegistered:" + r8.registerObricDisplayInfoCallback((ObricDisplayInfoCallback) ZeusTransformUtils.preCheckCast(e, ObricDisplayInfoCallback.class, "com.obric.memorydata.plugin")), false, 4, null);     // Catch: Exception -> L8
    L11:
        return;
    L6:
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "DisplayInfoManager", "IObricActivityManager is null, cannot register secure state listener", null, 4, null);     // Catch: Exception -> L8
    L8:
        e = move-exception;
        RunLog.INSTANCE.error("DisplayInfoManager", "Failed to register secure state listener: ", (Throwable) ZeusTransformUtils.preCheckCast(e, Throwable.class, "com.obric.memorydata.plugin"));
    }

    private static final IObricActivityManager f() {
        IPlatformService r0 = am.f13169a.a();
        if (r0 == null) goto L7;
        IObricActivityManager r1 = r0.activityManager();
        if (r1 == null) goto L7;
        d = r1;
        return r1;
    L7:
        IRunLog.a.b((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "DisplayInfoManager", "IObricActivityManager is not initialized", null, 4, null);
        return null;
    }

    public static /* synthetic */ IObricActivityManager lambda$_zxPx1SZMR7LUNBApMgt8iWnzN4() {
        return f();
    }

    /* JADX INFO: renamed from: lambda$z-g1wL2dhGEG1MApb6aT51-FvbA, reason: not valid java name */
    public static /* synthetic */ IObricActivityManager m1243lambda$zg1wL2dhGEG1MApb6aT51FvbA(Exception r0) {
        return a(r0);
    }

    public final ar<Boolean> a() {
        return c;
    }

    public final void b() {
        e();
    }

    public final Pair<Integer, Integer> c() {
        Object r1 = ((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(AppContext.INSTANCE.getContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin")).getSystemService("display");     // Catch: RuntimeException -> L21
        if (ZeusTransformUtils.instanceOf(r1, DisplayManager.class) == false) goto L6;
        DisplayManager r3 = (DisplayManager) ZeusTransformUtils.preCheckCast(r1, DisplayManager.class, "com.obric.memorydata.plugin");     // Catch: RuntimeException -> L21
    L7:
        if (r3 != null) goto L9;
        return null;
    L9:
        Display r4 = r3.getDisplay(0);     // Catch: RuntimeException -> L21
        if (r4 == null) goto L20;
        Display.Mode r5 = r4.getMode();     // Catch: RuntimeException -> L21
        if (r5 == null) goto L20;
        int r2 = r5.getPhysicalWidth();
        int r6 = r5.getPhysicalHeight();
        if (r2 <= 0) goto L20;
        if (r6 <= 0) goto L20;
        return TuplesKt.to(Integer.valueOf(Math.min(r2, r6)), Integer.valueOf(Math.max(r2, r6)));
    L6:
        r3 = null;
    L20:
        return null;
    }
}
