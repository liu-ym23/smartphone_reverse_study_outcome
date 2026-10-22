package com.bytedance.android.live.revlink.impl.multianchor.widget;

import android.content.res.Configuration;
import android.graphics.RectF;
import android.os.Handler;
import android.os.Looper;
import android.view.SurfaceView;
import android.view.TextureView;
import android.view.View;
import android.widget.FrameLayout;
import com.bytedance.android.live.core.tetris.widgets.LiveWidget;
import com.bytedance.android.live.revlink.impl.LynxCentralManager;
import com.bytedance.android.live.revlink.impl.multianchor.dialog.pk.MultiAnchorRecordLinkSimpleDialog;
import com.bytedance.android.live.revlink.impl.multianchor.widget.dialogmananger.DialogLaunchService;
import com.bytedance.android.live.revlink.impl.multianchor.widget.renderframe.WindowClickImpl;
import com.bytedance.android.live.revlink.impl.pk.dialog.PkFeedbackDialog;
import com.bytedance.android.live.revlink.impl.pk.dialog.PkMuteCheckDialogFragment;
import com.bytedance.android.live.revlink.impl.pk.ui.MultiOptFrameLayout;
import com.bytedance.android.live.revlink.impl.plantform.AnchorLinkUserCenterV2;
import com.bytedance.android.live.revlink.impl.region.RevLinkWindowRegionContext;
import com.bytedance.android.live.revlink.impl.utils.u;
import com.bytedance.android.live.revlink.link.domain.anchorimpl.AlertBizType;
import com.bytedance.android.live.revlink.link.domain.anchorimpl.p;
import com.bytedance.android.live.revlink.link.infra.lifecontrol.context.RevLinkBizContext;
import com.bytedance.android.live.revlink.link.infra.rtcbiz.RTCAdvanceManagerService;
import com.bytedance.android.live.revlink.link.infra.rtcbiz.RTCBizManagerService;
import com.bytedance.android.live.revlink.widgetservice.RevLinkAnchorLaunchParam;
import com.bytedance.android.livesdk.widget.CommonBottomDialog;
import com.bytedance.android.livesdk.widget.j0;
import com.bytedance.android.livesdk.widget.x0;
import com.bytedance.android.livesdkapi.depend.model.live.IRoom;
import com.bytedance.android.scope.m;
import com.bytedance.common.jato.views.JatoOptFrameLayout;
import com.bytedance.ies.sdk.widgets.NextLiveData;
import com.bytedance.ies.sdk.widgets.Widget;
import com.obric.assistant.interaction.impl.window.helpers.DialogFragmentLancet;
import com.obric.assistant.interaction.impl.window.helpers.DialogLancet;
import fr2.h0;
import fr2.v;
import io.reactivex.disposables.Disposable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.ExceptionsKt;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001:\u0001\u0002¨\u0006\u0003"}, d2 = {"Lcom/bytedance/android/live/revlink/impl/multianchor/widget/RevLinkAnchorWidget;", "Lcom/bytedance/android/live/core/tetris/widgets/LiveWidget;", "a", "liverevlink-impl_saasRelease"}, k = 1, mv = {1, 5, 1})
public final class RevLinkAnchorWidget extends LiveWidget {
    public final Lazy a;
    public com.bytedance.android.live.revlink.widgetservice.a b;
    public g c;
    public DialogLaunchService d;
    public b e;
    public l f;
    public RevLinkAnchorLaunchParam g;
    public final RevLinkAnchorLaunchParam h;
    public final u51.b i;
    public final o11.a j;
    public final com.bytedance.android.livesdk.revenue.service.room.c k;
    public final wq2.f l;
    public final ld.a m;
    public final x11.a n;
    public final Function0<v> o;

    public static final class a {
    }

    static {
    }

    public final int getLayoutId() {
        return 2131566213;
    }

    public final void onCreate() {
        super.onCreate();
        this.g = this.h;
        if (((RTCBizManagerService) this.a.getValue()) == null) goto L5;
        Intrinsics.checkNotNullParameter(this.h, "launchParam");
    L5:
        View r1 = ((Widget) this).contentView;
        if (r1 == null) goto L88;
        JatoOptFrameLayout r9 = (MultiOptFrameLayout) r1.findViewById(2131380435);
        if (r9 == null) goto L89;
        com.bytedance.android.live.revlink.impl.settings.dynamic.b r2 = com.bytedance.android.live.revlink.impl.settings.dynamic.b.m;
        r2.getClass();
        r9.setHasFixSize(((Boolean) com.bytedance.android.live.revlink.impl.settings.dynamic.b.e.getValue(r2, com.bytedance.android.live.revlink.impl.settings.dynamic.b.a[3])).booleanValue());
        View r3 = ((Widget) this).contentView;
        if (r3 == null) goto L12;
        FrameLayout r4 = (FrameLayout) r3.findViewById(2131384483);
    L12:
        View r5 = ((Widget) this).contentView;
        if (r5 == null) goto L15;
        FrameLayout r6 = (FrameLayout) r5.findViewById(2131384481);
    L16:
        LynxCentralManager r7 = new LynxCentralManager(r9, (vy0.c) com.bytedance.android.live.revenue.core.util.f.a(vy0.c.class));
        com.bytedance.android.live.revlink.impl.global.c r8 = (com.bytedance.android.live.revlink.impl.global.c) m.e.d(this.j, com.bytedance.android.live.revlink.impl.global.c.class);
        if (r8 == null) goto L70;
        com.bytedance.android.live.revenuelink.rtc.f r10 = r8.m0();
        if (r10 == null) goto L70;
        com.bytedance.android.live.revenuelink.rtc.i r12 = r10.getRtcManager();
        if (r12 == null) goto L70;
        String r13 = this.h.b;
        Function0<v> r14 = this.o;
        com.bytedance.android.live.revlink.link.infra.lifecontrol.context.l.a(r6);
        g r15 = new g(r14, r12, r6, r13, new RevLinkAnchorWidget$onCreate$renderImpl$1(this));
        this.c = r15;
        DialogLaunchService r16 = new DialogLaunchService(((Widget) this).context, ((Widget) this).dataCenter, (IRoom) this.k.getRoomContext().getRoom().getValue(), new RevLinkAnchorWidget$onCreate$dialogLaunchService$1(this));
        this.d = r16;
        enableSubWidgetManager();
        View r17 = ((Widget) this).contentView;
        if (r17 == null) goto L69;
        FrameLayout r18 = (FrameLayout) r17.findViewById(2131384484);
        if (r18 == null) goto L85;
        l r19 = new l(r18, ((Widget) this).context);
        this.f = r19;
        Object r20 = this.k.getRoomContext().getRoom().getValue();
        if ((r20 instanceof IRoom) == true) goto L31;
        r20 = null;
    L31:
        IRoom r22 = (IRoom) r20;
        View r23 = ((Widget) this).contentView;
        if (r23 == null) goto L84;
        FrameLayout r24 = (FrameLayout) r23.findViewById(2131384482);
        if (r24 == null) goto L86;
        b r110 = new b(((Widget) this).context, r22, ((Widget) this).dataCenter, r24, r19, ((Widget) this).subWidgetManager, r9);
        this.e = r110;
        RevLinkWindowRegionContext r25 = com.bytedance.android.live.revlink.impl.global.b.f0();
        if (r25 == null) goto L43;
        com.bytedance.live.datacontext.j<com.bytedance.android.live.revlink.impl.multianchor.service.g> r26 = r25.getPartnerService();
        if (r26 == null) goto L43;
        com.bytedance.android.live.revlink.impl.multianchor.service.g r27 = (com.bytedance.android.live.revlink.impl.multianchor.service.g) r26.getValue();
        if (r27 == null) goto L43;
        r27.j(r110);
    L43:
        i r28 = new i(this);
        RevLinkAnchorLaunchParam r29 = this.h;
        u51.b r30 = this.i;
        o11.a r32 = this.j;
        com.bytedance.android.livesdk.revenue.service.room.c r33 = this.k;
        wq2.f r34 = this.l;
        com.bytedance.android.live.revenue.core.util.j.a r35 = com.bytedance.android.live.revenue.core.util.j.C0;
        yz0.f r111 = (yz0.f) com.bytedance.android.live.revenue.core.util.f.d(r35.a(), yz0.f.class);
        com.bytedance.android.live.revenue.core.b r36 = r35.a();
        Intrinsics.checkNotNull(r36);
        com.bytedance.android.livesdk.revenue.service.message.d r112 = com.bytedance.android.live.revenue.core.util.e.b(r36, com.bytedance.android.livesdk.revenue.service.message.d.class);
        ld.a r37 = this.m;
        x11.a r113 = this.n;
        Function0<v> r114 = this.o;
        String r115 = u.e();
        if (r115 != null) goto L46;
        r115 = "";
    L46:
        com.bytedance.android.live.revlink.impl.rtc.a.G0.getClass();
        com.bytedance.android.live.revlink.widgetservice.a r38 = new com.bytedance.android.live.revlink.widgetservice.a(r29, r30, r32, r33, r7, r34, r111, r112, r37, r113, r114, r15, r16, r115, r28, com.bytedance.android.live.revlink.impl.rtc.a.C0196a.a(), r110, r19);
        this.b = r38;
        r38.a();
        jy0.b.c("FrameRenderImpl", "attach", null, 4);
        r15.h.g1(r15);
        HashMap r39 = h0.a(r15.h.L().d());
        LinkedHashMap r40 = new LinkedHashMap();
        Iterator r42 = r39.entrySet().iterator();
    L48:
        if (r42.hasNext() == false) goto L52;
        Map.Entry r43 = (Map.Entry) r42.next();
        if ((!Intrinsics.areEqual((String) r43.getKey(), r15.j)) == false) goto L48;
        r40.put(r43.getKey(), r43.getValue());
        goto L48
    L52:
        Iterator r44 = r40.entrySet().iterator();
    L54:
        if (r44.hasNext() == false) goto L87;
        Map.Entry r45 = (Map.Entry) r44.next();
        String r46 = (String) r45.getKey();
        Object r47 = r45.getValue();
        jy0.b.c("FrameRenderImpl", "get remote view with linkerID: " + r46 + " and rtc render: " + r47, null, 4);
        if ((r47 instanceof SurfaceView) == false) goto L60;
        u11.a r48 = new com.bytedance.android.live.revlink.impl.multianchor.widget.renderframe.c(r15.i, (View) r47);
    L58:
        u11.a r49 = r48;
    L66:
        if (r49 == null) goto L54;
        r15.j(r46, r49, "attach with exist frame");
        goto L54
    L60:
        if ((r47 instanceof TextureView) == false) goto L63;
        r48 = new com.bytedance.android.live.revlink.impl.multianchor.widget.renderframe.c(r15.i, (View) r47);
        goto L58
    L63:
        if ((r47 instanceof fr2.l) == false) goto L65;
        r48 = new com.bytedance.android.live.revlink.impl.multianchor.widget.renderframe.b((fr2.l) r47, false);
        goto L58
    L65:
        r49 = null;
        goto L66
    L87:
        return;
    L86:
        return;
    L84:
        return;
    L85:
        return;
    L69:
        return;
    L70:
        Error r50 = new Error();
        jy0.b.c("RevLinkAnchorWidget", "RevLinkAnchorWidget onCreate crashed with: " + ExceptionsKt.stackTraceToString(r50), null, 4);
        com.bytedance.android.live.revlink.impl.multianchor.utils.v r52 = com.bytedance.android.live.revlink.impl.global.b.C();
        if (r52 == null) goto L90;
        Intrinsics.checkNotNullParameter(r50, "e");
        LinkedHashMap r53 = new LinkedHashMap();
        r53.put("exception", r50.toString());
        r52.H("rev_scope_load_exception", r53);
        return;
    L90:
        return;
    L15:
        r6 = null;
        goto L16
    L89:
        return;
    }

    public final void onDestroy() {
        super.onDestroy();
        com.bytedance.android.live.revlink.widgetservice.a r0 = this.b;
        if (r0 == null) goto L24;
        jy0.b.c("xuzr_log", "RevLinkAnchorFacade detach", null, 4);
        r0.c.clear();
        com.bytedance.android.live.revlink.link.infra.lifecontrol.context.g r4 = r0.b;
        if (r4 == null) goto L9;
        NextLiveData<com.bytedance.android.live.revlink.link.core.layoutstatus.l> r5 = r4.a;
        if (r5 == null) goto L9;
        r5.setValue(new com.bytedance.android.live.revlink.link.core.layoutstatus.l(1, null));
    L9:
        v51.d r6 = r0.a;
        if (r6 == null) goto L12;
        com.bytedance.android.live.revlink.link.utils.a.c(r6);
    L12:
        r0.a = null;
        com.bytedance.android.live.revlink.link.infra.lifecontrol.context.g r7 = r0.b;
        if (r7 == null) goto L17;
        AnchorLinkUserCenterV2 r8 = r7.d.d;
        if (r8 == null) goto L17;
        r8.clear(false);
    L17:
        u51.b r9 = r0.e;
        m.e.getClass();
        RTCAdvanceManagerService r10 = (RTCAdvanceManagerService) m.b(r9).a(Reflection.getOrCreateKotlinClass(RTCAdvanceManagerService.class));
        if (r10 == null) goto L23;
        Disposable r12 = r10.b;
        if (r12 == null) goto L22;
        r12.dispose();
    L22:
        jy0.b.c("RTCAdvanceManagerService", "resetStatus", null, 4);
    L23:
        r0.b = null;
    L24:
        g r1 = this.c;
        if (r1 == null) goto L35;
        jy0.b.c("FrameRenderImpl", "detach", null, 4);
        r1.h.i1(r1);
        r1.i.removeAllViews();
        ((LinkedHashMap) r1.a).clear();
        Iterator<T> r2 = r1.d.iterator();
    L28:
        if (r2.hasNext() == false) goto L30;
        WindowClickImpl r13 = (WindowClickImpl) r2.next();
        r13.e.removeView(r13.a);
        goto L28
    L30:
        r1.d = CollectionsKt.emptyList();
        r1.c = CollectionsKt.emptyList();
        if (r1.f == false) goto L35;
        u11.a r3 = r1.e;
        if (r3 == null) goto L35;
        r3.b(new p(r1.j, new RectF(), new RectF(0.0f, 0.0f, 1.0f, 1.0f)));
    L35:
        RTCBizManagerService r14 = (RTCBizManagerService) this.a.getValue();
        DialogLaunchService r15 = this.d;
        if (r15 == null) goto L113;
        CommonBottomDialog r16 = r15.a;
        if (r16 != null) goto L40;
    L45:
        Iterator r17 = ((LinkedHashMap) r15.b).entrySet().iterator();
    L47:
        if (r17.hasNext() == false) goto L51;
        Map.Entry r18 = (Map.Entry) r17.next();
        AlertBizType r19 = (AlertBizType) r18.getKey();
        j0 r20 = (j0) r18.getValue();
        if (r20.isShowing() == false) goto L47;
        DialogLaunchService.p(r20);
        goto L47
    L51:
        PkMuteCheckDialogFragment r22 = r15.d;
        if (r22 != null) goto L54;
    L64:
        MultiAnchorRecordLinkSimpleDialog r23 = r15.g;
        if (r23 != null) goto L67;
    L77:
        x0 r24 = r15.e;
        if (r24 != null) goto L80;
    L85:
        q46.a r25 = r15.c;
        if (r25 != null) goto L88;
    L109:
        ((LinkedHashMap) r15.b).clear();
        PkFeedbackDialog r26 = r15.f;
        if (r26 == null) goto L112;
        DialogLaunchService.q(r26);
    L112:
        r15.f = null;
        goto L113
    L88:
        if (r25.isShowing() != true) goto L109;
        q46.a r27 = r15.c;
        if (r27 == null) goto L108;
        Handler r28 = DialogLancet.resolveDialogHandler(r27);
        if (r28 != null) goto L94;
    L96:
        DialogLancet.beforeDialogDismiss(r27);
        r27.dismiss();     // Catch: Throwable -> L99 Exception -> L101
    L105:
        DialogLancet.afterDialogDismiss(r27);
        goto L108
    L101:
        e = move-exception;
        com.bytedance.crash.d.d(e, "DIALOG_DISMISS_EXCEPTION");     // Catch: Throwable -> L99
        Throwable r29 = DialogLancet.sLastShowStack;     // Catch: Throwable -> L99
        if (r29 == null) goto L105;
        com.bytedance.crash.d.d(r29, "DIALOG_SHOW_STACK_TRACE");     // Catch: Throwable -> L99
    L99:
        th = move-exception;
        DialogLancet.afterDialogDismiss(r27);
        throw th;
    L94:
        if (Looper.myLooper() == r28.getLooper()) goto L96;
        r28.post(DialogLancet.createDismissRunnable(r27));
    L108:
        r15.c = null;
        goto L109
    L80:
        if (r24.isShowing() != true) goto L85;
        x0 r30 = r15.e;
        if (r30 == null) goto L84;
        DialogLaunchService.n(r30);
    L84:
        r15.e = null;
        goto L85
    L67:
        if (r23.isShowing() != true) goto L77;
        MultiAnchorRecordLinkSimpleDialog r32 = r15.g;
        if (r32 != null) goto L122;
    L76:
        r15.g = null;
        goto L77
    L122:
        r32.dismiss();     // Catch: Exception -> L72
    L72:
        e = move-exception;
        com.bytedance.crash.d.d(e, "DIALOG_FRAGMENT_DISMISS_EXCEPTION");
        Throwable r33 = DialogFragmentLancet.sLastShowStack;
        if (r33 == null) goto L76;
        com.bytedance.crash.d.d(r33, "DIALOG_FRAGMENT_SHOW_STACK_TRACE");
        goto L76
    L54:
        if (r22.isShowing() != true) goto L64;
        PkMuteCheckDialogFragment r34 = r15.d;
        if (r34 != null) goto L120;
    L63:
        r15.d = null;
        goto L64
    L120:
        r34.dismiss();     // Catch: Exception -> L59
    L59:
        e = move-exception;
        com.bytedance.crash.d.d(e, "DIALOG_FRAGMENT_DISMISS_EXCEPTION");
        Throwable r35 = DialogFragmentLancet.sLastShowStack;
        if (r35 == null) goto L63;
        com.bytedance.crash.d.d(r35, "DIALOG_FRAGMENT_SHOW_STACK_TRACE");
        goto L63
    L40:
        if (r16.isShowing() != true) goto L45;
        CommonBottomDialog r36 = r15.a;
        if (r36 == null) goto L44;
        DialogLaunchService.o(r36);
    L44:
        r15.a = null;
    L113:
        b r37 = this.e;
        if (r37 == null) goto L116;
        BackgroundImpl r38 = r37.a;
        r38.e = null;
        r38.f = null;
        r38.h.removeAllViews();
        r37.c.c();
    L116:
        l r39 = this.f;
        if (r39 == null) goto L133;
        r39.c();
        return;
    }

    public final void onPause() {
        super.onPause();
        com.bytedance.android.live.revlink.widgetservice.a r0 = this.b;
        if (r0 == null) goto L12;
        com.bytedance.android.live.revlink.link.infra.lifecontrol.context.g r1 = r0.b;
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
        com.bytedance.android.live.revlink.widgetservice.a r0 = this.b;
        if (r0 == null) goto L12;
        com.bytedance.android.live.revlink.link.infra.lifecontrol.context.g r1 = r0.b;
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
        com.bytedance.android.live.revlink.widgetservice.a r0 = this.b;
        if (r0 == null) goto L17;
        if (r3 == null) goto L6;
        b03.b r4 = zr0.b.a(r3);
    L7:
        com.bytedance.android.live.revlink.link.infra.lifecontrol.context.g r1 = r0.b;
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

    public RevLinkAnchorWidget(RevLinkAnchorLaunchParam r2, u51.d r3, o11.a r4, com.bytedance.android.livesdk.revenue.service.room.c r5, wq2.f r6, ld.a r7, x11.a r8, Function0 r9) {
        Intrinsics.checkNotNullParameter(r2, "launchParam");
        Intrinsics.checkNotNullParameter(r3, "infraScope");
        Intrinsics.checkNotNullParameter(r4, "linkScope");
        Intrinsics.checkNotNullParameter(r5, "revRoomService");
        Intrinsics.checkNotNullParameter(r6, "roomDataCenterService");
        Intrinsics.checkNotNullParameter(r9, "liveVideoClientFactoryGetter");
        this.h = r2;
        this.i = r3;
        this.j = r4;
        this.k = r5;
        this.l = r6;
        this.m = r7;
        this.n = r8;
        this.o = r9;
        this.a = LazyKt.lazy(new RevLinkAnchorWidget$rtcBizManagerService$2(this));
    }
}
