package com.bytedance.android.livesdk.interactivity.api;

import com.bytedance.android.live.core.tetris.widgets.LiveRecyclableWidget;
import com.bytedance.android.livesdk.interactivity.notifications.LiveRoomNotifyWidget;
import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0017\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0012\u0010\u0003\u001a\f\u0012\b\b\u0001\u0012\u0004\u0018\u00010\u00050\u0004H\u0016¨\u0006\u0006"}, d2 = {"Lcom/bytedance/android/livesdk/interactivity/api/NotifyService;", "Lcom/bytedance/android/livesdk/interactivity/api/INotifyService;", "()V", "getNotifyWidgetClass", "Ljava/lang/Class;", "Lcom/bytedance/android/live/core/tetris/widgets/LiveRecyclableWidget;", "interactivity-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public class NotifyService implements INotifyService {
    public NotifyService() {
    }

    @Override // com.bytedance.android.livesdk.interactivity.api.INotifyService
    public Class<? extends LiveRecyclableWidget> getNotifyWidgetClass() {
        return LiveRoomNotifyWidget.class;
    }
}
