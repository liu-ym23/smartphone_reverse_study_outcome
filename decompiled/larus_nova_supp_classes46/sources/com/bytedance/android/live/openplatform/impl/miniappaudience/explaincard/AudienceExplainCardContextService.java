package com.bytedance.android.live.openplatform.impl.miniappaudience.explaincard;

import android.os.Handler;
import android.os.Looper;
import android.os.SystemClock;
import android.view.View;
import com.bytedance.android.live.core.utils.v;
import com.bytedance.android.live.liveinteract.api.IInteractService;
import com.bytedance.android.live.openplatform.api.constant.MountedMiniAppSource;
import com.bytedance.android.live.openplatform.api.model.shelf.ShelfCardInfo;
import com.bytedance.android.live.openplatform.api.model.shelf.ShelfInfo;
import com.bytedance.android.live.openplatform.impl.base.context.OpenPlatformContext;
import com.bytedance.android.live.openplatform.impl.base.context.OpenPlatformContextService;
import com.bytedance.android.live.openplatform.impl.base.perf.PerformanceScene;
import com.bytedance.android.live.openplatform.impl.base.utils.w;
import com.bytedance.android.live.openplatform.impl.miniappaudience.entrancemonitor.EntranceMonitorContextService;
import com.bytedance.android.live.openplatform.impl.miniappaudience.entrancemonitor.EntranceType;
import com.bytedance.android.live.openplatform.impl.miniappaudience.explaincard.atmosphere.hot.MiniAppHotAtmosphereView;
import com.bytedance.android.live.openplatform.impl.miniappaudience.shelf.AudienceShelfSupplementInfoContextService;
import com.bytedance.android.live.openplatform.impl.miniappcommon.explaincard.MiniAppExplainCard;
import com.bytedance.android.livesdk.chatroom.RoomContext;
import com.bytedance.android.livesdk.config.de0;
import com.bytedance.android.livesdk.config.ee0;
import com.bytedance.android.livesdk.config.uc1;
import com.bytedance.android.livesdk.config.wc1;
import com.bytedance.android.livesdk.vscore_api.paid.PaidSceneEnum;
import com.bytedance.ies.sdk.widgets.DataCenter;
import com.bytedance.live.datacontext.j;
import com.larus.apm.impl.protector.RunnableProtector;
import java.util.HashMap;
import java.util.List;
import java.util.ListIterator;
import jc1.k;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import zo0.h;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001:\u0001\u0006B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005¨\u0006\u0007"}, d2 = {"Lcom/bytedance/android/live/openplatform/impl/miniappaudience/explaincard/AudienceExplainCardContextService;", "Lcom/bytedance/android/live/openplatform/impl/base/context/OpenPlatformContextService;", "Lcom/bytedance/android/live/openplatform/impl/base/context/OpenPlatformContext;", "openPlatformContext", "<init>", "(Lcom/bytedance/android/live/openplatform/impl/base/context/OpenPlatformContext;)V", "a", "liveopenplatform-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class AudienceExplainCardContextService extends OpenPlatformContextService {
    public static final /* synthetic */ int h = 0;
    public View a;
    public boolean b;
    public AudienceExplainCardWidget<com.bytedance.android.live.openplatform.impl.miniappcommon.explaincard.b> c;
    public final w d;
    public final Handler e;
    public final b f;
    public AudienceExplainCardContextService$tryShowExplainCard$1 g;

    public static final class a {
    }

    public static final class b implements Runnable {
        public final /* synthetic */ AudienceExplainCardContextService a;

        public b(AudienceExplainCardContextService r1) {
            this.a = r1;
        }

        @Override // java.lang.Runnable
        public final void run() {
            AudienceExplainCardContextService r0 = this.a;     // Catch: Throwable -> L4
            int r1 = AudienceExplainCardContextService.h;     // Catch: Throwable -> L4
            r0.f(false);     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }
    }

    static {
    }

    @Override // com.bytedance.android.live.openplatform.impl.base.context.OpenPlatformContextService
    public final void onDestroy() {
        super.onDestroy();
        AudienceExplainCardWidget<com.bytedance.android.live.openplatform.impl.miniappcommon.explaincard.b> r0 = this.c;
        if (r0 == null) goto L5;
        r0.g.d();
    L5:
        this.e.removeCallbacksAndMessages(null);
        DataCenter r1 = getOpenPlatformContext().getDataCenter();
        if (r1 == null) goto L9;
        r1.removeObserver(this.g);
        return;
    }

    public AudienceExplainCardContextService(OpenPlatformContext r2) {
        Intrinsics.checkNotNullParameter(r2, "openPlatformContext");
        super(r2);
        this.d = new w();
        this.e = new Handler(Looper.getMainLooper());
        this.f = new b(this);
    }

    public final void f(boolean r4) {
        if (m71.e.c(10) == false) goto L6;
        return;
    L6:
        if (this.b == true) goto L8;
        return;
    L8:
        this.b = false;
        this.e.removeCallbacks(this.f);
        AudienceExplainCardWidget<com.bytedance.android.live.openplatform.impl.miniappcommon.explaincard.b> r0 = this.c;
        if (r0 != null) goto L11;
        return;
    L11:
        this.d.a("register hide tasks", new AudienceExplainCardContextService$hideExplainCard$1(this, r0, r4));
    }

    public final void h(ShelfInfo r4, boolean r5) {
        com.bytedance.android.live.openplatform.impl.miniappcommon.explaincard.b r6 = com.bytedance.android.live.openplatform.impl.miniappcommon.explaincard.c.a(r4);
        AudienceExplainCardWidget<com.bytedance.android.live.openplatform.impl.miniappcommon.explaincard.b> r0 = this.c;
        if (r0 == null) goto L5;
        r0.setData(r6);
    L5:
        AudienceExplainCardWidget<com.bytedance.android.live.openplatform.impl.miniappcommon.explaincard.b> r1 = this.c;
        if (r1 == null) goto L8;
        r1.setOnClickBlock(new AudienceExplainCardContextService$getOnExplainCardClickListener$1(this, MountedMiniAppSource.ExplainCard, r5));
    L8:
        AudienceExplainCardWidget<com.bytedance.android.live.openplatform.impl.miniappcommon.explaincard.b> r2 = this.c;
        if (r2 == null) goto L11;
        r2.setOnBtnClickBlock(new AudienceExplainCardContextService$getOnExplainCardClickListener$1(this, MountedMiniAppSource.ExplainCardButton, r5));
    L11:
        AudienceShelfSupplementInfoContextService r7 = (AudienceShelfSupplementInfoContextService) getOpenPlatformContext().getService(AudienceShelfSupplementInfoContextService.class);
        if (r6 == null) goto L14;
        Long r8 = Long.valueOf(r6.a);
    L15:
        com.bytedance.android.livesdk.wrds.syncdata.openplatform.a r9 = r7.f(r8);
        if (r9 == null) goto L21;
        AudienceExplainCardWidget<com.bytedance.android.live.openplatform.impl.miniappcommon.explaincard.b> r10 = this.c;
        if (r10 == null) goto L22;
        r10.setSupplementInfo(r9);
        return;
    L22:
        return;
    L21:
        return;
    L14:
        r8 = null;
        goto L15
    }

    public final void g(final ShelfInfo r13, boolean r14, boolean r15) {
        if (m71.e.c(10) == false) goto L6;
        return;
    L6:
        if (((IInteractService) k.n(IInteractService.class)).isLinkCasting() == false) goto L9;
        ((EntranceMonitorContextService) getOpenPlatformContext().getService(EntranceMonitorContextService.class)).f(EntranceType.Shelf).a("is casting", null);
        return;
    L9:
        DataCenter r0 = getOpenPlatformContext().getDataCenter();
        if (r0 == null) goto L12;
        Boolean r1 = (Boolean) r0.get("cmd_commerce_ad_show", Boolean.FALSE);
    L14:
        if (Intrinsics.areEqual(r1, Boolean.TRUE) == false) goto L17;
        return;
    L17:
        if (com.bytedance.android.livesdk.vscore_api.paidlive.c.a.b(com.bytedance.android.livesdk.vscore_api.paidlive.scope.g.d(getOpenPlatformContext().getDataCenter()), PaidSceneEnum.PAID_ROOM, 2) == true) goto L19;
        return;
    L19:
        List<ShelfCardInfo> r2 = r13.cardInfoList;
        if (r2 == null) goto L71;
        ListIterator<ShelfCardInfo> r3 = r2.listIterator(r2.size());
    L22:
        boolean r4 = true;
        if (r3.hasPrevious() == false) goto L30;
        ShelfCardInfo r5 = r3.previous();
        if (r5.getStatus() != 1) goto L27;
        boolean r6 = true;
    L28:
        if (r6 == false) goto L22;
    L31:
        ShelfCardInfo r7 = r5;
        if (r7 == null) goto L79;
        HashMap<String, zo0.f> r8 = zo0.g.a;
        zo0.f r9 = h.b(PerformanceScene.EXPLAIN_CARD);
        r9.o();
        r9.m("is_from_enter", r14);
        this.b = true;
        uc1 r10 = (uc1) ee0.a.getValue();
        if (r10 == null) goto L39;
        if (r10.d() != 1) goto L39;
    L42:
        if (r4 == false) goto L46;
        this.e.removeCallbacks(this.f);
        if (r7.f0() <= 0) goto L46;
        this.e.postDelayed(this.f, ((long) r7.f0()) * 1000);
    L46:
        RoomContext r11 = RoomContext.a.c(RoomContext.Companion, null, 0, 3);
        if (r11 == null) goto L52;
        j r12 = r11.getToolbarBubbleManager();
        if (r12 == null) goto L52;
        r12.c(new AudienceExplainCardContextService$realShowExplainCard$1(this));
    L52:
        if (this.c == null) goto L54;
    L57:
        AudienceExplainCardWidget<com.bytedance.android.live.openplatform.impl.miniappcommon.explaincard.b> r16 = this.c;
        if (r16 != null) goto L60;
        return;
    L60:
        w r17 = this.d;
        int r18 = w.d;
        monitor-enter(r17);
    L68:
        th = move-exception;
        throw th;
    L63:
        if ((SystemClock.uptimeMillis() - r17.c) < 10000) goto L65;
        v.a();     // Catch: Throwable -> L68
        r17.a.clear();     // Catch: Throwable -> L68
    L65:
        monitor-exit(r17);
        this.d.a("register show tasks", new AudienceExplainCardContextService$realShowExplainCard$2(this, r16, r15, r13, r14));
        return;
    L54:
        if (this.a == null) goto L56;
        qo0.a.c("AudienceExplainCardContextService", "content view is preloaded");
    L56:
        AudienceExplainCardWidget<com.bytedance.android.live.openplatform.impl.miniappcommon.explaincard.b> r19 = new AudienceExplainCardWidget(getOpenPlatformContext().getContext(), getOpenPlatformContext().getRoomId(), new f(getOpenPlatformContext(), new MiniAppExplainCard(getOpenPlatformContext().getContext(), null, 0, this.a), new MiniAppHotAtmosphereView(getOpenPlatformContext().getContext(), null, 6, 0)));
        r19.setData(com.bytedance.android.live.openplatform.impl.miniappcommon.explaincard.c.a(r13));
        r19.setOnCloseBlock(new AudienceExplainCardContextService$createExplainCardWidget$$inlined$apply$lambda$1(this, r13));
        r19.setOnClickBlock(new AudienceExplainCardContextService$getOnExplainCardClickListener$1(this, MountedMiniAppSource.ExplainCard, false));
        r19.setOnBtnClickBlock(new AudienceExplainCardContextService$getOnExplainCardClickListener$1(this, MountedMiniAppSource.ExplainCardButton, false));
        this.c = r19;
    L39:
        if (r13.coexistKAAnchor == 1) goto L42;
        r4 = false;
        goto L42
    L79:
        return;
    L27:
        r6 = false;
        goto L28
    L30:
        r5 = null;
        goto L31
    L71:
        return;
    L12:
        r1 = null;
        goto L14
    }

    /* JADX WARN: Type inference failed for: r9v11, types: [com.bytedance.android.live.openplatform.impl.miniappaudience.explaincard.AudienceExplainCardContextService$tryShowExplainCard$1] */
    public static void i(final AudienceExplainCardContextService r5, final ShelfInfo r6, final boolean r7, final boolean r8, int r9) {
        if ((r9 & 2) == 0) goto L6;
        r7 = false;
    L6:
        if ((r9 & 4) == 0) goto L8;
        r8 = false;
    L8:
        r5.getClass();
        Intrinsics.checkNotNullParameter(r6, "shelfInfo");
        if (r7 == true) goto L11;
    L13:
        boolean r0 = false;
    L14:
        if (r0 == false) goto L25;
        DataCenter r1 = r5.getOpenPlatformContext().getDataCenter();
        if (r1 == null) goto L18;
        String r2 = (String) r1.get("data_right_card_loaded", "");
    L20:
        if ((true ^ Intrinsics.areEqual(r2, "3")) == false) goto L24;
        int r10 = qo0.a.a;
        qo0.a.c("Perf", "right card widget is not loaded, wait until load, curr time: " + SystemClock.uptimeMillis());
        r5.g = new AudienceExplainCardContextService$tryShowExplainCard$1(r5, r6, r7, r8);
        DataCenter r11 = r5.getOpenPlatformContext().getDataCenter();
        if (r11 == null) goto L27;
        r11.observe("data_right_card_loaded", r5.g, false);
        return;
    L27:
        return;
    L24:
        int r12 = qo0.a.a;
        qo0.a.c("Perf", "right card widget is already loaded, show explain card, curr time: " + SystemClock.uptimeMillis());
        r5.g(r6, r7, r8);
        return;
    L18:
        r2 = null;
        goto L20
    L25:
        r5.g(r6, r7, r8);
        return;
    L11:
        if (((wc1) de0.a.getValue()).b() != 1) goto L13;
        r0 = true;
        goto L14
    }
}
