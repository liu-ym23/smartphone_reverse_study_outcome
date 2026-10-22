package com.bytedance.android.live.profit.privilege.datalayer;

import com.bytedance.android.live.profit.privilege.model.danmu.DanmakuTabList;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import io.reactivex.functions.Consumer;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class i<T> implements Consumer {
    public final /* synthetic */ d a;
    public final /* synthetic */ long b;

    public i(d r1, long r2) {
        this.a = r1;
        this.b = r2;
    }

    public final void accept(Object r19) {
        com.bytedance.android.live.profit.privilege.model.danmu.a r1 = (com.bytedance.android.live.profit.privilege.model.danmu.a) r19;
        com.bytedance.live.kmp.util.c r2 = com.bytedance.live.kmp.util.c.a;
        long r3 = System.currentTimeMillis() - this.b;
        com.bytedance.android.live.profit.privilege.e r4 = com.bytedance.android.live.profit.privilege.e.a;
        String r5 = this.a.f();
        long r6 = this.a.d();
        Intrinsics.checkNotNullParameter(r5, "userId");
        com.bytedance.android.live.profit.privilege.e.p("ttlive_privilege_danmaku_tab_status_all", com.bytedance.android.live.profit.privilege.e.k(true, null, null), com.bytedance.android.live.profit.privilege.e.n(Long.valueOf(r3)), com.bytedance.android.live.profit.privilege.e.m(r4, Long.valueOf(r6), 4));
        if (r1 != null) goto L5;
    L17:
        this.a.b.setValue(new DanmakuTabList(null, true, false, 0, (int) r1.getShadowType(), null, 45, null));
        return;
    L5:
        if ((!r1.getItem().isEmpty()) == false) goto L17;
        d r7 = this.a;
        List<com.bytedance.android.live.profit.privilege.model.danmu.b> r8 = r1.getItem();
        int r14 = (int) r1.getShadowType();
        r7.getClass();
        ArrayList r10 = new ArrayList();
        r10.addAll(r8);
        Iterator r9 = r10.iterator();
        int r12 = 0;
        boolean r13 = false;
        int r15 = -1;
    L8:
        if (r9.hasNext() == false) goto L16;
        Object r16 = r9.next();
        int r17 = r12 + 1;
        if (r12 >= 0) goto L13;
        CollectionsKt.throwIndexOverflow();
    L13:
        if (((com.bytedance.android.live.profit.privilege.model.danmu.b) r16).getStyle() != 0) goto L15;
        r15 = r12;
        r13 = true;
    L15:
        r12 = r17;
        goto L8
    L16:
        vh7.c r18 = vh7.f.c(com.bytedance.android.live.profit.privilege.model.danmu.b.class);
        com.bytedance.android.live.profit.privilege.model.danmu.b r20 = (com.bytedance.android.live.profit.privilege.model.danmu.b) r18;
        r20.setStatus(0);
        r20.setStyle(21);
        Unit r22 = Unit.INSTANCE;
        ListProtector.add(r10, 0, r18);
        r7.b.setValue(new DanmakuTabList(r10, false, r13, r15, r14, null, 34, null));
    }
}
