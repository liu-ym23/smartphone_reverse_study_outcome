package com.obric.assistant.settings;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import androidx.appcompat.app.AppCompatDelegate;
import com.larus.common_ui.activity.FlowCommonAppCompatActivity;
import com.larus.utils.logger.FLogger;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
public final class c0 {
    public static final void a(FlowCommonAppCompatActivity r7) {
        Intrinsics.checkNotNullParameter(r7, "<this>");
        int r0 = r7.getResources().getConfiguration().uiMode & 48;
        String r1 = r7.getIntent().getStringExtra("theme_source");
        if (r1 != null) goto L5;
        r1 = "assistant";
    L5:
        boolean r4 = true;
        int r5 = -1;
        if (Intrinsics.areEqual(r1, "system") == true) goto L14;
        int r2 = AppCompatDelegate.getDefaultNightMode();
        if (r2 == (-1)) goto L13;
        if (r2 == 1) goto L13;
        if (r2 != 2) goto L14;
    L13:
        r5 = r2;
    L14:
        if (r5 == 1) goto L19;
        if (r5 != 2) goto L17;
    L20:
        FLogger.a.d(r7.getClass().getSimpleName(), "applyObricSettingThemeFromIntent themeSource=" + r1 + ", targetNightMode=" + r5 + ", isNightMode=" + r4);
        r7.getDelegate().setLocalNightMode(r5);
        boolean r8 = v19.h.a;
        v19.h.a = r4;
        return;
    L17:
        if (r0 == 32) goto L20;
    L19:
        r4 = false;
        goto L20
    }

    public static final String c(Context r1) {
        Intrinsics.checkNotNullParameter(r1, "<this>");
        if ((r1 instanceof Activity) == false) goto L5;
        Activity r2 = (Activity) r1;
    L6:
        if (r2 == null) goto L11;
        Intent r3 = r2.getIntent();
        if (r3 == null) goto L11;
        String r4 = r3.getStringExtra("theme_source");
        if (r4 == null) goto L11;
        return r4;
    L11:
        return "assistant";
    L5:
        r2 = null;
        goto L6
    }

    public static final void b(Intent r1, Context r2) {
        Intrinsics.checkNotNullParameter(r1, "<this>");
        if (r2 == null) goto L5;
        String r3 = c(r2);
    L6:
        r1.putExtra("theme_source", r3);
        return;
    L5:
        r3 = null;
        goto L6
    }
}
