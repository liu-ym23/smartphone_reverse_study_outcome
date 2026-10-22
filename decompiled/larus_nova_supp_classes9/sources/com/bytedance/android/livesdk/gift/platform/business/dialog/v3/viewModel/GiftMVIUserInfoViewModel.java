package com.bytedance.android.livesdk.gift.platform.business.dialog.v3.viewModel;

import com.bytedance.android.anya.BaseMVIDataStore;
import com.bytedance.android.anya.MVIState;
import com.bytedance.android.anya.j0;
import com.bytedance.android.anya.k0;
import com.bytedance.android.anya.l0;
import com.bytedance.android.anya.p;
import com.bytedance.android.anya.r;
import com.bytedance.android.anya.r0;
import com.bytedance.android.anya.t;
import com.bytedance.android.live.profit.privilege.model.paygrade.PayGrade;
import com.bytedance.android.live.recharge.IRechargeService;
import com.bytedance.android.livesdk.gift.model.h1;
import com.bytedance.android.livesdk.gift.model.l1;
import com.bytedance.android.livesdk.gift.platform.business.dialog.v3.datastore.GiftGroupCardDataStore;
import com.bytedance.android.livesdk.gift.platform.business.dialog.v3.datastore.y;
import com.bytedance.android.livesdk.gift.platform.business.dialog.v3.helper.GiftBuffCardHelper;
import com.bytedance.android.livesdk.gift.platform.business.dialog.v3.helper.o0;
import com.bytedance.android.livesdk.gift.platform.business.dialog.v3.helper.p0;
import com.bytedance.android.livesdk.gift.platform.business.dialog.v3.helper.v;
import com.bytedance.android.livesdk.gift.platform.business.dialog.v3.stateMachine.GiftAction;
import com.bytedance.android.livesdk.gift.platform.business.dialog.v3.stateMachine.GiftListBusinessState;
import com.bytedance.android.livesdk.gift.platform.business.dialog.v3.stateMachine.GiftPanelState;
import com.bytedance.android.livesdk.gift.platform.business.dialog.v3.stateMachine.GiftTabViewState;
import com.bytedance.android.livesdk.gift.platform.business.dialog.v3.stateMachine.GiftUserInfoViewState;
import com.bytedance.android.livesdk.gift.platform.business.dialog.v3.stateMachine.GiftVerticalState;
import com.bytedance.android.livesdk.gift.platform.business.dialog.v3.stateMachine.SelectGiftHonorData;
import com.bytedance.android.scope.o;
import com.bytedance.bdlocation.BuildConfig;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Set;
import kotlin.collections.SetsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class GiftMVIUserInfoViewModel extends com.bytedance.android.anya.f<GiftPanelState, GiftUserInfoViewState, GiftAction> implements o {
    public final Set<BaseMVIDataStore<?>> u;
    public final com.bytedance.android.livesdk.gift.platform.business.dialog.v3.repo.receiver.a v;
    public final y w;
    public final com.bytedance.android.livesdk.gift.platform.business.dialog.v3.datastore.c x;
    public final GiftGroupCardDataStore y;

    public final void onStart() {
    }

    public final void onStop() {
    }

    public final Set<BaseMVIDataStore<?>> I() {
        return this.u;
    }

    public final MVIState F(l0 r6) {
        Intrinsics.checkNotNullParameter(r6, "$this$createState");
        GiftUserInfoViewState r0 = new GiftUserInfoViewState();
        r0<GiftUserInfoViewState, Long> r1 = r0.getAvailableDiamonds();
        this.w.getClass();
        IRechargeService r2 = jc1.k.f(IRechargeService.class);
        if (r2 == null) goto L7;
        zv0.f r3 = r2.rechargeCenter();
        if (r3 == null) goto L7;
        long r4 = r3.getAvailableDiamonds();
    L8:
        Long r5 = Long.valueOf(r4);
        r6.getClass();
        l0.h(r1, r5);
        r0<GiftUserInfoViewState, PayGrade> r7 = r0.getPayGrade();
        y r8 = this.w;
        l0.h(r7, (PayGrade) r8.f.getValue(r8, y.h[1]));
        return r0;
    L7:
        r4 = 0;
        goto L8
    }

    public final void d(com.bytedance.android.anya.dsl.h<GiftPanelState, GiftAction> r4) {
        Intrinsics.checkNotNullParameter(r4, "$this$bindToParent");
        GiftMVIUserInfoViewModel$bindToParent$1 r0 = GiftMVIUserInfoViewModel$bindToParent$1.INSTANCE;
        List r5 = r4.a;
        ArrayList r6 = (ArrayList) r5;
        r6.add(new com.bytedance.android.anya.dsl.i(this, r0, GiftAction.class));
    }

    public final void J0(com.bytedance.android.anya.internal.e r5, MVIState r6) {
        final GiftUserInfoViewState r7 = (GiftUserInfoViewState) r6;
        Intrinsics.checkNotNullParameter(r5, "$this$reduce");
        Intrinsics.checkNotNullParameter(r7, "state");
        if (v.e() == false) goto L6;
        y r0 = this.w;
        r5.e((t) r0.e.getValue(r0, y.h[0]), new GiftMVIUserInfoViewModel$reduce$1(r7));
        return;
    }

    public final void w0(j0 r13, MVIState r14, p r15) {
        GiftUserInfoViewState r16 = (GiftUserInfoViewState) r14;
        Intrinsics.checkNotNullParameter(r13, "$this$postReduce");
        Intrinsics.checkNotNullParameter(r16, "state");
        Intrinsics.checkNotNullParameter((GiftAction) r15, "action");
        if (v.e() == false) goto L71;
        com.bytedance.android.anya.internal.p r17 = r13.getContext();
        com.bytedance.android.anya.internal.c r18 = (com.bytedance.android.anya.v) r17.b(r17.c(GiftPanelState.class), GiftMVIUserInfoViewModel$postReduce$1$1.INSTANCE).a.invoke();
        boolean r0 = true;
        if (r18 == null) goto L20;
        com.bytedance.android.anya.internal.c r2 = r18;
        Object r3 = r18.c();     // Catch: Throwable -> L68
        int r4 = r18.c;     // Catch: Throwable -> L68
        Object r5 = ((LinkedHashMap) r13.d).get(r18);     // Catch: Throwable -> L68
        if (r5 != null) goto L12;
        r5 = 0;     // Catch: Throwable -> L68
    L12:
        if (r4 <= ((Number) r5).intValue()) goto L14;
        boolean r6 = true;
    L15:
        if (r6 == false) goto L17;
        j0.a r7 = j0.a.a;     // Catch: Throwable -> L68
        GiftTabViewState r8 = (GiftTabViewState) r3;     // Catch: Throwable -> L68
        GiftUserInfoViewState r9 = (GiftUserInfoViewState) r13.g.f();     // Catch: Throwable -> L68
        l0.h(r16.getGiftSelectData(), new SelectGiftHonorData(null, 0, 3, null));     // Catch: Throwable -> L68
    L17:
        if (r6 == false) goto L19;
        r13.a();     // Catch: Throwable -> L68
    L19:
        r13.c.put(r18, Integer.valueOf(r2.c));
        goto L20
    L14:
        r6 = false;
    L68:
        th = move-exception;
        r13.c.put(r18, Integer.valueOf(r2.c));
        throw th;
    L20:
        com.bytedance.android.anya.internal.p r19 = r13.getContext();
        com.bytedance.android.anya.internal.c r110 = (com.bytedance.android.anya.v) r19.a(r19.b(r19.c(GiftPanelState.class), GiftMVIUserInfoViewModel$postReduce$3$wrapped$1.INSTANCE), GiftMVIUserInfoViewModel$postReduce$3$wrapped$2.INSTANCE).a.invoke();
        if (r110 == null) goto L77;
        com.bytedance.android.anya.internal.c r10 = r110;
        Object r11 = r110.c();     // Catch: Throwable -> L57
        int r20 = r110.c;     // Catch: Throwable -> L57
        Object r21 = ((LinkedHashMap) r13.d).get(r110);     // Catch: Throwable -> L57
        if (r21 != null) goto L28;
        r21 = 0;     // Catch: Throwable -> L57
    L28:
        if (r20 <= ((Number) r21).intValue()) goto L30;
        boolean r23 = true;
    L31:
        if (r23 == false) goto L63;
        k0 r24 = j0.a.a;     // Catch: Throwable -> L57
        r24.getClass();     // Catch: Throwable -> L57
        r r25 = ((GiftVerticalState) r11).toBusinessState(r24);     // Catch: Throwable -> L57
        if ((r25 instanceof GiftListBusinessState.GiftSelected) == false) goto L63;
        vz1.e r26 = ((GiftListBusinessState.GiftSelected) r25).getIconModel();     // Catch: Throwable -> L57
        if (r26 == null) goto L63;
        GiftUserInfoViewState r27 = (GiftUserInfoViewState) r13.g.f();     // Catch: Throwable -> L57
        Long r28 = r26.h;     // Catch: Throwable -> L57
        if (r28 == null) goto L39;
        long r29 = r28.longValue();     // Catch: Throwable -> L57
    L40:
        GiftBuffCardHelper.Companion r30 = GiftBuffCardHelper.a;     // Catch: Throwable -> L57
        l1 r31 = this.x.q();     // Catch: Throwable -> L57
        h1 r33 = r26.a;     // Catch: Throwable -> L57
        r30.getClass();     // Catch: Throwable -> L57
        o0 r34 = GiftBuffCardHelper.Companion.h(r31, r33);     // Catch: Throwable -> L57
        if (r34 == null) goto L43;
        r29 = r29 + r34.a.getBuffDiamondCount();     // Catch: Throwable -> L57
    L43:
        p0 r35 = GiftBuffCardHelper.Companion.i(this.x.k(), r26.a);     // Catch: Throwable -> L57
        if (r35 == null) goto L46;
        r29 = r29 + r35.a.getTotalDiamonds();     // Catch: Throwable -> L57
    L46:
        oc6.g r36 = this.y.k();     // Catch: Throwable -> L57
        if (r36 == null) goto L60;
        if (r36.a() > 0) goto L52;
        r0 = false;
    L52:
        if (r0 == true) goto L55;
        r36 = null;
    L55:
        if (r36 == null) goto L60;
        r29 = r29 * ((long) r36.a());     // Catch: Throwable -> L57
    L60:
        if (this.v.j() == false) goto L62;
        r29 = r29 * ((long) this.v.i().size());     // Catch: Throwable -> L57
    L62:
        l0.h(r16.getGiftSelectData(), new SelectGiftHonorData(BuildConfig.FLAVOR, r29));     // Catch: Throwable -> L57
        goto L63
    L39:
        r29 = 0;
    L63:
        if (r23 == false) goto L65;
        r13.a();     // Catch: Throwable -> L57
    L65:
        r13.c.put(r110, Integer.valueOf(r10.c));
        return;
    L30:
        r23 = false;
    L57:
        th = move-exception;
        r13.c.put(r110, Integer.valueOf(r10.c));
        throw th;
    L77:
        return;
    }

    public GiftMVIUserInfoViewModel(com.bytedance.android.livesdk.gift.platform.business.dialog.v3.repo.receiver.a r2, y r3, com.bytedance.android.livesdk.gift.platform.business.dialog.v3.datastore.c r4, GiftGroupCardDataStore r5) {
        Intrinsics.checkNotNullParameter(r2, "giftAllMicService");
        Intrinsics.checkNotNullParameter(r3, "userInfoDataStore");
        Intrinsics.checkNotNullParameter(r4, "giftCardDataStore");
        Intrinsics.checkNotNullParameter(r5, "giftGroupCardDataStore");
        this.v = r2;
        this.w = r3;
        this.x = r4;
        this.y = r5;
        this.u = SetsKt.setOf(r3);
    }
}
