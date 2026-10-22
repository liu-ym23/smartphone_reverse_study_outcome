package com.ss.android.lark.passportc.api;

import com.ss.android.lark.passport.signinsdk_api.account.User;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
public final class a extends z {
    public final User c;
    public final String d;

    @Override // com.ss.android.lark.passportc.api.z
    public final String a() {
        return this.d;
    }

    public a(User r3) {
        Intrinsics.checkNotNullParameter(r3, "user");
        super(null, 3);
        this.c = r3;
        this.d = "BringNewForeground";
    }
}
