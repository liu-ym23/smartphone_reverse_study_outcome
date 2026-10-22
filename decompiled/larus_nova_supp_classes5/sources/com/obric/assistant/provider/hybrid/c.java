package com.obric.assistant.provider.hybrid;

import android.os.Bundle;
import com.larus.account.base.api.ILoginService;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes5.dex */
public final class c implements a {
    public c() {
    }

    public Bundle call(String r2, Bundle r3) {
        Bundle r4 = new Bundle();
        r4.putBoolean("is_login", ILoginService.a.getAccountInfo().a);
        return r4;
    }
}
