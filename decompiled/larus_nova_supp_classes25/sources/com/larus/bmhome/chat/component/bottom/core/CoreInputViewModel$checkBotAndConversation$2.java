package com.larus.bmhome.chat.component.bottom.core;

import androidx.lifecycle.FlowLiveDataConversions;
import com.larus.bmhome.chat.api.AuthModelDelegate;
import com.larus.bmhome.chat.cell.MessageCellStateTransformerType;
import com.larus.im.bean.bot.BotModel;
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
import kotlinx.coroutines.flow.Flow;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = MessageCellStateTransformerType.Z_LOTTERY_GUIDE_CELL)
@DebugMetadata(c = "com.larus.bmhome.chat.component.bottom.core.CoreInputViewModel$checkBotAndConversation$2", f = "CoreInputViewModel.kt", i = {}, l = {657, 657, 661}, m = "invokeSuspend", n = {}, s = {})
public final class CoreInputViewModel$checkBotAndConversation$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ BotModel $bot;
    final /* synthetic */ Function2<BotModel, Integer, Unit> $callback;
    final /* synthetic */ wc9.e $conversation;
    int label;

    /* JADX INFO: renamed from: com.larus.bmhome.chat.component.bottom.core.CoreInputViewModel$checkBotAndConversation$2$1, reason: invalid class name */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = MessageCellStateTransformerType.Z_LOTTERY_GUIDE_CELL)
    @DebugMetadata(c = "com.larus.bmhome.chat.component.bottom.core.CoreInputViewModel$checkBotAndConversation$2$1", f = "CoreInputViewModel.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    public static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ BotModel $bot;
        final /* synthetic */ Function2<BotModel, Integer, Unit> $callback;
        final /* synthetic */ Integer $type;
        int label;

        public AnonymousClass1(Function2<? super BotModel, ? super Integer, Unit> r1, BotModel r2, Integer r3, Continuation<? super AnonymousClass1> r4) {
            this.$callback = r1;
            this.$bot = r2;
            this.$type = r3;
            super(2, r4);
        }

        public final Continuation<Unit> create(Object r4, Continuation<?> r5) {
            return new AnonymousClass1(this.$callback, this.$bot, this.$type, r5);
        }

        public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
            return invoke((CoroutineScope) r1, (Continuation) r2);
        }

        public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
            return create(r1, r2).invokeSuspend(Unit.INSTANCE);
        }

        public final Object invokeSuspend(Object r3) {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label != 0) goto L7;
            ResultKt.throwOnFailure(r3);
            this.$callback.invoke(this.$bot, this.$type);
            return Unit.INSTANCE;
        L7:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    public CoreInputViewModel$checkBotAndConversation$2(wc9.e r1, BotModel r2, Function2<? super BotModel, ? super Integer, Unit> r3, Continuation<? super CoreInputViewModel$checkBotAndConversation$2> r4) {
        this.$conversation = r1;
        this.$bot = r2;
        this.$callback = r3;
        super(2, r4);
    }

    public final Continuation<Unit> create(Object r4, Continuation<?> r5) {
        return new CoreInputViewModel$checkBotAndConversation$2(this.$conversation, this.$bot, this.$callback, r5);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r8) {
        Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r1 = this.label;
        if (r1 == 0) goto L12;
        if (r1 == 1) goto L11;
        if (r1 == 2) goto L10;
        if (r1 != 3) goto L9;
        ResultKt.throwOnFailure(r8);
    L40:
        return Unit.INSTANCE;
    L9:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L10:
        ResultKt.throwOnFailure(r8);
    L20:
        List r9 = (List) r8;
        if (r9 == null) goto L23;
        String r10 = (String) CollectionsKt.firstOrNull(r9);
    L24:
        wc9.e r2 = this.$conversation;
        if (r2 == null) goto L27;
        Integer r3 = r2.j;
    L28:
        BotModel r4 = this.$bot;
        if (r4 == null) goto L31;
        String r5 = r4.getBotId();
    L32:
        if (r5 == null) goto L40;
        if (Intrinsics.areEqual(this.$bot.getBotId(), r10) == false) goto L40;
        if (r3 == null) goto L40;
        MainCoroutineDispatcher r11 = Dispatchers.getMain();
        AnonymousClass1 r6 = new AnonymousClass1(this.$callback, this.$bot, r3, null);
        this.label = 3;
        if (BuildersKt.withContext(r11, r6, this) != r0) goto L40;
        return r0;
    L31:
        r5 = null;
        goto L32
    L27:
        r3 = null;
    L23:
        r10 = null;
        goto L24
    L11:
        ResultKt.throwOnFailure(r8);
    L15:
        wc9.e r12 = (wc9.e) r8;
        if (r12 == null) goto L23;
        this.label = 2;
        r8 = ic8.n.c(r12, this);
        if (r8 != r0) goto L20;
        return r0;
    L12:
        ResultKt.throwOnFailure(r8);
        Flow r13 = FlowLiveDataConversions.asFlow(AuthModelDelegate.b.y());
        CoreInputViewModel$checkBotAndConversation$2$mainBotId$1 r7 = new CoreInputViewModel$checkBotAndConversation$2$mainBotId$1(null);
        this.label = 1;
        r8 = kotlinx.coroutines.flow.e.u(r13, r7, this);
        if (r8 != r0) goto L15;
        return r0;
    }
}
