package com.ss.android.lark.chameleon.util;

import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.util.DisplayMetrics;
import com.obric.assistant.interaction.impl.window.WindowDisplayMetricsOverride;
import com.ss.android.lark.chameleon.idependency.Log;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public class DarkModeContextExtension {
    private static final String TAG = "DarkModeContextExtension";
    private final Context mContext;
    private final int mOriginApplicationUiMode;

    public Context getContext() {
        return this.mContext;
    }

    public DarkModeContextExtension(Context r3) {
        this.mContext = r3;
        Configuration r4 = r3.getResources().getConfiguration();
        this.mOriginApplicationUiMode = r4.uiMode;
        Log.i(TAG, "origin config=" + r4);
    }

    public static DisplayMetrics INVOKEVIRTUAL_com_ss_android_lark_chameleon_util_DarkModeContextExtension_com_obric_assistant_interaction_impl_window_helpers_ResourcesLancet_getDisplayMetrics(Resources r1) {
        return WindowDisplayMetricsOverride.apply(r1, r1.getDisplayMetrics());
    }

    public void injectRedirectConfiguration(Context r5) {
        Configuration r0 = r5.getResources().getConfiguration();
        Log.i(TAG, "merge config=" + r0);
        int r1 = this.mOriginApplicationUiMode;
        if (r1 != r0.uiMode) goto L5;
        Log.i(TAG, "redirect pass");
        return;
    L5:
        r0.uiMode = r1;
        r5.getResources().updateConfiguration(r0, INVOKEVIRTUAL_com_ss_android_lark_chameleon_util_DarkModeContextExtension_com_obric_assistant_interaction_impl_window_helpers_ResourcesLancet_getDisplayMetrics(r5.getResources()));
        Log.i(TAG, "redirect config=" + r5.getResources().getConfiguration());
    }
}
