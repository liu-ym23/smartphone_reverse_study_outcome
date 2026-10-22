package androidx.fragment.app;

import android.app.Activity;
import android.content.Context;
import android.os.Handler;
import android.view.LayoutInflater;

/* JADX INFO: loaded from: classes.dex */
public abstract class r<E> extends o {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Activity f2042a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Context f2043b;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final Handler f2044m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public final u f2045n;

    public r(m r8) {
        Handler r10 = new Handler();
        this.f2045n = new u();
        this.f2042a = r8;
        t2.b.n(r8, "context == null");
        this.f2043b = r8;
        this.f2044m = r10;
    }

    public abstract m d();

    public abstract LayoutInflater e();

    public abstract boolean f(String r8);

    public abstract void g();
}
