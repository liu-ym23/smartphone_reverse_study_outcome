package kotlinx.coroutines.channels;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.FunctionReferenceImpl;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
final /* synthetic */ class BufferedChannel$onSend$1 extends FunctionReferenceImpl implements Function3<f, kotlinx.coroutines.selects.g, Object, Unit> {
    public static final BufferedChannel$onSend$1 INSTANCE = null;

    static {
        INSTANCE = new BufferedChannel$onSend$1();
    }

    public BufferedChannel$onSend$1() {
        super(3, f.class, "registerSelectForSend", "registerSelectForSend(Lkotlinx/coroutines/selects/SelectInstance;Ljava/lang/Object;)V", 0);
    }

    @Override // kotlin.jvm.functions.Function3
    public /* bridge */ /* synthetic */ Unit invoke(f r5, kotlinx.coroutines.selects.g r10, Object r11) {
        invoke2(r5, r10, r11);
        return Unit.INSTANCE;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(f r5, kotlinx.coroutines.selects.g r10, Object r11) {
        r5.I(r10, r11);
    }
}
