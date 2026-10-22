package com.larus.xbridge.custom;

import com.ivy.ivykit.api.bridge.core.model.IvyBridgePlatformType;
import com.larus.platform.service.AccountService;
import com.larus.utils.logger.FLogger;
import com.lynx.jsbridge.LynxResourceModule;
import com.obric.aivoice.core.data.NameKeys;
import java.util.LinkedHashMap;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
public final class l extends bx7.c {

    public static final class a {
    }

    static {
    }

    public final String getName() {
        return "app.getSecUid";
    }

    public l() {
    }

    public final void a(dx7.b r4, ux7.d.d r5, IvyBridgePlatformType r6) {
        Intrinsics.checkNotNullParameter(r4, LynxResourceModule.PARAMS_KEY);
        Intrinsics.checkNotNullParameter(r5, "callback");
        Intrinsics.checkNotNullParameter(r6, "type");
        AccountService r7 = AccountService.a;
        boolean r8 = r7.isLogin().booleanValue();
        if (r8 == false) goto L5;
        String r9 = r7.getSecUserId();
    L6:
        FLogger r0 = FLogger.a;
        StringBuilder r1 = new StringBuilder("app.getSecUid isLogin=");
        r1.append(r8);
        r1.append(", source=");
        if (r8 == false) goto L9;
        String r10 = "accountServiceSecUserId";
    L10:
        r1.append(r10);
        r1.append(", uid=");
        r1.append(r9);
        r0.i("AppGetBannedUserID", r1.toString());
        LinkedHashMap r11 = new LinkedHashMap();
        r11.put(LynxResourceModule.CODE_KEY, 1);
        LinkedHashMap r2 = new LinkedHashMap();
        Intrinsics.checkNotNull(r9);
        r2.put("uid", r9);
        Unit r12 = Unit.INSTANCE;
        r11.put(LynxResourceModule.DATA_KEY, r2);
        r5.invoke(r11);
        return;
    L9:
        r10 = "keva_banned_user_id";
        goto L10
    L5:
        r9 = xg9.b.a().getString("banned_user_id", NameKeys.UnloadStrategy_No_Strategy);
        goto L6
    }
}
