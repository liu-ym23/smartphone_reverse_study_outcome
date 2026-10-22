package com.ss.android.lark.passportc.internal;

import com.ss.android.lark.passport.signinsdk_api.account.User;
import com.ss.android.lark.passportc.entity.UserSession;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
public interface f0 {
    void a(Function1<? super f0c.h, Unit> r1);

    UserSession getSession();

    User getUser();
}
