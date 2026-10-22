package com.larus.common.account.platform.larkauth;

import androidx.fragment.app.FragmentActivity;
import com.larus.account.base.provider.ILarkLoginProvider;
import com.larus.common_ui.dialog.p0;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
public final class f implements p0 {
    public final /* synthetic */ LarkAuthorization a;
    public final /* synthetic */ FragmentActivity b;

    @Override // com.larus.common_ui.dialog.p0
    public final void confirm() {
        LarkAuthorization r0 = this.a;
        FragmentActivity r1 = this.b;
        r0.getClass();
        ILarkLoginProvider r2 = (ILarkLoginProvider) ServiceManager.get().getService(ILarkLoginProvider.class);
        if (r2 == null) goto L6;
        r2.d(r1, new h(r0, r1));
        return;
    }

    public f(LarkAuthorization r1, FragmentActivity r2) {
        this.a = r1;
        this.b = r2;
    }
}
