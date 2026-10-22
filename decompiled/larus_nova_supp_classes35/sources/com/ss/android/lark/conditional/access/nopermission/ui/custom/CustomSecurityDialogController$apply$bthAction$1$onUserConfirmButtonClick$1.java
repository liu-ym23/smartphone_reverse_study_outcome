package com.ss.android.lark.conditional.access.nopermission.ui.custom;

import com.bytedance.lark.pb.security.v1.CustomDisplayHandler;
import com.ss.android.lark.conditional.access.nopermission.manager.SecurityPolicyDialogActionManager;
import com.ss.android.lark.conditional.access.nopermission.viewmodel.DialogUserScopeView;
import com.ss.android.lark.conditional.access.traffic.InternalSecurityAction;
import com.ss.android.lark.security.compliance.api.params.SecurityActionHandleContext;
import com.tencent.qqmusic.third.api.contract.BuildConfig;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", BuildConfig.FLAVOR, "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.ss.android.lark.conditional.access.nopermission.ui.custom.CustomSecurityDialogController$apply$bthAction$1$onUserConfirmButtonClick$1", f = "CustomSecurityDialogController.kt", i = {}, l = {145}, m = "invokeSuspend", n = {}, s = {})
public final class CustomSecurityDialogController$apply$bthAction$1$onUserConfirmButtonClick$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ CustomDisplayHandler $handler;
    final /* synthetic */ InternalSecurityAction $internalSecurityAction;
    final /* synthetic */ DialogUserScopeView $vm;
    int label;

    public CustomSecurityDialogController$apply$bthAction$1$onUserConfirmButtonClick$1(CustomDisplayHandler r1, InternalSecurityAction r2, DialogUserScopeView r3, Continuation<? super CustomSecurityDialogController$apply$bthAction$1$onUserConfirmButtonClick$1> r4) {
        this.$handler = r1;
        this.$internalSecurityAction = r2;
        this.$vm = r3;
        super(2, r4);
    }

    public final Continuation<Unit> create(Object r4, Continuation<?> r5) {
        return new CustomSecurityDialogController$apply$bthAction$1$onUserConfirmButtonClick$1(this.$handler, this.$internalSecurityAction, this.$vm, r5);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r5) {
        Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r1 = this.label;
        if (r1 == 0) goto L8;
        if (r1 != 1) goto L7;
        ResultKt.throwOnFailure(r5);
    L25:
        return Unit.INSTANCE;
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        ResultKt.throwOnFailure(r5);
        SecurityPolicyDialogActionManager.a.getClass();
        SecurityPolicyDialogActionManager.b();
        String r6 = (String) this.$handler.params.get("confirmParams");
        if (r6 != null) goto L11;
        r6 = BuildConfig.FLAVOR;
    L11:
        InternalSecurityAction r2 = this.$internalSecurityAction;
        if (r2 == null) goto L16;
        SecurityActionHandleContext r3 = r2.getHandleContext();
        if (r3 == null) goto L16;
        String r4 = r3.getPointKey();
    L18:
        if (Intrinsics.areEqual(r4, "PointKey_IM_MSG_FILE_READ") == false) goto L20;
        int r7 = 2131892524;
    L21:
        DialogUserScopeView r8 = this.$vm;
        this.label = 1;
        if (r8.c(r6, r7, this) != r0) goto L25;
        return r0;
    L20:
        r7 = 2131892527;
    L16:
        r4 = null;
        goto L18
    }
}
