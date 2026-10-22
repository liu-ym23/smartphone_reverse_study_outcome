package com.ss.android.lark.conditional.access.nopermission.ui.custom;

import com.ss.android.lark.conditional.access.nopermission.manager.SecurityPolicyDialogActionManager;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.CallableReference;
import kotlin.jvm.internal.FunctionReferenceImpl;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
@Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
public /* synthetic */ class CustomSecurityDialogController$apply$bthAction$1$onDeviceApplyButtonClick$1 extends FunctionReferenceImpl implements Function0<Unit> {
    public CustomSecurityDialogController$apply$bthAction$1$onDeviceApplyButtonClick$1(Object r8) {
        super(0, r8, SecurityPolicyDialogActionManager.class, "exitDialog", "exitDialog()V", 0);
    }

    /* JADX INFO: renamed from: invoke, reason: collision with other method in class */
    public final void m988invoke() {
        ((SecurityPolicyDialogActionManager) ((CallableReference) this).receiver).getClass();
        SecurityPolicyDialogActionManager.b();
    }

    public /* bridge */ /* synthetic */ Object invoke() {
        m988invoke();
        return Unit.INSTANCE;
    }
}
