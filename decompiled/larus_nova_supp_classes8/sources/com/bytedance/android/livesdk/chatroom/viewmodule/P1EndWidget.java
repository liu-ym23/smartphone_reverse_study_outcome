package com.bytedance.android.livesdk.chatroom.viewmodule;

import com.bytedance.android.live.core.tetris.widgets.LiveWidget;
import com.bytedance.android.livesdk.chatroom.RoomContext;
import com.bytedance.android.livesdk.config.wy0;
import com.bytedance.android.livesdkapi.depend.model.live.Room;
import com.bytedance.ies.sdk.widgets.DataCenter;
import com.bytedance.ies.sdk.widgets.Widget;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public class P1EndWidget extends LiveWidget {

    public class a extends com.bytedance.android.live.core.tetris.task.a {
        public final void run() {
            b(true);
        }

        public a() {
            super("p1_end_widget_load");
        }
    }

    public class b implements rv2.d {
        public final /* synthetic */ P1EndWidget a;

        public final void b() {
        }

        public final void a() {
            ((Widget) this.a).dataCenter.put("cmd_send_priority_widget_load_track", 1);
        }

        public b(P1EndWidget r1) {
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
        r6.H(r0, new b(this));
    L12:
        ((Widget) this).dataCenter.put("cmd_p1_widget_loaded", new com.bytedance.android.livesdk.chatroom.model.q());
        return;
    }

    public final void onResume() {
        super.onResume();
        if (isViewValid() == false) goto L8;
        DataCenter r0 = ((Widget) this).dataCenter;
        if (r0 == null) goto L9;
        r0.put("cmd_p1_widget_loaded_v2", new com.bytedance.android.livesdk.chatroom.model.q());
        return;
    L9:
        return;
    }

    public P1EndWidget() {
    }

    public final void onDestroy() {
        super.onDestroy();
    }
}
