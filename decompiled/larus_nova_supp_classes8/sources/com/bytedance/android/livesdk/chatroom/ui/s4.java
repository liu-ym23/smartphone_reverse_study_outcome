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
public final class s4 implements IBaseCallbackSchemaHandler.SchemaCallback<String> {
    public final /* synthetic */ mt1.a a;
    public final /* synthetic */ AbsInteractionFragment b;

    public final void onComplete() {
    }

    public final void onFailure(Throwable r1) {
    }

    public s4(AbsInteractionFragment r1, mt1.a r2) {
        this.b = r1;
        this.a = r2;
    }

    public final void onSuccess(Integer r5, Object r6) {
        String r7 = (String) r6;
        boolean r0 = true;
        if (com.bytedance.android.livesdk.utils.c1.c(this.b.W) == false) goto L15;
        JSONObject r8 = new JSONObject();
        r8.put("anchor_id", this.b.q.getOwner().getIdStr());     // Catch: JSONException -> L7
        r8.put("room_id", String.valueOf(this.b.q.getId()));     // Catch: JSONException -> L7
    L9:
        ILiveDouPlusService r1 = jc1.k.f(ILiveDouPlusService.class);
        HashMap r2 = new HashMap();
        r2.put("ad_extra_data", r8.toString());
        Map r9 = com.bytedance.android.livesdk.utils.c1.f(this.b.W);
        if (r9.isEmpty() == true) goto L13;
        r2.putAll(r9);
    L13:
        r1.logEvent(true, "live_ad", "follow_cancel", r2);
    L7:
        e = move-exception;
        e.printStackTrace();
    L15:
        if (AbsInteractionFragment.u4.contains(this.a.d) == false) goto L18;
        xs2.b.a().post(new zg1.h1(38, this.a.c));
    L18:
        if (RoomContext.getShared() != null) goto L20;
        return;
    L20:
        if (RoomContext.getShared().getRoom() != null) goto L22;
        return;
    L22:
        if (((Room) RoomContext.getShared().getRoom().getValue()).getOwner() != null) goto L24;
        return;
    L24:
        if (this.b.W == null) goto L37;
        ((Room) RoomContext.getShared().getRoom().getValue()).getOwner().setFollowStatus(r5.intValue());
        DataCenter r10 = this.b.W;
        if (r5.intValue() != 0) goto L30;
        r0 = false;
    L30:
        r10.put("data_is_followed", Boolean.valueOf(r0));
        return;
    }
}
