package com.larus.camera.impl.ui.component.result.general;

import com.larus.camera.api.params.OutputParam;
import com.larus.camera.impl.databinding.LarusLayoutViewPreviewComponentBinding;
import com.larus.camera.impl.ui.component.result.general.viewpager.PreviewContainerView;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
@Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n"}, d2 = {"<anonymous>", "", "newCount", ""}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.larus.camera.impl.ui.component.result.general.ResultPreviewComponent$onViewCreated$6", f = "ResultPreviewComponent.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
public final class ResultPreviewComponent$onViewCreated$6 extends SuspendLambda implements Function2<Integer, Continuation<? super Unit>, Object> {
    /* synthetic */ int I$0;
    int label;
    final /* synthetic */ ResultPreviewComponent this$0;

    public ResultPreviewComponent$onViewCreated$6(ResultPreviewComponent r1, Continuation<? super ResultPreviewComponent$onViewCreated$6> r2) {
        this.this$0 = r1;
        super(2, r2);
    }

    public final Continuation<Unit> create(Object r3, Continuation<?> r4) {
        ResultPreviewComponent$onViewCreated$6 r0 = new ResultPreviewComponent$onViewCreated$6(this.this$0, r4);
        r0.I$0 = ((Number) r3).intValue();
        return r0;
    }

    public final Object invoke(int r1, Continuation<? super Unit> r2) {
        return create(Integer.valueOf(r1), r2).invokeSuspend(Unit.INSTANCE);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke(((Number) r1).intValue(), (Continuation) r2);
    }

    public final Object invokeSuspend(Object r4) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) goto L15;
        ResultKt.throwOnFailure(r4);
        int r5 = this.I$0;
        com.larus.camera.impl.ui.viewmodel.t r0 = com.larus.camera.impl.ui.viewmodel.t.a;
        int r1 = com.larus.camera.impl.ui.viewmodel.t.e() - r5;
        ResultPreviewComponent r6 = this.this$0;
        r6.r(Boxing.boxInt(r6.o));
        LarusLayoutViewPreviewComponentBinding r7 = this.this$0.m;
        if (r7 == null) goto L9;
        PreviewContainerView r8 = r7.d;
        if (r8 == null) goto L9;
        r8.k();
    L9:
        OutputParam r9 = (OutputParam) CollectionsKt.getOrNull(com.larus.camera.impl.ui.viewmodel.t.f(), r1);
        if (r9 == null) goto L13;
        this.this$0.p(r9, r1, null, null);
    L13:
        return Unit.INSTANCE;
    L15:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
