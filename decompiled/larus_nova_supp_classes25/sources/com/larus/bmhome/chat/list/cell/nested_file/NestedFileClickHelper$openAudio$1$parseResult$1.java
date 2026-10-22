package com.larus.bmhome.chat.list.cell.nested_file;

import com.larus.bmhome.chat.cell.MessageCellStateTransformerType;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u0004\u0018\u00010\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "Lcom/larus/bmhome/chat/bean/AudioParseResultData;", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = MessageCellStateTransformerType.Z_LOTTERY_GUIDE_CELL)
@DebugMetadata(c = "com.larus.bmhome.chat.list.cell.nested_file.NestedFileClickHelper$openAudio$1$parseResult$1", f = "NestedFileClickHelper.kt", i = {}, l = {257}, m = "invokeSuspend", n = {}, s = {})
public final class NestedFileClickHelper$openAudio$1$parseResult$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super ic8.g>, Object> {
    final /* synthetic */ String $tosKey;
    int label;

    public NestedFileClickHelper$openAudio$1$parseResult$1(String r1, Continuation<? super NestedFileClickHelper$openAudio$1$parseResult$1> r2) {
        this.$tosKey = r1;
        super(2, r2);
    }

    public final Continuation<Unit> create(Object r2, Continuation<?> r3) {
        return new NestedFileClickHelper$openAudio$1$parseResult$1(this.$tosKey, r3);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super ic8.g> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r4) {
        Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r1 = this.label;
        if (r1 == 0) goto L8;
        if (r1 != 1) goto L7;
        ResultKt.throwOnFailure(r4);
    L16:
        return (ic8.g) r4;
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        ResultKt.throwOnFailure(r4);
        String r5 = this.$tosKey;
        if (r5 == null) goto L14;
        NestedFileClickHelper r2 = NestedFileClickHelper.a;
        this.label = 1;
        r4 = r2.d(r5, this);
        if (r4 != r0) goto L16;
        return r0;
    L14:
        return null;
    }
}
