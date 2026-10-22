package com.obric.capability.schedulekit;

import android.app.Application;
import android.content.ComponentName;
import android.content.Intent;
import android.content.ServiceConnection;
import android.content.pm.ResolveInfo;
import android.content.pm.ServiceInfo;
import android.os.IBinder;
import com.bytedance.crash.tracker.ActivityLifecycle;
import com.obric.capabilitykit.PackageUtils;
import com.obric.capabilitykit.common.ICapabilitySchedule;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.ExceptionsKt;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÀ\u0002\u0018\u00002\u00020\u0001:\u0001\u001cB\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0015\u0010\u0010\u001a\u00020\u00072\u0006\u0010\u0011\u001a\u00020\u0012H\u0000¢\u0006\u0002\b\u0013J\u0012\u0010\u0014\u001a\u00020\u00152\b\u0010\u0016\u001a\u0004\u0018\u00010\u0017H\u0016J\u001c\u0010\u0018\u001a\u00020\u00152\b\u0010\u0016\u001a\u0004\u0018\u00010\u00172\b\u0010\u0019\u001a\u0004\u0018\u00010\u001aH\u0016J\u0012\u0010\u001b\u001a\u00020\u00152\b\u0010\u0016\u001a\u0004\u0018\u00010\u0017H\u0016R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u0010\u0010\u0006\u001a\u0004\u0018\u00010\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\b\u001a\u00020\tX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\rR\u000e\u0010\u000e\u001a\u00020\u000fX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u001d"}, d2 = {"Lcom/obric/capability/schedulekit/ScheduleServiceConnection;", "Landroid/content/ServiceConnection;", "()V", "SVR_NAME", "", "TAG", "mApi", "Lcom/obric/capability/schedulekit/IScheduleProxy;", "mBindState", "Lcom/obric/capability/schedulekit/ScheduleServiceConnection$BindState;", "getMBindState", "()Lcom/obric/capability/schedulekit/ScheduleServiceConnection$BindState;", "setMBindState", "(Lcom/obric/capability/schedulekit/ScheduleServiceConnection$BindState;)V", "stateLock", "", "getApi", "extBindFlags", "", "getApi$capabilityschedulekit_release", "onNullBinding", "", ActivityLifecycle.NAME, "Landroid/content/ComponentName;", "onServiceConnected", "service", "Landroid/os/IBinder;", "onServiceDisconnected", "BindState", "capabilityschedulekit_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class ScheduleServiceConnection implements ServiceConnection {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final ScheduleServiceConnection f7370a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static d f7371b;
    private static final Object c = null;
    private static BindState d;

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0005\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005¨\u0006\u0006"}, d2 = {"Lcom/obric/capability/schedulekit/ScheduleServiceConnection$BindState;", "", "(Ljava/lang/String;I)V", "NotStart", "Started", "Connected", "capabilityschedulekit_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
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

    @Metadata(d1 = {"\u0000\u0011\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H\u0016¨\u0006\u0004"}, d2 = {"com/obric/capability/schedulekit/ScheduleServiceConnection$onServiceConnected$1$1$binder$1$1", "Landroid/os/IBinder$DeathRecipient;", "binderDied", "", "capabilityschedulekit_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    public static final class a implements IBinder.DeathRecipient {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ IBinder f7372a;

        a(IBinder r3) {
            this.f7372a = (IBinder) ZeusTransformUtils.wrapperContextForParams(r3, IBinder.class, "com.obric.memorydata.plugin");
        }

        @Override // android.os.IBinder.DeathRecipient
        public void binderDied() {
            com.obric.capability.schedulekit.b.c.f7384a.c("ScheduleServiceConnection", "binderDied: " + Thread.currentThread().getName());
            this.f7372a.unlinkToDeath((IBinder.DeathRecipient) ZeusTransformUtils.preCheckCast(this, IBinder.DeathRecipient.class, "com.obric.memorydata.plugin"), 0);
            Object r4 = ScheduleServiceConnection.a();
            monitor-enter(r4);
            ScheduleServiceConnection.f7370a.a(BindState.NotStart);     // Catch: Throwable -> L8
            ScheduleServiceConnection r0 = ScheduleServiceConnection.f7370a;     // Catch: Throwable -> L8
            ScheduleServiceConnection.a(null);     // Catch: Throwable -> L8
            Unit r1 = Unit.INSTANCE;     // Catch: Throwable -> L8
            monitor-exit(r4);
            com.obric.capability.schedulekit.a.f7373a.a();
            return;
        L8:
            th = move-exception;
            throw th;
        }
    }

    static {
        f7370a = new ScheduleServiceConnection();
        c = new Object();
        d = BindState.NotStart;
    }

    private ScheduleServiceConnection() {
    }

    public static final /* synthetic */ Object a() {
        return c;
    }

    public static final /* synthetic */ void a(d r2) {
        f7371b = (d) ZeusTransformUtils.wrapperContextForParams(r2, d.class, "com.obric.memorydata.plugin");
    }

    public final d a(int r13) {
        Object r0 = c;
        monitor-enter(r0);
        d r1 = f7371b;     // Catch: Throwable -> L74
        if (r1 == null) goto L77;
        monitor-exit(r0);
        return r1;
    L77:
        Result.Companion r2 = Result.Companion;     // Catch: Throwable -> L57
        if (d != BindState.NotStart) goto L55;
        com.obric.capability.schedulekit.b.c.f7384a.c("ScheduleServiceConnection", "start to bind service");     // Catch: Throwable -> L57
        Intent r3 = new Intent("com.obric.capability.schedule.SCHEDULE_SERVICE");     // Catch: Throwable -> L57
        List<ResolveInfo> r4 = ((Application) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(com.obric.capability.schedulekit.a.c.f7378a.a(), "com.obric.memorydata.plugin"), Application.class, "com.obric.memorydata.plugin")).getPackageManager().queryIntentServices(r3, 0);     // Catch: Throwable -> L57
        Intrinsics.checkNotNullExpressionValue(r4, "packageManager.queryIntentServices(intent, 0)");     // Catch: Throwable -> L57
        ServiceInfo r5 = null;
        Object r6 = null;
        if (r4 == null) goto L25;
        Iterable r7 = (Iterable) ZeusTransformUtils.preCheckCast(r4, Iterable.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L57
        Collection r8 = (Collection) ZeusTransformUtils.preCheckCast(new ArrayList(), Collection.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L57
        Iterator r9 = r7.iterator();     // Catch: Throwable -> L57
    L14:
        if (r9.hasNext() == false) goto L18;
        ServiceInfo r10 = ((ResolveInfo) ZeusTransformUtils.preCheckCast(r9.next(), ResolveInfo.class, "com.obric.memorydata.plugin")).serviceInfo;     // Catch: Throwable -> L57
        if (r10 == null) goto L14;
        r8.add(r10);     // Catch: Throwable -> L57
        goto L14
    L18:
        Iterator r11 = ((Iterable) ZeusTransformUtils.preCheckCast((List) ZeusTransformUtils.preCheckCast(r8, List.class, "com.obric.memorydata.plugin"), Iterable.class, "com.obric.memorydata.plugin")).iterator();     // Catch: Throwable -> L57
    L20:
        if (r11.hasNext() == false) goto L24;
        Object r12 = r11.next();     // Catch: Throwable -> L57
        if (PackageUtils.INSTANCE.checkSignature(((ServiceInfo) ZeusTransformUtils.preCheckCast(r12, ServiceInfo.class, "com.obric.memorydata.plugin")).packageName) == false) goto L20;
        r6 = r12;
    L24:
        r5 = (ServiceInfo) ZeusTransformUtils.preCheckCast(r6, ServiceInfo.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L57
    L25:
        if (r5 == null) goto L27;
        r3.setComponent(new ComponentName(r5.packageName, r5.name));     // Catch: Throwable -> L57
        r3.setPackage(r5.packageName);     // Catch: Throwable -> L57
    L27:
        com.obric.capability.schedulekit.a.f7373a.a(false);     // Catch: Throwable -> L57
        Ref.BooleanRef r14 = new Ref.BooleanRef();     // Catch: Throwable -> L57
        int r15 = 0;
    L28:
        if (r15 >= 3) goto L48;
        if (r14.element == true) goto L46;
        Result.Companion r16 = Result.Companion;     // Catch: Throwable -> L37
        if (ZeusTransformUtils.startService((Application) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(com.obric.capability.schedulekit.a.c.f7378a.a(), "com.obric.memorydata.plugin"), Application.class, "com.obric.memorydata.plugin"), r3, "com.obric.memorydata.plugin") == null) goto L34;
        boolean r17 = true;
    L35:
        Object r18 = Result.m1421constructorimpl(Boolean.valueOf(r17));     // Catch: Throwable -> L37
    L39:
        Throwable r19 = Result.m1424exceptionOrNullimpl(r18);     // Catch: Throwable -> L57
        if (r19 == null) goto L43;
        com.obric.capability.schedulekit.b.c.f7384a.b("ScheduleServiceConnection", "startService attempt " + (r15 + 1) + " failed: " + ExceptionsKt.stackTraceToString(r19));     // Catch: Throwable -> L57
    L43:
        if (Result.m1427isFailureimpl(r18) == false) goto L45;
        r18 = false;
    L45:
        r14.element = ((Boolean) ZeusTransformUtils.preCheckCast(r18, Boolean.class, "com.obric.memorydata.plugin")).booleanValue();     // Catch: Throwable -> L57
        goto L46
    L34:
        r17 = false;
    L37:
        th = move-exception;
        Result.Companion r20 = Result.Companion;     // Catch: Throwable -> L57
        r18 = Result.m1421constructorimpl(ResultKt.createFailure(th));     // Catch: Throwable -> L57
    L46:
        r15 = r15 + 1;     // Catch: Throwable -> L57
        goto L28
    L48:
        if (r14.element == false) goto L54;
        if (ZeusTransformUtils.bindService((Application) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(com.obric.capability.schedulekit.a.c.f7378a.a(), "com.obric.memorydata.plugin"), Application.class, "com.obric.memorydata.plugin"), r3, (ServiceConnection) ZeusTransformUtils.preCheckCast(this, ServiceConnection.class, "com.obric.memorydata.plugin"), r13, "com.obric.memorydata.plugin") == false) goto L52;
        d = BindState.Started;     // Catch: Throwable -> L57
        goto L55
    L52:
        com.obric.capability.schedulekit.b.c.f7384a.c("ScheduleServiceConnection", "bindService fail");     // Catch: Throwable -> L57
        d = BindState.NotStart;     // Catch: Throwable -> L57
        ZeusTransformUtils.unbindService((Application) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(com.obric.capability.schedulekit.a.c.f7378a.a(), "com.obric.memorydata.plugin"), Application.class, "com.obric.memorydata.plugin"), (ServiceConnection) ZeusTransformUtils.preCheckCast(this, ServiceConnection.class, "com.obric.memorydata.plugin"), "com.obric.memorydata.plugin");     // Catch: Throwable -> L57
        goto L55
    L54:
        throw new IllegalStateException("startService failed after 3 attempts");     // Catch: Throwable -> L57
    L55:
        Object r110 = Result.m1421constructorimpl(Unit.INSTANCE);     // Catch: Throwable -> L57
    L59:
        Throwable r111 = Result.m1424exceptionOrNullimpl(r110);     // Catch: Throwable -> L74
        if (r111 == null) goto L69;
        com.obric.capability.schedulekit.b.c.f7384a.b("ScheduleServiceConnection", "bindService throw exception: " + ExceptionsKt.stackTraceToString(r111));     // Catch: Throwable -> L74
        d = BindState.NotStart;     // Catch: Throwable -> L74
        Result.Companion r112 = Result.Companion;     // Catch: Throwable -> L64
        ZeusTransformUtils.unbindService((Application) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(com.obric.capability.schedulekit.a.c.f7378a.a(), "com.obric.memorydata.plugin"), Application.class, "com.obric.memorydata.plugin"), (ServiceConnection) ZeusTransformUtils.preCheckCast(this, ServiceConnection.class, "com.obric.memorydata.plugin"), "com.obric.memorydata.plugin");     // Catch: Throwable -> L64
        Object r113 = Result.m1421constructorimpl(Unit.INSTANCE);     // Catch: Throwable -> L64
    L66:
        Throwable r114 = Result.m1424exceptionOrNullimpl(r113);     // Catch: Throwable -> L74
        if (r114 == null) goto L69;
        com.obric.capability.schedulekit.b.c.f7384a.b("ScheduleServiceConnection", "unbindService throw exception: " + ExceptionsKt.stackTraceToString(r114));     // Catch: Throwable -> L74
        goto L69
    L64:
        th = move-exception;
        Result.Companion r115 = Result.Companion;     // Catch: Throwable -> L74
        r113 = Result.m1421constructorimpl(ResultKt.createFailure(th));     // Catch: Throwable -> L74
    L69:
        d r116 = f7371b;     // Catch: Throwable -> L74
        if (r116 != null) goto L72;
        r116 = (d) ZeusTransformUtils.preCheckCast(b.f7381a, d.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L74
    L72:
        monitor-exit(r0);
        return r116;
    L57:
        th = move-exception;
        Result.Companion r21 = Result.Companion;     // Catch: Throwable -> L74
        r110 = Result.m1421constructorimpl(ResultKt.createFailure(th));     // Catch: Throwable -> L74
    L74:
        th = move-exception;
        throw th;
    }

    public final void a(BindState r1) {
        Intrinsics.checkNotNullParameter(r1, "<set-?>");
        d = r1;
    }

    @Override // android.content.ServiceConnection
    public void onNullBinding(ComponentName r4) {
        com.obric.capability.schedulekit.b.c.f7384a.c("ScheduleServiceConnection", "onNullBinding: " + Thread.currentThread().getName());
        Object r5 = c;
        monitor-enter(r5);
        d = BindState.NotStart;     // Catch: Throwable -> L12
        f7371b = null;     // Catch: Throwable -> L12
        Unit r0 = Unit.INSTANCE;     // Catch: Throwable -> L12
        monitor-exit(r5);
        Result.Companion r6 = Result.Companion;     // Catch: Throwable -> L8
        ZeusTransformUtils.unbindService((Application) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(com.obric.capability.schedulekit.a.c.f7378a.a(), "com.obric.memorydata.plugin"), Application.class, "com.obric.memorydata.plugin"), (ServiceConnection) ZeusTransformUtils.preCheckCast((ScheduleServiceConnection) ZeusTransformUtils.preCheckCast(this, ScheduleServiceConnection.class, "com.obric.memorydata.plugin"), ServiceConnection.class, "com.obric.memorydata.plugin"), "com.obric.memorydata.plugin");     // Catch: Throwable -> L8
        Result.m1421constructorimpl(Unit.INSTANCE);     // Catch: Throwable -> L8
    L10:
        com.obric.capability.schedulekit.a.f7373a.a();
        return;
    L8:
        th = move-exception;
        Result.Companion r7 = Result.Companion;
        Result.m1421constructorimpl(ResultKt.createFailure(th));
    L12:
        th = move-exception;
        throw th;
    }

    @Override // android.content.ServiceConnection
    public void onServiceConnected(ComponentName r4, IBinder r5) {
        IBinder r3 = (IBinder) ZeusTransformUtils.wrapperContextForParams(r5, IBinder.class, "com.obric.memorydata.plugin");
        com.obric.capability.schedulekit.b.c.f7384a.c("ScheduleServiceConnection", "onServiceConnected: " + Thread.currentThread().getName());
        Object r6 = c;
        monitor-enter(r6);
        d = BindState.Connected;     // Catch: Throwable -> L18
        Result.Companion r7 = Result.Companion;     // Catch: Throwable -> L11
        if (r3 == null) goto L8;
        r3.linkToDeath((IBinder.DeathRecipient) ZeusTransformUtils.preCheckCast(new a(r3), IBinder.DeathRecipient.class, "com.obric.memorydata.plugin"), 0);     // Catch: Throwable -> L11
    L9:
        ICapabilitySchedule r8 = ICapabilitySchedule.Stub.asInterface(r3);     // Catch: Throwable -> L11
        Intrinsics.checkNotNullExpressionValue(r8, "asInterface(binder)");     // Catch: Throwable -> L11
        g r9 = new g(r8);     // Catch: Throwable -> L11
        com.obric.capability.schedulekit.b.c.f7384a.c("ScheduleServiceConnection", "get ICapabilitySchedule Interface ");     // Catch: Throwable -> L11
        f7371b = (d) ZeusTransformUtils.preCheckCast(r9, d.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L11
        com.obric.capability.schedulekit.a.f7373a.b();     // Catch: Throwable -> L11
        Object r10 = Result.m1421constructorimpl(Unit.INSTANCE);     // Catch: Throwable -> L11
    L13:
        Throwable r11 = Result.m1424exceptionOrNullimpl(r10);     // Catch: Throwable -> L18
        if (r11 == null) goto L16;
        com.obric.capability.schedulekit.b.c.f7384a.b("ScheduleServiceConnection", "onServiceConnected throw exception: " + ExceptionsKt.stackTraceToString(r11));     // Catch: Throwable -> L18
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
        com.obric.capability.schedulekit.b.c.f7384a.c("ScheduleServiceConnection", "onServiceDisconnected");
        Object r1 = c;
        monitor-enter(r1);
        d = BindState.NotStart;     // Catch: Throwable -> L8
        f7371b = null;     // Catch: Throwable -> L8
        Unit r3 = Unit.INSTANCE;     // Catch: Throwable -> L8
        monitor-exit(r1);
        com.obric.capability.schedulekit.a.f7373a.a();
        return;
    L8:
        th = move-exception;
        throw th;
    }
}
