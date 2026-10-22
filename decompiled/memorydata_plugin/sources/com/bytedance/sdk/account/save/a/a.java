package com.bytedance.sdk.account.save.a;

import android.os.Handler;
import android.os.Looper;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/* JADX INFO: loaded from: classes2.dex */
public abstract class a<T> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static ExecutorService f3135a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final Handler f3136b = null;

    static {
        f3135a = Executors.newSingleThreadExecutor();
        f3136b = new Handler(Looper.getMainLooper());
    }

    public a() {
    }

    static /* synthetic */ void a(a r0, Object r1) {
        r0.b(r1);
    }

    private void b(final T r3) {
        f3136b.post(new AnonymousClass2(this, r3));
    }

    public void a(T r1) {
    }

    public abstract T b();

    public final void c() {
        f3135a.execute(new AnonymousClass1(this));
    }
}
