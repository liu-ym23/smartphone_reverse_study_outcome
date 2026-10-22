package com.larus.chat.search.impl.chat;

import com.larus.chat.search.api.model.SectionItemData;
import com.larus.chat.search.impl.chat.section.SectionListAdapter;
import java.util.ArrayList;
import java.util.List;
import kotlin.KotlinNothingValueException;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.flow.FlowCollector;
import kotlinx.coroutines.flow.i1;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.larus.chat.search.impl.chat.ChatSearchFragment$loadSectionList$1$1", f = "ChatSearchFragment.kt", i = {}, l = {704}, m = "invokeSuspend", n = {}, s = {})
final class ChatSearchFragment$loadSectionList$1$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ SectionListAdapter $adapter;
    int label;
    final /* synthetic */ ChatSearchFragment this$0;

    public static final class a<T> implements FlowCollector {
        public final /* synthetic */ ChatSearchFragment a;
        public final /* synthetic */ SectionListAdapter b;

        public a(ChatSearchFragment r1, SectionListAdapter r2) {
            this.a = r1;
            this.b = r2;
        }

        public final Object emit(Object r2, Continuation r3) {
            List r4 = (List) r2;
            ((ArrayList) this.a.v).clear();
            ArrayList r5 = (ArrayList) this.a.v;
            r5.addAll(r4);
            this.b.submitList(r4);
            return Unit.INSTANCE;
        }
    }

    public ChatSearchFragment$loadSectionList$1$1(ChatSearchFragment r1, SectionListAdapter r2, Continuation<? super ChatSearchFragment$loadSectionList$1$1> r3) {
        this.this$0 = r1;
        this.$adapter = r2;
        super(2, r3);
    }

    public final Continuation<Unit> create(Object r3, Continuation<?> r4) {
        return new ChatSearchFragment$loadSectionList$1$1(this.this$0, this.$adapter, r4);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r6) {
        Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r1 = this.label;
        if (r1 == 0) goto L8;
        if (r1 != 1) goto L6;
        ResultKt.throwOnFailure(r6);
    L12:
        throw new KotlinNothingValueException();
    L6:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        ResultKt.throwOnFailure(r6);
        ChatSearchFragment r7 = this.this$0;
        int r2 = ChatSearchFragment.A;
        i1<List<SectionItemData>> r8 = r7.Z90().getDataFlow();
        a r3 = new a(this.this$0, this.$adapter);
        this.label = 1;
        if (r8.collect(r3, this) != r0) goto L12;
        return r0;
    }
}
