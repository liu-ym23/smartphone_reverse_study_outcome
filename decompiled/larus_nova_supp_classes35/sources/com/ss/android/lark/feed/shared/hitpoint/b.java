package com.ss.android.lark.feed.shared.hitpoint;

import com.ss.android.lark.biz.im.api.FeedCard;
import com.ss.android.lark.feed.app.entity.UIFeedCard;
import com.ss.android.lark.feed.app.entity.UIFeedCardExtraKt;
import com.ss.android.lark.feed.shared.data.preview.ChatFeedPreview;
import java.util.LinkedHashMap;
import java.util.Locale;
import java.util.Map;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import neb.e;
import qeb.d;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public final class b {
    static {
    }

    @JvmStatic
    public static final void a(UIFeedCard r6, Map<String, ? extends Object> r7) {
        Intrinsics.checkNotNullParameter(r6, "item");
        String r0 = r6.getId();
        String r1 = r6.getType().name().toLowerCase(Locale.ROOT);
        int r2 = FeedHitPointNew.a;
        boolean r3 = UIFeedCardExtraKt.isOnTop(r6);
        LinkedHashMap r4 = new LinkedHashMap();
        r4.putAll(d.a(r6));
        if (r7 == null) goto L6;
        r4.putAll(r7);
    L6:
        if (r6.getType() != FeedCard.Type.DOC) goto L9;
        FeedHitPointNew.c(FeedHitPointNew.FeedMainClickParam.FEED_LEFTCLICK_DOC, MapsKt.mapOf(TuplesKt.to("file_id", r0)), e.a(r6), 4);
        return;
    L9:
        if (r6.getType() != FeedCard.Type.APP_FEED) goto L11;
        FeedHitPointNew.c(FeedHitPointNew.FeedMainClickParam.FEED_LEFTCLICK_APP_FEED, r4, e.a(r6), 4);
        return;
    L11:
        FeedHitPointNew.FeedMainClickParam r8 = FeedHitPointNew.FeedMainClickParam.FEED_LEFTCLICK_CHAT;
        Intrinsics.checkNotNull(r0);
        r4.put("chat_id", r0);
        r4.put("feed_type", r1);
        r4.put("is_temporary_top", Integer.valueOf(r3 ? 1 : 0));
        r4.put("app_type", "null");
        r4.put("unread_count", Long.valueOf(r6.getUnreadCount()));
        if ((r6 instanceof ChatFeedPreview) == false) goto L14;
        ChatFeedPreview r5 = (ChatFeedPreview) r6;
        Intrinsics.checkNotNullParameter(r5, "<this>");
        r4.put("is_ai", Boolean.valueOf(r5.isAIMainChat() | r5.isAIBotChat()));
        r4.put("msg_id", r5.getLastMessageId());
    L14:
        FeedHitPointNew.c(r8, r4, e.a(r6), 4);
    }
}
