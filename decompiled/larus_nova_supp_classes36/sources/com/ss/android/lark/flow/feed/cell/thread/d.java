package com.ss.android.lark.flow.feed.cell.thread;

import com.bytedance.lark.pb.basic.v1.Chat;
import com.bytedance.lark.pb.feed.v1.FeedEntityPreview;
import com.bytedance.lark.pb.feed.v1.ThreadData;
import com.ss.android.lark.biz.im.api.FeedCard;
import com.ss.android.lark.biz.im.api.FeedPreviewInfo;
import com.ss.android.lark.feed.app.entity.UIFeedCard;
import com.ss.android.lark.feed.export.feedcard.f;
import com.ss.android.lark.feed.shared.data.preview.ThreadFeedPreview;
import com.ss.android.lark.feed.shared.data.utils.j;
import kotlin.jvm.internal.Intrinsics;
import leb.e;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public final class d implements f {
    public final e a;

    public d() {
        this.a = new e();
    }

    public final FeedPreviewInfo a(FeedEntityPreview r4) {
        Intrinsics.checkNotNullParameter(r4, "pbFeed");
        FeedPreviewInfo r0 = beb.b.c(r4);
        Intrinsics.checkNotNullParameter(r0, "<this>");
        Intrinsics.checkNotNullParameter(r4, "pb");
        ThreadData r5 = r4.thread_data;
        if (r5 == null) goto L22;
        ThreadData.EntityType r1 = r5.entity_type;
        if (r1 != null) goto L7;
        int r2 = -1;
    L9:
        if (r2 != 1) goto L11;
        FeedCard.Type r3 = FeedCard.Type.THREAD;
    L18:
        r0.d = r3;
        r0.g = r5.name;
        r0.f = r5.avatar_key;
        r0.i = r5.unread_count.intValue();
        r0.j = r5.is_remind.booleanValue();
        r0.s = com.ss.android.lark.feed.shared.data.utils.b.a(r5.draft_preview);
        r0.p = com.ss.android.lark.feed.shared.data.utils.b.c(r5.at_info);
        r0.M1 = com.ss.android.lark.feed.shared.data.utils.b.b(r5.at_infos);
        r0.q = r5.at_infos_count.intValue();
        r0.t = FeedPreviewInfo.EntityStatus.getSource(r5.entity_status.getValue());
        r0.k = r5.display_time.longValue();
        r0.l = r5.rank_time.longValue();
        r0.b2 = r5.chat_id;
        r0.p0 = r5.digest;
        Chat.Type r6 = r5.chat_type;
        if (r6 == null) goto L21;
        r0.G = com.ss.android.lark.chat.entity.chat.Chat.Type.forNumber(r6.getValue());
    L21:
        r0.J = r5.chatter_id;
        r0.P0 = j.a(r5.reactions);
        goto L22
    L11:
        if (r2 != 2) goto L13;
        r3 = FeedCard.Type.TOPIC;
        goto L18
    L13:
        if (r2 == 3) goto L15;
        r3 = FeedCard.Type.UNKNOWN;
        goto L18
    L15:
        r3 = FeedCard.Type.MSG_THREAD;
        goto L18
    L7:
        r2 = com.ss.android.lark.feed.shared.page.utils.c.a[r1.ordinal()];
    L22:
        return r0;
    }

    public final UIFeedCard b(FeedPreviewInfo r3) {
        Intrinsics.checkNotNullParameter(r3, "feedPreviewInfo");
        Object r4 = this.a.e(r3);
        ((ThreadFeedPreview) r4).setReactionDisplayCount(6);
        return (UIFeedCard) r4;
    }

    public final boolean c(FeedEntityPreview r2) {
        Intrinsics.checkNotNullParameter(r2, "pbFeed");
        if (r2.thread_data == null) goto L5;
        return true;
    L5:
        return false;
    }
}
