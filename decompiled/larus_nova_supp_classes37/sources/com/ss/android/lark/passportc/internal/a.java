package com.ss.android.lark.passportc.internal;

import com.ss.android.lark.passport.signinsdk_api.account.User;
import com.ss.android.lark.passportc.api.ContainerConstsKt;
import com.ss.android.lark.passportc.entity.UserSession;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
public final class a implements f0 {
    public static final a a = null;

    static {
        a = new a();
    }

    public a() {
    }

    @Override // com.ss.android.lark.passportc.internal.f0
    public final User getUser() {
        return (User) AbsentUserDelegateKt.a.getValue();
    }

    @Override // com.ss.android.lark.passportc.internal.f0
    public final UserSession getSession() {
        return ContainerConstsKt.a();
    }

    @Override // com.ss.android.lark.passportc.internal.f0
    public final void a(Function1<? super f0c.h, Unit> r2) {
        Intrinsics.checkNotNullParameter(r2, "observer");
        r2.invoke(f0c.i.a);
    }
}
