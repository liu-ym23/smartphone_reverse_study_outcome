package com.bytedance.android.livesdk.interactivity.pin.container.v2.utils;

import com.bytedance.android.livesdk.interactivity.api.pin.container.PinType;
import com.bytedance.android.livesdk.wrds.syncdata.highlight.HighlightItem;
import g42.d;
import g42.h;
import java.util.List;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class PinContainerAppLogger extends com.bytedance.android.livesdk.interactivity.common.utils.b {
    public static final /* synthetic */ int a = 0;

    static {
    }

    public static void d(final boolean r1, final PinType r2) {
        com.bytedance.android.livesdk.interactivity.common.utils.b.a("livesdk_comment_pin_popup_window_click", new PinContainerAppLogger$logFirstPinDialogClick$1(r1, r2));
    }

    public static void e(final boolean r1, final PinType r2) {
        com.bytedance.android.livesdk.interactivity.common.utils.b.a("livesdk_comment_pin_popup_window_show", new PinContainerAppLogger$logFirstPinDialogShow$1(r1, r2));
    }

    @JvmStatic
    public static final void c(final h<?> r1, final boolean r2, final boolean r3, final List<? extends d> r4) {
        Intrinsics.checkNotNullParameter(r1, "pinEvent");
        Intrinsics.checkNotNullParameter(r4, "injectors");
        com.bytedance.android.livesdk.interactivity.common.utils.b.a("livesdk_comment_pin", new PinContainerAppLogger$logClickPin$1(r1, r2, r3, r4));
    }

    public static void g(final HighlightItem r1, final PinType r2, final String r3, final List r4) {
        Intrinsics.checkNotNullParameter(r1, "item");
        Intrinsics.checkNotNullParameter(r3, "changeType");
        Intrinsics.checkNotNullParameter(r4, "injectors");
        com.bytedance.android.livesdk.interactivity.common.utils.b.a("livesdk_comment_on_wall_change", new PinContainerAppLogger$logPinItemShow$1(r2, r3, r4, r1));
    }

    public static void h(final HighlightItem r10, final PinType r11, final long r13, final boolean r14, final long r15, final List r17) {
        Intrinsics.checkNotNullParameter(r10, "item");
        Intrinsics.checkNotNullParameter(r17, "injectors");
        com.bytedance.android.livesdk.interactivity.common.utils.b.a("livesdk_comment_on_wall_review_duration", new PinContainerAppLogger$logReviewDuration$1(r11, r13, r14, r15, r17, r10));
    }

    @JvmStatic
    public static final void i(final HighlightItem r9, final PinType r10, final long r11, final String r13, final boolean r14, final List<? extends d> r15) {
        Intrinsics.checkNotNullParameter(r9, "item");
        Intrinsics.checkNotNullParameter(r13, "commentContent");
        Intrinsics.checkNotNullParameter(r15, "injectors");
        com.bytedance.android.livesdk.interactivity.common.utils.b.a("livesdk_comment_on_wall", new PinContainerAppLogger$logReviewSuccess$1(r10, r11, r13, r14, r15, r9));
    }

    public static void f(final HighlightItem r10, final PinType r11, final long r13, final String r14, final boolean r15, final String r16, final List r17) {
        Intrinsics.checkNotNullParameter(r10, "item");
        Intrinsics.checkNotNullParameter(r14, "commentContent");
        Intrinsics.checkNotNullParameter(r16, "deleteWay");
        Intrinsics.checkNotNullParameter(r17, "injectors");
        com.bytedance.android.livesdk.interactivity.common.utils.b.a("livesdk_comment_delete_v2", new PinContainerAppLogger$logPinItemDeleted$1(r11, r13, r14, r15, r16, r17, r10));
    }
}
