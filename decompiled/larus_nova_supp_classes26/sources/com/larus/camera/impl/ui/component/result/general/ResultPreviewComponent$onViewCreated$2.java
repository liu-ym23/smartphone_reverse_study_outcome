package com.larus.camera.impl.ui.component.result.general;

import android.app.Application;
import android.content.Context;
import android.graphics.Bitmap;
import android.view.View;
import com.larus.camera.api.params.OutputParam;
import com.larus.camera.impl.databinding.LarusLayoutViewPreviewComponentBinding;
import com.larus.camera.impl.monitor.CameraEvent;
import com.larus.camera.impl.ui.component.result.general.viewpager.PreviewContainerView;
import com.larus.camera.impl.ui.viewmodel.CameraResultViewModel;
import com.larus.common.apphost.AppHost;
import com.larus.utils.logger.FLogger;
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
import kotlinx.coroutines.CoroutineScope;
import org.json.JSONObject;
import v19.m5;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.larus.camera.impl.ui.component.result.general.ResultPreviewComponent$onViewCreated$2", f = "ResultPreviewComponent.kt", i = {}, l = {126, 128, 136}, m = "invokeSuspend", n = {}, s = {})
public final class ResultPreviewComponent$onViewCreated$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ String $albumPath;
    final /* synthetic */ CameraResultViewModel $viewModel;
    int label;
    final /* synthetic */ ResultPreviewComponent this$0;

    /* JADX INFO: renamed from: com.larus.camera.impl.ui.component.result.general.ResultPreviewComponent$onViewCreated$2$1, reason: invalid class name */
    @Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n"}, d2 = {"<anonymous>", "", "it", ""}, k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "com.larus.camera.impl.ui.component.result.general.ResultPreviewComponent$onViewCreated$2$1", f = "ResultPreviewComponent.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    public static final class AnonymousClass1 extends SuspendLambda implements Function2<Integer, Continuation<? super Boolean>, Object> {
        /* synthetic */ int I$0;
        int label;

        public AnonymousClass1(Continuation<? super AnonymousClass1> r2) {
            super(2, r2);
        }

        public final Continuation<Unit> create(Object r2, Continuation<?> r3) {
            AnonymousClass1 r0 = new AnonymousClass1(r3);
            r0.I$0 = ((Number) r2).intValue();
            return r0;
        }

        public final Object invoke(int r1, Continuation<? super Boolean> r2) {
            return create(Integer.valueOf(r1), r2).invokeSuspend(Unit.INSTANCE);
        }

        public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
            return invoke(((Number) r1).intValue(), (Continuation) r2);
        }

        public final Object invokeSuspend(Object r2) {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label != 0) goto L11;
            ResultKt.throwOnFailure(r2);
            if (this.I$0 == (-1)) goto L7;
            boolean r3 = true;
        L9:
            return Boxing.boxBoolean(r3);
        L7:
            r3 = false;
            goto L9
        L11:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    public ResultPreviewComponent$onViewCreated$2(CameraResultViewModel r1, String r2, ResultPreviewComponent r3, Continuation<? super ResultPreviewComponent$onViewCreated$2> r4) {
        this.$viewModel = r1;
        this.$albumPath = r2;
        this.this$0 = r3;
        super(2, r4);
    }

    public final Continuation<Unit> create(Object r4, Continuation<?> r5) {
        return new ResultPreviewComponent$onViewCreated$2(this.$viewModel, this.$albumPath, this.this$0, r5);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r16) {
        Object r9 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r0 = this.label;
        OutputParam.ResultType r11 = null;
        boolean r13 = true;
        if (r0 == 0) goto L12;
        if (r0 == 1) goto L11;
        if (r0 == 2) goto L10;
        if (r0 != 3) goto L9;
        ResultKt.throwOnFailure(r16);
        Object r1 = r16;
    L31:
        com.larus.camera.impl.ui.viewmodel.o0 r2 = (com.larus.camera.impl.ui.viewmodel.o0) r1;
    L32:
        Bitmap r3 = r2.a;
        OutputParam r4 = r2.b;
        ResultPreviewComponent r5 = this.this$0;
        int r6 = ResultPreviewComponent.z;
        r5.getClass();
        if (r4 == null) goto L35;
        String r7 = r4.getPath();
    L36:
        if (r7 != null) goto L38;
    L41:
        boolean r8 = true;
    L42:
        if (r8 == false) goto L44;
        FLogger.a.i("ResultPreviewComponent", "[checkResultValid] path is invalid, return");
    L67:
        r13 = false;
    L68:
        if (r13 == true) goto L78;
        t19.s r10 = t19.s.a;
        Application r12 = AppHost.a.getApplication();
        r10.getClass();
        t19.s.b(r12, 2131898469, false);
        this.$viewModel.closePage();
        FLogger r14 = FLogger.a;
        StringBuilder r15 = new StringBuilder("previewBitmapState is empty previewBitmap=");
        r15.append(r3);
        r15.append(" previewPath=");
        if (r4 == null) goto L72;
        String r17 = r4.getPath();
    L73:
        r15.append(r17);
        r15.append(" type=");
        if (r4 == null) goto L76;
        r11 = r4.getResultType();
    L76:
        r15.append(r11);
        r14.e("ResultPreviewComponent", r15.toString());
        return Unit.INSTANCE;
    L72:
        r17 = null;
        goto L73
    L78:
        if (r3 == null) goto L80;
        CameraResultViewModel r18 = this.$viewModel;
        r18.detectPreviewImage(r3, r4);
        r18.addPreviewBitmap(r4, r3);
        r18.changeCurrentBitmap(r4, r3, "ResultPreviewComponent");
    L80:
        LarusLayoutViewPreviewComponentBinding r19 = this.this$0.m;
        if (r19 == null) goto L86;
        PreviewContainerView r20 = r19.d;
        if (r20 == null) goto L86;
        r20.h(r2, this.$viewModel.resultSupportMark());
    L86:
        if (this.$viewModel.isMultiResultFromCamera() == true) goto L88;
        this.this$0.r(null);
    L88:
        final ResultPreviewComponent r21 = this.this$0;
        final CameraResultViewModel r22 = this.$viewModel;
        r21.getClass();
        if (zx8.b.b() == false) goto L97;
        LarusLayoutViewPreviewComponentBinding r23 = r21.m;
        if (r23 == null) goto L97;
        View r24 = r23.f;
        if (r24 == null) goto L97;
        r24.setOnTouchListener(new s(r22, r21));
    L97:
        if (this.$viewModel.isFromAlbum() == true) goto L100;
        qx8.a.b.a.a(CameraEvent.CAPTURE_DURATION, new JSONObject());
    L100:
        return Unit.INSTANCE;
    L44:
        if (r3 != null) goto L52;
        if (r4 != null) goto L47;
    L49:
        boolean r25 = false;
    L50:
        if (r25 == false) goto L52;
        FLogger.a.i("ResultPreviewComponent", "[checkResultValid] bitmap is invalid, return");
        goto L67
    L47:
        if (r4.isVideo() == true) goto L49;
        r25 = true;
    L52:
        if (r4 != null) goto L54;
    L56:
        boolean r26 = false;
    L57:
        if (r26 == false) goto L68;
        if (r4 == null) goto L64;
        String r27 = r4.getPath();
        if (r27 == null) goto L64;
        if (m5.c(r27) != true) goto L64;
        boolean r28 = true;
    L65:
        if (r28 == true) goto L68;
        FLogger.a.i("ResultPreviewComponent", "[checkResultValid] video file is invalid, return");
        qx8.a.b.g(-16001, "file_invalid");
    L64:
        r28 = false;
        goto L65
    L54:
        if (r4.isVideo() != true) goto L56;
        r26 = true;
        goto L57
    L38:
        if (r7.length() == 0) goto L41;
        r8 = false;
        goto L42
    L35:
        r7 = null;
        goto L36
    L9:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L10:
        ResultKt.throwOnFailure(r16);
        Object r29 = r16;
    L25:
        OutputParam r30 = (OutputParam) r29;
        com.larus.camera.impl.ui.viewmodel.t r31 = com.larus.camera.impl.ui.viewmodel.t.a;
        Bitmap r32 = com.larus.camera.impl.ui.viewmodel.t.c(r30);
        FLogger.a.i("ResultPreviewComponent", "[onViewCreated] bitmap:" + r32 + " outputParam:" + r30);
        if (r32 == null) goto L28;
        r2 = new com.larus.camera.impl.ui.viewmodel.o0(r32, r30);
        goto L32
    L28:
        this.$viewModel.addPreviewBitmapHolder(r30);
        CameraResultViewModel r33 = this.$viewModel;
        ResultPreviewComponent r34 = this.this$0;
        int r35 = ResultPreviewComponent.z;
        Context r36 = r34.getContext();
        String r37 = this.$albumPath;
        this.label = 3;
        r1 = CameraResultViewModel.getPreviewBitmap$default(r33, r36, r37, 0, null, this, 12, null);
        if (r1 != r9) goto L31;
        return r9;
    L11:
        ResultKt.throwOnFailure(r16);
    L22:
        CameraResultViewModel r38 = this.$viewModel;
        String r39 = this.$albumPath;
        this.label = 2;
        r29 = CameraResultViewModel.getPreviewOutputParam$default(r38, r39, null, this, 2, null);
        if (r29 != r9) goto L25;
        return r9;
    L12:
        ResultKt.throwOnFailure(r16);
        if (this.$viewModel.getInitialCaptureOutputParam() == null) goto L22;
        List<OutputParam> r40 = this.$viewModel.getOriginMultiOutputParamList();
        if (r40 == null) goto L17;
        int r41 = r40.size();
    L18:
        if (r41 <= 1) goto L22;
        kotlinx.coroutines.flow.i1<Integer> r42 = this.$viewModel.isMultiResultLoadComplete();
        AnonymousClass1 r43 = new AnonymousClass1(null);
        this.label = 1;
        if (kotlinx.coroutines.flow.e.t(r42, r43, this) != r9) goto L22;
        return r9;
    L17:
        r41 = 0;
        goto L18
    }
}
