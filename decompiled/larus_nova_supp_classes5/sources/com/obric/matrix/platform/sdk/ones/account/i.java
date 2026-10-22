package com.obric.matrix.platform.sdk.ones.account;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes5.dex */
public abstract class i implements cka.a {
    public final Context a;
    public final a b;

    public class a extends BroadcastReceiver {
        public final /* synthetic */ i a;

        public a(i r1) {
            this.a = r1;
        }

        @Override // android.content.BroadcastReceiver
        public final void onReceive(Context r2, Intent r3) {
            this.a.d(new h(this, r3));
        }
    }

    public abstract void d(Runnable r1);

    public void a() {
        dka.a.a("AccountSDK_SecureAccountStatusListener", "onAccountLogin");
    }

    public void b() {
        dka.a.a("AccountSDK_SecureAccountStatusListener", "onAccountInfoUpdate");
    }

    public i() {
        this.b = new a(this);
        this.a = AppGlobals.a();
    }

    public void c(int r3) {
        dka.a.a("AccountSDK_SecureAccountStatusListener", "onAccountLogout logoutScene = " + r3);
    }
}
