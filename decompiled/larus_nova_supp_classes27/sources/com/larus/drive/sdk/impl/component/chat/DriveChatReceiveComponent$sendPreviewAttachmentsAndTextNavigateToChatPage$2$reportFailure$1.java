package com.larus.drive.sdk.impl.component.chat;

import android.content.Context;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Ref;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.MainCoroutineDispatcher;
import t19.s;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
@Metadata(d1 = {"\u0000\u0006\n\u0000\n\u0002\u0010\u0002\u0010\u0000\u001a\u00020\u0001H\n"}, d2 = {"<anonymous>", ""}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.larus.drive.sdk.impl.component.chat.DriveChatReceiveComponent$sendPreviewAttachmentsAndTextNavigateToChatPage$2$reportFailure$1", f = "DriveChatReceiveComponent.kt", i = {}, l = {366}, m = "invokeSuspend", n = {}, s = {})
public final class DriveChatReceiveComponent$sendPreviewAttachmentsAndTextNavigateToChatPage$2$reportFailure$1 extends SuspendLambda implements Function1<Continuation<? super Unit>, Object> {
    final /* synthetic */ Context $applicationContext;
    final /* synthetic */ Function1<Boolean, Unit> $onResult;
    final /* synthetic */ Function0<Boolean> $shouldContinue;
    final /* synthetic */ Ref.BooleanRef $terminalReported;
    int label;

    /* JADX INFO: renamed from: com.larus.drive.sdk.impl.component.chat.DriveChatReceiveComponent$sendPreviewAttachmentsAndTextNavigateToChatPage$2$reportFailure$1$1, reason: invalid class name */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "com.larus.drive.sdk.impl.component.chat.DriveChatReceiveComponent$sendPreviewAttachmentsAndTextNavigateToChatPage$2$reportFailure$1$1", f = "DriveChatReceiveComponent.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    public static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ Context $applicationContext;
        final /* synthetic */ Function1<Boolean, Unit> $onResult;
        int label;

        /* JADX WARN: Multi-variable type inference failed */
        public AnonymousClass1(Context r1, Function1<? super Boolean, Unit> r2, Continuation<? super AnonymousClass1> r3) {
            this.$applicationContext = r1;
            this.$onResult = r2;
            super(2, r3);
        }

        public final Continuation<Unit> create(Object r3, Continuation<?> r4) {
            return new AnonymousClass1(this.$applicationContext, this.$onResult, r4);
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
            s r4 = s.a;
            Context r0 = this.$applicationContext;
            r4.getClass();
            s.b(r0, 2131900799, false);
            this.$onResult.invoke(Boxing.boxBoolean(false));
            return Unit.INSTANCE;
        L7:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public DriveChatReceiveComponent$sendPreviewAttachmentsAndTextNavigateToChatPage$2$reportFailure$1(Ref.BooleanRef r1, Function0<Boolean> r2, Context r3, Function1<? super Boolean, Unit> r4, Continuation<? super DriveChatReceiveComponent$sendPreviewAttachmentsAndTextNavigateToChatPage$2$reportFailure$1> r5) {
        this.$terminalReported = r1;
        this.$shouldContinue = r2;
        this.$applicationContext = r3;
        this.$onResult = r4;
        super(1, r5);
    }

    public final Continuation<Unit> create(Continuation<?> r8) {
        return new DriveChatReceiveComponent$sendPreviewAttachmentsAndTextNavigateToChatPage$2$reportFailure$1(this.$terminalReported, this.$shouldContinue, this.$applicationContext, this.$onResult, r8);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1) {
        return invoke((Continuation) r1);
    }

    public final Object invoke(Continuation<? super Unit> r2) {
        return create(r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r7) {
        Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r1 = this.label;
        if (r1 == 0) goto L8;
        if (r1 != 1) goto L7;
        ResultKt.throwOnFailure(r7);
    L16:
        return Unit.INSTANCE;
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        ResultKt.throwOnFailure(r7);
        if (this.$terminalReported.element == true) goto L16;
        if (((Boolean) this.$shouldContinue.invoke()).booleanValue() == false) goto L16;
        this.$terminalReported.element = true;
        MainCoroutineDispatcher r8 = Dispatchers.getMain();
        AnonymousClass1 r2 = new AnonymousClass1(this.$applicationContext, this.$onResult, null);
        this.label = 1;
        if (BuildersKt.withContext(r8, r2, this) != r0) goto L16;
        return r0;
    }
}
