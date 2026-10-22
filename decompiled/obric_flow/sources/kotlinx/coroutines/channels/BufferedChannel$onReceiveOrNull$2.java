package kotlinx.coroutines.channels;

import java.util.concurrent.atomic.AtomicLongFieldUpdater;
import kotlin.Metadata;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.FunctionReferenceImpl;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
final /* synthetic */ class BufferedChannel$onReceiveOrNull$2 extends FunctionReferenceImpl implements Function3<f, Object, Object, Object> {
    public static final BufferedChannel$onReceiveOrNull$2 INSTANCE = null;

    static {
        INSTANCE = new BufferedChannel$onReceiveOrNull$2();
    }

    public BufferedChannel$onReceiveOrNull$2() {
        super(3, f.class, "processResultSelectReceiveOrNull", "processResultSelectReceiveOrNull(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;", 0);
    }

    @Override // kotlin.jvm.functions.Function3
    public /* bridge */ /* synthetic */ Object invoke(f r5, Object r10, Object r11) {
        return invoke2(r5, r10, r11);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final Object invoke2(f r5, Object r10, Object r11) {
        AtomicLongFieldUpdater r12 = f.d;
        r5.getClass();
        if (r11 == g.f18804l) goto L5;
        return r11;
    L5:
        if (r5.u() != null) goto L8;
        return null;
    L8:
        throw r5.v();
    }
}
