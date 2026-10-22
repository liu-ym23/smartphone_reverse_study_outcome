package kotlinx.coroutines.channels;

import ai.j0;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.FunctionReferenceImpl;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
final /* synthetic */ class LazyActorCoroutine$onSend$1 extends FunctionReferenceImpl implements Function3<r, kotlinx.coroutines.selects.g, Object, Unit> {
    public static final LazyActorCoroutine$onSend$1 INSTANCE = null;

    static {
        INSTANCE = new LazyActorCoroutine$onSend$1();
    }

    public LazyActorCoroutine$onSend$1() {
        super(3, r.class, "onSendRegFunction", "onSendRegFunction(Lkotlinx/coroutines/selects/SelectInstance;Ljava/lang/Object;)V", 0);
    }

    @Override // kotlin.jvm.functions.Function3
    public /* bridge */ /* synthetic */ Unit invoke(r r5, kotlinx.coroutines.selects.g r10, Object r11) {
        j0.A(r5);
        invoke2(null, r10, r11);
        return Unit.INSTANCE;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(r r5, kotlinx.coroutines.selects.g r10, Object r11) {
        int r12 = r.e;
        throw null;
    }
}
