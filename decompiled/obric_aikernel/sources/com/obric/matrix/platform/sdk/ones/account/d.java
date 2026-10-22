package com.obric.matrix.platform.sdk.ones.account;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;

/* JADX INFO: loaded from: classes2.dex */
public abstract class d implements a9.c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Context f5835a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final BroadcastReceiver f5836b;

    class a extends BroadcastReceiver {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ d f5837a;

        a(d r10) {
            this.f5837a = r10;
        }

        public static /* synthetic */ void a(a r10, Intent r11) {
            r10.b(r11);
        }

        private /* synthetic */ void b(Intent r10) {
            if (r10.getAction().equals("obric.intent.action.account.LOGIN") == false) goto L6;
            this.f5837a.a();
            return;
        L6:
            if (r10.getAction().equals("obric.intent.action.account.LOGOUT") == false) goto L9;
            int r11 = r10.getIntExtra("obric.intent.extra.account.LOGOUT_SCENE", 0);
            this.f5837a.b(r11);
            return;
        L9:
            if (r10.getAction().equals("obric.intent.action.account.ACCOUNT_INFO_UPDATE") == false) goto L14;
            this.f5837a.c();
            return;
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context r10, final Intent r11) {
            this.f5837a.d(new c(this, r11));
        }
    }

    public d() {
        this.f5836b = new a(this);
        this.f5835a = AppGlobals.f5799a.c();
    }

    @Override // a9.c
    public void a() {
        b9.a.c("AccountSDK_AccountStatusListener", "onAccountLogin");
    }

    @Override // a9.c
    public void b(int r10) {
        b9.a.c("AccountSDK_AccountStatusListener", "onAccountLogout logoutScene = " + r10);
    }

    @Override // a9.c
    public void c() {
        b9.a.c("AccountSDK_AccountStatusListener", "onAccountInfoUpdate");
    }

    protected abstract void d(Runnable r10);

    public void e() {
        IntentFilter r10 = new IntentFilter();
        r10.addAction("obric.intent.action.account.LOGIN");
        r10.addAction("obric.intent.action.account.LOGOUT");
        r10.addAction("obric.intent.action.account.ACCOUNT_INFO_UPDATE");
        this.f5835a.registerReceiver(this.f5836b, r10);
    }
}
