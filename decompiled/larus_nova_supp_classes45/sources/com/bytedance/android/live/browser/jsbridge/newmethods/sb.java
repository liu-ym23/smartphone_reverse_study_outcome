package com.bytedance.android.live.browser.jsbridge.newmethods;

import com.bytedance.android.live.browser.jsbridge.base.SendLiveMicroAppLogResultModel;
import com.bytedance.android.live.openplatform.api.IOpenPlatformAnchorService;
import com.bytedance.android.live.openplatform.api.IOpenPlatformAudienceService;
import com.bytedance.android.livesdk.chatroom.RoomContext;
import com.bytedance.android.livesdkapi.depend.model.live.Room;
import com.bytedance.ies.web.jsbridge2.CallContext;
import com.bytedance.sdk.xbridge.annotations.XBridgeMethod;
import com.google.gson.JsonObject;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;
import kotlin.Unit;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
@XBridgeMethod(biz = "webcast", name = "sendLiveMicroAppLog")
public final class sb extends w20.a6<w20.ge, SendLiveMicroAppLogResultModel> {
    public sb() {
    }

    public final void invoke(Object r11, CallContext r12) {
        w20.ge r13 = (w20.ge) r11;
        Intrinsics.checkNotNullParameter(r13, "params");
        Intrinsics.checkNotNullParameter(r12, "context");
        RoomContext r14 = RoomContext.a.c(RoomContext.Companion, null, 0, 3);
        if (r14 == null) goto L9;
        com.bytedance.live.datacontext.i r1 = r14.isAnchor();
        if (r1 == null) goto L9;
        Boolean r2 = (Boolean) r1.getValue();
        if (r2 == null) goto L9;
        boolean r3 = r2.booleanValue();
    L10:
        if (r3 == false) goto L12;
        Map r4 = jc1.k.n(IOpenPlatformAnchorService.class).getCommonEventParams();
    L14:
        if (r14 != null) goto L16;
        Object[] r15 = new Object[0];
    L17:
        com.bytedance.android.livesdk.log.g r5 = com.bytedance.android.livesdk.log.u.l();
        String r6 = r13.a();
        LinkedHashMap r7 = new LinkedHashMap();
        if (r4 != null) goto L20;
        r4 = MapsKt.emptyMap();
    L20:
        r7.putAll(r4);
        JsonObject r16 = r13.b();
        LinkedHashMap r8 = new LinkedHashMap();
        if (r16 == null) goto L28;
        Set r9 = r16.keySet();
        if (r9 == null) goto L28;
        Iterator r17 = r9.iterator();
    L26:
        if (r17.hasNext() == false) goto L28;
        String r18 = (String) r17.next();
        r8.put(r18, r16.get(r18).getAsString());
    L28:
        r7.putAll(r8);
        Unit r19 = Unit.INSTANCE;
        r5.h(r6, r7, new Object[]{r15});
        finishWithSuccess();
        return;
    L16:
        r15 = new Class[]{Room.class, am2.x.class};
        goto L17
    L12:
        r4 = jc1.k.n(IOpenPlatformAudienceService.class).getCommonEventParams();
    L9:
        r3 = true;
        goto L10
    }
}
