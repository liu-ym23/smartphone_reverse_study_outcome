package gna;

import android.os.SystemClock;
import com.obric.aiagent.platform.depend.ILogDepend;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import kotlin.Pair;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes5.dex */
public final class a {
    public static long a;
    public static long b;
    public static final List<Pair<Integer, Long>> c = null;

    static {
        c = Collections.synchronizedList(new ArrayList());
    }

    public static long b() {
        List<Pair<Integer, Long>> r0 = c;
        monitor-enter(r0);
        Iterator<T> r1 = r0.iterator();     // Catch: Throwable -> L11
        long r4 = 0;
    L6:
        if (r1.hasNext() == false) goto L8;
        r4 = r4 + (SystemClock.uptimeMillis() - Math.max(b, ((Number) ((Pair) r1.next()).getSecond()).longValue()));     // Catch: Throwable -> L11
        goto L6
    L8:
        long r5 = r4 + a;     // Catch: Throwable -> L11
        a = 0;     // Catch: Throwable -> L11
        b = SystemClock.uptimeMillis();     // Catch: Throwable -> L11
        monitor-exit(r0);
        return r5;
    L11:
        th = move-exception;
        throw th;
    }

    @JvmStatic
    public static final void a(int r11) {
        List<Pair<Integer, Long>> r0 = c;
        Intrinsics.checkNotNull(r0);
        monitor-enter(r0);
        Iterator<T> r1 = r0.iterator();     // Catch: Throwable -> L22
    L6:
        if (r1.hasNext() == false) goto L13;
        Object r2 = r1.next();     // Catch: Throwable -> L22
        if (((Number) ((Pair) r2).getFirst()).intValue() != r11) goto L10;
        boolean r3 = true;
    L11:
        if (r3 == false) goto L6;
    L14:
        Pair r4 = (Pair) r2;     // Catch: Throwable -> L22
        if (r4 != null) goto L18;
        monitor-exit(r0);
        return;
    L18:
        a += SystemClock.uptimeMillis() - Math.max(b, ((Number) r4.getSecond()).longValue());     // Catch: Throwable -> L22
        c.remove(r4);     // Catch: Throwable -> L22
        monitor-exit(r0);
        ILogDepend.a.d("PowerMonitor", "AudioMonitor onPauseOrStop: " + r11 + ", audioStartTime: " + a);
        return;
    L10:
        r3 = false;
        goto L11
    L13:
        r2 = null;
    L22:
        th = move-exception;
        throw th;
    }

    @JvmStatic
    public static final void c(int r6) {
        List<Pair<Integer, Long>> r0 = c;
        Intrinsics.checkNotNull(r0);
        monitor-enter(r0);
        List<Pair<Integer, Long>> r1 = r0;     // Catch: Throwable -> L26
        boolean r3 = false;
        if ((r1 instanceof Collection) == true) goto L7;
    L9:
        Iterator<T> r2 = r1.iterator();     // Catch: Throwable -> L26
    L11:
        if (r2.hasNext() == false) goto L19;
        if (((Number) ((Pair) r2.next()).getFirst()).intValue() != r6) goto L16;
        boolean r4 = true;
    L17:
        if (r4 == false) goto L11;
        r3 = true;
        goto L19
    L16:
        r4 = false;
    L19:
        if (r3 == false) goto L22;
        monitor-exit(r0);
        return;
    L22:
        c.add(new Pair(Integer.valueOf(r6), Long.valueOf(SystemClock.uptimeMillis())));     // Catch: Throwable -> L26
        monitor-exit(r0);
        ILogDepend.a.d("PowerMonitor", "AudioMonitor onStart: " + r6);
        return;
    L7:
        if (r1.isEmpty() == false) goto L9;
    L26:
        th = move-exception;
        throw th;
    }
}
