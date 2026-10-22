package com.larus.profile.impl;

import com.larus.im.bean.bot.BotModel;
import com.tencent.open.log.TraceLevel;
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
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.MainCoroutineDispatcher;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = TraceLevel.ABOVE_WARN)
@DebugMetadata(c = "com.larus.profile.impl.ProfileBotListFragment$botUpdateListener$1$onBotChanged$1", f = "ProfileBotListFragment.kt", i = {}, l = {139}, m = "invokeSuspend", n = {}, s = {})
public final class ProfileBotListFragment$botUpdateListener$1$onBotChanged$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ List<BotModel> $changedBots;
    int label;
    final /* synthetic */ ProfileBotListFragment this$0;
    final /* synthetic */ ProfileBotListFragment$botUpdateListener$1 this$1;

    public ProfileBotListFragment$botUpdateListener$1$onBotChanged$1(ProfileBotListFragment r1, List<BotModel> r2, ProfileBotListFragment$botUpdateListener$1 r3, Continuation<? super ProfileBotListFragment$botUpdateListener$1$onBotChanged$1> r4) {
        this.this$0 = r1;
        this.$changedBots = r2;
        this.this$1 = r3;
        super(2, r4);
    }

    public final Continuation<Unit> create(Object r4, Continuation<?> r5) {
        return new ProfileBotListFragment$botUpdateListener$1$onBotChanged$1(this.this$0, this.$changedBots, this.this$1, r5);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r11) {
        Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r1 = this.label;
        if (r1 == 0) goto L8;
        if (r1 != 1) goto L7;
        ResultKt.throwOnFailure(r11);
    L26:
        return Unit.INSTANCE;
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        ResultKt.throwOnFailure(r11);
        ProfileBotListAdapter r6 = this.this$0.k;
        if (r6 == null) goto L29;
        List<BotModel> r12 = this.$changedBots;
        ProfileBotListFragment$botUpdateListener$1 r2 = this.this$1;
        int r3 = r6.getItemCount();
        BotModel r5 = (BotModel) CollectionsKt.firstOrNull(r12);
        if (r5 == null) goto L29;
        if (Intrinsics.areEqual(r5.getBotId(), r2.a) == false) goto L29;
        List r13 = CollectionsKt.toList(r6.a);
        int r7 = 0;
    L15:
        if (r7 >= r3) goto L29;
        fs9.n r4 = (fs9.n) CollectionsKt.getOrNull(r13, r7);
        String r8 = r2.a;
        if (r4 == null) goto L19;
        String r9 = r4.e();
    L21:
        if (Intrinsics.areEqual(r8, r9) == true) goto L22;
        r7 = r7 + 1;
        goto L15
    L22:
        MainCoroutineDispatcher r14 = Dispatchers.getMain();
        ProfileBotListFragment$botUpdateListener$1$onBotChanged$1$1$1 r10 = new ProfileBotListFragment$botUpdateListener$1$onBotChanged$1$1$1(r4, r5, r6, r7, null);
        this.label = 1;
        if (BuildersKt.withContext(r14, r10, this) != r0) goto L26;
        return r0;
    L19:
        r9 = null;
    L29:
        return Unit.INSTANCE;
    }
}
