package va;

import ae.d;
import ce.c;
import ce.e;
import com.obric.aikernel.phx.sdk.api.AIKernelApi;

/* JADX INFO: loaded from: classes.dex */
@e(c = "com.obric.aikernel.phx.sdk.api.AIKernelApi", f = "AIKernelApi.kt", l = {149}, m = "updatePackageInner-0E7RQCE")
public final class b extends c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public /* synthetic */ Object f12779a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ AIKernelApi f12780b;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public int f12781m;

    public b(AIKernelApi r8, d<? super b> r10) {
        this.f12780b = r8;
        super(r10);
    }

    @Override // ce.a
    public final Object invokeSuspend(Object r8) {
        this.f12779a = r8;
        this.f12781m |= Integer.MIN_VALUE;
        Object r10 = AIKernelApi.c(this.f12780b, null, null, this);
        if (r10 != be.a.f3165a) goto L6;
        return r10;
    L6:
        return new xd.e(r10);
    }
}
