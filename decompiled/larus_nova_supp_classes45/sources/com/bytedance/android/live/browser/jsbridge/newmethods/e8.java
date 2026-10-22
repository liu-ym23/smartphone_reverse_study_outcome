package com.bytedance.android.live.browser.jsbridge.newmethods;

import android.app.Activity;
import android.app.AlertDialog;
import com.bytedance.android.live.core.utils.ContextUtil;
import com.bytedance.ies.web.jsbridge2.CallContext;
import com.bytedance.sdk.xbridge.annotations.XBridgeMethod;
import com.obric.assistant.interaction.impl.window.helpers.DialogLancet;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
@XBridgeMethod(biz = "webcast", name = "handleNotificationSettings")
public final class e8 extends com.bytedance.ies.web.jsbridge2.f<Object, Object> {
    public final void onTerminate() {
    }

    public e8() {
    }

    public final void invoke(Object r3, CallContext r4) {
        Intrinsics.checkNotNullParameter(r3, "params");
        Intrinsics.checkNotNullParameter(r4, "context");
        Activity r5 = ContextUtil.contextToActivity(r4.getContext());
        if (r5 != null) goto L5;
        finishWithFailure();
    L5:
        if (r5 == null) goto L27;
        int r0 = c30.c.a;
        if (c30.c.b(r5) == false) goto L9;
        finishWithSuccess();
        return;
    L9:
        Intrinsics.checkNotNullParameter(r5, "context");
        c30.b r6 = new c30.b(r5);     // Catch: Exception -> L17
        c30.a r1 = c30.a.a;     // Catch: Exception -> L17
        AlertDialog r7 = new AlertDialog.Builder(r5).setTitle(2131922480).setMessage(2131922483).setPositiveButton(2131922482, r6).setNegativeButton(2131922481, r1).create();     // Catch: Exception -> L17
        if (DialogLancet.shouldBlockDialogShow(r7) == false) goto L25;
        DialogLancet.handleBlockedDialogShow(r7);     // Catch: Exception -> L17
    L22:
    L19:
        finishWithFailure();
        return;
    L25:
        DialogLancet.sLastShowStack = new Throwable();     // Catch: Exception -> L21
    L15:
        DialogLancet.beforeDialogShow(r7);     // Catch: Exception -> L17
        r7.show();     // Catch: Exception -> L17
        DialogLancet.afterDialogShow(r7);     // Catch: Exception -> L17
    L17:
        e = move-exception;
        e.printStackTrace();
        goto L19
    }
}
