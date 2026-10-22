package com.bytedance.apm.agent.v2.instrumentation;

import android.text.TextUtils;
import androidx.annotation.Keep;
import com.bytedance.apm.agent.tracing.AutoPageTraceHelper;
import e.b;
import h.a;

/* JADX INFO: loaded from: classes.dex */
@Keep
public class ActivityAgent {
    private static final String TAG = "ActivityInstrumentation";

    public ActivityAgent() {
    }

    @Keep
    public static void onTrace(String r10, String r11, boolean r12) {
        if (r12 == false) goto L9;
        if (a.f9124a == false) goto L9;
        if (TextUtils.equals("onResume", r11) == false) goto L9;
        b.a(r10, true);
    L9:
        if (a.f9125b == true) goto L11;
        return;
    L11:
        AutoPageTraceHelper.onTrace(r10, r11, r12);
    }
}
