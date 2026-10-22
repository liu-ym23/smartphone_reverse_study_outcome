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
public final class u4 {
    public static final Map<IBinder, WeakReference<ScreenshotCallbackIDLStubWrapper>> a = null;

    static {
        a = new LinkedHashMap();
    }

    public static final IScreenshotCallbackIDL.Stub a(final IScreenshotCallbackIDL.Stub r5) {
        Intrinsics.checkNotNullParameter(r5, "<this>");
        Map<IBinder, WeakReference<ScreenshotCallbackIDLStubWrapper>> r1 = a;
        monitor-enter(r1);
        WeakReference r2 = (WeakReference) ((LinkedHashMap) r1).get(r5.asBinder());     // Catch: Throwable -> L25
        if (r2 == null) goto L11;
        ScreenshotCallbackIDLStubWrapper r3 = (ScreenshotCallbackIDLStubWrapper) r2.get();     // Catch: Throwable -> L25
        if (r3 == null) goto L11;
        r3.log = true;     // Catch: Throwable -> L25
        monitor-exit(r1);
        return r3;
    L11:
        Unit r4 = Unit.INSTANCE;     // Catch: Throwable -> L25
        monitor-exit(r1);
        if ((r5 instanceof ScreenshotCallbackIDLStubWrapper) == false) goto L16;
        ScreenshotCallbackIDLStubWrapper r6 = new ScreenshotCallbackIDLStubWrapper(((ScreenshotCallbackIDLStubWrapper) r5).origin, true);
    L17:
        monitor-enter(r1);
        CollectionsKt.removeAll(((LinkedHashMap) r1).entrySet(), new t4());     // Catch: Throwable -> L22
        int r7 = e.a;     // Catch: Throwable -> L22
        e.a("IScreenshotCallbackIDL", "Stub.wrap, (" + r6 + ')');     // Catch: Throwable -> L22
        WeakReference<ScreenshotCallbackIDLStubWrapper> r0 = r1.put(r5.asBinder(), new WeakReference(r6));     // Catch: Throwable -> L22
        monitor-exit(r1);
        r6.linkToDeath(new s4(r5), 0);
        return r6;
    L22:
        th = move-exception;
        throw th;
    L16:
        r6 = new ScreenshotCallbackIDLStubWrapper(r5, true);
    L25:
        th = move-exception;
        throw th;
    }

    public static final IScreenshotCallbackIDL b(IScreenshotCallbackIDL r2) {
        Intrinsics.checkNotNullParameter(r2, "<this>");
        if ((r2 instanceof ScreenshotCallbackIDLIpcWrapper) == false) goto L7;
        return new ScreenshotCallbackIDLIpcWrapper(((ScreenshotCallbackIDLIpcWrapper) r2).origin, true);
    L7:
        return new ScreenshotCallbackIDLIpcWrapper(r2, true);
    }
}
