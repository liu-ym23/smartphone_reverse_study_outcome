package com.obric.aiagent.assistant.idl;

import android.os.IBinder;
import com.obric.aiagent.ipc.utils.e;
import java.lang.ref.WeakReference;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
public final class f2 {
    public static final Map<IBinder, WeakReference<FlowIsMessageInterruptedCallbackIDLStubWrapper>> a = null;

    static {
        a = new LinkedHashMap();
    }

    public static final IFlowIsMessageInterruptedCallbackIDL.Stub a(final IFlowIsMessageInterruptedCallbackIDL.Stub r5) {
        Intrinsics.checkNotNullParameter(r5, "<this>");
        Map<IBinder, WeakReference<FlowIsMessageInterruptedCallbackIDLStubWrapper>> r1 = a;
        monitor-enter(r1);
        WeakReference r2 = (WeakReference) ((LinkedHashMap) r1).get(r5.asBinder());     // Catch: Throwable -> L25
        if (r2 == null) goto L11;
        FlowIsMessageInterruptedCallbackIDLStubWrapper r3 = (FlowIsMessageInterruptedCallbackIDLStubWrapper) r2.get();     // Catch: Throwable -> L25
        if (r3 == null) goto L11;
        r3.log = true;     // Catch: Throwable -> L25
        monitor-exit(r1);
        return r3;
    L11:
        Unit r4 = Unit.INSTANCE;     // Catch: Throwable -> L25
        monitor-exit(r1);
        if ((r5 instanceof FlowIsMessageInterruptedCallbackIDLStubWrapper) == false) goto L16;
        FlowIsMessageInterruptedCallbackIDLStubWrapper r6 = new FlowIsMessageInterruptedCallbackIDLStubWrapper(((FlowIsMessageInterruptedCallbackIDLStubWrapper) r5).origin, true);
    L17:
        monitor-enter(r1);
        CollectionsKt.removeAll(((LinkedHashMap) r1).entrySet(), new e2());     // Catch: Throwable -> L22
        int r7 = e.a;     // Catch: Throwable -> L22
        e.a("IFlowIsMessageInterruptedCallbackIDL", "Stub.wrap, (" + r6 + ')');     // Catch: Throwable -> L22
        WeakReference<FlowIsMessageInterruptedCallbackIDLStubWrapper> r0 = r1.put(r5.asBinder(), new WeakReference(r6));     // Catch: Throwable -> L22
        monitor-exit(r1);
        r6.linkToDeath(new d2(r5), 0);
        return r6;
    L22:
        th = move-exception;
        throw th;
    L16:
        r6 = new FlowIsMessageInterruptedCallbackIDLStubWrapper(r5, true);
    L25:
        th = move-exception;
        throw th;
    }

    public static final IFlowIsMessageInterruptedCallbackIDL b(IFlowIsMessageInterruptedCallbackIDL r2) {
        Intrinsics.checkNotNullParameter(r2, "<this>");
        if ((r2 instanceof FlowIsMessageInterruptedCallbackIDLIpcWrapper) == false) goto L7;
        return new FlowIsMessageInterruptedCallbackIDLIpcWrapper(((FlowIsMessageInterruptedCallbackIDLIpcWrapper) r2).origin, true);
    L7:
        return new FlowIsMessageInterruptedCallbackIDLIpcWrapper(r2, true);
    }
}
