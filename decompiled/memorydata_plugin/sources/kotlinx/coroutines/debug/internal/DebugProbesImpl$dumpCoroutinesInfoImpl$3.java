package kotlinx.coroutines.debug.internal;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import kotlin.Metadata;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: Add missing generic type declarations: [R] */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u0004\u0018\u0001H\u0001\"\b\b\u0000\u0010\u0001*\u00020\u00022\n\u0010\u0003\u001a\u0006\u0012\u0002\b\u00030\u0004H\n¢\u0006\u0004\b\u0005\u0010\u0006"}, d2 = {"<anonymous>", "R", "", "owner", "Lkotlinx/coroutines/debug/internal/DebugProbesImpl$CoroutineOwner;", "invoke", "(Lkotlinx/coroutines/debug/internal/DebugProbesImpl$CoroutineOwner;)Ljava/lang/Object;"}, k = 3, mv = {1, 9, 0}, xi = 48)
public final class DebugProbesImpl$dumpCoroutinesInfoImpl$3<R> extends Lambda implements Function1<e.a<?>, R> {
    final /* synthetic */ Function2<e.a<?>, CoroutineContext, R> $create;

    public DebugProbesImpl$dumpCoroutinesInfoImpl$3(Function2<? super e.a<?>, ? super CoroutineContext, ? extends R> r3) {
        this.$create = (Function2) ZeusTransformUtils.wrapperContextForParams(r3, Function2.class, "com.obric.memorydata.plugin");
        super(1);
    }

    @Override // kotlin.jvm.functions.Function1
    public /* synthetic */ Object invoke(e.a<?> r3) {
        return invoke2((e.a) ZeusTransformUtils.preCheckCast(r3, e.a.class, "com.obric.memorydata.plugin"));
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final R invoke2(e.a<?> r3) {
        if (e.a(e.f17327a, r3) == true) goto L10;
        CoroutineContext r0 = r3.f17330b.getContext();
        if (r0 != null) goto L8;
        return null;
    L8:
        return this.$create.invoke(r3, r0);
    L10:
        return null;
    }
}
