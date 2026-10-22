package r0;

import android.util.Log;
import androidx.core.util.Pools;

/* JADX INFO: loaded from: classes.dex */
public final class d implements Pools.Pool {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final c f21635a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final f f21636b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Pools.SynchronizedPool f21637c;

    public d(Pools.SynchronizedPool r5, c r10, f r11) {
        this.f21637c = r5;
        this.f21635a = r10;
        this.f21636b = r11;
    }

    @Override // androidx.core.util.Pools.Pool
    public final Object acquire() {
        Object r5 = this.f21637c.acquire();
        if (r5 != null) goto L8;
        r5 = this.f21635a.create();
        if (Log.isLoggable("FactoryPools", 2) == false) goto L8;
        Log.v("FactoryPools", "Created new " + r5.getClass());
    L8:
        if ((r5 instanceof e) == false) goto L10;
        ((e) r5).b().f10127a = false;
    L10:
        return r5;
    }

    @Override // androidx.core.util.Pools.Pool
    public final boolean release(Object r5) {
        if ((r5 instanceof e) == false) goto L5;
        ((e) r5).b().f10127a = true;
    L5:
        this.f21636b.c(r5);
        return this.f21637c.release(r5);
    }
}
