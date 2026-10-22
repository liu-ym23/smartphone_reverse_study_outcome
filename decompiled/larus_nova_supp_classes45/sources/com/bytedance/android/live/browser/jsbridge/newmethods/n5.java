package com.bytedance.android.live.browser.jsbridge.newmethods;

import com.bytedance.android.live.browser.jsbridge.base.InputActivityEmojiResultModel;
import com.bytedance.android.livesdk.interactivity.api.ICommentService;
import com.bytedance.ies.web.jsbridge2.CallContext;
import com.bytedance.sdk.xbridge.annotations.XBridgeMethod;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonPrimitive;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
@XBridgeMethod(biz = "webcast", name = "inputActivityEmoji")
public final class n5 extends w20.e2<w20.ca, InputActivityEmojiResultModel> {
    public n5() {
    }

    public final void invoke(Object r8, CallContext r9) {
        w20.ca r11 = (w20.ca) r8;
        Intrinsics.checkNotNullParameter(r11, "params");
        Intrinsics.checkNotNullParameter(r9, "context");
        String r12 = r11.a();
        if (r12 == null) goto L5;
        Long r13 = StringsKt.toLongOrNull(r12);
    L6:
        if (r13 != null) goto L8;
        finishWithFailure();
        return;
    L8:
        JsonObject r1 = r11.b();
        if (r1 == null) goto L21;
        HashMap r2 = new HashMap();
        Iterator r3 = r1.keySet().iterator();
    L12:
        if (r3.hasNext() == false) goto L22;
        String r4 = (String) r3.next();
        JsonElement r5 = r1.get(r4);
        if ((r5 instanceof JsonPrimitive) == true) goto L16;
        r5 = null;
    L16:
        JsonPrimitive r6 = (JsonPrimitive) r5;
        if (r6 == null) goto L12;
        String r7 = r6.getAsString();
        if (r7 == null) goto L12;
        String r14 = (String) r2.put(r4, r7);
    L22:
        ICommentService r0 = jc1.k.f(ICommentService.class);
        if (r0 == null) goto L26;
        r0.inputActivityEmoji(r13.longValue(), r11.c(), r2);
    L26:
        if (((Boolean) com.bytedance.android.livesdk.s4.a.getValue()).booleanValue() == false) goto L31;
        LinkedHashMap r15 = new LinkedHashMap();
        String r16 = r11.d();
        if (r16 != null) goto L30;
        r16 = "";
    L30:
        r15.put("request_source", r16);
        r15.put("jsb_name", "inputActivityEmoji");
        com.bytedance.android.livesdk.log.j0.l().sendLog("livesdk_comment_jsb_usage_stat", r15, new Object[0]);
    L31:
        finishWithSuccess();
        return;
    L21:
        r2 = new HashMap();
        goto L22
    L5:
        r13 = null;
        goto L6
    }
}
