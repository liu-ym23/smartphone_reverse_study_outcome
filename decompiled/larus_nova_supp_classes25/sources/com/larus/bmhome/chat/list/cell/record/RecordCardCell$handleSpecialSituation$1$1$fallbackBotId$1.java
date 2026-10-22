package com.larus.bmhome.chat.list.cell.record;

import com.larus.bmhome.chat.cell.MessageCellStateTransformerType;
import com.larus.bmhome.chat.component.cvs.y;
import ic8.n;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u000e\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = MessageCellStateTransformerType.Z_LOTTERY_GUIDE_CELL)
@DebugMetadata(c = "com.larus.bmhome.chat.list.cell.record.RecordCardCell$handleSpecialSituation$1$1$fallbackBotId$1", f = "RecordCardCell.kt", i = {}, l = {606}, m = "invokeSuspend", n = {}, s = {})
public final class RecordCardCell$handleSpecialSituation$1$1$fallbackBotId$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super String>, Object> {
    int label;
    final /* synthetic */ RecordCardCell this$0;

    public RecordCardCell$handleSpecialSituation$1$1$fallbackBotId$1(RecordCardCell r1, Continuation<? super RecordCardCell$handleSpecialSituation$1$1$fallbackBotId$1> r2) {
        this.this$0 = r1;
        super(2, r2);
    }

    public final Continuation<Unit> create(Object r2, Continuation<?> r3) {
        return new RecordCardCell$handleSpecialSituation$1$1$fallbackBotId$1(this.this$0, r3);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super String> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r4) {
        Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r1 = this.label;
        if (r1 == 0) goto L8;
        if (r1 != 1) goto L7;
        ResultKt.throwOnFailure(r4);
    L15:
        List r5 = (List) r4;
        if (r5 == null) goto L20;
        String r6 = (String) CollectionsKt.firstOrNull(r5);
        if (r6 == null) goto L20;
        return r6;
    L20:
        return "";
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        ResultKt.throwOnFailure(r4);
        RecordCardCell r7 = this.this$0;
        Map r2 = RecordCardCell.m;
        y r8 = (y) r7.k.getValue();
        if (r8 == null) goto L20;
        wc9.e r9 = r8.h();
        if (r9 == null) goto L20;
        this.label = 1;
        r4 = n.c(r9, this);
        if (r4 != r0) goto L15;
        return r0;
    }
}
