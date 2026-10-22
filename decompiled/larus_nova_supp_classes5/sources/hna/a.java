package hna;

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
public final class a {
    public static long a;
    public static long b;
    public static final List<Pair<Integer, Long>> c = null;

    static {
        c = Collections.synchronizedList(new ArrayList());
    }

    public static long a() {
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
    public static final void b(int r5) {
        List<Pair<Integer, Long>> r0 = c;
        Intrinsics.checkNotNull(r0);
        List<Pair<Integer, Long>> r1 = r0;
        ArrayList r2 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r1, 10));
        Iterator<T> r3 = r1.iterator();
    L4:
        if (r3.hasNext() == false) goto L7;
        r2.add(Integer.valueOf(((Number) ((Pair) r3.next()).getFirst()).intValue()));
        goto L4
    L7:
        if (r2.contains(Integer.valueOf(r5)) == false) goto L9;
        return;
    L9:
        c.add(new Pair(Integer.valueOf(r5), Long.valueOf(SystemClock.uptimeMillis())));
        ILogDepend.a.d("PowerMonitor", "AudioInMonitor onStart: " + r5);
    }

    @JvmStatic
    public static final void c(int r11) {
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
        ILogDepend.a.d("PowerMonitor", "AudioInMonitor onStop: " + r11 + ", audioInStartTime: " + a);
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
}
