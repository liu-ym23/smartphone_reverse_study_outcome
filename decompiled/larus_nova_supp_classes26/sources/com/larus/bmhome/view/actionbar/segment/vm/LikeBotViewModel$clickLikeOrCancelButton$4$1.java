package com.larus.bmhome.view.actionbar.segment.vm;

import com.larus.bmhome.chat.model.repo.BotRepo;
import com.larus.bmhome.chat.model.repo.IBotRepoService;
import com.larus.bmhome.chat.model.repo.RepoDispatcher;
import com.larus.im.bean.bot.BotModel;
import com.larus.im.internal.protocol.model.LikeInfo;
import com.larus.utils.logger.FLogger;
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
import kotlinx.coroutines.DelayKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.larus.bmhome.view.actionbar.segment.vm.LikeBotViewModel$clickLikeOrCancelButton$4$1", f = "LikeBotViewModel.kt", i = {}, l = {233, 251, 254}, m = "invokeSuspend", n = {}, s = {})
public final class LikeBotViewModel$clickLikeOrCancelButton$4$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ long $callLikeCount;
    final /* synthetic */ int $callLikeOrCancel;
    final /* synthetic */ BotModel $it;
    int label;
    final /* synthetic */ LikeBotViewModel this$0;

    public LikeBotViewModel$clickLikeOrCancelButton$4$1(LikeBotViewModel r1, BotModel r2, int r3, long r4, Continuation<? super LikeBotViewModel$clickLikeOrCancelButton$4$1> r6) {
        this.this$0 = r1;
        this.$it = r2;
        this.$callLikeOrCancel = r3;
        this.$callLikeCount = r4;
        super(2, r6);
    }

    public final Continuation<Unit> create(Object r8, Continuation<?> r9) {
        return new LikeBotViewModel$clickLikeOrCancelButton$4$1(this.this$0, this.$it, this.$callLikeOrCancel, this.$callLikeCount, r9);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r78) {
        Object r8 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r0 = this.label;
        if (r0 == 0) goto L12;
        if (r0 == 1) goto L11;
        if (r0 == 2) goto L10;
        if (r0 != 3) goto L9;
        ResultKt.throwOnFailure(r78);
    L39:
        int r1 = LikeBotViewModel.access$getRemainPullCount$cp();
        LikeBotViewModel.access$setRemainPullCount$cp(r1 - 1);
        Boxing.boxInt(r1);
    L42:
        return Unit.INSTANCE;
    L9:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L10:
        ResultKt.throwOnFailure(r78);
    L31:
        if (LikeBotViewModel.access$getRemainPullCount$cp() != 0) goto L38;
        FLogger.a.i("ComponentViewModel", "clickLikeOrCancelButton request refresh " + LikeBotViewModel.access$getRemainPullCount$cp());
        RepoDispatcher.a.getClass();
        BotRepo r2 = RepoDispatcher.g;
        String r3 = this.$it.getBotId();
        if (r3 != null) goto L35;
        r3 = "";
    L35:
        this.label = 3;
        if (IBotRepoService.b.a(r2, r3, true, "detail", true, this, 16) != r8) goto L39;
        return r8;
    L38:
        FLogger.a.i("ComponentViewModel", "clickLikeOrCancelButton skip refresh " + LikeBotViewModel.access$getRemainPullCount$cp());
        Unit r4 = Unit.INSTANCE;
        goto L39
    L11:
        ResultKt.throwOnFailure(r78);
    L16:
        if (LikeBotViewModel.access$getRemainRequestCount$cp() == 0) goto L18;
        LikeBotViewModel.access$setRemainPullCount$cp(LikeBotViewModel.access$getRemainPullCount$cp() - 1);
        LikeBotViewModel.access$setRemainBotSaveCount$cp(LikeBotViewModel.access$getRemainBotSaveCount$cp() - 1);
        FLogger.a.i("ComponentViewModel", "clickLikeOrCancelButton delay refresh " + LikeBotViewModel.access$getRemainRequestCount$cp());
        goto L42
    L18:
        if (LikeBotViewModel.access$getRemainBotSaveCount$cp() != 0) goto L26;
        FLogger.a.i("ComponentViewModel", "clickLikeOrCancelButton save bot " + LikeBotViewModel.access$getRemainBotSaveCount$cp());
        BotModel r9 = LikeBotViewModel.access$getMBotModel$p(this.this$0);
        if (r9 == null) goto L27;
        int r5 = this.$callLikeOrCancel;
        long r6 = this.$callLikeCount;
        RepoDispatcher.a.getClass();
        BotRepo r7 = RepoDispatcher.g;
        LikeInfo r69 = r9.getLikeInfo();
        if (r69 == null) goto L24;
        LikeInfo r10 = LikeInfo.copy$default(r69, null, null, Boxing.boxInt(r5), Boxing.boxLong(r6), 3, null);
    L25:
        r7.e1(BotModel.copy$default(r9, null, null, null, 0, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, false, null, null, null, null, null, null, null, null, null, null, null, null, 0, null, null, null, null, null, null, null, null, null, false, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, r10, null, null, null, null, -1, 2080374783, null));
        goto L27
    L24:
        r10 = null;
    L27:
        LikeBotViewModel.access$setRemainBotSaveCount$cp(LikeBotViewModel.access$getRemainBotSaveCount$cp() - 1);
        this.label = 2;
        if (DelayKt.delay(2000, this) != r8) goto L31;
        return r8;
    L26:
        FLogger.a.i("ComponentViewModel", "clickLikeOrCancelButton skip save bot " + LikeBotViewModel.access$getRemainBotSaveCount$cp());
        goto L27
    L12:
        ResultKt.throwOnFailure(r78);
        this.label = 1;
        if (DelayKt.delay(1000, this) != r8) goto L16;
        return r8;
    }
}
