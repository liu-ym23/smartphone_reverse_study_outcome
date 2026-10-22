package com.bytedance.android.live.revlink.link.biz.component;

import com.bytedance.android.livesdk.link.model.x6;
import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.schedulers.Schedulers;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class p implements com.bytedance.android.live.revlink.link.biz.service.c {
    public final String a;
    public final CompositeDisposable b;
    public final com.bytedance.android.live.revlink.link.infra.lifecontrol.context.a c;

    @Override // com.bytedance.android.live.revlink.link.biz.service.e
    public final String getTAG() {
        return "RevenueLinkAnchorComponent";
    }

    @Override // com.bytedance.android.live.revlink.link.biz.service.e
    public final void detach() {
        this.b.clear();
    }

    @Override // com.bytedance.android.live.revlink.link.biz.service.e
    public final void attach() {
        f21.a r0 = com.bytedance.android.live.revlink.link.biz.service.i.i(this);
        if (r0 != null) goto L6;
        return;
    L6:
        if (r0.f == true) goto L8;
        return;
    L8:
        if (r0.d == 6) goto L82;
        g51.a r1 = g51.a.d;
        r1.getClass();
        if (((Boolean) g51.a.c.getValue(r1, g51.a.a[1])).booleanValue() == false) goto L86;
        x6 r2 = r0.o.e;
        if (r2 == null) goto L83;
        Map r3 = r2.getRoleLinkMicMap();
        if (r3 != null) goto L17;
        return;
    L17:
        if (r3.size() != 4) goto L85;
        com.bytedance.android.live.revenuelink.rtc.i r4 = com.bytedance.android.live.revlink.link.biz.service.i.f(this);
        if (r4 == null) goto L23;
        com.bytedance.android.live.revenuelink.rtc.p r5 = r4.L();
        if (r5 == null) goto L23;
        int r6 = r5.a.size();
    L24:
        if (r6 >= 4) goto L87;
        x6 r7 = r0.o.e;
        ArrayList r8 = new ArrayList();
        ArrayList r9 = new ArrayList();
        Map r10 = r7.getRoleLinkMicMap();
        if (r10 == null) goto L53;
        ArrayList r12 = new ArrayList();
        ArrayList r13 = new ArrayList();
        String r14 = (String) r10.get(1L);
        if (r14 == null) goto L31;
        r12.add(r14);
    L31:
        String r15 = (String) r10.get(Long.valueOf(2));
        if (r15 == null) goto L34;
        r12.add(r15);
    L34:
        String r16 = (String) r10.get(Long.valueOf(3));
        if (r16 == null) goto L37;
        r13.add(r16);
    L37:
        String r17 = (String) r10.get(Long.valueOf(4));
        if (r17 == null) goto L40;
        r13.add(r17);
    L40:
        Iterator r18 = MapsKt.toMap(r10).entrySet().iterator();
    L42:
        if (r18.hasNext() == false) goto L48;
        Map.Entry r19 = (Map.Entry) r18.next();
        int r110 = (int) ((Number) r19.getKey()).longValue();
        if (Intrinsics.areEqual((String) r19.getValue(), com.bytedance.android.live.revlink.link.biz.service.i.A(this).c()) == false) goto L42;
        if (r110 == 3) goto L47;
        if (r110 != 4) goto L42;
    L47:
        boolean r20 = false;
    L49:
        if (r20 == false) goto L51;
        Pair r22 = TuplesKt.to(r12, r13);
    L52:
        r8.addAll((Collection) r22.getFirst());
        r9.addAll((Collection) r22.getSecond());
        goto L53
    L51:
        r22 = TuplesKt.to(r13, r12);
        goto L52
    L48:
        r20 = true;
    L53:
        Object r23 = null;
        jy0.b.c(com.bytedance.android.live.revlink.link.biz.service.e.a.a(this), "loadRandomTeamPKLayout leftLinkIds=" + r8 + ", rightLinkIds=" + r9, null, 4);
        if (r8.size() != 2) goto L56;
    L58:
        Pair[] r24 = new Pair[4];
        r24[0] = TuplesKt.to(getContext().Ab(), 0);
        Iterator r25 = r8.iterator();
    L60:
        if (r25.hasNext() == false) goto L64;
        Object r26 = r25.next();
        if ((!Intrinsics.areEqual((String) r26, getContext().Zl())) == false) goto L60;
        r23 = r26;
    L64:
        String r27 = (String) r23;
        if (r27 == null) goto L68;
        Intrinsics.checkNotNullParameter(r27, "$this$uid");
        Intrinsics.checkNotNullParameter(r27, "$this$uid");
        Intrinsics.checkNotNullParameter(r27, "$this$uid");
        String r28 = com.bytedance.android.live.revlink.link.biz.service.j.a.b(this, r27);
        if (r28 == null) goto L68;
    L69:
        r24[1] = TuplesKt.to(r28, 3);
        r24[2] = TuplesKt.to("role_invitee", 1);
        r24[3] = TuplesKt.to("role_invitee_follower", 2);
        getContext().m6().setValue(new com.bytedance.android.live.revlink.link.core.layoutstatus.l(4, MapsKt.mapOf(r24)));
        com.bytedance.revenue.platform.api.core.rx.l r29 = com.bytedance.revenue.platform.api.core.rx.l.a;
        int r30 = com.bytedance.revenue.platform.api.core.rx.p.a;
        com.bytedance.revenue.platform.api.core.rx.f.a(Observable.timer(10000, TimeUnit.MILLISECONDS, Schedulers.computation()).observeOn(AndroidSchedulers.mainThread()).subscribe(new o(this)), this.b);
        return;
    L68:
        r28 = "role_inviter_follower";
        goto L69
    L56:
        if (r9.size() == 2) goto L58;
        return;
    L87:
        return;
    L23:
        r6 = 0;
        goto L24
    L85:
        return;
    L83:
        return;
    L86:
        return;
    }

    @Override // com.bytedance.android.live.revlink.link.biz.service.c, com.bytedance.android.live.revlink.link.biz.service.e, com.bytedance.android.live.revlink.link.biz.service.j
    public /* bridge */ /* synthetic */ com.bytedance.android.live.revlink.link.infra.lifecontrol.context.d getContext() {
        return getContext();
    }

    @Override // com.bytedance.android.live.revlink.link.biz.service.k
    public final com.bytedance.android.live.revlink.impl.global.c getLinkInstanceService() {
        return getContext();
    }

    @Override // com.bytedance.android.live.revlink.link.biz.service.e
    public final String getComponentName() {
        return this.a;
    }

    @Override // com.bytedance.android.live.revlink.link.biz.service.c, com.bytedance.android.live.revlink.link.biz.service.e, com.bytedance.android.live.revlink.link.biz.service.j
    public com.bytedance.android.live.revlink.link.infra.lifecontrol.context.a getContext() {
        return this.c;
    }

    public p(com.bytedance.android.live.revlink.link.infra.lifecontrol.context.g r2) {
        Intrinsics.checkNotNullParameter(r2, "context");
        this.c = r2;
        this.a = "MultiRandomPKComponent";
        this.b = new CompositeDisposable();
    }
}
