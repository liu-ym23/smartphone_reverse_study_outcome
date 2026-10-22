package com.bytedance.android.live.browser.jsbridge.newmethods;

import com.bytedance.android.live.broadcast.api.gamepromote.GamePromoteDataContext;
import com.bytedance.android.live.user.IMiddlewareUserService;
import com.bytedance.android.livesdk.event.ISendCommentEvent;
import com.bytedance.ies.web.jsbridge2.CallContext;
import com.bytedance.sdk.xbridge.annotations.XBridgeMethod;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonPrimitive;
import java.util.HashMap;
import java.util.Iterator;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
@XBridgeMethod(biz = "webcast", name = "sendSubscribeEmoji")
public final class xb extends u<yb, SendSubscribeEmojiResultModel> {
    public xb() {
    }

    public final void invoke(Object r13, CallContext r14) {
        yb r15 = (yb) r13;
        Intrinsics.checkNotNullParameter(r15, "params");
        Intrinsics.checkNotNullParameter(r14, "context");
        String r16 = r15.a();
        if (r16 == null) goto L5;
        Long r17 = StringsKt.toLongOrNull(r16);
    L6:
        if (r17 != null) goto L8;
        finishWithFailure();
        return;
    L8:
        IMiddlewareUserService r1 = jc1.k.f(IMiddlewareUserService.class);
        if (r1 == null) goto L40;
        com.bytedance.android.livesdk.user.e r2 = r1.user();
        if (r2 == null) goto L40;
        if (r2.isLogin() != true) goto L40;
        JsonObject r3 = r15.b();
        if (r3 == null) goto L28;
        HashMap r4 = new HashMap();
        Iterator r5 = r3.keySet().iterator();
    L19:
        if (r5.hasNext() == false) goto L29;
        String r6 = (String) r5.next();
        JsonElement r7 = r3.get(r6);
        if ((r7 instanceof JsonPrimitive) == true) goto L23;
        r7 = null;
    L23:
        JsonPrimitive r8 = (JsonPrimitive) r7;
        if (r8 == null) goto L19;
        String r9 = r8.getAsString();
        if (r9 == null) goto L19;
        r4.put(r6, r9);
    L29:
        HashMap r11 = r4;
        HashMap r12 = new HashMap();
        if (Intrinsics.areEqual(r15.c(), "emoji_detail_page") == false) goto L32;
        r12.put("is_from_screen_chat", GamePromoteDataContext.GAME_TYPE_MOBILE);
    L32:
        String r0 = r15.c();
        if (r0 == null) goto L35;
        r12.put("message_source", r0);
    L35:
        xs2.b r18 = xs2.b.a();
        long r19 = r17.longValue();
        Integer r110 = r15.d();
        if (r110 == null) goto L38;
        int r21 = r110.intValue();
    L39:
        r18.post(new com.bytedance.android.livesdk.event.c0(r19, r21, false, ISendCommentEvent.Sender.SubscribeJSB, r11, null, r12));
        finishWithSuccess();
        return;
    L38:
        r21 = 0;
        goto L39
    L28:
        r4 = new HashMap();
    L40:
        finishWithFailure();
        return;
    L5:
        r17 = null;
        goto L6
    }
}
