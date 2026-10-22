package com.lynx.animax.player;

import android.os.Process;
import android.os.SystemClock;
import com.lynx.tasm.utils.k;
import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.jvm.internal.StringCompanionObject;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public class e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public long f9665a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public long f9666b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Object f9667c;

    public e(b r5) {
        this.f9665a = 0;
        this.f9666b = 0;
        this.f9667c = r5;
    }

    public synchronized Object a(Object r5) {
        monitor-enter(this);
        Object r10 = ((LinkedHashMap) this.f9667c).get(r5);     // Catch: Throwable -> L8
        monitor-exit(this);
        return r10;
    L8:
        th = move-exception;
        throw th;
    }

    public int b(Object r5) {
        return 1;
    }

    public void c(String r11) {
        Intrinsics.checkNotNullParameter(r11, "scene");
        if (this.f9665a != 0) goto L5;
        return;
    L5:
        if (this.f9666b == 0) goto L17;
        long r5 = Process.getElapsedCpuTime();
        long r10 = SystemClock.uptimeMillis();
        long r12 = r5 - this.f9665a;
        long r13 = r10 - this.f9666b;
        this.f9665a = 0;
        this.f9666b = 0;
        if (r13 <= 0) goto L15;
        float r14 = (r12 / r13) * 100.0f;
        StringCompanionObject r15 = StringCompanionObject.INSTANCE;
        StringBuilder r16 = androidx.constraintlayout.motion.widget.a.y("[", r11, "] CPU Usage: ", String.format("%.2f", Arrays.copyOf(new Object[]{Float.valueOf(r14)}, 1)), "% (CPU Time: ");
        r16.append(r12);
        r16.append("ms, Real Time: ");
        r16.append(r13);
        r16.append("ms)");
        String r17 = r16.toString();
        Intrinsics.checkNotNullParameter("APM_ResourceMonitor", "tag");
        Intrinsics.checkNotNullParameter(r17, "msg");
        org.koin.core.a r18 = su.a.f22013b;
        if (r18 == null) goto L13;
        ((ju.b) r18.f20999a.d.b(null, Reflection.getOrCreateKotlinClass(ju.b.class), null)).i("APM_ResourceMonitor", r17);
        JSONObject r19 = new JSONObject();
        r19.put("scene", r11);
        r19.put("cpu_usage_percent", Float.valueOf(r14));
        r19.put("cpu_time_ms", r12);
        r19.put("real_time_ms", r13);
        r19.put("metric_type", "cpu");
        k.r().a("apm_stat", r19);
        return;
    L13:
        throw new IllegalStateException("KoinApplication has not been started");
    L15:
        return;
    }

    public void d(Object r5, Object r10) {
    }

    public synchronized Object e(Object r10, Object r11) {
        monitor-enter(this);
        long r5 = b(r11);     // Catch: Throwable -> L9
        if (r5 < this.f9665a) goto L11;
        d(r10, r11);     // Catch: Throwable -> L9
        monitor-exit(this);
        return null;
    L11:
        if (r11 == null) goto L13;
        this.f9666b += r5;     // Catch: Throwable -> L9
    L13:
        Object r12 = ((LinkedHashMap) this.f9667c).put(r10, r11);     // Catch: Throwable -> L9
        if (r12 == null) goto L18;
        this.f9666b -= (long) b(r12);     // Catch: Throwable -> L9
        if (r12.equals(r11) == true) goto L18;
        d(r10, r12);     // Catch: Throwable -> L9
    L18:
        f(this.f9665a);     // Catch: Throwable -> L9
        monitor-exit(this);
        return r12;
    L9:
        th = move-exception;
        throw th;
    }

    public synchronized void f(long r10) {
        monitor-enter(this);
    L13:
    L7:
        th = move-exception;
        throw th;
    L4:
        if (this.f9666b <= r10) goto L9;
        Iterator r5 = ((LinkedHashMap) this.f9667c).entrySet().iterator();     // Catch: Throwable -> L7
        Map.Entry r11 = (Map.Entry) r5.next();     // Catch: Throwable -> L7
        Object r12 = r11.getValue();     // Catch: Throwable -> L7
        this.f9666b -= (long) b(r12);     // Catch: Throwable -> L7
        Object r13 = r11.getKey();     // Catch: Throwable -> L7
        r5.remove();     // Catch: Throwable -> L7
        d(r13, r12);     // Catch: Throwable -> L7
        goto L13
    L9:
        monitor-exit(this);
    }

    public e(kotlinx.coroutines.internal.c r5) {
        Intrinsics.checkNotNullParameter(r5, "scope");
        this.f9667c = r5;
    }

    public e(long r5) {
        this.f9667c = new LinkedHashMap(100, 0.75f, true);
        this.f9665a = r5;
    }
}
