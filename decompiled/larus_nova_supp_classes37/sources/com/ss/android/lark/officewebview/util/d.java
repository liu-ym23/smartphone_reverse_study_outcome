package com.ss.android.lark.officewebview.util;

import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;
import com.obric.assistant.interaction.impl.window.WindowDisplayMetricsOverride;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
public final class d {
    public final Context a;
    public final int b;

    public Context getContext() {
        return this.a;
    }

    public d(Context r3) {
        this.a = r3;
        Configuration r4 = r3.getResources().getConfiguration();
        this.b = r4.uiMode;
        com.ss.android.lark.officesdk.utils.di.j.e("DarkModeContextExtension", "origin config=" + r4);
    }

    public final void a(Context r6) {
        Configuration r0 = r6.getResources().getConfiguration();
        com.ss.android.lark.officesdk.utils.di.j.e("DarkModeContextExtension", "merge config=" + r0);
        int r1 = this.b;
        if (r1 != r0.uiMode) goto L5;
        com.ss.android.lark.officesdk.utils.di.j.e("DarkModeContextExtension", "redirect pass");
        return;
    L5:
        r0.uiMode = r1;
        Resources r2 = r6.getResources();
        Resources r3 = r6.getResources();
        r2.updateConfiguration(r0, WindowDisplayMetricsOverride.apply(r3, r3.getDisplayMetrics()));
        com.ss.android.lark.officesdk.utils.di.j.e("DarkModeContextExtension", "redirect config=" + r6.getResources().getConfiguration());
    }
}
