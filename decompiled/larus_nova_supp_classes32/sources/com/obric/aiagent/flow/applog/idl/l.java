package com.obric.aiagent.flow.applog.idl;

import android.os.IBinder;
import java.lang.ref.WeakReference;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
public final class l {
    public static final Map<IBinder, WeakReference<FlowAppLogSessionObserverIDLStubWrapper>> a = null;

    static {
        a = new LinkedHashMap();
    }

    public static final IFlowAppLogSessionObserverIDL.Stub a(final IFlowAppLogSessionObserverIDL.Stub r5) {
        Intrinsics.checkNotNullParameter(r5, "<this>");
        Map<IBinder, WeakReference<FlowAppLogSessionObserverIDLStubWrapper>> r1 = a;
        monitor-enter(r1);
        WeakReference r2 = (WeakReference) ((LinkedHashMap) r1).get(r5.asBinder());     // Catch: Throwable -> L25
        if (r2 == null) goto L11;
        FlowAppLogSessionObserverIDLStubWrapper r3 = (FlowAppLogSessionObserverIDLStubWrapper) r2.get();     // Catch: Throwable -> L25
        if (r3 == null) goto L11;
        r3.log = true;     // Catch: Throwable -> L25
        monitor-exit(r1);
        return r3;
    L11:
        Unit r4 = Unit.INSTANCE;     // Catch: Throwable -> L25
        monitor-exit(r1);
        if ((r5 instanceof FlowAppLogSessionObserverIDLStubWrapper) == false) goto L16;
        FlowAppLogSessionObserverIDLStubWrapper r6 = new FlowAppLogSessionObserverIDLStubWrapper(((FlowAppLogSessionObserverIDLStubWrapper) r5).origin, true);
    L17:
        monitor-enter(r1);
        CollectionsKt.removeAll(((LinkedHashMap) r1).entrySet(), new k());     // Catch: Throwable -> L22
        int r7 = com.obric.aiagent.ipc.utils.e.a;     // Catch: Throwable -> L22
        com.obric.aiagent.ipc.utils.e.a("IFlowAppLogSessionObserverIDL", "Stub.wrap, (" + r6 + ')');     // Catch: Throwable -> L22
        WeakReference<FlowAppLogSessionObserverIDLStubWrapper> r0 = r1.put(r5.asBinder(), new WeakReference(r6));     // Catch: Throwable -> L22
        monitor-exit(r1);
        r6.linkToDeath(new j(r5), 0);
        return r6;
    L22:
        th = move-exception;
        throw th;
    L16:
        r6 = new FlowAppLogSessionObserverIDLStubWrapper(r5, true);
    L25:
        th = move-exception;
        throw th;
    }

    public static final IFlowAppLogSessionObserverIDL b(IFlowAppLogSessionObserverIDL r2) {
        Intrinsics.checkNotNullParameter(r2, "<this>");
        if ((r2 instanceof FlowAppLogSessionObserverIDLIpcWrapper) == false) goto L7;
        return new FlowAppLogSessionObserverIDLIpcWrapper(((FlowAppLogSessionObserverIDLIpcWrapper) r2).origin, true);
    L7:
        return new FlowAppLogSessionObserverIDLIpcWrapper(r2, true);
    }
}
