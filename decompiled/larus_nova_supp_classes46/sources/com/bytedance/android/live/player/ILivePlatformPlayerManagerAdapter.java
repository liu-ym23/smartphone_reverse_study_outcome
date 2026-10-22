package com.bytedance.android.live.player;

import android.view.View;
import com.bytedance.android.live.base.IService;
import com.bytedance.android.livesdkapi.depend.player.ILivePlatformPlayerProxy;
import com.bytedance.android.livesdkapi.roomplayer.ILivePlayerClient;
import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\bg\u0018\u00002\u00020\u0001J\n\u0010\n\u001a\u0004\u0018\u00010\u000bH&R\u0014\u0010\u0002\u001a\u0004\u0018\u00010\u0003X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0004\u0010\u0005R\u0014\u0010\u0006\u001a\u0004\u0018\u00010\u0007X¦\u0004¢\u0006\u0006\u001a\u0004\b\b\u0010\t¨\u0006\f"}, d2 = {"Lcom/bytedance/android/live/player/ILivePlatformPlayerManagerAdapter;", "Lcom/bytedance/android/live/base/IService;", "currentClient", "Lcom/bytedance/android/livesdkapi/roomplayer/ILivePlayerClient;", "getCurrentClient", "()Lcom/bytedance/android/livesdkapi/roomplayer/ILivePlayerClient;", "currentLivePlayerParent", "Landroid/view/View;", "getCurrentLivePlayerParent", "()Landroid/view/View;", "curRoomPlayer", "Lcom/bytedance/android/livesdkapi/depend/player/ILivePlatformPlayerProxy;", "multilink-platform-api_saasRelease"}, k = 1, mv = {1, 5, 1})
public interface ILivePlatformPlayerManagerAdapter extends IService {
    ILivePlatformPlayerProxy curRoomPlayer();

    ILivePlayerClient getCurrentClient();

    View getCurrentLivePlayerParent();
}
