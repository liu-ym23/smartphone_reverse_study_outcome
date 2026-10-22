package com.bytedance.android.livesdk.interactivity.zdanmaku.layout;

import com.bytedance.android.livesdk.interactivity.barrage.widget.CarnivalDanmakuWidget;
import com.bytedance.android.livesdk.interactivity.zdanmaku.attributes.DanmakuType;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class e extends com.bytedance.android.livesdk.interactivity.zdanmaku.a<com.bytedance.android.livesdk.interactivity.zdanmaku.i> {
    public q72.a a;
    public final uc2.f b;
    public final List<com.bytedance.android.livesdk.interactivity.zdanmaku.i> c;
    public final List<com.bytedance.android.livesdk.interactivity.zdanmaku.i> d;
    public int e;
    public int f;
    public final d g;

    public final boolean c() {
        return false;
    }

    @Override // com.bytedance.android.livesdk.interactivity.zdanmaku.a
    public final void a() {
        ((ArrayList) this.c).clear();
        ((ArrayList) this.d).clear();
    }

    public e(q72.a r3) {
        c r0 = c.a;
        Intrinsics.checkNotNullParameter(r3, "initialConfig");
        Intrinsics.checkNotNullParameter(r0, "linePriorityStrategy");
        super(r3);
        this.a = r3;
        this.b = new uc2.f(r3);
        this.c = new ArrayList();
        this.d = new ArrayList();
        this.e = 5;
        this.g = new d(this, r0);
    }

    @Override // com.bytedance.android.livesdk.interactivity.zdanmaku.a
    public final void d(q72.a r2) {
        Intrinsics.checkNotNullParameter(r2, "newConfig");
        this.a = r2;
        this.b.e(r2);
        this.f = 0;
    }

    @Override // com.bytedance.android.livesdk.interactivity.zdanmaku.a
    public final void e(int r1) {
        this.e = r1;
    }

    public final void b(vk6.e r8, float r9, Function0 r10) {
        Intrinsics.checkNotNullParameter(r8, "runningDanmakuList");
        Intrinsics.checkNotNullParameter(r10, "nextPreparedDanmakuSupplier");
        q72.a r0 = this.a;
        int r1 = r0.b;
        int r2 = r0.c;
        vk6.e.a r3 = r8.iterator();
    L3:
        vk6.e.a r4 = r3;
        if (r4.hasNext() == false) goto L14;
        com.bytedance.android.livesdk.interactivity.zdanmaku.i r5 = (com.bytedance.android.livesdk.interactivity.zdanmaku.i) r4.next();
        if (this.a.g == false) goto L8;
        if (r5.a() <= r1) goto L13;
        r4.remove();
    L13:
        r5.m(r9, this.a.g);
        this.b.f(r5.f, r5);
        goto L3
    L8:
        if (r5.c() >= 0) goto L13;
        r4.remove();
        goto L3
    L14:
        uc2.f r11 = this.b;
        d r6 = this.g;
        r6.a = r1;
        r6.b = this.a.a;
        Unit r7 = Unit.INSTANCE;
        Iterator<Integer> r13 = r11.a(r6).iterator();
    L16:
        if (r13.hasNext() == false) goto L47;
        int r14 = r13.next().intValue();
        boolean r15 = true;
        if ((this.a.d * r14) > r2) goto L46;
        com.bytedance.android.livesdk.interactivity.zdanmaku.i r16 = (com.bytedance.android.livesdk.interactivity.zdanmaku.i) r10.invoke();
        if (r16 == null) goto L46;
        if (r16.getType() != DanmakuType.CarnivalEgg) goto L26;
        ((ArrayList) this.c).add(r16);
    L28:
        if (CarnivalDanmakuWidget.A == false) goto L43;
        if (this.f < this.e) goto L43;
        if (((ArrayList) this.c).size() <= 0) goto L45;
        com.bytedance.android.livesdk.interactivity.zdanmaku.i r17 = (com.bytedance.android.livesdk.interactivity.zdanmaku.i) ListProtector.remove(this.c, 0);
        tc2.f r18 = (tc2.f) r16.b().e(tc2.f.class);
        if (r18 == null) goto L36;
        Boolean r19 = r18.c;
    L38:
        if (Intrinsics.areEqual(r19, Boolean.TRUE) == false) goto L40;
        uc2.f r20 = this.b;
        r20.d(r20.a.size() - 1, r17);
    L41:
        r8.add(r17);
        this.f = 0;
        goto L45
    L40:
        this.b.d(r14, r17);
        goto L41
    L36:
        r19 = null;
    L45:
        r15 = false;
    L43:
        if (((ArrayList) this.d).size() <= 0) goto L45;
        com.bytedance.android.livesdk.interactivity.zdanmaku.i r21 = (com.bytedance.android.livesdk.interactivity.zdanmaku.i) ListProtector.remove(this.d, 0);
        this.b.d(r14, r21);
        r8.add(r21);
        this.f++;
        goto L45
    L26:
        ((ArrayList) this.d).add(r16);
    L46:
        if (r15 == false) goto L16;
        return;
    }
}
