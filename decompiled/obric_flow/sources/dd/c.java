package dd;

import ai.y;
import android.app.ActivityManager;
import android.app.Application;
import android.content.ComponentName;
import android.util.Log;
import bolts.ExecutorException;
import com.bytedance.android.anniex.scene.core.i;
import com.bytedance.apm6.cpu.ApmCpuManager;
import com.bytedance.ies.bullet.core.e;
import com.bytedance.ies.bullet.core.f;
import com.bytedance.ies.bullet.core.h;
import java.util.HashMap;
import java.util.Iterator;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.Lazy;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes2.dex */
public abstract class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static long f16639a = -1;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final ConcurrentHashMap f16640b = null;

    static {
        f16640b = new ConcurrentHashMap();
    }

    public static HashMap a() {
        t6.a r5 = ApmCpuManager.getInstance().getCurrentCpuRate();
        HashMap r10 = new HashMap();
        r10.put("cpu_rate", Double.valueOf(r5.f22102a));
        r10.put("cpu_speed", Double.valueOf(r5.f22103b));
        return r10;
    }

    public static void b(String r10) {
        Intrinsics.checkNotNullParameter(r10, "sessionId");
        Lazy r5 = f.f5312b;
        e r11 = td.b.b().a(r10);
        String r12 = null;
        if (r11 == null) goto L7;
        com.bytedance.ies.bullet.core.c r13 = r11.f5308w;
        if (r13 == null) goto L7;
        z4.a r14 = r13.f5278i;
    L8:
        if (r14 != null) goto L11;
        r14 = null;
    L11:
        if (r14 == null) goto L44;
        AtomicBoolean r15 = (AtomicBoolean) r14.f23391c;
        if (r15 != null) goto L15;
    L17:
        Application r16 = h.g.f5316b;
        if (r16 == null) goto L20;
        Object r17 = r16.getSystemService("activity");
    L21:
        Intrinsics.checkNotNull(r17, "null cannot be cast to non-null type android.app.ActivityManager");
        ActivityManager.RunningTaskInfo r18 = ((ActivityManager) r17).getRunningTasks(1).get(0);     // Catch: Exception -> L24
    L26:
        long r19 = System.currentTimeMillis();
        if (r18 == null) goto L29;
        ComponentName r20 = r18.baseActivity;
    L30:
        if (r18 == null) goto L32;
        ComponentName r21 = r18.topActivity;
    L33:
        StringBuilder r22 = new StringBuilder();
        r22.append("time:" + r19 + ',');
        StringBuilder r23 = new StringBuilder("Running TaskInfo:topActivity=");
        if (r21 == null) goto L36;
        String r24 = r21.toShortString();
    L37:
        r23.append(r24);
        r23.append(",baseActivity=");
        if (r20 == null) goto L40;
        r12 = r20.toShortString();
    L40:
        r23.append(r12);
        r23.append(',');
        r22.append(r23.toString());
        String r25 = r22.toString();
        Intrinsics.checkNotNullParameter(r25, "<set-?>");
        r14.e = r25;
        return;
    L36:
        r24 = null;
        goto L37
    L32:
        r21 = null;
        goto L33
    L29:
        r20 = null;
    L24:
        e = move-exception;
        com.bytedance.ies.bullet.service.base.b.g("recordActivityInfo exception", "CpuMemoryHelper", e);
        r18 = null;
        goto L26
    L20:
        r17 = null;
        goto L21
    L15:
        if (r15.get() == true) goto L17;
        return;
    L44:
        return;
    L7:
        r14 = null;
        goto L8
    }

    public static void c(String r10, String r11) {
        int r5 = 0;
        int r12 = 1;
        Intrinsics.checkNotNullParameter(r10, "sessionId");
        Intrinsics.checkNotNullParameter(r11, "stepName");
        Lazy r13 = f.f5312b;
        e r14 = td.b.b().a(r10);
        if (r14 != null) goto L5;
    L8:
        z4.a r15 = null;
        if (r14 == null) goto L13;
        com.bytedance.ies.bullet.core.c r16 = r14.f5308w;
        if (r16 == null) goto L13;
        z4.a r17 = r16.f5278i;
    L14:
        if (r17 == null) goto L16;
        r15 = r17;
    L16:
        if (r15 == null) goto L58;
        AtomicBoolean r18 = (AtomicBoolean) r15.f23391c;
        if (r18 != null) goto L20;
    L22:
        long r19 = f16639a;
        if (r19 == (-1)) goto L26;
        r15.c(r19, r10, "memory_warning");
    L26:
        if (Intrinsics.areEqual(r11, "view_load_cancel") == false) goto L49;
        h.f r20 = h.f.b(new a(r15, r10, r11, r5), h.f.g);
        b r21 = new b(r14, r5);
        r20.getClass();
        y r22 = h.f.f17262h;
        b r23 = new b(r21, r12);
        k6.a r24 = new k6.a(8);
        Object r25 = r20.f17267a;
        monitor-enter(r25);
        Object r26 = r20.f17267a;     // Catch: Throwable -> L35
        monitor-enter(r26);     // Catch: Throwable -> L35
        boolean r27 = r20.f17268b;     // Catch: Throwable -> L44
        monitor-exit(r26);     // Catch: Throwable -> L44
        if (r27 == true) goto L37;
        r20.f.add(new h.e(r24, r23, r22, r12));     // Catch: Throwable -> L35
    L37:
        monitor-exit(r25);     // Catch: Throwable -> L35
        if (r27 == false) goto L56;
        r22.execute(new i(r24, 18, r23, r20));     // Catch: Exception -> L41
        return;
    L41:
        e = move-exception;
        r24.h(new ExecutorException(e));
        return;
    L56:
        return;
    L44:
        th = move-exception;
        throw th;     // Catch: Throwable -> L35
    L35:
        th = move-exception;
        throw th;
    L49:
        h.f.b(new a(r15, r11, r10, r12), h.f.g);
        return;
    L20:
        if (r18.get() == true) goto L22;
        return;
    L58:
        return;
    L13:
        r17 = null;
        goto L14
    L5:
        if (r14.B != true) goto L8;
        Log.d("CpuMemoryHelper", "useCodeMode is true. Ignore recordCpuMemory");
    }

    public static boolean d(String r5, boolean r10) {
        Intrinsics.checkNotNullParameter(r5, "userInterActiveKey");
        ConcurrentHashMap r11 = f16640b;
        if (r10 == false) goto L18;
        Iterator r12 = r11.keySet().iterator();
    L6:
        if (r12.hasNext() == false) goto L15;
        String r13 = (String) r12.next();
        ScheduledExecutorService r14 = (ScheduledExecutorService) r11.get(r5);
        if (r14 == null) goto L12;
        if (r14.isShutdown() == true) goto L6;
    L12:
        ScheduledExecutorService r15 = (ScheduledExecutorService) r11.get(r13);
        if (r15 == null) goto L6;
        r15.shutdownNow();
        goto L6
    L15:
        r11.clear();
        return true;
    L18:
        if (r11.get(r5) != null) goto L21;
        return false;
    L21:
        ScheduledExecutorService r16 = (ScheduledExecutorService) r11.get(r5);
        if (r16 != null) goto L24;
    L26:
        ScheduledExecutorService r17 = (ScheduledExecutorService) r11.get(r5);
        if (r17 == null) goto L29;
        r17.shutdownNow();
    L29:
        r11.remove(r5);
    L30:
        return true;
    L24:
        if (r16.isShutdown() != true) goto L26;
        goto L26
    }

    public static HashMap e() {
        HashMap r5 = new HashMap();
        long r10 = Runtime.getRuntime().totalMemory();
        long r11 = Runtime.getRuntime().freeMemory();
        long r12 = 1024;
        r5.put("mem_java_total", Long.valueOf(r10 / r12));
        r5.put("mem_java_free", Long.valueOf(r11 / r12));
        r5.put("mem_java_used", Long.valueOf((r10 - r11) / r12));
        return r5;
    }
}
