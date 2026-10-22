package com.bytedance.android.livesdk.interactivity.zdanmaku.layout;

import com.bytedance.android.live.core.utils.v;
import com.bytedance.android.livesdk.interactivity.api.publicscreen.topcontainer.test.CarnivalAutoTestUtil;
import com.bytedance.android.livesdk.interactivity.barrage.widget.CarnivalDanmakuWidget;
import com.bytedance.android.livesdk.interactivity.common.utils.LimitQueue;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class j extends com.bytedance.android.livesdk.interactivity.zdanmaku.a<com.bytedance.android.livesdk.interactivity.zdanmaku.i> {
    public q72.a a;
    public final uc2.f b;
    public final Queue<com.bytedance.android.livesdk.interactivity.zdanmaku.i> c;
    public final Queue<com.bytedance.android.livesdk.interactivity.zdanmaku.i> d;
    public final Queue<com.bytedance.android.livesdk.interactivity.zdanmaku.i> e;
    public final Queue<com.bytedance.android.livesdk.interactivity.zdanmaku.i> f;
    public int g;
    public int h;
    public final h i;

    public final boolean c() {
        return false;
    }

    @Override // com.bytedance.android.livesdk.interactivity.zdanmaku.a
    public final void a() {
        this.c.clear();
        this.d.clear();
        this.e.clear();
        ((PriorityQueue) this.f).clear();
    }

    public j(q72.a r3) {
        c r0 = c.a;
        Intrinsics.checkNotNullParameter(r3, "initialConfig");
        Intrinsics.checkNotNullParameter(r0, "linePriorityStrategy");
        super(r3);
        this.a = r3;
        fc2.a r1 = (fc2.a) ec2.k.a.getValue();
        this.b = new uc2.f(r3);
        if (r1.controlEnable.booleanValue() == false) goto L5;
        Queue<com.bytedance.android.livesdk.interactivity.zdanmaku.i> r4 = new LimitQueue(r1.eggPendingListThreshold);
    L6:
        this.c = r4;
        if (r1.controlEnable.booleanValue() == false) goto L9;
        Queue<com.bytedance.android.livesdk.interactivity.zdanmaku.i> r5 = new LimitQueue(r1.eggPendingListThreshold);
    L10:
        this.d = r5;
        if (r1.controlEnable.booleanValue() == false) goto L13;
        Queue<com.bytedance.android.livesdk.interactivity.zdanmaku.i> r6 = new LimitQueue(r1.danmakuPendingListThreshold);
    L14:
        this.e = r6;
        this.f = new PriorityQueue(16, i.a);
        this.g = 5;
        this.i = new h(this);
        com.bytedance.android.livesdk.interactivity.utils.e r7 = com.bytedance.android.livesdk.interactivity.utils.e.f;
        Function1<com.bytedance.android.livesdk.interactivity.utils.e, Unit> r2 = new LinearCarnivalDanmakuLayoutManager$1(this);
        r7.getClass();
        Intrinsics.checkNotNullParameter(r2, "action");
        if (((Boolean) ec2.l.a.getValue()).booleanValue() == false) goto L18;
        r2.invoke(r7);
        return;
    L18:
        return;
    L13:
        r6 = new LinkedList();
        goto L14
    L9:
        r5 = new LinkedList();
        goto L10
    L5:
        r4 = new LinkedList();
        goto L6
    }

    @Override // com.bytedance.android.livesdk.interactivity.zdanmaku.a
    public final void d(q72.a r2) {
        Intrinsics.checkNotNullParameter(r2, "newConfig");
        this.a = r2;
        this.b.e(r2);
        this.h = 0;
    }

    @Override // com.bytedance.android.livesdk.interactivity.zdanmaku.a
    public final void e(int r1) {
        this.g = r1;
    }

    public final void b(vk6.e r10, float r11, Function0 r13) {
        Intrinsics.checkNotNullParameter(r10, "runningDanmakuList");
        Intrinsics.checkNotNullParameter(r13, "nextPreparedDanmakuSupplier");
        q72.a r0 = this.a;
        int r1 = r0.b;
        int r2 = r0.c;
        vk6.e.a r3 = r10.iterator();
    L3:
        vk6.e.a r4 = r3;
        if (r4.hasNext() == false) goto L30;
        com.bytedance.android.livesdk.interactivity.zdanmaku.i r5 = (com.bytedance.android.livesdk.interactivity.zdanmaku.i) r4.next();
        if (this.a.g == false) goto L8;
        if (r5.a() <= r1) goto L29;
        r4.remove();
        Intrinsics.checkNotNullParameter(r5, "danmaku");
        uc2.b r6 = r5.e;
        if (r6 == null) goto L23;
        com.bytedance.android.livesdk.interactivity.zdanmaku.i r7 = r6.c;
    L25:
        if (Intrinsics.areEqual(r7, r5) == false) goto L3;
        uc2.b r8 = r5.e;
        if (r8 == null) goto L3;
        r8.c = null;
        goto L3
    L23:
        r7 = null;
    L29:
        r5.m(r11, this.a.g);
        this.b.f(r5.f, r5);
        goto L3
    L8:
        if (r5.c() >= 0) goto L29;
        r4.remove();
        Intrinsics.checkNotNullParameter(r5, "danmaku");
        uc2.b r9 = r5.e;
        if (r9 == null) goto L12;
        com.bytedance.android.livesdk.interactivity.zdanmaku.i r14 = r9.c;
    L14:
        if (Intrinsics.areEqual(r14, r5) == false) goto L3;
        uc2.b r15 = r5.e;
        if (r15 == null) goto L3;
        r15.c = null;
        goto L3
    L12:
        r14 = null;
        goto L14
    L30:
        Iterator<Integer> r16 = this.b.a(this.i).iterator();
    L32:
        if (r16.hasNext() == false) goto L94;
        int r17 = r16.next().intValue();
        boolean r18 = true;
        if ((this.a.d * r17) > r2) goto L93;
        if (r17 == 0) goto L38;
        com.bytedance.android.livesdk.interactivity.zdanmaku.i r19 = (com.bytedance.android.livesdk.interactivity.zdanmaku.i) r13.invoke();
    L42:
        if (r19 == null) goto L60;
        int r20 = g.a[r19.getType().ordinal()];
        if (r20 != 1) goto L46;
        this.d.add(r19);
        goto L60
    L46:
        if (r20 == 2) goto L57;
        tc2.f r21 = (tc2.f) r19.b().e(tc2.f.class);
        if (r21 == null) goto L50;
        Integer r23 = r21.d;
    L51:
        if (r23 != null) goto L54;
    L56:
        this.e.add(r19);
        goto L60
    L54:
        if (r23.intValue() != 0) goto L56;
        ((PriorityQueue) this.f).add(r19);
        goto L60
    L50:
        r23 = null;
        goto L51
    L57:
        this.c.add(r19);
    L60:
        if (CarnivalDanmakuWidget.A == false) goto L79;
        if (this.h < this.g) goto L79;
        if ((!this.c.isEmpty()) == false) goto L66;
        Queue<com.bytedance.android.livesdk.interactivity.zdanmaku.i> r24 = this.c;
    L68:
        if (r24.size() <= 0) goto L92;
        com.bytedance.android.livesdk.interactivity.zdanmaku.i r25 = r24.remove();
        tc2.f r26 = (tc2.f) r25.b().e(tc2.f.class);
        if (r26 == null) goto L72;
        Boolean r27 = r26.c;
    L74:
        if (Intrinsics.areEqual(r27, Boolean.TRUE) == false) goto L76;
        uc2.f r28 = this.b;
        r28.d(r28.a.size() - 1, r25);
    L77:
        r10.add(r25);
        this.h = 0;
    L86:
        if (this.e.isEmpty() == false) goto L92;
        if (this.f.isEmpty() == false) goto L92;
        if (this.d.isEmpty() == false) goto L92;
    L76:
        this.b.d(r17, r25);
        goto L77
    L72:
        r27 = null;
    L92:
        r18 = false;
        goto L93
    L66:
        r24 = this.d;
    L79:
        if (this.e.size() <= 0) goto L92;
        com.bytedance.android.livesdk.interactivity.zdanmaku.i r29 = this.e.remove();
        this.b.d(r17, r29);
        r10.add(r29);
        this.h++;
        com.bytedance.android.livesdk.interactivity.utils.e.f.getClass();
        com.bytedance.android.livesdk.interactivity.utils.e.b++;
        if (v.a() == false) goto L86;
        if (CarnivalAutoTestUtil.a == false) goto L86;
        CarnivalAutoTestUtil.a();
        goto L86
    L38:
        if ((!this.f.isEmpty()) == false) goto L40;
        com.bytedance.android.livesdk.interactivity.zdanmaku.i r30 = this.f.remove();
        com.bytedance.android.livesdk.interactivity.utils.e.f.getClass();
        com.bytedance.android.livesdk.interactivity.utils.e.b++;
        this.b.d(r17, r30);
        r10.add(r30);
        this.h++;
        goto L92
    L40:
        r19 = (com.bytedance.android.livesdk.interactivity.zdanmaku.i) r13.invoke();
    L93:
        if (r18 == false) goto L32;
        return;
    }
}
