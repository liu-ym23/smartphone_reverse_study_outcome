package com.larus.camera.impl.ui.component.result.general;

import android.widget.ImageView;
import com.larus.camera.api.params.InputParam;
import com.larus.camera.impl.ui.viewmodel.CameraResultViewModel;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
@Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n"}, d2 = {"<anonymous>", "", "it", "Lcom/larus/camera/impl/ui/component/result/general/ResultTitleEditState;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.larus.camera.impl.ui.component.result.general.ResultTitleComponent$configRedoAndUndoButton$2", f = "ResultTitleComponent.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
final class ResultTitleComponent$configRedoAndUndoButton$2 extends SuspendLambda implements Function2<d2, Continuation<? super Unit>, Object> {
    final /* synthetic */ CameraResultViewModel $viewModel;
    /* synthetic */ Object L$0;
    int label;
    final /* synthetic */ ResultTitleComponent this$0;

    public ResultTitleComponent$configRedoAndUndoButton$2(ResultTitleComponent r1, CameraResultViewModel r2, Continuation<? super ResultTitleComponent$configRedoAndUndoButton$2> r3) {
        this.this$0 = r1;
        this.$viewModel = r2;
        super(2, r3);
    }

    public final Continuation<Unit> create(Object r4, Continuation<?> r5) {
        ResultTitleComponent$configRedoAndUndoButton$2 r0 = new ResultTitleComponent$configRedoAndUndoButton$2(this.this$0, this.$viewModel, r5);
        r0.L$0 = r4;
        return r0;
    }

    public final Object invoke(d2 r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((d2) r1, (Continuation) r2);
    }

    /* JADX WARN: Type inference failed for: r5v1, types: [com.larus.camera.impl.ui.component.result.general.s1, java.lang.Object] */
    public final Object invokeSuspend(Object r9) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) goto L29;
        ResultKt.throwOnFailure(r9);
        d2 r10 = (d2) this.L$0;
        final boolean r0 = r10.a;
        final boolean r1 = r10.b;
        final boolean r2 = r10.c;
        final boolean r11 = r10.d;
        ResultTitleComponent r3 = this.this$0;
        Function1<? super ImageView, Unit> r4 = new f1(r2, r11);
        int r5 = ResultTitleComponent.s;
        r3.p(r4);
        if (r2 == true) goto L7;
    L18:
        ResultTitleComponent r6 = this.this$0;
        r6.p = r2;
        final CameraResultViewModel r7 = this.$viewModel;
        ?? r8 = new s1(r11, r7, r2);
        Intrinsics.checkNotNullParameter(r8, "config");
        r8.invoke(r6.h(2131377814));
        if (r11 == false) goto L21;
        ResultTitleComponent.s(this.this$0, new t1());
        ResultTitleComponent.u(this.this$0, new u1());
        ResultTitleComponent.t(this.this$0, new v1());
        ResultTitleComponent.v(this.this$0, new w1());
    L27:
        return Unit.INSTANCE;
    L21:
        if (r2 == true) goto L25;
        if (r0 == true) goto L25;
        if (r1 == true) goto L25;
        ResultTitleComponent r12 = this.this$0;
        final CameraResultViewModel r13 = this.$viewModel;
        ResultTitleComponent.s(r12, new g1(r13));
        ResultTitleComponent.u(this.this$0, new h1());
        ResultTitleComponent.t(this.this$0, new i1());
        ResultTitleComponent.v(this.this$0, new j1());
    L25:
        ResultTitleComponent.s(this.this$0, new o1());
        ResultTitleComponent.u(this.this$0, new p1());
        ResultTitleComponent r14 = this.this$0;
        final CameraResultViewModel r15 = this.$viewModel;
        ResultTitleComponent.t(r14, new q1(r0, r15));
        ResultTitleComponent r16 = this.this$0;
        final CameraResultViewModel r17 = this.$viewModel;
        ResultTitleComponent.v(r16, new r1(r1, r17));
        goto L27
    L7:
        if (this.this$0.p == true) goto L18;
        CameraResultViewModel r18 = this.$viewModel;
        InputParam r19 = r18.getInputParam();
        if (r19 == null) goto L13;
        boolean r20 = true;
        if (r19.isFromChatAttachment() != true) goto L13;
    L14:
        if (r20 == false) goto L16;
        String r21 = "chat";
    L17:
        r18.onSingleFunctionEditButtonShow("lasso_cancel", "camera_confirm", r21, "edit_entrance");
        goto L18
    L16:
        r21 = "camera";
    L13:
        r20 = false;
        goto L14
    L29:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
