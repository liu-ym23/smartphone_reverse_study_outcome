package r4;

import com.lynx.jsbridge.LynxResourceModule;
import java.util.HashMap;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes2.dex */
public final class m extends a {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public float f21692b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public float f21693c;
    public float d;
    public float e;
    public float f;
    public float g;

    @Override // r4.a
    public final String d() {
        return "tf";
    }

    @Override // r4.a
    public final void e(HashMap r5, q4.c r10) {
        Intrinsics.checkNotNullParameter(r5, LynxResourceModule.PARAMS_KEY);
        Intrinsics.checkNotNullParameter(r10, "dataManager");
        this.f21692b = a.b("kx", r5);
        this.f21693c = a.b("ky", r5);
        this.d = a.b("sx", r5);
        this.e = a.b("sy", r5);
        this.f = a.b("dx", r5);
        this.g = a.b("dy", r5);
    }

    @Override // r4.a
    public final void f(q4.b r5) {
        Intrinsics.checkNotNullParameter(r5, "context");
        r5.a().scale(this.d, this.e);
        r5.a().skew(this.f21692b, this.f21693c);
        r5.a().translate(this.f, this.g);
    }
}
