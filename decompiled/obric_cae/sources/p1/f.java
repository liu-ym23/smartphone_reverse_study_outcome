package p1;

import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;

/* JADX INFO: loaded from: classes.dex */
public abstract class f<T> extends h<T> {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final e f9920f;

    public f(Context r8, u1.b r10) {
        super(r8, r10);
        this.f9920f = new e(this);
    }

    @Override // p1.h
    public final void d() {
        androidx.work.m.d().a(g.f9921a, getClass().getSimpleName().concat(": registering receiver"));
        IntentFilter r8 = f();
        this.f9923b.registerReceiver(this.f9920f, r8);
    }

    @Override // p1.h
    public final void e() {
        androidx.work.m.d().a(g.f9921a, getClass().getSimpleName().concat(": unregistering receiver"));
        e r8 = this.f9920f;
        this.f9923b.unregisterReceiver(r8);
    }

    public abstract IntentFilter f();

    public abstract void g(Intent r8);
}
