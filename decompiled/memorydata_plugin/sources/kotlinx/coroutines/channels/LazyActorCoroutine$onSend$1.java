package kotlinx.coroutines.channels;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.FunctionReferenceImpl;

/* JADX INFO: loaded from: classes6.dex */
@Metadata(k = 3, mv = {1, 9, 0}, xi = 48)
/* synthetic */ class LazyActorCoroutine$onSend$1 extends FunctionReferenceImpl implements Function3<t<?>, kotlinx.coroutines.selects.m<?>, Object, Unit> {
    public static final LazyActorCoroutine$onSend$1 INSTANCE = null;

    static {
        INSTANCE = new LazyActorCoroutine$onSend$1();
    }

    LazyActorCoroutine$onSend$1() {
        super(3, t.class, "onSendRegFunction", "onSendRegFunction(Lkotlinx/coroutines/selects/SelectInstance;Ljava/lang/Object;)V", 0);
    }

    @Override // kotlin.jvm.functions.Function3
    public /* synthetic */ Unit invoke(t<?> r3, kotlinx.coroutines.selects.m<?> r4, Object r5) {
        invoke2((t) ZeusTransformUtils.preCheckCast(r3, t.class, "com.obric.memorydata.plugin"), (kotlinx.coroutines.selects.m) ZeusTransformUtils.preCheckCast(r4, kotlinx.coroutines.selects.m.class, "com.obric.memorydata.plugin"), r5);
        return Unit.INSTANCE;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(t<?> r2, kotlinx.coroutines.selects.m<?> r3, Object r4) {
        t.a(r2, (kotlinx.coroutines.selects.m) ZeusTransformUtils.wrapperContextForParams(r3, kotlinx.coroutines.selects.m.class, "com.obric.memorydata.plugin"), r4);
    }
}
