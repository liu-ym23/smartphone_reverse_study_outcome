package kotlinx.coroutines.selects;

import com.lynx.tasm.ui.image.v;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.DelayKt;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
final /* synthetic */ class OnTimeout$selectClause$1 extends FunctionReferenceImpl implements Function3<a, g, Object, Unit> {
    public static final OnTimeout$selectClause$1 INSTANCE = null;

    static {
        INSTANCE = new OnTimeout$selectClause$1();
    }

    public OnTimeout$selectClause$1() {
        super(3, a.class, "register", "register(Lkotlinx/coroutines/selects/SelectInstance;Ljava/lang/Object;)V", 0);
    }

    @Override // kotlin.jvm.functions.Function3
    public /* bridge */ /* synthetic */ Unit invoke(a r5, g r10, Object r11) {
        invoke2(r5, r10, r11);
        return Unit.INSTANCE;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(a r5, g r10, Object r11) {
        long r12 = r5.f18995a;
        if (r12 > 0) goto L5;
        r10.c(Unit.INSTANCE);
        return;
    L5:
        v r13 = new v(14, r10, false, r5);
        Intrinsics.checkNotNull(r10, "null cannot be cast to non-null type kotlinx.coroutines.selects.SelectImplementation<*>");
        f r14 = (f) r10;
        CoroutineContext r15 = r14.f19004a;
        r14.f19006c = DelayKt.getDelay(r15).e(r12, r13, r15);
    }
}
