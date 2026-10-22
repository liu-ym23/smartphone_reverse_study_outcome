package com.bytedance.android.live.browser.jsbridge.newmethods;

import android.app.Activity;
import android.text.TextUtils;
import androidx.fragment.app.DialogFragment;
import com.bytedance.android.live.browser.container.HybridContainerManager;
import com.bytedance.ies.web.jsbridge2.CallContext;
import com.obric.assistant.interaction.impl.window.helpers.DialogFragmentLancet;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public final class d2 extends com.bytedance.ies.web.jsbridge2.g<JSONObject, Object> {
    public final DialogFragment a;
    public final Activity b;

    public d2(Activity r1) {
        this.b = r1;
    }

    public d2(DialogFragment r1) {
        this.a = r1;
    }

    public final Object invoke(Object r1, CallContext r2) throws Exception {
        String r3 = ((JSONObject) r1).optString("containerID");
        if (TextUtils.isEmpty(r3) == false) goto L5;
        DialogFragment r4 = this.a;
        if (r4 != null) goto L21;
        Activity r5 = this.b;
        if (r5 == null) goto L18;
        r5.finish();
        return null;
    L18:
        terminate();
        return null;
    L21:
        r4.dismissAllowingStateLoss();     // Catch: Exception -> L11
        return null;
    L11:
        e = move-exception;
        com.bytedance.crash.d.d(e, "DIALOG_FRAGMENT_DISMISS_ALLOWING_STATE_LOSS_EXCEPTION");
        Throwable r6 = DialogFragmentLancet.sLastShowStack;
        if (r6 == null) goto L25;
        com.bytedance.crash.d.d(r6, "DIALOG_FRAGMENT_SHOW_STACK_TRACE");
        return null;
    L25:
        return null;
    L5:
        if (HybridContainerManager.a(r3) == true) goto L23;
        terminate("containerID is invalid");
        return null;
    L23:
        return null;
    }
}
