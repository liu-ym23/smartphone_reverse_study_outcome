package com.ss.android.lark.integrator.ccm.dependency.di;

import android.content.Context;
import com.bytedance.ee.util.info.AppInfoUtils;
import com.ss.android.lark.security.compliance.api.ISecurityComplianceApi;
import com.ss.android.lark.security.compliance.api.model.filepolicy.AuthEntity;
import com.ss.android.lark.security.compliance.api.model.filepolicy.PolicyModel;
import com.ss.android.lark.security.compliance.api.model.filepolicy.ValidateConfig;
import com.ss.android.lark.security.compliance.api.model.filepolicy.ValidateResult;
import com.ss.android.lark.utils.ApiUtils;
import com.ss.android.lark.utils.LarkContext;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public final class w1 implements com.bytedance.ee.bear.lark.dependency.i0 {
    public w1() {
    }

    public final long c() {
        return ((p4c.b) LarkContext.spiByDwarf(p4c.b.class)).h() / 60;
    }

    public final boolean getSwitchStatusFromCurrentApp() {
        if (AppInfoUtils.f().booleanValue() == false) goto L5;
        ISecurityComplianceApi r0 = (ISecurityComplianceApi) LarkContext.spiByDwarf(ISecurityComplianceApi.class);
    L7:
        return r0.getSwitchStatusFromCurrentApp();
    L5:
        r0 = (ISecurityComplianceApi) ApiUtils.getApi(ISecurityComplianceApi.class);
        goto L7
    }

    public final void a(PolicyModel r2) {
        ((p4c.b) LarkContext.spiByDwarf(p4c.b.class)).a(r2);
    }

    public final ValidateResult b(PolicyModel r2, AuthEntity r3, ValidateConfig r4) {
        return ((p4c.b) LarkContext.spiByDwarf(p4c.b.class)).b(r2, r3, r4);
    }

    public final void e(Context r9, String r10, String r11) {
        Long r0 = p75.a.c;
        ((ISecurityComplianceApi) ApiUtils.getApi(ISecurityComplianceApi.class)).openFileSecurityCheckPage(r9, r10, r0.longValue(), 12, r11);
    }

    public final void d(PolicyModel r3, AuthEntity r4, ValidateConfig r5, fi5.a.c r6) {
        ((p4c.b) LarkContext.spiByDwarf(p4c.b.class)).f(new PolicyModel[]{r3}, r4, r5, r6);
    }
}
