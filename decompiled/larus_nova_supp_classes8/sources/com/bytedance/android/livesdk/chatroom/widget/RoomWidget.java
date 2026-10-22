package com.bytedance.android.livesdk.chatroom.widget;

import com.bytedance.android.live.core.tetris.widgets.LiveWidget;
import com.bytedance.android.live.core.utils.rxutils.autodispose.ObservableSubscribeProxy;
import com.bytedance.android.livesdk.chatroom.RoomContext;
import com.bytedance.android.livesdkapi.model.com.bytedance.android.livesdk.config.MultiRoomConfig;
import io.reactivex.Observable;
import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b&\u0018\u00002\u00020\u00012\u00020\u0002B\u0007¢\u0006\u0004\b\u0003\u0010\u0004¨\u0006\u0005"}, d2 = {"Lcom/bytedance/android/livesdk/chatroom/widget/RoomWidget;", "Lcom/bytedance/android/live/core/tetris/widgets/LiveWidget;", "Lcom/bytedance/android/livesdk/chatroom/widget/g0;", "<init>", "()V", "liveroom-api_saasRelease"}, k = 1, mv = {1, 4, 3})
public abstract class RoomWidget extends LiveWidget implements g0 {
    public RoomContext a;

    public final void onMergeLoad() {
        super.onMergeLoad();
        if (MultiRoomConfig.INSTANCE.enableRoomPreload() == false) goto L22;
        RoomContext r0 = this.a;
        if (r0 == null) goto L9;
        com.bytedance.live.datacontext.n r1 = r0.isRoomVisible();
        if (r1 == null) goto L9;
        Boolean r2 = (Boolean) r1.getValue();
    L10:
        if (r2 == null) goto L12;
        r2.booleanValue();
    L12:
        RoomContext r3 = this.a;
        if (r3 == null) goto L23;
        com.bytedance.live.datacontext.n r4 = r3.isRoomVisible();
        if (r4 == null) goto L24;
        Observable r5 = r4.a();
        if (r5 == null) goto L25;
        ObservableSubscribeProxy r6 = (ObservableSubscribeProxy) r5.as(autoDispose());
        if (r6 == null) goto L26;
        r6.subscribe(new j2(this));
        return;
    L26:
        return;
    L25:
        return;
    L24:
        return;
    L23:
        return;
    L9:
        r2 = null;
        goto L10
    }

    public RoomWidget() {
    }

    public void onCreate() {
        super.onCreate();
    }

    @Override // com.bytedance.android.livesdk.chatroom.widget.g0
    public final void setRoomContext(RoomContext r1) {
        this.a = r1;
    }
}
