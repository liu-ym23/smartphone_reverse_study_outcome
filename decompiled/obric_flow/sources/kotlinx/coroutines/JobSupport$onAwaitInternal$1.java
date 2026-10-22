package kotlinx.coroutines;

import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.FunctionReferenceImpl;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
final /* synthetic */ class JobSupport$onAwaitInternal$1 extends FunctionReferenceImpl implements Function3<r1, kotlinx.coroutines.selects.g, Object, Unit> {
    public static final JobSupport$onAwaitInternal$1 INSTANCE = null;

    static {
        INSTANCE = new JobSupport$onAwaitInternal$1();
    }

    public JobSupport$onAwaitInternal$1() {
        super(3, r1.class, "onAwaitInternalRegFunc", "onAwaitInternalRegFunc(Lkotlinx/coroutines/selects/SelectInstance;Ljava/lang/Object;)V", 0);
    }

    @Override // kotlin.jvm.functions.Function3
    public /* bridge */ /* synthetic */ Unit invoke(r1 r5, kotlinx.coroutines.selects.g r10, Object r11) {
        invoke2(r5, r10, r11);
        return Unit.INSTANCE;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(r1 r5, kotlinx.coroutines.selects.g r10, Object r11) {
        AtomicReferenceFieldUpdater r12 = r1.f18988a;
        r5.getClass();
    L3:
        Object r13 = r1.f18988a.get(r5);
        if ((r13 instanceof g1) == false) goto L6;
        if (r5.W(r13) < 0) goto L3;
        r10.d(j0.i(r5, new q1(r5, r10, 0)));
        return;
    L6:
        if ((r13 instanceof v) == true) goto L9;
        r13 = j0.k(r13);
    L9:
        r10.c(r13);
    }
}
