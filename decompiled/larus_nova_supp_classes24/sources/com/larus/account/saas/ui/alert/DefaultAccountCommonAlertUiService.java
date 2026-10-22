package com.larus.account.saas.ui.alert;

import android.app.Activity;
import android.os.Bundle;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import com.larus.account.saas.ui.AccountCommonAlertAction;
import com.larus.account.saas.ui.AccountCommonAlertData;
import com.larus.account.saas.ui.IAccountCommonAlertUiService;
import com.obric.assistant.interaction.impl.window.helpers.DialogFragmentLancet;
import com.obric.assistant.interaction.impl.window.landscape.restriction.LandscapeRestrictionGuard;
import com.obric.assistant.interaction.impl.window.landscape.restriction.LandscapeRestrictionOperation;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes24.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/larus/account/saas/ui/alert/DefaultAccountCommonAlertUiService;", "Lcom/larus/account/saas/ui/IAccountCommonAlertUiService;", "<init>", "()V", "account-saas-ui-android_release"}, k = 1, mv = {1, 7, 1})
public final class DefaultAccountCommonAlertUiService implements IAccountCommonAlertUiService {
    @Override // f48.c
    public final void priority() {
    }

    public DefaultAccountCommonAlertUiService() {
    }

    @Override // com.larus.account.saas.ui.IAccountCommonAlertUiService
    public final boolean b(Activity r4, AccountCommonAlertData r5, Function1<? super AccountCommonAlertAction, Unit> r6, Function0<Unit> r7) {
        Intrinsics.checkNotNullParameter(r4, "activity");
        Intrinsics.checkNotNullParameter(r5, "data");
        Intrinsics.checkNotNullParameter(r6, "onAction");
        Intrinsics.checkNotNullParameter(r7, "onCancel");
        if ((r4 instanceof FragmentActivity) == false) goto L5;
        FragmentActivity r8 = (FragmentActivity) r4;
    L7:
        if (r8 != null) goto L10;
        return false;
    L10:
        if (r8.isFinishing() == false) goto L12;
    L21:
        return false;
    L12:
        if (r8.isDestroyed() == true) goto L21;
        int r1 = AccountCommonAlertDialog.h;
        Intrinsics.checkNotNullParameter(r5, "data");
        AccountCommonAlertDialog r0 = new AccountCommonAlertDialog();
        Bundle r2 = new Bundle();
        r2.putSerializable("key_data", r5);
        r0.setArguments(r2);
        r0.f = r6;
        r0.g = r7;
        FragmentManager r9 = r8.getSupportFragmentManager();
        LandscapeRestrictionOperation r10 = LandscapeRestrictionOperation.DIALOG_FRAGMENT_SHOW;
        LandscapeRestrictionGuard.markDialogFragmentIfAllowed(r0, "AccountCommonAlertDialog", r10);
        if (LandscapeRestrictionGuard.shouldBlockDialogFragmentShow(r9, r0, r10) == true) goto L25;
        DialogFragmentLancet.sLastShowStack = new Throwable();     // Catch: Exception -> L22
    L18:
        r0.show(r9, "AccountCommonAlertDialog");
        return true;
    L25:
        return true;
    L5:
        r8 = null;
        goto L7
    }
}
