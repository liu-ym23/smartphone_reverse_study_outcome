package com.larus.bmhome.chat.list.cell.text.cells.base;

import android.content.Context;
import com.larus.avlink.model.DoraCallStateCode;
import com.larus.bmhome.chat.cell.MessageCellStateTransformerType;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.MapsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = MessageCellStateTransformerType.Z_LOTTERY_GUIDE_CELL)
@DebugMetadata(c = "com.larus.bmhome.chat.list.cell.text.cells.base.CutMultipleCellNotifyManager$notifyDeepThinkContentFirstTypingEnd$1", f = "CutMultipleCellNotifyManager.kt", i = {}, l = {DoraCallStateCode.DOUBAO_STOP_RECORD_BY_IM}, m = "invokeSuspend", n = {}, s = {})
final class CutMultipleCellNotifyManager$notifyDeepThinkContentFirstTypingEnd$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ int $contentType;
    final /* synthetic */ Context $context;
    final /* synthetic */ String $messageId;
    final /* synthetic */ wq8.a $state;
    int label;
    final /* synthetic */ CutMultipleCellNotifyManager this$0;

    public CutMultipleCellNotifyManager$notifyDeepThinkContentFirstTypingEnd$1(CutMultipleCellNotifyManager r1, String r2, int r3, Context r4, wq8.a r5, Continuation<? super CutMultipleCellNotifyManager$notifyDeepThinkContentFirstTypingEnd$1> r6) {
        this.this$0 = r1;
        this.$messageId = r2;
        this.$contentType = r3;
        this.$context = r4;
        this.$state = r5;
        super(2, r6);
    }

    public final Continuation<Unit> create(Object r8, Continuation<?> r9) {
        return new CutMultipleCellNotifyManager$notifyDeepThinkContentFirstTypingEnd$1(this.this$0, this.$messageId, this.$contentType, this.$context, this.$state, r9);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r10) {
        Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r1 = this.label;
        if (r1 == 0) goto L8;
        if (r1 != 1) goto L7;
        ResultKt.throwOnFailure(r10);
    L12:
        return Unit.INSTANCE;
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        ResultKt.throwOnFailure(r10);
        CutMultipleCellNotifyManager r2 = this.this$0;
        String r3 = this.$messageId;
        int r4 = this.$contentType;
        Context r5 = this.$context;
        wq8.a r6 = this.$state;
        Map r7 = MapsKt.mutableMapOf(new Pair[]{TuplesKt.to(r3, r6)});
        this.label = 1;
        int r11 = CutMultipleCellNotifyManager.i;
        if (r2.c(true, r3, r4, r5, r6, r7, null) != r0) goto L12;
        return r0;
    }
}
