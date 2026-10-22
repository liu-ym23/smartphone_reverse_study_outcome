package com.bytedance.android.live.room.api;

import com.bytedance.android.live.base.IService;
import com.bytedance.android.live.room.api.rank.IAudienceWidget;
import com.bytedance.android.live.utility.ServiceLookup;
import com.bytedance.android.livesdk.chatroom.presenter.n;
import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
@ServiceLookup("com.bytedance.android.live.room.PlatformAudienceRankService")
@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\bg\u0018\u00002\u00020\u0001J\u0010\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0002H&J\b\u0010\u0006\u001a\u00020\u0005H\u0016¨\u0006\u0007"}, d2 = {"Lcom/bytedance/android/live/room/api/IPlatformAudienceRankService;", "Lcom/bytedance/android/live/base/IService;", "Lcom/bytedance/android/livesdk/chatroom/presenter/n;", "Lcom/bytedance/android/live/room/api/rank/IAudienceWidget;", "getPlatformWatchUserPresenter", "", "interceptAudienceCountRefresh", "experience-platform-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public interface IPlatformAudienceRankService extends IService {
    n<IAudienceWidget> getPlatformWatchUserPresenter();

    boolean interceptAudienceCountRefresh();
}
