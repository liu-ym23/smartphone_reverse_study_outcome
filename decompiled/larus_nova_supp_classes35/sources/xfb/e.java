package xfb;

import android.content.Context;
import android.content.res.Resources;
import android.provider.Settings;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.WindowManager;
import com.ss.android.floatbubble.util.RomUtils;
import com.ss.android.lark.log.Log;
import kotlin.Deprecated;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
@Deprecated(message = "use DisplayCompatUtils")
public final class e {
    public static final /* synthetic */ int a = 0;

    static {
    }

    public static int a(Context r7) {
        Intrinsics.checkNotNullParameter(r7, "context");
        Intrinsics.checkNotNullParameter(r7, "context");
        if (b(r7) == 0) goto L21;
        boolean r2 = true;
        if ((!TextUtils.isEmpty(RomUtils.a("ro.build.version.emui"))) == true) goto L8;
    L13:
        Object r0 = r7.getSystemService("window");
        Intrinsics.checkNotNull(r0, "null cannot be cast to non-null type android.view.WindowManager");
        Display r1 = ((WindowManager) r0).getDefaultDisplay();
        DisplayMetrics r3 = new DisplayMetrics();
        r1.getRealMetrics(r3);
        int r4 = r3.heightPixels;
        int r5 = r3.widthPixels;
        DisplayMetrics r6 = new DisplayMetrics();
        r1.getMetrics(r6);
        int r8 = r6.heightPixels;
        int r9 = r6.widthPixels;
        if ((b(r7) + r8) > r4) goto L21;
        if ((r5 - r9) <= 0) goto L19;
    L22:
        if (r2 == true) goto L24;
        return 0;
    L24:
        return b(r7);
    L19:
        if ((r4 - r8) <= 0) goto L21;
    L8:
        if (Settings.Global.getInt(r7.getContentResolver(), "navigationbar_is_min", 0) == 0) goto L10;
        boolean r10 = true;
    L11:
        if (r10 == false) goto L13;
    L10:
        r10 = false;
    L21:
        r2 = false;
        goto L22
    }

    public static int b(Context r3) {
        Intrinsics.checkNotNullParameter(r3, "context");
        Resources r4 = r3.getResources();
        int r0 = r4.getIdentifier("navigation_bar_height", "dimen", "android");
        if (r0 <= 0) goto L5;
        int r5 = r4.getDimensionPixelSize(r0);
    L6:
        Log.d("DisplayUtils--->", "getNavigationBarHeight = " + r5);
        return r5;
    L5:
        r5 = 0;
        goto L6
    }
}
