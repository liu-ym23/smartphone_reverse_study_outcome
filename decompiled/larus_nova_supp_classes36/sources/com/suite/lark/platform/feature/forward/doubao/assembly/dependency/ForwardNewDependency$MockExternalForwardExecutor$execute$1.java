package com.suite.lark.platform.feature.forward.doubao.assembly.dependency;

import com.ss.android.lark.forwardv3.dependency.IExternalForwardExecutor;
import com.ss.android.lark.guide.ui.common.popup.AnchorFit;
import com.ss.android.lark.search.dto.info.SearchBaseInfo;
import java.util.List;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = AnchorFit.END)
@DebugMetadata(c = "com.suite.lark.platform.feature.forward.doubao.assembly.dependency.ForwardNewDependency$MockExternalForwardExecutor$execute$1", f = "ForwardNewDependency.kt", i = {}, l = {373}, m = "invokeSuspend", n = {}, s = {})
final class ForwardNewDependency$MockExternalForwardExecutor$execute$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ IExternalForwardExecutor.a $callback;
    final /* synthetic */ List<SearchBaseInfo> $items;
    final /* synthetic */ String $note;
    int label;
    final /* synthetic */ ForwardNewDependency.b this$0;

    public ForwardNewDependency$MockExternalForwardExecutor$execute$1(ForwardNewDependency.b r1, List<? extends SearchBaseInfo> r2, String r3, IExternalForwardExecutor.a r4, Continuation<? super ForwardNewDependency$MockExternalForwardExecutor$execute$1> r5) {
        this.$items = r2;
        this.$note = r3;
        this.$callback = r4;
        super(2, r5);
    }

    public final Continuation<Unit> create(Object r7, Continuation<?> r8) {
        return new ForwardNewDependency$MockExternalForwardExecutor$execute$1(null, this.$items, this.$note, this.$callback, r8);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r4) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r0 = this.label;
        if (r0 != 0) goto L5;
        ResultKt.throwOnFailure(r4);
        throw null;
    L5:
        if (r0 != 1) goto L7;
        ResultKt.throwOnFailure(r4);
        throw null;
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
