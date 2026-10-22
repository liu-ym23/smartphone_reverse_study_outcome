package com.larus.bmhome.chat.deepresearch.component;

import com.larus.bmhome.chat.cell.MessageCellStateTransformerType;
import com.larus.bmhome.chat.deepresearch.DeepReSearchFragment;
import com.larus.bmhome.chat.deepresearch.DeepReSearchParam;
import com.larus.im.bean.bot.BotModel;
import com.larus.im.bean.message.Message;
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
import kotlinx.coroutines.CoroutineScope;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = MessageCellStateTransformerType.Z_LOTTERY_GUIDE_CELL)
@DebugMetadata(c = "com.larus.bmhome.chat.deepresearch.component.DeepReSearchContentComponent$trackFinishTTS$1", f = "DeepReSearchContentComponent.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
final class DeepReSearchContentComponent$trackFinishTTS$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    int label;
    final /* synthetic */ DeepReSearchContentComponent this$0;

    public DeepReSearchContentComponent$trackFinishTTS$1(DeepReSearchContentComponent r1, Continuation<? super DeepReSearchContentComponent$trackFinishTTS$1> r2) {
        this.this$0 = r1;
        super(2, r2);
    }

    public final Continuation<Unit> create(Object r2, Continuation<?> r3) {
        return new DeepReSearchContentComponent$trackFinishTTS$1(this.this$0, r3);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r6) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) goto L29;
        ResultKt.throwOnFailure(r6);
        com.larus.platform.service.o r7 = com.larus.platform.service.o.a;
        JSONObject r0 = new JSONObject();
        DeepReSearchContentComponent r1 = this.this$0;
        Map<String, Long> r2 = DeepReSearchContentComponent.M;
        DeepReSearchParam r3 = r1.z3();
        String r4 = null;
        if (r3 == null) goto L7;
        String r5 = r3.c;
    L8:
        r0.put("conversation_id", r5);
        DeepReSearchParam r8 = r1.z3();
        if (r8 == null) goto L13;
        Message r9 = r8.f;
        if (r9 == null) goto L13;
        String r10 = r9.getMessageId();
    L14:
        r0.put("message_id", r10);
        DeepReSearchParam r11 = r1.z3();
        if (r11 == null) goto L19;
        BotModel r12 = r11.g;
        if (r12 == null) goto L19;
        String r13 = r12.getBotId();
    L20:
        r0.put("bot_id", r13);
        Intrinsics.checkNotNullParameter(r1, "<this>");
        DeepReSearchFragment r14 = com.larus.ui.arch.component.internal.attach.a.b(r1, r1);
        if ((r14 instanceof DeepReSearchFragment) == false) goto L23;
        DeepReSearchFragment r15 = r14;
    L24:
        if (r15 == null) goto L26;
        r4 = r15.k();
    L26:
        r0.put("current_page", r4);
        Unit r16 = Unit.INSTANCE;
        r7.reportEvent("finish_tts", r0);
        return Unit.INSTANCE;
    L23:
        r15 = null;
    L19:
        r13 = null;
    L13:
        r10 = null;
        goto L14
    L7:
        r5 = null;
        goto L8
    L29:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
