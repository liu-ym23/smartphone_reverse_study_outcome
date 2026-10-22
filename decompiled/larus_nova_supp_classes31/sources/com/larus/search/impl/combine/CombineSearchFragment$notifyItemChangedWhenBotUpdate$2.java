package com.larus.search.impl.combine;

import androidx.recyclerview.widget.ListAdapter;
import androidx.recyclerview.widget.RecyclerView;
import com.larus.bmhome.chat.bean.RecommendBot;
import com.larus.im.bean.bot.BotModel;
import com.tencent.open.log.TraceLevel;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = TraceLevel.ABOVE_WARN)
@DebugMetadata(c = "com.larus.search.impl.combine.CombineSearchFragment$notifyItemChangedWhenBotUpdate$2", f = "CombineSearchFragment.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
final class CombineSearchFragment$notifyItemChangedWhenBotUpdate$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ ListAdapter<c0, RecyclerView.ViewHolder> $adapter;
    final /* synthetic */ BotModel $changedBot;
    final /* synthetic */ int $index;
    final /* synthetic */ c0 $itemData;
    int label;

    public CombineSearchFragment$notifyItemChangedWhenBotUpdate$2(c0 r1, BotModel r2, ListAdapter<c0, RecyclerView.ViewHolder> r3, int r4, Continuation<? super CombineSearchFragment$notifyItemChangedWhenBotUpdate$2> r5) {
        this.$itemData = r1;
        this.$changedBot = r2;
        this.$adapter = r3;
        this.$index = r4;
        super(2, r5);
    }

    public final Continuation<Unit> create(Object r7, Continuation<?> r8) {
        return new CombineSearchFragment$notifyItemChangedWhenBotUpdate$2(this.$itemData, this.$changedBot, this.$adapter, this.$index, r8);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r2) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) goto L19;
        ResultKt.throwOnFailure(r2);
        RecommendBot r3 = this.$itemData.q.a();
        if (r3 == null) goto L7;
        r3.w0(this.$changedBot.getBgImgInfo());
    L7:
        RecommendBot r4 = this.$itemData.q.a();
        if (r4 == null) goto L10;
        r4.C0(this.$changedBot.getBgImgUrl());
    L10:
        RecommendBot r5 = this.$itemData.q.a();
        if (r5 == null) goto L13;
        r5.y0(this.$changedBot.getBgImgUri());
    L13:
        RecommendBot r6 = this.$itemData.q.a();
        if (r6 == null) goto L16;
        r6.v0(this.$changedBot.getBgImgColor());
    L16:
        this.$adapter.notifyItemChanged(this.$index);
        return Unit.INSTANCE;
    L19:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
