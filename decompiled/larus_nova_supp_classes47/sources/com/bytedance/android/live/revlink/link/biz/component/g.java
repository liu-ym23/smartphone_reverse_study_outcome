package com.bytedance.android.live.revlink.link.biz.component;

import com.bytedance.android.live.base.model.Extra;
import com.bytedance.android.live.network.response.ExtraResponse;
import com.bytedance.android.live.profile.monitor.DataType;
import com.bytedance.android.live.schema.api.WebcastRedirectException;
import com.bytedance.android.livesdk.link.model.bridge.n0;
import com.bytedance.android.livesdk.revenue.log.LogCommon;
import io.reactivex.disposables.CompositeDisposable;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class g extends com.bytedance.android.live.revenuelink.connect.c implements com.bytedance.android.live.revlink.link.biz.service.c {
    public final String a;
    public final CompositeDisposable b;
    public boolean c;
    public final com.bytedance.android.live.revlink.link.infra.lifecontrol.context.a d;
    public final com.bytedance.android.live.revlink.impl.multianchor.ui.i e;
    public final com.bytedance.android.live.revenuelink.rtc.i f;
    public final h g;

    @Override // com.bytedance.android.live.revlink.link.biz.service.e
    public final String getTAG() {
        return "RevenueLinkAnchorComponent";
    }

    @Override // com.bytedance.android.live.revlink.link.biz.service.e
    public final void attach() {
        com.bytedance.android.live.revenuelink.connect.f r0 = com.bytedance.android.live.revlink.link.biz.service.i.c(this);
        if (r0 == null) goto L6;
        r0.addLinkInListener(7, this);
        return;
    }

    @Override // com.bytedance.android.live.revlink.link.biz.service.e
    public final void detach() {
        com.bytedance.android.live.revenuelink.connect.f r0 = com.bytedance.android.live.revlink.link.biz.service.i.c(this);
        if (r0 == null) goto L5;
        r0.removeLinkInListener(7, this);
    L5:
        this.b.clear();
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
        return this.d;
    }

    @Override // com.bytedance.android.live.revenuelink.connect.c, com.bytedance.android.live.revenuelink.connect.i
    public final void k3(fy.h r5, ExtraResponse<n0, Extra> r6) {
        Intrinsics.checkNotNullParameter(r5, "leaveParams");
        cy0.e.a.getClass();
        cy0.j r7 = cy0.e.a.a;
        com.bytedance.android.scope.m.e.getClass();
        Object r8 = com.bytedance.android.scope.m.b(r7).b(er2.b.class);
        Intrinsics.checkNotNull(r8);
        iq2.b r9 = ((com.bytedance.live.kmp.core.c) r8).getChorusService();
        if (r9 != null) goto L5;
        return;
    L5:
        if (r9.e() != true) goto L16;
        Object r10 = com.bytedance.android.scope.m.b(r7).b(er2.b.class);
        Intrinsics.checkNotNull(r10);
        iq2.b r12 = ((com.bytedance.live.kmp.core.c) r10).getChorusService();
        long r0 = 0;
        if (r12 == null) goto L13;
        com.bytedance.android.live.liveinteract.model.a r13 = r12.c();
        if (r13 == null) goto L13;
        if (r13.getStartTime() <= 0) goto L13;
        i97.a r14 = i97.a.a;
        r0 = (System.currentTimeMillis() / ((long) WebcastRedirectException.UNKNOWN)) - r13.getStartTime();
    L13:
        a(0, this.g.f, r0);
        return;
    }

    public final void a(int r8, boolean r9, long r10) {
        if (r8 != 2) goto L12;
        f21.a r2 = com.bytedance.android.live.revlink.link.biz.service.i.i(this);
        if (r2 == null) goto L12;
        if (r2.f != true) goto L12;
        if (this.c == true) goto L12;
        this.c = true;
        return;
    L12:
        LinkedHashMap r3 = new LinkedHashMap();
        r3.put("channel_id", String.valueOf(com.bytedance.android.live.revlink.link.biz.service.i.A(this).a()));
        r3.put("anchor_connect_status", "2");
        r3.put("invite_mode", "connection");
        String r5 = DataType.FALSE;
        r3.put("is_oncemore", DataType.FALSE);
        r3.put("room_status", "connection");
        cy0.e.a.getClass();
        cy0.j r4 = cy0.e.a.a;
        com.bytedance.android.scope.m.e.getClass();
        Object r6 = com.bytedance.android.scope.m.b(r4).b(er2.b.class);
        Intrinsics.checkNotNull(r6);
        iq2.b r7 = ((com.bytedance.live.kmp.core.c) r6).getChorusService();
        if (r7 != null) goto L15;
    L17:
        String r12 = "follower";
    L18:
        r3.put("role_type", r12);
        if (r8 == 1) goto L23;
        if (r8 == 2) goto L22;
        String r13 = "disconnect";
    L24:
        r3.put("over_type", r13);
        if (r9 == false) goto L27;
        r5 = DataType.TRUE;
    L27:
        r3.put("if_active", r5);
        r3.put("chorus_time", String.valueOf(r10));
        Object r14 = com.bytedance.android.scope.m.b(r4).b(er2.b.class);
        Intrinsics.checkNotNull(r14);
        iq2.b r15 = ((com.bytedance.live.kmp.core.c) r14).getChorusService();
        if (r15 == null) goto L33;
        com.bytedance.android.live.liveinteract.model.a r16 = r15.c();
        if (r16 == null) goto L33;
        String r17 = String.valueOf(r16.getChorusId());
        if (r17 == null) goto L33;
    L34:
        r3.put("chorus_id", r17);
        mz0.n r18 = new mz0.n();
        Map<String, String> r19 = r18.a;
        Intrinsics.checkNotNullParameter(r19, "map");
        Intrinsics.checkNotNullParameter(r3, "map");
        r19.putAll(r3);
        mz0.m r20 = new mz0.m();
        com.bytedance.android.live.revlink.link.biz.service.i.m(this).a(r20);
        r20.b(LogCommon.ROOM);
        r20.b(LogCommon.PAGE_SOURCE_LOG);
        List<Object> r110 = r18.b;
        ArrayList r111 = (ArrayList) r110;
        r111.addAll(r20.a);
        Object r22 = com.bytedance.android.scope.m.b(r4).a(Reflection.getOrCreateKotlinClass(mz0.i.class));
        Intrinsics.checkNotNull(r22);
        ((mz0.i) ((f80.a) r22)).w3("livesdk_connection_chorus_over", r18.a, r18.b);
        return;
    L33:
        r17 = "";
        goto L34
    L22:
        r13 = "join";
        goto L24
    L23:
        r13 = "shut_down";
        goto L24
    L15:
        if (r7.d() != 1) goto L17;
        r12 = "leader";
        goto L18
    }

    public g(com.bytedance.android.live.revlink.link.infra.lifecontrol.context.g r2, com.bytedance.android.live.revlink.link.domain.service.a r3, com.bytedance.android.live.revenuelink.rtc.i r4, h r5) {
        Intrinsics.checkNotNullParameter(r2, "context");
        Intrinsics.checkNotNullParameter(r3, "muteManager");
        Intrinsics.checkNotNullParameter(r4, "rtcManager");
        Intrinsics.checkNotNullParameter(r5, "bizDataContext");
        this.d = r2;
        this.e = r3;
        this.f = r4;
        this.g = r5;
        this.a = "MultiChorusComponent";
        this.b = new CompositeDisposable();
    }
}
