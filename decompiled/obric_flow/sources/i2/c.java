package i2;

import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes2.dex */
public abstract class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final AtomicBoolean f17489a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final l2.a f17490b;

    public c() {
        this.f17489a = new AtomicBoolean(false);
        this.f17490b = new l2.a();
    }

    public void a() {
        this.f17490b.a();
        this.f17489a.compareAndSet(false, true);
    }

    public abstract void b(a r5);

    public void c() {
        String r5 = "[" + getClass().getSimpleName() + "] remoteReady";
        Intrinsics.checkNotNullParameter("ai_bridge", "tag");
        Intrinsics.checkNotNullParameter(r5, "msg");
        a1.a.f43a.d("ai_bridge", r5);
        this.f17490b.b(new b(this, 0));
    }

    public abstract void d(j2.a r5);
}
