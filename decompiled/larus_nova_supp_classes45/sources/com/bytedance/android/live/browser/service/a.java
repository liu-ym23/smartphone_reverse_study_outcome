package com.bytedance.android.live.browser.service;

import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.ies.bullet.base.utils.logger.HybridLogger;
import com.bytedance.ies.bullet.service.base.api.LogLevel;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public final class a implements x8.d {
    public a() {
    }

    public final void e(String r9, Throwable r11) {
        ALogger.e(r9, r11);
        if (r11 == null) goto L6;
        String r12 = r11.getMessage();
        if (r12 == null) goto L6;
    L7:
        JSONObject r6 = new JSONObject();
        r6.put("tag", r9);
        Unit r13 = Unit.INSTANCE;
        y50.i.m("annie", null, null, "AnnieEnv.registerService#e(tag: String?, throwable: Throwable?)", 1, r12, r6, 6);
        return;
    L6:
        r12 = "";
        goto L7
    }

    public final void i(String r2, String r3) {
        Intrinsics.checkNotNullParameter(r2, "tag");
        Intrinsics.checkNotNullParameter(r3, "msg");
        HybridLogger r0 = HybridLogger.a;
        if (HybridLogger.c(r2, r3, LogLevel.I) == false) goto L5;
        return;
    L5:
        ALogger.i(r2, r3);
    }

    public final void e(String r11, String r12) {
        Intrinsics.checkNotNullParameter(r11, "tag");
        Intrinsics.checkNotNullParameter(r12, "msg");
        ALogger.e(r11, r12);
        JSONObject r8 = new JSONObject();
        r8.put("tag", r11);
        Unit r13 = Unit.INSTANCE;
        y50.i.m("annie", null, null, "AnnieEnv.registerService#e(tag: String, msg: String)", 1, r12, r8, 6);
    }
}
