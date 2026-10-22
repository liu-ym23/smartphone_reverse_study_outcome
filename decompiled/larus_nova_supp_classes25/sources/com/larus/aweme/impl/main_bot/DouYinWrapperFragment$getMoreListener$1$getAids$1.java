package com.larus.aweme.impl.main_bot;

import com.larus.bmhome.chat.cell.MessageCellStateTransformerType;
import com.larus.bmhome.video.Content;
import com.larus.bmhome.video.RecommendVideoApi;
import com.larus.bmhome.video.RecommendVideoData;
import com.larus.bmhome.video.SortRequestType;
import com.larus.bmhome.video.SortScene;
import java.util.ArrayList;
import java.util.Iterator;
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
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = MessageCellStateTransformerType.Z_LOTTERY_GUIDE_CELL)
@DebugMetadata(c = "com.larus.aweme.impl.main_bot.DouYinWrapperFragment$getMoreListener$1$getAids$1", f = "DouYinWrapperFragment.kt", i = {}, l = {153}, m = "invokeSuspend", n = {}, s = {})
final class DouYinWrapperFragment$getMoreListener$1$getAids$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ pr9.c $callback;
    int label;
    final /* synthetic */ DouYinWrapperFragment this$0;

    public DouYinWrapperFragment$getMoreListener$1$getAids$1(DouYinWrapperFragment r1, pr9.c r2, Continuation<? super DouYinWrapperFragment$getMoreListener$1$getAids$1> r3) {
        this.this$0 = r1;
        this.$callback = r2;
        super(2, r3);
    }

    public final Continuation<Unit> create(Object r3, Continuation<?> r4) {
        return new DouYinWrapperFragment$getMoreListener$1$getAids$1(this.this$0, this.$callback, r4);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r14) {
        Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r1 = this.label;
        boolean r2 = true;
        if (r1 == 0) goto L8;
        if (r1 != 1) goto L7;
        ResultKt.throwOnFailure(r14);
    L11:
        RecommendVideoData r15 = (RecommendVideoData) r14;
        if (r15 == null) goto L21;
        List r3 = r15.getItemLists();
        if (r3 == null) goto L21;
        ArrayList r4 = new ArrayList();
        Iterator r5 = r3.iterator();
    L17:
        if (r5.hasNext() == false) goto L23;
        String r6 = ((Content) r5.next()).getItemId();
        if (r6 == null) goto L17;
        r4.add(r6);
    L23:
        if (r4 != null) goto L25;
    L27:
        r2 = false;
    L28:
        if (r2 == false) goto L30;
        this.$callback.a(r15.getHasMore(), r4);
    L32:
        return Unit.INSTANCE;
    L30:
        this.$callback.a(false, CollectionsKt.emptyList());
        goto L32
    L25:
        if ((!r4.isEmpty()) != true) goto L27;
    L21:
        r4 = null;
        goto L23
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        ResultKt.throwOnFailure(r14);
        DouYinWrapperFragment r16 = this.this$0;
        int r7 = r16.h + 1;
        r16.h = r7;
        RecommendVideoApi r17 = RecommendVideoApi.a;
        SortScene r8 = SortScene.InnerStream;
        SortRequestType r9 = SortRequestType.UserLoadMore;
        this.label = 1;
        r14 = RecommendVideoApi.b(r8, r9, r7, null, null, null, null, null, this, 248);
        if (r14 != r0) goto L11;
        return r0;
    }
}
