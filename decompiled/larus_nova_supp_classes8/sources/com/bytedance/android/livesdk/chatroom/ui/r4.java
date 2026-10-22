package com.bytedance.android.livesdk.chatroom.ui;

import com.bytedance.android.livesdk.chatroom.RoomContext;
import com.bytedance.android.livesdk.schema.interfaces.IBaseCallbackSchemaHandler;
import com.bytedance.android.livesdkapi.business.ILiveDouPlusService;
import com.bytedance.android.livesdkapi.depend.model.live.Room;
import com.bytedance.ies.sdk.widgets.DataCenter;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class r4 implements IBaseCallbackSchemaHandler.SchemaCallback<String> {
    public final /* synthetic */ AbsInteractionFragment a;

    public final void onComplete() {
        AbsInteractionFragment.ba0(this.a);
    }

    public r4(AbsInteractionFragment r1) {
        this.a = r1;
    }

    public final void onFailure(Throwable r2) {
        AbsInteractionFragment.aa0(this.a, r2);
    }

    public final void onSuccess(Integer r7, Object r8) {
        String r9 = (String) r8;
        if (RoomContext.getShared() != null) goto L5;
        return;
    L5:
        if (RoomContext.getShared().getRoom() == null) goto L47;
        Room r10 = (Room) RoomContext.getShared().getRoom().getValue();
        if (r10.getOwner() != null) goto L10;
        return;
    L10:
        if (this.a.W == null) goto L48;
        r10.getOwner().setFollowStatus(r7.intValue());
        DataCenter r11 = this.a.W;
        if (r7.intValue() == 0) goto L15;
        boolean r0 = true;
    L16:
        r11.put("data_is_followed", Boolean.valueOf(r0));
        if (r7.intValue() == 0) goto L44;
        JSONObject r12 = new JSONObject();
        r12.put("anchor_id", this.a.q.getOwner().getIdStr());     // Catch: JSONException -> L21
        r12.put("room_id", String.valueOf(this.a.q.getId()));     // Catch: JSONException -> L21
        r12.put("follow_status", r7);     // Catch: JSONException -> L21
    L23:
        com.bytedance.android.livesdk.utils.g4.h(r12);
        if (com.bytedance.android.livesdk.utils.c1.b(this.a.W) == false) goto L33;
        ILiveDouPlusService r13 = jc1.k.f(ILiveDouPlusService.class);
        HashMap r4 = new HashMap();
        r4.put("ad_extra_data", r12.toString());
        Map r14 = com.bytedance.android.livesdk.utils.c1.e(this.a.W);
        if (r14 != null) goto L28;
    L31:
        r13.logEvent(true, "live_ad", "follow_success", r4);
        return;
    L28:
        if (r14.isEmpty() == true) goto L31;
        r4.putAll(r14);
        goto L31
    L33:
        if (com.bytedance.android.livesdk.utils.c1.c(this.a.W) == false) goto L46;
        ILiveDouPlusService r15 = jc1.k.f(ILiveDouPlusService.class);
        HashMap r5 = new HashMap();
        r5.put("ad_extra_data", r12.toString());
        Map r1 = com.bytedance.android.livesdk.utils.c1.f(this.a.W);
        if (r1.isEmpty() == true) goto L38;
        r5.putAll(r1);
    L38:
        r15.logEvent(true, "live_ad", "follow_success", r5);
        com.bytedance.android.livesdk.utils.b3.a(this.a.W, r12);
        return;
    L46:
        return;
    L21:
        e = move-exception;
        e.printStackTrace();
        goto L23
    L44:
        return;
    L15:
        r0 = false;
        goto L16
    L48:
        return;
    }
}
