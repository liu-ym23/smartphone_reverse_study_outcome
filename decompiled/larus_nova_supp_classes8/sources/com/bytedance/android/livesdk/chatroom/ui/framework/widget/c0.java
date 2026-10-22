package com.bytedance.android.livesdk.chatroom.ui.framework.widget;

import com.bytedance.android.live.base.model.user.User;
import com.bytedance.android.livesdk.schema.interfaces.IBaseCallbackSchemaHandler;
import com.bytedance.android.livesdk.utils.b3;
import com.bytedance.android.livesdk.utils.g4;
import com.bytedance.android.livesdkapi.business.ILiveDouPlusService;
import com.bytedance.android.livesdkapi.depend.model.live.Room;
import com.bytedance.ies.sdk.widgets.DataCenter;
import com.bytedance.ies.sdk.widgets.Widget;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class c0 implements IBaseCallbackSchemaHandler.SchemaCallback<String> {
    public final /* synthetic */ LongPressPanelFollowWidget a;

    public final void onComplete() {
        LongPressPanelFollowWidget.xq(this.a);
    }

    public c0(LongPressPanelFollowWidget r1) {
        this.a = r1;
    }

    public final void onFailure(Throwable r2) {
        LongPressPanelFollowWidget.yq(this.a, r2);
    }

    public final void onSuccess(Integer r7, Object r8) {
        Intrinsics.checkNotNullParameter((String) r8, "msg");
        LongPressPanelFollowWidget r9 = this.a;
        List<String> r0 = LongPressPanelFollowWidget.b;
        Room r10 = r9.getRoom();
        if (r10 != null) goto L6;
        return;
    L6:
        if (r10.getOwner() != null) goto L8;
        return;
    L8:
        if (((Widget) this.a).dataCenter == null) goto L64;
        User r1 = r10.getOwner();
        if (r1 == null) goto L13;
        Intrinsics.checkNotNull(r7);
        r1.setFollowStatus(r7.intValue());
    L13:
        DataCenter r2 = ((Widget) this.a).dataCenter;
        if (r7 != null) goto L17;
    L18:
        boolean r3 = true;
    L20:
        r2.put("data_is_followed", Boolean.valueOf(r3));
        if (r7 != null) goto L24;
    L25:
        JSONObject r4 = new JSONObject();
        User r5 = r10.getOwner();     // Catch: JSONException -> L32
        if (r5 == null) goto L29;
        String r6 = r5.getIdStr();     // Catch: JSONException -> L32
    L30:
        r4.put("anchor_id", r6);     // Catch: JSONException -> L32
        r4.put("room_id", String.valueOf(r10.id));     // Catch: JSONException -> L32
        r4.put("follow_status", r7);     // Catch: JSONException -> L32
    L34:
        g4.h(r4);
        if (com.bytedance.android.livesdk.utils.c1.b(((Widget) this.a).dataCenter) == false) goto L46;
        ILiveDouPlusService r11 = jc1.k.f(ILiveDouPlusService.class);
        if (r11 == null) goto L60;
        HashMap r12 = new HashMap();
        r12.put("ad_extra_data", r4.toString());
        Map r13 = com.bytedance.android.livesdk.utils.c1.e(((Widget) this.a).dataCenter);
        if (r13 != null) goto L41;
    L44:
        r11.logEvent(true, "live_ad", "follow_success", r12);
        return;
    L41:
        if (r13.isEmpty() == true) goto L44;
        r12.putAll(r13);
        goto L44
    L60:
        return;
    L46:
        if (com.bytedance.android.livesdk.utils.c1.c(((Widget) this.a).dataCenter) == false) goto L62;
        ILiveDouPlusService r14 = jc1.k.f(ILiveDouPlusService.class);
        if (r14 == null) goto L54;
        HashMap r15 = new HashMap();
        r15.put("ad_extra_data", r4.toString());
        Map r16 = com.bytedance.android.livesdk.utils.c1.f(((Widget) this.a).dataCenter);
        if (r16.isEmpty() == true) goto L53;
        r15.putAll(r16);
    L53:
        r14.logEvent(true, "live_ad", "follow_success", r15);
    L54:
        b3.a(((Widget) this.a).dataCenter, r4);
        return;
    L62:
        return;
    L29:
        r6 = null;
    L32:
        e = move-exception;
        e.printStackTrace();
        goto L34
    L24:
        if (r7.intValue() != 0) goto L25;
        return;
    L17:
        if (r7.intValue() != 0) goto L18;
        r3 = false;
        goto L20
    }
}
