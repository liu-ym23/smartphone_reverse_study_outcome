package com.bytedance.android.livesdk.gift.platform.business.dialog.v3.viewModel.topViewModel;

import com.bytedance.android.live.base.model.user.IBaseUser;
import com.bytedance.android.live.base.model.user.o;
import com.bytedance.android.live.revenue.common.x0;
import com.bytedance.android.livesdk.gift.model.g0;
import com.bytedance.android.livesdk.gift.model.h1;
import com.bytedance.android.livesdk.gift.model.p;
import com.bytedance.android.livesdk.gift.platform.business.dialog.v3.stateMachine.ShowCustomDIYPage;
import com.bytedance.android.livesdk.gift.platform.business.effect.assets.k;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class b implements k.b {
    public final /* synthetic */ String a;
    public final /* synthetic */ GiftMVIDIYTopViewModel b;
    public final /* synthetic */ h1 c;
    public final /* synthetic */ IBaseUser d;

    @Override // com.bytedance.android.livesdk.gift.platform.business.effect.assets.k.b
    public final void b(boolean r1) {
    }

    @Override // com.bytedance.android.livesdk.gift.platform.business.effect.assets.k.b
    public final void a(List<k.a> r2) {
        Intrinsics.checkNotNullParameter(r2, "assetsResult");
        jy0.b.a("DIYGiftWidget", "cancel download asset");
    }

    @Override // com.bytedance.android.livesdk.gift.platform.business.effect.assets.k.b
    public final void onFailed(Throwable r3) {
        StringBuilder r0 = new StringBuilder("download asset failed: ");
        if (r3 == null) goto L5;
        String r4 = r3.getMessage();
    L6:
        r0.append(r4);
        jy0.b.a("DIYGiftWidget", r0.toString());
        return;
    L5:
        r4 = null;
        goto L6
    }

    @Override // com.bytedance.android.livesdk.gift.platform.business.effect.assets.k.b
    public final void onResult(List<k.a> r13) {
        Intrinsics.checkNotNullParameter(r13, "assetsResult");
        g0 r0 = this.b.H.q(this.c.getId());
        if (r0 == null) goto L5;
        p r1 = r0.getDiyGiftToolbarInfo();
    L6:
        x0 r2 = new x0(this.a);
        x0 r3 = r2.d("url");
        r3.b("giftId", String.valueOf(this.c.getId()));
        if (r1 == null) goto L9;
        long r4 = r1.getConfigId();
    L10:
        r3.b("configId", String.valueOf(r4));
        r3.b("pageSource", com.bytedance.android.livesdk.gift.model.e.FETCH_FROM_GIFT_PANEL);
        r3.b("toUserId", this.d.getIdString());
        r3.b("secToUserId", o.a(this.d));
        if ((!r13.isEmpty()) == true) goto L14;
        r13 = null;
    L14:
        if (r13 == null) goto L22;
        JSONObject r5 = new JSONObject();
        int r6 = r13.size();
        int r7 = 0;
    L16:
        if (r7 >= r6) goto L21;
        if (((k.a) ListProtector.get(r13, r7)).a != this.c.getPrimaryEffectId()) goto L20;
        r3.b("modelPath", "file://" + ((k.a) ListProtector.get(r13, r7)).b);
    L20:
        r5.put(String.valueOf(((k.a) ListProtector.get(r13, r7)).a), "file://" + ((k.a) ListProtector.get(r13, r7)).b);
        r7 = r7 + 1;
        goto L16
    L21:
        r3.b("assetPath", r5.toString());
    L22:
        r3.b("baseDiamond", String.valueOf(this.c.getDiamondCount()));
        com.bytedance.android.livesdk.revenue.service.interact.d r14 = vh6.c.b(com.bytedance.android.livesdk.revenue.service.interact.d.class);
        r3.b("liveType", r14.getLiveTypeForLog());
        r3.b("functionType", r14.getCurrentFunctionType());
        r3.b("functionType2", r14.getFunctionTypeForLog());
        if (this.b.F.isAnchor() == false) goto L25;
        String r15 = "anchor";
    L26:
        r3.b("userType", r15);
        this.b.K0(new ShowCustomDIYPage(r2.toString()));
        return;
    L25:
        r15 = "guest";
        goto L26
    L9:
        r4 = 0;
        goto L10
    L5:
        r1 = null;
        goto L6
    }

    public b(String r1, GiftMVIDIYTopViewModel r2, h1 r3, IBaseUser r4) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
        this.d = r4;
    }
}
