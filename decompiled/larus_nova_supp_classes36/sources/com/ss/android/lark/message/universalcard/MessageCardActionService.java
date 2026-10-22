package com.ss.android.lark.message.universalcard;

import com.bytedance.lark.pb.basic.v1.Command;
import com.bytedance.lark.pb.basic.v1.UniversalCardEntity;
import com.bytedance.lark.pb.im.v2.PutActionRequest;
import com.bytedance.mt.protector.impl.string2number.CastIntegerProtector;
import com.larksuite.component.card.protocol.context.action.CardActionService;
import com.larksuite.framework.callback.IGetDataCallback;
import com.ss.android.lark.guide.ui.common.popup.AnchorFit;
import com.ss.android.lark.log.Log;
import com.ss.android.lark.message.lynxcard.action.LynxCardActionClient;
import com.ss.android.lark.opmonitor.trace.OPTrace;
import com.ss.android.lark.sdk.SdkSender;
import dz7.b;
import dz7.c;
import java.util.HashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J(\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u000e\u0010\n\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\f0\u000bH\u0016¨\u0006\r"}, d2 = {"Lcom/ss/android/lark/message/universalcard/MessageCardActionService;", "Lcom/larksuite/component/card/protocol/context/action/CardActionService;", "<init>", "()V", "sendRequest", "", "context", "Lcom/larksuite/component/card/protocol/context/action/CardActionContext;", "cardActionRequestParams", "Lcom/larksuite/component/card/protocol/context/action/CardActionRequestParams;", "callback", "Lcom/larksuite/framework/callback/IGetDataCallback;", "Lcom/larksuite/component/card/protocol/context/action/UniversalCardPutActionResponse;", "message-card_release"}, k = 1, mv = {2, 1, 0}, xi = AnchorFit.END)
public final class MessageCardActionService implements CardActionService {
    public MessageCardActionService() {
    }

    public void sendRequest(dz7.a r17, b r18, final IGetDataCallback<c> r19) {
        Intrinsics.checkNotNullParameter(r17, "context");
        Intrinsics.checkNotNullParameter(r18, "cardActionRequestParams");
        Intrinsics.checkNotNullParameter(r19, "callback");
        String r3 = r18.d;
        boolean r4 = false;
        if (r3 == null) goto L5;
        int r8 = CastIntegerProtector.parseInt(r3);
    L6:
        String r6 = r18.a;
        String r7 = r18.c;
        Map r9 = r18.b;
        OPTrace r10 = r18.g;
        HashMap r11 = new HashMap();
        r11.put("eventName", "ActionFinish");
        mrb.a r0 = new mrb.a(r6, r7, r8, r9, r10, r11, r18.f, r18.e, r18.j, r18.l);
        LynxCardActionClient r5 = (LynxCardActionClient) LynxCardActionClient.a.getValue();
        IGetDataCallback<mrb.b> r12 = new AnonymousClass2(r19);
        r5.getClass();
        Intrinsics.checkNotNullParameter(r0, "lynxCardActionRequestEntity");
        Intrinsics.checkNotNullParameter(r12, "callback");
        String r1 = r0.n;
        if (r1 != null) goto L32;
    L11:
        int r2 = 0;
    L12:
        int r13 = LynxCardActionClient.b.a[r0.o.ordinal()];
        if (r13 != 1) goto L15;
        UniversalCardEntity.ActionDataSource r14 = UniversalCardEntity.ActionDataSource.IM_CONTENT;
    L23:
        PutActionRequest.Builder r15 = new PutActionRequest.Builder().action_id(r0.b).message_id(r0.a).content_version(Integer.valueOf(r2)).trace_id(r0.d).is_ephemeral(Boolean.valueOf(r0.j)).app_card_version(Integer.valueOf(r0.c)).action_data_source(r14);
        Map<String, String> r16 = r0.e;
        if (r16 != null) goto L26;
    L28:
        if (r4 == false) goto L30;
        r15.params(r0.e);
    L30:
        SdkSender.asynSendRequestNonWrap(Command.PUT_ACTION_V2, r15, r12, com.ss.android.lark.message.lynxcard.action.a.a);
        return;
    L26:
        if ((!r16.isEmpty()) != true) goto L28;
        r4 = true;
        goto L28
    L15:
        if (r13 != 2) goto L17;
        r14 = UniversalCardEntity.ActionDataSource.ENTITY_CARD;
        goto L23
    L17:
        if (r13 != 3) goto L20;
        r14 = UniversalCardEntity.ActionDataSource.STREAMING_CARD;
        goto L23
    L20:
        throw new NoWhenBranchMatchedException();
    L32:
        r2 = CastIntegerProtector.parseInt(r1);     // Catch: NumberFormatException -> L10
    L10:
        Log.w("LynxCardActionClient", "parse Number exception requestVersion:" + r0.n);
        goto L11
    L5:
        r8 = 0;
        goto L6
    }
}
