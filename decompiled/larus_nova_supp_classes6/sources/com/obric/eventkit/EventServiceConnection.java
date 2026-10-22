package com.obric.eventkit;

import android.content.ComponentName;
import android.content.Intent;
import android.content.ServiceConnection;
import android.content.pm.ResolveInfo;
import android.content.pm.ServiceInfo;
import android.os.Handler;
import android.os.IBinder;
import android.os.Looper;
import com.obric.capabilitykit.PackageUtils;
import com.obric.eventkit.apphost.AppHost;
import com.obric.eventkit.eventstaskmanager.ITaskManager;
import com.obric.eventkit.logger.Logger;
import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.ExceptionsKt;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes6.dex */
@Metadata(d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÁ\u0002\u0018\u00002\u00020\u0001:\u0001\u001fB\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\r\u0010\u0015\u001a\u00020\tH\u0000¢\u0006\u0002\b\u0016J\u0012\u0010\u0017\u001a\u00020\u00182\b\u0010\u0019\u001a\u0004\u0018\u00010\u001aH\u0016J\u001c\u0010\u001b\u001a\u00020\u00182\b\u0010\u0019\u001a\u0004\u0018\u00010\u001a2\b\u0010\u001c\u001a\u0004\u0018\u00010\u001dH\u0016J\u0012\u0010\u001e\u001a\u00020\u00182\b\u0010\u0019\u001a\u0004\u0018\u00010\u001aH\u0016R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0006X\u0082T¢\u0006\u0002\n\u0000R\u0010\u0010\b\u001a\u0004\u0018\u00010\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\n\u001a\u00020\u000bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR\u000e\u0010\u0010\u001a\u00020\u0011X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0004X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0014X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006 "}, d2 = {"Lcom/obric/eventkit/EventServiceConnection;", "Landroid/content/ServiceConnection;", "()V", "MAX_RETRY_TIMES", "", "SVR_NAME", "", "TAG", "mApi", "Lcom/obric/eventkit/IEventProxy;", "mBindState", "Lcom/obric/eventkit/EventServiceConnection$BindState;", "getMBindState", "()Lcom/obric/eventkit/EventServiceConnection$BindState;", "setMBindState", "(Lcom/obric/eventkit/EventServiceConnection$BindState;)V", "mHandler", "Landroid/os/Handler;", "retryTimes", "stateLock", "", "getApi", "getApi$eventstaskkit_release", "onNullBinding", "", "name", "Landroid/content/ComponentName;", "onServiceConnected", "service", "Landroid/os/IBinder;", "onServiceDisconnected", "BindState", "eventstaskkit_release"}, k = 1, mv = {1, 7, 1}, xi = ITaskManager.Stub.TRANSACTION_getEventTasksByType)
public final class EventServiceConnection implements ServiceConnection {
    public static final EventServiceConnection INSTANCE = null;
    private static final int MAX_RETRY_TIMES = 3;
    public static final String SVR_NAME = "com.obric.aiagent.executionengine.TASK_MANAGER_SERVICE";
    private static final String TAG = "EventServiceConnection";
    private static IEventProxy mApi;
    private static a mBindState;
    private static final Handler mHandler = null;
    private static int retryTimes;
    private static final Object stateLock = null;

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0003\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/obric/eventkit/EventServiceConnection$BindState;", "", "<init>", "(Ljava/lang/String;I)V", "eventstaskkit_release"}, k = 1, mv = {1, 7, 1})
    public static final enum a extends Enum<a> {
        public static final a a = null;
        public static final a b = null;
        public static final a c = null;
        public static final /* synthetic */ a[] d = null;

        static {
            a = new a("NotStart", 0);
            b = new a("Started", 1);
            c = new a("Connected", 2);
            d = a();
        }

        public a(String r1, int r2) {
            super(r1, r2);
        }

        public static final /* synthetic */ a[] a() {
            return new a[]{a, b, c};
        }

        public static a valueOf(String r1) {
            return (a) r27.a.a(a.class, r1);
        }

        public static a[] values() {
            return (a[]) d.clone();
        }
    }

    public static final class b implements IBinder.DeathRecipient {
        public final /* synthetic */ IBinder a;

        public b(IBinder r1) {
            this.a = r1;
        }

        @Override // android.os.IBinder.DeathRecipient
        public final void binderDied() {
            Object r0 = EventServiceConnection.access$getStateLock$p();
            monitor-enter(r0);
            EventServiceConnection.INSTANCE.setMBindState(a.a);     // Catch: Throwable -> L8
            EventServiceConnection.access$setMApi$p(null);     // Catch: Throwable -> L8
            monitor-exit(r0);
            this.a.unlinkToDeath(this, 0);
            EventsTaskSdk r1 = EventsTaskSdk.INSTANCE;
            r1.binderDied$eventstaskkit_release();
            r1.onConnectionClosed$eventstaskkit_release();
            return;
        L8:
            th = move-exception;
            throw th;
        }
    }

    static {
        INSTANCE = new EventServiceConnection();
        stateLock = new Object();
        mHandler = new Handler(Looper.getMainLooper());
        mBindState = a.a;
    }

    private EventServiceConnection() {
    }

    public static /* synthetic */ void a(EventServiceConnection r0) {
        getApi$lambda$21$lambda$17$lambda$16(r0);
    }

    public static final /* synthetic */ Object access$getStateLock$p() {
        return stateLock;
    }

    public static final /* synthetic */ void access$setMApi$p(IEventProxy r0) {
        mApi = r0;
    }

    private static final void getApi$lambda$21$lambda$17$lambda$16(EventServiceConnection r5) {
        Intrinsics.checkNotNullParameter(r5, "this$0");
        Object r0 = stateLock;
        monitor-enter(r0);
        EventServiceConnection r1 = INSTANCE;     // Catch: Throwable -> L12
        if (mBindState == a.b) goto L7;
    L9:
        retryTimes++;     // Catch: Throwable -> L12
        monitor-exit(r0);
        return;
    L7:
        if (retryTimes > 3) goto L9;
        Logger.INSTANCE.i(TAG, "events bindService fail timeout 10s");     // Catch: Throwable -> L12
        mBindState = a.a;     // Catch: Throwable -> L12
        AppHost.Companion.getApplication().unbindService(r5);     // Catch: Throwable -> L12
        r1.getApi$eventstaskkit_release();     // Catch: Throwable -> L12
    L12:
        th = move-exception;
        throw th;
    }

    public final IEventProxy getApi$eventstaskkit_release() {
        Object r1 = stateLock;
        monitor-enter(r1);
        IEventProxy r2 = mApi;     // Catch: Throwable -> L84
        if (r2 == null) goto L10;
        monitor-exit(r1);
        return r2;
    L10:
        Logger.INSTANCE.i(TAG, "events getApi() " + mApi + ' ' + mBindState);     // Catch: Throwable -> L84
    L63:
        th = move-exception;
        Object r0 = Result.constructor-impl(ResultKt.createFailure(th));     // Catch: Throwable -> L84
    L65:
        Throwable r3 = Result.exceptionOrNull-impl(r0);     // Catch: Throwable -> L84
        if (r3 != null) goto L69;
    L79:
        IEventProxy r4 = mApi;     // Catch: Throwable -> L84
        if (r4 != null) goto L82;
        r4 = EmptyEventProxy.INSTANCE;     // Catch: Throwable -> L84
    L82:
        monitor-exit(r1);
        return r4;
    L69:
        Logger.INSTANCE.e(TAG, "bindService throw exception: " + ExceptionsKt.stackTraceToString(r3));     // Catch: Throwable -> L84
        mBindState = a.a;     // Catch: Throwable -> L84
        AppHost.Companion.getApplication().unbindService(this);     // Catch: Throwable -> L72
        Object r5 = Result.constructor-impl(Unit.INSTANCE);     // Catch: Throwable -> L72
    L74:
        Throwable r6 = Result.exceptionOrNull-impl(r5);     // Catch: Throwable -> L84
        if (r6 == null) goto L79;
        Logger.INSTANCE.e(TAG, "unbindService throw exception: " + ExceptionsKt.stackTraceToString(r6));     // Catch: Throwable -> L84
        goto L79
    L72:
        th = move-exception;
        r5 = Result.constructor-impl(ResultKt.createFailure(th));     // Catch: Throwable -> L84
        goto L74
    L12:
        if (mBindState != a.a) goto L61;
        Intent r7 = new Intent(SVR_NAME);     // Catch: Throwable -> L63
        List<ResolveInfo> r8 = AppHost.Companion.getApplication().getPackageManager().queryIntentServices(r7, 0);     // Catch: Throwable -> L63
        ServiceInfo r9 = null;
        Object r10 = null;
        if (r8 == null) goto L28;
        ArrayList r11 = new ArrayList();     // Catch: Throwable -> L63
        Iterator<T> r12 = r8.iterator();     // Catch: Throwable -> L63
    L17:
        if (r12.hasNext() == false) goto L21;
        ServiceInfo r13 = ((ResolveInfo) r12.next()).serviceInfo;     // Catch: Throwable -> L63
        if (r13 == null) goto L17;
        r11.add(r13);     // Catch: Throwable -> L63
        goto L17
    L21:
        Iterator r14 = r11.iterator();     // Catch: Throwable -> L63
    L23:
        if (r14.hasNext() == false) goto L27;
        Object r15 = r14.next();     // Catch: Throwable -> L63
        if (PackageUtils.INSTANCE.checkSignature(((ServiceInfo) r15).packageName) == false) goto L23;
        r10 = r15;
    L27:
        r9 = (ServiceInfo) r10;     // Catch: Throwable -> L63
    L28:
        if (r9 == null) goto L30;
        r7.setComponent(new ComponentName(r9.packageName, r9.name));     // Catch: Throwable -> L63
        r7.setPackage(r9.packageName);     // Catch: Throwable -> L63
    L30:
        EventsTaskSdk.INSTANCE.setPendingCallsExecuted$eventstaskkit_release(false);     // Catch: Throwable -> L63
        Ref.BooleanRef r16 = new Ref.BooleanRef();     // Catch: Throwable -> L63
        int r17 = 0;
    L32:
        if (r17 >= 3) goto L54;
        if (r16.element == true) goto L52;
    L41:
        th = move-exception;
        Object r18 = Result.constructor-impl(ResultKt.createFailure(th));     // Catch: Throwable -> L63
    L43:
        Throwable r19 = Result.exceptionOrNull-impl(r18);     // Catch: Throwable -> L63
        if (r19 != null) goto L47;
    L48:
        Boolean r20 = Boolean.FALSE;     // Catch: Throwable -> L63
        if (Result.isFailure-impl(r18) == false) goto L51;
        r18 = r20;
    L51:
        r16.element = ((Boolean) r18).booleanValue();     // Catch: Throwable -> L63
        goto L52
    L47:
        Logger.INSTANCE.e(TAG, "startService attempt " + (r17 + 1) + " failed: " + ExceptionsKt.stackTraceToString(r19));     // Catch: Throwable -> L63
        goto L48
    L36:
        if (AppHost.Companion.getApplication().startService(r7) == null) goto L38;
        boolean r21 = true;
    L39:
        r18 = Result.constructor-impl(Boolean.valueOf(r21));     // Catch: Throwable -> L41
    L38:
        r21 = false;
    L52:
        r17 = r17 + 1;     // Catch: Throwable -> L63
        goto L32
    L54:
        if (r16.element == false) goto L60;
        AppHost.Companion r22 = AppHost.Companion;     // Catch: Throwable -> L63
        if (r22.getApplication().bindService(r7, this, 32) == false) goto L58;
        mBindState = a.b;     // Catch: Throwable -> L63
        mHandler.postDelayed(new yja.a(this), 10000);     // Catch: Throwable -> L63
        goto L61
    L58:
        Logger.INSTANCE.i(TAG, "bindService fail");     // Catch: Throwable -> L63
        mBindState = a.a;     // Catch: Throwable -> L63
        r22.getApplication().unbindService(this);     // Catch: Throwable -> L63
        goto L61
    L60:
        throw new IllegalStateException("startService failed after 3 attempts");     // Catch: Throwable -> L63
    L61:
        r0 = Result.constructor-impl(Unit.INSTANCE);     // Catch: Throwable -> L63
    L84:
        th = move-exception;
        throw th;
    }

    public final a getMBindState() {
        return mBindState;
    }

    @Override // android.content.ServiceConnection
    public void onNullBinding(ComponentName r3) {
        Logger.INSTANCE.i(TAG, "onNullBinding: " + ThreadMethodProxy.currentThread().getName());
        Object r4 = stateLock;
        monitor-enter(r4);
        mBindState = a.a;     // Catch: Throwable -> L12
        mApi = null;     // Catch: Throwable -> L12
        monitor-exit(r4);
        AppHost.Companion.getApplication().unbindService(this);     // Catch: Throwable -> L8
        Result.constructor-impl(Unit.INSTANCE);     // Catch: Throwable -> L8
    L10:
        EventsTaskSdk.INSTANCE.onConnectionClosed$eventstaskkit_release();
        return;
    L8:
        th = move-exception;
        Result.constructor-impl(ResultKt.createFailure(th));
    L12:
        th = move-exception;
        throw th;
    }

    @Override // android.content.ServiceConnection
    public void onServiceConnected(ComponentName r6, IBinder r7) {
        Logger r0 = Logger.INSTANCE;
        r0.i(TAG, "onServiceConnected: " + ThreadMethodProxy.currentThread().getName());
        Object r1 = stateLock;
        monitor-enter(r1);
        mBindState = a.c;     // Catch: Throwable -> L21
        if (r7 != null) goto L24;
        r7 = null;
    L11:
        EventProxy r3 = new EventProxy(ITaskManager.Stub.asInterface(r7));     // Catch: Throwable -> L8
        r0.i(TAG, "get ICapabilitySchedule Interface ");     // Catch: Throwable -> L8
        mApi = r3;     // Catch: Throwable -> L8
        retryTimes = 0;     // Catch: Throwable -> L8
        EventsTaskSdk.INSTANCE.onApiInitComplete$eventstaskkit_release();     // Catch: Throwable -> L8
        Object r8 = Result.constructor-impl(Unit.INSTANCE);     // Catch: Throwable -> L8
    L14:
        Throwable r9 = Result.exceptionOrNull-impl(r8);     // Catch: Throwable -> L21
        if (r9 != null) goto L18;
    L19:
        monitor-exit(r1);
        return;
    L18:
        Logger.INSTANCE.e(TAG, "onServiceConnected throw exception: " + ExceptionsKt.stackTraceToString(r9));     // Catch: Throwable -> L21
        goto L19
    L8:
        th = move-exception;
        r8 = Result.constructor-impl(ResultKt.createFailure(th));     // Catch: Throwable -> L21
        goto L14
    L24:
        r7.linkToDeath(new b(r7), 0);     // Catch: Throwable -> L8
    L21:
        th = move-exception;
        throw th;
    }

    @Override // android.content.ServiceConnection
    public void onServiceDisconnected(ComponentName r3) {
        Logger.INSTANCE.i(TAG, "events onServiceDisconnected");
        Object r4 = stateLock;
        monitor-enter(r4);
        mBindState = a.a;     // Catch: Throwable -> L8
        mApi = null;     // Catch: Throwable -> L8
        monitor-exit(r4);
        EventsTaskSdk r5 = EventsTaskSdk.INSTANCE;
        r5.onServiceDisconnected$eventstaskkit_release();
        r5.onConnectionClosed$eventstaskkit_release();
        return;
    L8:
        th = move-exception;
        throw th;
    }

    public final void setMBindState(a r2) {
        Intrinsics.checkNotNullParameter(r2, "<set-?>");
        mBindState = r2;
    }
}
