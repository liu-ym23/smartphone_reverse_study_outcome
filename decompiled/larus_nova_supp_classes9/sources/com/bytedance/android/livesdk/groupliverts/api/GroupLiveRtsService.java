package com.bytedance.android.livesdk.groupliverts.api;

import com.bytedance.android.live.core.tetris.widgets.LiveRecyclableWidget;
import com.bytedance.android.livesdk.groupliverts.widget.GroupLiveRtsServiceWidget;
import com.bytedance.android.livesdk.interactivity.api.IGroupLiveRtsService;
import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\b\u0017\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0010\u0010\t\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00040\nH\u0016R\u001c\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\b¨\u0006\u000b"}, d2 = {"Lcom/bytedance/android/livesdk/groupliverts/api/GroupLiveRtsService;", "Lcom/bytedance/android/livesdk/interactivity/api/IGroupLiveRtsService;", "()V", "groupLiveRtsWidget", "Lcom/bytedance/android/live/core/tetris/widgets/LiveRecyclableWidget;", "getGroupLiveRtsWidget", "()Lcom/bytedance/android/live/core/tetris/widgets/LiveRecyclableWidget;", "setGroupLiveRtsWidget", "(Lcom/bytedance/android/live/core/tetris/widgets/LiveRecyclableWidget;)V", "getGroupLiveRtsServiceWidget", "Ljava/lang/Class;", "livegift-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public class GroupLiveRtsService implements IGroupLiveRtsService {
    private LiveRecyclableWidget groupLiveRtsWidget;

    public GroupLiveRtsService() {
    }

    @Override // com.bytedance.android.livesdk.interactivity.api.IGroupLiveRtsService
    public Class<? extends LiveRecyclableWidget> getGroupLiveRtsServiceWidget() {
        return GroupLiveRtsServiceWidget.class;
    }

    @Override // com.bytedance.android.livesdk.interactivity.api.IGroupLiveRtsService
    public LiveRecyclableWidget getGroupLiveRtsWidget() {
        return this.groupLiveRtsWidget;
    }

    @Override // com.bytedance.android.livesdk.interactivity.api.IGroupLiveRtsService
    public void setGroupLiveRtsWidget(LiveRecyclableWidget r1) {
        this.groupLiveRtsWidget = r1;
    }
}
