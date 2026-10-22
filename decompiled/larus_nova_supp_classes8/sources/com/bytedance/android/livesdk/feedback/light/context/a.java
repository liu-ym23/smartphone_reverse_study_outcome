package com.bytedance.android.livesdk.feedback.light.context;

import com.bytedance.android.live.base.model.feed.FeedItem;
import com.bytedance.android.livesdk.feedback.service.FeedbackHideCode;
import com.bytedance.ies.sdk.widgets.DataCenter;
import com.bytedance.ies.web.jsbridge2.f;
import com.bytedance.live.datacontext.i;
import com.bytedance.live.datacontext.m;
import com.bytedance.live.datacontext.n;
import io.reactivex.Observable;
import java.util.List;
import kotlin.Pair;
import kotlin.Unit;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public interface a {
    void dismissFeedbackWithAnim(FeedbackHideCode r1);

    FeedbackHideCode getDismissCode();

    i<ix1.a> getFeedbackConfigService();

    String getLynxUrl();

    Observable<Unit> getOnHideEndEvent();

    m<? extends Boolean> getOnJsAutoCloseEvent();

    Observable<Integer> getOnJsCloseClickEvent();

    Observable<Unit> getOnJsCloseEvent();

    Observable<Unit> getOnShowStartEvent();

    n<? extends FeedItem> getShowRoomFeedback();

    String getWebUrl();

    void initFeedbackConfig(DataCenter r1);

    m<? extends Boolean> isFeedbackCardShowing();

    List<Pair<String, f.b>> provideJsMethods();

    void reqFeedbackShow();

    void showFeedbackCardWithAnim();

    void showRoomFeedback(FeedItem r1);

    void updateFeedbackCardShowingStatus(boolean r1);
}
