package com.ss.android.lark.officesdk.chameleon.assembly.doubao.common.deps;

import com.bytedance.i18n.claymore.ClaymoreServiceLoader;
import com.ss.android.lark.log.Log;
import com.ss.android.lark.officesdk.api.IUserManager;
import com.ss.android.lark.officesdk.api.api.OfficeSDKUserApi;
import com.ss.android.lark.officesdk.api.init.IDeviceInfoProvider;
import com.ss.android.lark.officesdk.internal.OfficeSDKProvider;
import com.ss.android.lark.officesdk.manager.OfficeSDKManager;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
public final class q implements ntb.r {
    public q() {
    }

    @Override // ntb.r
    public final String getDeviceId() {
        IDeviceInfoProvider r1 = OfficeSDKManager.getDeviceInfoProvider();     // Catch: Exception -> L7
        if (r1 == null) goto L12;
        return r1.getDeviceId();
    L12:
        return null;
    L7:
        e = move-exception;
        Log.w("OfficeSdk-PassportDependency", "getDeviceId failed", e);
        return null;
    }

    @Override // ntb.r
    public final String getUserId() {
        IUserManager r1 = OfficeSDKProvider.INSTANCE.getInstance().getUserManager();     // Catch: Exception -> L9
        if (r1 == null) goto L14;
        OfficeSDKUserApi r2 = r1.getUserApi();     // Catch: Exception -> L9
        if (r2 == null) goto L15;
        return r2.getUserId();
    L15:
        return null;
    L14:
        return null;
    L9:
        e = move-exception;
        Log.w("OfficeSdk-PassportDependency", "getUserId failed", e);
        return null;
    }

    @Override // ntb.r
    public final ntb.a h() {
        vzb.a r1 = (vzb.a) ClaymoreServiceLoader.loadFirst(vzb.a.class);     // Catch: Exception -> L8
        if (r1 == null) goto L11;
        return new ntb.a(r1.a());
    L11:
        return null;
    L12:
        return null;
    }

    @Override // ntb.r
    public final boolean isBoe() {
        Integer r0 = OfficeSDKManager.getEnv();
        if (r0 != null) goto L6;
    L8:
        return false;
    L6:
        if (r0.intValue() != 2) goto L8;
        return true;
    }
}
