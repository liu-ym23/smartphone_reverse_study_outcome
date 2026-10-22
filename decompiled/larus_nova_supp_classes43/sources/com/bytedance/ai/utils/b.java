package com.bytedance.ai.utils;

import android.content.Context;
import com.bytedance.news.common.settings.SettingsManager;
import com.bytedance.news.common.settings.api.SettingsData;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public final class b {
    public static final /* synthetic */ int a = 0;

    static {
    }

    public static Map a(List r10) {
        Intrinsics.checkNotNullParameter(r10, "settingsList");
        LinkedHashMap r0 = new LinkedHashMap();
        h2.a r1 = f2.b.c;
        if (r1 == null) goto L27;
        Context r11 = r1.a;
        if (r11 == null) goto L27;
        SettingsData r12 = SettingsManager.obtainSettingsFast(r11);
        if (r12 == null) goto L9;
        JSONObject r13 = r12.getAppSettings();
    L11:
        if (r13 != null) goto L13;
        g.a.e("AppSettingsUtils", "appSetting is null");
        goto L27
    L13:
        Iterator r14 = r10.iterator();
    L15:
        if (r14.hasNext() == false) goto L27;
        String r15 = (String) r14.next();
        Result.Companion r16 = Result.Companion;     // Catch: Throwable -> L19
        Object r17 = Result.constructor-impl(r13.get(r15));     // Catch: Throwable -> L19
    L21:
        Throwable r18 = Result.exceptionOrNull-impl(r17);
        if (r18 == null) goto L25;
        g.a.e("AppSettingsUtils", String.valueOf(r18.getMessage()));
        r17 = null;
    L25:
        if (r17 == null) goto L15;
        r0.put(r15, r17);
    L19:
        th = move-exception;
        Result.Companion r19 = Result.Companion;
        r17 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L21
    L9:
        r13 = null;
    L27:
        return r0;
    }
}
