package com.bytedance.lark.lark_biz_feed_android;

import com.bytedance.lark.pb.feed.v1.FeedEntityPreview;
import kotlin.ULong;
import kotlin.jvm.internal.Intrinsics;
import lark_biz_feed.proto.BizError;
import lark_biz_feed.proto.LarkFeedInfo;
import lark_biz_feed.proto.LarkFeedListViewObjectFieldValue;
import lark_biz_feed.proto.ListStatus;
import lark_biz_feed.proto.ToastStatus;
import lark_biz_feed.proto.ToastStatusFailure;
import lark_biz_feed.proto.ToastStatusSuccess;
import okio.ByteString;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class s0 {
    public static final n a(LarkFeedInfo r11) {
        Intrinsics.checkNotNullParameter(r11, "<this>");
        int r2 = r11.badge_count.intValue();
        ByteString r0 = r11.latest_preview;
        if (r0 == null) goto L5;
        FeedEntityPreview r1 = (FeedEntityPreview) FeedEntityPreview.ADAPTER.decode(r0.toByteArray());
    L7:
        return new n(r2, r1, r11.rank_time_ms.longValue(), r11.version.longValue(), r11.badge_count_without_doubao.intValue(), r11.message_on_top_badge_count.intValue(), r11.message_without_doubao_on_top_badge_count.intValue());
    L5:
        r1 = null;
        goto L7
    }

    public static final o0 b(LarkFeedListViewObjectFieldValue r5) {
        Intrinsics.checkNotNullParameter(r5, "<this>");
        ListStatus r1 = r5.load_status;
        if (r1 == null) goto L6;
        Intrinsics.checkNotNullParameter(r1, "<this>");
        return new q0(new t0(r1.is_loading.booleanValue(), r1.is_empty.booleanValue()));
    L6:
        ToastStatus r2 = r5.toast_status;
        if (r2 == null) goto L31;
        Intrinsics.checkNotNullParameter(r2, "<this>");
        if (r2.none == null) goto L11;
        w0 r0 = z0.a;
    L28:
        return new r0(r0);
    L11:
        ToastStatusSuccess r3 = r2.on_no_disturb_switch_change_success;
        if (r3 == null) goto L15;
        Intrinsics.checkNotNullParameter(r3, "<this>");
        w0 r4 = new d1(new e1(ULong.constructor-impl(r3.version.longValue()), r3.is_remind.booleanValue()));
    L14:
        r0 = r4;
        goto L28
    L15:
        ToastStatusFailure r6 = r2.on_no_disturb_switch_change_failure;
        if (r6 == null) goto L18;
        r0 = new c1(c(r6));
        goto L28
    L18:
        ToastStatusSuccess r7 = r2.on_auto_mute_switch_change_success;
        if (r7 == null) goto L21;
        Intrinsics.checkNotNullParameter(r7, "<this>");
        r4 = new b1(new e1(ULong.constructor-impl(r7.version.longValue()), r7.is_remind.booleanValue()));
        goto L14
    L21:
        ToastStatusFailure r8 = r2.on_auto_mute_switch_change_failure;
        if (r8 == null) goto L24;
        r4 = new a1(c(r8));
        goto L14
    L24:
        ToastStatusFailure r9 = r2.general_failure;
        if (r9 == null) goto L30;
        r4 = new y0(c(r9));
        goto L14
    L30:
        throw new UnhandledException("Unable to determine the [ToastStatus] variant");
    L31:
        Boolean r10 = r5.can_load_more;
        if (r10 == null) goto L36;
        return new p0(r10.booleanValue());
    L36:
        throw new UnhandledException("Unable to determine the [LarkFeedListViewObjectFieldValue] variant");
    }

    public static final x0 c(ToastStatusFailure r7) {
        Intrinsics.checkNotNullParameter(r7, "<this>");
        return new x0(ULong.constructor-impl(r7.version.longValue()), r7.is_remind.booleanValue(), r7.error_message, r7.error_code.intValue());
    }

    public static final ViewFlowError d(lark_biz_feed.proto.ViewFlowError r3) {
        Intrinsics.checkNotNullParameter(r3, "<this>");
        if (r3.view_flow_is_shut_down == null) goto L7;
        return ViewFlowErrorViewFlowIsShutDown.INSTANCE;
    L7:
        if (r3.no_container_handle == null) goto L11;
        return ViewFlowErrorNoContainerHandle.INSTANCE;
    L11:
        if (r3.biz == null) goto L15;
        BizError r4 = r3.biz;
        Intrinsics.checkNotNullParameter(r4, "<this>");
        return new ViewFlowErrorBiz(new d(r4.code.intValue(), r4.msg));
    L15:
        throw new UnhandledException("Unable to determine the [ViewFlowError] variant");
    }
}
