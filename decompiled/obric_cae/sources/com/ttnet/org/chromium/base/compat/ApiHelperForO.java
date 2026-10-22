package com.ttnet.org.chromium.base.compat;

import android.annotation.TargetApi;
import android.content.pm.PackageManager;
import android.content.res.Configuration;
import android.view.Display;
import android.view.View;
import com.ttnet.org.chromium.base.annotations.DoNotInline;

/* JADX INFO: loaded from: classes2.dex */
@TargetApi(26)
@DoNotInline
public final class ApiHelperForO {
    private ApiHelperForO() {
    }

    public static boolean isInstantApp(PackageManager r8) {
        return r8.isInstantApp();
    }

    public static boolean isScreenWideColorGamut(Configuration r8) {
        return r8.isScreenWideColorGamut();
    }

    public static boolean isWideColorGamut(Display r8) {
        return r8.isWideColorGamut();
    }

    public static void setDefaultFocusHighlightEnabled(View r8, boolean r10) {
        r8.setDefaultFocusHighlightEnabled(r10);
    }
}
