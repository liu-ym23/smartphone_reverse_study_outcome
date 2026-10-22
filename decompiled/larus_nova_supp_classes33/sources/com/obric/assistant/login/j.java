package com.obric.assistant.login;

import com.bytedance.common.utility.NetworkUtils;
import com.larus.common.apphost.AppHost;
import com.obric.assistant.onelogin.ObricOneLoginImpl;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
public final /* synthetic */ class j implements Function0 {
    public /* synthetic */ j() {
    }

    public final Object invoke() {
        AppHost.Companion r0 = AppHost.a;
        if (NetworkUtils.isNetworkAvailable(r0.getApplication()) == false) goto L5;
        t19.s.a.g(r0.getApplication(), 2131912303, false);
    L5:
        int r1 = ObricOneLoginImpl.j;
        f0.d(f0.a, "account_consistency", null, null, null, 62);
        return Unit.INSTANCE;
    }
}
