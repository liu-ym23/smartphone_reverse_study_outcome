package com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.control;

import com.bytedance.android.live.core.log.ALogger;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class g implements e {
    public g() {
    }

    @Override // com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.control.e
    public final void a(a r2, d r3) {
        Intrinsics.checkNotNullParameter(r2, "dialogInterface");
        Intrinsics.checkNotNullParameter(r3, "requestInterface");
        ALogger.i("MorePanelDynamic", "MorePanelOnlyLocalDataStrategy");
        r2.a();
    }
}
