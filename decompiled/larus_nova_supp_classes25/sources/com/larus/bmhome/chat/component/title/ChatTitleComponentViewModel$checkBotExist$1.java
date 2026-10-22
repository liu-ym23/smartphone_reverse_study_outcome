package com.larus.bmhome.chat.component.title;

import com.larus.bmhome.chat.cell.MessageCellStateTransformerType;
import com.larus.im.bean.bot.BotModel;
import com.larus.im.callback.IIMCallback;
import com.larus.im.callback.IIMError;
import com.larus.im.d;
import java.util.List;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CompletableDeferred;
import kotlinx.coroutines.CompletableDeferredKt;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = MessageCellStateTransformerType.Z_LOTTERY_GUIDE_CELL)
@DebugMetadata(c = "com.larus.bmhome.chat.component.title.ChatTitleComponentViewModel$checkBotExist$1", f = "ChatTitleComponentViewModel.kt", i = {}, l = {101}, m = "invokeSuspend", n = {}, s = {})
public final class ChatTitleComponentViewModel$checkBotExist$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ String $cvsId;
    final /* synthetic */ Function1<Boolean, Unit> $postAction;
    int label;

    public static final class a implements IIMCallback<List<? extends BotModel>> {
        public final /* synthetic */ CompletableDeferred<BotModel> a;

        public final boolean mustInMain() {
            return !com.larus.im.internal.delegate.y0.a();
        }

        public a(CompletableDeferred<BotModel> r1) {
            this.a = r1;
        }

        public final void onFailure(IIMError r2) {
            Intrinsics.checkNotNullParameter(r2, "error");
            Intrinsics.checkNotNullParameter(r2, "error");
            this.a.complete(null);
        }

        public final void onSuccess(Object r2) {
            List r3 = (List) r2;
            Intrinsics.checkNotNullParameter(r3, "result");
            this.a.complete(CollectionsKt.firstOrNull(r3));
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public ChatTitleComponentViewModel$checkBotExist$1(String r1, Function1<? super Boolean, Unit> r2, Continuation<? super ChatTitleComponentViewModel$checkBotExist$1> r3) {
        this.$cvsId = r1;
        this.$postAction = r2;
        super(2, r3);
    }

    public final Continuation<Unit> create(Object r3, Continuation<?> r4) {
        return new ChatTitleComponentViewModel$checkBotExist$1(this.$cvsId, this.$postAction, r4);
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
        boolean r2 = true;
        if (r1 == 0) goto L8;
        if (r1 != 1) goto L7;
        ResultKt.throwOnFailure(r6);
    L11:
        BotModel r7 = (BotModel) r6;
        Function1<Boolean, Unit> r3 = this.$postAction;
        if (r7 != null) goto L15;
        r2 = false;
    L15:
        r3.invoke(Boxing.boxBoolean(r2));
        return Unit.INSTANCE;
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        ResultKt.throwOnFailure(r6);
        CompletableDeferred r8 = CompletableDeferredKt.CompletableDeferred$default(null, 1, null);
        d.a().getBotByConversationId(this.$cvsId, new a(r8));
        this.label = 1;
        r6 = r8.await(this);
        if (r6 != r0) goto L11;
        return r0;
    }
}
