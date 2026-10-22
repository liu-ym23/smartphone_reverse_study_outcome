package com.bytedance.android.livesdk.gift.platform.business.dialog.v3.preload;

import android.os.SystemClock;
import com.bytedance.android.live.core.utils.s1;
import com.bytedance.android.livesdk.gift.platform.business.dialog.v3.helper.GiftPanelBizBoostUtils;
import com.bytedance.android.livesdk.gift.platform.business.effect.assets.IAssetsManager;
import kotlin.jvm.JvmStatic;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class e {
    public static final int a = 0;
    public static final String b = null;
    public static int c;
    public static long d;

    static {
        a = s1.h(2131106882);
        b = s1.B(2131922465);
        c = s1.j(2131168749);
        d = SystemClock.uptimeMillis();
    }

    public static int a() {
        GiftPanelBizBoostUtils.E.getClass();
        if (((Boolean) GiftPanelBizBoostUtils.s.getValue()).booleanValue() == false) goto L7;
        return a;
    L7:
        return s1.h(2131106882);
    }

    public static String c() {
        GiftPanelBizBoostUtils.E.getClass();
        if (((Boolean) GiftPanelBizBoostUtils.s.getValue()).booleanValue() == false) goto L7;
        return b;
    L7:
        return s1.B(2131922465);
    }

    @JvmStatic
    public static final int b(int r5) {
        GiftPanelBizBoostUtils.E.getClass();
        if (((Boolean) GiftPanelBizBoostUtils.s.getValue()).booleanValue() == false) goto L12;
        if (r5 != 2131168749) goto L12;
        if ((SystemClock.uptimeMillis() - d) <= IAssetsManager.DownloadAssetsSource.SOURCE_LOCAL_SEND_GIFT_NOW) goto L10;
        c = s1.j(2131168749);
        d = SystemClock.uptimeMillis();
    L10:
        return c;
    L12:
        return s1.j(r5);
    }
}
