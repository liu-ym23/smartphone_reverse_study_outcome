package kotlinx.coroutines;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.FunctionReferenceImpl;

/* JADX INFO: loaded from: classes6.dex */
@Metadata(k = 3, mv = {1, 9, 0}, xi = 48)
/* synthetic */ class JobSupport$onAwaitInternal$1 extends FunctionReferenceImpl implements Function3<ce, kotlinx.coroutines.selects.m<?>, Object, Unit> {
    public static final JobSupport$onAwaitInternal$1 INSTANCE = null;

    static {
        INSTANCE = new JobSupport$onAwaitInternal$1();
    }

    JobSupport$onAwaitInternal$1() {
        super(3, ce.class, "onAwaitInternalRegFunc", "onAwaitInternalRegFunc(Lkotlinx/coroutines/selects/SelectInstance;Ljava/lang/Object;)V", 0);
    }

    @Override // kotlin.jvm.functions.Function3
    public /* synthetic */ Unit invoke(ce r3, kotlinx.coroutines.selects.m<?> r4, Object r5) {
        invoke2((ce) ZeusTransformUtils.preCheckCast(r3, ce.class, "com.obric.memorydata.plugin"), (kotlinx.coroutines.selects.m) ZeusTransformUtils.preCheckCast(r4, kotlinx.coroutines.selects.m.class, "com.obric.memorydata.plugin"), r5);
        return Unit.INSTANCE;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(ce r2, kotlinx.coroutines.selects.m<?> r3, Object r4) {
        ce.b(r2, (kotlinx.coroutines.selects.m) ZeusTransformUtils.wrapperContextForParams(r3, kotlinx.coroutines.selects.m.class, "com.obric.memorydata.plugin"), r4);
    }
}
