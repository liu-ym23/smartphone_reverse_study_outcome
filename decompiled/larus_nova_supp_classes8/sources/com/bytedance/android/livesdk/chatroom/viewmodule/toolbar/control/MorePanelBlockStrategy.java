package com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.control;

import com.bytedance.android.live.core.log.ALogger;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class MorePanelBlockStrategy implements e {
    public MorePanelBlockStrategy() {
    }

    @Override // com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.control.e
    public final void a(final a r3, d r4) {
        Intrinsics.checkNotNullParameter(r3, "dialogInterface");
        Intrinsics.checkNotNullParameter(r4, "requestInterface");
        ALogger.i("MorePanelDynamic", "MorePanelBlockStrategy");
        r4.requestData(2, new MorePanelBlockStrategy$openDialog$1(r3), new MorePanelBlockStrategy$openDialog$2(r3));
    }
}
