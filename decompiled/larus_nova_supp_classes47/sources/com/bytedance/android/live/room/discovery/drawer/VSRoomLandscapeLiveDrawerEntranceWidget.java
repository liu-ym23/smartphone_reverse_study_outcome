package com.bytedance.android.live.room.discovery.drawer;

import androidx.lifecycle.Observer;
import com.bytedance.android.live.core.tetris.layer.core.event.LayerEventDispatcher;
import com.bytedance.android.livesdk.chatroom.RoomContext;
import com.bytedance.android.livesdk.chatroom.vsplayer.model.PlayerViewControl;
import com.bytedance.android.livesdk.utils.e5;
import com.bytedance.ies.sdk.widgets.DataCenter;
import com.bytedance.ies.sdk.widgets.KVData;
import com.bytedance.ies.sdk.widgets.Widget;
import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
@PlayerViewControl(key = PlayerViewControl.KEY.LandscapeDrawer, needDynamicControl = true, type = PlayerViewControl.Type.TOP)
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/bytedance/android/live/room/discovery/drawer/VSRoomLandscapeLiveDrawerEntranceWidget;", "Lcom/bytedance/android/live/room/discovery/drawer/NewLiveDrawerEntranceWidget;", "<init>", "()V", "experience-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class VSRoomLandscapeLiveDrawerEntranceWidget extends NewLiveDrawerEntranceWidget {
    public static final /* synthetic */ int A = 0;

    public static final class a<T> implements Observer {
        public final /* synthetic */ VSRoomLandscapeLiveDrawerEntranceWidget a;

        public a(VSRoomLandscapeLiveDrawerEntranceWidget r1) {
            this.a = r1;
        }

        public final void onChanged(Object r3) {
            KVData r4 = (KVData) r3;
            VSRoomLandscapeLiveDrawerEntranceWidget r5 = this.a;
            int r0 = VSRoomLandscapeLiveDrawerEntranceWidget.A;
            ((Widget) r5).contentView.setVisibility(8);
            DataCenter r6 = ((Widget) r5).dataCenter;
            if (r6 == null) goto L5;
            Integer r7 = Integer.valueOf(r6.hashCode());
        L6:
            LayerEventDispatcher r8 = o70.c.a(r7);
            if (r8 == null) goto L10;
            r8.b(new yn1.b());
            return;
        L10:
            return;
        L5:
            r7 = null;
            goto L6
        }
    }

    @Override // com.bytedance.android.live.room.discovery.drawer.NewLiveDrawerEntranceWidget
    public final boolean Fq() {
        RoomContext r0 = RoomContext.a.c(RoomContext.Companion, null, 0, 3);
        if (r0 == null) goto L9;
        if (true != r0.isVSRoom()) goto L9;
        return e5.n();
    L9:
        return super.Fq();
    }

    public VSRoomLandscapeLiveDrawerEntranceWidget() {
    }

    @Override // com.bytedance.android.live.room.discovery.drawer.NewLiveDrawerEntranceWidget
    public final void onInit(Object[] r3) {
        super.onInit(r3);
        DataCenter r4 = ((Widget) this).dataCenter;
        if (r4 == null) goto L6;
        r4.observe("cmd_top_right_banner_load_url", new a(this));
        return;
    }
}
