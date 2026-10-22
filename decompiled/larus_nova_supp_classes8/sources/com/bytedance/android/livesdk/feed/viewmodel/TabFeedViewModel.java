package com.bytedance.android.livesdk.feed.viewmodel;

import android.net.Uri;
import android.text.TextUtils;
import com.bytedance.android.livesdk.feed.IFeedRepository;
import com.bytedance.android.livesdk.feed.feed.FeedDataKey;
import com.bytedance.common.utility.StringUtils;
import com.bytedance.mt.protector.impl.UriProtector;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public class TabFeedViewModel extends FragmentFeedViewModel {
    private static final String DEFAULT_LABEL = "video";
    private static final String DY_DEFAULT_LABEL = "live_merge_null";
    protected com.bytedance.android.livesdk.feed.j feedTabRepository;
    private long id;
    private int mLastOffset;
    private int mLastPosition;
    private com.bytedance.android.livesdk.feed.m scrollTop;

    @Override // com.bytedance.android.livesdk.feed.viewmodel.BaseFeedDataViewModel
    public void mocRefresh(String r1) {
    }

    @Override // com.bytedance.android.livesdk.feed.viewmodel.BaseFeedDataViewModel
    public String event() {
        if (TextUtils.isEmpty(this.eventType) == false) goto L8;
        if (this.feedTabRepository.d(this.id) == null) goto L8;
        this.eventType = this.feedTabRepository.d(this.id).e();
    L8:
        if (TextUtils.isEmpty(this.eventType) == false) goto L11;
        this.eventType = DY_DEFAULT_LABEL;
    L11:
        return this.eventType;
    }

    @Override // com.bytedance.android.livesdk.feed.viewmodel.BaseFeedDataViewModel
    public String getUrl() {
        if (StringUtils.isEmpty(this.url) == false) goto L13;
        if (this.feedTabRepository.d(this.id) == null) goto L13;
        if (this.feedTabRepository.d(this.id).n() != null) goto L9;
        return "";
    L9:
        return this.feedTabRepository.d(this.id).n();
    L13:
        return this.url;
    }

    @Override // com.bytedance.android.livesdk.feed.viewmodel.BaseFeedDataViewModel
    public boolean scrollTop() {
        com.bytedance.android.livesdk.feed.m r0 = this.scrollTop;
        feedDataKey();
        r0.a();
        return false;
    }

    @Override // com.bytedance.android.livesdk.feed.viewmodel.BaseFeedDataViewModel
    public FeedDataKey buildFeedDataKey() {
        return FeedDataKey.a(event(), getUrl(), this.id);
    }

    public String pageKey() {
        return event();
    }

    public int getLastOffset() {
        return this.mLastOffset;
    }

    public int getLastPosition() {
        return this.mLastPosition;
    }

    public void setLastOffset(int r1) {
        this.mLastOffset = r1;
    }

    public void setLastPosition(int r1) {
        this.mLastPosition = r1;
    }

    public void setUrl(String r3) {
        if (TextUtils.isEmpty(r3) == true) goto L6;
        Uri r4 = UriProtector.parse(r3);
        this.url = r4.getPath() + "?" + r4.getQuery();
        return;
    }

    public TabFeedViewModel(IFeedRepository r1, com.bytedance.android.livesdk.feed.g r2, com.bytedance.android.livesdk.feed.j r3, hw1.a r4, com.bytedance.android.livesdk.feed.m r5, long r6) {
        super(r1, r2, r4);
        this.feedTabRepository = r3;
        this.id = r6;
        this.scrollTop = r5;
    }
}
