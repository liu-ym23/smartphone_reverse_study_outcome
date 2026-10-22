package com.ss.android.lark.conditional.access.nopermission.manager;

import android.os.Bundle;
import com.ss.android.lark.conditional.access.traffic.InternalSecurityAction;
import com.ss.android.lark.conditional.access.utils.NoPermissionType;
import com.ss.android.lark.security.compliance.infra.log.ScsLogger;
import com.ss.android.lark.utils.e0;
import com.tencent.qqmusic.third.api.contract.BuildConfig;
import com.tencent.qqmusic.third.api.contract.Keys;
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
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", BuildConfig.FLAVOR, "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.ss.android.lark.conditional.access.nopermission.manager.NoPermissionModuleManager$setCurrentNoPermissionType$1", f = "NoPermissionModuleManager.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
public final class NoPermissionModuleManager$setCurrentNoPermissionType$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ Bundle $extra;
    final /* synthetic */ NoPermissionType $noPermissionType;
    final /* synthetic */ String $traceId;
    int label;
    final /* synthetic */ NoPermissionModuleManager this$0;

    public NoPermissionModuleManager$setCurrentNoPermissionType$1(NoPermissionModuleManager r1, NoPermissionType r2, Bundle r3, String r4, Continuation<? super NoPermissionModuleManager$setCurrentNoPermissionType$1> r5) {
        this.this$0 = r1;
        this.$noPermissionType = r2;
        this.$extra = r3;
        this.$traceId = r4;
        super(2, r5);
    }

    public final Continuation<Unit> create(Object r7, Continuation<?> r8) {
        return new NoPermissionModuleManager$setCurrentNoPermissionType$1(this.this$0, this.$noPermissionType, this.$extra, this.$traceId, r8);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r7) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) goto L40;
        ResultKt.throwOnFailure(r7);
        if (this.this$0.d.get() != null) goto L36;
        this.this$0.d.set(this.$noPermissionType);
        NoPermissionModuleManager r8 = this.this$0;
        Bundle r1 = this.$extra;
        r8.e = r1;
        String r2 = this.$traceId;
        r8.f = r2;
        r1.putString("param_trace_id", r2);
        NoPermissionModuleManager r9 = this.this$0;
        NoPermissionType r3 = this.$noPermissionType;
        Bundle r4 = this.$extra;
        r9.getClass();
        Result.Companion r10 = Result.Companion;     // Catch: Throwable -> L9
        Object r11 = Result.constructor-impl(Boolean.valueOf(w4c.c.a().J()));     // Catch: Throwable -> L9
    L11:
        Boolean r5 = Boolean.TRUE;
        if (Result.isFailure-impl(r11) == false) goto L15;
        r11 = r5;
    L15:
        if (((Boolean) r11).booleanValue() == true) goto L17;
        ScsLogger.d("SecurityPolicy_NoPermissionModuleManager", "persistInterceptionIfNeeded: fg disabled, skip");
    L35:
        this.this$0.k.postValue(Boxing.boxBoolean(true));
        this.this$0.g();
    L38:
        return Unit.INSTANCE;
    L17:
        int r12 = ScsLogger.a;
        ScsLogger.d("SecurityPolicy_NoPermissionModuleManager", "persistInterceptionIfNeeded: enter, type=" + r3.name() + ", hasAction=" + r4.containsKey("param_action"));
        InternalSecurityAction r13 = (InternalSecurityAction) r4.getParcelable("param_action");
        if (r13 != null) goto L20;
        ScsLogger.d("SecurityPolicy_NoPermissionModuleManager", "persistInterceptionIfNeeded: no PARAM_ACTION in bundle, skip");
        goto L35
    L20:
        com.ss.android.lark.conditional.access.nopermission.interception.a.a.getClass();
        Intrinsics.checkNotNullParameter(r3, "noPermissionType");
        Intrinsics.checkNotNullParameter(r13, Keys.API_PARAM_KEY_ACTION);
        Object r0 = Result.constructor-impl(e0.c(r13));     // Catch: Throwable -> L23
    L25:
        Throwable r6 = Result.exceptionOrNull-impl(r0);
        if (r6 == null) goto L29;
        int r14 = ScsLogger.a;
        ScsLogger.c("SecurityPolicy_InterceptionPersistStore", "save: encode failed, " + r6);
    L29:
        if (Result.isFailure-impl(r0) == false) goto L31;
        r0 = null;
    L31:
        String r15 = (String) r0;
        if (r15 == null) goto L35;
        com.ss.android.lark.conditional.access.nopermission.interception.a.b().putString("no_permission_type", r3.name());
        com.ss.android.lark.conditional.access.nopermission.interception.a.b().putString("action_json", r15);
        int r16 = ScsLogger.a;
        ScsLogger.d("SecurityPolicy_InterceptionPersistStore", "save interception, type=" + r3.name() + ", traceId=" + r13.getTraceId() + ", jsonLen=" + r15.length());
    L23:
        th = move-exception;
        Result.Companion r17 = Result.Companion;
        r0 = Result.constructor-impl(ResultKt.createFailure(th));
    L9:
        th = move-exception;
        Result.Companion r18 = Result.Companion;
        r11 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L11
    L36:
        int r19 = ScsLogger.a;
        ScsLogger.d("SecurityPolicy_NoPermissionModuleManager", "setCurrentUnauthorizedType ignored, current: " + this.$noPermissionType);
        goto L38
    L40:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
