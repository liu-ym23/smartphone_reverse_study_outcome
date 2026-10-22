package com.larus.profile.impl;

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
@DebugMetadata(c = "com.larus.profile.impl.ProfileBotListFragment$botUpdateListener$1$onBotChanged$1$1$1", f = "ProfileBotListFragment.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
public final class ProfileBotListFragment$botUpdateListener$1$onBotChanged$1$1$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ BotModel $changedBot;
    final /* synthetic */ int $index;
    final /* synthetic */ ProfileBotListAdapter $it;
    final /* synthetic */ fs9.n $itemData;
    int label;

    public ProfileBotListFragment$botUpdateListener$1$onBotChanged$1$1$1(fs9.n r1, BotModel r2, ProfileBotListAdapter r3, int r4, Continuation<? super ProfileBotListFragment$botUpdateListener$1$onBotChanged$1$1$1> r5) {
        this.$itemData = r1;
        this.$changedBot = r2;
        this.$it = r3;
        this.$index = r4;
        super(2, r5);
    }

    public final Continuation<Unit> create(Object r7, Continuation<?> r8) {
        return new ProfileBotListFragment$botUpdateListener$1$onBotChanged$1$1$1(this.$itemData, this.$changedBot, this.$it, this.$index, r8);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r2) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) goto L7;
        ResultKt.throwOnFailure(r2);
        this.$itemData.x(this.$changedBot.getName());
        this.$itemData.w(this.$changedBot.getIconImage());
        this.$itemData.s(this.$changedBot.getBgImgInfo());
        this.$itemData.u(this.$changedBot.getBgImgUrl());
        this.$itemData.t(this.$changedBot.getBgImgUri());
        this.$itemData.r(this.$changedBot.getBgImgColor());
        this.$itemData.y(this.$changedBot.getPrivateStatus());
        this.$it.notifyItemChanged(this.$index);
        return Unit.INSTANCE;
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
