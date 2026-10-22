package com.bytedance.android.livesdk.feed.viewmodel;

import com.bytedance.android.live.base.model.Extra;
import com.bytedance.android.livesdk.feed.IFeedRepository;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public class FragmentFeedViewModel extends BaseFeedDataViewModel {
    private boolean preload;
    private boolean shouldRefresh;
    private boolean started;
    private boolean userVisible;

    private void onLeave() {
        if (this.started == false) goto L9;
        IFeedRepository r0 = this.feedRepository;
        if (r0 == null) goto L10;
        r0.onLeave();
        return;
    L10:
        return;
    }

    private void realStart() {
        if (this.started == false) goto L5;
        return;
    L5:
        super.start();
        this.started = true;
        this.preload = false;
    }

    public void clearDataCache() {
        IFeedRepository r0 = this.feedRepository;
        if (r0 == null) goto L6;
        r0.clearDataCache();
        return;
    }

    public Extra extra() {
        IFeedRepository r0 = this.feedRepository;
        if (r0 != null) goto L6;
        return null;
    L6:
        return r0.extra();
    }

    @Override // com.bytedance.android.livesdk.feed.viewmodel.BaseFeedDataViewModel
    public void start() {
        if (this.preload == false) goto L5;
    L6:
        realStart();
        return;
    L5:
        if (this.userVisible == true) goto L6;
    }

    public boolean getStarted() {
        return this.started;
    }

    public boolean shouldRefresh() {
        return this.shouldRefresh;
    }

    public void onFragmentUserVisibleHint(boolean r1) {
        this.userVisible = r1;
        if (r1 == true) goto L5;
        onLeave();
    L5:
        start();
    }

    public void setPreload(boolean r1) {
        this.preload = r1;
    }

    public void setShouldRefresh(boolean r1) {
        this.shouldRefresh = r1;
    }

    public void setStarted(boolean r1) {
        this.started = r1;
    }

    public FragmentFeedViewModel(IFeedRepository r1, com.bytedance.android.livesdk.feed.g r2, hw1.a r3) {
        super(r1, r2, r3);
    }
}
