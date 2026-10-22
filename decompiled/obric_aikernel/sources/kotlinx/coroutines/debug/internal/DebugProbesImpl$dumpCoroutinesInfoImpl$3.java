package kotlinx.coroutines.debug.internal;

import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.SourceDebugExtension;

/* JADX INFO: loaded from: classes3.dex */
@SourceDebugExtension({"SMAP\nDebugProbesImpl.kt\nKotlin\n*S Kotlin\n*F\n+ 1 DebugProbesImpl.kt\nkotlinx/coroutines/debug/internal/DebugProbesImpl$dumpCoroutinesInfoImpl$3\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,620:1\n1#2:621\n*E\n"})
public final class DebugProbesImpl$dumpCoroutinesInfoImpl$3 extends Lambda implements Function1<c.a<?>, Object> {
    final /* synthetic */ Function2<c.a<?>, CoroutineContext, Object> $create;

    /* JADX WARN: Multi-variable type inference failed */
    public DebugProbesImpl$dumpCoroutinesInfoImpl$3(Function2<? super c.a<?>, ? super CoroutineContext, Object> r10) {
        this.$create = r10;
        super(1);
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Object invoke(c.a<?> r10) {
        return invoke2(r10);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final Object invoke2(c.a<?> r10) {
        if (c.b(c.f10368a, r10) == true) goto L10;
        CoroutineContext r11 = r10.f10373g.c();
        if (r11 != null) goto L8;
        return null;
    L8:
        return this.$create.invoke(r10, r11);
    L10:
        return null;
    }
}
