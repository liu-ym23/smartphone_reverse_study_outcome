package com.bytedance.android.livesdk.gift.biggift.view;

import android.view.View;
import com.bytedance.android.live.revenue.common.ViewUtilsKt;
import com.bytedance.android.live.revenue.common.u;
import com.bytedance.android.livesdk.gift.model.q3;
import java.util.HashMap;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class e implements View.OnClickListener {
    public final /* synthetic */ CustomGiftHintDialog a;
    public final /* synthetic */ q3 b;

    public e(CustomGiftHintDialog r1, q3 r2) {
        this.a = r1;
        this.b = r2;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r4) {
        q3 r5 = this.b;
        HashMap r0 = new HashMap();
        r0.put("has_bought", "1");
        r0.put("card_number", String.valueOf(r5.getLeftScores()));
        com.bytedance.android.live.revenue.core.util.f.a(zz0.g.class).S2(this.a.getContext(), u.a(r5.getEntranceSchemeUrl(), r0));
        jy0.b.d("CustomSpecialGiftEffects", "confirm dialog continue buy relate id" + r5.getRelatedGiftId());
        CustomGiftHintDialog.a(this.a, "buy");
        ViewUtilsKt.e(this.a);
    }
}
