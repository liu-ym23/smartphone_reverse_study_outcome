package com.obric.mcpclient.complextasksdk;

import androidx.core.app.NotificationCompat;
import com.bytedance.apm6.util.constant.CommonConsts;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.al;
import kotlinx.coroutines.am;
import kotlinx.coroutines.bo;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000V\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\bÆ\u0002\u0018\u00002\u00020\u0001:\u0002()B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u000eH\u0002J\u0016\u0010\u0014\u001a\u00020\u00122\f\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00120\u0016H\u0002J\b\u0010\u0017\u001a\u00020\u0012H\u0002J \u0010\u0018\u001a\u00020\u00122\u0006\u0010\u0019\u001a\u00020\u00042\u0006\u0010\u001a\u001a\u00020\u000b2\b\u0010\u001b\u001a\u0004\u0018\u00010\u001cJ\b\u0010\u001d\u001a\u00020\u001eH\u0002J\u0010\u0010\u001f\u001a\u00020\u00122\u0006\u0010\u0007\u001a\u00020\u0006H\u0007J\r\u0010 \u001a\u00020\u0012H\u0000¢\u0006\u0002\b!J\u0010\u0010\"\u001a\u00020\u00122\u0006\u0010#\u001a\u00020$H\u0007J\u0015\u0010%\u001a\u00020\u00122\u0006\u0010&\u001a\u00020\u000bH\u0000¢\u0006\u0002\b'R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082D¢\u0006\u0002\n\u0000R\u0010\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u0007\u001a\u00020\u00068BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\b\u0010\tR\u000e\u0010\n\u001a\u00020\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u000e0\rX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0010X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006*"}, d2 = {"Lcom/obric/mcpclient/complextasksdk/ComplexTaskHandleSdk;", "", "()V", "TAG", "", "_config", "Lcom/obric/mcpclient/complextasksdk/ComplexTaskHandleSdk$InitConfig;", "config", "getConfig", "()Lcom/obric/mcpclient/complextasksdk/ComplexTaskHandleSdk$InitConfig;", "mPendingCallsExecuted", "", "mPendingCals", "", "Lcom/obric/mcpclient/complextasksdk/ComplexTaskHandleSdk$ApiCall;", "scope", "Lkotlinx/coroutines/CoroutineScope;", "addPendingCall", "", NotificationCompat.CATEGORY_CALL, "callOrAddPendingCall", "func", "Lkotlin/Function0;", "execPendingCalls", "executeTask", "taskData", "isShow", "callback", "Lcom/obric/mcpclient/complextasksdk/IComplexTaskCallback;", "getApi", "Lcom/obric/mcpclient/complextasksdk/IScheduleProxy;", CommonConsts.APM_INNER_EVENT_COST_INIT, "onApiInitComplete", "onApiInitComplete$complextasksdk_release", "setLogger", "logger", "Lcom/obric/mcpclient/complextasksdk/logger/ILogger;", "setPendingCallsExecuted", "isExecuted", "setPendingCallsExecuted$complextasksdk_release", "ApiCall", "InitConfig", "complextasksdk_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final a f8276a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final String f8277b = null;
    private static final al c = null;
    private static final List<InterfaceC0408a> d = null;
    private static boolean e;

    /* JADX INFO: renamed from: com.obric.mcpclient.complextasksdk.a$a, reason: collision with other inner class name */
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\bb\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H&¨\u0006\u0004"}, d2 = {"Lcom/obric/mcpclient/complextasksdk/ComplexTaskHandleSdk$ApiCall;", "", NotificationCompat.CATEGORY_CALL, "", "complextasksdk_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    private interface InterfaceC0408a {
        void call();
    }

    static {
        f8276a = new a();
        f8277b = "ComplexTaskHandleSdk";
        ExecutorService r0 = Executors.newSingleThreadExecutor($$Lambda$a$ePTIcIAxImXgqmw0QW7p0z3_zPw.INSTANCE);
        Intrinsics.checkNotNullExpressionValue(r0, "newSingleThreadExecutor …pability-schedule\")\n    }");
        c = am.a((CoroutineContext) ZeusTransformUtils.preCheckCast(bo.a(r0), CoroutineContext.class, "com.obric.memorydata.plugin"));
        d = (List) ZeusTransformUtils.preCheckCast(new ArrayList(), List.class, "com.obric.memorydata.plugin");
    }

    private a() {
    }

    public static final /* synthetic */ e a(a r0) {
        return r0.c();
    }

    private static final Thread a(Runnable r2) {
        return new Thread((Runnable) ZeusTransformUtils.wrapperContextForParams(r2, Runnable.class, "com.obric.memorydata.plugin"), "capability-schedule");
    }

    public static final /* synthetic */ String b() {
        return f8277b;
    }

    private final e c() {
        return ScheduleServiceConnection.f8273a.a();
    }

    private final void d() {
        com.obric.mcpclient.complextasksdk.b.c.f8283a.a(f8277b, "execPendingCalls");
        List<InterfaceC0408a> r5 = d;
        monitor-enter(r5);
        Iterator r0 = ((Iterable) ZeusTransformUtils.preCheckCast(r5, Iterable.class, "com.obric.memorydata.plugin")).iterator();     // Catch: Throwable -> L11
    L6:
        if (r0.hasNext() == false) goto L8;
        InterfaceC0408a r1 = (InterfaceC0408a) ZeusTransformUtils.preCheckCast(r0.next(), InterfaceC0408a.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L11
        com.obric.mcpclient.complextasksdk.b.c.f8283a.a(f8277b, "exec foreach call");     // Catch: Throwable -> L11
        r1.call();     // Catch: Throwable -> L11
        goto L6
    L8:
        d.clear();     // Catch: Throwable -> L11
        e = true;     // Catch: Throwable -> L11
        Unit r2 = Unit.INSTANCE;     // Catch: Throwable -> L11
        monitor-exit(r5);
        return;
    L11:
        th = move-exception;
        throw th;
    }

    public static /* synthetic */ Thread lambda$ePTIcIAxImXgqmw0QW7p0z3_zPw(Runnable r0) {
        return a(r0);
    }

    public final void a() {
        d();
    }

    public final void a(boolean r1) {
        List<InterfaceC0408a> r0 = d;
        monitor-enter(r0);
        e = r1;     // Catch: Throwable -> L7
        Unit r2 = Unit.INSTANCE;     // Catch: Throwable -> L7
        monitor-exit(r0);
        return;
    L7:
        th = move-exception;
        throw th;
    }
}
