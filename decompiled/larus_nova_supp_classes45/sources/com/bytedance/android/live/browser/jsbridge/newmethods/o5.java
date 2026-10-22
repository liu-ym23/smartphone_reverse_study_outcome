package com.bytedance.android.live.browser.jsbridge.newmethods;

import com.bytedance.android.live.browser.jsbridge.base.InputFusionEmojiResultModel;
import com.bytedance.android.livesdk.interactivity.api.ICommentService;
import com.bytedance.ies.web.jsbridge2.CallContext;
import com.bytedance.sdk.xbridge.annotations.XBridgeMethod;
import java.util.LinkedHashMap;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
@XBridgeMethod(biz = "webcast", name = "inputFusionEmoji")
public final class o5 extends w20.f2<w20.da, InputFusionEmojiResultModel> {
    public o5() {
    }

    public final void invoke(Object r8, CallContext r9) {
        w20.da r11 = (w20.da) r8;
        Intrinsics.checkNotNullParameter(r11, "params");
        Intrinsics.checkNotNullParameter(r9, "context");
        String r12 = r11.a();
        if (r12 == null) goto L5;
        Long r13 = StringsKt.toLongOrNull(r12);
    L6:
        if (r13 != null) goto L9;
        finishWithFailure();
        return;
    L9:
        if (((Boolean) com.bytedance.android.livesdk.s4.a.getValue()).booleanValue() == false) goto L14;
        LinkedHashMap r0 = new LinkedHashMap();
        String r1 = r11.d();
        if (r1 != null) goto L13;
        r1 = "";
    L13:
        r0.put("request_source", r1);
        r0.put("jsb_name", "inputFusionEmoji");
        com.bytedance.android.livesdk.log.j0.l().sendLog("livesdk_comment_jsb_usage_stat", r0, new Object[0]);
    L14:
        ICommentService r2 = jc1.k.f(ICommentService.class);
        if (r2 == null) goto L17;
        r2.inputFusionEmoji(r13.longValue(), r11.b(), r11.c(), null);
    L17:
        finishWithSuccess();
        return;
    L5:
        r13 = null;
        goto L6
    }
}
