package com.bytedance.android.livesdk.gift.platform.business.dialog.v3.viewModel;

import com.bytedance.android.anya.MVIState;
import com.bytedance.android.anya.j0;
import com.bytedance.android.anya.k0;
import com.bytedance.android.anya.l0;
import com.bytedance.android.anya.p;
import com.bytedance.android.anya.r;
import com.bytedance.android.anya.r0;
import com.bytedance.android.anya.v;
import com.bytedance.android.live.revenue.model.extension.main.IMainGiftRoom;
import com.bytedance.android.livesdk.gift.model.h1;
import com.bytedance.android.livesdk.gift.platform.business.dialog.v3.stateMachine.ChangeDSHeightAction;
import com.bytedance.android.livesdk.gift.platform.business.dialog.v3.stateMachine.GiftAction;
import com.bytedance.android.livesdk.gift.platform.business.dialog.v3.stateMachine.GiftDSNoticeState;
import com.bytedance.android.livesdk.gift.platform.business.dialog.v3.stateMachine.GiftListBusinessState;
import com.bytedance.android.livesdk.gift.platform.business.dialog.v3.stateMachine.GiftPanelState;
import com.bytedance.android.livesdk.gift.platform.business.dialog.v3.stateMachine.GiftReceiverViewState;
import com.bytedance.android.livesdk.gift.platform.business.dialog.v3.stateMachine.GiftVerticalState;
import com.bytedance.android.scope.o;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class GiftMVIDSNoticeViewModel extends com.bytedance.android.anya.f<GiftPanelState, GiftDSNoticeState, GiftAction> implements o {
    public final yz0.k u;

    public final void onStart() {
    }

    public final void onStop() {
    }

    public GiftMVIDSNoticeViewModel(yz0.k r2) {
        Intrinsics.checkNotNullParameter(r2, "roomDataService");
        this.u = r2;
    }

    public final MVIState F(l0 r4) {
        Intrinsics.checkNotNullParameter(r4, "$this$createState");
        GiftDSNoticeState r0 = new GiftDSNoticeState();
        IMainGiftRoom r1 = this.u.getRoom().castToOrNull(IMainGiftRoom.class);
        if (r1 == null) goto L9;
        com.bytedance.android.live.revenue.model.extension.main.c r2 = r1.getOthers();
        if (r2 == null) goto L9;
        com.bytedance.android.live.revenue.model.extension.main.b r3 = r2.getGiftPanelTopperTray();
        if (r3 == null) goto L9;
        r0<GiftDSNoticeState, com.bytedance.android.live.revenue.model.extension.main.b> r5 = r0.getGiftDSNoticeInfo();
        r4.getClass();
        l0.h(r5, r3);
    L9:
        return r0;
    }

    public final void d(com.bytedance.android.anya.dsl.h<GiftPanelState, GiftAction> r4) {
        Intrinsics.checkNotNullParameter(r4, "$this$bindToParent");
        GiftMVIDSNoticeViewModel$bindToParent$1 r0 = GiftMVIDSNoticeViewModel$bindToParent$1.INSTANCE;
        List r5 = r4.a;
        ArrayList r6 = (ArrayList) r5;
        r6.add(new com.bytedance.android.anya.dsl.i(this, r0, GiftAction.class));
    }

    public final void w0(j0 r9, MVIState r10, p r11) {
        GiftDSNoticeState r13 = (GiftDSNoticeState) r10;
        Intrinsics.checkNotNullParameter(r9, "$this$postReduce");
        Intrinsics.checkNotNullParameter(r13, "state");
        Intrinsics.checkNotNullParameter((GiftAction) r11, "action");
        com.bytedance.android.anya.internal.p r14 = r9.getContext();
        boolean r0 = false;
        com.bytedance.android.anya.internal.c r15 = (v) r14.a(r14.b(r14.c(GiftPanelState.class), GiftMVIDSNoticeViewModel$postReduce$1$tmp$1.INSTANCE), GiftMVIDSNoticeViewModel$postReduce$1$tmp$2.INSTANCE).a.invoke();
        if (r15 == null) goto L64;
        com.bytedance.android.anya.internal.c r3 = r15;
        Object r4 = r15.c();     // Catch: Throwable -> L89
        int r5 = r15.c;     // Catch: Throwable -> L89
        Object r6 = ((LinkedHashMap) r9.d).get(r15);     // Catch: Throwable -> L89
        if (r6 != null) goto L10;
        r6 = 0;
    L10:
        if (r5 <= ((Number) r6).intValue()) goto L12;
        boolean r7 = true;
    L13:
        if (r7 == false) goto L61;
        k0 r8 = j0.a.a;     // Catch: Throwable -> L89
        r8.getClass();     // Catch: Throwable -> L89
        r r16 = ((GiftVerticalState) r4).toBusinessState(r8);     // Catch: Throwable -> L89
        String r17 = null;
        if ((r16 instanceof GiftListBusinessState.GiftSelected) == true) goto L17;
        r16 = null;
    L17:
        GiftListBusinessState.GiftSelected r18 = (GiftListBusinessState.GiftSelected) r16;     // Catch: Throwable -> L89
        if (r18 == null) goto L60;
        vz1.e r19 = r18.getIconModel();     // Catch: Throwable -> L89
        if (r19 == null) goto L60;
        h1 r20 = r19.a;     // Catch: Throwable -> L89
        if (r20 == null) goto L60;
        GiftDSNoticeState r21 = (GiftDSNoticeState) r9.g.f();     // Catch: Throwable -> L89
        String r23 = r20.getBannerScheme();     // Catch: Throwable -> L89
        if (r23 != null) goto L27;
    L30:
        boolean r24 = true;
    L31:
        if (r24 == true) goto L33;
        boolean r25 = true;
    L35:
        if (((Boolean) com.bytedance.android.anya.h.b(r13.getHasReceiverWidget())).booleanValue() == true) goto L55;
        if (r25 == true) goto L55;
        IMainGiftRoom r26 = this.u.getRoom().castToOrNull(IMainGiftRoom.class);     // Catch: Throwable -> L89
        if (r26 == null) goto L44;
        com.bytedance.android.live.revenue.model.extension.main.c r27 = r26.getOthers();     // Catch: Throwable -> L89
        if (r27 == null) goto L44;
        com.bytedance.android.live.revenue.model.extension.main.b r28 = r27.getGiftPanelTopperTray();     // Catch: Throwable -> L89
        if (r28 == null) goto L44;
        r17 = r28.getPanelSchema();     // Catch: Throwable -> L89
    L44:
        if (r17 != null) goto L46;
    L49:
        boolean r29 = true;
    L51:
        if ((!r29) == false) goto L55;
        if (this.u.isPortraitInteraction() == false) goto L55;
        boolean r30 = true;
    L56:
        l0.h(r13.getShouldShow(), Boolean.valueOf(r30));     // Catch: Throwable -> L89
        if (r30 == true) goto L61;
        l0.h(r13.getDsHeight(), 0);     // Catch: Throwable -> L89
        goto L61
    L46:
        if (r17.length() == 0) goto L49;
        r29 = false;
    L55:
        r30 = false;
        goto L56
    L33:
        r25 = false;
        goto L35
    L27:
        if (r23.length() == 0) goto L30;
        r24 = false;
    L60:
        r9.c.put(r15, Integer.valueOf(r3.c));
        return;
    L61:
        if (r7 == false) goto L63;
        r9.a();     // Catch: Throwable -> L89
    L63:
        r9.c.put(r15, Integer.valueOf(r3.c));
        goto L64
    L12:
        r7 = false;
    L89:
        th = move-exception;
        r9.c.put(r15, Integer.valueOf(r3.c));
        throw th;
    L64:
        com.bytedance.android.anya.internal.p r110 = r9.getContext();
        com.bytedance.android.anya.internal.c r111 = (v) r110.a(r110.b(r110.c(GiftPanelState.class), GiftMVIDSNoticeViewModel$postReduce$3$tmp$1.INSTANCE), GiftMVIDSNoticeViewModel$postReduce$3$tmp$2.INSTANCE).a.invoke();
        if (r111 == null) goto L97;
        com.bytedance.android.anya.internal.c r31 = r111;
        Object r33 = r111.c();     // Catch: Throwable -> L86
        int r34 = r111.c;     // Catch: Throwable -> L86
        Object r35 = ((LinkedHashMap) r9.d).get(r111);     // Catch: Throwable -> L86
        if (r35 != null) goto L72;
        r35 = 0;
    L72:
        if (r34 <= ((Number) r35).intValue()) goto L74;
        boolean r36 = true;
    L75:
        if (r36 == false) goto L82;
        j0.a r37 = j0.a.a;     // Catch: Throwable -> L86
        GiftReceiverViewState.Mode r38 = (GiftReceiverViewState.Mode) r33;     // Catch: Throwable -> L86
        GiftDSNoticeState r39 = (GiftDSNoticeState) r9.g.f();     // Catch: Throwable -> L86
        r0<GiftDSNoticeState, Boolean> r40 = r13.getHasReceiverWidget();     // Catch: Throwable -> L86
        GiftReceiverViewState.Mode r41 = GiftReceiverViewState.Mode.IDLE;     // Catch: Throwable -> L86
        if (r38 == r41) goto L79;
        r0 = true;
    L79:
        l0.h(r40, Boolean.valueOf(r0));     // Catch: Throwable -> L86
        if (r38 == r41) goto L82;
        l0.h(r13.getShouldShow(), Boolean.FALSE);     // Catch: Throwable -> L86
        l0.h(r13.getDsHeight(), 0);     // Catch: Throwable -> L86
    L82:
        if (r36 == false) goto L84;
        r9.a();     // Catch: Throwable -> L86
    L84:
        r9.c.put(r111, Integer.valueOf(r31.c));
        return;
    L74:
        r36 = false;
    L86:
        th = move-exception;
        r9.c.put(r111, Integer.valueOf(r31.c));
        throw th;
    }

    public final void y0(l0 r2, MVIState r3, p r4) {
        GiftDSNoticeState r5 = (GiftDSNoticeState) r3;
        GiftAction r6 = (GiftAction) r4;
        Intrinsics.checkNotNullParameter(r2, "$this$reduce");
        Intrinsics.checkNotNullParameter(r5, "state");
        Intrinsics.checkNotNullParameter(r6, "action");
        if ((r6 instanceof ChangeDSHeightAction) == false) goto L8;
        r0<GiftDSNoticeState, Boolean> r0 = r5.getShouldShow();
        r2.getClass();
        if (((Boolean) com.bytedance.android.anya.h.b(r0)).booleanValue() == false) goto L9;
        l0.h(r5.getDsHeight(), Integer.valueOf(((ChangeDSHeightAction) r6).getHeight()));
        return;
    L9:
        return;
    }
}
