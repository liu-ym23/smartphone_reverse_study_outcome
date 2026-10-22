package com.bytedance.android.live.core.utils;

import android.app.Dialog;
import android.content.Context;
import android.text.TextUtils;
import com.bytedance.android.live.GsonHelper;
import com.bytedance.android.live.base.exception.ApiServerException;
import com.bytedance.android.live.base.model.Extra;
import com.bytedance.android.live.core.network.CustomApiServerException;
import com.bytedance.android.live.network.response.RequestError;
import com.bytedance.android.live.uikit.dialog.AlertDialog;
import com.bytedance.android.live.uikit.util.IESUIUtils;
import com.bytedance.common.utility.StringUtils;
import com.bytedance.mt.protector.impl.GsonProtectorUtils;
import com.obric.assistant.interaction.impl.window.helpers.DialogLancet;
import com.ss.android.ugc.aweme.debug.LocalTestManager;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public class ExceptionUtils {
    private ExceptionUtils() {
    }

    public static void INVOKEVIRTUAL_com_bytedance_android_live_core_utils_ExceptionUtils_com_obric_assistant_interaction_impl_window_helpers_DialogLancet_show(AlertDialog r1) {
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

    public static boolean isErrorCodeMatch(ApiServerException r1) {
        if (r1.getErrorCode() != 20047) goto L5;
        return true;
    L5:
        return false;
    }

    public static boolean shouldShowBindPhone(Exception r1) {
        if ((r1 instanceof ApiServerException) == true) goto L5;
    L7:
        return false;
    L5:
        if (isErrorCodeMatch((ApiServerException) r1) == false) goto L7;
        return true;
    }

    public static void handleException(Context r1, Throwable r2) {
        handleException(r1, r2, s1.B(2131916038));
    }

    public static void handleExceptionWithOutCustom(Context r1, Throwable r2) {
        handleExceptionWithOutCustom(r1, r2, 0);
    }

    public static void showPopupToast(Context r2, String r3) {
        if (r2 != null) goto L4;
        return;
    L4:
        bc1.e r0 = new bc1.e(r2);
        r0.b.setVisibility(8);
        if (StringUtils.isEmpty(r3) == true) goto L7;
        r0.c.setText(r3);
        boolean r4 = true;
    L8:
        if (r4 == false) goto L31;
        r0.e.removeCallbacks(r0.f);
        if (r0.a.isShowing() == false) goto L25;
        bc1.e.a(r0.a);     // Catch: Exception -> L22
    L25:
        r0.a.getWindow().setGravity(17);     // Catch: Exception -> L24
        Dialog r5 = r0.a;     // Catch: Exception -> L24
        if (DialogLancet.shouldBlockDialogShow(r5) == false) goto L29;
        DialogLancet.handleBlockedDialogShow(r5);     // Catch: Exception -> L24
    L20:
        r0.e.postDelayed(r0.f, 2000);     // Catch: Exception -> L24
        return;
    L29:
        DialogLancet.sLastShowStack = new Throwable();     // Catch: Exception -> L23
    L19:
        DialogLancet.beforeDialogShow(r5);     // Catch: Exception -> L24
        r5.show();     // Catch: Exception -> L24
        DialogLancet.afterDialogShow(r5);     // Catch: Exception -> L24
    L32:
        return;
    L31:
        return;
    L7:
        r4 = false;
        goto L8
    }

    public static void displayAlert(Context r2, String r3, String r4) {
        if (r2 != null) goto L4;
        return;
    L4:
        AlertDialog.Builder r0 = new AlertDialog.Builder(r2);
        r0.setTitle(r2.getResources().getString(2131916050));
        r0.setMessage(r3);
        r0.setPositiveButton(r4, null);
        INVOKEVIRTUAL_com_bytedance_android_live_core_utils_ExceptionUtils_com_obric_assistant_interaction_impl_window_helpers_DialogLancet_show(r0.create());
    }

    public static void handleException(Context r2, Throwable r3, String r4) {
        if (r3 == null) goto L19;
        if (r2 != null) goto L6;
        return;
    L6:
        if ((r3 instanceof ApiServerException) == false) goto L16;
        ApiServerException r5 = (ApiServerException) r3;
        String r0 = r5.getPrompt();
        String r1 = r5.getAlert();
        if (r5.isBlockNotice() == false) goto L10;
    L17:
        LocalTestManager.a(new Class[]{wy.a.class});
        return;
    L10:
        if (TextUtils.isEmpty(r1) == true) goto L13;
        displayAlert(r2, r1, r2.getResources().getString(2131915973));
        goto L17
    L13:
        if (TextUtils.isEmpty(r0) == true) goto L15;
        IESUIUtils.displayToast(r2, r0);
        goto L17
    L15:
        IESUIUtils.displayToast(r2, r4);
        goto L17
    L16:
        IESUIUtils.displayToast(r2, r4);
        goto L17
    }

    public static void handleExceptionWithOutCustom(Context r3, Throwable r4, String r5) {
        if ((r4 instanceof ApiServerException) == false) goto L15;
        ApiServerException r6 = (ApiServerException) r4;
        if (r6.getErrorCode() == 20006) goto L15;
        String r0 = r6.getPrompt();
        String r2 = r6.getAlert();
        if (r6.isBlockNotice() == false) goto L9;
    L16:
        LocalTestManager.a(new Class[]{wy.a.class});
        return;
    L9:
        if (TextUtils.isEmpty(r2) == true) goto L12;
        displayAlert(r3, r2, r3.getResources().getString(2131915973));
        goto L16
    L12:
        if (TextUtils.isEmpty(r0) == true) goto L14;
        IESUIUtils.displayToast(r3, r0);
        goto L16
    L14:
        f2.c(r5, 0);
    L15:
        f2.c(r5, 0);
        goto L16
    }

    public static void handleException(Context r0, Throwable r1, int r2) {
        if (r2 > 0) goto L5;
        r2 = 2131916038;
    L5:
        handleException(r0, r1, s1.B(r2));
    }

    public static void handleExceptionWithOutCustom(Context r0, Throwable r1, int r2) {
        if (r2 > 0) goto L5;
        r2 = 2131916038;
    L5:
        handleExceptionWithOutCustom(r0, r1, s1.B(r2));
    }

    public static void throwError(int r2, RequestError r3, String r4, String r5, String r6) throws Exception {
        if (r3 != null) goto L4;
        r3 = new RequestError();
        r3.prompts = s1.B(2131916038);
    L4:
        CustomApiServerException r0 = new CustomApiServerException(r2, r3.url, r5, r6);
        r0.setErrorMsg(r3.message);
        r0.setPrompt(r3.prompts);
        r0.setAlert(r3.alert);
        r0.setBlockNotice(r3.isBlockNotice());
        r0.setExtra(r4);
        throw r0;
    }

    public static void throwError(int r1, RequestError r2, Extra r3, String r4, String r5) throws Exception {
        throwError(r1, r2, GsonProtectorUtils.toJson(GsonHelper.get(), r3), r4, r5);
    }
}
