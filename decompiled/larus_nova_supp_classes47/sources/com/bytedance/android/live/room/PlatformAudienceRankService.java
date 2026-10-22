package com.bytedance.android.live.room;

import com.bytedance.android.live.room.api.IPlatformAudienceRankService;
import com.bytedance.android.live.room.api.rank.IAudienceWidget;
import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0017\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0007\u0010\bJ\u0010\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0002H\u0016J\b\u0010\u0006\u001a\u00020\u0005H\u0016¨\u0006\t"}, d2 = {"Lcom/bytedance/android/live/room/PlatformAudienceRankService;", "Lcom/bytedance/android/live/room/api/IPlatformAudienceRankService;", "Lcom/bytedance/android/livesdk/chatroom/presenter/n;", "Lcom/bytedance/android/live/room/api/rank/IAudienceWidget;", "getPlatformWatchUserPresenter", "", "interceptAudienceCountRefresh", "<init>", "()V", "experience-platform-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public class PlatformAudienceRankService implements IPlatformAudienceRankService {
    public PlatformAudienceRankService() {
    }

    @Override // com.bytedance.android.live.room.api.IPlatformAudienceRankService
    public com.bytedance.android.livesdk.chatroom.presenter.n<IAudienceWidget> getPlatformWatchUserPresenter() {
        return new da1.b();
    }

    @Override // com.bytedance.android.live.room.api.IPlatformAudienceRankService
    public boolean interceptAudienceCountRefresh() {
        int r0 = da1.b.e;
        return !da1.b.a.a();
    }
}
