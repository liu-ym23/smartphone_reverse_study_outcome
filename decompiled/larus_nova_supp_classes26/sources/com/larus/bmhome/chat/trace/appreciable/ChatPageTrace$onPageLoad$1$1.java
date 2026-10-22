package com.larus.bmhome.chat.trace.appreciable;

import com.larus.bmhome.chat.model.repo.ChatRepo;
import com.larus.bmhome.chat.model.repo.RepoDispatcher;
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

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.larus.bmhome.chat.trace.appreciable.ChatPageTrace$onPageLoad$1$1", f = "ChatPageTrace.kt", i = {}, l = {96}, m = "invokeSuspend", n = {}, s = {})
final class ChatPageTrace$onPageLoad$1$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ String $key;
    final /* synthetic */ ChatPageTrace.ChatPageRecord $this_apply;
    Object L$0;
    int label;

    public ChatPageTrace$onPageLoad$1$1(ChatPageTrace.ChatPageRecord r1, String r2, Continuation<? super ChatPageTrace$onPageLoad$1$1> r3) {
        this.$this_apply = r1;
        this.$key = r2;
        super(2, r3);
    }

    public final Continuation<Unit> create(Object r3, Continuation<?> r4) {
        return new ChatPageTrace$onPageLoad$1$1(this.$this_apply, this.$key, r4);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r5) {
        Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r1 = this.label;
        if (r1 == 0) goto L8;
        if (r1 != 1) goto L7;
        ChatPageTrace.ChatPageRecord r2 = (ChatPageTrace.ChatPageRecord) this.L$0;
        ResultKt.throwOnFailure(r5);
    L12:
        if (r5 == null) goto L14;
        Integer r6 = Boxing.boxInt(1);
    L15:
        r2.setHasLocal(r6);
        return Unit.INSTANCE;
    L14:
        r6 = Boxing.boxInt(0);
        goto L15
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        ResultKt.throwOnFailure(r5);
        ChatPageTrace.ChatPageRecord r7 = this.$this_apply;
        RepoDispatcher.a.getClass();
        ChatRepo r3 = RepoDispatcher.d;
        String r4 = this.$key;
        this.L$0 = r7;
        this.label = 1;
        Object r8 = r3.K1(r4, this);
        if (r8 != r0) goto L11;
        return r0;
    L11:
        r2 = r7;
        r5 = r8;
        goto L12
    }
}
