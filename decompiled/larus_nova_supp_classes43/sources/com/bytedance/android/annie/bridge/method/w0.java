package com.bytedance.android.annie.bridge.method;

import android.app.Activity;
import androidx.fragment.app.DialogFragment;
import com.bytedance.android.annie.Annie;
import com.bytedance.android.annie.bridge.method.abs.LoginResultModel;
import com.bytedance.android.annie.service.userinfo.IUserInfoService;
import com.bytedance.ies.web.jsbridge2.CallContext;
import com.bytedance.sdk.xbridge.annotations.XBridgeMethod;
import com.google.gson.JsonObject;
import com.obric.assistant.interaction.impl.window.helpers.DialogFragmentLancet;
import java.lang.ref.WeakReference;
import java.util.Iterator;
import java.util.LinkedHashMap;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
@XBridgeMethod(biz = "webcast_sdk", name = "login")
public final class w0 extends e7.k<e7.l0, LoginResultModel> {
    public final WeakReference<Activity> a;
    public final DialogFragment b;

    public w0(m16.b r10) {
        Intrinsics.checkNotNullParameter(r10, "providerFactory");
        Activity r0 = (Activity) r10.c(Activity.class);
        if (r0 == null) goto L5;
        this.a = new WeakReference(r0);
    L5:
        DialogFragment r11 = (DialogFragment) r10.c(DialogFragment.class);
        if (r11 == null) goto L9;
        this.b = r11;
        return;
    }

    public w0(WeakReference<Activity> r10, DialogFragment r11) {
        Intrinsics.checkNotNullParameter(r10, "activityRef");
        this.a = r10;
        this.b = r11;
    }

    public final void invoke(Object r10, CallContext r11) {
        e7.l0 r12 = (e7.l0) r10;
        Intrinsics.checkNotNullParameter(r12, "params");
        Intrinsics.checkNotNullParameter(r11, "context");
        Boolean r0 = r12.a();
        if (r0 == null) goto L5;
        boolean r1 = r0.booleanValue();
    L6:
        IUserInfoService r13 = (IUserInfoService) Annie.getService(IUserInfoService.class, r11.a());
        r13.hasLogin();
        LinkedHashMap r14 = new LinkedHashMap();
        JsonObject r15 = r12.getContext();
        if (r15 == null) goto L12;
        Iterator r16 = r15.keySet().iterator();
    L10:
        if (r16.hasNext() == false) goto L12;
        String r17 = (String) r16.next();
        r14.put(r17, r15.get(r17).getAsString().toString());
    L12:
        v0 r18 = new v0(r13, this);
        WeakReference<Activity> r19 = this.a;
        Unit r20 = null;
        if (r19 == null) goto L30;
        Activity r21 = r19.get();
        if (r21 == null) goto L30;
        if (r1 == false) goto L18;
        r13.z1(r21, r18);
    L29:
        r20 = Unit.INSTANCE;
        goto L30
    L18:
        IUserInfoService.LoginParamsExt r22 = new IUserInfoService.LoginParamsExt();
        r22.setKeepOpen(r1);
        Unit r23 = Unit.INSTANCE;
        r13.U(r21, r18, r22);
        DialogFragment r24 = this.b;
        if (r24 != null) goto L33;
    L27:
        if (r20 != null) goto L29;
        r21.finish();
        goto L29
    L33:
        r24.dismissAllowingStateLoss();     // Catch: Exception -> L22
    L26:
        r20 = Unit.INSTANCE;
    L22:
        e = move-exception;
        com.bytedance.crash.d.d(e, "DIALOG_FRAGMENT_DISMISS_ALLOWING_STATE_LOSS_EXCEPTION");
        Throwable r25 = DialogFragmentLancet.sLastShowStack;
        if (r25 == null) goto L26;
        com.bytedance.crash.d.d(r25, "DIALOG_FRAGMENT_SHOW_STACK_TRACE");
    L30:
        if (r20 != null) goto L36;
        LoginResultModel r26 = new LoginResultModel();
        r26.b(LoginResultModel.Code.Failed);
        r26.a(Boolean.FALSE);
        r26.c("Activity is Null");
        finishWithResult(r26);
        return;
    L36:
        return;
    L5:
        r1 = true;
        goto L6
    }
}
