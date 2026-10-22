package com.bytedance.android.live.revlink.link.biz.audiencecomponent;

import com.bytedance.android.live.base.model.Extra;
import com.bytedance.android.live.network.response.ExtraResponse;
import com.bytedance.android.live.revenue.common.p0;
import com.bytedance.android.live.revlink.impl.multianchor.service.h;
import com.bytedance.android.live.revlink.impl.multianchor.utils.AnchorLinkAudienceOptUtils;
import com.bytedance.android.live.revlink.impl.multianchor.utils.MultiEnterRoomTracer;
import com.bytedance.android.live.revlink.impl.multianchor.utils.MultiLinkEnterCheck;
import com.bytedance.android.live.revlink.impl.plantform.AnchorLinkUserCenterV2;
import com.bytedance.android.live.revlink.link.biz.component.MultiPKContextHolder;
import com.bytedance.android.live.revlink.link.biz.service.i;
import com.bytedance.android.livesdk.link.model.r;
import java.util.concurrent.CopyOnWriteArrayList;
import kotlin.jvm.internal.Intrinsics;
import kotlin.properties.ReadOnlyProperty;
import kotlin.reflect.KProperty;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class MultiAudiencePreloadComponent implements com.bytedance.android.live.revlink.link.biz.service.d, h.b {
    public final String a;
    public MultiLinkEnterCheck b;
    public final com.bytedance.android.live.revlink.link.infra.lifecontrol.context.b c;
    public final MultiPKContextHolder d;

    @Override // com.bytedance.android.live.revlink.link.biz.service.e
    public final String getTAG() {
        return "RevenueLinkAudienceComponent";
    }

    @Override // com.bytedance.android.live.revlink.impl.multianchor.service.h.b
    public final void a() {
        jy0.b.c("link_preload", this.a + " preload linkmic list failed", null, 4);
        AnchorLinkUserCenterV2 r0 = i.t(this);
        if (r0 == null) goto L6;
        r0.b(2, "multi_anchor_link_widget_create");
        return;
    }

    @Override // com.bytedance.android.live.revlink.link.biz.service.e
    public final void detach() {
        MultiLinkEnterCheck r0 = this.b;
        if (r0 == null) goto L5;
        r0.a.clear();
    L5:
        Intrinsics.checkNotNullParameter(this, "$this$preloadService");
        h r1 = i.getContext(this).wo();
        if (r1 == null) goto L9;
        r1.g();
        return;
    }

    @Override // com.bytedance.android.live.revlink.link.biz.service.e
    public final void attach() {
        AnchorLinkUserCenterV2 r0 = i.t(this);
        if (r0 == null) goto L5;
        MultiLinkEnterCheck r1 = new MultiLinkEnterCheck(getContext(), r0);
        this.b = r1;
        r1.a();
    L5:
        boolean r2 = false;
        if (u41.b.i.b() == true) goto L8;
    L18:
        boolean r3 = false;
    L20:
        if (r3 == false) goto L24;
        jy0.b.c("link_preload", this.a + " valid preload data register data listener", null, 4);
        Intrinsics.checkNotNullParameter(this, "$this$preloadService");
        h r4 = i.getContext(this).wo();
        if (r4 == null) goto L54;
        r4.f(this);
    L54:
        boolean r5 = true;
    L56:
        if (r5 == false) goto L58;
        return;
    L58:
        i11.e r6 = i11.e.f;
        r6.getClass();
        ReadOnlyProperty r7 = i11.e.d;
        KProperty[] r8 = i11.e.a;
        if (((Boolean) r7.getValue(r6, r8[2])).booleanValue() == false) goto L76;
        com.bytedance.android.live.revlink.impl.control.launchcontext.b r9 = i.E(this);
        if (r9 == null) goto L63;
        com.bytedance.android.live.revlink.impl.audience.c r10 = r9.b;
    L65:
        if (Intrinsics.areEqual(r10, com.bytedance.android.live.revlink.impl.audience.c.C0119c.b) == false) goto L70;
        if (((Boolean) i11.e.e.getValue(r6, r8[3])).booleanValue() == false) goto L70;
        r2 = true;
    L70:
        if (((CopyOnWriteArrayList) i.t(this).a).isEmpty() == true) goto L74;
        if (r2 == true) goto L74;
        jy0.b.f("ttlive_anchor_link", "skip linkmic/list request", null, 4);
        MultiEnterRoomTracer r12 = i.F(this);
        r12.getClass();
        i97.a r13 = i97.a.a;
        System.currentTimeMillis();
        jy0.b.f("MultiEnterRoomTracer", "linkListSkip source=" + r12.a, null, 4);
        r12.j = 0;
        r12.k = 0;
        r12.i = System.currentTimeMillis();
        r12.g();
        this.d.c.getBasePKContext().resetPkState();
    L75:
        r2 = true;
    L74:
        i.t(this).b(4, "multi_anchor_link_widget_create");
        goto L75
    L63:
        r10 = null;
    L76:
        if (r2 == false) goto L78;
        return;
    L78:
        i.t(this).b(4, "multi_anchor_link_widget_create");
        return;
    L24:
        Intrinsics.checkNotNullParameter(this, "$this$anchorLinkAudienceOptUtils");
        AnchorLinkAudienceOptUtils r14 = i.getContext(this).a3();
        if (((Boolean) r14.a.getValue()).booleanValue() == true) goto L27;
    L29:
        boolean r15 = false;
    L30:
        if (r15 == true) goto L32;
    L51:
        boolean r16 = false;
    L52:
        if (r16 == false) goto L55;
        jy0.b.c("ttlive_anchor_link_audience", "preload by control: linklist valid", null, 4);
        goto L54
    L55:
        r5 = false;
        goto L56
    L32:
        if (i.F(this).a != MultiEnterRoomTracer.MultiLoadSource.RoomEnter) goto L34;
        boolean r17 = true;
    L35:
        if (r17 == false) goto L51;
        i11.f r18 = i.t(this).j;
        if (r18 != null) goto L39;
    L48:
        boolean r19 = false;
    L49:
        if (r19 == false) goto L51;
        r16 = true;
        goto L52
    L39:
        if (r18.a == null) goto L41;
    L42:
        i97.a r20 = i97.a.a;
        if ((System.currentTimeMillis() - r18.c) >= 3000) goto L45;
        boolean r22 = true;
    L46:
        if (r22 != true) goto L48;
        r19 = true;
    L45:
        r22 = false;
        goto L46
    L41:
        if (r18.b == false) goto L45;
    L34:
        r17 = false;
        goto L35
    L27:
        if (((r11.a) r14.b.getValue()).q5() == false) goto L29;
        r15 = true;
        goto L30
    L8:
        if (i.F(this).a != MultiEnterRoomTracer.MultiLoadSource.RoomEnter) goto L10;
        boolean r23 = true;
    L11:
        if (r23 == false) goto L18;
        long r24 = getContext().getRoomID();
        long r25 = getContext().G();
        Intrinsics.checkNotNullParameter(this, "$this$preloadService");
        h r26 = i.getContext(this).wo();
        if (r26 == null) goto L18;
        i97.a r27 = i97.a.a;
        if (r26.a(r24, r25, System.currentTimeMillis(), true) != true) goto L18;
        r3 = true;
        goto L20
    L10:
        r23 = false;
        goto L11
    }

    @Override // com.bytedance.android.live.revlink.link.biz.service.d, com.bytedance.android.live.revlink.link.biz.service.e, com.bytedance.android.live.revlink.link.biz.service.j
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

    @Override // com.bytedance.android.live.revlink.link.biz.service.d, com.bytedance.android.live.revlink.link.biz.service.e, com.bytedance.android.live.revlink.link.biz.service.j
    public com.bytedance.android.live.revlink.link.infra.lifecontrol.context.b getContext() {
        return this.c;
    }

    public MultiAudiencePreloadComponent(com.bytedance.android.live.revlink.link.infra.lifecontrol.context.b r2, MultiPKContextHolder r3) {
        Intrinsics.checkNotNullParameter(r2, "context");
        Intrinsics.checkNotNullParameter(r3, "pkContextHolder");
        this.c = r2;
        this.d = r3;
        this.a = "MultiAudienceWindowBizComponent";
    }

    @Override // com.bytedance.android.live.revlink.impl.multianchor.service.h.b
    public final void b(final long r14, final long r16, final ExtraResponse<r, Extra> r18, boolean r19) {
        Intrinsics.checkNotNullParameter(r18, "preloadData");
        jy0.b.c("link_preload", this.a + " hit preload cache logID: " + r18.logId + " preloadListData=" + ef2.a.c((vh7.c) r18.data), null, 4);
        MultiEnterRoomTracer r1 = i.F(this);
        if (r1 == null) goto L6;
        r1.z = true;
        r1.B = r19;
    L6:
        if (r19 == false) goto L10;
        y41.f r0 = y41.f.N;
        r0.getClass();
        if (((Boolean) y41.f.u.getValue(r0, y41.f.a[19])).booleanValue() == false) goto L10;
        boolean r12 = true;
    L11:
        p0.a(0, false, r12, new MultiAudiencePreloadComponent$notify$1(this, r18, r14, r16), 3);
        return;
    L10:
        r12 = false;
        goto L11
    }
}
