package com.ss.android.lark.passportc.internal;

import com.ss.android.lark.openplatform.common.constant.AppbrandHostConstants;
import com.ss.android.lark.passport.signinsdk_api.account.User;
import com.ss.android.lark.passportc.entity.UserSession;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.Set;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
public final class g0 implements f0 {
    public final UserSession a;
    public final p b;
    public User c;
    public final Set<Function1<f0c.h, Unit>> d;

    @Override // com.ss.android.lark.passportc.internal.f0
    public final User getUser() {
        User r0 = this.b.a(this.a.b);
        if (r0 == null) goto L6;
        this.c = r0;
        return r0;
    L6:
        return this.c;
    }

    @Override // com.ss.android.lark.passportc.internal.f0
    public final UserSession getSession() {
        return this.a;
    }

    @Override // com.ss.android.lark.passportc.internal.f0
    public final void a(Function1<? super f0c.h, Unit> r2) {
        Intrinsics.checkNotNullParameter(r2, "observer");
        this.d.add(r2);
    }

    public final void b(f0c.h r3) {
        Intrinsics.checkNotNullParameter(r3, "userState");
        Iterator<T> r0 = this.d.iterator();
    L4:
        if (r0.hasNext() == false) goto L6;
        ((Function1) r0.next()).invoke(r3);
        goto L4
    }

    public g0(UserSession r2, p r3, User r4) {
        Intrinsics.checkNotNullParameter(r2, AppbrandHostConstants.SCHEMA_INSPECT.SESSION);
        Intrinsics.checkNotNullParameter(r3, "userDataSource");
        Intrinsics.checkNotNullParameter(r4, "userSaved");
        this.a = r2;
        this.b = r3;
        this.c = r4;
        this.d = Collections.synchronizedSet(new LinkedHashSet());
    }
}
