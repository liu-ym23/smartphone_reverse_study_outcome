package com.bytedance.android.annie.bridge.method;

import android.app.Activity;
import androidx.fragment.app.DialogFragment;
import com.bytedance.android.annie.container.fragment.AnnieFragmentManager;
import com.bytedance.ies.web.jsbridge2.CallContext;
import com.bytedance.mt.protector.impl.UriProtector;
import com.bytedance.sdk.xbridge.annotations.XBridgeMethod;
import com.obric.assistant.interaction.impl.window.helpers.DialogFragmentLancet;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
@XBridgeMethod(biz = "webcast_sdk", name = "closeAndOpen")
public final class i extends com.bytedance.ies.web.jsbridge2.g<JSONObject, Object> {
    public final Activity a;
    public final DialogFragment b;

    public i(m16.b r10) {
        Intrinsics.checkNotNullParameter(r10, "providerFactory");
        DialogFragment r0 = (DialogFragment) r10.c(DialogFragment.class);
        if (r0 == null) goto L5;
        this.b = r0;
    L5:
        Activity r11 = (Activity) r10.c(Activity.class);
        if (r11 == null) goto L9;
        this.a = r11;
        return;
    }

    public i(DialogFragment r10) {
        Intrinsics.checkNotNullParameter(r10, "fragment");
        this.b = r10;
    }

    public i(Activity r1) {
        this.a = r1;
    }

    public final Object invoke(Object r10, CallContext r11) {
        JSONObject r12 = (JSONObject) r10;
        Intrinsics.checkNotNullParameter(r12, "params");
        Intrinsics.checkNotNullParameter(r11, "context");
        String r0 = r12.optString("containerID");
        String r13 = r12.optString(com.bytedance.android.ec.core.event.a.KEY_SCHEMA);
        boolean r1 = true;
        if (r0 != null) goto L5;
    L8:
        boolean r14 = true;
    L9:
        if (r14 == false) goto L11;
        boolean r15 = false;
    L15:
        if (r15 == true) goto L28;
        DialogFragment r16 = this.b;
        if (r16 != null) goto L39;
        Activity r17 = this.a;
        if (r17 == null) goto L27;
        r17.finish();
        goto L28
    L27:
        terminate();
        goto L28
    L39:
        r16.dismissAllowingStateLoss();     // Catch: Exception -> L20
    L20:
        e = move-exception;
        com.bytedance.crash.d.d(e, "DIALOG_FRAGMENT_DISMISS_ALLOWING_STATE_LOSS_EXCEPTION");
        Throwable r18 = DialogFragmentLancet.sLastShowStack;
        if (r18 == null) goto L28;
        com.bytedance.crash.d.d(r18, "DIALOG_FRAGMENT_SHOW_STACK_TRACE");
    L28:
        if (r13 != null) goto L30;
    L33:
        if (r1 == false) goto L36;
        terminate("schema is null");
    L36:
        if (r13 == null) goto L38;
        Boolean.valueOf(w9.a.a.j0(r11.getContext(), UriProtector.parse(r13), null, null)).booleanValue();
    L38:
        return null;
    L30:
        if (r13.length() == 0) goto L33;
        r1 = false;
        goto L33
    L11:
        if (AnnieFragmentManager.a(r0, false, 6) == true) goto L13;
        terminate("containerID is invalid");
    L13:
        r15 = true;
        goto L15
    L5:
        if (StringsKt.isBlank(r0) == true) goto L8;
        r14 = false;
        goto L9
    }
}
