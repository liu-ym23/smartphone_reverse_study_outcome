package kotlinx.coroutines.flow;

import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;

/* JADX INFO: loaded from: classes3.dex */
public final class t implements g {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f18906a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Object f18907b;

    public /* synthetic */ t(Object r5, int r10) {
        this.f18906a = r10;
        this.f18907b = r5;
    }

    @Override // kotlinx.coroutines.flow.g
    public final Object collect(h r5, Continuation r10) {
        switch(this.f18906a) {
            case 0: goto L9;
            default: goto L4;
        };
    L4:
        n1 r11 = new n1(r5);
        Object r12 = ((q2) ((d2) this.f18907b)).collect(r11, r10);
        if (r12 != IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L8;
        return r12;
    L8:
        return Unit.INSTANCE;
    L9:
        Object r13 = r5.emit(this.f18907b, r10);
        if (r13 != IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L13;
        return r13;
    L13:
        return Unit.INSTANCE;
    }
}
