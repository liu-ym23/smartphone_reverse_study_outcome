package com.bytedance.android.livesdk.interactivity.api;

import com.bytedance.android.live.base.IService;
import com.bytedance.android.live.core.tetris.widgets.LiveRecyclableWidget;
import com.bytedance.android.live.utility.ServiceLookup;
import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
@ServiceLookup("com.bytedance.android.livesdk.groupliverts.api.GroupLiveRtsService")
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\bg\u0018\u00002\u00020\u0001J\u0010\u0010\b\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00030\tH&R\u001a\u0010\u0002\u001a\u0004\u0018\u00010\u0003X¦\u000e¢\u0006\f\u001a\u0004\b\u0004\u0010\u0005\"\u0004\b\u0006\u0010\u0007¨\u0006\n"}, d2 = {"Lcom/bytedance/android/livesdk/interactivity/api/IGroupLiveRtsService;", "Lcom/bytedance/android/live/base/IService;", "groupLiveRtsWidget", "Lcom/bytedance/android/live/core/tetris/widgets/LiveRecyclableWidget;", "getGroupLiveRtsWidget", "()Lcom/bytedance/android/live/core/tetris/widgets/LiveRecyclableWidget;", "setGroupLiveRtsWidget", "(Lcom/bytedance/android/live/core/tetris/widgets/LiveRecyclableWidget;)V", "getGroupLiveRtsServiceWidget", "Ljava/lang/Class;", "interactivity-platform-api_saasRelease"}, k = 1, mv = {1, 4, 3})
public interface IGroupLiveRtsService extends IService {
    Class<? extends LiveRecyclableWidget> getGroupLiveRtsServiceWidget();

    LiveRecyclableWidget getGroupLiveRtsWidget();

    void setGroupLiveRtsWidget(LiveRecyclableWidget r1);
}
