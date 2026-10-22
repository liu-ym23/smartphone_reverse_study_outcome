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
public final class e4 {
    public static final Map<IBinder, WeakReference<MusicStateListenerIDLStubWrapper>> a = null;

    static {
        a = new LinkedHashMap();
    }

    public static final IMusicStateListenerIDL.Stub a(final IMusicStateListenerIDL.Stub r5) {
        Intrinsics.checkNotNullParameter(r5, "<this>");
        Map<IBinder, WeakReference<MusicStateListenerIDLStubWrapper>> r1 = a;
        monitor-enter(r1);
        WeakReference r2 = (WeakReference) ((LinkedHashMap) r1).get(r5.asBinder());     // Catch: Throwable -> L25
        if (r2 == null) goto L11;
        MusicStateListenerIDLStubWrapper r3 = (MusicStateListenerIDLStubWrapper) r2.get();     // Catch: Throwable -> L25
        if (r3 == null) goto L11;
        r3.log = true;     // Catch: Throwable -> L25
        monitor-exit(r1);
        return r3;
    L11:
        Unit r4 = Unit.INSTANCE;     // Catch: Throwable -> L25
        monitor-exit(r1);
        if ((r5 instanceof MusicStateListenerIDLStubWrapper) == false) goto L16;
        MusicStateListenerIDLStubWrapper r6 = new MusicStateListenerIDLStubWrapper(((MusicStateListenerIDLStubWrapper) r5).origin, true);
    L17:
        monitor-enter(r1);
        CollectionsKt.removeAll(((LinkedHashMap) r1).entrySet(), new d4());     // Catch: Throwable -> L22
        int r7 = e.a;     // Catch: Throwable -> L22
        e.a("IMusicStateListenerIDL", "Stub.wrap, (" + r6 + ')');     // Catch: Throwable -> L22
        WeakReference<MusicStateListenerIDLStubWrapper> r0 = r1.put(r5.asBinder(), new WeakReference(r6));     // Catch: Throwable -> L22
        monitor-exit(r1);
        r6.linkToDeath(new c4(r5), 0);
        return r6;
    L22:
        th = move-exception;
        throw th;
    L16:
        r6 = new MusicStateListenerIDLStubWrapper(r5, true);
    L25:
        th = move-exception;
        throw th;
    }

    public static final IMusicStateListenerIDL b(IMusicStateListenerIDL r2) {
        Intrinsics.checkNotNullParameter(r2, "<this>");
        if ((r2 instanceof MusicStateListenerIDLIpcWrapper) == false) goto L7;
        return new MusicStateListenerIDLIpcWrapper(((MusicStateListenerIDLIpcWrapper) r2).origin, true);
    L7:
        return new MusicStateListenerIDLIpcWrapper(r2, true);
    }
}
