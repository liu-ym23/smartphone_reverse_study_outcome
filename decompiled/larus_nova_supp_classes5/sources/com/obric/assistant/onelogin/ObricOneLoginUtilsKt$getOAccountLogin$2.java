package com.obric.assistant.onelogin;

import com.larus.utils.logger.FLogger;
import com.obric.matrix.platform.sdk.ones.account.OAccount;
import com.obric.matrix.platform.sdk.ones.account.g;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes5.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u000b\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.obric.assistant.onelogin.ObricOneLoginUtilsKt$getOAccountLogin$2", f = "ObricOneLoginUtils.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
final class ObricOneLoginUtilsKt$getOAccountLogin$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Boolean>, Object> {
    int label;

    public ObricOneLoginUtilsKt$getOAccountLogin$2(Continuation<? super ObricOneLoginUtilsKt$getOAccountLogin$2> r2) {
        super(2, r2);
    }

    public final Continuation<Unit> create(Object r1, Continuation<?> r2) {
        return new ObricOneLoginUtilsKt$getOAccountLogin$2(r2);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Boolean> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r4) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) goto L23;
        ResultKt.throwOnFailure(r4);
        OAccount.a.getClass();     // Catch: Exception -> L18
        OAccount.c(true);     // Catch: Exception -> L18
        g r5 = OAccount.d;     // Catch: Exception -> L18
        if (r5 != null) goto L8;
        Intrinsics.throwUninitializedPropertyAccessException("mAccountManager");     // Catch: Exception -> L18
        r5 = null;
    L8:
        monitor-enter(r5);     // Catch: Exception -> L18
    L15:
        th = move-exception;
        throw th;     // Catch: Exception -> L18
    L10:
        if (g.d != null) goto L12;
        r5.f();     // Catch: Throwable -> L15
    L12:
        com.obric.matrix.platform.sdk.ones.account.a r0 = g.d;     // Catch: Throwable -> L15
        Intrinsics.checkNotNull(r0);     // Catch: Throwable -> L15
        monitor-exit(r5);     // Catch: Exception -> L18
        boolean r6 = r0.a;     // Catch: Exception -> L18
    L21:
        return Boxing.boxBoolean(r6);
    L18:
        e = move-exception;
        FLogger.a.e("ObricOneLoginUtils", "getOAccountLogin failed: " + e, e);
        r6 = false;
        goto L21
    L23:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
