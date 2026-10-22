package com.bytedance.android.live.browser.jsbridge.upload;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Handler;
import android.os.Looper;
import androidx.fragment.app.Fragment;
import com.bytedance.android.live.core.monitor.LiveSlardarConstants;
import com.bytedance.android.live.core.setting.SettingKey;
import com.bytedance.bpea.cert.token.TokenCert;
import com.bytedance.ies.web.jsbridge2.CallContext;
import com.google.gson.annotations.SerializedName;
import com.obric.assistant.interaction.impl.window.helpers.DialogLancet;
import io.reactivex.disposables.Disposable;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public final class i0 extends com.bytedance.ies.web.jsbridge2.f<JSONObject, a> {
    public Disposable a;
    public Fragment b;
    public ProgressDialog c;
    public CallContext d;
    public TokenCert e;

    public static final class a {

        @SerializedName("code")
        int code;

        @SerializedName("uri")
        String uri;

        @SerializedName(LiveSlardarConstants.EXTRA_KEY_URL)
        String url;

        public a(String r2, String r3) {
            this.code = 1;
            this.uri = r2;
            this.url = r3;
        }
    }

    public final void k() {
        ProgressDialog r0 = this.c;
        if (r0 == null) goto L5;
        j(r0);
        this.c = null;
    L5:
        finishWithFailure();
    }

    public final void onTerminate() {
        Disposable r0 = this.a;
        if (r0 == null) goto L5;
        r0.dispose();
    L5:
        this.b = null;
        this.d = null;
    }

    public i0(Fragment r2) {
        this.e = TokenCert.with("bpea-live_uploadVideo_jsb_upload_video_method");
        this.b = r2;
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

    public final void invoke(Object r4, CallContext r5) throws Exception {
        JSONObject r6 = (JSONObject) r4;
        this.d = r5;
        int r0 = r6.optInt("action_type", 0);
        String r1 = r6.optString("token", "");
        if (r1 != null) goto L5;
    L7:
        if (r0 != 0) goto L10;
        Activity r2 = (Activity) r5.getContext();
        SettingKey<Boolean> r3 = m60.i.a;
        new m60.i.b(r2).b(new g0(this, r6, r5), null, this.e, new String[]{"android.permission.CAMERA"});
        return;
    L10:
        if (r0 != 1) goto L19;
        Intent r7 = new Intent("android.intent.action.GET_CONTENT");
        r7.setType("video/*");
        Fragment r8 = this.b;
        if (r8 != null) goto L14;
        return;
    L14:
        if (r8.getActivity() != null) goto L16;
        finishWithFailure();
        return;
    L16:
        this.b.startActivityForResult(r7, 9002);
        return;
    L19:
        return;
    L5:
        if (r1.isEmpty() == true) goto L7;
        this.e = TokenCert.with(r1);
        goto L7
    }
}
