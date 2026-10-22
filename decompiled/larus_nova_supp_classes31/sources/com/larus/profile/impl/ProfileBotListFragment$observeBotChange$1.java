package com.larus.profile.impl;

import com.tencent.open.log.TraceLevel;
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

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = TraceLevel.ABOVE_WARN)
@DebugMetadata(c = "com.larus.profile.impl.ProfileBotListFragment$observeBotChange$1", f = "ProfileBotListFragment.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
final class ProfileBotListFragment$observeBotChange$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ fs9.n $bot;
    int label;
    final /* synthetic */ ProfileBotListFragment this$0;

    public ProfileBotListFragment$observeBotChange$1(fs9.n r1, ProfileBotListFragment r2, Continuation<? super ProfileBotListFragment$observeBotChange$1> r3) {
        this.$bot = r1;
        this.this$0 = r2;
        super(2, r3);
    }

    public final Continuation<Unit> create(Object r3, Continuation<?> r4) {
        return new ProfileBotListFragment$observeBotChange$1(this.$bot, this.this$0, r4);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r4) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) goto L10;
        ResultKt.throwOnFailure(r4);
        String r5 = this.$bot.e();
        if (r5 == null) goto L8;
        ProfileBotListFragment r0 = this.this$0;
        int r1 = ProfileBotListFragment.y;
        com.larus.im.service.o r2 = (com.larus.im.service.o) r0.w.getValue();
        ProfileBotListFragment$botUpdateListener$1 r3 = r0.x;
        r3.getClass();
        Intrinsics.checkNotNullParameter(r5, "<set-?>");
        r3.a = r5;
        Unit r6 = Unit.INSTANCE;
        r2.registerBotChangeListener(r5, r3);
    L8:
        return Unit.INSTANCE;
    L10:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
