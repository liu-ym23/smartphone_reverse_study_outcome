package com.ss.android.lark.feed.export.feedcard;

import com.bytedance.lark.pb.feed.v1.FeedEntityPreview;
import com.ss.android.lark.biz.im.api.FeedPreviewInfo;
import com.ss.android.lark.feed.app.entity.UIFeedCard;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public interface f {
    FeedPreviewInfo a(FeedEntityPreview r1);

    UIFeedCard b(FeedPreviewInfo r1);

    boolean c(FeedEntityPreview r1);
}
