package com.larus.common.account.platform.larkauth;

import android.content.DialogInterface;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import com.larus.common.apphost.AppHost;
import com.larus.common_ui.dialog.CommonDialog;
import com.larus.utils.logger.FLogger;
import com.obric.assistant.interaction.impl.window.helpers.DialogFragmentLancet;
import com.obric.assistant.interaction.impl.window.landscape.restriction.LandscapeRestrictionGuard;
import com.obric.assistant.interaction.impl.window.landscape.restriction.LandscapeRestrictionOperation;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
public final /* synthetic */ class d implements Runnable {
    public final /* synthetic */ LarkAuthorization a;

    public /* synthetic */ d(LarkAuthorization r1) {
        this.a = r1;
    }

    @Override // java.lang.Runnable
    public final void run() {
        final LarkAuthorization r0 = this.a;
        FragmentActivity r1 = AppHost.a.a().getCurrentActivity();
        if ((r1 instanceof FragmentActivity) == false) goto L5;
        FragmentActivity r2 = r1;
    L6:
        if (r2 != null) goto L9;
        FLogger.a.e(r0.a, "can not find activity to attach authorize dialog");
        return;
    L9:
        if (r0.d == null) goto L11;
        FLogger.a.i(r0.a, "authorize dialog already show");
        return;
    L11:
        FLogger.a.i(r0.a, "show authorize dialog");
        CommonDialog.a r3 = new CommonDialog.a();
        r3.i(r2.getString(2131905548));
        r3.g(r2.getString(2131905547));
        CommonDialog.a.f(r3, new f(r0, r2), r2.getString(2131905435), false, 4);
        CommonDialog.a.e(r3, new g(r0), null, 2);
        r3.z = false;
        r3.A = false;
        DialogInterface.OnDismissListener r4 = new e(r0);
        Intrinsics.checkNotNullParameter(r4, "listener");
        r3.x = r4;
        CommonDialog r5 = r3.b(v19.c.a(2130972079, r2, 2131103136));
        r0.d = r5;
        FragmentManager r6 = r2.getSupportFragmentManager();
        LandscapeRestrictionOperation r7 = LandscapeRestrictionOperation.DIALOG_FRAGMENT_SHOW;
        LandscapeRestrictionGuard.markDialogFragmentIfAllowed(r5, "lark_authorize", r7);
        if (LandscapeRestrictionGuard.shouldBlockDialogFragmentShow(r6, r5, r7) == true) goto L22;
        DialogFragmentLancet.sLastShowStack = new Throwable();     // Catch: Exception -> L17
    L15:
        r5.show(r6, "lark_authorize");
        return;
    L22:
        return;
    L5:
        r2 = null;
        goto L6
    }
}
