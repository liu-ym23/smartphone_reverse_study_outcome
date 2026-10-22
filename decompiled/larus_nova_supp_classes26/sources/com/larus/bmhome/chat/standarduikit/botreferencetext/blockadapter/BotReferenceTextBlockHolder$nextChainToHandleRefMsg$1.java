package com.larus.bmhome.chat.standarduikit.botreferencetext.blockadapter;

import com.larus.im.bean.bot.BotModel;
import com.larus.im.bean.message.Message;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Ref;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.MainCoroutineDispatcher;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.larus.bmhome.chat.standarduikit.botreferencetext.blockadapter.BotReferenceTextBlockHolder$nextChainToHandleRefMsg$1", f = "BotReferenceTextBlockHolder.kt", i = {}, l = {88, 89}, m = "invokeSuspend", n = {}, s = {})
public final class BotReferenceTextBlockHolder$nextChainToHandleRefMsg$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ a $blockModel;
    final /* synthetic */ BotModel $botModel;
    final /* synthetic */ Ref.ObjectRef<Message> $referenceMessage;
    final /* synthetic */ String $referenceMessageId;
    Object L$0;
    int label;
    final /* synthetic */ BotReferenceTextBlockHolder this$0;

    /* JADX INFO: renamed from: com.larus.bmhome.chat.standarduikit.botreferencetext.blockadapter.BotReferenceTextBlockHolder$nextChainToHandleRefMsg$1$1, reason: invalid class name */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "com.larus.bmhome.chat.standarduikit.botreferencetext.blockadapter.BotReferenceTextBlockHolder$nextChainToHandleRefMsg$1$1", f = "BotReferenceTextBlockHolder.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    public static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ a $blockModel;
        final /* synthetic */ BotModel $botModel;
        final /* synthetic */ Ref.ObjectRef<Message> $referenceMessage;
        int label;
        final /* synthetic */ BotReferenceTextBlockHolder this$0;

        public AnonymousClass1(BotReferenceTextBlockHolder r1, a r2, BotModel r3, Ref.ObjectRef<Message> r4, Continuation<? super AnonymousClass1> r5) {
            this.this$0 = r1;
            this.$blockModel = r2;
            this.$botModel = r3;
            this.$referenceMessage = r4;
            super(2, r5);
        }

        public final Continuation<Unit> create(Object r7, Continuation<?> r8) {
            return new AnonymousClass1(this.this$0, this.$blockModel, this.$botModel, this.$referenceMessage, r8);
        }

        public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
            return invoke((CoroutineScope) r1, (Continuation) r2);
        }

        public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
            return create(r1, r2).invokeSuspend(Unit.INSTANCE);
        }

        public final Object invokeSuspend(Object r4) {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label != 0) goto L7;
            ResultKt.throwOnFailure(r4);
            this.this$0.l(this.$blockModel, this.$botModel, (Message) this.$referenceMessage.element);
            return Unit.INSTANCE;
        L7:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    public BotReferenceTextBlockHolder$nextChainToHandleRefMsg$1(Ref.ObjectRef<Message> r1, BotReferenceTextBlockHolder r2, String r3, a r4, BotModel r5, Continuation<? super BotReferenceTextBlockHolder$nextChainToHandleRefMsg$1> r6) {
        this.$referenceMessage = r1;
        this.this$0 = r2;
        this.$referenceMessageId = r3;
        this.$blockModel = r4;
        this.$botModel = r5;
        super(2, r6);
    }

    public final Continuation<Unit> create(Object r8, Continuation<?> r9) {
        return new BotReferenceTextBlockHolder$nextChainToHandleRefMsg$1(this.$referenceMessage, this.this$0, this.$referenceMessageId, this.$blockModel, this.$botModel, r9);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r10) {
        Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r1 = this.label;
        if (r1 == 0) goto L10;
        if (r1 == 1) goto L9;
        if (r1 != 2) goto L8;
        ResultKt.throwOnFailure(r10);
    L17:
        return Unit.INSTANCE;
    L8:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L9:
        Ref.ObjectRef<Message> r2 = (Ref.ObjectRef) this.L$0;
        ResultKt.throwOnFailure(r10);
    L13:
        r2.element = r10;
        MainCoroutineDispatcher r11 = Dispatchers.getMain();
        AnonymousClass1 r3 = new AnonymousClass1(this.this$0, this.$blockModel, this.$botModel, this.$referenceMessage, null);
        this.L$0 = null;
        this.label = 2;
        if (BuildersKt.withContext(r11, r3, this) != r0) goto L17;
        return r0;
    L10:
        ResultKt.throwOnFailure(r10);
        r2 = this.$referenceMessage;
        BotReferenceTextBlockHolder r12 = this.this$0;
        String r4 = this.$referenceMessageId;
        this.L$0 = r2;
        this.label = 1;
        r10 = BotReferenceTextBlockHolder.j(r12, r4, this);
        if (r10 != r0) goto L13;
        return r0;
    }
}
