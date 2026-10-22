package com.bytedance.android.live.multilink.impl;

import androidx.lifecycle.Observer;
import com.bytedance.android.livesdkapi.roomplayer.SwitchResolutionResult;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class y2<T> implements Observer {
    public final /* synthetic */ MultiLinkSeiIndicator a;

    public y2(MultiLinkSeiIndicator r1) {
        this.a = r1;
    }

    public final void onChanged(Object r3) {
        if (((SwitchResolutionResult) r3).isSuccess() == false) goto L8;
        MultiLinkSeiIndicator r4 = this.a;
        int r0 = r4.g;
        if (r0 <= 0) goto L9;
        r4.b(r0, MultiLinkSeiIndicator.Source.SWITCH_RESOLUTION);
        MultiLinkSeiIndicator r5 = this.a;
        r5.c = -1;
        r5.d = -1;
        r5.e = 0;
        r5.f = 0;
        return;
    L9:
        return;
    }
}
