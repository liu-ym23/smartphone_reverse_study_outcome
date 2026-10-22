package com.ss.android.lark.compose.chat_member_list;

import androidx.compose.foundation.lazy.LazyListState;
import androidx.compose.runtime.SnapshotStateKt;
import com.tencent.qqmusic.third.api.contract.BuildConfig;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowCollector;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", BuildConfig.FLAVOR, "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.ss.android.lark.compose.chat_member_list.ChatMemberListComponentsKt$ChatterPagingList$2$1", f = "ChatMemberListComponents.kt", i = {}, l = {105}, m = "invokeSuspend", n = {}, s = {})
public final class ChatMemberListComponentsKt$ChatterPagingList$2$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ boolean $hasMore;
    final /* synthetic */ boolean $isLoadingMore;
    final /* synthetic */ LazyListState $listState;
    final /* synthetic */ Function0<Unit> $onLoadMore;
    int label;

    public static final class a<T> implements FlowCollector {
        public final /* synthetic */ Function0<Unit> a;

        public a(Function0<Unit> r1) {
            this.a = r1;
        }

        public final Object emit(Object r1, Continuation r2) {
            ((Number) r1).intValue();
            this.a.invoke();
            return Unit.INSTANCE;
        }
    }

    public ChatMemberListComponentsKt$ChatterPagingList$2$1(LazyListState r1, boolean r2, boolean r3, Function0<Unit> r4, Continuation<? super ChatMemberListComponentsKt$ChatterPagingList$2$1> r5) {
        this.$listState = r1;
        this.$hasMore = r2;
        this.$isLoadingMore = r3;
        this.$onLoadMore = r4;
        super(2, r5);
    }

    public final Continuation<Unit> create(Object r7, Continuation<?> r8) {
        return new ChatMemberListComponentsKt$ChatterPagingList$2$1(this.$listState, this.$hasMore, this.$isLoadingMore, this.$onLoadMore, r8);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARN: Type inference failed for: r4v0, types: [com.ss.android.lark.compose.chat_member_list.ChatMemberListComponentsKt$ChatterPagingList$2$1$invokeSuspend$$inlined$filter$1] */
    public final Object invokeSuspend(Object r6) {
        Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r1 = this.label;
        if (r1 == 0) goto L8;
        if (r1 != 1) goto L7;
        ResultKt.throwOnFailure(r6);
    L12:
        return Unit.INSTANCE;
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        ResultKt.throwOnFailure(r6);
        final LazyListState r2 = this.$listState;
        final Flow r7 = SnapshotStateKt.snapshotFlow(new AnonymousClass1(r2));
        final Flow r8 = kotlinx.coroutines.flow.e.n(new ChatMemberListComponentsKt$ChatterPagingList$2$1$invokeSuspend$$inlined$map$1(r7));
        final boolean r3 = this.$hasMore;
        final boolean r4 = this.$isLoadingMore;
        final ?? r5 = new ChatMemberListComponentsKt$ChatterPagingList$2$1$invokeSuspend$$inlined$filter$1(r8, r3, r4);
        Flow r9 = kotlinx.coroutines.flow.e.n(new ChatMemberListComponentsKt$ChatterPagingList$2$1$invokeSuspend$$inlined$mapNotNull$1(r5));
        a r10 = new a(this.$onLoadMore);
        this.label = 1;
        if (r9.collect(r10, this) != r0) goto L12;
        return r0;
    }
}
