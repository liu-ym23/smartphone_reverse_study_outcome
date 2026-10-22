package androidx.lifecycle;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;

/* JADX INFO: loaded from: classes.dex */
public class p extends Service implements m {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final g0 f2186a;

    public p() {
        this.f2186a = new g0(this);
    }

    @Override // androidx.lifecycle.m
    public final h getLifecycle() {
        return this.f2186a.f2150a;
    }

    @Override // android.app.Service
    public final IBinder onBind(Intent r8) {
        he.i.f(r8, "intent");
        g0 r10 = this.f2186a;
        r10.getClass();
        r10.a(h.a.ON_START);
        return null;
    }

    @Override // android.app.Service
    public void onCreate() {
        g0 r8 = this.f2186a;
        r8.getClass();
        r8.a(h.a.ON_CREATE);
        super.onCreate();
    }

    @Override // android.app.Service
    public void onDestroy() {
        g0 r8 = this.f2186a;
        r8.getClass();
        r8.a(h.a.ON_STOP);
        r8.a(h.a.ON_DESTROY);
        super.onDestroy();
    }

    @Override // android.app.Service
    public final void onStart(Intent r8, int r10) {
        g0 r11 = this.f2186a;
        r11.getClass();
        r11.a(h.a.ON_START);
        super.onStart(r8, r10);
    }

    @Override // android.app.Service
    public int onStartCommand(Intent r8, int r10, int r11) {
        return super.onStartCommand(r8, r10, r11);
    }
}
