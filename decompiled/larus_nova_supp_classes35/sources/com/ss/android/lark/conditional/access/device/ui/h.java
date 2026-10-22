package com.ss.android.lark.conditional.access.device.ui;

import androidx.lifecycle.Observer;
import com.ss.android.lark.security.compliance.infra.log.ScsLogger;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public final class h<T> implements Observer {
    public final /* synthetic */ UserScopeDeviceDeclareFragment a;

    public h(UserScopeDeviceDeclareFragment r1) {
        this.a = r1;
    }

    public final void onChanged(Object r2) {
        Boolean r3 = (Boolean) r2;
        this.a.finish();
        ScsLogger.d("SecurityPolicy_UserScopeDeviceDeclareFragment", "finish page");
    }
}
