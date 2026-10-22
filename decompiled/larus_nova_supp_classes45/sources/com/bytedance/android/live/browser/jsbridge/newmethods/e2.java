package com.bytedance.android.live.browser.jsbridge.newmethods;

import android.app.Activity;
import android.text.TextUtils;
import androidx.fragment.app.DialogFragment;
import com.bytedance.android.live.browser.container.HybridContainerManager;
import com.bytedance.android.livesdkapi.TTLiveServiceMiddleware;
import com.bytedance.android.livesdkapi.service.IMiddlewareLiveService;
import com.bytedance.ies.web.jsbridge2.CallContext;
import com.bytedance.mt.protector.impl.UriProtector;
import com.obric.assistant.interaction.impl.window.helpers.DialogFragmentLancet;
import kotlin.Lazy;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public final class e2 extends com.bytedance.ies.web.jsbridge2.g<JSONObject, Object> {
    public final DialogFragment a;
    public final Activity b;

    public e2(Activity r1, DialogFragment r2) {
        this.a = r2;
        this.b = r1;
    }

    public final Object invoke(Object r5, CallContext r6) {
        JSONObject r7 = (JSONObject) r5;
        Intrinsics.checkNotNullParameter(r7, "params");
        Intrinsics.checkNotNullParameter(r6, "context");
        String r0 = r7.optString("containerID");
        String r8 = r7.optString("schema");
        boolean r2 = true;
        if (TextUtils.isEmpty(r0) == true) goto L8;
        Lazy r1 = HybridContainerManager.a;
        Intrinsics.checkNotNull(r0);
        if (HybridContainerManager.a(r0) == true) goto L7;
        terminate("containerID is invalid");
    L7:
        boolean r3 = true;
    L9:
        if (r3 == true) goto L22;
        DialogFragment r4 = this.a;
        if (r4 != null) goto L35;
        Activity r9 = this.b;
        if (r9 == null) goto L21;
        r9.finish();
        goto L22
    L21:
        terminate();
        goto L22
    L35:
        r4.dismissAllowingStateLoss();     // Catch: Exception -> L14
    L14:
        e = move-exception;
        com.bytedance.crash.d.d(e, "DIALOG_FRAGMENT_DISMISS_ALLOWING_STATE_LOSS_EXCEPTION");
        Throwable r11 = DialogFragmentLancet.sLastShowStack;
        if (r11 == null) goto L22;
        com.bytedance.crash.d.d(r11, "DIALOG_FRAGMENT_SHOW_STACK_TRACE");
    L22:
        if (r8 != null) goto L24;
    L27:
        if (r2 == false) goto L29;
        terminate("schema is null");
    L29:
        if (r8 == null) goto L37;
        IMiddlewareLiveService r12 = TTLiveServiceMiddleware.getLiveService();
        if (r12 == null) goto L38;
        r12.handleSchema(r6.getContext(), UriProtector.parse(r8));
        return null;
    L38:
        return null;
    L37:
        return null;
    L24:
        if (r8.length() == 0) goto L27;
        r2 = false;
        goto L27
    L8:
        r3 = false;
        goto L9
    }
}
