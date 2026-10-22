package kotlinx.coroutines.debug.internal;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\n\u0010\u0002\u001a\u0006\u0012\u0002\b\u00030\u0003H\n¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"<anonymous>", "", "it", "Lkotlinx/coroutines/debug/internal/DebugProbesImpl$CoroutineOwner;", "invoke", "(Lkotlinx/coroutines/debug/internal/DebugProbesImpl$CoroutineOwner;)Ljava/lang/Boolean;"}, k = 3, mv = {1, 9, 0}, xi = 48)
final class DebugProbesImpl$dumpCoroutinesSynchronized$2 extends Lambda implements Function1<e.a<?>, Boolean> {
    public static final DebugProbesImpl$dumpCoroutinesSynchronized$2 INSTANCE = null;

    static {
        INSTANCE = new DebugProbesImpl$dumpCoroutinesSynchronized$2();
    }

    DebugProbesImpl$dumpCoroutinesSynchronized$2() {
        super(1);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final Boolean invoke2(e.a<?> r1) {
        return Boolean.valueOf(!e.a(e.f17327a, r1));
    }

    @Override // kotlin.jvm.functions.Function1
    public /* synthetic */ Boolean invoke(e.a<?> r3) {
        return invoke2((e.a) ZeusTransformUtils.preCheckCast(r3, e.a.class, "com.obric.memorydata.plugin"));
    }
}
