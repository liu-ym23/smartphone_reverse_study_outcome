package com.loc;

import android.content.Context;
import android.content.Intent;
import android.os.IBinder;
import android.os.Messenger;
import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: loaded from: classes3.dex */
public final class ec {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    cy f5481a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    Context f5482b;
    Messenger c;

    public ec(Context r4) {
        Context r5 = (Context) ZeusTransformUtils.wrapperContextForParams(r4, Context.class, "com.obric.memorydata.plugin");
        this.f5481a = null;
        this.f5482b = ZeusTransformUtils.wrapperContext(null, "com.obric.memorydata.plugin");
        this.c = null;
        this.f5482b = ZeusTransformUtils.wrapperContext((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(r5.getApplicationContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin"), "com.obric.memorydata.plugin");
        this.f5481a = new cy(this.f5482b);
    }

    public final IBinder a(Intent r2) {
        this.f5481a.b(r2);
        this.f5481a.a(r2);
        Messenger r3 = new Messenger(this.f5481a.b());
        this.c = r3;
        return r3.getBinder();
    }

    public final void a() {
        cy.e();     // Catch: Throwable -> L4
        cy r0 = this.f5481a;     // Catch: Throwable -> L4
        r0.j = fd.b();     // Catch: Throwable -> L4
        cy r1 = this.f5481a;     // Catch: Throwable -> L4
        r1.k = fd.a();     // Catch: Throwable -> L4
        this.f5481a.a();     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        ev.a(th, "ApsServiceCore", "onCreate");
    }

    public final int b() {
        cy r0 = this.f5481a;
        if (r0 != null) goto L5;
        return 3;
    L5:
        if (r0.n.isSelfStartServiceEnable() == true) goto L10;
        return 2;
    L10:
        return 3;
    }

    public final void c() {
        cy r2 = this.f5481a;     // Catch: Throwable -> L6
        if (r2 == null) goto L11;
        r2.b().sendEmptyMessage(11);     // Catch: Throwable -> L6
        return;
    L11:
        return;
    L6:
        th = move-exception;
        ev.a(th, "ApsServiceCore", "onDestroy");
    }
}
