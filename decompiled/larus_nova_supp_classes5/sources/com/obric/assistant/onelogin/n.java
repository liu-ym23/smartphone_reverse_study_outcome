package com.obric.assistant.onelogin;

import com.larus.utils.logger.FLogger;
import com.ss.android.token.d;
import com.ss.android.token.e;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes5.dex */
public final class n implements e {
    public n() {
    }

    @Override // com.ss.android.token.e
    public final void a(d r4) {
        Intrinsics.checkNotNullParameter(r4, "logoutContent");
        FLogger.a.i("ObricOneLoginImpl", "afterPassportLogout, logoutContent = " + r4);
    }

    @Override // com.ss.android.token.e
    public final void b(d r4, Object r5, com.bytedance.sdk.account.impl.e r6) {
        Intrinsics.checkNotNullParameter(r4, "logoutContent");
        FLogger.a.i("ObricOneLoginImpl", "beforePassportLogout, logoutContent = " + r4);
        r6.a(null, r5);
    }
}
