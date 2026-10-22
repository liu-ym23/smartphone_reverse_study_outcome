package com.bytedance.android.livesdk.interactivity.common.utils;

import kotlin.Deprecated;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
@Deprecated(message = "use PinContainerAppLogger")
public final class LiveHighlightAppLogger extends b {
    static {
    }

    @JvmStatic
    public static final void c(final int r2) {
        final String r1 = "auto";
        Intrinsics.checkNotNullParameter("auto", "changeType");
        b.a("livesdk_reply_comment_on_wall_change", new LiveHighlightAppLogger$sendCommentOnWallPagerChange$1(r1, r2));
    }

    @JvmStatic
    public static final void d(final String r1, final String r2) {
        Intrinsics.checkNotNullParameter(r2, "sendUserType");
        b.a("livesdk_video_comment_pin_success", new LiveHighlightAppLogger$sendPinVideoSuccess$1(r1, r2));
    }
}
