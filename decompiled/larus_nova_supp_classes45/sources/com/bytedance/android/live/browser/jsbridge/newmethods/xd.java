package com.bytedance.android.live.browser.jsbridge.newmethods;

import com.bytedance.android.livesdkapi.depend.message.MessageType;
import com.bytedance.ies.web.jsbridge2.CallContext;
import com.bytedance.mt.protector.impl.JSONArrayProtectorUtils;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public final class xd extends com.bytedance.ies.web.jsbridge2.f<JSONObject, JSONObject> {
    public final /* synthetic */ zd a;

    public final void onTerminate() {
    }

    public xd(zd r1) {
        this.a = r1;
    }

    public final void invoke(Object r8, CallContext r9) {
        JSONObject r11 = (JSONObject) r8;
        Intrinsics.checkNotNullParameter(r11, "params");
        Intrinsics.checkNotNullParameter(r9, "context");
        JSONArray r12 = r11.optJSONArray("types");
        if (r12 == null) goto L5;
        int r0 = r12.length();
    L6:
        int r1 = 0;
    L7:
        boolean r2 = true;
        if (r1 >= r0) goto L24;
        if (r12 == null) goto L12;
        String r3 = JSONArrayProtectorUtils.getString(r12, r1);
        if (r3 == null) goto L12;
    L14:
        if (r3.length() > 0) goto L17;
        r2 = false;
    L17:
        if (r2 == false) goto L23;
        zd r4 = this.a;
        r4.getClass();
        Integer r5 = MessageType.getMessageIntType("Webcast".concat(r3));
        if (r5 == null) goto L23;
        int r6 = r5.intValue();
        vlc.d r7 = r4.a;
        if (r7 == null) goto L23;
        r7.addMessageListener(r6, new sd(r4, r3));
    L23:
        r1 = r1 + 1;
    L12:
        r3 = "";
        goto L14
    L24:
        JSONObject r13 = new JSONObject();
        r13.put("code", 1);
        Unit r14 = Unit.INSTANCE;
        finishWithResult(r13);
        return;
    L5:
        r0 = 0;
        goto L6
    }
}
