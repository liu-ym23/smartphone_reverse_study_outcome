package com.ss.android.lark.im.sdk.message.send;

import com.ss.android.lark.biz.im.api.usergroup.UserGroupHitPoint;
import com.ss.android.lark.chat.entity.message.Message;
import com.ss.android.lark.chat.entity.message.MessageInfo;
import com.ss.android.lark.chat.utils.ChatParamUtils;
import com.ss.android.lark.im.sdk.message.SendMessagePipelines;
import com.ss.android.lark.im.sdk.service.o;
import com.ss.android.lark.log.Log;
import com.ss.android.lark.statistics.Statistics;
import java.util.Iterator;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public final class h implements jkb.d<k> {
    public final SendMessagePipelines.b a;

    public static final class a {
    }

    static {
    }

    @Override // jkb.d
    public final String getName() {
        return "PushPreMessageStep";
    }

    public h(SendMessagePipelines.h r2) {
        Intrinsics.checkNotNullParameter(r2, "preMessageCallback");
        this.a = r2;
    }

    @Override // jkb.d
    public final void a(jkb.b r7, jkb.c r8) {
        k r9 = (k) r7;
        Intrinsics.checkNotNullParameter(r9, "pipelineContext");
        Intrinsics.checkNotNullParameter(r8, "pipelineControl");
        o r0 = r9.b;
        MessageInfo r1 = r9.c;
        Intrinsics.checkNotNull(r1);
        r0.h(r1);
        com.ss.android.lark.im.sdk.a.b("PushPreMessageStep", "Push pre-message");
        this.a.I(r1);
        r0.o(r1.getcId());
        r0.c(r1.getcId());
        MessageInfo r2 = r9.c;
        Intrinsics.checkNotNull(r2);
        Message r3 = r2.getMessage();
        String r4 = r9.a.t;
        if (r4 != null) goto L5;
        r4 = "msg_send";
    L5:
        int r5 = UserGroupHitPoint.a;
        Map r6 = UserGroupHitPoint.a(ChatParamUtils.g(r3), r3);
        if (Intrinsics.areEqual(r4, "msg_send") == false) goto L8;
        r9.a.getClass();
    L8:
        String r10 = r3.getChatId();
        int r11 = com.ss.android.lark.im.sdk.statistics.a.a;
        Intrinsics.checkNotNullParameter(r4, "click");
        Intrinsics.checkNotNullParameter("none", "target");
        Map r12 = ChatParamUtils.f(r10);
        if (r12 == null) goto L18;
        JSONObject r13 = new JSONObject(r12).put("click", r4).put("target", "none");
        if (r6 == null) goto L17;
        Iterator r14 = r6.entrySet().iterator();
    L15:
        if (r14.hasNext() == false) goto L17;
        Map.Entry r15 = (Map.Entry) r14.next();
        r13.put((String) r15.getKey(), r15.getValue());
    L17:
        Log.d("ChatHitPointNew", "IM_CHAT_MAIN_CLICK, params:" + r13);
        Statistics.sendEvent("im_chat_main_click", r13);
    L18:
        r8.a();
    }
}
