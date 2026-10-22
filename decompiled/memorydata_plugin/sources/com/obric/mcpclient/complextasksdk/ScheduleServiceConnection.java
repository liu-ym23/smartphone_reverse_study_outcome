package com.obric.mcpclient.complextasksdk;

import android.app.Application;
import android.content.ComponentName;
import android.content.Intent;
import android.content.ServiceConnection;
import android.content.pm.ResolveInfo;
import android.content.pm.ServiceInfo;
import android.os.IBinder;
import com.bytedance.crash.tracker.ActivityLifecycle;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.Collection;
import java.util.List;
import kotlin.ExceptionsKt;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\bÀ\u0002\u0018\u00002\u00020\u0001:\u0001\u0019B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\r\u0010\u0010\u001a\u00020\u0007H\u0000¢\u0006\u0002\b\u0011J\u001c\u0010\u0012\u001a\u00020\u00132\b\u0010\u0014\u001a\u0004\u0018\u00010\u00152\b\u0010\u0016\u001a\u0004\u0018\u00010\u0017H\u0016J\u0012\u0010\u0018\u001a\u00020\u00132\b\u0010\u0014\u001a\u0004\u0018\u00010\u0015H\u0016R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u0010\u0010\u0006\u001a\u0004\u0018\u00010\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\b\u001a\u00020\tX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\rR\u000e\u0010\u000e\u001a\u00020\u000fX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u001a"}, d2 = {"Lcom/obric/mcpclient/complextasksdk/ScheduleServiceConnection;", "Landroid/content/ServiceConnection;", "()V", "SVR_NAME", "", "TAG", "mApi", "Lcom/obric/mcpclient/complextasksdk/IScheduleProxy;", "mBindState", "Lcom/obric/mcpclient/complextasksdk/ScheduleServiceConnection$BindState;", "getMBindState", "()Lcom/obric/mcpclient/complextasksdk/ScheduleServiceConnection$BindState;", "setMBindState", "(Lcom/obric/mcpclient/complextasksdk/ScheduleServiceConnection$BindState;)V", "stateLock", "", "getApi", "getApi$complextasksdk_release", "onServiceConnected", "", ActivityLifecycle.NAME, "Landroid/content/ComponentName;", "service", "Landroid/os/IBinder;", "onServiceDisconnected", "BindState", "complextasksdk_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class ScheduleServiceConnection implements ServiceConnection {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final ScheduleServiceConnection f8273a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static e f8274b;
    private static final Object c = null;
    private static BindState d;

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0005\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005¨\u0006\u0006"}, d2 = {"Lcom/obric/mcpclient/complextasksdk/ScheduleServiceConnection$BindState;", "", "(Ljava/lang/String;I)V", "NotStart", "Started", "Connected", "complextasksdk_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    public static final enum BindState extends Enum<BindState> {
        private static final /* synthetic */ BindState[] $VALUES = null;
        public static final BindState Connected = null;
        public static final BindState NotStart = null;
        public static final BindState Started = null;

        private static final /* synthetic */ BindState[] $values() {
            return new BindState[]{NotStart, Started, Connected};
        }

        static {
            NotStart = new BindState("NotStart", 0);
            Started = new BindState("Started", 1);
            Connected = new BindState("Connected", 2);
            $VALUES = $values();
        }

        private BindState(String r1, int r2) {
            super(r1, r2);
        }

        public static BindState valueOf(String r2) {
            return (BindState) ZeusTransformUtils.preCheckCast(Enum.valueOf(BindState.class, r2), BindState.class, "com.obric.memorydata.plugin");
        }

        public static BindState[] values() {
            return (BindState[]) ZeusTransformUtils.preCheckCast($VALUES.clone(), BindState[].class, "com.obric.memorydata.plugin");
        }
    }

    @Metadata(d1 = {"\u0000\u0011\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H\u0016¨\u0006\u0004"}, d2 = {"com/obric/mcpclient/complextasksdk/ScheduleServiceConnection$onServiceConnected$1$1$binder$1$1", "Landroid/os/IBinder$DeathRecipient;", "binderDied", "", "complextasksdk_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    public static final class a implements IBinder.DeathRecipient {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ IBinder f8275a;

        a(IBinder r3) {
            this.f8275a = (IBinder) ZeusTransformUtils.wrapperContextForParams(r3, IBinder.class, "com.obric.memorydata.plugin");
        }

        @Override // android.os.IBinder.DeathRecipient
        public void binderDied() {
            this.f8275a.unlinkToDeath((IBinder.DeathRecipient) ZeusTransformUtils.preCheckCast(this, IBinder.DeathRecipient.class, "com.obric.memorydata.plugin"), 0);
            ScheduleServiceConnection r3 = ScheduleServiceConnection.f8273a;
            ScheduleServiceConnection.a(null);
        }
    }

    static {
        f8273a = new ScheduleServiceConnection();
        c = new Object();
        d = BindState.NotStart;
    }

    private ScheduleServiceConnection() {
    }

    public static final /* synthetic */ void a(e r2) {
        f8274b = (e) ZeusTransformUtils.wrapperContextForParams(r2, e.class, "com.obric.memorydata.plugin");
    }

    public final e a() {
        Object r0 = c;
        monitor-enter(r0);
        e r1 = f8274b;     // Catch: Throwable -> L42
        if (r1 == null) goto L49;
        monitor-exit(r0);
        return r1;
    L49:
        Result.Companion r2 = Result.Companion;     // Catch: Throwable -> L25
        if (d != BindState.NotStart) goto L23;
        Intent r3 = new Intent("com.obric.complexTask.ComplexTaskHandleService");     // Catch: Throwable -> L25
        List<ResolveInfo> r4 = ((Application) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(com.obric.mcpclient.complextasksdk.a.a.f8278a.a(), "com.obric.memorydata.plugin"), Application.class, "com.obric.memorydata.plugin")).getPackageManager().queryIntentServices(r3, 0);     // Catch: Throwable -> L25
        Intrinsics.checkNotNullExpressionValue(r4, "packageManager.queryIntentServices(intent, 0)");     // Catch: Throwable -> L25
        Collection r5 = (Collection) ZeusTransformUtils.preCheckCast(r4, Collection.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L25
        if (r5 != null) goto L13;
    L16:
        boolean r6 = true;
    L17:
        if (r6 == true) goto L19;
        ServiceInfo r7 = ((ResolveInfo) ZeusTransformUtils.preCheckCast(r4.get(0), ResolveInfo.class, "com.obric.memorydata.plugin")).serviceInfo;     // Catch: Throwable -> L25
        r3.setComponent(new ComponentName(r7.packageName, r7.name));     // Catch: Throwable -> L25
    L19:
        com.obric.mcpclient.complextasksdk.a.f8276a.a(false);     // Catch: Throwable -> L25
        if (ZeusTransformUtils.bindService((Application) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(com.obric.mcpclient.complextasksdk.a.a.f8278a.a(), "com.obric.memorydata.plugin"), Application.class, "com.obric.memorydata.plugin"), r3, (ServiceConnection) ZeusTransformUtils.preCheckCast(this, ServiceConnection.class, "com.obric.memorydata.plugin"), 1, "com.obric.memorydata.plugin") == false) goto L22;
        d = BindState.Started;     // Catch: Throwable -> L25
        goto L23
    L22:
        com.obric.mcpclient.complextasksdk.b.c.f8283a.c("ScheduleServiceConnection", "bindService fail");     // Catch: Throwable -> L25
        ZeusTransformUtils.unbindService((Application) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(com.obric.mcpclient.complextasksdk.a.a.f8278a.a(), "com.obric.memorydata.plugin"), Application.class, "com.obric.memorydata.plugin"), (ServiceConnection) ZeusTransformUtils.preCheckCast(this, ServiceConnection.class, "com.obric.memorydata.plugin"), "com.obric.memorydata.plugin");     // Catch: Throwable -> L25
        goto L23
    L13:
        if (r5.isEmpty() == true) goto L16;
        r6 = false;
    L23:
        Object r8 = Result.m1421constructorimpl(Unit.INSTANCE);     // Catch: Throwable -> L25
    L27:
        Throwable r9 = Result.m1424exceptionOrNullimpl(r8);     // Catch: Throwable -> L42
        if (r9 == null) goto L37;
        com.obric.mcpclient.complextasksdk.b.c.f8283a.b("ScheduleServiceConnection", "bindService throw exception: " + ExceptionsKt.stackTraceToString(r9));     // Catch: Throwable -> L42
        Result.Companion r10 = Result.Companion;     // Catch: Throwable -> L32
        ZeusTransformUtils.unbindService((Application) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(com.obric.mcpclient.complextasksdk.a.a.f8278a.a(), "com.obric.memorydata.plugin"), Application.class, "com.obric.memorydata.plugin"), (ServiceConnection) ZeusTransformUtils.preCheckCast(this, ServiceConnection.class, "com.obric.memorydata.plugin"), "com.obric.memorydata.plugin");     // Catch: Throwable -> L32
        Object r11 = Result.m1421constructorimpl(Unit.INSTANCE);     // Catch: Throwable -> L32
    L34:
        Throwable r12 = Result.m1424exceptionOrNullimpl(r11);     // Catch: Throwable -> L42
        if (r12 == null) goto L37;
        com.obric.mcpclient.complextasksdk.b.c.f8283a.b("ScheduleServiceConnection", "unbindService throw exception: " + ExceptionsKt.stackTraceToString(r12));     // Catch: Throwable -> L42
        goto L37
    L32:
        th = move-exception;
        Result.Companion r13 = Result.Companion;     // Catch: Throwable -> L42
        r11 = Result.m1421constructorimpl(ResultKt.createFailure(th));     // Catch: Throwable -> L42
    L37:
        e r14 = f8274b;     // Catch: Throwable -> L42
        if (r14 != null) goto L40;
        r14 = (e) ZeusTransformUtils.preCheckCast(b.f8280a, e.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L42
    L40:
        monitor-exit(r0);
        return r14;
    L25:
        th = move-exception;
        Result.Companion r15 = Result.Companion;     // Catch: Throwable -> L42
        r8 = Result.m1421constructorimpl(ResultKt.createFailure(th));     // Catch: Throwable -> L42
    L42:
        th = move-exception;
        throw th;
    }

    @Override // android.content.ServiceConnection
    public void onServiceConnected(ComponentName r4, IBinder r5) {
        IBinder r3 = (IBinder) ZeusTransformUtils.wrapperContextForParams(r5, IBinder.class, "com.obric.memorydata.plugin");
        com.obric.mcpclient.complextasksdk.b.c.f8283a.c("ScheduleServiceConnection", "onServiceConnected: " + Thread.currentThread().getName());
        Object r6 = c;
        monitor-enter(r6);
        d = BindState.Connected;     // Catch: Throwable -> L18
        Result.Companion r7 = Result.Companion;     // Catch: Throwable -> L11
        if (r3 == null) goto L8;
        r3.linkToDeath((IBinder.DeathRecipient) ZeusTransformUtils.preCheckCast(new a(r3), IBinder.DeathRecipient.class, "com.obric.memorydata.plugin"), 0);     // Catch: Throwable -> L11
    L9:
        d r8 = d.a.a(r3);     // Catch: Throwable -> L11
        Intrinsics.checkNotNullExpressionValue(r8, "asInterface(binder)");     // Catch: Throwable -> L11
        f r9 = new f(r8);     // Catch: Throwable -> L11
        com.obric.mcpclient.complextasksdk.b.c.f8283a.c("ScheduleServiceConnection", "get ICapabilitySchedule Interface ");     // Catch: Throwable -> L11
        f8274b = (e) ZeusTransformUtils.preCheckCast(r9, e.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L11
        com.obric.mcpclient.complextasksdk.a.f8276a.a();     // Catch: Throwable -> L11
        Object r10 = Result.m1421constructorimpl(Unit.INSTANCE);     // Catch: Throwable -> L11
    L13:
        Throwable r11 = Result.m1424exceptionOrNullimpl(r10);     // Catch: Throwable -> L18
        if (r11 == null) goto L16;
        com.obric.mcpclient.complextasksdk.b.c.f8283a.b("ScheduleServiceConnection", "onServiceConnected throw exception: " + ExceptionsKt.stackTraceToString(r11));     // Catch: Throwable -> L18
    L16:
        monitor-exit(r6);
        return;
    L8:
        r3 = null;
    L11:
        th = move-exception;
        Result.Companion r12 = Result.Companion;     // Catch: Throwable -> L18
        r10 = Result.m1421constructorimpl(ResultKt.createFailure(th));     // Catch: Throwable -> L18
    L18:
        th = move-exception;
        throw th;
    }

    @Override // android.content.ServiceConnection
    public void onServiceDisconnected(ComponentName r2) {
        com.obric.mcpclient.complextasksdk.b.c.f8283a.c("ScheduleServiceConnection", "onServiceDisconnected");
        d = BindState.NotStart;
    }
}
