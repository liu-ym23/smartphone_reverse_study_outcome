package com.obric.assistant.interaction.impl;

import android.content.Intent;
import com.larus.utils.logger.FLogger;
import com.obric.assistant.interaction.api.service.CheckActivityAuthenticationCallback;
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
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.obric.assistant.interaction.impl.ObricShowOnLockedServiceImpl$checkActivityAuthenticationOnLockAsync$1", f = "ObricShowOnLockedServiceImpl.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
public final class ObricShowOnLockedServiceImpl$checkActivityAuthenticationOnLockAsync$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ Intent $activityIntent;
    final /* synthetic */ CheckActivityAuthenticationCallback $callback;
    int label;
    final /* synthetic */ ObricShowOnLockedServiceImpl this$0;

    /* JADX INFO: renamed from: com.obric.assistant.interaction.impl.ObricShowOnLockedServiceImpl$checkActivityAuthenticationOnLockAsync$1$1, reason: invalid class name */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "com.obric.assistant.interaction.impl.ObricShowOnLockedServiceImpl$checkActivityAuthenticationOnLockAsync$1$1", f = "ObricShowOnLockedServiceImpl.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    public static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ CheckActivityAuthenticationCallback $callback;
        final /* synthetic */ boolean $result;
        int label;

        public AnonymousClass1(CheckActivityAuthenticationCallback r1, boolean r2, Continuation<? super AnonymousClass1> r3) {
            this.$callback = r1;
            this.$result = r2;
            super(2, r3);
        }

        public final Continuation<Unit> create(Object r3, Continuation<?> r4) {
            return new AnonymousClass1(this.$callback, this.$result, r4);
        }

        public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
            return invoke((CoroutineScope) r1, (Continuation) r2);
        }

        public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
            return create(r1, r2).invokeSuspend(Unit.INSTANCE);
        }

        public final Object invokeSuspend(Object r2) {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label != 0) goto L7;
            ResultKt.throwOnFailure(r2);
            this.$callback.onResult(this.$result);
            return Unit.INSTANCE;
        L7:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    public ObricShowOnLockedServiceImpl$checkActivityAuthenticationOnLockAsync$1(ObricShowOnLockedServiceImpl r1, Intent r2, CheckActivityAuthenticationCallback r3, Continuation<? super ObricShowOnLockedServiceImpl$checkActivityAuthenticationOnLockAsync$1> r4) {
        this.this$0 = r1;
        this.$activityIntent = r2;
        this.$callback = r3;
        super(2, r4);
    }

    public final Continuation<Unit> create(Object r4, Continuation<?> r5) {
        return new ObricShowOnLockedServiceImpl$checkActivityAuthenticationOnLockAsync$1(this.this$0, this.$activityIntent, this.$callback, r5);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r8) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) goto L18;
        ResultKt.throwOnFailure(r8);
        ObricShowOnLockedServiceImpl r9 = this.this$0;
        Intent r1 = this.$activityIntent;
        Result.Companion r2 = Result.Companion;     // Catch: Throwable -> L7
        FLogger.a.i("ObricShowOnLockedServiceImpl", "checkActivityAuthenticationOnLockAsync: start");     // Catch: Throwable -> L7
        Object r10 = Result.constructor-impl(Boxing.boxBoolean(ObricShowOnLockedServiceImpl.access$computeCheckActivityAuthenticationOnLock(r9, r1)));     // Catch: Throwable -> L7
    L9:
        Throwable r3 = Result.exceptionOrNull-impl(r10);
        if (r3 == null) goto L12;
        FLogger.a.w("ObricShowOnLockedServiceImpl", "checkActivityAuthenticationOnLockAsync: failed " + r3.getMessage(), r3);
    L12:
        Boolean r0 = Boxing.boxBoolean(false);
        if (Result.isFailure-impl(r10) == false) goto L15;
        r10 = r0;
    L15:
        BuildersKt.launch$default(ObricShowOnLockedServiceImpl.access$getMainScope$p(this.this$0), null, null, new AnonymousClass1(this.$callback, ((Boolean) r10).booleanValue(), null), 3, null);
        return Unit.INSTANCE;
    L7:
        th = move-exception;
        Result.Companion r4 = Result.Companion;
        r10 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L9
    L18:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
