package com.larus.account.saas.ui.loading;

import android.app.Activity;
import android.os.Bundle;
import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import com.bytedance.crash.d;
import com.larus.account.saas.ui.IAccountLoadingUiService;
import com.obric.assistant.interaction.impl.window.helpers.DialogFragmentLancet;
import com.obric.assistant.interaction.impl.window.landscape.restriction.LandscapeRestrictionGuard;
import com.obric.assistant.interaction.impl.window.landscape.restriction.LandscapeRestrictionOperation;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes24.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/larus/account/saas/ui/loading/DefaultAccountLoadingUiService;", "Lcom/larus/account/saas/ui/IAccountLoadingUiService;", "<init>", "()V", "account-saas-ui-android_release"}, k = 1, mv = {1, 7, 1})
public final class DefaultAccountLoadingUiService implements IAccountLoadingUiService {
    @Override // f48.c
    public final void priority() {
    }

    public DefaultAccountLoadingUiService() {
    }

    public static boolean f(FragmentActivity r2) {
        DialogFragment r3 = r2.getSupportFragmentManager().findFragmentByTag("CommonLoadDialogFragment");
        if ((r3 instanceof DialogFragment) == false) goto L5;
        DialogFragment r4 = r3;
    L6:
        if (r4 != null) goto L17;
    L13:
        if (r4 == null) goto L15;
        return true;
    L15:
        return false;
    L17:
        r4.dismissAllowingStateLoss();     // Catch: Exception -> L9
    L9:
        e = move-exception;
        d.d(e, "DIALOG_FRAGMENT_DISMISS_ALLOWING_STATE_LOSS_EXCEPTION");
        Throwable r0 = DialogFragmentLancet.sLastShowStack;
        if (r0 == null) goto L13;
        d.d(r0, "DIALOG_FRAGMENT_SHOW_STACK_TRACE");
        goto L13
    L5:
        r4 = null;
        goto L6
    }

    @Override // com.larus.account.saas.ui.IAccountLoadingUiService
    public final boolean d(Activity r2) {
        Intrinsics.checkNotNullParameter(r2, "activity");
        if ((r2 instanceof FragmentActivity) == false) goto L5;
        FragmentActivity r3 = (FragmentActivity) r2;
    L6:
        if (r3 != null) goto L10;
        return false;
    L10:
        return f(r3);
    L5:
        r3 = null;
        goto L6
    }

    @Override // com.larus.account.saas.ui.IAccountLoadingUiService
    public final boolean showLoading(Activity r6) {
        Intrinsics.checkNotNullParameter(r6, "activity");
        if ((r6 instanceof FragmentActivity) == false) goto L5;
        FragmentActivity r7 = (FragmentActivity) r6;
    L7:
        if (r7 != null) goto L10;
        return false;
    L10:
        if (r7.isFinishing() == false) goto L12;
    L21:
        return false;
    L12:
        if (r7.isDestroyed() == true) goto L21;
        f(r7);
        CommonLoadDialogFragment r1 = new CommonLoadDialogFragment();
        Bundle r2 = new Bundle();
        r2.putFloat("key_dim", 0.2f);
        r1.setArguments(r2);
        Intrinsics.checkNotNullParameter(r7, "activity");
        FragmentManager r8 = r7.getSupportFragmentManager();
        LandscapeRestrictionOperation r0 = LandscapeRestrictionOperation.DIALOG_FRAGMENT_SHOW;
        LandscapeRestrictionGuard.markDialogFragmentIfAllowed(r1, "CommonLoadDialogFragment", r0);
        if (LandscapeRestrictionGuard.shouldBlockDialogFragmentShow(r8, r1, r0) == true) goto L25;
        DialogFragmentLancet.sLastShowStack = new Throwable();     // Catch: Exception -> L22
    L18:
        r1.show(r8, "CommonLoadDialogFragment");
        return true;
    L25:
        return true;
    L5:
        r7 = null;
        goto L7
    }
}
