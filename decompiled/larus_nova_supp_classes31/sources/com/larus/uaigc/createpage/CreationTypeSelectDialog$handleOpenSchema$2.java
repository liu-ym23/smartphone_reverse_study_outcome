package com.larus.uaigc.createpage;

import com.tencent.open.log.TraceLevel;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Ref;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
@Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u00012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003H\n"}, d2 = {"<anonymous>", "", "it", "Lcom/larus/im/bean/conversation/Conversation;"}, k = 3, mv = {2, 1, 0}, xi = TraceLevel.ABOVE_WARN)
@DebugMetadata(c = "com.larus.uaigc.createpage.CreationTypeSelectDialog$handleOpenSchema$2", f = "CreationTypeSelectDialog.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
final class CreationTypeSelectDialog$handleOpenSchema$2 extends SuspendLambda implements Function2<wc9.e, Continuation<? super Unit>, Object> {
    final /* synthetic */ Ref.ObjectRef<String> $conversationId;
    /* synthetic */ Object L$0;
    int label;

    public CreationTypeSelectDialog$handleOpenSchema$2(Ref.ObjectRef<String> r1, Continuation<? super CreationTypeSelectDialog$handleOpenSchema$2> r2) {
        this.$conversationId = r1;
        super(2, r2);
    }

    public final Continuation<Unit> create(Object r3, Continuation<?> r4) {
        CreationTypeSelectDialog$handleOpenSchema$2 r0 = new CreationTypeSelectDialog$handleOpenSchema$2(this.$conversationId, r4);
        r0.L$0 = r3;
        return r0;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((wc9.e) r1, (Continuation) r2);
    }

    public final Object invoke(wc9.e r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r2) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) goto L12;
        ResultKt.throwOnFailure(r2);
        wc9.e r3 = (wc9.e) this.L$0;
        Ref.ObjectRef<String> r0 = this.$conversationId;
        if (r3 == null) goto L8;
        String r4 = r3.a;
        if (r4 == null) goto L8;
    L9:
        r0.element = r4;
        return Unit.INSTANCE;
    L8:
        r4 = "";
        goto L9
    L12:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
