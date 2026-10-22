package y8;

import android.app.ActivityManager;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.SystemClock;
import com.bytedance.android.annie.Annie;
import com.bytedance.android.annie.util.n;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Pair;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public final class a {
    public static final a a = null;
    public static final Map<String, Pair<Long, Object>> b = null;

    public a() {
    }

    public final synchronized Object b() {
        monitor-enter(this);
        long r0 = SystemClock.elapsedRealtime();     // Catch: Throwable -> L13
        Map<String, Pair<Long, Object>> r10 = b;     // Catch: Throwable -> L13
        if (r10.containsKey("network_time") == false) goto L10;
        Object r11 = ((LinkedHashMap) r10).get("network_time");     // Catch: Throwable -> L13
        Intrinsics.checkNotNull(r11);     // Catch: Throwable -> L13
        if ((r0 - ((Number) ((Pair) r11).getFirst()).longValue()) >= 5000) goto L10;
        Object r1 = ((LinkedHashMap) r10).get("network_time");     // Catch: Throwable -> L13
        Intrinsics.checkNotNull(r1);     // Catch: Throwable -> L13
        Object r12 = ((Pair) r1).getSecond();     // Catch: Throwable -> L13
        monitor-exit(this);
        return r12;
    L10:
        int r13 = ((c) Annie.getService$default(c.class, null, 2, null)).getEffectiveConnectionType();     // Catch: Throwable -> L13
        r10.put("network_time", new Pair(Long.valueOf(r0), Integer.valueOf(r13)));     // Catch: Throwable -> L13
        Integer r14 = Integer.valueOf(r13);     // Catch: Throwable -> L13
        monitor-exit(this);
        return r14;
    L13:
        th = move-exception;
        throw th;
    }

    static {
        a = new a();
        b = new LinkedHashMap();
    }

    public static float c() {
        float r0 = ((c) Annie.getService$default(c.class, null, 2, null)).getScreenFps();
        if (r0 >= 0) goto L6;
        return 60.0f;
    L6:
        return r0;
    }

    public final synchronized float a(Context r10) {
        monitor-enter(this);
        long r0 = SystemClock.elapsedRealtime();     // Catch: Throwable -> L20
        Map<String, Pair<Long, Object>> r11 = b;     // Catch: Throwable -> L20
        if (r11.containsKey("temperature") == false) goto L10;
        Object r12 = ((LinkedHashMap) r11).get("temperature");     // Catch: Throwable -> L20
        Intrinsics.checkNotNull(r12);     // Catch: Throwable -> L20
        if ((r0 - ((Number) ((Pair) r12).getFirst()).longValue()) >= 5000) goto L10;
        Object r13 = ((LinkedHashMap) r11).get("temperature");     // Catch: Throwable -> L20
        Intrinsics.checkNotNull(r13);     // Catch: Throwable -> L20
        Object r14 = ((Pair) r13).getSecond();     // Catch: Throwable -> L20
        Intrinsics.checkNotNull(r14, "null cannot be cast to non-null type kotlin.Float");     // Catch: Throwable -> L20
        float r15 = ((Float) r14).floatValue();     // Catch: Throwable -> L20
        monitor-exit(this);
        return r15;
    L10:
        int r16 = n.c;     // Catch: Throwable -> L20
        if (r10 == null) goto L16;
        Intent r17 = n.a(r10, new IntentFilter("android.intent.action.BATTERY_CHANGED"));     // Catch: Throwable -> L20
        if (r17 == null) goto L16;
        float r18 = r17.getIntExtra("temperature", -10) / 10.0f;     // Catch: Throwable -> L20
    L17:
        r11.put("temperature", new Pair(Long.valueOf(r0), Float.valueOf(r18)));     // Catch: Throwable -> L20
        monitor-exit(this);
        return r18;
    L16:
        r18 = -1.0f;
    L20:
        th = move-exception;
        throw th;
    }

    public final synchronized double d(Context r10) {
        monitor-enter(this);
        long r0 = SystemClock.elapsedRealtime();     // Catch: Throwable -> L22
        Map<String, Pair<Long, Object>> r11 = b;     // Catch: Throwable -> L22
        if (r11.containsKey("memory_info") == false) goto L10;
        Object r12 = ((LinkedHashMap) r11).get("memory_info");     // Catch: Throwable -> L22
        Intrinsics.checkNotNull(r12);     // Catch: Throwable -> L22
        if ((r0 - ((Number) ((Pair) r12).getFirst()).longValue()) >= 5000) goto L10;
        Object r13 = ((LinkedHashMap) r11).get("memory_info");     // Catch: Throwable -> L22
        Intrinsics.checkNotNull(r13);     // Catch: Throwable -> L22
        Object r14 = ((Pair) r13).getSecond();     // Catch: Throwable -> L22
        Intrinsics.checkNotNull(r14, "null cannot be cast to non-null type kotlin.Double");     // Catch: Throwable -> L22
        double r1 = ((Double) r14).doubleValue();     // Catch: Throwable -> L22
        monitor-exit(this);
        return r1;
    L10:
        int r15 = n.c;     // Catch: Throwable -> L22
        if (r10 == null) goto L15;
        Object r16 = r10.getSystemService(com.bytedance.android.ec.core.event.a.VALUE_ACTIVITY);     // Catch: Throwable -> L22
        if ((r16 instanceof ActivityManager) == false) goto L15;
        ActivityManager.MemoryInfo r17 = new ActivityManager.MemoryInfo();     // Catch: Throwable -> L22
        ((ActivityManager) r16).getMemoryInfo(r17);     // Catch: Throwable -> L22
        double r18 = (r17.availMem / 1024.0d) / 1024.0d;     // Catch: Throwable -> L22
    L17:
        if (r18 >= 0) goto L19;
        r18 = 1201.0d;
    L19:
        r11.put("memory_info", new Pair(Long.valueOf(r0), Double.valueOf(r18)));     // Catch: Throwable -> L22
        monitor-exit(this);
        return r18;
    L15:
        r18 = -1.0d;
    L22:
        th = move-exception;
        throw th;
    }
}
