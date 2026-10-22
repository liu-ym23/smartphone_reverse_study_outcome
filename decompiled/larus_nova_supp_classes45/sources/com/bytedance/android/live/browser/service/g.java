package com.bytedance.android.live.browser.service;

import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.ies.xbridge.event.Event;
import com.bytedance.ies.xbridge.event.EventCenter;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public final class g implements com.bytedance.android.live.browser.utils.i {
    public g() {
    }

    @Override // com.bytedance.android.live.browser.utils.i
    public final void a(String r5) {
        Intrinsics.checkNotNullParameter(r5, "filePath");
        ALogger.i("AnnieAbilityProviderImpl", "onScreenCapture filePath = " + r5);
        EventCenter.enqueueEvent(new Event("H5_screenShot", System.currentTimeMillis(), null));
    }
}
