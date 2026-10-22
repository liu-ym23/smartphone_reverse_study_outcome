package com.obric.matrix.platform.sdk.ones.account;

import android.app.Application;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.Handler;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Looper;
import com.obric.cae.R;
import com.qualcomm.qti.qesdk.QesdkUtils;
import ge.l;
import ge.p;
import he.i;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;
import xd.e;
import xd.f;
import xd.j;

/* JADX INFO: loaded from: classes2.dex */
public final class OAccount {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final OAccount f6096a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static volatile AtomicBoolean f6097b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final CountDownLatch f6098c = null;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final Handler f6099d = null;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static IAccountService f6100e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final b f6101f = null;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final f f6102g = null;

    public static final class AsyncResultCallback extends IAccountActionCallback.Stub {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public ge.a<j> f6103a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public p<? super Integer, ? super String, j> f6104b;

        /* JADX INFO: renamed from: m, reason: collision with root package name */
        public l<? super Bundle, j> f6105m;

        public static final class a extends he.j implements ge.a<j> {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final /* synthetic */ AsyncResultCallback f6106a;

            public a(AsyncResultCallback r8) {
                this.f6106a = r8;
                super(0);
            }

            @Override // ge.a
            public final j f() {
                AsyncResultCallback r8 = this.f6106a;
                r8.f6103a = null;
                r8.f6104b = null;
                r8.f6105m = null;
                return j.f13877a;
            }
        }

        public final void I2(final boolean r10, final Bundle r11) {
            OAccount r8 = OAccount.f6096a;
            final ge.a<j> r12 = this.f6103a;
            final l<? super Bundle, j> r13 = this.f6105m;
            final p<? super Integer, ? super String, j> r14 = this.f6104b;
            final a r15 = new a(this);
            r8.getClass();
            OAccount.f6099d.post(new c(r11, r12, r15, r13, r14, r10));
        }
    }

    public static final class a extends he.j implements ge.a<String> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final a f6107a = null;

        static {
            f6107a = new a();
        }

        public a() {
            super(0);
        }

        @Override // ge.a
        public final String f() {
            Context r8 = ((Application) com.obric.matrix.platform.sdk.ones.account.b.f6110a.getValue()).getApplicationContext();
            i.e(r8, "getApplication().applicationContext");
            return r8.getString(R.string.sdk_account_unknown_error);
        }
    }

    public static final class b implements ServiceConnection {
        @Override // android.content.ServiceConnection
        public final void onServiceConnected(ComponentName r8, IBinder r10) {
            i.f(r8, QesdkUtils.TAGS.JSON_TAG_NAME);
            i.f(r10, "service");
            OAccount r11 = OAccount.f6096a;
            int r12 = IAccountService.Stub.f6094a;
            IInterface r13 = r10.queryLocalInterface("com.obric.matrix.platform.sdk.ones.account.IAccountService");
            if (r13 != null) goto L5;
        L7:
            IAccountService r14 = new IAccountService.Stub.Proxy(r10);
        L8:
            OAccount.f6100e = r14;
            return;
        L5:
            if ((r13 instanceof IAccountService) == false) goto L7;
            r14 = (IAccountService) r13;
            goto L8
        }

        @Override // android.content.ServiceConnection
        public final void onServiceDisconnected(ComponentName r8) {
            i.f(r8, QesdkUtils.TAGS.JSON_TAG_NAME);
            i.f("onServiceDisconnected: name=" + r8, "msg");
            OAccount.f6096a.getClass();
            if (OAccount.f6097b.get() == false) goto L15;
        L6:
            Intent r10 = new Intent();
            r10.setClassName("com.obric.matrix", "com.obric.matrix.account.service.OAccountService");
            Context r11 = ((Application) com.obric.matrix.platform.sdk.ones.account.b.f6110a.getValue()).getApplicationContext();     // Catch: Throwable -> L9
            i.e(r11, "getApplication().applicationContext");     // Catch: Throwable -> L9
            r11.bindService(r10, OAccount.f6101f, 1);     // Catch: Throwable -> L9
            Object r12 = j.f13877a;     // Catch: Throwable -> L9
        L11:
            e.a(r12);
            return;
        L9:
            th = move-exception;
            r12 = defpackage.c.D(th);
            goto L11
        L15:
            OAccount.f6098c.await(3000, TimeUnit.MILLISECONDS);     // Catch: Exception -> L13
        L14:
            throw new com.obric.matrix.platform.sdk.ones.account.a(1002, "account init timeout");
        }
    }

    static {
        f6096a = new OAccount();
        f6097b = new AtomicBoolean(false);
        f6098c = new CountDownLatch(1);
        f6099d = new Handler(Looper.getMainLooper());
        f6101f = new b();
        f6102g = defpackage.c.R(a.f6107a);
    }

    public OAccount() {
    }
}
