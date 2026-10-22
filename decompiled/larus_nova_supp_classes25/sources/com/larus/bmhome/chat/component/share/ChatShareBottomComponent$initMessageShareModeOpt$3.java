package com.larus.bmhome.chat.component.share;

import com.bytedance.services.apm.api.EnsureManager;
import com.larus.bmhome.chat.cell.MessageCellStateTransformerType;
import com.larus.platform.service.z2;
import com.larus.utils.logger.FLogger;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CompletableDeferred;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.MainCoroutineDispatcher;
import kotlinx.coroutines.TimeoutKt;
import wr8.d;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = MessageCellStateTransformerType.Z_LOTTERY_GUIDE_CELL)
@DebugMetadata(c = "com.larus.bmhome.chat.component.share.ChatShareBottomComponent$initMessageShareModeOpt$3", f = "ChatShareBottomComponent.kt", i = {}, l = {480, 497}, m = "invokeSuspend", n = {}, s = {})
final class ChatShareBottomComponent$initMessageShareModeOpt$3 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    int label;
    final /* synthetic */ ChatShareBottomComponent this$0;

    /* JADX INFO: renamed from: com.larus.bmhome.chat.component.share.ChatShareBottomComponent$initMessageShareModeOpt$3$1, reason: invalid class name */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = MessageCellStateTransformerType.Z_LOTTERY_GUIDE_CELL)
    @DebugMetadata(c = "com.larus.bmhome.chat.component.share.ChatShareBottomComponent$initMessageShareModeOpt$3$1", f = "ChatShareBottomComponent.kt", i = {}, l = {481, 482}, m = "invokeSuspend", n = {}, s = {})
    public static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        int label;
        final /* synthetic */ ChatShareBottomComponent this$0;

        /* JADX INFO: renamed from: com.larus.bmhome.chat.component.share.ChatShareBottomComponent$initMessageShareModeOpt$3$1$1, reason: invalid class name and collision with other inner class name */
        @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = MessageCellStateTransformerType.Z_LOTTERY_GUIDE_CELL)
        @DebugMetadata(c = "com.larus.bmhome.chat.component.share.ChatShareBottomComponent$initMessageShareModeOpt$3$1$1", f = "ChatShareBottomComponent.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
        public static final class C00581 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
            private /* synthetic */ Object L$0;
            int label;
            final /* synthetic */ ChatShareBottomComponent this$0;

            public C00581(ChatShareBottomComponent r1, Continuation<? super C00581> r2) {
                this.this$0 = r1;
                super(2, r2);
            }

            public final Continuation<Unit> create(Object r3, Continuation<?> r4) {
                C00581 r0 = new C00581(this.this$0, r4);
                r0.L$0 = r3;
                return r0;
            }

            public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
                return invoke((CoroutineScope) r1, (Continuation) r2);
            }

            public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
                return create(r1, r2).invokeSuspend(Unit.INSTANCE);
            }

            public final Object invokeSuspend(Object r4) {
                IntrinsicsKt.getCOROUTINE_SUSPENDED();
                if (this.label != 0) goto L20;
                ResultKt.throwOnFailure(r4);
                CoroutineScope r5 = (CoroutineScope) this.L$0;
                FLogger r6 = FLogger.a;
                r6.d("ChatShareBottomComponent", "延迟后，开始初始化分享按钮相关的东西");
                ChatShareBottomComponent r0 = this.this$0;
                Result.Companion r2 = Result.Companion;     // Catch: Throwable -> L11
                if (s1a.a.c(r0).getView() == null) goto L8;
                int r7 = ChatShareBottomComponent.R;     // Catch: Throwable -> L11
                r0.i4();     // Catch: Throwable -> L11
            L9:
                Object r8 = Result.constructor-impl(Unit.INSTANCE);     // Catch: Throwable -> L11
            L13:
                Throwable r9 = Result.exceptionOrNull-impl(r8);
                if (r9 == null) goto L18;
                EnsureManager.ensureNotReachHere("initMessageShareMode err! msg=" + r9.getMessage());
            L18:
                return Unit.INSTANCE;
            L8:
                r6.e("ChatShareBottomComponent", "provider.fragment().view is null! stop init");     // Catch: Throwable -> L11
            L11:
                th = move-exception;
                Result.Companion r1 = Result.Companion;
                r8 = Result.constructor-impl(ResultKt.createFailure(th));
                goto L13
            L20:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
        }

        public AnonymousClass1(ChatShareBottomComponent r1, Continuation<? super AnonymousClass1> r2) {
            this.this$0 = r1;
            super(2, r2);
        }

        public final Continuation<Unit> create(Object r2, Continuation<?> r3) {
            return new AnonymousClass1(this.this$0, r3);
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
            if (r1 == 0) goto L10;
            if (r1 == 1) goto L9;
            if (r1 != 2) goto L8;
            ResultKt.throwOnFailure(r6);
        L20:
            return Unit.INSTANCE;
        L8:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L9:
            ResultKt.throwOnFailure(r6);
        L15:
            Boolean r7 = (Boolean) r6;
        L16:
            MainCoroutineDispatcher r8 = Dispatchers.getMain();
            C00581 r2 = new C00581(this.this$0, null);
            this.label = 2;
            if (BuildersKt.withContext(r8, r2, this) != r0) goto L20;
            return r0;
        L10:
            ResultKt.throwOnFailure(r6);
            CompletableDeferred r9 = d.a;
            CompletableDeferred r10 = d.a;
            if (r10 == null) goto L16;
            this.label = 1;
            r6 = r10.await(this);
            if (r6 != r0) goto L15;
            return r0;
        }
    }

    /* JADX INFO: renamed from: com.larus.bmhome.chat.component.share.ChatShareBottomComponent$initMessageShareModeOpt$3$2, reason: invalid class name */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = MessageCellStateTransformerType.Z_LOTTERY_GUIDE_CELL)
    @DebugMetadata(c = "com.larus.bmhome.chat.component.share.ChatShareBottomComponent$initMessageShareModeOpt$3$2", f = "ChatShareBottomComponent.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    public static final class AnonymousClass2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        int label;
        final /* synthetic */ ChatShareBottomComponent this$0;

        public AnonymousClass2(ChatShareBottomComponent r1, Continuation<? super AnonymousClass2> r2) {
            this.this$0 = r1;
            super(2, r2);
        }

        public final Continuation<Unit> create(Object r2, Continuation<?> r3) {
            return new AnonymousClass2(this.this$0, r3);
        }

        public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
            return invoke((CoroutineScope) r1, (Continuation) r2);
        }

        public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
            return create(r1, r2).invokeSuspend(Unit.INSTANCE);
        }

        public final Object invokeSuspend(Object r3) {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label != 0) goto L11;
            ResultKt.throwOnFailure(r3);
            if (s1a.a.c(this.this$0).getView() == null) goto L7;
            ChatShareBottomComponent r4 = this.this$0;
            int r0 = ChatShareBottomComponent.R;
            r4.i4();
        L9:
            return Unit.INSTANCE;
        L7:
            FLogger.a.e("ChatShareBottomComponent", "provider.fragment().view is null! stop init");
            goto L9
        L11:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    public ChatShareBottomComponent$initMessageShareModeOpt$3(ChatShareBottomComponent r1, Continuation<? super ChatShareBottomComponent$initMessageShareModeOpt$3> r2) {
        this.this$0 = r1;
        super(2, r2);
    }

    public final Continuation<Unit> create(Object r2, Continuation<?> r3) {
        return new ChatShareBottomComponent$initMessageShareModeOpt$3(this.this$0, r3);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r9) {
        Object r1 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r2 = this.label;
        if (r2 == 0) goto L16;
        if (r2 == 1) goto L12;
        if (r2 != 2) goto L11;
        ResultKt.throwOnFailure(r9);     // Catch: Throwable -> L8
    L20:
        this.this$0.o = null;
        return Unit.INSTANCE;
    L11:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L12:
        ResultKt.throwOnFailure(r9);     // Catch: Throwable -> L14
    L28:
    L16:
        ResultKt.throwOnFailure(r9);
        long r6 = z2.a.getAppLaunchFeedOptConfig().b;     // Catch: Throwable -> L14
        AnonymousClass1 r10 = new AnonymousClass1(this.this$0, null);     // Catch: Throwable -> L14
        this.label = 1;     // Catch: Throwable -> L14
        if (TimeoutKt.b(r6, r10, this) != r1) goto L28;
        return r1;
    L14:
        th = move-exception;
        FLogger.a.e("ChatShareBottomComponent", "delay init message share model err! msg=" + th.getMessage());     // Catch: Throwable -> L8
        MainCoroutineDispatcher r11 = Dispatchers.getMain();     // Catch: Throwable -> L8
        AnonymousClass2 r0 = new AnonymousClass2(this.this$0, null);     // Catch: Throwable -> L8
        this.label = 2;     // Catch: Throwable -> L8
        if (BuildersKt.withContext(r11, r0, this) != r1) goto L20;
        return r1;
    L8:
        th = move-exception;
        this.this$0.o = null;
        throw th;
    }
}
