package com.larus.bmhome.chat.component.list.pipeline.pre_dependent;

import com.larus.bmhome.chat.cell.MessageCellStateTransformerType;
import com.larus.im.bean.bot.BotModel;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Result;
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
@DebugMetadata(c = "com.larus.bmhome.chat.component.list.pipeline.pre_dependent.PreDependentFilterTask$monitorDuplicateFirstMeetMsg$1", f = "PreDependentFilterTask.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
final class PreDependentFilterTask$monitorDuplicateFirstMeetMsg$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ Map<Long, List<xc8.b>> $map;
    final /* synthetic */ String $mapInfoStr;
    private /* synthetic */ Object L$0;
    int label;
    final /* synthetic */ g this$0;

    /* JADX WARN: Multi-variable type inference failed */
    public PreDependentFilterTask$monitorDuplicateFirstMeetMsg$1(g r1, Map<Long, ? extends List<? extends xc8.b>> r2, String r3, Continuation<? super PreDependentFilterTask$monitorDuplicateFirstMeetMsg$1> r4) {
        this.this$0 = r1;
        this.$map = r2;
        this.$mapInfoStr = r3;
        super(2, r4);
    }

    public final Continuation<Unit> create(Object r5, Continuation<?> r6) {
        PreDependentFilterTask$monitorDuplicateFirstMeetMsg$1 r0 = new PreDependentFilterTask$monitorDuplicateFirstMeetMsg$1(this.this$0, this.$map, this.$mapInfoStr, r6);
        r0.L$0 = r5;
        return r0;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r7) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) goto L20;
        ResultKt.throwOnFailure(r7);
        CoroutineScope r8 = (CoroutineScope) this.L$0;
        g r9 = this.this$0;
        Map<Long, List<xc8.b>> r0 = this.$map;
        String r1 = this.$mapInfoStr;
        Result.Companion r2 = Result.Companion;     // Catch: Throwable -> L15
        JSONObject r3 = new JSONObject();     // Catch: Throwable -> L15
        BotModel r4 = r9.a.a();     // Catch: Throwable -> L15
        if (r4 == null) goto L8;
        String r5 = r4.getBotId();     // Catch: Throwable -> L15
    L9:
        r3.put("bot_id", r5);     // Catch: Throwable -> L15
        wc9.e r10 = r9.a.g();     // Catch: Throwable -> L15
        if (r10 == null) goto L12;
        String r11 = r10.a;     // Catch: Throwable -> L15
    L13:
        r3.put("conversation_id", r11);     // Catch: Throwable -> L15
        r3.put("map_size", r0.size());     // Catch: Throwable -> L15
        r3.put("map_info", r1);     // Catch: Throwable -> L15
        com.larus.platform.service.g.a.monitorEventForSlardar("duplicate_first_meet_msg", r3, null, null);     // Catch: Throwable -> L15
        Result.constructor-impl(Unit.INSTANCE);     // Catch: Throwable -> L15
    L18:
        return Unit.INSTANCE;
    L12:
        r11 = null;
        goto L13
    L8:
        r5 = null;
    L15:
        th = move-exception;
        Result.Companion r6 = Result.Companion;
        Result.constructor-impl(ResultKt.createFailure(th));
        goto L18
    L20:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
