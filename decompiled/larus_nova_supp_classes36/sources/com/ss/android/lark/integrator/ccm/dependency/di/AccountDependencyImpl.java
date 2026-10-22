package com.ss.android.lark.integrator.ccm.dependency.di;

import com.bytedance.i18n.claymore.ClaymoreImpl;
import com.ss.android.lark.passport.signinsdk_api.account.Tenant;
import com.ss.android.lark.passport.signinsdk_api.account.User;
import com.ss.android.lark.utils.ApiUtils;
import com.ss.android.lark.utils.LarkContext;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
@ClaymoreImpl(com.bytedance.ee.bear.lark.dependency.b.class)
public class AccountDependencyImpl implements com.bytedance.ee.bear.lark.dependency.b {
    private static final String TAG = "AccountDependencyImpl";

    public AccountDependencyImpl() {
    }

    public String getTenantCode() {
        int r0 = jl5.a.a;
        User r1 = ((yzb.b) LarkContext.spiByDwarf(yzb.b.class)).getForegroundUser();
        if (r1 == null) goto L5;
        String r2 = r1.getTenantCode();
    L6:
        if (r2 != null) goto L9;
        return "";
    L9:
        return r2;
    L5:
        r2 = null;
        goto L6
    }

    public String getTenantId() {
        int r0 = jl5.a.a;
        User r1 = ((yzb.b) LarkContext.spiByDwarf(yzb.b.class)).getForegroundUser();
        if (r1 == null) goto L5;
        String r2 = r1.getTenantId();
    L6:
        if (r2 != null) goto L9;
        return "";
    L9:
        return r2;
    L5:
        r2 = null;
        goto L6
    }

    public String getUserName() {
        int r0 = jl5.a.a;
        User r1 = ((yzb.b) LarkContext.spiByDwarf(yzb.b.class)).getForegroundUser();
        if (r1 == null) goto L5;
        String r2 = b0c.a.a(r1);
    L6:
        if (r2 != null) goto L9;
        return "";
    L9:
        return r2;
    L5:
        r2 = null;
        goto L6
    }

    public boolean isCustomer() {
        int r0 = jl5.a.a;
        User r1 = ((yzb.b) LarkContext.spiByDwarf(yzb.b.class)).getForegroundUser();
        if (r1 == null) goto L11;
        Intrinsics.checkNotNullParameter(r1, "<this>");
        Tenant r2 = r1.tenant;
        if (r2 == null) goto L7;
        String r3 = r2.tenantId;
    L8:
        int r4 = com.ss.android.lark.passport.signinsdk_api.contants.a.a;
        if (Intrinsics.areEqual(r3, "0") != true) goto L11;
        return true;
    L7:
        r3 = null;
    L11:
        return false;
    }

    public boolean isFeishuBrand() {
        int r0 = jl5.a.a;
        return ((gpb.a) ApiUtils.getApi(gpb.a.class)).isFeishuBrand();
    }

    public boolean isSimpleTenant() {
        int r0 = jl5.a.a;
        User r1 = ((yzb.b) LarkContext.spiByDwarf(yzb.b.class)).getForegroundUser();
        if (r1 == null) goto L5;
        Integer r2 = Integer.valueOf(r1.getTenantTag());
    L7:
        if (r2 != null) goto L10;
        return false;
    L10:
        if (r2.intValue() == 0) goto L13;
        return true;
    L13:
        return false;
    L5:
        r2 = null;
        goto L7
    }

    public String getSession() {
        return jl5.a.a();
    }

    public String getUserId() {
        return jl5.a.b();
    }

    public boolean isPrimaryHost() {
        return jl5.a.c();
    }
}
