package com.ss.android.lark.passportc.internal;

import com.ss.android.lark.openplatform.common.constant.AppbrandHostConstants;
import com.ss.android.lark.passportc.entity.UserSession;
import java.util.Set;
import javax.inject.Inject;
import javax.inject.Singleton;
import kotlin.collections.SetsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
@Singleton
public final class a0 implements z {
    public final y a;

    @Inject
    public a0(y r2) {
        Intrinsics.checkNotNullParameter(r2, "userComponentManager");
        this.a = r2;
    }

    @Override // com.ss.android.lark.passportc.internal.z
    public final void a(UserSession r2) {
        Intrinsics.checkNotNullParameter(r2, AppbrandHostConstants.SCHEMA_INSPECT.SESSION);
        this.a.a(r2);
    }

    @Override // com.ss.android.lark.passportc.internal.z
    public final Set<com.ss.android.lark.passportc.task.c> b(UserSession r2) {
        Intrinsics.checkNotNullParameter(r2, AppbrandHostConstants.SCHEMA_INSPECT.SESSION);
        e0c.l r3 = this.a.g(r2);
        if (r3 == null) goto L7;
        Set<com.ss.android.lark.passportc.task.c> r4 = ((com.ss.android.lark.passportc.task.j) r3).g();
        if (r4 == null) goto L7;
        return r4;
    L7:
        return SetsKt.emptySet();
    }

    @Override // com.ss.android.lark.passportc.internal.z
    public final Set<com.ss.android.lark.passportc.task.d> c(UserSession r2) {
        Intrinsics.checkNotNullParameter(r2, AppbrandHostConstants.SCHEMA_INSPECT.SESSION);
        e0c.l r3 = this.a.g(r2);
        if (r3 == null) goto L7;
        Set<com.ss.android.lark.passportc.task.d> r4 = ((com.ss.android.lark.passportc.task.j) r3).R();
        if (r4 == null) goto L7;
        return r4;
    L7:
        return SetsKt.emptySet();
    }

    @Override // com.ss.android.lark.passportc.internal.z
    public final void d(UserSession r2) {
        Intrinsics.checkNotNullParameter(r2, AppbrandHostConstants.SCHEMA_INSPECT.SESSION);
        this.a.d(r2);
    }

    @Override // com.ss.android.lark.passportc.internal.z
    public final void e(g0 r2) {
        Intrinsics.checkNotNullParameter(r2, "userDelegate");
        this.a.i(r2);
    }

    @Override // com.ss.android.lark.passportc.internal.z
    public final e0c.a f(UserSession r2) {
        Intrinsics.checkNotNullParameter(r2, AppbrandHostConstants.SCHEMA_INSPECT.SESSION);
        return this.a.f(r2);
    }

    @Override // com.ss.android.lark.passportc.internal.z
    public final void g(g0 r2) {
        Intrinsics.checkNotNullParameter(r2, "userDelegate");
        this.a.h(r2);
    }
}
