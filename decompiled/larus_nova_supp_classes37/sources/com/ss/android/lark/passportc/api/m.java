package com.ss.android.lark.passportc.api;

import com.bytedance.ee.bear.middleground.unbundle.BenefitManagerImpl;
import com.ss.android.lark.passport.signinsdk_api.account.User;
import com.ss.android.lark.passportc.entity.UserSession;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
public interface m {
    void a(Function1<? super f0c.h, Unit> r1);

    void b(BenefitManagerImpl.b r1);

    void c(o r1);

    void d(o r1);

    UserSession getSession();

    f0c.h getState();

    User getUser();
}
