package com.larus.uaigc.chat.block.create.horizontal;

import androidx.recyclerview.widget.DiffUtil;
import com.larus.uaigc.chat.block.widget.container.CreationItemListAdapter;
import com.tencent.open.log.TraceLevel;
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

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = TraceLevel.ABOVE_WARN)
@DebugMetadata(c = "com.larus.uaigc.chat.block.create.horizontal.CreationHorizontalGroup$refreshViewState$1", f = "CreationHorizontalGroup.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
final class CreationHorizontalGroup$refreshViewState$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ List<cz9.b> $viewDataList;
    int label;
    final /* synthetic */ CreationHorizontalGroup this$0;

    /* JADX WARN: Multi-variable type inference failed */
    public CreationHorizontalGroup$refreshViewState$1(CreationHorizontalGroup r1, List<? extends cz9.b> r2, Continuation<? super CreationHorizontalGroup$refreshViewState$1> r3) {
        this.this$0 = r1;
        this.$viewDataList = r2;
        super(2, r3);
    }

    public final Continuation<Unit> create(Object r3, Continuation<?> r4) {
        return new CreationHorizontalGroup$refreshViewState$1(this.this$0, this.$viewDataList, r4);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r4) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) goto L10;
        ResultKt.throwOnFailure(r4);
        CreationItemListAdapter r5 = this.this$0.t;
        if (r5 == null) goto L8;
        List<cz9.b> r0 = this.$viewDataList;
        Intrinsics.checkNotNullParameter(r0, "data");
        DiffUtil.DiffResult r1 = DiffUtil.calculateDiff(new CreationItemListAdapter.DiffCallback(r5.j, r0), false);
        r5.j = r0;
        r1.dispatchUpdatesTo(r5);
    L8:
        return Unit.INSTANCE;
    L10:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
