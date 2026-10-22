package kotlinx.coroutines.selects;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.FunctionReferenceImpl;

/* JADX INFO: loaded from: classes6.dex */
@Metadata(k = 3, mv = {1, 9, 0}, xi = 48)
/* synthetic */ class OnTimeout$selectClause$1 extends FunctionReferenceImpl implements Function3<a, m<?>, Object, Unit> {
    public static final OnTimeout$selectClause$1 INSTANCE = null;

    static {
        INSTANCE = new OnTimeout$selectClause$1();
    }

    OnTimeout$selectClause$1() {
        super(3, a.class, "register", "register(Lkotlinx/coroutines/selects/SelectInstance;Ljava/lang/Object;)V", 0);
    }

    @Override // kotlin.jvm.functions.Function3
    public /* synthetic */ Unit invoke(a r3, m<?> r4, Object r5) {
        invoke2((a) ZeusTransformUtils.preCheckCast(r3, a.class, "com.obric.memorydata.plugin"), (m) ZeusTransformUtils.preCheckCast(r4, m.class, "com.obric.memorydata.plugin"), r5);
        return Unit.INSTANCE;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(a r2, m<?> r3, Object r4) {
        a.a(r2, (m) ZeusTransformUtils.wrapperContextForParams(r3, m.class, "com.obric.memorydata.plugin"), r4);
    }
}
