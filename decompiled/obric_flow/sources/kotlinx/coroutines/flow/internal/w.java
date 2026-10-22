package kotlinx.coroutines.flow.internal;

import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;

/* JADX INFO: loaded from: classes3.dex */
public final class w implements kotlinx.coroutines.flow.h {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final kotlinx.coroutines.channels.u f18885a;

    public w(kotlinx.coroutines.channels.u r5) {
        this.f18885a = r5;
    }

    @Override // kotlinx.coroutines.flow.h
    public final Object emit(Object r5, Continuation r10) {
        Object r11 = ((kotlinx.coroutines.channels.j) this.f18885a).d.r(r5, r10);
        if (r11 != IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L6;
        return r11;
    L6:
        return Unit.INSTANCE;
    }
}
