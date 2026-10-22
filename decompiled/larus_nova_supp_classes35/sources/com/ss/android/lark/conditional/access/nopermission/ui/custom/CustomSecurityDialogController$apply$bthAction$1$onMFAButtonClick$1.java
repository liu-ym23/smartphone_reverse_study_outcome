package com.ss.android.lark.conditional.access.nopermission.ui.custom;

import android.app.Activity;
import com.alibaba.fastjson.JSONObject;
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
@DebugMetadata(c = "com.ss.android.lark.conditional.access.nopermission.ui.custom.CustomSecurityDialogController$apply$bthAction$1$onMFAButtonClick$1", f = "CustomSecurityDialogController.kt", i = {}, l = {128}, m = "invokeSuspend", n = {}, s = {})
public final class CustomSecurityDialogController$apply$bthAction$1$onMFAButtonClick$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ JSONObject $customParams;
    final /* synthetic */ InternalSecurityAction $internalSecurityAction;
    final /* synthetic */ String $mfaParams;
    final /* synthetic */ String $scope;
    final /* synthetic */ DialogUserScopeView $vm;
    int label;
    final /* synthetic */ CustomSecurityDialogController this$0;

    public CustomSecurityDialogController$apply$bthAction$1$onMFAButtonClick$1(InternalSecurityAction r1, DialogUserScopeView r2, CustomSecurityDialogController r3, String r4, JSONObject r5, String r6, Continuation<? super CustomSecurityDialogController$apply$bthAction$1$onMFAButtonClick$1> r7) {
        this.$internalSecurityAction = r1;
        this.$vm = r2;
        this.this$0 = r3;
        this.$scope = r4;
        this.$customParams = r5;
        this.$mfaParams = r6;
        super(2, r7);
    }

    public final Continuation<Unit> create(Object r9, Continuation<?> r10) {
        return new CustomSecurityDialogController$apply$bthAction$1$onMFAButtonClick$1(this.$internalSecurityAction, this.$vm, this.this$0, this.$scope, this.$customParams, this.$mfaParams, r10);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r11) {
        Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r1 = this.label;
        if (r1 == 0) goto L8;
        if (r1 != 1) goto L7;
        ResultKt.throwOnFailure(r11);
    L22:
        return Unit.INSTANCE;
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        ResultKt.throwOnFailure(r11);
        SecurityPolicyDialogActionManager.a.getClass();
        SecurityPolicyDialogActionManager.b();
        InternalSecurityAction r12 = this.$internalSecurityAction;
        if (r12 == null) goto L13;
        SecurityActionHandleContext r13 = r12.getHandleContext();
        if (r13 == null) goto L13;
        String r14 = r13.getPointKey();
    L15:
        if (Intrinsics.areEqual(r14, "PointKey_IM_MSG_FILE_READ") == false) goto L17;
        int r8 = 2131892535;
    L18:
        DialogUserScopeView r3 = this.$vm;
        Activity r4 = this.this$0.getActivity();
        String r5 = this.$scope;
        JSONObject r6 = this.$customParams;
        String r7 = this.$mfaParams;
        this.label = 1;
        if (r3.b(r4, r5, r6, r7, r8, this) != r0) goto L22;
        return r0;
    L17:
        r8 = 2131892534;
    L13:
        r14 = null;
        goto L15
    }
}
