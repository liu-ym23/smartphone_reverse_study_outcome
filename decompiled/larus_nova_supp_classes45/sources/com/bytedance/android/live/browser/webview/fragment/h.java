package com.bytedance.android.live.browser.webview.fragment;

import android.graphics.Color;
import android.net.Uri;
import android.text.TextUtils;
import android.view.View;
import android.view.Window;
import androidx.fragment.app.FragmentActivity;
import com.bytedance.android.live.browser.utils.LiveImmersedStatusBarUtils;
import com.bytedance.android.livesdk.config.LiveSettingKeys;
import com.bytedance.common.utility.StringUtils;
import com.bytedance.mt.protector.impl.UriProtector;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public final class h {
    public static boolean a(String r3) {
        List r0 = (List) LiveSettingKeys.LIVE_THEME_LIGHT_ALLOW_LIST.getValue();
        if (r0 != null) goto L5;
    L23:
        return false;
    L5:
        if (r0.isEmpty() == true) goto L23;
        Iterator r1 = r0.iterator();
    L8:
        if (r1.hasNext() == false) goto L23;
        String r2 = (String) r1.next();
        if (r2.startsWith("http") == true) goto L12;
        r2 = "https://".concat(r2);
    L12:
        Uri r4 = UriProtector.parse(r2);
        if (r4 == null) goto L8;
        if (TextUtils.isEmpty(r4.getPath()) == true) goto L19;
        if (r3.contains(r4.getPath()) == false) goto L8;
    L19:
        if (TextUtils.isEmpty(r4.getHost()) == true) goto L22;
        if (r3.contains(r4.getHost()) == false) goto L8;
    L22:
        return true;
    }

    public static void b(FragmentActivity r2, String r3) {
        if (StringUtils.isEmpty(r3) == true) goto L18;
        Window r0 = r2.getWindow();
        if (r0 == null) goto L7;
        r0.addFlags(Integer.MIN_VALUE);
        r0.clearFlags(67108864);
        r0.setStatusBarColor(0);
        View r1 = LiveImmersedStatusBarUtils.b(r0);
        r1.setSystemUiVisibility(r1.getSystemUiVisibility() | 1280);
    L7:
        LiveImmersedStatusBarUtils.c(r2);
        int r4 = Color.parseColor(r3);     // Catch: Exception -> L15
        Window r5 = r2.getWindow();     // Catch: Exception -> L15
        if (r5 != null) goto L11;
        return;
    L11:
        if (r5.getStatusBarColor() == r4) goto L20;
        r5.setStatusBarColor(r4);     // Catch: Exception -> L15
        return;
    L20:
        return;
    L21:
        return;
    }
}
