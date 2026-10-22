package com.bytedance.android.livesdk.gift.platform.business.dialog.v3.repo;

import com.bytedance.android.live.profit.privilege.model.touch.TouchPositionData;
import com.bytedance.android.livesdk.gift.platform.business.dialog.v3.stateMachine.LynxTouchViewVisibleChange;
import com.bytedance.android.livesdk.gift.platform.business.dialog.v3.stateMachine.UpdateTouchPositionsStr;
import io.reactivex.functions.Consumer;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class s0<T> implements Consumer {
    public final /* synthetic */ v0 a;

    public s0(v0 r1) {
        this.a = r1;
    }

    public final void accept(Object r4) {
        TouchPositionData r5 = (TouchPositionData) r4;
        if (r5 == null) goto L8;
        String r0 = r5.getTouchPositionsStr();
        if (r0 == null) goto L9;
        this.a.c.a(new UpdateTouchPositionsStr(r0));
        this.a.c.a(new LynxTouchViewVisibleChange(true, r5.getNeedShowTopDetail()));
        return;
    L9:
        return;
    }
}
