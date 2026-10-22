package com.ss.android.lark.feed.shared.data.utils;

import com.bytedance.lark.pb.feed.v1.AtInfo;
import com.bytedance.lark.pb.feed.v1.DraftPreview;
import com.bytedance.lark.pb.feed.v1.UrgentInfo;
import com.ss.android.lark.biz.im.api.FeedPreviewInfo;
import com.ss.android.lark.biz.im.api.MuteUrgentInfo;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.TimeUnit;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public final class b {
    public static FeedPreviewInfo.a a(DraftPreview r2) {
        if (r2 != null) goto L5;
        return null;
    L5:
        FeedPreviewInfo.a r0 = new FeedPreviewInfo.a();
        r0.a = r2.content;
        r0.b = r2.cloud_draft_content;
        r0.c = r2.attachment_snapshot;
        return r0;
    }

    public static List<FeedPreviewInfo.AtInfo> b(List<AtInfo> r2) {
        ArrayList r0 = new ArrayList();
        if (r2 != null) goto L5;
        return r0;
    L5:
        Iterator<AtInfo> r3 = r2.iterator();
    L7:
        if (r3.hasNext() == false) goto L9;
        r0.add(c(r3.next()));
        goto L7
    L9:
        return r0;
    }

    public static FeedPreviewInfo.AtInfo c(AtInfo r5) {
        if (r5 != null) goto L5;
        return null;
    L5:
        FeedPreviewInfo.AtInfo r0 = new FeedPreviewInfo.AtInfo();
        r0.b = FeedPreviewInfo.AtInfo.AtType.getSource(r5.type.getValue());
        r0.a = r5.user_id;
        r0.e = r5.avatar_key;
        r0.c = r5.localized_user_name;
        r0.d = r5.channel_id;
        Long r1 = r5.at_display_time;
        if (r1 == null) goto L8;
        long r2 = TimeUnit.SECONDS.toMillis(r1.longValue());
    L9:
        r0.g = r2;
        r0.f = r5.at_rank_time.longValue();
        r0.h = r5.at_content;
        return r0;
    L8:
        r2 = 0;
        goto L9
    }

    public static MuteUrgentInfo d(UrgentInfo r6) {
        if (r6 != null) goto L5;
        return null;
    L5:
        Long r1 = r6.rank_time;
        Long r2 = r6.display_time;
        if (r2 == null) goto L8;
        long r3 = TimeUnit.SECONDS.toMillis(r2.longValue());
    L10:
        return new MuteUrgentInfo(r1, Long.valueOf(r3), r6.urgent_content);
    L8:
        r3 = 0;
        goto L10
    }
}
