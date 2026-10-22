package com.larus.bmhome.chat.deepresearch.component;

import com.larus.bmhome.chat.cell.MessageCellStateTransformerType;
import com.larus.bmhome.chat.deepresearch.DeepReSearchParam;
import com.larus.bmhome.chat.model.repo.IConversationRepoService;
import com.larus.bmhome.chat.model.repo.IConversationRepoService$a;
import com.larus.im.bean.bot.BotModel;
import java.util.Map;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = MessageCellStateTransformerType.Z_LOTTERY_GUIDE_CELL)
@DebugMetadata(c = "com.larus.bmhome.chat.deepresearch.component.DeepReSearchContentComponent$mobGenerateTimeout$1", f = "DeepReSearchContentComponent.kt", i = {}, l = {373}, m = "invokeSuspend", n = {}, s = {})
final class DeepReSearchContentComponent$mobGenerateTimeout$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    int label;
    final /* synthetic */ DeepReSearchContentComponent this$0;

    public DeepReSearchContentComponent$mobGenerateTimeout$1(DeepReSearchContentComponent r1, Continuation<? super DeepReSearchContentComponent$mobGenerateTimeout$1> r2) {
        this.this$0 = r1;
        super(2, r2);
    }

    public final Continuation<Unit> create(Object r2, Continuation<?> r3) {
        return new DeepReSearchContentComponent$mobGenerateTimeout$1(this.this$0, r3);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r11) {
        Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r1 = this.label;
        String r3 = null;
        if (r1 == 0) goto L8;
        if (r1 != 1) goto L7;
        ResultKt.throwOnFailure(r11);
    L18:
        wc9.e r12 = (wc9.e) r11;
        com.larus.platform.service.o r2 = com.larus.platform.service.o.a;
        JSONObject r4 = new JSONObject();
        DeepReSearchContentComponent r5 = this.this$0;
        Map<String, Long> r6 = DeepReSearchContentComponent.M;
        DeepReSearchParam r7 = r5.z3();
        if (r7 == null) goto L21;
        String r8 = r7.c;
    L22:
        r4.put("conversation_id", r8);
        r4.put("resource_id", r5.C3());
        if (r12 == null) goto L25;
        String r13 = ic8.n.f(r12);
    L26:
        r4.put("chat_type", r13);
        DeepReSearchParam r14 = r5.z3();
        if (r14 == null) goto L31;
        BotModel r15 = r14.g;
        if (r15 == null) goto L31;
        r3 = r15.getBotId();
    L31:
        r4.put("bot_id", r3);
        r4.put("podcast_generation_source", "deep_research");
        Unit r16 = Unit.INSTANCE;
        r2.reportEvent("deep_research_podcast_generate_timeout", r4);
        return Unit.INSTANCE;
    L25:
        r13 = null;
        goto L26
    L21:
        r8 = null;
        goto L22
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        ResultKt.throwOnFailure(r11);
        DeepReSearchContentComponent r17 = this.this$0;
        Map<String, Long> r9 = DeepReSearchContentComponent.M;
        DeepReSearchParam r18 = r17.z3();
        if (r18 == null) goto L11;
        String r19 = r18.c;
    L12:
        IConversationRepoService r10 = zh8.a.b;
        if (r19 != null) goto L15;
        r19 = "";
    L15:
        this.label = 1;
        r11 = IConversationRepoService$a.c(r10, r19, true, null, this, 4);
        if (r11 != r0) goto L18;
        return r0;
    L11:
        r19 = null;
        goto L12
    }
}
