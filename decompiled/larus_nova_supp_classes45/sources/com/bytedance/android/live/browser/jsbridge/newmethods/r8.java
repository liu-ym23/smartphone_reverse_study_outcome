package com.bytedance.android.live.browser.jsbridge.newmethods;

import com.bytedance.android.live.browser.jsbridge.base.OpenEmojiPanelResultModel;
import com.bytedance.ies.web.jsbridge2.CallContext;
import com.bytedance.sdk.xbridge.annotations.XBridgeMethod;
import java.util.LinkedHashMap;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
@XBridgeMethod(biz = "webcast", name = "openEmojiPanel")
public final class r8 extends w20.h4<w20.gc, OpenEmojiPanelResultModel> {
    public r8() {
    }

    public final void invoke(Object r4, CallContext r5) {
        w20.gc r6 = (w20.gc) r4;
        Intrinsics.checkNotNullParameter(r6, "params");
        Intrinsics.checkNotNullParameter(r5, "context");
        com.bytedance.android.livesdk.sharedpref.e r7 = l42.a.u;
        Boolean r0 = Boolean.TRUE;
        r7.getClass();
        com.bytedance.android.livesdk.sharedpref.f.d(r7, r0);
        b30.k r8 = new b30.k(r6.a(), r6.b(), r6.c());
        xs2.b.a().post(r8);
        if (((Boolean) com.bytedance.android.livesdk.s4.a.getValue()).booleanValue() == false) goto L8;
        LinkedHashMap r9 = new LinkedHashMap();
        String r11 = r6.c();
        if (r11 != null) goto L7;
        r11 = "";
    L7:
        r9.put("request_source", r11);
        r9.put("jsb_name", "openEmojiPanel");
        com.bytedance.android.livesdk.log.j0.l().sendLog("livesdk_comment_jsb_usage_stat", r9, new Object[0]);
    L8:
        finishWithSuccess();
    }
}
