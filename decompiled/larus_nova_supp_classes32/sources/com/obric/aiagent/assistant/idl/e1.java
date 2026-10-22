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
public final class e1 {
    public static final Map<IBinder, WeakReference<FlowDeleteMessageCallbackIDLStubWrapper>> a = null;

    static {
        a = new LinkedHashMap();
    }

    public static final IFlowDeleteMessageCallbackIDL.Stub a(final IFlowDeleteMessageCallbackIDL.Stub r5) {
        Intrinsics.checkNotNullParameter(r5, "<this>");
        Map<IBinder, WeakReference<FlowDeleteMessageCallbackIDLStubWrapper>> r1 = a;
        monitor-enter(r1);
        WeakReference r2 = (WeakReference) ((LinkedHashMap) r1).get(r5.asBinder());     // Catch: Throwable -> L25
        if (r2 == null) goto L11;
        FlowDeleteMessageCallbackIDLStubWrapper r3 = (FlowDeleteMessageCallbackIDLStubWrapper) r2.get();     // Catch: Throwable -> L25
        if (r3 == null) goto L11;
        r3.log = true;     // Catch: Throwable -> L25
        monitor-exit(r1);
        return r3;
    L11:
        Unit r4 = Unit.INSTANCE;     // Catch: Throwable -> L25
        monitor-exit(r1);
        if ((r5 instanceof FlowDeleteMessageCallbackIDLStubWrapper) == false) goto L16;
        FlowDeleteMessageCallbackIDLStubWrapper r6 = new FlowDeleteMessageCallbackIDLStubWrapper(((FlowDeleteMessageCallbackIDLStubWrapper) r5).origin, true);
    L17:
        monitor-enter(r1);
        CollectionsKt.removeAll(((LinkedHashMap) r1).entrySet(), new d1());     // Catch: Throwable -> L22
        int r7 = e.a;     // Catch: Throwable -> L22
        e.a("IFlowDeleteMessageCallbackIDL", "Stub.wrap, (" + r6 + ')');     // Catch: Throwable -> L22
        WeakReference<FlowDeleteMessageCallbackIDLStubWrapper> r0 = r1.put(r5.asBinder(), new WeakReference(r6));     // Catch: Throwable -> L22
        monitor-exit(r1);
        r6.linkToDeath(new c1(r5), 0);
        return r6;
    L22:
        th = move-exception;
        throw th;
    L16:
        r6 = new FlowDeleteMessageCallbackIDLStubWrapper(r5, true);
    L25:
        th = move-exception;
        throw th;
    }

    public static final IFlowDeleteMessageCallbackIDL b(IFlowDeleteMessageCallbackIDL r2) {
        Intrinsics.checkNotNullParameter(r2, "<this>");
        if ((r2 instanceof FlowDeleteMessageCallbackIDLIpcWrapper) == false) goto L7;
        return new FlowDeleteMessageCallbackIDLIpcWrapper(((FlowDeleteMessageCallbackIDLIpcWrapper) r2).origin, true);
    L7:
        return new FlowDeleteMessageCallbackIDLIpcWrapper(r2, true);
    }
}
