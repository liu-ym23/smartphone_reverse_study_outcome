package com.obric.memorydata.sdk.awareness;

import android.content.ComponentName;
import android.content.ServiceConnection;
import android.os.IBinder;
import android.os.RemoteException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import tka.b;
import tka.c;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
public final class h implements ServiceConnection {
    public h() {
    }

    @Override // android.content.ServiceConnection
    public final void onBindingDied(ComponentName r3) {
        b r0 = c.a;
        c.c("ContextAwareness", "ContextAwarenessService binding died " + r3);
        e.a.getClass();
        e.c(this, null);
    }

    @Override // android.content.ServiceConnection
    public final void onNullBinding(ComponentName r3) {
        b r0 = c.a;
        c.d("ContextAwareness", "ContextAwarenessService onNullBinding " + r3);
        e.a.getClass();
        e.c(this, null);
    }

    @Override // android.content.ServiceConnection
    public final void onServiceDisconnected(ComponentName r4) {
        Intrinsics.checkNotNullParameter(r4, "comp");
        e r0 = e.a;
        monitor-enter(r0);
    L13:
        th = move-exception;
        throw th;
    L5:
        if (this == e.c) goto L9;
        monitor-exit(r0);
        return;
    L9:
        e.b = null;     // Catch: Throwable -> L13
        Unit r1 = Unit.INSTANCE;     // Catch: Throwable -> L13
        monitor-exit(r0);
        b r2 = c.a;
        c.c("ContextAwareness", "ContextAwarenessService disconnected " + r4);
    }

    @Override // android.content.ServiceConnection
    public final void onServiceConnected(ComponentName r13, IBinder r14) {
        Intrinsics.checkNotNullParameter(r13, "className");
        Intrinsics.checkNotNullParameter(r14, "binder");
        IBinder.DeathRecipient r15 = new f(this, r14);
        e r0 = e.a;
        monitor-enter(r0);
    L81:
        th = move-exception;
        throw th;
    L5:
        if (this == e.c) goto L7;
        boolean r1 = false;
    L9:
        monitor-exit(r0);
        if (r1 == true) goto L85;
        return;
    L85:
        r14.linkToDeath(r15, 0);     // Catch: RemoteException -> L78
        monitor-enter(r0);
    L75:
        th = move-exception;
        throw th;
    L15:
        if (this == e.c) goto L17;
    L72:
        pka.b.a(new g(r14, r15));     // Catch: Throwable -> L75
        monitor-exit(r0);
        return;
    L17:
        if (r14 != e.d) goto L72;
        if (r15 != e.e) goto L72;
        e.b = IContextAwarenessService.Stub.asInterface(r14);     // Catch: Throwable -> L75
        List r16 = e.f;     // Catch: Throwable -> L75
        List r17 = CollectionsKt.toList(r16);     // Catch: Throwable -> L75
        ((ArrayList) r16).clear();     // Catch: Throwable -> L75
        monitor-exit(r0);
        c.c("ContextAwareness", "ContextAwarenessService connected");
        e.a(r17, 0, "ContextAwarenessService connected");
        Iterator r18 = e.i.keySet().iterator();
    L25:
        if (r18.hasNext() == false) goto L39;
        String r19 = (String) r18.next();
        Set r4 = (Set) e.i.get(r19);
        if (r4 == null) goto L25;
        b r5 = c.a;
        c.a("Retry registering feature: " + r19);
        if ((!r4.isEmpty()) == false) goto L25;
        IFeatureChangeListener r6 = (IFeatureChangeListener) e.j.get(r19);
        if (r6 == null) goto L38;
        IContextAwarenessService r2 = e.b;     // Catch: RemoteException -> L36
        if (r2 == null) goto L25;
        r2.registerFeature(r19, r6);     // Catch: RemoteException -> L36
    L36:
        e = move-exception;
        b r3 = c.a;
        c.b("ContextAwareness", "Failed to re-register feature: " + r19, e);
        Unit r110 = Unit.INSTANCE;
        goto L25
    L38:
        c.b("ContextAwareness", "RemoteListener for feature " + r19 + " is null", null);
        goto L25
    L39:
        Iterator r111 = e.k.keySet().iterator();
    L41:
        if (r111.hasNext() == false) goto L55;
        String r112 = (String) r111.next();
        Set r7 = (Set) e.k.get(r112);
        if (r7 == null) goto L41;
        b r8 = c.a;
        c.a("Retry registering event: " + r112);
        if ((!r7.isEmpty()) == false) goto L41;
        IEventChangeListener r9 = (IEventChangeListener) e.l.get(r112);
        if (r9 == null) goto L54;
        IContextAwarenessService r10 = e.b;     // Catch: RemoteException -> L52
        if (r10 == null) goto L41;
        r10.registerEvent(r112, r9);     // Catch: RemoteException -> L52
    L52:
        e = move-exception;
        b r11 = c.a;
        c.b("ContextAwareness", "Failed to re-register event: " + r112, e);
        Unit r113 = Unit.INSTANCE;
        goto L41
    L54:
        c.b("ContextAwareness", "RemoteListener for event " + r112 + " is null", null);
        goto L41
    L55:
        Iterator r114 = e.m.keySet().iterator();
    L57:
        if (r114.hasNext() == false) goto L71;
        e$b r115 = (e$b) r114.next();
        Set r12 = (Set) e.m.get(r115);
        if (r12 == null) goto L57;
        b r20 = c.a;
        c.a("Retry registering duration feature: " + r115);
        if ((!r12.isEmpty()) == false) goto L57;
        IFeatureDurationListener r116 = (IFeatureDurationListener) e.n.get(r115);
        if (r116 == null) goto L70;
        IContextAwarenessService r21 = e.b;     // Catch: RemoteException -> L68
        if (r21 == null) goto L57;
        r115.getClass();     // Catch: RemoteException -> L68
        r21.registerFeatureDuration(null, null, 0, false, r116);     // Catch: RemoteException -> L68
    L68:
        e = move-exception;
        b r22 = c.a;
        c.b("ContextAwareness", "Failed to re-register duration feature: " + r115, e);
        Unit r117 = Unit.INSTANCE;
        goto L57
    L70:
        c.b("ContextAwareness", "Remote duration listener for " + r115 + " is null", null);
        goto L57
    L71:
        return;
    L78:
        e = move-exception;
        b r23 = c.a;
        c.b("ContextAwareness", "linkToDeath failed", e);
        e.a.getClass();
        e.c(this, r14);
        return;
    L7:
        e.d = r14;     // Catch: Throwable -> L81
        e.e = r15;     // Catch: Throwable -> L81
        r1 = true;
        goto L9
    }
}
