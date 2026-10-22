package rc;

import com.lynx.tasm.ui.image.f0;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes2.dex */
public final class b implements f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final a f21721a;

    public b(a r5) {
        Intrinsics.checkNotNullParameter("default_bid", "businessId");
        Intrinsics.checkNotNullParameter(r5, "serviceContext");
        this.f21721a = r5;
    }

    @Override // rc.f
    public final c a(Class r5) {
        Intrinsics.checkNotNullParameter(r5, "clazz");
        tc.c r10 = tc.c.f22119c;
        return tc.c.f22119c.a(r5, "default_bid");
    }

    @Override // rc.f
    public final Object b(Class r5) {
        return f0.c(this, r5);
    }

    @Override // rc.f
    public final Map getAllDependency() {
        return this.f21721a.a();
    }

    @Override // rc.f
    public final String getBid() {
        return "default_bid";
    }

    @Override // rc.f
    public final e getServiceContext() {
        return this.f21721a;
    }
}
