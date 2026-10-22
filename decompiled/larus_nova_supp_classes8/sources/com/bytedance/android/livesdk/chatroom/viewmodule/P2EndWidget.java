package com.bytedance.android.livesdk.chatroom.viewmodule;

import com.bytedance.android.live.core.tetris.widgets.LiveWidget;
import com.bytedance.android.livesdk.chatroom.RoomContext;
import com.bytedance.android.livesdk.config.wy0;
import com.bytedance.android.livesdkapi.depend.model.live.Room;
import com.bytedance.ies.sdk.widgets.DataCenter;
import com.bytedance.ies.sdk.widgets.Widget;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public class P2EndWidget extends LiveWidget {

    public class a extends com.bytedance.android.live.core.tetris.task.a {
        public final void run() {
            b(true);
        }

        public a() {
            super("p2_end_widget_load");
        }
    }

    public class b implements rv2.d {
        public final /* synthetic */ P2EndWidget a;

        public final void b() {
        }

        public final void a() {
            ((Widget) this.a).dataCenter.put("cmd_send_priority_widget_load_track", 2);
        }

        public b(P2EndWidget r1) {
            this.a = r1;
        }
    }

    public final int getLayoutId() {
        if (wy0.a.getValue().getEndWidgetLoadOpt() == false) goto L6;
        return 0;
    L6:
        return 2131568008;
    }

    public final void onCreate() {
        super.onCreate();
        a r0 = new a();
        if (isViewValid() == false) goto L14;
        Room r1 = (Room) ((Widget) this).dataCenter.get("data_room");
        if (r1 != null) goto L7;
        return;
    L7:
        RoomContext.a r2 = RoomContext.Companion;
        DataCenter r3 = ((Widget) this).dataCenter;
        long r4 = r1.getId();
        r2.getClass();
        RoomContext r5 = RoomContext.a.a(r3, r4);
        if (r5 == null) goto L12;
        rv2.a r6 = (rv2.a) r5.getWidgetLoadTaskScheduler().getValue();
        if (r6 == null) goto L12;
        r6.J(r0, new b(this));
    L12:
        ((Widget) this).dataCenter.put("cmd_p2_widget_loaded", new com.bytedance.android.livesdk.chatroom.model.q());
        return;
    }

    public final void onResume() {
        super.onResume();
        if (isViewValid() == false) goto L12;
        DataCenter r0 = ((Widget) this).dataCenter;
        if (r0 == null) goto L13;
        r0.put("cmd_p2_widget_loaded_v2", new com.bytedance.android.livesdk.chatroom.model.q());
        RoomContext.a r1 = RoomContext.Companion;
        DataCenter r2 = ((Widget) this).dataCenter;
        r1.getClass();
        RoomContext r3 = RoomContext.a.c(r1, r2, 0, 2);
        if (r3 == null) goto L14;
        com.bytedance.android.live.revenue.core.b r4 = (com.bytedance.android.live.revenue.core.b) r3.getRevenueInstance().getValue();
        if (r4 == null) goto L15;
        yz0.p.a(r4, new o2());
        return;
    L15:
        return;
    L14:
        return;
    L13:
        return;
    }

    public P2EndWidget() {
    }

    public final void onDestroy() {
        super.onDestroy();
    }
}
