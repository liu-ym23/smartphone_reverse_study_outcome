package e0;

import d0.b0;
import d0.g;
import d0.r;
import d0.s;
import d0.z;
import java.io.InputStream;

/* JADX INFO: loaded from: classes.dex */
public final class b implements s {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f16725a;

    public /* synthetic */ b(int r5) {
        this.f16725a = r5;
    }

    @Override // d0.s
    public final r a(z r5) {
        switch(this.f16725a) {
            case 0: goto L7;
            default: goto L5;
        };
    L5:
        return new b0(r5.b(g.class, InputStream.class), 1);
    L7:
        return new c(r5.b(g.class, InputStream.class));
    }
}
