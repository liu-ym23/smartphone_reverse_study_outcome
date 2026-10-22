package com.obric.assistant.component;

import androidx.recyclerview.widget.RecyclerView;
import com.larus.bmhome.chat.adapter.MessageAdapter;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.obric.assistant.component.ObricMessageVisibilityComponent$scheduleVisibilityDispatch$1", f = "ObricMessageVisibilityComponent.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
public final class ObricMessageVisibilityComponent$scheduleVisibilityDispatch$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ String $reason;
    int label;
    final /* synthetic */ ObricMessageVisibilityComponent this$0;

    public ObricMessageVisibilityComponent$scheduleVisibilityDispatch$1(ObricMessageVisibilityComponent r1, String r2, Continuation<? super ObricMessageVisibilityComponent$scheduleVisibilityDispatch$1> r3) {
        this.this$0 = r1;
        this.$reason = r2;
        super(2, r3);
    }

    public final Continuation<Unit> create(Object r3, Continuation<?> r4) {
        return new ObricMessageVisibilityComponent$scheduleVisibilityDispatch$1(this.this$0, this.$reason, r4);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r4) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) goto L24;
        ResultKt.throwOnFailure(r4);
        ObricMessageVisibilityComponent r5 = this.this$0;
        int r0 = ObricMessageVisibilityComponent.w;
        r5.L2();
        ObricMessageVisibilityComponent r6 = this.this$0;
        MessageAdapter r1 = r6.P2();
        if (r1 == null) goto L13;
        MessageAdapter r2 = r6.p;
        if (r2 == r1) goto L13;
        if (r2 == null) goto L12;
        r2.r1(r6.r);
    L12:
        r6.p = r1;
        MessageAdapter r3 = r1;
        r3.p1(r6.r);
    L13:
        RecyclerView r7 = this.this$0.Ly();
        if (r7 != null) goto L17;
        ObricMessageVisibilityComponent.F2(this.this$0, this.$reason);
        return Unit.INSTANCE;
    L17:
        final ObricMessageVisibilityComponent r8 = this.this$0;
        if (r8.q == true) goto L20;
        r8.q = true;
        final String r9 = this.$reason;
        r7.post(new e3(r8, r9));
        return Unit.INSTANCE;
    L20:
        return Unit.INSTANCE;
    L24:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
