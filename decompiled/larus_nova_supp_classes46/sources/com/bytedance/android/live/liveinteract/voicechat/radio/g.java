package com.bytedance.android.live.liveinteract.voicechat.radio;

import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.liveinteract.api.MultiLinkOpenSource;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class g implements jk0.b {
    public final /* synthetic */ RadioStageContainerWidget a;

    @Override // jk0.b
    public final void onStart() {
        ALogger.i("RadioStageContainerWidget", "RadioMessage onStart--");
        k r0 = this.a.c;
        if (r0 == null) goto L6;
        r0.e = true;
        r0.h(MultiLinkOpenSource.MESSAGE);
        return;
    }

    @Override // jk0.b
    public final void onStop() {
        ALogger.i("RadioStageContainerWidget", "RadioMessage onStop--");
        k r0 = this.a.c;
        if (r0 == null) goto L6;
        r0.e = false;
        r0.i(MultiLinkOpenSource.MESSAGE);
        return;
    }

    public g(RadioStageContainerWidget r1) {
        this.a = r1;
    }
}
