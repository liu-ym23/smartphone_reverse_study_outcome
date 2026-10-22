package com.bytedance.android.live.core.utils;

import com.bytedance.mt.protector.impl.color.ColorProtector;
import java.util.HashMap;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public final class u {
    public static HashMap<String, Object> a() {
        HashMap<String, Object> r0 = new HashMap();
        if (fm3.d.b() == false) goto L5;
        r0.put("PROGRESS_BG_COLOR", Integer.valueOf(ColorProtector.parseColor("#14FFFFFF")));
        r0.put("PROGRESS_COLOR", Integer.valueOf(ColorProtector.parseColor("#80FE2C55")));
        r0.put("TEXT_COLOR", Integer.valueOf(ColorProtector.parseColor("#161823")));
        r0.put("SCREEN_COLOR", Integer.valueOf(ColorProtector.parseColor("#FFFFFF")));
    L6:
        return r0;
    L5:
        r0.put("PROGRESS_BG_COLOR", Integer.valueOf(ColorProtector.parseColor("#1E161823")));
        r0.put("PROGRESS_COLOR", Integer.valueOf(ColorProtector.parseColor("#80FE2C55")));
        r0.put("TEXT_COLOR", Integer.valueOf(ColorProtector.parseColor("#E6FFFFFF")));
        r0.put("SCREEN_COLOR", Integer.valueOf(ColorProtector.parseColor("#161823")));
        goto L6
    }
}
