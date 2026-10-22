package com.bytedance.android.live.browser.jsbridge.method.dialog;

import android.content.Context;
import android.text.TextUtils;
import androidx.fragment.app.DialogFragment;
import com.obric.assistant.interaction.impl.window.helpers.DialogFragmentLancet;
import e30.d;
import java.lang.ref.WeakReference;
import n56.f;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public final class a extends d {
    public final DialogFragment d;

    public a(WeakReference<Context> r1, DialogFragment r2) {
        super(r1);
        this.d = r2;
    }

    @Override // e30.a
    public void call(f r1, JSONObject r2) throws Exception {
        super.call(r1, r2);
        if (TextUtils.equals(r1.d.optString("type"), "gift_panel") == true) goto L12;
        return;
    L12:
        this.d.dismissAllowingStateLoss();     // Catch: Exception -> L7
        return;
    L7:
        e = move-exception;
        com.bytedance.crash.d.d(e, "DIALOG_FRAGMENT_DISMISS_ALLOWING_STATE_LOSS_EXCEPTION");
        Throwable r3 = DialogFragmentLancet.sLastShowStack;
        if (r3 == null) goto L15;
        com.bytedance.crash.d.d(r3, "DIALOG_FRAGMENT_SHOW_STACK_TRACE");
        return;
    }
}
