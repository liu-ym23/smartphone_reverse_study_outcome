package okio;

import com.bytedance.crash.dumper.Scraps;
import java.util.concurrent.TimeUnit;
import kotlin.jvm.JvmName;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes3.dex */
public class m extends g0 {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private g0 f12255e;

    public m(g0 r10) {
        Intrinsics.checkNotNullParameter(r10, "delegate");
        this.f12255e = r10;
    }

    @Override // okio.g0
    public g0 a() {
        return this.f12255e.a();
    }

    @Override // okio.g0
    public g0 b() {
        return this.f12255e.b();
    }

    @Override // okio.g0
    public long c() {
        return this.f12255e.c();
    }

    @Override // okio.g0
    public g0 d(long r10) {
        return this.f12255e.d(r10);
    }

    @Override // okio.g0
    public boolean e() {
        return this.f12255e.e();
    }

    @Override // okio.g0
    public void f() {
        this.f12255e.f();
    }

    @Override // okio.g0
    public g0 g(long r10, TimeUnit r11) {
        Intrinsics.checkNotNullParameter(r11, Scraps.INNER_UNIT);
        return this.f12255e.g(r10, r11);
    }

    @Override // okio.g0
    public long h() {
        return this.f12255e.h();
    }

    @JvmName(name = "delegate")
    public final g0 i() {
        return this.f12255e;
    }

    public final m j(g0 r10) {
        Intrinsics.checkNotNullParameter(r10, "delegate");
        this.f12255e = r10;
        return this;
    }
}
