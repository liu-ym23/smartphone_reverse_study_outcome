package com.larus.xbridge.custom;

import android.app.Application;
import com.ivy.ivykit.api.bridge.core.model.IvyBridgePlatformType;
import com.larus.common.apphost.AppHost;
import com.larus.utils.logger.FLogger;
import com.lynx.jsbridge.LynxResourceModule;
import com.obric.aivoice.core.data.NameKeys;
import java.util.LinkedHashMap;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
public final class k extends bx7.c {

    public static final class a {
    }

    static {
    }

    public final String getName() {
        return "app.getAppSettings";
    }

    public k() {
    }

    public final void a(dx7.b r10, ux7.d.d r11, IvyBridgePlatformType r12) {
        Intrinsics.checkNotNullParameter(r10, LynxResourceModule.PARAMS_KEY);
        Intrinsics.checkNotNullParameter(r11, "callback");
        Intrinsics.checkNotNullParameter(r12, "type");
        String r13 = cx7.a.d(r10, "key", NameKeys.UnloadStrategy_No_Strategy);
        Result.Companion r14 = Result.Companion;     // Catch: Throwable -> L9
        ft9.k r15 = ft9.k.a;     // Catch: Throwable -> L9
        Application r0 = AppHost.a.getApplication();     // Catch: Throwable -> L9
        r15.getClass();     // Catch: Throwable -> L9
        JSONObject r16 = ft9.k.c(r0);     // Catch: Throwable -> L9
        if (r16 == null) goto L6;
        Object r17 = r16.opt(r13);     // Catch: Throwable -> L9
    L7:
        Object r18 = Result.constructor-impl(r17);     // Catch: Throwable -> L9
    L11:
        Throwable r1 = Result.exceptionOrNull-impl(r18);
        if (r1 != null) goto L18;
        if (r18 != null) goto L16;
        FLogger.a.e("AppGetAppSettingsMethod", "settings value is null for key: " + r13);
        LinkedHashMap r19 = new LinkedHashMap();
        r19.put(LynxResourceModule.CODE_KEY, 1);
        LinkedHashMap r110 = new LinkedHashMap();
        r110.put("success", 0);
        Unit r2 = Unit.INSTANCE;
        r19.put(LynxResourceModule.DATA_KEY, r110);
        r11.invoke(r19);
        return;
    L16:
        FLogger.a.i("AppGetAppSettingsMethod", "key: " + r13 + " settings: " + r18);
        LinkedHashMap r111 = new LinkedHashMap();
        r111.put(LynxResourceModule.CODE_KEY, 1);
        LinkedHashMap r3 = new LinkedHashMap();
        r3.put("success", 1);
        r3.put("value", r18);
        Unit r112 = Unit.INSTANCE;
        r111.put(LynxResourceModule.DATA_KEY, r3);
        r11.invoke(r111);
        return;
    L18:
        FLogger.a.e("AppGetAppSettingsMethod", "get app settings for key: " + r13 + " failed, error: " + r1.getMessage());
        LinkedHashMap r113 = new LinkedHashMap();
        r113.put(LynxResourceModule.CODE_KEY, 1);
        LinkedHashMap r114 = new LinkedHashMap();
        r114.put("success", 0);
        Unit r4 = Unit.INSTANCE;
        r113.put(LynxResourceModule.DATA_KEY, r114);
        r11.invoke(r113);
        return;
    L6:
        r17 = null;
    L9:
        th = move-exception;
        Result.Companion r5 = Result.Companion;
        r18 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L11
    }
}
