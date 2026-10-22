package jna;

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
    public static final List<Pair<String, Long>> c = null;

    static {
        c = Collections.synchronizedList(new ArrayList());
    }

    public static long c() {
        List<Pair<String, Long>> r0 = c;
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
    public static final void a(String r11) {
        Intrinsics.checkNotNullParameter(r11, "cameraId");
        List<Pair<String, Long>> r0 = c;
        Intrinsics.checkNotNull(r0);
        monitor-enter(r0);
        Iterator<T> r1 = r0.iterator();     // Catch: Throwable -> L19
    L6:
        if (r1.hasNext() == false) goto L10;
        Object r2 = r1.next();     // Catch: Throwable -> L19
        if (Intrinsics.areEqual(((Pair) r2).getFirst(), r11) == false) goto L6;
    L11:
        Pair r3 = (Pair) r2;     // Catch: Throwable -> L19
        if (r3 != null) goto L15;
        monitor-exit(r0);
        return;
    L15:
        a += SystemClock.uptimeMillis() - Math.max(b, ((Number) r3.getSecond()).longValue());     // Catch: Throwable -> L19
        c.remove(r3);     // Catch: Throwable -> L19
        monitor-exit(r0);
        ILogDepend.a.d("PowerMonitor", "CameraMonitor onClose: " + r11 + ", cameraOpenTime: " + a);
        return;
    L10:
        r2 = null;
    L19:
        th = move-exception;
        throw th;
    }

    @JvmStatic
    public static final void b(String r4) {
        Intrinsics.checkNotNullParameter(r4, "cameraId");
        List<Pair<String, Long>> r0 = c;
        Intrinsics.checkNotNull(r0);
        List<Pair<String, Long>> r1 = r0;
        ArrayList r2 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r1, 10));
        Iterator<T> r3 = r1.iterator();
    L4:
        if (r3.hasNext() == false) goto L7;
        r2.add((String) ((Pair) r3.next()).getFirst());
        goto L4
    L7:
        if (r2.contains(r4) == false) goto L9;
        return;
    L9:
        c.add(new Pair(r4, Long.valueOf(SystemClock.uptimeMillis())));
        ILogDepend.a.d("PowerMonitor", "CameraMonitor onOpen: " + r4);
    }
}
