package com.bytedance.android.live.gift;

import android.content.Context;
import ca0.v;
import com.bytedance.android.live.base.IService;
import com.bytedance.android.live.utility.ServiceLookup;
import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
@ServiceLookup("com.bytedance.android.livesdk.gift.platform.core.download.RoomStateService")
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\bg\u0018\u00002\u00020\u0001J\u0012\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H&J\b\u0010\u0006\u001a\u00020\u0004H&J\u0010\u0010\t\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u0007H&J\u0010\u0010\n\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u0007H&¨\u0006\u000b"}, d2 = {"Lcom/bytedance/android/live/gift/IRoomStateService;", "Lcom/bytedance/android/live/base/IService;", "Landroid/content/Context;", "context", "", "onEnterRoom", "onExitRoom", "Lca0/v;", "listener", "registRoomStateListner", "unregistRoomStateListner", "revenue-api_saasRelease"}, k = 1, mv = {1, 5, 1})
public interface IRoomStateService extends IService {
    void onEnterRoom(Context r1);

    void onExitRoom();

    void registRoomStateListner(v r1);

    void unregistRoomStateListner(v r1);
}
