package com.bytedance.android.live.browser.jsbridge.newmethods;

import android.app.Activity;
import android.content.Context;
import android.view.View;
import android.view.Window;
import com.bytedance.android.live.browser.jsbridge.base.ShowLoadingResultModel;
import com.bytedance.ies.web.jsbridge2.CallContext;
import com.bytedance.sdk.xbridge.annotations.XBridgeMethod;
import com.larus.utils.logger.FLogger;
import com.obric.assistant.interaction.impl.window.helpers.DialogLancet;
import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import w20.we;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
@XBridgeMethod(biz = "webcast", name = "showLoading")
public final class zc extends w20.o6<we, ShowLoadingResultModel> {
    public zc() {
    }

    public final void invoke(Object r5, CallContext r6) {
        we r7 = (we) r5;
        Intrinsics.checkNotNullParameter(r7, "params");
        Intrinsics.checkNotNullParameter(r6, "context");
        com.bytedance.android.livesdk.widget.e1 r1 = l30.f.a;
        Context r8 = r6.getContext();
        String r9 = r7.a();
        if (r9 != null) goto L5;
        r9 = "";
    L5:
        Intrinsics.checkNotNullParameter(r8, "context");
        Intrinsics.checkNotNullParameter(r9, "text");
        Result.Companion r0 = Result.Companion;     // Catch: Throwable -> L36
        com.bytedance.android.livesdk.widget.e1 r2 = l30.f.a;     // Catch: Throwable -> L36
        if (r2 == null) goto L9;
        l30.f.a(r2);     // Catch: Throwable -> L36
    L9:
        com.bytedance.android.livesdk.widget.e1 r3 = new com.bytedance.android.livesdk.widget.e1((Activity) r8);     // Catch: Throwable -> L36
        r3.c = r9;     // Catch: Throwable -> L36
        l30.f.a = r3;     // Catch: Throwable -> L36
        r3.setCancelable(false);     // Catch: Throwable -> L36
        com.bytedance.android.livesdk.widget.e1 r11 = l30.f.a;     // Catch: Throwable -> L36
        if (r11 == null) goto L19;
        Window r12 = r11.getWindow();     // Catch: Throwable -> L36
        if (r12 == null) goto L19;
        View r4 = r12.getDecorView();     // Catch: Throwable -> L36
        if (com.larus.home.impl.utils.c.e == false) goto L18;
        FLogger.a.i("DecorViewLancet", "getDecorView");     // Catch: Throwable -> L36
        Thread r13 = ThreadMethodProxy.currentThread();     // Catch: Throwable -> L36
        if (r13 == com.larus.home.impl.utils.c.a) goto L18;
        com.larus.home.impl.utils.c.a(r13, "getDecorView");     // Catch: Throwable -> L36
    L18:
        com.bytedance.android.live.core.utils.statusbar.a.C0173a r14 = com.bytedance.android.live.core.utils.statusbar.a.b;     // Catch: Throwable -> L36
        r14.a();     // Catch: Throwable -> L36
        r14.a();     // Catch: Throwable -> L36
        r4.setSystemUiVisibility(1792);     // Catch: Throwable -> L36
        r14.a();     // Catch: Throwable -> L36
        r12.addFlags(Integer.MIN_VALUE);     // Catch: Throwable -> L36
        r12.setStatusBarColor(0);     // Catch: Throwable -> L36
        r12.setNavigationBarColor(0);     // Catch: Throwable -> L36
    L19:
        com.bytedance.android.livesdk.widget.e1 r15 = l30.f.a;     // Catch: Throwable -> L36
        if (r15 == null) goto L24;
        Window r16 = r15.getWindow();     // Catch: Throwable -> L36
        if (r16 == null) goto L24;
        r16.setDimAmount(0.0f);     // Catch: Throwable -> L36
    L24:
        com.bytedance.android.livesdk.widget.e1 r17 = l30.f.a;     // Catch: Throwable -> L36
        if (r17 != null) goto L27;
        Unit r18 = null;
    L34:
        Result.constructor-impl(r18);     // Catch: Throwable -> L36
    L38:
        ShowLoadingResultModel r19 = new ShowLoadingResultModel();
        r19.a(ShowLoadingResultModel.Code.Success);
        r19.b("SUCCESS");
        Unit r21 = Unit.INSTANCE;
        finishWithResult(r19);
        return;
    L27:
        if (DialogLancet.shouldBlockDialogShow(r17) == false) goto L41;
        DialogLancet.handleBlockedDialogShow(r17);     // Catch: Throwable -> L36
    L32:
        r18 = Unit.INSTANCE;     // Catch: Throwable -> L36
        goto L34
    L41:
        DialogLancet.sLastShowStack = new Throwable();     // Catch: Exception -> L40 Throwable -> L36
    L31:
        DialogLancet.beforeDialogShow(r17);     // Catch: Throwable -> L36
        r17.show();     // Catch: Throwable -> L36
        DialogLancet.afterDialogShow(r17);     // Catch: Throwable -> L36
    L36:
        th = move-exception;
        Result.Companion r22 = Result.Companion;
        Result.constructor-impl(ResultKt.createFailure(th));
        goto L38
    }
}
