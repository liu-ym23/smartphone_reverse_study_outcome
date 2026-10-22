package com.bytedance.android.livesdk.feed;

import android.text.TextUtils;
import com.bytedance.android.live.base.model.feed.FeedItem;
import com.bytedance.android.livesdk.feed.feed.FeedDataKey;
import com.bytedance.android.livesdk.feed.viewmodel.LiveFeedViewModel;
import com.bytedance.common.utility.collection.CollectionUtils;
import com.bytedance.mt.protector.impl.UriProtector;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import io.reactivex.functions.Function4;
import java.util.Collections;
import java.util.List;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class a implements Function4<FeedDataKey, List<FeedItem>, Integer, List<FeedItem>, List<FeedItem>> {
    public a() {
    }

    public final Object apply(Object r5, Object r6, Object r7, Object r8) throws Exception {
        FeedDataKey r9 = (FeedDataKey) r5;
        List r10 = (List) r6;
        Integer r11 = (Integer) r7;
        List r12 = (List) r8;
        if (r9 != null) goto L5;
    L56:
        return r12;
    L5:
        if (TextUtils.isEmpty(r9.a) == true) goto L56;
        if (TextUtils.isEmpty(r9.a) == false) goto L58;
    L10:
        String r13 = null;
    L12:
        if (LiveFeedViewModel.DOUBLE_FEED_WITH_BANNER.equals(r13) == false) goto L56;
        int r14 = 0;
        if (CollectionUtils.isEmpty(r10) == true) goto L28;
        int r15 = 0;
        boolean r2 = true;
    L17:
        if (r15 >= r10.size()) goto L30;
        if (((FeedItem) ListProtector.get(r10, r15)).type != 6) goto L27;
        if ((r15 % 2) != 1) goto L24;
        if (r2 == false) goto L26;
        Collections.swap(r10, r15, r15 - 1);
    L26:
        r2 = !r2;
        goto L27
    L24:
        if (r2 == true) goto L26;
        Collections.swap(r10, r15, r15 - 1);
    L27:
        r15 = r15 + 1;
    L30:
        if (CollectionUtils.isEmpty(r12) == true) goto L56;
        if (CollectionUtils.isEmpty(r10) == false) goto L34;
        int r16 = 0;
    L36:
        if (r14 >= r12.size()) goto L56;
        int r17 = r14 + r16;
        if (((FeedItem) ListProtector.get(r12, r14)).type != 6) goto L55;
        if ((r17 % 2) != 1) goto L47;
        if (r2 == false) goto L54;
        if (r14 == 0) goto L44;
    L46:
        Collections.swap(r12, r14, r14 - 1);
        goto L54
    L44:
        if (r14 >= (r12.size() + 1)) goto L46;
        int r18 = r14 + 1;
        Collections.swap(r12, r14, r18);
    L52:
        r14 = r18;
    L54:
        r2 = !r2;
        goto L55
    L47:
        if (r2 == true) goto L54;
        if (r14 == 0) goto L50;
    L53:
        Collections.swap(r12, r14, r14 - 1);
        goto L54
    L50:
        if (r12.size() <= 1) goto L53;
        r18 = r14 + 1;
        Collections.swap(r12, r14, r18);
    L55:
        r14 = r14 + 1;
        goto L36
    L34:
        r16 = r10.size();
        goto L36
    L28:
        r2 = true;
        goto L30
    L58:
        r13 = UriProtector.getQueryParameter(UriProtector.parse(r9.a), "style");     // Catch: Exception -> L57
        goto L12
    }
}
