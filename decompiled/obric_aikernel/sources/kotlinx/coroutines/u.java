package kotlinx.coroutines;

import kotlin.Unit;
import kotlin.jvm.JvmField;

/* JADX INFO: loaded from: classes3.dex */
public final class u extends w1 implements t {

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    @JvmField
    public final v f10720j;

    public u(v r10) {
        this.f10720j = r10;
    }

    @Override // kotlinx.coroutines.t
    public boolean b(Throwable r10) {
        return r().j0(r10);
    }

    @Override // kotlinx.coroutines.t
    public v1 getParent() {
        return r();
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(Throwable r10) {
        q(r10);
        return Unit.INSTANCE;
    }

    @Override // kotlinx.coroutines.d0
    public void q(Throwable r10) {
        this.f10720j.s(r());
    }
}
