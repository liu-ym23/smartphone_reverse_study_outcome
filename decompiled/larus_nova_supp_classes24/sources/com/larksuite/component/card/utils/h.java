package com.larksuite.component.card.utils;

import android.content.Context;
import android.provider.Settings;
import com.bytedance.ee.lark.infra.foundation.log.AppBrandLogger;
import com.larksuite.framework.utils.DeviceUtils;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes24.dex */
public final class h {
    public static final /* synthetic */ int a = 0;

    static {
    }

    public static boolean a(Context r6) {
        boolean r0 = true;
        if (r6 != null) goto L7;
        AppBrandLogger.w("KeyboardScreenUtil", new Object[]{"context can't be null"});
        return false;
    L7:
        if ((r6.getResources().getConfiguration().screenLayout & 15) < 3) goto L9;
        boolean r2 = true;
    L10:
        if (r2 == true) goto L12;
        r2 = DeviceUtils.isPad();
    L12:
        if (r2 == true) goto L29;
        boolean r3 = com.ss.android.lark.base.embedded.b.g();
        if (Settings.Global.getInt(r6.getContentResolver(), "device_posture", 0) != 3) goto L16;
        boolean r4 = true;
    L18:
        if (com.ss.android.lark.base.embedded.b.e() == true) goto L20;
    L23:
        if (r3 == false) goto L26;
        if (r4 == false) goto L26;
    L28:
        return r0;
    L26:
        r0 = false;
        goto L28
    L20:
        if (Settings.Global.getInt(r6.getContentResolver(), "oplus_system_device_state", 0) != 3) goto L22;
        r4 = true;
        goto L23
    L22:
        r4 = false;
        goto L23
    L16:
        r4 = false;
        goto L18
    L29:
        return r2;
    L9:
        r2 = false;
        goto L10
    }
}
