package com.larus.bmhome.chat.model;

import com.larus.bmhome.chat.cell.MessageCellStateTransformerType;
import com.larus.im.callback.IIMCallback;
import com.larus.im.callback.IIMError;
import kotlin.Lazy;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.DebugProbesKt;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineDispatcher;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Dispatchers;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u000b\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = MessageCellStateTransformerType.Z_LOTTERY_GUIDE_CELL)
@DebugMetadata(c = "com.larus.bmhome.chat.model.ConversationListModel$deleteRecommendBot$2", f = "ConversationListModel.kt", i = {0}, l = {1089}, m = "invokeSuspend", n = {"res"}, s = {"L$0"})
final class ConversationListModel$deleteRecommendBot$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Boolean>, Object> {
    final /* synthetic */ String $botId;
    Object L$0;
    int label;

    /* JADX INFO: renamed from: com.larus.bmhome.chat.model.ConversationListModel$deleteRecommendBot$2$1, reason: invalid class name */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = MessageCellStateTransformerType.Z_LOTTERY_GUIDE_CELL)
    @DebugMetadata(c = "com.larus.bmhome.chat.model.ConversationListModel$deleteRecommendBot$2$1", f = "ConversationListModel.kt", i = {}, l = {1549}, m = "invokeSuspend", n = {}, s = {})
    public static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ String $botId;
        final /* synthetic */ Ref.BooleanRef $res;
        Object L$0;
        Object L$1;
        int label;

        /* JADX INFO: renamed from: com.larus.bmhome.chat.model.ConversationListModel$deleteRecommendBot$2$1$a */
        public static final class a implements IIMCallback<Boolean> {
            public final /* synthetic */ kotlinx.coroutines.i<Boolean> a;

            public final boolean mustInMain() {
                return !com.larus.im.internal.delegate.y0.a();
            }

            public a(kotlinx.coroutines.j r1) {
                this.a = r1;
            }

            public final void onFailure(IIMError r2) {
                Intrinsics.checkNotNullParameter(r2, "error");
                kotlinx.coroutines.i<Boolean> r3 = this.a;
                Result.Companion r0 = Result.Companion;
                r3.resumeWith(Result.constructor-impl(Boolean.FALSE));
            }

            public final void onSuccess(Object r2) {
                Boolean r3 = Boolean.valueOf(((Boolean) r2).booleanValue());
                this.a.resumeWith(Result.constructor-impl(r3));
            }
        }

        public AnonymousClass1(Ref.BooleanRef r1, String r2, Continuation<? super AnonymousClass1> r3) {
            this.$res = r1;
            this.$botId = r2;
            super(2, r3);
        }

        public final Continuation<Unit> create(Object r3, Continuation<?> r4) {
            return new AnonymousClass1(this.$res, this.$botId, r4);
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
            if (r1 == 0) goto L8;
            if (r1 != 1) goto L7;
            Ref.BooleanRef r2 = (Ref.BooleanRef) this.L$1;
            String r3 = (String) this.L$0;
            ResultKt.throwOnFailure(r6);
        L14:
            r2.element = ((Boolean) r6).booleanValue();
            return Unit.INSTANCE;
        L7:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L8:
            ResultKt.throwOnFailure(r6);
            Ref.BooleanRef r7 = this.$res;
            String r4 = this.$botId;
            this.L$0 = r4;
            this.L$1 = r7;
            this.label = 1;
            kotlinx.coroutines.j r5 = new kotlinx.coroutines.j(IntrinsicsKt.intercepted(this), 1);
            r5.C();
            com.larus.im.d.a().deleteSelectionBot(r4, new a(r5));
            Object r8 = r5.B();
            if (r8 != IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L11;
            DebugProbesKt.probeCoroutineSuspended(this);
        L11:
            if (r8 != r0) goto L13;
            return r0;
        L13:
            r2 = r7;
            r6 = r8;
            goto L14
        }
    }

    public ConversationListModel$deleteRecommendBot$2(String r1, Continuation<? super ConversationListModel$deleteRecommendBot$2> r2) {
        this.$botId = r1;
        super(2, r2);
    }

    public final Continuation<Unit> create(Object r2, Continuation<?> r3) {
        return new ConversationListModel$deleteRecommendBot$2(this.$botId, r3);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Boolean> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r7) {
        Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r1 = this.label;
        if (r1 == 0) goto L8;
        if (r1 != 1) goto L7;
        Ref.BooleanRef r2 = (Ref.BooleanRef) this.L$0;
        ResultKt.throwOnFailure(r7);
    L13:
        if (r2.element == false) goto L15;
        Lazy r8 = com.larus.im.j.a;
        String r9 = com.larus.im.j.c(this.$botId, null);
        com.larus.bmhome.chat.adapter.p0.a.a(r9);
        ConversationListModel.a.getClass();
        ConversationListModel.o(r9);
        return Boxing.boxBoolean(r2.element);
    L15:
        return Boxing.boxBoolean(false);
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        ResultKt.throwOnFailure(r7);
        Ref.BooleanRef r10 = new Ref.BooleanRef();
        CoroutineDispatcher r3 = Dispatchers.getIO();
        AnonymousClass1 r4 = new AnonymousClass1(r10, this.$botId, null);
        this.L$0 = r10;
        this.label = 1;
        if (BuildersKt.withContext(r3, r4, this) != r0) goto L11;
        return r0;
    L11:
        r2 = r10;
        goto L13
    }
}
