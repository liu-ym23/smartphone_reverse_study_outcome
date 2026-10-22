package com.obric.capability.schedulekit;

import android.content.ComponentName;
import android.content.ServiceConnection;
import android.os.IBinder;
import com.obric.capabilitykit.common.ICapabilitySchedule;
import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;
import kotlin.ExceptionsKt;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes6.dex */
public final class ScheduleServiceConnection implements ServiceConnection {
    public static final ScheduleServiceConnection a = null;
    public static final Object b = null;

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0004\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001j\u0002\b\u0002j\u0002\b\u0003j\u0002\b\u0004¨\u0006\u0005"}, d2 = {"Lcom/obric/capability/schedulekit/ScheduleServiceConnection$BindState;", "", "NotStart", "Started", "Connected", "capabilityschedulekit_release"}, k = 1, mv = {1, 7, 1})
    public static final enum BindState extends Enum<BindState> {
        public static final BindState Connected = null;
        public static final BindState NotStart = null;
        public static final BindState Started = null;
        public static final /* synthetic */ BindState[] a = null;

        public static BindState valueOf(String r1) {
            return (BindState) r27.a.a(BindState.class, r1);
        }

        public static BindState[] values() {
            return (BindState[]) a.clone();
        }

        static {
            BindState r0 = new BindState("NotStart", 0);
            NotStart = r0;
            BindState r1 = new BindState("Started", 1);
            Started = r1;
            BindState r3 = new BindState("Connected", 2);
            Connected = r3;
            a = new BindState[]{r0, r1, r3};
        }

        public BindState(String r1, int r2) {
            super(r1, r2);
        }
    }

    public static final class a implements IBinder.DeathRecipient {
        public final /* synthetic */ IBinder a;

        @Override // android.os.IBinder.DeathRecipient
        public final void binderDied() {
            via.b r0 = via.b.a;
            ThreadMethodProxy.currentThread().getName();
            r0.a("ScheduleServiceConnection");
            this.a.unlinkToDeath(this, 0);
            Object r1 = ScheduleServiceConnection.b;
            monitor-enter(r1);
            ScheduleServiceConnection r2 = ScheduleServiceConnection.a;     // Catch: Throwable -> L8
            BindState r3 = BindState.NotStart;     // Catch: Throwable -> L8
            r2.getClass();     // Catch: Throwable -> L8
            Intrinsics.checkNotNullParameter(r3, "<set-?>");     // Catch: Throwable -> L8
            ScheduleServiceConnection r4 = ScheduleServiceConnection.a;     // Catch: Throwable -> L8
            Unit r5 = Unit.INSTANCE;     // Catch: Throwable -> L8
            monitor-exit(r1);
            b.c();
            return;
        L8:
            th = move-exception;
            throw th;
        }

        public a(IBinder r1) {
            this.a = r1;
        }
    }

    public ScheduleServiceConnection() {
    }

    static {
        a = new ScheduleServiceConnection();
        b = new Object();
        BindState r0 = BindState.NotStart;
    }

    @Override // android.content.ServiceConnection
    public final void onNullBinding(ComponentName r3) {
        via.b r4 = via.b.a;
        ThreadMethodProxy.currentThread().getName();
        r4.a("ScheduleServiceConnection");
        Object r5 = b;
        monitor-enter(r5);
        BindState r0 = BindState.NotStart;     // Catch: Throwable -> L11
        Unit r1 = Unit.INSTANCE;     // Catch: Throwable -> L11
        monitor-exit(r5);
        Result.Companion r6 = Result.Companion;     // Catch: Throwable -> L8
        uia.a.a.getClass();     // Catch: Throwable -> L8
        throw new IllegalStateException("app module must call Apphost.setApphost()");     // Catch: Throwable -> L8
    L8:
        th = move-exception;
        Result.Companion r2 = Result.Companion;
        Result.constructor-impl(ResultKt.createFailure(th));
        b.c();
        return;
    L11:
        th = move-exception;
        throw th;
    }

    @Override // android.content.ServiceConnection
    public final void onServiceDisconnected(ComponentName r2) {
        via.b.a.a("ScheduleServiceConnection");
        Object r3 = b;
        monitor-enter(r3);
        BindState r0 = BindState.NotStart;     // Catch: Throwable -> L8
        Unit r1 = Unit.INSTANCE;     // Catch: Throwable -> L8
        monitor-exit(r3);
        b.c();
        return;
    L8:
        th = move-exception;
        throw th;
    }

    @Override // android.content.ServiceConnection
    public final void onServiceConnected(ComponentName r5, IBinder r6) {
        via.b r7 = via.b.a;
        ThreadMethodProxy.currentThread().getName();
        r7.a("ScheduleServiceConnection");
        monitor-enter(b);
        BindState r1 = BindState.NotStart;     // Catch: Throwable -> L17
        Result.Companion r2 = Result.Companion;     // Catch: Throwable -> L11
        if (r6 == null) goto L8;
        r6.linkToDeath(new a(r6), 0);     // Catch: Throwable -> L11
    L9:
        new d(ICapabilitySchedule.Stub.asInterface(r6));     // Catch: Throwable -> L11
        r7.a("ScheduleServiceConnection");     // Catch: Throwable -> L11
        b.b();     // Catch: Throwable -> L11
        throw null;     // Catch: Throwable -> L11
    L8:
        r6 = null;
    L11:
        th = move-exception;
        Result.Companion r8 = Result.Companion;     // Catch: Throwable -> L17
        Throwable r9 = Result.exceptionOrNull-impl(Result.constructor-impl(ResultKt.createFailure(th)));     // Catch: Throwable -> L17
        if (r9 == null) goto L23;
        via.b r10 = via.b.a;     // Catch: Throwable -> L17
        ExceptionsKt.stackTraceToString(r9);     // Catch: Throwable -> L17
        Intrinsics.checkNotNullParameter("ScheduleServiceConnection", "tag");     // Catch: Throwable -> L17
        int r3 = via.a.a;     // Catch: Throwable -> L17
        Intrinsics.checkNotNullParameter("ac_".concat("ScheduleServiceConnection"), "tag");     // Catch: Throwable -> L17
        return;
    L23:
        return;
    L17:
        th = move-exception;
        throw th;
    }
}
