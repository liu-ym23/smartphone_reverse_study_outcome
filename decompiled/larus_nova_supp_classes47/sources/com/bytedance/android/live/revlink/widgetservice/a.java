package com.bytedance.android.live.revlink.widgetservice;

import com.bytedance.android.live.revlink.impl.LynxCentralManager;
import com.bytedance.android.live.revlink.impl.multianchor.widget.dialogmananger.DialogLaunchService;
import com.bytedance.android.live.revlink.link.domain.anchorimpl.i;
import com.bytedance.android.live.revlink.link.domain.anchorimpl.k;
import com.bytedance.android.live.revlink.link.domain.anchorimpl.l;
import com.bytedance.android.live.revlink.link.domain.anchorimpl.m;
import com.bytedance.android.live.revlink.link.domain.service.RevLinkDomainAnchorService;
import com.bytedance.android.live.revlink.link.infra.lifecontrol.context.AnchorContextBuilder;
import com.bytedance.android.live.revlink.link.infra.lifecontrol.context.RevLinkBizContext;
import com.bytedance.android.live.revlink.link.infra.lifecontrol.context.e;
import com.bytedance.android.live.revlink.link.infra.lifecontrol.context.g;
import com.bytedance.android.livesdk.revenue.service.room.c;
import fr2.v;
import io.reactivex.disposables.CompositeDisposable;
import java.util.Map;
import kotlin.UninitializedPropertyAccessException;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import u51.b;
import v51.d;
import wq2.f;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class a {
    public d a;
    public g b;
    public final CompositeDisposable c;
    public final RevLinkAnchorLaunchParam d;
    public final b e;
    public final o11.a f;
    public final c g;
    public final x51.a h;
    public final f i;
    public final yz0.f j;
    public final com.bytedance.android.livesdk.revenue.service.message.d k;
    public final ld.a l;
    public final x11.a m;
    public final Function0<v> n;
    public final com.bytedance.android.live.revlink.link.domain.anchorimpl.f o;
    public final k p;
    public final String q;
    public final l r;
    public final i s;
    public final com.bytedance.android.live.revlink.link.domain.anchorimpl.g t;
    public final m u;

    public final void a() {
        jy0.b.c("xuzr_log", "RevLinkAnchorFacade attach", null, 4);
        final RevLinkAnchorLaunchParam r1 = this.d;
        int r2 = e.a;
        Function1<AnchorContextBuilder, Unit> r3 = new RevLinkAnchorFacade$buildRevLinkBizAnchorContext$1(this, r1);
        Intrinsics.checkNotNullParameter(r3, "initFunc");
        AnchorContextBuilder r4 = new AnchorContextBuilder();
        r3.invoke(r4);
        RevLinkBizContext r5 = com.bytedance.android.live.revlink.link.infra.lifecontrol.context.k.a(r4);
        Map<Long, String> r6 = r4.v;
        Map<Long, String> r7 = r4.w;
        Map<Long, String> r8 = r4.x;
        Map<Long, String> r9 = r4.y;
        sc0.a r10 = r4.z;
        sc0.c r12 = r4.C;
        Function0<? extends v> r13 = r4.D;
        com.bytedance.android.live.revlink.link.domain.anchorimpl.f r14 = r4.E;
        com.bytedance.android.live.revlink.link.infra.lifecontrol.context.l.a(r14);
        k r15 = r4.F;
        com.bytedance.android.live.revlink.link.infra.lifecontrol.context.l.a(r15);
        int r16 = r4.i;
        boolean r17 = r4.G;
        boolean r18 = r4.H;
        i r19 = r4.A;
        com.bytedance.android.live.revlink.link.infra.lifecontrol.context.l.a(r19);
        com.bytedance.android.live.revlink.link.domain.anchorimpl.g r20 = r4.B;
        com.bytedance.android.live.revlink.link.infra.lifecontrol.context.l.a(r20);
        m r22 = r4.t;
        com.bytedance.android.live.revlink.link.infra.lifecontrol.context.l.a(r22);
        g r23 = new g(r5, r6, r7, r8, r9, r10, r12, r13, r14, r15, r16, r17, r18, r19, r20, r22);
        this.b = r23;
        b r24 = this.e;
        String r25 = "context";
        Intrinsics.checkNotNullParameter(r23, "context");
        Intrinsics.checkNotNullParameter(r24, "infraScope");
        d r26 = new d(r24);
        Intrinsics.checkNotNullParameter(r26, "scope");
        Intrinsics.checkNotNullParameter(r23, "value");
        r26.e = r23;
        Object r27 = e33.k.a;
        if (r23 != r27) goto L6;
    L36:
        if (r25 != null) goto L49;
        this.a = r26;
        com.bytedance.android.scope.l.a(r26);
        d r28 = this.a;
        if (r28 == null) goto L50;
        Intrinsics.checkNotNullParameter(r28, "$this$domainService");
        o51.c r29 = com.bytedance.android.live.revlink.link.utils.a.a(r28);
        if (r29 == null) goto L51;
        Intrinsics.checkNotNullParameter(r29, "$this$domainService");
        Intrinsics.checkNotNullParameter(r29, "$this$domainScope");
        com.bytedance.android.scope.m.e.getClass();
        com.bytedance.android.live.revlink.link.core.service.a r30 = (com.bytedance.android.live.revlink.link.core.service.a) com.bytedance.android.scope.m.b(r29).a(Reflection.getOrCreateKotlinClass(com.bytedance.android.live.revlink.link.core.service.a.class));
        if (r30 == null) goto L44;
        p51.c r32 = r30.a;
    L45:
        if (r32 == null) goto L52;
        Intrinsics.checkNotNullParameter(r32, "$this$domainService");
        RevLinkDomainAnchorService r33 = (RevLinkDomainAnchorService) com.bytedance.android.scope.m.b(r32).a(Reflection.getOrCreateKotlinClass(RevLinkDomainAnchorService.class));
        return;
    L52:
        return;
    L44:
        r32 = null;
        goto L45
    L51:
        return;
    L50:
        return;
    L49:
        throw new UninitializedPropertyAccessException(r25);
    L6:
        if (r26.f != r27) goto L9;
        r25 = "dynamicLayoutClient";
        goto L36
    L9:
        if (r26.g != r27) goto L12;
        r25 = "linkInternalDataSet";
        goto L36
    L12:
        if (r26.h != r27) goto L15;
        r25 = "linkInstanceService";
        goto L36
    L15:
        if (r26.i != r27) goto L18;
        r25 = "anchorRtcManager";
        goto L36
    L18:
        if (r26.j != r27) goto L21;
        r25 = "linkOutManager";
        goto L36
    L21:
        if (r26.k != r27) goto L24;
        r25 = "revLinkHostService";
        goto L36
    L24:
        if (r26.l != r27) goto L27;
        r25 = "linkDataScope";
        goto L36
    L27:
        if (r26.m != r27) goto L30;
        r25 = "revenueInstance";
        goto L36
    L30:
        if (r26.n != r27) goto L33;
        r25 = "revenueInstanceExt";
        goto L36
    L33:
        if (r26.o != r27) goto L35;
        r25 = "roomInstance";
        goto L36
    L35:
        r25 = null;
        goto L36
    }

    public final g getContext() {
        return this.b;
    }

    public a(RevLinkAnchorLaunchParam r16, b r17, o11.a r18, c r19, LynxCentralManager r20, f r22, yz0.f r23, com.bytedance.android.livesdk.revenue.service.message.d r24, ld.a r25, x11.a r26, Function0 r27, com.bytedance.android.live.revlink.impl.multianchor.widget.g r28, DialogLaunchService r29, String r210, com.bytedance.android.live.revlink.impl.multianchor.widget.i r30, com.bytedance.android.live.revlink.impl.rtc.a r32, com.bytedance.android.live.revlink.impl.multianchor.widget.b r33, com.bytedance.android.live.revlink.impl.multianchor.widget.l r34) {
        Intrinsics.checkNotNullParameter(r16, "launchParam");
        Intrinsics.checkNotNullParameter(r17, "infraScope");
        Intrinsics.checkNotNullParameter(r18, "linkScope");
        Intrinsics.checkNotNullParameter(r19, "revRoomService");
        Intrinsics.checkNotNullParameter(r20, "lynxCentralService");
        Intrinsics.checkNotNullParameter(r22, "roomDataCenterService");
        Intrinsics.checkNotNullParameter(r27, "liveVideoClientFactoryGetter");
        Intrinsics.checkNotNullParameter(r28, "frameRenderService");
        Intrinsics.checkNotNullParameter(r29, "dialogLaunchService");
        Intrinsics.checkNotNullParameter(r210, "selfUID");
        Intrinsics.checkNotNullParameter(r30, "performanceMonitor");
        Intrinsics.checkNotNullParameter(r33, "commonService");
        Intrinsics.checkNotNullParameter(r34, "windowService");
        this.d = r16;
        this.e = r17;
        this.f = r18;
        this.g = r19;
        this.h = r20;
        this.i = r22;
        this.j = r23;
        this.k = r24;
        this.l = r25;
        this.m = r26;
        this.n = r27;
        this.o = r28;
        this.p = r29;
        this.q = r210;
        this.r = r30;
        this.s = r32;
        this.t = r33;
        this.u = r34;
        this.c = new CompositeDisposable();
    }
}
