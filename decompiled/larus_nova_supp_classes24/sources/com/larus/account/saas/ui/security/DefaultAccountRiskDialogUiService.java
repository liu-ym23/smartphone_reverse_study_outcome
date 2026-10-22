package com.larus.account.saas.ui.security;

import android.app.Application;
import android.content.Intent;
import androidx.fragment.app.FragmentActivity;
import com.larus.account.saas.runtime.internal.delegate.SaasApp;
import com.larus.account.saas.security.api.IAccountRiskDialogUiService;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes24.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/larus/account/saas/ui/security/DefaultAccountRiskDialogUiService;", "Lcom/larus/account/saas/security/api/IAccountRiskDialogUiService;", "<init>", "()V", "account-saas-ui-android_release"}, k = 1, mv = {1, 7, 1})
public final class DefaultAccountRiskDialogUiService implements IAccountRiskDialogUiService {
    public DefaultAccountRiskDialogUiService() {
    }

    @Override // com.larus.account.saas.security.api.IAccountRiskDialogUiService
    public final boolean a(e48.b r13, Function1<? super e48.a, Unit> r14) {
        Intrinsics.checkNotNullParameter(r13, "riskInfo");
        c48.a.a().a();
        com.larus.init.task.accountsdk.a r1 = com.larus.init.task.accountsdk.a.a;
        FragmentActivity r2 = r1.currentActivity();
        c48.a.a().a();
        Application r3 = r1.getApplication();
        String r4 = r13.a;
        if (StringsKt.isBlank(r4) == false) goto L5;
        r4 = r3.getString(2131899084);
    L5:
        String r5 = r4;
        String r6 = r13.b;
        if (StringsKt.isBlank(r6) == false) goto L8;
        r6 = r3.getString(2131899078);
    L8:
        String r7 = r6;
        String r8 = r13.e;
        if (StringsKt.isBlank(r8) == false) goto L11;
        r8 = r3.getString(2131899089);
    L11:
        String r9 = r8;
        String r10 = r13.f;
        if (StringsKt.isBlank(r10) == false) goto L14;
        r10 = r3.getString(2131899088);
    L14:
        String r11 = r10;
        String r12 = r13.g;
        if (StringsKt.isBlank(r12) == false) goto L17;
        String r15 = r3.getString(2131899089);
    L18:
        int r16 = r13.c;
        String r17 = r13.d;
        Intrinsics.checkNotNullParameter(r5, "title");
        Intrinsics.checkNotNullParameter(r7, "content");
        Intrinsics.checkNotNullParameter(r17, "h5Url");
        Intrinsics.checkNotNullParameter(r9, "toast");
        Intrinsics.checkNotNullParameter(r11, "successToast");
        Intrinsics.checkNotNullParameter(r15, "failToast");
        e48.b r19 = new e48.b(r5, r7, r16, r17, r9, r11, r15);
        Result.Companion r20 = Result.Companion;     // Catch: Throwable -> L34
        if ((r2 instanceof FragmentActivity) == false) goto L22;
        FragmentActivity r21 = r2;     // Catch: Throwable -> L34
    L23:
        if (r21 != null) goto L25;
    L29:
        e48.b r22 = FlowAccountAppealDialogActivity.d;     // Catch: Throwable -> L34
        Intrinsics.checkNotNullParameter(r19, "riskInfo");     // Catch: Throwable -> L34
        FlowAccountAppealDialogActivity.d = r19;     // Catch: Throwable -> L34
        FlowAccountAppealDialogActivity.e = r14;     // Catch: Throwable -> L34
        SaasApp r23 = SaasApp.a;     // Catch: Throwable -> L34
        Intent r0 = new Intent(r23.getApplication(), FlowAccountAppealDialogActivity.class);     // Catch: Throwable -> L34
        r0.addFlags(268435456);     // Catch: Throwable -> L34
        if (r23.startActivity(null, r0) == true) goto L32;
        r23.getApplication().startActivity(r0);     // Catch: Throwable -> L34
    L32:
        Object r24 = Result.constructor-impl(Boolean.TRUE);     // Catch: Throwable -> L34
    L36:
        Throwable r25 = Result.exceptionOrNull-impl(r24);
        if (r25 == null) goto L46;
        if (FlowAccountAppealDialogActivity.d == r19) goto L42;
    L44:
        com.larus.account.saas.runtime.internal.delegate.a.a.b("DefaultAccountRiskUi", "show appeal dialog failed: " + r25.getMessage(), r25);
        r24 = Boolean.FALSE;
        goto L46
    L42:
        if (FlowAccountAppealDialogActivity.e != r14) goto L44;
        FlowAccountAppealDialogActivity.d = null;
        FlowAccountAppealDialogActivity.e = null;
    L46:
        return ((Boolean) r24).booleanValue();
    L25:
        if (r21.isFinishing() == true) goto L29;
        if (r21.isDestroyed() == true) goto L29;
        b.a(r21, r19, r14);     // Catch: Throwable -> L34
        goto L32
    L22:
        r21 = null;
    L34:
        th = move-exception;
        Result.Companion r26 = Result.Companion;
        r24 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L36
    L17:
        r15 = r12;
        goto L18
    }
}
