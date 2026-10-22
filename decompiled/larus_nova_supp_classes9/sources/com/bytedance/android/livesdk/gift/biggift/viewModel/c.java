package com.bytedance.android.livesdk.gift.biggift.viewModel;

import com.bytedance.android.live.network.response.ExtraResponse;
import com.bytedance.android.livesdk.gift.model.m0;
import com.bytedance.android.livesdk.gift.model.p2;
import com.bytedance.ies.sdk.widgets.NextLiveData;
import io.reactivex.functions.Consumer;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Unit;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class c<T> implements Consumer {
    public final /* synthetic */ BigGiftViewModel a;

    public c(BigGiftViewModel r1) {
        this.a = r1;
    }

    public final void accept(Object r6) {
        m0 r7 = ((p2) ((ExtraResponse) r6).data).getGiftRecommendInfo();
        if (r7 != null) goto L5;
        return;
    L5:
        if (r7.getComboCount() < 1) goto L12;
        NextLiveData<Map<String, Object>> r0 = this.a.e;
        LinkedHashMap r1 = new LinkedHashMap();
        LinkedHashMap r2 = new LinkedHashMap();
        List<Integer> r3 = r7.getChangeGiftIdPool();
        if (r3 == null) goto L9;
        r2.put("change_gift_id_pool", r3);
    L9:
        r2.put("combo_count", Integer.valueOf(r7.getComboCount()));
        r1.put("recommend_info", r2);
        Unit r8 = Unit.INSTANCE;
        r0.setValue(r1);
        return;
    }
}
