package com.ss.android.lark.passportc.ffi;

import com.lark.kmp.basic.ActionContext;
import com.ss.android.lark.log.Log;
import com.ss.android.lark.passportc.api.j;
import com.ss.android.lark.passportc.api.p;
import f0c.f;
import f0c.g;
import gy7.e;
import gy7.l;
import javax.inject.Inject;
import javax.inject.Singleton;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
@Singleton
public final class a implements p {
    public static final /* synthetic */ int c = 0;
    public final j a;
    public final CoroutineScope b;

    /* JADX INFO: renamed from: com.ss.android.lark.passportc.ffi.a$a, reason: collision with other inner class name */
    public static final class C0096a implements Function1<f0c.b, Unit> {
        public final /* synthetic */ a a;

        public C0096a(a r1) {
            this.a = r1;
        }

        public final Object invoke(Object r8) {
            f0c.b r9 = (f0c.b) r8;
            Intrinsics.checkNotNullParameter(r9, "state");
            a r0 = this.a;
            BuildersKt.launch$default(r0.b, null, null, new KmpGlobalConvention$1$invoke$1(r0, r9, null), 3, null);
            return Unit.INSTANCE;
        }
    }

    public static final class b {
    }

    static {
    }

    public static e a() {
        com.lark.kmp.containerization.b r0 = iy7.a.a();
        if (r0 == null) goto L9;
        Object r1 = r0.a(Reflection.getOrCreateKotlinClass(e.class));
        if (r1 == null) goto L8;
        return (e) r1;
    L8:
        throw new IllegalArgumentException("No instance of " + Reflection.getOrCreateKotlinClass(e.class).getSimpleName() + " found");
    L9:
        return null;
    }

    @Inject
    public a(j r2) {
        Intrinsics.checkNotNullParameter(r2, "passport");
        this.a = r2;
        this.b = CoroutineScopeKt.CoroutineScope(com.lark.kmp.impl.a.c);
        r2.c(new C0096a(this));
    }

    @Override // com.ss.android.lark.passportc.api.n
    public final void afterUserOffline(f0c.e r5) {
        Intrinsics.checkNotNullParameter(r5, "state");
        int r1 = com.ss.android.lark.passportc.ffi.b.a;
        gy7.p r2 = com.ss.android.lark.passportc.ffi.b.b(r5.c);
        if (r2 != null) goto L5;
        return;
    L5:
        Intrinsics.checkNotNullParameter(r5.b.getContext(), "userActionContext");
        ActionContext r3 = ActionContext.InternalContext;
        com.ss.android.lark.passportc.ffi.b.a(r5.b.b);
        gy7.j r0 = new gy7.j(r2, r3);
        e r6 = a();
        if (r6 != null) goto L8;
        Log.w("PassportKmpGlobalConvention", "afterUserOffline skipped: KMP global service not found");
        return;
    L8:
        r6.g(r0);
    }

    @Override // com.ss.android.lark.passportc.api.n
    public final void afterUserOnline(f r5) {
        Intrinsics.checkNotNullParameter(r5, "state");
        int r1 = com.ss.android.lark.passportc.ffi.b.a;
        gy7.p r2 = com.ss.android.lark.passportc.ffi.b.b(r5.c);
        if (r2 != null) goto L5;
        return;
    L5:
        Intrinsics.checkNotNullParameter(r5.b.getContext(), "userActionContext");
        ActionContext r3 = ActionContext.InternalContext;
        com.ss.android.lark.passportc.ffi.b.a(r5.b.b);
        l r0 = new l(r2, r3);
        e r6 = a();
        if (r6 != null) goto L8;
        Log.w("PassportKmpGlobalConvention", "afterUserOnline skipped: KMP global service not found");
        return;
    L8:
        r6.b(r0);
    }

    @Override // com.ss.android.lark.passportc.api.n
    public final void onUserOffline(f0c.e r5) {
        Intrinsics.checkNotNullParameter(r5, "state");
        int r1 = com.ss.android.lark.passportc.ffi.b.a;
        gy7.p r2 = com.ss.android.lark.passportc.ffi.b.b(r5.c);
        if (r2 != null) goto L5;
        return;
    L5:
        Intrinsics.checkNotNullParameter(r5.b.getContext(), "userActionContext");
        ActionContext r3 = ActionContext.InternalContext;
        com.ss.android.lark.passportc.ffi.b.a(r5.b.b);
        gy7.j r0 = new gy7.j(r2, r3);
        e r6 = a();
        if (r6 != null) goto L8;
        Log.w("PassportKmpGlobalConvention", "onUserOffline skipped: KMP global service not found");
        return;
    L8:
        r6.a(r0);
    }

    @Override // com.ss.android.lark.passportc.api.n
    public final void onUserOnline(f r5) {
        Intrinsics.checkNotNullParameter(r5, "state");
        int r1 = com.ss.android.lark.passportc.ffi.b.a;
        gy7.p r2 = com.ss.android.lark.passportc.ffi.b.b(r5.c);
        if (r2 != null) goto L5;
        return;
    L5:
        Intrinsics.checkNotNullParameter(r5.b.getContext(), "userActionContext");
        ActionContext r3 = ActionContext.InternalContext;
        com.ss.android.lark.passportc.ffi.b.a(r5.b.b);
        l r0 = new l(r2, r3);
        e r6 = a();
        if (r6 != null) goto L8;
        Log.w("PassportKmpGlobalConvention", "onUserOnline skipped: KMP global service not found");
        return;
    L8:
        r6.d(r0);
    }

    @Override // com.ss.android.lark.passportc.api.n
    public final void afterUserChanged(g r4, f0c.b r5) {
        Intrinsics.checkNotNullParameter(r5, "currentState");
        if (r5.a() != null) goto L6;
        Log.w("PassportKmpGlobalConvention", "afterUserChanged skipped: current user payload is null");
        return;
    L6:
        int r2 = com.ss.android.lark.passportc.ffi.b.a;
        gy7.b r0 = new gy7.b(com.ss.android.lark.passportc.ffi.b.c(r5.b), com.ss.android.lark.passportc.ffi.b.b(r5.a()));
        e r6 = a();
        if (r6 != null) goto L9;
        Log.w("PassportKmpGlobalConvention", "afterUserChanged skipped: KMP global service not found");
        return;
    L9:
        r6.f(r0, com.ss.android.lark.passportc.ffi.b.b(r4));
    }

    @Override // com.ss.android.lark.passportc.api.n
    public final void onUserChanged(g r4, f0c.b r5) {
        Intrinsics.checkNotNullParameter(r5, "currentState");
        if (r5.a() != null) goto L6;
        Log.w("PassportKmpGlobalConvention", "onUserChanged skipped: current user payload is null");
        return;
    L6:
        int r2 = com.ss.android.lark.passportc.ffi.b.a;
        gy7.b r0 = new gy7.b(com.ss.android.lark.passportc.ffi.b.c(r5.b), com.ss.android.lark.passportc.ffi.b.b(r5.a()));
        e r6 = a();
        if (r6 != null) goto L9;
        Log.w("PassportKmpGlobalConvention", "onUserChanged skipped: KMP global service not found");
        return;
    L9:
        r6.c(r0, com.ss.android.lark.passportc.ffi.b.b(r4));
    }
}
