package com.ss.android.lark.feed.export.feedcard;

import android.content.Context;
import com.ss.android.lark.feed.app.entity.UIFeedCard;
import com.ss.android.lark.feed.cardcomponent.bottomaction.FeedCardButtonsComponent;
import com.ss.android.lark.feed.shared.data.preview.ChatFeedPreview;
import com.ss.android.lark.feed.shared.data.preview.FeedPreview;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public interface c {
    xdb.a.b a(UIFeedCard r1);

    FeedCardButtonsComponent.c b(ChatFeedPreview r1, d r2);

    com.ss.android.lark.feed.cardcomponent.preview.c c(FeedPreview r1);

    com.ss.android.lark.feed.cardcomponent.preview.a.b d(Context r1, UIFeedCard r2);

    com.ss.android.lark.feed.cardcomponent.preview.e.b e(UIFeedCard r1);
}
