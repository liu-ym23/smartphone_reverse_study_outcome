package com.ss.android.lark.passportc.api;

import com.ss.android.lark.passport.signinsdk_api.account.User;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
public final class x extends z {
    public final String c;

    @Override // com.ss.android.lark.passportc.api.z
    public final String a() {
        return this.c;
    }

    public x(List<? extends User> r2, boolean r3) {
        Intrinsics.checkNotNullParameter(r2, "expectedBackgroundUserList");
        super(r2, r3);
        this.c = "OnlineForeground";
    }
}
