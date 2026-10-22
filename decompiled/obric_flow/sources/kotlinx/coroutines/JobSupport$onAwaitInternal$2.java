package kotlinx.coroutines;

import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import kotlin.Metadata;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.FunctionReferenceImpl;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
final /* synthetic */ class JobSupport$onAwaitInternal$2 extends FunctionReferenceImpl implements Function3<r1, Object, Object, Object> {
    public static final JobSupport$onAwaitInternal$2 INSTANCE = null;

    static {
        INSTANCE = new JobSupport$onAwaitInternal$2();
    }

    public JobSupport$onAwaitInternal$2() {
        super(3, r1.class, "onAwaitInternalProcessResFunc", "onAwaitInternalProcessResFunc(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;", 0);
    }

    @Override // kotlin.jvm.functions.Function3
    public /* bridge */ /* synthetic */ Object invoke(r1 r5, Object r10, Object r11) {
        return invoke2(r5, r10, r11);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final Object invoke2(r1 r5, Object r10, Object r11) {
        AtomicReferenceFieldUpdater r12 = r1.f18988a;
        r5.getClass();
        if ((r11 instanceof v) == true) goto L6;
        return r11;
    L6:
        throw ((v) r11).f19025a;
    }
}
