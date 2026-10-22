package com.larksuite.component.card.utils;

import android.app.ActivityManager;
import android.content.Context;
import android.os.Build;
import android.text.TextUtils;
import androidx.fragment.app.FragmentActivity;
import com.larksuite.component.card.protocol.CardConfig;
import com.larksuite.component.card.settings.LynxCardCommonConfig;
import com.larksuite.component.ui.display.manager.zoom.LarkFont;
import com.larksuite.component.ui.display.manager.zoom.ZoomLevel6;
import com.larksuite.framework.utils.ApkUtil;
import com.ss.android.lark.appcontext.applifecycle.AppLifecycle;
import com.ss.android.lark.component.appcontext.LarkAppContext;
import com.ss.android.lark.log.Log;
import com.ss.android.lark.utils.LarkContext;
import com.ss.android.lark.utils.PackageChannelManager;
import java.util.Iterator;
import java.util.Locale;
import java.util.Map;
import java.util.TimeZone;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes24.dex */
public final class j {
    public static String c() {
        Locale r0 = ty7.a.a().getLanguageSetting();
        if (r0 != null) goto L5;
        r0 = Locale.getDefault();
    L5:
        String r1 = r0.toLanguageTag();
        if (r1 != null) goto L8;
        Log.e("UniversalCardUtil", "get language failed, use default language:en-US");
        return "en-US";
    L8:
        if (TextUtils.equals("zh-Hans-CN", r1) == false) goto L11;
        return "zh-CN";
    L11:
        if (TextUtils.equals("zh-Hant-TW", r1) == false) goto L14;
        return "zh-TW";
    L14:
        if (r1.startsWith("zh-Hans") == false) goto L16;
    L17:
        return "zh-HK";
    L16:
        if (r1.startsWith("zh-Hant") == true) goto L17;
        return r1;
    }

    public static FragmentActivity getActivity(Context r1) {
        if ((r1 instanceof FragmentActivity) == true) goto L10;
        FragmentActivity r2 = AppLifecycle.a.a.f();
        if ((r2 instanceof FragmentActivity) == true) goto L11;
        return null;
    L11:
        return r2;
    L10:
        return (FragmentActivity) r1;
    }

    public static String a(CardConfig r1, Context r2) {
        if (LarkAppContext.inst().buildConfig().isOfficeSDK() == false) goto L8;
        if (r2 == null) goto L8;
        return b(r1, r2);
    L8:
        return b(r1, LarkContext.getApplication());
    }

    public static String b(CardConfig r10, Context r11) {
        if (h18.f.a(r11) == false) goto L5;
        String r12 = "dark";
    L6:
        JSONObject r1 = new JSONObject();
        JSONObject r2 = new JSONObject();     // Catch: Throwable -> L64
        r2.put("os", "Android");     // Catch: Throwable -> L64
        r2.put("platform", "android");     // Catch: Throwable -> L64
        r2.put("osVersion", String.valueOf(Build.VERSION.SDK_INT));     // Catch: Throwable -> L64
        r2.put("supportCanvas", k.a(LarkContext.getApplication()));     // Catch: Throwable -> L64
        r1.put("deviceInfo", r2);     // Catch: Throwable -> L64
        yy7.a.C0139a r3 = ty7.a.a().getAccountInfo();     // Catch: Throwable -> L64
        JSONObject r4 = new JSONObject();     // Catch: Throwable -> L64
        String r5 = r3.a;     // Catch: Throwable -> L64
        String r6 = "";
        if (r5 != null) goto L11;
        r5 = "";
    L11:
        r4.put("deviceID", r5);     // Catch: Throwable -> L64
        String r7 = r3.b;     // Catch: Throwable -> L64
        if (r7 != null) goto L14;
        r7 = "";
    L14:
        r4.put("tenantID", r7);     // Catch: Throwable -> L64
        String r8 = r3.c;     // Catch: Throwable -> L64
        if (r8 != null) goto L17;
        r8 = "";
    L17:
        r4.put("tenantBrand", r8);     // Catch: Throwable -> L64
        r4.put("isFeishuBrand", r3.d);     // Catch: Throwable -> L64
        r4.put("isChinaMainlandGeo", r3.e);     // Catch: Throwable -> L64
        String r9 = r3.f;     // Catch: Throwable -> L64
        if (r9 != null) goto L20;
        r9 = "";
    L20:
        r4.put("userID", r9);     // Catch: Throwable -> L64
        String r13 = r3.g;     // Catch: Throwable -> L64
        if (r13 == null) goto L24;
        r6 = r13;
    L24:
        r4.put("userGeo", r6);     // Catch: Throwable -> L64
        r1.put("accountInfo", r4);     // Catch: Throwable -> L64
        JSONObject r14 = new JSONObject();     // Catch: Throwable -> L64
        r14.put("language", c().toLowerCase());     // Catch: Throwable -> L64
        r14.put("local", ty7.a.a().getLanguageSetting().toString());     // Catch: Throwable -> L64
        int r15 = 0;
        boolean r16 = true;
        if (ty7.a.a().is12HourClock() == true) goto L27;
        boolean r17 = true;
    L28:
        r14.put("is24HourTime", r17);     // Catch: Throwable -> L64
        r14.put("larkVersion", ApkUtil.getAppVersionName(LarkContext.getApplication()));     // Catch: Throwable -> L64
        r14.put("theme", r12);     // Catch: Throwable -> L64
        r14.put("isKA", PackageChannelManager.isKABuildPackage(LarkContext.getApplication()));     // Catch: Throwable -> L64
        r14.put("isLark", LarkAppContext.inst().buildConfig().isUsPackage());     // Catch: Throwable -> L64
        if (LarkAppContext.inst().buildConfig().isUsPackage() == false) goto L32;
        r16 = false;
    L32:
        r14.put("isFeishu", r16);     // Catch: Throwable -> L64
        r14.put("timezone", TimeZone.getDefault().getID());     // Catch: Throwable -> L64
        ZoomLevel6 r19 = zz7.b.d();     // Catch: Throwable -> L64
        r14.put("fontLevelName", r19.toString().toLowerCase());     // Catch: Throwable -> L64
        r14.put("fontMultiplier", r19.getMultiplier());     // Catch: Throwable -> L64
        JSONObject r110 = new JSONObject();     // Catch: Throwable -> L64
        LarkFont[] r20 = LarkFont.values();     // Catch: Throwable -> L64
        int r21 = r20.length;     // Catch: Throwable -> L64
    L33:
        if (r15 >= r21) goto L35;
        LarkFont r22 = r20[r15];     // Catch: Throwable -> L64
        String r23 = f.a(r22);     // Catch: Throwable -> L64
        Intrinsics.checkNotNullParameter(r22, "larkFont");     // Catch: Throwable -> L64
        r110.put(r23, zz7.b.b(r22, zz7.b.d()));     // Catch: Throwable -> L64
        r15 = r15 + 1;     // Catch: Throwable -> L64
        goto L33
    L35:
        r14.put("fontSizeMap", r110);     // Catch: Throwable -> L64
        r1.put("larkInfo", r14);     // Catch: Throwable -> L64
        JSONObject r111 = new JSONObject();     // Catch: Throwable -> L64
        if (r10 != null) goto L38;
    L60:
        r1.put("settings", r111);     // Catch: Throwable -> L64
        if (idb.f.a().isEnable("universalcard.chart_memory_downgrade_dpr.enable") == false) goto L67;
        int r112 = g.a;     // Catch: Throwable -> L64
        ActivityManager.MemoryInfo r113 = new ActivityManager.MemoryInfo();     // Catch: Throwable -> L64
        LarkAppContext.Companion.getClass();     // Catch: Throwable -> L64
        Object r114 = LarkAppContext.access$getInstance$cp().getContext().getSystemService("activity");     // Catch: Throwable -> L64
        Intrinsics.checkNotNull(r114, "null cannot be cast to non-null type android.app.ActivityManager");     // Catch: Throwable -> L64
        ((ActivityManager) r114).getMemoryInfo(r113);     // Catch: Throwable -> L64
        boolean r115 = r113.lowMemory;     // Catch: Throwable -> L64
        Log.i("UniversalCardUtil", "low memory: " + r115);     // Catch: Throwable -> L64
        r1.put("isMemoryDowngrade", r115);     // Catch: Throwable -> L64
    L67:
        return r1.toString();
    L38:
        if (r10.getSettings().b == null) goto L41;
        r111.put("fallbackStyleConfig", r10.getSettings().b.styleJson);     // Catch: Throwable -> L64
    L41:
        if (r10.getSettings().c == null) goto L47;
        int r24 = ez7.c.d;     // Catch: Throwable -> L64
        LynxCardCommonConfig r25 = r10.getSettings().c;     // Catch: Throwable -> L64
        if (r25 != null) goto L45;
        JSONObject r26 = new JSONObject();     // Catch: Throwable -> L64
    L46:
        r111.put(LynxCardCommonConfig.COMMON_CONFIG, r26);     // Catch: Throwable -> L64
        goto L47
    L45:
        r26 = r25.mConfig;     // Catch: Throwable -> L64
    L47:
        Map<String, Boolean> r27 = r10.getFg().a;     // Catch: Throwable -> L64
        JSONObject r29 = new JSONObject();     // Catch: Throwable -> L64
        if (r27 == null) goto L53;
        Iterator<String> r30 = r27.keySet().iterator();     // Catch: Throwable -> L64
    L51:
        if (r30.hasNext() == false) goto L53;
        String r31 = r30.next();     // Catch: Throwable -> L64
        r29.put(r31, r27.get(r31));     // Catch: Throwable -> L64
    L53:
        r1.put("fgs", r29);     // Catch: Throwable -> L64
        Map<String, String> r116 = r10.getI18nText().a;     // Catch: Throwable -> L64
        JSONObject r32 = new JSONObject();     // Catch: Throwable -> L64
        if (r116 == null) goto L59;
        Iterator<String> r33 = r116.keySet().iterator();     // Catch: Throwable -> L64
    L57:
        if (r33.hasNext() == false) goto L59;
        String r34 = r33.next();     // Catch: Throwable -> L64
        r32.put(r34, r116.get(r34));     // Catch: Throwable -> L64
    L59:
        r1.put("i18nText", r32);     // Catch: Throwable -> L64
        goto L60
    L27:
        r17 = false;
    L64:
        th = move-exception;
        Log.e("UniversalCardUtil", "parse global error" + th);
        goto L67
    L5:
        r12 = "light";
        goto L6
    }
}
