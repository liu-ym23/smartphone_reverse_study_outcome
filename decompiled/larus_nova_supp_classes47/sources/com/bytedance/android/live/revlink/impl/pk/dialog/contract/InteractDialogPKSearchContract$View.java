package com.bytedance.android.live.revlink.impl.pk.dialog.contract;

import com.bytedance.android.live.revlink.impl.control.dialog.RevInteractDialogFragmentBaseContract$View;
import com.bytedance.android.live.revlink.impl.pk.dialog.presenter.j;
import com.bytedance.android.livesdk.link.model.IRivalRankRecommendResponse;
import com.bytedance.android.livesdk.link.model.u6;
import com.bytedance.android.livesdk.link.model.v4;
import com.bytedance.android.livesdkapi.depend.model.live.IRoom;
import d11.d;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public abstract class InteractDialogPKSearchContract$View extends RevInteractDialogFragmentBaseContract$View<j> {
    public abstract void ba0();

    public abstract void ca0(IRivalRankRecommendResponse r1);

    public abstract void da0(Throwable r1);

    public abstract void ea0(IRoom r1, d r2, v4 r3);

    public abstract void fa0(Throwable r1);

    public abstract void finish();

    public abstract void ga0(u6 r1);

    public InteractDialogPKSearchContract$View() {
    }
}
