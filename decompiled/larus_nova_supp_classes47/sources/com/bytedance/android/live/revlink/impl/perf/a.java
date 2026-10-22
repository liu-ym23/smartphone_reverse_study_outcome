package com.bytedance.android.live.revlink.impl.perf;

import com.bytedance.android.live.revlink.api.service.IDegradeTask;
import com.bytedance.android.live.revlink.api.service.ILinkDegradeManager;
import com.bytedance.android.live.revlink.impl.utils.z;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class a implements ILinkDegradeManager {
    public long a;
    public long b;
    public boolean c;
    public long d;
    public long e;
    public final boolean f;
    public final boolean g;
    public final ConcurrentHashMap<Integer, IDegradeTask> h;

    /* JADX INFO: renamed from: com.bytedance.android.live.revlink.impl.perf.a$a, reason: collision with other inner class name */
    public static final class C0153a {
    }

    static {
    }

    public final void m() {
        this.c = true;
        this.a = -1;
        this.b = -1;
        if (this.d >= 0) goto L5;
        this.d = System.currentTimeMillis();
        this.e = -1;
    L5:
        ConcurrentHashMap<Integer, IDegradeTask> r0 = this.h;
        if (r0 == null) goto L17;
        Iterator<Map.Entry<Integer, IDegradeTask>> r1 = r0.entrySet().iterator();
    L9:
        if (r1.hasNext() == false) goto L26;
        Map.Entry<Integer, IDegradeTask> r2 = r1.next();
        IDegradeTask r3 = r2.getValue();     // Catch: Exception -> L15
        if (r3 == null) goto L9;
        r3.onDegrade();     // Catch: Exception -> L15
    L15:
        e = move-exception;
        jy0.b.c("LinkDegradeManager", "trigger degrade error：type = " + r2.getKey().intValue() + "; message = " + e.getMessage(), null, 4);
        goto L9
    L26:
        return;
    }

    public static boolean j() {
        int r0 = vh6.c.b(com.bytedance.android.livesdk.revenue.service.performance.d.class).getCurrentPerformanceLevel();
        if (r0 != 1) goto L5;
        return true;
    L5:
        if (r0 != 2) goto L7;
        return true;
    L7:
        if (r0 != 3) goto L9;
        return true;
    L9:
        if (r0 != 4) goto L11;
        return true;
    L11:
        if (r0 == 5) goto L19;
        return false;
    L19:
        return true;
    }

    @Override // com.bytedance.android.live.revlink.api.service.ILinkDegradeManager
    public final void d() {
        IDegradeTask r0 = this.h.remove(1);
        if (r0 == null) goto L6;
        r0.onClear();
        return;
    }

    public a() {
        this.a = -1;
        this.b = -1;
        this.d = -1;
        this.e = -1;
        com.bytedance.android.live.revlink.impl.settings.live.b r0 = com.bytedance.android.live.revlink.impl.settings.live.b.p;
        if (r0.b().V6() == true) goto L5;
    L7:
        boolean r1 = false;
    L8:
        this.f = r1;
        this.g = r11.f.a(r0.b());
        this.h = new ConcurrentHashMap();
        return;
    L5:
        if (r0.b().b3() == false) goto L7;
        r1 = true;
        goto L8
    }

    public static long k(int r5) {
        r11.e r0 = com.bytedance.android.live.revlink.impl.settings.live.b.p.b();
        Long r4 = null;
        if (r5 != 1) goto L5;
        if (r0 == null) goto L18;
        r11.e.c r6 = r0.c9();
        if (r6 == null) goto L18;
        r4 = Long.valueOf(r6.p());
    L18:
        long r1 = r4.longValue();
        if (r1 > 0) goto L24;
    L21:
        return 30000;
    L24:
        return r1;
    L5:
        if (r5 != 2) goto L21;
        if (r0 == null) goto L11;
        r11.e.c r7 = r0.c9();
        if (r7 == null) goto L11;
        r4 = Long.valueOf(r7.y7());
    L11:
        long r2 = r4.longValue();
        if (r2 <= 0) goto L21;
        return r2;
    }

    @Override // com.bytedance.android.live.revlink.api.service.ILinkDegradeManager
    public final void c(LinkRtcDegradeTask r3) {
        Intrinsics.checkNotNullParameter(r3, "degradeTask");
        this.h.put(1, r3);
    }

    public final void f(String r4) {
        Intrinsics.checkNotNullParameter(r4, "source");
        if (this.c == true) goto L6;
        m();
        z.e(-1, null, 1, r4);
        return;
    }

    public static boolean l(double r3, boolean r5) {
        if (r5 == true) goto L8;
        float r6 = com.bytedance.android.live.revlink.impl.settings.live.b.p.b().W();
        if (Float.compare(r6, 0) > 0) goto L13;
        r6 = 50.0f;
    L13:
        if (Double.compare(r3, r6) >= 0) goto L16;
        return true;
    L16:
        return false;
    L8:
        r6 = com.bytedance.android.live.revlink.impl.settings.live.b.p.b().B1();
        if (Float.compare(r6, 0) > 0) goto L13;
        r6 = 10.0f;
        goto L13
    }
}
