package com.larus.chat.search.impl.chat;

import com.larus.chat.search.impl.databinding.LarusFragmentChatSearchBinding;
import kotlin.KotlinNothingValueException;
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
import kotlinx.coroutines.flow.FlowCollector;
import kotlinx.coroutines.flow.d1;
import tx9.c0;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.larus.chat.search.impl.chat.ChatSearchFragment$onViewCreated$2$2", f = "ChatSearchFragment.kt", i = {}, l = {502}, m = "invokeSuspend", n = {}, s = {})
public final class ChatSearchFragment$onViewCreated$2$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ LarusFragmentChatSearchBinding $this_apply;
    int label;
    final /* synthetic */ ChatSearchFragment this$0;

    public static final class a<T> implements FlowCollector {
        public final /* synthetic */ ChatSearchFragment a;

        public a(ChatSearchFragment r1) {
            this.a = r1;
        }

        public final Object emit(Object r2, Continuation r3) {
            String r4 = (String) r2;
            if (Intrinsics.areEqual(this.a.k, r4) == true) goto L5;
            ChatSearchFragment r5 = this.a;
            r5.k = r4;
            r5.l = iz8.c.d(r4);
            ChatSearchFragment.U90(this.a);
            c0.y("click_button", this.a);
        L7:
            return Unit.INSTANCE;
        L5:
            c0.y("click_button", this.a);
            goto L7
        }
    }

    public ChatSearchFragment$onViewCreated$2$2(LarusFragmentChatSearchBinding r1, ChatSearchFragment r2, Continuation<? super ChatSearchFragment$onViewCreated$2$2> r3) {
        this.$this_apply = r1;
        this.this$0 = r2;
        super(2, r3);
    }

    public final Continuation<Unit> create(Object r3, Continuation<?> r4) {
        return new ChatSearchFragment$onViewCreated$2$2(this.$this_apply, this.this$0, r4);
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
        if (r1 != 1) goto L6;
        ResultKt.throwOnFailure(r5);
    L12:
        throw new KotlinNothingValueException();
    L6:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        ResultKt.throwOnFailure(r5);
        d1 r6 = this.$this_apply.c.getSearchTextFlow();
        a r2 = new a(this.this$0);
        this.label = 1;
        if (r6.collect(r2, this) != r0) goto L12;
        return r0;
    }
}
