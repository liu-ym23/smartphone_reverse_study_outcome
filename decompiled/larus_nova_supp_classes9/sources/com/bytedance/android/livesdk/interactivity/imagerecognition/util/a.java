package com.bytedance.android.livesdk.interactivity.imagerecognition.util;

import com.bytedance.android.live.core.monitor.LiveMonitor;
import com.bytedance.android.livesdk.chatroom.RoomContext;
import com.bytedance.android.livesdk.interactivity.api.monitor.InteractivityMonitor;
import com.bytedance.android.livesdk.interactivity.imagerecognition.d;
import com.bytedance.android.livesdkapi.depend.model.live.Room;
import com.bytedance.android.livesdkapi.imagerecognition.ImageRecognitionEntry;
import com.bytedance.live.datacontext.m;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class a {
    public static final /* synthetic */ int a = 0;

    static {
    }

    public static void b(int r5, d r6) {
        RoomContext r0 = RoomContext.a.c(RoomContext.Companion, null, 0, 3);
        if (r0 == null) goto L7;
        m r1 = r0.getRoom();
        if (r1 == null) goto L7;
        Room r2 = (Room) r1.getValue();
    L8:
        LiveMonitor.a r3 = InteractivityMonitor.a(InteractivityMonitor.Event.ImageRecognitionRequest, r2, null);
        r3.l(r6.c);
        r3.m(r6.d);
        r3.e("scene", String.valueOf(r5));
        r3.h(r6.k);
        r3.i("log_id", r6.o);
        r3.i("req_id", String.valueOf(r6.n));
        r3.a().report();
        return;
    L7:
        r2 = null;
        goto L8
    }

    public static void a(int r5, ImageRecognitionEntry r6, d r7) {
        RoomContext r0 = RoomContext.a.c(RoomContext.Companion, null, 0, 3);
        if (r0 == null) goto L7;
        m r1 = r0.getRoom();
        if (r1 == null) goto L7;
        Room r2 = (Room) r1.getValue();
    L8:
        LiveMonitor.a r3 = InteractivityMonitor.a(InteractivityMonitor.Event.ImageRecognition, r2, null);
        r3.l(r7.c);
        r3.m(r7.d);
        r3.h(r7.m);
        r3.e("scene", String.valueOf(r5));
        r3.e("entry", r6.getDesc());
        r3.e("error_info", r7.e);
        r3.g("save_frame_cost", r7.h);
        r3.g("crop_cost", r7.i);
        r3.g("compress_cost", r7.j);
        r3.g("request_cost", r7.k);
        r3.g("handle_res_cost", r7.l);
        r3.i("log_id", r7.o);
        r3.a().report();
        return;
    L7:
        r2 = null;
        goto L8
    }
}
