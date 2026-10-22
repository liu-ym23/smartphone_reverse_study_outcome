package af;

import javax.annotation.Nullable;
import jf.r;
import we.c0;
import we.t;

/* JADX INFO: loaded from: classes2.dex */
public final class g extends c0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @Nullable
    public final String f371a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final long f372b;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final jf.f f373m;

    public g(@Nullable String r8, long r10, r r11) {
        this.f371a = r8;
        this.f372b = r10;
        this.f373m = r11;
    }

    @Override // we.c0
    public final long a() {
        return this.f372b;
    }

    @Override // we.c0
    public final t i() {
        String r8 = this.f371a;
        if (r8 != null) goto L7;
        return null;
    L7:
        return t.b(r8);
    }

    @Override // we.c0
    public final jf.f k() {
        return this.f373m;
    }
}
