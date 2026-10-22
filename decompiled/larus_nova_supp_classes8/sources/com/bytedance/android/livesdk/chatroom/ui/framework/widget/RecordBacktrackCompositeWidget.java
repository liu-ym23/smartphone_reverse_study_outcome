package com.bytedance.android.livesdk.chatroom.ui.framework.widget;

import com.bytedance.android.livesdk.chatroom.widget.MiddlewareRoomWidget;
import com.bytedance.android.livesdkapi.depend.live.IAnchorBacktrackService;
import com.bytedance.ies.sdk.widgets.DataCenter;
import com.bytedance.ies.sdk.widgets.Widget;
import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/bytedance/android/livesdk/chatroom/ui/framework/widget/RecordBacktrackCompositeWidget;", "Lcom/bytedance/android/livesdk/chatroom/widget/MiddlewareRoomWidget;", "<init>", "()V", "livesdk_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class RecordBacktrackCompositeWidget extends MiddlewareRoomWidget {
    @Override // com.bytedance.android.livesdk.chatroom.widget.MiddlewareRoomWidget
    public final void onCreate() {
        super.onCreate();
        com.bytedance.android.livesdk.chatroom.ui.framework.utils.f.c(this);
        if (((Widget) this).dataCenter.get("data_backtrack_service", null) != null) goto L6;
        DataCenter r0 = ((Widget) this).dataCenter;
        r0.put("data_backtrack_service", new zf1.b0(r0, zf1.c.b(getContext())));
        return;
    }

    public final void onDestroy() {
        super.onDestroy();
        com.bytedance.android.livesdk.chatroom.ui.framework.utils.f.d(this);
        IAnchorBacktrackService r0 = (IAnchorBacktrackService) ((Widget) this).dataCenter.get("data_backtrack_service", null);
        if (r0 == null) goto L6;
        r0.release();
        ((Widget) this).dataCenter.put("data_backtrack_service", null);
        return;
    }

    public RecordBacktrackCompositeWidget() {
    }
}
