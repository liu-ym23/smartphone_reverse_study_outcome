package kotlinx.coroutines.flow;

import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.internal.Ref;

/* JADX INFO: loaded from: classes3.dex */
public final class e implements g {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final g f18842a;

    public e(g r5) {
        this.f18842a = r5;
    }

    /* JADX WARN: Type inference failed for: r1v0, types: [T, g8.g] */
    @Override // kotlinx.coroutines.flow.g
    public final Object collect(h r5, Continuation r10) {
        Ref.ObjectRef r11 = new Ref.ObjectRef();
        r11.element = kotlinx.coroutines.flow.internal.b.f18863b;
        d r12 = new d(this, r11, r5);
        Object r13 = this.f18842a.collect(r12, r10);
        if (r13 != IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L6;
        return r13;
    L6:
        return Unit.INSTANCE;
    }
}
