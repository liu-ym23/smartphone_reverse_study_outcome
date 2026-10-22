package ixb;

import com.ss.android.lark.appsetting.api.SettingManager;
import com.ss.android.lark.officesdk.utils.di.g;
import com.ss.android.lark.officesdk.utils.di.j;
import com.ss.android.lark.officewebview.quality.HangDetectConfig;
import com.ss.android.lark.officewebview.quality.WebViewOptimizeConfig;
import swb.b;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
public final class a {
    public static final WebViewOptimizeConfig a = null;
    public static final boolean b = false;
    public static final boolean c = false;
    public static final boolean d = false;
    public static final boolean e = false;
    public static final int f = 0;
    public static final long g = 0;
    public static int h;
    public static long i;

    static {
        WebViewOptimizeConfig r0 = (WebViewOptimizeConfig) SettingManager.getInstance().get(WebViewOptimizeConfig.class);
        a = r0;
        int r1 = g.a;
        b = g.a.a("chameleon.webview.blank.detection.enable");
        c = g.a.a("chameleon.webview.freezescreen.detection.enable");
        d = g.a.a("doubao.chameleon.webview.blankscreen.detection.disable");
        e = g.a.a("doubao.chameleon.webview.freezescreen.detection.disable");
        if (r0 == null) goto L7;
        HangDetectConfig r2 = r0.getHangDetect();
        if (r2 == null) goto L7;
        int r3 = r2.getMaxKillCount();
    L8:
        f = r3;
        if (r0 == null) goto L13;
        HangDetectConfig r4 = r0.getHangDetect();
        if (r4 == null) goto L13;
        long r5 = r4.getMinKillInterval();
    L14:
        g = r5 * 1000;
        return;
    L13:
        r5 = 120;
    L7:
        r3 = 3;
        goto L8
    }

    public static boolean a() {
        if (b.b() == false) goto L9;
        if (e == false) goto L9;
        j.e("WebViewOptimizeUtil", "DouBao disable hang detect");
        return false;
    L9:
        if (b.b() == false) goto L11;
    L14:
        WebViewOptimizeConfig r0 = a;
        if (r0 == null) goto L17;
        HangDetectConfig r1 = r0.getHangDetect();
    L18:
        if (r1 != null) goto L20;
        return false;
    L20:
        return r1.getEnableDetection();
    L17:
        r1 = null;
        goto L18
    L11:
        if (c == true) goto L14;
        j.e("WebViewOptimizeUtil", "hangFgEnable is false");
        return false;
    }
}
