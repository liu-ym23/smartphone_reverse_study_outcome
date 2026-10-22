package com.obric.aiagent.assistant.utils;

import android.content.Context;
import android.os.Bundle;
import com.obric.capabilitykit.PackageUtils;
import com.obric.eventkit.eventstaskmanager.ITaskManager;
import com.obric.sva.sdk.session.IWakeupSessionConstant;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes6.dex */
@Metadata(k = 3, mv = {2, 1, 0}, xi = ITaskManager.Stub.TRANSACTION_getEventTasksByType)
@DebugMetadata(c = "com.obric.aiagent.assistant.utils.ObricAppStatusHelper", f = "ObricAppStatusHelper.kt", i = {0}, l = {ITaskManager.Stub.TRANSACTION_registerAssistantSessionState}, m = "getObricAppStatus", n = {"context"}, s = {"L$0"})
final class ObricAppStatusHelper$getObricAppStatus$1 extends ContinuationImpl {
    Object L$0;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ a this$0;

    public ObricAppStatusHelper$getObricAppStatus$1(a r1, Continuation<? super ObricAppStatusHelper$getObricAppStatus$1> r2) {
        this.this$0 = r1;
        super(r2);
    }

    public final Object invokeSuspend(Object r5) {
        this.result = r5;
        this.label |= IWakeupSessionConstant.RC_ERROR;
        a r6 = this.this$0;
        r6.getClass();
        int r1 = this.label;
        if ((r1 & IWakeupSessionConstant.RC_ERROR) == 0) goto L5;
        this.label = r1 - IWakeupSessionConstant.RC_ERROR;
        ObricAppStatusHelper$getObricAppStatus$1 r0 = this;
    L6:
        Object r7 = r0.result;
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r2 = r0.label;
        if (r2 != 0) goto L9;
        ResultKt.throwOnFailure(r7);
        return ObricAppStatus.Unknown;
    L9:
        if (r2 != 1) goto L45;
        Context r3 = (Context) r0.L$0;
        ResultKt.throwOnFailure(r7);
        int r8 = a$a.a[((PrivacyApprovalStatus) r7).ordinal()];
        if (r8 == 1) goto L54;
        if (r8 == 2) goto L53;
        if (r8 == 3) goto L53;
        if (r8 != 4) goto L41;
        b.a.getClass();
        Intrinsics.checkNotNullParameter(r3, "context");
        Result.Companion r4 = Result.Companion;     // Catch: Throwable -> L25
        Bundle r9 = r3.getContentResolver().call(b.b, "is_login", null, null);     // Catch: Throwable -> L25
        if (r9 == null) goto L22;
        boolean r10 = r9.getBoolean("is_login");     // Catch: Throwable -> L25
    L23:
        Object r11 = Result.constructor-impl(Boolean.valueOf(r10));     // Catch: Throwable -> L25
    L27:
        Throwable r12 = Result.exceptionOrNull-impl(r11);
        if (r12 == null) goto L30;
        r12.getMessage();
    L30:
        Boolean r13 = Boolean.FALSE;
        if (Result.isFailure-impl(r11) == false) goto L34;
        r11 = r13;
    L34:
        if (((Boolean) r11).booleanValue() == false) goto L50;
        b.a.getClass();
        if (Intrinsics.areEqual(b.d(r3), PackageUtils.NOVA_PKG_NAME) == true) goto L52;
        return ObricAppStatus.NotRoleAssistant;
    L52:
        return ObricAppStatus.Success;
    L50:
        return ObricAppStatus.UserNoLogin;
    L22:
        r10 = false;
    L25:
        th = move-exception;
        Result.Companion r14 = Result.Companion;
        r11 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L27
    L41:
        throw new NoWhenBranchMatchedException();
    L53:
        return ObricAppStatus.PrivacyNotObtainError;
    L54:
        return ObricAppStatus.PrivacyNotApprovalError;
    L45:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L5:
        r0 = new ObricAppStatusHelper$getObricAppStatus$1(r6, this);
        goto L6
    }
}
