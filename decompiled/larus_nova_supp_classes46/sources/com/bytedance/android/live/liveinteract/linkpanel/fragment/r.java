package com.bytedance.android.live.liveinteract.linkpanel.fragment;

import android.view.View;
import com.bytedance.ies.sdk.widgets.DataCenter;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class r implements View.OnClickListener {
    public final /* synthetic */ AudioTalkSettingFragment a;

    public r(AudioTalkSettingFragment r1) {
        this.a = r1;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r9) {
        AudioTalkSettingFragment r10 = this.a;
        DataCenter r2 = r10.l;
        if (r2 == null) goto L6;
        yf0.g r7 = r10.d;
        int r0 = MultiLinkIntegrationPlayMethodFragment.q;
        r7.Rh(MultiLinkIntegrationPlayMethodFragment.a.a(r7, r10.getRoom(), r2, this.a.p, null, 2, true));
        return;
    }
}
