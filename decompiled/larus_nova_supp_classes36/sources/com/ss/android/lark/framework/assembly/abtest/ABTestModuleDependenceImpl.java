package com.ss.android.lark.framework.assembly.abtest;

import com.bytedance.i18n.claymore.ClaymoreImpl;
import com.ss.android.lark.abtest.api.listener.AbTestModuleDependency;
import com.ss.android.lark.log.Log;
import com.ss.android.lark.passport.signinsdk_api.account.User;
import com.ss.android.lark.utils.LarkContext;
import epb.a;
import yzb.b;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
@ClaymoreImpl(AbTestModuleDependency.class)
public class ABTestModuleDependenceImpl implements AbTestModuleDependency {
    private static final String TAG = "ABTestModuleDependenceImpl";
    a mDeviceIdApi;
    b mUserListApi;

    public ABTestModuleDependenceImpl() {
    }

    private a getDeviceIdApi() {
        if (this.mDeviceIdApi != null) goto L6;
        this.mDeviceIdApi = (a) LarkContext.spiByDwarf(a.class);
    L6:
        return this.mDeviceIdApi;
    }

    private b getUserListApi() {
        if (this.mUserListApi != null) goto L6;
        this.mUserListApi = (b) LarkContext.spiByDwarf(b.class);
    L6:
        return this.mUserListApi;
    }

    public String getAbTestHost() {
        return jcb.b.c().a("tt_abtest");
    }

    public String getDeviceId() {
        return getDeviceIdApi().getDeviceIdFromLocal();
    }

    public int getTenantTag() {
        User r0 = getUserListApi().getForegroundUser();
        if (r0 != null) goto L7;
        Log.i(TAG, "user == null");
        return 0;
    L7:
        return r0.getTenantTag();
    }

    public String getUserId() {
        return getUserListApi().c();
    }
}
