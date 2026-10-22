package com.obric.aiagent.assistant.utils;

import android.content.Context;
import android.database.Cursor;
import android.os.CancellationSignal;
import android.os.OperationCanceledException;
import com.obric.aivoice.core.data.NameKeys;
import java.util.Objects;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CompletableDeferred;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", NameKeys.UnloadStrategy_No_Strategy, "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.obric.aiagent.assistant.utils.ObricAppStatusUtility$checkApprovalAsync$result$1$1", f = "ObricAppStatusUtility.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
public final class ObricAppStatusUtility$checkApprovalAsync$result$1$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ CancellationSignal $cancellationSignal;
    final /* synthetic */ Context $context;
    final /* synthetic */ CompletableDeferred<PrivacyApprovalStatus> $deferred;
    int label;

    public ObricAppStatusUtility$checkApprovalAsync$result$1$1(Context r1, CancellationSignal r2, CompletableDeferred<PrivacyApprovalStatus> r3, Continuation<? super ObricAppStatusUtility$checkApprovalAsync$result$1$1> r4) {
        this.$context = r1;
        this.$cancellationSignal = r2;
        this.$deferred = r3;
        super(2, r4);
    }

    public final Continuation<Unit> create(Object r4, Continuation<?> r5) {
        return new ObricAppStatusUtility$checkApprovalAsync$result$1$1(this.$context, this.$cancellationSignal, this.$deferred, r5);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r11) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) goto L41;
        ResultKt.throwOnFailure(r11);
        b r12 = b.a;
        Context r0 = this.$context;
        CancellationSignal r1 = this.$cancellationSignal;
        r12.getClass();
        Intrinsics.checkNotNullParameter(r0, "context");
        long r2 = System.currentTimeMillis();
        b.a r13 = b.f;
        long r4 = r13.b;
        Cursor r8 = null;
        if ((r2 - r4) < 5000) goto L7;
    L9:
        r13 = null;
    L42:
        if (r13 == null) goto L43;
        PrivacyApprovalStatus r14 = r13.a;
    L35:
        this.$deferred.complete(r14);
        return Unit.INSTANCE;
    L43:
        r8 = b.b(r0.getContentResolver(), b.c, new String[]{"value"}, r1);     // Catch: Throwable -> L24 Exception -> L26 OperationCanceledException -> L30
        if (r8 != null) goto L15;
    L20:
        PrivacyApprovalStatus r15 = PrivacyApprovalStatus.CannotObtain;     // Catch: Throwable -> L24 Exception -> L26 OperationCanceledException -> L30
    L21:
        Objects.toString(r15);     // Catch: Throwable -> L24 Exception -> L26 OperationCanceledException -> L30
        if (r8 != null) goto L33;
    L34:
        b.a r3 = new b.a(r15, System.currentTimeMillis());
        b.f = r3;
        r14 = r3.a;
    L33:
        r8.close();
        goto L34
    L15:
        if (r8.moveToFirst() == false) goto L20;
        if (r8.getInt(0) != 1) goto L19;
        r15 = PrivacyApprovalStatus.Approved;     // Catch: Throwable -> L24 Exception -> L26 OperationCanceledException -> L30
        goto L21
    L19:
        r15 = PrivacyApprovalStatus.NotApproved;     // Catch: Throwable -> L24 Exception -> L26 OperationCanceledException -> L30
    L30:
        e = move-exception;
        e.toString();     // Catch: Throwable -> L24
        r15 = PrivacyApprovalStatus.Timeout;     // Catch: Throwable -> L24
        if (r8 == null) goto L34;
    L26:
        e = move-exception;
        e.toString();     // Catch: Throwable -> L24
        r15 = PrivacyApprovalStatus.CannotObtain;     // Catch: Throwable -> L24
        if (r8 == null) goto L34;
    L24:
        th = move-exception;
        if (r8 == null) goto L39;
        r8.close();
    L39:
        throw th;
    L7:
        if (r4 == (-1)) goto L9;
    L41:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
