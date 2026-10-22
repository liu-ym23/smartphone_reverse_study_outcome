package com.larus.bmhome.block.holder.deepthink;

import com.larus.bmhome.chat.ChatParam;
import com.larus.bmhome.chat.cell.MessageCellStateTransformerType;
import com.larus.im.bean.message.Message;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = MessageCellStateTransformerType.Z_LOTTERY_GUIDE_CELL)
@DebugMetadata(c = "com.larus.bmhome.block.holder.deepthink.SearchCotBlockHolder$SearchCotVMDependencyImpl$trackSearchCotShow$1", f = "SearchCotBlockHolder.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
final class SearchCotBlockHolder$SearchCotVMDependencyImpl$trackSearchCotShow$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ String $cardType;
    final /* synthetic */ boolean $isDeepThinking;
    final /* synthetic */ Message $message;
    final /* synthetic */ Integer $searchPosition;
    final /* synthetic */ String $status;
    final /* synthetic */ String $toolName;
    int label;
    final /* synthetic */ SearchCotBlockHolder.SearchCotVMDependencyImpl this$0;

    public SearchCotBlockHolder$SearchCotVMDependencyImpl$trackSearchCotShow$1(Message r1, SearchCotBlockHolder.SearchCotVMDependencyImpl r2, Integer r3, String r4, String r5, boolean r6, String r7, Continuation<? super SearchCotBlockHolder$SearchCotVMDependencyImpl$trackSearchCotShow$1> r8) {
        this.$message = r1;
        this.this$0 = r2;
        this.$searchPosition = r3;
        this.$cardType = r4;
        this.$status = r5;
        this.$isDeepThinking = r6;
        this.$toolName = r7;
        super(2, r8);
    }

    public final Continuation<Unit> create(Object r10, Continuation<?> r11) {
        return new SearchCotBlockHolder$SearchCotVMDependencyImpl$trackSearchCotShow$1(this.$message, this.this$0, this.$searchPosition, this.$cardType, this.$status, this.$isDeepThinking, this.$toolName, r11);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r21) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) goto L10;
        ResultKt.throwOnFailure(r21);
        int r1 = oi8.n.a;
        String r2 = this.$message.getSenderId();
        if (r2 != null) goto L7;
        r2 = "";
    L7:
        String r8 = r2;
        ChatParam r3 = this.this$0.f();
        oi8.n.b(this.$message, r3, null, this.$searchPosition, null, this.$cardType, r8, this.$status, Boxing.boxBoolean(this.$isDeepThinking), null, null, null, this.$toolName, null, null, null, null, 253076);
        return Unit.INSTANCE;
    L10:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
