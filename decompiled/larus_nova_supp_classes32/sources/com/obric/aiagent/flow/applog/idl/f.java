package com.obric.aiagent.flow.applog.idl;

import android.os.IBinder;
import java.lang.ref.WeakReference;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
public final class f {
    public static final Map<IBinder, WeakReference<FlowAppLogEventObserverIDLStubWrapper>> a = null;

    static {
        a = new LinkedHashMap();
    }

    public static final IFlowAppLogEventObserverIDL.Stub a(IFlowAppLogEventObserverIDL.Stub r5) {
        Intrinsics.checkNotNullParameter(r5, "<this>");
        Map<IBinder, WeakReference<FlowAppLogEventObserverIDLStubWrapper>> r1 = a;
        monitor-enter(r1);
        WeakReference r2 = (WeakReference) ((LinkedHashMap) r1).get(r5.asBinder());     // Catch: Throwable -> L25
        if (r2 == null) goto L11;
        FlowAppLogEventObserverIDLStubWrapper r3 = (FlowAppLogEventObserverIDLStubWrapper) r2.get();     // Catch: Throwable -> L25
        if (r3 == null) goto L11;
        r3.log = true;     // Catch: Throwable -> L25
        monitor-exit(r1);
        return r3;
    L11:
        Unit r4 = Unit.INSTANCE;     // Catch: Throwable -> L25
        monitor-exit(r1);
        if ((r5 instanceof FlowAppLogEventObserverIDLStubWrapper) == false) goto L16;
        FlowAppLogEventObserverIDLStubWrapper r6 = new FlowAppLogEventObserverIDLStubWrapper(((FlowAppLogEventObserverIDLStubWrapper) r5).origin, true);
    L17:
        monitor-enter(r1);
        CollectionsKt.removeAll(((LinkedHashMap) r1).entrySet(), new e());     // Catch: Throwable -> L22
        int r7 = com.obric.aiagent.ipc.utils.e.a;     // Catch: Throwable -> L22
        com.obric.aiagent.ipc.utils.e.a("IFlowAppLogEventObserverIDL", "Stub.wrap, (" + r6 + ')');     // Catch: Throwable -> L22
        WeakReference<FlowAppLogEventObserverIDLStubWrapper> r0 = r1.put(r5.asBinder(), new WeakReference(r6));     // Catch: Throwable -> L22
        monitor-exit(r1);
        r6.linkToDeath(new d(r5), 0);
        return r6;
    L22:
        th = move-exception;
        throw th;
    L16:
        r6 = new FlowAppLogEventObserverIDLStubWrapper(r5, true);
    L25:
        th = move-exception;
        throw th;
    }

    public static final IFlowAppLogEventObserverIDL b(IFlowAppLogEventObserverIDL r2) {
        Intrinsics.checkNotNullParameter(r2, "<this>");
        if ((r2 instanceof FlowAppLogEventObserverIDLIpcWrapper) == false) goto L7;
        return new FlowAppLogEventObserverIDLIpcWrapper(((FlowAppLogEventObserverIDLIpcWrapper) r2).origin, true);
    L7:
        return new FlowAppLogEventObserverIDLIpcWrapper(r2, true);
    }
}
