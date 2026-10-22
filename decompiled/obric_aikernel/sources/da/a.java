package da;

import android.app.Activity;
import android.content.res.Resources;
import android.view.Window;
import android.view.WindowInsetsController;
import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatDelegate;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes2.dex */
public final class a {
    static {
        new a();
    }

    private a() {
    }

    @JvmStatic
    @RequiresApi(30)
    public static final void a(Activity r10) {
        Intrinsics.checkNotNullParameter(r10, "$this$adaptLightDarkStatusBar");
        Window r11 = r10.getWindow();
        if (r11 == null) goto L5;
        WindowInsetsController r12 = r11.getInsetsController();
    L6:
        if (r12 != null) goto L8;
        return;
    L8:
        if (c() == false) goto L10;
    L13:
        r12.setSystemBarsAppearance(0, 8);
        return;
    L10:
        if (b() == true) goto L13;
        r12.setSystemBarsAppearance(8, 8);
        return;
    L5:
        r12 = null;
        goto L6
    }

    @JvmStatic
    public static final boolean b() {
        if (AppCompatDelegate.getDefaultNightMode() != 2) goto L5;
        boolean r10 = true;
    L6:
        ea.b.a("ActivityUtils", "isAppInDarkTheme: " + r10);
        return r10;
    L5:
        r10 = false;
        goto L6
    }

    @JvmStatic
    public static final boolean c() {
        Resources r10 = Resources.getSystem();
        Intrinsics.checkNotNullExpressionValue(r10, "Resources.getSystem()");
        int r11 = r10.getConfiguration().uiMode & 48;
        if (r11 != 32) goto L5;
        boolean r12 = true;
    L6:
        ea.b.a("ActivityUtils", "isSystemInDarkTheme: " + r12 + ", currentNightMode" + r11);
        return r12;
    L5:
        r12 = false;
        goto L6
    }
}
