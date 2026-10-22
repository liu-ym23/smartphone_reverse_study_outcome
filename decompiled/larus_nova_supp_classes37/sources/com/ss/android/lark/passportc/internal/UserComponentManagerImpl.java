package com.ss.android.lark.passportc.internal;

import com.ss.android.lark.openplatform.common.constant.AppbrandHostConstants;
import com.ss.android.lark.passportc.entity.UserSession;
import javax.inject.Inject;
import javax.inject.Singleton;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
@Singleton
public final class UserComponentManagerImpl implements y, v, b, k {
    public final b0 a;
    public final com.ss.android.lark.log.c b;
    public final x c;
    public final Lazy d;
    public final d e;
    public final Lazy f;

    @Override // com.ss.android.lark.passportc.internal.y
    public final synchronized e0c.l a(UserSession r4) {
        monitor-enter(this);
        Intrinsics.checkNotNullParameter(r4, AppbrandHostConstants.SCHEMA_INSPECT.SESSION);     // Catch: Throwable -> L7
        m0c.b.b(this.b, "deleteUserComponent, uid=" + r4.b);     // Catch: Throwable -> L7
        e0c.l r5 = (e0c.l) this.c.destroyComponent(r4);     // Catch: Throwable -> L7
        monitor-exit(this);
        return r5;
    L7:
        th = move-exception;
        throw th;
    }

    @Override // com.ss.android.lark.passportc.internal.b
    public final e0c.a b(UserSession r2) {
        Intrinsics.checkNotNullParameter(r2, AppbrandHostConstants.SCHEMA_INSPECT.SESSION);
        e0c.a r3 = (e0c.a) this.e.findComponent(r2);
        if (r3 == null) goto L5;
        return r3;
    L5:
        return (e0c.a) this.f.getValue();
    }

    @Override // com.ss.android.lark.passportc.internal.v
    public final synchronized e0c.l c(UserSession r2) {
        monitor-enter(this);
        Intrinsics.checkNotNullParameter(r2, AppbrandHostConstants.SCHEMA_INSPECT.SESSION);     // Catch: Throwable -> L8
        e0c.l r3 = (e0c.l) this.c.findComponent(r2);     // Catch: Throwable -> L8
        if (r3 != null) goto L6;
        r3 = (e0c.l) this.d.getValue();     // Catch: Throwable -> L8
    L6:
        monitor-exit(this);
        return r3;
    L8:
        th = move-exception;
        throw th;
    }

    @Override // com.ss.android.lark.passportc.internal.y
    public final e0c.a d(UserSession r4) {
        Intrinsics.checkNotNullParameter(r4, AppbrandHostConstants.SCHEMA_INSPECT.SESSION);
        m0c.b.b(this.b, "deleteUserComponent, uid=" + r4.b);
        return (e0c.a) this.e.destroyComponent(r4);
    }

    @Override // com.ss.android.lark.passportc.internal.y
    public final e0c.a f(UserSession r2) {
        Intrinsics.checkNotNullParameter(r2, AppbrandHostConstants.SCHEMA_INSPECT.SESSION);
        return (e0c.a) this.e.findComponent(r2);
    }

    @Override // com.ss.android.lark.passportc.internal.y
    public final e0c.l g(UserSession r2) {
        Intrinsics.checkNotNullParameter(r2, AppbrandHostConstants.SCHEMA_INSPECT.SESSION);
        return (e0c.l) this.c.findComponent(r2);
    }

    @Override // com.ss.android.lark.passportc.internal.y
    public final e0c.a h(f0 r3) {
        Intrinsics.checkNotNullParameter(r3, "userDelete");
        e0c.a r0 = f(r3.getSession());
        if (r0 == null) goto L5;
        return r0;
    L5:
        return (e0c.a) this.e.generatedComponent(r3.getSession(), r3);
    }

    @Override // com.ss.android.lark.passportc.internal.y
    public final synchronized e0c.l i(f0 r3) {
        monitor-enter(this);
        Intrinsics.checkNotNullParameter(r3, "userDelete");     // Catch: Throwable -> L8
        e0c.l r0 = (e0c.l) this.c.findComponent(r3.getSession());     // Catch: Throwable -> L8
        if (r0 != null) goto L6;
        r0 = (e0c.l) this.c.generatedComponent(r3.getSession(), r3);     // Catch: Throwable -> L8
    L6:
        monitor-exit(this);
        return r0;
    L8:
        th = move-exception;
        throw th;
    }

    @Inject
    public UserComponentManagerImpl(b0 r2, com.ss.android.lark.log.c r3) {
        Intrinsics.checkNotNullParameter(r2, "componentProviders");
        Intrinsics.checkNotNullParameter(r3, "logger");
        this.a = r2;
        this.b = r3;
        this.c = new x(r2, r3);
        this.d = LazyKt.lazy(new UserComponentManagerImpl$absentUserComponent$2(this));
        this.e = new d(r2, r3);
        this.f = LazyKt.lazy(new UserComponentManagerImpl$absentBackgroundUserComponent$2(this));
    }
}
