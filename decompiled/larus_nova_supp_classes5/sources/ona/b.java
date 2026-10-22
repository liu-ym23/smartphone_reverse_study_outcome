package ona;

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
public final class b {
    public static long a;
    public static long b;
    public static final List<Pair<a, Long>> c = null;

    static {
        c = Collections.synchronizedList(new ArrayList());
    }

    public static long b() {
        List<Pair<a, Long>> r0 = c;
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
    public static final void a(a r4) {
        Intrinsics.checkNotNullParameter(r4, "sensorInfo");
        List<Pair<a, Long>> r0 = c;
        Intrinsics.checkNotNull(r0);
        List<Pair<a, Long>> r1 = r0;
        ArrayList r2 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r1, 10));
        Iterator<T> r3 = r1.iterator();
    L4:
        if (r3.hasNext() == false) goto L7;
        r2.add(Integer.valueOf(((a) ((Pair) r3.next()).getFirst()).a));
        goto L4
    L7:
        if (r2.contains(Integer.valueOf(r4.a)) == false) goto L15;
        List<Pair<a, Long>> r5 = c;
        Intrinsics.checkNotNull(r5);
        List<Pair<a, Long>> r6 = r5;
        ArrayList r7 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r6, 10));
        Iterator<T> r8 = r6.iterator();
    L10:
        if (r8.hasNext() == false) goto L13;
        r7.add(((a) ((Pair) r8.next()).getFirst()).b);
        goto L10
    L13:
        if (r7.contains(r4.b) == false) goto L15;
        return;
    L15:
        c.add(new Pair(r4, Long.valueOf(SystemClock.uptimeMillis())));
        ILogDepend.a.d("PowerMonitor", "SensorMonitor onRegister: listenerHashCode=" + r4.a + ", sensorHashCode=" + r4.b);
    }

    @JvmStatic
    public static final void c(a r10) {
        Intrinsics.checkNotNullParameter(r10, "sensorInfo");
        Object r3 = null;
        if (r10.b != null) goto L25;
        List<Pair<a, Long>> r0 = c;
        Intrinsics.checkNotNull(r0);
        monitor-enter(r0);
        Iterator<T> r4 = r0.iterator();     // Catch: Throwable -> L22
    L8:
        if (r4.hasNext() == false) goto L15;
        Object r5 = r4.next();     // Catch: Throwable -> L22
        if (((a) ((Pair) r5).getFirst()).a != r10.a) goto L12;
        boolean r6 = true;
    L13:
        if (r6 == false) goto L8;
        r3 = r5;
        goto L15
    L12:
        r6 = false;
    L15:
        Pair r7 = (Pair) r3;     // Catch: Throwable -> L22
        if (r7 != null) goto L19;
        monitor-exit(r0);
        return;
    L19:
        a += SystemClock.uptimeMillis() - Math.max(b, ((Number) r7.getSecond()).longValue());     // Catch: Throwable -> L22
        c.remove(r7);     // Catch: Throwable -> L22
        monitor-exit(r0);
        ILogDepend.a.d("PowerMonitor", "SensorMonitor onUnregister: listenerHashCode=" + r10.a + ", sensorHashCode=null, sensorListenerTime=" + a);
        return;
    L22:
        th = move-exception;
        throw th;
    L25:
        List<Pair<a, Long>> r1 = c;
        Intrinsics.checkNotNull(r1);
        monitor-enter(r1);
        Iterator<T> r8 = r1.iterator();     // Catch: Throwable -> L46
    L29:
        if (r8.hasNext() == false) goto L38;
        Object r9 = r8.next();     // Catch: Throwable -> L46
        Pair r11 = (Pair) r9;     // Catch: Throwable -> L46
        if (((a) r11.getFirst()).a == r10.a) goto L33;
    L35:
        boolean r12 = false;
    L36:
        if (r12 == false) goto L29;
        r3 = r9;
        goto L38
    L33:
        if (Intrinsics.areEqual(((a) r11.getFirst()).b, r10.b) == false) goto L35;
        r12 = true;
    L38:
        Pair r13 = (Pair) r3;     // Catch: Throwable -> L46
        if (r13 != null) goto L42;
        monitor-exit(r1);
        return;
    L42:
        a += SystemClock.uptimeMillis() - Math.max(b, ((Number) r13.getSecond()).longValue());     // Catch: Throwable -> L46
        c.remove(r13);     // Catch: Throwable -> L46
        monitor-exit(r1);
        ILogDepend.a.d("PowerMonitor", "SensorMonitor onUnregister: listenerHashCode=" + r10.a + ", sensorHashCode=" + r10.b + ", sensorListenerTime=" + a);
        return;
    L46:
        th = move-exception;
        throw th;
    }
}
