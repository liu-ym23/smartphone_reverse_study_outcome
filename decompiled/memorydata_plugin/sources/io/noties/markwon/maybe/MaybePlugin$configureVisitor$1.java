package io.noties.markwon.maybe;

import com.bytedance.crash.tracker.ActivityLifecycle;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import io.noties.markwon.n;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.FunctionReference;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KDeclarationContainer;

/* JADX INFO: loaded from: classes6.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001c\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u0015\u0010\u0002\u001a\u00110\u0003¢\u0006\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u00062\u0019\u0010\u0007\u001a\u0015\u0012\u0002\b\u00030\b¢\u0006\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\t¢\u0006\u0002\b\n"}, d2 = {"<anonymous>", "", "p1", "Lio/noties/markwon/MarkwonVisitor;", "Lkotlin/ParameterName;", ActivityLifecycle.NAME, "visitor", "p2", "Lio/noties/markwon/maybe/MaybeNode;", "node", "invoke"}, k = 3, mv = {1, 1, 15})
final /* synthetic */ class MaybePlugin$configureVisitor$1 extends FunctionReference implements Function2<n, g<?>, Unit> {
    MaybePlugin$configureVisitor$1(h r2) {
        super(2, r2);
    }

    @Override // kotlin.jvm.internal.CallableReference, kotlin.reflect.KCallable
    public final String getName() {
        return "visitMaybe";
    }

    @Override // kotlin.jvm.internal.CallableReference
    public final KDeclarationContainer getOwner() {
        return Reflection.getOrCreateKotlinClass(h.class);
    }

    @Override // kotlin.jvm.internal.CallableReference
    public final String getSignature() {
        return "visitMaybe(Lio/noties/markwon/MarkwonVisitor;Lio/noties/markwon/maybe/MaybeNode;)V";
    }

    @Override // kotlin.jvm.functions.Function2
    public /* synthetic */ Unit invoke(n r3, g<?> r4) {
        invoke2((n) ZeusTransformUtils.preCheckCast(r3, n.class, "com.obric.memorydata.plugin"), (g) ZeusTransformUtils.preCheckCast(r4, g.class, "com.obric.memorydata.plugin"));
        return Unit.INSTANCE;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(n r3, g<?> r4) {
        n r5 = (n) ZeusTransformUtils.wrapperContextForParams(r3, n.class, "com.obric.memorydata.plugin");
        Intrinsics.checkParameterIsNotNull(r5, "p1");
        Intrinsics.checkParameterIsNotNull(r4, "p2");
        ((h) ZeusTransformUtils.preCheckCast(this.receiver, h.class, "com.obric.memorydata.plugin")).a(r5, r4);
    }
}
