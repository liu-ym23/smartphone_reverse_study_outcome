package com.obric.matrix.platform.sdk.ones.account;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes5.dex */
public abstract class d implements cka.a {
    public final Context a;
    public final a b;

    public class a extends BroadcastReceiver {
        public final /* synthetic */ d a;

        public a(d r1) {
            this.a = r1;
        }

        @Override // android.content.BroadcastReceiver
        public final void onReceive(Context r2, Intent r3) {
            d r4 = this.a;
            Runnable r0 = new c(this, r3);
            ((g) r4).getClass();
            Intrinsics.checkNotNullParameter(r0, "runnable");
            g.j.post(r0);
        }
    }

    public abstract void a();

    public abstract void b();

    public abstract void c(int r1);

    public d() {
        this.b = new a(this);
        this.a = AppGlobals.a();
    }
}
