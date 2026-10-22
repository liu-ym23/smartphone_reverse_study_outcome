package kotlinx.coroutines.sync;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlinx.coroutines.selects.m;

/* JADX INFO: loaded from: classes6.dex */
@Metadata(k = 3, mv = {1, 9, 0}, xi = 48)
/* synthetic */ class MutexImpl$onLock$1 extends FunctionReferenceImpl implements Function3<b, m<?>, Object, Unit> {
    public static final MutexImpl$onLock$1 INSTANCE = null;

    static {
        INSTANCE = new MutexImpl$onLock$1();
    }

    MutexImpl$onLock$1() {
        super(3, b.class, "onLockRegFunction", "onLockRegFunction(Lkotlinx/coroutines/selects/SelectInstance;Ljava/lang/Object;)V", 0);
    }

    @Override // kotlin.jvm.functions.Function3
    public /* synthetic */ Unit invoke(b r3, m<?> r4, Object r5) {
        invoke2((b) ZeusTransformUtils.preCheckCast(r3, b.class, "com.obric.memorydata.plugin"), (m) ZeusTransformUtils.preCheckCast(r4, m.class, "com.obric.memorydata.plugin"), r5);
        return Unit.INSTANCE;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(b r2, m<?> r3, Object r4) {
        r2.a((m) ZeusTransformUtils.wrapperContextForParams(r3, m.class, "com.obric.memorydata.plugin"), r4);
    }
}
