package com.larus.camera.impl.ui.component.capture;

import android.view.SurfaceView;
import android.view.ViewGroup;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.constraintlayout.widget.ConstraintSet;
import com.larus.camera.impl.ui.viewmodel.CameraCaptureViewModel;
import com.larus.camera.impl.widget.SurfaceBaselineView;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
@Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n"}, d2 = {"<anonymous>", "", "it", ""}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.larus.camera.impl.ui.component.capture.CaptureSurfaceComponent$onViewCreated$3", f = "CaptureSurfaceComponent.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
public final class CaptureSurfaceComponent$onViewCreated$3 extends SuspendLambda implements Function2<String, Continuation<? super Unit>, Object> {
    final /* synthetic */ CameraCaptureViewModel $viewModel;
    /* synthetic */ Object L$0;
    int label;
    final /* synthetic */ CaptureSurfaceComponent this$0;

    public CaptureSurfaceComponent$onViewCreated$3(CameraCaptureViewModel r1, CaptureSurfaceComponent r2, Continuation<? super CaptureSurfaceComponent$onViewCreated$3> r3) {
        this.$viewModel = r1;
        this.this$0 = r2;
        super(2, r3);
    }

    public final Continuation<Unit> create(Object r4, Continuation<?> r5) {
        CaptureSurfaceComponent$onViewCreated$3 r0 = new CaptureSurfaceComponent$onViewCreated$3(this.$viewModel, this.this$0, r5);
        r0.L$0 = r4;
        return r0;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((String) r1, (Continuation) r2);
    }

    public final Object invoke(String r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r15) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) goto L32;
        ResultKt.throwOnFailure(r15);
        String r16 = (String) this.L$0;
        this.$viewModel.enterCapturePage(r16);
        CaptureSurfaceComponent r0 = this.this$0;
        CameraCaptureViewModel r1 = this.$viewModel;
        ConstraintLayout.LayoutParams r2 = r0.q;
        if (r2 == null) goto L7;
        r0.h(2131373055).setLayoutParams(new ConstraintLayout.LayoutParams(r2));
    L7:
        boolean r3 = fx8.a.b.contains(r16);
        boolean r4 = CollectionsKt.minus(fx8.a.e, CollectionsKt.toSet(fx8.a.d)).contains(r16);
        int r5 = 0;
        if (r3 == false) goto L11;
        com.larus.utils.e1.o(r0.h(2131389183));
        ConstraintLayout r10 = r0.h(2131365096);
        ConstraintSet r12 = new ConstraintSet();
        r12.clone(r10);
        r12.clear(2131365104);
        r12.connect(2131365104, 3, 2131373055, 3);
        r12.connect(2131365104, 4, 2131373055, 4);
        r12.connect(2131365104, 6, 2131373055, 6);
        r12.connect(2131365104, 7, 2131373055, 7);
        r12.setDimensionRatio(2131365104, "w,9:16");
        r12.clear(2131373055);
        r12.connect(2131373055, 3, 0, 3);
        r12.connect(2131373055, 4, 0, 4);
        r12.connect(2131373055, 6, 0, 6);
        r12.connect(2131373055, 7, 0, 7);
        r12.setDimensionRatio(2131373055, "w,9:16");
        r12.applyTo(r10);
        SurfaceView r6 = (SurfaceView) r0.h(2131365104);
        ViewGroup.LayoutParams r7 = r6.getLayoutParams();
        r7.height = -1;
        r6.setLayoutParams(r7);
    L25:
        r0.r(r1);
        r1.updatePageStyle(r3);
        ConstraintLayout r8 = (SurfaceBaselineView) r0.h(2131387767);
        if (r4 == true) goto L29;
        r5 = 8;
    L29:
        r8.setVisibility(r5);
        this.$viewModel.updateMultiPickConfig(r16);
        return Unit.INSTANCE;
    L11:
        if (zx8.b.h == false) goto L13;
    L16:
        boolean r13 = true;
    L17:
        if (r13 == false) goto L19;
        com.larus.utils.e1.o(r0.h(2131389183));
    L20:
        ((SurfaceView) r0.h(2131365104)).getLayoutParams().height = 0;
        ConstraintLayout r11 = r0.h(2131365096);
        ConstraintSet r14 = new ConstraintSet();
        r14.clone(r11);
        r14.clear(2131365104);
        r14.connect(2131365104, 4, 2131373055, 4);
        r14.connect(2131365104, 6, 2131373055, 6);
        r14.connect(2131365104, 7, 2131373055, 7);
        if (r13 == false) goto L23;
        r14.connect(2131365104, 3, 2131373055, 3);
        r14.setDimensionRatio(2131365104, "h,3:4");
    L24:
        r14.connect(2131373055, 3, 2131389181, 3);
        r14.connect(2131373055, 4, 2131364481, 4);
        r14.connect(2131373055, 6, 0, 6);
        r14.connect(2131373055, 7, 0, 7);
        r14.setDimensionRatio(2131373055, "3:4");
        r14.applyTo(r11);
        goto L25
    L23:
        r14.setDimensionRatio(2131365104, "h,9:16");
        goto L24
    L19:
        com.larus.utils.e1.x(r0.h(2131389183));
        goto L20
    L13:
        if (((oq9.f) zx8.b.b.getValue()).c == true) goto L16;
        r13 = false;
        goto L17
    L32:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
