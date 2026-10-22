package com.obric.assistant.security.provision.check.impl;

import android.content.ComponentName;
import android.content.Context;
import android.os.Bundle;
import android.os.IBinder;
import com.bytedance.securityserver.provision.ISecurityProvisionService;
import com.larus.utils.logger.FLogger;
import com.obric.assistant.security.provision.check.bean.ProvisionResult;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.i;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.obric.assistant.security.provision.check.impl.SecurityProvisionCheckerImpl$startKeyProvision$2$serviceConnection$1$onServiceConnected$1$1", f = "SecurityProvisionCheckerImpl.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
public final class SecurityProvisionCheckerImpl$startKeyProvision$2$serviceConnection$1$onServiceConnected$1$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ SecurityProvisionCheckerImpl$startKeyProvision$2$serviceConnection$1 $connection;
    final /* synthetic */ Context $context;
    final /* synthetic */ i<ProvisionResult> $continuation;
    final /* synthetic */ Bundle $extras;
    final /* synthetic */ AtomicBoolean $isContinuationResumed;
    final /* synthetic */ AtomicBoolean $isServiceBound;
    final /* synthetic */ ComponentName $name;
    final /* synthetic */ IBinder $service;
    int label;
    final /* synthetic */ SecurityProvisionCheckerImpl this$0;

    /* JADX WARN: Multi-variable type inference failed */
    public SecurityProvisionCheckerImpl$startKeyProvision$2$serviceConnection$1$onServiceConnected$1$1(ComponentName r1, IBinder r2, SecurityProvisionCheckerImpl r3, i<? super ProvisionResult> r4, AtomicBoolean r5, Bundle r6, Context r7, SecurityProvisionCheckerImpl$startKeyProvision$2$serviceConnection$1 r8, AtomicBoolean r9, Continuation<? super SecurityProvisionCheckerImpl$startKeyProvision$2$serviceConnection$1$onServiceConnected$1$1> r10) {
        this.$name = r1;
        this.$service = r2;
        this.this$0 = r3;
        this.$continuation = r4;
        this.$isContinuationResumed = r5;
        this.$extras = r6;
        this.$context = r7;
        this.$connection = r8;
        this.$isServiceBound = r9;
        super(2, r10);
    }

    public final Continuation<Unit> create(Object r12, Continuation<?> r13) {
        return new SecurityProvisionCheckerImpl$startKeyProvision$2$serviceConnection$1$onServiceConnected$1$1(this.$name, this.$service, this.this$0, this.$continuation, this.$isContinuationResumed, this.$extras, this.$context, this.$connection, this.$isServiceBound, r13);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r10) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) goto L40;
        ResultKt.throwOnFailure(r10);
        boolean r11 = true;
        FLogger r6 = FLogger.a;     // Catch: Throwable -> L13
        r6.d("SecurityProvisionCheckerImpl", "startKeyProvision: service connected, name=" + this.$name);     // Catch: Throwable -> L13
        IBinder r3 = this.$service;     // Catch: Throwable -> L13
        if (r3 == null) goto L8;
        ISecurityProvisionService r4 = ISecurityProvisionService.Stub.asInterface(r3);     // Catch: Throwable -> L13
    L9:
        if (r4 != null) goto L15;
        SecurityProvisionCheckerImpl.c(this.this$0, this.$continuation, "Service interface is null", 1003, this.$isContinuationResumed);     // Catch: Throwable -> L13
        Unit r12 = Unit.INSTANCE;     // Catch: Throwable -> L13
        SecurityProvisionCheckerImpl.d(this.this$0, this.$context, this.$connection, this.$isServiceBound);
        return r12;
    L15:
        Bundle r5 = r4.startKeyProvision(this.$extras);     // Catch: Throwable -> L13
        StringBuilder r7 = new StringBuilder("Provision Result: ");     // Catch: Throwable -> L13
        int r2 = xfa.a.a;     // Catch: Throwable -> L13
        Intrinsics.checkNotNull(r5);     // Catch: Throwable -> L13
        Intrinsics.checkNotNullParameter(r5, "bundle");     // Catch: Throwable -> L13
        Result.Companion r8 = Result.Companion;     // Catch: Throwable -> L18
        String r9 = xfa.a.b(r5, 0);     // Catch: Throwable -> L18
    L20:
        r7.append(r9);     // Catch: Throwable -> L13
        r6.d("SecurityProvisionCheckerImpl", r7.toString());     // Catch: Throwable -> L13
        ProvisionResult.Companion.getClass();     // Catch: Throwable -> L13
        ProvisionResult r13 = ProvisionResult.a.a(r5);     // Catch: Throwable -> L13
        if (this.$isContinuationResumed.compareAndSet(false, true) == false) goto L34;
        this.$continuation.resumeWith(Result.constructor-impl(r13));     // Catch: Throwable -> L13
    L34:
        SecurityProvisionCheckerImpl.d(this.this$0, this.$context, this.$connection, this.$isServiceBound);
        return Unit.INSTANCE;
    L18:
        th = move-exception;
        Result.Companion r14 = Result.Companion;     // Catch: Throwable -> L13
        Result.constructor-impl(ResultKt.createFailure(th));     // Catch: Throwable -> L13
        r9 = "";
        goto L20
    L8:
        r4 = null;
    L13:
        th = move-exception;
        FLogger.a.e("SecurityProvisionCheckerImpl", "Provision Failed: " + th.getMessage(), th);     // Catch: Throwable -> L36
        String r0 = th.getMessage();     // Catch: Throwable -> L36
        if (r0 != null) goto L27;
    L30:
        if (r11 == false) goto L32;
        String r15 = th.getClass().getSimpleName();     // Catch: Throwable -> L36
    L33:
        SecurityProvisionCheckerImpl.c(this.this$0, this.$continuation, "Provision Failed: " + r15, 1003, this.$isContinuationResumed);     // Catch: Throwable -> L36
        goto L34
    L32:
        r15 = th.getMessage();     // Catch: Throwable -> L36
        goto L33
    L27:
        if (r0.length() == 0) goto L30;
        r11 = false;
    L36:
        th = move-exception;
        SecurityProvisionCheckerImpl.d(this.this$0, this.$context, this.$connection, this.$isServiceBound);
        throw th;
    L40:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
