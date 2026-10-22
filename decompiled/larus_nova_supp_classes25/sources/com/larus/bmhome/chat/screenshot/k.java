package com.larus.bmhome.chat.screenshot;

import com.larus.utils.logger.FLogger;
import java.lang.ref.WeakReference;
import java.util.Iterator;
import java.util.UUID;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.function.Consumer;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
public final /* synthetic */ class k implements Consumer {
    public /* synthetic */ k() {
    }

    @Override // java.util.function.Consumer
    public final void accept(Object r7) {
        Integer r8 = (Integer) r7;
        Intrinsics.checkNotNullParameter(r8, "state");
        int r9 = r8.intValue();
        if (r9 != 0) goto L5;
        FLogger.a.i("ScreenRecordManager", "System Callback: End Recording / Recording Not active");
        CopyOnWriteArrayList<WeakReference<e>> r10 = ScreenRecordManager.a;
        ScreenRecordManager.b("system");
        return;
    L5:
        if (r9 != 1) goto L50;
        FLogger.a.i("ScreenRecordManager", "System callback: Start Recording");
        if (ScreenRecordManager.f == true) goto L51;
        ScreenRecordManager.f = true;
        ScreenRecordManager.g = UUID.randomUUID().toString();
        Object r11 = ScreenRecordManager.e;
        monitor-enter(r11);
        ScreenRecordManager.c.clear();     // Catch: Throwable -> L33
        ScreenRecordManager.d.clear();     // Catch: Throwable -> L33
        Unit r1 = Unit.INSTANCE;     // Catch: Throwable -> L33
        monitor-exit(r11);
        String r12 = ScreenRecordManager.g;
        if (r12 == null) goto L52;
        CopyOnWriteArrayList<WeakReference<e>> r2 = ScreenRecordManager.a;
        Iterator<WeakReference<e>> r3 = r2.iterator();
    L19:
        if (r3.hasNext() == false) goto L27;
        WeakReference<e> r4 = r3.next();
        WeakReference<e> r5 = r4;
        Intrinsics.checkNotNullParameter(r5, "it");
        if (r5.get() != null) goto L23;
        boolean r6 = true;
    L25:
        if (Boolean.valueOf(r6).booleanValue() == false) goto L19;
        r2.remove(r4);
        goto L19
    L23:
        r6 = false;
        goto L25
    L27:
        Iterator<WeakReference<e>> r0 = r2.iterator();
    L29:
        if (r0.hasNext() == false) goto L53;
        e r13 = r0.next().get();
        if (r13 == null) goto L29;
        r13.a(r12);
        goto L29
    L53:
        return;
    L52:
        return;
    L33:
        th = move-exception;
        throw th;
    L51:
        return;
    }
}
