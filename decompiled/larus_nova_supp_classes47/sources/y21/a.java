package y21;

import com.bytedance.android.live.revlink.impl.pk.feedview.machine.t;
import com.bytedance.android.live.revlink.impl.pk.feedview.machine.w;
import d41.d;
import d41.f;
import d41.g;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class a implements d, g, d41.b {
    public final d41.c a;
    public final d41.c b;
    public final d41.a c;
    public final f d;
    public b e;
    public w f;
    public t g;
    public c h;

    /* JADX INFO: renamed from: y21.a$a, reason: collision with other inner class name */
    public static final class C0347a {
    }

    static {
    }

    @Override // d41.g
    public final void b() {
        b r0 = this.e;
        if (r0 == null) goto L6;
        r0.b();
        return;
    }

    @Override // d41.g
    public final boolean c() {
        b r0 = this.e;
        if (r0 != null) goto L7;
        return false;
    L7:
        return r0.c();
    }

    public a() {
        this.a = new d41.c("pk_left_timer", this);
        this.b = new d41.c("penal_left_timer", this);
        this.c = new d41.a("", this);
        this.d = new f(this);
    }

    @Override // d41.b
    public final void e(String r2, int r3) {
        Intrinsics.checkNotNullParameter(r2, "name");
        c r4 = this.h;
        if (r4 == null) goto L6;
        r4.d(r3);
        return;
    }

    @Override // d41.d
    public final void g(String r2, int r3) {
        Intrinsics.checkNotNullParameter(r2, "name");
        if (Intrinsics.areEqual(r2, "pk_left_timer") == false) goto L10;
        if (r3 != 0) goto L6;
        this.d.b();
    L6:
        w r0 = this.f;
        if (r0 == null) goto L10;
        r0.h(r3);
    L10:
        if (Intrinsics.areEqual(r2, "penal_left_timer") == false) goto L19;
        if (r3 != 0) goto L15;
        b r4 = this.e;
        if (r4 == null) goto L15;
        r4.a();
    L15:
        t r5 = this.g;
        if (r5 == null) goto L20;
        r5.g(r3);
        return;
    L20:
        return;
    }
}
