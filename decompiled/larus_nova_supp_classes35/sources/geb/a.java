package geb;

import com.bytedance.lark.pb.feed.v1.FeedEntityPreview;
import com.larksuite.framework.utils.CollectionUtils;
import com.ss.android.lark.feed.app.entity.UIFeedCard;
import com.ss.android.lark.feed.shared.data.preview.FeedPreview;
import com.tencent.qqmusic.third.api.contract.BuildConfig;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public final class a {
    static {
    }

    public static String a(FeedEntityPreview r4) {
        if (r4 != null) goto L5;
        return "null";
    L5:
        StringBuilder r0 = new StringBuilder(128);
        r0.append("[feedId=");
        r0.append(r4.feed_id);
        r0.append(",feedType=");
        r0.append(r4.feed_type);
        r0.append(",updateTime=");
        r0.append(r4.update_time.longValue());
        r0.append(",userId=");
        r0.append(r4.user_id.longValue());
        r0.append(",onTopRankTime=");
        r0.append(r4.on_top_rank_time.longValue());
        r0.append(",hasChat=");
        boolean r2 = false;
        if (r4.chat_data == null) goto L8;
        boolean r1 = true;
    L9:
        r0.append(r1);
        r0.append(",hasDoc=");
        if (r4.doc_data == null) goto L12;
        boolean r3 = true;
    L13:
        r0.append(r3);
        r0.append(",hasOpenApp=");
        if (r4.open_app_data == null) goto L16;
        boolean r5 = true;
    L17:
        r0.append(r5);
        r0.append(",hasThread=");
        if (r4.thread_data == null) goto L20;
        boolean r6 = true;
    L21:
        r0.append(r6);
        r0.append(",hasSubscriptions=");
        if (r4.subscriptions_data == null) goto L24;
        r2 = true;
    L24:
        r0.append(r2);
        r0.append("]");
        return r0.toString();
    L20:
        r6 = false;
        goto L21
    L16:
        r5 = false;
        goto L17
    L12:
        r3 = false;
        goto L13
    L8:
        r1 = false;
        goto L9
    }

    public static String b(UIFeedCard r3) {
        if (r3 != null) goto L5;
        return "null";
    L5:
        StringBuilder r0 = new StringBuilder(256);
        r0.append("[id=");
        r0.append(r3.getId());
        r0.append(",entityType:");
        r0.append(r3.getType());
        r0.append(",rt:");
        r0.append(r3.getRankTime());
        r0.append(",topRankTime:");
        r0.append(r3.getOnTopRankTime());
        r0.append(",isPriority:");
        r0.append(r3.getIsPriorityProcessing());
        r0.append(",dt:");
        r0.append(r3.getDisplayTime());
        r0.append(",ut:");
        r0.append(r3.getUpdateTime());
        r0.append(",mark:");
        r0.append(r3.getMarkType());
        r0.append(",isRemind:");
        r0.append(r3.isRemind());
        r0.append(",sendStatus:");
        r0.append(r3.getMutexMarkType());
        r0.append(",bgCount:");
        r0.append(r3.getUnreadCount());
        r0.append(",avatar:");
        r0.append(r3.getAvatarKey());
        r0.append(",type:");
        r0.append(r3.getFeedType());
        r0.append(",bizType:");
        r0.append(r3.getBizType());
        r0.append(",bizId:");
        r0.append(r3.getBizId());
        r0.append(",digestMessage:");
        r0.append(CollectionUtils.isNotEmpty(r3.getDigestMessage()));
        r0.append(",draftDigestMessage:");
        if ((r3 instanceof FeedPreview) == false) goto L8;
        Object r1 = Boolean.valueOf(CollectionUtils.isNotEmpty(((FeedPreview) r3).getDraftDigestMessage()));
    L9:
        r0.append(r1);
        r0.append(",isRedBadge:");
        r0.append(r3.isRedBadge());
        r0.append("]");
        return r0.toString();
    L8:
        r1 = BuildConfig.FLAVOR;
        goto L9
    }
}
