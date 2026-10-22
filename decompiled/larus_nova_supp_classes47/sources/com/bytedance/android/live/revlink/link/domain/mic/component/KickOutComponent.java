package com.bytedance.android.live.revlink.link.domain.mic.component;

import com.bytedance.android.live.base.model.user.IBaseUser;
import com.bytedance.android.live.revenuelink.connect.n;
import com.bytedance.android.live.revlink.impl.multianchor.utils.q;
import com.bytedance.android.livesdk.link.model.ILinkerKickOutContent;
import com.bytedance.android.livesdk.link.model.p;
import com.bytedance.android.livesdk.revenue.log.LogCommon;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class KickOutComponent implements s51.a {
    public final String a;
    public final String b;
    public final n c;
    public final com.bytedance.android.live.revlink.link.infra.lifecontrol.context.a d;

    @Override // s51.a
    public final void attach() {
    }

    @Override // s51.a
    public final void detach() {
    }

    public final void a(final String r10, final ILinkerKickOutContent.KickOutSource r12, final Function1<? super String, Boolean> r13) {
        Intrinsics.checkNotNullParameter(r10, "reqSrc");
        Intrinsics.checkNotNullParameter(r12, "kickOutSource");
        Intrinsics.checkNotNullParameter(r13, "validCheck");
        Long r2 = null;
        p r0 = this.d.getAnchorLinkUserCenter().getGuestInfo(this.a, null);
        if (r0 == null) goto L8;
        IBaseUser r1 = r0.getUser();
        if (r1 == null) goto L8;
        String r3 = r1.getNickName();
        if (r3 == null) goto L8;
    L9:
        com.bytedance.live.kmp.util.c r4 = com.bytedance.live.kmp.util.c.a;
        int r5 = w11.a.a;
        final String r8 = com.bytedance.live.kmp.util.c.a(2131920554, new Object[]{r3});
        this.d.ko().j(new KickOutComponent$kickOut$1(this, r13, r10, r12, r8));
        q r14 = this.d.getMultiAnchorLinkLogUtils();
        String r15 = this.a;
        r14.getClass();
        LinkedHashMap r16 = new LinkedHashMap();
        w31.c r6 = r14.k();
        if (r6 == null) goto L12;
        Map<String, String> r7 = r6.f();
    L13:
        r16.putAll(r7);
        com.bytedance.android.live.revlink.impl.multianchor.vm.g r9 = r14.g();
        if (r9 == null) goto L16;
        Long r17 = Long.valueOf(r9.a());
    L17:
        r16.put("channel_id", String.valueOf(r17));
        w31.c r18 = r14.k();
        if (r18 == null) goto L20;
        r2 = Long.valueOf(r18.i());
    L20:
        r16.put("pk_id", String.valueOf(r2));
        d31.d r19 = r14.m();
        if (r19 == null) goto L23;
        r19.r(r16);
    L23:
        r16.put("to_anchor_id", String.valueOf(r15));
        r16.put("connection_anchor_cnt", r14.b());
        mz0.n r110 = new mz0.n();
        Map<String, String> r111 = r110.a;
        Intrinsics.checkNotNullParameter(r111, "map");
        Intrinsics.checkNotNullParameter(r16, "map");
        r111.putAll(r16);
        mz0.m r112 = new mz0.m();
        r112.b(LogCommon.ROOM);
        ((ArrayList) r110.b).addAll(r112.a);
        cy0.e.a.getClass();
        cy0.j r113 = cy0.e.a.a;
        com.bytedance.android.scope.m.e.getClass();
        Object r114 = com.bytedance.android.scope.m.b(r113).a(Reflection.getOrCreateKotlinClass(mz0.i.class));
        Intrinsics.checkNotNull(r114);
        ((mz0.i) ((f80.a) r114)).w3("livesdk_connection_kickout_comfirm_show", r110.a, r110.b);
        return;
    L16:
        r17 = null;
        goto L17
    L12:
        r7 = MapsKt.emptyMap();
    L8:
        r3 = "";
        goto L9
    }

    public KickOutComponent(String r2, String r3, n r4, com.bytedance.android.live.revlink.link.infra.lifecontrol.context.a r5) {
        Intrinsics.checkNotNullParameter(r2, "uid");
        Intrinsics.checkNotNullParameter(r3, "secUID");
        Intrinsics.checkNotNullParameter(r4, "linkOutManager");
        Intrinsics.checkNotNullParameter(r5, "context");
        this.a = r2;
        this.b = r3;
        this.c = r4;
        this.d = r5;
    }
}
