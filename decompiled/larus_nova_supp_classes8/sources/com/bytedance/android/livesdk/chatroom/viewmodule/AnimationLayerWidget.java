package com.bytedance.android.livesdk.chatroom.viewmodule;

import com.bytedance.android.live.core.tetris.widgets.LiveRecyclableWidget;
import com.bytedance.android.livesdk.chatroom.RoomContext;
import com.bytedance.android.livesdk.chatroom.widget.AnimationLayer;
import com.bytedance.ies.sdk.widgets.DataCenter;
import com.bytedance.ies.sdk.widgets.KVData;
import com.bytedance.ies.sdk.widgets.Widget;
import com.ss.android.ugc.aweme.compat.nullable.Observer;
import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u00012\b\u0012\u0004\u0012\u00020\u00030\u0002B\u0007¢\u0006\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, d2 = {"Lcom/bytedance/android/livesdk/chatroom/viewmodule/AnimationLayerWidget;", "Lcom/bytedance/android/live/core/tetris/widgets/LiveRecyclableWidget;", "Lcom/ss/android/ugc/aweme/compat/nullable/Observer;", "Lcom/bytedance/ies/sdk/widgets/KVData;", "<init>", "()V", "livesdk_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class AnimationLayerWidget extends LiveRecyclableWidget implements Observer<KVData> {
    public AnimationLayer a;

    public final int getLayoutId() {
        return 2131566616;
    }

    public final void onUnload() {
        ((Widget) this).dataCenter.removeObserver(this);
    }

    public AnimationLayerWidget() {
    }

    public final void onChanged(Object r3) {
        KVData r4 = (KVData) r3;
        if (r4 == null) goto L9;
        String r5 = r4.getKey();
        if (r5.hashCode() != (-427075684)) goto L10;
        r5.equals("cmd_live_clear_screen_notify");
        return;
    L10:
        return;
    }

    public final void onInit(Object[] r2) {
        this.a = (AnimationLayer) ((Widget) this).containerView.findViewById(2131362961);
    }

    public final void onLoad(Object[] r4) {
        RoomContext.a r5 = RoomContext.Companion;
        DataCenter r0 = ((Widget) this).dataCenter;
        long r1 = com.bytedance.android.live.core.utils.z.o(r0).id;
        r5.getClass();
        RoomContext r6 = RoomContext.a.a(r0, r1);
        if (r6 == null) goto L5;
        r6.getAnimationLayer().setValue(this.a);
    L5:
        ((Widget) this).dataCenter.observe("cmd_live_clear_screen_notify", this);
    }
}
