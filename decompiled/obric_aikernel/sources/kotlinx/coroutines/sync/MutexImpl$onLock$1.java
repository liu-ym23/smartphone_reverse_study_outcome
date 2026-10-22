package kotlinx.coroutines.sync;

import kotlin.Unit;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlinx.coroutines.selects.k;

/* JADX INFO: loaded from: classes3.dex */
final /* synthetic */ class MutexImpl$onLock$1 extends FunctionReferenceImpl implements Function3<MutexImpl, k<?>, Object, Unit> {
    public static final MutexImpl$onLock$1 INSTANCE = null;

    static {
        INSTANCE = new MutexImpl$onLock$1();
    }

    MutexImpl$onLock$1() {
        super(3, MutexImpl.class, "onLockRegFunction", "onLockRegFunction(Lkotlinx/coroutines/selects/SelectInstance;Ljava/lang/Object;)V", 0);
    }

    @Override // kotlin.jvm.functions.Function3
    public /* bridge */ /* synthetic */ Unit invoke(MutexImpl r10, k<?> r11, Object r12) {
        invoke2(r10, r11, r12);
        return Unit.INSTANCE;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(MutexImpl r10, k<?> r11, Object r12) {
        r10.w(r11, r12);
    }
}
