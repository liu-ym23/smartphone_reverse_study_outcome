package com.ss.android.lark.passportc.ffi;

import com.ss.android.lark.log.Log;
import com.ss.android.lark.passportc.api.m;
import com.ss.android.lark.passportc.api.q;
import com.ss.android.lark.passportc.dwarf.UserScope;
import f0c.h;
import javax.inject.Inject;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineDispatcher;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
@UserScope
public final class KmpUserConvention implements q {
    public static final /* synthetic */ int d = 0;
    public final m a;
    public final CoroutineScope b;
    public final Lazy c;

    public static final class a implements Function1<h, Unit> {
        public final /* synthetic */ KmpUserConvention a;

        public a(KmpUserConvention r1) {
            this.a = r1;
        }

        public final Object invoke(Object r8) {
            h r9 = (h) r8;
            Intrinsics.checkNotNullParameter(r9, "userStatePayload");
            KmpUserConvention r0 = this.a;
            BuildersKt.launch$default(r0.b, null, null, new KmpUserConvention$1$invoke$1(r0, r9, null), 3, null);
            return Unit.INSTANCE;
        }
    }

    public static final class b {
    }

    static {
    }

    @Inject
    public KmpUserConvention(m r2) {
        Intrinsics.checkNotNullParameter(r2, "passport");
        this.a = r2;
        CoroutineDispatcher r0 = com.lark.kmp.impl.a.a;
        this.b = CoroutineScopeKt.CoroutineScope(com.lark.kmp.impl.a.c);
        this.c = LazyKt.lazy(new KmpUserConvention$userService$2(this));
        r2.a(new a(this));
    }

    @Override // com.ss.android.lark.passportc.api.o
    public final void afterUserOffline(h r2) {
        Intrinsics.checkNotNullParameter(r2, "state");
        gy7.h r0 = (gy7.h) this.c.getValue();
        if (r0 != null) goto L5;
        Log.w("PassportKmpUserConvention", "afterUserOffline skipped: KMP user service not found");
        return;
    L5:
        r0.a(com.ss.android.lark.passportc.ffi.b.c(r2));
    }

    @Override // com.ss.android.lark.passportc.api.o
    public final void afterUserOnline(h r2) {
        Intrinsics.checkNotNullParameter(r2, "state");
        gy7.h r0 = (gy7.h) this.c.getValue();
        if (r0 != null) goto L5;
        Log.w("PassportKmpUserConvention", "afterUserOnline skipped: KMP user service not found");
        return;
    L5:
        r0.c(com.ss.android.lark.passportc.ffi.b.c(r2));
    }

    @Override // com.ss.android.lark.passportc.api.o
    public final void onUserOffline(h r2) {
        Intrinsics.checkNotNullParameter(r2, "state");
        gy7.h r0 = (gy7.h) this.c.getValue();
        if (r0 != null) goto L5;
        Log.w("PassportKmpUserConvention", "onUserOffline skipped: KMP user service not found");
        return;
    L5:
        r0.b(com.ss.android.lark.passportc.ffi.b.c(r2));
    }

    @Override // com.ss.android.lark.passportc.api.o
    public final void onUserOnline(h r2) {
        Intrinsics.checkNotNullParameter(r2, "state");
        gy7.h r0 = (gy7.h) this.c.getValue();
        if (r0 != null) goto L5;
        Log.w("PassportKmpUserConvention", "onUserOnline skipped: KMP user service not found");
        return;
    L5:
        r0.f(com.ss.android.lark.passportc.ffi.b.c(r2));
    }
}
