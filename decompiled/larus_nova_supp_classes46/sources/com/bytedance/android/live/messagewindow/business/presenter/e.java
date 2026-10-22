package com.bytedance.android.live.messagewindow.business.presenter;

import com.bytedance.android.livesdk.message.model.i3;
import com.bytedance.ies.sdk.widgets.DataCenter;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class e extends AbsCommonCardPresenter<i3> {
    public final String e;

    @Override // com.bytedance.android.live.messagewindow.business.presenter.AbsCommonCardPresenter
    public final String d0() {
        return this.e;
    }

    public e(DataCenter r1) {
        super(r1);
        this.e = "TopRightCommonCardPresenter";
    }
}
