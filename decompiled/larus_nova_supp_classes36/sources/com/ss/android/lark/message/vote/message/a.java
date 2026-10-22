package com.ss.android.lark.message.vote.message;

import com.bytedance.lark.pb.basic.v1.Command;
import com.bytedance.lark.pb.im.v1.PutActionRequest;
import com.larksuite.framework.callback.UIGetDataCallback;
import com.ss.android.lark.chat.entity.message.Message;
import com.ss.android.lark.notification.export.entity.INotificationHitPoint;
import com.ss.android.lark.sdk.SdkSender;
import com.ss.android.lark.statistics.Statistics;
import java.util.HashMap;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public final /* synthetic */ class a implements trb.b {
    public final /* synthetic */ VoteMessageCell a;
    public final /* synthetic */ v5b.c b;

    public /* synthetic */ a(VoteMessageCell r1, v5b.c r2) {
        this.a = r1;
        this.b = r2;
    }

    public final void a(String r6, Map r7) {
        final VoteMessageCell r0 = this.a;
        v5b.c r1 = this.b;
        r0.getClass();
        String r2 = r1.getId();
        UIGetDataCallback<rrb.a> r3 = new VoteMessageCell.AnonymousClass1(r0);
        PutActionRequest.Builder r4 = new PutActionRequest.Builder().action_id(r6).message_id(r2).is_ephemeral(Boolean.FALSE);
        if (((HashMap) r7).size() <= 0) goto L5;
        r4.params(r7);
    L5:
        SdkSender.asynSendRequestNonWrap(Command.PUT_ACTION, r4, r3, new srb.b());
        int r5 = hva.a.a;
        HashMap r8 = (HashMap) r7;
        String r9 = String.valueOf(r8.size());
        boolean r10 = true;
        if (r8.size() <= 1) goto L8;
        r10 = false;
    L8:
        Intrinsics.checkNotNullParameter(r9, "itemCount");
        Intrinsics.checkNotNullParameter(r6, "voteId");
        JSONObject r11 = new JSONObject().put("item_count", r9);
        if (r10 == false) goto L11;
        String r12 = INotificationHitPoint.ChatType.CHAT_TYPE_SINGLE;
    L12:
        Statistics.sendEvent("ex_platform_click_vote_submit", r11.put("vote_type", r12).put("vote_id", r6));
        int r13 = urb.b.a;
        urb.b.a.a(r1.getChatId(), r1.getId(), r1.getcId(), Message.Type.CARD);
        return;
    L11:
        r12 = "multi";
        goto L12
    }
}
