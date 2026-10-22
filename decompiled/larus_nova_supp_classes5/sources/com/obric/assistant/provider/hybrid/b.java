package com.obric.assistant.provider.hybrid;

import android.os.Bundle;
import com.larus.account.base.api.ILoginService;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes5.dex */
public final class b implements a {
    public b() {
    }

    public Bundle call(String r3, Bundle r4) {
        Bundle r5 = new Bundle();
        ILoginService.Companion r6 = ILoginService.a;
        r5.putBoolean("is_login", r6.getAccountInfo().a);
        r5.putBoolean("is_enterprise", r6.getAccountInfo().g);
        return r5;
    }
}
