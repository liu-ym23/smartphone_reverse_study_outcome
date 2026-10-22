package com.bytedance.android.live.profit.redpacket;

import android.view.View;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class e0 implements View.OnClickListener {
    public final /* synthetic */ RedPacketIconModel a;

    public e0(RedPacketIconModel r1) {
        this.a = r1;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r2) {
        this.a.h(true);
    }
}
