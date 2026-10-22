package com.ss.android.lark.officesdk.minutes.service.foundation.mvi.common;

import com.ss.android.lark.officesdk.minutes.service.foundation.mvi.repo.a;
import com.ss.android.lark.picker.base.view.ItemViewType;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.channels.ChannelIterator;
import kotlinx.coroutines.channels.c;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\b\u0012\u0004\u0012\u00020\u00030\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/channels/ActorScope;", "Lcom/ss/android/lark/officesdk/minutes/service/foundation/mvi/repo/ConcurrentEvent;"}, k = 3, mv = {2, 1, 0}, xi = ItemViewType.ITEM_VIEW_TYPE_DOUBAO_COMMON_CCM)
@DebugMetadata(c = "com.ss.android.lark.officesdk.minutes.service.foundation.mvi.common.CoroutinesSafe$initConcurrentEventIfNeed$1", f = "CoroutinesSafe.kt", i = {}, l = {ItemViewType.ITEM_VIEW_TYPE_SHIELD_P2P_CHAT, ItemViewType.ITEM_VIEW_TYPE_WIKI_SPACE}, m = "invokeSuspend", n = {}, s = {})
final class CoroutinesSafe$initConcurrentEventIfNeed$1 extends SuspendLambda implements Function2<c<a>, Continuation<? super Unit>, Object> {
    private /* synthetic */ Object L$0;
    int label;

    public CoroutinesSafe$initConcurrentEventIfNeed$1(Continuation<? super CoroutinesSafe$initConcurrentEventIfNeed$1> r2) {
        super(2, r2);
    }

    public final Continuation<Unit> create(Object r2, Continuation<?> r3) {
        CoroutinesSafe$initConcurrentEventIfNeed$1 r0 = new CoroutinesSafe$initConcurrentEventIfNeed$1(r3);
        r0.L$0 = r2;
        return r0;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((c) r1, (Continuation) r2);
    }

    public final Object invoke(c<a> r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:21:0x0062 -> B:12:0x0038). Please report as a decompilation issue!!! */
    public final Object invokeSuspend(Object r7) {
        Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r1 = this.label;
        if (r1 == 0) goto L10;
        if (r1 == 1) goto L9;
        if (r1 != 2) goto L8;
        ChannelIterator r2 = (ChannelIterator) this.L$0;
        ResultKt.throwOnFailure(r7);
        ChannelIterator r8 = r2;
    L11:
        CoroutinesSafe$initConcurrentEventIfNeed$1 r3 = this;
    L12:
        r3.L$0 = r8;
        r3.label = 1;
        Object r4 = r8.hasNext(r3);
        if (r4 != r0) goto L15;
        return r0;
    L15:
        CoroutinesSafe$initConcurrentEventIfNeed$1 r5 = r3;
        ChannelIterator r6 = r8;
        r7 = r4;
        CoroutinesSafe$initConcurrentEventIfNeed$1 r9 = r5;
    L17:
        if (((Boolean) r7).booleanValue() == false) goto L23;
        Function1<Continuation<? super Unit>, Object> r10 = ((a) r6.next()).a;
        r9.L$0 = r6;
        r9.label = 2;
        if (r10.invoke(r9) != r0) goto L21;
        return r0;
    L21:
        r8 = r6;
        r3 = r9;
        goto L12
    L23:
        return Unit.INSTANCE;
    L8:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L9:
        r6 = (ChannelIterator) this.L$0;
        ResultKt.throwOnFailure(r7);
        r9 = this;
        goto L17
    L10:
        ResultKt.throwOnFailure(r7);
        r8 = ((c) this.L$0).getChannel().iterator();
        goto L11
    }
}
