package zz1;

import com.bytedance.android.live.profit.privilege.model.touch.GiftPanelTouchData;
import com.bytedance.android.live.recharge.IRechargeService;
import com.bytedance.android.livesdk.gift.platform.business.dialog.v3.viewModel.GiftMVIVerticalListViewModel;
import com.bytedance.android.livesdk.gift.platform.core.GiftContext;
import com.bytedance.android.livesdk.gift.platform.core.scope.service.OpenDialogService;
import com.bytedance.android.livesdk.gift.platform.core.scope.service.u1;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import oc6.z;
import zg1.x2;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class k implements z, com.bytedance.android.scope.o {
    public final OpenDialogService a;
    public final u1 b;
    public final GiftMVIVerticalListViewModel c;

    public final void onStart() {
    }

    public final void onStop() {
    }

    public final void openRechargeDialog() {
        IRechargeService r0 = jc1.k.f(IRechargeService.class);
        if (r0 == null) goto L7;
        zv0.f r1 = r0.rechargeCenter();
        if (r1 == null) goto L7;
        long r2 = r1.getAvailableDiamonds();
    L8:
        com.bytedance.android.live.profit.privilege.a r3 = yt0.c.i();
        Map<String, String> r4 = null;
        if (r3 == null) goto L15;
        com.bytedance.live.datacontext.m r5 = r3.getGiftPanelTouchData();
        if (r5 == null) goto L15;
        GiftPanelTouchData r6 = (GiftPanelTouchData) r5.getValue();
        if (r6 == null) goto L15;
        GiftPanelTouchData.a r7 = r6.getRechargeButton();
    L16:
        GiftMVIVerticalListViewModel.b r8 = this.c.V;
        if (r8 != null) goto L19;
    L28:
        OpenDialogService r9 = this.a;
        x2 r10 = new x2("click", "gift_recharge");
        int r11 = OpenDialogService.r;
        r9.i(r10, true, false, null);
        u1 r13 = this.b;
        if (r7 == null) goto L31;
        r4 = r7.c;
    L31:
        r13.T0(1, r2, r4);
        return;
    L19:
        if (StringsKt.contains$default(r8.c, "ClickGiftPanelIcon", false, 2, null) == false) goto L28;
        if (((Boolean) vh6.c.b(wh6.a.class).getClientABValue(q41.a.g)).booleanValue() == false) goto L28;
        jy0.b.d("ttlive_gift_panel", "record recharge gift " + r8);
        GiftContext r14 = com.bytedance.android.livesdk.gift.util.b.b();
        if (r14 == null) goto L28;
        com.bytedance.live.datacontext.n<GiftContext.a> r15 = r14.getLastClickRechargeSelectGift();
        if (r15 == null) goto L28;
        r15.setValue(new GiftContext.a(r8.a, 0, r8.b));
    L15:
        r7 = null;
    L7:
        r2 = 0;
        goto L8
    }

    public k(OpenDialogService r2, u1 r3, GiftMVIVerticalListViewModel r4) {
        Intrinsics.checkNotNullParameter(r2, "openDialogService");
        Intrinsics.checkNotNullParameter(r3, "giftPanelLogService");
        Intrinsics.checkNotNullParameter(r4, "giftMVIVerticalListViewModel");
        this.a = r2;
        this.b = r3;
        this.c = r4;
    }
}
