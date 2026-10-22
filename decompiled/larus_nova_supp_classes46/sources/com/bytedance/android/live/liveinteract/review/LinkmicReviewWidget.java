package com.bytedance.android.live.liveinteract.review;

import com.bytedance.android.livesdk.chatroom.viewmodule.IWidget;
import com.bytedance.android.livesdk.chatroom.widget.MiddlewareRoomWidget;
import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u00012\u00020\u0002B\u0007¢\u0006\u0004\b\u0003\u0010\u0004¨\u0006\u0005"}, d2 = {"Lcom/bytedance/android/live/liveinteract/review/LinkmicReviewWidget;", "Lcom/bytedance/android/livesdk/chatroom/widget/MiddlewareRoomWidget;", "Lcom/bytedance/android/live/liveinteract/review/LinkmicReviewPresenter$IView;", "<init>", "()V", "liveinteract-impl_saasRelease"}, k = 1, mv = {1, 5, 1})
public final class LinkmicReviewWidget extends MiddlewareRoomWidget implements LinkmicReviewPresenter.IView {
    public LinkmicReviewPresenter a;

    public final /* synthetic */ String getLogTag() {
        return IWidget.-CC.$default$getLogTag(this);
    }

    public final void onCreate() {
        super.onCreate();
        LinkmicReviewPresenter r0 = new LinkmicReviewPresenter();
        this.a = r0;
        r0.g0(this);
    }

    public final void onDestroy() {
        super/*com.bytedance.android.live.core.tetris.widgets.LiveWidget*/.onDestroy();
        LinkmicReviewPresenter r0 = this.a;
        if (r0 == null) goto L6;
        r0.detachView();
        return;
    }

    public LinkmicReviewWidget() {
    }
}
