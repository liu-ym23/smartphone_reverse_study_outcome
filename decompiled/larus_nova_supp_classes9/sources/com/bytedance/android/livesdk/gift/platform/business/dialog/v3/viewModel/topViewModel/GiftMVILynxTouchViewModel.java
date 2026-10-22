package com.bytedance.android.livesdk.gift.platform.business.dialog.v3.viewModel.topViewModel;

import ca0.s;
import com.bytedance.android.anya.MVIState;
import com.bytedance.android.anya.dsl.h;
import com.bytedance.android.anya.internal.p;
import com.bytedance.android.anya.j0;
import com.bytedance.android.anya.k0;
import com.bytedance.android.anya.l0;
import com.bytedance.android.anya.r;
import com.bytedance.android.anya.r0;
import com.bytedance.android.anya.v;
import com.bytedance.android.live.profit.privilege.model.paygrade.PayGrade;
import com.bytedance.android.livesdk.gift.model.h1;
import com.bytedance.android.livesdk.gift.model.l1;
import com.bytedance.android.livesdk.gift.platform.business.dialog.v3.datastore.GiftGroupCardDataStore;
import com.bytedance.android.livesdk.gift.platform.business.dialog.v3.helper.GiftBuffCardHelper;
import com.bytedance.android.livesdk.gift.platform.business.dialog.v3.helper.o0;
import com.bytedance.android.livesdk.gift.platform.business.dialog.v3.helper.p0;
import com.bytedance.android.livesdk.gift.platform.business.dialog.v3.stateMachine.ChangeMultiSendReceiver;
import com.bytedance.android.livesdk.gift.platform.business.dialog.v3.stateMachine.ChangeReceiver;
import com.bytedance.android.livesdk.gift.platform.business.dialog.v3.stateMachine.GiftAction;
import com.bytedance.android.livesdk.gift.platform.business.dialog.v3.stateMachine.GiftListBusinessState;
import com.bytedance.android.livesdk.gift.platform.business.dialog.v3.stateMachine.GiftLynxGrowthTouchState;
import com.bytedance.android.livesdk.gift.platform.business.dialog.v3.stateMachine.GiftPanelState;
import com.bytedance.android.livesdk.gift.platform.business.dialog.v3.stateMachine.GiftTabViewState;
import com.bytedance.android.livesdk.gift.platform.business.dialog.v3.stateMachine.GiftTopViewState;
import com.bytedance.android.livesdk.gift.platform.business.dialog.v3.stateMachine.GiftVerticalState;
import com.bytedance.android.livesdk.gift.platform.business.dialog.v3.stateMachine.PayGradeChange;
import com.bytedance.android.livesdk.gift.platform.business.dialog.v3.stateMachine.QueryUserHonorMap;
import com.bytedance.android.livesdk.gift.platform.business.dialog.v3.stateMachine.SelectGiftHonorData;
import com.bytedance.android.livesdk.gift.platform.business.dialog.v3.stateMachine.UpdateTouchPositionsStr;
import com.bytedance.android.livesdk.gift.platform.business.dialog.v3.stateMachine.updateLynxTopView;
import com.bytedance.android.livesdk.gift.platform.business.dialog.v3.viewModel.l;
import com.bytedance.android.livesdk.gift.platform.core.GiftContext;
import com.bytedance.bdlocation.BuildConfig;
import com.bytedance.live.datacontext.i;
import io.reactivex.disposables.CompositeDisposable;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.jvm.internal.Intrinsics;
import oc6.g;
import yz0.k;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class GiftMVILynxTouchViewModel extends com.bytedance.android.anya.f<GiftTopViewState, GiftLynxGrowthTouchState, GiftAction> implements l<GiftLynxGrowthTouchState, GiftAction>, s {
    public final com.bytedance.android.livesdk.gift.platform.business.dialog.v3.repo.receiver.a u;
    public final k v;
    public final com.bytedance.android.livesdk.revenue.service.user.a w;
    public final com.bytedance.android.livesdk.gift.platform.business.dialog.v3.datastore.c x;
    public final GiftGroupCardDataStore y;

    public final void onStart() {
        GiftContext r0 = com.bytedance.android.livesdk.gift.util.b.b();
        if (r0 == null) goto L10;
        i<Set<s>> r1 = r0.getGiftSendResultListeners();
        if (r1 == null) goto L11;
        Set r2 = (Set) r1.getValue();
        if (r2 == null) goto L12;
        r2.add(this);
        return;
    L12:
        return;
    L11:
        return;
    }

    public final void onStop() {
        GiftContext r0 = com.bytedance.android.livesdk.gift.util.b.b();
        if (r0 == null) goto L10;
        i<Set<s>> r1 = r0.getGiftSendResultListeners();
        if (r1 == null) goto L11;
        Set r2 = (Set) r1.getValue();
        if (r2 == null) goto L12;
        r2.remove(this);
        return;
    L12:
        return;
    L11:
        return;
    }

    public final MVIState F(l0 r2) {
        Intrinsics.checkNotNullParameter(r2, "$this$createState");
        return new GiftLynxGrowthTouchState();
    }

    public final void d(h<GiftTopViewState, GiftAction> r4) {
        Intrinsics.checkNotNullParameter(r4, "$this$bindToParent");
        GiftMVILynxTouchViewModel$bindToParent$1 r0 = GiftMVILynxTouchViewModel$bindToParent$1.INSTANCE;
        List r5 = r4.a;
        ArrayList r6 = (ArrayList) r5;
        r6.add(new com.bytedance.android.anya.dsl.i(this, r0, GiftAction.class));
    }

    public final void j(com.bytedance.android.livesdk.gift.platform.business.sendGift.f r2) {
        Intrinsics.checkNotNullParameter(r2, "result");
        K0(new updateLynxTopView());
    }

    public final void e1(j0<GiftLynxGrowthTouchState> r8, GiftLynxGrowthTouchState r9) {
        p r0 = r8.getContext();
        p.b r1 = r0.a(r0.b(r0.c(GiftPanelState.class), GiftMVILynxTouchViewModel$changeGiftScore$1$wrapped$1.INSTANCE), GiftMVILynxTouchViewModel$changeGiftScore$1$wrapped$2.INSTANCE);
        boolean r2 = false;
        Object r3 = 0;
        com.bytedance.android.anya.internal.c r4 = (v) r1.a.invoke();
        if (r4 == null) goto L27;
        com.bytedance.android.anya.internal.c r5 = r4;
        Object r6 = r4.c();     // Catch: Throwable -> L22
        int r7 = r4.c;     // Catch: Throwable -> L22
        Object r10 = ((LinkedHashMap) r8.d).get(r4);     // Catch: Throwable -> L22
        if (r10 == null) goto L11;
        r3 = r10;
    L11:
        if (r7 <= ((Number) r3).intValue()) goto L13;
        r2 = true;
    L13:
        k0 r11 = j0.a.a;     // Catch: Throwable -> L22
        r11.getClass();     // Catch: Throwable -> L22
        r r13 = ((GiftVerticalState) r6).toBusinessState(r11);     // Catch: Throwable -> L22
        if ((r13 instanceof GiftListBusinessState.GiftSelected) == false) goto L18;
        vz1.e r14 = ((GiftListBusinessState.GiftSelected) r13).getIconModel();     // Catch: Throwable -> L22
        if (r14 == null) goto L18;
        l0<GiftLynxGrowthTouchState> r15 = r8.g;     // Catch: Throwable -> L22
        GiftLynxGrowthTouchState r16 = (GiftLynxGrowthTouchState) r15.f();     // Catch: Throwable -> L22
        h1(r15, r9, r14);     // Catch: Throwable -> L22
    L18:
        if (r2 == false) goto L20;
        r8.a();     // Catch: Throwable -> L22
    L20:
        r8.c.put(r4, Integer.valueOf(r5.c));
        return;
    L22:
        th = move-exception;
        r8.c.put(r4, Integer.valueOf(r5.c));
        throw th;
    }

    public final void h1(l0<GiftLynxGrowthTouchState> r6, GiftLynxGrowthTouchState r7, vz1.e r8) {
        Long r0 = r8.h;
        if (r0 == null) goto L5;
        long r1 = r0.longValue();
    L6:
        GiftBuffCardHelper.Companion r2 = GiftBuffCardHelper.a;
        l1 r3 = this.x.q();
        h1 r4 = r8.a;
        r2.getClass();
        o0 r5 = GiftBuffCardHelper.Companion.h(r3, r4);
        if (r5 == null) goto L9;
        r1 = r1 + r5.a.getBuffDiamondCount();
    L9:
        p0 r9 = GiftBuffCardHelper.Companion.i(this.x.k(), r8.a);
        if (r9 == null) goto L12;
        r1 = r1 + r9.a.getTotalDiamonds();
    L12:
        g r10 = this.y.k();
        if (r10 == null) goto L24;
        if (r10.a() <= 0) goto L17;
        boolean r11 = true;
    L18:
        if (r11 == true) goto L21;
        r10 = null;
    L21:
        if (r10 == null) goto L24;
        r1 = r1 * ((long) r10.a());
        goto L24
    L17:
        r11 = false;
    L24:
        if (this.u.j() == false) goto L26;
        r1 = r1 * ((long) this.u.i().size());
    L26:
        r0<GiftLynxGrowthTouchState, SelectGiftHonorData> r13 = r7.getGiftSelectData();
        SelectGiftHonorData r14 = new SelectGiftHonorData(BuildConfig.FLAVOR, r1);
        r6.getClass();
        l0.h(r13, r14);
        return;
    L5:
        r1 = 0;
        goto L6
    }

    public final void w0(j0 r19, MVIState r20, com.bytedance.android.anya.p r21) {
        GiftLynxGrowthTouchState r0 = (GiftLynxGrowthTouchState) r20;
        GiftAction r3 = (GiftAction) r21;
        Intrinsics.checkNotNullParameter(r19, "$this$postReduce");
        Intrinsics.checkNotNullParameter(r0, "state");
        Intrinsics.checkNotNullParameter(r3, "action");
        p r4 = r19.getContext();
        p.b r5 = r4.b(r4.c(GiftPanelState.class), GiftMVILynxTouchViewModel$postReduce$1$1.INSTANCE);
        Object r6 = 0;
        com.bytedance.android.anya.internal.c r7 = (v) r5.a.invoke();
        boolean r8 = true;
        if (r7 == null) goto L18;
        com.bytedance.android.anya.internal.c r9 = r7;
        Object r10 = r7.c();     // Catch: Throwable -> L49
        int r11 = r7.c;     // Catch: Throwable -> L49
        Object r13 = ((LinkedHashMap) r19.d).get(r7);     // Catch: Throwable -> L49
        if (r13 != null) goto L10;
        r13 = r6;
    L10:
        if (r11 <= ((Number) r13).intValue()) goto L12;
        boolean r14 = true;
    L13:
        if (r14 == false) goto L15;
        j0.a r15 = j0.a.a;     // Catch: Throwable -> L49
        GiftTabViewState r16 = (GiftTabViewState) r10;     // Catch: Throwable -> L49
        GiftLynxGrowthTouchState r17 = (GiftLynxGrowthTouchState) r19.g.f();     // Catch: Throwable -> L49
        l0.h(r0.getGiftSelectData(), new SelectGiftHonorData(null, 0, 3, null));     // Catch: Throwable -> L49
    L15:
        if (r14 == false) goto L17;
        r19.a();     // Catch: Throwable -> L49
    L17:
        r19.c.put(r7, Integer.valueOf(r9.c));
        goto L18
    L12:
        r14 = false;
    L49:
        th = move-exception;
        r19.c.put(r7, Integer.valueOf(r9.c));
        throw th;
    L18:
        p r18 = r19.getContext();
        com.bytedance.android.anya.internal.c r23 = (v) r18.a(r18.b(r18.c(GiftPanelState.class), GiftMVILynxTouchViewModel$postReduce$3$wrapped$1.INSTANCE), GiftMVILynxTouchViewModel$postReduce$3$wrapped$2.INSTANCE).a.invoke();
        if (r23 == null) goto L40;
        com.bytedance.android.anya.internal.c r24 = r23;
        Object r25 = r23.c();     // Catch: Throwable -> L46
        int r26 = r23.c;     // Catch: Throwable -> L46
        Object r110 = ((LinkedHashMap) r19.d).get(r23);     // Catch: Throwable -> L46
        if (r110 == null) goto L27;
        r6 = r110;
    L27:
        if (r26 > ((Number) r6).intValue()) goto L30;
        r8 = false;
    L30:
        if (r8 == false) goto L36;
        k0 r27 = j0.a.a;     // Catch: Throwable -> L46
        r27.getClass();     // Catch: Throwable -> L46
        r r28 = ((GiftVerticalState) r25).toBusinessState(r27);     // Catch: Throwable -> L46
        if ((r28 instanceof GiftListBusinessState.GiftSelected) == false) goto L36;
        vz1.e r29 = ((GiftListBusinessState.GiftSelected) r28).getIconModel();     // Catch: Throwable -> L46
        if (r29 == null) goto L36;
        l0<GiftLynxGrowthTouchState> r30 = r19.g;     // Catch: Throwable -> L46
        GiftLynxGrowthTouchState r31 = (GiftLynxGrowthTouchState) r30.f();     // Catch: Throwable -> L46
        h1(r30, r0, r29);     // Catch: Throwable -> L46
    L36:
        if (r8 == false) goto L38;
        r19.a();     // Catch: Throwable -> L46
    L38:
        r19.c.put(r23, Integer.valueOf(r24.c));
    L46:
        th = move-exception;
        r19.c.put(r23, Integer.valueOf(r24.c));
        throw th;
    L40:
        if ((r3 instanceof ChangeReceiver) == false) goto L43;
        e1(r19, r0);
        return;
    L43:
        if ((r3 instanceof ChangeMultiSendReceiver) == false) goto L57;
        e1(r19, r0);
        return;
    }

    public final void y0(l0 r2, MVIState r3, com.bytedance.android.anya.p r4) {
        GiftLynxGrowthTouchState r5 = (GiftLynxGrowthTouchState) r3;
        GiftAction r6 = (GiftAction) r4;
        Intrinsics.checkNotNullParameter(r2, "$this$reduce");
        Intrinsics.checkNotNullParameter(r5, "state");
        Intrinsics.checkNotNullParameter(r6, "action");
        if ((r6 instanceof UpdateTouchPositionsStr) == false) goto L6;
        r0<GiftLynxGrowthTouchState, String> r7 = r5.getTouchPositionsStr();
        String r8 = ((UpdateTouchPositionsStr) r6).getTouchPositionsStr();
        r2.getClass();
        l0.h(r7, r8);
        return;
    L6:
        if ((r6 instanceof QueryUserHonorMap) == false) goto L9;
        r0<GiftLynxGrowthTouchState, Map<String, Object>> r9 = r5.getUserHonorMap();
        Map<String, Object> r10 = ((QueryUserHonorMap) r6).getUserHonorMap();
        r2.getClass();
        l0.h(r9, r10);
        return;
    L9:
        if ((r6 instanceof PayGradeChange) == false) goto L14;
        r0<GiftLynxGrowthTouchState, PayGrade> r11 = r5.getPayGrade();
        PayGrade r13 = ((PayGradeChange) r6).getPayGrade();
        r2.getClass();
        l0.h(r11, r13);
        return;
    }

    public GiftMVILynxTouchViewModel(com.bytedance.android.livesdk.gift.platform.business.dialog.v3.repo.receiver.a r2, k r3, com.bytedance.android.livesdk.revenue.service.user.a r4, com.bytedance.android.livesdk.gift.platform.business.dialog.v3.datastore.c r5, GiftGroupCardDataStore r6) {
        Intrinsics.checkNotNullParameter(r2, "giftAllMicService");
        Intrinsics.checkNotNullParameter(r3, "roomService");
        Intrinsics.checkNotNullParameter(r4, "userService");
        Intrinsics.checkNotNullParameter(r5, "giftCardDataStore");
        Intrinsics.checkNotNullParameter(r6, "giftGroupCardDataStore");
        this.u = r2;
        this.v = r3;
        this.w = r4;
        this.x = r5;
        this.y = r6;
        new CompositeDisposable();
    }
}
