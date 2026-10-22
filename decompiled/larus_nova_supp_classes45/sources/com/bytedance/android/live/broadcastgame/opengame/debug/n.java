package com.bytedance.android.live.broadcastgame.opengame.debug;

import com.bytedance.android.live.core.utils.UtilityKotlinExtentionsKt;
import io.reactivex.functions.Consumer;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public final class n<T> implements Consumer {
    public final /* synthetic */ OpenPlatformMiniAppDebugger a;

    public n(OpenPlatformMiniAppDebugger r1) {
        this.a = r1;
    }

    public final void accept(Object r7) {
        UtilityKotlinExtentionsKt.s(0, false, false, new OpenPlatformMiniAppDebugger$checkFastStartLiveInfo$3$1(this), 7);
        OpenPlatformMiniAppDebugger r0 = this.a;
        r0.f(false, (Throwable) r7);
    }
}
