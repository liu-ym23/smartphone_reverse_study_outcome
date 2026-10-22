package com.bytedance.android.live.revlink.impl.multianchor.widget;

import android.content.res.Configuration;
import android.view.View;
import android.widget.FrameLayout;
import com.bytedance.android.live.core.tetris.widgets.LiveWidget;
import com.bytedance.android.live.revlink.impl.LynxCentralManager;
import com.bytedance.android.live.revlink.impl.multianchor.utils.v;
import com.bytedance.android.live.revlink.impl.pk.ui.MultiOptFrameLayout;
import com.bytedance.android.live.revlink.impl.plantform.AnchorLinkUserCenterV2;
import com.bytedance.android.live.revlink.impl.region.RevLinkWindowRegionContext;
import com.bytedance.android.live.revlink.impl.utils.u;
import com.bytedance.android.live.revlink.link.infra.lifecontrol.context.RevLinkBizContext;
import com.bytedance.android.live.revlink.widgetservice.RevLinkAudienceFacade;
import com.bytedance.android.live.revlink.widgetservice.RevLinkAudienceLaunchParam;
import com.bytedance.android.livesdkapi.depend.model.live.IRoom;
import com.bytedance.android.scope.m;
import com.bytedance.common.jato.views.JatoOptFrameLayout;
import com.bytedance.ies.sdk.widgets.Widget;
import io.reactivex.subjects.PublishSubject;
import java.util.ArrayList;
import java.util.Iterator;
import kotlin.ExceptionsKt;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.UninitializedPropertyAccessException;
import kotlin.Unit;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001:\u0001\u0002¨\u0006\u0003"}, d2 = {"Lcom/bytedance/android/live/revlink/impl/multianchor/widget/RevLinkAudienceWidget;", "Lcom/bytedance/android/live/core/tetris/widgets/LiveWidget;", "a", "liverevlink-impl_saasRelease"}, k = 1, mv = {1, 5, 1})
public final class RevLinkAudienceWidget extends LiveWidget {
    public RevLinkAudienceFacade a;
    public c b;
    public l c;
    public final RevLinkAudienceLaunchParam d;
    public final u51.c e;
    public final o11.a f;
    public final com.bytedance.android.livesdk.revenue.service.room.c g;
    public final wq2.f h;
    public final ld.a i;
    public final x11.a j;

    public static final class a {
    }

    static {
    }

    public final int getLayoutId() {
        return 2131566213;
    }

    public final void onDestroy() {
        super.onDestroy();     // Catch: Throwable -> L14
        RevLinkAudienceFacade r1 = this.a;     // Catch: Throwable -> L14
        if (r1 == null) goto L16;
        o51.i r2 = r1.b;     // Catch: Throwable -> L14
        if (r2 == null) goto L8;
        com.bytedance.android.live.revlink.link.utils.a.c(r2);     // Catch: Throwable -> L14
    L8:
        com.bytedance.android.live.revlink.link.infra.lifecontrol.context.h r3 = r1.a;     // Catch: Throwable -> L14
        if (r3 == null) goto L16;
        AnchorLinkUserCenterV2 r4 = r3.d.d;     // Catch: Throwable -> L14
        if (r4 == null) goto L16;
        r4.clear(false);     // Catch: Throwable -> L14
    L16:
        c r5 = this.b;
        if (r5 == null) goto L19;
        BackgroundImpl r6 = r5.a;
        r6.e = null;
        r6.f = null;
        r6.h.removeAllViews();
    L19:
        l r0 = this.c;
        if (r0 == null) goto L25;
        r0.c();
        return;
    L25:
        return;
    L14:
        th = move-exception;
        jy0.b.c("xuzr_crash", "RevLinkAudienceWidget onDestroy crash with " + ExceptionsKt.stackTraceToString(th), null, 4);
        goto L16
    }

    public final void onCreate() {
        super.onCreate();
        View r0 = ((Widget) this).contentView;
        if (r0 == null) goto L72;
        JatoOptFrameLayout r10 = (MultiOptFrameLayout) r0.findViewById(2131380435);
        if (r10 == null) goto L73;
        com.bytedance.android.live.revlink.impl.settings.dynamic.b r1 = com.bytedance.android.live.revlink.impl.settings.dynamic.b.m;
        r1.getClass();
        r10.setHasFixSize(((Boolean) com.bytedance.android.live.revlink.impl.settings.dynamic.b.e.getValue(r1, com.bytedance.android.live.revlink.impl.settings.dynamic.b.a[3])).booleanValue());
        View r2 = ((Widget) this).contentView;
        if (r2 == null) goto L74;
        FrameLayout r6 = (FrameLayout) r2.findViewById(2131384482);
        if (r6 == null) goto L79;
        LynxCentralManager r3 = new LynxCentralManager(r10, (vy0.c) com.bytedance.android.live.revenue.core.util.f.a(vy0.c.class));
        i r15 = new i(this);
        View r4 = ((Widget) this).contentView;
        if (r4 == null) goto L75;
        FrameLayout r5 = (FrameLayout) r4.findViewById(2131384484);
        if (r5 == null) goto L80;
        l r14 = new l(r5, ((Widget) this).context);
        this.c = r14;
        Object r7 = this.g.getRoomContext().getRoom().getValue();
        String r26 = null;
        if ((r7 instanceof IRoom) == true) goto L19;
        r7 = null;
    L19:
        enableSubWidgetManager();
        c r13 = new c(((Widget) this).context, (IRoom) r7, ((Widget) this).dataCenter, r6, r14, ((Widget) this).subWidgetManager, ((Widget) this).contentView, r10);
        this.b = r13;
        RevLinkWindowRegionContext r8 = com.bytedance.android.live.revlink.impl.global.b.f0();
        if (r8 == null) goto L26;
        com.bytedance.live.datacontext.j<com.bytedance.android.live.revlink.impl.multianchor.service.g> r9 = r8.getPartnerService();
        if (r9 == null) goto L26;
        com.bytedance.android.live.revlink.impl.multianchor.service.g r12 = (com.bytedance.android.live.revlink.impl.multianchor.service.g) r9.getValue();
        if (r12 == null) goto L26;
        r12.j(r13);
    L26:
        RevLinkAudienceLaunchParam r16 = this.d;
        u51.c r17 = this.e;
        o11.a r18 = this.f;
        com.bytedance.android.livesdk.revenue.service.room.c r19 = this.g;
        wq2.f r20 = this.h;
        com.bytedance.android.live.revenue.core.util.j.a r22 = com.bytedance.android.live.revenue.core.util.j.C0;
        yz0.f r110 = (yz0.f) com.bytedance.android.live.revenue.core.util.f.d(r22.a(), yz0.f.class);
        com.bytedance.android.live.revenue.core.b r23 = r22.a();
        Intrinsics.checkNotNull(r23);
        com.bytedance.android.livesdk.revenue.service.message.d r111 = com.bytedance.android.live.revenue.core.util.e.b(r23, com.bytedance.android.livesdk.revenue.service.message.d.class);
        ld.a r24 = this.i;
        x11.a r25 = this.j;
        String r27 = u.e();
        if (r27 != null) goto L29;
        r27 = "";
    L29:
        RevLinkAudienceFacade r28 = new RevLinkAudienceFacade(r16, r17, r18, r19, r3, r20, r110, r111, r24, r25, r27, r15, r13, r14);
        this.a = r28;
        Result.Companion r29 = Result.Companion;     // Catch: Throwable -> L32
        Object r30 = Result.constructor-impl(r28.a(r28.c));     // Catch: Throwable -> L32
    L35:
        if (Result.isSuccess-impl(r30) == false) goto L62;
        com.bytedance.android.live.revlink.link.infra.lifecontrol.context.h r32 = (com.bytedance.android.live.revlink.link.infra.lifecontrol.context.h) r30;
        r28.a = r32;
        u51.c r33 = r28.d;
        String r34 = "context";
        Intrinsics.checkNotNullParameter(r32, "context");
        Intrinsics.checkNotNullParameter(r33, "infraScope");
        o51.i r35 = new o51.i(r33);
        Intrinsics.checkNotNullParameter(r35, "scope");
        Intrinsics.checkNotNullParameter(r32, "value");
        r35.e = r32;
        Object r36 = e33.k.a;
        if (r32 != r36) goto L40;
    L58:
        if (r34 != null) goto L61;
        r28.b = r35;
        com.bytedance.android.scope.l.a(r35);
        goto L62
    L61:
        throw new UninitializedPropertyAccessException(r34);
    L40:
        if (r35.f != r36) goto L43;
        r26 = "linkInternalDataSet";
    L57:
        r34 = r26;
        goto L58
    L43:
        if (r35.g != r36) goto L46;
        r26 = "dynamicLayoutClient";
        goto L57
    L46:
        if (r35.h != r36) goto L49;
        r26 = "linkDataScope";
        goto L57
    L49:
        if (r35.i != r36) goto L52;
        r26 = "revenueInstance";
        goto L57
    L52:
        if (r35.j != r36) goto L55;
        r26 = "revenueInstanceExt";
        goto L57
    L55:
        if (r35.k != r36) goto L57;
        r26 = "roomInstance";
    L62:
        Throwable r37 = Result.exceptionOrNull-impl(r30);
        if (r37 == null) goto L76;
        o11.a r38 = r28.e;
        m.e.getClass();
        com.bytedance.android.live.revlink.impl.global.c r39 = (com.bytedance.android.live.revlink.impl.global.c) m.b(r38).a(Reflection.getOrCreateKotlinClass(com.bytedance.android.live.revlink.impl.global.c.class));
        if (r39 == null) goto L77;
        v r40 = r39.getMultiLinkMonitor();
        if (r40 == null) goto L78;
        r40.H("rev_link_audience_context_build_crash", MapsKt.mutableMapOf(new Pair[]{TuplesKt.to("throwable", ExceptionsKt.stackTraceToString(r37))}));
        return;
    L78:
        return;
    L77:
        return;
    L76:
        return;
    L32:
        th = move-exception;
        Result.Companion r42 = Result.Companion;
        r30 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L35
    L80:
        return;
    L75:
        return;
    L79:
        return;
    L74:
        return;
    L73:
        return;
    }

    public final void wq() {
        RevLinkAudienceFacade r0 = this.a;
        if (r0 == null) goto L10;
        com.bytedance.android.live.revlink.link.infra.lifecontrol.context.h r1 = r0.a;
        if (r1 == null) goto L11;
        PublishSubject<Unit> r2 = r1.b;
        if (r2 == null) goto L12;
        r2.onNext(Unit.INSTANCE);
        return;
    L12:
        return;
    L11:
        return;
    }

    public final void onPause() {
        super.onPause();
        RevLinkAudienceFacade r0 = this.a;
        if (r0 == null) goto L12;
        com.bytedance.android.live.revlink.link.infra.lifecontrol.context.h r1 = r0.a;
        if (r1 == null) goto L14;
        RevLinkBizContext r2 = r1.d;
        if (r2 == null) goto L15;
        r2.j = Boolean.FALSE;
        Iterator r3 = ((ArrayList) r2.b).iterator();
    L10:
        if (r3.hasNext() == false) goto L16;
        ((Function0) r3.next()).invoke();
        goto L10
    L16:
        return;
    L15:
        return;
    L14:
        return;
    }

    public final void onResume() {
        super.onResume();
        RevLinkAudienceFacade r0 = this.a;
        if (r0 == null) goto L12;
        com.bytedance.android.live.revlink.link.infra.lifecontrol.context.h r1 = r0.a;
        if (r1 == null) goto L14;
        RevLinkBizContext r2 = r1.d;
        if (r2 == null) goto L15;
        r2.j = Boolean.TRUE;
        Iterator r3 = ((ArrayList) r2.a).iterator();
    L10:
        if (r3.hasNext() == false) goto L16;
        ((Function0) r3.next()).invoke();
        goto L10
    L16:
        return;
    L15:
        return;
    L14:
        return;
    }

    public final void onConfigurationChanged(Configuration r3) {
        super/*com.bytedance.ies.sdk.widgets.Widget*/.onConfigurationChanged(r3);
        RevLinkAudienceFacade r0 = this.a;
        if (r0 == null) goto L17;
        if (r3 == null) goto L6;
        b03.b r4 = zr0.b.a(r3);
    L7:
        com.bytedance.android.live.revlink.link.infra.lifecontrol.context.h r1 = r0.a;
        if (r1 == null) goto L19;
        RevLinkBizContext r2 = r1.d;
        if (r2 == null) goto L20;
        if (r4 == null) goto L21;
        Iterator r5 = ((ArrayList) r2.c).iterator();
    L15:
        if (r5.hasNext() == false) goto L22;
        ((Function1) r5.next()).invoke(r4);
        goto L15
    L22:
        return;
    L21:
        return;
    L20:
        return;
    L19:
        return;
    L6:
        r4 = null;
        goto L7
    }

    public RevLinkAudienceWidget(RevLinkAudienceLaunchParam r2, u51.e r3, o11.a r4, com.bytedance.android.livesdk.revenue.service.room.c r5, wq2.f r6, ld.a r7, x11.a r8) {
        Intrinsics.checkNotNullParameter(r2, "launchParam");
        Intrinsics.checkNotNullParameter(r3, "infraScope");
        Intrinsics.checkNotNullParameter(r4, "linkScope");
        Intrinsics.checkNotNullParameter(r5, "revRoomService");
        Intrinsics.checkNotNullParameter(r6, "roomDataCenterService");
        this.d = r2;
        this.e = r3;
        this.f = r4;
        this.g = r5;
        this.h = r6;
        this.i = r7;
        this.j = r8;
    }
}
