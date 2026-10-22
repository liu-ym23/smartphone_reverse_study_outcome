package com.bytedance.android.live.browser.jsbridge.newmethods;

import com.bytedance.android.live.browser.jsbridge.base.GetCurrentCameraIdResultModel;
import com.bytedance.android.livesdk.chatroom.RoomContext;
import com.bytedance.android.livesdkapi.depend.model.live.Room;
import com.bytedance.android.livesdkapi.depend.model.live.episode.EpisodeExtraInfo;
import com.bytedance.ies.web.jsbridge2.CallContext;
import com.bytedance.sdk.xbridge.annotations.XBridgeMethod;
import com.google.gson.JsonObject;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
@XBridgeMethod(biz = "webcast", name = "getCurrentCameraId")
public final class c4 extends w20.f1<JsonObject, GetCurrentCameraIdResultModel> {
    public c4() {
    }

    public final void invoke(Object r6, CallContext r7) {
        Intrinsics.checkNotNullParameter((JsonObject) r6, "params");
        Intrinsics.checkNotNullParameter(r7, "context");
        Long r0 = null;
        long r1 = 0;
        RoomContext r8 = RoomContext.a.c(RoomContext.Companion, null, 0, 3);
        if (r8 == null) goto L9;
        com.bytedance.live.datacontext.m r9 = r8.getCameraId();
        if (r9 == null) goto L9;
        Long r11 = (Long) r9.getValue();
        if (r11 == null) goto L9;
        long r3 = r11.longValue();
    L11:
        if (r3 <= 0) goto L28;
        if (r8 == null) goto L16;
        com.bytedance.live.datacontext.m r12 = r8.getCameraId();
        if (r12 == null) goto L16;
        Long r13 = (Long) r12.getValue();
    L17:
        if (r8 == null) goto L25;
        com.bytedance.live.datacontext.m r4 = r8.getRoom();
        if (r4 == null) goto L25;
        Room r5 = (Room) r4.getValue();
        if (r5 == null) goto L25;
        EpisodeExtraInfo r14 = r5.getEpisodeComponentData();
        if (r14 == null) goto L25;
        r0 = Long.valueOf(r14.getDefaultCameraId());
    L25:
        boolean r15 = Intrinsics.areEqual(r13, r0);
        boolean r2 = true;
        if ((!r15) == false) goto L28;
    L29:
        if (r2 == false) goto L36;
        if (r8 == null) goto L36;
        com.bytedance.live.datacontext.m r16 = r8.getCameraId();
        if (r16 == null) goto L36;
        Long r17 = (Long) r16.getValue();
        if (r17 == null) goto L36;
        r1 = r17.longValue();
    L36:
        GetCurrentCameraIdResultModel r18 = new GetCurrentCameraIdResultModel();
        r18.a(GetCurrentCameraIdResultModel.Code.Success);
        GetCurrentCameraIdResultModel.a r19 = new GetCurrentCameraIdResultModel.a();
        r19.a(String.valueOf(r1));
        Unit r21 = Unit.INSTANCE;
        r18.b(r19);
        finishWithResult(r18);
        return;
    L16:
        r13 = null;
    L28:
        r2 = false;
    L9:
        r3 = 0;
        goto L11
    }
}
