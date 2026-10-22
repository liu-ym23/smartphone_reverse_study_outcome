package com.bytedance.android.live.browser.jsbridge.newmethods;

import android.app.ProgressDialog;
import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import com.bytedance.ies.web.jsbridge2.CallContext;
import com.bytedance.mt.protector.impl.JSONObjectProtectorUtils;
import com.bytedance.sdk.xbridge.annotations.XBridgeMethod;
import com.obric.assistant.interaction.impl.window.helpers.DialogLancet;
import io.reactivex.Single;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import java.util.concurrent.TimeUnit;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
@XBridgeMethod(biz = "webcast", name = "liveLoading")
public final class aa extends com.bytedance.ies.web.jsbridge2.f<JSONObject, Object> {
    public com.bytedance.android.livesdk.utils.k5 a;
    public Disposable b;

    public final void onTerminate() {
        Disposable r0 = this.b;
        if (r0 == null) goto L5;
        r0.dispose();
    L5:
        com.bytedance.android.livesdk.utils.k5 r1 = this.a;
        if (r1 == null) goto L9;
        j(r1);
        return;
    }

    public aa() {
    }

    public static void j(ProgressDialog r3) {
        Handler r0 = DialogLancet.resolveDialogHandler(r3);
        if (r0 != null) goto L5;
    L8:
        DialogLancet.beforeDialogDismiss(r3);
        r3.dismiss();     // Catch: Throwable -> L11 Exception -> L13
    L10:
        DialogLancet.afterDialogDismiss(r3);
        return;
    L11:
        th = move-exception;
        DialogLancet.afterDialogDismiss(r3);
        throw th;
    L13:
        e = move-exception;
        com.bytedance.crash.d.d(e, "DIALOG_DISMISS_EXCEPTION");     // Catch: Throwable -> L11
        Throwable r1 = DialogLancet.sLastShowStack;     // Catch: Throwable -> L11
        if (r1 == null) goto L10;
        com.bytedance.crash.d.d(r1, "DIALOG_SHOW_STACK_TRACE");     // Catch: Throwable -> L11
        goto L10
    L5:
        if (Looper.myLooper() == r0.getLooper()) goto L8;
        r0.post(DialogLancet.createDismissRunnable(r3));
    }

    public final void invoke(Object r3, CallContext r4) throws Exception {
        JSONObject r5 = (JSONObject) r3;
        String r0 = JSONObjectProtectorUtils.getString(r5, "type");
        JSONObject r6 = JSONObjectProtectorUtils.getJSONObject(r5, "args");
        r0.getClass();
        if (r0.equals("show") == false) goto L5;
        com.bytedance.android.livesdk.utils.k5 r1 = this.a;
        if (r1 == null) goto L17;
        j(r1);
    L17:
        Context r7 = r4.getContext();
        String r8 = JSONObjectProtectorUtils.getString(r6, "message");
        com.bytedance.android.livesdk.utils.k5 r2 = new com.bytedance.android.livesdk.utils.k5(r7);
        r2.setMessage(r8);
        this.a = r2;
        r2.setCancelable(false);
        com.bytedance.android.livesdk.utils.k5 r9 = this.a;
        if (DialogLancet.shouldBlockDialogShow(r9) == false) goto L26;
        DialogLancet.handleBlockedDialogShow(r9);
    L22:
        this.b = Single.timer(8, TimeUnit.SECONDS).observeOn(AndroidSchedulers.mainThread()).subscribe(new y9(this), new z9());
    L23:
        finishWithSuccess();
        return;
    L26:
        DialogLancet.sLastShowStack = new Throwable();     // Catch: Exception -> L25
    L21:
        DialogLancet.beforeDialogShow(r9);
        r9.show();
        DialogLancet.afterDialogShow(r9);
        goto L22
    L5:
        if (r0.equals("dismiss") == false) goto L23;
        Disposable r11 = this.b;
        if (r11 == null) goto L10;
        r11.dispose();
    L10:
        com.bytedance.android.livesdk.utils.k5 r12 = this.a;
        if (r12 == null) goto L13;
        j(r12);
    L13:
        this.b = null;
        this.a = null;
        goto L23
    }
}
