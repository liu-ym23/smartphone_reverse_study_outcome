package com.ss.android.lark.passportc.internal;

import com.ss.android.lark.passport.signinsdk_api.account.User;
import javax.inject.Inject;
import javax.inject.Singleton;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
@Singleton
public final class j implements p {
    @Inject
    public j() {
    }

    @Override // com.ss.android.lark.passportc.internal.p
    public final User a(String r2) {
        Intrinsics.checkNotNullParameter(r2, "uid");
        User r0 = new User();
        r0.userId = r2;
        return r0;
    }
}
