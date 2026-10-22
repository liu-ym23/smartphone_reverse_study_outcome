package com.bytedance.android.livesdk.interactivity.comment.share;

import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class InteractivityShareAppLogger extends com.bytedance.android.livesdk.interactivity.common.utils.b {
    public static final /* synthetic */ int a = 0;

    static {
    }

    @JvmStatic
    public static final void c(final w22.a r1) {
        Intrinsics.checkNotNullParameter(r1, "shareContent");
        com.bytedance.android.livesdk.interactivity.common.utils.b.a("livesdk_audience_live_message", new InteractivityShareAppLogger$sendShare$2(r1));
    }

    @JvmStatic
    public static final void d(final com.bytedance.android.livesdk.interactivity.comment.share.model.a.C0146a r1) {
        Intrinsics.checkNotNullParameter(r1, "item");
        com.bytedance.android.livesdk.interactivity.common.utils.b.a("livesdk_room_share_panel_send_click", new InteractivityShareAppLogger$sendSharePanelItemClick$1(r1));
    }

    @JvmStatic
    public static final void e(final com.bytedance.android.livesdk.interactivity.comment.share.model.a.C0146a r1) {
        Intrinsics.checkNotNullParameter(r1, "item");
        com.bytedance.android.livesdk.interactivity.common.utils.b.a("livesdk_room_share_panel_card_show", new InteractivityShareAppLogger$sendSharePanelItemShow$1(r1));
    }
}
