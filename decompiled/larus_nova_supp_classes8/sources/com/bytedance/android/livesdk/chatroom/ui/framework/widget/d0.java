package com.bytedance.android.livesdk.chatroom.ui.framework.widget;

import com.bytedance.android.live.base.model.user.User;
import com.bytedance.android.livesdk.schema.interfaces.IBaseCallbackSchemaHandler;
import com.bytedance.android.livesdkapi.business.ILiveDouPlusService;
import com.bytedance.android.livesdkapi.depend.model.live.Room;
import com.bytedance.ies.sdk.widgets.DataCenter;
import com.bytedance.ies.sdk.widgets.Widget;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class d0 implements IBaseCallbackSchemaHandler.SchemaCallback<String> {
    public final /* synthetic */ LongPressPanelFollowWidget a;
    public final /* synthetic */ mt1.a b;

    public final void onComplete() {
    }

    public final void onFailure(Throwable r1) {
    }

    public d0(LongPressPanelFollowWidget r1, mt1.a r2) {
        this.a = r1;
        this.b = r2;
    }

    public final void onSuccess(Integer r6, Object r7) {
        Intrinsics.checkNotNullParameter((String) r7, "response");
        LongPressPanelFollowWidget r8 = this.a;
        List<String> r0 = LongPressPanelFollowWidget.b;
        Room r9 = r8.getRoom();
        if (r9 == null) goto L46;
        boolean r1 = true;
        if (com.bytedance.android.livesdk.utils.c1.c(((Widget) this.a).dataCenter) == false) goto L24;
        JSONObject r2 = new JSONObject();
        User r3 = r9.getOwner();     // Catch: JSONException -> L14
        if (r3 == null) goto L11;
        String r4 = r3.getIdStr();     // Catch: JSONException -> L14
    L12:
        r2.put("anchor_id", r4);     // Catch: JSONException -> L14
        r2.put("room_id", String.valueOf(r9.id));     // Catch: JSONException -> L14
    L16:
        ILiveDouPlusService r5 = jc1.k.f(ILiveDouPlusService.class);
        if (r5 == null) goto L24;
        HashMap r10 = new HashMap();
        r10.put("ad_extra_data", r2.toString());
        Map r11 = com.bytedance.android.livesdk.utils.c1.f(((Widget) this.a).dataCenter);
        if (r11.isEmpty() == true) goto L22;
        r10.putAll(r11);
    L22:
        r5.logEvent(true, "live_ad", "follow_cancel", r10);
        goto L24
    L11:
        r4 = null;
    L14:
        e = move-exception;
        e.printStackTrace();
    L24:
        if (CollectionsKt.contains(LongPressPanelFollowWidget.b, this.b.d) == false) goto L27;
        xs2.b.a().post(new zg1.h1(38, this.b.c));
    L27:
        if (r9.getOwner() == null) goto L47;
        User r12 = r9.getOwner();
        if (r12 == null) goto L35;
        if (r6 == null) goto L33;
        int r13 = r6.intValue();
    L34:
        r12.setFollowStatus(r13);
        goto L35
    L33:
        r13 = 0;
    L35:
        DataCenter r14 = ((Widget) this.a).dataCenter;
        if (r6 != null) goto L39;
    L42:
        r14.put("data_is_followed", Boolean.valueOf(r1));
        return;
    L39:
        if (r6.intValue() != 0) goto L42;
        r1 = false;
        goto L42
    L47:
        return;
    }
}
