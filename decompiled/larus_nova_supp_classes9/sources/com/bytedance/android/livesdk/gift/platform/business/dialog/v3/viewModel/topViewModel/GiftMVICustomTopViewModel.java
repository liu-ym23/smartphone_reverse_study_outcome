package com.bytedance.android.livesdk.gift.platform.business.dialog.v3.viewModel.topViewModel;

import com.bytedance.android.anya.MVIState;
import com.bytedance.android.anya.dsl.h;
import com.bytedance.android.anya.dsl.i;
import com.bytedance.android.anya.j0;
import com.bytedance.android.anya.k0;
import com.bytedance.android.anya.l0;
import com.bytedance.android.anya.p;
import com.bytedance.android.anya.r;
import com.bytedance.android.anya.r0;
import com.bytedance.android.anya.v;
import com.bytedance.android.live.revenue.common.ToastUtil;
import com.bytedance.android.live.revenue.common.u;
import com.bytedance.android.livesdk.gift.model.g0;
import com.bytedance.android.livesdk.gift.model.h1;
import com.bytedance.android.livesdk.gift.model.h2;
import com.bytedance.android.livesdk.gift.model.q3;
import com.bytedance.android.livesdk.gift.platform.business.dialog.v3.repo.GiftExtraRepo;
import com.bytedance.android.livesdk.gift.platform.business.dialog.v3.stateMachine.ClickCustomBuyView;
import com.bytedance.android.livesdk.gift.platform.business.dialog.v3.stateMachine.ClickCustomGiftIcon;
import com.bytedance.android.livesdk.gift.platform.business.dialog.v3.stateMachine.CustomData;
import com.bytedance.android.livesdk.gift.platform.business.dialog.v3.stateMachine.GiftAction;
import com.bytedance.android.livesdk.gift.platform.business.dialog.v3.stateMachine.GiftCustomBarViewState;
import com.bytedance.android.livesdk.gift.platform.business.dialog.v3.stateMachine.GiftListBusinessState;
import com.bytedance.android.livesdk.gift.platform.business.dialog.v3.stateMachine.GiftPanelState;
import com.bytedance.android.livesdk.gift.platform.business.dialog.v3.stateMachine.GiftTopViewState;
import com.bytedance.android.livesdk.gift.platform.business.dialog.v3.stateMachine.GiftVerticalState;
import com.bytedance.android.livesdk.gift.platform.business.dialog.v3.stateMachine.OpenCustomBuyPage;
import com.bytedance.android.livesdk.gift.platform.business.dialog.v3.viewModel.l;
import com.bytedance.android.livesdk.gift.platform.core.manager.GiftManagerKt;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;
import py.k;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class GiftMVICustomTopViewModel extends com.bytedance.android.anya.f<GiftTopViewState, GiftCustomBarViewState, GiftAction> implements l<GiftCustomBarViewState, GiftAction> {
    public vz1.e u;
    public final GiftExtraRepo v;

    public final void onStart() {
    }

    public final void onStop() {
    }

    public GiftMVICustomTopViewModel(GiftExtraRepo r2) {
        Intrinsics.checkNotNullParameter(r2, "giftExtraRepo");
        this.v = r2;
    }

    public final MVIState F(l0 r2) {
        Intrinsics.checkNotNullParameter(r2, "$this$createState");
        return new GiftCustomBarViewState();
    }

    public final void d(h<GiftTopViewState, GiftAction> r4) {
        Intrinsics.checkNotNullParameter(r4, "$this$bindToParent");
        GiftMVICustomTopViewModel$bindToParent$1 r0 = GiftMVICustomTopViewModel$bindToParent$1.INSTANCE;
        List r5 = r4.a;
        ArrayList r6 = (ArrayList) r5;
        r6.add(new i(this, r0, GiftAction.class));
    }

    public final void w0(j0 r11, MVIState r13, p r14) {
        GiftCustomBarViewState r15 = (GiftCustomBarViewState) r13;
        Intrinsics.checkNotNullParameter(r11, "$this$postReduce");
        Intrinsics.checkNotNullParameter(r15, "state");
        Intrinsics.checkNotNullParameter((GiftAction) r14, "action");
        com.bytedance.android.anya.internal.p r16 = r11.getContext();
        com.bytedance.android.anya.internal.p.b r17 = r16.a(r16.b(r16.c(GiftPanelState.class), GiftMVICustomTopViewModel$postReduce$1$wrapped$1.INSTANCE), GiftMVICustomTopViewModel$postReduce$1$wrapped$2.INSTANCE);
        boolean r0 = false;
        Object r1 = 0;
        com.bytedance.android.anya.internal.c r18 = (v) r17.a.invoke();
        if (r18 == null) goto L54;
        com.bytedance.android.anya.internal.c r2 = r18;
        Object r3 = r18.c();     // Catch: Throwable -> L49
        int r4 = r18.c;     // Catch: Throwable -> L49
        Object r5 = ((LinkedHashMap) r11.d).get(r18);     // Catch: Throwable -> L49
        if (r5 == null) goto L11;
        r1 = r5;
    L11:
        if (r4 <= ((Number) r1).intValue()) goto L13;
        r0 = true;
    L13:
        if (r0 == false) goto L45;
        k0 r6 = j0.a.a;     // Catch: Throwable -> L49
        r6.getClass();     // Catch: Throwable -> L49
        r r7 = ((GiftVerticalState) r3).toBusinessState(r6);     // Catch: Throwable -> L49
        if ((r7 instanceof GiftListBusinessState.GiftSelected) == false) goto L45;
        if (((GiftListBusinessState.GiftSelected) r7).getIconModel() == null) goto L45;
        GiftCustomBarViewState r8 = (GiftCustomBarViewState) r11.g.f();     // Catch: Throwable -> L49
        vz1.e r9 = ((GiftListBusinessState.GiftSelected) r7).getIconModel();     // Catch: Throwable -> L49
        this.u = r9;     // Catch: Throwable -> L49
        g0 r10 = this.v.q(r9.a.getId());     // Catch: Throwable -> L49
        if (r10 == null) goto L45;
        q3 r19 = r10.getSubscribeGiftPackInfo();     // Catch: Throwable -> L49
        if (r19 == null) goto L45;
        h2 r20 = GiftManagerKt.l(r10.getGiftId());     // Catch: Throwable -> L49
        h2 r21 = GiftManagerKt.l(r19.getRelatedGiftId());     // Catch: Throwable -> L49
        if (r19.getLeftScores() <= 0) goto L34;
        if (r20 == null) goto L30;
        com.bytedance.android.livesdk.gift.model.k0 r23 = r20.getGiftPreviewInfo();     // Catch: Throwable -> L49
        if (r23 == null) goto L30;
        if (r23.getLockStatus() == com.bytedance.android.livesdk.gift.model.k0.UNLOCKED) goto L34;
    L30:
        if (r20 == null) goto L34;
        com.bytedance.android.livesdk.gift.model.k0 r24 = r20.getGiftPreviewInfo();     // Catch: Throwable -> L49
        if (r24 == null) goto L34;
        r24.setLockStatus(com.bytedance.android.livesdk.gift.model.k0.UNLOCKED);     // Catch: Throwable -> L49
    L34:
        if (r21 == null) goto L45;
        l0.h(r15.getGiftName(), r21.getName());     // Catch: Throwable -> L49
        r0<GiftCustomBarViewState, k> r25 = r15.getGiftImage();     // Catch: Throwable -> L49
        k r26 = r21.getImage();     // Catch: Throwable -> L49
        if (r26 != null) goto L38;
        r26 = (k) vh7.f.c(k.class);     // Catch: Throwable -> L49
    L38:
        l0.h(r25, r26);     // Catch: Throwable -> L49
        r0<GiftCustomBarViewState, CustomData> r110 = r15.getCustomData();     // Catch: Throwable -> L49
        if (r20 == null) goto L43;
        com.bytedance.android.livesdk.gift.model.k0 r27 = r20.getGiftPreviewInfo();     // Catch: Throwable -> L49
        if (r27 == null) goto L43;
        long r28 = r27.getLockStatus();     // Catch: Throwable -> L49
    L44:
        l0.h(r110, new CustomData(r19, r28));     // Catch: Throwable -> L49
    L43:
        r28 = com.bytedance.android.livesdk.gift.model.k0.UNLOCKED;     // Catch: Throwable -> L49
    L45:
        if (r0 == false) goto L47;
        r11.a();     // Catch: Throwable -> L49
    L47:
        r11.c.put(r18, Integer.valueOf(r2.c));
        return;
    L49:
        th = move-exception;
        r11.c.put(r18, Integer.valueOf(r2.c));
        throw th;
    }

    public final void y0(l0 r7, MVIState r8, p r9) {
        GiftCustomBarViewState r10 = (GiftCustomBarViewState) r8;
        GiftAction r11 = (GiftAction) r9;
        Intrinsics.checkNotNullParameter(r7, "$this$reduce");
        Intrinsics.checkNotNullParameter(r10, "state");
        Intrinsics.checkNotNullParameter(r11, "action");
        T0(r10, r11);
        if ((r11 instanceof ClickCustomBuyView) == false) goto L10;
        r0<GiftCustomBarViewState, CustomData> r13 = r10.getCustomData();
        r7.getClass();
        q3 r14 = ((CustomData) com.bytedance.android.anya.h.b(r13)).getSubscribeGiftPackInfo();
        String r15 = r14.getEntranceSchemeUrl();
        int r16 = r14.getLeftScores();
        if (((CustomData) com.bytedance.android.anya.h.b(r10.getCustomData())).getLockStatus() == com.bytedance.android.livesdk.gift.model.k0.UNLOCKED) goto L7;
        String r17 = "0";
    L8:
        HashMap r0 = new HashMap();
        r0.put("has_bought", r17);
        r0.put("card_number", String.valueOf(r16));
        K0(new OpenCustomBuyPage(u.a(r15, r0)));
        return;
    L7:
        r17 = "1";
        goto L8
    L10:
        if ((r11 instanceof ClickCustomGiftIcon) == false) goto L39;
        GiftExtraRepo r18 = this.v;
        vz1.e r1 = this.u;
        if (r1 == null) goto L16;
        h1 r2 = r1.a;
        if (r2 == null) goto L16;
        long r3 = r2.getId();
    L17:
        g0 r19 = r18.q(r3);
        if (r19 == null) goto L43;
        q3 r4 = r19.getSubscribeGiftPackInfo();
        h2 r20 = GiftManagerKt.l(r19.getGiftId());
        if (r20 == null) goto L36;
        com.bytedance.android.livesdk.gift.model.k0 r21 = r20.getGiftPreviewInfo();
        if (r21 == null) goto L36;
        if (r21.getLockStatus() != com.bytedance.android.livesdk.gift.model.k0.UNLOCKED) goto L36;
        if (r4 == null) goto L29;
        int r23 = r4.getLeftScores();
    L30:
        if (r23 > 0) goto L32;
        ToastUtil.a(2131916120, 0);
        return;
    L32:
        r0<GiftCustomBarViewState, Boolean> r24 = r10.isSelected();
        r7.getClass();
        if (((Boolean) com.bytedance.android.anya.h.b(r24)).booleanValue() == false) goto L35;
        l0.h(r10.isSelected(), Boolean.FALSE);
        return;
    L35:
        l0.h(r10.isSelected(), Boolean.TRUE);
        return;
    L29:
        r23 = 0;
    L36:
        ToastUtil.a(2131916118, 0);
        return;
    L43:
        return;
    L16:
        r3 = 0;
        goto L17
    }
}
