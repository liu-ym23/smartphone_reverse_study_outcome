package com.obric.sva.sdk.controller;

import com.obric.eventkit.eventstaskmanager.ITaskManager;
import com.obric.sva.sdk.utils.LogUtils;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CompletableDeferred;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.TimeoutKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes6.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = ITaskManager.Stub.TRANSACTION_getEventTasksByType)
@DebugMetadata(c = "com.obric.sva.sdk.controller.SvaSdkGlobal$init$1$1$1", f = "SvaSdkGlobal.kt", i = {}, l = {152}, m = "invokeSuspend", n = {}, s = {})
public final class SvaSdkGlobal$init$1$1$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ CompletableDeferred<Integer> $configDeferred;
    final /* synthetic */ Function1<String, Unit> $effectInitedTask;
    final /* synthetic */ String $tag;
    int label;

    /* JADX INFO: renamed from: com.obric.sva.sdk.controller.SvaSdkGlobal$init$1$1$1$1, reason: invalid class name */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\b\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = ITaskManager.Stub.TRANSACTION_getEventTasksByType)
    @DebugMetadata(c = "com.obric.sva.sdk.controller.SvaSdkGlobal$init$1$1$1$1", f = "SvaSdkGlobal.kt", i = {}, l = {153}, m = "invokeSuspend", n = {}, s = {})
    public static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Integer>, Object> {
        final /* synthetic */ CompletableDeferred<Integer> $configDeferred;
        int label;

        public AnonymousClass1(CompletableDeferred<Integer> r1, Continuation<? super AnonymousClass1> r2) {
            this.$configDeferred = r1;
            super(2, r2);
        }

        public final Continuation<Unit> create(Object r2, Continuation<?> r3) {
            return new AnonymousClass1(this.$configDeferred, r3);
        }

        public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
            return invoke((CoroutineScope) r1, (Continuation) r2);
        }

        public final Object invoke(CoroutineScope r1, Continuation<? super Integer> r2) {
            return create(r1, r2).invokeSuspend(Unit.INSTANCE);
        }

        public final Object invokeSuspend(Object r4) {
            Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int r1 = this.label;
            if (r1 == 0) goto L8;
            if (r1 != 1) goto L7;
            ResultKt.throwOnFailure(r4);
        L11:
            return r4;
        L7:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L8:
            ResultKt.throwOnFailure(r4);
            CompletableDeferred<Integer> r5 = this.$configDeferred;
            this.label = 1;
            r4 = r5.await(this);
            if (r4 != r0) goto L11;
            return r0;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public SvaSdkGlobal$init$1$1$1(Function1<? super String, Unit> r1, String r2, CompletableDeferred<Integer> r3, Continuation<? super SvaSdkGlobal$init$1$1$1> r4) {
        this.$effectInitedTask = r1;
        this.$tag = r2;
        this.$configDeferred = r3;
        super(2, r4);
    }

    public final Continuation<Unit> create(Object r4, Continuation<?> r5) {
        return new SvaSdkGlobal$init$1$1$1(this.$effectInitedTask, this.$tag, this.$configDeferred, r5);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r7) {
        Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r1 = this.label;
        if (r1 == 0) goto L8;
        if (r1 != 1) goto L7;
        ResultKt.throwOnFailure(r7);
    L11:
        LogUtils.d(SvaSdkGlobal.TAG, "initEffectPlatformProvider wait done", new Object[0]);
        this.$effectInitedTask.invoke(this.$tag);
        return Unit.INSTANCE;
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        ResultKt.throwOnFailure(r7);
        LogUtils.d(SvaSdkGlobal.TAG, "initEffectPlatformProvider wait 5secs for the config inited", new Object[0]);
        AnonymousClass1 r8 = new AnonymousClass1(this.$configDeferred, null);
        this.label = 1;
        if (TimeoutKt.c(5000, r8, this) != r0) goto L11;
        return r0;
    }
}
