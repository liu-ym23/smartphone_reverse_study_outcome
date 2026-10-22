package e0;

import android.content.Context;
import android.net.Uri;
import av.i;
import d0.q;
import d0.r;

/* JADX INFO: loaded from: classes.dex */
public final class f implements r {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Context f16737a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final r f16738b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final r f16739c;
    public final Class d;

    public f(Context r5, r r10, r r11, Class r12) {
        this.f16737a = r5.getApplicationContext();
        this.f16738b = r10;
        this.f16739c = r11;
        this.d = r12;
    }

    @Override // d0.r
    public final boolean a(Object r5) {
        return i.s((Uri) r5);
    }

    @Override // d0.r
    public final q b(Object r12, int r13, int r14, z.f r15) {
        Uri r5 = (Uri) r12;
        return new q(new p0.b(r5), new e(this.f16737a, this.f16738b, this.f16739c, r5, r13, r14, r15, this.d));
    }
}
