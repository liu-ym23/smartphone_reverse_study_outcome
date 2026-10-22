package com.bytedance.android.live.revlink.impl.multianchor.utils;

import com.bytedance.android.live.revlink.api.ILinkService;
import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.TimeUnit;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class c extends i11.c.a {
    public final /* synthetic */ com.bytedance.android.live.revlink.impl.multianchor.utils.b a;

    public static final class a<T> implements Consumer {
        public final /* synthetic */ c a;
        public final /* synthetic */ List b;

        public a(c r1, List r2) {
            this.a = r1;
            this.b = r2;
        }

        public final void accept(Object r3) {
            Long r4 = (Long) r3;
            if (com.bytedance.android.live.revlink.impl.multianchor.utils.b.a(this.a.a) == true) goto L5;
            return;
        L5:
            if (com.bytedance.android.live.revlink.impl.multianchor.utils.b.b(this.a.a, this.b) == false) goto L20;
            com.bytedance.android.live.revenuelink.rtc.i r5 = this.a.a.c;
            if (r5 == null) goto L11;
            boolean r0 = true;
            if (r5.isEngineOn() != true) goto L11;
        L12:
            if (r0 == false) goto L21;
            com.bytedance.android.live.revlink.impl.multianchor.utils.b r6 = this.a.a;
            r6.getClass();
            LinkedHashMap r1 = new LinkedHashMap();
            com.bytedance.android.live.revlink.impl.global.c r7 = r6.i;
            if (r7 == null) goto L22;
            d r8 = r7.of();
            if (r8 == null) goto L23;
            r8.c("not_online_but_rtc_on", r1);
            return;
        L23:
            return;
        L22:
            return;
        L21:
            return;
        L11:
            r0 = false;
            goto L12
        }
    }

    public static final class b<T> implements Consumer {
        public final /* synthetic */ c a;

        public b(c r1) {
            this.a = r1;
        }

        public final void accept(Object r1) {
            Long r2 = (Long) r1;
            com.bytedance.android.live.revenuelink.rtc.i r3 = this.a.a.c;
            if (r3 == null) goto L7;
            com.bytedance.android.live.revenuelink.rtc.p r4 = r3.L();
            if (r4 == null) goto L7;
            r4.a.size();
        L7:
            i11.b r5 = this.a.a.b;
            if (r5 == null) goto L12;
            List<com.bytedance.android.livesdk.link.model.p> r6 = r5.getOnlineUserList();
            if (r6 == null) goto L12;
            r6.size();
        L12:
            com.bytedance.android.live.revlink.impl.multianchor.utils.b.a(this.a.a);
        }
    }

    public c(com.bytedance.android.live.revlink.impl.multianchor.utils.b r1) {
        this.a = r1;
    }

    @Override // i11.c.a, i11.c.b
    public final void d(int r7, List<? extends com.bytedance.android.livesdk.link.model.p> r8) {
        Intrinsics.checkNotNullParameter(r8, "list");
        if (com.bytedance.android.live.revlink.impl.multianchor.utils.b.a(this.a) == false) goto L37;
        boolean r0 = true;
        if (com.bytedance.android.live.revlink.impl.multianchor.utils.b.b(this.a, r8) == false) goto L14;
        com.bytedance.android.live.revenuelink.rtc.i r9 = this.a.c;
        if (r9 != null) goto L9;
    L11:
        boolean r10 = false;
    L12:
        if (r10 == false) goto L14;
        int r12 = com.bytedance.android.live.revenue.common.v.a;
        com.bytedance.android.live.revenue.common.v.h("ttlive_anchor_link_checker", "current not_online_but_rtc_on, try delay check " + i11.a.c(r8));
        com.bytedance.revenue.platform.api.core.rx.l r13 = com.bytedance.revenue.platform.api.core.rx.l.a;
        int r14 = com.bytedance.revenue.platform.api.core.rx.p.a;
        this.a.a.add(Observable.timer(10000, TimeUnit.MILLISECONDS, Schedulers.computation()).observeOn(AndroidSchedulers.mainThread()).subscribe(new a(this, r8)));
        goto L14
    L9:
        if (r9.isEngineOn() != true) goto L11;
        r10 = true;
    L14:
        com.bytedance.android.live.revenuelink.rtc.i r15 = this.a.c;
        if (r15 == null) goto L19;
        com.bytedance.android.live.revenuelink.rtc.p r16 = r15.L();
        if (r16 == null) goto L19;
        int r17 = r16.a.size();
    L20:
        CopyOnWriteArrayList r3 = (CopyOnWriteArrayList) r8;
        if (r3.size() == this.a.d.size()) goto L26;
        if ((r17 + 1) == r3.size()) goto L26;
        com.bytedance.revenue.platform.api.core.rx.l r18 = com.bytedance.revenue.platform.api.core.rx.l.a;
        int r19 = com.bytedance.revenue.platform.api.core.rx.p.a;
        this.a.a.add(Observable.timer(10000, TimeUnit.MILLISECONDS, Schedulers.computation()).observeOn(AndroidSchedulers.mainThread()).subscribe(new b(this)));
    L26:
        if (r3.size() <= 4) goto L37;
        boolean r20 = r41.f.a;
        int r22 = com.bytedance.android.live.revlink.impl.utils.c.a;
        float r23 = ((Number) com.bytedance.android.live.revenue.common.b0.d.getValue(null, com.bytedance.android.live.revenue.common.b0.a[2])).floatValue();
        if (r23 <= 0) goto L33;
        y41.f r2 = y41.f.N;
        r2.getClass();
        if (r23 >= ((Number) y41.f.t.getValue(r2, y41.f.a[18])).floatValue()) goto L33;
        r0 = false;
    L33:
        if (r0 == true) goto L37;
        p11.d r24 = ((ILinkService) com.bytedance.android.live.revenue.core.util.f.a(ILinkService.class)).mo469getPerfManager();
        if (r24 == null) goto L37;
        r24.f("multi_linker");
    L19:
        r17 = 0;
    L37:
        this.a.d.clear();
        this.a.d.addAll(r8);
    }
}
