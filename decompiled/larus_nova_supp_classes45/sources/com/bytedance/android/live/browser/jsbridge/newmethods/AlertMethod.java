package com.bytedance.android.live.browser.jsbridge.newmethods;

import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import android.view.WindowManager;
import androidx.appcompat.app.AlertDialog;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.ies.web.jsbridge2.CallContext;
import com.bytedance.sdk.xbridge.annotations.XBridgeMethod;
import com.google.gson.annotations.SerializedName;
import com.obric.assistant.interaction.impl.window.helpers.DialogLancet;
import java.util.Locale;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
@XBridgeMethod(biz = "webcast", name = "showModal")
public final class AlertMethod extends com.bytedance.ies.web.jsbridge2.f<a, b> {
    public AlertDialog a;

    public static final enum ActionType extends Enum<ActionType> {
        public static final ActionType CANCEL = null;
        public static final ActionType CONFIRM = null;
        public static final ActionType MASK = null;
        public static final /* synthetic */ ActionType[] a = null;

        static {
            ActionType r0 = new ActionType("CONFIRM", 0);
            CONFIRM = r0;
            ActionType r1 = new ActionType("CANCEL", 1);
            CANCEL = r1;
            ActionType r3 = new ActionType("MASK", 2);
            MASK = r3;
            a = new ActionType[]{r0, r1, r3};
        }

        public static ActionType[] values() {
            return (ActionType[]) a.clone();
        }

        public static ActionType valueOf(String r1) {
            return (ActionType) r27.a.a(ActionType.class, r1);
        }

        public ActionType(String r1, int r2) {
            super(r1, r2);
        }
    }

    public static final class a {

        @SerializedName("cancelText")
        String cancelText;

        @SerializedName("confirmText")
        String confirmText;

        @SerializedName("content")
        String content;

        @SerializedName("showCancel")
        boolean showCancel;

        @SerializedName("tapMaskToDismiss")
        boolean tapMaskToDismiss;

        @SerializedName("title")
        String title;

        public a() {
            this.tapMaskToDismiss = true;
        }
    }

    public static final class b {

        @SerializedName("data")
        a data;

        @SerializedName("msg")
        String msg;

        public static final class a {

            @SerializedName("action")
            String action;

            @SerializedName("cancel")
            boolean cancel;

            @SerializedName("confirm")
            boolean confirm;

            public a(boolean r1, ActionType r2) {
                this.confirm = r1;
                this.cancel = !r1;
                this.action = r2.name().toLowerCase(Locale.getDefault());
            }
        }

        public b(boolean r2, ActionType r3) {
            this.data = new a(r2, r3);
            this.msg = "SUCCESS";
        }
    }

    public final void onTerminate() {
        AlertDialog r0 = this.a;
        if (r0 == null) goto L21;
        Handler r1 = DialogLancet.resolveDialogHandler(r0);
        if (r1 != null) goto L7;
    L9:
        DialogLancet.beforeDialogDismiss(r0);
        r0.dismiss();     // Catch: Throwable -> L12 Exception -> L14
    L18:
        DialogLancet.afterDialogDismiss(r0);
        goto L21
    L12:
        th = move-exception;
        DialogLancet.afterDialogDismiss(r0);
        throw th;
    L14:
        e = move-exception;
        com.bytedance.crash.d.d(e, "DIALOG_DISMISS_EXCEPTION");     // Catch: Throwable -> L12
        Throwable r2 = DialogLancet.sLastShowStack;     // Catch: Throwable -> L12
        if (r2 == null) goto L18;
        com.bytedance.crash.d.d(r2, "DIALOG_SHOW_STACK_TRACE");     // Catch: Throwable -> L12
        goto L18
    L7:
        if (Looper.myLooper() == r1.getLooper()) goto L9;
        r1.post(DialogLancet.createDismissRunnable(r0));
    L21:
        this.a = null;
    }

    public AlertMethod() {
    }

    public final void invoke(Object r3, CallContext r4) throws Exception {
        a r5 = (a) r3;
        AlertDialog.Builder r0 = new AlertDialog.Builder(r4.getContext());
        r0.setMessage(r5.content);
        if (TextUtils.isEmpty(r5.title) == true) goto L6;
        r0.setTitle(r5.title);
    L6:
        if (TextUtils.isEmpty(r5.confirmText) == false) goto L8;
        String r6 = com.bytedance.android.live.core.utils.s1.B(2131920806);
    L9:
        r0.setPositiveButton(r6, new n0(this));
        if (r5.showCancel == true) goto L12;
    L16:
        AlertDialog r7 = r0.create();
        this.a = r7;
        r7.setCanceledOnTouchOutside(r5.tapMaskToDismiss);
        this.a.setOnCancelListener(new p0(this));
        AlertDialog r8 = this.a;
        if (DialogLancet.shouldBlockDialogShow(r8) == false) goto L32;
        DialogLancet.handleBlockedDialogShow(r8);
    L34:
        AlertDialog r9 = this.a;     // Catch: Exception -> L29
        if (r9 != null) goto L24;
        return;
    L24:
        if (r9.getWindow() == null) goto L37;
        WindowManager.LayoutParams r11 = this.a.getWindow().getAttributes();     // Catch: Exception -> L29
        if (r11 == null) goto L38;
        r11.width = (com.bytedance.android.live.core.utils.s1.y() / 10) * 9;     // Catch: Exception -> L29
        r11.gravity = 17;     // Catch: Exception -> L29
        this.a.getWindow().setAttributes(r11);     // Catch: Exception -> L29
        return;
    L38:
        return;
    L37:
        return;
    L29:
        ALogger.e("alert_jsb_method_error", "alert jsb method resize dialog error");
        return;
    L32:
        DialogLancet.sLastShowStack = new Throwable();     // Catch: Exception -> L31
    L20:
        DialogLancet.beforeDialogShow(r8);
        r8.show();
        DialogLancet.afterDialogShow(r8);
        goto L34
    L12:
        if (TextUtils.isEmpty(r5.cancelText) == false) goto L14;
        String r12 = com.bytedance.android.live.core.utils.s1.B(2131915442);
    L15:
        r0.setNegativeButton(r12, new o0(this));
        goto L16
    L14:
        r12 = r5.cancelText;
        goto L15
    L8:
        r6 = r5.confirmText;
        goto L9
    }
}
