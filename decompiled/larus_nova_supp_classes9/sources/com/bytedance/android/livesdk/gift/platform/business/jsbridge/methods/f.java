package com.bytedance.android.livesdk.gift.platform.business.jsbridge.methods;

import com.bytedance.android.live.GsonHelper;
import com.bytedance.android.live.browser.jsbridge.base.GetGiftDataResultModel;
import com.bytedance.android.live.network.response.ExtraResponse;
import com.bytedance.android.livesdk.gift.model.h1;
import com.bytedance.android.livesdk.gift.model.s0;
import com.bytedance.android.livesdk.gift.platform.core.c0;
import com.bytedance.mt.protector.impl.GsonProtectorUtils;
import io.reactivex.functions.Consumer;
import java.util.List;
import kotlin.collections.CollectionsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class f<T> implements Consumer {
    public final /* synthetic */ long a;
    public final /* synthetic */ h b;
    public final /* synthetic */ String c;
    public final /* synthetic */ List d;

    public f(long r1, h r3, String r4, List r5) {
        this.a = r1;
        this.b = r3;
        this.c = r4;
        this.d = r5;
    }

    public final void accept(Object r8) {
        ExtraResponse r9 = (ExtraResponse) r8;
        com.bytedance.android.livesdk.gift.platform.core.giftlist.i r0 = (com.bytedance.android.livesdk.gift.platform.core.giftlist.i) com.bytedance.android.live.revenue.core.util.f.a(com.bytedance.android.livesdk.gift.platform.core.giftlist.i.class);
        List<h1> r1 = ((s0) r9.data).getGiftList();
        if (r1 != null) goto L5;
        r1 = CollectionsKt.emptyList();
    L5:
        r0.s5(r1);
        List r2 = this.d;
        List<h1> r10 = ((s0) r9.data).getGiftList();
        if (r10 != null) goto L9;
        r10 = CollectionsKt.emptyList();
    L9:
        r2.addAll(r10);
        GetGiftDataResultModel r11 = new GetGiftDataResultModel();
        if (this.d.size() != 1) goto L12;
        r11.b(GsonProtectorUtils.toJsonTree(GsonHelper.getDefault(), CollectionsKt.first(this.d)));
    L13:
        r11.a(GetGiftDataResultModel.Code.Success);
        com.bytedance.android.livesdk.gift.platform.core.utils.h.t(this.c, this.a, 2, null);
        c0 r3 = c0.a;
        String r4 = this.c;
        long r5 = this.a;
        c0.a.q(r4, r5, 2, null);
        this.b.finishWithResult(r11);
        return;
    L12:
        r11.b(GsonProtectorUtils.toJsonTree(GsonHelper.getDefault(), this.d));
        goto L13
    }
}
