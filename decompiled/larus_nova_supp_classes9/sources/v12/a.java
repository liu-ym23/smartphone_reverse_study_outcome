package v12;

import com.bytedance.android.livesdk.revenue.log.LogCommon;
import com.bytedance.android.scope.o;
import cy0.j;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import mz0.i;
import mz0.m;
import mz0.n;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class a implements o {
    public long a;
    public final ConcurrentHashMap<String, Long> b;
    public final ConcurrentHashMap<String, Long> c;
    public final ConcurrentHashMap<String, Long> d;
    public final ConcurrentHashMap<String, Long> e;
    public final ConcurrentHashMap<String, Long> f;
    public final ConcurrentHashMap<String, Long> g;
    public final ConcurrentHashMap<String, Integer> h;
    public final ConcurrentHashMap<String, String> i;

    public final void onStart() {
    }

    public final void onStop() {
        this.b.clear();
        this.c.clear();
        this.d.clear();
        this.e.clear();
        this.f.clear();
        this.g.clear();
        this.a = 0;
    }

    public a() {
        this.a = 0;
        this.b = new ConcurrentHashMap();
        this.c = new ConcurrentHashMap();
        this.d = new ConcurrentHashMap();
        this.e = new ConcurrentHashMap();
        this.f = new ConcurrentHashMap();
        this.g = new ConcurrentHashMap();
        this.h = new ConcurrentHashMap();
        this.i = new ConcurrentHashMap();
    }

    public final void d(String r14) {
        if (r14 != null) goto L4;
        return;
    L4:
        i97.a r0 = i97.a.a;
        long r1 = System.currentTimeMillis();
        boolean r4 = false;
        Long r5 = null;
        if (((Boolean) b.b.getValue(null, b.a[0])).booleanValue() == false) goto L14;
        Long r2 = Long.valueOf(this.a);
        if (r2.longValue() <= 0) goto L10;
        r4 = true;
    L10:
        if (r4 == false) goto L12;
        r5 = r2;
    L12:
        Long r3 = this.b.get(r14);
        Long r6 = this.c.get(r14);
        Long r7 = this.d.get(r14);
        Long r8 = this.e.get(r14);
        Long r9 = this.f.get(r14);
        Long r10 = this.g.get(r14);
        String r11 = this.i.get(r14);
        Integer r15 = this.h.get(r14);
        Long r13 = a(r5, r3);
        Long r16 = a(r3, r6);
        Long r17 = a(r6, r7);
        Long r18 = a(r7, r9);
        Long r19 = a(r9, r10);
        Long r20 = a(r10, r7);
        Long r21 = a(r7, r8);
        Long r23 = a(r8, Long.valueOf(r1));
        Long r24 = a(r3, Long.valueOf(r1));
        n r25 = new n();
        mz0.o r26 = new mz0.o(r25.a);
        r26.a("start_send_gift", String.valueOf(r13));
        r26.a("send_callback", String.valueOf(r16));
        r26.a("before_queue", String.valueOf(r17));
        r26.a("effect_msg_dispatch", String.valueOf(r18));
        r26.a("download_callback", String.valueOf(r19));
        r26.a("effect_before_queue", String.valueOf(r20));
        r26.a("effect_queue_duration", String.valueOf(r21));
        r26.a("start_play", String.valueOf(r23));
        r26.a("send_all_time", String.valueOf(r24));
        r26.a("gift_id", String.valueOf(r11));
        r26.a("all_queue_size", String.valueOf(r15));
        m r110 = new m();
        r110.b(LogCommon.ROOM);
        r110.b(LogCommon.PAGE_SOURCE_LOG);
        List r27 = r25.b;
        ArrayList r28 = (ArrayList) r27;
        r28.addAll(r110.a);
        cy0.e.a.getClass();
        j r111 = cy0.e.a.a;
        com.bytedance.android.scope.m.e.getClass();
        Object r112 = com.bytedance.android.scope.m.b(r111).a(Reflection.getOrCreateKotlinClass(i.class));
        Intrinsics.checkNotNull(r112);
        ((f80.a) r112).w3("livesdk_rd_gift_send_time", r25.a, r25.b);
        return;
    }

    public static Long a(Long r4, Long r5) {
        if (r4 == null) goto L11;
        if (r5 == null) goto L11;
        Long r6 = Long.valueOf(r5.longValue() - r4.longValue());
        if (r6.longValue() <= 0) goto L8;
        boolean r7 = true;
    L9:
        if (r7 == false) goto L11;
        return r6;
    L8:
        r7 = false;
    L11:
        return null;
    }

    public final void c(String r3, boolean r4) {
        if (r3 != null) goto L4;
        return;
    L4:
        i97.a r0 = i97.a.a;
        long r1 = System.currentTimeMillis();
        if (r4 == false) goto L7;
        this.e.put(r3, Long.valueOf(r1));
        return;
    L7:
        this.f.put(r3, Long.valueOf(r1));
    }
}
