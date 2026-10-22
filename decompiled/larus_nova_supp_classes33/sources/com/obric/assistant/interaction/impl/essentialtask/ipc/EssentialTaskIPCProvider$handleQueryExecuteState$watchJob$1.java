package com.obric.assistant.interaction.impl.essentialtask.ipc;

import android.os.Message;
import android.os.Messenger;
import com.larus.utils.logger.FLogger;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.flow.e;
import kotlinx.coroutines.flow.i1;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.obric.assistant.interaction.impl.essentialtask.ipc.EssentialTaskIPCProvider$handleQueryExecuteState$watchJob$1", f = "EssentialTaskIPCProvider.kt", i = {0}, l = {100}, m = "invokeSuspend", n = {"$this$launch"}, s = {"L$0"})
public final class EssentialTaskIPCProvider$handleQueryExecuteState$watchJob$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ int $callingPid;
    final /* synthetic */ String $callingProcessName;
    final /* synthetic */ i1<Boolean> $isExecuteSucceedState;
    final /* synthetic */ Messenger $messenger;
    private /* synthetic */ Object L$0;
    int label;

    /* JADX INFO: renamed from: com.obric.assistant.interaction.impl.essentialtask.ipc.EssentialTaskIPCProvider$handleQueryExecuteState$watchJob$1$1, reason: invalid class name */
    @Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u000b\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0001H\n"}, d2 = {"<anonymous>", "", "it"}, k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "com.obric.assistant.interaction.impl.essentialtask.ipc.EssentialTaskIPCProvider$handleQueryExecuteState$watchJob$1$1", f = "EssentialTaskIPCProvider.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    public static final class AnonymousClass1 extends SuspendLambda implements Function2<Boolean, Continuation<? super Boolean>, Object> {
        /* synthetic */ boolean Z$0;
        int label;

        public AnonymousClass1(Continuation<? super AnonymousClass1> r2) {
            super(2, r2);
        }

        public final Continuation<Unit> create(Object r2, Continuation<?> r3) {
            AnonymousClass1 r0 = new AnonymousClass1(r3);
            r0.Z$0 = ((Boolean) r2).booleanValue();
            return r0;
        }

        public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
            return invoke(((Boolean) r1).booleanValue(), (Continuation) r2);
        }

        public final Object invoke(boolean r1, Continuation<? super Boolean> r2) {
            return create(Boolean.valueOf(r1), r2).invokeSuspend(Unit.INSTANCE);
        }

        public final Object invokeSuspend(Object r2) {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label != 0) goto L7;
            ResultKt.throwOnFailure(r2);
            return Boxing.boxBoolean(this.Z$0);
        L7:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    public EssentialTaskIPCProvider$handleQueryExecuteState$watchJob$1(i1<Boolean> r1, Messenger r2, int r3, String r4, Continuation<? super EssentialTaskIPCProvider$handleQueryExecuteState$watchJob$1> r5) {
        this.$isExecuteSucceedState = r1;
        this.$messenger = r2;
        this.$callingPid = r3;
        this.$callingProcessName = r4;
        super(2, r5);
    }

    public final Continuation<Unit> create(Object r8, Continuation<?> r9) {
        EssentialTaskIPCProvider$handleQueryExecuteState$watchJob$1 r6 = new EssentialTaskIPCProvider$handleQueryExecuteState$watchJob$1(this.$isExecuteSucceedState, this.$messenger, this.$callingPid, this.$callingProcessName, r9);
        r6.L$0 = r8;
        return r6;
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
        if (r1 == 0) goto L8;
        if (r1 != 1) goto L7;
        CoroutineScope r2 = (CoroutineScope) this.L$0;
        ResultKt.throwOnFailure(r8);
    L11:
        FLogger.a.i("EssentialTaskIPCProvider", "is succeed");
        Messenger r9 = this.$messenger;
        Result.Companion r3 = Result.Companion;     // Catch: Throwable -> L14
        r9.send(Message.obtain(null, 1));     // Catch: Throwable -> L14
        Object r10 = Result.constructor-impl(Unit.INSTANCE);     // Catch: Throwable -> L14
    L16:
        int r4 = this.$callingPid;
        String r5 = this.$callingProcessName;
        Throwable r6 = Result.exceptionOrNull-impl(r10);
        if (r6 == null) goto L20;
        FLogger.a.e("EssentialTaskIPCProvider", "send message failed. target pid = " + r4 + ", target process name = " + r5 + ", errorMsg = " + r6.getMessage(), r6);
    L20:
        if (Result.isSuccess-impl(r10) == false) goto L23;
        Unit r11 = (Unit) r10;
        FLogger.a.i("EssentialTaskIPCProvider", "send message success");
    L23:
        return Unit.INSTANCE;
    L14:
        th = move-exception;
        Result.Companion r7 = Result.Companion;
        r10 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L16
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        ResultKt.throwOnFailure(r8);
        CoroutineScope r12 = (CoroutineScope) this.L$0;
        FLogger.a.i("EssentialTaskIPCProvider", "will wait until succeed");
        i1<Boolean> r13 = this.$isExecuteSucceedState;
        AnonymousClass1 r14 = new AnonymousClass1(null);
        this.L$0 = r12;
        this.label = 1;
        if (e.t(r13, r14, this) != r0) goto L11;
        return r0;
    }
}
