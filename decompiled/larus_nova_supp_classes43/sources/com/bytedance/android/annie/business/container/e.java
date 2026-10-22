package com.bytedance.android.annie.business.container;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public final class e implements com.bytedance.ies.bullet.flow.a {
    public e() {
    }

    public final void onRelease(String r10) {
        Intrinsics.checkNotNullParameter(r10, "sessionId");
        AnnieXLiveFlowLoaderControl$liveFlowLoadContextMap$1 r1 = AnnieXLiveFlowLoaderControl.a;
        Intrinsics.checkNotNullParameter(r10, "sessionId");
        AnnieXLiveFlowLoaderControl.a r11 = (AnnieXLiveFlowLoaderControl.a) AnnieXLiveFlowLoaderControl.a.remove(r10);
        if (r11 == null) goto L6;
        r11.f.a();
        return;
    }
}
