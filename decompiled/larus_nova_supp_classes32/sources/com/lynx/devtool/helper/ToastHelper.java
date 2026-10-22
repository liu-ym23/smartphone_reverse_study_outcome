package com.lynx.devtool.helper;

import android.app.AlertDialog;
import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import com.larus.apm.impl.protector.RunnableProtector;
import com.obric.assistant.interaction.impl.window.helpers.DialogLancet;
import me.ele.lancet.base.annotations.Skip;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
public class ToastHelper {

    public static class Alert implements Runnable {
        private Context mContext;
        private String mMessage;
        private String mTitle;

        private Alert() {
        }

        @Override // java.lang.Runnable
        public void run() {
            com_lynx_devtool_helper_ToastHelper$Alert_com_larus_apm_impl_protector_RunnableLancet_run(this);
        }

        public void com_lynx_devtool_helper_ToastHelper$Alert__run$___twin___() {
            Context r0 = this.mContext;
            if (r0 == null) goto L6;
            ToastHelper.showAlertSync(this.mTitle, this.mMessage, r0);
            return;
        }

        public /* synthetic */ Alert(AnonymousClass1 r1) {
            this();
        }

        @Skip({"com.ss.android.ugc.bytex.pthread+"})
        public static void com_lynx_devtool_helper_ToastHelper$Alert_com_larus_apm_impl_protector_RunnableLancet_run(Alert r1) {
            r1.com_lynx_devtool_helper_ToastHelper$Alert__run$___twin___();     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }

        public void setData(String r1, String r2, Context r3) {
            this.mTitle = r1;
            this.mMessage = r2;
            this.mContext = r3;
        }
    }

    public ToastHelper() {
    }

    public static void INVOKEVIRTUAL_com_lynx_devtool_helper_ToastHelper_com_obric_assistant_interaction_impl_window_helpers_DialogLancet_show(AlertDialog r1) {
        if (DialogLancet.shouldBlockDialogShow(r1) == false) goto L10;
        DialogLancet.handleBlockedDialogShow(r1);
        return;
    L10:
        DialogLancet.sLastShowStack = new Throwable();     // Catch: Exception -> L9
    L7:
        DialogLancet.beforeDialogShow(r1);
        r1.show();
        DialogLancet.afterDialogShow(r1);
    }

    public static void showAlert(String r3, String r4, Context r5) {
        Handler r0 = new Handler(Looper.getMainLooper());
        Alert r1 = new Alert(null);
        r1.setData(r3, r4, r5);
        r0.post(r1);
    }

    public static void showAlertSync(String r1, String r2, Context r3) {
        AlertDialog.Builder r0 = new AlertDialog.Builder(r3);     // Catch: Throwable -> L9
        if (r2 == null) goto L6;
        AlertDialog r4 = r0.setTitle(r1).setMessage(r2).setNegativeButton("OK", new AnonymousClass1()).create();     // Catch: Throwable -> L9
    L7:
        INVOKEVIRTUAL_com_lynx_devtool_helper_ToastHelper_com_obric_assistant_interaction_impl_window_helpers_DialogLancet_show(r4);     // Catch: Throwable -> L9
        return;
    L6:
        r4 = r0.setTitle(r1).setNegativeButton("OK", new AnonymousClass2()).create();     // Catch: Throwable -> L9
    L9:
        th = move-exception;
        th.printStackTrace();
    }
}
