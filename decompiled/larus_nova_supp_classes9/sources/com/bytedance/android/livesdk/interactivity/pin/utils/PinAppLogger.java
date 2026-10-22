package com.bytedance.android.livesdk.interactivity.pin.utils;

import com.bytedance.android.livesdk.interactivity.common.utils.b;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class PinAppLogger extends b {
    static {
    }

    @JvmStatic
    public static final void c(final String r1, final boolean r2) {
        Intrinsics.checkNotNullParameter(r1, "audienceId");
        b.a("livesdk_anchor_audience_link_popup_click", new PinAppLogger$sendInteractPinClick$1(r2, r1));
    }

    @JvmStatic
    public static final void d(final String r1, final boolean r2) {
        Intrinsics.checkNotNullParameter(r1, "audienceId");
        b.a("livesdk_anchor_audience_link_popup_show", new PinAppLogger$sendInteractPinShow$1(r2, r1));
    }

    @JvmStatic
    public static final void e(final long r1, final String r3) {
        Intrinsics.checkNotNullParameter(r3, "actionType");
        b.a("livesdk_anchor_comment_popup_click", new PinAppLogger$sendPinPopupClickVideoEvent$1(r3, r1));
    }

    @JvmStatic
    public static final void f(final String r1, final String r2) {
        Intrinsics.checkNotNullParameter(r1, "videoId");
        Intrinsics.checkNotNullParameter(r2, "userType");
        b.a("livesdk_video_comment_pin_click", new PinAppLogger$sendVideoCommentPinClick$1(r1, r2));
    }

    @JvmStatic
    public static final void g(final String r1, final String r2) {
        Intrinsics.checkNotNullParameter(r1, "videoId");
        Intrinsics.checkNotNullParameter(r2, "userType");
        b.a("livesdk_video_comment_pin_show", new PinAppLogger$sendVideoCommentPinShow$1(r1, r2));
    }
}
