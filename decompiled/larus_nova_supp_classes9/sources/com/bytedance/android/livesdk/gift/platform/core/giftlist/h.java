package com.bytedance.android.livesdk.gift.platform.core.giftlist;

import com.bytedance.android.livesdk.gift.model.w1;
import com.bytedance.android.livesdk.gift.platform.business.dialog.v3.repo.MostlyUsedGiftOperateAction;
import com.bytedance.android.livesdk.gift.platform.core.model.ReceiverType;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public interface h extends dy0.d {
    void Kg();

    Map<ReceiverType, com.bytedance.android.livesdk.gift.platform.core.model.l> M4();

    com.bytedance.android.livesdk.gift.platform.core.model.j Mn(ReceiverType r1);

    void N(long r1, int r3, @MostlyUsedGiftOperateAction int r4, ReceiverType r5);

    boolean Si();

    void lm(ReceiverType r1, com.bytedance.android.livesdk.gift.platform.core.model.l r2, List<k> r3, List<k> r4, int r5, String r6);

    void t1(ReceiverType r1, Integer r2, Long r3, com.bytedance.android.livesdk.gift.platform.core.model.l r4, List<k> r5, List<k> r6, int r7, String r8);

    List<Long> vb(ReceiverType r1);

    w1 ve(ReceiverType r1, int r2);
}
