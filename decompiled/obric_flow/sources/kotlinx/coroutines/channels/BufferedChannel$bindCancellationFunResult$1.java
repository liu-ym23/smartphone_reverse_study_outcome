package kotlinx.coroutines.channels;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
final /* synthetic */ class BufferedChannel$bindCancellationFunResult$1 extends FunctionReferenceImpl implements Function3<Throwable, n, CoroutineContext, Unit> {
    public BufferedChannel$bindCancellationFunResult$1(Object r10) {
        super(3, r10, f.class, "onCancellationChannelResultImplDoNotCall", "onCancellationChannelResultImplDoNotCall-5_sEAP8(Ljava/lang/Throwable;Ljava/lang/Object;Lkotlin/coroutines/CoroutineContext;)V", 0);
    }

    @Override // kotlin.jvm.functions.Function3
    public /* synthetic */ Unit invoke(Throwable r5, n r10, CoroutineContext r11) {
        m1630invoke5_sEAP8(r5, r10.f18815a, r11);
        return Unit.INSTANCE;
    }

    /* JADX INFO: renamed from: invoke-5_sEAP8, reason: not valid java name */
    public final void m1630invoke5_sEAP8(Throwable r5, Object r10, CoroutineContext r11) {
        Function1 r12 = ((f) this.receiver).f18795b;
        Intrinsics.checkNotNull(r12);
        if ((r10 instanceof m) == false) goto L6;
        r10 = null;
    L6:
        Intrinsics.checkNotNull(r10);
        kotlinx.coroutines.internal.f.a(r12, r10, r11);
    }
}
