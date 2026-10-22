package com.larus.uaigc.chat.markdown.image;

import androidx.recyclerview.widget.DiffUtil;
import com.larus.im.bean.message.Message;
import com.tencent.open.log.TraceLevel;
import java.util.List;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = TraceLevel.ABOVE_WARN)
@DebugMetadata(c = "com.larus.uaigc.chat.markdown.image.MDImageScrollWidget$refreshViewState$1$1", f = "MDImageScrollWidget.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
final class MDImageScrollWidget$refreshViewState$1$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ List<fz9.c> $viewDataList;
    int label;
    final /* synthetic */ MDImageScrollWidget this$0;

    /* JADX WARN: Multi-variable type inference failed */
    public MDImageScrollWidget$refreshViewState$1$1(MDImageScrollWidget r1, List<? extends fz9.c> r2, Continuation<? super MDImageScrollWidget$refreshViewState$1$1> r3) {
        this.this$0 = r1;
        this.$viewDataList = r2;
        super(2, r3);
    }

    public final Continuation<Unit> create(Object r3, Continuation<?> r4) {
        return new MDImageScrollWidget$refreshViewState$1$1(this.this$0, this.$viewDataList, r4);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r5) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) goto L27;
        ResultKt.throwOnFailure(r5);
        MDImageScrollAdapter r6 = this.this$0.r;
        if (r6 == null) goto L25;
        List<fz9.c> r0 = this.$viewDataList;
        if (r0 != null) goto L9;
        r0 = CollectionsKt.emptyList();
    L9:
        Intrinsics.checkNotNullParameter(r0, "data");
        fz9.c r1 = (fz9.c) CollectionsKt.firstOrNull(r0);
        String r2 = null;
        if (r1 == null) goto L14;
        Message r3 = r1.getMessage();
        if (r3 == null) goto L14;
        String r4 = r3.getMessageId();
    L15:
        fz9.c r7 = (fz9.c) CollectionsKt.firstOrNull(r6.j);
        if (r7 == null) goto L21;
        Message r8 = r7.getMessage();
        if (r8 == null) goto L21;
        r2 = r8.getMessageId();
    L21:
        if (Intrinsics.areEqual(r4, r2) == false) goto L23;
        DiffUtil.DiffResult r9 = DiffUtil.calculateDiff(new MDImageScrollAdapter.DiffCallback(r6.j, r0), false);
        r6.j = r0;
        r9.dispatchUpdatesTo(r6);
        goto L25
    L23:
        r6.j = r0;
        r6.notifyDataSetChanged();
    L14:
        r4 = null;
    L25:
        return Unit.INSTANCE;
    L27:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
