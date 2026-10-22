package com.larus.camera.impl.ui.component.result.general;

import com.larus.camera.api.params.OutputParam;
import com.larus.camera.impl.databinding.LarusLayoutViewPreviewComponentBinding;
import com.larus.camera.impl.ui.component.result.general.viewpager.PreviewContainerView;
import com.larus.camera.impl.ui.viewmodel.CameraResultViewModel;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
@Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n"}, d2 = {"<anonymous>", "", "it", ""}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.larus.camera.impl.ui.component.result.general.ResultPreviewComponent$onViewCreated$5", f = "ResultPreviewComponent.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
public final class ResultPreviewComponent$onViewCreated$5 extends SuspendLambda implements Function2<Integer, Continuation<? super Unit>, Object> {
    final /* synthetic */ CameraResultViewModel $viewModel;
    /* synthetic */ int I$0;
    int label;
    final /* synthetic */ ResultPreviewComponent this$0;

    public ResultPreviewComponent$onViewCreated$5(CameraResultViewModel r1, ResultPreviewComponent r2, Continuation<? super ResultPreviewComponent$onViewCreated$5> r3) {
        this.$viewModel = r1;
        this.this$0 = r2;
        super(2, r3);
    }

    public final Continuation<Unit> create(Object r4, Continuation<?> r5) {
        ResultPreviewComponent$onViewCreated$5 r0 = new ResultPreviewComponent$onViewCreated$5(this.$viewModel, this.this$0, r5);
        r0.I$0 = ((Number) r4).intValue();
        return r0;
    }

    public final Object invoke(int r1, Continuation<? super Unit> r2) {
        return create(Integer.valueOf(r1), r2).invokeSuspend(Unit.INSTANCE);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke(((Number) r1).intValue(), (Continuation) r2);
    }

    public final Object invokeSuspend(Object r10) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) goto L35;
        ResultKt.throwOnFailure(r10);
        int r11 = this.I$0;
        int r0 = -1;
        if (r11 == (-1)) goto L33;
        com.larus.camera.impl.ui.viewmodel.t r1 = com.larus.camera.impl.ui.viewmodel.t.a;
        List r2 = com.larus.camera.impl.ui.viewmodel.t.f();
        OutputParam r3 = this.$viewModel.getInitialCaptureOutputParam();
        Integer r4 = null;
        if (r3 == null) goto L9;
        String r5 = com.larus.camera.impl.ui.viewmodel.t.g(r3);
    L10:
        if (r5 == null) goto L23;
        Iterator r6 = r2.iterator();
        boolean r7 = false;
        int r8 = 0;
    L13:
        if (r6.hasNext() == false) goto L18;
        OutputParam r9 = (OutputParam) r6.next();
        com.larus.camera.impl.ui.viewmodel.t r12 = com.larus.camera.impl.ui.viewmodel.t.a;
        if (Intrinsics.areEqual(com.larus.camera.impl.ui.viewmodel.t.g(r9), r5) == true) goto L16;
        r8 = r8 + 1;
        goto L13
    L16:
        r0 = r8;
    L18:
        Integer r13 = Boxing.boxInt(r0);
        if (r13.intValue() < 0) goto L21;
        r7 = true;
    L21:
        if (r7 == false) goto L23;
        r4 = r13;
    L23:
        ResultPreviewComponent r14 = this.this$0;
        if (r4 == null) goto L26;
        int r15 = r4.intValue();
    L27:
        Integer r16 = Boxing.boxInt(r15);
        int r17 = ResultPreviewComponent.z;
        r14.r(r16);
        LarusLayoutViewPreviewComponentBinding r18 = this.this$0.m;
        if (r18 == null) goto L33;
        PreviewContainerView r19 = r18.d;
        if (r19 == null) goto L33;
        r19.k();
        goto L33
    L26:
        r15 = r2.size() - r11;
        goto L27
    L9:
        r5 = null;
    L33:
        return Unit.INSTANCE;
    L35:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
