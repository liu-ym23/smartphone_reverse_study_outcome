package com.larus.bmhome.chat.component.trace;

import android.os.Bundle;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.ixigua.lib.track.TrackParams;
import com.larus.bmhome.chat.bean.d;
import com.larus.bmhome.chat.cell.MessageCellStateTransformerType;
import com.larus.bmhome.chat.component.immerse.a;
import com.larus.bmhome.chat.model.repo.ChatRepo;
import com.larus.bmhome.chat.model.repo.RepoDispatcher;
import com.larus.bmhome.chat.trace.ChatControlTrace;
import com.larus.im.bean.message.Message;
import com.larus.platform.model.RecommendFrom;
import com.larus.utils.logger.FLogger;
import com.larus.utils.o0;
import de8.c;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;
import org.json.JSONException;
import org.json.JSONObject;
import wc9.e;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = MessageCellStateTransformerType.Z_LOTTERY_GUIDE_CELL)
@DebugMetadata(c = "com.larus.bmhome.chat.component.trace.ChatTraceComponent$doMobLeaveChatPageAsync$1", f = "ChatTraceComponent.kt", i = {0}, l = {645}, m = "invokeSuspend", n = {"conversationId"}, s = {"L$0"})
final class ChatTraceComponent$doMobLeaveChatPageAsync$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ String $caseId;
    final /* synthetic */ String $caseRequestId;
    final /* synthetic */ long $duration;
    final /* synthetic */ String $enterChatMethod;
    final /* synthetic */ boolean $isLastShownMessageLoadingFake;
    final /* synthetic */ String $leaveMethod;
    final /* synthetic */ int $noreadCount;
    final /* synthetic */ String $noreadType;
    final /* synthetic */ String $recommendFrom;
    Object L$0;
    int label;
    final /* synthetic */ ChatTraceComponent this$0;

    public ChatTraceComponent$doMobLeaveChatPageAsync$1(ChatTraceComponent r1, boolean r2, int r3, String r4, String r5, String r6, String r7, String r8, long r9, String r11, Continuation<? super ChatTraceComponent$doMobLeaveChatPageAsync$1> r12) {
        this.this$0 = r1;
        this.$isLastShownMessageLoadingFake = r2;
        this.$noreadCount = r3;
        this.$enterChatMethod = r4;
        this.$noreadType = r5;
        this.$recommendFrom = r6;
        this.$caseId = r7;
        this.$caseRequestId = r8;
        this.$duration = r9;
        this.$leaveMethod = r11;
        super(2, r12);
    }

    public final Continuation<Unit> create(Object r14, Continuation<?> r15) {
        return new ChatTraceComponent$doMobLeaveChatPageAsync$1(this.this$0, this.$isLastShownMessageLoadingFake, this.$noreadCount, this.$enterChatMethod, this.$noreadType, this.$recommendFrom, this.$caseId, this.$caseRequestId, this.$duration, this.$leaveMethod, r15);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r23) {
        Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r2 = this.label;
        String r5 = "";
        if (r2 == 0) goto L8;
        if (r2 != 1) goto L7;
        String r1 = (String) this.L$0;
        ResultKt.throwOnFailure(r23);
        Object r7 = r23;
    L20:
        List r8 = (List) r7;
        if ((!r8.isEmpty()) == false) goto L23;
        Message r3 = (Message) ListProtector.get(r8, 0);
    L24:
        List r9 = r8;
        Iterator r10 = r9.iterator();
    L26:
        if (r10.hasNext() == false) goto L30;
        Object r11 = r10.next();
        if ((!d.G0((Message) r11)) == false) goto L26;
    L31:
        Message r12 = (Message) r11;
        Iterator r13 = r9.iterator();
    L33:
        if (r13.hasNext() == false) goto L37;
        Object r14 = r13.next();
        if (d.G0((Message) r14) == false) goto L33;
    L38:
        Message r15 = (Message) r14;
        ChatTraceComponent r16 = this.this$0;
        boolean r17 = this.$isLastShownMessageLoadingFake;
        int r18 = ChatTraceComponent.L;
        r16.getClass();
        if (r3 == null) goto L60;
        boolean r19 = d.G0(r3);
        if (r19 == true) goto L43;
    L45:
        if (r19 == false) goto L48;
        if (r17 == false) goto L48;
    L51:
        String r4 = "waiting_for_reply";
    L61:
        boolean r6 = Intrinsics.areEqual(r4, "waiting_for_reply");
        if (r6 == false) goto L67;
        if (r15 == null) goto L70;
        String r20 = r15.getMessageId();
        if (r20 == null) goto L70;
    L71:
        if (r6 == false) goto L76;
        if (r15 == null) goto L85;
        String r21 = r15.getSectionId();
        if (r21 == null) goto L85;
    L86:
        if (r6 == true) goto L93;
        if (r12 == null) goto L93;
        String r22 = r12.getMessageId();
        if (r22 == null) goto L93;
        r5 = r22;
    L93:
        c r24 = this.this$0.f1();
        if (r24 == null) goto L98;
        RecommendFrom r25 = r24.d;
        if (r25 == null) goto L98;
        String r26 = r25.b;
    L99:
        String r110 = String.valueOf(this.$noreadCount);
        c r111 = this.this$0.f1();
        if (r111 == null) goto L102;
        String r112 = r111.p();
    L103:
        c r113 = this.this$0.f1();
        if (r113 == null) goto L110;
        Bundle r114 = r113.b;
        if (r114 == null) goto L109;
        String r115 = r114.getString("is_call_bot");
        if (r115 == null) goto L109;
    L111:
        Integer r116 = this.this$0.N2();
        ChatControlTrace r27 = ChatControlTrace.b;
        c r28 = this.this$0.f1();
        if (r28 == null) goto L114;
        RecommendFrom r29 = r28.d;
    L115:
        JSONObject r30 = r27.Xb(r29);
        ChatTraceComponent r31 = this.this$0;
        long r117 = this.$duration;
        String r118 = r4;
        String r32 = this.$leaveMethod;
        com.larus.bmhome.chat.component.cvs.y r119 = r31.u0();
        if (r119 == null) goto L120;
        String r210 = r20;
        String r33 = r119.getBotId();
        String r120 = r21;
        if (r33 == null) goto L121;
        r30.put("bot_id", r33);
        r30.put("item_id", r33);
    L121:
        e r34 = r31.P2();
        if (r34 == null) goto L124;
        Integer r35 = r34.v;
    L125:
        String r211 = r5;
        r30.put("chat_type", r27.g(r35, r31.N2(), r31.L2()));
        r30.put("duration", String.valueOf(r117));
        r30.put("leave_method", r32);
        c r36 = r31.f1();
        if (r36 != null) goto L128;
    L130:
        boolean r37 = false;
    L132:
        if (r37 == false) goto L134;
        Object r38 = "1";
    L135:
        r30.put("is_immersive_background", r38);
        a r39 = (a) r31.l.getValue();
        if (r39 == null) goto L140;
        boolean r40 = true;
        if (r39.kw() != true) goto L140;
    L141:
        if (r40 == false) goto L143;
        Object r121 = "1";
    L144:
        r30.put("is_immersive_background_dynamic", r121);
        c r41 = r31.f1();
        if (r41 == null) goto L156;
        Bundle r42 = r41.b;
        if (r42 == null) goto L156;
        String r43 = r42.getString("custom_current_page");
        if (r43 == null) goto L156;
        if (o0.d(r43) == true) goto L154;
        r43 = null;
    L154:
        if (r43 == null) goto L156;
        r30.put("custom_current_page", r43);
    L156:
        c r44 = r31.f1();
        if (r44 == null) goto L168;
        Bundle r45 = r44.b;
        if (r45 == null) goto L168;
        String r46 = r45.getString("enter_message_id");
        if (r46 == null) goto L168;
        if (o0.d(r46) == true) goto L166;
        r46 = null;
    L166:
        if (r46 == null) goto L168;
        r30.put("enter_message_id", r46);
    L168:
        by7.e r47 = s1a.a.c(this.this$0);
        if ((r47 instanceof by7.e) == false) goto L171;
        by7.e r48 = r47;
    L172:
        String r49 = this.$enterChatMethod;
        String r50 = this.$noreadType;
        String r51 = this.$recommendFrom;
        String r52 = this.$caseId;
        String r122 = this.$caseRequestId;
        Intrinsics.checkNotNullParameter(r30, "params");
        if (r116 != null) goto L208;
    L177:
        if (r1 == null) goto L179;
        r30.put("conversation_id", r1);     // Catch: JSONException -> L175
    L179:
        if (r49 == null) goto L181;
        r30.put("enter_chat_method", r49);     // Catch: JSONException -> L175
    L181:
        r30.put("group_type", "private");     // Catch: JSONException -> L175
        if (r110 == null) goto L184;
        r30.put("noread_count", r110);     // Catch: JSONException -> L175
    L184:
        if (r50 == null) goto L186;
        r30.put("noread_type", r50);     // Catch: JSONException -> L175
    L186:
        if (r112 == null) goto L188;
        r30.put("previous_page", r112);     // Catch: JSONException -> L175
    L188:
        if (r51 == null) goto L190;
        r30.put("recommend_from", r51);     // Catch: JSONException -> L175
    L190:
        if (r26 == null) goto L192;
        r30.put("req_id", r26);     // Catch: JSONException -> L175
    L192:
        if (r115 == null) goto L194;
        r30.put("is_call_bot", r115);     // Catch: JSONException -> L175
    L194:
        if (r52 == null) goto L196;
        r30.put("user_case_item_id", r52);     // Catch: JSONException -> L175
    L196:
        if (r122 == null) goto L198;
        r30.put("user_case_reco_request_id", r122);     // Catch: JSONException -> L175
    L198:
        r30.put("chat_last_message_id", r211);     // Catch: JSONException -> L175
        r30.put("chat_last_section_id", r120);     // Catch: JSONException -> L175
        r30.put("chat_last_reply_id", r210);     // Catch: JSONException -> L175
        if (r118 == null) goto L203;
        r30.put("reply_status", r118);     // Catch: JSONException -> L175
    L175:
        e = move-exception;
        FLogger.a.e("LeaveEventHelper", "error in LeaveEventHelper leaveChatPage " + e.getLocalizedMessage());
    L203:
        TrackParams r53 = new TrackParams().merge(r30);
        by7.a r54 = new by7.a("leave_chat_page");
        if (r48 == null) goto L206;
        r54.b = r48;
    L206:
        r54.a.merge(r53);
        r54.b();
        return Unit.INSTANCE;
    L208:
        r30.put("bot_type", r116.intValue());     // Catch: JSONException -> L175
        goto L177
    L171:
        r48 = null;
        goto L172
    L143:
        r121 = "0";
    L140:
        r40 = false;
        goto L141
    L134:
        r38 = "0";
        goto L135
    L128:
        if (r36.C() != true) goto L130;
        r37 = true;
        goto L132
    L124:
        r35 = null;
        goto L125
    L120:
        r210 = r20;
        r120 = r21;
        goto L121
    L114:
        r29 = null;
    L109:
        r115 = "0";
        goto L111
    L110:
        r115 = null;
        goto L111
    L102:
        r112 = null;
    L98:
        r26 = null;
    L85:
        r21 = "";
        goto L86
    L76:
        if (r12 == null) goto L81;
        String r123 = r12.getSectionId();
        if (r123 == null) goto L81;
        r21 = r123;
    L81:
        if (r15 == null) goto L83;
        r21 = r15.getSectionId();
    L84:
        if (r21 != null) goto L86;
    L83:
        r21 = null;
    L70:
        r20 = "";
        goto L71
    L67:
        if (r12 == null) goto L70;
        r20 = r12.getReplyId();
        if (r20 != null) goto L71;
    L48:
        if (r19 == false) goto L50;
    L52:
        if (r19 == false) goto L54;
    L59:
        r4 = "others";
        goto L61
    L54:
        if (r3.getMessageStatusLocal() != 20) goto L59;
        if (d.f0(r3) == false) goto L58;
        r4 = "thinking";
        goto L61
    L58:
        r4 = "replying";
        goto L61
    L50:
        if (r3.getMessageStatusLocal() != 24) goto L52;
    L43:
        if (r3.getMessageStatusLocal() != 10) goto L45;
    L60:
        r4 = null;
        goto L61
    L37:
        r14 = null;
        goto L38
    L30:
        r11 = null;
        goto L31
    L23:
        r3 = null;
        goto L24
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        ResultKt.throwOnFailure(r23);
        ChatTraceComponent r55 = this.this$0;
        int r56 = ChatTraceComponent.L;
        e r57 = r55.P2();
        if (r57 == null) goto L11;
        String r58 = r57.a;
    L12:
        RepoDispatcher.a.getClass();
        ChatRepo r59 = RepoDispatcher.d;
        if (r58 != null) goto L15;
        String r60 = "";
    L16:
        this.L$0 = r58;
        this.label = 1;
        r7 = r59.o1(r60, 10, this);
        if (r7 != r0) goto L19;
        return r0;
    L19:
        r1 = r58;
        goto L20
    L15:
        r60 = r58;
        goto L16
    L11:
        r58 = null;
        goto L12
    }
}
