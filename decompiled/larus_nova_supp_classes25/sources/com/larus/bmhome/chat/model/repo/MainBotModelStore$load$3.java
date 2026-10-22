package com.larus.bmhome.chat.model.repo;

import com.larus.bmhome.chat.cell.MessageCellStateTransformerType;
import com.larus.im.bean.bot.BotModel;
import com.larus.im.callback.IIMCallback;
import com.larus.im.callback.IIMError;
import com.larus.utils.logger.FLogger;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CompletableDeferred;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = MessageCellStateTransformerType.Z_LOTTERY_GUIDE_CELL)
@DebugMetadata(c = "com.larus.bmhome.chat.model.repo.MainBotModelStore$load$3", f = "MainBotModelStore.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
final class MainBotModelStore$load$3 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ String $botId;
    final /* synthetic */ boolean $forceNew;
    final /* synthetic */ CompletableDeferred<BotModel> $request;
    final /* synthetic */ CoroutineScope $requestScope;
    final /* synthetic */ String $scene;
    final /* synthetic */ boolean $shared;
    final /* synthetic */ boolean $syncLocal;
    final /* synthetic */ long $version;
    int label;
    final /* synthetic */ MainBotModelStore this$0;

    public static final class a implements IIMCallback<BotModel> {
        public final /* synthetic */ MainBotModelStore a;
        public final /* synthetic */ CoroutineScope b;
        public final /* synthetic */ long c;
        public final /* synthetic */ CompletableDeferred<BotModel> d;

        public final boolean mustInMain() {
            return false;
        }

        public final void onFailure(IIMError r9) {
            Intrinsics.checkNotNullParameter(r9, "error");
            FLogger.a.w("MainBotModelStore", "sdk read failed, request=" + this.d.hashCode() + ", code=" + r9.getCode());
            MainBotModelStore.b(this.a, this.b, this.c, this.d, null);
        }

        public final void onSuccess(Object r7) {
            BotModel r5 = (BotModel) r7;
            Intrinsics.checkNotNullParameter(r5, "result");
            MainBotModelStore.b(this.a, this.b, this.c, this.d, r5);
        }

        public a(MainBotModelStore r1, CoroutineScope r2, long r3, CompletableDeferred<BotModel> r5) {
            this.a = r1;
            this.b = r2;
            this.c = r3;
            this.d = r5;
        }
    }

    public MainBotModelStore$load$3(CompletableDeferred<BotModel> r1, String r2, boolean r3, boolean r4, boolean r5, String r6, MainBotModelStore r7, CoroutineScope r8, long r9, Continuation<? super MainBotModelStore$load$3> r11) {
        this.$request = r1;
        this.$botId = r2;
        this.$forceNew = r3;
        this.$syncLocal = r4;
        this.$shared = r5;
        this.$scene = r6;
        this.this$0 = r7;
        this.$requestScope = r8;
        this.$version = r9;
        super(2, r11);
    }

    public final Continuation<Unit> create(Object r13, Continuation<?> r14) {
        return new MainBotModelStore$load$3(this.$request, this.$botId, this.$forceNew, this.$syncLocal, this.$shared, this.$scene, this.this$0, this.$requestScope, this.$version, r14);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r13) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) goto L12;
        ResultKt.throwOnFailure(r13);
        FLogger.a.i("MainBotModelStore", "sdk read start, request=" + this.$request.hashCode() + ", botId=" + this.$botId + ", forceNew=" + this.$forceNew + ", syncLocal=" + this.$syncLocal + ", shared=" + this.$shared + ", scene=" + this.$scene);     // Catch: Exception -> L7
        MainBotModelStore r3 = this.this$0;     // Catch: Exception -> L7
        r3.c.getBot(this.$botId, this.$forceNew, this.$scene, this.$syncLocal, new a(r3, this.$requestScope, this.$version, this.$request));     // Catch: Exception -> L7
    L10:
        return Unit.INSTANCE;
    L7:
        e = move-exception;
        FLogger.a.e("MainBotModelStore", "sdk read exception, request=" + this.$request.hashCode(), e);
        MainBotModelStore.b(this.this$0, this.$requestScope, this.$version, this.$request, null);
        goto L10
    L12:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
