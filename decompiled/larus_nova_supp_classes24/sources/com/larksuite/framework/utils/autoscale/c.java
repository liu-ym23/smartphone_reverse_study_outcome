package com.larksuite.framework.utils.autoscale;

import android.app.UiModeManager;
import android.content.res.AssetManager;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.Build;
import android.util.DisplayMetrics;
import com.obric.assistant.interaction.impl.window.WindowDisplayMetricsOverride;
import com.ss.android.lark.log.Log;
import com.ss.android.lark.utils.CarUtils;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes24.dex */
public final class c extends Resources {
    @Override // android.content.res.Resources
    public final Configuration getConfiguration() {
        Configuration r0 = super.getConfiguration();
        int r1 = a.a;
        Intrinsics.checkNotNull(r0);
        Intrinsics.checkNotNullParameter(r0, "configuration");
        return r0;
    }

    @Override // android.content.res.Resources
    public final DisplayMetrics getDisplayMetrics() {
        DisplayMetrics r0 = WindowDisplayMetricsOverride.apply(this, super.getDisplayMetrics());
        int r1 = a.a;
        Intrinsics.checkNotNull(r0);
        a.a(r0);
        return r0;
    }

    public c(Resources r9) {
        Intrinsics.checkNotNullParameter(r9, "base");
        AssetManager r0 = r9.getAssets();
        DisplayMetrics r1 = WindowDisplayMetricsOverride.apply(r9, r9.getDisplayMetrics());
        String[] r2 = CarUtils.a;
        Configuration r10 = r9.getConfiguration();
        Intrinsics.checkNotNullParameter(r10, "<this>");
        if (CarUtils.b() == true) goto L5;
    L20:
        super(r0, r1, r10);
        int r11 = a.a;
        a.a(WindowDisplayMetricsOverride.apply(this, super.getDisplayMetrics()));
        Intrinsics.checkNotNullParameter(super.getConfiguration(), "configuration");
        return;
    L5:
        if (Build.VERSION.SDK_INT < 23) goto L20;
        int r3 = r10.uiMode;
        boolean r5 = true;
        if (((UiModeManager) com.larksuite.framework.utils.b.a.getSystemService(UiModeManager.class)).getNightMode() != 2) goto L9;
        boolean r4 = true;
    L10:
        int r7 = 32;
        if ((r3 & 48) == 32) goto L15;
        if (r3 == 0) goto L15;
        r5 = false;
    L15:
        if (r4 == r5) goto L20;
        if (r4 == true) goto L19;
        r7 = 16;
    L19:
        r10.uiMode = r7;
        Log.i("CarUtils", "fixUIMode, before: " + r3 + ", after: " + r10.uiMode);
        goto L20
    L9:
        r4 = false;
        goto L10
    }

    @Override // android.content.res.Resources
    public final float getDimension(int r2) {
        int r0 = a.a;
        a.a(WindowDisplayMetricsOverride.apply(this, super.getDisplayMetrics()));
        return super.getDimension(r2);
    }

    @Override // android.content.res.Resources
    public final int getDimensionPixelOffset(int r2) {
        int r0 = a.a;
        a.a(WindowDisplayMetricsOverride.apply(this, super.getDisplayMetrics()));
        return super.getDimensionPixelOffset(r2);
    }

    @Override // android.content.res.Resources
    public final int getDimensionPixelSize(int r2) {
        int r0 = a.a;
        a.a(WindowDisplayMetricsOverride.apply(this, super.getDisplayMetrics()));
        return super.getDimensionPixelSize(r2);
    }

    @Override // android.content.res.Resources
    public final void updateConfiguration(Configuration r1, DisplayMetrics r2) {
        super.updateConfiguration(r1, r2);
        int r3 = a.a;
        a.a(WindowDisplayMetricsOverride.apply(this, super.getDisplayMetrics()));
        Intrinsics.checkNotNullParameter(super.getConfiguration(), "configuration");
    }
}
