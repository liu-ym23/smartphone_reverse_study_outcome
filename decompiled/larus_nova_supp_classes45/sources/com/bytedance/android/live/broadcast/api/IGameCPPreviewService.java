package com.bytedance.android.live.broadcast.api;

import com.bytedance.android.livesdkapi.depend.model.live.LiveMode;
import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\bg\u0018\u00002\u00020\u0001J\u000f\u0010\u0002\u001a\u0004\u0018\u00010\u0003H&¢\u0006\u0002\u0010\u0004J\n\u0010\u0005\u001a\u0004\u0018\u00010\u0006H&J\u0010\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nH&¨\u0006\u000b"}, d2 = {"Lcom/bytedance/android/live/broadcast/api/IGameCPPreviewService;", "", "getCategoryId", "", "()Ljava/lang/Long;", "getPreviewLiveMode", "Lcom/bytedance/android/livesdkapi/depend/model/live/LiveMode;", "setGameDetailCameraOperation", "", "bool", "", "livebroadcast-api_saasRelease"}, k = 1, mv = {1, 4, 3})
public interface IGameCPPreviewService {
    Long getCategoryId();

    LiveMode getPreviewLiveMode();

    void setGameDetailCameraOperation(boolean r1);
}
