package com.larus.bmhome.chat.component.trace;

import android.os.Bundle;
import com.larus.audio.AudioServiceDelegate;
import com.larus.bmhome.chat.cell.MessageCellStateTransformerType;
import com.larus.bmhome.chat.trace.ChatControlTrace;
import com.larus.bmhome.chat.trace.a;
import com.larus.bmhome.setting.UserSettingRepo;
import com.larus.im.bean.bot.BotModel;
import com.larus.platform.model.RecommendFrom;
import com.larus.platform.model.SearchMobParam;
import com.larus.platform.service.z2;
import com.larus.utils.logger.FLogger;
import de8.c;
import de8.d;
import java.util.HashMap;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlinx.coroutines.CoroutineScope;
import wc9.e;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = MessageCellStateTransformerType.Z_LOTTERY_GUIDE_CELL)
@DebugMetadata(c = "com.larus.bmhome.chat.component.trace.ChatTraceComponent$updateChatControlTraceInfo$1", f = "ChatTraceComponent.kt", i = {0, 0, 0, 0, 0, 0, 0, 0, 0, 0}, l = {1051}, m = "invokeSuspend", n = {"currentArgument", "chatArgumentWrapper", "currentConversation", "searchMobParam", "recommendFrom", "bot", "currentConversationId", "currentBotId", "currentBotType", "uniqueChatKey"}, s = {"L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "L$6", "L$7", "L$8", "J$0"})
public final class ChatTraceComponent$updateChatControlTraceInfo$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    long J$0;
    Object L$0;
    Object L$1;
    Object L$2;
    Object L$3;
    Object L$4;
    Object L$5;
    Object L$6;
    Object L$7;
    Object L$8;
    Object L$9;
    int label;
    final /* synthetic */ ChatTraceComponent this$0;

    public ChatTraceComponent$updateChatControlTraceInfo$1(ChatTraceComponent r1, Continuation<? super ChatTraceComponent$updateChatControlTraceInfo$1> r2) {
        this.this$0 = r1;
        super(2, r2);
    }

    public final Continuation<Unit> create(Object r2, Continuation<?> r3) {
        return new ChatTraceComponent$updateChatControlTraceInfo$1(this.this$0, r3);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r32) {
        Object r1 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r2 = this.label;
        if (r2 == 0) goto L8;
        if (r2 != 1) goto L7;
        long r3 = this.J$0;
        Ref.ObjectRef r5 = (Ref.ObjectRef) this.L$9;
        Ref.ObjectRef r6 = (Ref.ObjectRef) this.L$8;
        Ref.ObjectRef r7 = (Ref.ObjectRef) this.L$7;
        Ref.ObjectRef r8 = (Ref.ObjectRef) this.L$6;
        BotModel r9 = (BotModel) this.L$5;
        RecommendFrom r10 = (RecommendFrom) this.L$4;
        SearchMobParam r11 = (SearchMobParam) this.L$3;
        e r12 = (e) this.L$2;
        c r13 = (c) this.L$1;
        Bundle r14 = (Bundle) this.L$0;
        ResultKt.throwOnFailure(r32);
        Object r4 = r32;
    L81:
        r5.element = r4;
        Ref.ObjectRef r15 = r6;
        RecommendFrom r24 = r10;
        SearchMobParam r25 = r11;
        Ref.ObjectRef r16 = r7;
        long r17 = r3;
    L84:
        if (AudioServiceDelegate.a.getAudioConfig().n(r9) == false) goto L86;
        String r18 = "1";
    L87:
        ChatControlTrace r19 = ChatControlTrace.b;
        ChatTraceComponent r20 = this.this$0;
        String r110 = (String) r16.element;
        int r21 = ChatTraceComponent.L;
        boolean r111 = r20.L2();
        if (r12 == null) goto L90;
        Integer r22 = r12.v;
    L91:
        Integer r23 = (Integer) r15.element;
        c r26 = r20.f1();
        if (r26 == null) goto L94;
        boolean r27 = r26.C();
    L95:
        String r28 = (String) r8.element;
        if (r13 == null) goto L98;
        String r29 = r13.p();
    L99:
        if (r14 == null) goto L101;
        String r210 = r14.getString("from_activity_name");
    L102:
        if (r14 == null) goto L104;
        String r211 = r14.getString("from_activity_module");
    L105:
        r19.getClass();
        Intrinsics.checkNotNullParameter(r18, "isCallBot");
        a r30 = new a(r110, r111, r18, r22, r23, r27, r28, r24, r25, r29, r210, r211);
        Long r31 = Long.valueOf(r17);
        HashMap r33 = ChatControlTrace.C;
        r33.put(r31, r30);
        FLogger.a.d("ChatControlTrace", "initBotId key=" + r17 + " size=" + r33.size());
        return Unit.INSTANCE;
    L104:
        r211 = null;
        goto L105
    L101:
        r210 = null;
        goto L102
    L98:
        r29 = null;
        goto L99
    L94:
        r27 = false;
        goto L95
    L90:
        r22 = null;
        goto L91
    L86:
        r18 = "0";
        goto L87
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        ResultKt.throwOnFailure(r32);
        ChatTraceComponent r34 = this.this$0;
        int r35 = ChatTraceComponent.L;
        c r36 = r34.f1();
        if (r36 == null) goto L11;
        r14 = r36.b;
    L12:
        r13 = this.this$0.f1();
        r17 = d.a(this.this$0.f1());
        r12 = this.this$0.P2();
        c r37 = this.this$0.f1();
        if (r37 == null) goto L15;
        r11 = r37.e;
    L16:
        c r38 = this.this$0.f1();
        if (r38 == null) goto L19;
        r10 = r38.d;
    L20:
        com.larus.bmhome.chat.component.cvs.y r39 = this.this$0.u0();
        if (r39 == null) goto L23;
        r9 = r39.j0();
    L24:
        r8 = new Ref.ObjectRef();
        com.larus.bmhome.chat.component.cvs.y r40 = this.this$0.u0();
        if (r40 == null) goto L27;
        String r41 = r40.Y1();
    L28:
        r8.element = r41;
        if (r41 != null) goto L31;
    L34:
        boolean r42 = true;
    L35:
        if (r42 == false) goto L61;
        ChatTraceComponent r43 = this.this$0;
        c r112 = r43.f1();
        String r44 = "";
        if (r112 == null) goto L41;
        Bundle r113 = r112.b;
        if (r113 == null) goto L41;
        String r114 = r113.getString("argConversationId", "");
    L42:
        if (r114 != null) goto L44;
    L47:
        boolean r115 = true;
    L48:
        if (r115 == true) goto L50;
        c r45 = r43.f1();
        if (r45 == null) goto L59;
        Bundle r46 = r45.b;
        if (r46 == null) goto L59;
        r44 = r46.getString("argConversationId", "");
    L60:
        r8.element = r44;
    L59:
        r44 = null;
        goto L60
    L50:
        if (z2.a.d1() != 2) goto L60;
        UserSettingRepo r47 = UserSettingRepo.a;
        if (Intrinsics.areEqual(UserSettingRepo.b(), Boolean.TRUE) == false) goto L60;
        r44 = UserSettingRepo.a();
        goto L60
    L44:
        if (r114.length() == 0) goto L47;
        r115 = false;
    L41:
        r114 = null;
    L61:
        r16 = new Ref.ObjectRef();
        if (r9 == null) goto L65;
        String r48 = r9.getBotId();
        if (r48 == null) goto L65;
    L66:
        r16.element = r48;
        if (r48 != null) goto L69;
    L72:
        boolean r49 = true;
    L73:
        if (r49 == false) goto L75;
        r16.element = this.this$0.U2();
    L75:
        r15 = new Ref.ObjectRef();
        Integer r50 = this.this$0.N2();
        r15.element = r50;
        if (r50 != null) goto L82;
        ChatTraceComponent r51 = this.this$0;
        String r116 = (String) r16.element;
        this.L$0 = r14;
        this.L$1 = r13;
        this.L$2 = r12;
        this.L$3 = r11;
        this.L$4 = r10;
        this.L$5 = r9;
        this.L$6 = r8;
        this.L$7 = r16;
        this.L$8 = r15;
        this.L$9 = r15;
        this.J$0 = r17;
        this.label = 1;
        r4 = ChatTraceComponent.F2(r51, r116, this);
        if (r4 != r1) goto L80;
        return r1;
    L80:
        r5 = r15;
        r7 = r16;
        r6 = r5;
        r3 = r17;
        goto L81
    L82:
        r24 = r10;
        r25 = r11;
        goto L84
    L69:
        if (r48.length() == 0) goto L72;
        r49 = false;
    L65:
        r48 = this.this$0.U2();
        goto L66
    L31:
        if (r41.length() == 0) goto L34;
        r42 = false;
        goto L35
    L27:
        r41 = null;
        goto L28
    L23:
        r9 = null;
        goto L24
    L19:
        r10 = null;
        goto L20
    L15:
        r11 = null;
        goto L16
    L11:
        r14 = null;
        goto L12
    }
}
