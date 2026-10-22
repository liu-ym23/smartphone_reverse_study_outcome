package com.larus.avlink;

import android.os.SystemClock;
import com.larus.avlink.activeSummary.SoundPlayManager;
import com.larus.dora.api.IDoraService;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import java.util.Map;
import java.util.concurrent.atomic.AtomicLong;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes24.dex */
public final class q1 {
    public static final AtomicLong m = null;
    public final String a;
    public final long b;
    public final int c;
    public final long d;
    public volatile long e;
    public volatile long f;
    public volatile long g;
    public volatile long h;
    public volatile boolean i;
    public volatile int j;
    public volatile boolean k;
    public final b l;

    public static final class a {
    }

    public static final class b implements SoundPlayManager.c {
        public final /* synthetic */ q1 a;

        @Override // com.larus.avlink.activeSummary.SoundPlayManager.c
        public final void a() {
            q1 r0 = this.a;
            r0.g = SystemClock.elapsedRealtime();
        }

        @Override // com.larus.avlink.activeSummary.SoundPlayManager.c
        public final void onRenderStart() {
            q1 r0 = this.a;
            r0.h = SystemClock.elapsedRealtime();
            this.a.b("success");
        }

        public b(q1 r1) {
            this.a = r1;
        }

        @Override // com.larus.avlink.activeSummary.SoundPlayManager.c
        public final void b(int r2) {
            this.a.j = r2;
            this.a.b("error");
        }

        @Override // com.larus.avlink.activeSummary.SoundPlayManager.c
        public final void c(boolean r4) {
            q1 r0 = this.a;
            r0.f = SystemClock.elapsedRealtime();
            this.a.i = r4;
        }
    }

    public static long a(long r3, long r5) {
        if (r3 > 0) goto L5;
        return -1;
    L5:
        if (r5 > 0) goto L8;
        return -1;
    L8:
        return r5 - r3;
    }

    static {
        m = new AtomicLong(0);
    }

    public final void b(String r10) {
        if (this.k == false) goto L5;
        return;
    L5:
        this.k = true;
        long r3 = -1;
        if (Intrinsics.areEqual(r10, "success") == false) goto L8;
        long r5 = a(this.g, this.h);
    L9:
        Pair[] r2 = new Pair[5];
        r2[0] = TuplesKt.to("platform", "android");
        r2[1] = TuplesKt.to("status", r10);
        if (Intrinsics.areEqual(r10, "success") == false) goto L12;
        r3 = a(this.b, this.h);
    L12:
        r2[2] = TuplesKt.to("total", Long.valueOf(r3));
        r2[3] = TuplesKt.to("biz_cost", Long.valueOf(a(this.b, this.g)));
        r2[4] = TuplesKt.to("play_cost", Long.valueOf(r5));
        Map r0 = MapsKt.mutableMapOf(r2);
        r0.put("error_code", Integer.valueOf(this.j));
        long r1 = a(this.b, this.e);
        if (r1 < 0) goto L15;
        r0.put("schedule_cost", Long.valueOf(r1));
    L15:
        long r4 = a(this.e, this.f);
        if (r4 < 0) goto L18;
        r0.put("file_cost", Long.valueOf(r4));
    L18:
        long r6 = a(this.f, this.g);
        if (r6 < 0) goto L22;
        r0.put("setup_cost", Long.valueOf(r6));
    L22:
        if (this.f <= 0) goto L25;
        r0.put("is_cached", Integer.valueOf(this.i ? 1 : 0));
    L25:
        if (Intrinsics.areEqual(this.a, "dora_fuzzy_wake_sound_play_duration") == false) goto L27;
        r0.put("result", Integer.valueOf(this.c));
    L27:
        n1.d("WakeupSoundLatencyTrace", "report event=" + this.a + " traceId=" + this.d + " status=" + r10 + " params=" + r0);
        IDoraService r11 = (IDoraService) ServiceManager.get().getService(IDoraService.class);
        if (r11 == null) goto L31;
        r11.A0(this.a, r0);
        return;
    L31:
        return;
    L8:
        r5 = -1;
        goto L9
    }

    public q1(String r2, long r3, int r5) {
        Intrinsics.checkNotNullParameter(r2, "event");
        this.a = r2;
        this.b = r3;
        this.c = r5;
        this.d = m.incrementAndGet();
        this.e = -1;
        this.f = -1;
        this.g = -1;
        this.h = -1;
        this.j = -1;
        this.l = new b(this);
    }
}
