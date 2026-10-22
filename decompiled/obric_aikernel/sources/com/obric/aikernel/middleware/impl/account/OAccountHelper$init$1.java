package com.obric.aikernel.middleware.impl.account;

import a9.d;
import android.app.Application;
import com.obric.aikernel.middleware.api.log.AIKLog;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.DelayKt;
import kotlinx.coroutines.l0;

/* JADX INFO: loaded from: classes2.dex */
@DebugMetadata(c = "com.obric.aikernel.middleware.impl.account.OAccountHelper$init$1", f = "OAccountHelper.kt", i = {0}, l = {52}, m = "invokeSuspend", n = {"deadSystemRetryCount"}, s = {"I$0"})
final class OAccountHelper$init$1 extends SuspendLambda implements Function2<l0, Continuation<? super Unit>, Object> {
    final /* synthetic */ Application $application;
    final /* synthetic */ a9.a $bridge;
    final /* synthetic */ d $logger;
    int I$0;
    int label;

    OAccountHelper$init$1(Application r10, d r11, a9.a r12, Continuation<? super OAccountHelper$init$1> r13) {
        this.$application = r10;
        this.$logger = r11;
        this.$bridge = r12;
        super(2, r13);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object r10, Continuation<?> r11) {
        return new OAccountHelper$init$1(this.$application, this.$logger, this.$bridge, r11);
    }

    @Override // kotlin.jvm.functions.Function2
    public /* bridge */ /* synthetic */ Object invoke(l0 r10, Continuation<? super Unit> r11) {
        return invoke2(r10, r11);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final Object invoke2(l0 r10, Continuation<? super Unit> r11) {
        return ((OAccountHelper$init$1) create(r10, r11)).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:24:0x0087 -> B:7:0x0013). Please report as a decompilation issue!!! */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r10) {
        Object r11 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r12 = this.label;
        if (r12 == 0) goto L14;
        if (r12 != 1) goto L13;
        int r13 = this.I$0;
        ResultKt.throwOnFailure(r10);     // Catch: Throwable -> L8 Exception -> L10
    L7:
        int r14 = r13;
    L16:
        if (OAccountHelper.c() == true) goto L27;
        OAccountHelper r15 = OAccountHelper.f4551a;     // Catch: Throwable -> L8 Exception -> L10
        if (OAccountHelper.b(r15, this.$application, this.$logger, this.$bridge) == false) goto L21;
        OAccountHelper.d(true);     // Catch: Throwable -> L8 Exception -> L10
        goto L16
    L21:
        if (OAccountHelper.e(r15, r14) == true) goto L23;
        AIKLog.INSTANCE.w("OAccountHelper", "init stopped after " + r14 + " dead system retries.");     // Catch: Throwable -> L8 Exception -> L10
    L23:
        r13 = r14 + 1;     // Catch: Throwable -> L8 Exception -> L10
        AIKLog.INSTANCE.w("OAccountHelper", "init retry " + r13 + "/10 scheduled after dead system fallback.");     // Catch: Throwable -> L8 Exception -> L10
        this.I$0 = r13;     // Catch: Throwable -> L8 Exception -> L10
        this.label = 1;     // Catch: Throwable -> L8 Exception -> L10
        if (DelayKt.b(5000, this) != r11) goto L7;
        return r11;
    L27:
        OAccountHelper.a().set(false);
        return Unit.INSTANCE;
    L10:
        e = move-exception;
        AIKLog.INSTANCE.e("OAccountHelper", "init failed unexpectedly, stop retrying", e);     // Catch: Throwable -> L8
        goto L27
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        ResultKt.throwOnFailure(r10);
        r14 = 0;
    L8:
        th = move-exception;
        OAccountHelper.a().set(false);
        throw th;
    }
}
