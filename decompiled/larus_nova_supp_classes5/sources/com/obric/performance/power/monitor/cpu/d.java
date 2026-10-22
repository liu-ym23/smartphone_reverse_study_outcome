package com.obric.performance.power.monitor.cpu;

import android.os.PowerManager;
import android.os.SystemClock;
import com.obric.aiagent.platform.depend.ILogDepend;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import kotlin.Pair;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes5.dex */
public final class d {
    public static long a;
    public static long b;
    public static final List<Pair<Integer, Long>> c = null;

    static {
        c = Collections.synchronizedList(new ArrayList());
    }

    @JvmStatic
    public static final void a(Object r5) {
        Intrinsics.checkNotNullParameter(r5, "wakeLockObject");
        int r0 = r5.hashCode();
        if ((r5 instanceof PowerManager.WakeLock) == false) goto L14;
        List<Pair<Integer, Long>> r6 = c;
        Intrinsics.checkNotNull(r6);
        List<Pair<Integer, Long>> r7 = r6;
        ArrayList r1 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r7, 10));
        Iterator<T> r8 = r7.iterator();
    L6:
        if (r8.hasNext() == false) goto L9;
        r1.add(Integer.valueOf(((Number) ((Pair) r8.next()).getFirst()).intValue()));
        goto L6
    L9:
        if (r1.contains(Integer.valueOf(r0)) == true) goto L15;
        c.add(new Pair(Integer.valueOf(r0), Long.valueOf(SystemClock.uptimeMillis())));
        ILogDepend.a.d("PowerMonitor", "WakeLockMonitor onAcquire: " + r0);
        return;
    L15:
        return;
    }

    @JvmStatic
    public static final void b(Object r11) {
        Intrinsics.checkNotNullParameter(r11, "wakeLockObject");
        int r0 = r11.hashCode();
        if ((r11 instanceof PowerManager.WakeLock) == false) goto L35;
        List<Pair<Integer, Long>> r1 = c;
        Intrinsics.checkNotNull(r1);
        List<Pair<Integer, Long>> r2 = r1;
        ArrayList r3 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r2, 10));
        Iterator<T> r4 = r2.iterator();
    L6:
        if (r4.hasNext() == false) goto L9;
        r3.add(Integer.valueOf(((Number) ((Pair) r4.next()).getFirst()).intValue()));
        goto L6
    L9:
        if (r3.contains(Integer.valueOf(r0)) == true) goto L12;
        return;
    L12:
        if (((PowerManager.WakeLock) r11).isHeld() == true) goto L44;
        List<Pair<Integer, Long>> r12 = c;
        Intrinsics.checkNotNull(r12);
        monitor-enter(r12);
        Iterator<T> r5 = r12.iterator();     // Catch: Throwable -> L32
    L17:
        if (r5.hasNext() == false) goto L24;
        Object r6 = r5.next();     // Catch: Throwable -> L32
        if (((Number) ((Pair) r6).getFirst()).intValue() != r0) goto L21;
        boolean r7 = true;
    L22:
        if (r7 == false) goto L17;
    L25:
        Pair r8 = (Pair) r6;     // Catch: Throwable -> L32
        if (r8 != null) goto L29;
        monitor-exit(r12);
        return;
    L29:
        a += SystemClock.uptimeMillis() - Math.max(b, ((Number) r8.getSecond()).longValue());     // Catch: Throwable -> L32
        c.remove(r8);     // Catch: Throwable -> L32
        monitor-exit(r12);
        ILogDepend.a.d("PowerMonitor", "WakeLockMonitor onRelease: " + r0 + ", wakeLockTime: " + a);
        return;
    L21:
        r7 = false;
        goto L22
    L24:
        r6 = null;
    L32:
        th = move-exception;
        throw th;
    L44:
        return;
    }
}
