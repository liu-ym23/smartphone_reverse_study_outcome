package com.larus.camera.impl.ui.component.result.general.edu;

import android.app.Application;
import android.content.Context;
import android.graphics.Bitmap;
import com.larus.camera.api.params.OutputParam;
import com.larus.camera.impl.ui.viewmodel.CameraResultViewModel;
import com.larus.camera.impl.ui.viewmodel.o0;
import com.larus.camera.impl.widget.CaptureFocusFrame;
import com.larus.camera.impl.widget.EduCaptureTipView;
import com.larus.common.apphost.AppHost;
import com.larus.utils.logger.FLogger;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.flow.FlowKt__TransformKt$onEach$;
import nx8.m;
import t19.s;
import v19.i5;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.larus.camera.impl.ui.component.result.general.edu.ResultEduIntentPreviewComponent$onViewCreated$3", f = "ResultEduIntentPreviewComponent.kt", i = {}, l = {132}, m = "invokeSuspend", n = {}, s = {})
public final class ResultEduIntentPreviewComponent$onViewCreated$3 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ String $albumPath;
    final /* synthetic */ CameraResultViewModel $viewModel;
    int label;
    final /* synthetic */ ResultEduIntentPreviewComponent this$0;

    public ResultEduIntentPreviewComponent$onViewCreated$3(CameraResultViewModel r1, ResultEduIntentPreviewComponent r2, String r3, Continuation<? super ResultEduIntentPreviewComponent$onViewCreated$3> r4) {
        this.$viewModel = r1;
        this.this$0 = r2;
        this.$albumPath = r3;
        super(2, r4);
    }

    public final Continuation<Unit> create(Object r4, Continuation<?> r5) {
        return new ResultEduIntentPreviewComponent$onViewCreated$3(this.$viewModel, this.this$0, this.$albumPath, r5);
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
        boolean r2 = true;
        if (r1 == 0) goto L8;
        if (r1 != 1) goto L7;
        ResultKt.throwOnFailure(r12);
    L11:
        Bitmap r13 = ((o0) r12).a;
        if (r13 != null) goto L15;
        this.$viewModel.closePage();
        s r14 = s.a;
        Application r3 = AppHost.a.getApplication();
        r14.getClass();
        s.b(r3, 2131898469, false);
        return Unit.INSTANCE;
    L15:
        String r4 = this.$albumPath;
        if (r4.length() > 0) goto L20;
        r2 = false;
    L20:
        if (r2 == true) goto L23;
        r4 = null;
    L23:
        if (r4 != null) goto L28;
        OutputParam r5 = this.$viewModel.getCurrentDisplayOutputParam();
        if (r5 == null) goto L27;
        r4 = r5.getPath();
        goto L28
    L27:
        r4 = null;
    L28:
        if (r4 == null) goto L51;
        this.$viewModel.updateCurrentBitmap(r13, "ResultEduIntentPreviewComponent");
        if (this.$viewModel.enableFocusFrameInGeneralMode() == true) goto L32;
        int r6 = EduCaptureTipView.l;
        ResultEduIntentPreviewComponent r7 = this.this$0;
        int r8 = ResultEduIntentPreviewComponent.s;
        Pair r9 = EduCaptureTipView.a.a(r7.getContext(), 0);
    L40:
        int r10 = ((Number) r9.component1()).intValue();
        int r11 = ((Number) r9.component2()).intValue();
        m r15 = this.this$0.m;
        if (r15 == null) goto L43;
        r15.f(r10, r11);
    L43:
        m r16 = this.this$0.m;
        if (r16 == null) goto L46;
        r16.o(r13, r4, 0, false);
    L46:
        ResultEduIntentPreviewComponent r17 = this.this$0;
        CameraResultViewModel r18 = (CameraResultViewModel) ((com.larus.camera.impl.ui.arch.b.a) r17.e.getValue()).a();
        if (r18 == null) goto L51;
        FLogger.a.i("ResultEduIntentPreviewComponent", "[initQuestionClipView] started");
        r17.r();
        kotlinx.coroutines.flow.e.x(new FlowKt__TransformKt$onEach$.inlined.unsafeTransform.1(r18.getResultDetectionStatus(), new ResultEduIntentPreviewComponent$initQuestionClipView$1(r17, null)), r17.k());
        goto L51
    L32:
        if (CaptureFocusFrame.j != 0) goto L34;
    L37:
        int r19 = i5.y0(v19.c.b(2130971380, null, 2131167129));
        int r20 = i5.y0(v19.c.b(2130971380, null, 2131167129));
        int r21 = r19;
    L38:
        r9 = TuplesKt.to(Integer.valueOf(r21), Integer.valueOf(r20));
        goto L40
    L34:
        if (CaptureFocusFrame.k == 0) goto L37;
        r21 = CaptureFocusFrame.j;
        r20 = CaptureFocusFrame.k;
    L51:
        return Unit.INSTANCE;
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        ResultKt.throwOnFailure(r12);
        CameraResultViewModel r22 = this.$viewModel;
        ResultEduIntentPreviewComponent r110 = this.this$0;
        int r23 = ResultEduIntentPreviewComponent.s;
        Context r24 = r110.getContext();
        String r25 = this.$albumPath;
        this.label = 1;
        r12 = CameraResultViewModel.getPreviewBitmap$default(r22, r24, r25, 0, null, this, 12, null);
        if (r12 != r0) goto L11;
        return r0;
    }
}
