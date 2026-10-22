package com.ss.android.lark.passport.signinsdk_api.interfaces;

import com.ss.android.lark.manis.annotation.RemoteCallback;
import com.ss.android.lark.manis.annotation.RemoteService;
import com.ss.android.lark.passport.signinsdk_api.entity.SessionResult;
import ee.android.framework.manis.interfaces.IHookInterface;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
@RemoteService
public interface ILoginManisService extends IHookInterface {

    @RemoteCallback
    public interface a {
        void onError(int r1, String r2);

        void onSuccess(SessionResult r1);
    }

    void switchLoginTenantUser(String r1, a r2);
}
