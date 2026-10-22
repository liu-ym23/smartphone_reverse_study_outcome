package com.bytedance.android.live.liveinteract.voicechat.radio;

import com.bytedance.android.live.core.log.ALogger;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class h implements jk0.b {
    public final /* synthetic */ RadioStageContainerWidget a;

    @Override // jk0.b
    public final void onStart() {
        ALogger.i("RadioStageContainerWidget", "RadioSubtitle onStart--");
        k r0 = this.a.c;
        if (r0 == null) goto L6;
        r0.d();
        return;
    }

    @Override // jk0.b
    public final void onStop() {
        ALogger.i("RadioStageContainerWidget", "RadioSubtitle onStop--");
        k r0 = this.a.c;
        if (r0 == null) goto L6;
        r0.e();
        return;
    }

    public h(RadioStageContainerWidget r1) {
        this.a = r1;
    }
}
