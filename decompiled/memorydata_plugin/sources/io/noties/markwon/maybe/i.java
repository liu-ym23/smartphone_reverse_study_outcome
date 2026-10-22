package io.noties.markwon.maybe;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import io.noties.markwon.n;
import kotlin.Metadata;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import org.commonmark.node.Node;

/* JADX INFO: loaded from: classes6.dex */
@Metadata(bv = {1, 0, 3}, k = 3, mv = {1, 1, 15})
final class i implements n.c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final /* synthetic */ Function2 f16654a;

    i(Function2 r3) {
        this.f16654a = (Function2) ZeusTransformUtils.wrapperContextForParams(r3, Function2.class, "com.obric.memorydata.plugin");
    }

    @Override // io.noties.markwon.n.c
    public final /* synthetic */ void a(n r3, Node r4) {
        n r5 = (n) ZeusTransformUtils.wrapperContextForParams(r3, n.class, "com.obric.memorydata.plugin");
        Intrinsics.checkParameterIsNotNull(r5, "p0");
        Intrinsics.checkExpressionValueIsNotNull(this.f16654a.invoke(r5, r4), "invoke(...)");
    }
}
