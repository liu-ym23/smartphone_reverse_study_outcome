package com.larus.dora.impl.nl.notification_rule.data;

import com.larus.dora.api.entity.NotificationRule;
import com.larus.dora.impl.network.DoraNetworkApi;
import com.larus.dora.impl.util.b0;
import com.larus.platform.service.AccountService;
import java.util.List;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
public final class DoraNotificationRuleRepo {
    public static final DoraNotificationRuleRepo a = null;

    static {
        a = new DoraNotificationRuleRepo();
    }

    public DoraNotificationRuleRepo() {
    }

    public final Object e(Continuation<? super Result<? extends List<NotificationRule>>> r7) {
        if ((r7 instanceof DoraNotificationRuleRepo$loadRules$1) == false) goto L7;
        DoraNotificationRuleRepo$loadRules$1 r0 = (DoraNotificationRuleRepo$loadRules$1) r7;
        int r1 = r0.label;
        if ((r1 & Integer.MIN_VALUE) == 0) goto L7;
        r0.label = r1 - Integer.MIN_VALUE;
    L8:
        Object r8 = r0.result;
        Object r2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r3 = r0.label;
        if (r3 == 0) goto L16;
        if (r3 != 1) goto L15;
        String r4 = (String) r0.L$0;
        ResultKt.throwOnFailure(r8);     // Catch: Exception -> L31
        Object r9 = ((Result) r8).unbox-impl();     // Catch: Exception -> L31
    L22:
        if (Result.isSuccess-impl(r9) == false) goto L27;
        List r5 = CollectionsKt.emptyList();     // Catch: Exception -> L31
        if (Result.isFailure-impl(r9) == false) goto L26;
        r9 = r5;
    L26:
        List r10 = (List) r9;     // Catch: Exception -> L31
        b0.a.getClass();     // Catch: Exception -> L31
        b0.G(r4, r10);     // Catch: Exception -> L31
        return Result.constructor-impl(r10);
    L27:
        b0.a.getClass();     // Catch: Exception -> L31
        List r6 = b0.m(r4);     // Catch: Exception -> L31
        if ((!r6.isEmpty()) == true) goto L37;
        return r9;
    L37:
        return Result.constructor-impl(r6);
    L15:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L16:
        ResultKt.throwOnFailure(r8);
        String r11 = AccountService.a.getUserId();
        DoraNetworkApi r12 = DoraNetworkApi.a;     // Catch: Exception -> L31
        r0.L$0 = r11;     // Catch: Exception -> L31
        r0.label = 1;     // Catch: Exception -> L31
        Object r13 = r12.s(null, r0);     // Catch: Exception -> L31
        if (r13 != r2) goto L20;
        return r2;
    L20:
        r4 = r11;
        r9 = r13;
    L31:
        e = move-exception;
        Result.Companion r14 = Result.Companion;
        return Result.constructor-impl(ResultKt.createFailure(e));
    L7:
        r0 = new DoraNotificationRuleRepo$loadRules$1(this, r7);
        goto L8
    }

    public final Object a(List<String> r5, Continuation<? super Result<Boolean>> r6) {
        if ((r6 instanceof DoraNotificationRuleRepo$batchDeleteRules$1) == false) goto L7;
        DoraNotificationRuleRepo$batchDeleteRules$1 r0 = (DoraNotificationRuleRepo$batchDeleteRules$1) r6;
        int r1 = r0.label;
        if ((r1 & Integer.MIN_VALUE) == 0) goto L7;
        r0.label = r1 - Integer.MIN_VALUE;
    L8:
        Object r7 = r0.result;
        Object r2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r3 = r0.label;
        if (r3 == 0) goto L17;
        if (r3 != 1) goto L16;
        ResultKt.throwOnFailure(r7);     // Catch: Exception -> L13
        Object r8 = ((Result) r7).unbox-impl();     // Catch: Exception -> L13
    L22:
        if (Result.isSuccess-impl(r8) == false) goto L35;
        Object r9 = Boxing.boxBoolean(false);     // Catch: Exception -> L13
        if (Result.isFailure-impl(r8) == true) goto L28;
        r9 = r8;
    L28:
        if (((Boolean) r9).booleanValue() == false) goto L36;
        return Result.constructor-impl(Boxing.boxBoolean(true));
    L36:
        return r8;
    L35:
        return r8;
    L16:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L17:
        ResultKt.throwOnFailure(r7);
        DoraNetworkApi r10 = DoraNetworkApi.a;     // Catch: Exception -> L13
        r0.label = 1;     // Catch: Exception -> L13
        r8 = r10.d(r5, r0);     // Catch: Exception -> L13
        if (r8 != r2) goto L22;
        return r2;
    L13:
        e = move-exception;
        Result.Companion r11 = Result.Companion;
        return Result.constructor-impl(ResultKt.createFailure(e));
    L7:
        r0 = new DoraNotificationRuleRepo$batchDeleteRules$1(this, r6);
        goto L8
    }

    public final Object b(String r5, Continuation<? super Result<? extends List<String>>> r6) {
        if ((r6 instanceof DoraNotificationRuleRepo$clarifyRule$1) == false) goto L7;
        DoraNotificationRuleRepo$clarifyRule$1 r0 = (DoraNotificationRuleRepo$clarifyRule$1) r6;
        int r1 = r0.label;
        if ((r1 & Integer.MIN_VALUE) == 0) goto L7;
        r0.label = r1 - Integer.MIN_VALUE;
    L8:
        Object r7 = r0.result;
        Object r2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r3 = r0.label;
        if (r3 == 0) goto L14;
        if (r3 != 1) goto L13;
        ResultKt.throwOnFailure(r7);
        return ((Result) r7).unbox-impl();
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        ResultKt.throwOnFailure(r7);
        DoraNetworkApi r8 = DoraNetworkApi.a;
        r0.label = 1;
        Object r9 = r8.h(r5, r0);
        if (r9 != r2) goto L18;
        return r2;
    L18:
        return r9;
    L7:
        r0 = new DoraNotificationRuleRepo$clarifyRule$1(this, r6);
        goto L8
    }

    public final Object c(List<String> r5, Continuation<? super Result<Boolean>> r6) {
        if ((r6 instanceof DoraNotificationRuleRepo$createRules$1) == false) goto L7;
        DoraNotificationRuleRepo$createRules$1 r0 = (DoraNotificationRuleRepo$createRules$1) r6;
        int r1 = r0.label;
        if ((r1 & Integer.MIN_VALUE) == 0) goto L7;
        r0.label = r1 - Integer.MIN_VALUE;
    L8:
        Object r7 = r0.result;
        Object r2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r3 = r0.label;
        if (r3 == 0) goto L17;
        if (r3 != 1) goto L16;
        ResultKt.throwOnFailure(r7);     // Catch: Exception -> L13
        Object r8 = ((Result) r7).unbox-impl();     // Catch: Exception -> L13
    L22:
        if (Result.isSuccess-impl(r8) == true) goto L32;
        Throwable r9 = Result.exceptionOrNull-impl(r8);     // Catch: Exception -> L13
        if (r9 != null) goto L33;
        r9 = new RuntimeException("Create rules failed");     // Catch: Exception -> L13
    L33:
        return Result.constructor-impl(ResultKt.createFailure(r9));
    L32:
        return Result.constructor-impl(Boxing.boxBoolean(true));
    L16:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L17:
        ResultKt.throwOnFailure(r7);
        DoraNetworkApi r10 = DoraNetworkApi.a;     // Catch: Exception -> L13
        r0.label = 1;     // Catch: Exception -> L13
        r8 = r10.i(r5, r0);     // Catch: Exception -> L13
        if (r8 != r2) goto L22;
        return r2;
    L13:
        e = move-exception;
        Result.Companion r11 = Result.Companion;
        return Result.constructor-impl(ResultKt.createFailure(e));
    L7:
        r0 = new DoraNotificationRuleRepo$createRules$1(this, r6);
        goto L8
    }

    public final Object d(String r5, Continuation<? super Result<Boolean>> r6) {
        if ((r6 instanceof DoraNotificationRuleRepo$deleteRule$1) == false) goto L7;
        DoraNotificationRuleRepo$deleteRule$1 r0 = (DoraNotificationRuleRepo$deleteRule$1) r6;
        int r1 = r0.label;
        if ((r1 & Integer.MIN_VALUE) == 0) goto L7;
        r0.label = r1 - Integer.MIN_VALUE;
    L8:
        Object r7 = r0.result;
        Object r2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r3 = r0.label;
        if (r3 == 0) goto L14;
        if (r3 != 1) goto L13;
        ResultKt.throwOnFailure(r7);
        return ((Result) r7).unbox-impl();
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        ResultKt.throwOnFailure(r7);
        List<String> r8 = CollectionsKt.listOf(r5);
        r0.label = 1;
        Object r9 = a(r8, r0);
        if (r9 != r2) goto L18;
        return r2;
    L18:
        return r9;
    L7:
        r0 = new DoraNotificationRuleRepo$deleteRule$1(this, r6);
        goto L8
    }

    public final Object f(String r6, boolean r7, String r8, Continuation<? super Result<Boolean>> r9) {
        if ((r9 instanceof DoraNotificationRuleRepo$updateRuleStatus$1) == false) goto L7;
        DoraNotificationRuleRepo$updateRuleStatus$1 r0 = (DoraNotificationRuleRepo$updateRuleStatus$1) r9;
        int r1 = r0.label;
        if ((r1 & Integer.MIN_VALUE) == 0) goto L7;
        r0.label = r1 - Integer.MIN_VALUE;
    L8:
        Object r10 = r0.result;
        Object r2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r3 = r0.label;
        if (r3 == 0) goto L17;
        if (r3 != 1) goto L16;
        ResultKt.throwOnFailure(r10);     // Catch: Exception -> L13
        Object r11 = ((Result) r10).unbox-impl();     // Catch: Exception -> L13
    L26:
        if (Result.isSuccess-impl(r11) == false) goto L39;
        Object r12 = Boxing.boxBoolean(false);     // Catch: Exception -> L13
        if (Result.isFailure-impl(r11) == true) goto L32;
        r12 = r11;
    L32:
        if (((Boolean) r12).booleanValue() == false) goto L40;
        return Result.constructor-impl(Boxing.boxBoolean(true));
    L40:
        return r11;
    L39:
        return r11;
    L16:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L17:
        ResultKt.throwOnFailure(r10);
        AccountService.a.getUserId();
        DoraNetworkApi r13 = DoraNetworkApi.a;     // Catch: Exception -> L13
        if (r7 == false) goto L21;
        boolean r14 = true;
    L22:
        r0.label = 1;     // Catch: Exception -> L13
        r11 = r13.G(r6, r14, r8, r0);     // Catch: Exception -> L13
        if (r11 != r2) goto L26;
        return r2;
    L21:
        r14 = false;
    L13:
        e = move-exception;
        Result.Companion r15 = Result.Companion;
        return Result.constructor-impl(ResultKt.createFailure(e));
    L7:
        r0 = new DoraNotificationRuleRepo$updateRuleStatus$1(this, r9);
        goto L8
    }
}
