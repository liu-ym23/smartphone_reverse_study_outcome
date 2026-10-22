package com.larus.bmhome.chat.deepsearch;

import com.larus.bmhome.chat.api.ILegacyChatUiServiceDelegate;
import com.larus.bmhome.chat.api.s;
import com.larus.bmhome.chat.bean.ChatPageContext;
import com.larus.bmhome.chat.model.ChatDraftItem;
import com.larus.bmhome.chat.model.repo.IChatRepoService;
import com.larus.bmhome.chat.model.repo.u1;
import com.larus.bmhome.chat.model.repo.u1$a;
import com.larus.im.bean.message.Message;
import com.larus.im.bean.message.MessageStatus;
import com.larus.utils.logger.FLogger;
import java.util.LinkedHashMap;
import java.util.UUID;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.functions.Function2;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
public final class m {
    public static final m a = null;
    public static final s b = null;

    public m() {
    }

    static {
        a = new m();
        b = ILegacyChatUiServiceDelegate.b.t8();
    }

    public final Object a(String r27, String r28, ChatPageContext r29, com.larus.bmhome.chat.deepsearch.component.h r30, Continuation r31) {
        String r0 = r27;
        if ((r31 instanceof DeepSearchUtil$sendDeepSearchMessageFrom$1) == false) goto L7;
        DeepSearchUtil$sendDeepSearchMessageFrom$1 r2 = (DeepSearchUtil$sendDeepSearchMessageFrom$1) r31;
        int r3 = r2.label;
        if ((r3 & Integer.MIN_VALUE) == 0) goto L7;
        r2.label = r3 - Integer.MIN_VALUE;
    L8:
        Object r1 = r2.result;
        Object r4 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r5 = r2.label;
        if (r5 == 0) goto L16;
        if (r5 == 1) goto L15;
        if (r5 != 2) goto L14;
        String r6 = (String) r2.L$5;
        String r7 = (String) r2.L$4;
        Function2 r8 = (Function2) r2.L$3;
        ChatPageContext r9 = (ChatPageContext) r2.L$2;
        String r10 = (String) r2.L$1;
        String r11 = (String) r2.L$0;
        ResultKt.throwOnFailure(r1);
        String r17 = r6;
        Function2 r15 = r8;
        ChatPageContext r22 = r9;
        String r12 = r10;
    L34:
        Message r13 = (Message) r1;
        if (r13 == null) goto L40;
        String r14 = r13.getContent();
        if (r14 == null) goto L40;
        u1 r16 = zh8.a.a.getSender();
        String r18 = new JSONObject(r14).optString(ChatDraftItem.TYPE_TEXT);
        LinkedHashMap r19 = new LinkedHashMap();
        r19.put("source", "deep_search");
        r19.put("deep_search_from_id", r11);
        u1$a.f(r16, r18, r12, "deep_search", r19, r15, MessageStatus.MessageStatus_INVISIBLE, r17, false, null, "DeepSearchFragment#sendText", null, r22, null, false, 26888);
        FLogger.a.d("DeepSearchUtil", "[biz_deep_search]deepSearchFromId : " + r11 + " , questionMsgID = " + r7);
    L40:
        return Unit.INSTANCE;
    L14:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L15:
        Function2 r20 = (Function2) r2.L$3;
        ChatPageContext r21 = (ChatPageContext) r2.L$2;
        String r23 = (String) r2.L$1;
        String r24 = (String) r2.L$0;
        ResultKt.throwOnFailure(r1);
        Function2 r25 = r20;
        r0 = r24;
        ChatPageContext r26 = r21;
        String r32 = r23;
    L19:
        Message r33 = (Message) r1;
        if (r33 == null) goto L22;
        String r34 = r33.getReplyId();
    L23:
        String r35 = UUID.randomUUID().toString();
        s r110 = b;
        if (r110 == null) goto L26;
        r110.d(r35);
    L26:
        IChatRepoService r111 = zh8.a.a;
        if (r34 != null) goto L29;
        String r112 = "";
    L30:
        r2.L$0 = r0;
        r2.L$1 = r32;
        r2.L$2 = r26;
        r2.L$3 = r25;
        r2.L$4 = r34;
        r2.L$5 = r35;
        r2.label = 2;
        Object r36 = r111.E1(r112, r2);
        if (r36 != r4) goto L33;
        return r4;
    L33:
        r7 = r34;
        r1 = r36;
        r12 = r32;
        r17 = r35;
        r22 = r26;
        r15 = r25;
        r11 = r0;
        goto L34
    L29:
        r112 = r34;
        goto L30
    L22:
        r34 = null;
        goto L23
    L16:
        ResultKt.throwOnFailure(r1);
        IChatRepoService r37 = zh8.a.a;
        r2.L$0 = r0;
        r32 = r28;
        r2.L$1 = r32;
        r26 = r29;
        r2.L$2 = r26;
        r25 = r30;
        r2.L$3 = r25;
        r2.label = 1;
        r1 = r37.E1(r0, r2);
        if (r1 != r4) goto L19;
        return r4;
    L7:
        r2 = new DeepSearchUtil$sendDeepSearchMessageFrom$1(this, r31);
        goto L8
    }
}
