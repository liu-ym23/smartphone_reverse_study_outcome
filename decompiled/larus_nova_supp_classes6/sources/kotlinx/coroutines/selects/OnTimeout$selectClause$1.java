package kotlinx.coroutines.selects;

import com.obric.eventkit.eventstaskmanager.ITaskManager;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.DelayKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes6.dex */
@Metadata(k = 3, mv = {1, 9, 0}, xi = ITaskManager.Stub.TRANSACTION_getEventTasksByType)
final /* synthetic */ class OnTimeout$selectClause$1 extends FunctionReferenceImpl implements Function3<b, l<?>, Object, Unit> {
    public static final OnTimeout$selectClause$1 INSTANCE = null;

    static {
        INSTANCE = new OnTimeout$selectClause$1();
    }

    public OnTimeout$selectClause$1() {
        super(3, b.class, "register", "register(Lkotlinx/coroutines/selects/SelectInstance;Ljava/lang/Object;)V", 0);
    }

    public final void invoke(b r5, l<?> r6, Object r7) {
        if (r5.a > 0) goto L5;
        r6.c(Unit.INSTANCE);
        return;
    L5:
        a r8 = new a(r6, r5);
        Intrinsics.checkNotNull(r6, "null cannot be cast to non-null type kotlinx.coroutines.selects.SelectImplementation<*>");
        SelectImplementation r0 = (SelectImplementation) r6;
        CoroutineContext r1 = r6.getContext();
        r6.b(DelayKt.getDelay(r1).invokeOnTimeout(r5.a, r8, r1));
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2, Object r3) {
        invoke((b) r1, (l) r2, r3);
        return Unit.INSTANCE;
    }
}
