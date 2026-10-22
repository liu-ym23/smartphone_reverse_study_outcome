package com.obric.matrix.platform.sdk.ones.account;

import android.app.Application;
import android.content.ComponentName;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.Handler;
import android.os.IBinder;
import android.os.Looper;
import androidx.core.view.PointerIconCompat;
import com.bytedance.common.wschannel.WsConstants;
import com.bytedance.crash.tracker.ActivityLifecycle;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes2.dex */
public final class OAccount {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final OAccount f5801a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static volatile AtomicBoolean f5802b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static final CountDownLatch f5803c = null;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static a9.a f5804d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private static a9.b f5805e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private static Handler f5806f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private static f f5807g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private static final ServiceConnection f5808h = null;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private static final Lazy f5809i = null;

    public static final class AsyncResultCallback extends e.a {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private final String f5810c;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        private Function0<Unit> f5811g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        private Function2<? super Integer, ? super String, Unit> f5812h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        private Function1<? super Bundle, Unit> f5813i;

        public AsyncResultCallback(String r10, Function0<Unit> r11, Function2<? super Integer, ? super String, Unit> r12, Function1<? super Bundle, Unit> r13) {
            Intrinsics.checkNotNullParameter(r10, "methodName");
            this.f5810c = r10;
            this.f5811g = r11;
            this.f5812h = r12;
            this.f5813i = r13;
        }

        public /* synthetic */ AsyncResultCallback(String r10, Function0 r11, Function2 r12, Function1 r13, int r14, DefaultConstructorMarker r15) {
            if ((r14 & 8) == 0) goto L5;
            r13 = null;
        L5:
            this(r10, r11, r12, r13);
        }

        public static final /* synthetic */ void U0(AsyncResultCallback r10, Function2 r11) {
            r10.f5812h = r11;
        }

        public static final /* synthetic */ void f2(AsyncResultCallback r10, Function1 r11) {
            r10.f5813i = r11;
        }

        public static final /* synthetic */ void k1(AsyncResultCallback r10, Function0 r11) {
            r10.f5811g = r11;
        }

        @Override // com.obric.matrix.platform.sdk.ones.account.e
        public void u1(boolean r10, Bundle r11) {
            OAccount.b(OAccount.f5801a, this.f5810c, r10, r11, this.f5811g, this.f5813i, this.f5812h, new OAccount$AsyncResultCallback$onResult$1(this));
        }
    }

    public static final class a implements ServiceConnection {
        a() {
        }

        @Override // android.content.ServiceConnection
        public void onServiceConnected(ComponentName r10, IBinder r11) {
            Intrinsics.checkNotNullParameter(r10, ActivityLifecycle.NAME);
            Intrinsics.checkNotNullParameter(r11, "service");
            b9.a.f("AccountSDK_OAccount", "onServiceConnected: ");
            OAccount r12 = OAccount.f5801a;
            OAccount.c(f.a.U0(r11));
        }

        @Override // android.content.ServiceConnection
        public void onServiceDisconnected(ComponentName r10) {
            Intrinsics.checkNotNullParameter(r10, ActivityLifecycle.NAME);
            b9.a.h("AccountSDK_OAccount", "onServiceDisconnected: name=" + r10);
            OAccount r11 = OAccount.f5801a;
            OAccount.c(null);
            OAccount.d(r11);
        }
    }

    static {
        f5801a = new OAccount();
        f5802b = new AtomicBoolean(false);
        f5803c = new CountDownLatch(1);
        f5806f = new Handler(Looper.getMainLooper());
        f5808h = new a();
        f5809i = LazyKt.lazy(OAccount$defaultErrorMsg$2.INSTANCE);
    }

    private OAccount() {
    }

    public static /* synthetic */ void a(boolean r10, String r11, Function1 r12, Bundle r13, Function0 r14, Function0 r15, Function2 r16) {
        g(r10, r11, r12, r13, r14, r15, r16);
    }

    public static final /* synthetic */ void b(OAccount r10, String r11, boolean r12, Bundle r13, Function0 r14, Function1 r15, Function2 r16, Function0 r17) {
        r10.f(r11, r12, r13, r14, r15, r16, r17);
    }

    public static final /* synthetic */ void c(f r10) {
        f5807g = r10;
    }

    public static final /* synthetic */ void d(OAccount r10) {
        r10.p();
    }

    private final void f(final String r11, final boolean r12, final Bundle r13, final Function0<Unit> r14, final Function1<? super Bundle, Unit> r15, final Function2<? super Integer, ? super String, Unit> r16, final Function0<Unit> r17) {
        f5806f.post(new g(r12, r11, r15, r13, r14, r17, r16));
    }

    private static final void g(boolean r10, String r11, Function1 r12, Bundle r13, Function0 r14, Function0 r15, Function2 r16) {
        Intrinsics.checkNotNullParameter(r11, "$method");
        if (r10 == false) goto L11;
        b9.a.c("AccountSDK_OAccount", "asyncResult, " + r11 + ", success");
        if (r12 == null) goto L7;
        r12.invoke(r13);
    L9:
        if (r15 == null) goto L17;
    L15:
        r15.invoke();
        return;
    L17:
        return;
    L7:
        if (r14 == null) goto L9;
        r14.invoke();
        goto L9
    L11:
        OAccount r17 = f5801a;
        int r18 = r17.l(r13, -1);
        String r19 = r17.k();
        Intrinsics.checkNotNullExpressionValue(r19, "defaultErrorMsg");
        String r20 = r17.m(r13, r19);
        b9.a.d("AccountSDK_OAccount", "asyncResult, " + r11 + " failed. errorCode: " + r18 + " errorMsg: " + r20 + '.');
        if (r16 == null) goto L14;
        r16.invoke(Integer.valueOf(r18), r20);
    L14:
        if (r15 != null) goto L15;
    }

    private final void h(boolean r10) {
        boolean r11 = f5802b.get();
        if (r10 == false) goto L10;
        if (r11 == false) goto L14;
        return;
    L14:
        f5803c.await(WsConstants.EXIT_DELAY_TIME, TimeUnit.MILLISECONDS);     // Catch: Exception -> L8
        return;
    L9:
        throw new AccountException(PointerIconCompat.TYPE_HAND, "account init timeout", null, 4, null);
    L10:
        if (r11 == false) goto L13;
        return;
    L13:
        throw new AccountException(1001, "please call init first ", null, 4, null);
    }

    static /* synthetic */ void i(OAccount r10, boolean r11, int r12, Object r13) {
        if ((r12 & 1) == 0) goto L5;
        r11 = true;
    L5:
        r10.h(r11);
    }

    private final void j(Application r10, a9.d r11, a9.a r12, boolean r13) {
        b9.a.f("AccountSDK_OAccount", "init, asyncInit: " + r13);
        AtomicBoolean r14 = f5802b;
        monitor-enter(r14);
    L12:
        th = move-exception;
        throw th;
    L5:
        if (f5802b.get() == false) goto L9;
        b9.a.h("AccountSDK_OAccount", "Init already.");     // Catch: Throwable -> L12
        monitor-exit(r14);
        return;
    L9:
        b9.a.f540a.g(r11);     // Catch: Throwable -> L12
        OAccount r15 = f5801a;     // Catch: Throwable -> L12
        f5804d = r12;     // Catch: Throwable -> L12
        f5805e = i.f5848c;     // Catch: Throwable -> L12
        r15.o(r13);     // Catch: Throwable -> L12
        f5802b.set(true);     // Catch: Throwable -> L12
        f5803c.countDown();     // Catch: Throwable -> L12
        r15.p();     // Catch: Throwable -> L12
        Unit r16 = Unit.INSTANCE;     // Catch: Throwable -> L12
        monitor-exit(r14);
    }

    private final String k() {
        return (String) f5809i.getValue();
    }

    private final int l(Bundle r10, int r11) {
        if (r10 != null) goto L4;
        return r11;
    L4:
        return r10.getInt("errorCode", r11);
    }

    private final String m(Bundle r10, String r11) {
        if (r10 == null) goto L4;
        String r12 = r10.getString("errorMsg", r11);
    L5:
        if (r12 != null) goto L8;
        return r11;
    L8:
        return r12;
    L4:
        r12 = null;
        goto L5
    }

    private final void o(boolean r10) {
        a9.b r11 = f5805e;
        if (r11 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("mAccountManager");
        r11 = null;
    L5:
        r11.A(r10);
    }

    private final void p() {
        i(this, false, 1, null);
        b9.a.f("AccountSDK_OAccount", "startBindService: ");
        Intent r10 = new Intent();
        r10.setClassName("com.obric.matrix", "com.obric.matrix.account.service.OAccountService");
        Result.Companion r11 = Result.Companion;     // Catch: Throwable -> L8
        if (AppGlobals.f5799a.c().bindService(r10, f5808h, 1) == true) goto L6;
        b9.a.d("AccountSDK_OAccount", "startBindService: failed");     // Catch: Throwable -> L8
    L6:
        Object r12 = Result.m32constructorimpl(Unit.INSTANCE);     // Catch: Throwable -> L8
    L10:
        Throwable r13 = Result.m35exceptionOrNullimpl(r12);
        if (r13 == null) goto L16;
        b9.a.f540a.e("AccountSDK_OAccount", "onFailure startBindService: failed", r13);
        return;
    L16:
        return;
    L8:
        th = move-exception;
        Result.Companion r14 = Result.Companion;
        r12 = Result.m32constructorimpl(ResultKt.createFailure(th));
        goto L10
    }

    public final a9.a e() {
        i(this, false, 1, null);
        a9.a r10 = f5804d;
        if (r10 != null) goto L6;
        Intrinsics.throwUninitializedPropertyAccessException("mAccountBridge");
        return null;
    L6:
        return r10;
    }

    public final void n(Application r10, a9.d r11, a9.a r12) {
        Intrinsics.checkNotNullParameter(r10, "application");
        Intrinsics.checkNotNullParameter(r11, "logger");
        Intrinsics.checkNotNullParameter(r12, "bridge");
        j(r10, r11, r12, false);
    }
}
