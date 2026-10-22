package com.larus.camera.impl.ui.component.result.edu;

import android.content.Context;
import android.graphics.Bitmap;
import com.larus.camera.api.params.OutputParam;
import com.larus.camera.impl.ui.viewmodel.CameraResultViewModel;
import com.larus.camera.impl.ui.viewmodel.o0;
import com.larus.camera.impl.utils.c0;
import com.larus.camera.impl.widget.EduCaptureTipView;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import nx8.m;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.larus.camera.impl.ui.component.result.edu.EduHomeworkResultPreviewComponent$onViewCreated$2", f = "EduHomeworkResultPreviewComponent.kt", i = {}, l = {39}, m = "invokeSuspend", n = {}, s = {})
public final class EduHomeworkResultPreviewComponent$onViewCreated$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ String $albumPath;
    final /* synthetic */ int $orientation;
    final /* synthetic */ CameraResultViewModel $viewModel;
    int label;
    final /* synthetic */ EduHomeworkResultPreviewComponent this$0;

    public EduHomeworkResultPreviewComponent$onViewCreated$2(CameraResultViewModel r1, EduHomeworkResultPreviewComponent r2, String r3, int r4, Continuation<? super EduHomeworkResultPreviewComponent$onViewCreated$2> r5) {
        this.$viewModel = r1;
        this.this$0 = r2;
        this.$albumPath = r3;
        this.$orientation = r4;
        super(2, r5);
    }

    public final Continuation<Unit> create(Object r7, Continuation<?> r8) {
        return new EduHomeworkResultPreviewComponent$onViewCreated$2(this.$viewModel, this.this$0, this.$albumPath, this.$orientation, r8);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r12) {
        Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r1 = this.label;
        if (r1 == 0) goto L8;
        if (r1 != 1) goto L7;
        ResultKt.throwOnFailure(r12);
    L11:
        Bitmap r13 = ((o0) r12).a;
        if (r13 == null) goto L14;
        String r2 = this.$albumPath;
        if (r2.length() <= 0) goto L18;
        boolean r3 = true;
    L19:
        String r4 = null;
        if (r3 == true) goto L23;
        r2 = null;
    L23:
        if (r2 != null) goto L27;
        OutputParam r5 = this.$viewModel.getCurrentDisplayOutputParam();
        if (r5 == null) goto L28;
        r2 = r5.getPath();
    L28:
        if (r4 == null) goto L36;
        this.$viewModel.updateCurrentBitmap(r13, "EduHomeworkResultPreviewComponent");
        int r6 = c0.d;
        int r7 = (int) c0.a.a(this.$orientation, true);
        int r8 = EduCaptureTipView.l;
        EduHomeworkResultPreviewComponent r9 = this.this$0;
        int r10 = EduHomeworkResultPreviewComponent.B;
        Pair r11 = EduCaptureTipView.a.a(r9.getContext(), r7);
        int r14 = ((Number) r11.component1()).intValue();
        int r15 = ((Number) r11.component2()).intValue();
        m r16 = this.this$0.A;
        if (r16 == null) goto L32;
        r16.f(r14, r15);
    L32:
        m r17 = this.this$0.A;
        if (r17 == null) goto L36;
        r17.o(r13, r4, r7, true);
    L36:
        return Unit.INSTANCE;
    L27:
        r4 = r2;
        goto L28
    L18:
        r3 = false;
        goto L19
    L14:
        return Unit.INSTANCE;
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        ResultKt.throwOnFailure(r12);
        CameraResultViewModel r18 = this.$viewModel;
        EduHomeworkResultPreviewComponent r19 = this.this$0;
        int r20 = EduHomeworkResultPreviewComponent.B;
        Context r21 = r19.getContext();
        String r22 = this.$albumPath;
        this.label = 1;
        r12 = CameraResultViewModel.getPreviewBitmap$default(r18, r21, r22, 0, null, this, 12, null);
        if (r12 != r0) goto L11;
        return r0;
    }
}
