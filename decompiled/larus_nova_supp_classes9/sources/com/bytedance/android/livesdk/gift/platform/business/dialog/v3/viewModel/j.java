package com.bytedance.android.livesdk.gift.platform.business.dialog.v3.viewModel;

import com.bytedance.android.livesdk.gift.model.h1;
import com.bytedance.android.livesdk.gift.platform.business.dialog.v2.viewmodel.GiftStateMachineConfig;
import com.bytedance.android.livesdk.gift.platform.core.utils.a0;
import io.reactivex.functions.Consumer;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class j<T> implements Consumer {
    public final /* synthetic */ vz1.e a;

    public j(vz1.e r1) {
        this.a = r1;
    }

    public final void accept(Object r4) {
        Boolean r5 = (Boolean) r4;
        vz1.e r6 = this.a;
        if (r6 == null) goto L17;
        h1 r7 = r6.a;
        if (r7 == null) goto L18;
        boolean r0 = true;
        if (r7.getBizType() != 1) goto L19;
        int r8 = a0.a;
        Integer r9 = Integer.valueOf(this.a.a.getAfterSendAction());
        if (r9 == null) goto L13;
        r9.intValue();
        if ((r9.intValue() & 2) != 2) goto L13;
    L14:
        if (r0 == false) goto L20;
        com.bytedance.android.livesdk.gift.util.b.f(new GiftStateMachineConfig.Event.h(0, 6));
        return;
    L20:
        return;
    L13:
        r0 = false;
        goto L14
    L19:
        return;
    L18:
        return;
    }
}
