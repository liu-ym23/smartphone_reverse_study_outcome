package com.larus.voicecall.impl.continue_talk;

import com.larus.bmhome.chat.bean.d;
import com.larus.bmhome.chat.component.list.u7;
import com.larus.bmhome.chat.model.repo.IChatRepoService;
import com.larus.im.bean.message.Message;
import com.larus.utils.logger.FLogger;
import com.obric.aivoice.core.data.NameKeys;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import zh8.a;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
@Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n"}, d2 = {"<anonymous>", NameKeys.UnloadStrategy_No_Strategy, "isContinuousTalk", NameKeys.UnloadStrategy_No_Strategy}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.larus.voicecall.impl.continue_talk.ChatContinuousTalkComponent$onViewCreated$5", f = "ChatContinuousTalkComponent.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
public final class ChatContinuousTalkComponent$onViewCreated$5 extends SuspendLambda implements Function2<Boolean, Continuation<? super Unit>, Object> {
    /* synthetic */ boolean Z$0;
    int label;
    final /* synthetic */ ChatContinuousTalkComponent this$0;

    public ChatContinuousTalkComponent$onViewCreated$5(ChatContinuousTalkComponent r1, Continuation<? super ChatContinuousTalkComponent$onViewCreated$5> r2) {
        this.this$0 = r1;
        super(2, r2);
    }

    public final Continuation<Unit> create(Object r3, Continuation<?> r4) {
        ChatContinuousTalkComponent$onViewCreated$5 r0 = new ChatContinuousTalkComponent$onViewCreated$5(this.this$0, r4);
        r0.Z$0 = ((Boolean) r3).booleanValue();
        return r0;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke(((Boolean) r1).booleanValue(), (Continuation) r2);
    }

    public final Object invoke(boolean r1, Continuation<? super Unit> r2) {
        return create(Boolean.valueOf(r1), r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r10) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) goto L53;
        ResultKt.throwOnFailure(r10);
        boolean r11 = this.Z$0;
        ChatContinuousTalkComponent r0 = this.this$0;
        int r1 = ChatContinuousTalkComponent.M;
        u7 r2 = r0.u3();
        ArrayList r3 = null;
        int r4 = 0;
        if (r2 == null) goto L25;
        List r5 = r2.zj();
        if (r5 == null) goto L25;
        ArrayList r6 = new ArrayList();
        Iterator r7 = r5.iterator();
    L10:
        if (r7.hasNext() == false) goto L23;
        Object r8 = r7.next();
        Message r9 = (Message) r8;
        if (d.G0(r9) == true) goto L20;
        Map r12 = r9.getBusinessExt();
        if (r12 == null) goto L16;
        String r13 = (String) r12.get("common_button_v2_scene_audio");
    L18:
        if (Intrinsics.areEqual(r13, "true") == false) goto L20;
        boolean r14 = true;
    L21:
        if (r14 == false) goto L10;
        r6.add(r8);
        goto L10
    L16:
        r13 = null;
    L20:
        r14 = false;
        goto L21
    L23:
        r3 = r6;
    L25:
        if (r11 == false) goto L38;
        if (r3 == null) goto L34;
        Iterator r15 = r3.iterator();
    L29:
        if (r15.hasNext() == false) goto L34;
        Message r16 = (Message) r15.next();
        IChatRepoService r17 = a.a;
        IChatRepoService r18 = a.a;
        String r19 = r16.getLocalMessageId();
        if (r19 != null) goto L33;
        r19 = NameKeys.UnloadStrategy_No_Strategy;
    L33:
        r18.r1(r19, new q0());
    L34:
        FLogger r110 = FLogger.a;
        StringBuilder r20 = new StringBuilder("[onViewCreated]_");
        r20.append(this.this$0.hashCode());
        r20.append(" set button hidden to true for ");
        if (r3 == null) goto L37;
        r4 = r3.size();
    L37:
        r20.append(r4);
        r20.append(" messages");
        r110.i("ChatContinuousComponent", r20.toString());
    L51:
        return Unit.INSTANCE;
    L38:
        if (r3 == null) goto L46;
        Iterator r111 = r3.iterator();
    L41:
        if (r111.hasNext() == false) goto L46;
        Message r21 = (Message) r111.next();
        IChatRepoService r22 = a.a;
        IChatRepoService r23 = a.a;
        String r24 = r21.getLocalMessageId();
        if (r24 != null) goto L45;
        r24 = NameKeys.UnloadStrategy_No_Strategy;
    L45:
        r23.r1(r24, new r0());
    L46:
        FLogger r112 = FLogger.a;
        StringBuilder r25 = new StringBuilder("[onViewCreated]_");
        r25.append(this.this$0.hashCode());
        r25.append(" set button hidden to false for ");
        if (r3 == null) goto L49;
        r4 = r3.size();
    L49:
        r25.append(r4);
        r25.append(" messages");
        r112.i("ChatContinuousComponent", r25.toString());
        goto L51
    L53:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
