package com.larus.common.account.platform.larkauth;

import com.larus.account.base.api.ILoginService;
import com.larus.common_ui.dialog.u;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
public final class g implements u {
    public final /* synthetic */ LarkAuthorization a;

    @Override // com.larus.common_ui.dialog.u
    public final void cancel() {
        this.a.getClass();
        ILoginService r0 = (ILoginService) ServiceManager.get().getService(ILoginService.class);
        if (r0 == null) goto L6;
        r0.x(true, null, "enterprise_account_unavailable");
        return;
    }

    public g(LarkAuthorization r1) {
        this.a = r1;
    }
}
