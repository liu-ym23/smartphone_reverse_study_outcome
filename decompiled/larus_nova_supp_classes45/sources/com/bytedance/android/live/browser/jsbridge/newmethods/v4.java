package com.bytedance.android.live.browser.jsbridge.newmethods;

import com.bytedance.android.live.room.IMicRoomService;
import com.bytedance.android.live.room.IRoomService;
import com.bytedance.android.livesdkapi.depend.live.ILiveRoomService;
import com.bytedance.android.livesdkapi.depend.model.live.OfficialChannelInfo;
import com.bytedance.android.livesdkapi.depend.model.live.Room;
import com.bytedance.ies.web.jsbridge2.CallContext;
import com.bytedance.sdk.xbridge.annotations.XBridgeMethod;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
@XBridgeMethod(biz = "webcast", name = "GetMaixuRoomStatus")
public final class v4 extends com.bytedance.ies.web.jsbridge2.g<Object, JSONObject> {
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v0, types: [org.json.JSONObject] */
    /* JADX WARN: Type inference failed for: r2v0 */
    /* JADX WARN: Type inference failed for: r2v1, types: [int] */
    /* JADX WARN: Type inference failed for: r2v5 */
    /* JADX WARN: Type inference failed for: r3v0 */
    /* JADX WARN: Type inference failed for: r3v1, types: [int] */
    /* JADX WARN: Type inference failed for: r3v7 */
    /* JADX WARN: Type inference failed for: r4v0 */
    /* JADX WARN: Type inference failed for: r4v1, types: [int] */
    /* JADX WARN: Type inference failed for: r4v9 */
    public final JSONObject j() throws Exception {
        ?? r0 = new JSONObject();
        ILiveRoomService r1 = jc1.k.f(IRoomService.class);
        ?? r2 = 0;
        boolean r3 = false;
        if (r1 == null) goto L25;
        Room r4 = r1.getCurrentRoom();
        if (r4 == null) goto L25;
        IMicRoomService r5 = jc1.k.f(IMicRoomService.class);
        if (r5 != null) goto L9;
        boolean r6 = false;
    L10:
        IMicRoomService r7 = jc1.k.f(IMicRoomService.class);
        if (r7 != null) goto L13;
        boolean r8 = false;
    L14:
        OfficialChannelInfo r9 = r4.officialChannelInfo;
        if (r9 != null) goto L17;
    L19:
        int r11 = 0;
    L20:
        IMicRoomService r12 = jc1.k.f(IMicRoomService.class);
        if (r12 == null) goto L24;
        r3 = r12.isLoyalAudience();
    L24:
        boolean r13 = r6;
        ?? r14 = r3;
        r2 = r13;
        ?? r15 = r8;
    L26:
        r0.put("isInMaixuRoom", r2);
        r0.put("iswillNext", r15);
        r0.put("isBackupRoom", r11);
        r0.put("isLoyalAudience", r14);
        return r0;
    L17:
        if (r9.getBackupRoomId() != r4.getId()) goto L19;
        r11 = 1;
        goto L20
    L13:
        r8 = r7.willNext(r4);
        goto L14
    L9:
        r6 = r5.isMicRoom(r4);
    L25:
        r11 = 0;
        r14 = 0;
        r15 = 0;
        goto L26
    }

    public v4() {
    }

    public final /* bridge */ /* synthetic */ Object invoke(Object r1, CallContext r2) throws Exception {
        return j();
    }
}
