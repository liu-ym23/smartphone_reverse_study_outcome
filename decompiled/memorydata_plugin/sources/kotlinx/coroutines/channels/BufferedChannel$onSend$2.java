package kotlinx.coroutines.channels;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import kotlin.Metadata;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.FunctionReferenceImpl;

/* JADX INFO: loaded from: classes6.dex */
@Metadata(k = 3, mv = {1, 9, 0}, xi = 48)
/* synthetic */ class BufferedChannel$onSend$2 extends FunctionReferenceImpl implements Function3<g<?>, Object, Object, Object> {
    public static final BufferedChannel$onSend$2 INSTANCE = null;

    static {
        INSTANCE = new BufferedChannel$onSend$2();
    }

    BufferedChannel$onSend$2() {
        super(3, g.class, "processResultSelectSend", "processResultSelectSend(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;", 0);
    }

    @Override // kotlin.jvm.functions.Function3
    public /* synthetic */ Object invoke(g<?> r3, Object r4, Object r5) {
        return invoke2((g) ZeusTransformUtils.preCheckCast(r3, g.class, "com.obric.memorydata.plugin"), r4, r5);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final Object invoke2(g<?> r1, Object r2, Object r3) {
        return g.a(r1, r2, r3);
    }
}
