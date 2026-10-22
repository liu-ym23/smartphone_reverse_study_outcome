package com.bytedance.android.live.room.navi.tetris;

import am2.x;
import android.view.View;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.room.IMiddlewareRoomService;
import com.bytedance.android.livesdk.log.filter.t;
import com.bytedance.android.livesdk.log.j0;
import com.bytedance.android.livesdk.utils.s2;
import com.bytedance.android.livesdkapi.depend.live.IRoomAction;
import com.bytedance.android.livesdkapi.depend.model.live.IRoom;
import com.bytedance.ies.sdk.widgets.DataCenter;
import java.util.HashMap;
import java.util.LinkedHashMap;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;
import zg1.h1;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class j implements View.OnClickListener {
    public final /* synthetic */ DataCenter a;

    public j(DataCenter r1) {
        this.a = r1;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r7) {
        IMiddlewareRoomService r8 = (IMiddlewareRoomService) jc1.k.f(IMiddlewareRoomService.class);
        if (r8 != null) goto L5;
    L7:
        DataCenter r9 = this.a;
        t r2 = null;
        if (r9 == null) goto L10;
        IRoomAction r10 = (IRoomAction) r9.get("data_room_action", null);
    L12:
        if ((r10 instanceof IRoomAction) == true) goto L14;
    L16:
        xs2.b r12 = xs2.b.a();
        h1 r3 = new h1(6);
        HashMap r1 = new HashMap();
        r1.put("exit_type", "cross");
        r3.e = r1;
        Unit r4 = Unit.INSTANCE;
        r12.post(r3);
        LinkedHashMap r13 = new LinkedHashMap();
        r13.put("leave_type", "click");
        int r5 = k.a;
        Intrinsics.checkNotNullParameter(r13, "logMap");
        t r6 = j0.l().c(x.class);     // Catch: Exception -> L32
        if ((r6 instanceof t) == false) goto L21;
        r2 = r6;
    L21:
        t r14 = r2;     // Catch: Exception -> L32
        if (r14 == null) goto L34;
        String r15 = r14.i();     // Catch: Exception -> L32
        if (r15 == null) goto L34;
        JSONObject r16 = s2.a(r15);     // Catch: Exception -> L32
        String r17 = r16.optString("video_id");     // Catch: Exception -> L32
        if (r17 == null) goto L28;
        r13.put("video_id", r17);     // Catch: Exception -> L32
    L28:
        String r18 = r16.optString("video_live_label");     // Catch: Exception -> L32
        if (r18 == null) goto L34;
        r13.put("video_live_label", r18);     // Catch: Exception -> L32
    L34:
        j0.l().sendLog("live_leave", r13, new Object[]{x.class, IRoom.class});
        return;
    L32:
        e = move-exception;
        ALogger.e("LiveSdkLogUti", "can't parse json for relevant log", e);
        goto L34
    L14:
        if (r10.interceptRoomClose() == false) goto L16;
        return;
    L10:
        r10 = null;
        goto L12
    L5:
        if (r8.shouldFeedbackInterceptLeaveRoom(this.a, 6) != true) goto L7;
    }
}
