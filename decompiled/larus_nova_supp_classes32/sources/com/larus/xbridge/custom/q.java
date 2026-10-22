package com.larus.xbridge.custom;

import android.os.Bundle;
import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.FragmentActivity;
import com.ivy.ivykit.api.bridge.core.model.IvyBridgePlatformType;
import com.larus.common.apphost.AppHost;
import com.larus.common_ui.dialog.CommonLoadDialogFragment;
import com.larus.utils.logger.FLogger;
import com.lynx.jsbridge.LynxResourceModule;
import com.obric.assistant.interaction.impl.window.helpers.DialogFragmentLancet;
import java.util.LinkedHashMap;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
public final class q extends bx7.c {

    public static final class a {
    }

    static {
    }

    public final String getName() {
        return "app.loading";
    }

    public q() {
    }

    public static void f(FragmentActivity r1) {
        DialogFragment r2 = r1.getSupportFragmentManager().findFragmentByTag("CommonLoadDialogFragment");
        if ((r2 instanceof DialogFragment) == false) goto L5;
        DialogFragment r3 = r2;
    L6:
        if (r3 == null) goto L16;
        r3.dismissAllowingStateLoss();     // Catch: Exception -> L9
        return;
    L9:
        e = move-exception;
        com.bytedance.crash.d.d(e, "DIALOG_FRAGMENT_DISMISS_ALLOWING_STATE_LOSS_EXCEPTION");
        Throwable r4 = DialogFragmentLancet.sLastShowStack;
        if (r4 == null) goto L17;
        com.bytedance.crash.d.d(r4, "DIALOG_FRAGMENT_SHOW_STACK_TRACE");
        return;
    L17:
        return;
    L16:
        return;
    L5:
        r3 = null;
        goto L6
    }

    public final void a(dx7.b r5, ux7.d.d r6, IvyBridgePlatformType r7) {
        Intrinsics.checkNotNullParameter(r5, LynxResourceModule.PARAMS_KEY);
        Intrinsics.checkNotNullParameter(r6, "callback");
        Intrinsics.checkNotNullParameter(r7, "type");
        FragmentActivity r8 = AppHost.a.a().getCurrentActivity();
        if ((r8 instanceof FragmentActivity) == false) goto L13;
        FragmentActivity r0 = r8;
        if (r0.isFinishing() == true) goto L13;
        if (r0.isDestroyed() == true) goto L13;
        if (cx7.a.c(r5, "show") != 1) goto L11;
        f(r0);
        int r9 = CommonLoadDialogFragment.e;
        Bundle r10 = new Bundle();
        r10.putFloat("key_dim", 0.2f);
        CommonLoadDialogFragment r2 = new CommonLoadDialogFragment();
        r2.setArguments(r10);
        r2.S90(r0);
    L12:
        LinkedHashMap r11 = new LinkedHashMap();
        r11.put(LynxResourceModule.CODE_KEY, 1);
        r6.invoke(r11);
        return;
    L11:
        f(r0);
    L13:
        FLogger.a.e("AppLoadingMethod", "current activity " + r8 + " is illegal, Abort.");
        LinkedHashMap r12 = new LinkedHashMap();
        r12.put(LynxResourceModule.CODE_KEY, 0);
        r6.invoke(r12);
    }
}
