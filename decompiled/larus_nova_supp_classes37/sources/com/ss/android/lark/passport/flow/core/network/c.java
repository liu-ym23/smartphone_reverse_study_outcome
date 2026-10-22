package com.ss.android.lark.passport.flow.core.network;

import com.ss.android.lark.passport.signinsdk_api.base.policy.PolicyAgreement;
import com.ss.android.lark.passport.signinsdk_api.entity.EnvConst$GEO;
import com.ss.android.lark.passport.signinsdk_api.entity.EnvConst$UNIT;
import kotlin.Deprecated;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
public final class c implements gpb.a {
    public final gpb.a a;
    public final int b;

    public final String getGeo() {
        if (this.b != 2) goto L6;
        return EnvConst$GEO.BOE_CN;
    L6:
        return this.a.getGeo();
    }

    public final String getTenantBrand() {
        return this.a.getTenantBrand();
    }

    public final String getUserUnit() {
        if (this.b != 2) goto L6;
        return EnvConst$UNIT.BOE_CN;
    L6:
        return this.a.getUserUnit();
    }

    public final boolean isBoe() {
        if (this.b != 2) goto L5;
        return true;
    L5:
        return false;
    }

    public final boolean isChinaMainlandGeo() {
        if (this.b != 2) goto L6;
        return true;
    L6:
        return this.a.isChinaMainlandGeo();
    }

    public final boolean isFeishuBrand() {
        return this.a.isFeishuBrand();
    }

    @Deprecated(message = "use isFeishuBrand and envType")
    public final int oldSdkEnv() {
        return gpb.a.a.a(this);
    }

    public final int envType() {
        return this.b;
    }

    public final String getPolicyUrl(PolicyAgreement r2) {
        Intrinsics.checkNotNullParameter(r2, "policyAgreement");
        return this.a.getPolicyUrl(r2);
    }

    public final void registerEnvChangeListener(ipb.a r2) {
        this.a.registerEnvChangeListener(r2);
    }

    public c(gpb.a r2, int r3) {
        Intrinsics.checkNotNullParameter(r2, "delegate");
        this.a = r2;
        this.b = r3;
    }
}
