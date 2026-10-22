package com.bytedance.android.livesdk.interactivity.api.publicscreen.utils;

import com.bytedance.android.livesdk.interactivity.api.settings.config.b1;
import com.bytedance.android.livesdkapi.depend.model.live.IRoom;
import com.bytedance.android.livesdkapi.depend.model.live.IRoomAuthStatus;
import kotlin.jvm.JvmStatic;
import kotlin.text.StringsKt;
import r52.l4;
import r52.x0;
import r52.y0;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class j {
    public static final String a = null;
    public static final b1 b = null;
    public static final com.bytedance.android.livesdk.interactivity.api.settings.config.e c = null;

    static {
        a = (String) y0.a.getValue();
        b = (b1) l4.a.getValue();
        c = (com.bytedance.android.livesdk.interactivity.api.settings.config.e) x0.a.getValue();
    }

    @JvmStatic
    public static final boolean a(boolean r1, IRoom r2) {
        if (r1 == false) goto L5;
        return false;
    L5:
        if (r2 == null) goto L21;
        IRoomAuthStatus r3 = r2.getRoomAuthStatus();
        if (r3 == null) goto L21;
        if (r3.isLandscapeDynamicSpeedStrategyEnable() != true) goto L21;
        String r4 = a;
        if (r4 != null) goto L14;
    L17:
        boolean r5 = true;
    L18:
        if (r5 == false) goto L20;
        return false;
    L20:
        return true;
    L14:
        if (StringsKt.isBlank(r4) == true) goto L17;
        r5 = false;
    L21:
        return false;
    }
}
