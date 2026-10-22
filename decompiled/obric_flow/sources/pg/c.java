package pg;

import android.app.Application;
import com.bytedance.ies.bullet.core.j;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/* JADX INFO: loaded from: classes2.dex */
public final class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public Application f21347a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public vg.a f21348b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public qg.a f21349c;
    public ExecutorService d;
    public long e;
    public long f;
    public boolean g;

    public c() {
        this.e = -1;
        this.f = -1;
        this.g = true;
    }

    public final d a() {
        if (this.f21347a == null) goto L27;
        if (this.f21349c == null) goto L25;
        if (this.f21348b != null) goto L10;
        this.f21348b = new vg.a();
    L10:
        if (this.d != null) goto L13;
        this.d = Executors.newCachedThreadPool();
    L13:
        if (this.e >= 0) goto L16;
        this.e = 3600000;
    L16:
        if (this.f >= 0) goto L18;
        this.f = 120000;
    L18:
        j r5 = new j();
        r5.f5321c = this.f21348b;
        r5.d = this.d;
        r5.f5319a = this.g;
        Application r10 = this.f21347a;
        if (r10 == null) goto L23;
        return new d(r10, this.f21349c, r5);
    L23:
        return new d(r10.getApplicationContext(), this.f21349c, r5);
    L25:
        throw new IllegalArgumentException("requestService不能为空");
    L27:
        throw new IllegalArgumentException("context不能为空");
    }
}
