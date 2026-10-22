package com.bytedance.android.livesdk.chatroom.ui.behavior;

import com.bytedance.android.live.core.log.ALogger;
import io.reactivex.functions.Consumer;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class e<T> implements Consumer {
    public final /* synthetic */ ToolbarVideoQualityBehavior a;

    public e(ToolbarVideoQualityBehavior r1) {
        this.a = r1;
    }

    public final void accept(Object r2) {
        Boolean r3 = (Boolean) r2;
        ToolbarVideoQualityBehavior r4 = this.a;
        int r0 = ToolbarVideoQualityBehavior.m;
        r4.c();
        ALogger.d("ToolbarVideoQualityBehavior", "playerViewVisibleTriggeredByUser");
    }
}
