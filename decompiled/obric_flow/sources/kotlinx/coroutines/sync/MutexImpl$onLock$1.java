package kotlinx.coroutines.sync;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
final /* synthetic */ class MutexImpl$onLock$1 extends FunctionReferenceImpl implements Function3<d, kotlinx.coroutines.selects.g, Object, Unit> {
    public static final MutexImpl$onLock$1 INSTANCE = null;

    static {
        INSTANCE = new MutexImpl$onLock$1();
    }

    public MutexImpl$onLock$1() {
        super(3, d.class, "onLockRegFunction", "onLockRegFunction(Lkotlinx/coroutines/selects/SelectInstance;Ljava/lang/Object;)V", 0);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(d r5, kotlinx.coroutines.selects.g r10, Object r11) {
        if (r11 == null) goto L10;
        r5.getClass();
    L5:
        if (Math.max(g.f.get(r5), 0) != 0) goto L11;
        Object r12 = d.g.get(r5);
        if (r12 == e.f19013a) goto L5;
        if (r12 != r11) goto L11;
        r10.c(e.f19014b);
        return;
    L11:
        Intrinsics.checkNotNull(r10, "null cannot be cast to non-null type kotlinx.coroutines.selects.SelectInstanceInternal<*>");
        c r13 = new c(r5, (kotlinx.coroutines.selects.h) r10, r11);
    L12:
        r5.getClass();
    L13:
        int r14 = g.f.getAndDecrement(r5);
        if (r14 > 1) goto L13;
        if (r14 > 0) goto L16;
        Intrinsics.checkNotNull(r13, "null cannot be cast to non-null type kotlinx.coroutines.Waiter");
        if (r5.a(r13) == false) goto L12;
        return;
    L16:
        r13.c(Unit.INSTANCE);
        return;
    L10:
        r5.getClass();
        goto L11
    }

    @Override // kotlin.jvm.functions.Function3
    public /* bridge */ /* synthetic */ Unit invoke(d r5, kotlinx.coroutines.selects.g r10, Object r11) {
        invoke2(r5, r10, r11);
        return Unit.INSTANCE;
    }
}
