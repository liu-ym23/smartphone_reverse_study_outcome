package com.obric.matrix.platform.sdk.ones.account;

import android.content.ComponentName;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Handler;
import android.os.IBinder;
import android.os.Looper;
import com.obric.assistant.onelogin.ObricOneLoginImpl;
import com.ss.android.socialbase.downloader.constants.DBDefinition;
import java.util.Set;
import java.util.concurrent.CopyOnWriteArraySet;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes5.dex */
public final class OAccount {
    public static final OAccount a = null;
    public static volatile AtomicBoolean b;
    public static final CountDownLatch c = null;
    public static g d;
    public static final Handler e = null;
    public static IAccountService f;
    public static final a g = null;
    public static final Lazy h = null;

    public static final class a implements ServiceConnection {
        public a() {
        }

        @Override // android.content.ServiceConnection
        public final void onServiceDisconnected(ComponentName r3) {
            Intrinsics.checkNotNullParameter(r3, DBDefinition.NAME);
            dka.a.f("AccountSDK_OAccount", "onServiceDisconnected: name=" + r3);
            OAccount.f = null;
            OAccount.a.getClass();
            OAccount.d();
        }

        @Override // android.content.ServiceConnection
        public final void onServiceConnected(ComponentName r2, IBinder r3) {
            Intrinsics.checkNotNullParameter(r2, DBDefinition.NAME);
            Intrinsics.checkNotNullParameter(r3, "service");
            dka.a.c("AccountSDK_OAccount", "onServiceConnected: ");
            OAccount r4 = OAccount.a;
            OAccount.f = IAccountService.Stub.asInterface(r3);
        }
    }

    public OAccount() {
    }

    public static void d() {
        c(true);
        dka.a.c("AccountSDK_OAccount", "startBindService: ");
        Intent r2 = new Intent();
        r2.setClassName("com.obric.matrix", "com.obric.matrix.account.service.OAccountService");
        Result.Companion r3 = Result.Companion;     // Catch: Throwable -> L8
        if (AppGlobals.a().bindService(r2, g, 1) == true) goto L6;
        dka.a.b("AccountSDK_OAccount", "startBindService: failed");     // Catch: Throwable -> L8
    L6:
        Object r0 = Result.constructor-impl(Unit.INSTANCE);     // Catch: Throwable -> L8
    L10:
        Throwable r1 = Result.exceptionOrNull-impl(r0);
        if (r1 == null) goto L16;
        dka.a.a.e("AccountSDK_OAccount", "onFailure startBindService: failed", r1);
        return;
    L16:
        return;
    L8:
        th = move-exception;
        Result.Companion r4 = Result.Companion;
        r0 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L10
    }

    static {
        a = new OAccount();
        b = new AtomicBoolean(false);
        c = new CountDownLatch(1);
        e = new Handler(Looper.getMainLooper());
        g = new a();
        h = LazyKt.lazy(OAccount$defaultErrorMsg$2.INSTANCE);
    }

    public static void a(ObricOneLoginImpl.e r2) {
        Intrinsics.checkNotNullParameter(r2, "accountStatusListener");
        g r0 = d;
        if (r0 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("mAccountManager");
        r0 = null;
    L5:
        r0.getClass();
        Intrinsics.checkNotNullParameter(r2, "accountStatusListener");
        Set<cka.a> r1 = g.f;
        monitor-enter(r1);
        ((CopyOnWriteArraySet) r1).add(r2);     // Catch: Throwable -> L10
        monitor-exit(r1);
        return;
    L10:
        th = move-exception;
        throw th;
    }

    public static void b(ObricOneLoginImpl.e r2) {
        Intrinsics.checkNotNullParameter(r2, "accountStatusListener");
        c(true);
        g r0 = d;
        if (r0 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("mAccountManager");
        r0 = null;
    L5:
        r0.getClass();
        Intrinsics.checkNotNullParameter(r2, "accountStatusListener");
        Set<cka.a> r1 = g.h;
        monitor-enter(r1);
        ((CopyOnWriteArraySet) r1).add(r2);     // Catch: Throwable -> L10
        monitor-exit(r1);
        return;
    L10:
        th = move-exception;
        throw th;
    }

    public static void c(boolean r9) throws AccountException {
        if (r9 == false) goto L11;
        if (b.get() == false) goto L15;
        return;
    L15:
        c.await(3000, TimeUnit.MILLISECONDS);     // Catch: Exception -> L8
        return;
    L9:
        throw new AccountException(1002, "account init timeout", null, 4, null);
    L11:
        if (b.get() == false) goto L14;
        return;
    L14:
        throw new AccountException(1001, "please call init first ", null, 4, null);
    }
}
