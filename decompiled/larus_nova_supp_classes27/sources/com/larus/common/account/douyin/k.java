package com.larus.common.account.douyin;

import android.os.Bundle;
import com.bytedance.sdk.account.platform.AuthorizeAdapter;
import com.bytedance.sdk.account.platform.base.AuthorizeErrorResponse;
import com.larus.account.base.api.IDouyinHeartBeatService;
import com.larus.utils.logger.FLogger;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
public final class k extends AuthorizeAdapter {
    public final /* synthetic */ n38.l a;
    public final /* synthetic */ DouyinLogin b;

    public final void onAuthError(AuthorizeErrorResponse r6) {
        FLogger r0 = FLogger.a;
        String r1 = this.b.a;
        StringBuilder r2 = new StringBuilder("updateToken onAuthError, errorCode:");
        String r3 = null;
        if (r6 == null) goto L5;
        String r4 = r6.platformErrorCode;
    L6:
        r2.append(r4);
        r2.append(", errorMsg: ");
        if (r6 == null) goto L9;
        String r5 = r6.platformErrorMsg;
    L10:
        r2.append(r5);
        r0.i(r1, r2.toString());
        n38.l r7 = this.a;
        if (r6 == null) goto L14;
        String r8 = r6.platformErrorMsg;
        if (r8 == null) goto L14;
    L15:
        if (r6 == null) goto L17;
        r3 = r6.platformErrorCode;
    L17:
        r7.b(r8, r3);
        return;
    L14:
        r8 = "";
        goto L15
    L9:
        r5 = null;
        goto L10
    L5:
        r4 = null;
        goto L6
    }

    public final void onAuthSuccess(Bundle r8) {
        if (r8 == null) goto L5;
        String r0 = r8.getString("auth_code");
        if (r0 == null) goto L5;
    L6:
        this.a.a(r0, r8);
        IDouyinHeartBeatService r1 = (IDouyinHeartBeatService) ServiceManager.get().getService(IDouyinHeartBeatService.class);
        if (r1 == null) goto L10;
        IDouyinHeartBeatService.a.a(r1, 3000, true, null, null, 12);
        return;
    L10:
        return;
    L5:
        r0 = "";
        goto L6
    }

    public k(n38.l r1, DouyinLogin r2) {
        this.a = r1;
        this.b = r2;
        super("aweme_v2");
    }
}
