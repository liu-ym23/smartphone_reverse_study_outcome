package com.bytedance.badger.x;

import android.content.ComponentName;
import android.content.ServiceConnection;
import android.os.IBinder;
import java.util.concurrent.CountDownLatch;
import kotlin.jvm.internal.Ref;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class s implements ServiceConnection {
    public final /* synthetic */ u a;
    public final /* synthetic */ CountDownLatch b;
    public final /* synthetic */ Ref.ObjectRef c;

    public s(u r1, CountDownLatch r2, Ref.ObjectRef r3) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
    }

    @Override // android.content.ServiceConnection
    public final void onBindingDied(ComponentName r4) {
        if (this.a.d == this) goto L5;
        return;
    L5:
        this.a.b = null;
        Ref.ObjectRef r5 = this.c;
        r5.element = new C0390f("service binding died", null);
        this.b.countDown();
    }

    @Override // android.content.ServiceConnection
    public final void onNullBinding(ComponentName r4) {
        if (this.a.d == this) goto L5;
        return;
    L5:
        Ref.ObjectRef r5 = this.c;
        r5.element = new C0390f("service null binding", null);
        this.b.countDown();
    }

    @Override // android.content.ServiceConnection
    public final void onServiceDisconnected(ComponentName r2) {
        if (this.a.d == this) goto L5;
        return;
    L5:
        this.a.b = null;
    }

    @Override // android.content.ServiceConnection
    public final void onServiceConnected(ComponentName r1, IBinder r2) {
        if (this.a.d == this) goto L5;
        return;
    L5:
        u r3 = this.a;
        r3.b = C.a(r2);
        this.b.countDown();
    }
}
