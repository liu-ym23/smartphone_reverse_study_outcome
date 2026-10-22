package com.bytedance.android.livesdk.interactivity.zdanmaku.simplewidget;

import java.util.Iterator;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import p22.n;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class h implements rk6.a<com.bytedance.android.livesdk.interactivity.zdanmaku.i> {
    public final g a;
    public n b;

    public final boolean c() {
        return false;
    }

    public final void a() {
        Iterator<uc2.b> r0 = this.a.a.iterator();
    L4:
        if (r0.hasNext() == false) goto L6;
        r0.next().c = null;
        goto L4
    }

    public h(n r2) {
        Intrinsics.checkNotNullParameter(r2, "danmakuConfig");
        this.b = r2;
        this.a = new g(r2);
    }

    public final void b(vk6.e r10, float r11, Function0 r13) {
        Intrinsics.checkNotNullParameter(r10, "runningDanmakuList");
        Intrinsics.checkNotNullParameter(r13, "nextPreparedDanmakuSupplier");
        vk6.e.a r0 = r10.iterator();
    L3:
        vk6.e.a r1 = r0;
        if (r1.hasNext() == false) goto L17;
        com.bytedance.android.livesdk.interactivity.zdanmaku.i r2 = (com.bytedance.android.livesdk.interactivity.zdanmaku.i) r1.next();
        if (r2.c() < 0) goto L7;
        r2.d((-r11) * this.b.g, 0.0f);
        this.a.getClass();
        g.a(r2);
        goto L3
    L7:
        r1.remove();
        this.a.getClass();
        Intrinsics.checkNotNullParameter(r2, "danmaku");
        uc2.b r3 = r2.e;
        if (r3 == null) goto L10;
        com.bytedance.android.livesdk.interactivity.zdanmaku.i r4 = r3.c;
    L12:
        if (Intrinsics.areEqual(r4, r2) == false) goto L3;
        uc2.b r5 = r2.e;
        if (r5 == null) goto L3;
        r5.c = null;
        goto L3
    L10:
        r4 = null;
        goto L12
    L17:
        g r14 = this.a;
        r14.b.clear();
        Iterator<uc2.b> r6 = r14.a.iterator();
    L19:
        if (r6.hasNext() == false) goto L28;
        uc2.b r7 = r6.next();
        if (r7.e == false) goto L19;
        com.bytedance.android.livesdk.interactivity.zdanmaku.i r8 = r7.c;
        if (r8 == null) goto L24;
        float r9 = r8.c();
        n r15 = r14.d;
        if ((r9 + r15.f) >= r15.b) goto L19;
        r14.b.add(Integer.valueOf(r7.d));
        goto L19
    L24:
        r14.b.add(Integer.valueOf(r7.d));
        goto L19
    L28:
        CollectionsKt.sortWith(r14.b, r14.c);
        Iterator<Integer> r16 = r14.b.iterator();
    L30:
        if (r16.hasNext() == false) goto L69;
        int r17 = r16.next().intValue();
        com.bytedance.android.livesdk.interactivity.zdanmaku.i r18 = (com.bytedance.android.livesdk.interactivity.zdanmaku.i) r13.invoke();
        if (r18 != null) goto L34;
        boolean r19 = true;
    L42:
        if (r19 == false) goto L30;
        return;
    L34:
        g r20 = this.a;
        r20.getClass();
        Intrinsics.checkNotNullParameter(r18, "danmaku");
        uc2.b r21 = (uc2.b) CollectionsKt.getOrNull(r20.a, r17);
        if (r21 != null) goto L37;
    L40:
        i.b("targetLine is null or !enable");
    L41:
        r10.add(r18);
        r19 = false;
        goto L42
    L37:
        if (r21.e == false) goto L40;
        n r23 = r20.d;
        r18.e(r23.b, r17 * (r23.d + r23.e));
        r18.f = r17;
        r18.e = r21;
        g.a(r18);
        goto L41
    }
}
