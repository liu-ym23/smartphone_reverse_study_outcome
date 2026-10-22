package com.larus.xbridge.custom;

import android.os.Bundle;
import com.bytedance.sdk.account.platform.AuthorizeAdapter;
import com.bytedance.sdk.account.platform.base.AuthorizeErrorResponse;
import com.ivy.ivykit.api.bridge.core.IvyBridgeMethod;
import com.larus.utils.logger.FLogger;
import com.lynx.jsbridge.LynxResourceModule;
import com.obric.aivoice.core.data.NameKeys;
import java.util.LinkedHashMap;
import kotlin.Unit;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
public final class b extends AuthorizeAdapter {
    public final /* synthetic */ IvyBridgeMethod.a a;

    public b(ux7.d.d r1) {
        this.a = r1;
        super("aweme_v2");
    }

    public final void onAuthError(AuthorizeErrorResponse r6) {
        FLogger r0 = FLogger.a;
        StringBuilder r1 = new StringBuilder("updateToken onAuthError, errorCode:");
        String r2 = null;
        if (r6 == null) goto L5;
        String r3 = r6.platformErrorCode;
    L6:
        r1.append(r3);
        r1.append(", errorMsg: ");
        if (r6 == null) goto L9;
        r2 = r6.platformErrorMsg;
    L9:
        r1.append(r2);
        r0.i("AccountThirdPartyAuthMethod", r1.toString());
        IvyBridgeMethod.a r4 = this.a;
        LinkedHashMap r5 = new LinkedHashMap();
        r5.put(LynxResourceModule.CODE_KEY, 0);
        LinkedHashMap r7 = new LinkedHashMap();
        r7.put(LynxResourceModule.CODE_KEY, NameKeys.UnloadStrategy_No_Strategy);
        r7.put("platform", "douyin");
        int r8 = a.c;
        r7.put("platformAppId", "8943");
        if (r6 == null) goto L13;
        Object r9 = r6.platformErrorCode;
        if (r9 == null) goto L13;
    L14:
        r7.put("errorCode", r9);
        Unit r10 = Unit.INSTANCE;
        r5.put(LynxResourceModule.DATA_KEY, r7);
        r4.invoke(r5);
        return;
    L13:
        r9 = -1;
        goto L14
    L5:
        r3 = null;
        goto L6
    }

    public final void onAuthSuccess(Bundle r5) {
        if (r5 == null) goto L5;
        String r6 = r5.getString("auth_code");
        if (r6 == null) goto L5;
    L6:
        IvyBridgeMethod.a r0 = this.a;
        LinkedHashMap r1 = new LinkedHashMap();
        r1.put(LynxResourceModule.CODE_KEY, 1);
        LinkedHashMap r2 = new LinkedHashMap();
        r2.put(LynxResourceModule.CODE_KEY, r6);
        r2.put("platform", "douyin");
        int r7 = a.c;
        r2.put("platformAppId", "8943");
        Unit r8 = Unit.INSTANCE;
        r1.put(LynxResourceModule.DATA_KEY, r2);
        r0.invoke(r1);
        return;
    L5:
        r6 = NameKeys.UnloadStrategy_No_Strategy;
        goto L6
    }
}
