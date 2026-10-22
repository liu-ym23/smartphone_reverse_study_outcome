package com.ss.android.lark.flow.feed.utils;

import android.content.Context;
import com.ss.android.lark.biz.im.api.FeedCard;
import com.ss.android.lark.feed.shared.page.constant.FeedConstants;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public final class a {
    public static final /* synthetic */ int a = 0;

    static {
    }

    public static void a(Context r2, FeedCard.Type r3, String r4, Integer r5) {
        Intrinsics.checkNotNullParameter(r3, "type");
        Intrinsics.checkNotNullParameter(r4, "id");
        b.d("PendingDeleteFeedErrorHandler", "handle pending delete feed, type=" + r3 + ", id=" + r4 + ", errCode=" + r5);
        int r6 = FeedConstants.FeedErrorCode.ERROR_OPERATION_TO_PENDING_DELETE_FEED.getErrorCode();
        if (r5 != null) goto L6;
    L7:
        int r7 = FeedConstants.FeedErrorCode.ERROR_OPERATION_TO_PENDING_DELETE_FEED_SERVER_CODE.getErrorCode();
        if (r5 != null) goto L11;
    L12:
        if (r5 != null) goto L15;
    L17:
        c.a(r2, 2131889968, 2131237938);
        return;
    L15:
        if (r5.intValue() != 4007) goto L17;
    L18:
        c.a(r2, 2131889997, 2131237938);
        return;
    L11:
        if (r5.intValue() == r7) goto L18;
    L6:
        if (r5.intValue() == r6) goto L18;
        goto L7
    }
}
