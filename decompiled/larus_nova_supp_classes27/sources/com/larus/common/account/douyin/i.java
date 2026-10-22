package com.larus.common.account.douyin;

import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import com.bytedance.sdk.account.impl.p;
import com.bytedance.sdk.account.platform.PlatformLoginAdapter;
import com.ixigua.lib.track.TrackParams;
import com.larus.account.base.model.LoginPlatform;
import com.larus.common.apphost.AppHost;
import com.larus.common_ui.dialog.l0;
import com.larus.utils.logger.FLogger;
import com.obric.assistant.interaction.impl.window.helpers.DialogLancet;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;
import tx9.w0;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
public final class i extends PlatformLoginAdapter {
    public String a;
    public final /* synthetic */ n38.h b;
    public final /* synthetic */ LoginPlatform c;
    public final /* synthetic */ String d;
    public final /* synthetic */ DouyinLogin e;

    public static final class a extends sa7.h<ua7.h> {
        public final /* synthetic */ DouyinLogin a;
        public final /* synthetic */ n38.h b;
        public final /* synthetic */ LoginPlatform c;
        public final /* synthetic */ String d;

        public static void a(l0 r3) {
            Handler r0 = DialogLancet.resolveDialogHandler(r3);
            if (r0 != null) goto L5;
        L8:
            DialogLancet.beforeDialogDismiss(r3);
            r3.dismiss();     // Catch: Throwable -> L11 Exception -> L13
        L17:
            DialogLancet.afterDialogDismiss(r3);
            return;
        L13:
            e = move-exception;
            com.bytedance.crash.d.d(e, "DIALOG_DISMISS_EXCEPTION");     // Catch: Throwable -> L11
            Throwable r1 = DialogLancet.sLastShowStack;     // Catch: Throwable -> L11
            if (r1 == null) goto L17;
            com.bytedance.crash.d.d(r1, "DIALOG_SHOW_STACK_TRACE");     // Catch: Throwable -> L11
        L11:
            th = move-exception;
            DialogLancet.afterDialogDismiss(r3);
            throw th;
        L5:
            if (Looper.myLooper() == r0.getLooper()) goto L8;
            r0.post(DialogLancet.createDismissRunnable(r3));
        }

        public final void onSuccess(ua7.b r5) {
            ua7.h r6 = (ua7.h) r5;
            l0 r7 = this.a.b;
            if (r7 == null) goto L7;
            boolean r0 = true;
            if (r7.isShowing() != true) goto L7;
        L8:
            if (r0 == true) goto L17;
        L15:
            this.a.b = null;
            this.b.b(this.c, this.d, Boolean.TRUE);
            return;
        L17:
            l0 r8 = this.a.b;     // Catch: Exception -> L13
            if (r8 == null) goto L15;
            a(r8);     // Catch: Exception -> L13
        L13:
            e = move-exception;
            FLogger.a.e(this.a.a, "dismiss commonLoadDialog exception: " + e.getMessage());
        L7:
            r0 = false;
            goto L8
        }

        public final void onError(ua7.b r13, int r14) {
            ua7.h r15 = (ua7.h) r13;
            l0 r0 = this.a.b;
            if (r0 == null) goto L7;
            boolean r1 = true;
            if (r0.isShowing() != true) goto L7;
        L8:
            if (r1 == true) goto L22;
        L15:
            this.a.b = null;
            n38.h r2 = this.b;
            LoginPlatform r3 = this.c;
            if (r15 == null) goto L19;
            String r16 = ((ua7.b) r15).i;
            if (r16 == null) goto L19;
        L20:
            n38.h.a.a(r2, r3, r14, r16, this.d, null, null, null, null, 480);
            return;
        L19:
            r16 = "";
            goto L20
        L22:
            l0 r4 = this.a.b;     // Catch: Exception -> L13
            if (r4 == null) goto L15;
            a(r4);     // Catch: Exception -> L13
        L13:
            e = move-exception;
            FLogger.a.e(this.a.a, "dismiss commonLoadDialog exception: " + e.getMessage());
        L7:
            r1 = false;
            goto L8
        }

        public a(DouyinLogin r1, n38.h r2, LoginPlatform r3, String r4) {
            this.a = r1;
            this.b = r2;
            this.c = r3;
            this.d = r4;
        }
    }

    public final void onLoginError(ua7.h r14) {
        Intrinsics.checkNotNullParameter(r14, "response");
        w0.d("normal", "host", "douyin_login", 0, null, null, null, null, null, null, null, 4064);
        FLogger.a.i(this.e.a, "onLoginError, error:" + ((ua7.b) r14).g + ", detailErrorMsg: " + ((ua7.b) r14).j);
        int r5 = ((ua7.b) r14).g;
        if (r5 != this.e.i) goto L17;
        JSONObject r0 = new JSONObject();
        Intrinsics.checkNotNullParameter(r0, "params");
        TrackParams r1 = new TrackParams().merge(r0);
        by7.a r2 = new by7.a("handle_login_1041");
        r2.a.merge(r1);
        r2.b();
        l0 r3 = this.e.b;     // Catch: Exception -> L14
        if (r3 != null) goto L8;
    L22:
    L16:
        p.t().v(this.e.e, "aweme_v2", r14.y, MapsKt.mapOf(TuplesKt.to("app_name", AppHost.a.getAppName())), new a(this.e, this.b, this.c, this.d));
        return;
    L8:
        if (DialogLancet.shouldBlockDialogShow(r3) == false) goto L20;
        DialogLancet.handleBlockedDialogShow(r3);     // Catch: Exception -> L14
        goto L22
    L20:
        DialogLancet.sLastShowStack = new Throwable();     // Catch: Exception -> L19
    L12:
        DialogLancet.beforeDialogShow(r3);     // Catch: Exception -> L14
        r3.show();     // Catch: Exception -> L14
        DialogLancet.afterDialogShow(r3);     // Catch: Exception -> L14
    L14:
        e = move-exception;
        FLogger.a.e(this.e.a, "show commonLoadDialog exception: " + e.getMessage());
        goto L16
    L17:
        n38.h.a.a(this.b, this.c, r5, ((ua7.b) r14).i, this.d, null, Integer.valueOf(((ua7.b) r14).h), ((ua7.b) r14).j, null, 256);
        this.e.b = null;
    }

    public final void onLoginSuccess(ua7.h r14) {
        Intrinsics.checkNotNullParameter(r14, "response");
        w0.d("normal", "host", "douyin_login", 1, this.a, null, null, null, null, null, null, 4064);
        com.ss.android.account.d r15 = r14.p;
        if (r15 == null) goto L7;
        boolean r0 = true;
        if (((sc7.a) r15).g != true) goto L7;
    L8:
        this.b.b(this.c, this.d, Boolean.valueOf(r0));
        this.e.b = null;
        return;
    L7:
        r0 = false;
        goto L8
    }

    public final void onSuccess(Bundle r2) {
        if (r2 == null) goto L4;
        String r0 = r2.getString("granted_permission");
    L5:
        this.a = r0;
        super.onSuccess(r2);
        return;
    L4:
        r0 = null;
        goto L5
    }

    public i(com.larus.account.base.impl.n r7, LoginPlatform r8, String r9, DouyinLogin r10, Context r11, String r12) {
        this.b = r7;
        this.c = r8;
        this.d = r9;
        this.e = r10;
        super(r11, r12, "aweme_v2", false, false);
    }
}
