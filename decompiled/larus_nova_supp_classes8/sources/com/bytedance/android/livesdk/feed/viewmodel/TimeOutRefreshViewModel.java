package com.bytedance.android.livesdk.feed.viewmodel;

import com.bytedance.android.live.core.utils.rxutils.RxUtil;
import com.bytedance.android.live.core.utils.rxutils.RxViewModel;
import com.bytedance.android.livesdk.feed.setting.LiveFeedSettings;
import io.reactivex.Observable;
import io.reactivex.subjects.PublishSubject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public class TimeOutRefreshViewModel extends RxViewModel {
    private boolean enterDetail;
    private long leaveTime;
    private PublishSubject<Object> timeOutRefresh;

    public void onEnterDetail() {
        this.enterDetail = true;
    }

    public long getLeaveTime() {
        return ((Integer) LiveFeedSettings.MAIN_REFRESH_TIME_OUT.getValue()).intValue();
    }

    public void onLeave() {
        if (this.leaveTime != Long.MAX_VALUE) goto L6;
        this.leaveTime = System.currentTimeMillis();
        return;
    }

    public void onReturn() {
        if (this.enterDetail == false) goto L5;
    L9:
        this.leaveTime = Long.MAX_VALUE;
        this.enterDetail = false;
        return;
    L5:
        if (this.leaveTime == Long.MAX_VALUE) goto L9;
        if ((System.currentTimeMillis() - this.leaveTime) <= getLeaveTime()) goto L9;
        this.timeOutRefresh.onNext(RxUtil.__);
        goto L9
    }

    public TimeOutRefreshViewModel() {
        this.timeOutRefresh = PublishSubject.create();
        this.leaveTime = Long.MAX_VALUE;
    }

    public Observable<Object> timeOutRefresh() {
        return this.timeOutRefresh;
    }
}
